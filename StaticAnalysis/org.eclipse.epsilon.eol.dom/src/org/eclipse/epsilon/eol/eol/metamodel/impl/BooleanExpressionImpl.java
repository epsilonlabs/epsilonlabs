/**
 */
package org.eclipse.epsilon.eol.eol.metamodel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.epsilon.eol.eol.metamodel.BooleanExpression;
import org.eclipse.epsilon.eol.eol.metamodel.EolPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boolean Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.eol.metamodel.impl.BooleanExpressionImpl#isVal <em>Val</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BooleanExpressionImpl extends PrimitiveExpressionImpl implements BooleanExpression {
	/**
	 * The default value of the '{@link #isVal() <em>Val</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isVal() <em>Val</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVal()
	 * @generated
	 * @ordered
	 */
	protected boolean val = VAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BooleanExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EolPackage.Literals.BOOLEAN_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isVal() {
		return val;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVal(boolean newVal) {
		boolean oldVal = val;
		val = newVal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EolPackage.BOOLEAN_EXPRESSION__VAL, oldVal, val));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EolPackage.BOOLEAN_EXPRESSION__VAL:
				return isVal();
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
			case EolPackage.BOOLEAN_EXPRESSION__VAL:
				setVal((Boolean)newValue);
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
			case EolPackage.BOOLEAN_EXPRESSION__VAL:
				setVal(VAL_EDEFAULT);
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
			case EolPackage.BOOLEAN_EXPRESSION__VAL:
				return val != VAL_EDEFAULT;
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
		result.append(" (val: ");
		result.append(val);
		result.append(')');
		return result.toString();
	}

} //BooleanExpressionImpl
