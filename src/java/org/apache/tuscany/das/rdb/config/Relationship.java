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
 * A representation of the model object '<em><b>Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.apache.tuscany.das.rdb.config.Relationship#getKeyPair <em>Key Pair</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.Relationship#getName <em>Name</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.Relationship#getPrimaryKeyTable <em>Primary Key Table</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.Relationship#getForeignKeyTable <em>Foreign Key Table</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.Relationship#isMany <em>Many</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.Relationship#isKeyRestricted <em>Key Restricted</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface Relationship extends Serializable
{
	/**
	 * Returns the value of the '<em><b>Key Pair</b></em>' containment reference list.
	 * The list contents are of type {@link org.apache.tuscany.das.rdb.config.KeyPair}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key Pair</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key Pair</em>' containment reference list.
	 * @generated
	 */
	List getKeyPair();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.apache.tuscany.das.rdb.config.Relationship#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Primary Key Table</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Key Table</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Key Table</em>' attribute.
	 * @see #setPrimaryKeyTable(String)
	 * @generated
	 */
	String getPrimaryKeyTable();

	/**
	 * Sets the value of the '{@link org.apache.tuscany.das.rdb.config.Relationship#getPrimaryKeyTable <em>Primary Key Table</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Key Table</em>' attribute.
	 * @see #getPrimaryKeyTable()
	 * @generated
	 */
	void setPrimaryKeyTable(String value);

	/**
	 * Returns the value of the '<em><b>Foreign Key Table</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Foreign Key Table</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Foreign Key Table</em>' attribute.
	 * @see #setForeignKeyTable(String)
	 * @generated
	 */
	String getForeignKeyTable();

	/**
	 * Sets the value of the '{@link org.apache.tuscany.das.rdb.config.Relationship#getForeignKeyTable <em>Foreign Key Table</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Foreign Key Table</em>' attribute.
	 * @see #getForeignKeyTable()
	 * @generated
	 */
	void setForeignKeyTable(String value);

	/**
	 * Returns the value of the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Many</em>' attribute.
	 * @see #setMany(boolean)
	 * @generated
	 */
	boolean isMany();

	/**
	 * Sets the value of the '{@link org.apache.tuscany.das.rdb.config.Relationship#isMany <em>Many</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Many</em>' attribute.
	 * @see #isMany()
	 * @generated
	 */
	void setMany(boolean value);

	/**
	 * Returns the value of the '<em><b>Key Restricted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key Restricted</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key Restricted</em>' attribute.
	 * @see #setKeyRestricted(boolean)
	 * @generated
	 */
	boolean isKeyRestricted();

	/**
	 * Sets the value of the '{@link org.apache.tuscany.das.rdb.config.Relationship#isKeyRestricted <em>Key Restricted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key Restricted</em>' attribute.
	 * @see #isKeyRestricted()
	 * @generated
	 */
	void setKeyRestricted(boolean value);

} // Relationship
