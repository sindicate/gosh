package ronnie.gosh;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.logicacmg.idt.commons.util.Assert;

public class FlashCache
{
	static final private Logger log = Logger.getLogger( FlashCache.class );
	
	static final public int MAX_CACHE_SIZE = 10;
	static final public long MILLISECONDS_PER_DAY = 1000 * 60 * 60 * 24;

	protected ArrayList< CacheEntry > cache = new ArrayList< CacheEntry >();

	public String store( Object value )
	{
		String key = Long.toString( System.currentTimeMillis() % MILLISECONDS_PER_DAY );
		store( key, value );
		return key;
	}

	public void store( String key, Object value )
	{
		Assert.notNull( key );
		Assert.notNull( value );

		this.cache.add( 0, new CacheEntry( key, value ) );
		if( this.cache.size() > MAX_CACHE_SIZE )
			this.cache.remove( MAX_CACHE_SIZE );

		log.debug( "Stored [" + key + "]." );
	}

	public Object find( String key )
	{
		for( CacheEntry entry : this.cache )
			if( entry.key.equals( key ) )
			{
				log.debug( "Retrieved [" + key + "]." );
				return entry.value;
			}
		log.debug( "Not found [" + key + "]." );
		return null;
	}

	public Object retrieve( String key )
	{
		Object result = find( key );
		if( result == null )
			throw new FlashEntryNotFoundException();
		return result;
	}
	
	static public class FlashEntryNotFoundException extends RuntimeException
	{
		public FlashEntryNotFoundException()
		{
			super();
		}
	}
}

class CacheEntry
{
	String key;
	Object value;
	CacheEntry( String key, Object value ) { this.key = key; this.value = value; }
}

