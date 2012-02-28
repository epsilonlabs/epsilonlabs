/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package EpsilonCoverage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Coverage Strategy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link EpsilonCoverage.CoverageStrategy#getType <em>Type</em>}</li>
 *   <li>{@link EpsilonCoverage.CoverageStrategy#getPoints <em>Points</em>}</li>
 * </ul>
 * </p>
 *
 * @see EpsilonCoverage.EpsilonCoveragePackage#getCoverageStrategy()
 * @model
 * @generated
 */
public interface CoverageStrategy extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link EpsilonCoverage.CoverageType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see EpsilonCoverage.CoverageType
	 * @see #setType(CoverageType)
	 * @see EpsilonCoverage.EpsilonCoveragePackage#getCoverageStrategy_Type()
	 * @model
	 * @generated
	 */
	CoverageType getType();

	/**
	 * Sets the value of the '{@link EpsilonCoverage.CoverageStrategy#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see EpsilonCoverage.CoverageType
	 * @see #getType()
	 * @generated
	 */
	void setType(CoverageType value);

	/**
	 * Returns the value of the '<em><b>Points</b></em>' containment reference list.
	 * The list contents are of type {@link EpsilonCoverage.CoveragePoint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Points</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Points</em>' containment reference list.
	 * @see EpsilonCoverage.EpsilonCoveragePackage#getCoverageStrategy_Points()
	 * @model containment="true"
	 * @generated
	 */
	EList<CoveragePoint> getPoints();

} // CoverageStrategy
