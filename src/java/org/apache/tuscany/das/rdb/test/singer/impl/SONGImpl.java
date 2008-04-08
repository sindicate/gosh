/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.das.rdb.test.singer.impl;

import commonj.sdo.Type;

import org.apache.tuscany.das.rdb.test.singer.SONG;
import org.apache.tuscany.das.rdb.test.singer.SingerFactory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SONG</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.das.rdb.test.singer.impl.SONGImpl#getID <em>ID</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.test.singer.impl.SONGImpl#getTITLE <em>TITLE</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.test.singer.impl.SONGImpl#getSINGERID <em>SINGERID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SONGImpl extends DataObjectBase implements SONG
{

	public final static int ID = 0;

	public final static int TITLE = 1;

	public final static int SINGERID = 2;

	public final static int SDO_PROPERTY_COUNT = 3;

	public final static int EXTENDED_PROPERTY_COUNT = 0;


	/**
	 * The internal feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_ID = 0;

	/**
	 * The internal feature id for the '<em><b>TITLE</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_TITLE = 1;

	/**
	 * The internal feature id for the '<em><b>SINGERID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_SINGERID = 2;

	/**
	 * The number of properties for this type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public final static int INTERNAL_PROPERTY_COUNT = 3;

	protected int internalConvertIndex(int internalIndex)
	{
		switch (internalIndex)
		{
			case INTERNAL_ID: return ID;
			case INTERNAL_TITLE: return TITLE;
			case INTERNAL_SINGERID: return SINGERID;
		}
		return super.internalConvertIndex(internalIndex);
	}


	/**
	 * The default value of the '{@link #getID() <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getID()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_DEFAULT_ = 0;

	/**
	 * The cached value of the '{@link #getID() <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getID()
	 * @generated
	 * @ordered
	 */
	protected int id = ID_DEFAULT_;

	/**
	 * The default value of the '{@link #getTITLE() <em>TITLE</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTITLE()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_DEFAULT_ = null;

	/**
	 * The cached value of the '{@link #getTITLE() <em>TITLE</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTITLE()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_DEFAULT_;

	/**
	 * The default value of the '{@link #getSINGERID() <em>SINGERID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSINGERID()
	 * @generated
	 * @ordered
	 */
	protected static final int SINGERID_DEFAULT_ = 0;

	/**
	 * The cached value of the '{@link #getSINGERID() <em>SINGERID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSINGERID()
	 * @generated
	 * @ordered
	 */
	protected int singerid = SINGERID_DEFAULT_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SONGImpl()
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
		return ((SingerFactoryImpl)SingerFactory.INSTANCE).getSONG();
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
	public int getID()
	{
		return id;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setID(int newID)
	{
		int oldID = id;
		id = newID;
		if (isNotifying())
			notify(ChangeKind.SET, INTERNAL_ID, oldID, id);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTITLE()
	{
		return title;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTITLE(String newTITLE)
	{
		String oldTITLE = title;
		title = newTITLE;
		if (isNotifying())
			notify(ChangeKind.SET, INTERNAL_TITLE, oldTITLE, title);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSINGERID()
	{
		return singerid;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSINGERID(int newSINGERID)
	{
		int oldSINGERID = singerid;
		singerid = newSINGERID;
		if (isNotifying())
			notify(ChangeKind.SET, INTERNAL_SINGERID, oldSINGERID, singerid);
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
			case ID:
				return new Integer(getID());
			case TITLE:
				return getTITLE();
			case SINGERID:
				return new Integer(getSINGERID());
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
			case ID:
				setID(((Integer)newValue).intValue());
				return;
			case TITLE:
				setTITLE((String)newValue);
				return;
			case SINGERID:
				setSINGERID(((Integer)newValue).intValue());
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
			case ID:
				setID(ID_DEFAULT_);
				return;
			case TITLE:
				setTITLE(TITLE_DEFAULT_);
				return;
			case SINGERID:
				setSINGERID(SINGERID_DEFAULT_);
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
			case ID:
				return id != ID_DEFAULT_;
			case TITLE:
				return TITLE_DEFAULT_ == null ? title != null : !TITLE_DEFAULT_.equals(title);
			case SINGERID:
				return singerid != SINGERID_DEFAULT_;
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
		result.append(" (ID: ");
		result.append(id);
		result.append(", TITLE: ");
		result.append(title);
		result.append(", SINGERID: ");
		result.append(singerid);
		result.append(')');
		return result.toString();
	}

} //SONGImpl
