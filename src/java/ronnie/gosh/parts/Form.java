package ronnie.gosh.parts;

import groovy.lang.Closure;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import ronnie.gosh.RequestContext;

import commonj.sdo.DataObject;

public class Form extends Composite
{
	static private final Logger log = Logger.getLogger( Form.class );

	static public class Value
	{
		protected String path;
		protected String description;
		protected boolean edit;
		protected Select select;
		protected boolean mandatory;
	}

	protected List< Value > values;
	protected Closure retrieve;
	protected Closure update;
	protected Errors errors;
	protected DataObject data;
	protected String path;
	protected Button updateButton;

	public Form( String name, Composite parent, String path, Closure retrieve, Closure update, Map args, Errors errors )
	{
		super( name, parent );
		
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
	
	public void retrieve()
	{
		this.data = (DataObject)this.retrieve.call();
	}
	
	@Override
	public void render( RequestContext context )
	{
		PrintWriter out = context.getOut();

		String path = this.name + "." + this.path + "[1]";
		
		out.print( "<table class=\"form\">\n" );
		out.print( "	<tr class=\"header\"><td colspan=\"2\">Create Issue</td></tr>\n" );
		for( Value value : this.values )
		{
			out.print( "	<tr class=\"data\"><th>" );
			out.print( value.description );
			out.print( ":</th><td><input name=\"" );
			out.print( path );
			out.print( '/' );
			out.print( value.path );
			out.print( "\" value=\"" );
			print( out, this.data.getString( this.path + "[1]/" + value.path ) );
			out.print( "\"/></td></tr>\n" );
		}
		out.print( "	<tr class=\"buttons\"><td colspan=\"2\">" );
		this.updateButton.render( context );
		out.print( "</td></tr>\n" );
		out.print( "</table>\n" );
	}

	public void update()
	{
		this.update.call( new Object[] { this.data } );
	}

	@Override
	public void setValue( String path, String value )
	{
		setDataObjectValue( this.data, path, value );
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
