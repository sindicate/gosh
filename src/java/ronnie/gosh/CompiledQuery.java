package ronnie.gosh;

import groovy.lang.Closure;

import java.util.Map;

// TODO Rename to QueryTemplate
public class CompiledQuery
{
	private final Closure query;
	protected long lastModified;
	
	public CompiledQuery( Closure query, long lastModified )
	{
		this.query = query;
		this.lastModified = lastModified;
	}

	public Query params( Map params )
	{
		Query query = new Query( (Closure)this.query.clone() );
		query.params( params );
		return query;
	}
	
	public Closure getQuery()
	{
		return this.query;
	}
	
	public long getLastModified()
	{
		return this.lastModified;
	}
}
