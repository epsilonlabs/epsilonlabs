/**
 */
package org.eclipse.epsilon.etl.metamodel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.epsilon.eol.metamodel.EolPackage;

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
 * @see org.eclipse.epsilon.etl.metamodel.EtlFactory
 * @model kind="package"
 *        annotation="emf.gen classPackageSuffix='metamodel.impl' utilityPackageSuffix='metamodel.util' metaDataPackageSuffix='metamodel' interfacePackageSuffix='metamodel' basePackage='org.eclipse.epsilon'"
 *        annotation="emf.gen.usedGenPackage name='eol' genModel='platform:/resource/org.eclipse.epsilon.eol.metamodel/model/Eol.genmodel'"
 *        annotation="emf.gen.annotation source='emf.gen' key='extends' value='eol'"
 * @generated
 */
public interface EtlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "etl";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/epsilon/etl";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "etl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EtlPackage eINSTANCE = org.eclipse.epsilon.etl.metamodel.impl.EtlPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.etl.metamodel.impl.EtlElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.etl.metamodel.impl.EtlElementImpl
	 * @see org.eclipse.epsilon.etl.metamodel.impl.EtlPackageImpl#getEtlElement()
	 * @generated
	 */
	int ETL_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETL_ELEMENT__CONTAINER = EolPackage.EOL_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETL_ELEMENT__LINE = EolPackage.EOL_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETL_ELEMENT__COLUMN = EolPackage.EOL_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETL_ELEMENT__URI = EolPackage.EOL_ELEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETL_ELEMENT__REGION = EolPackage.EOL_ELEMENT__REGION;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETL_ELEMENT_FEATURE_COUNT = EolPackage.EOL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.etl.metamodel.impl.NamedBlockImpl <em>Named Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.etl.metamodel.impl.NamedBlockImpl
	 * @see org.eclipse.epsilon.etl.metamodel.impl.EtlPackageImpl#getNamedBlock()
	 * @generated
	 */
	int NAMED_BLOCK = 1;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_BLOCK__CONTAINER = ETL_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_BLOCK__LINE = ETL_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_BLOCK__COLUMN = ETL_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_BLOCK__URI = ETL_ELEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_BLOCK__REGION = ETL_ELEMENT__REGION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_BLOCK__NAME = ETL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_BLOCK__BODY = ETL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Named Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_BLOCK_FEATURE_COUNT = ETL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.etl.metamodel.impl.PreBlockImpl <em>Pre Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.etl.metamodel.impl.PreBlockImpl
	 * @see org.eclipse.epsilon.etl.metamodel.impl.EtlPackageImpl#getPreBlock()
	 * @generated
	 */
	int PRE_BLOCK = 2;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_BLOCK__CONTAINER = NAMED_BLOCK__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_BLOCK__LINE = NAMED_BLOCK__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_BLOCK__COLUMN = NAMED_BLOCK__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_BLOCK__URI = NAMED_BLOCK__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_BLOCK__REGION = NAMED_BLOCK__REGION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_BLOCK__NAME = NAMED_BLOCK__NAME;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_BLOCK__BODY = NAMED_BLOCK__BODY;

	/**
	 * The number of structural features of the '<em>Pre Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_BLOCK_FEATURE_COUNT = NAMED_BLOCK_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.etl.metamodel.impl.PostBlockImpl <em>Post Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.etl.metamodel.impl.PostBlockImpl
	 * @see org.eclipse.epsilon.etl.metamodel.impl.EtlPackageImpl#getPostBlock()
	 * @generated
	 */
	int POST_BLOCK = 3;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BLOCK__CONTAINER = NAMED_BLOCK__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BLOCK__LINE = NAMED_BLOCK__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BLOCK__COLUMN = NAMED_BLOCK__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BLOCK__URI = NAMED_BLOCK__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BLOCK__REGION = NAMED_BLOCK__REGION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BLOCK__NAME = NAMED_BLOCK__NAME;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BLOCK__BODY = NAMED_BLOCK__BODY;

	/**
	 * The number of structural features of the '<em>Post Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_BLOCK_FEATURE_COUNT = NAMED_BLOCK_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.etl.metamodel.impl.GuardImpl <em>Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.etl.metamodel.impl.GuardImpl
	 * @see org.eclipse.epsilon.etl.metamodel.impl.EtlPackageImpl#getGuard()
	 * @generated
	 */
	int GUARD = 4;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD__CONTAINER = ETL_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD__LINE = ETL_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD__COLUMN = ETL_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD__URI = ETL_ELEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD__REGION = ETL_ELEMENT__REGION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD__CONDITION = ETL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_FEATURE_COUNT = ETL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.etl.metamodel.impl.EtlProgramImpl <em>Program</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.etl.metamodel.impl.EtlProgramImpl
	 * @see org.eclipse.epsilon.etl.metamodel.impl.EtlPackageImpl#getEtlProgram()
	 * @generated
	 */
	int ETL_PROGRAM = 5;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETL_PROGRAM__CONTAINER = EolPackage.EOL_LIBRARY_MODULE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETL_PROGRAM__LINE = EolPackage.EOL_LIBRARY_MODULE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETL_PROGRAM__COLUMN = EolPackage.EOL_LIBRARY_MODULE__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETL_PROGRAM__URI = EolPackage.EOL_LIBRARY_MODULE__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETL_PROGRAM__REGION = EolPackage.EOL_LIBRARY_MODULE__REGION;

	/**
	 * The feature id for the '<em><b>Model Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETL_PROGRAM__MODEL_DECLARATIONS = EolPackage.EOL_LIBRARY_MODULE__MODEL_DECLARATIONS;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETL_PROGRAM__IMPORTS = EolPackage.EOL_LIBRARY_MODULE__IMPORTS;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETL_PROGRAM__OPERATIONS = EolPackage.EOL_LIBRARY_MODULE__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETL_PROGRAM__NAME = EolPackage.EOL_LIBRARY_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Transformation Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETL_PROGRAM__TRANSFORMATION_RULES = EolPackage.EOL_LIBRARY_MODULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Pre Blocks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETL_PROGRAM__PRE_BLOCKS = EolPackage.EOL_LIBRARY_MODULE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Post Blocks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETL_PROGRAM__POST_BLOCKS = EolPackage.EOL_LIBRARY_MODULE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Program</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETL_PROGRAM_FEATURE_COUNT = EolPackage.EOL_LIBRARY_MODULE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.etl.metamodel.impl.TransformationRuleImpl <em>Transformation Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.etl.metamodel.impl.TransformationRuleImpl
	 * @see org.eclipse.epsilon.etl.metamodel.impl.EtlPackageImpl#getTransformationRule()
	 * @generated
	 */
	int TRANSFORMATION_RULE = 6;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_RULE__CONTAINER = ETL_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_RULE__LINE = ETL_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_RULE__COLUMN = ETL_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_RULE__URI = ETL_ELEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_RULE__REGION = ETL_ELEMENT__REGION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_RULE__NAME = ETL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_RULE__SOURCE = ETL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_RULE__TARGETS = ETL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_RULE__BODY = ETL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Annotation Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_RULE__ANNOTATION_BLOCK = ETL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_RULE__EXTENDS = ETL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Resolved Parent Rules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_RULE__RESOLVED_PARENT_RULES = ETL_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Depending Rules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_RULE__DEPENDING_RULES = ETL_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_RULE__GUARD = ETL_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Transformation Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_RULE_FEATURE_COUNT = ETL_ELEMENT_FEATURE_COUNT + 9;


	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.etl.metamodel.EtlElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.eclipse.epsilon.etl.metamodel.EtlElement
	 * @generated
	 */
	EClass getEtlElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.etl.metamodel.NamedBlock <em>Named Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Block</em>'.
	 * @see org.eclipse.epsilon.etl.metamodel.NamedBlock
	 * @generated
	 */
	EClass getNamedBlock();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.etl.metamodel.NamedBlock#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Name</em>'.
	 * @see org.eclipse.epsilon.etl.metamodel.NamedBlock#getName()
	 * @see #getNamedBlock()
	 * @generated
	 */
	EReference getNamedBlock_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.etl.metamodel.NamedBlock#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.epsilon.etl.metamodel.NamedBlock#getBody()
	 * @see #getNamedBlock()
	 * @generated
	 */
	EReference getNamedBlock_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.etl.metamodel.PreBlock <em>Pre Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pre Block</em>'.
	 * @see org.eclipse.epsilon.etl.metamodel.PreBlock
	 * @generated
	 */
	EClass getPreBlock();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.etl.metamodel.PostBlock <em>Post Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Post Block</em>'.
	 * @see org.eclipse.epsilon.etl.metamodel.PostBlock
	 * @generated
	 */
	EClass getPostBlock();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.etl.metamodel.Guard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guard</em>'.
	 * @see org.eclipse.epsilon.etl.metamodel.Guard
	 * @generated
	 */
	EClass getGuard();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.etl.metamodel.Guard#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.epsilon.etl.metamodel.Guard#getCondition()
	 * @see #getGuard()
	 * @generated
	 */
	EReference getGuard_Condition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.etl.metamodel.EtlProgram <em>Program</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Program</em>'.
	 * @see org.eclipse.epsilon.etl.metamodel.EtlProgram
	 * @generated
	 */
	EClass getEtlProgram();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.etl.metamodel.EtlProgram#getTransformationRules <em>Transformation Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transformation Rules</em>'.
	 * @see org.eclipse.epsilon.etl.metamodel.EtlProgram#getTransformationRules()
	 * @see #getEtlProgram()
	 * @generated
	 */
	EReference getEtlProgram_TransformationRules();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.etl.metamodel.EtlProgram#getPreBlocks <em>Pre Blocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Pre Blocks</em>'.
	 * @see org.eclipse.epsilon.etl.metamodel.EtlProgram#getPreBlocks()
	 * @see #getEtlProgram()
	 * @generated
	 */
	EReference getEtlProgram_PreBlocks();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.etl.metamodel.EtlProgram#getPostBlocks <em>Post Blocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Post Blocks</em>'.
	 * @see org.eclipse.epsilon.etl.metamodel.EtlProgram#getPostBlocks()
	 * @see #getEtlProgram()
	 * @generated
	 */
	EReference getEtlProgram_PostBlocks();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.etl.metamodel.TransformationRule <em>Transformation Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformation Rule</em>'.
	 * @see org.eclipse.epsilon.etl.metamodel.TransformationRule
	 * @generated
	 */
	EClass getTransformationRule();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.etl.metamodel.TransformationRule#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Name</em>'.
	 * @see org.eclipse.epsilon.etl.metamodel.TransformationRule#getName()
	 * @see #getTransformationRule()
	 * @generated
	 */
	EReference getTransformationRule_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.etl.metamodel.TransformationRule#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see org.eclipse.epsilon.etl.metamodel.TransformationRule#getSource()
	 * @see #getTransformationRule()
	 * @generated
	 */
	EReference getTransformationRule_Source();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.etl.metamodel.TransformationRule#getTargets <em>Targets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Targets</em>'.
	 * @see org.eclipse.epsilon.etl.metamodel.TransformationRule#getTargets()
	 * @see #getTransformationRule()
	 * @generated
	 */
	EReference getTransformationRule_Targets();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.etl.metamodel.TransformationRule#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.epsilon.etl.metamodel.TransformationRule#getBody()
	 * @see #getTransformationRule()
	 * @generated
	 */
	EReference getTransformationRule_Body();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.etl.metamodel.TransformationRule#getAnnotationBlock <em>Annotation Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Annotation Block</em>'.
	 * @see org.eclipse.epsilon.etl.metamodel.TransformationRule#getAnnotationBlock()
	 * @see #getTransformationRule()
	 * @generated
	 */
	EReference getTransformationRule_AnnotationBlock();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.etl.metamodel.TransformationRule#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extends</em>'.
	 * @see org.eclipse.epsilon.etl.metamodel.TransformationRule#getExtends()
	 * @see #getTransformationRule()
	 * @generated
	 */
	EReference getTransformationRule_Extends();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.epsilon.etl.metamodel.TransformationRule#getResolvedParentRules <em>Resolved Parent Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Resolved Parent Rules</em>'.
	 * @see org.eclipse.epsilon.etl.metamodel.TransformationRule#getResolvedParentRules()
	 * @see #getTransformationRule()
	 * @generated
	 */
	EReference getTransformationRule_ResolvedParentRules();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.epsilon.etl.metamodel.TransformationRule#getDependingRules <em>Depending Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Depending Rules</em>'.
	 * @see org.eclipse.epsilon.etl.metamodel.TransformationRule#getDependingRules()
	 * @see #getTransformationRule()
	 * @generated
	 */
	EReference getTransformationRule_DependingRules();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.etl.metamodel.TransformationRule#getGuard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Guard</em>'.
	 * @see org.eclipse.epsilon.etl.metamodel.TransformationRule#getGuard()
	 * @see #getTransformationRule()
	 * @generated
	 */
	EReference getTransformationRule_Guard();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EtlFactory getEtlFactory();

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
		 * The meta object literal for the '{@link org.eclipse.epsilon.etl.metamodel.impl.EtlElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.etl.metamodel.impl.EtlElementImpl
		 * @see org.eclipse.epsilon.etl.metamodel.impl.EtlPackageImpl#getEtlElement()
		 * @generated
		 */
		EClass ETL_ELEMENT = eINSTANCE.getEtlElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.etl.metamodel.impl.NamedBlockImpl <em>Named Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.etl.metamodel.impl.NamedBlockImpl
		 * @see org.eclipse.epsilon.etl.metamodel.impl.EtlPackageImpl#getNamedBlock()
		 * @generated
		 */
		EClass NAMED_BLOCK = eINSTANCE.getNamedBlock();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMED_BLOCK__NAME = eINSTANCE.getNamedBlock_Name();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMED_BLOCK__BODY = eINSTANCE.getNamedBlock_Body();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.etl.metamodel.impl.PreBlockImpl <em>Pre Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.etl.metamodel.impl.PreBlockImpl
		 * @see org.eclipse.epsilon.etl.metamodel.impl.EtlPackageImpl#getPreBlock()
		 * @generated
		 */
		EClass PRE_BLOCK = eINSTANCE.getPreBlock();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.etl.metamodel.impl.PostBlockImpl <em>Post Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.etl.metamodel.impl.PostBlockImpl
		 * @see org.eclipse.epsilon.etl.metamodel.impl.EtlPackageImpl#getPostBlock()
		 * @generated
		 */
		EClass POST_BLOCK = eINSTANCE.getPostBlock();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.etl.metamodel.impl.GuardImpl <em>Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.etl.metamodel.impl.GuardImpl
		 * @see org.eclipse.epsilon.etl.metamodel.impl.EtlPackageImpl#getGuard()
		 * @generated
		 */
		EClass GUARD = eINSTANCE.getGuard();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUARD__CONDITION = eINSTANCE.getGuard_Condition();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.etl.metamodel.impl.EtlProgramImpl <em>Program</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.etl.metamodel.impl.EtlProgramImpl
		 * @see org.eclipse.epsilon.etl.metamodel.impl.EtlPackageImpl#getEtlProgram()
		 * @generated
		 */
		EClass ETL_PROGRAM = eINSTANCE.getEtlProgram();

		/**
		 * The meta object literal for the '<em><b>Transformation Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ETL_PROGRAM__TRANSFORMATION_RULES = eINSTANCE.getEtlProgram_TransformationRules();

		/**
		 * The meta object literal for the '<em><b>Pre Blocks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ETL_PROGRAM__PRE_BLOCKS = eINSTANCE.getEtlProgram_PreBlocks();

		/**
		 * The meta object literal for the '<em><b>Post Blocks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ETL_PROGRAM__POST_BLOCKS = eINSTANCE.getEtlProgram_PostBlocks();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.etl.metamodel.impl.TransformationRuleImpl <em>Transformation Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.etl.metamodel.impl.TransformationRuleImpl
		 * @see org.eclipse.epsilon.etl.metamodel.impl.EtlPackageImpl#getTransformationRule()
		 * @generated
		 */
		EClass TRANSFORMATION_RULE = eINSTANCE.getTransformationRule();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_RULE__NAME = eINSTANCE.getTransformationRule_Name();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_RULE__SOURCE = eINSTANCE.getTransformationRule_Source();

		/**
		 * The meta object literal for the '<em><b>Targets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_RULE__TARGETS = eINSTANCE.getTransformationRule_Targets();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_RULE__BODY = eINSTANCE.getTransformationRule_Body();

		/**
		 * The meta object literal for the '<em><b>Annotation Block</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_RULE__ANNOTATION_BLOCK = eINSTANCE.getTransformationRule_AnnotationBlock();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_RULE__EXTENDS = eINSTANCE.getTransformationRule_Extends();

		/**
		 * The meta object literal for the '<em><b>Resolved Parent Rules</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_RULE__RESOLVED_PARENT_RULES = eINSTANCE.getTransformationRule_ResolvedParentRules();

		/**
		 * The meta object literal for the '<em><b>Depending Rules</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_RULE__DEPENDING_RULES = eINSTANCE.getTransformationRule_DependingRules();

		/**
		 * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_RULE__GUARD = eINSTANCE.getTransformationRule_Guard();

	}

} //EtlPackage
