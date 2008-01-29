package ronnie.gosh

class GroovyQueryManager extends QueryManager
{
	def methodMissing( String name, Object args )
	{
		if( args != null && args.length == 2 )
			if( args[ 0 ] instanceof Map && args[ 1 ] instanceof java.sql.Connection )
			{
				Query query = getQuery( "/" + name ).params( args[ 0 ] )
				query.setConnection( args[ 1 ] )
				return query
			}

		throw new MissingMethodException( name, QueryManager, args )
	}
}
