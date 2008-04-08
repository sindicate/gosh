/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.das.rdb.config.impl;

import commonj.sdo.Type;

import org.apache.tuscany.das.rdb.config.ConfigFactory;
import org.apache.tuscany.das.rdb.config.ConnectionProperties;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.ConnectionPropertiesImpl#getDriverClass <em>Driver Class</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.ConnectionPropertiesImpl#getDatabaseURL <em>Database URL</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.ConnectionPropertiesImpl#getUserName <em>User Name</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.ConnectionPropertiesImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.ConnectionPropertiesImpl#getLoginTimeout <em>Login Timeout</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectionPropertiesImpl extends DataObjectBase implements ConnectionProperties
{

	public final static int DRIVER_CLASS = 0;

	public final static int DATABASE_URL = 1;

	public final static int USER_NAME = 2;

	public final static int PASSWORD = 3;

	public final static int LOGIN_TIMEOUT = 4;

	public final static int SDO_PROPERTY_COUNT = 5;

	public final static int EXTENDED_PROPERTY_COUNT = 0;


	/**
	 * The internal feature id for the '<em><b>Driver Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_DRIVER_CLASS = 0;

	/**
	 * The internal feature id for the '<em><b>Database URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_DATABASE_URL = 1;

	/**
	 * The internal feature id for the '<em><b>User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_USER_NAME = 2;

	/**
	 * The internal feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_PASSWORD = 3;

	/**
	 * The internal feature id for the '<em><b>Login Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_LOGIN_TIMEOUT = 4;

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
			case INTERNAL_DRIVER_CLASS: return DRIVER_CLASS;
			case INTERNAL_DATABASE_URL: return DATABASE_URL;
			case INTERNAL_USER_NAME: return USER_NAME;
			case INTERNAL_PASSWORD: return PASSWORD;
			case INTERNAL_LOGIN_TIMEOUT: return LOGIN_TIMEOUT;
		}
		return super.internalConvertIndex(internalIndex);
	}


	/**
	 * The default value of the '{@link #getDriverClass() <em>Driver Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDriverClass()
	 * @generated
	 * @ordered
	 */
	protected static final String DRIVER_CLASS_DEFAULT_ = null;

	/**
	 * The cached value of the '{@link #getDriverClass() <em>Driver Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDriverClass()
	 * @generated
	 * @ordered
	 */
	protected String driverClass = DRIVER_CLASS_DEFAULT_;

	/**
	 * The default value of the '{@link #getDatabaseURL() <em>Database URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatabaseURL()
	 * @generated
	 * @ordered
	 */
	protected static final String DATABASE_URL_DEFAULT_ = null;

	/**
	 * The cached value of the '{@link #getDatabaseURL() <em>Database URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatabaseURL()
	 * @generated
	 * @ordered
	 */
	protected String databaseURL = DATABASE_URL_DEFAULT_;

	/**
	 * The default value of the '{@link #getUserName() <em>User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserName()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_NAME_DEFAULT_ = "";

	/**
	 * The cached value of the '{@link #getUserName() <em>User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserName()
	 * @generated
	 * @ordered
	 */
	protected String userName = USER_NAME_DEFAULT_;

	/**
	 * The default value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWORD_DEFAULT_ = "";

	/**
	 * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected String password = PASSWORD_DEFAULT_;

	/**
	 * The default value of the '{@link #getLoginTimeout() <em>Login Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoginTimeout()
	 * @generated
	 * @ordered
	 */
	protected static final int LOGIN_TIMEOUT_DEFAULT_ = 0;

	/**
	 * The cached value of the '{@link #getLoginTimeout() <em>Login Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoginTimeout()
	 * @generated
	 * @ordered
	 */
	protected int loginTimeout = LOGIN_TIMEOUT_DEFAULT_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionPropertiesImpl()
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
		return ((ConfigFactoryImpl)ConfigFactory.INSTANCE).getConnectionProperties();
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
	public String getDriverClass()
	{
		return driverClass;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDriverClass(String newDriverClass)
	{
		driverClass = newDriverClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDatabaseURL()
	{
		return databaseURL;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDatabaseURL(String newDatabaseURL)
	{
		databaseURL = newDatabaseURL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserName()
	{
		return userName;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserName(String newUserName)
	{
		userName = newUserName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPassword()
	{
		return password;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassword(String newPassword)
	{
		password = newPassword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLoginTimeout()
	{
		return loginTimeout;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoginTimeout(int newLoginTimeout)
	{
		loginTimeout = newLoginTimeout;
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
			case DRIVER_CLASS:
				return getDriverClass();
			case DATABASE_URL:
				return getDatabaseURL();
			case USER_NAME:
				return getUserName();
			case PASSWORD:
				return getPassword();
			case LOGIN_TIMEOUT:
				return new Integer(getLoginTimeout());
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
			case DRIVER_CLASS:
				setDriverClass((String)newValue);
				return;
			case DATABASE_URL:
				setDatabaseURL((String)newValue);
				return;
			case USER_NAME:
				setUserName((String)newValue);
				return;
			case PASSWORD:
				setPassword((String)newValue);
				return;
			case LOGIN_TIMEOUT:
				setLoginTimeout(((Integer)newValue).intValue());
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
			case DRIVER_CLASS:
				setDriverClass(DRIVER_CLASS_DEFAULT_);
				return;
			case DATABASE_URL:
				setDatabaseURL(DATABASE_URL_DEFAULT_);
				return;
			case USER_NAME:
				setUserName(USER_NAME_DEFAULT_);
				return;
			case PASSWORD:
				setPassword(PASSWORD_DEFAULT_);
				return;
			case LOGIN_TIMEOUT:
				setLoginTimeout(LOGIN_TIMEOUT_DEFAULT_);
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
			case DRIVER_CLASS:
				return DRIVER_CLASS_DEFAULT_ == null ? driverClass != null : !DRIVER_CLASS_DEFAULT_.equals(driverClass);
			case DATABASE_URL:
				return DATABASE_URL_DEFAULT_ == null ? databaseURL != null : !DATABASE_URL_DEFAULT_.equals(databaseURL);
			case USER_NAME:
				return USER_NAME_DEFAULT_ == null ? userName != null : !USER_NAME_DEFAULT_.equals(userName);
			case PASSWORD:
				return PASSWORD_DEFAULT_ == null ? password != null : !PASSWORD_DEFAULT_.equals(password);
			case LOGIN_TIMEOUT:
				return loginTimeout != LOGIN_TIMEOUT_DEFAULT_;
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
		result.append(" (driverClass: ");
		result.append(driverClass);
		result.append(", databaseURL: ");
		result.append(databaseURL);
		result.append(", userName: ");
		result.append(userName);
		result.append(", password: ");
		result.append(password);
		result.append(", loginTimeout: ");
		result.append(loginTimeout);
		result.append(')');
		return result.toString();
	}

} //ConnectionPropertiesImpl
