package ronnie.gosh.parts;

import java.io.PrintWriter;
import java.util.Map;

public class Submit extends Component
{
	public Submit( Composite parent, Map args )
	{
		super( parent );
	}
	
	@Override
	public void render()
	{
		PrintWriter out = getOut();
		out.print( "<input type=\"submit\"/>" );
	}
}
