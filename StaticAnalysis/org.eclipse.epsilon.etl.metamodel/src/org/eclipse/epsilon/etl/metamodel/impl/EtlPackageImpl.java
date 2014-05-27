/**
 */
package org.eclipse.epsilon.etl.metamodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.epsilon.eol.metamodel.EolPackage;

import org.eclipse.epsilon.etl.metamodel.EtlElement;
import org.eclipse.epsilon.etl.metamodel.EtlFactory;
import org.eclipse.epsilon.etl.metamodel.EtlPackage;
import org.eclipse.epsilon.etl.metamodel.EtlProgram;
import org.eclipse.epsilon.etl.metamodel.Guard;
import org.eclipse.epsilon.etl.metamodel.NamedBlock;
import org.eclipse.epsilon.etl.metamodel.PostBlock;
import org.eclipse.epsilon.etl.metamodel.PreBlock;
import org.eclipse.epsilon.etl.metamodel.TransformationRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EtlPackageImpl extends EPackageImpl implements EtlPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass etlElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass preBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass guardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass etlProgramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transformationRuleEClass = null;

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
	 * @see org.eclipse.epsilon.etl.metamodel.EtlPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EtlPackageImpl() {
		super(eNS_URI, EtlFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EtlPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EtlPackage init() {
		if (isInited) return (EtlPackage)EPackage.Registry.INSTANCE.getEPackage(EtlPackage.eNS_URI);

		// Obtain or create and register package
		EtlPackageImpl theEtlPackage = (EtlPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EtlPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EtlPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EolPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEtlPackage.createPackageContents();

		// Initialize created meta-data
		theEtlPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEtlPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EtlPackage.eNS_URI, theEtlPackage);
		return theEtlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEtlElement() {
		return etlElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedBlock() {
		return namedBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamedBlock_Name() {
		return (EReference)namedBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamedBlock_Body() {
		return (EReference)namedBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPreBlock() {
		return preBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPostBlock() {
		return postBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGuard() {
		return guardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGuard_Condition() {
		return (EReference)guardEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEtlProgram() {
		return etlProgramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEtlProgram_TransformationRules() {
		return (EReference)etlProgramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEtlProgram_PreBlocks() {
		return (EReference)etlProgramEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEtlProgram_PostBlocks() {
		return (EReference)etlProgramEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransformationRule() {
		return transformationRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationRule_Name() {
		return (EReference)transformationRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationRule_Source() {
		return (EReference)transformationRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationRule_Targets() {
		return (EReference)transformationRuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationRule_Body() {
		return (EReference)transformationRuleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationRule_AnnotationBlock() {
		return (EReference)transformationRuleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationRule_Extends() {
		return (EReference)transformationRuleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationRule_ResolvedParentRules() {
		return (EReference)transformationRuleEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationRule_Guard() {
		return (EReference)transformationRuleEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtlFactory getEtlFactory() {
		return (EtlFactory)getEFactoryInstance();
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
		etlElementEClass = createEClass(ETL_ELEMENT);

		namedBlockEClass = createEClass(NAMED_BLOCK);
		createEReference(namedBlockEClass, NAMED_BLOCK__NAME);
		createEReference(namedBlockEClass, NAMED_BLOCK__BODY);

		preBlockEClass = createEClass(PRE_BLOCK);

		postBlockEClass = createEClass(POST_BLOCK);

		guardEClass = createEClass(GUARD);
		createEReference(guardEClass, GUARD__CONDITION);

		etlProgramEClass = createEClass(ETL_PROGRAM);
		createEReference(etlProgramEClass, ETL_PROGRAM__TRANSFORMATION_RULES);
		createEReference(etlProgramEClass, ETL_PROGRAM__PRE_BLOCKS);
		createEReference(etlProgramEClass, ETL_PROGRAM__POST_BLOCKS);

		transformationRuleEClass = createEClass(TRANSFORMATION_RULE);
		createEReference(transformationRuleEClass, TRANSFORMATION_RULE__NAME);
		createEReference(transformationRuleEClass, TRANSFORMATION_RULE__SOURCE);
		createEReference(transformationRuleEClass, TRANSFORMATION_RULE__TARGETS);
		createEReference(transformationRuleEClass, TRANSFORMATION_RULE__BODY);
		createEReference(transformationRuleEClass, TRANSFORMATION_RULE__ANNOTATION_BLOCK);
		createEReference(transformationRuleEClass, TRANSFORMATION_RULE__EXTENDS);
		createEReference(transformationRuleEClass, TRANSFORMATION_RULE__RESOLVED_PARENT_RULES);
		createEReference(transformationRuleEClass, TRANSFORMATION_RULE__GUARD);
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

		// Obtain other dependent packages
		EolPackage theEolPackage = (EolPackage)EPackage.Registry.INSTANCE.getEPackage(EolPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		etlElementEClass.getESuperTypes().add(theEolPackage.getEolElement());
		namedBlockEClass.getESuperTypes().add(this.getEtlElement());
		preBlockEClass.getESuperTypes().add(this.getNamedBlock());
		postBlockEClass.getESuperTypes().add(this.getNamedBlock());
		guardEClass.getESuperTypes().add(this.getEtlElement());
		etlProgramEClass.getESuperTypes().add(theEolPackage.getEolLibraryModule());
		transformationRuleEClass.getESuperTypes().add(this.getEtlElement());

		// Initialize classes and features; add operations and parameters
		initEClass(etlElementEClass, EtlElement.class, "EtlElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(namedBlockEClass, NamedBlock.class, "NamedBlock", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNamedBlock_Name(), theEolPackage.getNameExpression(), null, "name", null, 1, 1, NamedBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNamedBlock_Body(), theEolPackage.getBlock(), null, "body", null, 0, 1, NamedBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(preBlockEClass, PreBlock.class, "PreBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(postBlockEClass, PostBlock.class, "PostBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(guardEClass, Guard.class, "Guard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGuard_Condition(), theEolPackage.getExpressionOrStatementBlock(), null, "condition", null, 1, 1, Guard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(etlProgramEClass, EtlProgram.class, "EtlProgram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEtlProgram_TransformationRules(), this.getTransformationRule(), null, "transformationRules", null, 0, -1, EtlProgram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEtlProgram_PreBlocks(), this.getPreBlock(), null, "preBlocks", null, 0, -1, EtlProgram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEtlProgram_PostBlocks(), this.getPostBlock(), null, "postBlocks", null, 0, -1, EtlProgram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transformationRuleEClass, TransformationRule.class, "TransformationRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransformationRule_Name(), theEolPackage.getNameExpression(), null, "name", null, 1, 1, TransformationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationRule_Source(), theEolPackage.getFormalParameterExpression(), null, "source", null, 1, 1, TransformationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationRule_Targets(), theEolPackage.getFormalParameterExpression(), null, "targets", null, 0, -1, TransformationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationRule_Body(), theEolPackage.getBlock(), null, "body", null, 0, 1, TransformationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationRule_AnnotationBlock(), theEolPackage.getAnnotationBlock(), null, "annotationBlock", null, 0, 1, TransformationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationRule_Extends(), theEolPackage.getNameExpression(), null, "extends", null, 0, -1, TransformationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationRule_ResolvedParentRules(), this.getTransformationRule(), null, "resolvedParentRules", null, 0, -1, TransformationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationRule_Guard(), this.getGuard(), null, "guard", null, 0, 1, TransformationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// emf.gen
		createEmfAnnotations();
		// emf.gen.usedGenPackage
		createEmf_1Annotations();
		// emf.gen.annotation
		createEmf_2Annotations();
	}

	/**
	 * Initializes the annotations for <b>emf.gen</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEmfAnnotations() {
		String source = "emf.gen";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "classPackageSuffix", "metamodel.impl",
			 "utilityPackageSuffix", "metamodel.util",
			 "metaDataPackageSuffix", "metamodel",
			 "interfacePackageSuffix", "metamodel",
			 "basePackage", "org.eclipse.epsilon"
		   });		
	}

	/**
	 * Initializes the annotations for <b>emf.gen.usedGenPackage</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEmf_1Annotations() {
		String source = "emf.gen.usedGenPackage";			
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "name", "eol",
			 "genModel", "platform:/resource/org.eclipse.epsilon.eol.metamodel/model/Eol.genmodel"
		   });	
	}

	/**
	 * Initializes the annotations for <b>emf.gen.annotation</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEmf_2Annotations() {
		String source = "emf.gen.annotation";				
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "source", "emf.gen",
			 "key", "extends",
			 "value", "eol"
		   });
	}

} //EtlPackageImpl
