package ronnie.gosh;

public class ControllerNotFoundException extends RequestedResourceNotAvailableException
{
	public ControllerNotFoundException( String message )
	{
		super( message );
	}
}
