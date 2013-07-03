/**
 */
package org.eclipse.epsilon.emc.yed.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.epsilon.emc.yed.NodeType;
import org.eclipse.epsilon.emc.yed.Slot;
import org.eclipse.epsilon.emc.yed.SlotPrototype;
import org.eclipse.epsilon.emc.yed.Type;
import org.eclipse.epsilon.emc.yed.YedPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Slot Prototype</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.emc.yed.impl.SlotPrototypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.yed.impl.SlotPrototypeImpl#isMany <em>Many</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.yed.impl.SlotPrototypeImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.yed.impl.SlotPrototypeImpl#getOwningType <em>Owning Type</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.yed.impl.SlotPrototypeImpl#getSlots <em>Slots</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SlotPrototypeImpl extends EObjectImpl implements SlotPrototype {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isMany() <em>Many</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMany()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MANY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMany() <em>Many</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMany()
	 * @generated
	 * @ordered
	 */
	protected boolean many = MANY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Type type;

	/**
	 * The cached value of the '{@link #getSlots() <em>Slots</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlots()
	 * @generated
	 * @ordered
	 */
	protected EList<Slot> slots;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SlotPrototypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return YedPackage.Literals.SLOT_PROTOTYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YedPackage.SLOT_PROTOTYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMany() {
		return many;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMany(boolean newMany) {
		boolean oldMany = many;
		many = newMany;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YedPackage.SLOT_PROTOTYPE__MANY, oldMany, many));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetType(Type newType, NotificationChain msgs) {
		Type oldType = type;
		type = newType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, YedPackage.SLOT_PROTOTYPE__TYPE, oldType, newType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Type newType) {
		if (newType != type) {
			NotificationChain msgs = null;
			if (type != null)
				msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - YedPackage.SLOT_PROTOTYPE__TYPE, null, msgs);
			if (newType != null)
				msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - YedPackage.SLOT_PROTOTYPE__TYPE, null, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YedPackage.SLOT_PROTOTYPE__TYPE, newType, newType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeType getOwningType() {
		if (eContainerFeatureID() != YedPackage.SLOT_PROTOTYPE__OWNING_TYPE) return null;
		return (NodeType)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningType(NodeType newOwningType, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningType, YedPackage.SLOT_PROTOTYPE__OWNING_TYPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningType(NodeType newOwningType) {
		if (newOwningType != eInternalContainer() || (eContainerFeatureID() != YedPackage.SLOT_PROTOTYPE__OWNING_TYPE && newOwningType != null)) {
			if (EcoreUtil.isAncestor(this, newOwningType))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningType != null)
				msgs = ((InternalEObject)newOwningType).eInverseAdd(this, YedPackage.NODE_TYPE__SLOT_PROTOTYPES, NodeType.class, msgs);
			msgs = basicSetOwningType(newOwningType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YedPackage.SLOT_PROTOTYPE__OWNING_TYPE, newOwningType, newOwningType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Slot> getSlots() {
		if (slots == null) {
			slots = new EObjectWithInverseResolvingEList<Slot>(Slot.class, this, YedPackage.SLOT_PROTOTYPE__SLOTS, YedPackage.SLOT__PROTOTYPE);
		}
		return slots;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case YedPackage.SLOT_PROTOTYPE__OWNING_TYPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningType((NodeType)otherEnd, msgs);
			case YedPackage.SLOT_PROTOTYPE__SLOTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSlots()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case YedPackage.SLOT_PROTOTYPE__TYPE:
				return basicSetType(null, msgs);
			case YedPackage.SLOT_PROTOTYPE__OWNING_TYPE:
				return basicSetOwningType(null, msgs);
			case YedPackage.SLOT_PROTOTYPE__SLOTS:
				return ((InternalEList<?>)getSlots()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case YedPackage.SLOT_PROTOTYPE__OWNING_TYPE:
				return eInternalContainer().eInverseRemove(this, YedPackage.NODE_TYPE__SLOT_PROTOTYPES, NodeType.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case YedPackage.SLOT_PROTOTYPE__NAME:
				return getName();
			case YedPackage.SLOT_PROTOTYPE__MANY:
				return isMany();
			case YedPackage.SLOT_PROTOTYPE__TYPE:
				return getType();
			case YedPackage.SLOT_PROTOTYPE__OWNING_TYPE:
				return getOwningType();
			case YedPackage.SLOT_PROTOTYPE__SLOTS:
				return getSlots();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case YedPackage.SLOT_PROTOTYPE__NAME:
				setName((String)newValue);
				return;
			case YedPackage.SLOT_PROTOTYPE__MANY:
				setMany((Boolean)newValue);
				return;
			case YedPackage.SLOT_PROTOTYPE__TYPE:
				setType((Type)newValue);
				return;
			case YedPackage.SLOT_PROTOTYPE__OWNING_TYPE:
				setOwningType((NodeType)newValue);
				return;
			case YedPackage.SLOT_PROTOTYPE__SLOTS:
				getSlots().clear();
				getSlots().addAll((Collection<? extends Slot>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case YedPackage.SLOT_PROTOTYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case YedPackage.SLOT_PROTOTYPE__MANY:
				setMany(MANY_EDEFAULT);
				return;
			case YedPackage.SLOT_PROTOTYPE__TYPE:
				setType((Type)null);
				return;
			case YedPackage.SLOT_PROTOTYPE__OWNING_TYPE:
				setOwningType((NodeType)null);
				return;
			case YedPackage.SLOT_PROTOTYPE__SLOTS:
				getSlots().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case YedPackage.SLOT_PROTOTYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case YedPackage.SLOT_PROTOTYPE__MANY:
				return many != MANY_EDEFAULT;
			case YedPackage.SLOT_PROTOTYPE__TYPE:
				return type != null;
			case YedPackage.SLOT_PROTOTYPE__OWNING_TYPE:
				return getOwningType() != null;
			case YedPackage.SLOT_PROTOTYPE__SLOTS:
				return slots != null && !slots.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", many: ");
		result.append(many);
		result.append(')');
		return result.toString();
	}

} //SlotPrototypeImpl
