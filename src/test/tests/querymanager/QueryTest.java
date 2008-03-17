package tests.querymanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
import org.testng.annotations.Test;

import ronnie.gosh.CompiledQuery;
import ronnie.gosh.Query;
import ronnie.gosh.QueryCompiler;



/**
 * @author René M. de Bloois
 * @since 2008-03-17
 */
public class QueryTest
{
	@Test
	public void testSimple()
	{
		CompiledQuery compiledQuery = QueryCompiler.compile( "column = ${column}", "name", 0 );
		Query query = compiledQuery.params( ScriptBytecodeAdapter.createMap( new Object[] { "column", "value" } ) );
		System.out.println( query );
		String result = query.getPreparedSQL( Collections.EMPTY_MAP, new ArrayList() );
		System.out.println( result );
		assert result.equals( "column = ?" );
	}

	@Test
	public void testList()
	{
		CompiledQuery compiledQuery = QueryCompiler.compile( "column in (${column})", "name", 0 );
		
		Query query = compiledQuery.params( ScriptBytecodeAdapter.createMap( new Object[] { "column", ScriptBytecodeAdapter.createList( new Object[] { 1, 2, 3 } ) } ) );
		System.out.println( query );
		String result = query.getPreparedSQL( Collections.EMPTY_MAP, new ArrayList() );
		System.out.println( result );
		assert result.equals( "column in (?,?,?)" );
		
		query = compiledQuery.params( ScriptBytecodeAdapter.createMap( new Object[] { "column", ScriptBytecodeAdapter.createList( new Object[] { "1", "2", "3" } ) } ) );
		System.out.println( query );
		result = query.getPreparedSQL( Collections.EMPTY_MAP, new ArrayList() );
		System.out.println( result );
		assert result.equals( "column in (?,?,?)" );
		
		query = compiledQuery.params( ScriptBytecodeAdapter.createMap( new Object[] { "column", new int[] { 1, 2, 3 } } ) );
		System.out.println( query );
		result = query.getPreparedSQL( Collections.EMPTY_MAP, new ArrayList() );
		System.out.println( result );
		assert result.equals( "column in (?,?,?)" );
		
		query = compiledQuery.params( ScriptBytecodeAdapter.createMap( new Object[] { "column", new String[] { "1", "2", "3" } } ) );
		System.out.println( query );
		result = query.getPreparedSQL( Collections.EMPTY_MAP, new ArrayList() );
		System.out.println( result );
		assert result.equals( "column in (?,?,?)" );
	}

	@Test
	public void testSimpleLiteral()
	{
		CompiledQuery compiledQuery = QueryCompiler.compile( "column = <%=column%>", "name", 0 );
		Query query = compiledQuery.params( ScriptBytecodeAdapter.createMap( new Object[] { "column", 1 } ) );
		System.out.println( query );
		String result = query.getPreparedSQL( Collections.EMPTY_MAP, new ArrayList() );
		System.out.println( result );
		assert result.equals( "column = 1" );
	}

	@Test
	// TODO (RBloois) Make it possible with <%=literalList(ids)%>
	public void testInLiteral()
	{
		CompiledQuery compiledQuery = QueryCompiler.compile( "column in (#{'ids})", "name", 0 );
		Query query = compiledQuery.params( ScriptBytecodeAdapter.createMap( new Object[] { "ids", new int[] { 1, 2, 3 } } ) );
		System.out.println( query );
		String result = query.getPreparedSQL( Collections.EMPTY_MAP, new ArrayList() );
		System.out.println( result );
		assert result.equals( "column in (1,2,3)" );
	}

	@Test
	// TODO (RBloois) Make it possible with <%=oracleLiteralIn(ids)%>
	public void testOracleInLiteral()
	{
		CompiledQuery compiledQuery = QueryCompiler.compile( "#{ORACLE-IN column 'ids}", "name", 0 );

		int[] par = new int[] { 1, 2, 3 };
		Query query = compiledQuery.params( ScriptBytecodeAdapter.createMap( new Object[] { "ids", par } ) );
		System.out.println( query );
		String result = query.getPreparedSQL( Collections.EMPTY_MAP, new ArrayList() );
		System.out.println( result );
		assert result.equals( "(column IN (1,2,3))" );

		par = new int[ 1000 ];
		for( int i = 0; i < 1000; i++ )
			par[ i ] = 1;
		query = compiledQuery.params( ScriptBytecodeAdapter.createMap( new Object[] { "ids", par } ) );
		System.out.println( query );
		result = query.getPreparedSQL( Collections.EMPTY_MAP, new ArrayList() );
		System.out.println( result );
		
		par = new int[ 1001 ];
		for( int i = 0; i < 1001; i++ )
			par[ i ] = 1;
		query = compiledQuery.params( ScriptBytecodeAdapter.createMap( new Object[] { "ids", par } ) );
		System.out.println( query );
		result = query.getPreparedSQL( Collections.EMPTY_MAP, new ArrayList() );
		System.out.println( result );
		
		par = new int[ 1002 ];
		for( int i = 0; i < 1002; i++ )
			par[ i ] = 1;
		query = compiledQuery.params( ScriptBytecodeAdapter.createMap( new Object[] { "ids", par } ) );
		System.out.println( query );
		result = query.getPreparedSQL( Collections.EMPTY_MAP, new ArrayList() );
		System.out.println( result );
		assert result.equals( "(column IN (1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1) OR column IN (1,1))" );
		
		Integer[] par2 = new Integer[ 3 ];
		for( int i = 0; i < 3; i++ )
			par2[ i ] = Integer.valueOf( 1 );
		query = compiledQuery.params( ScriptBytecodeAdapter.createMap( new Object[] { "ids", par } ) );
		System.out.println( query );
		result = query.getPreparedSQL( Collections.EMPTY_MAP, new ArrayList() );
		System.out.println( result );
	}

	@Test
	// TODO (RBloois) Make it possible with <%=oracleIn(ids)%>
	public void testOracleIn()
	{
		CompiledQuery compiledQuery = QueryCompiler.compile( "#{ORACLE-IN column ids}", "name", 0 );

		int[] par = new int[] { 1, 2, 3 };
		Query query = compiledQuery.params( ScriptBytecodeAdapter.createMap( new Object[] { "ids", par } ) );
		System.out.println( query );
		String result = query.getPreparedSQL( Collections.EMPTY_MAP, new ArrayList() );
		System.out.println( result );
		assert result.equals( "(column IN (?,?,?))" );

		String[] spar = new String[] { "A", "B", "C" };
		query = compiledQuery.params( ScriptBytecodeAdapter.createMap( new Object[] { "ids", spar } ) );
		System.out.println( query );
		result = query.getPreparedSQL( Collections.EMPTY_MAP, new ArrayList() );
		System.out.println( result );
		assert result.equals( "(column IN (?,?,?))" );
	}

	@Test
	public void testOracleInLiteralStrings()
	{
		CompiledQuery compiledQuery = QueryCompiler.compile( "#{ORACLE-IN column 'ids}", "name", 0 );

		String[] spar = new String[] { "A", "B", "C" };
		Query query = compiledQuery.params( ScriptBytecodeAdapter.createMap( new Object[] { "ids", spar } ) );
		System.out.println( query );
		String result = query.getPreparedSQL( Collections.EMPTY_MAP, new ArrayList() );
		System.out.println( result );
		assert result.equals( "(column IN ('A','B','C'))" );
	}
	
	@Test(expectedExceptions=UnsupportedOperationException.class)
	public void testInLiteralDatesNotSupported()
	{
		CompiledQuery compiledQuery = QueryCompiler.compile( "column in (#{'ids})", "name", 0 );

		Date[] par = new Date[] { new Date(), new Date(), new Date() };
		Query query = compiledQuery.params( ScriptBytecodeAdapter.createMap( new Object[] { "ids", par } ) );
		System.out.println( query );
		String result = query.getPreparedSQL( Collections.EMPTY_MAP, new ArrayList() );
		System.out.println( result );
		assert false;
	}
	
	@Test
	public void testSimpleLiteralStringNotSupported()
	{
		CompiledQuery compiledQuery = QueryCompiler.compile( "column = #{'column}", "name", 0 );
		Query query = compiledQuery.params( ScriptBytecodeAdapter.createMap( new Object[] { "column", "string" } ) );
		System.out.println( query );
		String result = query.getPreparedSQL( Collections.EMPTY_MAP, new ArrayList() );
		System.out.println( result );
		assert result.equals( "column = 'string'" );
	}
}
