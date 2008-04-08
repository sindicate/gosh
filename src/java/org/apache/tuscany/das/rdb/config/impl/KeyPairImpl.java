/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.das.rdb.config.impl;

import commonj.sdo.Type;

import org.apache.tuscany.das.rdb.config.ConfigFactory;
import org.apache.tuscany.das.rdb.config.KeyPair;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Key Pair</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.KeyPairImpl#getPrimaryKeyColumn <em>Primary Key Column</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.KeyPairImpl#getForeignKeyColumn <em>Foreign Key Column</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KeyPairImpl extends DataObjectBase implements KeyPair
{

	public final static int PRIMARY_KEY_COLUMN = 0;

	public final static int FOREIGN_KEY_COLUMN = 1;

	public final static int SDO_PROPERTY_COUNT = 2;

	public final static int EXTENDED_PROPERTY_COUNT = 0;


	/**
	 * The internal feature id for the '<em><b>Primary Key Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_PRIMARY_KEY_COLUMN = 0;

	/**
	 * The internal feature id for the '<em><b>Foreign Key Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_FOREIGN_KEY_COLUMN = 1;

	/**
	 * The number of properties for this type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public final static int INTERNAL_PROPERTY_COUNT = 2;

	protected int internalConvertIndex(int internalIndex)
	{
		switch (internalIndex)
		{
			case INTERNAL_PRIMARY_KEY_COLUMN: return PRIMARY_KEY_COLUMN;
			case INTERNAL_FOREIGN_KEY_COLUMN: return FOREIGN_KEY_COLUMN;
		}
		return super.internalConvertIndex(internalIndex);
	}


	/**
	 * The default value of the '{@link #getPrimaryKeyColumn() <em>Primary Key Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryKeyColumn()
	 * @generated
	 * @ordered
	 */
	protected static final String PRIMARY_KEY_COLUMN_DEFAULT_ = null;

	/**
	 * The cached value of the '{@link #getPrimaryKeyColumn() <em>Primary Key Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryKeyColumn()
	 * @generated
	 * @ordered
	 */
	protected String primaryKeyColumn = PRIMARY_KEY_COLUMN_DEFAULT_;

	/**
	 * The default value of the '{@link #getForeignKeyColumn() <em>Foreign Key Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForeignKeyColumn()
	 * @generated
	 * @ordered
	 */
	protected static final String FOREIGN_KEY_COLUMN_DEFAULT_ = null;

	/**
	 * The cached value of the '{@link #getForeignKeyColumn() <em>Foreign Key Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForeignKeyColumn()
	 * @generated
	 * @ordered
	 */
	protected String foreignKeyColumn = FOREIGN_KEY_COLUMN_DEFAULT_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KeyPairImpl()
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
		return ((ConfigFactoryImpl)ConfigFactory.INSTANCE).getKeyPair();
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
	public String getPrimaryKeyColumn()
	{
		return primaryKeyColumn;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimaryKeyColumn(String newPrimaryKeyColumn)
	{
		primaryKeyColumn = newPrimaryKeyColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getForeignKeyColumn()
	{
		return foreignKeyColumn;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForeignKeyColumn(String newForeignKeyColumn)
	{
		foreignKeyColumn = newForeignKeyColumn;
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
			case PRIMARY_KEY_COLUMN:
				return getPrimaryKeyColumn();
			case FOREIGN_KEY_COLUMN:
				return getForeignKeyColumn();
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
			case PRIMARY_KEY_COLUMN:
				setPrimaryKeyColumn((String)newValue);
				return;
			case FOREIGN_KEY_COLUMN:
				setForeignKeyColumn((String)newValue);
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
			case PRIMARY_KEY_COLUMN:
				setPrimaryKeyColumn(PRIMARY_KEY_COLUMN_DEFAULT_);
				return;
			case FOREIGN_KEY_COLUMN:
				setForeignKeyColumn(FOREIGN_KEY_COLUMN_DEFAULT_);
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
			case PRIMARY_KEY_COLUMN:
				return PRIMARY_KEY_COLUMN_DEFAULT_ == null ? primaryKeyColumn != null : !PRIMARY_KEY_COLUMN_DEFAULT_.equals(primaryKeyColumn);
			case FOREIGN_KEY_COLUMN:
				return FOREIGN_KEY_COLUMN_DEFAULT_ == null ? foreignKeyColumn != null : !FOREIGN_KEY_COLUMN_DEFAULT_.equals(foreignKeyColumn);
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
		result.append(" (primaryKeyColumn: ");
		result.append(primaryKeyColumn);
		result.append(", foreignKeyColumn: ");
		result.append(foreignKeyColumn);
		result.append(')');
		return result.toString();
	}

} //KeyPairImpl
