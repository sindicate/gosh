package ronnie.gosh.parts;

import groovy.lang.Closure;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.codehaus.groovy.runtime.InvokerHelper;

import ronnie.gosh.RequestContext;

import com.logicacmg.idt.commons.util.Assert;

public abstract class Component
{
//	static private final Logger log = Logger.getLogger( Component.class );

	protected String name;
//	protected Map<String, String> attributes = new HashMap();
	protected Composite parent;
	
	public Component( String name, Composite parent )
	{
		this.name = name;
		if( parent != null )
		{
			this.parent = parent;
			if( name != null )
			{
				Assert.isFalse( parent.childs.containsKey( name ) );
				parent.childs.put( name, this );
			}
		}
	}
	
//	public PrintWriter getOut()
//	{
//		return getRequestContext().getOut();
//	}
	
	public RequestContext getRequestContext()
	{
		Assert.notNull( this.parent );
		return this.parent.getRequestContext();
	}

//	public void setClass( String name )
//	{
//		this.attributes.put( "class", name );
//	}
	
	public void call( String action )
	{
		Assert.isTrue( action.indexOf( '.' ) < 0 );
		int pos = action.indexOf( '(' );
		Assert.isTrue( pos > 0 );
		Assert.isTrue( action.endsWith( ")" ) );
		if( pos < action.length() - 2 )
		{
			String arg = action.substring( pos + 1, action.length() - 1 );
			action = action.substring( 0, pos );
			InvokerHelper.invokeMethod( this, action, arg );
		}
		else
		{
			action = action.substring( 0, action.length() - 2 );
			InvokerHelper.invokeMethod( this, action, null );
		}
	}
	
	public String getPath()
	{
		Assert.notNull( this.parent );
		Assert.notNull( this.name );
		String path = this.parent.getPath();
		if( path != null )
			return path + "." + this.name;
		return this.name;
	}

	public String getText()
	{
		throw new UnsupportedOperationException();
	}
	
	public void render( RequestContext context )
	{
		throw new UnsupportedOperationException();
	}

	public void render( RequestContext context, Closure closure )
	{
		throw new UnsupportedOperationException();
	}
	
	protected void print( RequestContext context, PrintWriter out, Object value )
	{
		if( value != null )
		{
			String s;
			if( value instanceof Timestamp )
			{
				// TODO Need to use locale here?
				DateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ); 
				s = format.format( value );
			}
			else
				s = value.toString();
			out.print( context.encode( s ) );
		}
	}
	
	public void applyRequest( RequestContext context )
	{
		//
	}
}
