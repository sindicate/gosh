package ronnie.gosh;

import groovy.lang.Closure;


public class CompiledGroovyPage
{
//	static final private Logger __LOGGER = Logger.getLogger( CompiledGroovyPage.class );

	private Closure _closure;
	protected long lastModified;

	public CompiledGroovyPage( Closure closure, long lastModified )
	{
		this._closure = closure;
		this.lastModified = lastModified;
	}
	
	public void call( RequestContext delegate )
	{
		Closure clone = (Closure)this._closure.clone();
		clone.setDelegate( delegate );
		clone.call(); 
	}
}
