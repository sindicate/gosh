package ronnie.gosh

import org.hibernate.criterion.Restrictions

import org.springframework.orm.hibernate3.support.HibernateDaoSupport

public class GoshHibernateDaoSupport extends HibernateDaoSupport
{
	def getConnection() { session.connection() }
	
	List list( Class domainClass )
	{
		def criteria = session.createCriteria( domainClass )
		return criteria.list()
	}
	
	Object findBy( Map args, Class domainClass )
	{
		def criteria = session.createCriteria( domainClass )
		for( arg in args )
			criteria.add( Restrictions.eq( arg.key, arg.value ) )
		return criteria.uniqueResult()
	}
	
	List findAll( Class domainClass )
	{
		def criteria = session.createCriteria( domainClass )
		return criteria.list()
	}
	
	Object load( Class domainClass, Serializable id ) 
	{ 
		def result = session.load( domainClass, id )
		org.hibernate.Hibernate.initialize( result )
		return result
	}

	void save( object )
	{
		session.save( object )
	}
	
	void update( object )
	{
		session.update( object )
	}
	
	Object find( String hql, List args )
	{
		def query = session.createQuery( hql )
		int i = 0
		for( arg in args )
			query.setParameter( i++, arg )
		return query.uniqueResult()
	}
	
	List findAll( String hql, List args )
	{
		def query = session.createQuery( hql )
		int i = 0
		for( arg in args )
			query.setParameter( i++, arg )
		return query.list()
	}
	
	List findAll( GString hql )
	{
		Object[] values = hql.values
		Object[] args = values.clone() // shallow clone
		
		for( int i = values.length - 1; i >= 0; i-- )
			values[ i ] = "?";
		
		def query = session.createQuery( hql.toString() )
		for( int i = 0; i < args.length; i++ )
		{
			assert !( args[ i ] instanceof Closure )
			query.setParameter( i, args[ i ] )
		}
		return query.list()
	}
}
