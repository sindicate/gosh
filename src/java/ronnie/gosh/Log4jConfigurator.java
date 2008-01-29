package ronnie.gosh;

import java.io.File;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

public class Log4jConfigurator implements InitializingBean
{
	protected String folder;
	
	public void setFolder( String folder )
	{
		this.folder = folder;
	}

	public void afterPropertiesSet() throws Exception
	{
		configure();
	}

	public void configure()
	{
		if( this.folder == null || this.folder.length() == 0 )
		{
			System.out.println( "No folder set for log4j" );
			return;
		}
		
		File parent = new File( this.folder );
		System.out.println( "Setting log files to folder [" + parent + "]" );
		Assert.isTrue( parent.exists() && parent.isDirectory(), "Log folder does not exists" );
		
		HashSet appenders = getAllAppenders();
		System.out.println( "Number of appenders found = [" + appenders.size() + "]" );
		
		for( Iterator iter = appenders.iterator(); iter.hasNext(); )
		{
			Appender appender = (Appender)iter.next();
			if( appender instanceof FileAppender )
			{
				FileAppender fileAppender = ( FileAppender )appender;
				File file = new File( fileAppender.getFile( ) ); //.getAbsoluteFile( );
				File newFile = new File( parent, file.getName() );
				
				System.out.println( "FileAppender, file = [" + file + "] --> [" + newFile + "]" );
				
				fileAppender.setAppend( true ); // A DailyRollingFileAppender sets the append to false when rolling over, force it to true again
				fileAppender.setFile( newFile.toString() );
			}
		}

		// Activate
		for( Iterator iter = appenders.iterator(); iter.hasNext(); )
		{
			Appender appender = (Appender)iter.next();
			if( appender instanceof FileAppender )
			{
				FileAppender fileAppender = ( FileAppender )appender;
				fileAppender.activateOptions();
			}
		}
}
	
	public HashSet getAllAppenders()
	{
		HashSet result = new HashSet( );
		
		Logger root = Logger.getRootLogger( );
		Enumeration appenders = root.getAllAppenders( );
		while( appenders.hasMoreElements( ) )
			result.add( appenders.nextElement( ) );

		Enumeration loggers = root.getLoggerRepository( ).getCurrentLoggers( );
		while( loggers.hasMoreElements( ) )
		{
			appenders = ( ( Logger )loggers.nextElement( ) ).getAllAppenders( );
			while( appenders.hasMoreElements( ) )
				result.add( appenders.nextElement( ) );
		}
		
		return result;
	}
}
