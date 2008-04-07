package ronnie.gosh.parts;

import groovy.lang.Closure;
import groovy.lang.GroovyInterceptable;
import groovy.lang.MetaClass;

import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.groovy.runtime.InvokerHelper;
import org.fest.assertions.Assertions;

import ronnie.gosh.parts.Table.Column;

import com.logicacmg.idt.commons.NotImplementedException;
import com.logicacmg.idt.commons.util.Assert;

public class ScreenBuilder implements GroovyInterceptable
{
	static private final Logger log = Logger.getLogger( ScreenBuilder.class );
	
	protected ScreenSupport screen;
	protected Object current;
	
	public ScreenBuilder( ScreenSupport screen )
	{
		this.screen = screen;
		this.current = screen;
	}
	
	protected Object callClosure( Object current, Closure closure )
	{
		Object old = this.current;
		this.current = current;
		
		closure.setDelegate( this );
		closure.setResolveStrategy( Closure.DELEGATE_FIRST );
		Object result = closure.call();
		closure.setResolveStrategy( Closure.OWNER_ONLY );
		
		this.current = old;
		return result;
	}
	
	public Object call( Closure closure )
	{
		return callClosure( this.screen, closure );
	}

	@Override
	public MetaClass getMetaClass()
	{
		return InvokerHelper.getMetaClass( getClass() );
	}

	// TODO Give errors on unexpected arguments
	protected Form form( Map args, Closure closure )
	{
		String name = (String)args.remove( "name" );
		Object title = args.remove( "title" );
		Closure retrieve = (Closure)args.remove( "retrieve" );
		Closure update = (Closure)args.remove( "update" );
		Form form = new Form( name, title != null ? title.toString() : null, (Composite)this.current, retrieve, update, args );
		
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

		if( this.current instanceof Form )
		{
			Form form = (Form)this.current;
			form.addValue( value );
			return value;
		}
		
		Assertions.assertThat( this.current ).isInstanceOf( Column.class );
		Column column = (Column)this.current;
		column.addValue( value );
		return value;
	}
	
	protected Message message()
	{
		return new Message( null, (Composite)this.current );
	}

	protected Errors errors( Object... components )
	{
		return new Errors( null, (Composite)this.current, components );
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
		Closure retrieve = (Closure)args.remove( "retrieve" );
		Closure update = (Closure)args.remove( "update" );
		Message status = (Message)args.remove( "status" );
		Errors errors = (Errors)args.remove( "errors" );
		Assert.isNull( errors, "'errors' attribute not expected for 'table'" );
		Table table = new Table( name, (Composite)this.current, retrieve, update, args, status );
		Object title = args.remove( "title" );
		table.title = title != null ? title.toString() : null;
		Closure rowAdded = (Closure)args.remove( "rowAdded" );
		table.rowAdded = rowAdded;
		Boolean timestamp = (Boolean)args.get( "timestamp" );
		table.timestamp = timestamp != null ? timestamp : false;
		
		callClosure( table, closure );

		// TODO Check that columns have been added
		return table;
	}

	protected Column column( Map args )
	{
		Value value = new Value();
		value.path = (String)args.get( "path" );
		Boolean edit = (Boolean)args.get( "edit" );
		value.edit = edit != null ? edit : false;
//		Boolean key = (Boolean)args.get( "key" );
//		value.key = key != null ? key : false;
		Select select = (Select)args.get( "select" );
		value.select = select;
		Boolean mandatory = (Boolean)args.get( "mandatory" );
		value.mandatory = mandatory != null ? mandatory : false;
		Boolean checkbox = (Boolean)args.get( "checkbox" );
		value.checkbox = checkbox != null ? checkbox : false;
		value.size = (Integer)args.get( "size" );

		Column column = new Column();
		column.header = (String)args.get( "header" );
		
		if( value.path != null )
			column.addValue( value );
		
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
	
	protected Column column( Map args, Closure closure )
	{
		Column column = column( args );
		callClosure( column, closure );
		return column;
	}
	
	protected Link link( Map args )
	{
		Link link = new Link();
		link.text = (String)args.remove( "text" );
		link.html = (String)args.remove( "html" );
		link.args = args;

		Column column = (Column)this.current;
		column.addLink( link );
		return link;		
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
	public Object getProperty( String name )
	{
		log.debug( "getProperty [" + ( this.current != null ? this.current.getClass() : "null" ) + "][" + name + "]" );
		return ( (Composite)this.current ).childs.get( name );
	}
	
	@Override
	public void setProperty( String name, Object value )
	{
		log.debug( "setProperty [" + ( this.current != null ? this.current.getClass() : "null" ) + "][" + name + "] <- [" + ( value != null ? value.getClass() : "null" ) + "]" );
		( (Composite)this.current ).childs.put( name, (Component)value );
		( (Component)value ).name = name;
	}
}
