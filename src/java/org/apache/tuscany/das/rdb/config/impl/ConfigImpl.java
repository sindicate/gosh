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

import org.apache.tuscany.das.rdb.config.Command;
import org.apache.tuscany.das.rdb.config.Config;
import org.apache.tuscany.das.rdb.config.ConfigFactory;
import org.apache.tuscany.das.rdb.config.ConnectionInfo;
import org.apache.tuscany.das.rdb.config.Relationship;
import org.apache.tuscany.das.rdb.config.Table;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.ConfigImpl#getCommand <em>Command</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.ConfigImpl#getTable <em>Table</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.ConfigImpl#getRelationship <em>Relationship</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.ConfigImpl#getConnectionInfo <em>Connection Info</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.ConfigImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.ConfigImpl#getDataObjectModel <em>Data Object Model</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.ConfigImpl#isDatabaseSchemaNameSupported <em>Database Schema Name Supported</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.ConfigImpl#getGeneratedKeysSupported <em>Generated Keys Supported</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigImpl extends DataObjectBase implements Config
{

	public final static int COMMAND = 0;

	public final static int TABLE = 1;

	public final static int RELATIONSHIP = 2;

	public final static int CONNECTION_INFO = 3;

	public final static int URI = 4;

	public final static int DATA_OBJECT_MODEL = 5;

	public final static int DATABASE_SCHEMA_NAME_SUPPORTED = 6;

	public final static int GENERATED_KEYS_SUPPORTED = 7;

	public final static int SDO_PROPERTY_COUNT = 8;

	public final static int EXTENDED_PROPERTY_COUNT = 0;


	/**
	 * The internal feature id for the '<em><b>Command</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_COMMAND = 0;

	/**
	 * The internal feature id for the '<em><b>Table</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_TABLE = 1;

	/**
	 * The internal feature id for the '<em><b>Relationship</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_RELATIONSHIP = 2;

	/**
	 * The internal feature id for the '<em><b>Connection Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_CONNECTION_INFO = 3;

	/**
	 * The internal feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_URI = 4;

	/**
	 * The internal feature id for the '<em><b>Data Object Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_DATA_OBJECT_MODEL = 5;

	/**
	 * The internal feature id for the '<em><b>Database Schema Name Supported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_DATABASE_SCHEMA_NAME_SUPPORTED = 6;

	/**
	 * The internal feature id for the '<em><b>Generated Keys Supported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_GENERATED_KEYS_SUPPORTED = 7;

	/**
	 * The number of properties for this type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public final static int INTERNAL_PROPERTY_COUNT = 8;

	protected int internalConvertIndex(int internalIndex)
	{
		switch (internalIndex)
		{
			case INTERNAL_COMMAND: return COMMAND;
			case INTERNAL_TABLE: return TABLE;
			case INTERNAL_RELATIONSHIP: return RELATIONSHIP;
			case INTERNAL_CONNECTION_INFO: return CONNECTION_INFO;
			case INTERNAL_URI: return URI;
			case INTERNAL_DATA_OBJECT_MODEL: return DATA_OBJECT_MODEL;
			case INTERNAL_DATABASE_SCHEMA_NAME_SUPPORTED: return DATABASE_SCHEMA_NAME_SUPPORTED;
			case INTERNAL_GENERATED_KEYS_SUPPORTED: return GENERATED_KEYS_SUPPORTED;
		}
		return super.internalConvertIndex(internalIndex);
	}


	/**
	 * The cached value of the '{@link #getCommand() <em>Command</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommand()
	 * @generated
	 * @ordered
	 */
	
	protected List command = null;
	
	/**
	 * The cached value of the '{@link #getTable() <em>Table</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTable()
	 * @generated
	 * @ordered
	 */
	
	protected List table = null;
	
	/**
	 * The cached value of the '{@link #getRelationship() <em>Relationship</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelationship()
	 * @generated
	 * @ordered
	 */
	
	protected List relationship = null;
	
	/**
	 * The cached value of the '{@link #getConnectionInfo() <em>Connection Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionInfo()
	 * @generated
	 * @ordered
	 */
	
	protected ConnectionInfo connectionInfo = null;
	
	/**
	 * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_DEFAULT_ = null;

	/**
	 * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected String uri = URI_DEFAULT_;

	/**
	 * The default value of the '{@link #getDataObjectModel() <em>Data Object Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataObjectModel()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_OBJECT_MODEL_DEFAULT_ = null;

	/**
	 * The cached value of the '{@link #getDataObjectModel() <em>Data Object Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataObjectModel()
	 * @generated
	 * @ordered
	 */
	protected String dataObjectModel = DATA_OBJECT_MODEL_DEFAULT_;

	/**
	 * The default value of the '{@link #isDatabaseSchemaNameSupported() <em>Database Schema Name Supported</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDatabaseSchemaNameSupported()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DATABASE_SCHEMA_NAME_SUPPORTED_DEFAULT_ = false;

	/**
	 * The cached value of the '{@link #isDatabaseSchemaNameSupported() <em>Database Schema Name Supported</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDatabaseSchemaNameSupported()
	 * @generated
	 * @ordered
	 */
	protected boolean databaseSchemaNameSupported = DATABASE_SCHEMA_NAME_SUPPORTED_DEFAULT_;

	/**
	 * The default value of the '{@link #getGeneratedKeysSupported() <em>Generated Keys Supported</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneratedKeysSupported()
	 * @generated
	 * @ordered
	 */
	protected static final String GENERATED_KEYS_SUPPORTED_DEFAULT_ = null;

	/**
	 * The cached value of the '{@link #getGeneratedKeysSupported() <em>Generated Keys Supported</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneratedKeysSupported()
	 * @generated
	 * @ordered
	 */
	protected String generatedKeysSupported = GENERATED_KEYS_SUPPORTED_DEFAULT_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigImpl()
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
		return ((ConfigFactoryImpl)ConfigFactory.INSTANCE).getConfig();
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
	public List getCommand()
	{
		if (command == null)
		{
		  command = createPropertyList(ListKind.CONTAINMENT, Command.class, COMMAND, 0);
		}
		return command;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getTable()
	{
		if (table == null)
		{
		  table = createPropertyList(ListKind.CONTAINMENT, Table.class, TABLE, 0);
		}
		return table;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getRelationship()
	{
		if (relationship == null)
		{
		  relationship = createPropertyList(ListKind.CONTAINMENT, Relationship.class, RELATIONSHIP, 0);
		}
		return relationship;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionInfo getConnectionInfo()
	{
		return connectionInfo;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeContext basicSetConnectionInfo(ConnectionInfo newConnectionInfo, ChangeContext changeContext)
	{
		ConnectionInfo oldConnectionInfo = connectionInfo;
		connectionInfo = newConnectionInfo;
		return changeContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionInfo(ConnectionInfo newConnectionInfo)
	{
		if (newConnectionInfo != connectionInfo)
		{
			ChangeContext changeContext = null;
			if (connectionInfo != null)
				changeContext = inverseRemove(connectionInfo, this, OPPOSITE_FEATURE_BASE - INTERNAL_CONNECTION_INFO, null, changeContext);
			if (newConnectionInfo != null)
				changeContext = inverseAdd(newConnectionInfo, this, OPPOSITE_FEATURE_BASE - INTERNAL_CONNECTION_INFO, null, changeContext);
			changeContext = basicSetConnectionInfo(newConnectionInfo, changeContext);
			if (changeContext != null) dispatch(changeContext);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUri()
	{
		return uri;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUri(String newUri)
	{
		uri = newUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDataObjectModel()
	{
		return dataObjectModel;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataObjectModel(String newDataObjectModel)
	{
		dataObjectModel = newDataObjectModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDatabaseSchemaNameSupported()
	{
		return databaseSchemaNameSupported;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDatabaseSchemaNameSupported(boolean newDatabaseSchemaNameSupported)
	{
		databaseSchemaNameSupported = newDatabaseSchemaNameSupported;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGeneratedKeysSupported()
	{
		return generatedKeysSupported;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeneratedKeysSupported(String newGeneratedKeysSupported)
	{
		generatedKeysSupported = newGeneratedKeysSupported;
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
			case COMMAND:
				return removeFromList(getCommand(), otherEnd, changeContext);
			case TABLE:
				return removeFromList(getTable(), otherEnd, changeContext);
			case RELATIONSHIP:
				return removeFromList(getRelationship(), otherEnd, changeContext);
			case CONNECTION_INFO:
				return basicSetConnectionInfo(null, changeContext);
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
			case COMMAND:
				return getCommand();
			case TABLE:
				return getTable();
			case RELATIONSHIP:
				return getRelationship();
			case CONNECTION_INFO:
				return getConnectionInfo();
			case URI:
				return getUri();
			case DATA_OBJECT_MODEL:
				return getDataObjectModel();
			case DATABASE_SCHEMA_NAME_SUPPORTED:
				return isDatabaseSchemaNameSupported() ? Boolean.TRUE : Boolean.FALSE;
			case GENERATED_KEYS_SUPPORTED:
				return getGeneratedKeysSupported();
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
			case COMMAND:
				getCommand().clear();
				getCommand().addAll((Collection)newValue);
				return;
			case TABLE:
				getTable().clear();
				getTable().addAll((Collection)newValue);
				return;
			case RELATIONSHIP:
				getRelationship().clear();
				getRelationship().addAll((Collection)newValue);
				return;
			case CONNECTION_INFO:
				setConnectionInfo((ConnectionInfo)newValue);
				return;
			case URI:
				setUri((String)newValue);
				return;
			case DATA_OBJECT_MODEL:
				setDataObjectModel((String)newValue);
				return;
			case DATABASE_SCHEMA_NAME_SUPPORTED:
				setDatabaseSchemaNameSupported(((Boolean)newValue).booleanValue());
				return;
			case GENERATED_KEYS_SUPPORTED:
				setGeneratedKeysSupported((String)newValue);
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
			case COMMAND:
				getCommand().clear();
				return;
			case TABLE:
				getTable().clear();
				return;
			case RELATIONSHIP:
				getRelationship().clear();
				return;
			case CONNECTION_INFO:
				setConnectionInfo((ConnectionInfo)null);
				return;
			case URI:
				setUri(URI_DEFAULT_);
				return;
			case DATA_OBJECT_MODEL:
				setDataObjectModel(DATA_OBJECT_MODEL_DEFAULT_);
				return;
			case DATABASE_SCHEMA_NAME_SUPPORTED:
				setDatabaseSchemaNameSupported(DATABASE_SCHEMA_NAME_SUPPORTED_DEFAULT_);
				return;
			case GENERATED_KEYS_SUPPORTED:
				setGeneratedKeysSupported(GENERATED_KEYS_SUPPORTED_DEFAULT_);
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
			case COMMAND:
				return command != null && !command.isEmpty();
			case TABLE:
				return table != null && !table.isEmpty();
			case RELATIONSHIP:
				return relationship != null && !relationship.isEmpty();
			case CONNECTION_INFO:
				return connectionInfo != null;
			case URI:
				return URI_DEFAULT_ == null ? uri != null : !URI_DEFAULT_.equals(uri);
			case DATA_OBJECT_MODEL:
				return DATA_OBJECT_MODEL_DEFAULT_ == null ? dataObjectModel != null : !DATA_OBJECT_MODEL_DEFAULT_.equals(dataObjectModel);
			case DATABASE_SCHEMA_NAME_SUPPORTED:
				return databaseSchemaNameSupported != DATABASE_SCHEMA_NAME_SUPPORTED_DEFAULT_;
			case GENERATED_KEYS_SUPPORTED:
				return GENERATED_KEYS_SUPPORTED_DEFAULT_ == null ? generatedKeysSupported != null : !GENERATED_KEYS_SUPPORTED_DEFAULT_.equals(generatedKeysSupported);
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
		result.append(" (uri: ");
		result.append(uri);
		result.append(", dataObjectModel: ");
		result.append(dataObjectModel);
		result.append(", databaseSchemaNameSupported: ");
		result.append(databaseSchemaNameSupported);
		result.append(", generatedKeysSupported: ");
		result.append(generatedKeysSupported);
		result.append(')');
		return result.toString();
	}

} //ConfigImpl
