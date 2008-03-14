package ronnie.gosh.parts;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import ronnie.gosh.RequestContext;

public class Errors extends Component
{
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
	
	public void addMessage( String message )
	{
		if( this.errors == null )
			this.errors = new ArrayList< String >();
		this.errors.add( message );
	}
	
	public void clear()
	{
		this.errors = null;
	}

	public boolean hasErrors()
	{
		return this.errors.size() > 0;
	}
}
