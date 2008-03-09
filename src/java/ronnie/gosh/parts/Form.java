package ronnie.gosh.parts;

import groovy.lang.Closure;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.Map;

public class Form extends Composite
{
	public Form( String name, Composite parent, Map args )
	{
		super( name, parent );
	}
	
	@Override
	public void render()
	{
		throw new UnsupportedOperationException();
	}
	
	public void render( Closure closure )
	{
		PrintWriter out = getOut();
		String link = getRequestContext().link( Collections.EMPTY_MAP );
		out.print( "<form method=\"post\" action=\"" );
		out.print( link );
		out.print( "\">\n" );
		closure.call();
		out.print( "</form>\n" );
	}
}
