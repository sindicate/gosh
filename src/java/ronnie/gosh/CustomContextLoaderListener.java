package ronnie.gosh;

import groovy.lang.ExpandoMetaClass;
import groovy.lang.GroovyClassLoader;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.logicacmg.idt.commons.SystemException;
import com.logicacmg.idt.commons.profiling.ProfilingSupport;


public class CustomContextLoaderListener implements ServletContextListener
{
	private static final Logger __LOGGER = Logger.getLogger( CustomContextLoaderListener.class );

	private Object contextLoader;

	public void contextInitialized( ServletContextEvent event )
	{
		// See also applicationContext.xml
		
		// TODO (RBloois -> RBloois) This is not right, the fact that for example tts.properties exists does not mean that it contains the property 'log.folder'. Use the utility I created for the VIP project.
		URL url = CustomContextLoaderListener.class.getResource( "/TTS/tts.properties" );
		if( url == null )
			url = CustomContextLoaderListener.class.getResource( "/tts.properties" );
		if( url == null )
			url = CustomContextLoaderListener.class.getResource( "/tts-default.properties" );
		if( url == null )
			throw new SystemException( "None of /TTS/tts.properties, /tts.properties, /tts-default.properties found" );
		
		System.out.println( "Reading log.folder from [" + url + "]" );
		
		Properties props = new Properties();
		try
		{
			props.load( url.openStream() );
		}
		catch( IOException e )
		{
			throw new SystemException( "Exception while loading properties from [" + url + "]", e );
		}
		
		String folder = props.getProperty( "log.folder" );
		
		// This log4j configurator can also be used from the spring factory, but then log4j has problems with daily rolling file appenders (it won't role)
		Log4jConfigurator log4j = new Log4jConfigurator();
		log4j.setFolder( folder );
		log4j.configure();
		
		// LOGGING SHOULD ONLY BE DONE AFTER THIS POINT
		
		// We need this to inherit metaClass things from java interfaces
		//GroovySystem.getMetaClassRegistry().setMetaClassCreationHandle( new ExpandoMetaClassCreationHandle() );
		ExpandoMetaClass.enableGlobally();
		//GroovySystem.setKeepJavaMetaClasses( true ); // TODO Do we need this?

		// ------
		
		Logger log = Logger.getLogger( CustomContextLoaderListener.class );
		log.info( "Read log.folder from [" + url + "], value is [" + folder + "], configured log4j log folders" );

		ProfilingSupport.logMemoryAndProcessorCount( "init", true );

		boolean useGroovyClassLoader = false;
		try
		{
			__LOGGER.info( "My classloader is [" + CustomContextLoaderListener.class.getClassLoader().getClass().getName() + "]" );
			__LOGGER.info( "Context classloader is [" + Thread.currentThread().getContextClassLoader().getClass().getName() + "]" );
			
			if( useGroovyClassLoader )
			{
				GroovyClassLoader loader = new GroovyClassLoader();
				Thread.currentThread().setContextClassLoader( loader );
			}
			
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			
			Class contextLoaderClass = loader.loadClass( "org.springframework.web.context.ContextLoader" );
			if( useGroovyClassLoader )
				__LOGGER.info( "Loaded ContextLoader with the GroovyClassLoader" );
			this.contextLoader = contextLoaderClass.newInstance();
			
			Method initWebApplicationContextMethod = contextLoaderClass.getMethod( "initWebApplicationContext", ServletContext.class );
			initWebApplicationContextMethod.invoke( this.contextLoader, event.getServletContext() );
			__LOGGER.info( "Called ContextLoader.initWebApplicationContext()" );
		}
		catch( ClassNotFoundException e )
		{
			throw new RuntimeException( e );
		}
		catch( InstantiationException e )
		{
			throw new RuntimeException( e );
		}
		catch( IllegalAccessException e )
		{
			throw new RuntimeException( e );
		}
		catch( InvocationTargetException e )
		{
			throw new RuntimeException( e );
		}
		catch( NoSuchMethodException e )
		{
			throw new RuntimeException( e );
		}
		
		// ------
		
		new SystemBootstrap().run();
	}

	/**
	 * Close the root web application context.
	 */
	public void contextDestroyed( ServletContextEvent event )
	{
		try
		{
			if( this.contextLoader != null )
			{
				Method closeWebApplicationContextMethod = this.contextLoader.getClass().getMethod( "closeWebApplicationContext", ServletContext.class );
				closeWebApplicationContextMethod.invoke( this.contextLoader, event.getServletContext() );
				
				__LOGGER.info( "Called ContextLoader.closeWebApplicationContext()" );
			}
		}
		catch( IllegalAccessException e )
		{
			throw new RuntimeException( e );
		}
		catch( InvocationTargetException e )
		{
			throw new RuntimeException( e );
		}
		catch( NoSuchMethodException e )
		{
			throw new RuntimeException( e );
		}
	}
}
