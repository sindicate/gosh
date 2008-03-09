package ronnie.gosh.parts;

import groovy.lang.MissingPropertyException;

import java.util.HashMap;
import java.util.Map;

public abstract class Composite extends Component
{
	protected Map<String, Component> childs = new HashMap();
	
	public Composite( String name, Composite parent )
	{
		super( name, parent );
	}
	
	public void renderChilds()
	{
		for( Component child : this.childs.values() )
			child.render();
	}
	
	public Object propertyMissing( String name )
	{
		if( this.childs.containsKey( name ) )
			return this.childs.get( name );
		throw new MissingPropertyException( name );
	}
}
