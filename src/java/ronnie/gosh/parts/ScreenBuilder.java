package ronnie.gosh.parts;

import groovy.lang.Closure;
import groovy.lang.GroovyObject;
import groovy.lang.MetaClass;

import java.util.Map;

import org.codehaus.groovy.runtime.InvokerHelper;

import ronnie.gosh.parts.Table.Column;

import com.logicacmg.idt.commons.NotImplementedException;

public class ScreenBuilder implements GroovyObject
{
	protected ScreenSupport screen;
	protected Component current;
	
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
	
//	protected Form form( Map args, Closure closure )
//	{
//		Form form = new Form( (Composite)this.current, args );
//		this.current = form;
//		
//		closure.setDelegate( this );
//		closure.call();
//		
//		this.current = form.parent;
//
//		return form;
//	}

	protected Table table( Map args, Closure closure )
	{
		Table table = new Table( (Composite)this.current, args );
		this.current = table;
		
		closure.setDelegate( this );
		closure.call();
		
		this.current = table.parent;

		// TODO Check that columns have been added
		return table;
	}

	protected Column column( Map args )
	{
		Column column = new Column();
		column.data = (String)args.get( "data" );
		column.header = (String)args.get( "header" );
		Boolean edit = (Boolean)args.get( "edit" );
		column.edit = edit != null ? edit : false;

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
	public void setProperty( String name, Object arg1 )
	{
		throw new NotImplementedException();
	}
}
