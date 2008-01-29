package ronnie.gosh;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONSerializer;

import groovy.lang.GString;

import com.logicacmg.idt.commons.SystemException;

public class Util
{
	static public Object newInstance( Class cls )
	{
		try
		{
			return cls.newInstance();
		}
		catch( InstantiationException e )
		{
			throw new SystemException( e );
		}
		catch( IllegalAccessException e )
		{
			throw new SystemException( e );
		}
	}
	
	static String[] internalClassesArray = new String[] { 
		"groovy.lang.Closure",
		"groovy.lang.ExpandoMetaClass",
		"groovy.lang.GroovyClassLoader",
		"groovy.lang.MetaClassImpl",
		"groovy.lang.MetaMethod",
		"java.lang.reflect.Constructor",
		"java.lang.reflect.Method",
		"java.lang.Thread",
		"javax.servlet.http.HttpServlet",
		"org.apache.catalina.connector.CoyoteAdapter",
		"org.apache.catalina.core.ApplicationFilterChain",
		"org.apache.catalina.core.StandardContextValve",
		"org.apache.catalina.core.StandardEngineValve",
		"org.apache.catalina.core.StandardHostValve",
		"org.apache.catalina.core.StandardWrapperValve",
		"org.apache.catalina.valves.ErrorReportValve",
		"org.apache.coyote.http11.Http11Processor",
		"org.apache.coyote.http11.Http11Protocol$Http11ConnectionHandler",
		"org.apache.tomcat.util.net.JIoEndpoint$Worker",
		"org.codehaus.groovy.antlr.AntlrParserPlugin",
		"org.codehaus.groovy.control.CompilationUnit",
		"org.codehaus.groovy.control.CompilationUnit$1",
		"org.codehaus.groovy.control.ErrorCollector",
		"org.codehaus.groovy.control.SourceUnit",
		"org.codehaus.groovy.reflection.CachedMethod",
		"org.codehaus.groovy.runtime.InvokerHelper",
		"org.codehaus.groovy.runtime.MetaClassHelper",
		"org.codehaus.groovy.runtime.ScriptBytecodeAdapter", 
		"org.springframework.aop.framework.JdkDynamicAopProxy",
		"org.springframework.aop.framework.ReflectiveMethodInvocation",
		"org.springframework.aop.support.AopUtils",
		"org.springframework.aop.support.DelegatingIntroductionInterceptor",
		"ronnie.gosh.UnboundClosure", // <-- This one might be renamed someday
		"sun.reflect.DelegatingConstructorAccessorImpl",
		"sun.reflect.DelegatingMethodAccessorImpl",
		"sun.reflect.NativeConstructorAccessorImpl",
		"sun.reflect.NativeMethodAccessorImpl",
	};
	
	static Set< String > internalClasses;
	
	static
	{
		internalClasses = new HashSet( Arrays.asList( internalClassesArray ) );
	}
	
	static void transformToGroovy( Throwable throwable )
	{
		StackTraceElement[] elements = throwable.getStackTrace();
		int j = 0;
		for( int i = 0; i < elements.length; i++ )
		{
			StackTraceElement element = elements[ i ];
			if( !internalClasses.contains( element.getClassName() ) )
				elements[ j++ ] = element;
		}
		StackTraceElement[] newElements = new StackTraceElement[ j ]; 
		System.arraycopy( elements, 0, newElements, 0, j );
		throwable.setStackTrace( newElements );
		
		throwable = throwable.getCause(); 
		if( throwable != null )
			transformToGroovy( throwable );
	}
	
	static String removeString( Map map, String key )
	{
		Object object = map.remove( key );
		if( object instanceof GString )
			return ( (GString)object ).toString();
		return (String)object;
	}
	
	static public String encodeJSON( Object object )
	{
		return JSONSerializer.toJSON( object ).toString();
	}
	
	static public Object decodeJSON( String string )
	{
		return JSONSerializer.toJava( JSONSerializer.toJSON( string ) );
	}
}
