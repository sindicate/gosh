package ronnie.gosh;

import groovy.lang.Closure;
import groovy.lang.GroovyObject;
import groovy.lang.MetaClass;
import groovy.lang.MetaProperty;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.MessageSource;

import ronnie.gosh.parts.Screen;

import com.logicacmg.idt.commons.SystemException;
import com.logicacmg.idt.commons.servlet.HttpUtil;
import com.logicacmg.idt.commons.util.Assert;


public class ApplicationContext implements BeanFactoryAware 
{
	static private Logger log = Logger.getLogger( ApplicationContext.class );

	protected BeanFactory beanFactory; 
	protected GroovyPageManager pageManager;
	protected MessageSource messageSource;
	protected boolean useActionNames = true;
	
	// TODO If groovy removes this strange threadbound behaviour from the ExpandoMetaClass, then we can inject a property on the controller itself
	protected WeakHashMap< MetaClass, Map > actions = new WeakHashMap< MetaClass, Map >();

	public void setBeanFactory( BeanFactory beanFactory )
	{
		this.beanFactory = beanFactory;
	}

	public void include( String path, RequestContext requestContext, Map args )
	{
		CompiledGroovyPage page = this.pageManager.getPage( path );
		RequestContext context = (RequestContext)this.beanFactory.getBean( "requestContext" );
		context.configure( requestContext, requestContext.controllerName, requestContext.actionName, args ); // Inherit controllername to be used within the page
		page.call( context );
	}
	
	public void include( String controllerName, String actionName, RequestContext requestContext, Map args )
	{
		UnboundClosure action = getActionClosure( controllerName, actionName );
		
		RequestContext context = (RequestContext)this.beanFactory.getBean( "requestContext" );
		context.configure( requestContext, controllerName, actionName, args );
		action.call( context );
	}

	public void call( String path, HttpServletRequest request, HttpServletResponse response )
	{
		CompiledGroovyPage page = this.pageManager.getPage( path );
		RequestContext context = (RequestContext)this.beanFactory.getBean( "requestContext" );
		context.configure( request, response, this, null, null, null );
		page.call( context );
	}
	
	public void call( String controllerName, String actionName, HttpServletRequest request, HttpServletResponse response, Map args )
	{
		RequestContext context = (RequestContext)this.beanFactory.getBean( "requestContext" );
		context.configure( request, response, this, controllerName, actionName, args );

		// Screen already present?
		Screen screen = context.getScreen( controllerName );
		if( screen != null )
		{
			screen.call( context );
			return;
		}
		
		// Is it a screen?
		screen = getScreen( controllerName );
		if( screen != null )
		{
			context.createSession(); // storeScreen may fail otherwise
			screen.init();
			screen.call( context ); // Before setting the attribute, this prevents the screen itself from removing itself in case of the "open" action
			context.storeScreen( controllerName, screen );
			return;
		}
		
		UnboundClosure action = getActionClosure( controllerName, actionName );
		
		// TODO Does the screen also need the flash?
		String flashKey = request.getParameter( RequestContext.FLASHKEY );
		if( flashKey != null )
		{
			HttpSession session = request.getSession();
			FlashCache cache = (FlashCache)session.getAttribute( RequestContext.GOSH_FLASHCACHE );
			if( cache == null )
				throw new FlashCache.FlashEntryNotFoundException();
			Map value = (Map)cache.retrieve( flashKey );
			args.putAll( value );
		}
		
		action.call( context );
	}

	public void call( ResolvedRequest resolved, HttpServletRequest request, HttpServletResponse response )
	{
		log.debug( "controller [" + resolved.controllerName + "], action [" + resolved.actionName + "], pathInfo [" + resolved.pathInfo + "]" );

		Map args = new HashMap();
		if( resolved.pathInfo != null )
			args.put( "pathInfo", resolved.pathInfo );
		
		call( resolved.controllerName, resolved.actionName, request, response, args );
	}

	protected String resolveActionName( HttpServletRequest request, String actionNameInUrl )
	{
		return actionNameInUrl;
	}
	
	static final private Pattern pathInfoPattern1 = Pattern.compile( "/([^\\/]+)/?([^\\/]+)?/?(.+)?" );
	static final private Pattern pathInfoPattern2 = Pattern.compile( "/([^\\/]+)/?(.+)?" );
	
	protected ResolvedRequest resolveRequest( HttpServletRequest request )
	{
		String pathInfo = request.getPathInfo();
		if( pathInfo == null )
			return null;
		
		Matcher matcher = this.useActionNames ? pathInfoPattern1.matcher( pathInfo ) : pathInfoPattern2.matcher( pathInfo ); 
		if( !matcher.matches() )
			return null;
		
		String controllerName = matcher.group( 1 );
		String actionName = this.useActionNames ? resolveActionName( request, matcher.group( 2 ) ) : null;
		String pathInfoRest = matcher.group( this.useActionNames ? 3 : 2 );
		
		return new ResolvedRequest( controllerName, actionName, pathInfoRest );
	}
	
	public void call( HttpServletRequest request, HttpServletResponse response )
	{
		try
		{
			ResolvedRequest resolved = resolveRequest( request );
			if( resolved == null )
			{
				response.sendError( HttpServletResponse.SC_NOT_FOUND, request.getRequestURI() );
				return;
			}
			
			try
			{
				call( resolved, request, response );
			}
			catch( RequestedResourceNotAvailableException e )
			{
				log.error( "", e );
				response.sendError( HttpServletResponse.SC_NOT_FOUND, request.getRequestURI() );
			}
		}
		catch( IOException e )
		{
			throw new SystemException( e );
		}
	}

	public Screen getScreen( String screenName )
	{
		screenName += "-screen";
		if( !this.beanFactory.containsBean( screenName ) )
			return null;
		return (Screen)this.beanFactory.getBean( screenName );
	}
	
	public GroovyObject getController( String controllerName )
	{
		controllerName += "-controller";
		
		// TODO Need to change the exception handling because it could also be a screen instead
		if( !this.beanFactory.containsBean( controllerName ) )
			throw new ControllerNotFoundException( controllerName );
		
		return (GroovyObject)this.beanFactory.getBean( controllerName );
	}

	public UnboundClosure getActionClosure( String controllerName, String actionName )
	{
		GroovyObject controller = getController( controllerName );
		
		// Use the metaclass, otherwise we would not detect a reload
		Map actions = this.actions.get( controller.getMetaClass() );
		if( actions == null )
		{
			MetaProperty actionsProperty = controller.getMetaClass().hasProperty( controller, "actions" );
			MetaProperty actionProperty = controller.getMetaClass().hasProperty( controller, "action" );
			Assert.isTrue( actionsProperty != null || actionProperty != null, "Need 'actions' or 'action'" );
			
			actions = new HashMap();

			if( actionsProperty != null )
			{
				Closure actionsClosure = (Closure)controller.getProperty( "actions" );
				actionsClosure.setDelegate( new ActionBuilder( actions ) );
				actionsClosure.call();
				actionsClosure.setResolveStrategy( Closure.OWNER_ONLY );
				actionsClosure.setDelegate( null );
			}
			
			if( actionProperty != null )
			{
				Closure actionClosure = (Closure)controller.getProperty( "action" );
				if( actionClosure != null )
					actions.put( null, new UnboundClosure( actionClosure ) ); // default action
			}

			this.actions.put( controller.getMetaClass(), actions ); // Only set if the ActionBuilder succeeds
		}
		
		Assert.notNull( actions );
		UnboundClosure action = (UnboundClosure)actions.get( actionName );
		if( action == null )
			throw new SystemException( "Controller bean [" + controllerName + "] does not have an action called [" + actionName + "]" );
		
		return action;
	}

	public void redirect( String path, HttpServletRequest request, HttpServletResponse response )
	{
		log.debug( "redirect, contextPath = [" + request.getContextPath() + "]" );
		HttpUtil.sendRelativeRedirect( response, request.getContextPath() + request.getServletPath() + path );
	}
	
	public GroovyPageManager getPageManager()
	{
		return this.pageManager;
	}

	public void setPageManager( GroovyPageManager pageManager )
	{
		this.pageManager = pageManager;
	}
	
	public Object getBean( String id )
	{
		return this.beanFactory.getBean( id );
	}
	
	public Object getBean( String id, Object[] args )
	{
		return this.beanFactory.getBean( id, args );
	}

	public MessageSource getMessageSource()
	{
		return this.messageSource;
	}

	public void setMessageSource( MessageSource messageSource )
	{
		this.messageSource = messageSource;
	}
	
	static public class ResolvedRequest
	{
		protected String controllerName;
		protected String actionName;
		protected String pathInfo;
		
		public ResolvedRequest( String controllerName, String actionName, String pathInfoRest )
		{
			this.controllerName = controllerName;
			this.actionName = actionName;
			this.pathInfo = pathInfoRest;
		}
	}
}
