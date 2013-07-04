/**
 */
package org.eclipse.epsilon.emc.graphml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.epsilon.emc.graphml.EdgeType;
import org.eclipse.epsilon.emc.graphml.GraphmlPackage;
import org.eclipse.epsilon.emc.graphml.SlotPrototype;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edge Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.emc.graphml.impl.EdgeTypeImpl#getSourcePrototype <em>Source Prototype</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.graphml.impl.EdgeTypeImpl#getTargetPrototype <em>Target Prototype</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.graphml.impl.EdgeTypeImpl#getRoleInSourcePrototype <em>Role In Source Prototype</em>}</li>
 *   <li>{@link org.eclipse.epsilon.emc.graphml.impl.EdgeTypeImpl#getRoleInTargetPrototype <em>Role In Target Prototype</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EdgeTypeImpl extends NodeTypeImpl implements EdgeType {
	/**
	 * The cached value of the '{@link #getSourcePrototype() <em>Source Prototype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourcePrototype()
	 * @generated
	 * @ordered
	 */
	protected SlotPrototype sourcePrototype;

	/**
	 * The cached value of the '{@link #getTargetPrototype() <em>Target Prototype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetPrototype()
	 * @generated
	 * @ordered
	 */
	protected SlotPrototype targetPrototype;

	/**
	 * The cached value of the '{@link #getRoleInSourcePrototype() <em>Role In Source Prototype</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoleInSourcePrototype()
	 * @generated
	 * @ordered
	 */
	protected SlotPrototype roleInSourcePrototype;

	/**
	 * The cached value of the '{@link #getRoleInTargetPrototype() <em>Role In Target Prototype</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoleInTargetPrototype()
	 * @generated
	 * @ordered
	 */
	protected SlotPrototype roleInTargetPrototype;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EdgeTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphmlPackage.Literals.EDGE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SlotPrototype getSourcePrototype() {
		if (sourcePrototype != null && sourcePrototype.eIsProxy()) {
			InternalEObject oldSourcePrototype = (InternalEObject)sourcePrototype;
			sourcePrototype = (SlotPrototype)eResolveProxy(oldSourcePrototype);
			if (sourcePrototype != oldSourcePrototype) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphmlPackage.EDGE_TYPE__SOURCE_PROTOTYPE, oldSourcePrototype, sourcePrototype));
			}
		}
		return sourcePrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SlotPrototype basicGetSourcePrototype() {
		return sourcePrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourcePrototype(SlotPrototype newSourcePrototype) {
		SlotPrototype oldSourcePrototype = sourcePrototype;
		sourcePrototype = newSourcePrototype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphmlPackage.EDGE_TYPE__SOURCE_PROTOTYPE, oldSourcePrototype, sourcePrototype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SlotPrototype getTargetPrototype() {
		if (targetPrototype != null && targetPrototype.eIsProxy()) {
			InternalEObject oldTargetPrototype = (InternalEObject)targetPrototype;
			targetPrototype = (SlotPrototype)eResolveProxy(oldTargetPrototype);
			if (targetPrototype != oldTargetPrototype) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphmlPackage.EDGE_TYPE__TARGET_PROTOTYPE, oldTargetPrototype, targetPrototype));
			}
		}
		return targetPrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SlotPrototype basicGetTargetPrototype() {
		return targetPrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetPrototype(SlotPrototype newTargetPrototype) {
		SlotPrototype oldTargetPrototype = targetPrototype;
		targetPrototype = newTargetPrototype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphmlPackage.EDGE_TYPE__TARGET_PROTOTYPE, oldTargetPrototype, targetPrototype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SlotPrototype getRoleInSourcePrototype() {
		return roleInSourcePrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRoleInSourcePrototype(SlotPrototype newRoleInSourcePrototype, NotificationChain msgs) {
		SlotPrototype oldRoleInSourcePrototype = roleInSourcePrototype;
		roleInSourcePrototype = newRoleInSourcePrototype;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphmlPackage.EDGE_TYPE__ROLE_IN_SOURCE_PROTOTYPE, oldRoleInSourcePrototype, newRoleInSourcePrototype);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoleInSourcePrototype(SlotPrototype newRoleInSourcePrototype) {
		if (newRoleInSourcePrototype != roleInSourcePrototype) {
			NotificationChain msgs = null;
			if (roleInSourcePrototype != null)
				msgs = ((InternalEObject)roleInSourcePrototype).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphmlPackage.EDGE_TYPE__ROLE_IN_SOURCE_PROTOTYPE, null, msgs);
			if (newRoleInSourcePrototype != null)
				msgs = ((InternalEObject)newRoleInSourcePrototype).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphmlPackage.EDGE_TYPE__ROLE_IN_SOURCE_PROTOTYPE, null, msgs);
			msgs = basicSetRoleInSourcePrototype(newRoleInSourcePrototype, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphmlPackage.EDGE_TYPE__ROLE_IN_SOURCE_PROTOTYPE, newRoleInSourcePrototype, newRoleInSourcePrototype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SlotPrototype getRoleInTargetPrototype() {
		return roleInTargetPrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRoleInTargetPrototype(SlotPrototype newRoleInTargetPrototype, NotificationChain msgs) {
		SlotPrototype oldRoleInTargetPrototype = roleInTargetPrototype;
		roleInTargetPrototype = newRoleInTargetPrototype;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphmlPackage.EDGE_TYPE__ROLE_IN_TARGET_PROTOTYPE, oldRoleInTargetPrototype, newRoleInTargetPrototype);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoleInTargetPrototype(SlotPrototype newRoleInTargetPrototype) {
		if (newRoleInTargetPrototype != roleInTargetPrototype) {
			NotificationChain msgs = null;
			if (roleInTargetPrototype != null)
				msgs = ((InternalEObject)roleInTargetPrototype).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphmlPackage.EDGE_TYPE__ROLE_IN_TARGET_PROTOTYPE, null, msgs);
			if (newRoleInTargetPrototype != null)
				msgs = ((InternalEObject)newRoleInTargetPrototype).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphmlPackage.EDGE_TYPE__ROLE_IN_TARGET_PROTOTYPE, null, msgs);
			msgs = basicSetRoleInTargetPrototype(newRoleInTargetPrototype, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphmlPackage.EDGE_TYPE__ROLE_IN_TARGET_PROTOTYPE, newRoleInTargetPrototype, newRoleInTargetPrototype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphmlPackage.EDGE_TYPE__ROLE_IN_SOURCE_PROTOTYPE:
				return basicSetRoleInSourcePrototype(null, msgs);
			case GraphmlPackage.EDGE_TYPE__ROLE_IN_TARGET_PROTOTYPE:
				return basicSetRoleInTargetPrototype(null, msgs);
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
			case GraphmlPackage.EDGE_TYPE__SOURCE_PROTOTYPE:
				if (resolve) return getSourcePrototype();
				return basicGetSourcePrototype();
			case GraphmlPackage.EDGE_TYPE__TARGET_PROTOTYPE:
				if (resolve) return getTargetPrototype();
				return basicGetTargetPrototype();
			case GraphmlPackage.EDGE_TYPE__ROLE_IN_SOURCE_PROTOTYPE:
				return getRoleInSourcePrototype();
			case GraphmlPackage.EDGE_TYPE__ROLE_IN_TARGET_PROTOTYPE:
				return getRoleInTargetPrototype();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GraphmlPackage.EDGE_TYPE__SOURCE_PROTOTYPE:
				setSourcePrototype((SlotPrototype)newValue);
				return;
			case GraphmlPackage.EDGE_TYPE__TARGET_PROTOTYPE:
				setTargetPrototype((SlotPrototype)newValue);
				return;
			case GraphmlPackage.EDGE_TYPE__ROLE_IN_SOURCE_PROTOTYPE:
				setRoleInSourcePrototype((SlotPrototype)newValue);
				return;
			case GraphmlPackage.EDGE_TYPE__ROLE_IN_TARGET_PROTOTYPE:
				setRoleInTargetPrototype((SlotPrototype)newValue);
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
			case GraphmlPackage.EDGE_TYPE__SOURCE_PROTOTYPE:
				setSourcePrototype((SlotPrototype)null);
				return;
			case GraphmlPackage.EDGE_TYPE__TARGET_PROTOTYPE:
				setTargetPrototype((SlotPrototype)null);
				return;
			case GraphmlPackage.EDGE_TYPE__ROLE_IN_SOURCE_PROTOTYPE:
				setRoleInSourcePrototype((SlotPrototype)null);
				return;
			case GraphmlPackage.EDGE_TYPE__ROLE_IN_TARGET_PROTOTYPE:
				setRoleInTargetPrototype((SlotPrototype)null);
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
			case GraphmlPackage.EDGE_TYPE__SOURCE_PROTOTYPE:
				return sourcePrototype != null;
			case GraphmlPackage.EDGE_TYPE__TARGET_PROTOTYPE:
				return targetPrototype != null;
			case GraphmlPackage.EDGE_TYPE__ROLE_IN_SOURCE_PROTOTYPE:
				return roleInSourcePrototype != null;
			case GraphmlPackage.EDGE_TYPE__ROLE_IN_TARGET_PROTOTYPE:
				return roleInTargetPrototype != null;
		}
		return super.eIsSet(featureID);
	}

} //EdgeTypeImpl
