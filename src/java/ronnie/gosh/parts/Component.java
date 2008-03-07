package ronnie.gosh.parts;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import ronnie.gosh.RequestContext;

import com.logicacmg.idt.commons.util.Assert;

public abstract class Component
{
	protected Map<String, String> attributes = new HashMap();
	protected Composite parent;
	
	public Component( Composite parent )
	{
		if( parent != null )
		{
			this.parent = parent;
			parent.childs.add( this );
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
}
