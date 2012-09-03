/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.epsilon.eol.dom.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.epsilon.eol.dom.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DomFactoryImpl extends EFactoryImpl implements DomFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DomFactory init() {
		try {
			DomFactory theDomFactory = (DomFactory)EPackage.Registry.INSTANCE.getEFactory("http://dom/1.0"); 
			if (theDomFactory != null) {
				return theDomFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DomFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomFactoryImpl() {
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
			case DomPackage.PROGRAM: return createProgram();
			case DomPackage.IMPORT: return createImport();
			case DomPackage.BLOCK: return createBlock();
			case DomPackage.AND_OPERATOR_EXPRESSION: return createAndOperatorExpression();
			case DomPackage.BOOLEAN_EXPRESSION: return createBooleanExpression();
			case DomPackage.DIVIDE_OPERATOR_EXPRESSION: return createDivideOperatorExpression();
			case DomPackage.ENUMERATION_LITERAL_EXPRESSION: return createEnumerationLiteralExpression();
			case DomPackage.EQUALS_OPERATOR_EXPRESSION: return createEqualsOperatorExpression();
			case DomPackage.GREATER_THAN_OPERATOR_EXPRESSION: return createGreaterThanOperatorExpression();
			case DomPackage.GREATER_THAN_OR_EQUAL_TO_OPERATOR_EXPRESSION: return createGreaterThanOrEqualToOperatorExpression();
			case DomPackage.IMPLIES_OPERATOR_EXPRESSION: return createImpliesOperatorExpression();
			case DomPackage.INTEGER_EXPRESSION: return createIntegerExpression();
			case DomPackage.LESS_THAN_OPERATOR_EXPRESSION: return createLessThanOperatorExpression();
			case DomPackage.LESS_THAN_OR_EQUAL_TO_OPERATOR_EXPRESSION: return createLessThanOrEqualToOperatorExpression();
			case DomPackage.METHOD_CALL_EXPRESSION: return createMethodCallExpression();
			case DomPackage.MINUS_OPERATOR_EXPRESSION: return createMinusOperatorExpression();
			case DomPackage.MULTIPLY_OPERATOR_EXPRESSION: return createMultiplyOperatorExpression();
			case DomPackage.NAME_EXPRESSION: return createNameExpression();
			case DomPackage.NEGATIVE_OPERATOR_EXPRESSION: return createNegativeOperatorExpression();
			case DomPackage.NOT_EQUALS_OPERATOR_EXPRESSION: return createNotEqualsOperatorExpression();
			case DomPackage.NOT_OPERATOR_EXPRESSION: return createNotOperatorExpression();
			case DomPackage.OR_OPERATOR_EXPRESSION: return createOrOperatorExpression();
			case DomPackage.PLUS_OPERATOR_EXPRESSION: return createPlusOperatorExpression();
			case DomPackage.PROPERTY_CALL_EXPRESSION: return createPropertyCallExpression();
			case DomPackage.REAL_EXPRESSION: return createRealExpression();
			case DomPackage.STRING_EXPRESSION: return createStringExpression();
			case DomPackage.VARIABLE_DECLARATION_EXPRESSION: return createVariableDeclarationExpression();
			case DomPackage.XOR_OPERATOR_EXPRESSION: return createXorOperatorExpression();
			case DomPackage.OPERATION_DEFINITION: return createOperationDefinition();
			case DomPackage.ASSIGNMENT_STATEMENT: return createAssignmentStatement();
			case DomPackage.BREAK_STATEMENT: return createBreakStatement();
			case DomPackage.BREAK_ALL_STATEMENT: return createBreakAllStatement();
			case DomPackage.CONTINUE_STATEMENT: return createContinueStatement();
			case DomPackage.DELETE_STATEMENT: return createDeleteStatement();
			case DomPackage.FOR_STATEMENT: return createForStatement();
			case DomPackage.IF_STATEMENT: return createIfStatement();
			case DomPackage.RETURN_STATEMENT: return createReturnStatement();
			case DomPackage.SWITCH_STATEMENT: return createSwitchStatement();
			case DomPackage.WHILE_STATEMENT: return createWhileStatement();
			case DomPackage.MODEL_DECLARATION_EXPRESSION: return createModelDeclarationExpression();
			case DomPackage.FLO_METHOD_CALL_EXPRESSION: return createFLOMethodCallExpression();
			case DomPackage.EXPRESSION_STATEMENT: return createExpressionStatement();
			case DomPackage.SWITCH_CASE_DEFAULT_STATEMENT: return createSwitchCaseDefaultStatement();
			case DomPackage.SWITCH_CASE_EXPRESSION_STATEMENT: return createSwitchCaseExpressionStatement();
			case DomPackage.ANY_EXPRESSION: return createAnyExpression();
			case DomPackage.SET_EXPRESSION: return createSetExpression();
			case DomPackage.BAG_EXPRESSION: return createBagExpression();
			case DomPackage.SEQUENCE_EXPRESSION: return createSequenceExpression();
			case DomPackage.ORDERED_SET_EXPRESSION: return createOrderedSetExpression();
			case DomPackage.MAP_EXPRESSION: return createMapExpression();
			case DomPackage.NATIVE_EXPRESSION: return createNativeExpression();
			case DomPackage.ANY_TYPE: return createAnyType();
			case DomPackage.MODEL_ELEMENT_TYPE: return createModelElementType();
			case DomPackage.BOOLEAN_TYPE: return createBooleanType();
			case DomPackage.INTEGER_TYPE: return createIntegerType();
			case DomPackage.REAL_TYPE: return createRealType();
			case DomPackage.STRING_TYPE: return createStringType();
			case DomPackage.SET_TYPE: return createSetType();
			case DomPackage.BAG_TYPE: return createBagType();
			case DomPackage.SEQUENCE_TYPE: return createSequenceType();
			case DomPackage.ORDERED_SET_TYPE: return createOrderedSetType();
			case DomPackage.MAP_TYPE: return createMapType();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Program createProgram() {
		ProgramImpl program = new ProgramImpl();
		return program;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Import createImport() {
		ImportImpl import_ = new ImportImpl();
		return import_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Block createBlock() {
		BlockImpl block = new BlockImpl();
		return block;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AndOperatorExpression createAndOperatorExpression() {
		AndOperatorExpressionImpl andOperatorExpression = new AndOperatorExpressionImpl();
		return andOperatorExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanExpression createBooleanExpression() {
		BooleanExpressionImpl booleanExpression = new BooleanExpressionImpl();
		return booleanExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DivideOperatorExpression createDivideOperatorExpression() {
		DivideOperatorExpressionImpl divideOperatorExpression = new DivideOperatorExpressionImpl();
		return divideOperatorExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationLiteralExpression createEnumerationLiteralExpression() {
		EnumerationLiteralExpressionImpl enumerationLiteralExpression = new EnumerationLiteralExpressionImpl();
		return enumerationLiteralExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EqualsOperatorExpression createEqualsOperatorExpression() {
		EqualsOperatorExpressionImpl equalsOperatorExpression = new EqualsOperatorExpressionImpl();
		return equalsOperatorExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GreaterThanOperatorExpression createGreaterThanOperatorExpression() {
		GreaterThanOperatorExpressionImpl greaterThanOperatorExpression = new GreaterThanOperatorExpressionImpl();
		return greaterThanOperatorExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GreaterThanOrEqualToOperatorExpression createGreaterThanOrEqualToOperatorExpression() {
		GreaterThanOrEqualToOperatorExpressionImpl greaterThanOrEqualToOperatorExpression = new GreaterThanOrEqualToOperatorExpressionImpl();
		return greaterThanOrEqualToOperatorExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImpliesOperatorExpression createImpliesOperatorExpression() {
		ImpliesOperatorExpressionImpl impliesOperatorExpression = new ImpliesOperatorExpressionImpl();
		return impliesOperatorExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerExpression createIntegerExpression() {
		IntegerExpressionImpl integerExpression = new IntegerExpressionImpl();
		return integerExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LessThanOperatorExpression createLessThanOperatorExpression() {
		LessThanOperatorExpressionImpl lessThanOperatorExpression = new LessThanOperatorExpressionImpl();
		return lessThanOperatorExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LessThanOrEqualToOperatorExpression createLessThanOrEqualToOperatorExpression() {
		LessThanOrEqualToOperatorExpressionImpl lessThanOrEqualToOperatorExpression = new LessThanOrEqualToOperatorExpressionImpl();
		return lessThanOrEqualToOperatorExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MethodCallExpression createMethodCallExpression() {
		MethodCallExpressionImpl methodCallExpression = new MethodCallExpressionImpl();
		return methodCallExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MinusOperatorExpression createMinusOperatorExpression() {
		MinusOperatorExpressionImpl minusOperatorExpression = new MinusOperatorExpressionImpl();
		return minusOperatorExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplyOperatorExpression createMultiplyOperatorExpression() {
		MultiplyOperatorExpressionImpl multiplyOperatorExpression = new MultiplyOperatorExpressionImpl();
		return multiplyOperatorExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameExpression createNameExpression() {
		NameExpressionImpl nameExpression = new NameExpressionImpl();
		return nameExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NegativeOperatorExpression createNegativeOperatorExpression() {
		NegativeOperatorExpressionImpl negativeOperatorExpression = new NegativeOperatorExpressionImpl();
		return negativeOperatorExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotEqualsOperatorExpression createNotEqualsOperatorExpression() {
		NotEqualsOperatorExpressionImpl notEqualsOperatorExpression = new NotEqualsOperatorExpressionImpl();
		return notEqualsOperatorExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotOperatorExpression createNotOperatorExpression() {
		NotOperatorExpressionImpl notOperatorExpression = new NotOperatorExpressionImpl();
		return notOperatorExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrOperatorExpression createOrOperatorExpression() {
		OrOperatorExpressionImpl orOperatorExpression = new OrOperatorExpressionImpl();
		return orOperatorExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlusOperatorExpression createPlusOperatorExpression() {
		PlusOperatorExpressionImpl plusOperatorExpression = new PlusOperatorExpressionImpl();
		return plusOperatorExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyCallExpression createPropertyCallExpression() {
		PropertyCallExpressionImpl propertyCallExpression = new PropertyCallExpressionImpl();
		return propertyCallExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RealExpression createRealExpression() {
		RealExpressionImpl realExpression = new RealExpressionImpl();
		return realExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringExpression createStringExpression() {
		StringExpressionImpl stringExpression = new StringExpressionImpl();
		return stringExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclarationExpression createVariableDeclarationExpression() {
		VariableDeclarationExpressionImpl variableDeclarationExpression = new VariableDeclarationExpressionImpl();
		return variableDeclarationExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XorOperatorExpression createXorOperatorExpression() {
		XorOperatorExpressionImpl xorOperatorExpression = new XorOperatorExpressionImpl();
		return xorOperatorExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationDefinition createOperationDefinition() {
		OperationDefinitionImpl operationDefinition = new OperationDefinitionImpl();
		return operationDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssignmentStatement createAssignmentStatement() {
		AssignmentStatementImpl assignmentStatement = new AssignmentStatementImpl();
		return assignmentStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BreakStatement createBreakStatement() {
		BreakStatementImpl breakStatement = new BreakStatementImpl();
		return breakStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BreakAllStatement createBreakAllStatement() {
		BreakAllStatementImpl breakAllStatement = new BreakAllStatementImpl();
		return breakAllStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContinueStatement createContinueStatement() {
		ContinueStatementImpl continueStatement = new ContinueStatementImpl();
		return continueStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeleteStatement createDeleteStatement() {
		DeleteStatementImpl deleteStatement = new DeleteStatementImpl();
		return deleteStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForStatement createForStatement() {
		ForStatementImpl forStatement = new ForStatementImpl();
		return forStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfStatement createIfStatement() {
		IfStatementImpl ifStatement = new IfStatementImpl();
		return ifStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReturnStatement createReturnStatement() {
		ReturnStatementImpl returnStatement = new ReturnStatementImpl();
		return returnStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchStatement createSwitchStatement() {
		SwitchStatementImpl switchStatement = new SwitchStatementImpl();
		return switchStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WhileStatement createWhileStatement() {
		WhileStatementImpl whileStatement = new WhileStatementImpl();
		return whileStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelDeclarationExpression createModelDeclarationExpression() {
		ModelDeclarationExpressionImpl modelDeclarationExpression = new ModelDeclarationExpressionImpl();
		return modelDeclarationExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FLOMethodCallExpression createFLOMethodCallExpression() {
		FLOMethodCallExpressionImpl floMethodCallExpression = new FLOMethodCallExpressionImpl();
		return floMethodCallExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionStatement createExpressionStatement() {
		ExpressionStatementImpl expressionStatement = new ExpressionStatementImpl();
		return expressionStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchCaseDefaultStatement createSwitchCaseDefaultStatement() {
		SwitchCaseDefaultStatementImpl switchCaseDefaultStatement = new SwitchCaseDefaultStatementImpl();
		return switchCaseDefaultStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchCaseExpressionStatement createSwitchCaseExpressionStatement() {
		SwitchCaseExpressionStatementImpl switchCaseExpressionStatement = new SwitchCaseExpressionStatementImpl();
		return switchCaseExpressionStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnyExpression createAnyExpression() {
		AnyExpressionImpl anyExpression = new AnyExpressionImpl();
		return anyExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetExpression createSetExpression() {
		SetExpressionImpl setExpression = new SetExpressionImpl();
		return setExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BagExpression createBagExpression() {
		BagExpressionImpl bagExpression = new BagExpressionImpl();
		return bagExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceExpression createSequenceExpression() {
		SequenceExpressionImpl sequenceExpression = new SequenceExpressionImpl();
		return sequenceExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrderedSetExpression createOrderedSetExpression() {
		OrderedSetExpressionImpl orderedSetExpression = new OrderedSetExpressionImpl();
		return orderedSetExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MapExpression createMapExpression() {
		MapExpressionImpl mapExpression = new MapExpressionImpl();
		return mapExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NativeExpression createNativeExpression() {
		NativeExpressionImpl nativeExpression = new NativeExpressionImpl();
		return nativeExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnyType createAnyType() {
		AnyTypeImpl anyType = new AnyTypeImpl();
		return anyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementType createModelElementType() {
		ModelElementTypeImpl modelElementType = new ModelElementTypeImpl();
		return modelElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanType createBooleanType() {
		BooleanTypeImpl booleanType = new BooleanTypeImpl();
		return booleanType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerType createIntegerType() {
		IntegerTypeImpl integerType = new IntegerTypeImpl();
		return integerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RealType createRealType() {
		RealTypeImpl realType = new RealTypeImpl();
		return realType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringType createStringType() {
		StringTypeImpl stringType = new StringTypeImpl();
		return stringType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetType createSetType() {
		SetTypeImpl setType = new SetTypeImpl();
		return setType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BagType createBagType() {
		BagTypeImpl bagType = new BagTypeImpl();
		return bagType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceType createSequenceType() {
		SequenceTypeImpl sequenceType = new SequenceTypeImpl();
		return sequenceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrderedSetType createOrderedSetType() {
		OrderedSetTypeImpl orderedSetType = new OrderedSetTypeImpl();
		return orderedSetType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MapType createMapType() {
		MapTypeImpl mapType = new MapTypeImpl();
		return mapType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomPackage getDomPackage() {
		return (DomPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DomPackage getPackage() {
		return DomPackage.eINSTANCE;
	}

} //DomFactoryImpl
