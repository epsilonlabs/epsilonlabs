/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package EpsilonCoverage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Coverage Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link EpsilonCoverage.BooleanCoveragePoint#isTrueBranchCovered <em>True Branch Covered</em>}</li>
 *   <li>{@link EpsilonCoverage.BooleanCoveragePoint#isFalseBranchCovered <em>False Branch Covered</em>}</li>
 * </ul>
 * </p>
 *
 * @see EpsilonCoverage.EpsilonCoveragePackage#getBooleanCoveragePoint()
 * @model
 * @generated
 */
public interface BooleanCoveragePoint extends CoveragePoint {
	/**
	 * Returns the value of the '<em><b>True Branch Covered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>True Branch Covered</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>True Branch Covered</em>' attribute.
	 * @see #setTrueBranchCovered(boolean)
	 * @see EpsilonCoverage.EpsilonCoveragePackage#getBooleanCoveragePoint_TrueBranchCovered()
	 * @model
	 * @generated
	 */
	boolean isTrueBranchCovered();

	/**
	 * Sets the value of the '{@link EpsilonCoverage.BooleanCoveragePoint#isTrueBranchCovered <em>True Branch Covered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>True Branch Covered</em>' attribute.
	 * @see #isTrueBranchCovered()
	 * @generated
	 */
	void setTrueBranchCovered(boolean value);

	/**
	 * Returns the value of the '<em><b>False Branch Covered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>False Branch Covered</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>False Branch Covered</em>' attribute.
	 * @see #setFalseBranchCovered(boolean)
	 * @see EpsilonCoverage.EpsilonCoveragePackage#getBooleanCoveragePoint_FalseBranchCovered()
	 * @model
	 * @generated
	 */
	boolean isFalseBranchCovered();

	/**
	 * Sets the value of the '{@link EpsilonCoverage.BooleanCoveragePoint#isFalseBranchCovered <em>False Branch Covered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>False Branch Covered</em>' attribute.
	 * @see #isFalseBranchCovered()
	 * @generated
	 */
	void setFalseBranchCovered(boolean value);

} // BooleanCoveragePoint
