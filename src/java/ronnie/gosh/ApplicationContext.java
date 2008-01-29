package ronnie.gosh;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

import ronnie.gosh.GoshDispatcherServlet.ResolvedRequest;

import groovy.lang.Closure;
import groovy.lang.GroovyObject;
import groovy.lang.MetaClass;
import groovy.lang.MetaProperty;

import com.logicacmg.idt.commons.SystemException;
import com.logicacmg.idt.commons.servlet.HttpUtil;
import com.logicacmg.idt.commons.util.Assert;


public class ApplicationContext implements BeanFactoryAware 
{
	static private Logger log = Logger.getLogger( ApplicationContext.class );

	protected BeanFactory beanFactory; 
	protected GroovyPageManager pageManager;
	
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
		context.configure( requestContext, requestContext.controllerName, args ); // Inherit controllername to be used within the page
		page.call( context );
	}
	
	public void include( String controllerName, String actionName, RequestContext requestContext, Map args )
	{
		UnboundClosure action = getActionClosure( controllerName, actionName );
		
		RequestContext context = (RequestContext)this.beanFactory.getBean( "requestContext" );
		context.configure( requestContext, controllerName, args );
		action.call( context );
	}

	public void call( String path, HttpServletRequest request, HttpServletResponse response )
	{
		CompiledGroovyPage page = this.pageManager.getPage( path );
		RequestContext context = (RequestContext)this.beanFactory.getBean( "requestContext" );
		context.configure( request, response, this, null, null );
		page.call( context );
	}
	
	public void call( String controllerName, String actionName, HttpServletRequest request, HttpServletResponse response, Map args )
	{
		UnboundClosure action = getActionClosure( controllerName, actionName );
		
		RequestContext context = (RequestContext)this.beanFactory.getBean( "requestContext" );
		context.configure( request, response, this, controllerName, args );
		
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

	public GroovyObject getController( String controllerName )
	{
		controllerName += "-controller";
		
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
}
