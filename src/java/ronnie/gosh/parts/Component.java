package ronnie.gosh.parts;

import groovy.lang.Closure;

import java.io.PrintWriter;

import org.apache.log4j.Logger;
import org.apache.tuscany.sdo.util.DataObjectUtil;
import org.apache.tuscany.sdo.util.DataObjectUtil.Accessor;
import org.codehaus.groovy.runtime.InvokerHelper;
import org.eclipse.emf.ecore.EObject;

import ronnie.gosh.RequestContext;

import com.logicacmg.idt.commons.NotImplementedException;
import com.logicacmg.idt.commons.util.Assert;
import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;

public abstract class Component
{
	static private final Logger log = Logger.getLogger( Component.class );

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
	
	static protected Integer toInteger( String value )
	{
		if( value == null )
			return null;
		return Integer.valueOf( value );
	}
	
	static protected void setValue0( DataObject data, String path, String value )
	{
		// TODO Check that only editable things are being set
		log.debug( "set [" + path + "] <- [" + value + "]" );
		Accessor accessor = DataObjectUtil.Accessor.create( (EObject)data, path, value );
		try
		{
			Property property = accessor.getProperty();
			Type type = property.getType();
			log.debug( "type: " + type );
			// TODO Better type checking
			if( type.getName().equals( "IntObject" ) )
				accessor.set( toInteger( value ) );
			else
				accessor.set( value );
		}
		finally
		{
			accessor.recycle();
		}
	}
	
	static public void setDataObjectValue( DataObject data, String path, String value )
	{
		Object old = data.get( path );
		if( value == null )
		{
			if( old != null )
				setValue0( data, path, value );
		}
		else if( !value.equals( old ) )
			setValue0( data, path, value );
	}
	
	public void setValue( String path, String value )
	{
		throw new NotImplementedException();
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
	
	protected void print( PrintWriter out, String s )
	{
		if( s != null )
			out.print( s );
	}
}
