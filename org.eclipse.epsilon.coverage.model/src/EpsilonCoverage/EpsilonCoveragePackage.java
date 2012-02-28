/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package EpsilonCoverage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see EpsilonCoverage.EpsilonCoverageFactory
 * @model kind="package"
 * @generated
 */
public interface EpsilonCoveragePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "EpsilonCoverage";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/epsilon/coverage";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.epsilon.coverage";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EpsilonCoveragePackage eINSTANCE = EpsilonCoverage.impl.EpsilonCoveragePackageImpl.init();

	/**
	 * The meta object id for the '{@link EpsilonCoverage.impl.CoverageModelImpl <em>Coverage Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EpsilonCoverage.impl.CoverageModelImpl
	 * @see EpsilonCoverage.impl.EpsilonCoveragePackageImpl#getCoverageModel()
	 * @generated
	 */
	int COVERAGE_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Strategies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_MODEL__STRATEGIES = 0;

	/**
	 * The number of structural features of the '<em>Coverage Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_MODEL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link EpsilonCoverage.impl.CoverageStrategyImpl <em>Coverage Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EpsilonCoverage.impl.CoverageStrategyImpl
	 * @see EpsilonCoverage.impl.EpsilonCoveragePackageImpl#getCoverageStrategy()
	 * @generated
	 */
	int COVERAGE_STRATEGY = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_STRATEGY__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_STRATEGY__POINTS = 1;

	/**
	 * The number of structural features of the '<em>Coverage Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_STRATEGY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link EpsilonCoverage.impl.CoveragePointImpl <em>Coverage Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EpsilonCoverage.impl.CoveragePointImpl
	 * @see EpsilonCoverage.impl.EpsilonCoveragePackageImpl#getCoveragePoint()
	 * @generated
	 */
	int COVERAGE_POINT = 2;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_POINT__LINE = 0;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_POINT__COLUMN = 1;

	/**
	 * The feature id for the '<em><b>Ast Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_POINT__AST_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Times Executed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_POINT__TIMES_EXECUTED = 3;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_POINT__URI = 4;

	/**
	 * The number of structural features of the '<em>Coverage Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_POINT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link EpsilonCoverage.impl.BooleanCoveragePointImpl <em>Boolean Coverage Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EpsilonCoverage.impl.BooleanCoveragePointImpl
	 * @see EpsilonCoverage.impl.EpsilonCoveragePackageImpl#getBooleanCoveragePoint()
	 * @generated
	 */
	int BOOLEAN_COVERAGE_POINT = 3;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_COVERAGE_POINT__LINE = COVERAGE_POINT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_COVERAGE_POINT__COLUMN = COVERAGE_POINT__COLUMN;

	/**
	 * The feature id for the '<em><b>Ast Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_COVERAGE_POINT__AST_TYPE = COVERAGE_POINT__AST_TYPE;

	/**
	 * The feature id for the '<em><b>Times Executed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_COVERAGE_POINT__TIMES_EXECUTED = COVERAGE_POINT__TIMES_EXECUTED;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_COVERAGE_POINT__URI = COVERAGE_POINT__URI;

	/**
	 * The feature id for the '<em><b>True Branch Covered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_COVERAGE_POINT__TRUE_BRANCH_COVERED = COVERAGE_POINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>False Branch Covered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_COVERAGE_POINT__FALSE_BRANCH_COVERED = COVERAGE_POINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Boolean Coverage Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_COVERAGE_POINT_FEATURE_COUNT = COVERAGE_POINT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link EpsilonCoverage.CoverageType <em>Coverage Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EpsilonCoverage.CoverageType
	 * @see EpsilonCoverage.impl.EpsilonCoveragePackageImpl#getCoverageType()
	 * @generated
	 */
	int COVERAGE_TYPE = 4;


	/**
	 * Returns the meta object for class '{@link EpsilonCoverage.CoverageModel <em>Coverage Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Coverage Model</em>'.
	 * @see EpsilonCoverage.CoverageModel
	 * @generated
	 */
	EClass getCoverageModel();

	/**
	 * Returns the meta object for the containment reference list '{@link EpsilonCoverage.CoverageModel#getStrategies <em>Strategies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Strategies</em>'.
	 * @see EpsilonCoverage.CoverageModel#getStrategies()
	 * @see #getCoverageModel()
	 * @generated
	 */
	EReference getCoverageModel_Strategies();

	/**
	 * Returns the meta object for class '{@link EpsilonCoverage.CoverageStrategy <em>Coverage Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Coverage Strategy</em>'.
	 * @see EpsilonCoverage.CoverageStrategy
	 * @generated
	 */
	EClass getCoverageStrategy();

	/**
	 * Returns the meta object for the attribute '{@link EpsilonCoverage.CoverageStrategy#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see EpsilonCoverage.CoverageStrategy#getType()
	 * @see #getCoverageStrategy()
	 * @generated
	 */
	EAttribute getCoverageStrategy_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link EpsilonCoverage.CoverageStrategy#getPoints <em>Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Points</em>'.
	 * @see EpsilonCoverage.CoverageStrategy#getPoints()
	 * @see #getCoverageStrategy()
	 * @generated
	 */
	EReference getCoverageStrategy_Points();

	/**
	 * Returns the meta object for class '{@link EpsilonCoverage.CoveragePoint <em>Coverage Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Coverage Point</em>'.
	 * @see EpsilonCoverage.CoveragePoint
	 * @generated
	 */
	EClass getCoveragePoint();

	/**
	 * Returns the meta object for the attribute '{@link EpsilonCoverage.CoveragePoint#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see EpsilonCoverage.CoveragePoint#getLine()
	 * @see #getCoveragePoint()
	 * @generated
	 */
	EAttribute getCoveragePoint_Line();

	/**
	 * Returns the meta object for the attribute '{@link EpsilonCoverage.CoveragePoint#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Column</em>'.
	 * @see EpsilonCoverage.CoveragePoint#getColumn()
	 * @see #getCoveragePoint()
	 * @generated
	 */
	EAttribute getCoveragePoint_Column();

	/**
	 * Returns the meta object for the attribute '{@link EpsilonCoverage.CoveragePoint#getAstType <em>Ast Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ast Type</em>'.
	 * @see EpsilonCoverage.CoveragePoint#getAstType()
	 * @see #getCoveragePoint()
	 * @generated
	 */
	EAttribute getCoveragePoint_AstType();

	/**
	 * Returns the meta object for the attribute '{@link EpsilonCoverage.CoveragePoint#getTimesExecuted <em>Times Executed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Times Executed</em>'.
	 * @see EpsilonCoverage.CoveragePoint#getTimesExecuted()
	 * @see #getCoveragePoint()
	 * @generated
	 */
	EAttribute getCoveragePoint_TimesExecuted();

	/**
	 * Returns the meta object for the attribute '{@link EpsilonCoverage.CoveragePoint#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see EpsilonCoverage.CoveragePoint#getUri()
	 * @see #getCoveragePoint()
	 * @generated
	 */
	EAttribute getCoveragePoint_Uri();

	/**
	 * Returns the meta object for class '{@link EpsilonCoverage.BooleanCoveragePoint <em>Boolean Coverage Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Coverage Point</em>'.
	 * @see EpsilonCoverage.BooleanCoveragePoint
	 * @generated
	 */
	EClass getBooleanCoveragePoint();

	/**
	 * Returns the meta object for the attribute '{@link EpsilonCoverage.BooleanCoveragePoint#isTrueBranchCovered <em>True Branch Covered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>True Branch Covered</em>'.
	 * @see EpsilonCoverage.BooleanCoveragePoint#isTrueBranchCovered()
	 * @see #getBooleanCoveragePoint()
	 * @generated
	 */
	EAttribute getBooleanCoveragePoint_TrueBranchCovered();

	/**
	 * Returns the meta object for the attribute '{@link EpsilonCoverage.BooleanCoveragePoint#isFalseBranchCovered <em>False Branch Covered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>False Branch Covered</em>'.
	 * @see EpsilonCoverage.BooleanCoveragePoint#isFalseBranchCovered()
	 * @see #getBooleanCoveragePoint()
	 * @generated
	 */
	EAttribute getBooleanCoveragePoint_FalseBranchCovered();

	/**
	 * Returns the meta object for enum '{@link EpsilonCoverage.CoverageType <em>Coverage Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Coverage Type</em>'.
	 * @see EpsilonCoverage.CoverageType
	 * @generated
	 */
	EEnum getCoverageType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EpsilonCoverageFactory getEpsilonCoverageFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link EpsilonCoverage.impl.CoverageModelImpl <em>Coverage Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EpsilonCoverage.impl.CoverageModelImpl
		 * @see EpsilonCoverage.impl.EpsilonCoveragePackageImpl#getCoverageModel()
		 * @generated
		 */
		EClass COVERAGE_MODEL = eINSTANCE.getCoverageModel();

		/**
		 * The meta object literal for the '<em><b>Strategies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COVERAGE_MODEL__STRATEGIES = eINSTANCE.getCoverageModel_Strategies();

		/**
		 * The meta object literal for the '{@link EpsilonCoverage.impl.CoverageStrategyImpl <em>Coverage Strategy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EpsilonCoverage.impl.CoverageStrategyImpl
		 * @see EpsilonCoverage.impl.EpsilonCoveragePackageImpl#getCoverageStrategy()
		 * @generated
		 */
		EClass COVERAGE_STRATEGY = eINSTANCE.getCoverageStrategy();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COVERAGE_STRATEGY__TYPE = eINSTANCE.getCoverageStrategy_Type();

		/**
		 * The meta object literal for the '<em><b>Points</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COVERAGE_STRATEGY__POINTS = eINSTANCE.getCoverageStrategy_Points();

		/**
		 * The meta object literal for the '{@link EpsilonCoverage.impl.CoveragePointImpl <em>Coverage Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EpsilonCoverage.impl.CoveragePointImpl
		 * @see EpsilonCoverage.impl.EpsilonCoveragePackageImpl#getCoveragePoint()
		 * @generated
		 */
		EClass COVERAGE_POINT = eINSTANCE.getCoveragePoint();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COVERAGE_POINT__LINE = eINSTANCE.getCoveragePoint_Line();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COVERAGE_POINT__COLUMN = eINSTANCE.getCoveragePoint_Column();

		/**
		 * The meta object literal for the '<em><b>Ast Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COVERAGE_POINT__AST_TYPE = eINSTANCE.getCoveragePoint_AstType();

		/**
		 * The meta object literal for the '<em><b>Times Executed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COVERAGE_POINT__TIMES_EXECUTED = eINSTANCE.getCoveragePoint_TimesExecuted();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COVERAGE_POINT__URI = eINSTANCE.getCoveragePoint_Uri();

		/**
		 * The meta object literal for the '{@link EpsilonCoverage.impl.BooleanCoveragePointImpl <em>Boolean Coverage Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EpsilonCoverage.impl.BooleanCoveragePointImpl
		 * @see EpsilonCoverage.impl.EpsilonCoveragePackageImpl#getBooleanCoveragePoint()
		 * @generated
		 */
		EClass BOOLEAN_COVERAGE_POINT = eINSTANCE.getBooleanCoveragePoint();

		/**
		 * The meta object literal for the '<em><b>True Branch Covered</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_COVERAGE_POINT__TRUE_BRANCH_COVERED = eINSTANCE.getBooleanCoveragePoint_TrueBranchCovered();

		/**
		 * The meta object literal for the '<em><b>False Branch Covered</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_COVERAGE_POINT__FALSE_BRANCH_COVERED = eINSTANCE.getBooleanCoveragePoint_FalseBranchCovered();

		/**
		 * The meta object literal for the '{@link EpsilonCoverage.CoverageType <em>Coverage Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EpsilonCoverage.CoverageType
		 * @see EpsilonCoverage.impl.EpsilonCoveragePackageImpl#getCoverageType()
		 * @generated
		 */
		EEnum COVERAGE_TYPE = eINSTANCE.getCoverageType();

	}

} //EpsilonCoveragePackage
