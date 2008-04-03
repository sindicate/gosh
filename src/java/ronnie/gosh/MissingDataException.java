package ronnie.gosh;

public class MissingDataException extends DatastorageConstraintException
{
	public MissingDataException()
	{
		// default constructor
	}

	public MissingDataException( String message )
	{
		super( message );
	}

	public MissingDataException( Throwable cause )
	{
		super( cause );
	}

	public MissingDataException( String message, Throwable cause )
	{
		super( message, cause );
	}
}
