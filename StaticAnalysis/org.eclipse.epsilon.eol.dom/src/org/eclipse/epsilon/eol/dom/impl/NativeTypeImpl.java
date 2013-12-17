/**
 */
package org.eclipse.epsilon.eol.dom.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.epsilon.eol.dom.EolPackage;
import org.eclipse.epsilon.eol.dom.NativeType;
import org.eclipse.epsilon.eol.dom.StringExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Native Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.dom.impl.NativeTypeImpl#getNativeExpression <em>Native Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NativeTypeImpl extends TypeImpl implements NativeType {
	/**
	 * The cached value of the '{@link #getNativeExpression() <em>Native Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNativeExpression()
	 * @generated
	 * @ordered
	 */
	protected StringExpression nativeExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NativeTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EolPackage.Literals.NATIVE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringExpression getNativeExpression() {
		return nativeExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNativeExpression(StringExpression newNativeExpression, NotificationChain msgs) {
		StringExpression oldNativeExpression = nativeExpression;
		nativeExpression = newNativeExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EolPackage.NATIVE_TYPE__NATIVE_EXPRESSION, oldNativeExpression, newNativeExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNativeExpression(StringExpression newNativeExpression) {
		if (newNativeExpression != nativeExpression) {
			NotificationChain msgs = null;
			if (nativeExpression != null)
				msgs = ((InternalEObject)nativeExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EolPackage.NATIVE_TYPE__NATIVE_EXPRESSION, null, msgs);
			if (newNativeExpression != null)
				msgs = ((InternalEObject)newNativeExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EolPackage.NATIVE_TYPE__NATIVE_EXPRESSION, null, msgs);
			msgs = basicSetNativeExpression(newNativeExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.NATIVE_TYPE__NATIVE_EXPRESSION, newNativeExpression, newNativeExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EolPackage.NATIVE_TYPE__NATIVE_EXPRESSION:
				return basicSetNativeExpression(null, msgs);
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
			case EolPackage.NATIVE_TYPE__NATIVE_EXPRESSION:
				return getNativeExpression();
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
			case EolPackage.NATIVE_TYPE__NATIVE_EXPRESSION:
				setNativeExpression((StringExpression)newValue);
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
			case EolPackage.NATIVE_TYPE__NATIVE_EXPRESSION:
				setNativeExpression((StringExpression)null);
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
			case EolPackage.NATIVE_TYPE__NATIVE_EXPRESSION:
				return nativeExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //NativeTypeImpl
