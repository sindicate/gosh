package ronnie.gosh

import org.apache.log4j.Logger

/*
MetaClassRegistry registry = GroovySystem.metaClassRegistry
assert registry.metaClassCreationHandler instanceof ExpandoMetaClassCreationHandle // Set earlier				

def metaClass = registry.getMetaClass( Class.class )
assert metaClass instanceof ExpandoMetaClass

metaClass.getMetaClass =
{
	->
	def mc = registry.getMetaClass( delegate )
	if( mc instanceof ExpandoMetaClass ) return mc
	registry.removeMetaClass( delegate )
	return registry.getMetaClass( delegate )
}
*/

assert GroovyObject.metaClass instanceof ExpandoMetaClass

Class.metaClass.getLogger = { -> return GoshSystem.getLogger( delegate ) }

javax.servlet.http.HttpSession.metaClass.setProperty = 
{	
	String name, Object value ->
	def mp
    if( ( mp = delegate.class.metaClass.getMetaProperty( name ) ) ) 
    	return mp.setProperty( delegate, value )
	return delegate.setAttribute( name, value )
}
	
javax.servlet.http.HttpSession.metaClass.getProperty = 
{
	String name ->
	def mp
	if( ( mp = delegate.class.metaClass.getMetaProperty( name ) ) ) 
		return mp.getProperty( delegate )
	return delegate.getAttribute( name )
}

String.metaClass.zeroLengthToNull = { delegate.length() == 0 ? null : delegate }

javax.sql.DataSource.metaClass.withConnection =
{
	Closure closure ->
	def connection = delegate.getConnection()
	try
	{	closure( connection )
	}
	finally
	{	connection.close()
	}
}

StringBuilder.metaClass.leftShift =
{
	def value ->
	delegate.append( value )
	return delegate
}
