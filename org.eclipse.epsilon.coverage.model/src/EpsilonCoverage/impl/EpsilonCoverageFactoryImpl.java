/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package EpsilonCoverage.impl;

import EpsilonCoverage.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EpsilonCoverageFactoryImpl extends EFactoryImpl implements EpsilonCoverageFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EpsilonCoverageFactory init() {
		try {
			EpsilonCoverageFactory theEpsilonCoverageFactory = (EpsilonCoverageFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/epsilon/coverage"); 
			if (theEpsilonCoverageFactory != null) {
				return theEpsilonCoverageFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EpsilonCoverageFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EpsilonCoverageFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EpsilonCoveragePackage.COVERAGE_MODEL: return createCoverageModel();
			case EpsilonCoveragePackage.COVERAGE_STRATEGY: return createCoverageStrategy();
			case EpsilonCoveragePackage.COVERAGE_POINT: return createCoveragePoint();
			case EpsilonCoveragePackage.BOOLEAN_COVERAGE_POINT: return createBooleanCoveragePoint();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case EpsilonCoveragePackage.COVERAGE_TYPE:
				return createCoverageTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case EpsilonCoveragePackage.COVERAGE_TYPE:
				return convertCoverageTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoverageModel createCoverageModel() {
		CoverageModelImpl coverageModel = new CoverageModelImpl();
		return coverageModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoverageStrategy createCoverageStrategy() {
		CoverageStrategyImpl coverageStrategy = new CoverageStrategyImpl();
		return coverageStrategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoveragePoint createCoveragePoint() {
		CoveragePointImpl coveragePoint = new CoveragePointImpl();
		return coveragePoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanCoveragePoint createBooleanCoveragePoint() {
		BooleanCoveragePointImpl booleanCoveragePoint = new BooleanCoveragePointImpl();
		return booleanCoveragePoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoverageType createCoverageTypeFromString(EDataType eDataType, String initialValue) {
		CoverageType result = CoverageType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCoverageTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EpsilonCoveragePackage getEpsilonCoveragePackage() {
		return (EpsilonCoveragePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EpsilonCoveragePackage getPackage() {
		return EpsilonCoveragePackage.eINSTANCE;
	}

} //EpsilonCoverageFactoryImpl
