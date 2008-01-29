package ronnie.gosh;

// TODO This one is not used anymore
public class ActionNotFoundException extends RuntimeException
{
	public ActionNotFoundException( String message )
	{
		super( message );
	}

	public ActionNotFoundException( String message, Throwable cause )
	{
		super( message, cause );
	}
}
