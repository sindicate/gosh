package ronnie.gosh.parts;

import groovy.lang.Closure;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import ronnie.gosh.DatastorageIntegrityConstraintException;
import ronnie.gosh.GroovySupport;
import ronnie.gosh.RequestContext;

import com.logicacmg.idt.commons.util.Assert;
import commonj.sdo.DataObject;

public class Form extends Composite
{
//	static private final Logger log = Logger.getLogger( Form.class );

	static public class Value
	{
		protected String path;
		protected String description;
		protected boolean edit;
		protected Select select;
		protected List<DataObject> selectData;
		protected boolean mandatory;
	}

	protected List< Value > values;
	protected Closure retrieve;
	protected Closure update;
	protected DataObjectTableWrapper data;
	protected Button updateButton;
	protected String title;
	protected Set< String > errors = new LinkedHashSet< String >();

	public Form( String name, String title, Composite parent, Closure retrieve, Closure update, Map args )
	{
		super( name, parent );
		
		this.title = title;
		this.retrieve = retrieve;
		this.update = update;
		
		this.values = new ArrayList();
		this.updateButton = new UpdateButton();
	}

	public void addValue( Value value )
	{
		this.values.add( value );

	}
	
	public void retrieve()
	{
		this.data = (DataObjectTableWrapper)this.retrieve.call();
		
		// Retrieve select data
		for( Value value : this.values )
			if( value.select != null )
				value.selectData = (List)value.select.retrieve.call();
	}
	
	@Override
	public void render( RequestContext context )
	{
		PrintWriter out = context.getOut();

		String path = this.name + ".[1]";
		
		out.print( "<table class=\"form\">\n" );
		if( this.title != null )
		{
			out.print( "	<tr class=\"header\"><td colspan=\"2\">" );
			out.print( this.title );
			out.print( "</td></tr>\n" );
		}
		boolean edit = false;
		DataObject row = this.data.getRows().get( 0 );
		for( Value value : this.values )
		{
			if( value.edit )
				edit = true;
			
			out.print( "	<tr class=\"data\"><th>" );
			out.print( value.description );
			out.print( ":</th><td>" );
			if( value.select != null )
			{
				Object value2 = row.get( value.path );
				if( value.edit )
				{
					out.print( "<select name=\"" );
					out.print( path );
					out.print( '/' );
					out.print( value.path );
					out.print( "\">" );
					if( value2 == null )
						out.print( "<option value=\"\" selected=\"selected\">(select)</option>" );
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
				else
				{
					List<DataObject> sdata = (List)value.select.retrieve.call();
					if( value2 != null )
						for( DataObject object : sdata )
						{
							Object key = object.get( value.select.key ); 
							if( key.equals( value2 ) )
								out.print( object.get( value.select.display ) );
						}
				}
			}
			else
			{
				if( value.edit )
				{
					out.print( "<input name=\"" );
					out.print( path );
					out.print( '/' );
					out.print( value.path );
					out.print( "\" value=\"" );
					print( context, out, row.getString( value.path ) );
					out.print( "\"/>" );
				}
				else
					print( context, out, row.getString( value.path ) );
			}
			out.print( "</td></tr>\n" );
		}
		if( edit )
		{
			out.print( "	<tr class=\"buttons\"><td colspan=\"2\">" );
			this.updateButton.render( context );
			out.print( "</td></tr>\n" );
		}
		out.print( "</table>\n" );
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
			// TODO I think we should communicate DataObjectTableWrapper instead
			GroovySupport.callClosure( this.update, this.data.dataObject );
		}
		catch( DatastorageIntegrityConstraintException e )
		{
			this.errors.add( "Data integrity constraints prohibit the changes from being saved" );
			this.errors.add( "Save failed" );
		}
	}

	@Override
	public void applyRequest( RequestContext context )
	{
//		super.applyRequest( context );
		
		this.errors.clear();
		this.data.clearErrors();

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
				this.data.setString( prop, values[ 0 ] );
			}
		}
	}

	public class UpdateButton extends Button
	{
//		private final Logger log = Logger.getLogger( RemoveButton.class );
		
		public UpdateButton()
		{
			super( "updateButton", Form.this, "save", null, null );
		}

		@Override
		public void click()
		{
			Form.this.update();
		}
	}
	
	public void validate()
	{
		for( DataObject object : this.data.getRows() )
			for( Value value : this.values )
				if( value.mandatory )
					if( !object.isSet( value.path ) || object.get( value.path ) == null )
						this.errors.add( "Missing value for " + value.description );
	}

	@Override
	public void collectErrors( List< String > errors )
	{
		//log.debug( "Adding [" + this.data.errors.size()  + " + " + this.errors.size() + "] error messages" );
		this.data.collectErrors( errors );
		errors.addAll( this.errors );
	}
}
