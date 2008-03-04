package ronnie.gosh;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.logicacmg.idt.commons.NotImplementedException;

import groovy.lang.GroovyObject;
import groovy.lang.MetaClass;

// TODO Not used yet
public class StateManager implements GroovyObject
{
	static private final Logger log = Logger.getLogger( StateManager.class ); 
	
	protected HttpSession session;
	
	public StateManager( HttpSession session )
	{
		this.session = session;
	}

	public MetaClass getMetaClass()
	{
		throw new NotImplementedException();
	}

	public Object getProperty( String name )
	{
		log.debug( "getProperty [" + name + "]" );
		return this.session.getAttribute( name );
	}

	public Object invokeMethod( String arg0, Object arg1 )
	{
		throw new NotImplementedException();
	}

	public void setMetaClass( MetaClass arg0 )
	{
		throw new NotImplementedException();
	}

	public void setProperty( String name, Object value )
	{
		log.debug( "setProperty [" + name + "]" );
		this.session.setAttribute( name, value );
	}
}
