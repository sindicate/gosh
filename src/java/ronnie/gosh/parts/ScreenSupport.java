package ronnie.gosh.parts;

import groovy.lang.Closure;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ronnie.gosh.GroovySupport;
import ronnie.gosh.RequestContext;

import com.logicacmg.idt.commons.SystemException;
import com.logicacmg.idt.commons.util.Assert;


// TODO Need part builder
public class ScreenSupport extends Composite implements Screen
{
	static private Logger log = Logger.getLogger( ScreenSupport.class );
	
	protected RequestContext context;
	protected String myUrl;
	protected boolean built;
	protected boolean needsQueryString = true;
	
	public ScreenSupport()
	{
		super( null, null );
	}
	
	public void init( RequestContext context )
	{
//		context.storeScreen( this.name, this );
		this.myUrl = context.link( null );
	}
	
	// Is not called for the first request
	@Override
	public CANACCEPT canAccept( RequestContext context )
	{
		try
		{
			HttpServletRequest request = context.getRequest();
			if( this.built )
			{
				if( request.getMethod().equals( "GET" ) )
				{
					if( !request.getRequestURI().equals( this.myUrl ) )
						return CANACCEPT.NEW;
					if( request.getQueryString() != null )
						return CANACCEPT.NEW;
					return CANACCEPT.YES;
				}
				if( request.getMethod().equals( "POST" ) )
				{
					return CANACCEPT.YES;
				}
				context.getResponse().sendError( HttpServletResponse.SC_METHOD_NOT_ALLOWED );
				return CANACCEPT.ERROR;
			}
			
			if( request.getMethod().equals( "GET" ) )
			{
				if( !this.needsQueryString )
					return CANACCEPT.YES;
				if( !request.getRequestURI().equals( this.myUrl ) )
					return CANACCEPT.YES;
				if( request.getQueryString() != null )
					return CANACCEPT.YES;
				context.getResponse().sendError( HttpServletResponse.SC_FORBIDDEN, "Screen state is lost, try reloading it." );
				return CANACCEPT.ERROR;
			}
			if( request.getMethod().equals( "POST" ) )
			{
				context.getResponse().sendError( HttpServletResponse.SC_FORBIDDEN, "Screen state is lost, try reloading it." );
				return CANACCEPT.ERROR;
			}
			context.getResponse().sendError( HttpServletResponse.SC_METHOD_NOT_ALLOWED );
			return CANACCEPT.ERROR;
		}
		catch( IOException e )
		{
			throw new SystemException( e );
		}
	}

	public void build()
	{
		GroovySupport.callHook( this, "build", this.context );
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
			
			if( !this.built )
			{
				this.context.sendForbidden( "Screen state is lost, try reloading it." );
				return;
			}
			
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

//			if( !context.hasErrors() ) errors must be kept in the components and collected in the end if needed
				callAction( action );

			if( context.hasErrors() )
				requestFailed( context );
			
			if( context.executePlannedRedirect() )
				return;

			context.redirect( null );
			return;
		}
		
		if( !context.getRequest().getRequestURI().equals( this.myUrl ) || context.getRequest().getQueryString() != null )
		{
			log.debug( "Not base url" );
			build();
			this.built = true;
			context.redirect( null );
			return;
		}
		
		if( !this.built )
		{
			log.debug( "Not built yet" );
			build();
			this.built = true;
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
		Assert.notNull( component, "Component [" + child + "] not found" );
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

		GroovySupport.callHook( this, "render", this.context );
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
		GroovySupport.callHook( this, "applyRequestStart", this.context );
		super.applyRequest( context );
	}
}
