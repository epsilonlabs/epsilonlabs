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

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

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
 *   <li>{@link org.eclipse.epsilon.emc.yed.impl.SlotImpl#getValues <em>Values</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.yed.impl.SlotImpl#getPrototype <em>Prototype</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.yed.impl.SlotImpl#getOwningNode <em>Owning Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SlotImpl extends EObjectImpl implements Slot {
	/**
	 * The cached value of the '{@link #getValues() <em>Values</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected EList<Object> values;

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
	public EList<Object> getValues() {
		if (values == null) {
			values = new EDataTypeUniqueEList<Object>(Object.class, this, YedPackage.SLOT__VALUES);
		}
		return values;
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
			case YedPackage.SLOT__VALUES:
				return getValues();
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
			case YedPackage.SLOT__VALUES:
				getValues().clear();
				getValues().addAll((Collection<? extends Object>)newValue);
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
			case YedPackage.SLOT__VALUES:
				getValues().clear();
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
			case YedPackage.SLOT__VALUES:
				return values != null && !values.isEmpty();
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
		result.append(" (values: ");
		result.append(values);
		result.append(')');
		return result.toString();
	}

} //SlotImpl
