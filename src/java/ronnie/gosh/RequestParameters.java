package ronnie.gosh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import org.codehaus.groovy.runtime.InvokerHelper;

import com.logicacmg.idt.commons.util.Assert;

public class RequestParameters implements Map< String, Object >
{
	static private Logger log = Logger.getLogger( RequestParameters.class );
	
	protected HttpServletRequest request;
	protected Map< String, String > types;
	
	public RequestParameters( HttpServletRequest request )
	{
		this.request = request;
	}

	public void clear()
	{
		throw new UnsupportedOperationException();
	}

	public boolean containsKey( Object key )
	{
		throw new UnsupportedOperationException();
	}

	public boolean containsValue( Object key )
	{
		throw new UnsupportedOperationException();
	}

	public Set entrySet()
	{
//		throw new UnsupportedOperationException();
		return this.request.getParameterMap().entrySet();
	}

	static Pattern typePattern = Pattern.compile( "(Integer|Long|String|Boolean)?(\\[])?" );
	
	public Object get( Object key )
	{
		// log.debug( InvokerHelper.toString( "get: " + key ) );

		boolean array = false;
		String type = null;
		if( this.types != null )
		{
			type = this.types.get( key );
			if( type != null )
			{
				Matcher matcher = typePattern.matcher( type );
				Assert.isTrue( matcher.matches() );
				array = matcher.group( 2 ) != null;
				type = matcher.group( 1 );
				
				// log.debug( "type=[" + type + "],array=[" + array + "]" );
			}
		}
		
		// TODO Implement collect for the array
		if( array )
		{
			String[] values = this.request.getParameterValues( (String)key );
			List result;
			if( values == null || values[ 0 ].length() == 0 )
				result = null;
			else if( "Integer".equals( type ) )
			{
				result = new ArrayList( values.length );
				for( String value: values )
					result.add( new Integer( value ) );
			}
			else if( "Long".equals( type ) )
			{
				result = new ArrayList( values.length );
				for( String value: values )
					result.add( new Long( value ) );
			}
			else if( "Boolean".equals( type ) )
			{
				result = new ArrayList( values.length );
				for( String value: values )
					result.add( Boolean.valueOf( value ) );
			}
			else
				result = Arrays.asList( values );
			log.debug( key + " -> " + InvokerHelper.toString( result ) );
			return result;
		}
			
		String value = this.request.getParameter( (String)key );
		Object result;
		if( value == null || value.length() == 0 )
			result = null;
		else if( value.startsWith( "(json)" ) )
			result = Util.decodeJSON( value.substring( 6 ) );
		else if( type == "Integer" )
			result = new Integer( value );
		else if( type == "Long" )
			result = new Long( value );
		else if( type == "Boolean" )
			result = Boolean.valueOf( value );
		else
			result = value;
		log.debug( key + " -> " + InvokerHelper.toString( result ) );
		return result;
	}

	void addTypes( Map< String, String > types )
	{
		if( this.types != null )
			this.types.putAll( types );
		else
			this.types = types;
	}

	public boolean isEmpty()
	{
		return this.request.getParameterMap().isEmpty();
	}

	public Set keySet()
	{
		return this.request.getParameterMap().keySet();
	}

	public String put( String key, Object value )
	{
		throw new UnsupportedOperationException();
	}

	public void putAll( Map map )
	{
		throw new UnsupportedOperationException();
	}

	public String remove( Object key )
	{
		throw new UnsupportedOperationException();
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
