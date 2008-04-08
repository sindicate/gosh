/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.das.rdb.test.companynoid.impl;

import commonj.sdo.helper.HelperContext;
import org.apache.tuscany.sdo.helper.HelperContextImpl;
import org.apache.tuscany.sdo.helper.TypeHelperImpl;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;

import org.apache.tuscany.das.rdb.test.companynoid.*;

import org.apache.tuscany.sdo.impl.FactoryBase;

import org.apache.tuscany.sdo.model.ModelFactory;

import org.apache.tuscany.sdo.model.impl.ModelFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * Generator information:
 * patternVersion=1.2; -noUnsettable
 * <!-- end-user-doc -->
 * @generated
 */
public class CompanynoidFactoryImpl extends FactoryBase implements CompanynoidFactory
{

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String NAMESPACE_URI = "org.apache.tuscany.das.rdb.test/companynoid.xsd";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String NAMESPACE_PREFIX = "companynoid";

	/**
	 * The version of the generator pattern used to generate this class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String PATTERN_VERSION = "1.2";
	
	public static final int COMPANYNOID_TYPE = 1;	
	public static final int DEPARTMENTNOID_TYPE = 2;	
	public static final int EMPLOYEENOID_TYPE = 3;
	
	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompanynoidFactoryImpl()
	{
		super(NAMESPACE_URI, NAMESPACE_PREFIX, "org.apache.tuscany.das.rdb.test.companynoid");
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
			case COMPANYNOID_TYPE: return (DataObject)createCompanynoidType();
			case DEPARTMENTNOID_TYPE: return (DataObject)createDepartmentnoidType();
			case EMPLOYEENOID_TYPE: return (DataObject)createEmployeenoidType();
			default:
				return super.create(typeNumber);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompanynoidType createCompanynoidType()
	{
		CompanynoidTypeImpl companynoidType = new CompanynoidTypeImpl();
		return companynoidType;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DepartmentnoidType createDepartmentnoidType()
	{
		DepartmentnoidTypeImpl departmentnoidType = new DepartmentnoidTypeImpl();
		return departmentnoidType;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmployeenoidType createEmployeenoidType()
	{
		EmployeenoidTypeImpl employeenoidType = new EmployeenoidTypeImpl();
		return employeenoidType;
	}
	
	// Following creates and initializes SDO metadata for the supported types.		
	protected Type companynoidTypeType = null;

	public Type getCompanynoidType()
	{
		return companynoidTypeType;
	}
		
	protected Type departmentnoidTypeType = null;

	public Type getDepartmentnoidType()
	{
		return departmentnoidTypeType;
	}
			
	protected Type employeenoidTypeType = null;

	public Type getEmployeenoidType()
	{
		return employeenoidTypeType;
	}
	

	private static CompanynoidFactoryImpl instance = null; 
	public static CompanynoidFactoryImpl init()
	{
		if (instance != null ) return instance;
		instance = new CompanynoidFactoryImpl();

		// Create package meta-data objects
		instance.createMetaData();

		// Initialize created meta-data
		instance.initializeMetaData();
		
		// Mark meta-data to indicate it can't be changed
		//theCompanynoidFactoryImpl.freeze(); //FB do we need to freeze / should we freeze ????

		return instance;
	}
  
	private boolean isCreated = false;

	public void createMetaData()
	{
		if (isCreated) return;
		isCreated = true;	

		// Create types and their properties
		companynoidTypeType = createType(false, COMPANYNOID_TYPE);
		createProperty(false, companynoidTypeType,CompanynoidTypeImpl.INTERNAL_DEPARTMENTSNOID); 
		createProperty(true, companynoidTypeType,CompanynoidTypeImpl.INTERNAL_NAME); 
		createProperty(true, companynoidTypeType,CompanynoidTypeImpl.INTERNAL_EMPLOYEE_OF_THE_MONTH); 
		departmentnoidTypeType = createType(false, DEPARTMENTNOID_TYPE);
		createProperty(false, departmentnoidTypeType,DepartmentnoidTypeImpl.INTERNAL_EMPLOYEES); 
		createProperty(true, departmentnoidTypeType,DepartmentnoidTypeImpl.INTERNAL_NAME); 
		createProperty(true, departmentnoidTypeType,DepartmentnoidTypeImpl.INTERNAL_LOCATION); 
		createProperty(true, departmentnoidTypeType,DepartmentnoidTypeImpl.INTERNAL_NUMBER); 
		employeenoidTypeType = createType(false, EMPLOYEENOID_TYPE);
		createProperty(true, employeenoidTypeType,EmployeenoidTypeImpl.INTERNAL_ID); 
		createProperty(true, employeenoidTypeType,EmployeenoidTypeImpl.INTERNAL_NAME); 
		createProperty(true, employeenoidTypeType,EmployeenoidTypeImpl.INTERNAL_SN); 
		createProperty(true, employeenoidTypeType,EmployeenoidTypeImpl.INTERNAL_MANAGER); 
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
		initializeType(companynoidTypeType, CompanynoidType.class, "CompanynoidType", false);
		property = getLocalProperty(companynoidTypeType, 0);
		initializeProperty(property, this.getDepartmentnoidType(), "departmentsnoid", null, 1, -1, CompanynoidType.class, false, false, false, true , null);

		property = getLocalProperty(companynoidTypeType, 1);
		initializeProperty(property, theModelPackageImpl.getString(), "name", null, 0, 1, CompanynoidType.class, false, false, false);

		property = getLocalProperty(companynoidTypeType, 2);
		initializeProperty(property, theModelPackageImpl.getString(), "employeeOfTheMonth", null, 0, 1, CompanynoidType.class, false, false, false);

		initializeType(departmentnoidTypeType, DepartmentnoidType.class, "DepartmentnoidType", false);
		property = getLocalProperty(departmentnoidTypeType, 0);
		initializeProperty(property, this.getEmployeenoidType(), "employees", null, 1, -1, DepartmentnoidType.class, false, false, false, true , null);

		property = getLocalProperty(departmentnoidTypeType, 1);
		initializeProperty(property, theModelPackageImpl.getString(), "name", null, 0, 1, DepartmentnoidType.class, false, false, false);

		property = getLocalProperty(departmentnoidTypeType, 2);
		initializeProperty(property, theModelPackageImpl.getString(), "location", null, 0, 1, DepartmentnoidType.class, false, false, false);

		property = getLocalProperty(departmentnoidTypeType, 3);
		initializeProperty(property, theModelPackageImpl.getInt(), "number", null, 0, 1, DepartmentnoidType.class, false, false, false);

		initializeType(employeenoidTypeType, EmployeenoidType.class, "EmployeenoidType", false);
		property = getLocalProperty(employeenoidTypeType, 0);
		initializeProperty(property, theModelPackageImpl.getInt(), "id", null, 0, 1, EmployeenoidType.class, false, false, false);

		property = getLocalProperty(employeenoidTypeType, 1);
		initializeProperty(property, theModelPackageImpl.getString(), "name", null, 0, 1, EmployeenoidType.class, false, false, false);

		property = getLocalProperty(employeenoidTypeType, 2);
		initializeProperty(property, theModelPackageImpl.getString(), "SN", null, 0, 1, EmployeenoidType.class, false, false, false);

		property = getLocalProperty(employeenoidTypeType, 3);
		initializeProperty(property, theModelPackageImpl.getBoolean(), "manager", null, 0, 1, EmployeenoidType.class, false, false, false);

		createXSDMetaData(theModelPackageImpl);
	}
	  
	protected void createXSDMetaData(ModelFactoryImpl theModelPackageImpl)
	{
		super.initXSD();
		
		Property property = null;
		

		addXSDMapping
		  (companynoidTypeType,
			 new String[] 
			 {
			 "name", "CompanynoidType",
			 "kind", "elementOnly"
			 });

		addXSDMapping
			(getLocalProperty(companynoidTypeType, 0),
			 new String[]
			 {
			 "kind", "element",
			 "name", "departmentsnoid"
			 });

		addXSDMapping
			(getLocalProperty(companynoidTypeType, 1),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "name"
			 });

		addXSDMapping
			(getLocalProperty(companynoidTypeType, 2),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "employeeOfTheMonth"
			 });

		addXSDMapping
		  (departmentnoidTypeType,
			 new String[] 
			 {
			 "name", "DepartmentnoidType",
			 "kind", "elementOnly"
			 });

		addXSDMapping
			(getLocalProperty(departmentnoidTypeType, 0),
			 new String[]
			 {
			 "kind", "element",
			 "name", "employees"
			 });

		addXSDMapping
			(getLocalProperty(departmentnoidTypeType, 1),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "name"
			 });

		addXSDMapping
			(getLocalProperty(departmentnoidTypeType, 2),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "location"
			 });

		addXSDMapping
			(getLocalProperty(departmentnoidTypeType, 3),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "number"
			 });

		property = createGlobalProperty
		  ("companynoid",
		  this.getCompanynoidType(),
			 new String[]
			 {
			 "kind", "element",
			 "name", "companynoid",
			 "namespace", "##targetNamespace"
			 });
                
		addXSDMapping
		  (employeenoidTypeType,
			 new String[] 
			 {
			 "name", "EmployeenoidType",
			 "kind", "empty"
			 });

		addXSDMapping
			(getLocalProperty(employeenoidTypeType, 0),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "id"
			 });

		addXSDMapping
			(getLocalProperty(employeenoidTypeType, 1),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "name"
			 });

		addXSDMapping
			(getLocalProperty(employeenoidTypeType, 2),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "SN"
			 });

		addXSDMapping
			(getLocalProperty(employeenoidTypeType, 3),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "manager"
			 });

  }
    
} //CompanynoidFactoryImpl
