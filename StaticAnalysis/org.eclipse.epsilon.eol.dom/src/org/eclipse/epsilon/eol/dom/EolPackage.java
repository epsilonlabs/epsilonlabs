/**
 */
package org.eclipse.epsilon.eol.dom;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.eclipse.epsilon.eol.dom.EolFactory
 * @model kind="package"
 *        annotation="emf.gen classPackageSuffix='dom.impl' utilityPackageSuffix='dom.util' metaDataPackageSuffix='dom' interfacePackageSuffix='dom' basePackage='org.eclipse.epsilon'"
 * @generated
 */
public interface EolPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "eol";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/epsilon/eol";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "eol";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EolPackage eINSTANCE = org.eclipse.epsilon.eol.dom.impl.EolPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.DomElementImpl <em>Dom Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.DomElementImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getDomElement()
	 * @generated
	 */
	int DOM_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOM_ELEMENT__CONTAINER = 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOM_ELEMENT__LINE = 1;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOM_ELEMENT__COLUMN = 2;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOM_ELEMENT__URI = 3;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOM_ELEMENT__REGION = 4;

	/**
	 * The number of structural features of the '<em>Dom Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOM_ELEMENT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.TextRegionImpl <em>Text Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.TextRegionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getTextRegion()
	 * @generated
	 */
	int TEXT_REGION = 1;

	/**
	 * The feature id for the '<em><b>Start</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_REGION__START = 0;

	/**
	 * The feature id for the '<em><b>End</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_REGION__END = 1;

	/**
	 * The number of structural features of the '<em>Text Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_REGION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.TextPositionImpl <em>Text Position</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.TextPositionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getTextPosition()
	 * @generated
	 */
	int TEXT_POSITION = 2;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_POSITION__LINE = 0;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_POSITION__COLUMN = 1;

	/**
	 * The number of structural features of the '<em>Text Position</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_POSITION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.ProgramImpl <em>Program</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.ProgramImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getProgram()
	 * @generated
	 */
	int PROGRAM = 3;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__CONTAINER = DOM_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__LINE = DOM_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__COLUMN = DOM_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__URI = DOM_ELEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__REGION = DOM_ELEMENT__REGION;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__IMPORTS = DOM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Imported Modules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__IMPORTED_MODULES = DOM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__OPERATIONS = DOM_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__BLOCK = DOM_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__NAME = DOM_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Model Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__MODEL_DECLARATIONS = DOM_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Program</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM_FEATURE_COUNT = DOM_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.ImportImpl <em>Import</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.ImportImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getImport()
	 * @generated
	 */
	int IMPORT = 4;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__CONTAINER = DOM_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__LINE = DOM_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__COLUMN = DOM_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__URI = DOM_ELEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__REGION = DOM_ELEMENT__REGION;

	/**
	 * The feature id for the '<em><b>Imported</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__IMPORTED = DOM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Imported Program</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__IMPORTED_PROGRAM = DOM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_FEATURE_COUNT = DOM_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.StatementImpl <em>Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.StatementImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getStatement()
	 * @generated
	 */
	int STATEMENT = 5;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__CONTAINER = DOM_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__LINE = DOM_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__COLUMN = DOM_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__URI = DOM_ELEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__REGION = DOM_ELEMENT__REGION;

	/**
	 * The number of structural features of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_FEATURE_COUNT = DOM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.ExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 6;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__CONTAINER = DOM_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__LINE = DOM_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__COLUMN = DOM_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__URI = DOM_ELEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__REGION = DOM_ELEMENT__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__RESOLVED_TYPE = DOM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = DOM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.BlockImpl <em>Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.BlockImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getBlock()
	 * @generated
	 */
	int BLOCK = 7;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__CONTAINER = DOM_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__LINE = DOM_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__COLUMN = DOM_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__URI = DOM_ELEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__REGION = DOM_ELEMENT__REGION;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__STATEMENTS = DOM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_FEATURE_COUNT = DOM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.OperatorExpressionImpl <em>Operator Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.OperatorExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getOperatorExpression()
	 * @generated
	 */
	int OPERATOR_EXPRESSION = 8;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_EXPRESSION__CONTAINER = EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_EXPRESSION__LINE = EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_EXPRESSION__COLUMN = EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_EXPRESSION__URI = EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_EXPRESSION__REGION = EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_EXPRESSION__RESOLVED_TYPE = EXPRESSION__RESOLVED_TYPE;

	/**
	 * The number of structural features of the '<em>Operator Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.BinaryOperatorExpressionImpl <em>Binary Operator Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.BinaryOperatorExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getBinaryOperatorExpression()
	 * @generated
	 */
	int BINARY_OPERATOR_EXPRESSION = 9;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_EXPRESSION__CONTAINER = OPERATOR_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_EXPRESSION__LINE = OPERATOR_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_EXPRESSION__COLUMN = OPERATOR_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_EXPRESSION__URI = OPERATOR_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_EXPRESSION__REGION = OPERATOR_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_EXPRESSION__RESOLVED_TYPE = OPERATOR_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_EXPRESSION__LHS = OPERATOR_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_EXPRESSION__RHS = OPERATOR_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Binary Operator Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_EXPRESSION_FEATURE_COUNT = OPERATOR_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.AndOperatorExpressionImpl <em>And Operator Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.AndOperatorExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getAndOperatorExpression()
	 * @generated
	 */
	int AND_OPERATOR_EXPRESSION = 10;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_OPERATOR_EXPRESSION__CONTAINER = BINARY_OPERATOR_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_OPERATOR_EXPRESSION__LINE = BINARY_OPERATOR_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_OPERATOR_EXPRESSION__COLUMN = BINARY_OPERATOR_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_OPERATOR_EXPRESSION__URI = BINARY_OPERATOR_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_OPERATOR_EXPRESSION__REGION = BINARY_OPERATOR_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_OPERATOR_EXPRESSION__RESOLVED_TYPE = BINARY_OPERATOR_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_OPERATOR_EXPRESSION__LHS = BINARY_OPERATOR_EXPRESSION__LHS;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_OPERATOR_EXPRESSION__RHS = BINARY_OPERATOR_EXPRESSION__RHS;

	/**
	 * The number of structural features of the '<em>And Operator Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_OPERATOR_EXPRESSION_FEATURE_COUNT = BINARY_OPERATOR_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.LiteralExpressionImpl <em>Literal Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.LiteralExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getLiteralExpression()
	 * @generated
	 */
	int LITERAL_EXPRESSION = 11;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXPRESSION__CONTAINER = EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXPRESSION__LINE = EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXPRESSION__COLUMN = EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXPRESSION__URI = EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXPRESSION__REGION = EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXPRESSION__RESOLVED_TYPE = EXPRESSION__RESOLVED_TYPE;

	/**
	 * The number of structural features of the '<em>Literal Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.PrimitiveExpressionImpl <em>Primitive Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.PrimitiveExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getPrimitiveExpression()
	 * @generated
	 */
	int PRIMITIVE_EXPRESSION = 55;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_EXPRESSION__CONTAINER = LITERAL_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_EXPRESSION__LINE = LITERAL_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_EXPRESSION__COLUMN = LITERAL_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_EXPRESSION__URI = LITERAL_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_EXPRESSION__REGION = LITERAL_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_EXPRESSION__RESOLVED_TYPE = LITERAL_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The number of structural features of the '<em>Primitive Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_EXPRESSION_FEATURE_COUNT = LITERAL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.BooleanExpressionImpl <em>Boolean Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.BooleanExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getBooleanExpression()
	 * @generated
	 */
	int BOOLEAN_EXPRESSION = 12;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXPRESSION__CONTAINER = PRIMITIVE_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXPRESSION__LINE = PRIMITIVE_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXPRESSION__COLUMN = PRIMITIVE_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXPRESSION__URI = PRIMITIVE_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXPRESSION__REGION = PRIMITIVE_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXPRESSION__RESOLVED_TYPE = PRIMITIVE_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Val</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXPRESSION__VAL = PRIMITIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXPRESSION_FEATURE_COUNT = PRIMITIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.DivideOperatorExpressionImpl <em>Divide Operator Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.DivideOperatorExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getDivideOperatorExpression()
	 * @generated
	 */
	int DIVIDE_OPERATOR_EXPRESSION = 13;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVIDE_OPERATOR_EXPRESSION__CONTAINER = BINARY_OPERATOR_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVIDE_OPERATOR_EXPRESSION__LINE = BINARY_OPERATOR_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVIDE_OPERATOR_EXPRESSION__COLUMN = BINARY_OPERATOR_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVIDE_OPERATOR_EXPRESSION__URI = BINARY_OPERATOR_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVIDE_OPERATOR_EXPRESSION__REGION = BINARY_OPERATOR_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVIDE_OPERATOR_EXPRESSION__RESOLVED_TYPE = BINARY_OPERATOR_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVIDE_OPERATOR_EXPRESSION__LHS = BINARY_OPERATOR_EXPRESSION__LHS;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVIDE_OPERATOR_EXPRESSION__RHS = BINARY_OPERATOR_EXPRESSION__RHS;

	/**
	 * The number of structural features of the '<em>Divide Operator Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVIDE_OPERATOR_EXPRESSION_FEATURE_COUNT = BINARY_OPERATOR_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.EnumerationLiteralExpressionImpl <em>Enumeration Literal Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.EnumerationLiteralExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getEnumerationLiteralExpression()
	 * @generated
	 */
	int ENUMERATION_LITERAL_EXPRESSION = 14;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_EXPRESSION__CONTAINER = EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_EXPRESSION__LINE = EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_EXPRESSION__COLUMN = EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_EXPRESSION__URI = EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_EXPRESSION__REGION = EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_EXPRESSION__RESOLVED_TYPE = EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Enumeration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_EXPRESSION__ENUMERATION = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_EXPRESSION__LITERAL = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_EXPRESSION__MODEL = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Enumeration Literal Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.EqualsOperatorExpressionImpl <em>Equals Operator Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.EqualsOperatorExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getEqualsOperatorExpression()
	 * @generated
	 */
	int EQUALS_OPERATOR_EXPRESSION = 15;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALS_OPERATOR_EXPRESSION__CONTAINER = BINARY_OPERATOR_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALS_OPERATOR_EXPRESSION__LINE = BINARY_OPERATOR_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALS_OPERATOR_EXPRESSION__COLUMN = BINARY_OPERATOR_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALS_OPERATOR_EXPRESSION__URI = BINARY_OPERATOR_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALS_OPERATOR_EXPRESSION__REGION = BINARY_OPERATOR_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALS_OPERATOR_EXPRESSION__RESOLVED_TYPE = BINARY_OPERATOR_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALS_OPERATOR_EXPRESSION__LHS = BINARY_OPERATOR_EXPRESSION__LHS;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALS_OPERATOR_EXPRESSION__RHS = BINARY_OPERATOR_EXPRESSION__RHS;

	/**
	 * The number of structural features of the '<em>Equals Operator Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALS_OPERATOR_EXPRESSION_FEATURE_COUNT = BINARY_OPERATOR_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.FeatureCallExpressionImpl <em>Feature Call Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.FeatureCallExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getFeatureCallExpression()
	 * @generated
	 */
	int FEATURE_CALL_EXPRESSION = 16;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXPRESSION__CONTAINER = EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXPRESSION__LINE = EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXPRESSION__COLUMN = EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXPRESSION__URI = EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXPRESSION__REGION = EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXPRESSION__RESOLVED_TYPE = EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXPRESSION__TARGET = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Arrow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXPRESSION__IS_ARROW = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Feature Call Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.GreaterThanOperatorExpressionImpl <em>Greater Than Operator Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.GreaterThanOperatorExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getGreaterThanOperatorExpression()
	 * @generated
	 */
	int GREATER_THAN_OPERATOR_EXPRESSION = 17;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_THAN_OPERATOR_EXPRESSION__CONTAINER = BINARY_OPERATOR_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_THAN_OPERATOR_EXPRESSION__LINE = BINARY_OPERATOR_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_THAN_OPERATOR_EXPRESSION__COLUMN = BINARY_OPERATOR_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_THAN_OPERATOR_EXPRESSION__URI = BINARY_OPERATOR_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_THAN_OPERATOR_EXPRESSION__REGION = BINARY_OPERATOR_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_THAN_OPERATOR_EXPRESSION__RESOLVED_TYPE = BINARY_OPERATOR_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_THAN_OPERATOR_EXPRESSION__LHS = BINARY_OPERATOR_EXPRESSION__LHS;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_THAN_OPERATOR_EXPRESSION__RHS = BINARY_OPERATOR_EXPRESSION__RHS;

	/**
	 * The number of structural features of the '<em>Greater Than Operator Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_THAN_OPERATOR_EXPRESSION_FEATURE_COUNT = BINARY_OPERATOR_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.GreaterThanOrEqualToOperatorExpressionImpl <em>Greater Than Or Equal To Operator Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.GreaterThanOrEqualToOperatorExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getGreaterThanOrEqualToOperatorExpression()
	 * @generated
	 */
	int GREATER_THAN_OR_EQUAL_TO_OPERATOR_EXPRESSION = 18;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_THAN_OR_EQUAL_TO_OPERATOR_EXPRESSION__CONTAINER = BINARY_OPERATOR_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_THAN_OR_EQUAL_TO_OPERATOR_EXPRESSION__LINE = BINARY_OPERATOR_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_THAN_OR_EQUAL_TO_OPERATOR_EXPRESSION__COLUMN = BINARY_OPERATOR_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_THAN_OR_EQUAL_TO_OPERATOR_EXPRESSION__URI = BINARY_OPERATOR_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_THAN_OR_EQUAL_TO_OPERATOR_EXPRESSION__REGION = BINARY_OPERATOR_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_THAN_OR_EQUAL_TO_OPERATOR_EXPRESSION__RESOLVED_TYPE = BINARY_OPERATOR_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_THAN_OR_EQUAL_TO_OPERATOR_EXPRESSION__LHS = BINARY_OPERATOR_EXPRESSION__LHS;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_THAN_OR_EQUAL_TO_OPERATOR_EXPRESSION__RHS = BINARY_OPERATOR_EXPRESSION__RHS;

	/**
	 * The number of structural features of the '<em>Greater Than Or Equal To Operator Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_THAN_OR_EQUAL_TO_OPERATOR_EXPRESSION_FEATURE_COUNT = BINARY_OPERATOR_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.ImpliesOperatorExpressionImpl <em>Implies Operator Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.ImpliesOperatorExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getImpliesOperatorExpression()
	 * @generated
	 */
	int IMPLIES_OPERATOR_EXPRESSION = 19;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES_OPERATOR_EXPRESSION__CONTAINER = BINARY_OPERATOR_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES_OPERATOR_EXPRESSION__LINE = BINARY_OPERATOR_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES_OPERATOR_EXPRESSION__COLUMN = BINARY_OPERATOR_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES_OPERATOR_EXPRESSION__URI = BINARY_OPERATOR_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES_OPERATOR_EXPRESSION__REGION = BINARY_OPERATOR_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES_OPERATOR_EXPRESSION__RESOLVED_TYPE = BINARY_OPERATOR_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES_OPERATOR_EXPRESSION__LHS = BINARY_OPERATOR_EXPRESSION__LHS;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES_OPERATOR_EXPRESSION__RHS = BINARY_OPERATOR_EXPRESSION__RHS;

	/**
	 * The number of structural features of the '<em>Implies Operator Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES_OPERATOR_EXPRESSION_FEATURE_COUNT = BINARY_OPERATOR_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.IntegerExpressionImpl <em>Integer Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.IntegerExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getIntegerExpression()
	 * @generated
	 */
	int INTEGER_EXPRESSION = 20;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_EXPRESSION__CONTAINER = PRIMITIVE_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_EXPRESSION__LINE = PRIMITIVE_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_EXPRESSION__COLUMN = PRIMITIVE_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_EXPRESSION__URI = PRIMITIVE_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_EXPRESSION__REGION = PRIMITIVE_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_EXPRESSION__RESOLVED_TYPE = PRIMITIVE_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Val</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_EXPRESSION__VAL = PRIMITIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_EXPRESSION_FEATURE_COUNT = PRIMITIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.LessThanOperatorExpressionImpl <em>Less Than Operator Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.LessThanOperatorExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getLessThanOperatorExpression()
	 * @generated
	 */
	int LESS_THAN_OPERATOR_EXPRESSION = 21;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_THAN_OPERATOR_EXPRESSION__CONTAINER = BINARY_OPERATOR_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_THAN_OPERATOR_EXPRESSION__LINE = BINARY_OPERATOR_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_THAN_OPERATOR_EXPRESSION__COLUMN = BINARY_OPERATOR_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_THAN_OPERATOR_EXPRESSION__URI = BINARY_OPERATOR_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_THAN_OPERATOR_EXPRESSION__REGION = BINARY_OPERATOR_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_THAN_OPERATOR_EXPRESSION__RESOLVED_TYPE = BINARY_OPERATOR_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_THAN_OPERATOR_EXPRESSION__LHS = BINARY_OPERATOR_EXPRESSION__LHS;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_THAN_OPERATOR_EXPRESSION__RHS = BINARY_OPERATOR_EXPRESSION__RHS;

	/**
	 * The number of structural features of the '<em>Less Than Operator Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_THAN_OPERATOR_EXPRESSION_FEATURE_COUNT = BINARY_OPERATOR_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.LessThanOrEqualToOperatorExpressionImpl <em>Less Than Or Equal To Operator Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.LessThanOrEqualToOperatorExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getLessThanOrEqualToOperatorExpression()
	 * @generated
	 */
	int LESS_THAN_OR_EQUAL_TO_OPERATOR_EXPRESSION = 22;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_THAN_OR_EQUAL_TO_OPERATOR_EXPRESSION__CONTAINER = BINARY_OPERATOR_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_THAN_OR_EQUAL_TO_OPERATOR_EXPRESSION__LINE = BINARY_OPERATOR_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_THAN_OR_EQUAL_TO_OPERATOR_EXPRESSION__COLUMN = BINARY_OPERATOR_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_THAN_OR_EQUAL_TO_OPERATOR_EXPRESSION__URI = BINARY_OPERATOR_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_THAN_OR_EQUAL_TO_OPERATOR_EXPRESSION__REGION = BINARY_OPERATOR_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_THAN_OR_EQUAL_TO_OPERATOR_EXPRESSION__RESOLVED_TYPE = BINARY_OPERATOR_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_THAN_OR_EQUAL_TO_OPERATOR_EXPRESSION__LHS = BINARY_OPERATOR_EXPRESSION__LHS;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_THAN_OR_EQUAL_TO_OPERATOR_EXPRESSION__RHS = BINARY_OPERATOR_EXPRESSION__RHS;

	/**
	 * The number of structural features of the '<em>Less Than Or Equal To Operator Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_THAN_OR_EQUAL_TO_OPERATOR_EXPRESSION_FEATURE_COUNT = BINARY_OPERATOR_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.MethodCallExpressionImpl <em>Method Call Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.MethodCallExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getMethodCallExpression()
	 * @generated
	 */
	int METHOD_CALL_EXPRESSION = 23;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_CALL_EXPRESSION__CONTAINER = FEATURE_CALL_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_CALL_EXPRESSION__LINE = FEATURE_CALL_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_CALL_EXPRESSION__COLUMN = FEATURE_CALL_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_CALL_EXPRESSION__URI = FEATURE_CALL_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_CALL_EXPRESSION__REGION = FEATURE_CALL_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_CALL_EXPRESSION__RESOLVED_TYPE = FEATURE_CALL_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_CALL_EXPRESSION__TARGET = FEATURE_CALL_EXPRESSION__TARGET;

	/**
	 * The feature id for the '<em><b>Is Arrow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_CALL_EXPRESSION__IS_ARROW = FEATURE_CALL_EXPRESSION__IS_ARROW;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_CALL_EXPRESSION__ARGUMENTS = FEATURE_CALL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Method</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_CALL_EXPRESSION__METHOD = FEATURE_CALL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resolved Methods</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_CALL_EXPRESSION__RESOLVED_METHODS = FEATURE_CALL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Method Call Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_CALL_EXPRESSION_FEATURE_COUNT = FEATURE_CALL_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.MinusOperatorExpressionImpl <em>Minus Operator Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.MinusOperatorExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getMinusOperatorExpression()
	 * @generated
	 */
	int MINUS_OPERATOR_EXPRESSION = 24;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS_OPERATOR_EXPRESSION__CONTAINER = BINARY_OPERATOR_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS_OPERATOR_EXPRESSION__LINE = BINARY_OPERATOR_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS_OPERATOR_EXPRESSION__COLUMN = BINARY_OPERATOR_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS_OPERATOR_EXPRESSION__URI = BINARY_OPERATOR_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS_OPERATOR_EXPRESSION__REGION = BINARY_OPERATOR_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS_OPERATOR_EXPRESSION__RESOLVED_TYPE = BINARY_OPERATOR_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS_OPERATOR_EXPRESSION__LHS = BINARY_OPERATOR_EXPRESSION__LHS;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS_OPERATOR_EXPRESSION__RHS = BINARY_OPERATOR_EXPRESSION__RHS;

	/**
	 * The number of structural features of the '<em>Minus Operator Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS_OPERATOR_EXPRESSION_FEATURE_COUNT = BINARY_OPERATOR_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.MultiplyOperatorExpressionImpl <em>Multiply Operator Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.MultiplyOperatorExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getMultiplyOperatorExpression()
	 * @generated
	 */
	int MULTIPLY_OPERATOR_EXPRESSION = 25;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLY_OPERATOR_EXPRESSION__CONTAINER = BINARY_OPERATOR_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLY_OPERATOR_EXPRESSION__LINE = BINARY_OPERATOR_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLY_OPERATOR_EXPRESSION__COLUMN = BINARY_OPERATOR_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLY_OPERATOR_EXPRESSION__URI = BINARY_OPERATOR_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLY_OPERATOR_EXPRESSION__REGION = BINARY_OPERATOR_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLY_OPERATOR_EXPRESSION__RESOLVED_TYPE = BINARY_OPERATOR_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLY_OPERATOR_EXPRESSION__LHS = BINARY_OPERATOR_EXPRESSION__LHS;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLY_OPERATOR_EXPRESSION__RHS = BINARY_OPERATOR_EXPRESSION__RHS;

	/**
	 * The number of structural features of the '<em>Multiply Operator Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLY_OPERATOR_EXPRESSION_FEATURE_COUNT = BINARY_OPERATOR_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.NameExpressionImpl <em>Name Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.NameExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getNameExpression()
	 * @generated
	 */
	int NAME_EXPRESSION = 26;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXPRESSION__CONTAINER = EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXPRESSION__LINE = EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXPRESSION__COLUMN = EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXPRESSION__URI = EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXPRESSION__REGION = EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXPRESSION__RESOLVED_TYPE = EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXPRESSION__NAME = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXPRESSION__IS_TYPE = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resolved Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXPRESSION__RESOLVED_CONTENT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Name Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.UnaryOperatorExpressionImpl <em>Unary Operator Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.UnaryOperatorExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getUnaryOperatorExpression()
	 * @generated
	 */
	int UNARY_OPERATOR_EXPRESSION = 27;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR_EXPRESSION__CONTAINER = OPERATOR_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR_EXPRESSION__LINE = OPERATOR_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR_EXPRESSION__COLUMN = OPERATOR_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR_EXPRESSION__URI = OPERATOR_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR_EXPRESSION__REGION = OPERATOR_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR_EXPRESSION__RESOLVED_TYPE = OPERATOR_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR_EXPRESSION__EXPR = OPERATOR_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unary Operator Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR_EXPRESSION_FEATURE_COUNT = OPERATOR_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.NegativeOperatorExpressionImpl <em>Negative Operator Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.NegativeOperatorExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getNegativeOperatorExpression()
	 * @generated
	 */
	int NEGATIVE_OPERATOR_EXPRESSION = 28;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEGATIVE_OPERATOR_EXPRESSION__CONTAINER = UNARY_OPERATOR_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEGATIVE_OPERATOR_EXPRESSION__LINE = UNARY_OPERATOR_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEGATIVE_OPERATOR_EXPRESSION__COLUMN = UNARY_OPERATOR_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEGATIVE_OPERATOR_EXPRESSION__URI = UNARY_OPERATOR_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEGATIVE_OPERATOR_EXPRESSION__REGION = UNARY_OPERATOR_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEGATIVE_OPERATOR_EXPRESSION__RESOLVED_TYPE = UNARY_OPERATOR_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEGATIVE_OPERATOR_EXPRESSION__EXPR = UNARY_OPERATOR_EXPRESSION__EXPR;

	/**
	 * The number of structural features of the '<em>Negative Operator Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEGATIVE_OPERATOR_EXPRESSION_FEATURE_COUNT = UNARY_OPERATOR_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.NotEqualsOperatorExpressionImpl <em>Not Equals Operator Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.NotEqualsOperatorExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getNotEqualsOperatorExpression()
	 * @generated
	 */
	int NOT_EQUALS_OPERATOR_EXPRESSION = 29;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EQUALS_OPERATOR_EXPRESSION__CONTAINER = BINARY_OPERATOR_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EQUALS_OPERATOR_EXPRESSION__LINE = BINARY_OPERATOR_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EQUALS_OPERATOR_EXPRESSION__COLUMN = BINARY_OPERATOR_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EQUALS_OPERATOR_EXPRESSION__URI = BINARY_OPERATOR_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EQUALS_OPERATOR_EXPRESSION__REGION = BINARY_OPERATOR_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EQUALS_OPERATOR_EXPRESSION__RESOLVED_TYPE = BINARY_OPERATOR_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EQUALS_OPERATOR_EXPRESSION__LHS = BINARY_OPERATOR_EXPRESSION__LHS;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EQUALS_OPERATOR_EXPRESSION__RHS = BINARY_OPERATOR_EXPRESSION__RHS;

	/**
	 * The number of structural features of the '<em>Not Equals Operator Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EQUALS_OPERATOR_EXPRESSION_FEATURE_COUNT = BINARY_OPERATOR_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.NotOperatorExpressionImpl <em>Not Operator Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.NotOperatorExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getNotOperatorExpression()
	 * @generated
	 */
	int NOT_OPERATOR_EXPRESSION = 30;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_OPERATOR_EXPRESSION__CONTAINER = UNARY_OPERATOR_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_OPERATOR_EXPRESSION__LINE = UNARY_OPERATOR_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_OPERATOR_EXPRESSION__COLUMN = UNARY_OPERATOR_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_OPERATOR_EXPRESSION__URI = UNARY_OPERATOR_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_OPERATOR_EXPRESSION__REGION = UNARY_OPERATOR_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_OPERATOR_EXPRESSION__RESOLVED_TYPE = UNARY_OPERATOR_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_OPERATOR_EXPRESSION__EXPR = UNARY_OPERATOR_EXPRESSION__EXPR;

	/**
	 * The number of structural features of the '<em>Not Operator Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_OPERATOR_EXPRESSION_FEATURE_COUNT = UNARY_OPERATOR_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.OrOperatorExpressionImpl <em>Or Operator Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.OrOperatorExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getOrOperatorExpression()
	 * @generated
	 */
	int OR_OPERATOR_EXPRESSION = 31;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_OPERATOR_EXPRESSION__CONTAINER = BINARY_OPERATOR_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_OPERATOR_EXPRESSION__LINE = BINARY_OPERATOR_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_OPERATOR_EXPRESSION__COLUMN = BINARY_OPERATOR_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_OPERATOR_EXPRESSION__URI = BINARY_OPERATOR_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_OPERATOR_EXPRESSION__REGION = BINARY_OPERATOR_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_OPERATOR_EXPRESSION__RESOLVED_TYPE = BINARY_OPERATOR_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_OPERATOR_EXPRESSION__LHS = BINARY_OPERATOR_EXPRESSION__LHS;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_OPERATOR_EXPRESSION__RHS = BINARY_OPERATOR_EXPRESSION__RHS;

	/**
	 * The number of structural features of the '<em>Or Operator Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_OPERATOR_EXPRESSION_FEATURE_COUNT = BINARY_OPERATOR_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.PlusOperatorExpressionImpl <em>Plus Operator Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.PlusOperatorExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getPlusOperatorExpression()
	 * @generated
	 */
	int PLUS_OPERATOR_EXPRESSION = 32;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS_OPERATOR_EXPRESSION__CONTAINER = BINARY_OPERATOR_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS_OPERATOR_EXPRESSION__LINE = BINARY_OPERATOR_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS_OPERATOR_EXPRESSION__COLUMN = BINARY_OPERATOR_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS_OPERATOR_EXPRESSION__URI = BINARY_OPERATOR_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS_OPERATOR_EXPRESSION__REGION = BINARY_OPERATOR_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS_OPERATOR_EXPRESSION__RESOLVED_TYPE = BINARY_OPERATOR_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS_OPERATOR_EXPRESSION__LHS = BINARY_OPERATOR_EXPRESSION__LHS;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS_OPERATOR_EXPRESSION__RHS = BINARY_OPERATOR_EXPRESSION__RHS;

	/**
	 * The number of structural features of the '<em>Plus Operator Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS_OPERATOR_EXPRESSION_FEATURE_COUNT = BINARY_OPERATOR_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.PropertyCallExpressionImpl <em>Property Call Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.PropertyCallExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getPropertyCallExpression()
	 * @generated
	 */
	int PROPERTY_CALL_EXPRESSION = 33;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXPRESSION__CONTAINER = FEATURE_CALL_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXPRESSION__LINE = FEATURE_CALL_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXPRESSION__COLUMN = FEATURE_CALL_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXPRESSION__URI = FEATURE_CALL_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXPRESSION__REGION = FEATURE_CALL_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXPRESSION__RESOLVED_TYPE = FEATURE_CALL_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXPRESSION__TARGET = FEATURE_CALL_EXPRESSION__TARGET;

	/**
	 * The feature id for the '<em><b>Is Arrow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXPRESSION__IS_ARROW = FEATURE_CALL_EXPRESSION__IS_ARROW;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXPRESSION__PROPERTY = FEATURE_CALL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extended</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXPRESSION__EXTENDED = FEATURE_CALL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Property Call Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXPRESSION_FEATURE_COUNT = FEATURE_CALL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.RealExpressionImpl <em>Real Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.RealExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getRealExpression()
	 * @generated
	 */
	int REAL_EXPRESSION = 34;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_EXPRESSION__CONTAINER = PRIMITIVE_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_EXPRESSION__LINE = PRIMITIVE_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_EXPRESSION__COLUMN = PRIMITIVE_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_EXPRESSION__URI = PRIMITIVE_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_EXPRESSION__REGION = PRIMITIVE_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_EXPRESSION__RESOLVED_TYPE = PRIMITIVE_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Val</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_EXPRESSION__VAL = PRIMITIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Real Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_EXPRESSION_FEATURE_COUNT = PRIMITIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.StringExpressionImpl <em>String Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.StringExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getStringExpression()
	 * @generated
	 */
	int STRING_EXPRESSION = 35;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_EXPRESSION__CONTAINER = PRIMITIVE_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_EXPRESSION__LINE = PRIMITIVE_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_EXPRESSION__COLUMN = PRIMITIVE_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_EXPRESSION__URI = PRIMITIVE_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_EXPRESSION__REGION = PRIMITIVE_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_EXPRESSION__RESOLVED_TYPE = PRIMITIVE_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Val</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_EXPRESSION__VAL = PRIMITIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_EXPRESSION_FEATURE_COUNT = PRIMITIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.VariableDeclarationExpressionImpl <em>Variable Declaration Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.VariableDeclarationExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getVariableDeclarationExpression()
	 * @generated
	 */
	int VARIABLE_DECLARATION_EXPRESSION = 36;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_EXPRESSION__CONTAINER = EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_EXPRESSION__LINE = EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_EXPRESSION__COLUMN = EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_EXPRESSION__URI = EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_EXPRESSION__REGION = EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_EXPRESSION__RESOLVED_TYPE = EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_EXPRESSION__NAME = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Create</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_EXPRESSION__CREATE = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_EXPRESSION__PARAMETERS = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Last Definition Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_EXPRESSION__LAST_DEFINITION_POINT = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Variable Declaration Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.XorOperatorExpressionImpl <em>Xor Operator Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.XorOperatorExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getXorOperatorExpression()
	 * @generated
	 */
	int XOR_OPERATOR_EXPRESSION = 37;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_OPERATOR_EXPRESSION__CONTAINER = BINARY_OPERATOR_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_OPERATOR_EXPRESSION__LINE = BINARY_OPERATOR_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_OPERATOR_EXPRESSION__COLUMN = BINARY_OPERATOR_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_OPERATOR_EXPRESSION__URI = BINARY_OPERATOR_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_OPERATOR_EXPRESSION__REGION = BINARY_OPERATOR_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_OPERATOR_EXPRESSION__RESOLVED_TYPE = BINARY_OPERATOR_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_OPERATOR_EXPRESSION__LHS = BINARY_OPERATOR_EXPRESSION__LHS;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_OPERATOR_EXPRESSION__RHS = BINARY_OPERATOR_EXPRESSION__RHS;

	/**
	 * The number of structural features of the '<em>Xor Operator Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_OPERATOR_EXPRESSION_FEATURE_COUNT = BINARY_OPERATOR_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.OperationDefinitionImpl <em>Operation Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.OperationDefinitionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getOperationDefinition()
	 * @generated
	 */
	int OPERATION_DEFINITION = 38;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_DEFINITION__CONTAINER = DOM_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_DEFINITION__LINE = DOM_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_DEFINITION__COLUMN = DOM_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_DEFINITION__URI = DOM_ELEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_DEFINITION__REGION = DOM_ELEMENT__REGION;

	/**
	 * The feature id for the '<em><b>Context Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_DEFINITION__CONTEXT_TYPE = DOM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_DEFINITION__RETURN_TYPE = DOM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotation Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_DEFINITION__ANNOTATION_BLOCK = DOM_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_DEFINITION__BODY = DOM_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_DEFINITION__NAME = DOM_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_DEFINITION__PARAMETERS = DOM_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Self</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_DEFINITION__SELF = DOM_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_DEFINITION__RESULT = DOM_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Operation Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_DEFINITION_FEATURE_COUNT = DOM_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.AssignmentStatementImpl <em>Assignment Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.AssignmentStatementImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getAssignmentStatement()
	 * @generated
	 */
	int ASSIGNMENT_STATEMENT = 39;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_STATEMENT__CONTAINER = STATEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_STATEMENT__LINE = STATEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_STATEMENT__COLUMN = STATEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_STATEMENT__URI = STATEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_STATEMENT__REGION = STATEMENT__REGION;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_STATEMENT__LHS = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_STATEMENT__RHS = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Assignment Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.BreakStatementImpl <em>Break Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.BreakStatementImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getBreakStatement()
	 * @generated
	 */
	int BREAK_STATEMENT = 40;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_STATEMENT__CONTAINER = STATEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_STATEMENT__LINE = STATEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_STATEMENT__COLUMN = STATEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_STATEMENT__URI = STATEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_STATEMENT__REGION = STATEMENT__REGION;

	/**
	 * The number of structural features of the '<em>Break Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.BreakAllStatementImpl <em>Break All Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.BreakAllStatementImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getBreakAllStatement()
	 * @generated
	 */
	int BREAK_ALL_STATEMENT = 41;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_ALL_STATEMENT__CONTAINER = STATEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_ALL_STATEMENT__LINE = STATEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_ALL_STATEMENT__COLUMN = STATEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_ALL_STATEMENT__URI = STATEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_ALL_STATEMENT__REGION = STATEMENT__REGION;

	/**
	 * The number of structural features of the '<em>Break All Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_ALL_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.ContinueStatementImpl <em>Continue Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.ContinueStatementImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getContinueStatement()
	 * @generated
	 */
	int CONTINUE_STATEMENT = 42;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_STATEMENT__CONTAINER = STATEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_STATEMENT__LINE = STATEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_STATEMENT__COLUMN = STATEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_STATEMENT__URI = STATEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_STATEMENT__REGION = STATEMENT__REGION;

	/**
	 * The number of structural features of the '<em>Continue Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.DeleteStatementImpl <em>Delete Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.DeleteStatementImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getDeleteStatement()
	 * @generated
	 */
	int DELETE_STATEMENT = 43;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_STATEMENT__CONTAINER = STATEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_STATEMENT__LINE = STATEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_STATEMENT__COLUMN = STATEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_STATEMENT__URI = STATEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_STATEMENT__REGION = STATEMENT__REGION;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_STATEMENT__DELETED = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Delete Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.ForStatementImpl <em>For Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.ForStatementImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getForStatement()
	 * @generated
	 */
	int FOR_STATEMENT = 44;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__CONTAINER = STATEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__LINE = STATEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__COLUMN = STATEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__URI = STATEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__REGION = STATEMENT__REGION;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__ITERATOR = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Iterated</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__ITERATED = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__BODY = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>For Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.IfStatementImpl <em>If Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.IfStatementImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getIfStatement()
	 * @generated
	 */
	int IF_STATEMENT = 45;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__CONTAINER = STATEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__LINE = STATEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__COLUMN = STATEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__URI = STATEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__REGION = STATEMENT__REGION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__CONDITION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>If Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__IF_BODY = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Else Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__ELSE_BODY = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>If Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.ReturnStatementImpl <em>Return Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.ReturnStatementImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getReturnStatement()
	 * @generated
	 */
	int RETURN_STATEMENT = 46;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_STATEMENT__CONTAINER = STATEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_STATEMENT__LINE = STATEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_STATEMENT__COLUMN = STATEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_STATEMENT__URI = STATEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_STATEMENT__REGION = STATEMENT__REGION;

	/**
	 * The feature id for the '<em><b>Returned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_STATEMENT__RETURNED = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Return Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.SwitchStatementImpl <em>Switch Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.SwitchStatementImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getSwitchStatement()
	 * @generated
	 */
	int SWITCH_STATEMENT = 47;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT__CONTAINER = STATEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT__LINE = STATEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT__COLUMN = STATEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT__URI = STATEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT__REGION = STATEMENT__REGION;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT__EXPRESSION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cases</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT__CASES = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Default</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT__DEFAULT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Switch Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.SwitchCaseStatementImpl <em>Switch Case Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.SwitchCaseStatementImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getSwitchCaseStatement()
	 * @generated
	 */
	int SWITCH_CASE_STATEMENT = 48;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_STATEMENT__CONTAINER = STATEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_STATEMENT__LINE = STATEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_STATEMENT__COLUMN = STATEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_STATEMENT__URI = STATEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_STATEMENT__REGION = STATEMENT__REGION;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_STATEMENT__BODY = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Switch Case Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.WhileStatementImpl <em>While Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.WhileStatementImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getWhileStatement()
	 * @generated
	 */
	int WHILE_STATEMENT = 49;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_STATEMENT__CONTAINER = STATEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_STATEMENT__LINE = STATEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_STATEMENT__COLUMN = STATEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_STATEMENT__URI = STATEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_STATEMENT__REGION = STATEMENT__REGION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_STATEMENT__CONDITION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_STATEMENT__BODY = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>While Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.ModelDeclarationStatementImpl <em>Model Declaration Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.ModelDeclarationStatementImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getModelDeclarationStatement()
	 * @generated
	 */
	int MODEL_DECLARATION_STATEMENT = 50;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECLARATION_STATEMENT__CONTAINER = STATEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECLARATION_STATEMENT__LINE = STATEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECLARATION_STATEMENT__COLUMN = STATEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECLARATION_STATEMENT__URI = STATEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECLARATION_STATEMENT__REGION = STATEMENT__REGION;

	/**
	 * The feature id for the '<em><b>Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECLARATION_STATEMENT__PACKAGES = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECLARATION_STATEMENT__NAME = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Alias</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECLARATION_STATEMENT__ALIAS = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Driver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECLARATION_STATEMENT__DRIVER = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECLARATION_STATEMENT__PARAMETERS = STATEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>EReference0</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECLARATION_STATEMENT__EREFERENCE0 = STATEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Model Declaration Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECLARATION_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.FOLMethodCallExpressionImpl <em>FOL Method Call Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.FOLMethodCallExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getFOLMethodCallExpression()
	 * @generated
	 */
	int FOL_METHOD_CALL_EXPRESSION = 51;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOL_METHOD_CALL_EXPRESSION__CONTAINER = FEATURE_CALL_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOL_METHOD_CALL_EXPRESSION__LINE = FEATURE_CALL_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOL_METHOD_CALL_EXPRESSION__COLUMN = FEATURE_CALL_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOL_METHOD_CALL_EXPRESSION__URI = FEATURE_CALL_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOL_METHOD_CALL_EXPRESSION__REGION = FEATURE_CALL_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOL_METHOD_CALL_EXPRESSION__RESOLVED_TYPE = FEATURE_CALL_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOL_METHOD_CALL_EXPRESSION__TARGET = FEATURE_CALL_EXPRESSION__TARGET;

	/**
	 * The feature id for the '<em><b>Is Arrow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOL_METHOD_CALL_EXPRESSION__IS_ARROW = FEATURE_CALL_EXPRESSION__IS_ARROW;

	/**
	 * The feature id for the '<em><b>Iterators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOL_METHOD_CALL_EXPRESSION__ITERATORS = FEATURE_CALL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOL_METHOD_CALL_EXPRESSION__CONDITIONS = FEATURE_CALL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Method</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOL_METHOD_CALL_EXPRESSION__METHOD = FEATURE_CALL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>FOL Method Call Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOL_METHOD_CALL_EXPRESSION_FEATURE_COUNT = FEATURE_CALL_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.ExpressionStatementImpl <em>Expression Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.ExpressionStatementImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getExpressionStatement()
	 * @generated
	 */
	int EXPRESSION_STATEMENT = 52;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT__CONTAINER = STATEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT__LINE = STATEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT__COLUMN = STATEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT__URI = STATEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT__REGION = STATEMENT__REGION;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT__EXPRESSION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expression Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.SwitchCaseDefaultStatementImpl <em>Switch Case Default Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.SwitchCaseDefaultStatementImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getSwitchCaseDefaultStatement()
	 * @generated
	 */
	int SWITCH_CASE_DEFAULT_STATEMENT = 53;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_DEFAULT_STATEMENT__CONTAINER = SWITCH_CASE_STATEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_DEFAULT_STATEMENT__LINE = SWITCH_CASE_STATEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_DEFAULT_STATEMENT__COLUMN = SWITCH_CASE_STATEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_DEFAULT_STATEMENT__URI = SWITCH_CASE_STATEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_DEFAULT_STATEMENT__REGION = SWITCH_CASE_STATEMENT__REGION;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_DEFAULT_STATEMENT__BODY = SWITCH_CASE_STATEMENT__BODY;

	/**
	 * The number of structural features of the '<em>Switch Case Default Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_DEFAULT_STATEMENT_FEATURE_COUNT = SWITCH_CASE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.SwitchCaseExpressionStatementImpl <em>Switch Case Expression Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.SwitchCaseExpressionStatementImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getSwitchCaseExpressionStatement()
	 * @generated
	 */
	int SWITCH_CASE_EXPRESSION_STATEMENT = 54;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_EXPRESSION_STATEMENT__CONTAINER = SWITCH_CASE_STATEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_EXPRESSION_STATEMENT__LINE = SWITCH_CASE_STATEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_EXPRESSION_STATEMENT__COLUMN = SWITCH_CASE_STATEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_EXPRESSION_STATEMENT__URI = SWITCH_CASE_STATEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_EXPRESSION_STATEMENT__REGION = SWITCH_CASE_STATEMENT__REGION;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_EXPRESSION_STATEMENT__BODY = SWITCH_CASE_STATEMENT__BODY;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_EXPRESSION_STATEMENT__EXPRESSION = SWITCH_CASE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Switch Case Expression Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_EXPRESSION_STATEMENT_FEATURE_COUNT = SWITCH_CASE_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.CollectionExpressionImpl <em>Collection Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.CollectionExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getCollectionExpression()
	 * @generated
	 */
	int COLLECTION_EXPRESSION = 56;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_EXPRESSION__CONTAINER = LITERAL_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_EXPRESSION__LINE = LITERAL_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_EXPRESSION__COLUMN = LITERAL_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_EXPRESSION__URI = LITERAL_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_EXPRESSION__REGION = LITERAL_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_EXPRESSION__RESOLVED_TYPE = LITERAL_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Parameter List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_EXPRESSION__PARAMETER_LIST = LITERAL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Content Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_EXPRESSION__CONTENT_TYPE = LITERAL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_EXPRESSION__CONTENTS = LITERAL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Collection Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_EXPRESSION_FEATURE_COUNT = LITERAL_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.SetExpressionImpl <em>Set Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.SetExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getSetExpression()
	 * @generated
	 */
	int SET_EXPRESSION = 57;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_EXPRESSION__CONTAINER = COLLECTION_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_EXPRESSION__LINE = COLLECTION_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_EXPRESSION__COLUMN = COLLECTION_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_EXPRESSION__URI = COLLECTION_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_EXPRESSION__REGION = COLLECTION_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_EXPRESSION__RESOLVED_TYPE = COLLECTION_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Parameter List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_EXPRESSION__PARAMETER_LIST = COLLECTION_EXPRESSION__PARAMETER_LIST;

	/**
	 * The feature id for the '<em><b>Content Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_EXPRESSION__CONTENT_TYPE = COLLECTION_EXPRESSION__CONTENT_TYPE;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_EXPRESSION__CONTENTS = COLLECTION_EXPRESSION__CONTENTS;

	/**
	 * The number of structural features of the '<em>Set Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_EXPRESSION_FEATURE_COUNT = COLLECTION_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.BagExpressionImpl <em>Bag Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.BagExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getBagExpression()
	 * @generated
	 */
	int BAG_EXPRESSION = 58;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_EXPRESSION__CONTAINER = COLLECTION_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_EXPRESSION__LINE = COLLECTION_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_EXPRESSION__COLUMN = COLLECTION_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_EXPRESSION__URI = COLLECTION_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_EXPRESSION__REGION = COLLECTION_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_EXPRESSION__RESOLVED_TYPE = COLLECTION_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Parameter List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_EXPRESSION__PARAMETER_LIST = COLLECTION_EXPRESSION__PARAMETER_LIST;

	/**
	 * The feature id for the '<em><b>Content Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_EXPRESSION__CONTENT_TYPE = COLLECTION_EXPRESSION__CONTENT_TYPE;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_EXPRESSION__CONTENTS = COLLECTION_EXPRESSION__CONTENTS;

	/**
	 * The number of structural features of the '<em>Bag Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_EXPRESSION_FEATURE_COUNT = COLLECTION_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.SequenceExpressionImpl <em>Sequence Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.SequenceExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getSequenceExpression()
	 * @generated
	 */
	int SEQUENCE_EXPRESSION = 59;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_EXPRESSION__CONTAINER = COLLECTION_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_EXPRESSION__LINE = COLLECTION_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_EXPRESSION__COLUMN = COLLECTION_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_EXPRESSION__URI = COLLECTION_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_EXPRESSION__REGION = COLLECTION_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_EXPRESSION__RESOLVED_TYPE = COLLECTION_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Parameter List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_EXPRESSION__PARAMETER_LIST = COLLECTION_EXPRESSION__PARAMETER_LIST;

	/**
	 * The feature id for the '<em><b>Content Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_EXPRESSION__CONTENT_TYPE = COLLECTION_EXPRESSION__CONTENT_TYPE;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_EXPRESSION__CONTENTS = COLLECTION_EXPRESSION__CONTENTS;

	/**
	 * The number of structural features of the '<em>Sequence Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_EXPRESSION_FEATURE_COUNT = COLLECTION_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.OrderedSetExpressionImpl <em>Ordered Set Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.OrderedSetExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getOrderedSetExpression()
	 * @generated
	 */
	int ORDERED_SET_EXPRESSION = 60;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_EXPRESSION__CONTAINER = COLLECTION_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_EXPRESSION__LINE = COLLECTION_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_EXPRESSION__COLUMN = COLLECTION_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_EXPRESSION__URI = COLLECTION_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_EXPRESSION__REGION = COLLECTION_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_EXPRESSION__RESOLVED_TYPE = COLLECTION_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Parameter List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_EXPRESSION__PARAMETER_LIST = COLLECTION_EXPRESSION__PARAMETER_LIST;

	/**
	 * The feature id for the '<em><b>Content Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_EXPRESSION__CONTENT_TYPE = COLLECTION_EXPRESSION__CONTENT_TYPE;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_EXPRESSION__CONTENTS = COLLECTION_EXPRESSION__CONTENTS;

	/**
	 * The number of structural features of the '<em>Ordered Set Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_EXPRESSION_FEATURE_COUNT = COLLECTION_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.MapExpressionImpl <em>Map Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.MapExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getMapExpression()
	 * @generated
	 */
	int MAP_EXPRESSION = 61;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_EXPRESSION__CONTAINER = LITERAL_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_EXPRESSION__LINE = LITERAL_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_EXPRESSION__COLUMN = LITERAL_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_EXPRESSION__URI = LITERAL_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_EXPRESSION__REGION = LITERAL_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_EXPRESSION__RESOLVED_TYPE = LITERAL_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Key Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_EXPRESSION__KEY_VALUES = LITERAL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Map Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_EXPRESSION_FEATURE_COUNT = LITERAL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.TypeImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 62;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__CONTAINER = DOM_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__LINE = DOM_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__COLUMN = DOM_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__URI = DOM_ELEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__REGION = DOM_ELEMENT__REGION;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = DOM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.AnyTypeImpl <em>Any Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.AnyTypeImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getAnyType()
	 * @generated
	 */
	int ANY_TYPE = 63;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__CONTAINER = TYPE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__LINE = TYPE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__COLUMN = TYPE__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__URI = TYPE__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__REGION = TYPE__REGION;

	/**
	 * The feature id for the '<em><b>Temp Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__TEMP_TYPE = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Any Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.CollectionTypeImpl <em>Collection Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.CollectionTypeImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getCollectionType()
	 * @generated
	 */
	int COLLECTION_TYPE = 64;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__CONTAINER = TYPE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__LINE = TYPE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__COLUMN = TYPE__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__URI = TYPE__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__REGION = TYPE__REGION;

	/**
	 * The feature id for the '<em><b>Content Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__CONTENT_TYPE = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Collection Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.PrimitiveTypeImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getPrimitiveType()
	 * @generated
	 */
	int PRIMITIVE_TYPE = 65;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__CONTAINER = TYPE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__LINE = TYPE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__COLUMN = TYPE__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__URI = TYPE__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__REGION = TYPE__REGION;

	/**
	 * The number of structural features of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.BooleanTypeImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getBooleanType()
	 * @generated
	 */
	int BOOLEAN_TYPE = 66;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE__CONTAINER = PRIMITIVE_TYPE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE__LINE = PRIMITIVE_TYPE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE__COLUMN = PRIMITIVE_TYPE__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE__URI = PRIMITIVE_TYPE__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE__REGION = PRIMITIVE_TYPE__REGION;

	/**
	 * The number of structural features of the '<em>Boolean Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.IntegerTypeImpl <em>Integer Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.IntegerTypeImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getIntegerType()
	 * @generated
	 */
	int INTEGER_TYPE = 67;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__CONTAINER = PRIMITIVE_TYPE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__LINE = PRIMITIVE_TYPE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__COLUMN = PRIMITIVE_TYPE__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__URI = PRIMITIVE_TYPE__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__REGION = PRIMITIVE_TYPE__REGION;

	/**
	 * The number of structural features of the '<em>Integer Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.RealTypeImpl <em>Real Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.RealTypeImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getRealType()
	 * @generated
	 */
	int REAL_TYPE = 68;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE__CONTAINER = PRIMITIVE_TYPE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE__LINE = PRIMITIVE_TYPE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE__COLUMN = PRIMITIVE_TYPE__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE__URI = PRIMITIVE_TYPE__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE__REGION = PRIMITIVE_TYPE__REGION;

	/**
	 * The number of structural features of the '<em>Real Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.StringTypeImpl <em>String Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.StringTypeImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getStringType()
	 * @generated
	 */
	int STRING_TYPE = 69;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__CONTAINER = PRIMITIVE_TYPE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__LINE = PRIMITIVE_TYPE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__COLUMN = PRIMITIVE_TYPE__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__URI = PRIMITIVE_TYPE__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__REGION = PRIMITIVE_TYPE__REGION;

	/**
	 * The number of structural features of the '<em>String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.SetTypeImpl <em>Set Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.SetTypeImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getSetType()
	 * @generated
	 */
	int SET_TYPE = 70;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__CONTAINER = COLLECTION_TYPE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__LINE = COLLECTION_TYPE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__COLUMN = COLLECTION_TYPE__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__URI = COLLECTION_TYPE__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__REGION = COLLECTION_TYPE__REGION;

	/**
	 * The feature id for the '<em><b>Content Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__CONTENT_TYPE = COLLECTION_TYPE__CONTENT_TYPE;

	/**
	 * The number of structural features of the '<em>Set Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.BagTypeImpl <em>Bag Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.BagTypeImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getBagType()
	 * @generated
	 */
	int BAG_TYPE = 71;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__CONTAINER = COLLECTION_TYPE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__LINE = COLLECTION_TYPE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__COLUMN = COLLECTION_TYPE__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__URI = COLLECTION_TYPE__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__REGION = COLLECTION_TYPE__REGION;

	/**
	 * The feature id for the '<em><b>Content Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__CONTENT_TYPE = COLLECTION_TYPE__CONTENT_TYPE;

	/**
	 * The number of structural features of the '<em>Bag Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.SequenceTypeImpl <em>Sequence Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.SequenceTypeImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getSequenceType()
	 * @generated
	 */
	int SEQUENCE_TYPE = 72;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__CONTAINER = COLLECTION_TYPE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__LINE = COLLECTION_TYPE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__COLUMN = COLLECTION_TYPE__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__URI = COLLECTION_TYPE__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__REGION = COLLECTION_TYPE__REGION;

	/**
	 * The feature id for the '<em><b>Content Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__CONTENT_TYPE = COLLECTION_TYPE__CONTENT_TYPE;

	/**
	 * The number of structural features of the '<em>Sequence Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.OrderedSetTypeImpl <em>Ordered Set Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.OrderedSetTypeImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getOrderedSetType()
	 * @generated
	 */
	int ORDERED_SET_TYPE = 73;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__CONTAINER = COLLECTION_TYPE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__LINE = COLLECTION_TYPE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__COLUMN = COLLECTION_TYPE__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__URI = COLLECTION_TYPE__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__REGION = COLLECTION_TYPE__REGION;

	/**
	 * The feature id for the '<em><b>Content Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__CONTENT_TYPE = COLLECTION_TYPE__CONTENT_TYPE;

	/**
	 * The number of structural features of the '<em>Ordered Set Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.MapTypeImpl <em>Map Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.MapTypeImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getMapType()
	 * @generated
	 */
	int MAP_TYPE = 74;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_TYPE__CONTAINER = TYPE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_TYPE__LINE = TYPE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_TYPE__COLUMN = TYPE__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_TYPE__URI = TYPE__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_TYPE__REGION = TYPE__REGION;

	/**
	 * The number of structural features of the '<em>Map Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.AnnotationImpl <em>Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.AnnotationImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getAnnotation()
	 * @generated
	 */
	int ANNOTATION = 75;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__CONTAINER = DOM_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__LINE = DOM_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__COLUMN = DOM_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__URI = DOM_ELEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__REGION = DOM_ELEMENT__REGION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__NAME = DOM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_FEATURE_COUNT = DOM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.ExecutableAnnotationImpl <em>Executable Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.ExecutableAnnotationImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getExecutableAnnotation()
	 * @generated
	 */
	int EXECUTABLE_ANNOTATION = 76;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE_ANNOTATION__CONTAINER = ANNOTATION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE_ANNOTATION__LINE = ANNOTATION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE_ANNOTATION__COLUMN = ANNOTATION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE_ANNOTATION__URI = ANNOTATION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE_ANNOTATION__REGION = ANNOTATION__REGION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE_ANNOTATION__NAME = ANNOTATION__NAME;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE_ANNOTATION__EXPRESSION = ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Executable Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE_ANNOTATION_FEATURE_COUNT = ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.SimpleAnnotationImpl <em>Simple Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.SimpleAnnotationImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getSimpleAnnotation()
	 * @generated
	 */
	int SIMPLE_ANNOTATION = 77;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ANNOTATION__CONTAINER = ANNOTATION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ANNOTATION__LINE = ANNOTATION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ANNOTATION__COLUMN = ANNOTATION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ANNOTATION__URI = ANNOTATION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ANNOTATION__REGION = ANNOTATION__REGION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ANNOTATION__NAME = ANNOTATION__NAME;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ANNOTATION__VALUES = ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Simple Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ANNOTATION_FEATURE_COUNT = ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.KeyValueImpl <em>Key Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.KeyValueImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getKeyValue()
	 * @generated
	 */
	int KEY_VALUE = 78;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_VALUE__CONTAINER = DOM_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_VALUE__LINE = DOM_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_VALUE__COLUMN = DOM_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_VALUE__URI = DOM_ELEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_VALUE__REGION = DOM_ELEMENT__REGION;

	/**
	 * The feature id for the '<em><b>Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_VALUE__KEY = DOM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_VALUE__VALUE = DOM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Key Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_VALUE_FEATURE_COUNT = DOM_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.SpecialNameExpressionImpl <em>Special Name Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.SpecialNameExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getSpecialNameExpression()
	 * @generated
	 */
	int SPECIAL_NAME_EXPRESSION = 79;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_NAME_EXPRESSION__CONTAINER = NAME_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_NAME_EXPRESSION__LINE = NAME_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_NAME_EXPRESSION__COLUMN = NAME_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_NAME_EXPRESSION__URI = NAME_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_NAME_EXPRESSION__REGION = NAME_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_NAME_EXPRESSION__RESOLVED_TYPE = NAME_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_NAME_EXPRESSION__NAME = NAME_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Is Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_NAME_EXPRESSION__IS_TYPE = NAME_EXPRESSION__IS_TYPE;

	/**
	 * The feature id for the '<em><b>Resolved Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_NAME_EXPRESSION__RESOLVED_CONTENT = NAME_EXPRESSION__RESOLVED_CONTENT;

	/**
	 * The number of structural features of the '<em>Special Name Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_NAME_EXPRESSION_FEATURE_COUNT = NAME_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.ModelElementTypeImpl <em>Model Element Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.ModelElementTypeImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getModelElementType()
	 * @generated
	 */
	int MODEL_ELEMENT_TYPE = 80;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_TYPE__CONTAINER = TYPE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_TYPE__LINE = TYPE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_TYPE__COLUMN = TYPE__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_TYPE__URI = TYPE__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_TYPE__REGION = TYPE__REGION;

	/**
	 * The feature id for the '<em><b>Ecore Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_TYPE__ECORE_TYPE = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resolved Model Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_TYPE__RESOLVED_MODEL_DECLARATION = TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Model Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_TYPE__MODEL_NAME = TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_TYPE__ELEMENT_NAME = TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Model Element Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.NativeTypeImpl <em>Native Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.NativeTypeImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getNativeType()
	 * @generated
	 */
	int NATIVE_TYPE = 81;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE_TYPE__CONTAINER = TYPE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE_TYPE__LINE = TYPE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE_TYPE__COLUMN = TYPE__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE_TYPE__URI = TYPE__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE_TYPE__REGION = TYPE__REGION;

	/**
	 * The feature id for the '<em><b>Native Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE_TYPE__NATIVE_EXPRESSION = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Native Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.ModelExpressionImpl <em>Model Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.ModelExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getModelExpression()
	 * @generated
	 */
	int MODEL_EXPRESSION = 82;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_EXPRESSION__CONTAINER = NAME_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_EXPRESSION__LINE = NAME_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_EXPRESSION__COLUMN = NAME_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_EXPRESSION__URI = NAME_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_EXPRESSION__REGION = NAME_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_EXPRESSION__RESOLVED_TYPE = NAME_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_EXPRESSION__NAME = NAME_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Is Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_EXPRESSION__IS_TYPE = NAME_EXPRESSION__IS_TYPE;

	/**
	 * The feature id for the '<em><b>Resolved Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_EXPRESSION__RESOLVED_CONTENT = NAME_EXPRESSION__RESOLVED_CONTENT;

	/**
	 * The number of structural features of the '<em>Model Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_EXPRESSION_FEATURE_COUNT = NAME_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.AnnotationBlockImpl <em>Annotation Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.AnnotationBlockImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getAnnotationBlock()
	 * @generated
	 */
	int ANNOTATION_BLOCK = 83;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_BLOCK__CONTAINER = DOM_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_BLOCK__LINE = DOM_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_BLOCK__COLUMN = DOM_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_BLOCK__URI = DOM_ELEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_BLOCK__REGION = DOM_ELEMENT__REGION;

	/**
	 * The feature id for the '<em><b>Simple Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_BLOCK__SIMPLE_ANNOTATIONS = DOM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Executable Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_BLOCK__EXECUTABLE_ANNOTATIONS = DOM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Annotation Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_BLOCK_FEATURE_COUNT = DOM_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.ModelDeclarationParameterImpl <em>Model Declaration Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.ModelDeclarationParameterImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getModelDeclarationParameter()
	 * @generated
	 */
	int MODEL_DECLARATION_PARAMETER = 84;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECLARATION_PARAMETER__CONTAINER = DOM_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECLARATION_PARAMETER__LINE = DOM_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECLARATION_PARAMETER__COLUMN = DOM_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECLARATION_PARAMETER__URI = DOM_ELEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECLARATION_PARAMETER__REGION = DOM_ELEMENT__REGION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECLARATION_PARAMETER__NAME = DOM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECLARATION_PARAMETER__VALUE = DOM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Model Declaration Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECLARATION_PARAMETER_FEATURE_COUNT = DOM_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.ThrowStatementImpl <em>Throw Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.ThrowStatementImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getThrowStatement()
	 * @generated
	 */
	int THROW_STATEMENT = 85;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_STATEMENT__CONTAINER = STATEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_STATEMENT__LINE = STATEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_STATEMENT__COLUMN = STATEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_STATEMENT__URI = STATEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_STATEMENT__REGION = STATEMENT__REGION;

	/**
	 * The feature id for the '<em><b>Thrown</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_STATEMENT__THROWN = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Throw Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.AbortStatementImpl <em>Abort Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.AbortStatementImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getAbortStatement()
	 * @generated
	 */
	int ABORT_STATEMENT = 86;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABORT_STATEMENT__CONTAINER = STATEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABORT_STATEMENT__LINE = STATEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABORT_STATEMENT__COLUMN = STATEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABORT_STATEMENT__URI = STATEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABORT_STATEMENT__REGION = STATEMENT__REGION;

	/**
	 * The number of structural features of the '<em>Abort Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABORT_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.TransactionStatementImpl <em>Transaction Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.TransactionStatementImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getTransactionStatement()
	 * @generated
	 */
	int TRANSACTION_STATEMENT = 87;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_STATEMENT__CONTAINER = STATEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_STATEMENT__LINE = STATEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_STATEMENT__COLUMN = STATEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_STATEMENT__URI = STATEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_STATEMENT__REGION = STATEMENT__REGION;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_STATEMENT__BODY = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Names</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_STATEMENT__NAMES = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Transaction Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.FormalParameterExpressionImpl <em>Formal Parameter Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.FormalParameterExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getFormalParameterExpression()
	 * @generated
	 */
	int FORMAL_PARAMETER_EXPRESSION = 88;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_PARAMETER_EXPRESSION__CONTAINER = VARIABLE_DECLARATION_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_PARAMETER_EXPRESSION__LINE = VARIABLE_DECLARATION_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_PARAMETER_EXPRESSION__COLUMN = VARIABLE_DECLARATION_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_PARAMETER_EXPRESSION__URI = VARIABLE_DECLARATION_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_PARAMETER_EXPRESSION__REGION = VARIABLE_DECLARATION_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_PARAMETER_EXPRESSION__RESOLVED_TYPE = VARIABLE_DECLARATION_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_PARAMETER_EXPRESSION__NAME = VARIABLE_DECLARATION_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Create</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_PARAMETER_EXPRESSION__CREATE = VARIABLE_DECLARATION_EXPRESSION__CREATE;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_PARAMETER_EXPRESSION__PARAMETERS = VARIABLE_DECLARATION_EXPRESSION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Last Definition Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_PARAMETER_EXPRESSION__LAST_DEFINITION_POINT = VARIABLE_DECLARATION_EXPRESSION__LAST_DEFINITION_POINT;

	/**
	 * The number of structural features of the '<em>Formal Parameter Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_PARAMETER_EXPRESSION_FEATURE_COUNT = VARIABLE_DECLARATION_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.CollectionInitValueImpl <em>Collection Init Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.CollectionInitValueImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getCollectionInitValue()
	 * @generated
	 */
	int COLLECTION_INIT_VALUE = 89;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_INIT_VALUE__CONTAINER = DOM_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_INIT_VALUE__LINE = DOM_ELEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_INIT_VALUE__COLUMN = DOM_ELEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_INIT_VALUE__URI = DOM_ELEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_INIT_VALUE__REGION = DOM_ELEMENT__REGION;

	/**
	 * The number of structural features of the '<em>Collection Init Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_INIT_VALUE_FEATURE_COUNT = DOM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.ExprListImpl <em>Expr List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.ExprListImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getExprList()
	 * @generated
	 */
	int EXPR_LIST = 90;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_LIST__CONTAINER = COLLECTION_INIT_VALUE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_LIST__LINE = COLLECTION_INIT_VALUE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_LIST__COLUMN = COLLECTION_INIT_VALUE__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_LIST__URI = COLLECTION_INIT_VALUE__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_LIST__REGION = COLLECTION_INIT_VALUE__REGION;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_LIST__EXPRESSIONS = COLLECTION_INIT_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expr List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_LIST_FEATURE_COUNT = COLLECTION_INIT_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.ExpRangeImpl <em>Exp Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.ExpRangeImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getExpRange()
	 * @generated
	 */
	int EXP_RANGE = 91;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_RANGE__CONTAINER = COLLECTION_INIT_VALUE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_RANGE__LINE = COLLECTION_INIT_VALUE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_RANGE__COLUMN = COLLECTION_INIT_VALUE__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_RANGE__URI = COLLECTION_INIT_VALUE__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_RANGE__REGION = COLLECTION_INIT_VALUE__REGION;

	/**
	 * The feature id for the '<em><b>Start</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_RANGE__START = COLLECTION_INIT_VALUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_RANGE__END = COLLECTION_INIT_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Exp Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_RANGE_FEATURE_COUNT = COLLECTION_INIT_VALUE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.NewExpressionImpl <em>New Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.NewExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getNewExpression()
	 * @generated
	 */
	int NEW_EXPRESSION = 92;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_EXPRESSION__CONTAINER = EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_EXPRESSION__LINE = EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_EXPRESSION__COLUMN = EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_EXPRESSION__URI = EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_EXPRESSION__REGION = EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_EXPRESSION__RESOLVED_TYPE = EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_EXPRESSION__PARAMETERS = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>New Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.SpecialAssignmentStatementImpl <em>Special Assignment Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.SpecialAssignmentStatementImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getSpecialAssignmentStatement()
	 * @generated
	 */
	int SPECIAL_ASSIGNMENT_STATEMENT = 93;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_ASSIGNMENT_STATEMENT__CONTAINER = ASSIGNMENT_STATEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_ASSIGNMENT_STATEMENT__LINE = ASSIGNMENT_STATEMENT__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_ASSIGNMENT_STATEMENT__COLUMN = ASSIGNMENT_STATEMENT__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_ASSIGNMENT_STATEMENT__URI = ASSIGNMENT_STATEMENT__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_ASSIGNMENT_STATEMENT__REGION = ASSIGNMENT_STATEMENT__REGION;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_ASSIGNMENT_STATEMENT__LHS = ASSIGNMENT_STATEMENT__LHS;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_ASSIGNMENT_STATEMENT__RHS = ASSIGNMENT_STATEMENT__RHS;

	/**
	 * The number of structural features of the '<em>Special Assignment Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_ASSIGNMENT_STATEMENT_FEATURE_COUNT = ASSIGNMENT_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.ModelTypeImpl <em>Model Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.ModelTypeImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getModelType()
	 * @generated
	 */
	int MODEL_TYPE = 94;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__CONTAINER = TYPE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__LINE = TYPE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__COLUMN = TYPE__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__URI = TYPE__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__REGION = TYPE__REGION;

	/**
	 * The feature id for the '<em><b>Model Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__MODEL_NAME = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE__MODEL = TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Model Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.NativeExpressionImpl <em>Native Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.NativeExpressionImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getNativeExpression()
	 * @generated
	 */
	int NATIVE_EXPRESSION = 95;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE_EXPRESSION__CONTAINER = LITERAL_EXPRESSION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE_EXPRESSION__LINE = LITERAL_EXPRESSION__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE_EXPRESSION__COLUMN = LITERAL_EXPRESSION__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE_EXPRESSION__URI = LITERAL_EXPRESSION__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE_EXPRESSION__REGION = LITERAL_EXPRESSION__REGION;

	/**
	 * The feature id for the '<em><b>Resolved Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE_EXPRESSION__RESOLVED_TYPE = LITERAL_EXPRESSION__RESOLVED_TYPE;

	/**
	 * The feature id for the '<em><b>Native Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE_EXPRESSION__NATIVE_EXPR = LITERAL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE_EXPRESSION__IS_TYPE = LITERAL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Native Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NATIVE_EXPRESSION_FEATURE_COUNT = LITERAL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.ETypeImpl <em>EType</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.ETypeImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getEType()
	 * @generated
	 */
	int ETYPE = 96;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPE__CONTAINER = TYPE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPE__LINE = TYPE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPE__COLUMN = TYPE__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPE__URI = TYPE__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPE__REGION = TYPE__REGION;

	/**
	 * The feature id for the '<em><b>Ecore Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPE__ECORE_TYPE = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EType</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ETYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.VoidTypeImpl <em>Void Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.VoidTypeImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getVoidType()
	 * @generated
	 */
	int VOID_TYPE = 97;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__CONTAINER = TYPE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__LINE = TYPE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__COLUMN = TYPE__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__URI = TYPE__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__REGION = TYPE__REGION;

	/**
	 * The number of structural features of the '<em>Void Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.PseudoTypeImpl <em>Pseudo Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.PseudoTypeImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getPseudoType()
	 * @generated
	 */
	int PSEUDO_TYPE = 98;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDO_TYPE__CONTAINER = TYPE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDO_TYPE__LINE = TYPE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDO_TYPE__COLUMN = TYPE__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDO_TYPE__URI = TYPE__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDO_TYPE__REGION = TYPE__REGION;

	/**
	 * The number of structural features of the '<em>Pseudo Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDO_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.SelfTypeImpl <em>Self Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.SelfTypeImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getSelfType()
	 * @generated
	 */
	int SELF_TYPE = 99;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE__CONTAINER = PSEUDO_TYPE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE__LINE = PSEUDO_TYPE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE__COLUMN = PSEUDO_TYPE__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE__URI = PSEUDO_TYPE__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE__REGION = PSEUDO_TYPE__REGION;

	/**
	 * The number of structural features of the '<em>Self Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TYPE_FEATURE_COUNT = PSEUDO_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.eol.dom.impl.SelfContentTypeImpl <em>Self Content Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.eol.dom.impl.SelfContentTypeImpl
	 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getSelfContentType()
	 * @generated
	 */
	int SELF_CONTENT_TYPE = 100;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_CONTENT_TYPE__CONTAINER = PSEUDO_TYPE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_CONTENT_TYPE__LINE = PSEUDO_TYPE__LINE;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_CONTENT_TYPE__COLUMN = PSEUDO_TYPE__COLUMN;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_CONTENT_TYPE__URI = PSEUDO_TYPE__URI;

	/**
	 * The feature id for the '<em><b>Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_CONTENT_TYPE__REGION = PSEUDO_TYPE__REGION;

	/**
	 * The number of structural features of the '<em>Self Content Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_CONTENT_TYPE_FEATURE_COUNT = PSEUDO_TYPE_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.DomElement <em>Dom Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dom Element</em>'.
	 * @see org.eclipse.epsilon.eol.dom.DomElement
	 * @generated
	 */
	EClass getDomElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.epsilon.eol.dom.DomElement#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Container</em>'.
	 * @see org.eclipse.epsilon.eol.dom.DomElement#getContainer()
	 * @see #getDomElement()
	 * @generated
	 */
	EReference getDomElement_Container();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.epsilon.eol.dom.DomElement#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see org.eclipse.epsilon.eol.dom.DomElement#getLine()
	 * @see #getDomElement()
	 * @generated
	 */
	EAttribute getDomElement_Line();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.epsilon.eol.dom.DomElement#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Column</em>'.
	 * @see org.eclipse.epsilon.eol.dom.DomElement#getColumn()
	 * @see #getDomElement()
	 * @generated
	 */
	EAttribute getDomElement_Column();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.epsilon.eol.dom.DomElement#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.epsilon.eol.dom.DomElement#getUri()
	 * @see #getDomElement()
	 * @generated
	 */
	EAttribute getDomElement_Uri();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.DomElement#getRegion <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Region</em>'.
	 * @see org.eclipse.epsilon.eol.dom.DomElement#getRegion()
	 * @see #getDomElement()
	 * @generated
	 */
	EReference getDomElement_Region();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.TextRegion <em>Text Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Region</em>'.
	 * @see org.eclipse.epsilon.eol.dom.TextRegion
	 * @generated
	 */
	EClass getTextRegion();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.TextRegion#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Start</em>'.
	 * @see org.eclipse.epsilon.eol.dom.TextRegion#getStart()
	 * @see #getTextRegion()
	 * @generated
	 */
	EReference getTextRegion_Start();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.TextRegion#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>End</em>'.
	 * @see org.eclipse.epsilon.eol.dom.TextRegion#getEnd()
	 * @see #getTextRegion()
	 * @generated
	 */
	EReference getTextRegion_End();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.TextPosition <em>Text Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Position</em>'.
	 * @see org.eclipse.epsilon.eol.dom.TextPosition
	 * @generated
	 */
	EClass getTextPosition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.epsilon.eol.dom.TextPosition#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see org.eclipse.epsilon.eol.dom.TextPosition#getLine()
	 * @see #getTextPosition()
	 * @generated
	 */
	EAttribute getTextPosition_Line();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.epsilon.eol.dom.TextPosition#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Column</em>'.
	 * @see org.eclipse.epsilon.eol.dom.TextPosition#getColumn()
	 * @see #getTextPosition()
	 * @generated
	 */
	EAttribute getTextPosition_Column();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.Program <em>Program</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Program</em>'.
	 * @see org.eclipse.epsilon.eol.dom.Program
	 * @generated
	 */
	EClass getProgram();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.eol.dom.Program#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see org.eclipse.epsilon.eol.dom.Program#getImports()
	 * @see #getProgram()
	 * @generated
	 */
	EReference getProgram_Imports();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.eol.dom.Program#getImportedModules <em>Imported Modules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imported Modules</em>'.
	 * @see org.eclipse.epsilon.eol.dom.Program#getImportedModules()
	 * @see #getProgram()
	 * @generated
	 */
	EReference getProgram_ImportedModules();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.eol.dom.Program#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see org.eclipse.epsilon.eol.dom.Program#getOperations()
	 * @see #getProgram()
	 * @generated
	 */
	EReference getProgram_Operations();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.Program#getBlock <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Block</em>'.
	 * @see org.eclipse.epsilon.eol.dom.Program#getBlock()
	 * @see #getProgram()
	 * @generated
	 */
	EReference getProgram_Block();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.Program#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Name</em>'.
	 * @see org.eclipse.epsilon.eol.dom.Program#getName()
	 * @see #getProgram()
	 * @generated
	 */
	EReference getProgram_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.eol.dom.Program#getModelDeclarations <em>Model Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Declarations</em>'.
	 * @see org.eclipse.epsilon.eol.dom.Program#getModelDeclarations()
	 * @see #getProgram()
	 * @generated
	 */
	EReference getProgram_ModelDeclarations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.Import <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import</em>'.
	 * @see org.eclipse.epsilon.eol.dom.Import
	 * @generated
	 */
	EClass getImport();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.Import#getImported <em>Imported</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Imported</em>'.
	 * @see org.eclipse.epsilon.eol.dom.Import#getImported()
	 * @see #getImport()
	 * @generated
	 */
	EReference getImport_Imported();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.Import#getImportedProgram <em>Imported Program</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Imported Program</em>'.
	 * @see org.eclipse.epsilon.eol.dom.Import#getImportedProgram()
	 * @see #getImport()
	 * @generated
	 */
	EReference getImport_ImportedProgram();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement</em>'.
	 * @see org.eclipse.epsilon.eol.dom.Statement
	 * @generated
	 */
	EClass getStatement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.Expression#getResolvedType <em>Resolved Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Resolved Type</em>'.
	 * @see org.eclipse.epsilon.eol.dom.Expression#getResolvedType()
	 * @see #getExpression()
	 * @generated
	 */
	EReference getExpression_ResolvedType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.Block <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block</em>'.
	 * @see org.eclipse.epsilon.eol.dom.Block
	 * @generated
	 */
	EClass getBlock();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.eol.dom.Block#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see org.eclipse.epsilon.eol.dom.Block#getStatements()
	 * @see #getBlock()
	 * @generated
	 */
	EReference getBlock_Statements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.OperatorExpression <em>Operator Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.OperatorExpression
	 * @generated
	 */
	EClass getOperatorExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.BinaryOperatorExpression <em>Binary Operator Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Operator Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.BinaryOperatorExpression
	 * @generated
	 */
	EClass getBinaryOperatorExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.BinaryOperatorExpression#getLhs <em>Lhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lhs</em>'.
	 * @see org.eclipse.epsilon.eol.dom.BinaryOperatorExpression#getLhs()
	 * @see #getBinaryOperatorExpression()
	 * @generated
	 */
	EReference getBinaryOperatorExpression_Lhs();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.BinaryOperatorExpression#getRhs <em>Rhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rhs</em>'.
	 * @see org.eclipse.epsilon.eol.dom.BinaryOperatorExpression#getRhs()
	 * @see #getBinaryOperatorExpression()
	 * @generated
	 */
	EReference getBinaryOperatorExpression_Rhs();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.AndOperatorExpression <em>And Operator Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And Operator Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.AndOperatorExpression
	 * @generated
	 */
	EClass getAndOperatorExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.LiteralExpression <em>Literal Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.LiteralExpression
	 * @generated
	 */
	EClass getLiteralExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.BooleanExpression <em>Boolean Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.BooleanExpression
	 * @generated
	 */
	EClass getBooleanExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.epsilon.eol.dom.BooleanExpression#isVal <em>Val</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Val</em>'.
	 * @see org.eclipse.epsilon.eol.dom.BooleanExpression#isVal()
	 * @see #getBooleanExpression()
	 * @generated
	 */
	EAttribute getBooleanExpression_Val();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.DivideOperatorExpression <em>Divide Operator Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Divide Operator Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.DivideOperatorExpression
	 * @generated
	 */
	EClass getDivideOperatorExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.EnumerationLiteralExpression <em>Enumeration Literal Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration Literal Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.EnumerationLiteralExpression
	 * @generated
	 */
	EClass getEnumerationLiteralExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.EnumerationLiteralExpression#getEnumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Enumeration</em>'.
	 * @see org.eclipse.epsilon.eol.dom.EnumerationLiteralExpression#getEnumeration()
	 * @see #getEnumerationLiteralExpression()
	 * @generated
	 */
	EReference getEnumerationLiteralExpression_Enumeration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.EnumerationLiteralExpression#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Literal</em>'.
	 * @see org.eclipse.epsilon.eol.dom.EnumerationLiteralExpression#getLiteral()
	 * @see #getEnumerationLiteralExpression()
	 * @generated
	 */
	EReference getEnumerationLiteralExpression_Literal();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.EnumerationLiteralExpression#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Model</em>'.
	 * @see org.eclipse.epsilon.eol.dom.EnumerationLiteralExpression#getModel()
	 * @see #getEnumerationLiteralExpression()
	 * @generated
	 */
	EReference getEnumerationLiteralExpression_Model();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.EqualsOperatorExpression <em>Equals Operator Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equals Operator Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.EqualsOperatorExpression
	 * @generated
	 */
	EClass getEqualsOperatorExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.FeatureCallExpression <em>Feature Call Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Call Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.FeatureCallExpression
	 * @generated
	 */
	EClass getFeatureCallExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.FeatureCallExpression#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.eclipse.epsilon.eol.dom.FeatureCallExpression#getTarget()
	 * @see #getFeatureCallExpression()
	 * @generated
	 */
	EReference getFeatureCallExpression_Target();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.FeatureCallExpression#getIsArrow <em>Is Arrow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Is Arrow</em>'.
	 * @see org.eclipse.epsilon.eol.dom.FeatureCallExpression#getIsArrow()
	 * @see #getFeatureCallExpression()
	 * @generated
	 */
	EReference getFeatureCallExpression_IsArrow();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.GreaterThanOperatorExpression <em>Greater Than Operator Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Greater Than Operator Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.GreaterThanOperatorExpression
	 * @generated
	 */
	EClass getGreaterThanOperatorExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.GreaterThanOrEqualToOperatorExpression <em>Greater Than Or Equal To Operator Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Greater Than Or Equal To Operator Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.GreaterThanOrEqualToOperatorExpression
	 * @generated
	 */
	EClass getGreaterThanOrEqualToOperatorExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.ImpliesOperatorExpression <em>Implies Operator Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implies Operator Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ImpliesOperatorExpression
	 * @generated
	 */
	EClass getImpliesOperatorExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.IntegerExpression <em>Integer Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.IntegerExpression
	 * @generated
	 */
	EClass getIntegerExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.epsilon.eol.dom.IntegerExpression#getVal <em>Val</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Val</em>'.
	 * @see org.eclipse.epsilon.eol.dom.IntegerExpression#getVal()
	 * @see #getIntegerExpression()
	 * @generated
	 */
	EAttribute getIntegerExpression_Val();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.LessThanOperatorExpression <em>Less Than Operator Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Less Than Operator Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.LessThanOperatorExpression
	 * @generated
	 */
	EClass getLessThanOperatorExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.LessThanOrEqualToOperatorExpression <em>Less Than Or Equal To Operator Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Less Than Or Equal To Operator Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.LessThanOrEqualToOperatorExpression
	 * @generated
	 */
	EClass getLessThanOrEqualToOperatorExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.MethodCallExpression <em>Method Call Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method Call Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.MethodCallExpression
	 * @generated
	 */
	EClass getMethodCallExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.eol.dom.MethodCallExpression#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see org.eclipse.epsilon.eol.dom.MethodCallExpression#getArguments()
	 * @see #getMethodCallExpression()
	 * @generated
	 */
	EReference getMethodCallExpression_Arguments();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.MethodCallExpression#getMethod <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Method</em>'.
	 * @see org.eclipse.epsilon.eol.dom.MethodCallExpression#getMethod()
	 * @see #getMethodCallExpression()
	 * @generated
	 */
	EReference getMethodCallExpression_Method();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.epsilon.eol.dom.MethodCallExpression#getResolvedMethods <em>Resolved Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Resolved Methods</em>'.
	 * @see org.eclipse.epsilon.eol.dom.MethodCallExpression#getResolvedMethods()
	 * @see #getMethodCallExpression()
	 * @generated
	 */
	EReference getMethodCallExpression_ResolvedMethods();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.MinusOperatorExpression <em>Minus Operator Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Minus Operator Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.MinusOperatorExpression
	 * @generated
	 */
	EClass getMinusOperatorExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.MultiplyOperatorExpression <em>Multiply Operator Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiply Operator Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.MultiplyOperatorExpression
	 * @generated
	 */
	EClass getMultiplyOperatorExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.NameExpression <em>Name Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Name Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.NameExpression
	 * @generated
	 */
	EClass getNameExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.epsilon.eol.dom.NameExpression#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.epsilon.eol.dom.NameExpression#getName()
	 * @see #getNameExpression()
	 * @generated
	 */
	EAttribute getNameExpression_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.NameExpression#getIsType <em>Is Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Is Type</em>'.
	 * @see org.eclipse.epsilon.eol.dom.NameExpression#getIsType()
	 * @see #getNameExpression()
	 * @generated
	 */
	EReference getNameExpression_IsType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.epsilon.eol.dom.NameExpression#getResolvedContent <em>Resolved Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resolved Content</em>'.
	 * @see org.eclipse.epsilon.eol.dom.NameExpression#getResolvedContent()
	 * @see #getNameExpression()
	 * @generated
	 */
	EAttribute getNameExpression_ResolvedContent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.UnaryOperatorExpression <em>Unary Operator Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Operator Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.UnaryOperatorExpression
	 * @generated
	 */
	EClass getUnaryOperatorExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.UnaryOperatorExpression#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expr</em>'.
	 * @see org.eclipse.epsilon.eol.dom.UnaryOperatorExpression#getExpr()
	 * @see #getUnaryOperatorExpression()
	 * @generated
	 */
	EReference getUnaryOperatorExpression_Expr();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.NegativeOperatorExpression <em>Negative Operator Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Negative Operator Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.NegativeOperatorExpression
	 * @generated
	 */
	EClass getNegativeOperatorExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.NotEqualsOperatorExpression <em>Not Equals Operator Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Equals Operator Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.NotEqualsOperatorExpression
	 * @generated
	 */
	EClass getNotEqualsOperatorExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.NotOperatorExpression <em>Not Operator Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Operator Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.NotOperatorExpression
	 * @generated
	 */
	EClass getNotOperatorExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.OrOperatorExpression <em>Or Operator Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Operator Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.OrOperatorExpression
	 * @generated
	 */
	EClass getOrOperatorExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.PlusOperatorExpression <em>Plus Operator Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plus Operator Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.PlusOperatorExpression
	 * @generated
	 */
	EClass getPlusOperatorExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.PropertyCallExpression <em>Property Call Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Call Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.PropertyCallExpression
	 * @generated
	 */
	EClass getPropertyCallExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.PropertyCallExpression#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Property</em>'.
	 * @see org.eclipse.epsilon.eol.dom.PropertyCallExpression#getProperty()
	 * @see #getPropertyCallExpression()
	 * @generated
	 */
	EReference getPropertyCallExpression_Property();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.PropertyCallExpression#getExtended <em>Extended</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extended</em>'.
	 * @see org.eclipse.epsilon.eol.dom.PropertyCallExpression#getExtended()
	 * @see #getPropertyCallExpression()
	 * @generated
	 */
	EReference getPropertyCallExpression_Extended();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.RealExpression <em>Real Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.RealExpression
	 * @generated
	 */
	EClass getRealExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.epsilon.eol.dom.RealExpression#getVal <em>Val</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Val</em>'.
	 * @see org.eclipse.epsilon.eol.dom.RealExpression#getVal()
	 * @see #getRealExpression()
	 * @generated
	 */
	EAttribute getRealExpression_Val();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.StringExpression <em>String Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.StringExpression
	 * @generated
	 */
	EClass getStringExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.epsilon.eol.dom.StringExpression#getVal <em>Val</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Val</em>'.
	 * @see org.eclipse.epsilon.eol.dom.StringExpression#getVal()
	 * @see #getStringExpression()
	 * @generated
	 */
	EAttribute getStringExpression_Val();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.VariableDeclarationExpression <em>Variable Declaration Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Declaration Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.VariableDeclarationExpression
	 * @generated
	 */
	EClass getVariableDeclarationExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.VariableDeclarationExpression#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Name</em>'.
	 * @see org.eclipse.epsilon.eol.dom.VariableDeclarationExpression#getName()
	 * @see #getVariableDeclarationExpression()
	 * @generated
	 */
	EReference getVariableDeclarationExpression_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.VariableDeclarationExpression#getCreate <em>Create</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Create</em>'.
	 * @see org.eclipse.epsilon.eol.dom.VariableDeclarationExpression#getCreate()
	 * @see #getVariableDeclarationExpression()
	 * @generated
	 */
	EReference getVariableDeclarationExpression_Create();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.eol.dom.VariableDeclarationExpression#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.epsilon.eol.dom.VariableDeclarationExpression#getParameters()
	 * @see #getVariableDeclarationExpression()
	 * @generated
	 */
	EReference getVariableDeclarationExpression_Parameters();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.epsilon.eol.dom.VariableDeclarationExpression#getLastDefinitionPoint <em>Last Definition Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Definition Point</em>'.
	 * @see org.eclipse.epsilon.eol.dom.VariableDeclarationExpression#getLastDefinitionPoint()
	 * @see #getVariableDeclarationExpression()
	 * @generated
	 */
	EAttribute getVariableDeclarationExpression_LastDefinitionPoint();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.XorOperatorExpression <em>Xor Operator Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xor Operator Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.XorOperatorExpression
	 * @generated
	 */
	EClass getXorOperatorExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.OperationDefinition <em>Operation Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Definition</em>'.
	 * @see org.eclipse.epsilon.eol.dom.OperationDefinition
	 * @generated
	 */
	EClass getOperationDefinition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.OperationDefinition#getContextType <em>Context Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Context Type</em>'.
	 * @see org.eclipse.epsilon.eol.dom.OperationDefinition#getContextType()
	 * @see #getOperationDefinition()
	 * @generated
	 */
	EReference getOperationDefinition_ContextType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.OperationDefinition#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return Type</em>'.
	 * @see org.eclipse.epsilon.eol.dom.OperationDefinition#getReturnType()
	 * @see #getOperationDefinition()
	 * @generated
	 */
	EReference getOperationDefinition_ReturnType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.OperationDefinition#getAnnotationBlock <em>Annotation Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Annotation Block</em>'.
	 * @see org.eclipse.epsilon.eol.dom.OperationDefinition#getAnnotationBlock()
	 * @see #getOperationDefinition()
	 * @generated
	 */
	EReference getOperationDefinition_AnnotationBlock();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.OperationDefinition#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.epsilon.eol.dom.OperationDefinition#getBody()
	 * @see #getOperationDefinition()
	 * @generated
	 */
	EReference getOperationDefinition_Body();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.OperationDefinition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Name</em>'.
	 * @see org.eclipse.epsilon.eol.dom.OperationDefinition#getName()
	 * @see #getOperationDefinition()
	 * @generated
	 */
	EReference getOperationDefinition_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.eol.dom.OperationDefinition#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.epsilon.eol.dom.OperationDefinition#getParameters()
	 * @see #getOperationDefinition()
	 * @generated
	 */
	EReference getOperationDefinition_Parameters();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.OperationDefinition#getSelf <em>Self</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Self</em>'.
	 * @see org.eclipse.epsilon.eol.dom.OperationDefinition#getSelf()
	 * @see #getOperationDefinition()
	 * @generated
	 */
	EReference getOperationDefinition_Self();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.OperationDefinition#get_result <em>result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>result</em>'.
	 * @see org.eclipse.epsilon.eol.dom.OperationDefinition#get_result()
	 * @see #getOperationDefinition()
	 * @generated
	 */
	EReference getOperationDefinition__result();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.AssignmentStatement <em>Assignment Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment Statement</em>'.
	 * @see org.eclipse.epsilon.eol.dom.AssignmentStatement
	 * @generated
	 */
	EClass getAssignmentStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.AssignmentStatement#getLhs <em>Lhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lhs</em>'.
	 * @see org.eclipse.epsilon.eol.dom.AssignmentStatement#getLhs()
	 * @see #getAssignmentStatement()
	 * @generated
	 */
	EReference getAssignmentStatement_Lhs();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.AssignmentStatement#getRhs <em>Rhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rhs</em>'.
	 * @see org.eclipse.epsilon.eol.dom.AssignmentStatement#getRhs()
	 * @see #getAssignmentStatement()
	 * @generated
	 */
	EReference getAssignmentStatement_Rhs();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.BreakStatement <em>Break Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Break Statement</em>'.
	 * @see org.eclipse.epsilon.eol.dom.BreakStatement
	 * @generated
	 */
	EClass getBreakStatement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.BreakAllStatement <em>Break All Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Break All Statement</em>'.
	 * @see org.eclipse.epsilon.eol.dom.BreakAllStatement
	 * @generated
	 */
	EClass getBreakAllStatement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.ContinueStatement <em>Continue Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Continue Statement</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ContinueStatement
	 * @generated
	 */
	EClass getContinueStatement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.DeleteStatement <em>Delete Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete Statement</em>'.
	 * @see org.eclipse.epsilon.eol.dom.DeleteStatement
	 * @generated
	 */
	EClass getDeleteStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.DeleteStatement#getDeleted <em>Deleted</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Deleted</em>'.
	 * @see org.eclipse.epsilon.eol.dom.DeleteStatement#getDeleted()
	 * @see #getDeleteStatement()
	 * @generated
	 */
	EReference getDeleteStatement_Deleted();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.ForStatement <em>For Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For Statement</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ForStatement
	 * @generated
	 */
	EClass getForStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.ForStatement#getIterator <em>Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Iterator</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ForStatement#getIterator()
	 * @see #getForStatement()
	 * @generated
	 */
	EReference getForStatement_Iterator();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.ForStatement#getIterated <em>Iterated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Iterated</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ForStatement#getIterated()
	 * @see #getForStatement()
	 * @generated
	 */
	EReference getForStatement_Iterated();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.ForStatement#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ForStatement#getBody()
	 * @see #getForStatement()
	 * @generated
	 */
	EReference getForStatement_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.IfStatement <em>If Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Statement</em>'.
	 * @see org.eclipse.epsilon.eol.dom.IfStatement
	 * @generated
	 */
	EClass getIfStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.IfStatement#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.epsilon.eol.dom.IfStatement#getCondition()
	 * @see #getIfStatement()
	 * @generated
	 */
	EReference getIfStatement_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.IfStatement#getIfBody <em>If Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>If Body</em>'.
	 * @see org.eclipse.epsilon.eol.dom.IfStatement#getIfBody()
	 * @see #getIfStatement()
	 * @generated
	 */
	EReference getIfStatement_IfBody();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.IfStatement#getElseBody <em>Else Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else Body</em>'.
	 * @see org.eclipse.epsilon.eol.dom.IfStatement#getElseBody()
	 * @see #getIfStatement()
	 * @generated
	 */
	EReference getIfStatement_ElseBody();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.ReturnStatement <em>Return Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Return Statement</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ReturnStatement
	 * @generated
	 */
	EClass getReturnStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.ReturnStatement#getReturned <em>Returned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Returned</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ReturnStatement#getReturned()
	 * @see #getReturnStatement()
	 * @generated
	 */
	EReference getReturnStatement_Returned();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.SwitchStatement <em>Switch Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch Statement</em>'.
	 * @see org.eclipse.epsilon.eol.dom.SwitchStatement
	 * @generated
	 */
	EClass getSwitchStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.SwitchStatement#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.SwitchStatement#getExpression()
	 * @see #getSwitchStatement()
	 * @generated
	 */
	EReference getSwitchStatement_Expression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.eol.dom.SwitchStatement#getCases <em>Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cases</em>'.
	 * @see org.eclipse.epsilon.eol.dom.SwitchStatement#getCases()
	 * @see #getSwitchStatement()
	 * @generated
	 */
	EReference getSwitchStatement_Cases();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.SwitchStatement#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default</em>'.
	 * @see org.eclipse.epsilon.eol.dom.SwitchStatement#getDefault()
	 * @see #getSwitchStatement()
	 * @generated
	 */
	EReference getSwitchStatement_Default();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.SwitchCaseStatement <em>Switch Case Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch Case Statement</em>'.
	 * @see org.eclipse.epsilon.eol.dom.SwitchCaseStatement
	 * @generated
	 */
	EClass getSwitchCaseStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.SwitchCaseStatement#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.epsilon.eol.dom.SwitchCaseStatement#getBody()
	 * @see #getSwitchCaseStatement()
	 * @generated
	 */
	EReference getSwitchCaseStatement_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.WhileStatement <em>While Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>While Statement</em>'.
	 * @see org.eclipse.epsilon.eol.dom.WhileStatement
	 * @generated
	 */
	EClass getWhileStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.WhileStatement#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.epsilon.eol.dom.WhileStatement#getCondition()
	 * @see #getWhileStatement()
	 * @generated
	 */
	EReference getWhileStatement_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.WhileStatement#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.epsilon.eol.dom.WhileStatement#getBody()
	 * @see #getWhileStatement()
	 * @generated
	 */
	EReference getWhileStatement_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.ModelDeclarationStatement <em>Model Declaration Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Declaration Statement</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ModelDeclarationStatement
	 * @generated
	 */
	EClass getModelDeclarationStatement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.eol.dom.ModelDeclarationStatement#getPackages <em>Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Packages</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ModelDeclarationStatement#getPackages()
	 * @see #getModelDeclarationStatement()
	 * @generated
	 */
	EReference getModelDeclarationStatement_Packages();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.ModelDeclarationStatement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Name</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ModelDeclarationStatement#getName()
	 * @see #getModelDeclarationStatement()
	 * @generated
	 */
	EReference getModelDeclarationStatement_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.eol.dom.ModelDeclarationStatement#getAlias <em>Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Alias</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ModelDeclarationStatement#getAlias()
	 * @see #getModelDeclarationStatement()
	 * @generated
	 */
	EReference getModelDeclarationStatement_Alias();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.ModelDeclarationStatement#getDriver <em>Driver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Driver</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ModelDeclarationStatement#getDriver()
	 * @see #getModelDeclarationStatement()
	 * @generated
	 */
	EReference getModelDeclarationStatement_Driver();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.eol.dom.ModelDeclarationStatement#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ModelDeclarationStatement#getParameters()
	 * @see #getModelDeclarationStatement()
	 * @generated
	 */
	EReference getModelDeclarationStatement_Parameters();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.epsilon.eol.dom.ModelDeclarationStatement#getEReference0 <em>EReference0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EReference0</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ModelDeclarationStatement#getEReference0()
	 * @see #getModelDeclarationStatement()
	 * @generated
	 */
	EReference getModelDeclarationStatement_EReference0();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.FOLMethodCallExpression <em>FOL Method Call Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FOL Method Call Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.FOLMethodCallExpression
	 * @generated
	 */
	EClass getFOLMethodCallExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.eol.dom.FOLMethodCallExpression#getIterators <em>Iterators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Iterators</em>'.
	 * @see org.eclipse.epsilon.eol.dom.FOLMethodCallExpression#getIterators()
	 * @see #getFOLMethodCallExpression()
	 * @generated
	 */
	EReference getFOLMethodCallExpression_Iterators();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.eol.dom.FOLMethodCallExpression#getConditions <em>Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Conditions</em>'.
	 * @see org.eclipse.epsilon.eol.dom.FOLMethodCallExpression#getConditions()
	 * @see #getFOLMethodCallExpression()
	 * @generated
	 */
	EReference getFOLMethodCallExpression_Conditions();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.FOLMethodCallExpression#getMethod <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Method</em>'.
	 * @see org.eclipse.epsilon.eol.dom.FOLMethodCallExpression#getMethod()
	 * @see #getFOLMethodCallExpression()
	 * @generated
	 */
	EReference getFOLMethodCallExpression_Method();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.ExpressionStatement <em>Expression Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Statement</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ExpressionStatement
	 * @generated
	 */
	EClass getExpressionStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.ExpressionStatement#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ExpressionStatement#getExpression()
	 * @see #getExpressionStatement()
	 * @generated
	 */
	EReference getExpressionStatement_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.SwitchCaseDefaultStatement <em>Switch Case Default Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch Case Default Statement</em>'.
	 * @see org.eclipse.epsilon.eol.dom.SwitchCaseDefaultStatement
	 * @generated
	 */
	EClass getSwitchCaseDefaultStatement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.SwitchCaseExpressionStatement <em>Switch Case Expression Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch Case Expression Statement</em>'.
	 * @see org.eclipse.epsilon.eol.dom.SwitchCaseExpressionStatement
	 * @generated
	 */
	EClass getSwitchCaseExpressionStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.SwitchCaseExpressionStatement#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.SwitchCaseExpressionStatement#getExpression()
	 * @see #getSwitchCaseExpressionStatement()
	 * @generated
	 */
	EReference getSwitchCaseExpressionStatement_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.PrimitiveExpression <em>Primitive Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.PrimitiveExpression
	 * @generated
	 */
	EClass getPrimitiveExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.CollectionExpression <em>Collection Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.CollectionExpression
	 * @generated
	 */
	EClass getCollectionExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.CollectionExpression#getParameterList <em>Parameter List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Parameter List</em>'.
	 * @see org.eclipse.epsilon.eol.dom.CollectionExpression#getParameterList()
	 * @see #getCollectionExpression()
	 * @generated
	 */
	EReference getCollectionExpression_ParameterList();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.CollectionExpression#getContentType <em>Content Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content Type</em>'.
	 * @see org.eclipse.epsilon.eol.dom.CollectionExpression#getContentType()
	 * @see #getCollectionExpression()
	 * @generated
	 */
	EReference getCollectionExpression_ContentType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.eol.dom.CollectionExpression#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contents</em>'.
	 * @see org.eclipse.epsilon.eol.dom.CollectionExpression#getContents()
	 * @see #getCollectionExpression()
	 * @generated
	 */
	EReference getCollectionExpression_Contents();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.SetExpression <em>Set Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.SetExpression
	 * @generated
	 */
	EClass getSetExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.BagExpression <em>Bag Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bag Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.BagExpression
	 * @generated
	 */
	EClass getBagExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.SequenceExpression <em>Sequence Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.SequenceExpression
	 * @generated
	 */
	EClass getSequenceExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.OrderedSetExpression <em>Ordered Set Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ordered Set Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.OrderedSetExpression
	 * @generated
	 */
	EClass getOrderedSetExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.MapExpression <em>Map Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Map Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.MapExpression
	 * @generated
	 */
	EClass getMapExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.eol.dom.MapExpression#getKeyValues <em>Key Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Key Values</em>'.
	 * @see org.eclipse.epsilon.eol.dom.MapExpression#getKeyValues()
	 * @see #getMapExpression()
	 * @generated
	 */
	EReference getMapExpression_KeyValues();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see org.eclipse.epsilon.eol.dom.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.AnyType <em>Any Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Any Type</em>'.
	 * @see org.eclipse.epsilon.eol.dom.AnyType
	 * @generated
	 */
	EClass getAnyType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.AnyType#getTempType <em>Temp Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Temp Type</em>'.
	 * @see org.eclipse.epsilon.eol.dom.AnyType#getTempType()
	 * @see #getAnyType()
	 * @generated
	 */
	EReference getAnyType_TempType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.CollectionType <em>Collection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Type</em>'.
	 * @see org.eclipse.epsilon.eol.dom.CollectionType
	 * @generated
	 */
	EClass getCollectionType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.CollectionType#getContentType <em>Content Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content Type</em>'.
	 * @see org.eclipse.epsilon.eol.dom.CollectionType#getContentType()
	 * @see #getCollectionType()
	 * @generated
	 */
	EReference getCollectionType_ContentType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type</em>'.
	 * @see org.eclipse.epsilon.eol.dom.PrimitiveType
	 * @generated
	 */
	EClass getPrimitiveType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.BooleanType <em>Boolean Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Type</em>'.
	 * @see org.eclipse.epsilon.eol.dom.BooleanType
	 * @generated
	 */
	EClass getBooleanType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.IntegerType <em>Integer Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Type</em>'.
	 * @see org.eclipse.epsilon.eol.dom.IntegerType
	 * @generated
	 */
	EClass getIntegerType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.RealType <em>Real Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Type</em>'.
	 * @see org.eclipse.epsilon.eol.dom.RealType
	 * @generated
	 */
	EClass getRealType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.StringType <em>String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Type</em>'.
	 * @see org.eclipse.epsilon.eol.dom.StringType
	 * @generated
	 */
	EClass getStringType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.SetType <em>Set Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Type</em>'.
	 * @see org.eclipse.epsilon.eol.dom.SetType
	 * @generated
	 */
	EClass getSetType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.BagType <em>Bag Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bag Type</em>'.
	 * @see org.eclipse.epsilon.eol.dom.BagType
	 * @generated
	 */
	EClass getBagType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.SequenceType <em>Sequence Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Type</em>'.
	 * @see org.eclipse.epsilon.eol.dom.SequenceType
	 * @generated
	 */
	EClass getSequenceType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.OrderedSetType <em>Ordered Set Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ordered Set Type</em>'.
	 * @see org.eclipse.epsilon.eol.dom.OrderedSetType
	 * @generated
	 */
	EClass getOrderedSetType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.MapType <em>Map Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Map Type</em>'.
	 * @see org.eclipse.epsilon.eol.dom.MapType
	 * @generated
	 */
	EClass getMapType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation</em>'.
	 * @see org.eclipse.epsilon.eol.dom.Annotation
	 * @generated
	 */
	EClass getAnnotation();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.Annotation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Name</em>'.
	 * @see org.eclipse.epsilon.eol.dom.Annotation#getName()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.ExecutableAnnotation <em>Executable Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Executable Annotation</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ExecutableAnnotation
	 * @generated
	 */
	EClass getExecutableAnnotation();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.ExecutableAnnotation#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ExecutableAnnotation#getExpression()
	 * @see #getExecutableAnnotation()
	 * @generated
	 */
	EReference getExecutableAnnotation_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.SimpleAnnotation <em>Simple Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Annotation</em>'.
	 * @see org.eclipse.epsilon.eol.dom.SimpleAnnotation
	 * @generated
	 */
	EClass getSimpleAnnotation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.eol.dom.SimpleAnnotation#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see org.eclipse.epsilon.eol.dom.SimpleAnnotation#getValues()
	 * @see #getSimpleAnnotation()
	 * @generated
	 */
	EReference getSimpleAnnotation_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.KeyValue <em>Key Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Key Value</em>'.
	 * @see org.eclipse.epsilon.eol.dom.KeyValue
	 * @generated
	 */
	EClass getKeyValue();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.KeyValue#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Key</em>'.
	 * @see org.eclipse.epsilon.eol.dom.KeyValue#getKey()
	 * @see #getKeyValue()
	 * @generated
	 */
	EReference getKeyValue_Key();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.KeyValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.epsilon.eol.dom.KeyValue#getValue()
	 * @see #getKeyValue()
	 * @generated
	 */
	EReference getKeyValue_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.SpecialNameExpression <em>Special Name Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Special Name Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.SpecialNameExpression
	 * @generated
	 */
	EClass getSpecialNameExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.ModelElementType <em>Model Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Element Type</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ModelElementType
	 * @generated
	 */
	EClass getModelElementType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.epsilon.eol.dom.ModelElementType#getEcoreType <em>Ecore Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ecore Type</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ModelElementType#getEcoreType()
	 * @see #getModelElementType()
	 * @generated
	 */
	EReference getModelElementType_EcoreType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.epsilon.eol.dom.ModelElementType#getResolvedModelDeclaration <em>Resolved Model Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resolved Model Declaration</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ModelElementType#getResolvedModelDeclaration()
	 * @see #getModelElementType()
	 * @generated
	 */
	EReference getModelElementType_ResolvedModelDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.epsilon.eol.dom.ModelElementType#getModelName <em>Model Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Name</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ModelElementType#getModelName()
	 * @see #getModelElementType()
	 * @generated
	 */
	EAttribute getModelElementType_ModelName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.epsilon.eol.dom.ModelElementType#getElementName <em>Element Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Element Name</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ModelElementType#getElementName()
	 * @see #getModelElementType()
	 * @generated
	 */
	EAttribute getModelElementType_ElementName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.NativeType <em>Native Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Native Type</em>'.
	 * @see org.eclipse.epsilon.eol.dom.NativeType
	 * @generated
	 */
	EClass getNativeType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.NativeType#getNativeExpression <em>Native Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Native Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.NativeType#getNativeExpression()
	 * @see #getNativeType()
	 * @generated
	 */
	EReference getNativeType_NativeExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.ModelExpression <em>Model Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ModelExpression
	 * @generated
	 */
	EClass getModelExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.AnnotationBlock <em>Annotation Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation Block</em>'.
	 * @see org.eclipse.epsilon.eol.dom.AnnotationBlock
	 * @generated
	 */
	EClass getAnnotationBlock();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.eol.dom.AnnotationBlock#getSimpleAnnotations <em>Simple Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Simple Annotations</em>'.
	 * @see org.eclipse.epsilon.eol.dom.AnnotationBlock#getSimpleAnnotations()
	 * @see #getAnnotationBlock()
	 * @generated
	 */
	EReference getAnnotationBlock_SimpleAnnotations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.eol.dom.AnnotationBlock#getExecutableAnnotations <em>Executable Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Executable Annotations</em>'.
	 * @see org.eclipse.epsilon.eol.dom.AnnotationBlock#getExecutableAnnotations()
	 * @see #getAnnotationBlock()
	 * @generated
	 */
	EReference getAnnotationBlock_ExecutableAnnotations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.ModelDeclarationParameter <em>Model Declaration Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Declaration Parameter</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ModelDeclarationParameter
	 * @generated
	 */
	EClass getModelDeclarationParameter();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.ModelDeclarationParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Name</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ModelDeclarationParameter#getName()
	 * @see #getModelDeclarationParameter()
	 * @generated
	 */
	EReference getModelDeclarationParameter_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.ModelDeclarationParameter#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ModelDeclarationParameter#getValue()
	 * @see #getModelDeclarationParameter()
	 * @generated
	 */
	EReference getModelDeclarationParameter_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.ThrowStatement <em>Throw Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Throw Statement</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ThrowStatement
	 * @generated
	 */
	EClass getThrowStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.ThrowStatement#getThrown <em>Thrown</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Thrown</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ThrowStatement#getThrown()
	 * @see #getThrowStatement()
	 * @generated
	 */
	EReference getThrowStatement_Thrown();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.AbortStatement <em>Abort Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abort Statement</em>'.
	 * @see org.eclipse.epsilon.eol.dom.AbortStatement
	 * @generated
	 */
	EClass getAbortStatement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.TransactionStatement <em>Transaction Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transaction Statement</em>'.
	 * @see org.eclipse.epsilon.eol.dom.TransactionStatement
	 * @generated
	 */
	EClass getTransactionStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.TransactionStatement#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.epsilon.eol.dom.TransactionStatement#getBody()
	 * @see #getTransactionStatement()
	 * @generated
	 */
	EReference getTransactionStatement_Body();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.eol.dom.TransactionStatement#getNames <em>Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Names</em>'.
	 * @see org.eclipse.epsilon.eol.dom.TransactionStatement#getNames()
	 * @see #getTransactionStatement()
	 * @generated
	 */
	EReference getTransactionStatement_Names();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.FormalParameterExpression <em>Formal Parameter Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Formal Parameter Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.FormalParameterExpression
	 * @generated
	 */
	EClass getFormalParameterExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.CollectionInitValue <em>Collection Init Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Init Value</em>'.
	 * @see org.eclipse.epsilon.eol.dom.CollectionInitValue
	 * @generated
	 */
	EClass getCollectionInitValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.ExprList <em>Expr List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expr List</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ExprList
	 * @generated
	 */
	EClass getExprList();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.eol.dom.ExprList#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expressions</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ExprList#getExpressions()
	 * @see #getExprList()
	 * @generated
	 */
	EReference getExprList_Expressions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.ExpRange <em>Exp Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exp Range</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ExpRange
	 * @generated
	 */
	EClass getExpRange();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.ExpRange#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Start</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ExpRange#getStart()
	 * @see #getExpRange()
	 * @generated
	 */
	EReference getExpRange_Start();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.ExpRange#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>End</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ExpRange#getEnd()
	 * @see #getExpRange()
	 * @generated
	 */
	EReference getExpRange_End();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.NewExpression <em>New Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.NewExpression
	 * @generated
	 */
	EClass getNewExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.eol.dom.NewExpression#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.epsilon.eol.dom.NewExpression#getParameters()
	 * @see #getNewExpression()
	 * @generated
	 */
	EReference getNewExpression_Parameters();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.SpecialAssignmentStatement <em>Special Assignment Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Special Assignment Statement</em>'.
	 * @see org.eclipse.epsilon.eol.dom.SpecialAssignmentStatement
	 * @generated
	 */
	EClass getSpecialAssignmentStatement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.ModelType <em>Model Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Type</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ModelType
	 * @generated
	 */
	EClass getModelType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.ModelType#getModelName <em>Model Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Model Name</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ModelType#getModelName()
	 * @see #getModelType()
	 * @generated
	 */
	EReference getModelType_ModelName();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.epsilon.eol.dom.ModelType#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Model</em>'.
	 * @see org.eclipse.epsilon.eol.dom.ModelType#getModel()
	 * @see #getModelType()
	 * @generated
	 */
	EReference getModelType_Model();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.NativeExpression <em>Native Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Native Expression</em>'.
	 * @see org.eclipse.epsilon.eol.dom.NativeExpression
	 * @generated
	 */
	EClass getNativeExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.NativeExpression#getNativeExpr <em>Native Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Native Expr</em>'.
	 * @see org.eclipse.epsilon.eol.dom.NativeExpression#getNativeExpr()
	 * @see #getNativeExpression()
	 * @generated
	 */
	EReference getNativeExpression_NativeExpr();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.eol.dom.NativeExpression#getIsType <em>Is Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Is Type</em>'.
	 * @see org.eclipse.epsilon.eol.dom.NativeExpression#getIsType()
	 * @see #getNativeExpression()
	 * @generated
	 */
	EReference getNativeExpression_IsType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.EType <em>EType</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EType</em>'.
	 * @see org.eclipse.epsilon.eol.dom.EType
	 * @generated
	 */
	EClass getEType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.epsilon.eol.dom.EType#getEcoreType <em>Ecore Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ecore Type</em>'.
	 * @see org.eclipse.epsilon.eol.dom.EType#getEcoreType()
	 * @see #getEType()
	 * @generated
	 */
	EReference getEType_EcoreType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.VoidType <em>Void Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Void Type</em>'.
	 * @see org.eclipse.epsilon.eol.dom.VoidType
	 * @generated
	 */
	EClass getVoidType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.PseudoType <em>Pseudo Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pseudo Type</em>'.
	 * @see org.eclipse.epsilon.eol.dom.PseudoType
	 * @generated
	 */
	EClass getPseudoType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.SelfType <em>Self Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Self Type</em>'.
	 * @see org.eclipse.epsilon.eol.dom.SelfType
	 * @generated
	 */
	EClass getSelfType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.eol.dom.SelfContentType <em>Self Content Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Self Content Type</em>'.
	 * @see org.eclipse.epsilon.eol.dom.SelfContentType
	 * @generated
	 */
	EClass getSelfContentType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EolFactory getEolFactory();

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
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.DomElementImpl <em>Dom Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.DomElementImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getDomElement()
		 * @generated
		 */
		EClass DOM_ELEMENT = eINSTANCE.getDomElement();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOM_ELEMENT__CONTAINER = eINSTANCE.getDomElement_Container();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOM_ELEMENT__LINE = eINSTANCE.getDomElement_Line();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOM_ELEMENT__COLUMN = eINSTANCE.getDomElement_Column();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOM_ELEMENT__URI = eINSTANCE.getDomElement_Uri();

		/**
		 * The meta object literal for the '<em><b>Region</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOM_ELEMENT__REGION = eINSTANCE.getDomElement_Region();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.TextRegionImpl <em>Text Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.TextRegionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getTextRegion()
		 * @generated
		 */
		EClass TEXT_REGION = eINSTANCE.getTextRegion();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXT_REGION__START = eINSTANCE.getTextRegion_Start();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXT_REGION__END = eINSTANCE.getTextRegion_End();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.TextPositionImpl <em>Text Position</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.TextPositionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getTextPosition()
		 * @generated
		 */
		EClass TEXT_POSITION = eINSTANCE.getTextPosition();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_POSITION__LINE = eINSTANCE.getTextPosition_Line();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_POSITION__COLUMN = eINSTANCE.getTextPosition_Column();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.ProgramImpl <em>Program</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.ProgramImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getProgram()
		 * @generated
		 */
		EClass PROGRAM = eINSTANCE.getProgram();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRAM__IMPORTS = eINSTANCE.getProgram_Imports();

		/**
		 * The meta object literal for the '<em><b>Imported Modules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRAM__IMPORTED_MODULES = eINSTANCE.getProgram_ImportedModules();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRAM__OPERATIONS = eINSTANCE.getProgram_Operations();

		/**
		 * The meta object literal for the '<em><b>Block</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRAM__BLOCK = eINSTANCE.getProgram_Block();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRAM__NAME = eINSTANCE.getProgram_Name();

		/**
		 * The meta object literal for the '<em><b>Model Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRAM__MODEL_DECLARATIONS = eINSTANCE.getProgram_ModelDeclarations();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.ImportImpl <em>Import</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.ImportImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getImport()
		 * @generated
		 */
		EClass IMPORT = eINSTANCE.getImport();

		/**
		 * The meta object literal for the '<em><b>Imported</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORT__IMPORTED = eINSTANCE.getImport_Imported();

		/**
		 * The meta object literal for the '<em><b>Imported Program</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORT__IMPORTED_PROGRAM = eINSTANCE.getImport_ImportedProgram();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.StatementImpl <em>Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.StatementImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getStatement()
		 * @generated
		 */
		EClass STATEMENT = eINSTANCE.getStatement();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.ExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '<em><b>Resolved Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION__RESOLVED_TYPE = eINSTANCE.getExpression_ResolvedType();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.BlockImpl <em>Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.BlockImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getBlock()
		 * @generated
		 */
		EClass BLOCK = eINSTANCE.getBlock();

		/**
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK__STATEMENTS = eINSTANCE.getBlock_Statements();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.OperatorExpressionImpl <em>Operator Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.OperatorExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getOperatorExpression()
		 * @generated
		 */
		EClass OPERATOR_EXPRESSION = eINSTANCE.getOperatorExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.BinaryOperatorExpressionImpl <em>Binary Operator Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.BinaryOperatorExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getBinaryOperatorExpression()
		 * @generated
		 */
		EClass BINARY_OPERATOR_EXPRESSION = eINSTANCE.getBinaryOperatorExpression();

		/**
		 * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_OPERATOR_EXPRESSION__LHS = eINSTANCE.getBinaryOperatorExpression_Lhs();

		/**
		 * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_OPERATOR_EXPRESSION__RHS = eINSTANCE.getBinaryOperatorExpression_Rhs();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.AndOperatorExpressionImpl <em>And Operator Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.AndOperatorExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getAndOperatorExpression()
		 * @generated
		 */
		EClass AND_OPERATOR_EXPRESSION = eINSTANCE.getAndOperatorExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.LiteralExpressionImpl <em>Literal Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.LiteralExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getLiteralExpression()
		 * @generated
		 */
		EClass LITERAL_EXPRESSION = eINSTANCE.getLiteralExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.BooleanExpressionImpl <em>Boolean Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.BooleanExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getBooleanExpression()
		 * @generated
		 */
		EClass BOOLEAN_EXPRESSION = eINSTANCE.getBooleanExpression();

		/**
		 * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_EXPRESSION__VAL = eINSTANCE.getBooleanExpression_Val();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.DivideOperatorExpressionImpl <em>Divide Operator Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.DivideOperatorExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getDivideOperatorExpression()
		 * @generated
		 */
		EClass DIVIDE_OPERATOR_EXPRESSION = eINSTANCE.getDivideOperatorExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.EnumerationLiteralExpressionImpl <em>Enumeration Literal Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.EnumerationLiteralExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getEnumerationLiteralExpression()
		 * @generated
		 */
		EClass ENUMERATION_LITERAL_EXPRESSION = eINSTANCE.getEnumerationLiteralExpression();

		/**
		 * The meta object literal for the '<em><b>Enumeration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION_LITERAL_EXPRESSION__ENUMERATION = eINSTANCE.getEnumerationLiteralExpression_Enumeration();

		/**
		 * The meta object literal for the '<em><b>Literal</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION_LITERAL_EXPRESSION__LITERAL = eINSTANCE.getEnumerationLiteralExpression_Literal();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION_LITERAL_EXPRESSION__MODEL = eINSTANCE.getEnumerationLiteralExpression_Model();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.EqualsOperatorExpressionImpl <em>Equals Operator Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.EqualsOperatorExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getEqualsOperatorExpression()
		 * @generated
		 */
		EClass EQUALS_OPERATOR_EXPRESSION = eINSTANCE.getEqualsOperatorExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.FeatureCallExpressionImpl <em>Feature Call Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.FeatureCallExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getFeatureCallExpression()
		 * @generated
		 */
		EClass FEATURE_CALL_EXPRESSION = eINSTANCE.getFeatureCallExpression();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_CALL_EXPRESSION__TARGET = eINSTANCE.getFeatureCallExpression_Target();

		/**
		 * The meta object literal for the '<em><b>Is Arrow</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_CALL_EXPRESSION__IS_ARROW = eINSTANCE.getFeatureCallExpression_IsArrow();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.GreaterThanOperatorExpressionImpl <em>Greater Than Operator Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.GreaterThanOperatorExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getGreaterThanOperatorExpression()
		 * @generated
		 */
		EClass GREATER_THAN_OPERATOR_EXPRESSION = eINSTANCE.getGreaterThanOperatorExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.GreaterThanOrEqualToOperatorExpressionImpl <em>Greater Than Or Equal To Operator Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.GreaterThanOrEqualToOperatorExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getGreaterThanOrEqualToOperatorExpression()
		 * @generated
		 */
		EClass GREATER_THAN_OR_EQUAL_TO_OPERATOR_EXPRESSION = eINSTANCE.getGreaterThanOrEqualToOperatorExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.ImpliesOperatorExpressionImpl <em>Implies Operator Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.ImpliesOperatorExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getImpliesOperatorExpression()
		 * @generated
		 */
		EClass IMPLIES_OPERATOR_EXPRESSION = eINSTANCE.getImpliesOperatorExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.IntegerExpressionImpl <em>Integer Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.IntegerExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getIntegerExpression()
		 * @generated
		 */
		EClass INTEGER_EXPRESSION = eINSTANCE.getIntegerExpression();

		/**
		 * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_EXPRESSION__VAL = eINSTANCE.getIntegerExpression_Val();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.LessThanOperatorExpressionImpl <em>Less Than Operator Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.LessThanOperatorExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getLessThanOperatorExpression()
		 * @generated
		 */
		EClass LESS_THAN_OPERATOR_EXPRESSION = eINSTANCE.getLessThanOperatorExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.LessThanOrEqualToOperatorExpressionImpl <em>Less Than Or Equal To Operator Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.LessThanOrEqualToOperatorExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getLessThanOrEqualToOperatorExpression()
		 * @generated
		 */
		EClass LESS_THAN_OR_EQUAL_TO_OPERATOR_EXPRESSION = eINSTANCE.getLessThanOrEqualToOperatorExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.MethodCallExpressionImpl <em>Method Call Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.MethodCallExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getMethodCallExpression()
		 * @generated
		 */
		EClass METHOD_CALL_EXPRESSION = eINSTANCE.getMethodCallExpression();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD_CALL_EXPRESSION__ARGUMENTS = eINSTANCE.getMethodCallExpression_Arguments();

		/**
		 * The meta object literal for the '<em><b>Method</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD_CALL_EXPRESSION__METHOD = eINSTANCE.getMethodCallExpression_Method();

		/**
		 * The meta object literal for the '<em><b>Resolved Methods</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD_CALL_EXPRESSION__RESOLVED_METHODS = eINSTANCE.getMethodCallExpression_ResolvedMethods();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.MinusOperatorExpressionImpl <em>Minus Operator Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.MinusOperatorExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getMinusOperatorExpression()
		 * @generated
		 */
		EClass MINUS_OPERATOR_EXPRESSION = eINSTANCE.getMinusOperatorExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.MultiplyOperatorExpressionImpl <em>Multiply Operator Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.MultiplyOperatorExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getMultiplyOperatorExpression()
		 * @generated
		 */
		EClass MULTIPLY_OPERATOR_EXPRESSION = eINSTANCE.getMultiplyOperatorExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.NameExpressionImpl <em>Name Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.NameExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getNameExpression()
		 * @generated
		 */
		EClass NAME_EXPRESSION = eINSTANCE.getNameExpression();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAME_EXPRESSION__NAME = eINSTANCE.getNameExpression_Name();

		/**
		 * The meta object literal for the '<em><b>Is Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAME_EXPRESSION__IS_TYPE = eINSTANCE.getNameExpression_IsType();

		/**
		 * The meta object literal for the '<em><b>Resolved Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAME_EXPRESSION__RESOLVED_CONTENT = eINSTANCE.getNameExpression_ResolvedContent();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.UnaryOperatorExpressionImpl <em>Unary Operator Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.UnaryOperatorExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getUnaryOperatorExpression()
		 * @generated
		 */
		EClass UNARY_OPERATOR_EXPRESSION = eINSTANCE.getUnaryOperatorExpression();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY_OPERATOR_EXPRESSION__EXPR = eINSTANCE.getUnaryOperatorExpression_Expr();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.NegativeOperatorExpressionImpl <em>Negative Operator Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.NegativeOperatorExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getNegativeOperatorExpression()
		 * @generated
		 */
		EClass NEGATIVE_OPERATOR_EXPRESSION = eINSTANCE.getNegativeOperatorExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.NotEqualsOperatorExpressionImpl <em>Not Equals Operator Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.NotEqualsOperatorExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getNotEqualsOperatorExpression()
		 * @generated
		 */
		EClass NOT_EQUALS_OPERATOR_EXPRESSION = eINSTANCE.getNotEqualsOperatorExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.NotOperatorExpressionImpl <em>Not Operator Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.NotOperatorExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getNotOperatorExpression()
		 * @generated
		 */
		EClass NOT_OPERATOR_EXPRESSION = eINSTANCE.getNotOperatorExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.OrOperatorExpressionImpl <em>Or Operator Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.OrOperatorExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getOrOperatorExpression()
		 * @generated
		 */
		EClass OR_OPERATOR_EXPRESSION = eINSTANCE.getOrOperatorExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.PlusOperatorExpressionImpl <em>Plus Operator Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.PlusOperatorExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getPlusOperatorExpression()
		 * @generated
		 */
		EClass PLUS_OPERATOR_EXPRESSION = eINSTANCE.getPlusOperatorExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.PropertyCallExpressionImpl <em>Property Call Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.PropertyCallExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getPropertyCallExpression()
		 * @generated
		 */
		EClass PROPERTY_CALL_EXPRESSION = eINSTANCE.getPropertyCallExpression();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_CALL_EXPRESSION__PROPERTY = eINSTANCE.getPropertyCallExpression_Property();

		/**
		 * The meta object literal for the '<em><b>Extended</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_CALL_EXPRESSION__EXTENDED = eINSTANCE.getPropertyCallExpression_Extended();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.RealExpressionImpl <em>Real Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.RealExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getRealExpression()
		 * @generated
		 */
		EClass REAL_EXPRESSION = eINSTANCE.getRealExpression();

		/**
		 * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_EXPRESSION__VAL = eINSTANCE.getRealExpression_Val();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.StringExpressionImpl <em>String Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.StringExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getStringExpression()
		 * @generated
		 */
		EClass STRING_EXPRESSION = eINSTANCE.getStringExpression();

		/**
		 * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_EXPRESSION__VAL = eINSTANCE.getStringExpression_Val();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.VariableDeclarationExpressionImpl <em>Variable Declaration Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.VariableDeclarationExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getVariableDeclarationExpression()
		 * @generated
		 */
		EClass VARIABLE_DECLARATION_EXPRESSION = eINSTANCE.getVariableDeclarationExpression();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DECLARATION_EXPRESSION__NAME = eINSTANCE.getVariableDeclarationExpression_Name();

		/**
		 * The meta object literal for the '<em><b>Create</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DECLARATION_EXPRESSION__CREATE = eINSTANCE.getVariableDeclarationExpression_Create();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DECLARATION_EXPRESSION__PARAMETERS = eINSTANCE.getVariableDeclarationExpression_Parameters();

		/**
		 * The meta object literal for the '<em><b>Last Definition Point</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_DECLARATION_EXPRESSION__LAST_DEFINITION_POINT = eINSTANCE.getVariableDeclarationExpression_LastDefinitionPoint();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.XorOperatorExpressionImpl <em>Xor Operator Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.XorOperatorExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getXorOperatorExpression()
		 * @generated
		 */
		EClass XOR_OPERATOR_EXPRESSION = eINSTANCE.getXorOperatorExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.OperationDefinitionImpl <em>Operation Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.OperationDefinitionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getOperationDefinition()
		 * @generated
		 */
		EClass OPERATION_DEFINITION = eINSTANCE.getOperationDefinition();

		/**
		 * The meta object literal for the '<em><b>Context Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_DEFINITION__CONTEXT_TYPE = eINSTANCE.getOperationDefinition_ContextType();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_DEFINITION__RETURN_TYPE = eINSTANCE.getOperationDefinition_ReturnType();

		/**
		 * The meta object literal for the '<em><b>Annotation Block</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_DEFINITION__ANNOTATION_BLOCK = eINSTANCE.getOperationDefinition_AnnotationBlock();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_DEFINITION__BODY = eINSTANCE.getOperationDefinition_Body();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_DEFINITION__NAME = eINSTANCE.getOperationDefinition_Name();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_DEFINITION__PARAMETERS = eINSTANCE.getOperationDefinition_Parameters();

		/**
		 * The meta object literal for the '<em><b>Self</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_DEFINITION__SELF = eINSTANCE.getOperationDefinition_Self();

		/**
		 * The meta object literal for the '<em><b>result</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_DEFINITION__RESULT = eINSTANCE.getOperationDefinition__result();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.AssignmentStatementImpl <em>Assignment Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.AssignmentStatementImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getAssignmentStatement()
		 * @generated
		 */
		EClass ASSIGNMENT_STATEMENT = eINSTANCE.getAssignmentStatement();

		/**
		 * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT_STATEMENT__LHS = eINSTANCE.getAssignmentStatement_Lhs();

		/**
		 * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT_STATEMENT__RHS = eINSTANCE.getAssignmentStatement_Rhs();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.BreakStatementImpl <em>Break Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.BreakStatementImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getBreakStatement()
		 * @generated
		 */
		EClass BREAK_STATEMENT = eINSTANCE.getBreakStatement();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.BreakAllStatementImpl <em>Break All Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.BreakAllStatementImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getBreakAllStatement()
		 * @generated
		 */
		EClass BREAK_ALL_STATEMENT = eINSTANCE.getBreakAllStatement();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.ContinueStatementImpl <em>Continue Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.ContinueStatementImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getContinueStatement()
		 * @generated
		 */
		EClass CONTINUE_STATEMENT = eINSTANCE.getContinueStatement();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.DeleteStatementImpl <em>Delete Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.DeleteStatementImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getDeleteStatement()
		 * @generated
		 */
		EClass DELETE_STATEMENT = eINSTANCE.getDeleteStatement();

		/**
		 * The meta object literal for the '<em><b>Deleted</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELETE_STATEMENT__DELETED = eINSTANCE.getDeleteStatement_Deleted();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.ForStatementImpl <em>For Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.ForStatementImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getForStatement()
		 * @generated
		 */
		EClass FOR_STATEMENT = eINSTANCE.getForStatement();

		/**
		 * The meta object literal for the '<em><b>Iterator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_STATEMENT__ITERATOR = eINSTANCE.getForStatement_Iterator();

		/**
		 * The meta object literal for the '<em><b>Iterated</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_STATEMENT__ITERATED = eINSTANCE.getForStatement_Iterated();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_STATEMENT__BODY = eINSTANCE.getForStatement_Body();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.IfStatementImpl <em>If Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.IfStatementImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getIfStatement()
		 * @generated
		 */
		EClass IF_STATEMENT = eINSTANCE.getIfStatement();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_STATEMENT__CONDITION = eINSTANCE.getIfStatement_Condition();

		/**
		 * The meta object literal for the '<em><b>If Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_STATEMENT__IF_BODY = eINSTANCE.getIfStatement_IfBody();

		/**
		 * The meta object literal for the '<em><b>Else Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_STATEMENT__ELSE_BODY = eINSTANCE.getIfStatement_ElseBody();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.ReturnStatementImpl <em>Return Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.ReturnStatementImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getReturnStatement()
		 * @generated
		 */
		EClass RETURN_STATEMENT = eINSTANCE.getReturnStatement();

		/**
		 * The meta object literal for the '<em><b>Returned</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RETURN_STATEMENT__RETURNED = eINSTANCE.getReturnStatement_Returned();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.SwitchStatementImpl <em>Switch Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.SwitchStatementImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getSwitchStatement()
		 * @generated
		 */
		EClass SWITCH_STATEMENT = eINSTANCE.getSwitchStatement();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_STATEMENT__EXPRESSION = eINSTANCE.getSwitchStatement_Expression();

		/**
		 * The meta object literal for the '<em><b>Cases</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_STATEMENT__CASES = eINSTANCE.getSwitchStatement_Cases();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_STATEMENT__DEFAULT = eINSTANCE.getSwitchStatement_Default();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.SwitchCaseStatementImpl <em>Switch Case Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.SwitchCaseStatementImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getSwitchCaseStatement()
		 * @generated
		 */
		EClass SWITCH_CASE_STATEMENT = eINSTANCE.getSwitchCaseStatement();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_CASE_STATEMENT__BODY = eINSTANCE.getSwitchCaseStatement_Body();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.WhileStatementImpl <em>While Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.WhileStatementImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getWhileStatement()
		 * @generated
		 */
		EClass WHILE_STATEMENT = eINSTANCE.getWhileStatement();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WHILE_STATEMENT__CONDITION = eINSTANCE.getWhileStatement_Condition();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WHILE_STATEMENT__BODY = eINSTANCE.getWhileStatement_Body();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.ModelDeclarationStatementImpl <em>Model Declaration Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.ModelDeclarationStatementImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getModelDeclarationStatement()
		 * @generated
		 */
		EClass MODEL_DECLARATION_STATEMENT = eINSTANCE.getModelDeclarationStatement();

		/**
		 * The meta object literal for the '<em><b>Packages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_DECLARATION_STATEMENT__PACKAGES = eINSTANCE.getModelDeclarationStatement_Packages();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_DECLARATION_STATEMENT__NAME = eINSTANCE.getModelDeclarationStatement_Name();

		/**
		 * The meta object literal for the '<em><b>Alias</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_DECLARATION_STATEMENT__ALIAS = eINSTANCE.getModelDeclarationStatement_Alias();

		/**
		 * The meta object literal for the '<em><b>Driver</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_DECLARATION_STATEMENT__DRIVER = eINSTANCE.getModelDeclarationStatement_Driver();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_DECLARATION_STATEMENT__PARAMETERS = eINSTANCE.getModelDeclarationStatement_Parameters();

		/**
		 * The meta object literal for the '<em><b>EReference0</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_DECLARATION_STATEMENT__EREFERENCE0 = eINSTANCE.getModelDeclarationStatement_EReference0();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.FOLMethodCallExpressionImpl <em>FOL Method Call Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.FOLMethodCallExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getFOLMethodCallExpression()
		 * @generated
		 */
		EClass FOL_METHOD_CALL_EXPRESSION = eINSTANCE.getFOLMethodCallExpression();

		/**
		 * The meta object literal for the '<em><b>Iterators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOL_METHOD_CALL_EXPRESSION__ITERATORS = eINSTANCE.getFOLMethodCallExpression_Iterators();

		/**
		 * The meta object literal for the '<em><b>Conditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOL_METHOD_CALL_EXPRESSION__CONDITIONS = eINSTANCE.getFOLMethodCallExpression_Conditions();

		/**
		 * The meta object literal for the '<em><b>Method</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOL_METHOD_CALL_EXPRESSION__METHOD = eINSTANCE.getFOLMethodCallExpression_Method();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.ExpressionStatementImpl <em>Expression Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.ExpressionStatementImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getExpressionStatement()
		 * @generated
		 */
		EClass EXPRESSION_STATEMENT = eINSTANCE.getExpressionStatement();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_STATEMENT__EXPRESSION = eINSTANCE.getExpressionStatement_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.SwitchCaseDefaultStatementImpl <em>Switch Case Default Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.SwitchCaseDefaultStatementImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getSwitchCaseDefaultStatement()
		 * @generated
		 */
		EClass SWITCH_CASE_DEFAULT_STATEMENT = eINSTANCE.getSwitchCaseDefaultStatement();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.SwitchCaseExpressionStatementImpl <em>Switch Case Expression Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.SwitchCaseExpressionStatementImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getSwitchCaseExpressionStatement()
		 * @generated
		 */
		EClass SWITCH_CASE_EXPRESSION_STATEMENT = eINSTANCE.getSwitchCaseExpressionStatement();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_CASE_EXPRESSION_STATEMENT__EXPRESSION = eINSTANCE.getSwitchCaseExpressionStatement_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.PrimitiveExpressionImpl <em>Primitive Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.PrimitiveExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getPrimitiveExpression()
		 * @generated
		 */
		EClass PRIMITIVE_EXPRESSION = eINSTANCE.getPrimitiveExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.CollectionExpressionImpl <em>Collection Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.CollectionExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getCollectionExpression()
		 * @generated
		 */
		EClass COLLECTION_EXPRESSION = eINSTANCE.getCollectionExpression();

		/**
		 * The meta object literal for the '<em><b>Parameter List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_EXPRESSION__PARAMETER_LIST = eINSTANCE.getCollectionExpression_ParameterList();

		/**
		 * The meta object literal for the '<em><b>Content Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_EXPRESSION__CONTENT_TYPE = eINSTANCE.getCollectionExpression_ContentType();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_EXPRESSION__CONTENTS = eINSTANCE.getCollectionExpression_Contents();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.SetExpressionImpl <em>Set Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.SetExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getSetExpression()
		 * @generated
		 */
		EClass SET_EXPRESSION = eINSTANCE.getSetExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.BagExpressionImpl <em>Bag Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.BagExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getBagExpression()
		 * @generated
		 */
		EClass BAG_EXPRESSION = eINSTANCE.getBagExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.SequenceExpressionImpl <em>Sequence Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.SequenceExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getSequenceExpression()
		 * @generated
		 */
		EClass SEQUENCE_EXPRESSION = eINSTANCE.getSequenceExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.OrderedSetExpressionImpl <em>Ordered Set Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.OrderedSetExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getOrderedSetExpression()
		 * @generated
		 */
		EClass ORDERED_SET_EXPRESSION = eINSTANCE.getOrderedSetExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.MapExpressionImpl <em>Map Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.MapExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getMapExpression()
		 * @generated
		 */
		EClass MAP_EXPRESSION = eINSTANCE.getMapExpression();

		/**
		 * The meta object literal for the '<em><b>Key Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAP_EXPRESSION__KEY_VALUES = eINSTANCE.getMapExpression_KeyValues();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.TypeImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.AnyTypeImpl <em>Any Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.AnyTypeImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getAnyType()
		 * @generated
		 */
		EClass ANY_TYPE = eINSTANCE.getAnyType();

		/**
		 * The meta object literal for the '<em><b>Temp Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANY_TYPE__TEMP_TYPE = eINSTANCE.getAnyType_TempType();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.CollectionTypeImpl <em>Collection Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.CollectionTypeImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getCollectionType()
		 * @generated
		 */
		EClass COLLECTION_TYPE = eINSTANCE.getCollectionType();

		/**
		 * The meta object literal for the '<em><b>Content Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_TYPE__CONTENT_TYPE = eINSTANCE.getCollectionType_ContentType();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.PrimitiveTypeImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getPrimitiveType()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.BooleanTypeImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getBooleanType()
		 * @generated
		 */
		EClass BOOLEAN_TYPE = eINSTANCE.getBooleanType();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.IntegerTypeImpl <em>Integer Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.IntegerTypeImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getIntegerType()
		 * @generated
		 */
		EClass INTEGER_TYPE = eINSTANCE.getIntegerType();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.RealTypeImpl <em>Real Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.RealTypeImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getRealType()
		 * @generated
		 */
		EClass REAL_TYPE = eINSTANCE.getRealType();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.StringTypeImpl <em>String Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.StringTypeImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getStringType()
		 * @generated
		 */
		EClass STRING_TYPE = eINSTANCE.getStringType();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.SetTypeImpl <em>Set Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.SetTypeImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getSetType()
		 * @generated
		 */
		EClass SET_TYPE = eINSTANCE.getSetType();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.BagTypeImpl <em>Bag Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.BagTypeImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getBagType()
		 * @generated
		 */
		EClass BAG_TYPE = eINSTANCE.getBagType();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.SequenceTypeImpl <em>Sequence Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.SequenceTypeImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getSequenceType()
		 * @generated
		 */
		EClass SEQUENCE_TYPE = eINSTANCE.getSequenceType();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.OrderedSetTypeImpl <em>Ordered Set Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.OrderedSetTypeImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getOrderedSetType()
		 * @generated
		 */
		EClass ORDERED_SET_TYPE = eINSTANCE.getOrderedSetType();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.MapTypeImpl <em>Map Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.MapTypeImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getMapType()
		 * @generated
		 */
		EClass MAP_TYPE = eINSTANCE.getMapType();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.AnnotationImpl <em>Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.AnnotationImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getAnnotation()
		 * @generated
		 */
		EClass ANNOTATION = eINSTANCE.getAnnotation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION__NAME = eINSTANCE.getAnnotation_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.ExecutableAnnotationImpl <em>Executable Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.ExecutableAnnotationImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getExecutableAnnotation()
		 * @generated
		 */
		EClass EXECUTABLE_ANNOTATION = eINSTANCE.getExecutableAnnotation();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTABLE_ANNOTATION__EXPRESSION = eINSTANCE.getExecutableAnnotation_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.SimpleAnnotationImpl <em>Simple Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.SimpleAnnotationImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getSimpleAnnotation()
		 * @generated
		 */
		EClass SIMPLE_ANNOTATION = eINSTANCE.getSimpleAnnotation();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_ANNOTATION__VALUES = eINSTANCE.getSimpleAnnotation_Values();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.KeyValueImpl <em>Key Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.KeyValueImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getKeyValue()
		 * @generated
		 */
		EClass KEY_VALUE = eINSTANCE.getKeyValue();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY_VALUE__KEY = eINSTANCE.getKeyValue_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY_VALUE__VALUE = eINSTANCE.getKeyValue_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.SpecialNameExpressionImpl <em>Special Name Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.SpecialNameExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getSpecialNameExpression()
		 * @generated
		 */
		EClass SPECIAL_NAME_EXPRESSION = eINSTANCE.getSpecialNameExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.ModelElementTypeImpl <em>Model Element Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.ModelElementTypeImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getModelElementType()
		 * @generated
		 */
		EClass MODEL_ELEMENT_TYPE = eINSTANCE.getModelElementType();

		/**
		 * The meta object literal for the '<em><b>Ecore Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT_TYPE__ECORE_TYPE = eINSTANCE.getModelElementType_EcoreType();

		/**
		 * The meta object literal for the '<em><b>Resolved Model Declaration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT_TYPE__RESOLVED_MODEL_DECLARATION = eINSTANCE.getModelElementType_ResolvedModelDeclaration();

		/**
		 * The meta object literal for the '<em><b>Model Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_ELEMENT_TYPE__MODEL_NAME = eINSTANCE.getModelElementType_ModelName();

		/**
		 * The meta object literal for the '<em><b>Element Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_ELEMENT_TYPE__ELEMENT_NAME = eINSTANCE.getModelElementType_ElementName();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.NativeTypeImpl <em>Native Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.NativeTypeImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getNativeType()
		 * @generated
		 */
		EClass NATIVE_TYPE = eINSTANCE.getNativeType();

		/**
		 * The meta object literal for the '<em><b>Native Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NATIVE_TYPE__NATIVE_EXPRESSION = eINSTANCE.getNativeType_NativeExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.ModelExpressionImpl <em>Model Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.ModelExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getModelExpression()
		 * @generated
		 */
		EClass MODEL_EXPRESSION = eINSTANCE.getModelExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.AnnotationBlockImpl <em>Annotation Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.AnnotationBlockImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getAnnotationBlock()
		 * @generated
		 */
		EClass ANNOTATION_BLOCK = eINSTANCE.getAnnotationBlock();

		/**
		 * The meta object literal for the '<em><b>Simple Annotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION_BLOCK__SIMPLE_ANNOTATIONS = eINSTANCE.getAnnotationBlock_SimpleAnnotations();

		/**
		 * The meta object literal for the '<em><b>Executable Annotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION_BLOCK__EXECUTABLE_ANNOTATIONS = eINSTANCE.getAnnotationBlock_ExecutableAnnotations();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.ModelDeclarationParameterImpl <em>Model Declaration Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.ModelDeclarationParameterImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getModelDeclarationParameter()
		 * @generated
		 */
		EClass MODEL_DECLARATION_PARAMETER = eINSTANCE.getModelDeclarationParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_DECLARATION_PARAMETER__NAME = eINSTANCE.getModelDeclarationParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_DECLARATION_PARAMETER__VALUE = eINSTANCE.getModelDeclarationParameter_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.ThrowStatementImpl <em>Throw Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.ThrowStatementImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getThrowStatement()
		 * @generated
		 */
		EClass THROW_STATEMENT = eINSTANCE.getThrowStatement();

		/**
		 * The meta object literal for the '<em><b>Thrown</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THROW_STATEMENT__THROWN = eINSTANCE.getThrowStatement_Thrown();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.AbortStatementImpl <em>Abort Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.AbortStatementImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getAbortStatement()
		 * @generated
		 */
		EClass ABORT_STATEMENT = eINSTANCE.getAbortStatement();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.TransactionStatementImpl <em>Transaction Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.TransactionStatementImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getTransactionStatement()
		 * @generated
		 */
		EClass TRANSACTION_STATEMENT = eINSTANCE.getTransactionStatement();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSACTION_STATEMENT__BODY = eINSTANCE.getTransactionStatement_Body();

		/**
		 * The meta object literal for the '<em><b>Names</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSACTION_STATEMENT__NAMES = eINSTANCE.getTransactionStatement_Names();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.FormalParameterExpressionImpl <em>Formal Parameter Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.FormalParameterExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getFormalParameterExpression()
		 * @generated
		 */
		EClass FORMAL_PARAMETER_EXPRESSION = eINSTANCE.getFormalParameterExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.CollectionInitValueImpl <em>Collection Init Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.CollectionInitValueImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getCollectionInitValue()
		 * @generated
		 */
		EClass COLLECTION_INIT_VALUE = eINSTANCE.getCollectionInitValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.ExprListImpl <em>Expr List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.ExprListImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getExprList()
		 * @generated
		 */
		EClass EXPR_LIST = eINSTANCE.getExprList();

		/**
		 * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPR_LIST__EXPRESSIONS = eINSTANCE.getExprList_Expressions();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.ExpRangeImpl <em>Exp Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.ExpRangeImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getExpRange()
		 * @generated
		 */
		EClass EXP_RANGE = eINSTANCE.getExpRange();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXP_RANGE__START = eINSTANCE.getExpRange_Start();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXP_RANGE__END = eINSTANCE.getExpRange_End();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.NewExpressionImpl <em>New Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.NewExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getNewExpression()
		 * @generated
		 */
		EClass NEW_EXPRESSION = eINSTANCE.getNewExpression();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_EXPRESSION__PARAMETERS = eINSTANCE.getNewExpression_Parameters();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.SpecialAssignmentStatementImpl <em>Special Assignment Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.SpecialAssignmentStatementImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getSpecialAssignmentStatement()
		 * @generated
		 */
		EClass SPECIAL_ASSIGNMENT_STATEMENT = eINSTANCE.getSpecialAssignmentStatement();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.ModelTypeImpl <em>Model Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.ModelTypeImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getModelType()
		 * @generated
		 */
		EClass MODEL_TYPE = eINSTANCE.getModelType();

		/**
		 * The meta object literal for the '<em><b>Model Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_TYPE__MODEL_NAME = eINSTANCE.getModelType_ModelName();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_TYPE__MODEL = eINSTANCE.getModelType_Model();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.NativeExpressionImpl <em>Native Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.NativeExpressionImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getNativeExpression()
		 * @generated
		 */
		EClass NATIVE_EXPRESSION = eINSTANCE.getNativeExpression();

		/**
		 * The meta object literal for the '<em><b>Native Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NATIVE_EXPRESSION__NATIVE_EXPR = eINSTANCE.getNativeExpression_NativeExpr();

		/**
		 * The meta object literal for the '<em><b>Is Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NATIVE_EXPRESSION__IS_TYPE = eINSTANCE.getNativeExpression_IsType();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.ETypeImpl <em>EType</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.ETypeImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getEType()
		 * @generated
		 */
		EClass ETYPE = eINSTANCE.getEType();

		/**
		 * The meta object literal for the '<em><b>Ecore Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ETYPE__ECORE_TYPE = eINSTANCE.getEType_EcoreType();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.VoidTypeImpl <em>Void Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.VoidTypeImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getVoidType()
		 * @generated
		 */
		EClass VOID_TYPE = eINSTANCE.getVoidType();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.PseudoTypeImpl <em>Pseudo Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.PseudoTypeImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getPseudoType()
		 * @generated
		 */
		EClass PSEUDO_TYPE = eINSTANCE.getPseudoType();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.SelfTypeImpl <em>Self Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.SelfTypeImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getSelfType()
		 * @generated
		 */
		EClass SELF_TYPE = eINSTANCE.getSelfType();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.eol.dom.impl.SelfContentTypeImpl <em>Self Content Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.eol.dom.impl.SelfContentTypeImpl
		 * @see org.eclipse.epsilon.eol.dom.impl.EolPackageImpl#getSelfContentType()
		 * @generated
		 */
		EClass SELF_CONTENT_TYPE = eINSTANCE.getSelfContentType();

	}

} //EolPackage
