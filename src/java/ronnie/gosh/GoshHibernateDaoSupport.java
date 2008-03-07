package ronnie.gosh;

import groovy.lang.Closure;
import groovy.lang.GString;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.logicacmg.idt.commons.util.Assert;

public class GoshHibernateDaoSupport extends HibernateDaoSupport
{
	static final private Logger log = Logger.getLogger( GoshHibernateDaoSupport.class ); 

	@SuppressWarnings("deprecation")
	public Connection getConnection()
	{
		return getSession().connection();
	}
	
	public List list( Class domainClass )
	{
		Criteria criteria = getSession().createCriteria( domainClass );
		return criteria.list();
	}
	
	public Object findBy( Map<String, Object> args, Class domainClass )
	{
		Criteria criteria = getSession().createCriteria( domainClass );
		for( Map.Entry<String, Object> entry : args.entrySet() )
			criteria.add( Restrictions.eq( entry.getKey(), entry.getValue() ) );
		return criteria.uniqueResult();
	}
	
	public List findAll( Class domainClass )
	{
		log.debug( "findAll(domainClass)" );
		Criteria criteria = getSession().createCriteria( domainClass );
		return criteria.list();
	}
	
	public List findAll( String hql, List args )
	{
		org.hibernate.Query query = getSession().createQuery( hql );
		int i = 0;
		for( Object arg : args )
			query.setParameter( i++, arg );
		return query.list();
	}
	
	public List findAll( GString hql )
	{
		Object[] values = hql.getValues();
		Object[] args = values.clone(); // shallow clone
		
		for( int i = values.length - 1; i >= 0; i-- )
			values[ i ] = "?";
		
		org.hibernate.Query query = getSession().createQuery( hql.toString() );
		for( int i = 0; i < args.length; i++ )
		{
			Assert.isTrue( !( args[ i ] instanceof Closure ) );
			query.setParameter( i, args[ i ] );
		}
		return query.list();
	}
	
	public Object load( Class domainClass, Serializable id ) 
	{ 
		Object result = getSession().load( domainClass, id );
		org.hibernate.Hibernate.initialize( result );
		return result;
	}

	public void save( Object object )
	{
		getSession().save( object );
	}
	
	public void update( Object object )
	{
		getSession().update( object );
	}
	
	public Object find( String hql, List args )
	{
		org.hibernate.Query query = getSession().createQuery( hql );
		int i = 0;
		for( Object arg : args )
			query.setParameter( i++, arg );
		return query.uniqueResult();
	}
}
