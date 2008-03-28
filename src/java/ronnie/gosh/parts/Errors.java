package ronnie.gosh.parts;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ronnie.gosh.RequestContext;

public class Errors extends Component
{
	static private Logger log = Logger.getLogger( Errors.class );

	protected Component[] components;

	public Errors( String name, Composite parent, Object... components )
	{
		super( name, parent );
		
		int len = components.length;
		log.debug( "Adding [" + len + "] components to error object" );
		this.components = new Component[ len ];
		for( int i = 0; i < len; i++ )
			this.components[ i ] = (Component)components[ i ];
	}

	@Override
	public void render( RequestContext context )
	{
		List< String > errors = new ArrayList();
		for( Component component : this.components )
			component.collectErrors( errors );
		if( errors.size() == 0 )
			return;
		
		PrintWriter out = context.getOut();
		out.print( "<ul>" );
		for( String message : errors )
		{
			out.print( "<li>" );
			out.print( message );
			out.print( "</li>" );
		}
		out.print( "</ul>" );
	}
}
