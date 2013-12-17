/**
 */
package org.eclipse.epsilon.eol.dom.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.epsilon.eol.dom.AnyType;
import org.eclipse.epsilon.eol.dom.EolPackage;
import org.eclipse.epsilon.eol.dom.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Any Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.dom.impl.AnyTypeImpl#getTempType <em>Temp Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnyTypeImpl extends TypeImpl implements AnyType {
	/**
	 * The cached value of the '{@link #getTempType() <em>Temp Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTempType()
	 * @generated
	 * @ordered
	 */
	protected Type tempType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnyTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EolPackage.Literals.ANY_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getTempType() {
		return tempType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTempType(Type newTempType, NotificationChain msgs) {
		Type oldTempType = tempType;
		tempType = newTempType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EolPackage.ANY_TYPE__TEMP_TYPE, oldTempType, newTempType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTempType(Type newTempType) {
		if (newTempType != tempType) {
			NotificationChain msgs = null;
			if (tempType != null)
				msgs = ((InternalEObject)tempType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EolPackage.ANY_TYPE__TEMP_TYPE, null, msgs);
			if (newTempType != null)
				msgs = ((InternalEObject)newTempType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EolPackage.ANY_TYPE__TEMP_TYPE, null, msgs);
			msgs = basicSetTempType(newTempType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.ANY_TYPE__TEMP_TYPE, newTempType, newTempType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EolPackage.ANY_TYPE__TEMP_TYPE:
				return basicSetTempType(null, msgs);
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
			case EolPackage.ANY_TYPE__TEMP_TYPE:
				return getTempType();
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
			case EolPackage.ANY_TYPE__TEMP_TYPE:
				setTempType((Type)newValue);
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
			case EolPackage.ANY_TYPE__TEMP_TYPE:
				setTempType((Type)null);
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
			case EolPackage.ANY_TYPE__TEMP_TYPE:
				return tempType != null;
		}
		return super.eIsSet(featureID);
	}

} //AnyTypeImpl
