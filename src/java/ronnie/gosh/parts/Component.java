package ronnie.gosh.parts;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.groovy.runtime.InvokerHelper;

import ronnie.gosh.RequestContext;

import com.logicacmg.idt.commons.util.Assert;

public abstract class Component
{
	static private final Logger log = Logger.getLogger( Component.class );

	protected String name;
	protected Map<String, String> attributes = new HashMap();
	protected Composite parent;
	
	public Component( String name, Composite parent )
	{
		this.name = name;
		if( parent != null )
		{
			this.parent = parent;
			// TODO Assert that name is unique
			if( name != null )
				parent.childs.put( name, this );
		}
	}
	
	abstract public void render();
	
	public PrintWriter getOut()
	{
		return getRequestContext().getOut();
	}
	
	public RequestContext getRequestContext()
	{
		Assert.notNull( this.parent );
		return this.parent.getRequestContext();
	}

	public void setClass( String name )
	{
		this.attributes.put( "class", name );
	}
	
	public void call( String action )
	{
		Assert.isTrue( action.indexOf( '.' ) < 0 );
		Assert.isTrue( action.endsWith( "()" ) );
		action = action.substring( 0, action.length() - 2 );
		InvokerHelper.invokeMethod( this, action, null );
	}
	
	public void setValue( String name, String value )
	{
		throw new UnsupportedOperationException();
	}
}
