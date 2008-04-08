/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.das.rdb.config.impl;

import commonj.sdo.Type;

import org.apache.tuscany.das.rdb.config.ConfigFactory;
import org.apache.tuscany.das.rdb.config.ResultDescriptor;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.ResultDescriptorImpl#getColumnIndex <em>Column Index</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.ResultDescriptorImpl#getColumnName <em>Column Name</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.ResultDescriptorImpl#getTableName <em>Table Name</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.ResultDescriptorImpl#getSchemaName <em>Schema Name</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.ResultDescriptorImpl#getColumnType <em>Column Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResultDescriptorImpl extends DataObjectBase implements ResultDescriptor
{

	public final static int COLUMN_INDEX = 0;

	public final static int COLUMN_NAME = 1;

	public final static int TABLE_NAME = 2;

	public final static int SCHEMA_NAME = 3;

	public final static int COLUMN_TYPE = 4;

	public final static int SDO_PROPERTY_COUNT = 5;

	public final static int EXTENDED_PROPERTY_COUNT = 0;


	/**
	 * The internal feature id for the '<em><b>Column Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_COLUMN_INDEX = 0;

	/**
	 * The internal feature id for the '<em><b>Column Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_COLUMN_NAME = 1;

	/**
	 * The internal feature id for the '<em><b>Table Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_TABLE_NAME = 2;

	/**
	 * The internal feature id for the '<em><b>Schema Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_SCHEMA_NAME = 3;

	/**
	 * The internal feature id for the '<em><b>Column Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_COLUMN_TYPE = 4;

	/**
	 * The number of properties for this type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public final static int INTERNAL_PROPERTY_COUNT = 5;

	protected int internalConvertIndex(int internalIndex)
	{
		switch (internalIndex)
		{
			case INTERNAL_COLUMN_INDEX: return COLUMN_INDEX;
			case INTERNAL_COLUMN_NAME: return COLUMN_NAME;
			case INTERNAL_TABLE_NAME: return TABLE_NAME;
			case INTERNAL_SCHEMA_NAME: return SCHEMA_NAME;
			case INTERNAL_COLUMN_TYPE: return COLUMN_TYPE;
		}
		return super.internalConvertIndex(internalIndex);
	}


	/**
	 * The default value of the '{@link #getColumnIndex() <em>Column Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumnIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int COLUMN_INDEX_DEFAULT_ = -1;

	/**
	 * The cached value of the '{@link #getColumnIndex() <em>Column Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumnIndex()
	 * @generated
	 * @ordered
	 */
	protected int columnIndex = COLUMN_INDEX_DEFAULT_;

	/**
	 * The default value of the '{@link #getColumnName() <em>Column Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumnName()
	 * @generated
	 * @ordered
	 */
	protected static final String COLUMN_NAME_DEFAULT_ = null;

	/**
	 * The cached value of the '{@link #getColumnName() <em>Column Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumnName()
	 * @generated
	 * @ordered
	 */
	protected String columnName = COLUMN_NAME_DEFAULT_;

	/**
	 * The default value of the '{@link #getTableName() <em>Table Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTableName()
	 * @generated
	 * @ordered
	 */
	protected static final String TABLE_NAME_DEFAULT_ = null;

	/**
	 * The cached value of the '{@link #getTableName() <em>Table Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTableName()
	 * @generated
	 * @ordered
	 */
	protected String tableName = TABLE_NAME_DEFAULT_;

	/**
	 * The default value of the '{@link #getSchemaName() <em>Schema Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchemaName()
	 * @generated
	 * @ordered
	 */
	protected static final String SCHEMA_NAME_DEFAULT_ = null;

	/**
	 * The cached value of the '{@link #getSchemaName() <em>Schema Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchemaName()
	 * @generated
	 * @ordered
	 */
	protected String schemaName = SCHEMA_NAME_DEFAULT_;

	/**
	 * The default value of the '{@link #getColumnType() <em>Column Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumnType()
	 * @generated
	 * @ordered
	 */
	protected static final String COLUMN_TYPE_DEFAULT_ = null;

	/**
	 * The cached value of the '{@link #getColumnType() <em>Column Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumnType()
	 * @generated
	 * @ordered
	 */
	protected String columnType = COLUMN_TYPE_DEFAULT_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultDescriptorImpl()
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
		return ((ConfigFactoryImpl)ConfigFactory.INSTANCE).getResultDescriptor();
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
	public int getColumnIndex()
	{
		return columnIndex;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColumnIndex(int newColumnIndex)
	{
		columnIndex = newColumnIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getColumnName()
	{
		return columnName;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColumnName(String newColumnName)
	{
		columnName = newColumnName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTableName()
	{
		return tableName;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTableName(String newTableName)
	{
		tableName = newTableName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSchemaName()
	{
		return schemaName;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchemaName(String newSchemaName)
	{
		schemaName = newSchemaName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getColumnType()
	{
		return columnType;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColumnType(String newColumnType)
	{
		columnType = newColumnType;
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
			case COLUMN_INDEX:
				return new Integer(getColumnIndex());
			case COLUMN_NAME:
				return getColumnName();
			case TABLE_NAME:
				return getTableName();
			case SCHEMA_NAME:
				return getSchemaName();
			case COLUMN_TYPE:
				return getColumnType();
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
			case COLUMN_INDEX:
				setColumnIndex(((Integer)newValue).intValue());
				return;
			case COLUMN_NAME:
				setColumnName((String)newValue);
				return;
			case TABLE_NAME:
				setTableName((String)newValue);
				return;
			case SCHEMA_NAME:
				setSchemaName((String)newValue);
				return;
			case COLUMN_TYPE:
				setColumnType((String)newValue);
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
			case COLUMN_INDEX:
				setColumnIndex(COLUMN_INDEX_DEFAULT_);
				return;
			case COLUMN_NAME:
				setColumnName(COLUMN_NAME_DEFAULT_);
				return;
			case TABLE_NAME:
				setTableName(TABLE_NAME_DEFAULT_);
				return;
			case SCHEMA_NAME:
				setSchemaName(SCHEMA_NAME_DEFAULT_);
				return;
			case COLUMN_TYPE:
				setColumnType(COLUMN_TYPE_DEFAULT_);
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
			case COLUMN_INDEX:
				return columnIndex != COLUMN_INDEX_DEFAULT_;
			case COLUMN_NAME:
				return COLUMN_NAME_DEFAULT_ == null ? columnName != null : !COLUMN_NAME_DEFAULT_.equals(columnName);
			case TABLE_NAME:
				return TABLE_NAME_DEFAULT_ == null ? tableName != null : !TABLE_NAME_DEFAULT_.equals(tableName);
			case SCHEMA_NAME:
				return SCHEMA_NAME_DEFAULT_ == null ? schemaName != null : !SCHEMA_NAME_DEFAULT_.equals(schemaName);
			case COLUMN_TYPE:
				return COLUMN_TYPE_DEFAULT_ == null ? columnType != null : !COLUMN_TYPE_DEFAULT_.equals(columnType);
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
		result.append(" (columnIndex: ");
		result.append(columnIndex);
		result.append(", columnName: ");
		result.append(columnName);
		result.append(", tableName: ");
		result.append(tableName);
		result.append(", schemaName: ");
		result.append(schemaName);
		result.append(", columnType: ");
		result.append(columnType);
		result.append(')');
		return result.toString();
	}

} //ResultDescriptorImpl
