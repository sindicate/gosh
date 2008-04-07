package ronnie.gosh.parts;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.apache.tuscany.sdo.util.DataObjectUtil;
import org.apache.tuscany.sdo.util.DataObjectUtil.Accessor;
import org.eclipse.emf.ecore.EObject;

import com.logicacmg.idt.commons.util.Assert;
import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;

public class DataObjectTableWrapper
{
	static private final Logger log = Logger.getLogger( DataObjectTableWrapper.class );

	protected DataObject dataObject;
	protected String path;
	protected Map< String, String > shadow;
	protected Map< String, String > errors;
	protected Set< String > timestamps = new HashSet< String >();
	protected Map< String, Object > defaultValues;
	
	public DataObjectTableWrapper( DataObject dataObject, String path )
	{
		this.dataObject = dataObject;
		this.path = path;
	}
	
	public DataObjectTableWrapper( DataObject dataObject, String path, Map defaultValues )
	{
		this( dataObject, path );
		this.defaultValues = defaultValues;
	}
	
	protected void addError( String path, String error )
	{
		this.errors.put( path, error );
	}
	
	public void setString( String path, String value )
	{
		String fullPath = this.path + path;
		
		if( value != null && value.length() == 0 )
			value = null;
		
		// TODO Check that only editable things are being set
		Accessor accessor = DataObjectUtil.Accessor.create( (EObject)this.dataObject, fullPath, value );
		try
		{
			Property property = accessor.getProperty();
			Type type = property.getType();
			Object v;
			if( this.timestamps.contains( property.getName() ) )
			{
				Assert.isTrue( type.getName().equals( "Date" ) );
				try
				{
					v = toTimestamp( value );
				}
				catch( ParseException e )
				{
					addError( path, "'" + value + "' could not be converted to a timestamp" );
					log.debug( "put in shadow: [" + path + "] = [" + value + "]" );
					this.shadow.put( path, value );
					return;
				}
			}
			else
			{
				log.debug( "Converting [" + fullPath + "] to [" + type.getName() + "]" );
				if( type.getName().equals( "Int" ) || type.getName().equals( "IntObject" ) )
					try
					{
						v = toInteger( value );
					}
					catch( NumberFormatException e )
					{
						addError( path, "'" + value + "' could not be converted to an integer" );
						log.debug( "put in shadow: [" + path + "] = [" + value + "]" );
						this.shadow.put( path, value );
						return;
					}
				else if( type.getName().equals( "Boolean" ) )
					v = toBoolean( value );
				else if( type.getName().equals( "Short" ) )
					try
					{
						v = toShort( value );
					}
					catch( NumberFormatException e )
					{
						addError( path, "'" + value + "' could not be converted to an integer" );
						log.debug( "put in shadow: [" + path + "] = [" + value + "]" );
						this.shadow.put( path, value );
						return;
					}
				else
					v = value;
			}

			Object old = this.dataObject.get( fullPath );
			log.debug( "old: " + ( old != null ? old.getClass() : "null" ) );
			if( v == null )
			{
				if( old != null )
					if( !( old instanceof String && ( (String)old ).length() == 0 ) )
					{
						log.debug( "  set [" + path + "] = [" + old + "] <- [" + v + "]" );
						accessor.set( v );
					}
			}
			else if( !v.equals( old ) )
			{
				log.debug( "new: " + v.getClass() );
				log.debug( "  set [" + path + "] = [" + old + "] <- [" + v + "]" );
				accessor.set( v );
			}
		}
		finally
		{
			accessor.recycle();
		}
	}
	
	// TODO Rename back to set
	public void set2( String path, Object value )
	{
		String fullPath = this.path + path;
		
		// TODO Check that only editable things are being set
		Accessor accessor = DataObjectUtil.Accessor.create( (EObject)this.dataObject, fullPath, value );
		try
		{
			Object old = this.dataObject.get( fullPath );
			log.debug( "old: " + ( old != null ? old.getClass() : "null" ) );
			if( value == null )
			{
				if( old != null )
					if( !( old instanceof String && ( (String)old ).length() == 0 ) )
					{
						log.debug( "  set [" + path + "] = [" + old + "] <- [" + value + "]" );
						accessor.set( value );
					}
			}
			else if( !value.equals( old ) )
			{
				log.debug( "new: " + value.getClass() );
				log.debug( "  set [" + path + "] = [" + old + "] <- [" + value + "]" );
				accessor.set( value );
			}
		}
		finally
		{
			accessor.recycle();
		}
	}
	
	static protected Integer toInteger( String value ) throws NumberFormatException
	{
		if( value == null )
			return null;
		return Integer.valueOf( value );
	}
	
	static protected Short toShort( String value ) throws NumberFormatException
	{
		if( value == null )
			return null;
		return Short.valueOf( value );
	}
	
	static protected Boolean toBoolean( String value ) throws NumberFormatException
	{
		if( value == null )
			return null;
		return Boolean.valueOf( value );
	}
	
	static protected Date toDate( String value ) throws ParseException
	{
		if( value == null )
			return null;
		DateFormat parser = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ); 
		return parser.parse( value );
	}
	
	public DataObject getDataObject()
	{
		return this.dataObject;
	}

	static protected Timestamp toTimestamp( String value ) throws ParseException
	{
		if( value == null )
			return null;
		DateFormat parser = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ); 
		return new Timestamp( parser.parse( value ).getTime() );
	}

	public void clearErrors()
	{
		this.errors = new LinkedHashMap< String, String >();
		this.shadow = new HashMap();
	}
	
	// TODO Find better name
	public void addTimestamp( String name )
	{
		this.timestamps.add( name );
	}
	
	public List< DataObject > getRows()
	{
		return this.dataObject.getList( this.path );
	}

	public void removeRow( int rownum )
	{
		getRows().remove( rownum - 1 );
		
		// Remove errors for that row
		String p = "[" + rownum + "]";
		for( Iterator< Entry< String, String > > iter = this.errors.entrySet().iterator(); iter.hasNext(); )
		{
			Entry< String, String > entry = iter.next();
			if( entry.getKey().startsWith( p ) )
				iter.remove();
		}
	}

	public boolean hasErrors()
	{
		if( this.errors == null )
			return false;
		return !this.errors.isEmpty();
	}

	public void collectErrors( List< String > errors )
	{
		if( this.errors != null )
			errors.addAll( this.errors.values() );
	}

	public DataObject addRow()
	{
		DataObject result = this.dataObject.createDataObject( this.path );
		if( this.defaultValues != null )
		{
			int row = this.dataObject.getList( this.path ).size();
			String path = "[" + row + "]/";
			for( Entry< String, Object > entry : this.defaultValues.entrySet() )
			{
				log.debug( "Setting default value [" + path + entry.getKey() + "] = [" + entry.getValue() + "]" );
				set2( path + entry.getKey(), entry.getValue() );
			}
		}
		return result;
	}
}
