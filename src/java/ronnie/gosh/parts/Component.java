package ronnie.gosh.parts;

import java.io.PrintWriter;

import com.logicacmg.idt.commons.util.Assert;

public abstract class Component
{
	protected Composite parent;
	
	public Component( Composite parent )
	{
		this.parent = parent;
	}
	
	abstract public void render();
	
	public PrintWriter getOut()
	{
		Assert.notNull( this.parent );
		return this.parent.getOut();
	}
}
