/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.das.rdb.test.singer;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SONG</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.apache.tuscany.das.rdb.test.singer.SONG#getID <em>ID</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.test.singer.SONG#getTITLE <em>TITLE</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.test.singer.SONG#getSINGERID <em>SINGERID</em>}</li>
 * </ul>
 * </p>
 *
 * @extends Serializable
 * @generated
 */
public interface SONG extends Serializable
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
	 * Sets the value of the '{@link org.apache.tuscany.das.rdb.test.singer.SONG#getID <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ID</em>' attribute.
	 * @see #getID()
	 * @generated
	 */
	void setID(int value);

	/**
	 * Returns the value of the '<em><b>TITLE</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>TITLE</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>TITLE</em>' attribute.
	 * @see #setTITLE(String)
	 * @generated
	 */
	String getTITLE();

	/**
	 * Sets the value of the '{@link org.apache.tuscany.das.rdb.test.singer.SONG#getTITLE <em>TITLE</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TITLE</em>' attribute.
	 * @see #getTITLE()
	 * @generated
	 */
	void setTITLE(String value);

	/**
	 * Returns the value of the '<em><b>SINGERID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SINGERID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SINGERID</em>' attribute.
	 * @see #setSINGERID(int)
	 * @generated
	 */
	int getSINGERID();

	/**
	 * Sets the value of the '{@link org.apache.tuscany.das.rdb.test.singer.SONG#getSINGERID <em>SINGERID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SINGERID</em>' attribute.
	 * @see #getSINGERID()
	 * @generated
	 */
	void setSINGERID(int value);

} // SONG
