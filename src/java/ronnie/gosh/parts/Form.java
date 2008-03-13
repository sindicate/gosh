package ronnie.gosh.parts;

import groovy.lang.Closure;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.Map;

import ronnie.gosh.RequestContext;

public class Form extends Composite
{
	public Form( String name, Composite parent, Map args )
	{
		super( name, parent );
	}
	
	@Override
	public void render( RequestContext context, Closure closure )
	{
		PrintWriter out = context.getOut();
		String link = context.link( Collections.EMPTY_MAP );
		out.print( "<form method=\"post\" action=\"" );
		out.print( link );
		out.print( "\">\n" );
		closure.call();
		out.print( "</form>\n" );
	}
}
