package ronnie.gosh.parts;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.Map;

public class Form extends Composite
{
	public Form( Composite parent, Map args )
	{
		super( parent );
	}
	
	@Override
	public void render()
	{
		PrintWriter out = getOut();
		String link = getRequestContext().link( Collections.EMPTY_MAP );
		out.print( "<form method=\"post\" action=\"" );
		out.print( link );
		out.print( "\">\n" );
		renderChilds();
		out.print( "</form>\n" );
	}
}
