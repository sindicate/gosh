package ronnie.gosh;

import groovy.lang.Closure;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyCodeSource;
import groovy.lang.GroovyObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

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
			
		String script = new Parser().parse( new Scanner( reader ), pkg, name );
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
					script = new Parser().parse( new Scanner( in ), packag, name );
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
	
	static protected class Scanner
	{
//		static final private Logger log = Logger.getLogger( Scanner.class );

		protected Reader reader;
		protected Stack< Integer > pushBack = new Stack();
		protected Stack< Integer > pushBackMarked;
		
		protected Scanner( Reader reader )
		{
			if( !reader.markSupported() )
				reader = new BufferedReader( reader );
			this.reader = reader;
		}
		
		protected int read()
		{
			if( this.pushBack.isEmpty() )
				try
				{
					int c = this.reader.read();
					if( c == 13 )
					{
						c = this.reader.read();
						if( c != 10 )
						{
							unread( c );
							c = 10;
						}
					}
					return c;
				}
				catch( IOException e )
				{
					throw new SystemException( e );
				}
			return this.pushBack.pop();
		}
		
		protected void unread( int c )
		{
			this.pushBack.push( c );
		}
		
		protected void mark( int readAheadLimit )
		{
			try
			{
				this.reader.mark( readAheadLimit );
			}
			catch( IOException e )
			{
				throw new SystemException( e );
			}
			this.pushBackMarked = (Stack)this.pushBack.clone();
		}
		
		protected void reset()
		{
			try
			{
				this.reader.reset();
			}
			catch( IOException e )
			{
				throw new SystemException( e );
			}
			this.pushBack = this.pushBackMarked;
			this.pushBackMarked = null;
		}
		
		protected String readWhitespace()
		{
			StringBuilder builder = new StringBuilder();
			int c = read();
			while( Character.isWhitespace( (char)c ) && c != '\n' )
			{
				builder.append( (char)c );
				c = read();
			}
			unread( c );
			return builder.toString();
		}
	}
	
	static protected class Parser
	{
//		static final private Logger log = Logger.getLogger( GroovyPageCompiler.class );

		protected Parser()
		{
			// Constructor
		}
		
		protected String parse( Scanner reader, String pkg, String cls )
		{
			Writer writer = new Writer();
			writer.writeRaw( "package " + pkg + ";class " + cls + "{Closure getClosure(){return{" );

//			log.trace( "-> parse" );
			String leading = reader.readWhitespace();
			int c = reader.read();
			while( c != -1 )
			{
				if( c == '<' )
				{
					c = reader.read();
					if( c == '%' )
					{
						reader.mark( 2 );
						c = reader.read();
						if( c == '=' )
						{
							writer.writeAsString( leading ); leading = null;
							readScript( reader, writer, MODES.EXPRESSION );
						}
						else if( c == '-' && reader.read() == '-' )
						{
							if( leading == null )
								readComment( reader );
							else
							{
								readComment( reader );
								String trailing = reader.readWhitespace();
								c = reader.read();
								if( (char)c == '\n' )
									// Comment on lines of his own, then ignore the lines.
									leading = reader.readWhitespace();
								else
								{
									reader.unread( c );
									writer.writeAsString( leading ); leading = null;
									writer.writeAsString( trailing );
								}
							}
						}
						else
						{
							reader.reset();
							if( leading == null )
								readScript( reader, writer, MODES.SCRIPT );
							else
							{
								Writer writer2 = new Writer();
								readScript( reader, writer2, MODES.SCRIPT );
								String trailing = reader.readWhitespace();
								c = reader.read();
								if( (char)c == '\n' )
								{
									// If script on lines of his own, add the whitespace and the newline to the script.
									writer.writeAsScript( leading ); leading = null;
									writer.writeAsScript( writer2.buffer );
									writer.writeAsScript( trailing );
									writer.writeAsScript( '\n' ); // Must not lose newlines
									leading = reader.readWhitespace();
								}
								else
								{
									reader.unread( c );
									writer.writeAsString( leading ); leading = null;
									writer.writeAsScript( writer2.buffer );
									writer.writeAsString( trailing );
								}
							}
						}
					}
					else
					{
						writer.writeAsString( leading ); leading = null;
						writer.writeAsString( '<' );
						reader.unread( c );
					}
				}
				else
				{
					writer.writeAsString( leading ); leading = null;
					if( c == '$' )
					{
						// TODO And without {}?
						c = reader.read();
						if( c == '{' )
							readGStringExpression( reader, writer, MODES.STRING );
						else
						{
							writer.writeAsString( '$' );
							reader.unread( c );
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
							reader.unread( c );
						}
					}
					else if( c == '"' )
					{
						writer.writeAsString( '\\' );
						writer.writeAsString( (char)c );
					}
					else if( c == '\n' )
					{
						writer.writeAsString( (char)c );
						leading = reader.readWhitespace();
					}
					else
					{
						writer.writeAsString( (char)c );
					}
				}

				c = reader.read();
			}
			writer.writeAsString( leading );

//			log.trace( "<- parse" );

			writer.endAll();

			writer.writeRaw( "}}}" );

			return writer.getString();
		}
		
		protected void readScript( Scanner reader, Writer writer, MODES mode )
		{
			Assert.isTrue( mode == MODES.SCRIPT || mode == MODES.EXPRESSION );
			
//			log.trace( "-> readScript" );
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
					c = reader.read();
					if( c == '>' )
						break;
					reader.unread( c );
					writer.writeAs( '%', mode );
				}
				else
					writer.writeAs( (char)c, mode );
			}
//			log.trace( "<- readScript" );
		}
		
		protected void readGString( Scanner reader, Writer writer, MODES mode )
		{
//			log.trace( "-> readGString" );
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
						c = reader.read();
						if( c == '{' )
						{
							readGStringExpression( reader, writer, mode );
						}
						else
						{
							reader.unread( c );
							writer.writeAs( '$', mode );
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
//			log.trace( "<- readGString" );
		}
		
		protected void readString( Scanner reader, Writer writer, MODES mode )
		{
//			log.trace( "-> readString" );
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
//			log.trace( "<- readString" );
		}
		
		protected void readGStringExpression( Scanner reader, Writer writer, MODES mode )
		{
//			log.trace( "-> readEuh" );
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
//			log.trace( "<- readEuh" );
		}
		
		protected void readComment( Scanner reader )
		{
//			log.trace( "-> readComment" );
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
//			log.trace( "<- readComment" );
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
			if( string == null || string.length() == 0 )
				return;

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
			if( script == null || script.length() == 0 )
				return;
			
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
		
		protected void writeAs( CharSequence string, MODES mode )
		{
			if( string == null || string.length() == 0 )
				return;
			
			if( mode == MODES.EXPRESSION )
				Assert.fail( "mode EXPRESSION not allowed" );
			else if( mode == MODES.SCRIPT )
				writeAsScript( string );
			else if( mode == MODES.STRING )
				writeAsString( string );
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
