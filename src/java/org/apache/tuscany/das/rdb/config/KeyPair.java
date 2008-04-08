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
 * A representation of the model object '<em><b>Key Pair</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.apache.tuscany.das.rdb.config.KeyPair#getPrimaryKeyColumn <em>Primary Key Column</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.KeyPair#getForeignKeyColumn <em>Foreign Key Column</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface KeyPair extends Serializable
{
	/**
	 * Returns the value of the '<em><b>Primary Key Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Key Column</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Key Column</em>' attribute.
	 * @see #setPrimaryKeyColumn(String)
	 * @generated
	 */
	String getPrimaryKeyColumn();

	/**
	 * Sets the value of the '{@link org.apache.tuscany.das.rdb.config.KeyPair#getPrimaryKeyColumn <em>Primary Key Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Key Column</em>' attribute.
	 * @see #getPrimaryKeyColumn()
	 * @generated
	 */
	void setPrimaryKeyColumn(String value);

	/**
	 * Returns the value of the '<em><b>Foreign Key Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Foreign Key Column</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Foreign Key Column</em>' attribute.
	 * @see #setForeignKeyColumn(String)
	 * @generated
	 */
	String getForeignKeyColumn();

	/**
	 * Sets the value of the '{@link org.apache.tuscany.das.rdb.config.KeyPair#getForeignKeyColumn <em>Foreign Key Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Foreign Key Column</em>' attribute.
	 * @see #getForeignKeyColumn()
	 * @generated
	 */
	void setForeignKeyColumn(String value);

} // KeyPair
