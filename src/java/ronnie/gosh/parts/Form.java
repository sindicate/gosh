package ronnie.gosh.parts;

import groovy.lang.Closure;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
	protected Errors errors;
	protected DataObjectWrapper data;
	protected String path;
	protected Button updateButton;
	protected String title;

	public Form( String name, String title, Composite parent, String path, Closure retrieve, Closure update, Map args, Errors errors )
	{
		super( name, parent );
		
		this.title = title;
		this.retrieve = retrieve;
		this.update = update;
		this.errors = errors;
		this.path = path;
		
		this.values = new ArrayList();
		this.updateButton = new UpdateButton();
	}

	public void addValue( Value value )
	{
		this.values.add( value );

	}
	
	public void retrieve( Object... args )
	{
		this.data = new DataObjectWrapper( (DataObject)this.retrieve.call( args ) );
		
		// Retrieve select data
		for( Value value : this.values )
			if( value.select != null )
				value.selectData = (List)value.select.retrieve.call();
	}
	
	@Override
	public void render( RequestContext context )
	{
		PrintWriter out = context.getOut();

		String path = this.name + "." + this.path + "[1]";
		
		out.print( "<table class=\"form\">\n" );
		if( this.title != null )
		{
			out.print( "	<tr class=\"header\"><td colspan=\"2\">" );
			out.print( this.title );
			out.print( "</td></tr>\n" );
		}
		boolean edit = false;
		for( Value value : this.values )
		{
			if( value.edit )
				edit = true;
			
			out.print( "	<tr class=\"data\"><th>" );
			out.print( value.description );
			out.print( ":</th><td>" );
			if( value.select != null )
			{
				Object value2 = this.data.dataObject.get( this.path + "[1]/" + value.path );
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
					print( context, out, this.data.dataObject.getString( this.path + "[1]/" + value.path ) );
					out.print( "\"/>" );
				}
				else
					print( context, out, this.data.dataObject.getString( this.path + "[1]/" + value.path ) );
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
		this.update.call( new Object[] { this.data } );
	}

	@Override
	public void applyRequest( RequestContext context )
	{
//		super.applyRequest( context );
		
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
				this.data.set( prop, values[ 0 ] );
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
}
