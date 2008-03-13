package ronnie.gosh.parts;

import ronnie.gosh.RequestContext;

public class Message extends Component
{
	protected String message;

	public Message( String name, Composite parent )
	{
		super( name, parent );
	}

	@Override
	public void render()
	{
		RequestContext context = getRequestContext();
		context.getOut().print( this.message );
	}

	@Override
	public String getText()
	{
		return this.message;
	}
}
