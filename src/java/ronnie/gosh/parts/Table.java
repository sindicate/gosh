package ronnie.gosh.parts;

import groovy.lang.Closure;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import ronnie.gosh.RequestContext;

import commonj.sdo.DataObject;

public class Table extends Composite
{
	static private final Logger log = Logger.getLogger( Table.class );

	static public class Column
	{
		protected String path;
		protected String header;
		protected boolean edit;
		protected boolean key;
	}

	protected List< Column > columns;
	protected DataObject data;
	protected String path;
	protected Closure retrieve;
	protected Closure update;
	protected Button remove;
	protected Message status;
	
	public Table( String name, Composite parent, DataObject data, String path, Closure retrieve, Closure update, Map args, Message status )
	{
		super( name, parent );
		
		this.columns = new ArrayList();
		this.data = data;
		this.path = path;
		this.update = update;
		this.retrieve = retrieve;
		this.remove = new RemoveButton();
		this.status = status;
	}
	
	@Override
	public void render( RequestContext context )
	{
		// TODO Get the complete path instead of only the name
		
		PrintWriter out = context.getOut();
//		if( this.attributes.size() > 0 )
//		{
//			out.print( "<table" );
//			for( Entry< String, String > attribute : this.attributes.entrySet() )
//			{
//				out.print( ' ' );
//				out.print( attribute.getKey() );
//				out.print( "=\"" );
//				out.print( attribute.getValue() );
//				out.print( '"' );
//			}
//			out.print( '>' );
//		}
//		else
		out.print( "<table class=\"table\">\n" );
		out.print( "	<tr class=\"row\">" );
		for( Column column : this.columns )
		{
			out.print( "<th>" );
			print( out, column.header );
			out.print( "</th>" );
		}
		out.print( "<th/>" );
		out.print( "</tr>\n" );
		List<DataObject> data = this.data.getList( this.path );
		String path = this.name + "." + this.path;
		int i = 1;
		for( DataObject row : data )
		{
			String path2 = path + "[" + i + "]/";
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
					print( out, row.getString( column.path ) );
					out.print( "\"/>" );
				}
				else
					print( out, row.getString( column.path ) );
				out.print( "</td>\n" );
			}
			out.print( "		<td>" );
			this.remove.render( context, Integer.toString( i ) );
			out.print( "</td>" );
			out.print( "	</tr>\n" );
			
			i++;
		}
		out.println( "</table>\n" );
		
		if( this.status != null )
			this.status.clear();
	}

	protected void print( PrintWriter out, String s )
	{
		if( s != null )
			out.print( s );
	}

	public void addColumn( Column column )
	{
		this.columns.add( column );
	}
	
	public void update()
	{
		this.update.call( new Object[] { this.data } );
		retrieve();
		if( this.status != null )
			this.status.setMessage( "rows updated" );
	}
	
	public void retrieve()
	{
		this.data = (DataObject)this.retrieve.call();
		if( this.status != null )
			this.status.setMessage( getRowCount() + " rows retrieved" );
	}
	
	@Override
	public void setValue( String path, String value )
	{
		// TODO Check that only editable things are being set
		log.debug( "set [" + this.getClass() + "][" + path + "] <- [" + value + "]" );
		Object old = this.data.get( path );
		if( value == null )
		{
			if( old != null )
				this.data.set( path, value );
		}
		else if( !value.equals( old ) )
			this.data.set( path, value );
	}
	
	public DataObject addRow()
	{
		return this.data.createDataObject( this.path );
	}
	
	public int getRowCount()
	{
		return this.data.getList( this.path ).size();
	}
	
	public class RemoveButton extends Button
	{
		private final Logger log = Logger.getLogger( RemoveButton.class );
		
		public RemoveButton()
		{
			super( "removeButton", Table.this, "remove", null, null );
		}

		public void click( String arg )
		{
			int rownum = Integer.parseInt( arg );
			Table.this.data.getList( Table.this.path ).remove( rownum - 1 );
			this.log.debug( "removed " + rownum );
		}

		@Override
		public void render( RequestContext context )
		{
			super.render( context );
		}
	}
}
