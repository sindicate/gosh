/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.das.rdb.config;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.apache.tuscany.das.rdb.config.ConnectionProperties#getDriverClass <em>Driver Class</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.ConnectionProperties#getDatabaseURL <em>Database URL</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.ConnectionProperties#getUserName <em>User Name</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.ConnectionProperties#getPassword <em>Password</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.ConnectionProperties#getLoginTimeout <em>Login Timeout</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface ConnectionProperties extends Serializable
{
	/**
	 * Returns the value of the '<em><b>Driver Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Driver Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Driver Class</em>' attribute.
	 * @see #setDriverClass(String)
	 * @generated
	 */
	String getDriverClass();

	/**
	 * Sets the value of the '{@link org.apache.tuscany.das.rdb.config.ConnectionProperties#getDriverClass <em>Driver Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Driver Class</em>' attribute.
	 * @see #getDriverClass()
	 * @generated
	 */
	void setDriverClass(String value);

	/**
	 * Returns the value of the '<em><b>Database URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Database URL</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Database URL</em>' attribute.
	 * @see #setDatabaseURL(String)
	 * @generated
	 */
	String getDatabaseURL();

	/**
	 * Sets the value of the '{@link org.apache.tuscany.das.rdb.config.ConnectionProperties#getDatabaseURL <em>Database URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Database URL</em>' attribute.
	 * @see #getDatabaseURL()
	 * @generated
	 */
	void setDatabaseURL(String value);

	/**
	 * Returns the value of the '<em><b>User Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Name</em>' attribute.
	 * @see #setUserName(String)
	 * @generated
	 */
	String getUserName();

	/**
	 * Sets the value of the '{@link org.apache.tuscany.das.rdb.config.ConnectionProperties#getUserName <em>User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Name</em>' attribute.
	 * @see #getUserName()
	 * @generated
	 */
	void setUserName(String value);

	/**
	 * Returns the value of the '<em><b>Password</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link org.apache.tuscany.das.rdb.config.ConnectionProperties#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(String value);

	/**
	 * Returns the value of the '<em><b>Login Timeout</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Login Timeout</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Login Timeout</em>' attribute.
	 * @see #setLoginTimeout(int)
	 * @generated
	 */
	int getLoginTimeout();

	/**
	 * Sets the value of the '{@link org.apache.tuscany.das.rdb.config.ConnectionProperties#getLoginTimeout <em>Login Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Login Timeout</em>' attribute.
	 * @see #getLoginTimeout()
	 * @generated
	 */
	void setLoginTimeout(int value);

} // ConnectionProperties
