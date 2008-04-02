package ronnie.gosh;

public class DatastorageConstraintException extends RuntimeException
{
	public DatastorageConstraintException()
	{
		// default constructor
	}

	public DatastorageConstraintException( String message )
	{
		super( message );
	}

	public DatastorageConstraintException( Throwable cause )
	{
		super( cause );
	}

	public DatastorageConstraintException( String message, Throwable cause )
	{
		super( message, cause );
	}
}
