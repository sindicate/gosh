package ronnie.gosh.parts;

import groovy.lang.Closure;

import org.codehaus.groovy.runtime.InvokerHelper;

import ronnie.gosh.RequestContext;


// TODO Need part builder
public abstract class ScreenSupport extends Composite implements Screen
{
	protected RequestContext context;
	
	public ScreenSupport()
	{
		super( null );
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
