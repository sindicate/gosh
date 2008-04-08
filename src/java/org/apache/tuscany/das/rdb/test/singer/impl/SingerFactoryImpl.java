/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.das.rdb.test.singer.impl;

import commonj.sdo.helper.HelperContext;
import org.apache.tuscany.sdo.helper.HelperContextImpl;
import org.apache.tuscany.sdo.helper.TypeHelperImpl;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;

import org.apache.tuscany.das.rdb.test.singer.*;

import org.apache.tuscany.sdo.impl.FactoryBase;

import org.apache.tuscany.sdo.model.ModelFactory;

import org.apache.tuscany.sdo.model.impl.ModelFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * Generator information:
 * patternVersion=1.2; -prefix Singer -noUnsettable
 * <!-- end-user-doc -->
 * @generated
 */
public class SingerFactoryImpl extends FactoryBase implements SingerFactory
{

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String NAMESPACE_URI = "http:///org.apache.tuscany.das.rdb.test/SINGER.xsd";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String NAMESPACE_PREFIX = "this";

	/**
	 * The version of the generator pattern used to generate this class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String PATTERN_VERSION = "1.2";
	
	public static final int SINGER = 1;	
	public static final int SONG = 2;
	
	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SingerFactoryImpl()
	{
		super(NAMESPACE_URI, NAMESPACE_PREFIX, "org.apache.tuscany.das.rdb.test.singer");
	}

	/**
	 * Registers the Factory instance so that it is available within the supplied scope.
   * @argument scope a HelperContext instance that will make the types supported by this Factory available.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void register(HelperContext scope) 
	{
		if(scope == null) {
			throw new IllegalArgumentException("Scope can not be null");
		}

		if (((HelperContextImpl)scope).getExtendedMetaData().getPackage(NAMESPACE_URI) != null)
			return;
    
		// Register this package with provided scope   
		((HelperContextImpl)scope).getExtendedMetaData().putPackage(NAMESPACE_URI, this);
		
		//Register dependent packages with provided scope
		ModelFactory.INSTANCE.register(scope);
  }
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataObject create(int typeNumber)
	{
		switch (typeNumber)
		{
			case SINGER: return (DataObject)createSINGER();
			case SONG: return (DataObject)createSONG();
			default:
				return super.create(typeNumber);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SINGER createSINGER()
	{
		SINGERImpl singer = new SINGERImpl();
		return singer;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SONG createSONG()
	{
		SONGImpl song = new SONGImpl();
		return song;
	}
	
	// Following creates and initializes SDO metadata for the supported types.			
	protected Type singerType = null;

	public Type getSINGER()
	{
		return singerType;
	}
		
	protected Type songType = null;

	public Type getSONG()
	{
		return songType;
	}
	

	private static SingerFactoryImpl instance = null; 
	public static SingerFactoryImpl init()
	{
		if (instance != null ) return instance;
		instance = new SingerFactoryImpl();

		// Create package meta-data objects
		instance.createMetaData();

		// Initialize created meta-data
		instance.initializeMetaData();
		
		// Mark meta-data to indicate it can't be changed
		//theSingerFactoryImpl.freeze(); //FB do we need to freeze / should we freeze ????

		return instance;
	}
  
	private boolean isCreated = false;

	public void createMetaData()
	{
		if (isCreated) return;
		isCreated = true;	

		// Create types and their properties
		singerType = createType(false, SINGER);
		createProperty(true, singerType,SINGERImpl.INTERNAL_ID); 
		createProperty(true, singerType,SINGERImpl.INTERNAL_NAME); 
		createProperty(false, singerType,SINGERImpl.INTERNAL_SINGS); 
		songType = createType(false, SONG);
		createProperty(true, songType,SONGImpl.INTERNAL_ID); 
		createProperty(true, songType,SONGImpl.INTERNAL_TITLE); 
		createProperty(true, songType,SONGImpl.INTERNAL_SINGERID); 
	}
	
	private boolean isInitialized = false;

	public void initializeMetaData()
	{
		if (isInitialized) return;
		isInitialized = true;

		// Obtain other dependent packages
		ModelFactoryImpl theModelPackageImpl = (ModelFactoryImpl)ModelFactoryImpl.init();
		Property property = null;

		// Add supertypes to types

		// Initialize types and properties
		initializeType(singerType, SINGER.class, "SINGER", false);
		property = getLocalProperty(singerType, 0);
		initializeProperty(property, theModelPackageImpl.getInt(), "ID", null, 1, 1, SINGER.class, false, false, false);

		property = getLocalProperty(singerType, 1);
		initializeProperty(property, theModelPackageImpl.getString(), "NAME", null, 1, 1, SINGER.class, false, false, false);

		property = getLocalProperty(singerType, 2);
		initializeProperty(property, this.getSONG(), "sings", null, 1, -1, SINGER.class, false, false, false, true , null);

		initializeType(songType, SONG.class, "SONG", false);
		property = getLocalProperty(songType, 0);
		initializeProperty(property, theModelPackageImpl.getInt(), "ID", null, 1, 1, SONG.class, false, false, false);

		property = getLocalProperty(songType, 1);
		initializeProperty(property, theModelPackageImpl.getString(), "TITLE", null, 1, 1, SONG.class, false, false, false);

		property = getLocalProperty(songType, 2);
		initializeProperty(property, theModelPackageImpl.getInt(), "SINGERID", null, 1, 1, SONG.class, false, false, false);

		createXSDMetaData(theModelPackageImpl);
	}
	  
	protected void createXSDMetaData(ModelFactoryImpl theModelPackageImpl)
	{
		super.initXSD();
		
		Property property = null;
		

		addXSDMapping
		  (singerType,
			 new String[] 
			 {
			 "name", "SINGER",
			 "kind", "elementOnly"
			 });

		addXSDMapping
			(getLocalProperty(singerType, 0),
			 new String[]
			 {
			 "kind", "element",
			 "name", "ID"
			 });

		addXSDMapping
			(getLocalProperty(singerType, 1),
			 new String[]
			 {
			 "kind", "element",
			 "name", "NAME"
			 });

		addXSDMapping
			(getLocalProperty(singerType, 2),
			 new String[]
			 {
			 "kind", "element",
			 "name", "sings"
			 });

		addXSDMapping
		  (songType,
			 new String[] 
			 {
			 "name", "SONG",
			 "kind", "elementOnly"
			 });

		addXSDMapping
			(getLocalProperty(songType, 0),
			 new String[]
			 {
			 "kind", "element",
			 "name", "ID"
			 });

		addXSDMapping
			(getLocalProperty(songType, 1),
			 new String[]
			 {
			 "kind", "element",
			 "name", "TITLE"
			 });

		addXSDMapping
			(getLocalProperty(songType, 2),
			 new String[]
			 {
			 "kind", "element",
			 "name", "SINGERID"
			 });

  }
    
} //SingerFactoryImpl
