/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.das.rdb.test.company.impl;

import commonj.sdo.Type;

import java.util.Collection;
import java.util.List;

import org.apache.tuscany.das.rdb.test.company.CompanyFactory;
import org.apache.tuscany.das.rdb.test.company.CompanyType;
import org.apache.tuscany.das.rdb.test.company.DepartmentType;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.das.rdb.test.company.impl.CompanyTypeImpl#getDepartments <em>Departments</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.test.company.impl.CompanyTypeImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.test.company.impl.CompanyTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.test.company.impl.CompanyTypeImpl#getEmployeeOfTheMonth <em>Employee Of The Month</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompanyTypeImpl extends DataObjectBase implements CompanyType
{

	public final static int DEPARTMENTS = 0;

	public final static int ID = 1;

	public final static int NAME = 2;

	public final static int EMPLOYEE_OF_THE_MONTH = 3;

	public final static int SDO_PROPERTY_COUNT = 4;

	public final static int EXTENDED_PROPERTY_COUNT = 0;


	/**
	 * The internal feature id for the '<em><b>Departments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_DEPARTMENTS = 0;

	/**
	 * The internal feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_ID = 1;

	/**
	 * The internal feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_NAME = 2;

	/**
	 * The internal feature id for the '<em><b>Employee Of The Month</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_EMPLOYEE_OF_THE_MONTH = 3;

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
			case INTERNAL_DEPARTMENTS: return DEPARTMENTS;
			case INTERNAL_ID: return ID;
			case INTERNAL_NAME: return NAME;
			case INTERNAL_EMPLOYEE_OF_THE_MONTH: return EMPLOYEE_OF_THE_MONTH;
		}
		return super.internalConvertIndex(internalIndex);
	}


	/**
	 * The cached value of the '{@link #getDepartments() <em>Departments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepartments()
	 * @generated
	 * @ordered
	 */
	
	protected List departments = null;
	
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_DEFAULT_ = 0;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected int id = ID_DEFAULT_;

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
	public CompanyTypeImpl()
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
		return ((CompanyFactoryImpl)CompanyFactory.INSTANCE).getCompanyType();
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
	public List getDepartments()
	{
		if (departments == null)
		{
		  departments = createPropertyList(ListKind.CONTAINMENT, DepartmentType.class, DEPARTMENTS, 0);
		}
		return departments;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getId()
	{
		return id;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(int newId)
	{
		int oldId = id;
		id = newId;
		if (isNotifying())
			notify(ChangeKind.SET, INTERNAL_ID, oldId, id);
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
			case DEPARTMENTS:
				return removeFromList(getDepartments(), otherEnd, changeContext);
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
			case DEPARTMENTS:
				return getDepartments();
			case ID:
				return new Integer(getId());
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
			case DEPARTMENTS:
				getDepartments().clear();
				getDepartments().addAll((Collection)newValue);
				return;
			case ID:
				setId(((Integer)newValue).intValue());
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
			case DEPARTMENTS:
				getDepartments().clear();
				return;
			case ID:
				setId(ID_DEFAULT_);
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
			case DEPARTMENTS:
				return departments != null && !departments.isEmpty();
			case ID:
				return id != ID_DEFAULT_;
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
		result.append(" (id: ");
		result.append(id);
		result.append(", name: ");
		result.append(name);
		result.append(", employeeOfTheMonth: ");
		result.append(employeeOfTheMonth);
		result.append(')');
		return result.toString();
	}

} //CompanyTypeImpl
