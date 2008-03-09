package ronnie.gosh.parts;

import groovy.lang.Closure;

import java.util.Enumeration;

import org.codehaus.groovy.runtime.InvokerHelper;

import ronnie.gosh.RequestContext;

import com.logicacmg.idt.commons.util.Assert;


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
		
		String action = null;
		
		// Analyze the parameters
		Enumeration< String > i = context.getRequest().getParameterNames();
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
				component.setValue( prop, context.getRequest().getParameter( name ) );
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
