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
import org.apache.tuscany.das.rdb.test.companynoid.CompanynoidType;
import org.apache.tuscany.das.rdb.test.companynoid.DepartmentnoidType;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.das.rdb.test.companynoid.impl.CompanynoidTypeImpl#getDepartmentsnoid <em>Departmentsnoid</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.test.companynoid.impl.CompanynoidTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.test.companynoid.impl.CompanynoidTypeImpl#getEmployeeOfTheMonth <em>Employee Of The Month</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompanynoidTypeImpl extends DataObjectBase implements CompanynoidType
{

	public final static int DEPARTMENTSNOID = 0;

	public final static int NAME = 1;

	public final static int EMPLOYEE_OF_THE_MONTH = 2;

	public final static int SDO_PROPERTY_COUNT = 3;

	public final static int EXTENDED_PROPERTY_COUNT = 0;


	/**
	 * The internal feature id for the '<em><b>Departmentsnoid</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_DEPARTMENTSNOID = 0;

	/**
	 * The internal feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_NAME = 1;

	/**
	 * The internal feature id for the '<em><b>Employee Of The Month</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_EMPLOYEE_OF_THE_MONTH = 2;

	/**
	 * The number of properties for this type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public final static int INTERNAL_PROPERTY_COUNT = 3;

	protected int internalConvertIndex(int internalIndex)
	{
		switch (internalIndex)
		{
			case INTERNAL_DEPARTMENTSNOID: return DEPARTMENTSNOID;
			case INTERNAL_NAME: return NAME;
			case INTERNAL_EMPLOYEE_OF_THE_MONTH: return EMPLOYEE_OF_THE_MONTH;
		}
		return super.internalConvertIndex(internalIndex);
	}


	/**
	 * The cached value of the '{@link #getDepartmentsnoid() <em>Departmentsnoid</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepartmentsnoid()
	 * @generated
	 * @ordered
	 */
	
	protected List departmentsnoid = null;
	
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
	 * The default value of the '{@link #getEmployeeOfTheMonth() <em>Employee Of The Month</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmployeeOfTheMonth()
	 * @generated
	 * @ordered
	 */
	protected static final String EMPLOYEE_OF_THE_MONTH_DEFAULT_ = null;

	/**
	 * The cached value of the '{@link #getEmployeeOfTheMonth() <em>Employee Of The Month</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmployeeOfTheMonth()
	 * @generated
	 * @ordered
	 */
	protected String employeeOfTheMonth = EMPLOYEE_OF_THE_MONTH_DEFAULT_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompanynoidTypeImpl()
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
		return ((CompanynoidFactoryImpl)CompanynoidFactory.INSTANCE).getCompanynoidType();
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
	public List getDepartmentsnoid()
	{
		if (departmentsnoid == null)
		{
		  departmentsnoid = createPropertyList(ListKind.CONTAINMENT, DepartmentnoidType.class, DEPARTMENTSNOID, 0);
		}
		return departmentsnoid;
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
	public String getEmployeeOfTheMonth()
	{
		return employeeOfTheMonth;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmployeeOfTheMonth(String newEmployeeOfTheMonth)
	{
		String oldEmployeeOfTheMonth = employeeOfTheMonth;
		employeeOfTheMonth = newEmployeeOfTheMonth;
		if (isNotifying())
			notify(ChangeKind.SET, INTERNAL_EMPLOYEE_OF_THE_MONTH, oldEmployeeOfTheMonth, employeeOfTheMonth);
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
			case DEPARTMENTSNOID:
				return removeFromList(getDepartmentsnoid(), otherEnd, changeContext);
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
			case DEPARTMENTSNOID:
				return getDepartmentsnoid();
			case NAME:
				return getName();
			case EMPLOYEE_OF_THE_MONTH:
				return getEmployeeOfTheMonth();
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
			case DEPARTMENTSNOID:
				getDepartmentsnoid().clear();
				getDepartmentsnoid().addAll((Collection)newValue);
				return;
			case NAME:
				setName((String)newValue);
				return;
			case EMPLOYEE_OF_THE_MONTH:
				setEmployeeOfTheMonth((String)newValue);
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
			case DEPARTMENTSNOID:
				getDepartmentsnoid().clear();
				return;
			case NAME:
				setName(NAME_DEFAULT_);
				return;
			case EMPLOYEE_OF_THE_MONTH:
				setEmployeeOfTheMonth(EMPLOYEE_OF_THE_MONTH_DEFAULT_);
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
			case DEPARTMENTSNOID:
				return departmentsnoid != null && !departmentsnoid.isEmpty();
			case NAME:
				return NAME_DEFAULT_ == null ? name != null : !NAME_DEFAULT_.equals(name);
			case EMPLOYEE_OF_THE_MONTH:
				return EMPLOYEE_OF_THE_MONTH_DEFAULT_ == null ? employeeOfTheMonth != null : !EMPLOYEE_OF_THE_MONTH_DEFAULT_.equals(employeeOfTheMonth);
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
		result.append(", employeeOfTheMonth: ");
		result.append(employeeOfTheMonth);
		result.append(')');
		return result.toString();
	}

} //CompanynoidTypeImpl
