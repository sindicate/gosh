package ronnie.gosh;

import java.util.Map;

import org.apache.log4j.Logger;

import groovy.lang.Closure;
import groovy.lang.GroovyObjectSupport;

class ActionBuilder extends GroovyObjectSupport
{
	static final private Logger log = Logger.getLogger( ActionBuilder.class );
	
	protected Map actions;
	
	protected ActionBuilder( Map actions ) { this.actions = actions; }
	
	@Override
	public void setProperty( String name, Object value )
	{
		Closure closure = (Closure)value;
		this.actions.put( name, new UnboundClosure( closure ) );
		log.info( "added action [" + name + "]" );
	}

	@Override
	public Object invokeMethod( String name, Object args )
	{
		Object[] args2 = (Object[])args;
		Closure closure = (Closure)args2[ 0 ];
		this.actions.put( name, new UnboundClosure( closure ) );
		log.info( "added action [" + name + "]" );
		return null;
	}
}
