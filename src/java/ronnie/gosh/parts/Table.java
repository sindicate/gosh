package ronnie.gosh.parts;

import groovy.lang.Closure;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import ronnie.gosh.RequestContext;

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
		protected boolean key;
		protected Select select;
		protected List<DataObject> selectData;
		protected boolean mandatory;
		protected List things = new ArrayList();
		protected boolean delete;
		protected boolean checkbox; // TODO Change to type, inherit from SDO
		
		public void addLink( Link link )
		{
			this.things.add( link );
		}
	}

	protected List< Column > columns;
	protected DataObjectWrapper data;
	protected String dataPath;
	protected Closure retrieve;
	protected Closure update;
	protected Button removeButton;
	protected Button addButton;
	protected Button updateButton;
	protected Button retrieveButton;
	protected Message status;
	protected Errors errors;
	protected Map< String, String > unappliedRequestParameters;
	protected String title;
	
	public Table( String name, Composite parent, DataObject data, String dataPath, Closure retrieve, Closure update, Map args, Message status, Errors errors )
	{
		super( name, parent );
		
		this.columns = new ArrayList();
		this.data = new DataObjectWrapper( data );
		this.dataPath = dataPath;
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
		if( this.title != null )
		{
			out.print( "	<tr class=\"title\"><td colspan=\"" );
			out.print( this.columns.size() );
			out.print( "\">" );
			out.print( this.title );
			out.print( "</td></tr>\n" );
		}
		out.print( "	<tr class=\"row\">" );
		for( Column column : this.columns )
		{
			out.print( "<th>" );
			print( context, out, column.header );
			out.print( "</th>" );
		}
		out.print( "</tr>\n" );
		List<DataObject> data = this.data.dataObject.getList( this.dataPath );
		int i = 1;
		String path = getPath() + ".";
		Map< String, String > shadow = this.data.shadow;
		for( DataObject row : data )
		{
			String rowPath = this.dataPath + "[" + i + "]/";
			out.print( "	<tr class=\"row\">\n" );
			for( Column column : this.columns )
			{
				if( column.path != null )
				{
					String fieldPath = rowPath + column.path;
					Object value;
					if( shadow != null && shadow.containsKey( fieldPath ) )
						value = shadow.get( fieldPath );
					else
						value = row.get( column.path );
					log.debug( "value: " + ( value == null ? "(null)" : value.getClass() ) );
					
					if( column.edit )
					{
						out.print( "		<td class=\"edit\">" );
						if( column.select != null )
						{
							out.print( "<select name=\"" );
							out.print( path );
							out.print( fieldPath );
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
						else if( column.checkbox )
						{
							out.print( "<input type=\"checkbox\" name=\"" );
							out.print( path );
							out.print( fieldPath );
							out.print( "\" value=\"true\"" ); // TODO If checkbox is unchecked, we don't get a value
							if( value != null && ( (Boolean)value ).booleanValue() )
								out.print( " checked=\"checked\"" );
							out.print( "/>" );
						}
						else
						{
							out.print( "<input name=\"" );
							out.print( path );
							out.print( fieldPath );
							out.print( "\" value=\"" );
							print( context, out, value );
							out.print( "\"/>" );
						}
					}
					else
					{
						out.print( "		<td>" );
						print( context, out, value );
					}
				}
				else if( column.delete )
				{
					out.print( "		<td class=\"edit\">" );
					this.removeButton.render( context, Integer.toString( i ) );
				}
				else
				{
					// TODO Implement interface Renderable
					out.print( "		<td>" );
					for( Object child : column.things )
					{
						if( child instanceof Link )
						{
							Link link = (Link)child;
							Map< String, Object > args = new HashMap( link.args );
							// TODO Link should render itself
							for( Map.Entry entry : args.entrySet() )
								if( entry.getValue() instanceof Closure )
									entry.setValue( ( (Closure)entry.getValue() ).call( row ) );
							out.print( "<a href=\"" );
							out.print( context.link( new HashMap( args ) ) );
							out.print( "\">" );
							out.print( context.encode( link.text ) );
							out.print( "</a>" );
						}
					}
				}
				out.print( "</td>\n" );
			}
			out.print( "	</tr>\n" );
			
			i++;
		}
		out.print( "	<tr class=\"buttons\"><td colspan=\"" );
		out.print( this.columns.size() );
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
		this.update.call( new Object[] { this.data.dataObject } );
		retrieve();
		if( this.status != null )
			this.status.setMessage( "rows updated" );
	}
	
	public void retrieve()
	{
		this.data = new DataObjectWrapper( (DataObject)this.retrieve.call() );
		
		// Retrieve select data
		for( Column column : this.columns )
			if( column.select != null )
				column.selectData = (List)column.select.retrieve.call();
		
		if( this.status != null )
			this.status.setMessage( getRowCount() + " rows retrieved" );
	}
	
	@Override
	public void applyRequest( RequestContext context )
	{
//		super.applyRequest( context );

		this.data.clearShadow();
		
		String path = getPath() + ".";
		
		Map< String, String[] > pars = context.getRequest().getParameterMap();
		for( Entry< String, String[] > entry : pars.entrySet() )
		{
			String name = entry.getKey();
			if( name.startsWith( path ) )
			{
				// TODO Use another marker for this?
				String prop = name.substring( path.length() );
				String[] values = entry.getValue();
				Assert.isTrue( values.length == 1 );
				this.data.set( prop, values[ 0 ], context );
			}
		}
	}

	public DataObject addRow()
	{
		return this.data.dataObject.createDataObject( this.dataPath );
	}
	
	public int getRowCount()
	{
		return this.data.dataObject.getList( this.dataPath ).size();
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
			Table.this.data.dataObject.getList( Table.this.dataPath ).remove( rownum - 1 );
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
