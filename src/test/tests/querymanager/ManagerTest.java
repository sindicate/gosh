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
	}
	
	static public void main( String[] args )
	{
		new ManagerTest().testSimple();
	}
}
