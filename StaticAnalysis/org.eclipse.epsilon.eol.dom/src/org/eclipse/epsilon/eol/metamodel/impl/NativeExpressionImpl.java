/**
 */
package org.eclipse.epsilon.eol.metamodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.epsilon.eol.eol.EolPackage;

import org.eclipse.epsilon.eol.metamodel.BooleanExpression;
import org.eclipse.epsilon.eol.metamodel.NativeExpression;
import org.eclipse.epsilon.eol.metamodel.StringExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Native Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.NativeExpressionImpl#getNativeExpr <em>Native Expr</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.NativeExpressionImpl#getIsType <em>Is Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NativeExpressionImpl extends LiteralExpressionImpl implements NativeExpression {
	/**
	 * The cached value of the '{@link #getNativeExpr() <em>Native Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNativeExpr()
	 * @generated
	 * @ordered
	 */
	protected StringExpression nativeExpr;

	/**
	 * The cached value of the '{@link #getIsType() <em>Is Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsType()
	 * @generated
	 * @ordered
	 */
	protected BooleanExpression isType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NativeExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EolPackage.Literals.NATIVE_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringExpression getNativeExpr() {
		return nativeExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNativeExpr(StringExpression newNativeExpr, NotificationChain msgs) {
		StringExpression oldNativeExpr = nativeExpr;
		nativeExpr = newNativeExpr;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EolPackage.NATIVE_EXPRESSION__NATIVE_EXPR, oldNativeExpr, newNativeExpr);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNativeExpr(StringExpression newNativeExpr) {
		if (newNativeExpr != nativeExpr) {
			NotificationChain msgs = null;
			if (nativeExpr != null)
				msgs = ((InternalEObject)nativeExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EolPackage.NATIVE_EXPRESSION__NATIVE_EXPR, null, msgs);
			if (newNativeExpr != null)
				msgs = ((InternalEObject)newNativeExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EolPackage.NATIVE_EXPRESSION__NATIVE_EXPR, null, msgs);
			msgs = basicSetNativeExpr(newNativeExpr, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.NATIVE_EXPRESSION__NATIVE_EXPR, newNativeExpr, newNativeExpr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanExpression getIsType() {
		return isType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIsType(BooleanExpression newIsType, NotificationChain msgs) {
		BooleanExpression oldIsType = isType;
		isType = newIsType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EolPackage.NATIVE_EXPRESSION__IS_TYPE, oldIsType, newIsType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsType(BooleanExpression newIsType) {
		if (newIsType != isType) {
			NotificationChain msgs = null;
			if (isType != null)
				msgs = ((InternalEObject)isType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EolPackage.NATIVE_EXPRESSION__IS_TYPE, null, msgs);
			if (newIsType != null)
				msgs = ((InternalEObject)newIsType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EolPackage.NATIVE_EXPRESSION__IS_TYPE, null, msgs);
			msgs = basicSetIsType(newIsType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.NATIVE_EXPRESSION__IS_TYPE, newIsType, newIsType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EolPackage.NATIVE_EXPRESSION__NATIVE_EXPR:
				return basicSetNativeExpr(null, msgs);
			case EolPackage.NATIVE_EXPRESSION__IS_TYPE:
				return basicSetIsType(null, msgs);
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
			case EolPackage.NATIVE_EXPRESSION__NATIVE_EXPR:
				return getNativeExpr();
			case EolPackage.NATIVE_EXPRESSION__IS_TYPE:
				return getIsType();
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
			case EolPackage.NATIVE_EXPRESSION__NATIVE_EXPR:
				setNativeExpr((StringExpression)newValue);
				return;
			case EolPackage.NATIVE_EXPRESSION__IS_TYPE:
				setIsType((BooleanExpression)newValue);
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
			case EolPackage.NATIVE_EXPRESSION__NATIVE_EXPR:
				setNativeExpr((StringExpression)null);
				return;
			case EolPackage.NATIVE_EXPRESSION__IS_TYPE:
				setIsType((BooleanExpression)null);
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
			case EolPackage.NATIVE_EXPRESSION__NATIVE_EXPR:
				return nativeExpr != null;
			case EolPackage.NATIVE_EXPRESSION__IS_TYPE:
				return isType != null;
		}
		return super.eIsSet(featureID);
	}

} //NativeExpressionImpl
