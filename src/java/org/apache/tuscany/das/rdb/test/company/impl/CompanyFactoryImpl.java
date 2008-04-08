/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.das.rdb.test.company.impl;

import commonj.sdo.helper.HelperContext;
import org.apache.tuscany.sdo.helper.HelperContextImpl;
import org.apache.tuscany.sdo.helper.TypeHelperImpl;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;

import org.apache.tuscany.das.rdb.test.company.*;

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
public class CompanyFactoryImpl extends FactoryBase implements CompanyFactory
{

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String NAMESPACE_URI = "org.apache.tuscany.das.rdb.test/company.xsd";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String NAMESPACE_PREFIX = "company";

	/**
	 * The version of the generator pattern used to generate this class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String PATTERN_VERSION = "1.2";
	
	public static final int COMPANY_TYPE = 1;	
	public static final int DEPARTMENT_TYPE = 2;	
	public static final int EMPLOYEE_TYPE = 3;
	
	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompanyFactoryImpl()
	{
		super(NAMESPACE_URI, NAMESPACE_PREFIX, "org.apache.tuscany.das.rdb.test.company");
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
			case COMPANY_TYPE: return (DataObject)createCompanyType();
			case DEPARTMENT_TYPE: return (DataObject)createDepartmentType();
			case EMPLOYEE_TYPE: return (DataObject)createEmployeeType();
			default:
				return super.create(typeNumber);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompanyType createCompanyType()
	{
		CompanyTypeImpl companyType = new CompanyTypeImpl();
		return companyType;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DepartmentType createDepartmentType()
	{
		DepartmentTypeImpl departmentType = new DepartmentTypeImpl();
		return departmentType;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmployeeType createEmployeeType()
	{
		EmployeeTypeImpl employeeType = new EmployeeTypeImpl();
		return employeeType;
	}
	
	// Following creates and initializes SDO metadata for the supported types.		
	protected Type companyTypeType = null;

	public Type getCompanyType()
	{
		return companyTypeType;
	}
		
	protected Type departmentTypeType = null;

	public Type getDepartmentType()
	{
		return departmentTypeType;
	}
			
	protected Type employeeTypeType = null;

	public Type getEmployeeType()
	{
		return employeeTypeType;
	}
	

	private static CompanyFactoryImpl instance = null; 
	public static CompanyFactoryImpl init()
	{
		if (instance != null ) return instance;
		instance = new CompanyFactoryImpl();

		// Create package meta-data objects
		instance.createMetaData();

		// Initialize created meta-data
		instance.initializeMetaData();
		
		// Mark meta-data to indicate it can't be changed
		//theCompanyFactoryImpl.freeze(); //FB do we need to freeze / should we freeze ????

		return instance;
	}
  
	private boolean isCreated = false;

	public void createMetaData()
	{
		if (isCreated) return;
		isCreated = true;	

		// Create types and their properties
		companyTypeType = createType(false, COMPANY_TYPE);
		createProperty(false, companyTypeType,CompanyTypeImpl.INTERNAL_DEPARTMENTS); 
		createProperty(true, companyTypeType,CompanyTypeImpl.INTERNAL_ID); 
		createProperty(true, companyTypeType,CompanyTypeImpl.INTERNAL_NAME); 
		createProperty(true, companyTypeType,CompanyTypeImpl.INTERNAL_EMPLOYEE_OF_THE_MONTH); 
		departmentTypeType = createType(false, DEPARTMENT_TYPE);
		createProperty(false, departmentTypeType,DepartmentTypeImpl.INTERNAL_EMPLOYEES); 
		createProperty(true, departmentTypeType,DepartmentTypeImpl.INTERNAL_ID); 
		createProperty(true, departmentTypeType,DepartmentTypeImpl.INTERNAL_NAME); 
		createProperty(true, departmentTypeType,DepartmentTypeImpl.INTERNAL_LOCATION); 
		createProperty(true, departmentTypeType,DepartmentTypeImpl.INTERNAL_NUMBER); 
		employeeTypeType = createType(false, EMPLOYEE_TYPE);
		createProperty(true, employeeTypeType,EmployeeTypeImpl.INTERNAL_ID); 
		createProperty(true, employeeTypeType,EmployeeTypeImpl.INTERNAL_NAME); 
		createProperty(true, employeeTypeType,EmployeeTypeImpl.INTERNAL_SN); 
		createProperty(true, employeeTypeType,EmployeeTypeImpl.INTERNAL_MANAGER); 
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
		initializeType(companyTypeType, CompanyType.class, "CompanyType", false);
		property = getLocalProperty(companyTypeType, 0);
		initializeProperty(property, this.getDepartmentType(), "departments", null, 1, -1, CompanyType.class, false, false, false, true , null);

		property = getLocalProperty(companyTypeType, 1);
		initializeProperty(property, theModelPackageImpl.getInt(), "id", null, 0, 1, CompanyType.class, false, false, false);

		property = getLocalProperty(companyTypeType, 2);
		initializeProperty(property, theModelPackageImpl.getString(), "name", null, 0, 1, CompanyType.class, false, false, false);

		property = getLocalProperty(companyTypeType, 3);
		initializeProperty(property, theModelPackageImpl.getString(), "employeeOfTheMonth", null, 0, 1, CompanyType.class, false, false, false);

		initializeType(departmentTypeType, DepartmentType.class, "DepartmentType", false);
		property = getLocalProperty(departmentTypeType, 0);
		initializeProperty(property, this.getEmployeeType(), "employees", null, 1, -1, DepartmentType.class, false, false, false, true , null);

		property = getLocalProperty(departmentTypeType, 1);
		initializeProperty(property, theModelPackageImpl.getInt(), "id", null, 0, 1, DepartmentType.class, false, false, false);

		property = getLocalProperty(departmentTypeType, 2);
		initializeProperty(property, theModelPackageImpl.getString(), "name", null, 0, 1, DepartmentType.class, false, false, false);

		property = getLocalProperty(departmentTypeType, 3);
		initializeProperty(property, theModelPackageImpl.getString(), "location", null, 0, 1, DepartmentType.class, false, false, false);

		property = getLocalProperty(departmentTypeType, 4);
		initializeProperty(property, theModelPackageImpl.getInt(), "number", null, 0, 1, DepartmentType.class, false, false, false);

		initializeType(employeeTypeType, EmployeeType.class, "EmployeeType", false);
		property = getLocalProperty(employeeTypeType, 0);
		initializeProperty(property, theModelPackageImpl.getInt(), "id", null, 0, 1, EmployeeType.class, false, false, false);

		property = getLocalProperty(employeeTypeType, 1);
		initializeProperty(property, theModelPackageImpl.getString(), "name", null, 0, 1, EmployeeType.class, false, false, false);

		property = getLocalProperty(employeeTypeType, 2);
		initializeProperty(property, theModelPackageImpl.getString(), "SN", null, 0, 1, EmployeeType.class, false, false, false);

		property = getLocalProperty(employeeTypeType, 3);
		initializeProperty(property, theModelPackageImpl.getBoolean(), "manager", null, 0, 1, EmployeeType.class, false, false, false);

		createXSDMetaData(theModelPackageImpl);
	}
	  
	protected void createXSDMetaData(ModelFactoryImpl theModelPackageImpl)
	{
		super.initXSD();
		
		Property property = null;
		

		addXSDMapping
		  (companyTypeType,
			 new String[] 
			 {
			 "name", "CompanyType",
			 "kind", "elementOnly"
			 });

		addXSDMapping
			(getLocalProperty(companyTypeType, 0),
			 new String[]
			 {
			 "kind", "element",
			 "name", "departments"
			 });

		addXSDMapping
			(getLocalProperty(companyTypeType, 1),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "id"
			 });

		addXSDMapping
			(getLocalProperty(companyTypeType, 2),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "name"
			 });

		addXSDMapping
			(getLocalProperty(companyTypeType, 3),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "employeeOfTheMonth"
			 });

		addXSDMapping
		  (departmentTypeType,
			 new String[] 
			 {
			 "name", "DepartmentType",
			 "kind", "elementOnly"
			 });

		addXSDMapping
			(getLocalProperty(departmentTypeType, 0),
			 new String[]
			 {
			 "kind", "element",
			 "name", "employees"
			 });

		addXSDMapping
			(getLocalProperty(departmentTypeType, 1),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "id"
			 });

		addXSDMapping
			(getLocalProperty(departmentTypeType, 2),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "name"
			 });

		addXSDMapping
			(getLocalProperty(departmentTypeType, 3),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "location"
			 });

		addXSDMapping
			(getLocalProperty(departmentTypeType, 4),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "number"
			 });

		property = createGlobalProperty
		  ("company",
		  this.getCompanyType(),
			 new String[]
			 {
			 "kind", "element",
			 "name", "company",
			 "namespace", "##targetNamespace"
			 });
                
		addXSDMapping
		  (employeeTypeType,
			 new String[] 
			 {
			 "name", "EmployeeType",
			 "kind", "empty"
			 });

		addXSDMapping
			(getLocalProperty(employeeTypeType, 0),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "id"
			 });

		addXSDMapping
			(getLocalProperty(employeeTypeType, 1),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "name"
			 });

		addXSDMapping
			(getLocalProperty(employeeTypeType, 2),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "SN"
			 });

		addXSDMapping
			(getLocalProperty(employeeTypeType, 3),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "manager"
			 });

  }
    
} //CompanyFactoryImpl
