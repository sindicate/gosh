package ronnie.gosh.parts;

import groovy.lang.Closure;
import groovy.lang.GroovyObject;
import groovy.lang.MetaClass;

import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.groovy.runtime.InvokerHelper;

import ronnie.gosh.parts.Form.Value;
import ronnie.gosh.parts.Table.Column;

import com.logicacmg.idt.commons.NotImplementedException;
import commonj.sdo.DataObject;

public class ScreenBuilder implements GroovyObject
{
	static private final Logger log = Logger.getLogger( ScreenBuilder.class );
	
	protected ScreenSupport screen;
	protected Object current;
	
	public ScreenBuilder( ScreenSupport screen )
	{
		this.screen = screen;
		this.current = screen;
	}
	
	protected void callClosure( Object current, Closure closure )
	{
		Object old = this.current;
		this.current = current;
		
		closure.setDelegate( this );
		closure.call();
		closure.setResolveStrategy( Closure.OWNER_ONLY );
		
		this.current = old;
	}
	
	public Object call( Closure closure )
	{
		closure.setDelegate( this );
		Object result = closure.call();
		closure.setResolveStrategy( Closure.OWNER_ONLY );
		return result;
	}

	@Override
	public MetaClass getMetaClass()
	{
		return InvokerHelper.getMetaClass( getClass() );
	}

	@Override
	public Object getProperty( String name )
	{
		return getMetaClass().getProperty( this, name );
	}
	
	protected Form form( Map args, Closure closure )
	{
		String name = (String)args.remove( "name" );
		Object title = args.remove( "title" );
		String path = (String)args.remove( "path" );
		Closure retrieve = (Closure)args.remove( "retrieve" );
		Closure update = (Closure)args.remove( "update" );
		Errors errors = (Errors)args.remove( "errors" );
		Form form = new Form( name, title != null ? title.toString() : null, (Composite)this.current, path, retrieve, update, args, errors );
		
		callClosure( form, closure );

		// TODO Check that values have been added
		return form;
	}

	protected Value value( Map args )
	{
		Value value = new Value();
		value.path = (String)args.get( "path" );
		value.description = (String)args.get( "description" );
		Boolean edit = (Boolean)args.get( "edit" );
		value.edit = edit != null ? edit : false;
		Select select = (Select)args.get( "select" );
		value.select = select;
		Boolean mandatory = (Boolean)args.get( "mandatory" );
		value.mandatory = mandatory != null ? mandatory : false;

		Form form = (Form)this.current;
		form.addValue( value );
		return value;
	}
	
	protected Message message()
	{
		return new Message( null, (Composite)this.current );
	}

	protected Errors errors()
	{
		return new Errors( null, (Composite)this.current );
	}

	protected Button button( Map args )
	{
		String name = (String)args.remove( "name" );
		String type = (String)args.remove( "type" );
		Closure clicked = (Closure)args.remove( "clicked" );
		return new Button( name, (Composite)this.current, type, clicked, args );
	}

	// TODO Rename to datatable or something like that
	protected Table table( Map args, Closure closure )
	{
		String name = (String)args.remove( "name" );
		DataObject data = (DataObject)args.remove( "data" );
		Closure retrieve = (Closure)args.remove( "retrieve" );
		String path = (String)args.remove( "path" );
		Closure update = (Closure)args.remove( "update" );
		Message status = (Message)args.remove( "status" );
		Errors errors = (Errors)args.remove( "errors" );
		Table table = new Table( name, (Composite)this.current, data, path, retrieve, update, args, status, errors );
		
		callClosure( table, closure );

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
		Select select = (Select)args.get( "select" );
		column.select = select;
		Boolean mandatory = (Boolean)args.get( "mandatory" );
		column.mandatory = mandatory != null ? mandatory : false;

		Table table = (Table)this.current;
		table.addColumn( column );
		return column;
	}
	
	protected Column column( Closure closure )
	{
		Column column = new Column();

		callClosure( column, closure );

		Table table = (Table)this.current;
		table.addColumn( column );
		return column;
	}
	
	protected Link link( Map args )
	{
		Link link = new Link();
		link.text = (String)args.remove( "text" );
		link.args = args;

		Column column = (Column)this.current;
		column.addLink( link );
		return link;		
	}
	
	protected Data data( String path )
	{
		return new Data( path );
	}
	
	protected Column delete()
	{
		Column column = new Column();
		column.delete = true;

		Table table = (Table)this.current;
		table.addColumn( column );
		return column;
	}
	
	protected Select select( Map args )
	{
		Select select = new Select();
		select.key = (String)args.get( "key" );
		select.display = (String)args.get( "display" );
		select.retrieve = (Closure)args.get( "retrieve" );
		return select;
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
		( (Composite)this.current ).childs.put( name, (Component)value );
		( (Component)value ).name = name;
//		InvokerHelper.setProperty( this.current.c, name, value );
//		throw new NotImplementedException();
	}
}
