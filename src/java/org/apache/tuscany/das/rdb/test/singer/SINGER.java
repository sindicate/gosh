/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.das.rdb.test.singer;

import java.io.Serializable;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SINGER</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.apache.tuscany.das.rdb.test.singer.SINGER#getID <em>ID</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.test.singer.SINGER#getNAME <em>NAME</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.test.singer.SINGER#getSings <em>Sings</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface SINGER extends Serializable
{
	/**
	 * Returns the value of the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ID</em>' attribute.
	 * @see #setID(int)
	 * @generated
	 */
	int getID();

	/**
	 * Sets the value of the '{@link org.apache.tuscany.das.rdb.test.singer.SINGER#getID <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ID</em>' attribute.
	 * @see #getID()
	 * @generated
	 */
	void setID(int value);

	/**
	 * Returns the value of the '<em><b>NAME</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>NAME</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>NAME</em>' attribute.
	 * @see #setNAME(String)
	 * @generated
	 */
	String getNAME();

	/**
	 * Sets the value of the '{@link org.apache.tuscany.das.rdb.test.singer.SINGER#getNAME <em>NAME</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>NAME</em>' attribute.
	 * @see #getNAME()
	 * @generated
	 */
	void setNAME(String value);

	/**
	 * Returns the value of the '<em><b>Sings</b></em>' containment reference list.
	 * The list contents are of type {@link org.apache.tuscany.das.rdb.test.singer.SONG}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sings</em>' containment reference list.
	 * @generated
	 */
	List getSings();

} // SINGER
