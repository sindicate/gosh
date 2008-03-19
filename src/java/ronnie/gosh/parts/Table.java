package ronnie.gosh.parts;

import groovy.lang.Closure;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ronnie.gosh.RequestContext;

import commonj.sdo.DataObject;

public class Table extends Composite
{
//	static private final Logger log = Logger.getLogger( Table.class );

	static public class Column
	{
		protected String path;
		protected String header;
		protected boolean edit;
		protected boolean key;
		protected Select select;
		protected List<DataObject> selectData;
		protected boolean mandatory;
	}

	protected List< Column > columns;
	protected DataObject data;
	protected String path;
	protected Closure retrieve;
	protected Closure update;
	protected Button removeButton;
	protected Button addButton;
	protected Button updateButton;
	protected Button retrieveButton;
	protected Message status;
	protected Errors errors;
	
	public Table( String name, Composite parent, DataObject data, String path, Closure retrieve, Closure update, Map args, Message status, Errors errors )
	{
		super( name, parent );
		
		this.columns = new ArrayList();
		this.data = data;
		this.path = path;
		this.update = update;
		this.retrieve = retrieve;
		this.removeButton = new RemoveButton();
		this.addButton = new AddButton();
		this.updateButton = new UpdateButton();
		this.retrieveButton = new RetrieveButton();
		this.status = status;
		this.errors = errors;
	}
	
	@Override
	public void render( RequestContext context )
	{
		// TODO Get the complete path instead of only the name

		PrintWriter out = context.getOut();
		
		out.print( "<table class=\"table\">\n" );
		out.print( "	<tr class=\"row\">" );
		for( Column column : this.columns )
		{
			out.print( "<th>" );
			print( context, out, column.header );
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
				if( column.edit )
				{
					out.print( "		<td class=\"edit\">" );
					if( column.select != null )
					{
						Object value = row.get( column.path );
						
						out.print( "<select name=\"" );
						out.print( path2 );
						out.print( column.path );
						out.print( "\">" );
						if( value == null )
							out.print( "<option value=\"\" selected=\"selected\">(select)</option>" );
						for( DataObject object : column.selectData )
						{
							out.print( "<option value=\"" );
							Object key = object.get( column.select.key ); 
							out.print( key );
							if( value != null && key.equals( value ) )
								out.print( "\" selected=\"selected\">" );
							else
								out.print( "\">" );
							out.print( object.get( column.select.display ) );
							out.print( "</option>" );
						}
						out.print( "</select>" );
					}
					else
					{
						out.print( "<input name=\"" );
						out.print( path2 );
						out.print( column.path );
						out.print( "\" value=\"" );
						print( context, out, row.get( column.path ) );
						out.print( "\"/>" );
					}
				}
				else
				{
					out.print( "		<td>" );
					print( context, out, row.getString( column.path ) );
				}
				out.print( "</td>\n" );
			}
			out.print( "		<td class=\"edit\">" );
			this.removeButton.render( context, Integer.toString( i ) );
			out.print( "</td>\n" );
			out.print( "	</tr>\n" );
			
			i++;
		}
		out.print( "	<tr class=\"buttons\"><td colspan=\"" );
		out.print( this.columns.size() + 1 );
		out.print( "\">" );
		this.addButton.render( context );
		out.print( " " );
		this.retrieveButton.render( context );
		out.print( " " );
		this.updateButton.render( context );
		out.print( "</td></tr>\n" );
		out.println( "</table>\n" );
		
		if( this.status != null )
			this.status.clear();
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
		
		// Retrieve select data
		for( Column column : this.columns )
			if( column.select != null )
				column.selectData = (List)column.select.retrieve.call();
		
		if( this.status != null )
			this.status.setMessage( getRowCount() + " rows retrieved" );
	}
	
	@Override
	public void setValue( String path, String value )
	{
		setDataObjectValue( this.data, path, value );
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
//		private final Logger log = Logger.getLogger( RemoveButton.class );
		
		public RemoveButton()
		{
			super( "removeButton", Table.this, "remove", null, null );
		}

		public void click( String arg )
		{
			int rownum = Integer.parseInt( arg );
			Table.this.data.getList( Table.this.path ).remove( rownum - 1 );
//			this.log.debug( "removed " + rownum );
		}
	}
	
	public class AddButton extends Button
	{
//		private final Logger log = Logger.getLogger( RemoveButton.class );
		
		public AddButton()
		{
			super( "addButton", Table.this, "add", null, null );
		}

		@Override
		public void click()
		{
			Table.this.addRow();
		}
	}
	
	public class UpdateButton extends Button
	{
//		private final Logger log = Logger.getLogger( RemoveButton.class );
		
		public UpdateButton()
		{
			super( "updateButton", Table.this, "save", null, null );
		}

		@Override
		public void click()
		{
			Table.this.update();
		}
	}
	
	public class RetrieveButton extends Button
	{
//		private final Logger log = Logger.getLogger( RemoveButton.class );
		
		public RetrieveButton()
		{
			super( "retrieveButton", Table.this, "refresh", null, null );
		}

		@Override
		public void click()
		{
			Table.this.retrieve();
		}
	}
}
