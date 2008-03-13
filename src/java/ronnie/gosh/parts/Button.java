package ronnie.gosh.parts;

import groovy.lang.Closure;

import java.util.Map;

import ronnie.gosh.RequestContext;

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
		RequestContext context = getRequestContext();
		String display = context.message( "button." + this.type ); 
		context.getOut().print( "<input type=\"submit\" name=\"action(" + getPath() + ".click())\" value=\"" + display + "\"/>" );
	}
	
	// TODO Add context as parameter
	public void render( String arg )
	{
		if( arg == null )
			arg = "";
		RequestContext context = getRequestContext();
		String display = context.message( "button." + this.type ); 
		context.getOut().print( "<input type=\"submit\" name=\"action(" + getPath() + ".click(" + arg + "))\" value=\"" + display + "\"/>" );
	}
	
	public void click()
	{
		this.clicked.call();
	}
}
