package ronnie.gosh.parts;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
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
	}

	protected Map<String, String> attributes = new HashMap();
	protected List< Column > columns;
	protected List< DataObject > data;
	
	public Table( Composite parent, Map args )
	{
		super( parent );
		this.columns = new ArrayList();
		
		if( args != null )
		{
			setClass( (String)args.get( "class" ) );
			setData( (List)args.get( "data" ) );
		}
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
			out.print( "<table>" );
		out.print( "<tr>" );
		for( Column column : this.columns )
		{
			out.print( "<th>" );
			out.print( column.header );
			out.print( "</th>" );
		}
		out.print( "</tr>" );
		for( DataObject data : this.data )
		{
			out.print( "<tr>" );
			for( Column column : this.columns )
			{
				out.print( "<td>" );
				out.print( data.getString( column.data ) );
				out.print( "</td>" );
			}
		}
		out.print( "</table>" );
		//getOut().println( "Hello World! from Table" );
	}

	public void addColumn( Column column )
	{
		this.columns.add( column );
	}
	
	public void setClass( String name )
	{
		this.attributes.put( "class", name );
	}
	
	public void setData( List< DataObject > data )
	{
		this.data = data;
	}
}
