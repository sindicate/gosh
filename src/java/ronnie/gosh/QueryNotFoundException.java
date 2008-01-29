package ronnie.gosh;

public class QueryNotFoundException extends RuntimeException
{
	public QueryNotFoundException( String message, Throwable cause )
	{
		super( message, cause );
	}

	public QueryNotFoundException( String message )
	{
		super( message );
	}
}
