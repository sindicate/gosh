package ronnie.gosh.parts;

import groovy.lang.MissingPropertyException;

import java.util.HashMap;
import java.util.Map;

import ronnie.gosh.RequestContext;

import com.logicacmg.idt.commons.util.Assert;

public abstract class Composite extends Component
{
	protected Map<String, Component> childs = new HashMap();
	
	public Composite( String name, Composite parent )
	{
		super( name, parent );
	}
	
	@Override
	public void call( String action )
	{
		int pos = action.indexOf( '.' );
		if( pos < 0 )
		{
			super.call( action );
			return;
		}
		
		Assert.isTrue( pos > 0 );
		String child = action.substring( 0, pos );
		action = action.substring( pos + 1 );
		Component component = this.childs.get( child );
		component.call( action );
	}

	public void renderChilds( RequestContext context )
	{
		for( Component child : this.childs.values() )
			child.render( context );
	}

	// TODO Is this the way to go?
	public Object propertyMissing( String name )
	{
		if( this.childs.containsKey( name ) )
			return this.childs.get( name );
		throw new MissingPropertyException( name );
	}

	@Override
	public void applyRequest( RequestContext context )
	{
		for( Component child : this.childs.values() )
			child.applyRequest( context );
	}
}
