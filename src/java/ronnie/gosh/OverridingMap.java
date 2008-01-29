package ronnie.gosh;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class OverridingMap implements Map
{
	protected Map parent;
	protected Map map;
	
	public OverridingMap( Map parent )
	{
		this.parent = parent;
		this.map = new HashMap();
	}

	public OverridingMap( Map parent, Map map )
	{
		this.parent = parent;
		this.map = map != null ? map : new HashMap();
	}

	public void clear()
	{
		this.map.clear();
	}

	public boolean containsKey( Object key )
	{
		return this.map.containsKey( key ) || this.parent.containsKey( key );
	}

	public boolean containsValue( Object value )
	{
		return this.map.containsValue( value ) || this.parent.containsValue( value );
	}

	public Set entrySet()
	{
		throw new UnsupportedOperationException();
	}

	public Object get( Object key )
	{
		if( this.map.containsKey( key ) )
			return this.map.get( key );
		return this.parent.get( key );
	}

	public boolean isEmpty()
	{
		return this.map.isEmpty() && this.parent.isEmpty();
	}

	public Set keySet()
	{
		throw new UnsupportedOperationException();
	}

	public Object put( Object key, Object value )
	{
		return this.map.put( key, value );
	}

	public void putAll( Map map )
	{
		this.map.putAll( map );
	}

	public Object remove( Object key )
	{
		return this.map.remove( key );
	}

	public int size()
	{
		throw new UnsupportedOperationException();
	}

	public Collection values()
	{
		throw new UnsupportedOperationException();
	}
}
