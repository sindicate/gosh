package ronnie.gosh.parts;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.tuscany.sdo.util.DataObjectUtil;
import org.apache.tuscany.sdo.util.DataObjectUtil.Accessor;
import org.eclipse.emf.ecore.EObject;

import com.logicacmg.idt.commons.util.Assert;
import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;

public class DataObjectWrapper
{
	static private final Logger log = Logger.getLogger( DataObjectWrapper.class );

	protected DataObject dataObject;
	protected Map< String, String > shadow;
	protected Set< String > errors;
	protected Set< String > timestamps = new HashSet< String >();
	
	public DataObjectWrapper( DataObject dataObject )
	{
		this.dataObject = dataObject;
	}
	
	public void set( String path, String value )
	{
		if( value != null && value.length() == 0 )
			value = null;
		
		// TODO Check that only editable things are being set
		Accessor accessor = DataObjectUtil.Accessor.create( (EObject)this.dataObject, path, value );
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
					this.errors.add( "'" + value + "' could not be converted to a timestamp" );
					log.debug( "put in shadow: [" + path + "] = [" + value + "]" );
					this.shadow.put( path, value );
					return;
				}
			}
			else
			{
				log.debug( "Converting [" + path + "] to [" + type.getName() + "]" );
				if( type.getName().equals( "Int" ) || type.getName().equals( "IntObject" ) )
					try
					{
						v = toInteger( value );
					}
					catch( NumberFormatException e )
					{
						this.errors.add( "'" + value + "' could not be converted to an integer" );
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
						this.errors.add( "'" + value + "' could not be converted to an integer" );
						log.debug( "put in shadow: [" + path + "] = [" + value + "]" );
						this.shadow.put( path, value );
						return;
					}
				else
					v = value;
			}

			Object old = this.dataObject.get( path );
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
		this.errors = new LinkedHashSet< String >();
		this.shadow = new HashMap();
	}
	
	public void setTimestamp( String name )
	{
		this.timestamps.add( name );
	}
	
	public List< DataObject > getRows( String path )
	{
		return this.dataObject.getList( path );
	}
}
