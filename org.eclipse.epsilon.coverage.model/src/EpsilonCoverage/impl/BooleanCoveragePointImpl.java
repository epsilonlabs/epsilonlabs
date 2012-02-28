/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package EpsilonCoverage.impl;

import EpsilonCoverage.BooleanCoveragePoint;
import EpsilonCoverage.EpsilonCoveragePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boolean Coverage Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link EpsilonCoverage.impl.BooleanCoveragePointImpl#isTrueBranchCovered <em>True Branch Covered</em>}</li>
 *   <li>{@link EpsilonCoverage.impl.BooleanCoveragePointImpl#isFalseBranchCovered <em>False Branch Covered</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BooleanCoveragePointImpl extends CoveragePointImpl implements BooleanCoveragePoint {
	/**
	 * The default value of the '{@link #isTrueBranchCovered() <em>True Branch Covered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTrueBranchCovered()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRUE_BRANCH_COVERED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTrueBranchCovered() <em>True Branch Covered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTrueBranchCovered()
	 * @generated
	 * @ordered
	 */
	protected boolean trueBranchCovered = TRUE_BRANCH_COVERED_EDEFAULT;

	/**
	 * The default value of the '{@link #isFalseBranchCovered() <em>False Branch Covered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFalseBranchCovered()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FALSE_BRANCH_COVERED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFalseBranchCovered() <em>False Branch Covered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFalseBranchCovered()
	 * @generated
	 * @ordered
	 */
	protected boolean falseBranchCovered = FALSE_BRANCH_COVERED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BooleanCoveragePointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EpsilonCoveragePackage.Literals.BOOLEAN_COVERAGE_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTrueBranchCovered() {
		return trueBranchCovered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrueBranchCovered(boolean newTrueBranchCovered) {
		boolean oldTrueBranchCovered = trueBranchCovered;
		trueBranchCovered = newTrueBranchCovered;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EpsilonCoveragePackage.BOOLEAN_COVERAGE_POINT__TRUE_BRANCH_COVERED, oldTrueBranchCovered, trueBranchCovered));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFalseBranchCovered() {
		return falseBranchCovered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFalseBranchCovered(boolean newFalseBranchCovered) {
		boolean oldFalseBranchCovered = falseBranchCovered;
		falseBranchCovered = newFalseBranchCovered;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EpsilonCoveragePackage.BOOLEAN_COVERAGE_POINT__FALSE_BRANCH_COVERED, oldFalseBranchCovered, falseBranchCovered));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EpsilonCoveragePackage.BOOLEAN_COVERAGE_POINT__TRUE_BRANCH_COVERED:
				return isTrueBranchCovered();
			case EpsilonCoveragePackage.BOOLEAN_COVERAGE_POINT__FALSE_BRANCH_COVERED:
				return isFalseBranchCovered();
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
			case EpsilonCoveragePackage.BOOLEAN_COVERAGE_POINT__TRUE_BRANCH_COVERED:
				setTrueBranchCovered((Boolean)newValue);
				return;
			case EpsilonCoveragePackage.BOOLEAN_COVERAGE_POINT__FALSE_BRANCH_COVERED:
				setFalseBranchCovered((Boolean)newValue);
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
			case EpsilonCoveragePackage.BOOLEAN_COVERAGE_POINT__TRUE_BRANCH_COVERED:
				setTrueBranchCovered(TRUE_BRANCH_COVERED_EDEFAULT);
				return;
			case EpsilonCoveragePackage.BOOLEAN_COVERAGE_POINT__FALSE_BRANCH_COVERED:
				setFalseBranchCovered(FALSE_BRANCH_COVERED_EDEFAULT);
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
			case EpsilonCoveragePackage.BOOLEAN_COVERAGE_POINT__TRUE_BRANCH_COVERED:
				return trueBranchCovered != TRUE_BRANCH_COVERED_EDEFAULT;
			case EpsilonCoveragePackage.BOOLEAN_COVERAGE_POINT__FALSE_BRANCH_COVERED:
				return falseBranchCovered != FALSE_BRANCH_COVERED_EDEFAULT;
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
		result.append(" (trueBranchCovered: ");
		result.append(trueBranchCovered);
		result.append(", falseBranchCovered: ");
		result.append(falseBranchCovered);
		result.append(')');
		return result.toString();
	}

} //BooleanCoveragePointImpl
