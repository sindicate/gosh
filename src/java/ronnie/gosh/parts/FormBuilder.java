package ronnie.gosh.parts;

import groovy.lang.Closure;
import groovy.lang.GroovyObject;
import groovy.lang.MetaClass;
import groovy.lang.MissingMethodException;

import java.util.Map;

import org.codehaus.groovy.runtime.InvokerHelper;

import ronnie.gosh.parts.Table.Column;

import com.logicacmg.idt.commons.NotImplementedException;

public class FormBuilder implements GroovyObject
{
	protected FormSupport form;
	protected Component current;
	
	public FormBuilder( FormSupport form )
	{
		this.form = form;
		this.current = form;
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

	@Override
	public Object invokeMethod( String name, Object _args )
	{
		Object[] args = (Object[])_args;
		if( name.equals( "table" ) )
		{
			if( args.length == 1 )
			{
				if( args[ 0 ] instanceof Closure )
				{
					Table table = new Table( (Composite)this.current );
					this.current = table;
					
					Closure closure = (Closure)args[ 0 ];
					closure.setDelegate( this );
					closure.call();
					
					// TODO Check that columns have been added
					return table;
				}
			}
		}
		else if( name.equals( "column" ) )
		{
			Table table = (Table)this.current;
			if( args.length == 1 )
			{
				if( args[ 0 ] instanceof Map )
				{
					Map map = (Map)args[ 0 ];
					Column column = new Column();
					column.data = (String)map.get( "data" );
					column.header = (String)map.get( "header" );
					table.addColumn( column );
					return column;
				}
			}
		}
		throw new MissingMethodException( name, this.form.getClass(), args );
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
