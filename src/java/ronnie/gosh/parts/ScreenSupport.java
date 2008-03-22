package ronnie.gosh.parts;

import groovy.lang.Closure;
import groovy.lang.MetaProperty;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.groovy.runtime.InvokerHelper;

import ronnie.gosh.RequestContext;

import com.logicacmg.idt.commons.util.Assert;


// TODO Need part builder
public class ScreenSupport extends Composite implements Screen
{
	static private Logger log = Logger.getLogger( ScreenSupport.class );
	
	protected RequestContext context;
	protected String myUrl;
//	protected boolean rendered;
	
	public ScreenSupport()
	{
		super( null, null );
	}
	
	public void init( RequestContext context )
	{
		context.storeScreen( this.name, this );
		this.myUrl = context.link( null );
	}
	
	@Override
	public CANACCEPT canAccept( RequestContext context )
	{
		if( !context.getRequest().getRequestURI().equals( this.myUrl ) )
			return CANACCEPT.NEW;
		return CANACCEPT.YES;
	}

	public void build()
	{
		callHook( "build" );
	}

	// TODO This can be non-public?
	// TODO Use the referer to detect if a refresh is needed?
	// TODO synchronize on the session
	synchronized public void call( RequestContext context )
	{
		this.context = context;
		
		if( context.getRequest().getMethod().equals( "POST" ) )
		{
			log.debug( "POST" );
			// TODO Can't execute an action when the screen has just been build?
			
			String action = null;
			Map< String, String[] > pars = context.getRequest().getParameterMap();
			for( Entry< String, String[] > entry : pars.entrySet() )
			{
				String name = entry.getKey();
				if( name.startsWith( "action(" ) && name.endsWith( ")" ) )
				{
					action = name;
					break;
				}
			}
			
			Assert.notNull( action, "Missing action" );
			log.debug( "Action: " + action );
			
			applyRequest( context );

			if( !context.hasErrors() )
				callAction( action );

			if( context.hasErrors() )
				requestFailed( context );
			
			if( context.executePlannedRedirect() )
				return;

			context.redirect( null );
			return;
		}
		
		if( !context.getRequest().getRequestURI().equals( this.myUrl ) )
		{
			log.debug( "Not base url" );
			build();
			context.redirect( null );
			return;
		}
		
		render( context );
	}
	
	protected void callAction( String action )
	{
		action = action.substring( 7, action.length() - 1 );
		int pos = action.indexOf( '.' );
		Assert.isTrue( pos > 0 );
		String child = action.substring( 0, pos );
		action = action.substring( pos + 1 );
		Component component = this.childs.get( child );
		component.call( action );
	}
	
	protected void requestApplied()
	{
		// to be implemented by subclasses
	}

	protected void requestFailed( RequestContext context )
	{
		// to be implemented by subclasses
	}

	@Override
	public void render( RequestContext context )
	{
		Assert.notNull( context );
		
		HttpServletResponse response = this.context.getResponse();
		
		// no-store is the one that prevents back-button caching, no-cache has nothing to do with it.
		// BUT!!!, IE6 does not work correctly with no-store, so we add no-cache for IE6 only.
		response.setHeader( "Cache-Control", "no-cache" ); // Needed for IE6
		response.setHeader( "Cache-Control", "no-store" ); // no-store prevents back-button caching in both IE7 and Firefox

		callHook( "render" );
	}
	
	public void close()
	{
		Assert.notNull( this.context );
		Assert.notNull( this.context.getSession() );
		log.debug( "closed [" + this.name + "]" );
		// TODO Need to implement a screenmanager for this
		this.context.clearScreen( this.name );
	}
	
	@Override
	public RequestContext getRequestContext()
	{
		return this.context;
	}
	
	@Override
	public String getPath()
	{
		Assert.isNull( this.parent );
		return null;
	}
	
	@Override
	public void render( RequestContext context, Closure closure )
	{
		PrintWriter out = context.getOut();
		String link = context.link( Collections.EMPTY_MAP );
		out.print( "<form method=\"post\" action=\"" );
		out.print( link );
		out.print( "\">\n" );
		closure.call();
		out.print( "</form>\n" );
	}

	@Override
	public void applyRequest( RequestContext context )
	{
		callHook( "applyRequestStart" );
		super.applyRequest( context );
	}

	protected void callHook( String name )
	{
		MetaProperty property = InvokerHelper.getMetaClass( this ).hasProperty( this, name );
		if( property != null )
		{
			Closure closure = (Closure)property.getProperty( this );
			closure.setDelegate( this.context );
			closure.call();
		}
	}
}
