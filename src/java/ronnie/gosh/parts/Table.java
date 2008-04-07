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
import ronnie.gosh.Util;

import com.logicacmg.idt.commons.util.Assert;
import commonj.sdo.DataObject;

public class Table extends Composite
{
	static private final Logger log = Logger.getLogger( Table.class );

	static public class Column
	{
		protected String header;
		protected List things = new ArrayList();
		protected boolean delete;
		
		public void addLink( Link link )
		{
			this.things.add( link );
		}

		public void addValue( Value value )
		{
			this.things.add( value );
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
				if( column.delete )
				{
					out.print( "		<td class=\"edit\">" );
					this.removeButton.render( context, Integer.toString( i ) );
				}
				else
				{
					boolean containsInputs = false;
					for( Object child : column.things )
						if( child instanceof Value )
							if( ( (Value)child ).edit && !( (Value)child ).checkbox )
							{
								containsInputs = true;
								break;
							}
					
					// TODO Implement interface Renderable
					if( containsInputs )
						out.print( "		<td class=\"edit\">" );
					else
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
							out.print( " <a href=\"" );
							out.print( context.link( new HashMap( args ) ) );
							out.print( "\">" );
							if( link.text != null )
								out.print( context.encode( link.text ) );
							else
								out.print( link.html );
							out.print( "</a>" );
						}
						else if( child instanceof Value )
						{
							Value value = (Value)child;
							String fieldPath = rowPath + value.path;
							Object value2 = null;
							if( shadow != null && shadow.containsKey( fieldPath ) )
								value2 = shadow.get( fieldPath );
							else if( row.isSet( value.path ) )
								value2 = row.get( value.path );
							log.debug( "value for " + value.path + ": " + ( value2 == null ? "(null)" : value2.getClass() ) );
							
							if( value.edit )
							{
//								out.print( "		<td class=\"edit\">" );
								if( value.select != null )
								{
									out.print( " <select name=\"" );
									out.print( path );
									out.print( fieldPath );
									out.print( "\">" );
									if( value2 == null || !value.mandatory )
									{
										out.print( "<option value=\"\" selected=\"selected\">" );
										if( value.mandatory )
											out.print( "(select)" );
										else
											out.print( "&nbsp;" );
										out.print( "</option>" );
									}
									for( DataObject object : value.selectData )
									{
										out.print( "<option value=\"" );
										Object key = object.get( value.select.key ); 
										out.print( key );
										if( value2 != null && key.equals( value2 ) )
											out.print( "\" selected=\"selected\">" );
										else
											out.print( "\">" );
										out.print( object.get( value.select.display ) );
										out.print( "</option>" );
									}
									out.print( "</select>" );
								}
								else if( value.checkbox )
								{
									out.print( " <input type=\"checkbox\" name=\"" );
									out.print( path );
									out.print( fieldPath );
									out.print( "\" value=\"true\"" ); // TODO If checkbox is unchecked, we don't get a value
									if( value2 != null && ( (Boolean)value2 ).booleanValue() )
										out.print( " checked=\"checked\"" );
									out.print( "/>" );
								}
								else
								{
									out.print( " <input name=\"" );
									out.print( path );
									out.print( fieldPath );
									out.print( "\" value=\"" );
									print( context, out, value2 );
									if( value.size != null )
									{
										out.print( "\" size=\"" );
										out.print( value.size );
									}
									out.print( "\"/>" );
								}
							}
							else
							{
//								out.print( "		<td>" );
								print( context, out, value2 );
							}
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
			Util.transformToGroovy( e );
			log.debug( "", e );
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
			for( Object child : column.things )
				if( child instanceof Value )
				{
					Value value = (Value)child;
					if( value.select != null )
					{
						value.selectData = (List)value.select.retrieve.call();
						Assert.notNull( value.selectData, "Data is null for column " + column.header );
					}
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
				for( Object child : column.things )
					if( child instanceof Value )
					{
						Value value = (Value)child;
						if( value.edit && value.checkbox )
						{
							Object value2 = row.get( value.path );
							if( value2 != null && ( (Boolean)value2 ).booleanValue() )
							{
								result.add( rowPath + value.path );
								log.debug( "Collected checkbox [" + rowPath + value.path + "]" );
							}
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
				Value value = null;
//				log.debug( "Finding column [" + prop2 + "]" );
				for( Column c : this.columns )
					for( Object child : c.things )
						if( child instanceof Value )
						{
							if( prop2.equals( ( (Value)child ).path ) )
							{
								value = (Value)child;
								break;
							}
						}
				Assert.notNull( value );
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
				for( Object child : column.things )
					if( child instanceof Value )
					{
						Value value = (Value)child;
						if( value.mandatory )
							if( !object.isSet( value.path ) || object.get( value.path ) == null )
								this.errors.add( "Missing value for " + column.header );
					}
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
