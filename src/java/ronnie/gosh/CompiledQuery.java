package ronnie.gosh;

import java.util.Map;

import groovy.lang.Closure;

// TODO Rename to QueryTemplate
public class CompiledQuery
{
	private Closure _query;
	protected long lastModified;
	
	public CompiledQuery( Closure query, long lastModified )
	{
		this._query = query;
		this.lastModified = lastModified;
	}
	
	public Query params( Map params )
	{
		Query query = new Query( (Closure)this._query.clone() );
		query.params( params );
		return query;
	}
}
