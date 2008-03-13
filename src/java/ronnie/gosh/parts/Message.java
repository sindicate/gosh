package ronnie.gosh.parts;

import ronnie.gosh.RequestContext;

// Need message priorities
public class Message extends Component
{
	protected String message;

	public Message( String name, Composite parent )
	{
		super( name, parent );
	}

	@Override
	public void render( RequestContext context )
	{
		if( this.message != null )
			context.getOut().print( this.message );
	}
	
	public void setMessage( String message )
	{
		this.message = message;
	}
	
	public void clear()
	{
		this.message = null;
	}

	@Override
	public String getText()
	{
		return this.message != null ? this.message : "";
	}
}
