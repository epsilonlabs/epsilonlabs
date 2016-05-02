/**
 */
package org.eclipse.epsilon.eol.metamodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.epsilon.eol.metamodel.EolPackage;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.FeatureCallExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Call Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.FeatureCallExpressionImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.impl.FeatureCallExpressionImpl#isIsArrow <em>Is Arrow</em>}</li>
 * </ul>
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
	 * The default value of the '{@link #isIsArrow() <em>Is Arrow</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsArrow()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ARROW_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsArrow() <em>Is Arrow</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsArrow()
	 * @generated
	 * @ordered
	 */
	protected boolean isArrow = IS_ARROW_EDEFAULT;

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
	public boolean isIsArrow() {
		return isArrow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsArrow(boolean newIsArrow) {
		boolean oldIsArrow = isArrow;
		isArrow = newIsArrow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.FEATURE_CALL_EXPRESSION__IS_ARROW, oldIsArrow, isArrow));
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
				return isIsArrow();
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
				setIsArrow((Boolean)newValue);
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
				setIsArrow(IS_ARROW_EDEFAULT);
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
				return isArrow != IS_ARROW_EDEFAULT;
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
		result.append(" (isArrow: ");
		result.append(isArrow);
		result.append(')');
		return result.toString();
	}

} //FeatureCallExpressionImpl
