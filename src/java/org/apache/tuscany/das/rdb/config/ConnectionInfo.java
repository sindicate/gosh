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
 * A representation of the model object '<em><b>Connection Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.apache.tuscany.das.rdb.config.ConnectionInfo#getConnectionProperties <em>Connection Properties</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.ConnectionInfo#getDataSource <em>Data Source</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.ConnectionInfo#isManagedtx <em>Managedtx</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface ConnectionInfo extends Serializable
{
	/**
	 * Returns the value of the '<em><b>Connection Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Properties</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Properties</em>' containment reference.
	 * @see #setConnectionProperties(ConnectionProperties)
	 * @generated
	 */
	ConnectionProperties getConnectionProperties();

	/**
	 * Sets the value of the '{@link org.apache.tuscany.das.rdb.config.ConnectionInfo#getConnectionProperties <em>Connection Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection Properties</em>' containment reference.
	 * @see #getConnectionProperties()
	 * @generated
	 */
	void setConnectionProperties(ConnectionProperties value);

	/**
	 * Returns the value of the '<em><b>Data Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Source</em>' attribute.
	 * @see #setDataSource(String)
	 * @generated
	 */
	String getDataSource();

	/**
	 * Sets the value of the '{@link org.apache.tuscany.das.rdb.config.ConnectionInfo#getDataSource <em>Data Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Source</em>' attribute.
	 * @see #getDataSource()
	 * @generated
	 */
	void setDataSource(String value);

	/**
	 * Returns the value of the '<em><b>Managedtx</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Managedtx</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Managedtx</em>' attribute.
	 * @see #setManagedtx(boolean)
	 * @generated
	 */
	boolean isManagedtx();

	/**
	 * Sets the value of the '{@link org.apache.tuscany.das.rdb.config.ConnectionInfo#isManagedtx <em>Managedtx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Managedtx</em>' attribute.
	 * @see #isManagedtx()
	 * @generated
	 */
	void setManagedtx(boolean value);

} // ConnectionInfo
