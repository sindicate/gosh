package ronnie.gosh;

import groovy.lang.Closure;
import groovy.lang.MetaProperty;

import org.codehaus.groovy.runtime.InvokerHelper;
import org.codehaus.groovy.runtime.InvokerInvocationException;

public class GroovySupport
{
	static public Object callClosure( Closure closure, Object... args )
	{
		return callMethod( closure, "doCall", args );
	}
	
	static public Object callMethod( Object object, String methodName, Object... args )
	{
		try
		{
			return InvokerHelper.invokeMethod( object, methodName, args );
		}
		catch( InvokerInvocationException e )
		{
			Throwable t = e.getCause();
			if( t instanceof RuntimeException )
				throw (RuntimeException)t;
			if( t instanceof Error )
				throw (Error)t;
			throw e;
		}
	}

	static public void callHook( Object object, String name, Object delegate )
	{
		MetaProperty property = InvokerHelper.getMetaClass( object ).hasProperty( object, name );
		if( property != null )
		{
			Closure closure = (Closure)property.getProperty( object );
			closure.setDelegate( delegate );
			callClosure( closure );
		}
	}
}
