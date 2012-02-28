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
 * A representation of the model object '<em><b>Coverage Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link EpsilonCoverage.CoverageModel#getStrategies <em>Strategies</em>}</li>
 * </ul>
 * </p>
 *
 * @see EpsilonCoverage.EpsilonCoveragePackage#getCoverageModel()
 * @model
 * @generated
 */
public interface CoverageModel extends EObject {

	/**
	 * Returns the value of the '<em><b>Strategies</b></em>' containment reference list.
	 * The list contents are of type {@link EpsilonCoverage.CoverageStrategy}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Strategies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strategies</em>' containment reference list.
	 * @see EpsilonCoverage.EpsilonCoveragePackage#getCoverageModel_Strategies()
	 * @model containment="true"
	 * @generated
	 */
	EList<CoverageStrategy> getStrategies();
} // CoverageModel
