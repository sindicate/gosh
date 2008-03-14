package ronnie.gosh.parts;

import groovy.lang.Closure;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.groovy.runtime.InvokerHelper;

import ronnie.gosh.RequestContext;

import com.logicacmg.idt.commons.util.Assert;
import com.logicacmg.idt.commons.util.StringUtil;


// TODO Need part builder
public abstract class ScreenSupport extends Composite implements Screen
{
	static private Logger log = Logger.getLogger( ScreenSupport.class );
	
	protected RequestContext context;
//	protected boolean rendered;
	
	public ScreenSupport()
	{
		super( null, null );
	}
	
	public void init()
	{
		this.build();
	}
	
	abstract public void build();

	// TODO This can be non-public?
	// TODO Use the referer to detect if a refresh is needed?
	public void call( RequestContext context )
	{
		this.context = context;

		if( "open".equals( context.getActionName() ) )
		{
			close();
			// TODO Create automated test or assertion to test the a new screen has not been set in the session yet
			context.redirect( null );
			return;
		}
		
		HttpServletRequest request = context.getRequest();
		
		String action = null;

		// TODO Can't execute an action when the screen has just been build?
		
		// Analyze the parameters
		boolean flag = false;
		
		Enumeration< String > i = request.getParameterNames();
		while( i.hasMoreElements() )
		{
			String name = i.nextElement();
			if( name.startsWith( "action(" ) && name.endsWith( ")" ) )
			{
				action = name;
			}
			else
			{
				int pos = name.indexOf( '.' );
				Assert.isTrue( pos > 0 );
				String child = name.substring( 0, pos );
				String prop = name.substring( pos + 1 );
				Component component = this.childs.get( child );
				String value = request.getParameter( name );
				component.setValue( prop, StringUtil.emptyToNull( value ) );
				flag = true;
			}
		}
		
		if( flag )
			requestApplied();
		
		if( action != null )
		{
			action = action.substring( 7, action.length() - 1 );
			int pos = action.indexOf( '.' );
			Assert.isTrue( pos > 0 );
			String child = action.substring( 0, pos );
			action = action.substring( pos + 1 );
			Component component = this.childs.get( child );
			component.call( action );
		}
		
		if( "POST".equals( context.getRequest().getMethod() ) )
			context.redirect( null );
		
		render( context );
	}
	
	protected void requestApplied()
	{
		// to be implemented by subclasses
	}

	@Override
	public void render( RequestContext context )
	{
		HttpServletResponse response = this.context.getResponse();
		
		// no-store is the one that prevents back-button caching, no-cache has nothing to do with it.
		// BUT!!!, IE6 does not work correctly with no-store, so we add no-cache for IE6 only.
		response.setHeader( "Cache-Control", "no-cache" ); // Needed for IE6
		response.setHeader( "Cache-Control", "no-store" ); // no-store prevents back-button caching in both IE7 and Firefox

		Closure closure = (Closure)InvokerHelper.getProperty( this, "render" );
		if( closure != null )
		{
			closure.setDelegate( context );
			closure.call();
		}
	}
	
	public void close()
	{
		Assert.notNull( this.context );
		Assert.notNull( this.context.getSession() );
		log.debug( "closed [" + this.context.getControllerName() + "]" );
		// TODO Need to implement a screenmanager for this
		this.context.clearScreen( this.context.getControllerName() );
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
}
