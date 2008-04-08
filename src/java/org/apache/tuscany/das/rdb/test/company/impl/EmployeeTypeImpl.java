/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.das.rdb.test.company.impl;

import commonj.sdo.Type;

import org.apache.tuscany.das.rdb.test.company.CompanyFactory;
import org.apache.tuscany.das.rdb.test.company.EmployeeType;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Employee Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.das.rdb.test.company.impl.EmployeeTypeImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.test.company.impl.EmployeeTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.test.company.impl.EmployeeTypeImpl#getSN <em>SN</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.test.company.impl.EmployeeTypeImpl#isManager <em>Manager</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EmployeeTypeImpl extends DataObjectBase implements EmployeeType
{

	public final static int ID = 0;

	public final static int NAME = 1;

	public final static int SN = 2;

	public final static int MANAGER = 3;

	public final static int SDO_PROPERTY_COUNT = 4;

	public final static int EXTENDED_PROPERTY_COUNT = 0;


	/**
	 * The internal feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_ID = 0;

	/**
	 * The internal feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_NAME = 1;

	/**
	 * The internal feature id for the '<em><b>SN</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_SN = 2;

	/**
	 * The internal feature id for the '<em><b>Manager</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_MANAGER = 3;

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
			case INTERNAL_ID: return ID;
			case INTERNAL_NAME: return NAME;
			case INTERNAL_SN: return SN;
			case INTERNAL_MANAGER: return MANAGER;
		}
		return super.internalConvertIndex(internalIndex);
	}


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
	 * The default value of the '{@link #getSN() <em>SN</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSN()
	 * @generated
	 * @ordered
	 */
	protected static final String SN_DEFAULT_ = null;

	/**
	 * The cached value of the '{@link #getSN() <em>SN</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSN()
	 * @generated
	 * @ordered
	 */
	protected String sn = SN_DEFAULT_;

	/**
	 * The default value of the '{@link #isManager() <em>Manager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isManager()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MANAGER_DEFAULT_ = false;

	/**
	 * The cached value of the '{@link #isManager() <em>Manager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isManager()
	 * @generated
	 * @ordered
	 */
	protected boolean manager = MANAGER_DEFAULT_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmployeeTypeImpl()
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
		return ((CompanyFactoryImpl)CompanyFactory.INSTANCE).getEmployeeType();
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
	public String getSN()
	{
		return sn;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSN(String newSN)
	{
		String oldSN = sn;
		sn = newSN;
		if (isNotifying())
			notify(ChangeKind.SET, INTERNAL_SN, oldSN, sn);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isManager()
	{
		return manager;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManager(boolean newManager)
	{
		boolean oldManager = manager;
		manager = newManager;
		if (isNotifying())
			notify(ChangeKind.SET, INTERNAL_MANAGER, oldManager, manager);
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
			case ID:
				return new Integer(getId());
			case NAME:
				return getName();
			case SN:
				return getSN();
			case MANAGER:
				return isManager() ? Boolean.TRUE : Boolean.FALSE;
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
			case ID:
				setId(((Integer)newValue).intValue());
				return;
			case NAME:
				setName((String)newValue);
				return;
			case SN:
				setSN((String)newValue);
				return;
			case MANAGER:
				setManager(((Boolean)newValue).booleanValue());
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
			case ID:
				setId(ID_DEFAULT_);
				return;
			case NAME:
				setName(NAME_DEFAULT_);
				return;
			case SN:
				setSN(SN_DEFAULT_);
				return;
			case MANAGER:
				setManager(MANAGER_DEFAULT_);
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
			case ID:
				return id != ID_DEFAULT_;
			case NAME:
				return NAME_DEFAULT_ == null ? name != null : !NAME_DEFAULT_.equals(name);
			case SN:
				return SN_DEFAULT_ == null ? sn != null : !SN_DEFAULT_.equals(sn);
			case MANAGER:
				return manager != MANAGER_DEFAULT_;
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
		result.append(", SN: ");
		result.append(sn);
		result.append(", manager: ");
		result.append(manager);
		result.append(')');
		return result.toString();
	}

} //EmployeeTypeImpl
