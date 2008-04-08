/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.das.rdb.config.impl;

import commonj.sdo.Type;

import java.util.Collection;
import java.util.List;

import org.apache.tuscany.das.rdb.config.Command;
import org.apache.tuscany.das.rdb.config.ConfigFactory;
import org.apache.tuscany.das.rdb.config.Parameter;
import org.apache.tuscany.das.rdb.config.ResultDescriptor;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Command</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.CommandImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.CommandImpl#getResultDescriptor <em>Result Descriptor</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.CommandImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.CommandImpl#getSQL <em>SQL</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.CommandImpl#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CommandImpl extends DataObjectBase implements Command
{

	public final static int PARAMETER = 0;

	public final static int RESULT_DESCRIPTOR = 1;

	public final static int NAME = 2;

	public final static int SQL = 3;

	public final static int KIND = 4;

	public final static int SDO_PROPERTY_COUNT = 5;

	public final static int EXTENDED_PROPERTY_COUNT = 0;


	/**
	 * The internal feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_PARAMETER = 0;

	/**
	 * The internal feature id for the '<em><b>Result Descriptor</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_RESULT_DESCRIPTOR = 1;

	/**
	 * The internal feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_NAME = 2;

	/**
	 * The internal feature id for the '<em><b>SQL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_SQL = 3;

	/**
	 * The internal feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_KIND = 4;

	/**
	 * The number of properties for this type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public final static int INTERNAL_PROPERTY_COUNT = 5;

	protected int internalConvertIndex(int internalIndex)
	{
		switch (internalIndex)
		{
			case INTERNAL_PARAMETER: return PARAMETER;
			case INTERNAL_RESULT_DESCRIPTOR: return RESULT_DESCRIPTOR;
			case INTERNAL_NAME: return NAME;
			case INTERNAL_SQL: return SQL;
			case INTERNAL_KIND: return KIND;
		}
		return super.internalConvertIndex(internalIndex);
	}


	/**
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	
	protected List parameter = null;
	
	/**
	 * The cached value of the '{@link #getResultDescriptor() <em>Result Descriptor</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultDescriptor()
	 * @generated
	 * @ordered
	 */
	
	protected List resultDescriptor = null;
	
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
	 * The default value of the '{@link #getSQL() <em>SQL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSQL()
	 * @generated
	 * @ordered
	 */
	protected static final String SQL_DEFAULT_ = null;

	/**
	 * The cached value of the '{@link #getSQL() <em>SQL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSQL()
	 * @generated
	 * @ordered
	 */
	protected String sql = SQL_DEFAULT_;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final String KIND_DEFAULT_ = null;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected String kind = KIND_DEFAULT_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandImpl()
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
		return ((ConfigFactoryImpl)ConfigFactory.INSTANCE).getCommand();
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
	public List getParameter()
	{
		if (parameter == null)
		{
		  parameter = createPropertyList(ListKind.CONTAINMENT, Parameter.class, PARAMETER, 0);
		}
		return parameter;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getResultDescriptor()
	{
		if (resultDescriptor == null)
		{
		  resultDescriptor = createPropertyList(ListKind.CONTAINMENT, ResultDescriptor.class, RESULT_DESCRIPTOR, 0);
		}
		return resultDescriptor;
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
		name = newName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSQL()
	{
		return sql;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSQL(String newSQL)
	{
		sql = newSQL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKind()
	{
		return kind;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(String newKind)
	{
		kind = newKind;
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
			case PARAMETER:
				return removeFromList(getParameter(), otherEnd, changeContext);
			case RESULT_DESCRIPTOR:
				return removeFromList(getResultDescriptor(), otherEnd, changeContext);
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
			case PARAMETER:
				return getParameter();
			case RESULT_DESCRIPTOR:
				return getResultDescriptor();
			case NAME:
				return getName();
			case SQL:
				return getSQL();
			case KIND:
				return getKind();
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
			case PARAMETER:
				getParameter().clear();
				getParameter().addAll((Collection)newValue);
				return;
			case RESULT_DESCRIPTOR:
				getResultDescriptor().clear();
				getResultDescriptor().addAll((Collection)newValue);
				return;
			case NAME:
				setName((String)newValue);
				return;
			case SQL:
				setSQL((String)newValue);
				return;
			case KIND:
				setKind((String)newValue);
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
			case PARAMETER:
				getParameter().clear();
				return;
			case RESULT_DESCRIPTOR:
				getResultDescriptor().clear();
				return;
			case NAME:
				setName(NAME_DEFAULT_);
				return;
			case SQL:
				setSQL(SQL_DEFAULT_);
				return;
			case KIND:
				setKind(KIND_DEFAULT_);
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
			case PARAMETER:
				return parameter != null && !parameter.isEmpty();
			case RESULT_DESCRIPTOR:
				return resultDescriptor != null && !resultDescriptor.isEmpty();
			case NAME:
				return NAME_DEFAULT_ == null ? name != null : !NAME_DEFAULT_.equals(name);
			case SQL:
				return SQL_DEFAULT_ == null ? sql != null : !SQL_DEFAULT_.equals(sql);
			case KIND:
				return KIND_DEFAULT_ == null ? kind != null : !KIND_DEFAULT_.equals(kind);
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
		result.append(", SQL: ");
		result.append(sql);
		result.append(", kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} //CommandImpl
