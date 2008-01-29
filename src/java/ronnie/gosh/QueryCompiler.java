package ronnie.gosh;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import groovy.lang.Closure;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyCodeSource;
import groovy.lang.GroovyObject;

import com.logicacmg.idt.commons.SystemException;
import com.logicacmg.idt.commons.util.Assert;


public class QueryCompiler
{
	static final private Logger __LOGGER = Logger.getLogger( QueryCompiler.class );

	static final protected Pattern pathPattern = Pattern.compile( "/*(?:(.+?)/+)?([^\\/]+)" );

	static public CompiledQuery compile( Reader reader, String path, long lastModified )
	{
		__LOGGER.info( "compile [" + path + "]" );
		Matcher matcher = pathPattern.matcher( path );
		Assert.isTrue( matcher.matches() );
		path = matcher.group( 1 );
		String name = matcher.group( 2 ).replaceAll( "[\\.-]", "_" );
		
		String pkg = "ronnie.gosh.tmp.gsql";
		if( path != null )
			pkg += "." + path.replaceAll( "/", "." );
			
		String script = parse( reader, pkg, name );
		__LOGGER.debug( "Generated groovy:\n" + script );

		GroovyClassLoader loader = new GroovyClassLoader();
		Class groovyClass = loader.parseClass( new GroovyCodeSource( script, name, "x" ) );
		GroovyObject object = (GroovyObject)Util.newInstance( groovyClass );
		return new CompiledQuery( (Closure)object.invokeMethod( "getClosure", null ), lastModified );
	}
	
	static public CompiledQuery compile( String sql, String name, long lastModified )
	{
		return compile( new StringReader( sql ), name, lastModified );
	}
	
	static public String parse( Reader reader, String pkg, String cls )
	{
		Writer writer = new Writer();
		
		writer.write( "package " + pkg + ";class " + cls + "{Closure getClosure(){return{def builder=new ronnie.gosh.GStringBuilder();" );
		
		try
		{
			int c = reader.read();
			while( true )
			{
				if( c == -1 )
					break;
				if( c == '<' )
				{
					c = reader.read();
					if( c == '%' )
					{
						c = reader.read();
						if( c == '=' )
						{
							writer.startExpression();
							readScript( reader, writer );
							writer.endExpression();
						}
						else
						{
							writer.startScript();
							writer.write( (char)c );
							readScript( reader, writer );
							writer.endScript();
						}
					}
					else
					{
						writer.writeAsString( '<' );
						writer.writeAsString( (char)c );
					}
				}
				else if( c == '\\' )
				{
					c = reader.read();
					if( c == '$' )
					{
						writer.writeAsString( '\\' );
						writer.writeAsString( '$' );
					}
					else
					{
						writer.writeAsString( '\\' );
						writer.writeAsString( '\\' );
						writer.writeAsString( (char)c );
					}
				}
				else if( c == '"' )
				{
					c = reader.read();
					if( c == '"' )
					{
						c = reader.read();
						if( c == '"' )
						{
							writer.writeAsString( '\\' );
							writer.writeAsString( '"' );
							writer.writeAsString( '"' );
							writer.writeAsString( '"' );
						}
						else
						{
							writer.writeAsString( '"' );
							writer.writeAsString( '"' );
							writer.writeAsString( (char)c );
						}
					}
					else
					{
						writer.writeAsString( '"' );
						writer.writeAsString( (char)c );
					}
				}
				else
					writer.writeAsString( (char)c );
				
				c = reader.read();
			}
		}
		catch( IOException e )
		{
			throw new SystemException( e );
		}

		writer.end();

		writer.write( "return builder.toGString()}}}" );

		return writer.getString();
	}
	
	static protected void readScript( Reader reader, Writer writer ) throws IOException
	{
		while( true )
		{
			int c = reader.read();
			if( c == -1 )
				return;
			if( c == '%' )
			{
				c = reader.read();
				if( c == '>' )
					return;
				writer.write( '%' );
			}
			writer.write( (char)c );
		}
	}
	
	static protected class Writer
	{
		protected StringBuilder buffer;
		protected boolean stringMode = false;
		protected Writer()
		{
			this.buffer = new StringBuilder();
		}
		protected void writeAsString( char string )
		{
			if( !this.stringMode )
			{
				this.buffer.append( "builder.append(\"\"\"" );
				this.stringMode = true;
			}
			this.buffer.append( string );
		}
		protected void write( String s )
		{
			this.buffer.append( s );
		}
		protected void write( char c )
		{
			this.buffer.append( c );
		}
		protected void startExpression()
		{
			endString();
			this.buffer.append( "builder.append(" );
		}
		protected void endExpression()
		{
			this.buffer.append( ");" );
		}
		protected void startScript()
		{
			endString();
		}
		protected void endScript()
		{
			this.buffer.append( ';' );
		}
		protected void endString()
		{
			if( this.stringMode )
			{
				this.buffer.append( "\"\"\");" );
				this.stringMode = false;
			}
		}
		protected void end()
		{
			endString();
		}
		protected String getString()
		{
			return this.buffer.toString();
		}
	}
}
