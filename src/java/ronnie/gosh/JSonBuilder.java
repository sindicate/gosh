package ronnie.gosh;

import groovy.lang.GroovyObjectSupport;


public class JSonBuilder extends GroovyObjectSupport
{
////	private static final Logger __LOGGER = Logger.getLogger( JSonBuilder.class );
//
//	private JSONWriter jsonWriter;
//	private Writer writer;
//
//	public JSonBuilder( HttpServletResponse response ) throws IOException
//	{
//		this( response.getWriter() );
//		response.setContentType( "application/x-javascript" );
//	}
//
//	public JSonBuilder( Writer writer )
//	{
//		this.writer = writer;
//		this.jsonWriter = new JSONWriter( writer );
//	}
//
//	@Override
//	public Object invokeMethod( String methodName, Object arg )
//	{
////		__LOGGER.debug( "invokeMethod [" + methodName + "] [" + InvokerHelper.toString( args ) + "]" );
//
//		Assert.notBlank( methodName );
//
//		List args = InvokerHelper.asList( arg );
//		try
//		{
//			if( methodName.equals( "call" ) )
//			{
//				Assert.isTrue( args.size() == 1, "Expecting 1 argument" );
//				Closure closure = (Closure)args.get( 0 );
//				closure.setDelegate( this );
//				closure.call();
//			}
//			else if( methodName.equals( "assignTo" ) )
//			{
//				Assert.isTrue( args.size() == 2, "Expecting 2 arguments" );
//				String var = (String)args.get( 0 );
//				Closure closure = (Closure)args.get( 1 );
//				this.writer.write( "var " + var + "=" );
//				this.jsonWriter = new JSONWriter( this.writer );
//				closure.setDelegate( this );
//				closure.call();
//				this.writer.write( ";\n" );
//			}
//			else if( methodName.equals( "key" ) )
//			{
//				Assert.isTrue( args.size() == 1, "Expecting 1 argument" );
////				System.out.println( "key" );
//				this.jsonWriter.key( (String)args.get( 0 ) );
//			}
//			else if( methodName.equals( "value" ) )
//			{
//				Assert.isTrue( args.size() == 1, "Expecting 1 argument" );
////				System.out.println( "value" );
//				this.jsonWriter.value( args.get( 0 ) );
//			}
//			else if( methodName.equals( "array" ) )
//			{
//				writeArray( args );
//			}
//			else if( methodName.equals( "delayedArray" ) )
//			{
//				return new DelayedArray( args );
//			}
//			else if( methodName.equals( "object" ) )
//			{
//				writeObject( args );
//			}
//			else if( methodName.equals( "delayedObject" ) )
//			{
//				return new DelayedObject( args );
//			}
//			else
//				Assert.fail( "Unknown method [" + methodName + "]" );
//		}
//		catch( JSONException e )
//		{
//			throw new SystemException( e );
//		}
//		catch( IOException e )
//		{
//			throw new SystemException( e );
//		}
//		
//		return null;
//	}
//	
//	private void writeElements( List args ) throws JSONException
//	{
//		for( Object object : args )
//			if( object instanceof Closure )
//			{
//				Closure closure = (Closure)object;
//				closure.setDelegate( this );
//				closure.call();
//			}
//			else if( object instanceof DelayedArray )
//				writeArray( ( (DelayedArray)object ).args );
//			else if( object instanceof DelayedObject )
//				writeObject( ( (DelayedObject)object ).args );
//			else if( object instanceof List )
//				writeElements( (List)object );
//			else
//			{
////				System.out.println( "value" );
//				this.jsonWriter.value( object );
//			}
//	}
//	
//	private void writeArray( List args ) throws JSONException
//	{
////		System.out.println( "array" );
//		this.jsonWriter.array();
//		writeElements( args );
////		System.out.println( "endArray" );
//		this.jsonWriter.endArray();
//	}
//	
//	private void writeObject( List args ) throws JSONException
//	{
////		System.out.println( "object" );
//		this.jsonWriter.object();
//		for( Object object : args )
//			if( object instanceof Closure )
//			{
//				Closure closure = (Closure)object;
//				closure.setDelegate( this );
//				closure.call();
//			}
//			else if( object instanceof Map )
//			{
//				for( Iterator iterator = ((Map)object).entrySet().iterator(); iterator.hasNext(); )
//				{
//					Map.Entry entry = (Map.Entry)iterator.next();
////					System.out.println( "key" );
//					this.jsonWriter.key( (String)entry.getKey() );
//					if( entry.getValue() instanceof DelayedArray )
//						writeArray( ( (DelayedArray)entry.getValue() ).args );
//					else if( entry.getValue() instanceof DelayedObject )
//						writeObject( ( (DelayedObject)entry.getValue() ).args );
//					else
//					{
////						System.out.println( "value" );
//						this.jsonWriter.value( entry.getValue() );
//					}
//				}
//			}
//			else
//				Assert.fail( "Unknown argument to object [" + object.getClass() + "]" );
////		System.out.println( "endObject" );
//		this.jsonWriter.endObject();
//	}
//	
//	static protected class DelayedArray
//	{
//		protected List args;
//		protected DelayedArray( List args )
//		{
//			this.args = args;
//		}
//	}
//	
//	static protected class DelayedObject
//	{
//		protected List args;
//		protected DelayedObject( List args )
//		{
//			this.args = args;
//		}
//	}
}
