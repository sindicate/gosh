package ronnie.gosh.parts;

import groovy.lang.Closure;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.groovy.runtime.InvokerHelper;

import ronnie.gosh.RequestContext;

import com.logicacmg.idt.commons.util.Assert;
import com.logicacmg.idt.commons.util.StringUtil;


// TODO Need part builder
public abstract class ScreenSupport extends Composite implements Screen
{
	protected RequestContext context;
	
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
	public void call( RequestContext context )
	{
		this.context = context;
		HttpServletRequest request = context.getRequest();
		
		String action = null;
		
		// Analyze the parameters
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
			}
		}
		
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
		
		render();
	}
	
	@Override
	public void render()
	{
		HttpServletResponse response = this.context.getResponse();
		
		// no-store is the one that prevents back-button caching, no-cache has nothing to do with it.
		// BUT!!!, IE6 does not work correctly with no-store, so we add no-cache for IE6 only.
		response.setHeader( "Cache-Control", "no-store" ); // no-store prevents back-button caching in both IE7 and Firefox
		response.setHeader( "Cache-Control", "no-cache" ); // Needed for IE6

		Closure closure = (Closure)InvokerHelper.getProperty( this, "render" );
		if( closure != null )
		{
			closure.setDelegate( this.context );
			closure.call();
		}
	}
	
	public void close()
	{
		this.context.getSession().removeAttribute( this.context.getControllerName() );
	}
	
	@Override
	public RequestContext getRequestContext()
	{
		return this.context;
	}
}
