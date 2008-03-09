package ronnie.gosh.parts;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import commonj.sdo.DataObject;

public class Table extends Component
{
	static public class Column
	{
		protected String data;
		protected String header;
		protected boolean edit;
	}

	protected List< Column > columns;
	protected List< DataObject > data;
	
	public Table( Composite parent, List<DataObject> data, Map args )
	{
		super( parent );
		this.columns = new ArrayList();
		
		setData( data );
	}
	
	@Override
	public void render()
	{
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
			out.print( "<table class=\"table\">" );
		out.print( "<tr class=\"row\">" );
		for( Column column : this.columns )
		{
			out.print( "<th>" );
			out.print( column.header );
			out.print( "</th>" );
		}
		out.print( "</tr>" );
		for( DataObject data : this.data )
		{
			out.print( "<tr class=\"row\">" );
			for( Column column : this.columns )
			{
				out.print( "<td>" );
				if( column.edit )
				{
					out.print( "<input name=\"" );
					out.print( column.data );
					out.print( "\" value=\"" );
					out.print( data.getString( column.data ) );
					out.print( "\"/>" );
				}
				else
					out.print( data.getString( column.data ) );
				out.print( "</td>" );
			}
		}
		out.println( "</table>" );
	}

	public void addColumn( Column column )
	{
		this.columns.add( column );
	}
	
	public void setData( List< DataObject > data )
	{
		this.data = data;
	}
}
