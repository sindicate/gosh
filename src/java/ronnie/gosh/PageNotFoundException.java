package ronnie.gosh;

public class PageNotFoundException extends RuntimeException
{
	public PageNotFoundException( String message, Throwable cause )
	{
		super( message, cause );
	}

	public PageNotFoundException( String message )
	{
		super( message );
	}
}
