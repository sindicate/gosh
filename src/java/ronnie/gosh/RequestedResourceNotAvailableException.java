package ronnie.gosh;

public class RequestedResourceNotAvailableException extends RuntimeException
{
	public RequestedResourceNotAvailableException()
	{
		// Default constructor
	}

	public RequestedResourceNotAvailableException( String message )
	{
		super( message );
	}

	public RequestedResourceNotAvailableException( Throwable cause )
	{
		super( cause );
	}

	public RequestedResourceNotAvailableException( String message, Throwable cause )
	{
		super( message, cause );
	}
}
