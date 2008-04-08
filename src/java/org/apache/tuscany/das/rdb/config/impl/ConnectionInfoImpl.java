/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.das.rdb.config.impl;

import commonj.sdo.Type;

import org.apache.tuscany.das.rdb.config.ConfigFactory;
import org.apache.tuscany.das.rdb.config.ConnectionInfo;
import org.apache.tuscany.das.rdb.config.ConnectionProperties;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.ConnectionInfoImpl#getConnectionProperties <em>Connection Properties</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.ConnectionInfoImpl#getDataSource <em>Data Source</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.ConnectionInfoImpl#isManagedtx <em>Managedtx</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectionInfoImpl extends DataObjectBase implements ConnectionInfo
{

	public final static int CONNECTION_PROPERTIES = 0;

	public final static int DATA_SOURCE = 1;

	public final static int MANAGEDTX = 2;

	public final static int SDO_PROPERTY_COUNT = 3;

	public final static int EXTENDED_PROPERTY_COUNT = 0;


	/**
	 * The internal feature id for the '<em><b>Connection Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_CONNECTION_PROPERTIES = 0;

	/**
	 * The internal feature id for the '<em><b>Data Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_DATA_SOURCE = 1;

	/**
	 * The internal feature id for the '<em><b>Managedtx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_MANAGEDTX = 2;

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
			case INTERNAL_CONNECTION_PROPERTIES: return CONNECTION_PROPERTIES;
			case INTERNAL_DATA_SOURCE: return DATA_SOURCE;
			case INTERNAL_MANAGEDTX: return MANAGEDTX;
		}
		return super.internalConvertIndex(internalIndex);
	}


	/**
	 * The cached value of the '{@link #getConnectionProperties() <em>Connection Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionProperties()
	 * @generated
	 * @ordered
	 */
	
	protected ConnectionProperties connectionProperties = null;
	
	/**
	 * The default value of the '{@link #getDataSource() <em>Data Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataSource()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_SOURCE_DEFAULT_ = null;

	/**
	 * The cached value of the '{@link #getDataSource() <em>Data Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataSource()
	 * @generated
	 * @ordered
	 */
	protected String dataSource = DATA_SOURCE_DEFAULT_;

	/**
	 * The default value of the '{@link #isManagedtx() <em>Managedtx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isManagedtx()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MANAGEDTX_DEFAULT_ = true;

	/**
	 * The cached value of the '{@link #isManagedtx() <em>Managedtx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isManagedtx()
	 * @generated
	 * @ordered
	 */
	protected boolean managedtx = MANAGEDTX_DEFAULT_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionInfoImpl()
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
		return ((ConfigFactoryImpl)ConfigFactory.INSTANCE).getConnectionInfo();
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
	public ConnectionProperties getConnectionProperties()
	{
		return connectionProperties;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeContext basicSetConnectionProperties(ConnectionProperties newConnectionProperties, ChangeContext changeContext)
	{
		ConnectionProperties oldConnectionProperties = connectionProperties;
		connectionProperties = newConnectionProperties;
		return changeContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionProperties(ConnectionProperties newConnectionProperties)
	{
		if (newConnectionProperties != connectionProperties)
		{
			ChangeContext changeContext = null;
			if (connectionProperties != null)
				changeContext = inverseRemove(connectionProperties, this, OPPOSITE_FEATURE_BASE - INTERNAL_CONNECTION_PROPERTIES, null, changeContext);
			if (newConnectionProperties != null)
				changeContext = inverseAdd(newConnectionProperties, this, OPPOSITE_FEATURE_BASE - INTERNAL_CONNECTION_PROPERTIES, null, changeContext);
			changeContext = basicSetConnectionProperties(newConnectionProperties, changeContext);
			if (changeContext != null) dispatch(changeContext);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDataSource()
	{
		return dataSource;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataSource(String newDataSource)
	{
		dataSource = newDataSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isManagedtx()
	{
		return managedtx;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManagedtx(boolean newManagedtx)
	{
		managedtx = newManagedtx;
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
			case CONNECTION_PROPERTIES:
				return basicSetConnectionProperties(null, changeContext);
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
			case CONNECTION_PROPERTIES:
				return getConnectionProperties();
			case DATA_SOURCE:
				return getDataSource();
			case MANAGEDTX:
				return isManagedtx() ? Boolean.TRUE : Boolean.FALSE;
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
			case CONNECTION_PROPERTIES:
				setConnectionProperties((ConnectionProperties)newValue);
				return;
			case DATA_SOURCE:
				setDataSource((String)newValue);
				return;
			case MANAGEDTX:
				setManagedtx(((Boolean)newValue).booleanValue());
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
			case CONNECTION_PROPERTIES:
				setConnectionProperties((ConnectionProperties)null);
				return;
			case DATA_SOURCE:
				setDataSource(DATA_SOURCE_DEFAULT_);
				return;
			case MANAGEDTX:
				setManagedtx(MANAGEDTX_DEFAULT_);
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
			case CONNECTION_PROPERTIES:
				return connectionProperties != null;
			case DATA_SOURCE:
				return DATA_SOURCE_DEFAULT_ == null ? dataSource != null : !DATA_SOURCE_DEFAULT_.equals(dataSource);
			case MANAGEDTX:
				return managedtx != MANAGEDTX_DEFAULT_;
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
		result.append(" (dataSource: ");
		result.append(dataSource);
		result.append(", managedtx: ");
		result.append(managedtx);
		result.append(')');
		return result.toString();
	}

} //ConnectionInfoImpl
