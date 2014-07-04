/**
 */
package org.eclipse.epsilon.etl.metamodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.epsilon.etl.metamodel.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EtlFactoryImpl extends EFactoryImpl implements EtlFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EtlFactory init() {
		try {
			EtlFactory theEtlFactory = (EtlFactory)EPackage.Registry.INSTANCE.getEFactory(EtlPackage.eNS_URI);
			if (theEtlFactory != null) {
				return theEtlFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EtlFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtlFactoryImpl() {
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
			case EtlPackage.ETL_ELEMENT: return createEtlElement();
			case EtlPackage.PRE_BLOCK: return createPreBlock();
			case EtlPackage.POST_BLOCK: return createPostBlock();
			case EtlPackage.GUARD: return createGuard();
			case EtlPackage.ETL_PROGRAM: return createEtlProgram();
			case EtlPackage.TRANSFORMATION_RULE: return createTransformationRule();
			case EtlPackage.RULE_DEPENDENCY: return createRuleDependency();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtlElement createEtlElement() {
		EtlElementImpl etlElement = new EtlElementImpl();
		return etlElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PreBlock createPreBlock() {
		PreBlockImpl preBlock = new PreBlockImpl();
		return preBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostBlock createPostBlock() {
		PostBlockImpl postBlock = new PostBlockImpl();
		return postBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Guard createGuard() {
		GuardImpl guard = new GuardImpl();
		return guard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtlProgram createEtlProgram() {
		EtlProgramImpl etlProgram = new EtlProgramImpl();
		return etlProgram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformationRule createTransformationRule() {
		TransformationRuleImpl transformationRule = new TransformationRuleImpl();
		return transformationRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleDependency createRuleDependency() {
		RuleDependencyImpl ruleDependency = new RuleDependencyImpl();
		return ruleDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EtlPackage getEtlPackage() {
		return (EtlPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EtlPackage getPackage() {
		return EtlPackage.eINSTANCE;
	}

} //EtlFactoryImpl
