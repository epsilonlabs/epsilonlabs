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

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.epsilon.emc.yed.Node;
import org.eclipse.epsilon.emc.yed.Slot;
import org.eclipse.epsilon.emc.yed.SlotPrototype;
import org.eclipse.epsilon.emc.yed.YedPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Slot</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.emc.yed.impl.SlotImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.yed.impl.SlotImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.yed.impl.SlotImpl#getPrototype <em>Prototype</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.yed.impl.SlotImpl#getOwningNode <em>Owning Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SlotImpl extends EObjectImpl implements Slot {
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
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected Object value = VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPrototype() <em>Prototype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrototype()
	 * @generated
	 * @ordered
	 */
	protected SlotPrototype prototype;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SlotImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return YedPackage.Literals.SLOT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, YedPackage.SLOT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(Object newValue) {
		Object oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YedPackage.SLOT__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SlotPrototype getPrototype() {
		if (prototype != null && prototype.eIsProxy()) {
			InternalEObject oldPrototype = (InternalEObject)prototype;
			prototype = (SlotPrototype)eResolveProxy(oldPrototype);
			if (prototype != oldPrototype) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, YedPackage.SLOT__PROTOTYPE, oldPrototype, prototype));
			}
		}
		return prototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SlotPrototype basicGetPrototype() {
		return prototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPrototype(SlotPrototype newPrototype, NotificationChain msgs) {
		SlotPrototype oldPrototype = prototype;
		prototype = newPrototype;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, YedPackage.SLOT__PROTOTYPE, oldPrototype, newPrototype);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrototype(SlotPrototype newPrototype) {
		if (newPrototype != prototype) {
			NotificationChain msgs = null;
			if (prototype != null)
				msgs = ((InternalEObject)prototype).eInverseRemove(this, YedPackage.SLOT_PROTOTYPE__SLOTS, SlotPrototype.class, msgs);
			if (newPrototype != null)
				msgs = ((InternalEObject)newPrototype).eInverseAdd(this, YedPackage.SLOT_PROTOTYPE__SLOTS, SlotPrototype.class, msgs);
			msgs = basicSetPrototype(newPrototype, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YedPackage.SLOT__PROTOTYPE, newPrototype, newPrototype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getOwningNode() {
		if (eContainerFeatureID() != YedPackage.SLOT__OWNING_NODE) return null;
		return (Node)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningNode(Node newOwningNode, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningNode, YedPackage.SLOT__OWNING_NODE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningNode(Node newOwningNode) {
		if (newOwningNode != eInternalContainer() || (eContainerFeatureID() != YedPackage.SLOT__OWNING_NODE && newOwningNode != null)) {
			if (EcoreUtil.isAncestor(this, newOwningNode))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningNode != null)
				msgs = ((InternalEObject)newOwningNode).eInverseAdd(this, YedPackage.NODE__SLOTS, Node.class, msgs);
			msgs = basicSetOwningNode(newOwningNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YedPackage.SLOT__OWNING_NODE, newOwningNode, newOwningNode));
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
			case YedPackage.SLOT__PROTOTYPE:
				if (prototype != null)
					msgs = ((InternalEObject)prototype).eInverseRemove(this, YedPackage.SLOT_PROTOTYPE__SLOTS, SlotPrototype.class, msgs);
				return basicSetPrototype((SlotPrototype)otherEnd, msgs);
			case YedPackage.SLOT__OWNING_NODE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningNode((Node)otherEnd, msgs);
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
			case YedPackage.SLOT__PROTOTYPE:
				return basicSetPrototype(null, msgs);
			case YedPackage.SLOT__OWNING_NODE:
				return basicSetOwningNode(null, msgs);
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
			case YedPackage.SLOT__OWNING_NODE:
				return eInternalContainer().eInverseRemove(this, YedPackage.NODE__SLOTS, Node.class, msgs);
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
			case YedPackage.SLOT__NAME:
				return getName();
			case YedPackage.SLOT__VALUE:
				return getValue();
			case YedPackage.SLOT__PROTOTYPE:
				if (resolve) return getPrototype();
				return basicGetPrototype();
			case YedPackage.SLOT__OWNING_NODE:
				return getOwningNode();
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
			case YedPackage.SLOT__NAME:
				setName((String)newValue);
				return;
			case YedPackage.SLOT__VALUE:
				setValue(newValue);
				return;
			case YedPackage.SLOT__PROTOTYPE:
				setPrototype((SlotPrototype)newValue);
				return;
			case YedPackage.SLOT__OWNING_NODE:
				setOwningNode((Node)newValue);
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
			case YedPackage.SLOT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case YedPackage.SLOT__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case YedPackage.SLOT__PROTOTYPE:
				setPrototype((SlotPrototype)null);
				return;
			case YedPackage.SLOT__OWNING_NODE:
				setOwningNode((Node)null);
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
			case YedPackage.SLOT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case YedPackage.SLOT__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case YedPackage.SLOT__PROTOTYPE:
				return prototype != null;
			case YedPackage.SLOT__OWNING_NODE:
				return getOwningNode() != null;
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
		result.append(", value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //SlotImpl
