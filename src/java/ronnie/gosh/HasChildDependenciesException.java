package ronnie.gosh;

public class HasChildDependenciesException extends DatastorageReferentialConstraintException
{
	public HasChildDependenciesException()
	{
		// default constructor
	}

	public HasChildDependenciesException( String message )
	{
		super( message );
	}

	public HasChildDependenciesException( Throwable cause )
	{
		super( cause );
	}

	public HasChildDependenciesException( String message, Throwable cause )
	{
		super( message, cause );
	}
}
