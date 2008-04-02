package ronnie.gosh;

public class DatastorageReferentialConstraintException extends DatastorageConstraintException
{
	public DatastorageReferentialConstraintException()
	{
		// default constructor
	}

	public DatastorageReferentialConstraintException( String message )
	{
		super( message );
	}

	public DatastorageReferentialConstraintException( Throwable cause )
	{
		super( cause );
	}

	public DatastorageReferentialConstraintException( String message, Throwable cause )
	{
		super( message, cause );
	}
}
