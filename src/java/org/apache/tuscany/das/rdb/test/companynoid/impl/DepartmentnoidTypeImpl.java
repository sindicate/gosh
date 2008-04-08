/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.das.rdb.test.companynoid.impl;

import commonj.sdo.Type;

import java.util.Collection;
import java.util.List;

import org.apache.tuscany.das.rdb.test.companynoid.CompanynoidFactory;
import org.apache.tuscany.das.rdb.test.companynoid.DepartmentnoidType;
import org.apache.tuscany.das.rdb.test.companynoid.EmployeenoidType;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Departmentnoid Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.das.rdb.test.companynoid.impl.DepartmentnoidTypeImpl#getEmployees <em>Employees</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.test.companynoid.impl.DepartmentnoidTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.test.companynoid.impl.DepartmentnoidTypeImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.test.companynoid.impl.DepartmentnoidTypeImpl#getNumber <em>Number</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DepartmentnoidTypeImpl extends DataObjectBase implements DepartmentnoidType
{

	public final static int EMPLOYEES = 0;

	public final static int NAME = 1;

	public final static int LOCATION = 2;

	public final static int NUMBER = 3;

	public final static int SDO_PROPERTY_COUNT = 4;

	public final static int EXTENDED_PROPERTY_COUNT = 0;


	/**
	 * The internal feature id for the '<em><b>Employees</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_EMPLOYEES = 0;

	/**
	 * The internal feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_NAME = 1;

	/**
	 * The internal feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_LOCATION = 2;

	/**
	 * The internal feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_NUMBER = 3;

	/**
	 * The number of properties for this type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public final static int INTERNAL_PROPERTY_COUNT = 4;

	protected int internalConvertIndex(int internalIndex)
	{
		switch (internalIndex)
		{
			case INTERNAL_EMPLOYEES: return EMPLOYEES;
			case INTERNAL_NAME: return NAME;
			case INTERNAL_LOCATION: return LOCATION;
			case INTERNAL_NUMBER: return NUMBER;
		}
		return super.internalConvertIndex(internalIndex);
	}


	/**
	 * The cached value of the '{@link #getEmployees() <em>Employees</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmployees()
	 * @generated
	 * @ordered
	 */
	
	protected List employees = null;
	
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_DEFAULT_ = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_DEFAULT_;

	/**
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCATION_DEFAULT_ = null;

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected String location = LOCATION_DEFAULT_;

	/**
	 * The default value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_DEFAULT_ = 0;

	/**
	 * The cached value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected int number = NUMBER_DEFAULT_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DepartmentnoidTypeImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getStaticType()
	{
		return ((CompanynoidFactoryImpl)CompanynoidFactory.INSTANCE).getDepartmentnoidType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStaticPropertyCount()
	{
		return INTERNAL_PROPERTY_COUNT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getEmployees()
	{
		if (employees == null)
		{
		  employees = createPropertyList(ListKind.CONTAINMENT, EmployeenoidType.class, EMPLOYEES, 0);
		}
		return employees;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (isNotifying())
			notify(ChangeKind.SET, INTERNAL_NAME, oldName, name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocation()
	{
		return location;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(String newLocation)
	{
		String oldLocation = location;
		location = newLocation;
		if (isNotifying())
			notify(ChangeKind.SET, INTERNAL_LOCATION, oldLocation, location);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumber()
	{
		return number;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumber(int newNumber)
	{
		int oldNumber = number;
		number = newNumber;
		if (isNotifying())
			notify(ChangeKind.SET, INTERNAL_NUMBER, oldNumber, number);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeContext inverseRemove(Object otherEnd, int propertyIndex, ChangeContext changeContext)
	{
		switch (propertyIndex)
		{
			case EMPLOYEES:
				return removeFromList(getEmployees(), otherEnd, changeContext);
		}
		return super.inverseRemove(otherEnd, propertyIndex, changeContext);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object get(int propertyIndex, boolean resolve)
	{
		switch (propertyIndex)
		{
			case EMPLOYEES:
				return getEmployees();
			case NAME:
				return getName();
			case LOCATION:
				return getLocation();
			case NUMBER:
				return new Integer(getNumber());
		}
		return super.get(propertyIndex, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void set(int propertyIndex, Object newValue)
	{
		switch (propertyIndex)
		{
			case EMPLOYEES:
				getEmployees().clear();
				getEmployees().addAll((Collection)newValue);
				return;
			case NAME:
				setName((String)newValue);
				return;
			case LOCATION:
				setLocation((String)newValue);
				return;
			case NUMBER:
				setNumber(((Integer)newValue).intValue());
				return;
		}
		super.set(propertyIndex, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unset(int propertyIndex)
	{
		switch (propertyIndex)
		{
			case EMPLOYEES:
				getEmployees().clear();
				return;
			case NAME:
				setName(NAME_DEFAULT_);
				return;
			case LOCATION:
				setLocation(LOCATION_DEFAULT_);
				return;
			case NUMBER:
				setNumber(NUMBER_DEFAULT_);
				return;
		}
		super.unset(propertyIndex);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSet(int propertyIndex)
	{
		switch (propertyIndex)
		{
			case EMPLOYEES:
				return employees != null && !employees.isEmpty();
			case NAME:
				return NAME_DEFAULT_ == null ? name != null : !NAME_DEFAULT_.equals(name);
			case LOCATION:
				return LOCATION_DEFAULT_ == null ? location != null : !LOCATION_DEFAULT_.equals(location);
			case NUMBER:
				return number != NUMBER_DEFAULT_;
		}
		return super.isSet(propertyIndex);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString()
	{
		if (isProxy(this)) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", location: ");
		result.append(location);
		result.append(", number: ");
		result.append(number);
		result.append(')');
		return result.toString();
	}

} //DepartmentnoidTypeImpl