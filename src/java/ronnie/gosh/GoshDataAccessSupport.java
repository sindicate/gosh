package ronnie.gosh;

import groovy.lang.Closure;
import groovy.lang.GString;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.tuscany.das.rdb.DAS;
import org.apache.tuscany.das.rdb.config.impl.ResultDescriptorImpl;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.logicacmg.idt.commons.SystemException;
import com.logicacmg.idt.commons.util.Assert;
import commonj.sdo.DataObject;
import commonj.sdo.ChangeSummary.Setting;

public class GoshDataAccessSupport extends HibernateDaoSupport
{
	static final private Logger log = Logger.getLogger( GoshDataAccessSupport.class ); 

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
	
	static protected void addFieldDescriptor( List descriptor, String table, String column, String type )
	{
		ResultDescriptorImpl fieldDescriptor = new ResultDescriptorImpl();
		fieldDescriptor.setTableName( table );
		fieldDescriptor.setColumnName( column );
		fieldDescriptor.setColumnType( type );
		descriptor.add( fieldDescriptor );
	}
	
	protected void handleDASException( RuntimeException e )
	{
		Throwable t = e.getCause();
		log.debug( "Cause of type " + t.getClass().getName() );
		if( t instanceof SQLException )
		{
			SQLException sqle = (SQLException)t;
			String sqlState = sqle.getSQLState();
			String sqlStateClass = sqlState.substring( 0, 2 );
			if( sqlState.equals( "23502" ) )
				throw new MissingDataException( e );
			if( sqlState.equals( "23503" ) )
				throw new HasChildDependenciesException( e );
			if( sqlStateClass.equals( "23" ) )
				throw new DatastorageIntegrityConstraintException( e );
			throw new SystemException( "SQLException: errorCode=" + sqle.getErrorCode() + ", SQLState=" + sqle.getSQLState(), e );
		}
		throw e;
	}
	
	protected void update( DAS das, DataObject data )
	{
		try
		{
			das.applyChanges( data );
			data.getChangeSummary().endLogging();
			data.getChangeSummary().beginLogging();
		}
		catch( RuntimeException e ) // DAS throws RuntimeException in case of SQLException
		{
			handleDASException( e );
		}
	}
	
	protected Object getOldValue( List< Setting > oldValues, String name )
	{
		for( Setting setting : oldValues )
			if( setting.getProperty().getName().equals( name ) )
				return setting.getValue();
		
		throw new SystemException( "Old value for [" + name + "] not found" );
	}
}
