/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package EpsilonCoverage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see EpsilonCoverage.EpsilonCoveragePackage
 * @generated
 */
public interface EpsilonCoverageFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EpsilonCoverageFactory eINSTANCE = EpsilonCoverage.impl.EpsilonCoverageFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Coverage Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Coverage Model</em>'.
	 * @generated
	 */
	CoverageModel createCoverageModel();

	/**
	 * Returns a new object of class '<em>Coverage Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Coverage Strategy</em>'.
	 * @generated
	 */
	CoverageStrategy createCoverageStrategy();

	/**
	 * Returns a new object of class '<em>Coverage Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Coverage Point</em>'.
	 * @generated
	 */
	CoveragePoint createCoveragePoint();

	/**
	 * Returns a new object of class '<em>Boolean Coverage Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Coverage Point</em>'.
	 * @generated
	 */
	BooleanCoveragePoint createBooleanCoveragePoint();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EpsilonCoveragePackage getEpsilonCoveragePackage();

} //EpsilonCoverageFactory
