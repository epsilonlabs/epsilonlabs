/**
 */
package org.eclipse.epsilon.evl.metamodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.epsilon.eol.metamodel.EolPackage;

import org.eclipse.epsilon.evl.metamodel.Constraint;
import org.eclipse.epsilon.evl.metamodel.Context;
import org.eclipse.epsilon.evl.metamodel.Critique;
import org.eclipse.epsilon.evl.metamodel.EvlElement;
import org.eclipse.epsilon.evl.metamodel.EvlFactory;
import org.eclipse.epsilon.evl.metamodel.EvlPackage;
import org.eclipse.epsilon.evl.metamodel.EvlProgram;
import org.eclipse.epsilon.evl.metamodel.Fix;
import org.eclipse.epsilon.evl.metamodel.GuardedElement;
import org.eclipse.epsilon.evl.metamodel.Invariant;
import org.eclipse.epsilon.evl.metamodel.NamedBlock;
import org.eclipse.epsilon.evl.metamodel.PostBlock;
import org.eclipse.epsilon.evl.metamodel.PreBlock;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EvlPackageImpl extends EPackageImpl implements EvlPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass evlElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass evlProgramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass guardedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fixEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invariantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass critiqueEClass = null;

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
	 * @see org.eclipse.epsilon.evl.metamodel.EvlPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EvlPackageImpl() {
		super(eNS_URI, EvlFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EvlPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EvlPackage init() {
		if (isInited) return (EvlPackage)EPackage.Registry.INSTANCE.getEPackage(EvlPackage.eNS_URI);

		// Obtain or create and register package
		EvlPackageImpl theEvlPackage = (EvlPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EvlPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EvlPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EolPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEvlPackage.createPackageContents();

		// Initialize created meta-data
		theEvlPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEvlPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EvlPackage.eNS_URI, theEvlPackage);
		return theEvlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvlElement() {
		return evlElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvlProgram() {
		return evlProgramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvlProgram_Contexts() {
		return (EReference)evlProgramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvlProgram_PreBlocks() {
		return (EReference)evlProgramEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvlProgram_PostBlocks() {
		return (EReference)evlProgramEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGuardedElement() {
		return guardedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGuardedElement_Guard() {
		return (EReference)guardedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContext() {
		return contextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContext_Type() {
		return (EReference)contextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContext_PreBlocks() {
		return (EReference)contextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContext_PostBlocks() {
		return (EReference)contextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContext_Invariants() {
		return (EReference)contextEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFix() {
		return fixEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFix_Title() {
		return (EReference)fixEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFix_Do() {
		return (EReference)fixEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvariant() {
		return invariantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvariant_Name() {
		return (EReference)invariantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvariant_Fixes() {
		return (EReference)invariantEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvariant_Check() {
		return (EReference)invariantEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvariant_Message() {
		return (EReference)invariantEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraint() {
		return constraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCritique() {
		return critiqueEClass;
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
	public EvlFactory getEvlFactory() {
		return (EvlFactory)getEFactoryInstance();
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
		evlElementEClass = createEClass(EVL_ELEMENT);

		evlProgramEClass = createEClass(EVL_PROGRAM);
		createEReference(evlProgramEClass, EVL_PROGRAM__CONTEXTS);
		createEReference(evlProgramEClass, EVL_PROGRAM__PRE_BLOCKS);
		createEReference(evlProgramEClass, EVL_PROGRAM__POST_BLOCKS);

		guardedElementEClass = createEClass(GUARDED_ELEMENT);
		createEReference(guardedElementEClass, GUARDED_ELEMENT__GUARD);

		contextEClass = createEClass(CONTEXT);
		createEReference(contextEClass, CONTEXT__TYPE);
		createEReference(contextEClass, CONTEXT__PRE_BLOCKS);
		createEReference(contextEClass, CONTEXT__POST_BLOCKS);
		createEReference(contextEClass, CONTEXT__INVARIANTS);

		fixEClass = createEClass(FIX);
		createEReference(fixEClass, FIX__TITLE);
		createEReference(fixEClass, FIX__DO);

		invariantEClass = createEClass(INVARIANT);
		createEReference(invariantEClass, INVARIANT__NAME);
		createEReference(invariantEClass, INVARIANT__FIXES);
		createEReference(invariantEClass, INVARIANT__CHECK);
		createEReference(invariantEClass, INVARIANT__MESSAGE);

		constraintEClass = createEClass(CONSTRAINT);

		critiqueEClass = createEClass(CRITIQUE);

		namedBlockEClass = createEClass(NAMED_BLOCK);
		createEReference(namedBlockEClass, NAMED_BLOCK__NAME);
		createEReference(namedBlockEClass, NAMED_BLOCK__BODY);

		preBlockEClass = createEClass(PRE_BLOCK);

		postBlockEClass = createEClass(POST_BLOCK);
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
		evlElementEClass.getESuperTypes().add(theEolPackage.getEolElement());
		evlProgramEClass.getESuperTypes().add(theEolPackage.getEolLibraryModule());
		guardedElementEClass.getESuperTypes().add(this.getEvlElement());
		contextEClass.getESuperTypes().add(this.getGuardedElement());
		fixEClass.getESuperTypes().add(this.getEvlElement());
		invariantEClass.getESuperTypes().add(this.getGuardedElement());
		constraintEClass.getESuperTypes().add(this.getInvariant());
		critiqueEClass.getESuperTypes().add(this.getInvariant());
		namedBlockEClass.getESuperTypes().add(this.getEvlElement());
		preBlockEClass.getESuperTypes().add(this.getNamedBlock());
		postBlockEClass.getESuperTypes().add(this.getNamedBlock());

		// Initialize classes and features; add operations and parameters
		initEClass(evlElementEClass, EvlElement.class, "EvlElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(evlProgramEClass, EvlProgram.class, "EvlProgram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEvlProgram_Contexts(), this.getContext(), null, "contexts", null, 0, -1, EvlProgram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEvlProgram_PreBlocks(), this.getPreBlock(), null, "preBlocks", null, 0, -1, EvlProgram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEvlProgram_PostBlocks(), this.getPostBlock(), null, "postBlocks", null, 0, -1, EvlProgram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(guardedElementEClass, GuardedElement.class, "GuardedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGuardedElement_Guard(), theEolPackage.getExpressionOrStatementBlock(), null, "guard", null, 1, 1, GuardedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contextEClass, Context.class, "Context", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContext_Type(), theEolPackage.getModelElementType(), null, "type", null, 1, 1, Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContext_PreBlocks(), this.getPreBlock(), null, "preBlocks", null, 0, -1, Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContext_PostBlocks(), this.getPostBlock(), null, "postBlocks", null, 0, -1, Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContext_Invariants(), this.getInvariant(), null, "invariants", null, 0, -1, Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fixEClass, Fix.class, "Fix", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFix_Title(), theEolPackage.getExpressionOrStatementBlock(), null, "title", null, 1, 1, Fix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFix_Do(), theEolPackage.getBlock(), null, "do", null, 1, 1, Fix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(invariantEClass, Invariant.class, "Invariant", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInvariant_Name(), theEolPackage.getNameExpression(), null, "name", null, 1, 1, Invariant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInvariant_Fixes(), this.getFix(), null, "fixes", null, 0, -1, Invariant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInvariant_Check(), theEolPackage.getExpressionOrStatementBlock(), null, "check", null, 1, 1, Invariant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInvariant_Message(), theEolPackage.getExpressionOrStatementBlock(), null, "message", null, 1, 1, Invariant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constraintEClass, Constraint.class, "Constraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(critiqueEClass, Critique.class, "Critique", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(namedBlockEClass, NamedBlock.class, "NamedBlock", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNamedBlock_Name(), theEolPackage.getNameExpression(), null, "name", null, 1, 1, NamedBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNamedBlock_Body(), theEolPackage.getBlock(), null, "body", null, 0, 1, NamedBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(preBlockEClass, PreBlock.class, "PreBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(postBlockEClass, PostBlock.class, "PostBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

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

} //EvlPackageImpl
