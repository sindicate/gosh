package ronnie.gosh.parts;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;

import ronnie.gosh.RequestContext;

public class Errors extends Component
{
	static private Logger log = Logger.getLogger( Errors.class );

	protected List<String> errors;

	public Errors( String name, Composite parent )
	{
		super( name, parent );
	}

	@Override
	public void render( RequestContext context )
	{
		if( this.errors == null || this.errors.size() == 0 )
			return;
		
		PrintWriter out = context.getOut();
		out.print( "<ul>" );
		for( String message : this.errors )
		{
			out.print( "<li>" );
			out.print( message );
			out.print( "</li>" );
		}
		out.print( "</ul>" );
	}
	
	public void addError( String error )
	{
		if( this.errors == null )
			this.errors = new ArrayList< String >();
		this.errors.add( error );
		log.debug( "Added errors [" + error + "]" );
	}
	
	public void addErrors( Collection< String > errors )
	{
		if( this.errors == null )
			this.errors = new ArrayList< String >();
		this.errors.addAll( errors );
		log.debug( "Added error" );
	}
	
	public void clear()
	{
		this.errors = null;
		log.debug( "Cleared errors" );
	}

	public boolean hasErrors()
	{
		return this.errors.size() > 0;
	}
}
