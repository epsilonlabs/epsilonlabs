/**
 */
package org.eclipse.epsilon.eol.metamodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.epsilon.eol.eol.BooleanExpression;
import org.eclipse.epsilon.eol.eol.EolPackage;
import org.eclipse.epsilon.eol.eol.Expression;
import org.eclipse.epsilon.eol.eol.FeatureCallExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Call Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.FeatureCallExpressionImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.FeatureCallExpressionImpl#getIsArrow <em>Is Arrow</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FeatureCallExpressionImpl extends ExpressionImpl implements FeatureCallExpression {
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Expression target;

	/**
	 * The cached value of the '{@link #getIsArrow() <em>Is Arrow</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsArrow()
	 * @generated
	 * @ordered
	 */
	protected BooleanExpression isArrow;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureCallExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EolPackage.Literals.FEATURE_CALL_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(Expression newTarget, NotificationChain msgs) {
		Expression oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EolPackage.FEATURE_CALL_EXPRESSION__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Expression newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EolPackage.FEATURE_CALL_EXPRESSION__TARGET, null, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EolPackage.FEATURE_CALL_EXPRESSION__TARGET, null, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.FEATURE_CALL_EXPRESSION__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanExpression getIsArrow() {
		return isArrow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIsArrow(BooleanExpression newIsArrow, NotificationChain msgs) {
		BooleanExpression oldIsArrow = isArrow;
		isArrow = newIsArrow;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EolPackage.FEATURE_CALL_EXPRESSION__IS_ARROW, oldIsArrow, newIsArrow);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsArrow(BooleanExpression newIsArrow) {
		if (newIsArrow != isArrow) {
			NotificationChain msgs = null;
			if (isArrow != null)
				msgs = ((InternalEObject)isArrow).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EolPackage.FEATURE_CALL_EXPRESSION__IS_ARROW, null, msgs);
			if (newIsArrow != null)
				msgs = ((InternalEObject)newIsArrow).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EolPackage.FEATURE_CALL_EXPRESSION__IS_ARROW, null, msgs);
			msgs = basicSetIsArrow(newIsArrow, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.FEATURE_CALL_EXPRESSION__IS_ARROW, newIsArrow, newIsArrow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EolPackage.FEATURE_CALL_EXPRESSION__TARGET:
				return basicSetTarget(null, msgs);
			case EolPackage.FEATURE_CALL_EXPRESSION__IS_ARROW:
				return basicSetIsArrow(null, msgs);
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
			case EolPackage.FEATURE_CALL_EXPRESSION__TARGET:
				return getTarget();
			case EolPackage.FEATURE_CALL_EXPRESSION__IS_ARROW:
				return getIsArrow();
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
			case EolPackage.FEATURE_CALL_EXPRESSION__TARGET:
				setTarget((Expression)newValue);
				return;
			case EolPackage.FEATURE_CALL_EXPRESSION__IS_ARROW:
				setIsArrow((BooleanExpression)newValue);
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
			case EolPackage.FEATURE_CALL_EXPRESSION__TARGET:
				setTarget((Expression)null);
				return;
			case EolPackage.FEATURE_CALL_EXPRESSION__IS_ARROW:
				setIsArrow((BooleanExpression)null);
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
			case EolPackage.FEATURE_CALL_EXPRESSION__TARGET:
				return target != null;
			case EolPackage.FEATURE_CALL_EXPRESSION__IS_ARROW:
				return isArrow != null;
		}
		return super.eIsSet(featureID);
	}

} //FeatureCallExpressionImpl
