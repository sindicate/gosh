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
 * A representation of the model object '<em><b>Column</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.apache.tuscany.das.rdb.config.Column#getColumnName <em>Column Name</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.Column#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.Column#getConverterClassName <em>Converter Class Name</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.Column#isPrimaryKey <em>Primary Key</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.Column#isGenerated <em>Generated</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.Column#isCollision <em>Collision</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.Column#isManaged <em>Managed</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface Column extends Serializable
{
	/**
	 * Returns the value of the '<em><b>Column Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column Name</em>' attribute.
	 * @see #setColumnName(String)
	 * @generated
	 */
	String getColumnName();

	/**
	 * Sets the value of the '{@link org.apache.tuscany.das.rdb.config.Column#getColumnName <em>Column Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column Name</em>' attribute.
	 * @see #getColumnName()
	 * @generated
	 */
	void setColumnName(String value);

	/**
	 * Returns the value of the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Name</em>' attribute.
	 * @see #setPropertyName(String)
	 * @generated
	 */
	String getPropertyName();

	/**
	 * Sets the value of the '{@link org.apache.tuscany.das.rdb.config.Column#getPropertyName <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Name</em>' attribute.
	 * @see #getPropertyName()
	 * @generated
	 */
	void setPropertyName(String value);

	/**
	 * Returns the value of the '<em><b>Converter Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Converter Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Converter Class Name</em>' attribute.
	 * @see #setConverterClassName(String)
	 * @generated
	 */
	String getConverterClassName();

	/**
	 * Sets the value of the '{@link org.apache.tuscany.das.rdb.config.Column#getConverterClassName <em>Converter Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Converter Class Name</em>' attribute.
	 * @see #getConverterClassName()
	 * @generated
	 */
	void setConverterClassName(String value);

	/**
	 * Returns the value of the '<em><b>Primary Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Key</em>' attribute.
	 * @see #setPrimaryKey(boolean)
	 * @generated
	 */
	boolean isPrimaryKey();

	/**
	 * Sets the value of the '{@link org.apache.tuscany.das.rdb.config.Column#isPrimaryKey <em>Primary Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Key</em>' attribute.
	 * @see #isPrimaryKey()
	 * @generated
	 */
	void setPrimaryKey(boolean value);

	/**
	 * Returns the value of the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generated</em>' attribute.
	 * @see #setGenerated(boolean)
	 * @generated
	 */
	boolean isGenerated();

	/**
	 * Sets the value of the '{@link org.apache.tuscany.das.rdb.config.Column#isGenerated <em>Generated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generated</em>' attribute.
	 * @see #isGenerated()
	 * @generated
	 */
	void setGenerated(boolean value);

	/**
	 * Returns the value of the '<em><b>Collision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collision</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collision</em>' attribute.
	 * @see #setCollision(boolean)
	 * @generated
	 */
	boolean isCollision();

	/**
	 * Sets the value of the '{@link org.apache.tuscany.das.rdb.config.Column#isCollision <em>Collision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collision</em>' attribute.
	 * @see #isCollision()
	 * @generated
	 */
	void setCollision(boolean value);

	/**
	 * Returns the value of the '<em><b>Managed</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Managed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Managed</em>' attribute.
	 * @see #setManaged(boolean)
	 * @generated
	 */
	boolean isManaged();

	/**
	 * Sets the value of the '{@link org.apache.tuscany.das.rdb.config.Column#isManaged <em>Managed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Managed</em>' attribute.
	 * @see #isManaged()
	 * @generated
	 */
	void setManaged(boolean value);

} // Column
