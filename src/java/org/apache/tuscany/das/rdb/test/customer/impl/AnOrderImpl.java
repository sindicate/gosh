/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.tuscany.das.rdb.test.customer.impl;

import commonj.sdo.Type;

import org.apache.tuscany.das.rdb.test.customer.AnOrder;
import org.apache.tuscany.das.rdb.test.customer.CustomerFactory;

import org.apache.tuscany.sdo.impl.DataObjectBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>An Order</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.tuscany.das.rdb.test.customer.impl.AnOrderImpl#getID <em>ID</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.test.customer.impl.AnOrderImpl#getProduct <em>Product</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.test.customer.impl.AnOrderImpl#getQuantity <em>Quantity</em>}</li>
 *   <li>{@link org.apache.tuscany.das.rdb.test.customer.impl.AnOrderImpl#getCustomer_ID <em>Customer ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnOrderImpl extends DataObjectBase implements AnOrder
{

	public final static int ID = 0;

	public final static int PRODUCT = 1;

	public final static int QUANTITY = 2;

	public final static int CUSTOMER_ID = 3;

	public final static int SDO_PROPERTY_COUNT = 4;

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
	 * The internal feature id for the '<em><b>Product</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_PRODUCT = 1;

	/**
	 * The internal feature id for the '<em><b>Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_QUANTITY = 2;

	/**
	 * The internal feature id for the '<em><b>Customer ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */ 
	public final static int INTERNAL_CUSTOMER_ID = 3;

	/**
	 * The number of properties for this type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public final static int INTERNAL_PROPERTY_COUNT = 4;

	protected int internalConvertIndex(int internalIndex)
	{
		switch (internalIndex)
		{
			case INTERNAL_ID: return ID;
			case INTERNAL_PRODUCT: return PRODUCT;
			case INTERNAL_QUANTITY: return QUANTITY;
			case INTERNAL_CUSTOMER_ID: return CUSTOMER_ID;
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
	 * The default value of the '{@link #getProduct() <em>Product</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProduct()
	 * @generated
	 * @ordered
	 */
	protected static final String PRODUCT_DEFAULT_ = null;

	/**
	 * The cached value of the '{@link #getProduct() <em>Product</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProduct()
	 * @generated
	 * @ordered
	 */
	protected String product = PRODUCT_DEFAULT_;

	/**
	 * The default value of the '{@link #getQuantity() <em>Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuantity()
	 * @generated
	 * @ordered
	 */
	protected static final int QUANTITY_DEFAULT_ = 0;

	/**
	 * The cached value of the '{@link #getQuantity() <em>Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuantity()
	 * @generated
	 * @ordered
	 */
	protected int quantity = QUANTITY_DEFAULT_;

	/**
	 * The default value of the '{@link #getCustomer_ID() <em>Customer ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomer_ID()
	 * @generated
	 * @ordered
	 */
	protected static final int CUSTOMER_ID_DEFAULT_ = 0;

	/**
	 * The cached value of the '{@link #getCustomer_ID() <em>Customer ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomer_ID()
	 * @generated
	 * @ordered
	 */
	protected int customer_ID = CUSTOMER_ID_DEFAULT_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnOrderImpl()
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
		return ((CustomerFactoryImpl)CustomerFactory.INSTANCE).getAnOrder();
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
	public String getProduct()
	{
		return product;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProduct(String newProduct)
	{
		String oldProduct = product;
		product = newProduct;
		if (isNotifying())
			notify(ChangeKind.SET, INTERNAL_PRODUCT, oldProduct, product);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getQuantity()
	{
		return quantity;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuantity(int newQuantity)
	{
		int oldQuantity = quantity;
		quantity = newQuantity;
		if (isNotifying())
			notify(ChangeKind.SET, INTERNAL_QUANTITY, oldQuantity, quantity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCustomer_ID()
	{
		return customer_ID;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomer_ID(int newCustomer_ID)
	{
		int oldCustomer_ID = customer_ID;
		customer_ID = newCustomer_ID;
		if (isNotifying())
			notify(ChangeKind.SET, INTERNAL_CUSTOMER_ID, oldCustomer_ID, customer_ID);
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
			case PRODUCT:
				return getProduct();
			case QUANTITY:
				return new Integer(getQuantity());
			case CUSTOMER_ID:
				return new Integer(getCustomer_ID());
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
			case PRODUCT:
				setProduct((String)newValue);
				return;
			case QUANTITY:
				setQuantity(((Integer)newValue).intValue());
				return;
			case CUSTOMER_ID:
				setCustomer_ID(((Integer)newValue).intValue());
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
			case PRODUCT:
				setProduct(PRODUCT_DEFAULT_);
				return;
			case QUANTITY:
				setQuantity(QUANTITY_DEFAULT_);
				return;
			case CUSTOMER_ID:
				setCustomer_ID(CUSTOMER_ID_DEFAULT_);
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
			case PRODUCT:
				return PRODUCT_DEFAULT_ == null ? product != null : !PRODUCT_DEFAULT_.equals(product);
			case QUANTITY:
				return quantity != QUANTITY_DEFAULT_;
			case CUSTOMER_ID:
				return customer_ID != CUSTOMER_ID_DEFAULT_;
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
		result.append(", Product: ");
		result.append(product);
		result.append(", Quantity: ");
		result.append(quantity);
		result.append(", Customer_ID: ");
		result.append(customer_ID);
		result.append(')');
		return result.toString();
	}

} //AnOrderImpl
