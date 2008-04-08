/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.das.rdb.config.impl;

import commonj.sdo.helper.HelperContext;
import org.apache.tuscany.sdo.helper.HelperContextImpl;
import org.apache.tuscany.sdo.helper.TypeHelperImpl;

import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Type;

import org.apache.tuscany.das.rdb.config.*;

import org.apache.tuscany.sdo.impl.FactoryBase;

import org.apache.tuscany.sdo.model.ModelFactory;

import org.apache.tuscany.sdo.model.impl.ModelFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * Generator information:
 * patternVersion=1.2; -noNotification -noUnsettable
 * <!-- end-user-doc -->
 * @generated
 */
public class ConfigFactoryImpl extends FactoryBase implements ConfigFactory
{

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String NAMESPACE_URI = "http:///org.apache.tuscany.das.rdb/config.xsd";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String NAMESPACE_PREFIX = "config";

	/**
	 * The version of the generator pattern used to generate this class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String PATTERN_VERSION = "1.2";
	
	public static final int COLUMN = 1;	
	public static final int COMMAND = 2;	
	public static final int CONFIG = 3;	
	public static final int CONNECTION_INFO = 4;	
	public static final int CONNECTION_PROPERTIES = 5;	
	public static final int CREATE = 6;	
	public static final int DELETE = 7;	
	public static final int KEY_PAIR = 8;	
	public static final int PARAMETER = 9;	
	public static final int PARAMETERS = 10;	
	public static final int RELATIONSHIP = 11;	
	public static final int RESULT_DESCRIPTOR = 12;	
	public static final int TABLE = 13;	
	public static final int UPDATE = 14;	
	public static final int GENERATED_KEYS_SUPPORTED = 15;
	
	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigFactoryImpl()
	{
		super(NAMESPACE_URI, NAMESPACE_PREFIX, "org.apache.tuscany.das.rdb.config");
	}

	/**
	 * Registers the Factory instance so that it is available within the supplied scope.
   * @argument scope a HelperContext instance that will make the types supported by this Factory available.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void register(HelperContext scope) 
	{
		if(scope == null) {
			throw new IllegalArgumentException("Scope can not be null");
		}

		if (((HelperContextImpl)scope).getExtendedMetaData().getPackage(NAMESPACE_URI) != null)
			return;
    
		// Register this package with provided scope   
		((HelperContextImpl)scope).getExtendedMetaData().putPackage(NAMESPACE_URI, this);
		
		//Register dependent packages with provided scope
		ModelFactory.INSTANCE.register(scope);
  }
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataObject create(int typeNumber)
	{
		switch (typeNumber)
		{
			case COLUMN: return (DataObject)createColumn();
			case COMMAND: return (DataObject)createCommand();
			case CONFIG: return (DataObject)createConfig();
			case CONNECTION_INFO: return (DataObject)createConnectionInfo();
			case CONNECTION_PROPERTIES: return (DataObject)createConnectionProperties();
			case CREATE: return (DataObject)createCreate();
			case DELETE: return (DataObject)createDelete();
			case KEY_PAIR: return (DataObject)createKeyPair();
			case PARAMETER: return (DataObject)createParameter();
			case PARAMETERS: return (DataObject)createParameters();
			case RELATIONSHIP: return (DataObject)createRelationship();
			case RESULT_DESCRIPTOR: return (DataObject)createResultDescriptor();
			case TABLE: return (DataObject)createTable();
			case UPDATE: return (DataObject)createUpdate();
			default:
				return super.create(typeNumber);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromString(int typeNumber, String initialValue)
	{
		switch (typeNumber)
		{
			case GENERATED_KEYS_SUPPORTED:
				return creategeneratedKeysSupportedFromString(initialValue);
			default:
				throw new IllegalArgumentException("The type number '" + typeNumber + "' is not a valid datatype");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(int typeNumber, Object instanceValue)
	{
		switch (typeNumber)
		{
			case GENERATED_KEYS_SUPPORTED:
				return convertgeneratedKeysSupportedToString(instanceValue);
			default:
				throw new IllegalArgumentException("The type number '" + typeNumber + "' is not a valid datatype");
		}
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column createColumn()
	{
		ColumnImpl column = new ColumnImpl();
		return column;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Command createCommand()
	{
		CommandImpl command = new CommandImpl();
		return command;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Config createConfig()
	{
		ConfigImpl config = new ConfigImpl();
		return config;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionInfo createConnectionInfo()
	{
		ConnectionInfoImpl connectionInfo = new ConnectionInfoImpl();
		return connectionInfo;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionProperties createConnectionProperties()
	{
		ConnectionPropertiesImpl connectionProperties = new ConnectionPropertiesImpl();
		return connectionProperties;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Create createCreate()
	{
		CreateImpl create = new CreateImpl();
		return create;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Delete createDelete()
	{
		DeleteImpl delete = new DeleteImpl();
		return delete;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KeyPair createKeyPair()
	{
		KeyPairImpl keyPair = new KeyPairImpl();
		return keyPair;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createParameter()
	{
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameters createParameters()
	{
		ParametersImpl parameters = new ParametersImpl();
		return parameters;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relationship createRelationship()
	{
		RelationshipImpl relationship = new RelationshipImpl();
		return relationship;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultDescriptor createResultDescriptor()
	{
		ResultDescriptorImpl resultDescriptor = new ResultDescriptorImpl();
		return resultDescriptor;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table createTable()
	{
		TableImpl table = new TableImpl();
		return table;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Update createUpdate()
	{
		UpdateImpl update = new UpdateImpl();
		return update;
	}
	
	// Following creates and initializes SDO metadata for the supported types.		
	protected Type columnType = null;

	public Type getColumn()
	{
		return columnType;
	}
		
	protected Type commandType = null;

	public Type getCommand()
	{
		return commandType;
	}
		
	protected Type configType = null;

	public Type getConfig()
	{
		return configType;
	}
		
	protected Type connectionInfoType = null;

	public Type getConnectionInfo()
	{
		return connectionInfoType;
	}
		
	protected Type connectionPropertiesType = null;

	public Type getConnectionProperties()
	{
		return connectionPropertiesType;
	}
		
	protected Type createType = null;

	public Type getCreate()
	{
		return createType;
	}
		
	protected Type deleteType = null;

	public Type getDelete()
	{
		return deleteType;
	}
			
	protected Type keyPairType = null;

	public Type getKeyPair()
	{
		return keyPairType;
	}
		
	protected Type parameterType = null;

	public Type getParameter()
	{
		return parameterType;
	}
		
	protected Type parametersType = null;

	public Type getParameters()
	{
		return parametersType;
	}
		
	protected Type relationshipType = null;

	public Type getRelationship()
	{
		return relationshipType;
	}
		
	protected Type resultDescriptorType = null;

	public Type getResultDescriptor()
	{
		return resultDescriptorType;
	}
		
	protected Type tableType = null;

	public Type getTable()
	{
		return tableType;
	}
		
	protected Type updateType = null;

	public Type getUpdate()
	{
		return updateType;
	}
		
	protected Type generatedKeysSupportedType = null;

	public Type getgeneratedKeysSupported()
	{
		return generatedKeysSupportedType;
	}
	

	private static ConfigFactoryImpl instance = null; 
	public static ConfigFactoryImpl init()
	{
		if (instance != null ) return instance;
		instance = new ConfigFactoryImpl();

		// Create package meta-data objects
		instance.createMetaData();

		// Initialize created meta-data
		instance.initializeMetaData();
		
		// Mark meta-data to indicate it can't be changed
		//theConfigFactoryImpl.freeze(); //FB do we need to freeze / should we freeze ????

		return instance;
	}
  
	private boolean isCreated = false;

	public void createMetaData()
	{
		if (isCreated) return;
		isCreated = true;	

		// Create types and their properties
		columnType = createType(false, COLUMN);
		createProperty(true, columnType,ColumnImpl.INTERNAL_COLUMN_NAME); 
		createProperty(true, columnType,ColumnImpl.INTERNAL_PROPERTY_NAME); 
		createProperty(true, columnType,ColumnImpl.INTERNAL_CONVERTER_CLASS_NAME); 
		createProperty(true, columnType,ColumnImpl.INTERNAL_PRIMARY_KEY); 
		createProperty(true, columnType,ColumnImpl.INTERNAL_GENERATED); 
		createProperty(true, columnType,ColumnImpl.INTERNAL_COLLISION); 
		createProperty(true, columnType,ColumnImpl.INTERNAL_MANAGED); 
		commandType = createType(false, COMMAND);
		createProperty(false, commandType,CommandImpl.INTERNAL_PARAMETER); 
		createProperty(false, commandType,CommandImpl.INTERNAL_RESULT_DESCRIPTOR); 
		createProperty(true, commandType,CommandImpl.INTERNAL_NAME); 
		createProperty(true, commandType,CommandImpl.INTERNAL_SQL); 
		createProperty(true, commandType,CommandImpl.INTERNAL_KIND); 
		configType = createType(false, CONFIG);
		createProperty(false, configType,ConfigImpl.INTERNAL_COMMAND); 
		createProperty(false, configType,ConfigImpl.INTERNAL_TABLE); 
		createProperty(false, configType,ConfigImpl.INTERNAL_RELATIONSHIP); 
		createProperty(false, configType,ConfigImpl.INTERNAL_CONNECTION_INFO); 
		createProperty(true, configType,ConfigImpl.INTERNAL_URI); 
		createProperty(true, configType,ConfigImpl.INTERNAL_DATA_OBJECT_MODEL); 
		createProperty(true, configType,ConfigImpl.INTERNAL_DATABASE_SCHEMA_NAME_SUPPORTED); 
		createProperty(true, configType,ConfigImpl.INTERNAL_GENERATED_KEYS_SUPPORTED); 
		connectionInfoType = createType(false, CONNECTION_INFO);
		createProperty(false, connectionInfoType,ConnectionInfoImpl.INTERNAL_CONNECTION_PROPERTIES); 
		createProperty(true, connectionInfoType,ConnectionInfoImpl.INTERNAL_DATA_SOURCE); 
		createProperty(true, connectionInfoType,ConnectionInfoImpl.INTERNAL_MANAGEDTX); 
		connectionPropertiesType = createType(false, CONNECTION_PROPERTIES);
		createProperty(true, connectionPropertiesType,ConnectionPropertiesImpl.INTERNAL_DRIVER_CLASS); 
		createProperty(true, connectionPropertiesType,ConnectionPropertiesImpl.INTERNAL_DATABASE_URL); 
		createProperty(true, connectionPropertiesType,ConnectionPropertiesImpl.INTERNAL_USER_NAME); 
		createProperty(true, connectionPropertiesType,ConnectionPropertiesImpl.INTERNAL_PASSWORD); 
		createProperty(true, connectionPropertiesType,ConnectionPropertiesImpl.INTERNAL_LOGIN_TIMEOUT); 
		createType = createType(false, CREATE);
		createProperty(false, createType,CreateImpl.INTERNAL_PARAMETERS); 
		createProperty(true, createType,CreateImpl.INTERNAL_SQL); 
		deleteType = createType(false, DELETE);
		createProperty(false, deleteType,DeleteImpl.INTERNAL_PARAMETERS); 
		createProperty(true, deleteType,DeleteImpl.INTERNAL_SQL); 
		keyPairType = createType(false, KEY_PAIR);
		createProperty(true, keyPairType,KeyPairImpl.INTERNAL_PRIMARY_KEY_COLUMN); 
		createProperty(true, keyPairType,KeyPairImpl.INTERNAL_FOREIGN_KEY_COLUMN); 
		parameterType = createType(false, PARAMETER);
		createProperty(true, parameterType,ParameterImpl.INTERNAL_NAME); 
		createProperty(true, parameterType,ParameterImpl.INTERNAL_COLUMN_TYPE); 
		createProperty(true, parameterType,ParameterImpl.INTERNAL_DIRECTION); 
		createProperty(true, parameterType,ParameterImpl.INTERNAL_INDEX); 
		parametersType = createType(false, PARAMETERS);
		createProperty(false, parametersType,ParametersImpl.INTERNAL_PARAMETER); 
		relationshipType = createType(false, RELATIONSHIP);
		createProperty(false, relationshipType,RelationshipImpl.INTERNAL_KEY_PAIR); 
		createProperty(true, relationshipType,RelationshipImpl.INTERNAL_NAME); 
		createProperty(true, relationshipType,RelationshipImpl.INTERNAL_PRIMARY_KEY_TABLE); 
		createProperty(true, relationshipType,RelationshipImpl.INTERNAL_FOREIGN_KEY_TABLE); 
		createProperty(true, relationshipType,RelationshipImpl.INTERNAL_MANY); 
		createProperty(true, relationshipType,RelationshipImpl.INTERNAL_KEY_RESTRICTED); 
		resultDescriptorType = createType(false, RESULT_DESCRIPTOR);
		createProperty(true, resultDescriptorType,ResultDescriptorImpl.INTERNAL_COLUMN_INDEX); 
		createProperty(true, resultDescriptorType,ResultDescriptorImpl.INTERNAL_COLUMN_NAME); 
		createProperty(true, resultDescriptorType,ResultDescriptorImpl.INTERNAL_TABLE_NAME); 
		createProperty(true, resultDescriptorType,ResultDescriptorImpl.INTERNAL_SCHEMA_NAME); 
		createProperty(true, resultDescriptorType,ResultDescriptorImpl.INTERNAL_COLUMN_TYPE); 
		tableType = createType(false, TABLE);
		createProperty(false, tableType,TableImpl.INTERNAL_COLUMN); 
		createProperty(false, tableType,TableImpl.INTERNAL_CREATE); 
		createProperty(false, tableType,TableImpl.INTERNAL_UPDATE); 
		createProperty(false, tableType,TableImpl.INTERNAL_DELETE); 
		createProperty(true, tableType,TableImpl.INTERNAL_TABLE_NAME); 
		createProperty(true, tableType,TableImpl.INTERNAL_TYPE_NAME); 
		createProperty(true, tableType,TableImpl.INTERNAL_SCHEMA_NAME); 
		updateType = createType(false, UPDATE);
		createProperty(false, updateType,UpdateImpl.INTERNAL_PARAMETERS); 
		createProperty(true, updateType,UpdateImpl.INTERNAL_SQL); 

		// Create data types
		generatedKeysSupportedType = createType(true, GENERATED_KEYS_SUPPORTED );
	}
	
	private boolean isInitialized = false;

	public void initializeMetaData()
	{
		if (isInitialized) return;
		isInitialized = true;

		// Obtain other dependent packages
		ModelFactoryImpl theModelPackageImpl = (ModelFactoryImpl)ModelFactoryImpl.init();
		Property property = null;

		// Add supertypes to types

		// Initialize types and properties
		initializeType(columnType, Column.class, "Column", false);
		property = getLocalProperty(columnType, 0);
		initializeProperty(property, theModelPackageImpl.getString(), "columnName", null, 0, 1, Column.class, false, false, false);

		property = getLocalProperty(columnType, 1);
		initializeProperty(property, theModelPackageImpl.getString(), "propertyName", null, 0, 1, Column.class, false, false, false);

		property = getLocalProperty(columnType, 2);
		initializeProperty(property, theModelPackageImpl.getString(), "converterClassName", null, 0, 1, Column.class, false, false, false);

		property = getLocalProperty(columnType, 3);
		initializeProperty(property, theModelPackageImpl.getBoolean(), "primaryKey", null, 0, 1, Column.class, false, false, false);

		property = getLocalProperty(columnType, 4);
		initializeProperty(property, theModelPackageImpl.getBoolean(), "generated", null, 0, 1, Column.class, false, false, false);

		property = getLocalProperty(columnType, 5);
		initializeProperty(property, theModelPackageImpl.getBoolean(), "collision", null, 0, 1, Column.class, false, false, false);

		property = getLocalProperty(columnType, 6);
		initializeProperty(property, theModelPackageImpl.getBoolean(), "managed", "true", 0, 1, Column.class, false, false, false);

		initializeType(commandType, Command.class, "Command", false);
		property = getLocalProperty(commandType, 0);
		initializeProperty(property, this.getParameter(), "Parameter", null, 0, -1, Command.class, false, false, false, true , null);

		property = getLocalProperty(commandType, 1);
		initializeProperty(property, this.getResultDescriptor(), "ResultDescriptor", null, 0, -1, Command.class, false, false, false, true , null);

		property = getLocalProperty(commandType, 2);
		initializeProperty(property, theModelPackageImpl.getString(), "name", null, 0, 1, Command.class, false, false, false);

		property = getLocalProperty(commandType, 3);
		initializeProperty(property, theModelPackageImpl.getString(), "SQL", null, 0, 1, Command.class, false, false, false);

		property = getLocalProperty(commandType, 4);
		initializeProperty(property, theModelPackageImpl.getString(), "kind", null, 0, 1, Command.class, false, false, false);

		initializeType(configType, Config.class, "Config", false);
		property = getLocalProperty(configType, 0);
		initializeProperty(property, this.getCommand(), "Command", null, 0, -1, Config.class, false, false, false, true , null);

		property = getLocalProperty(configType, 1);
		initializeProperty(property, this.getTable(), "Table", null, 0, -1, Config.class, false, false, false, true , null);

		property = getLocalProperty(configType, 2);
		initializeProperty(property, this.getRelationship(), "Relationship", null, 0, -1, Config.class, false, false, false, true , null);

		property = getLocalProperty(configType, 3);
		initializeProperty(property, this.getConnectionInfo(), "ConnectionInfo", null, 0, 1, Config.class, false, false, false, true , null);

		property = getLocalProperty(configType, 4);
		initializeProperty(property, theModelPackageImpl.getString(), "uri", null, 0, 1, Config.class, false, false, false);

		property = getLocalProperty(configType, 5);
		initializeProperty(property, theModelPackageImpl.getString(), "dataObjectModel", null, 0, 1, Config.class, false, false, false);

		property = getLocalProperty(configType, 6);
		initializeProperty(property, theModelPackageImpl.getBoolean(), "databaseSchemaNameSupported", "false", 0, 1, Config.class, false, false, false);

		property = getLocalProperty(configType, 7);
		initializeProperty(property, this.getgeneratedKeysSupported(), "generatedKeysSupported", null, 0, 1, Config.class, false, false, false);

		initializeType(connectionInfoType, ConnectionInfo.class, "ConnectionInfo", false);
		property = getLocalProperty(connectionInfoType, 0);
		initializeProperty(property, this.getConnectionProperties(), "ConnectionProperties", null, 0, 1, ConnectionInfo.class, false, false, false, true , null);

		property = getLocalProperty(connectionInfoType, 1);
		initializeProperty(property, theModelPackageImpl.getString(), "dataSource", null, 0, 1, ConnectionInfo.class, false, false, false);

		property = getLocalProperty(connectionInfoType, 2);
		initializeProperty(property, theModelPackageImpl.getBoolean(), "managedtx", "true", 0, 1, ConnectionInfo.class, false, false, false);

		initializeType(connectionPropertiesType, ConnectionProperties.class, "ConnectionProperties", false);
		property = getLocalProperty(connectionPropertiesType, 0);
		initializeProperty(property, theModelPackageImpl.getString(), "driverClass", null, 0, 1, ConnectionProperties.class, false, false, false);

		property = getLocalProperty(connectionPropertiesType, 1);
		initializeProperty(property, theModelPackageImpl.getString(), "databaseURL", null, 0, 1, ConnectionProperties.class, false, false, false);

		property = getLocalProperty(connectionPropertiesType, 2);
		initializeProperty(property, theModelPackageImpl.getString(), "userName", "", 0, 1, ConnectionProperties.class, false, false, false);

		property = getLocalProperty(connectionPropertiesType, 3);
		initializeProperty(property, theModelPackageImpl.getString(), "password", "", 0, 1, ConnectionProperties.class, false, false, false);

		property = getLocalProperty(connectionPropertiesType, 4);
		initializeProperty(property, theModelPackageImpl.getInt(), "loginTimeout", "0", 0, 1, ConnectionProperties.class, false, false, false);

		initializeType(createType, Create.class, "Create", false);
		property = getLocalProperty(createType, 0);
		initializeProperty(property, this.getParameters(), "Parameters", null, 0, 1, Create.class, false, false, false, true , null);

		property = getLocalProperty(createType, 1);
		initializeProperty(property, theModelPackageImpl.getString(), "sql", null, 0, 1, Create.class, false, false, false);

		initializeType(deleteType, Delete.class, "Delete", false);
		property = getLocalProperty(deleteType, 0);
		initializeProperty(property, this.getParameters(), "Parameters", null, 0, 1, Delete.class, false, false, false, true , null);

		property = getLocalProperty(deleteType, 1);
		initializeProperty(property, theModelPackageImpl.getString(), "sql", null, 0, 1, Delete.class, false, false, false);

		initializeType(keyPairType, KeyPair.class, "KeyPair", false);
		property = getLocalProperty(keyPairType, 0);
		initializeProperty(property, theModelPackageImpl.getString(), "primaryKeyColumn", null, 0, 1, KeyPair.class, false, false, false);

		property = getLocalProperty(keyPairType, 1);
		initializeProperty(property, theModelPackageImpl.getString(), "foreignKeyColumn", null, 0, 1, KeyPair.class, false, false, false);

		initializeType(parameterType, Parameter.class, "Parameter", false);
		property = getLocalProperty(parameterType, 0);
		initializeProperty(property, theModelPackageImpl.getString(), "name", null, 0, 1, Parameter.class, false, false, false);

		property = getLocalProperty(parameterType, 1);
		initializeProperty(property, theModelPackageImpl.getString(), "columnType", null, 0, 1, Parameter.class, false, false, false);

		property = getLocalProperty(parameterType, 2);
		initializeProperty(property, theModelPackageImpl.getString(), "direction", "IN", 0, 1, Parameter.class, false, false, false);

		property = getLocalProperty(parameterType, 3);
		initializeProperty(property, theModelPackageImpl.getInt(), "index", null, 0, 1, Parameter.class, false, false, false);

		initializeType(parametersType, Parameters.class, "Parameters", false);
		property = getLocalProperty(parametersType, 0);
		initializeProperty(property, this.getParameter(), "Parameter", null, 0, -1, Parameters.class, false, false, false, true , null);

		initializeType(relationshipType, Relationship.class, "Relationship", false);
		property = getLocalProperty(relationshipType, 0);
		initializeProperty(property, this.getKeyPair(), "KeyPair", null, 0, -1, Relationship.class, false, false, false, true , null);

		property = getLocalProperty(relationshipType, 1);
		initializeProperty(property, theModelPackageImpl.getString(), "name", null, 0, 1, Relationship.class, false, false, false);

		property = getLocalProperty(relationshipType, 2);
		initializeProperty(property, theModelPackageImpl.getString(), "primaryKeyTable", null, 0, 1, Relationship.class, false, false, false);

		property = getLocalProperty(relationshipType, 3);
		initializeProperty(property, theModelPackageImpl.getString(), "foreignKeyTable", null, 0, 1, Relationship.class, false, false, false);

		property = getLocalProperty(relationshipType, 4);
		initializeProperty(property, theModelPackageImpl.getBoolean(), "many", null, 0, 1, Relationship.class, false, false, false);

		property = getLocalProperty(relationshipType, 5);
		initializeProperty(property, theModelPackageImpl.getBoolean(), "keyRestricted", null, 0, 1, Relationship.class, false, false, false);

		initializeType(resultDescriptorType, ResultDescriptor.class, "ResultDescriptor", false);
		property = getLocalProperty(resultDescriptorType, 0);
		initializeProperty(property, theModelPackageImpl.getInt(), "columnIndex", "-1", 0, 1, ResultDescriptor.class, false, false, false);

		property = getLocalProperty(resultDescriptorType, 1);
		initializeProperty(property, theModelPackageImpl.getString(), "columnName", null, 0, 1, ResultDescriptor.class, false, false, false);

		property = getLocalProperty(resultDescriptorType, 2);
		initializeProperty(property, theModelPackageImpl.getString(), "tableName", null, 0, 1, ResultDescriptor.class, false, false, false);

		property = getLocalProperty(resultDescriptorType, 3);
		initializeProperty(property, theModelPackageImpl.getString(), "schemaName", null, 0, 1, ResultDescriptor.class, false, false, false);

		property = getLocalProperty(resultDescriptorType, 4);
		initializeProperty(property, theModelPackageImpl.getString(), "columnType", null, 0, 1, ResultDescriptor.class, false, false, false);

		initializeType(tableType, Table.class, "Table", false);
		property = getLocalProperty(tableType, 0);
		initializeProperty(property, this.getColumn(), "Column", null, 0, -1, Table.class, false, false, false, true , null);

		property = getLocalProperty(tableType, 1);
		initializeProperty(property, this.getCreate(), "create", null, 0, 1, Table.class, false, false, false, true , null);

		property = getLocalProperty(tableType, 2);
		initializeProperty(property, this.getUpdate(), "update", null, 0, 1, Table.class, false, false, false, true , null);

		property = getLocalProperty(tableType, 3);
		initializeProperty(property, this.getDelete(), "delete", null, 0, 1, Table.class, false, false, false, true , null);

		property = getLocalProperty(tableType, 4);
		initializeProperty(property, theModelPackageImpl.getString(), "tableName", null, 0, 1, Table.class, false, false, false);

		property = getLocalProperty(tableType, 5);
		initializeProperty(property, theModelPackageImpl.getString(), "typeName", null, 0, 1, Table.class, false, false, false);

		property = getLocalProperty(tableType, 6);
		initializeProperty(property, theModelPackageImpl.getString(), "schemaName", "", 0, 1, Table.class, false, false, false);

		initializeType(updateType, Update.class, "Update", false);
		property = getLocalProperty(updateType, 0);
		initializeProperty(property, this.getParameters(), "Parameters", null, 0, 1, Update.class, false, false, false, true , null);

		property = getLocalProperty(updateType, 1);
		initializeProperty(property, theModelPackageImpl.getString(), "sql", null, 0, 1, Update.class, false, false, false);

		// Initialize data types
		initializeType(generatedKeysSupportedType, String.class, "generatedKeysSupported", true, false);

		createXSDMetaData(theModelPackageImpl);
	}
	  
	protected void createXSDMetaData(ModelFactoryImpl theModelPackageImpl)
	{
		super.initXSD();
		
		Property property = null;
		

		addXSDMapping
		  (columnType,
			 new String[] 
			 {
			 "name", "Column",
			 "kind", "empty"
			 });

		addXSDMapping
			(getLocalProperty(columnType, 0),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "columnName"
			 });

		addXSDMapping
			(getLocalProperty(columnType, 1),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "propertyName"
			 });

		addXSDMapping
			(getLocalProperty(columnType, 2),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "converterClassName"
			 });

		addXSDMapping
			(getLocalProperty(columnType, 3),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "primaryKey"
			 });

		addXSDMapping
			(getLocalProperty(columnType, 4),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "generated"
			 });

		addXSDMapping
			(getLocalProperty(columnType, 5),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "collision"
			 });

		addXSDMapping
			(getLocalProperty(columnType, 6),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "managed"
			 });

		addXSDMapping
		  (commandType,
			 new String[] 
			 {
			 "name", "Command",
			 "kind", "elementOnly"
			 });

		addXSDMapping
			(getLocalProperty(commandType, 0),
			 new String[]
			 {
			 "kind", "element",
			 "name", "Parameter",
			 "namespace", "##targetNamespace"
			 });

		addXSDMapping
			(getLocalProperty(commandType, 1),
			 new String[]
			 {
			 "kind", "element",
			 "name", "ResultDescriptor",
			 "namespace", "##targetNamespace"
			 });

		addXSDMapping
			(getLocalProperty(commandType, 2),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "name"
			 });

		addXSDMapping
			(getLocalProperty(commandType, 3),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "SQL"
			 });

		addXSDMapping
			(getLocalProperty(commandType, 4),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "kind"
			 });

		addXSDMapping
		  (configType,
			 new String[] 
			 {
			 "name", "Config",
			 "kind", "elementOnly"
			 });

		addXSDMapping
			(getLocalProperty(configType, 0),
			 new String[]
			 {
			 "kind", "element",
			 "name", "Command",
			 "namespace", "##targetNamespace"
			 });

		addXSDMapping
			(getLocalProperty(configType, 1),
			 new String[]
			 {
			 "kind", "element",
			 "name", "Table",
			 "namespace", "##targetNamespace"
			 });

		addXSDMapping
			(getLocalProperty(configType, 2),
			 new String[]
			 {
			 "kind", "element",
			 "name", "Relationship",
			 "namespace", "##targetNamespace"
			 });

		addXSDMapping
			(getLocalProperty(configType, 3),
			 new String[]
			 {
			 "kind", "element",
			 "name", "ConnectionInfo",
			 "namespace", "##targetNamespace"
			 });

		addXSDMapping
			(getLocalProperty(configType, 4),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "uri"
			 });

		addXSDMapping
			(getLocalProperty(configType, 5),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "dataObjectModel"
			 });

		addXSDMapping
			(getLocalProperty(configType, 6),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "databaseSchemaNameSupported"
			 });

		addXSDMapping
			(getLocalProperty(configType, 7),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "generatedKeysSupported"
			 });

		addXSDMapping
		  (connectionInfoType,
			 new String[] 
			 {
			 "name", "ConnectionInfo",
			 "kind", "elementOnly"
			 });

		addXSDMapping
			(getLocalProperty(connectionInfoType, 0),
			 new String[]
			 {
			 "kind", "element",
			 "name", "ConnectionProperties",
			 "namespace", "##targetNamespace"
			 });

		addXSDMapping
			(getLocalProperty(connectionInfoType, 1),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "dataSource"
			 });

		addXSDMapping
			(getLocalProperty(connectionInfoType, 2),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "managedtx"
			 });

		addXSDMapping
		  (connectionPropertiesType,
			 new String[] 
			 {
			 "name", "ConnectionProperties",
			 "kind", "empty"
			 });

		addXSDMapping
			(getLocalProperty(connectionPropertiesType, 0),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "driverClass"
			 });

		addXSDMapping
			(getLocalProperty(connectionPropertiesType, 1),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "databaseURL"
			 });

		addXSDMapping
			(getLocalProperty(connectionPropertiesType, 2),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "userName"
			 });

		addXSDMapping
			(getLocalProperty(connectionPropertiesType, 3),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "password"
			 });

		addXSDMapping
			(getLocalProperty(connectionPropertiesType, 4),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "loginTimeout"
			 });

		addXSDMapping
		  (createType,
			 new String[] 
			 {
			 "name", "Create",
			 "kind", "elementOnly"
			 });

		addXSDMapping
			(getLocalProperty(createType, 0),
			 new String[]
			 {
			 "kind", "element",
			 "name", "Parameters",
			 "namespace", "##targetNamespace"
			 });

		addXSDMapping
			(getLocalProperty(createType, 1),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "sql"
			 });

		addXSDMapping
		  (deleteType,
			 new String[] 
			 {
			 "name", "Delete",
			 "kind", "elementOnly"
			 });

		addXSDMapping
			(getLocalProperty(deleteType, 0),
			 new String[]
			 {
			 "kind", "element",
			 "name", "Parameters",
			 "namespace", "##targetNamespace"
			 });

		addXSDMapping
			(getLocalProperty(deleteType, 1),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "sql"
			 });

		property = createGlobalProperty
		  ("Config",
		  this.getConfig(),
			 new String[]
			 {
			 "kind", "element",
			 "name", "Config",
			 "namespace", "##targetNamespace"
			 });
                
		addXSDMapping
		  (keyPairType,
			 new String[] 
			 {
			 "name", "KeyPair",
			 "kind", "empty"
			 });

		addXSDMapping
			(getLocalProperty(keyPairType, 0),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "primaryKeyColumn"
			 });

		addXSDMapping
			(getLocalProperty(keyPairType, 1),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "foreignKeyColumn"
			 });

		addXSDMapping
		  (parameterType,
			 new String[] 
			 {
			 "name", "Parameter",
			 "kind", "empty"
			 });

		addXSDMapping
			(getLocalProperty(parameterType, 0),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "name"
			 });

		addXSDMapping
			(getLocalProperty(parameterType, 1),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "columnType"
			 });

		addXSDMapping
			(getLocalProperty(parameterType, 2),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "direction"
			 });

		addXSDMapping
			(getLocalProperty(parameterType, 3),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "index"
			 });

		addXSDMapping
		  (parametersType,
			 new String[] 
			 {
			 "name", "Parameters",
			 "kind", "elementOnly"
			 });

		addXSDMapping
			(getLocalProperty(parametersType, 0),
			 new String[]
			 {
			 "kind", "element",
			 "name", "Parameter",
			 "namespace", "##targetNamespace"
			 });

		addXSDMapping
		  (relationshipType,
			 new String[] 
			 {
			 "name", "Relationship",
			 "kind", "elementOnly"
			 });

		addXSDMapping
			(getLocalProperty(relationshipType, 0),
			 new String[]
			 {
			 "kind", "element",
			 "name", "KeyPair",
			 "namespace", "##targetNamespace"
			 });

		addXSDMapping
			(getLocalProperty(relationshipType, 1),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "name"
			 });

		addXSDMapping
			(getLocalProperty(relationshipType, 2),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "primaryKeyTable"
			 });

		addXSDMapping
			(getLocalProperty(relationshipType, 3),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "foreignKeyTable"
			 });

		addXSDMapping
			(getLocalProperty(relationshipType, 4),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "many"
			 });

		addXSDMapping
			(getLocalProperty(relationshipType, 5),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "keyRestricted"
			 });

		addXSDMapping
		  (resultDescriptorType,
			 new String[] 
			 {
			 "name", "ResultDescriptor",
			 "kind", "empty"
			 });

		addXSDMapping
			(getLocalProperty(resultDescriptorType, 0),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "columnIndex"
			 });

		addXSDMapping
			(getLocalProperty(resultDescriptorType, 1),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "columnName"
			 });

		addXSDMapping
			(getLocalProperty(resultDescriptorType, 2),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "tableName"
			 });

		addXSDMapping
			(getLocalProperty(resultDescriptorType, 3),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "schemaName"
			 });

		addXSDMapping
			(getLocalProperty(resultDescriptorType, 4),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "columnType"
			 });

		addXSDMapping
		  (tableType,
			 new String[] 
			 {
			 "name", "Table",
			 "kind", "elementOnly"
			 });

		addXSDMapping
			(getLocalProperty(tableType, 0),
			 new String[]
			 {
			 "kind", "element",
			 "name", "Column",
			 "namespace", "##targetNamespace"
			 });

		addXSDMapping
			(getLocalProperty(tableType, 1),
			 new String[]
			 {
			 "kind", "element",
			 "name", "create",
			 "namespace", "##targetNamespace"
			 });

		addXSDMapping
			(getLocalProperty(tableType, 2),
			 new String[]
			 {
			 "kind", "element",
			 "name", "update",
			 "namespace", "##targetNamespace"
			 });

		addXSDMapping
			(getLocalProperty(tableType, 3),
			 new String[]
			 {
			 "kind", "element",
			 "name", "delete",
			 "namespace", "##targetNamespace"
			 });

		addXSDMapping
			(getLocalProperty(tableType, 4),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "tableName"
			 });

		addXSDMapping
			(getLocalProperty(tableType, 5),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "typeName"
			 });

		addXSDMapping
			(getLocalProperty(tableType, 6),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "schemaName"
			 });

		addXSDMapping
		  (updateType,
			 new String[] 
			 {
			 "name", "Update",
			 "kind", "elementOnly"
			 });

		addXSDMapping
			(getLocalProperty(updateType, 0),
			 new String[]
			 {
			 "kind", "element",
			 "name", "Parameters",
			 "namespace", "##targetNamespace"
			 });

		addXSDMapping
			(getLocalProperty(updateType, 1),
			 new String[]
			 {
			 "kind", "attribute",
			 "name", "sql"
			 });

		addXSDMapping
		  (generatedKeysSupportedType,
			 new String[] 
			 {
			 "name", "generatedKeysSupported_._type",
			 "baseType", "commonj.sdo#String",
			 "enumeration", "true false"
			 });

  }
    
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String creategeneratedKeysSupportedFromString(String initialValue)
	{
		return (String)((ModelFactoryImpl)ModelFactory.INSTANCE).createStringFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertgeneratedKeysSupportedToString(Object instanceValue)
	{
		return ((ModelFactoryImpl)ModelFactory.INSTANCE).convertStringToString(instanceValue);
	}

} //ConfigFactoryImpl
