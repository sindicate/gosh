/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.das.rdb.config.impl;

import commonj.sdo.Type;

import java.util.Collection;
import java.util.List;

import org.apache.tuscany.das.rdb.config.Column;
import org.apache.tuscany.das.rdb.config.ConfigFactory;
import org.apache.tuscany.das.rdb.config.Create;
import org.apache.tuscany.das.rdb.config.Delete;
import org.apache.tuscany.das.rdb.config.Table;
import org.apache.tuscany.das.rdb.config.Update;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.TableImpl#getColumn <em>Column</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.TableImpl#getCreate <em>Create</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.TableImpl#getUpdate <em>Update</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.TableImpl#getDelete <em>Delete</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.TableImpl#getTableName <em>Table Name</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.TableImpl#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.TableImpl#getSchemaName <em>Schema Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TableImpl extends DataObjectBase implements Table
{

	public final static int COLUMN = 0;

	public final static int CREATE = 1;

	public final static int UPDATE = 2;

	public final static int DELETE = 3;

	public final static int TABLE_NAME = 4;

	public final static int TYPE_NAME = 5;

	public final static int SCHEMA_NAME = 6;

	public final static int SDO_PROPERTY_COUNT = 7;

	public final static int EXTENDED_PROPERTY_COUNT = 0;


	/**
	 * The internal feature id for the '<em><b>Column</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_COLUMN = 0;

	/**
	 * The internal feature id for the '<em><b>Create</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_CREATE = 1;

	/**
	 * The internal feature id for the '<em><b>Update</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_UPDATE = 2;

	/**
	 * The internal feature id for the '<em><b>Delete</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_DELETE = 3;

	/**
	 * The internal feature id for the '<em><b>Table Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_TABLE_NAME = 4;

	/**
	 * The internal feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_TYPE_NAME = 5;

	/**
	 * The internal feature id for the '<em><b>Schema Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_SCHEMA_NAME = 6;

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
			case INTERNAL_COLUMN: return COLUMN;
			case INTERNAL_CREATE: return CREATE;
			case INTERNAL_UPDATE: return UPDATE;
			case INTERNAL_DELETE: return DELETE;
			case INTERNAL_TABLE_NAME: return TABLE_NAME;
			case INTERNAL_TYPE_NAME: return TYPE_NAME;
			case INTERNAL_SCHEMA_NAME: return SCHEMA_NAME;
		}
		return super.internalConvertIndex(internalIndex);
	}


	/**
	 * The cached value of the '{@link #getColumn() <em>Column</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumn()
	 * @generated
	 * @ordered
	 */
	
	protected List column = null;
	
	/**
	 * The cached value of the '{@link #getCreate() <em>Create</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreate()
	 * @generated
	 * @ordered
	 */
	
	protected Create create = null;
	
	/**
	 * The cached value of the '{@link #getUpdate() <em>Update</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpdate()
	 * @generated
	 * @ordered
	 */
	
	protected Update update = null;
	
	/**
	 * The cached value of the '{@link #getDelete() <em>Delete</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelete()
	 * @generated
	 * @ordered
	 */
	
	protected Delete delete = null;
	
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
	 * The default value of the '{@link #getTypeName() <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeName()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_NAME_DEFAULT_ = null;

	/**
	 * The cached value of the '{@link #getTypeName() <em>Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeName()
	 * @generated
	 * @ordered
	 */
	protected String typeName = TYPE_NAME_DEFAULT_;

	/**
	 * The default value of the '{@link #getSchemaName() <em>Schema Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchemaName()
	 * @generated
	 * @ordered
	 */
	protected static final String SCHEMA_NAME_DEFAULT_ = "";

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableImpl()
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
		return ((ConfigFactoryImpl)ConfigFactory.INSTANCE).getTable();
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
	public List getColumn()
	{
		if (column == null)
		{
		  column = createPropertyList(ListKind.CONTAINMENT, Column.class, COLUMN, 0);
		}
		return column;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Create getCreate()
	{
		return create;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeContext basicSetCreate(Create newCreate, ChangeContext changeContext)
	{
		Create oldCreate = create;
		create = newCreate;
		return changeContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreate(Create newCreate)
	{
		if (newCreate != create)
		{
			ChangeContext changeContext = null;
			if (create != null)
				changeContext = inverseRemove(create, this, OPPOSITE_FEATURE_BASE - INTERNAL_CREATE, null, changeContext);
			if (newCreate != null)
				changeContext = inverseAdd(newCreate, this, OPPOSITE_FEATURE_BASE - INTERNAL_CREATE, null, changeContext);
			changeContext = basicSetCreate(newCreate, changeContext);
			if (changeContext != null) dispatch(changeContext);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Update getUpdate()
	{
		return update;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeContext basicSetUpdate(Update newUpdate, ChangeContext changeContext)
	{
		Update oldUpdate = update;
		update = newUpdate;
		return changeContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpdate(Update newUpdate)
	{
		if (newUpdate != update)
		{
			ChangeContext changeContext = null;
			if (update != null)
				changeContext = inverseRemove(update, this, OPPOSITE_FEATURE_BASE - INTERNAL_UPDATE, null, changeContext);
			if (newUpdate != null)
				changeContext = inverseAdd(newUpdate, this, OPPOSITE_FEATURE_BASE - INTERNAL_UPDATE, null, changeContext);
			changeContext = basicSetUpdate(newUpdate, changeContext);
			if (changeContext != null) dispatch(changeContext);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Delete getDelete()
	{
		return delete;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeContext basicSetDelete(Delete newDelete, ChangeContext changeContext)
	{
		Delete oldDelete = delete;
		delete = newDelete;
		return changeContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDelete(Delete newDelete)
	{
		if (newDelete != delete)
		{
			ChangeContext changeContext = null;
			if (delete != null)
				changeContext = inverseRemove(delete, this, OPPOSITE_FEATURE_BASE - INTERNAL_DELETE, null, changeContext);
			if (newDelete != null)
				changeContext = inverseAdd(newDelete, this, OPPOSITE_FEATURE_BASE - INTERNAL_DELETE, null, changeContext);
			changeContext = basicSetDelete(newDelete, changeContext);
			if (changeContext != null) dispatch(changeContext);
		}
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
	public String getTypeName()
	{
		return typeName;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeName(String newTypeName)
	{
		typeName = newTypeName;
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
	public ChangeContext inverseRemove(Object otherEnd, int propertyIndex, ChangeContext changeContext)
	{
		switch (propertyIndex)
		{
			case COLUMN:
				return removeFromList(getColumn(), otherEnd, changeContext);
			case CREATE:
				return basicSetCreate(null, changeContext);
			case UPDATE:
				return basicSetUpdate(null, changeContext);
			case DELETE:
				return basicSetDelete(null, changeContext);
		}
		return super.inverseRemove(otherEnd, propertyIndex, changeContext);
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
			case COLUMN:
				return getColumn();
			case CREATE:
				return getCreate();
			case UPDATE:
				return getUpdate();
			case DELETE:
				return getDelete();
			case TABLE_NAME:
				return getTableName();
			case TYPE_NAME:
				return getTypeName();
			case SCHEMA_NAME:
				return getSchemaName();
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
			case COLUMN:
				getColumn().clear();
				getColumn().addAll((Collection)newValue);
				return;
			case CREATE:
				setCreate((Create)newValue);
				return;
			case UPDATE:
				setUpdate((Update)newValue);
				return;
			case DELETE:
				setDelete((Delete)newValue);
				return;
			case TABLE_NAME:
				setTableName((String)newValue);
				return;
			case TYPE_NAME:
				setTypeName((String)newValue);
				return;
			case SCHEMA_NAME:
				setSchemaName((String)newValue);
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
			case COLUMN:
				getColumn().clear();
				return;
			case CREATE:
				setCreate((Create)null);
				return;
			case UPDATE:
				setUpdate((Update)null);
				return;
			case DELETE:
				setDelete((Delete)null);
				return;
			case TABLE_NAME:
				setTableName(TABLE_NAME_DEFAULT_);
				return;
			case TYPE_NAME:
				setTypeName(TYPE_NAME_DEFAULT_);
				return;
			case SCHEMA_NAME:
				setSchemaName(SCHEMA_NAME_DEFAULT_);
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
			case COLUMN:
				return column != null && !column.isEmpty();
			case CREATE:
				return create != null;
			case UPDATE:
				return update != null;
			case DELETE:
				return delete != null;
			case TABLE_NAME:
				return TABLE_NAME_DEFAULT_ == null ? tableName != null : !TABLE_NAME_DEFAULT_.equals(tableName);
			case TYPE_NAME:
				return TYPE_NAME_DEFAULT_ == null ? typeName != null : !TYPE_NAME_DEFAULT_.equals(typeName);
			case SCHEMA_NAME:
				return SCHEMA_NAME_DEFAULT_ == null ? schemaName != null : !SCHEMA_NAME_DEFAULT_.equals(schemaName);
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
		result.append(" (tableName: ");
		result.append(tableName);
		result.append(", typeName: ");
		result.append(typeName);
		result.append(", schemaName: ");
		result.append(schemaName);
		result.append(')');
		return result.toString();
	}

} //TableImpl
