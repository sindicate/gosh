/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.das.rdb.config;

import java.io.Serializable;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.apache.tuscany.das.rdb.config.Config#getCommand <em>Command</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.Config#getTable <em>Table</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.Config#getRelationship <em>Relationship</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.Config#getConnectionInfo <em>Connection Info</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.Config#getUri <em>Uri</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.Config#getDataObjectModel <em>Data Object Model</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.Config#isDatabaseSchemaNameSupported <em>Database Schema Name Supported</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.Config#getGeneratedKeysSupported <em>Generated Keys Supported</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface Config extends Serializable
{
	/**
	 * Returns the value of the '<em><b>Command</b></em>' containment reference list.
	 * The list contents are of type {@link org.apache.tuscany.das.rdb.config.Command}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Command</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Command</em>' containment reference list.
	 * @generated
	 */
	List getCommand();

	/**
	 * Returns the value of the '<em><b>Table</b></em>' containment reference list.
	 * The list contents are of type {@link org.apache.tuscany.das.rdb.config.Table}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Table</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table</em>' containment reference list.
	 * @generated
	 */
	List getTable();

	/**
	 * Returns the value of the '<em><b>Relationship</b></em>' containment reference list.
	 * The list contents are of type {@link org.apache.tuscany.das.rdb.config.Relationship}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relationship</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relationship</em>' containment reference list.
	 * @generated
	 */
	List getRelationship();

	/**
	 * Returns the value of the '<em><b>Connection Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Info</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Info</em>' containment reference.
	 * @see #setConnectionInfo(ConnectionInfo)
	 * @generated
	 */
	ConnectionInfo getConnectionInfo();

	/**
	 * Sets the value of the '{@link org.apache.tuscany.das.rdb.config.Config#getConnectionInfo <em>Connection Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection Info</em>' containment reference.
	 * @see #getConnectionInfo()
	 * @generated
	 */
	void setConnectionInfo(ConnectionInfo value);

	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link org.apache.tuscany.das.rdb.config.Config#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

	/**
	 * Returns the value of the '<em><b>Data Object Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Object Model</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Object Model</em>' attribute.
	 * @see #setDataObjectModel(String)
	 * @generated
	 */
	String getDataObjectModel();

	/**
	 * Sets the value of the '{@link org.apache.tuscany.das.rdb.config.Config#getDataObjectModel <em>Data Object Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Object Model</em>' attribute.
	 * @see #getDataObjectModel()
	 * @generated
	 */
	void setDataObjectModel(String value);

	/**
	 * Returns the value of the '<em><b>Database Schema Name Supported</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Database Schema Name Supported</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Database Schema Name Supported</em>' attribute.
	 * @see #setDatabaseSchemaNameSupported(boolean)
	 * @generated
	 */
	boolean isDatabaseSchemaNameSupported();

	/**
	 * Sets the value of the '{@link org.apache.tuscany.das.rdb.config.Config#isDatabaseSchemaNameSupported <em>Database Schema Name Supported</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Database Schema Name Supported</em>' attribute.
	 * @see #isDatabaseSchemaNameSupported()
	 * @generated
	 */
	void setDatabaseSchemaNameSupported(boolean value);

	/**
	 * Returns the value of the '<em><b>Generated Keys Supported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generated Keys Supported</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generated Keys Supported</em>' attribute.
	 * @see #setGeneratedKeysSupported(String)
	 * @generated
	 */
	String getGeneratedKeysSupported();

	/**
	 * Sets the value of the '{@link org.apache.tuscany.das.rdb.config.Config#getGeneratedKeysSupported <em>Generated Keys Supported</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generated Keys Supported</em>' attribute.
	 * @see #getGeneratedKeysSupported()
	 * @generated
	 */
	void setGeneratedKeysSupported(String value);

} // Config
