/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package EpsilonCoverage.impl;

import EpsilonCoverage.BooleanCoveragePoint;
import EpsilonCoverage.CoverageModel;
import EpsilonCoverage.CoveragePoint;
import EpsilonCoverage.CoverageStrategy;
import EpsilonCoverage.CoverageType;
import EpsilonCoverage.EpsilonCoverageFactory;
import EpsilonCoverage.EpsilonCoveragePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EpsilonCoveragePackageImpl extends EPackageImpl implements EpsilonCoveragePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coverageModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coverageStrategyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coveragePointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanCoveragePointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum coverageTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see EpsilonCoverage.EpsilonCoveragePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EpsilonCoveragePackageImpl() {
		super(eNS_URI, EpsilonCoverageFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link EpsilonCoveragePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EpsilonCoveragePackage init() {
		if (isInited) return (EpsilonCoveragePackage)EPackage.Registry.INSTANCE.getEPackage(EpsilonCoveragePackage.eNS_URI);

		// Obtain or create and register package
		EpsilonCoveragePackageImpl theEpsilonCoveragePackage = (EpsilonCoveragePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EpsilonCoveragePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EpsilonCoveragePackageImpl());

		isInited = true;

		// Create package meta-data objects
		theEpsilonCoveragePackage.createPackageContents();

		// Initialize created meta-data
		theEpsilonCoveragePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEpsilonCoveragePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EpsilonCoveragePackage.eNS_URI, theEpsilonCoveragePackage);
		return theEpsilonCoveragePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoverageModel() {
		return coverageModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoverageModel_Strategies() {
		return (EReference)coverageModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoverageStrategy() {
		return coverageStrategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoverageStrategy_Type() {
		return (EAttribute)coverageStrategyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoverageStrategy_Points() {
		return (EReference)coverageStrategyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoveragePoint() {
		return coveragePointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoveragePoint_Line() {
		return (EAttribute)coveragePointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoveragePoint_Column() {
		return (EAttribute)coveragePointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoveragePoint_AstType() {
		return (EAttribute)coveragePointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoveragePoint_TimesExecuted() {
		return (EAttribute)coveragePointEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoveragePoint_Uri() {
		return (EAttribute)coveragePointEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanCoveragePoint() {
		return booleanCoveragePointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanCoveragePoint_TrueBranchCovered() {
		return (EAttribute)booleanCoveragePointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanCoveragePoint_FalseBranchCovered() {
		return (EAttribute)booleanCoveragePointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCoverageType() {
		return coverageTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EpsilonCoverageFactory getEpsilonCoverageFactory() {
		return (EpsilonCoverageFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		coverageModelEClass = createEClass(COVERAGE_MODEL);
		createEReference(coverageModelEClass, COVERAGE_MODEL__STRATEGIES);

		coverageStrategyEClass = createEClass(COVERAGE_STRATEGY);
		createEAttribute(coverageStrategyEClass, COVERAGE_STRATEGY__TYPE);
		createEReference(coverageStrategyEClass, COVERAGE_STRATEGY__POINTS);

		coveragePointEClass = createEClass(COVERAGE_POINT);
		createEAttribute(coveragePointEClass, COVERAGE_POINT__LINE);
		createEAttribute(coveragePointEClass, COVERAGE_POINT__COLUMN);
		createEAttribute(coveragePointEClass, COVERAGE_POINT__AST_TYPE);
		createEAttribute(coveragePointEClass, COVERAGE_POINT__TIMES_EXECUTED);
		createEAttribute(coveragePointEClass, COVERAGE_POINT__URI);

		booleanCoveragePointEClass = createEClass(BOOLEAN_COVERAGE_POINT);
		createEAttribute(booleanCoveragePointEClass, BOOLEAN_COVERAGE_POINT__TRUE_BRANCH_COVERED);
		createEAttribute(booleanCoveragePointEClass, BOOLEAN_COVERAGE_POINT__FALSE_BRANCH_COVERED);

		// Create enums
		coverageTypeEEnum = createEEnum(COVERAGE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		booleanCoveragePointEClass.getESuperTypes().add(this.getCoveragePoint());

		// Initialize classes and features; add operations and parameters
		initEClass(coverageModelEClass, CoverageModel.class, "CoverageModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCoverageModel_Strategies(), this.getCoverageStrategy(), null, "strategies", null, 0, -1, CoverageModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(coverageStrategyEClass, CoverageStrategy.class, "CoverageStrategy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCoverageStrategy_Type(), this.getCoverageType(), "type", null, 0, 1, CoverageStrategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCoverageStrategy_Points(), this.getCoveragePoint(), null, "points", null, 0, -1, CoverageStrategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(coveragePointEClass, CoveragePoint.class, "CoveragePoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCoveragePoint_Line(), ecorePackage.getEInt(), "line", null, 0, 1, CoveragePoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoveragePoint_Column(), ecorePackage.getEInt(), "column", null, 0, 1, CoveragePoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoveragePoint_AstType(), ecorePackage.getEInt(), "astType", null, 0, 1, CoveragePoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoveragePoint_TimesExecuted(), ecorePackage.getEInt(), "timesExecuted", "0", 0, 1, CoveragePoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoveragePoint_Uri(), ecorePackage.getEString(), "uri", null, 0, 1, CoveragePoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanCoveragePointEClass, BooleanCoveragePoint.class, "BooleanCoveragePoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanCoveragePoint_TrueBranchCovered(), ecorePackage.getEBoolean(), "trueBranchCovered", null, 0, 1, BooleanCoveragePoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBooleanCoveragePoint_FalseBranchCovered(), ecorePackage.getEBoolean(), "falseBranchCovered", null, 0, 1, BooleanCoveragePoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(coverageTypeEEnum, CoverageType.class, "CoverageType");
		addEEnumLiteral(coverageTypeEEnum, CoverageType.RULE);
		addEEnumLiteral(coverageTypeEEnum, CoverageType.STATEMENT);
		addEEnumLiteral(coverageTypeEEnum, CoverageType.DECISION);
		addEEnumLiteral(coverageTypeEEnum, CoverageType.CONDITION);
		addEEnumLiteral(coverageTypeEEnum, CoverageType.OPERATION);

		// Create resource
		createResource(eNS_URI);
	}

} //EpsilonCoveragePackageImpl
