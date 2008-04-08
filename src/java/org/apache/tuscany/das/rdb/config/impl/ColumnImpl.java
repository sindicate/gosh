/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.das.rdb.config.impl;

import commonj.sdo.Type;

import org.apache.tuscany.das.rdb.config.Column;
import org.apache.tuscany.das.rdb.config.ConfigFactory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Column</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.ColumnImpl#getColumnName <em>Column Name</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.ColumnImpl#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.ColumnImpl#getConverterClassName <em>Converter Class Name</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.ColumnImpl#isPrimaryKey <em>Primary Key</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.ColumnImpl#isGenerated <em>Generated</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.ColumnImpl#isCollision <em>Collision</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.ColumnImpl#isManaged <em>Managed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ColumnImpl extends DataObjectBase implements Column
{

	public final static int COLUMN_NAME = 0;

	public final static int PROPERTY_NAME = 1;

	public final static int CONVERTER_CLASS_NAME = 2;

	public final static int PRIMARY_KEY = 3;

	public final static int GENERATED = 4;

	public final static int COLLISION = 5;

	public final static int MANAGED = 6;

	public final static int SDO_PROPERTY_COUNT = 7;

	public final static int EXTENDED_PROPERTY_COUNT = 0;


	/**
	 * The internal feature id for the '<em><b>Column Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_COLUMN_NAME = 0;

	/**
	 * The internal feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_PROPERTY_NAME = 1;

	/**
	 * The internal feature id for the '<em><b>Converter Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_CONVERTER_CLASS_NAME = 2;

	/**
	 * The internal feature id for the '<em><b>Primary Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_PRIMARY_KEY = 3;

	/**
	 * The internal feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_GENERATED = 4;

	/**
	 * The internal feature id for the '<em><b>Collision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_COLLISION = 5;

	/**
	 * The internal feature id for the '<em><b>Managed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_MANAGED = 6;

	/**
	 * The number of properties for this type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public final static int INTERNAL_PROPERTY_COUNT = 7;

	protected int internalConvertIndex(int internalIndex)
	{
		switch (internalIndex)
		{
			case INTERNAL_COLUMN_NAME: return COLUMN_NAME;
			case INTERNAL_PROPERTY_NAME: return PROPERTY_NAME;
			case INTERNAL_CONVERTER_CLASS_NAME: return CONVERTER_CLASS_NAME;
			case INTERNAL_PRIMARY_KEY: return PRIMARY_KEY;
			case INTERNAL_GENERATED: return GENERATED;
			case INTERNAL_COLLISION: return COLLISION;
			case INTERNAL_MANAGED: return MANAGED;
		}
		return super.internalConvertIndex(internalIndex);
	}


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
	 * The default value of the '{@link #getPropertyName() <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROPERTY_NAME_DEFAULT_ = null;

	/**
	 * The cached value of the '{@link #getPropertyName() <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyName()
	 * @generated
	 * @ordered
	 */
	protected String propertyName = PROPERTY_NAME_DEFAULT_;

	/**
	 * The default value of the '{@link #getConverterClassName() <em>Converter Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConverterClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String CONVERTER_CLASS_NAME_DEFAULT_ = null;

	/**
	 * The cached value of the '{@link #getConverterClassName() <em>Converter Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConverterClassName()
	 * @generated
	 * @ordered
	 */
	protected String converterClassName = CONVERTER_CLASS_NAME_DEFAULT_;

	/**
	 * The default value of the '{@link #isPrimaryKey() <em>Primary Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrimaryKey()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PRIMARY_KEY_DEFAULT_ = false;

	/**
	 * The cached value of the '{@link #isPrimaryKey() <em>Primary Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrimaryKey()
	 * @generated
	 * @ordered
	 */
	protected boolean primaryKey = PRIMARY_KEY_DEFAULT_;

	/**
	 * The default value of the '{@link #isGenerated() <em>Generated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGenerated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GENERATED_DEFAULT_ = false;

	/**
	 * The cached value of the '{@link #isGenerated() <em>Generated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGenerated()
	 * @generated
	 * @ordered
	 */
	protected boolean generated = GENERATED_DEFAULT_;

	/**
	 * The default value of the '{@link #isCollision() <em>Collision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCollision()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COLLISION_DEFAULT_ = false;

	/**
	 * The cached value of the '{@link #isCollision() <em>Collision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCollision()
	 * @generated
	 * @ordered
	 */
	protected boolean collision = COLLISION_DEFAULT_;

	/**
	 * The default value of the '{@link #isManaged() <em>Managed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isManaged()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MANAGED_DEFAULT_ = true;

	/**
	 * The cached value of the '{@link #isManaged() <em>Managed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isManaged()
	 * @generated
	 * @ordered
	 */
	protected boolean managed = MANAGED_DEFAULT_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColumnImpl()
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
		return ((ConfigFactoryImpl)ConfigFactory.INSTANCE).getColumn();
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
	public String getPropertyName()
	{
		return propertyName;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyName(String newPropertyName)
	{
		propertyName = newPropertyName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConverterClassName()
	{
		return converterClassName;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConverterClassName(String newConverterClassName)
	{
		converterClassName = newConverterClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPrimaryKey()
	{
		return primaryKey;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimaryKey(boolean newPrimaryKey)
	{
		primaryKey = newPrimaryKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGenerated()
	{
		return generated;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenerated(boolean newGenerated)
	{
		generated = newGenerated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCollision()
	{
		return collision;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCollision(boolean newCollision)
	{
		collision = newCollision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isManaged()
	{
		return managed;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManaged(boolean newManaged)
	{
		managed = newManaged;
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
			case COLUMN_NAME:
				return getColumnName();
			case PROPERTY_NAME:
				return getPropertyName();
			case CONVERTER_CLASS_NAME:
				return getConverterClassName();
			case PRIMARY_KEY:
				return isPrimaryKey() ? Boolean.TRUE : Boolean.FALSE;
			case GENERATED:
				return isGenerated() ? Boolean.TRUE : Boolean.FALSE;
			case COLLISION:
				return isCollision() ? Boolean.TRUE : Boolean.FALSE;
			case MANAGED:
				return isManaged() ? Boolean.TRUE : Boolean.FALSE;
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
			case COLUMN_NAME:
				setColumnName((String)newValue);
				return;
			case PROPERTY_NAME:
				setPropertyName((String)newValue);
				return;
			case CONVERTER_CLASS_NAME:
				setConverterClassName((String)newValue);
				return;
			case PRIMARY_KEY:
				setPrimaryKey(((Boolean)newValue).booleanValue());
				return;
			case GENERATED:
				setGenerated(((Boolean)newValue).booleanValue());
				return;
			case COLLISION:
				setCollision(((Boolean)newValue).booleanValue());
				return;
			case MANAGED:
				setManaged(((Boolean)newValue).booleanValue());
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
			case COLUMN_NAME:
				setColumnName(COLUMN_NAME_DEFAULT_);
				return;
			case PROPERTY_NAME:
				setPropertyName(PROPERTY_NAME_DEFAULT_);
				return;
			case CONVERTER_CLASS_NAME:
				setConverterClassName(CONVERTER_CLASS_NAME_DEFAULT_);
				return;
			case PRIMARY_KEY:
				setPrimaryKey(PRIMARY_KEY_DEFAULT_);
				return;
			case GENERATED:
				setGenerated(GENERATED_DEFAULT_);
				return;
			case COLLISION:
				setCollision(COLLISION_DEFAULT_);
				return;
			case MANAGED:
				setManaged(MANAGED_DEFAULT_);
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
			case COLUMN_NAME:
				return COLUMN_NAME_DEFAULT_ == null ? columnName != null : !COLUMN_NAME_DEFAULT_.equals(columnName);
			case PROPERTY_NAME:
				return PROPERTY_NAME_DEFAULT_ == null ? propertyName != null : !PROPERTY_NAME_DEFAULT_.equals(propertyName);
			case CONVERTER_CLASS_NAME:
				return CONVERTER_CLASS_NAME_DEFAULT_ == null ? converterClassName != null : !CONVERTER_CLASS_NAME_DEFAULT_.equals(converterClassName);
			case PRIMARY_KEY:
				return primaryKey != PRIMARY_KEY_DEFAULT_;
			case GENERATED:
				return generated != GENERATED_DEFAULT_;
			case COLLISION:
				return collision != COLLISION_DEFAULT_;
			case MANAGED:
				return managed != MANAGED_DEFAULT_;
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
		result.append(" (columnName: ");
		result.append(columnName);
		result.append(", propertyName: ");
		result.append(propertyName);
		result.append(", converterClassName: ");
		result.append(converterClassName);
		result.append(", primaryKey: ");
		result.append(primaryKey);
		result.append(", generated: ");
		result.append(generated);
		result.append(", collision: ");
		result.append(collision);
		result.append(", managed: ");
		result.append(managed);
		result.append(')');
		return result.toString();
	}

} //ColumnImpl
