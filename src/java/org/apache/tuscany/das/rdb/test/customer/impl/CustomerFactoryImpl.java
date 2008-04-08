/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.das.rdb.test.customer.impl;

import commonj.sdo.helper.HelperContext;
import org.apache.tuscany.sdo.helper.HelperContextImpl;
import org.apache.tuscany.sdo.helper.TypeHelperImpl;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;

import org.apache.tuscany.das.rdb.test.customer.*;

import org.apache.tuscany.sdo.impl.FactoryBase;

import org.apache.tuscany.sdo.model.ModelFactory;

import org.apache.tuscany.sdo.model.impl.ModelFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * Generator information:
 * patternVersion=1.2; -prefix Customer -noUnsettable
 * <!-- end-user-doc -->
 * @generated
 */
public class CustomerFactoryImpl extends FactoryBase implements CustomerFactory
{

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String NAMESPACE_URI = "http:///org.apache.tuscany.das.rdb.test/customer.xsd";

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
	
	public static final int AN_ORDER = 1;	
	public static final int CUSTOMER = 2;
	
	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomerFactoryImpl()
	{
		super(NAMESPACE_URI, NAMESPACE_PREFIX, "org.apache.tuscany.das.rdb.test.customer");
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
			case AN_ORDER: return (DataObject)createAnOrder();
			case CUSTOMER: return (DataObject)createCustomer();
			default:
				return super.create(typeNumber);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnOrder createAnOrder()
	{
		AnOrderImpl anOrder = new AnOrderImpl();
		return anOrder;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Customer createCustomer()
	{
		CustomerImpl customer = new CustomerImpl();
		return customer;
	}
	
	// Following creates and initializes SDO metadata for the supported types.		
	protected Type anOrderType = null;

	public Type getAnOrder()
	{
		return anOrderType;
	}
		
	protected Type customerType = null;

	public Type getCustomer()
	{
		return customerType;
	}
		

	private static CustomerFactoryImpl instance = null; 
	public static CustomerFactoryImpl init()
	{
		if (instance != null ) return instance;
		instance = new CustomerFactoryImpl();

		// Create package meta-data objects
		instance.createMetaData();

		// Initialize created meta-data
		instance.initializeMetaData();
		
		// Mark meta-data to indicate it can't be changed
		//theCustomerFactoryImpl.freeze(); //FB do we need to freeze / should we freeze ????

		return instance;
	}
  
	private boolean isCreated = false;

	public void createMetaData()
	{
		if (isCreated) return;
		isCreated = true;	

		// Create types and their properties
		anOrderType = createType(false, AN_ORDER);
		createProperty(true, anOrderType,AnOrderImpl.INTERNAL_ID); 
		createProperty(true, anOrderType,AnOrderImpl.INTERNAL_PRODUCT); 
		createProperty(true, anOrderType,AnOrderImpl.INTERNAL_QUANTITY); 
		createProperty(true, anOrderType,AnOrderImpl.INTERNAL_CUSTOMER_ID); 
		customerType = createType(false, CUSTOMER);
		createProperty(true, customerType,CustomerImpl.INTERNAL_ID); 
		createProperty(true, customerType,CustomerImpl.INTERNAL_LAST_NAME); 
		createProperty(true, customerType,CustomerImpl.INTERNAL_ADDRESS); 
		createProperty(false, customerType,CustomerImpl.INTERNAL_ORDERS); 
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
		initializeType(anOrderType, AnOrder.class, "AnOrder", false);
		property = getLocalProperty(anOrderType, 0);
		initializeProperty(property, theModelPackageImpl.getInt(), "ID", null, 1, 1, AnOrder.class, false, false, false);

		property = getLocalProperty(anOrderType, 1);
		initializeProperty(property, theModelPackageImpl.getString(), "Product", null, 1, 1, AnOrder.class, false, false, false);

		property = getLocalProperty(anOrderType, 2);
		initializeProperty(property, theModelPackageImpl.getInt(), "Quantity", null, 1, 1, AnOrder.class, false, false, false);

		property = getLocalProperty(anOrderType, 3);
		initializeProperty(property, theModelPackageImpl.getInt(), "Customer_ID", null, 1, 1, AnOrder.class, false, false, false);

		initializeType(customerType, Customer.class, "Customer", false);
		property = getLocalProperty(customerType, 0);
		initializeProperty(property, theModelPackageImpl.getInt(), "ID", null, 1, 1, Customer.class, false, false, false);

		property = getLocalProperty(customerType, 1);
		initializeProperty(property, theModelPackageImpl.getString(), "lastName", null, 1, 1, Customer.class, false, false, false);

		property = getLocalProperty(customerType, 2);
		initializeProperty(property, theModelPackageImpl.getString(), "address", null, 1, 1, Customer.class, false, false, false);

		property = getLocalProperty(customerType, 3);
		initializeProperty(property, this.getAnOrder(), "orders", null, 1, -1, Customer.class, false, false, false, true , null);

		createXSDMetaData(theModelPackageImpl);
	}
	  
	protected void createXSDMetaData(ModelFactoryImpl theModelPackageImpl)
	{
		super.initXSD();
		
		Property property = null;
		

		addXSDMapping
		  (anOrderType,
			 new String[] 
			 {
			 "name", "AnOrder",
			 "kind", "elementOnly"
			 });

		addXSDMapping
			(getLocalProperty(anOrderType, 0),
			 new String[]
			 {
			 "kind", "element",
			 "name", "ID"
			 });

		addXSDMapping
			(getLocalProperty(anOrderType, 1),
			 new String[]
			 {
			 "kind", "element",
			 "name", "Product"
			 });

		addXSDMapping
			(getLocalProperty(anOrderType, 2),
			 new String[]
			 {
			 "kind", "element",
			 "name", "Quantity"
			 });

		addXSDMapping
			(getLocalProperty(anOrderType, 3),
			 new String[]
			 {
			 "kind", "element",
			 "name", "Customer_ID"
			 });

		addXSDMapping
		  (customerType,
			 new String[] 
			 {
			 "name", "Customer",
			 "kind", "elementOnly"
			 });

		addXSDMapping
			(getLocalProperty(customerType, 0),
			 new String[]
			 {
			 "kind", "element",
			 "name", "ID"
			 });

		addXSDMapping
			(getLocalProperty(customerType, 1),
			 new String[]
			 {
			 "kind", "element",
			 "name", "lastName"
			 });

		addXSDMapping
			(getLocalProperty(customerType, 2),
			 new String[]
			 {
			 "kind", "element",
			 "name", "address"
			 });

		addXSDMapping
			(getLocalProperty(customerType, 3),
			 new String[]
			 {
			 "kind", "element",
			 "name", "orders"
			 });

  }
    
} //CustomerFactoryImpl
