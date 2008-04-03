package ronnie.gosh.parts;

import groovy.lang.Closure;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import ronnie.gosh.DatastorageIntegrityConstraintException;
import ronnie.gosh.GroovySupport;
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
		protected boolean checkbox; // TODO Change to type, inherit from SDO\
		protected Integer size;
		
		public void addLink( Link link )
		{
			this.things.add( link );
		}
	}

	protected List< Column > columns;
	protected DataObjectTableWrapper data;
	protected Closure retrieve;
	protected Closure update;
	protected Button removeButton;
	protected Button addButton;
	protected Button updateButton;
	protected Button retrieveButton;
	protected Message status;
	protected Map< String, String > unappliedRequestParameters;
	protected String title;
	protected Closure rowAdded;
	protected boolean timestamp;
	protected Set< String > errors = new LinkedHashSet< String >();
	
	public Table( String name, Composite parent, Closure retrieve, Closure update, Map args, Message status )
	{
		super( name, parent );
		
		this.columns = new ArrayList();
		this.update = update;
		this.retrieve = retrieve;
		this.removeButton = new RemoveButton();
		this.addButton = new AddButton();
		this.updateButton = new UpdateButton();
		this.retrieveButton = new RetrieveButton();
		this.status = status;
	}
	
	@Override
	public void render( RequestContext context )
	{
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
		List<DataObject> data = this.data.getRows();
		int i = 1;
		String path = getPath() + ".";
		Map< String, String > shadow = this.data.shadow;
		for( DataObject row : data )
		{
			String rowPath = "[" + i + "]/";
			out.print( "	<tr class=\"row\">\n" );
			for( Column column : this.columns )
			{
				if( column.path != null )
				{
					String fieldPath = rowPath + column.path;
					Object value = null;
					if( shadow != null && shadow.containsKey( fieldPath ) )
						value = shadow.get( fieldPath );
					else if( row.isSet( column.path ) )
						value = row.get( column.path );
					log.debug( "value for " + column.path + ": " + ( value == null ? "(null)" : value.getClass() ) );
					
					if( column.edit )
					{
						out.print( "		<td class=\"edit\">" );
						if( column.select != null )
						{
							out.print( "<select name=\"" );
							out.print( path );
							out.print( fieldPath );
							out.print( "\">" );
							if( value == null || !column.mandatory )
							{
								out.print( "<option value=\"\" selected=\"selected\">" );
								if( column.mandatory )
									out.print( "(select)" );
								else
									out.print( "&nbsp;" );
								out.print( "</option>" );
							}
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
							if( column.size != null )
							{
								out.print( "\" size=\"" );
								out.print( column.size );
							}
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
							if( link.text != null )
								out.print( context.encode( link.text ) );
							else
								out.print( link.html );
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
		validate();
		
		if( this.data.hasErrors() || !this.errors.isEmpty() )
		{
			this.errors.add( "Save failed" );
			return;
		}
		
		// TODO Only if there are no errors
		try
		{
			GroovySupport.callClosure( this.update, this.data.dataObject );
			retrieve();
			if( this.status != null )
				this.status.setMessage( "rows updated" );
		}
		catch( DatastorageIntegrityConstraintException e )
		{
			this.errors.add( "Data integrity constraints prohibit the changes from being saved" );
			this.errors.add( "Save failed" );
		}
	}
	
	public void retrieve()
	{
		this.errors.clear();
		
		this.data = (DataObjectTableWrapper)this.retrieve.call();
		Assert.notNull( this.data );
		
		// Retrieve select data
		for( Column column : this.columns )
			if( column.select != null )
			{
				column.selectData = (List)column.select.retrieve.call();
				Assert.notNull( column.selectData, "Data is null for column " + column.header );
			}
		
		if( this.status != null )
			this.status.setMessage( getRowCount() + " rows retrieved" );
	}
	
	public Set< String > collectCheckedCheckBoxes()
	{
		Set< String > result = new HashSet< String >();
		
		List< DataObject > data = this.data.getRows();
		int i = 1;
		for( DataObject row : data )
		{
			String rowPath = "[" + i + "]/";
			for( Column column : this.columns )
				if( column.path != null )
					if( column.edit && column.checkbox )
					{
						Object value = row.get( column.path );
						if( value != null && ( (Boolean)value ).booleanValue() )
						{
							result.add( rowPath + column.path );
							log.debug( "Collected checkbox [" + rowPath + column.path + "]" );
						}
					}
			i++;
		}
		
		return result;
	}

	@Override
	public void applyRequest( RequestContext context )
	{
//		super.applyRequest( context );

		this.errors.clear();
		this.data.clearErrors();
		
		Set< String > checked = collectCheckedCheckBoxes();
		
		String prefix = getPath() + ".";
		
		Map< String, String[] > pars = context.getRequest().getParameterMap();
		for( Entry< String, String[] > entry : pars.entrySet() )
		{
			String name = entry.getKey();
			if( name.startsWith( prefix ) )
			{
				// TODO Use another marker for this?
				String prop = name.substring( prefix.length() );
				String[] values = entry.getValue();
				Assert.isTrue( values.length == 1 );
				Assert.isTrue( prop.startsWith( "[" ) );
				int pos = prop.indexOf( ']' );
				Assert.isTrue( pos > 1 );
				String prop2 = prop.substring( pos + 1 );
				Assert.isTrue( prop2.startsWith( "/" ) );
				prop2 = prop2.substring( 1 );
				Column column = null;
//				log.debug( "Finding column [" + prop2 + "]" );
				for( Column c : this.columns )
				{
//					log.debug( "    Column [" + c.path + "]" );
					if( prop2.equals( c.path ) )
					{
						column = c;
						break;
					}
				}
				Assert.notNull( column );
				this.data.setString( prop, values[ 0 ] );
				checked.remove( prop ); // Remove from checked list
			}
		}
		
		// What remains are the previously checked checkboxes that are now not checked anymore
		for( String path : checked )
		{
			log.debug( "Unchecking checkbox [" + path + "]" );
			this.data.setString( path, "false" );
		}
	}
	
	public void validate()
	{
		for( DataObject object : this.data.getRows() )
			for( Column column : this.columns )
				if( column.mandatory )
					if( !object.isSet( column.path ) || object.get( column.path ) == null )
						this.errors.add( "Missing value for " + column.header );
	}

	public DataObject addRow()
	{
		DataObject row = this.data.addRow();
		if( this.rowAdded != null )
			this.rowAdded.call( row );
		return row;
	}
	
	public void removeRow( int rownum )
	{
//		Table.this.data.dataObject.getList( Table.this.dataPath ).remove( rownum - 1 );
		this.data.removeRow( rownum );
//		this.log.debug( "removed " + rownum );
	}
	
	public int getRowCount()
	{
		return this.data.getRows().size();
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
			removeRow( rownum );
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

	@Override
	public void collectErrors( List< String > errors )
	{
		//log.debug( "Adding [" + this.data.errors.size()  + " + " + this.errors.size() + "] error messages" );
		this.data.collectErrors( errors );
		errors.addAll( this.errors );
	}
}
