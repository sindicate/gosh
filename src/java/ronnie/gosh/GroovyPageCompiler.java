package ronnie.gosh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import groovy.lang.Closure;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyCodeSource;
import groovy.lang.GroovyObject;

import com.logicacmg.idt.commons.SystemException;
import com.logicacmg.idt.commons.util.Assert;


// Linenumbers should not change, so we can't add newlines here
public class GroovyPageCompiler
{
	static final private Logger log = Logger.getLogger( GroovyPageCompiler.class );

	static final protected Pattern pathPattern = Pattern.compile( "/*(?:(.+?)/+)?([^\\/]+)" );

	static public CompiledGroovyPage compile( Reader reader, String path, long lastModified )
	{
		log.info( "compile [" + path + "]" );
		Matcher matcher = pathPattern.matcher( path );
		Assert.isTrue( matcher.matches() );
		path = matcher.group( 1 );
		String name = matcher.group( 2 ).replaceAll( "[\\.-]", "_" );
		
		String pkg = "ronnie.gosh.tmp.gpage";
		if( path != null )
			pkg += "." + path.replaceAll( "/", "." );
			
		String script = new Parser().parse( reader, pkg, name );
		log.debug( "Generated groovy:\n" + script );

		GroovyClassLoader loader = new GroovyClassLoader();
		Class groovyClass = loader.parseClass( new GroovyCodeSource( script, name, "x" ) );
		GroovyObject object = (GroovyObject)Util.newInstance( groovyClass );
		return new CompiledGroovyPage( (Closure)object.invokeMethod( "getClosure", null ), lastModified );
	}
	
	static public void preCompilePages( File baseDir, String[] pages, File outputDir ) throws IOException
	{
		if( pages.length == 0 )
			System.out.println( "No pages to compile" );
			
		int count = 0;
		for( String page : pages )
		{
			// TODO Directly to outputstream
			
			File file = new File( page );
			String packagSlashed = file.getParentFile().getPath();
			String packag = packagSlashed.replaceAll( "/|\\\\", "." );
			String name = file.getName().replaceAll( "[\\.-]", "_" );
			File inputfile = new File( baseDir.getPath() + "/" + page );
			File outputfile = new File( outputDir.getPath() + "/" + packagSlashed + "/" + name + ".groovy" );
			
			if( inputfile.lastModified() > outputfile.lastModified() )
			{
				String script;
				FileReader in = new FileReader( baseDir.getPath() + "/" + page );
				try
				{
					script = new Parser().parse( in, packag, name );
				}
				finally
				{
					in.close();
				}
				outputfile.getParentFile().mkdirs();
				FileWriter out = new FileWriter( outputfile );
				try
				{
					out.write( script );
				}
				finally
				{
					out.close();
				}
				count++;
			}
		}
		if( count > 0 )
			System.out.println( "Precompiled " + count + " pages" );
	}
	
	static protected class Parser
	{
		static final private Logger log = Logger.getLogger( GroovyPageCompiler.class );

		protected Parser()
		{
			// Constructor
		}
		
		protected String parse( Reader reader, String pkg, String cls )
		{
			if( !reader.markSupported() )
				reader = new BufferedReader( reader );
			
			Writer writer = new Writer();
			writer.writeRaw( "package " + pkg + ";class " + cls + "{Closure getClosure(){return{" );
			try
			{
				// Read leading whitespace, this makes it easier to set the characterencoding (or contentType) at the start of the ghtml (or the template)
				int c = reader.read();
				while( Character.isSpaceChar( (char)c ) )
					c = reader.read();
				
				boolean startOfLine = true;
				StringBuilder buffer = new StringBuilder( 100 );
				StringBuilder buffer2 = new StringBuilder( 100 );
				
				log.trace( "-> parse" );
				while( true )
				{
					if( c == -1 )
						break;
					
//					Assert.isFalse( c == 10, "No carriage returns" ); // no carriage returns
					
					if( startOfLine && Character.isWhitespace( c ) )
						buffer.append( (char)c );
					else
					{
						if( c == '$' )
						{
							if( startOfLine )
							{
								startOfLine = false;
								if( buffer.length() > 0 )
									writer.writeAsString( buffer );
							}
							// TODO And without {}?
							reader.mark( 10 );
							c = reader.read();
							if( c == '{' )
								readEuh( reader, writer, MODES.STRING );
							else
							{
								writer.writeAsString( '$' );
								reader.reset();
							}
						}
						else if( c == '<' )
						{
							reader.mark( 10 );
							c = reader.read();
							if( c == '%' )
							{
								reader.mark( 10 );
								c = reader.read();
								if( c == '=' )
								{
									if( startOfLine )
									{
										startOfLine = false;
										if( buffer.length() > 0 )
											writer.writeAsString( buffer );
									}
									readScript( reader, writer, MODES.EXPRESSION );
								}
								else if( c == '-' && reader.read() == '-' )
								{
									if( startOfLine )
									{
										startOfLine = false;
										if( buffer.length() > 0 )
											writer.writeAsString( buffer );
									}
									readComment( reader );
								}
								else
								{
									reader.reset();
									Writer writer2 = new Writer();
									readScript( reader, writer2, MODES.SCRIPT );
									if( startOfLine )
									{
										startOfLine = false;

										buffer2.setLength( 0 );
										reader.mark( 1 );
										c = reader.read();
										while( Character.isWhitespace( c ) && c != '\n' )
										{
											buffer2.append( (char)c );
											reader.mark( 1 );
											c = reader.read();
										}
										if( c == '\n' )
										{
											if( buffer.length() > 0 )
												writer.writeAsScript( buffer );
											writer.writeAsScript( writer2.buffer );
											if( buffer2.length() > 0 )
												writer.writeAsScript( buffer2 );
											writer.writeAsScript( '\n' ); // Must not lose newlines
											startOfLine = true;
											buffer.setLength( 0 );
										}
										else
										{
											reader.reset();
											if( buffer.length() > 0 )
												writer.writeAsString( buffer );
											writer.writeAsScript( writer2.buffer );
											if( buffer2.length() > 0 )
												writer.writeAsString( buffer2 );
										}
									}
									else
									{
										writer.writeAsScript( writer2.buffer );
									}
								}
							}
							else
							{
								if( startOfLine )
								{
									startOfLine = false;
									if( buffer.length() > 0 )
										writer.writeAsString( buffer );
								}
								writer.writeAsString( '<' );
								reader.reset();
							}
						}
						else if( c == '\\' )
						{
							if( startOfLine )
							{
								startOfLine = false;
								if( buffer.length() > 0 )
									writer.writeAsString( buffer );
							}
							reader.mark( 10 );
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
								reader.reset();
							}
						}
						else if( c == '"' )
						{
							if( startOfLine )
							{
								startOfLine = false;
								if( buffer.length() > 0 )
									writer.writeAsString( buffer );
							}
							writer.writeAsString( '\\' );
							writer.writeAsString( (char)c );
						}
						else if( c == '\n' )
						{
							if( startOfLine )
							{
								if( buffer.length() > 0 )
									writer.writeAsString( buffer );
							}
							else
							{
								startOfLine = true;
								buffer.setLength( 0 );
							}
							writer.writeAsString( (char)c );
						}
						else
						{
							if( startOfLine )
							{
								startOfLine = false;
								if( buffer.length() > 0 )
									writer.writeAsString( buffer );
							}
							writer.writeAsString( (char)c );
						}
					}
					
					c = reader.read();
				}
			}
			catch( IOException e )
			{
				throw new SystemException( e );
			}
			log.trace( "<- parse" );

			writer.endAll();

			writer.writeRaw( "}}}" );

			return writer.getString();
		}
		
		protected void readScript( Reader reader, Writer writer, MODES mode ) throws IOException
		{
			Assert.isTrue( mode == MODES.SCRIPT || mode == MODES.EXPRESSION );
			
			log.trace( "-> readScript" );
			while( true )
			{
				int c = reader.read();
				Assert.isTrue( c > 0 );
				if( c == '"' )
					readGString( reader, writer, mode );
				else if( c == '\'' )
					readString( reader, writer, mode );
				else if( c == '%' )
				{
					reader.mark( 10 );
					c = reader.read();
					if( c == '>' )
						break;
					writer.writeAs( '%', mode );
					reader.reset();
				}
				else
					writer.writeAs( (char)c, mode );
			}
			log.trace( "<- readScript" );
		}
		
		protected void readGString( Reader reader, Writer writer, MODES mode ) throws IOException
		{
			log.trace( "-> readGString" );
			writer.writeAs( '"', mode );
			boolean escaped = false;
			while( true )
			{
				int c = reader.read();
				Assert.isTrue( c > 0, "Expected \", got EOF" );
				if( !escaped )
				{
					escaped = c == '\\';
					if( c == '"' )
						break;
					if( c == '$' )
					{
						reader.mark( 10 );
						c = reader.read();
						if( c == '{' )
						{
							readEuh( reader, writer, mode );
						}
						else
						{
							writer.writeAs( '$', mode );
							reader.reset();
						}
					}
					else
						writer.writeAs( (char)c, mode );
				}
				else
				{
					escaped = false;
					writer.writeAs( (char)c, mode );
				}
			}
			writer.writeAs( '"', mode );
			log.trace( "<- readGString" );
		}
		
		protected void readString( Reader reader, Writer writer, MODES mode ) throws IOException
		{
			log.trace( "-> readString" );
			writer.writeAs( '\'', mode );
			boolean escaped = false;
			while( true )
			{
				int c = reader.read();
				Assert.isTrue( c > 0 );
				if( c == '\'' && !escaped )
					break;
				escaped = c == '\\';
				writer.writeAs( (char)c, mode );
			}
			writer.writeAs( '\'', mode );
			log.trace( "<- readString" );
		}
		
		protected void readEuh( Reader reader, Writer writer, MODES mode ) throws IOException
		{
			log.trace( "-> readEuh" );
			writer.writeAs( '$', mode );
			writer.writeAs( '{', mode );
			while( true )
			{
				int c = reader.read();
				Assert.isTrue( c > 0 );
				if( c == '}' )
					break;
				if( c == '"' )
					readGString( reader, writer, mode );
				else if( c == '\'' )
					readString( reader, writer, mode );
				else
					writer.writeAs( (char)c, mode );
			}
			writer.writeAs( '}', mode );
			log.trace( "<- readEuh" );
		}
		
		protected void readComment( Reader reader ) throws IOException
		{
			log.trace( "-> readComment" );
			while( true )
			{
				int c = reader.read();
				Assert.isTrue( c > 0 );
				if( c == '-' )
				{
					reader.mark( 10 );
					if( reader.read() == '-' && reader.read() == '%' && reader.read() == '>' )
						break;
					reader.reset();
				}
				else if( c == '<' )
				{
					reader.mark( 10 );
					if( reader.read() == '%' && reader.read() == '-' && reader.read() == '-' )
						readComment( reader );
					else
						reader.reset();
				}
			}
			log.trace( "<- readComment" );
		}
	}
	
	static protected enum MODES { UNKNOWN, STRING, SCRIPT, EXPRESSION }
	
	static protected class Writer
	{
		protected StringBuilder buffer;
		protected MODES mode = MODES.UNKNOWN;
		
		protected Writer()
		{
			this.buffer = new StringBuilder();
		}
		
		protected void writeAsString( char c )
		{
			endAllExcept( MODES.STRING );
			if( this.mode == MODES.UNKNOWN )
			{
				this.buffer.append( "out<<autoEncode(\"\"\"" );
				this.mode = MODES.STRING;
			}
			this.buffer.append( c );
		}
		
		protected void writeAsString( CharSequence string )
		{
			endAllExcept( MODES.STRING );
			if( this.mode == MODES.UNKNOWN )
			{
				this.buffer.append( "out<<autoEncode(\"\"\"" );
				this.mode = MODES.STRING;
			}
			this.buffer.append( string );
		}
		
		protected void writeAsExpression( char c )
		{
			endAllExcept( MODES.EXPRESSION );
			if( this.mode == MODES.UNKNOWN )
			{
				this.buffer.append( "out<<(" );
				this.mode = MODES.EXPRESSION;
			}
			this.buffer.append( c );
		}
		
		protected void writeAsScript( char c )
		{
			endAllExcept( MODES.SCRIPT );
			if( this.mode == MODES.UNKNOWN )
				this.mode = MODES.SCRIPT;
			this.buffer.append( c );
		}
		
		protected void writeAsScript( CharSequence script )
		{
			endAllExcept( MODES.SCRIPT );
			if( this.mode == MODES.UNKNOWN )
				this.mode = MODES.SCRIPT;
			this.buffer.append( script );
		}
		
		protected void writeAs( char c, MODES mode )
		{
			if( mode == MODES.EXPRESSION )
				writeAsExpression( c );
			else if( mode == MODES.SCRIPT )
				writeAsScript( c );
			else if( mode == MODES.STRING )
				writeAsString( c );
			else
				Assert.fail( "mode UNKNOWN not allowed" );
		}
		
		protected void writeRaw( String s )
		{
			this.buffer.append( s );
		}
		
		private void endExpression()
		{
			Assert.isTrue( this.mode == MODES.EXPRESSION );
			this.buffer.append( ");" );
			this.mode = MODES.UNKNOWN;
		}
		
		private void endScript()
		{
			Assert.isTrue( this.mode == MODES.SCRIPT );
			this.buffer.append( ';' );
			this.mode = MODES.UNKNOWN;
		}
		
		private void endString()
		{
			Assert.isTrue( this.mode == MODES.STRING );
			this.buffer.append( "\"\"\");" );
			this.mode = MODES.UNKNOWN;
		}
		
		private void endAllExcept( MODES mode )
		{
			if( this.mode == mode )
				return;
			
			if( this.mode == MODES.STRING )
				endString();
			else if( this.mode == MODES.EXPRESSION )
				endExpression();
			else if( this.mode == MODES.SCRIPT )
				endScript();
		}
		
		protected void endAll()
		{
			endAllExcept( null );
		}
		
		protected String getString()
		{
			return this.buffer.toString();
		}
	}
}
