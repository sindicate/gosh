package ronnie.gosh.parts;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.logicacmg.idt.commons.util.Assert;
import commonj.sdo.DataObject;

public class Table extends Composite
{
	static private final Logger log = Logger.getLogger( Table.class );

	static public class Column
	{
		protected String path;
		protected String header;
		protected boolean edit;
	}

	protected List< Column > columns;
	protected DataObject data;
	protected String path;
	
	public Table( String name, Composite parent, DataObject data, String path, Map args )
	{
		super( name, parent );
		this.columns = new ArrayList();
		setData( data, path );
	}
	
	@Override
	public void render()
	{
		// TODO Get the complete path instead of only the name
		
		PrintWriter out = getOut();
		if( this.attributes.size() > 0 )
		{
			out.print( "<table" );
			for( Entry< String, String > attribute : this.attributes.entrySet() )
			{
				out.print( ' ' );
				out.print( attribute.getKey() );
				out.print( "=\"" );
				out.print( attribute.getValue() );
				out.print( '"' );
			}
			out.print( '>' );
		}
		else
			out.print( "<table class=\"table\">\n" );
		out.print( "	<tr class=\"row\">" );
		for( Column column : this.columns )
		{
			out.print( "<th>" );
			out.print( column.header );
			out.print( "</th>" );
		}
		out.print( "</tr>\n" );
		List<DataObject> data = this.data.getList( this.path );
		String path = this.name + "." + this.path;
		int i = 1;
		for( DataObject row : data )
		{
			String path2 = path + "[" + i++ + "]/";
			out.print( "	<tr class=\"row\">\n" );
			for( Column column : this.columns )
			{
				out.print( "		<td>" );
				if( column.edit )
				{
					out.print( "<input name=\"" );
					out.print( path2 );
					out.print( column.path );
					out.print( "\" value=\"" );
					out.print( row.getString( column.path ) );
					out.print( "\"/>" );
				}
				else
					out.print( row.getString( column.path ) );
				out.print( "</td>\n" );
			}
			out.print( "	</tr>\n" );
		}
		out.println( "</table>\n" );
	}

	public void addColumn( Column column )
	{
		this.columns.add( column );
	}
	
	public void setData( DataObject data, String path )
	{
		Assert.notNull( data );
		Assert.notNull( path );
		this.data = data;
		this.path = path;
	}
	
	public void update()
	{
		log.debug( "updating" );
	}
	
	@Override
	public void setValue( String name, String value )
	{
		log.debug( "set [" + this.getClass() + "][" + name + "] <- [" + value + "]" );
		this.data.set( name, value );
	}
}
