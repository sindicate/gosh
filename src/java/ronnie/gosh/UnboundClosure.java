package ronnie.gosh;

import org.codehaus.groovy.runtime.InvokerInvocationException;

import groovy.lang.Closure;

import com.logicacmg.idt.commons.SystemException;

public class UnboundClosure
{
	protected Closure closure;
	
	public UnboundClosure( Closure closure )
	{
		this.closure = closure;
	}
	
	public void call( Object delegate )
	{
		// TODO Can we do without cloning? By using InvokerHelper directly?
		Closure result = (Closure)this.closure.clone();
		result.setDelegate( delegate );
		try
		{
			result.call();
		}
		catch( InvokerInvocationException e )
		{
			Throwable cause = e.getCause();
			if( cause instanceof RuntimeException )
				throw (RuntimeException)cause;
			if( cause instanceof Error )
				throw (Error)cause;
			throw new SystemException( cause );
		}
	}
}
