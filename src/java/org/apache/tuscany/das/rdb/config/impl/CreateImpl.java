/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.das.rdb.config.impl;

import commonj.sdo.Type;

import org.apache.tuscany.das.rdb.config.ConfigFactory;
import org.apache.tuscany.das.rdb.config.Create;
import org.apache.tuscany.das.rdb.config.Parameters;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Create</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.CreateImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.CreateImpl#getSql <em>Sql</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CreateImpl extends DataObjectBase implements Create
{

	public final static int PARAMETERS = 0;

	public final static int SQL = 1;

	public final static int SDO_PROPERTY_COUNT = 2;

	public final static int EXTENDED_PROPERTY_COUNT = 0;


	/**
	 * The internal feature id for the '<em><b>Parameters</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_PARAMETERS = 0;

	/**
	 * The internal feature id for the '<em><b>Sql</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_SQL = 1;

	/**
	 * The number of properties for this type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public final static int INTERNAL_PROPERTY_COUNT = 2;

	protected int internalConvertIndex(int internalIndex)
	{
		switch (internalIndex)
		{
			case INTERNAL_PARAMETERS: return PARAMETERS;
			case INTERNAL_SQL: return SQL;
		}
		return super.internalConvertIndex(internalIndex);
	}


	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	
	protected Parameters parameters = null;
	
	/**
	 * The default value of the '{@link #getSql() <em>Sql</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSql()
	 * @generated
	 * @ordered
	 */
	protected static final String SQL_DEFAULT_ = null;

	/**
	 * The cached value of the '{@link #getSql() <em>Sql</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSql()
	 * @generated
	 * @ordered
	 */
	protected String sql = SQL_DEFAULT_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateImpl()
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
		return ((ConfigFactoryImpl)ConfigFactory.INSTANCE).getCreate();
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
	public Parameters getParameters()
	{
		return parameters;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeContext basicSetParameters(Parameters newParameters, ChangeContext changeContext)
	{
		Parameters oldParameters = parameters;
		parameters = newParameters;
		return changeContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameters(Parameters newParameters)
	{
		if (newParameters != parameters)
		{
			ChangeContext changeContext = null;
			if (parameters != null)
				changeContext = inverseRemove(parameters, this, OPPOSITE_FEATURE_BASE - INTERNAL_PARAMETERS, null, changeContext);
			if (newParameters != null)
				changeContext = inverseAdd(newParameters, this, OPPOSITE_FEATURE_BASE - INTERNAL_PARAMETERS, null, changeContext);
			changeContext = basicSetParameters(newParameters, changeContext);
			if (changeContext != null) dispatch(changeContext);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSql()
	{
		return sql;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSql(String newSql)
	{
		sql = newSql;
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
			case PARAMETERS:
				return basicSetParameters(null, changeContext);
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
			case PARAMETERS:
				return getParameters();
			case SQL:
				return getSql();
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
			case PARAMETERS:
				setParameters((Parameters)newValue);
				return;
			case SQL:
				setSql((String)newValue);
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
			case PARAMETERS:
				setParameters((Parameters)null);
				return;
			case SQL:
				setSql(SQL_DEFAULT_);
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
			case PARAMETERS:
				return parameters != null;
			case SQL:
				return SQL_DEFAULT_ == null ? sql != null : !SQL_DEFAULT_.equals(sql);
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
		result.append(" (sql: ");
		result.append(sql);
		result.append(')');
		return result.toString();
	}

} //CreateImpl
