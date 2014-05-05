/**
 */
package org.eclipse.epsilon.eol.metamodel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.epsilon.eol.metamodel.EType;
import org.eclipse.epsilon.eol.metamodel.EolPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EType</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.ETypeImpl#getEcoreType <em>Ecore Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ETypeImpl extends TypeImpl implements EType {
	/**
	 * The cached value of the '{@link #getEcoreType() <em>Ecore Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEcoreType()
	 * @generated
	 * @ordered
	 */
	protected EClassifier ecoreType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ETypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EolPackage.Literals.ETYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier getEcoreType() {
		if (ecoreType != null && ecoreType.eIsProxy()) {
			InternalEObject oldEcoreType = (InternalEObject)ecoreType;
			ecoreType = (EClassifier)eResolveProxy(oldEcoreType);
			if (ecoreType != oldEcoreType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EolPackage.ETYPE__ECORE_TYPE, oldEcoreType, ecoreType));
			}
		}
		return ecoreType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier basicGetEcoreType() {
		return ecoreType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEcoreType(EClassifier newEcoreType) {
		EClassifier oldEcoreType = ecoreType;
		ecoreType = newEcoreType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.ETYPE__ECORE_TYPE, oldEcoreType, ecoreType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EolPackage.ETYPE__ECORE_TYPE:
				if (resolve) return getEcoreType();
				return basicGetEcoreType();
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
			case EolPackage.ETYPE__ECORE_TYPE:
				setEcoreType((EClassifier)newValue);
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
			case EolPackage.ETYPE__ECORE_TYPE:
				setEcoreType((EClassifier)null);
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
			case EolPackage.ETYPE__ECORE_TYPE:
				return ecoreType != null;
		}
		return super.eIsSet(featureID);
	}

} //ETypeImpl
