package ronnie.gosh.parts;

import groovy.lang.Closure;
import groovy.lang.GroovyObject;
import groovy.lang.MetaClass;

import java.util.Map;

import org.codehaus.groovy.runtime.InvokerHelper;

import ronnie.gosh.parts.Table.Column;

import com.logicacmg.idt.commons.NotImplementedException;
import commonj.sdo.DataObject;

public class ScreenBuilder implements GroovyObject
{
//	static private final Logger log = Logger.getLogger( ScreenBuilder.class );
	
	protected ScreenSupport screen;
	protected Composite current;
	
	public ScreenBuilder( ScreenSupport screen )
	{
		this.screen = screen;
		this.current = screen;
	}
	
	public Object call( Closure closure )
	{
		closure.setDelegate( this );
		return closure.call();
	}

	@Override
	public MetaClass getMetaClass()
	{
		return InvokerHelper.getMetaClass( getClass() );
	}

	@Override
	public Object getProperty( String name )
	{
		throw new NotImplementedException();
	}
	
	protected Form form()
	{
		return form( null );
	}
	
	protected Form form( Map args )
	{
		String name = null;
		if( args != null )
		{
			name = (String)args.remove( "name" );
		}
		Form form = new Form( name, this.current, args );
		return form;
	}

	protected Message message()
	{
		return new Message( null, this.current );
	}

	protected Button button( Map args )
	{
		String name = (String)args.remove( "name" );
		String type = (String)args.remove( "type" );
		Closure clicked = (Closure)args.remove( "clicked" );
		return new Button( name, this.current, type, clicked, args );
	}

	// TODO Rename to datatable or something like that
	protected Table table( Map args, Closure closure )
	{
		String name = (String)args.remove( "name" );
		DataObject data = (DataObject)args.remove( "data" );
		String path = (String)args.remove( "path" );
		Closure update = (Closure)args.remove( "update" );
		Table table = new Table( name, this.current, data, path, update, args );
		
		Composite old = this.current;
		this.current = table;
		
		closure.setDelegate( this );
		closure.call();
		
		this.current = old;

		// TODO Check that columns have been added
		return table;
	}

	protected Column column( Map args )
	{
		Column column = new Column();
		column.path = (String)args.get( "path" );
		column.header = (String)args.get( "header" );
		Boolean edit = (Boolean)args.get( "edit" );
		column.edit = edit != null ? edit : false;
		Boolean key = (Boolean)args.get( "key" );
		column.key = key != null ? key : false;

		Table table = (Table)this.current;
		table.addColumn( column );
		return column;
	}

    public Object invokeMethod( String name, Object args )
	{
		return getMetaClass().invokeMethod( this, name, args );
	}

	@Override
	public void setMetaClass( MetaClass name )
	{
		throw new NotImplementedException();
	}

	@Override
	public void setProperty( String name, Object value )
	{
//		log.debug( "setting property [" + ( this.current != null ? this.current.getClass() : "null" ) + "][" + name + "] <- [" + ( value != null ? value.getClass() : "null" ) + "]" );
		this.current.childs.put( name, (Component)value );
		( (Component)value ).name = name;
//		InvokerHelper.setProperty( this.current.c, name, value );
//		throw new NotImplementedException();
	}
}
