package ronnie.gosh.parts;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.tuscany.sdo.util.DataObjectUtil;
import org.apache.tuscany.sdo.util.DataObjectUtil.Accessor;
import org.eclipse.emf.ecore.EObject;

import ronnie.gosh.RequestContext;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;

public class DataObjectWrapper
{
	static private final Logger log = Logger.getLogger( DataObjectWrapper.class );

	protected DataObject dataObject;
	protected Map< String, String > shadow;
	
	public DataObjectWrapper( DataObject dataObject )
	{
		this.dataObject = dataObject;
	}
	
	public void set( String path, String value, RequestContext context )
	{
		if( value != null && value.length() == 0 )
			value = null;
		
		// TODO Check that only editable things are being set
		Accessor accessor = DataObjectUtil.Accessor.create( (EObject)this.dataObject, path, value );
		try
		{
			Property property = accessor.getProperty();
			Type type = property.getType();
			// TODO Better type checking
			Object v;
			if( type.getName().equals( "IntObject" ) )
				try
				{
					v = toInteger( value );
				}
				catch( NumberFormatException e )
				{
					context.addError( "'" + value + "' could not be converted to a integer" );
					log.debug( "put in shadow: [" + path + "] = [" + value + "]" );
					this.shadow.put( path, value );
					return;
				}
			else if( type.getName().equals( "Date" ) )
				try
				{
					v = toDate( value );
				}
				catch( ParseException e )
				{
					context.addError( "'" + value + "' could not be converted to a timestamp" );
					log.debug( "put in shadow: [" + path + "] = [" + value + "]" );
					this.shadow.put( path, value );
					return;
				}
			else if( type.getName().equals( "Timestamp" ) )
				try
				{
					v = toTimestamp( value );
				}
				catch( ParseException e )
				{
					context.addError( "'" + value + "' could not be converted to a timestamp" );
					log.debug( "put in shadow: [" + path + "] = [" + value + "]" );
					this.shadow.put( path, value );
					return;
				}
			else
				v = value;

			Object old = this.dataObject.get( path );
			if( v == null )
			{
				if( old != null )
				{
					log.debug( "  set [" + path + "] = [" + old + "] <- [" + v + "]" );
					accessor.set( v );
				}
			}
			else if( !v.equals( old ) )
			{
				log.debug( "old: " + ( old != null ? old.getClass() : "null" ) );
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
	
	static protected Date toDate( String value ) throws ParseException
	{
		if( value == null )
			return null;
		DateFormat parser = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ); 
		return parser.parse( value );
	}
	
	static protected Timestamp toTimestamp( String value ) throws ParseException
	{
		if( value == null )
			return null;
		DateFormat parser = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ); 
		return new Timestamp( parser.parse( value ).getTime() );
	}

	public void clearShadow()
	{
		this.shadow = new HashMap();
	}
}
