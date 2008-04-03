package ronnie.gosh;

public class DatastorageIntegrityConstraintException extends DatastorageConstraintException
{
	public DatastorageIntegrityConstraintException()
	{
		// default constructor
	}

	public DatastorageIntegrityConstraintException( String message )
	{
		super( message );
	}

	public DatastorageIntegrityConstraintException( Throwable cause )
	{
		super( cause );
	}

	public DatastorageIntegrityConstraintException( String message, Throwable cause )
	{
		super( message, cause );
	}
}
