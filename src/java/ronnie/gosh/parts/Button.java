package ronnie.gosh.parts;

import groovy.lang.Closure;

import java.io.PrintWriter;
import java.util.Map;

public class Button extends Component
{
	protected String type;
	protected Closure clicked;
	
	public Button( String name, Composite parent, String type, Closure clicked, Map args )
	{
		super( name, parent );
		this.type = type;
		this.clicked = clicked;
	}
	
	@Override
	public void render()
	{
		PrintWriter out = getOut();
		out.print( "<input type=\"submit\" name=\"action(" + this.name + ".click())\" value=\"Update\"/>" );
	}
	
	public void click()
	{
		this.clicked.call();
	}
}
