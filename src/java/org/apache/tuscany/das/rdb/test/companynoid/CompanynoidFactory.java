/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.das.rdb.test.companynoid;

import commonj.sdo.helper.HelperContext;
import org.apache.tuscany.sdo.helper.HelperContextImpl;


/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @generated
 */
public interface CompanynoidFactory
{

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CompanynoidFactory INSTANCE = org.apache.tuscany.das.rdb.test.companynoid.impl.CompanynoidFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type</em>'.
	 * @generated
	 */
	CompanynoidType createCompanynoidType();

	/**
	 * Returns a new object of class '<em>Departmentnoid Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Departmentnoid Type</em>'.
	 * @generated
	 */
	DepartmentnoidType createDepartmentnoidType();

	/**
	 * Returns a new object of class '<em>Employeenoid Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Employeenoid Type</em>'.
	 * @generated
	 */
	EmployeenoidType createEmployeenoidType();

  /**
   * Registers the types supported by this Factory within the supplied scope.argument
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param scope an instance of HelperContext used to manage the scoping of types.
	 * @generated
   */
  public void register(HelperContext scope);
   
} //CompanynoidFactory
