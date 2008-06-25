package tests.querymanager;

import org.testng.annotations.Test;

import ronnie.gosh.CompiledQuery;
import ronnie.gosh.QueryManager;



/**
 * @author René M. de Bloois
 * @since 2008-05-27
 */
public class ManagerTest
{
	@Test
	public void testSimple()
	{
		QueryManager manager = new QueryManager();
		manager.setPackage( "tests.querymanager" );
		CompiledQuery query = manager.getQuery( "testQuery" );
		assert query != null;
		assert "ronnie.gosh.tmp.gsql.tests.querymanager.testQuery$_getClosure_closure1".equals( query.getQuery().getClass().getName() );
		assert query.getLastModified() > 0;
	}
	
	@Test
	public void testInJar()
	{
		QueryManager manager = new QueryManager();
		manager.setPackage( "tests.querymanager" );
		CompiledQuery query = manager.getQuery( "testQuery-in-jar" );
		assert query != null;
		assert "ronnie.gosh.tmp.gsql.tests.querymanager.testQuery_in_jar$_getClosure_closure1".equals( query.getQuery().getClass().getName() );
		assert query.getLastModified() == 0;
	}
	
	static public void main( String[] args )
	{
		new ManagerTest().testSimple();
	}
}
