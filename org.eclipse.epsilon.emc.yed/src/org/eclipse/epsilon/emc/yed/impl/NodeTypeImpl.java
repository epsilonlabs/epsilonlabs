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

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.epsilon.emc.yed.Node;
import org.eclipse.epsilon.emc.yed.NodeType;
import org.eclipse.epsilon.emc.yed.SlotPrototype;
import org.eclipse.epsilon.emc.yed.YedPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.emc.yed.impl.NodeTypeImpl#getInstances <em>Instances</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.yed.impl.NodeTypeImpl#getSlotPrototypes <em>Slot Prototypes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NodeTypeImpl extends TypeImpl implements NodeType {
	/**
	 * The cached value of the '{@link #getInstances() <em>Instances</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> instances;

	/**
	 * The cached value of the '{@link #getSlotPrototypes() <em>Slot Prototypes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlotPrototypes()
	 * @generated
	 * @ordered
	 */
	protected EList<SlotPrototype> slotPrototypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return YedPackage.Literals.NODE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Node> getInstances() {
		if (instances == null) {
			instances = new EObjectWithInverseResolvingEList<Node>(Node.class, this, YedPackage.NODE_TYPE__INSTANCES, YedPackage.NODE__TYPE);
		}
		return instances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SlotPrototype> getSlotPrototypes() {
		if (slotPrototypes == null) {
			slotPrototypes = new EObjectContainmentWithInverseEList<SlotPrototype>(SlotPrototype.class, this, YedPackage.NODE_TYPE__SLOT_PROTOTYPES, YedPackage.SLOT_PROTOTYPE__OWNING_TYPE);
		}
		return slotPrototypes;
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
			case YedPackage.NODE_TYPE__INSTANCES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInstances()).basicAdd(otherEnd, msgs);
			case YedPackage.NODE_TYPE__SLOT_PROTOTYPES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSlotPrototypes()).basicAdd(otherEnd, msgs);
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
			case YedPackage.NODE_TYPE__INSTANCES:
				return ((InternalEList<?>)getInstances()).basicRemove(otherEnd, msgs);
			case YedPackage.NODE_TYPE__SLOT_PROTOTYPES:
				return ((InternalEList<?>)getSlotPrototypes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case YedPackage.NODE_TYPE__INSTANCES:
				return getInstances();
			case YedPackage.NODE_TYPE__SLOT_PROTOTYPES:
				return getSlotPrototypes();
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
			case YedPackage.NODE_TYPE__INSTANCES:
				getInstances().clear();
				getInstances().addAll((Collection<? extends Node>)newValue);
				return;
			case YedPackage.NODE_TYPE__SLOT_PROTOTYPES:
				getSlotPrototypes().clear();
				getSlotPrototypes().addAll((Collection<? extends SlotPrototype>)newValue);
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
			case YedPackage.NODE_TYPE__INSTANCES:
				getInstances().clear();
				return;
			case YedPackage.NODE_TYPE__SLOT_PROTOTYPES:
				getSlotPrototypes().clear();
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
			case YedPackage.NODE_TYPE__INSTANCES:
				return instances != null && !instances.isEmpty();
			case YedPackage.NODE_TYPE__SLOT_PROTOTYPES:
				return slotPrototypes != null && !slotPrototypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //NodeTypeImpl
