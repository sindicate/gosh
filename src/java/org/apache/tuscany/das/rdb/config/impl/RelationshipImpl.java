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

import org.apache.tuscany.das.rdb.config.ConfigFactory;
import org.apache.tuscany.das.rdb.config.KeyPair;
import org.apache.tuscany.das.rdb.config.Relationship;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.RelationshipImpl#getKeyPair <em>Key Pair</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.RelationshipImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.RelationshipImpl#getPrimaryKeyTable <em>Primary Key Table</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.RelationshipImpl#getForeignKeyTable <em>Foreign Key Table</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.RelationshipImpl#isMany <em>Many</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.config.impl.RelationshipImpl#isKeyRestricted <em>Key Restricted</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RelationshipImpl extends DataObjectBase implements Relationship
{

	public final static int KEY_PAIR = 0;

	public final static int NAME = 1;

	public final static int PRIMARY_KEY_TABLE = 2;

	public final static int FOREIGN_KEY_TABLE = 3;

	public final static int MANY = 4;

	public final static int KEY_RESTRICTED = 5;

	public final static int SDO_PROPERTY_COUNT = 6;

	public final static int EXTENDED_PROPERTY_COUNT = 0;


	/**
	 * The internal feature id for the '<em><b>Key Pair</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_KEY_PAIR = 0;

	/**
	 * The internal feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_NAME = 1;

	/**
	 * The internal feature id for the '<em><b>Primary Key Table</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_PRIMARY_KEY_TABLE = 2;

	/**
	 * The internal feature id for the '<em><b>Foreign Key Table</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_FOREIGN_KEY_TABLE = 3;

	/**
	 * The internal feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_MANY = 4;

	/**
	 * The internal feature id for the '<em><b>Key Restricted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_KEY_RESTRICTED = 5;

	/**
	 * The number of properties for this type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public final static int INTERNAL_PROPERTY_COUNT = 6;

	protected int internalConvertIndex(int internalIndex)
	{
		switch (internalIndex)
		{
			case INTERNAL_KEY_PAIR: return KEY_PAIR;
			case INTERNAL_NAME: return NAME;
			case INTERNAL_PRIMARY_KEY_TABLE: return PRIMARY_KEY_TABLE;
			case INTERNAL_FOREIGN_KEY_TABLE: return FOREIGN_KEY_TABLE;
			case INTERNAL_MANY: return MANY;
			case INTERNAL_KEY_RESTRICTED: return KEY_RESTRICTED;
		}
		return super.internalConvertIndex(internalIndex);
	}


	/**
	 * The cached value of the '{@link #getKeyPair() <em>Key Pair</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyPair()
	 * @generated
	 * @ordered
	 */
	
	protected List keyPair = null;
	
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_DEFAULT_ = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_DEFAULT_;

	/**
	 * The default value of the '{@link #getPrimaryKeyTable() <em>Primary Key Table</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryKeyTable()
	 * @generated
	 * @ordered
	 */
	protected static final String PRIMARY_KEY_TABLE_DEFAULT_ = null;

	/**
	 * The cached value of the '{@link #getPrimaryKeyTable() <em>Primary Key Table</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryKeyTable()
	 * @generated
	 * @ordered
	 */
	protected String primaryKeyTable = PRIMARY_KEY_TABLE_DEFAULT_;

	/**
	 * The default value of the '{@link #getForeignKeyTable() <em>Foreign Key Table</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForeignKeyTable()
	 * @generated
	 * @ordered
	 */
	protected static final String FOREIGN_KEY_TABLE_DEFAULT_ = null;

	/**
	 * The cached value of the '{@link #getForeignKeyTable() <em>Foreign Key Table</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForeignKeyTable()
	 * @generated
	 * @ordered
	 */
	protected String foreignKeyTable = FOREIGN_KEY_TABLE_DEFAULT_;

	/**
	 * The default value of the '{@link #isMany() <em>Many</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMany()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MANY_DEFAULT_ = false;

	/**
	 * The cached value of the '{@link #isMany() <em>Many</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMany()
	 * @generated
	 * @ordered
	 */
	protected boolean many = MANY_DEFAULT_;

	/**
	 * The default value of the '{@link #isKeyRestricted() <em>Key Restricted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isKeyRestricted()
	 * @generated
	 * @ordered
	 */
	protected static final boolean KEY_RESTRICTED_DEFAULT_ = false;

	/**
	 * The cached value of the '{@link #isKeyRestricted() <em>Key Restricted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isKeyRestricted()
	 * @generated
	 * @ordered
	 */
	protected boolean keyRestricted = KEY_RESTRICTED_DEFAULT_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationshipImpl()
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
		return ((ConfigFactoryImpl)ConfigFactory.INSTANCE).getRelationship();
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
	public List getKeyPair()
	{
		if (keyPair == null)
		{
		  keyPair = createPropertyList(ListKind.CONTAINMENT, KeyPair.class, KEY_PAIR, 0);
		}
		return keyPair;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName)
	{
		name = newName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPrimaryKeyTable()
	{
		return primaryKeyTable;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimaryKeyTable(String newPrimaryKeyTable)
	{
		primaryKeyTable = newPrimaryKeyTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getForeignKeyTable()
	{
		return foreignKeyTable;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForeignKeyTable(String newForeignKeyTable)
	{
		foreignKeyTable = newForeignKeyTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMany()
	{
		return many;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMany(boolean newMany)
	{
		many = newMany;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isKeyRestricted()
	{
		return keyRestricted;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeyRestricted(boolean newKeyRestricted)
	{
		keyRestricted = newKeyRestricted;
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
			case KEY_PAIR:
				return removeFromList(getKeyPair(), otherEnd, changeContext);
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
			case KEY_PAIR:
				return getKeyPair();
			case NAME:
				return getName();
			case PRIMARY_KEY_TABLE:
				return getPrimaryKeyTable();
			case FOREIGN_KEY_TABLE:
				return getForeignKeyTable();
			case MANY:
				return isMany() ? Boolean.TRUE : Boolean.FALSE;
			case KEY_RESTRICTED:
				return isKeyRestricted() ? Boolean.TRUE : Boolean.FALSE;
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
			case KEY_PAIR:
				getKeyPair().clear();
				getKeyPair().addAll((Collection)newValue);
				return;
			case NAME:
				setName((String)newValue);
				return;
			case PRIMARY_KEY_TABLE:
				setPrimaryKeyTable((String)newValue);
				return;
			case FOREIGN_KEY_TABLE:
				setForeignKeyTable((String)newValue);
				return;
			case MANY:
				setMany(((Boolean)newValue).booleanValue());
				return;
			case KEY_RESTRICTED:
				setKeyRestricted(((Boolean)newValue).booleanValue());
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
			case KEY_PAIR:
				getKeyPair().clear();
				return;
			case NAME:
				setName(NAME_DEFAULT_);
				return;
			case PRIMARY_KEY_TABLE:
				setPrimaryKeyTable(PRIMARY_KEY_TABLE_DEFAULT_);
				return;
			case FOREIGN_KEY_TABLE:
				setForeignKeyTable(FOREIGN_KEY_TABLE_DEFAULT_);
				return;
			case MANY:
				setMany(MANY_DEFAULT_);
				return;
			case KEY_RESTRICTED:
				setKeyRestricted(KEY_RESTRICTED_DEFAULT_);
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
			case KEY_PAIR:
				return keyPair != null && !keyPair.isEmpty();
			case NAME:
				return NAME_DEFAULT_ == null ? name != null : !NAME_DEFAULT_.equals(name);
			case PRIMARY_KEY_TABLE:
				return PRIMARY_KEY_TABLE_DEFAULT_ == null ? primaryKeyTable != null : !PRIMARY_KEY_TABLE_DEFAULT_.equals(primaryKeyTable);
			case FOREIGN_KEY_TABLE:
				return FOREIGN_KEY_TABLE_DEFAULT_ == null ? foreignKeyTable != null : !FOREIGN_KEY_TABLE_DEFAULT_.equals(foreignKeyTable);
			case MANY:
				return many != MANY_DEFAULT_;
			case KEY_RESTRICTED:
				return keyRestricted != KEY_RESTRICTED_DEFAULT_;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", primaryKeyTable: ");
		result.append(primaryKeyTable);
		result.append(", foreignKeyTable: ");
		result.append(foreignKeyTable);
		result.append(", many: ");
		result.append(many);
		result.append(", keyRestricted: ");
		result.append(keyRestricted);
		result.append(')');
		return result.toString();
	}

} //RelationshipImpl
