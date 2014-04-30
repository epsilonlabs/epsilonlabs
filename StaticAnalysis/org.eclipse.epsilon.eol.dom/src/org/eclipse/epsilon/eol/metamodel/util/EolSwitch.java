/**
 */
package org.eclipse.epsilon.eol.metamodel.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.epsilon.eol.eol.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.epsilon.eol.eol.EolPackage
 * @generated
 */
public class EolSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EolPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EolSwitch() {
		if (modelPackage == null) {
			modelPackage = EolPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case EolPackage.EOL_ELEMENT: {
				EolElement eolElement = (EolElement)theEObject;
				T result = caseEolElement(eolElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.TEXT_REGION: {
				TextRegion textRegion = (TextRegion)theEObject;
				T result = caseTextRegion(textRegion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.TEXT_POSITION: {
				TextPosition textPosition = (TextPosition)theEObject;
				T result = caseTextPosition(textPosition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.PROGRAM: {
				Program program = (Program)theEObject;
				T result = caseProgram(program);
				if (result == null) result = caseEolElement(program);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.IMPORT: {
				Import import_ = (Import)theEObject;
				T result = caseImport(import_);
				if (result == null) result = caseEolElement(import_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.STATEMENT: {
				Statement statement = (Statement)theEObject;
				T result = caseStatement(statement);
				if (result == null) result = caseEolElement(statement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.EXPRESSION: {
				Expression expression = (Expression)theEObject;
				T result = caseExpression(expression);
				if (result == null) result = caseEolElement(expression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.BLOCK: {
				Block block = (Block)theEObject;
				T result = caseBlock(block);
				if (result == null) result = caseEolElement(block);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.OPERATOR_EXPRESSION: {
				OperatorExpression operatorExpression = (OperatorExpression)theEObject;
				T result = caseOperatorExpression(operatorExpression);
				if (result == null) result = caseExpression(operatorExpression);
				if (result == null) result = caseEolElement(operatorExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.BINARY_OPERATOR_EXPRESSION: {
				BinaryOperatorExpression binaryOperatorExpression = (BinaryOperatorExpression)theEObject;
				T result = caseBinaryOperatorExpression(binaryOperatorExpression);
				if (result == null) result = caseOperatorExpression(binaryOperatorExpression);
				if (result == null) result = caseExpression(binaryOperatorExpression);
				if (result == null) result = caseEolElement(binaryOperatorExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.AND_OPERATOR_EXPRESSION: {
				AndOperatorExpression andOperatorExpression = (AndOperatorExpression)theEObject;
				T result = caseAndOperatorExpression(andOperatorExpression);
				if (result == null) result = caseBinaryOperatorExpression(andOperatorExpression);
				if (result == null) result = caseOperatorExpression(andOperatorExpression);
				if (result == null) result = caseExpression(andOperatorExpression);
				if (result == null) result = caseEolElement(andOperatorExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.LITERAL_EXPRESSION: {
				LiteralExpression literalExpression = (LiteralExpression)theEObject;
				T result = caseLiteralExpression(literalExpression);
				if (result == null) result = caseExpression(literalExpression);
				if (result == null) result = caseEolElement(literalExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.BOOLEAN_EXPRESSION: {
				BooleanExpression booleanExpression = (BooleanExpression)theEObject;
				T result = caseBooleanExpression(booleanExpression);
				if (result == null) result = casePrimitiveExpression(booleanExpression);
				if (result == null) result = caseLiteralExpression(booleanExpression);
				if (result == null) result = caseExpression(booleanExpression);
				if (result == null) result = caseEolElement(booleanExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.DIVIDE_OPERATOR_EXPRESSION: {
				DivideOperatorExpression divideOperatorExpression = (DivideOperatorExpression)theEObject;
				T result = caseDivideOperatorExpression(divideOperatorExpression);
				if (result == null) result = caseBinaryOperatorExpression(divideOperatorExpression);
				if (result == null) result = caseOperatorExpression(divideOperatorExpression);
				if (result == null) result = caseExpression(divideOperatorExpression);
				if (result == null) result = caseEolElement(divideOperatorExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.ENUMERATION_LITERAL_EXPRESSION: {
				EnumerationLiteralExpression enumerationLiteralExpression = (EnumerationLiteralExpression)theEObject;
				T result = caseEnumerationLiteralExpression(enumerationLiteralExpression);
				if (result == null) result = caseExpression(enumerationLiteralExpression);
				if (result == null) result = caseEolElement(enumerationLiteralExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.EQUALS_OPERATOR_EXPRESSION: {
				EqualsOperatorExpression equalsOperatorExpression = (EqualsOperatorExpression)theEObject;
				T result = caseEqualsOperatorExpression(equalsOperatorExpression);
				if (result == null) result = caseBinaryOperatorExpression(equalsOperatorExpression);
				if (result == null) result = caseOperatorExpression(equalsOperatorExpression);
				if (result == null) result = caseExpression(equalsOperatorExpression);
				if (result == null) result = caseEolElement(equalsOperatorExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.FEATURE_CALL_EXPRESSION: {
				FeatureCallExpression featureCallExpression = (FeatureCallExpression)theEObject;
				T result = caseFeatureCallExpression(featureCallExpression);
				if (result == null) result = caseExpression(featureCallExpression);
				if (result == null) result = caseEolElement(featureCallExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.GREATER_THAN_OPERATOR_EXPRESSION: {
				GreaterThanOperatorExpression greaterThanOperatorExpression = (GreaterThanOperatorExpression)theEObject;
				T result = caseGreaterThanOperatorExpression(greaterThanOperatorExpression);
				if (result == null) result = caseBinaryOperatorExpression(greaterThanOperatorExpression);
				if (result == null) result = caseOperatorExpression(greaterThanOperatorExpression);
				if (result == null) result = caseExpression(greaterThanOperatorExpression);
				if (result == null) result = caseEolElement(greaterThanOperatorExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.GREATER_THAN_OR_EQUAL_TO_OPERATOR_EXPRESSION: {
				GreaterThanOrEqualToOperatorExpression greaterThanOrEqualToOperatorExpression = (GreaterThanOrEqualToOperatorExpression)theEObject;
				T result = caseGreaterThanOrEqualToOperatorExpression(greaterThanOrEqualToOperatorExpression);
				if (result == null) result = caseBinaryOperatorExpression(greaterThanOrEqualToOperatorExpression);
				if (result == null) result = caseOperatorExpression(greaterThanOrEqualToOperatorExpression);
				if (result == null) result = caseExpression(greaterThanOrEqualToOperatorExpression);
				if (result == null) result = caseEolElement(greaterThanOrEqualToOperatorExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.IMPLIES_OPERATOR_EXPRESSION: {
				ImpliesOperatorExpression impliesOperatorExpression = (ImpliesOperatorExpression)theEObject;
				T result = caseImpliesOperatorExpression(impliesOperatorExpression);
				if (result == null) result = caseBinaryOperatorExpression(impliesOperatorExpression);
				if (result == null) result = caseOperatorExpression(impliesOperatorExpression);
				if (result == null) result = caseExpression(impliesOperatorExpression);
				if (result == null) result = caseEolElement(impliesOperatorExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.INTEGER_EXPRESSION: {
				IntegerExpression integerExpression = (IntegerExpression)theEObject;
				T result = caseIntegerExpression(integerExpression);
				if (result == null) result = casePrimitiveExpression(integerExpression);
				if (result == null) result = caseLiteralExpression(integerExpression);
				if (result == null) result = caseExpression(integerExpression);
				if (result == null) result = caseEolElement(integerExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.LESS_THAN_OPERATOR_EXPRESSION: {
				LessThanOperatorExpression lessThanOperatorExpression = (LessThanOperatorExpression)theEObject;
				T result = caseLessThanOperatorExpression(lessThanOperatorExpression);
				if (result == null) result = caseBinaryOperatorExpression(lessThanOperatorExpression);
				if (result == null) result = caseOperatorExpression(lessThanOperatorExpression);
				if (result == null) result = caseExpression(lessThanOperatorExpression);
				if (result == null) result = caseEolElement(lessThanOperatorExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.LESS_THAN_OR_EQUAL_TO_OPERATOR_EXPRESSION: {
				LessThanOrEqualToOperatorExpression lessThanOrEqualToOperatorExpression = (LessThanOrEqualToOperatorExpression)theEObject;
				T result = caseLessThanOrEqualToOperatorExpression(lessThanOrEqualToOperatorExpression);
				if (result == null) result = caseBinaryOperatorExpression(lessThanOrEqualToOperatorExpression);
				if (result == null) result = caseOperatorExpression(lessThanOrEqualToOperatorExpression);
				if (result == null) result = caseExpression(lessThanOrEqualToOperatorExpression);
				if (result == null) result = caseEolElement(lessThanOrEqualToOperatorExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.METHOD_CALL_EXPRESSION: {
				MethodCallExpression methodCallExpression = (MethodCallExpression)theEObject;
				T result = caseMethodCallExpression(methodCallExpression);
				if (result == null) result = caseFeatureCallExpression(methodCallExpression);
				if (result == null) result = caseExpression(methodCallExpression);
				if (result == null) result = caseEolElement(methodCallExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.MINUS_OPERATOR_EXPRESSION: {
				MinusOperatorExpression minusOperatorExpression = (MinusOperatorExpression)theEObject;
				T result = caseMinusOperatorExpression(minusOperatorExpression);
				if (result == null) result = caseBinaryOperatorExpression(minusOperatorExpression);
				if (result == null) result = caseOperatorExpression(minusOperatorExpression);
				if (result == null) result = caseExpression(minusOperatorExpression);
				if (result == null) result = caseEolElement(minusOperatorExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.MULTIPLY_OPERATOR_EXPRESSION: {
				MultiplyOperatorExpression multiplyOperatorExpression = (MultiplyOperatorExpression)theEObject;
				T result = caseMultiplyOperatorExpression(multiplyOperatorExpression);
				if (result == null) result = caseBinaryOperatorExpression(multiplyOperatorExpression);
				if (result == null) result = caseOperatorExpression(multiplyOperatorExpression);
				if (result == null) result = caseExpression(multiplyOperatorExpression);
				if (result == null) result = caseEolElement(multiplyOperatorExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.NAME_EXPRESSION: {
				NameExpression nameExpression = (NameExpression)theEObject;
				T result = caseNameExpression(nameExpression);
				if (result == null) result = caseExpression(nameExpression);
				if (result == null) result = caseEolElement(nameExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.UNARY_OPERATOR_EXPRESSION: {
				UnaryOperatorExpression unaryOperatorExpression = (UnaryOperatorExpression)theEObject;
				T result = caseUnaryOperatorExpression(unaryOperatorExpression);
				if (result == null) result = caseOperatorExpression(unaryOperatorExpression);
				if (result == null) result = caseExpression(unaryOperatorExpression);
				if (result == null) result = caseEolElement(unaryOperatorExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.NEGATIVE_OPERATOR_EXPRESSION: {
				NegativeOperatorExpression negativeOperatorExpression = (NegativeOperatorExpression)theEObject;
				T result = caseNegativeOperatorExpression(negativeOperatorExpression);
				if (result == null) result = caseUnaryOperatorExpression(negativeOperatorExpression);
				if (result == null) result = caseOperatorExpression(negativeOperatorExpression);
				if (result == null) result = caseExpression(negativeOperatorExpression);
				if (result == null) result = caseEolElement(negativeOperatorExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.NOT_EQUALS_OPERATOR_EXPRESSION: {
				NotEqualsOperatorExpression notEqualsOperatorExpression = (NotEqualsOperatorExpression)theEObject;
				T result = caseNotEqualsOperatorExpression(notEqualsOperatorExpression);
				if (result == null) result = caseBinaryOperatorExpression(notEqualsOperatorExpression);
				if (result == null) result = caseOperatorExpression(notEqualsOperatorExpression);
				if (result == null) result = caseExpression(notEqualsOperatorExpression);
				if (result == null) result = caseEolElement(notEqualsOperatorExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.NOT_OPERATOR_EXPRESSION: {
				NotOperatorExpression notOperatorExpression = (NotOperatorExpression)theEObject;
				T result = caseNotOperatorExpression(notOperatorExpression);
				if (result == null) result = caseUnaryOperatorExpression(notOperatorExpression);
				if (result == null) result = caseOperatorExpression(notOperatorExpression);
				if (result == null) result = caseExpression(notOperatorExpression);
				if (result == null) result = caseEolElement(notOperatorExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.OR_OPERATOR_EXPRESSION: {
				OrOperatorExpression orOperatorExpression = (OrOperatorExpression)theEObject;
				T result = caseOrOperatorExpression(orOperatorExpression);
				if (result == null) result = caseBinaryOperatorExpression(orOperatorExpression);
				if (result == null) result = caseOperatorExpression(orOperatorExpression);
				if (result == null) result = caseExpression(orOperatorExpression);
				if (result == null) result = caseEolElement(orOperatorExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.PLUS_OPERATOR_EXPRESSION: {
				PlusOperatorExpression plusOperatorExpression = (PlusOperatorExpression)theEObject;
				T result = casePlusOperatorExpression(plusOperatorExpression);
				if (result == null) result = caseBinaryOperatorExpression(plusOperatorExpression);
				if (result == null) result = caseOperatorExpression(plusOperatorExpression);
				if (result == null) result = caseExpression(plusOperatorExpression);
				if (result == null) result = caseEolElement(plusOperatorExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.PROPERTY_CALL_EXPRESSION: {
				PropertyCallExpression propertyCallExpression = (PropertyCallExpression)theEObject;
				T result = casePropertyCallExpression(propertyCallExpression);
				if (result == null) result = caseFeatureCallExpression(propertyCallExpression);
				if (result == null) result = caseExpression(propertyCallExpression);
				if (result == null) result = caseEolElement(propertyCallExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.REAL_EXPRESSION: {
				RealExpression realExpression = (RealExpression)theEObject;
				T result = caseRealExpression(realExpression);
				if (result == null) result = casePrimitiveExpression(realExpression);
				if (result == null) result = caseLiteralExpression(realExpression);
				if (result == null) result = caseExpression(realExpression);
				if (result == null) result = caseEolElement(realExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.STRING_EXPRESSION: {
				StringExpression stringExpression = (StringExpression)theEObject;
				T result = caseStringExpression(stringExpression);
				if (result == null) result = casePrimitiveExpression(stringExpression);
				if (result == null) result = caseLiteralExpression(stringExpression);
				if (result == null) result = caseExpression(stringExpression);
				if (result == null) result = caseEolElement(stringExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.VARIABLE_DECLARATION_EXPRESSION: {
				VariableDeclarationExpression variableDeclarationExpression = (VariableDeclarationExpression)theEObject;
				T result = caseVariableDeclarationExpression(variableDeclarationExpression);
				if (result == null) result = caseExpression(variableDeclarationExpression);
				if (result == null) result = caseEolElement(variableDeclarationExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.XOR_OPERATOR_EXPRESSION: {
				XorOperatorExpression xorOperatorExpression = (XorOperatorExpression)theEObject;
				T result = caseXorOperatorExpression(xorOperatorExpression);
				if (result == null) result = caseBinaryOperatorExpression(xorOperatorExpression);
				if (result == null) result = caseOperatorExpression(xorOperatorExpression);
				if (result == null) result = caseExpression(xorOperatorExpression);
				if (result == null) result = caseEolElement(xorOperatorExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.OPERATION_DEFINITION: {
				OperationDefinition operationDefinition = (OperationDefinition)theEObject;
				T result = caseOperationDefinition(operationDefinition);
				if (result == null) result = caseEolElement(operationDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.ASSIGNMENT_STATEMENT: {
				AssignmentStatement assignmentStatement = (AssignmentStatement)theEObject;
				T result = caseAssignmentStatement(assignmentStatement);
				if (result == null) result = caseStatement(assignmentStatement);
				if (result == null) result = caseEolElement(assignmentStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.BREAK_STATEMENT: {
				BreakStatement breakStatement = (BreakStatement)theEObject;
				T result = caseBreakStatement(breakStatement);
				if (result == null) result = caseStatement(breakStatement);
				if (result == null) result = caseEolElement(breakStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.BREAK_ALL_STATEMENT: {
				BreakAllStatement breakAllStatement = (BreakAllStatement)theEObject;
				T result = caseBreakAllStatement(breakAllStatement);
				if (result == null) result = caseStatement(breakAllStatement);
				if (result == null) result = caseEolElement(breakAllStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.CONTINUE_STATEMENT: {
				ContinueStatement continueStatement = (ContinueStatement)theEObject;
				T result = caseContinueStatement(continueStatement);
				if (result == null) result = caseStatement(continueStatement);
				if (result == null) result = caseEolElement(continueStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.DELETE_STATEMENT: {
				DeleteStatement deleteStatement = (DeleteStatement)theEObject;
				T result = caseDeleteStatement(deleteStatement);
				if (result == null) result = caseStatement(deleteStatement);
				if (result == null) result = caseEolElement(deleteStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.FOR_STATEMENT: {
				ForStatement forStatement = (ForStatement)theEObject;
				T result = caseForStatement(forStatement);
				if (result == null) result = caseStatement(forStatement);
				if (result == null) result = caseEolElement(forStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.IF_STATEMENT: {
				IfStatement ifStatement = (IfStatement)theEObject;
				T result = caseIfStatement(ifStatement);
				if (result == null) result = caseStatement(ifStatement);
				if (result == null) result = caseEolElement(ifStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.RETURN_STATEMENT: {
				ReturnStatement returnStatement = (ReturnStatement)theEObject;
				T result = caseReturnStatement(returnStatement);
				if (result == null) result = caseStatement(returnStatement);
				if (result == null) result = caseEolElement(returnStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.SWITCH_STATEMENT: {
				SwitchStatement switchStatement = (SwitchStatement)theEObject;
				T result = caseSwitchStatement(switchStatement);
				if (result == null) result = caseStatement(switchStatement);
				if (result == null) result = caseEolElement(switchStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.SWITCH_CASE_STATEMENT: {
				SwitchCaseStatement switchCaseStatement = (SwitchCaseStatement)theEObject;
				T result = caseSwitchCaseStatement(switchCaseStatement);
				if (result == null) result = caseStatement(switchCaseStatement);
				if (result == null) result = caseEolElement(switchCaseStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.WHILE_STATEMENT: {
				WhileStatement whileStatement = (WhileStatement)theEObject;
				T result = caseWhileStatement(whileStatement);
				if (result == null) result = caseStatement(whileStatement);
				if (result == null) result = caseEolElement(whileStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.MODEL_DECLARATION_STATEMENT: {
				ModelDeclarationStatement modelDeclarationStatement = (ModelDeclarationStatement)theEObject;
				T result = caseModelDeclarationStatement(modelDeclarationStatement);
				if (result == null) result = caseStatement(modelDeclarationStatement);
				if (result == null) result = caseEolElement(modelDeclarationStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.FOL_METHOD_CALL_EXPRESSION: {
				FOLMethodCallExpression folMethodCallExpression = (FOLMethodCallExpression)theEObject;
				T result = caseFOLMethodCallExpression(folMethodCallExpression);
				if (result == null) result = caseFeatureCallExpression(folMethodCallExpression);
				if (result == null) result = caseExpression(folMethodCallExpression);
				if (result == null) result = caseEolElement(folMethodCallExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.EXPRESSION_STATEMENT: {
				ExpressionStatement expressionStatement = (ExpressionStatement)theEObject;
				T result = caseExpressionStatement(expressionStatement);
				if (result == null) result = caseStatement(expressionStatement);
				if (result == null) result = caseEolElement(expressionStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.SWITCH_CASE_DEFAULT_STATEMENT: {
				SwitchCaseDefaultStatement switchCaseDefaultStatement = (SwitchCaseDefaultStatement)theEObject;
				T result = caseSwitchCaseDefaultStatement(switchCaseDefaultStatement);
				if (result == null) result = caseSwitchCaseStatement(switchCaseDefaultStatement);
				if (result == null) result = caseStatement(switchCaseDefaultStatement);
				if (result == null) result = caseEolElement(switchCaseDefaultStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.SWITCH_CASE_EXPRESSION_STATEMENT: {
				SwitchCaseExpressionStatement switchCaseExpressionStatement = (SwitchCaseExpressionStatement)theEObject;
				T result = caseSwitchCaseExpressionStatement(switchCaseExpressionStatement);
				if (result == null) result = caseSwitchCaseStatement(switchCaseExpressionStatement);
				if (result == null) result = caseStatement(switchCaseExpressionStatement);
				if (result == null) result = caseEolElement(switchCaseExpressionStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.PRIMITIVE_EXPRESSION: {
				PrimitiveExpression primitiveExpression = (PrimitiveExpression)theEObject;
				T result = casePrimitiveExpression(primitiveExpression);
				if (result == null) result = caseLiteralExpression(primitiveExpression);
				if (result == null) result = caseExpression(primitiveExpression);
				if (result == null) result = caseEolElement(primitiveExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.COLLECTION_EXPRESSION: {
				CollectionExpression collectionExpression = (CollectionExpression)theEObject;
				T result = caseCollectionExpression(collectionExpression);
				if (result == null) result = caseLiteralExpression(collectionExpression);
				if (result == null) result = caseExpression(collectionExpression);
				if (result == null) result = caseEolElement(collectionExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.SET_EXPRESSION: {
				SetExpression setExpression = (SetExpression)theEObject;
				T result = caseSetExpression(setExpression);
				if (result == null) result = caseCollectionExpression(setExpression);
				if (result == null) result = caseLiteralExpression(setExpression);
				if (result == null) result = caseExpression(setExpression);
				if (result == null) result = caseEolElement(setExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.BAG_EXPRESSION: {
				BagExpression bagExpression = (BagExpression)theEObject;
				T result = caseBagExpression(bagExpression);
				if (result == null) result = caseCollectionExpression(bagExpression);
				if (result == null) result = caseLiteralExpression(bagExpression);
				if (result == null) result = caseExpression(bagExpression);
				if (result == null) result = caseEolElement(bagExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.SEQUENCE_EXPRESSION: {
				SequenceExpression sequenceExpression = (SequenceExpression)theEObject;
				T result = caseSequenceExpression(sequenceExpression);
				if (result == null) result = caseCollectionExpression(sequenceExpression);
				if (result == null) result = caseLiteralExpression(sequenceExpression);
				if (result == null) result = caseExpression(sequenceExpression);
				if (result == null) result = caseEolElement(sequenceExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.ORDERED_SET_EXPRESSION: {
				OrderedSetExpression orderedSetExpression = (OrderedSetExpression)theEObject;
				T result = caseOrderedSetExpression(orderedSetExpression);
				if (result == null) result = caseCollectionExpression(orderedSetExpression);
				if (result == null) result = caseLiteralExpression(orderedSetExpression);
				if (result == null) result = caseExpression(orderedSetExpression);
				if (result == null) result = caseEolElement(orderedSetExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.MAP_EXPRESSION: {
				MapExpression mapExpression = (MapExpression)theEObject;
				T result = caseMapExpression(mapExpression);
				if (result == null) result = caseLiteralExpression(mapExpression);
				if (result == null) result = caseExpression(mapExpression);
				if (result == null) result = caseEolElement(mapExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.TYPE: {
				Type type = (Type)theEObject;
				T result = caseType(type);
				if (result == null) result = caseEolElement(type);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.ANY_TYPE: {
				AnyType anyType = (AnyType)theEObject;
				T result = caseAnyType(anyType);
				if (result == null) result = caseType(anyType);
				if (result == null) result = caseEolElement(anyType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.COLLECTION_TYPE: {
				CollectionType collectionType = (CollectionType)theEObject;
				T result = caseCollectionType(collectionType);
				if (result == null) result = caseType(collectionType);
				if (result == null) result = caseEolElement(collectionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.PRIMITIVE_TYPE: {
				PrimitiveType primitiveType = (PrimitiveType)theEObject;
				T result = casePrimitiveType(primitiveType);
				if (result == null) result = caseType(primitiveType);
				if (result == null) result = caseEolElement(primitiveType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.BOOLEAN_TYPE: {
				BooleanType booleanType = (BooleanType)theEObject;
				T result = caseBooleanType(booleanType);
				if (result == null) result = casePrimitiveType(booleanType);
				if (result == null) result = caseType(booleanType);
				if (result == null) result = caseEolElement(booleanType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.INTEGER_TYPE: {
				IntegerType integerType = (IntegerType)theEObject;
				T result = caseIntegerType(integerType);
				if (result == null) result = casePrimitiveType(integerType);
				if (result == null) result = caseType(integerType);
				if (result == null) result = caseEolElement(integerType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.REAL_TYPE: {
				RealType realType = (RealType)theEObject;
				T result = caseRealType(realType);
				if (result == null) result = casePrimitiveType(realType);
				if (result == null) result = caseType(realType);
				if (result == null) result = caseEolElement(realType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.STRING_TYPE: {
				StringType stringType = (StringType)theEObject;
				T result = caseStringType(stringType);
				if (result == null) result = casePrimitiveType(stringType);
				if (result == null) result = caseType(stringType);
				if (result == null) result = caseEolElement(stringType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.SET_TYPE: {
				SetType setType = (SetType)theEObject;
				T result = caseSetType(setType);
				if (result == null) result = caseUniqueCollectionType(setType);
				if (result == null) result = caseCollectionType(setType);
				if (result == null) result = caseType(setType);
				if (result == null) result = caseEolElement(setType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.BAG_TYPE: {
				BagType bagType = (BagType)theEObject;
				T result = caseBagType(bagType);
				if (result == null) result = caseCollectionType(bagType);
				if (result == null) result = caseType(bagType);
				if (result == null) result = caseEolElement(bagType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.SEQUENCE_TYPE: {
				SequenceType sequenceType = (SequenceType)theEObject;
				T result = caseSequenceType(sequenceType);
				if (result == null) result = caseOrderedCollectionType(sequenceType);
				if (result == null) result = caseCollectionType(sequenceType);
				if (result == null) result = caseType(sequenceType);
				if (result == null) result = caseEolElement(sequenceType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.ORDERED_SET_TYPE: {
				OrderedSetType orderedSetType = (OrderedSetType)theEObject;
				T result = caseOrderedSetType(orderedSetType);
				if (result == null) result = caseOrderedCollectionType(orderedSetType);
				if (result == null) result = caseUniqueCollectionType(orderedSetType);
				if (result == null) result = caseCollectionType(orderedSetType);
				if (result == null) result = caseType(orderedSetType);
				if (result == null) result = caseEolElement(orderedSetType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.MAP_TYPE: {
				MapType mapType = (MapType)theEObject;
				T result = caseMapType(mapType);
				if (result == null) result = caseType(mapType);
				if (result == null) result = caseEolElement(mapType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.ANNOTATION: {
				Annotation annotation = (Annotation)theEObject;
				T result = caseAnnotation(annotation);
				if (result == null) result = caseEolElement(annotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.EXECUTABLE_ANNOTATION: {
				ExecutableAnnotation executableAnnotation = (ExecutableAnnotation)theEObject;
				T result = caseExecutableAnnotation(executableAnnotation);
				if (result == null) result = caseAnnotation(executableAnnotation);
				if (result == null) result = caseEolElement(executableAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.SIMPLE_ANNOTATION: {
				SimpleAnnotation simpleAnnotation = (SimpleAnnotation)theEObject;
				T result = caseSimpleAnnotation(simpleAnnotation);
				if (result == null) result = caseAnnotation(simpleAnnotation);
				if (result == null) result = caseEolElement(simpleAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.KEY_VALUE: {
				KeyValue keyValue = (KeyValue)theEObject;
				T result = caseKeyValue(keyValue);
				if (result == null) result = caseEolElement(keyValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.SPECIAL_NAME_EXPRESSION: {
				SpecialNameExpression specialNameExpression = (SpecialNameExpression)theEObject;
				T result = caseSpecialNameExpression(specialNameExpression);
				if (result == null) result = caseNameExpression(specialNameExpression);
				if (result == null) result = caseExpression(specialNameExpression);
				if (result == null) result = caseEolElement(specialNameExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.MODEL_ELEMENT_TYPE: {
				ModelElementType modelElementType = (ModelElementType)theEObject;
				T result = caseModelElementType(modelElementType);
				if (result == null) result = caseType(modelElementType);
				if (result == null) result = caseEolElement(modelElementType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.NATIVE_TYPE: {
				NativeType nativeType = (NativeType)theEObject;
				T result = caseNativeType(nativeType);
				if (result == null) result = caseType(nativeType);
				if (result == null) result = caseEolElement(nativeType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.MODEL_EXPRESSION: {
				ModelExpression modelExpression = (ModelExpression)theEObject;
				T result = caseModelExpression(modelExpression);
				if (result == null) result = caseNameExpression(modelExpression);
				if (result == null) result = caseExpression(modelExpression);
				if (result == null) result = caseEolElement(modelExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.ANNOTATION_BLOCK: {
				AnnotationBlock annotationBlock = (AnnotationBlock)theEObject;
				T result = caseAnnotationBlock(annotationBlock);
				if (result == null) result = caseEolElement(annotationBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.MODEL_DECLARATION_PARAMETER: {
				ModelDeclarationParameter modelDeclarationParameter = (ModelDeclarationParameter)theEObject;
				T result = caseModelDeclarationParameter(modelDeclarationParameter);
				if (result == null) result = caseEolElement(modelDeclarationParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.THROW_STATEMENT: {
				ThrowStatement throwStatement = (ThrowStatement)theEObject;
				T result = caseThrowStatement(throwStatement);
				if (result == null) result = caseStatement(throwStatement);
				if (result == null) result = caseEolElement(throwStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.ABORT_STATEMENT: {
				AbortStatement abortStatement = (AbortStatement)theEObject;
				T result = caseAbortStatement(abortStatement);
				if (result == null) result = caseStatement(abortStatement);
				if (result == null) result = caseEolElement(abortStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.TRANSACTION_STATEMENT: {
				TransactionStatement transactionStatement = (TransactionStatement)theEObject;
				T result = caseTransactionStatement(transactionStatement);
				if (result == null) result = caseStatement(transactionStatement);
				if (result == null) result = caseEolElement(transactionStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.FORMAL_PARAMETER_EXPRESSION: {
				FormalParameterExpression formalParameterExpression = (FormalParameterExpression)theEObject;
				T result = caseFormalParameterExpression(formalParameterExpression);
				if (result == null) result = caseVariableDeclarationExpression(formalParameterExpression);
				if (result == null) result = caseExpression(formalParameterExpression);
				if (result == null) result = caseEolElement(formalParameterExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.COLLECTION_INIT_VALUE: {
				CollectionInitValue collectionInitValue = (CollectionInitValue)theEObject;
				T result = caseCollectionInitValue(collectionInitValue);
				if (result == null) result = caseEolElement(collectionInitValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.EXPR_LIST: {
				ExprList exprList = (ExprList)theEObject;
				T result = caseExprList(exprList);
				if (result == null) result = caseCollectionInitValue(exprList);
				if (result == null) result = caseEolElement(exprList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.EXP_RANGE: {
				ExpRange expRange = (ExpRange)theEObject;
				T result = caseExpRange(expRange);
				if (result == null) result = caseCollectionInitValue(expRange);
				if (result == null) result = caseEolElement(expRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.NEW_EXPRESSION: {
				NewExpression newExpression = (NewExpression)theEObject;
				T result = caseNewExpression(newExpression);
				if (result == null) result = caseExpression(newExpression);
				if (result == null) result = caseEolElement(newExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.SPECIAL_ASSIGNMENT_STATEMENT: {
				SpecialAssignmentStatement specialAssignmentStatement = (SpecialAssignmentStatement)theEObject;
				T result = caseSpecialAssignmentStatement(specialAssignmentStatement);
				if (result == null) result = caseAssignmentStatement(specialAssignmentStatement);
				if (result == null) result = caseStatement(specialAssignmentStatement);
				if (result == null) result = caseEolElement(specialAssignmentStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.MODEL_TYPE: {
				ModelType modelType = (ModelType)theEObject;
				T result = caseModelType(modelType);
				if (result == null) result = caseType(modelType);
				if (result == null) result = caseEolElement(modelType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.NATIVE_EXPRESSION: {
				NativeExpression nativeExpression = (NativeExpression)theEObject;
				T result = caseNativeExpression(nativeExpression);
				if (result == null) result = caseLiteralExpression(nativeExpression);
				if (result == null) result = caseExpression(nativeExpression);
				if (result == null) result = caseEolElement(nativeExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.ETYPE: {
				EType eType = (EType)theEObject;
				T result = caseEType(eType);
				if (result == null) result = caseType(eType);
				if (result == null) result = caseEolElement(eType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.VOID_TYPE: {
				VoidType voidType = (VoidType)theEObject;
				T result = caseVoidType(voidType);
				if (result == null) result = caseType(voidType);
				if (result == null) result = caseEolElement(voidType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.PSEUDO_TYPE: {
				PseudoType pseudoType = (PseudoType)theEObject;
				T result = casePseudoType(pseudoType);
				if (result == null) result = caseType(pseudoType);
				if (result == null) result = caseEolElement(pseudoType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.SELF_TYPE: {
				SelfType selfType = (SelfType)theEObject;
				T result = caseSelfType(selfType);
				if (result == null) result = casePseudoType(selfType);
				if (result == null) result = caseType(selfType);
				if (result == null) result = caseEolElement(selfType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.SELF_CONTENT_TYPE: {
				SelfContentType selfContentType = (SelfContentType)theEObject;
				T result = caseSelfContentType(selfContentType);
				if (result == null) result = casePseudoType(selfContentType);
				if (result == null) result = caseType(selfContentType);
				if (result == null) result = caseEolElement(selfContentType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.ORDERED_COLLECTION_TYPE: {
				OrderedCollectionType orderedCollectionType = (OrderedCollectionType)theEObject;
				T result = caseOrderedCollectionType(orderedCollectionType);
				if (result == null) result = caseCollectionType(orderedCollectionType);
				if (result == null) result = caseType(orderedCollectionType);
				if (result == null) result = caseEolElement(orderedCollectionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.UNIQUE_COLLECTION_TYPE: {
				UniqueCollectionType uniqueCollectionType = (UniqueCollectionType)theEObject;
				T result = caseUniqueCollectionType(uniqueCollectionType);
				if (result == null) result = caseCollectionType(uniqueCollectionType);
				if (result == null) result = caseType(uniqueCollectionType);
				if (result == null) result = caseEolElement(uniqueCollectionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.SELF_INNERMOST_TYPE: {
				SelfInnermostType selfInnermostType = (SelfInnermostType)theEObject;
				T result = caseSelfInnermostType(selfInnermostType);
				if (result == null) result = casePseudoType(selfInnermostType);
				if (result == null) result = caseType(selfInnermostType);
				if (result == null) result = caseEolElement(selfInnermostType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EolPackage.OPERATION_ARG_TYPE: {
				OperationArgType operationArgType = (OperationArgType)theEObject;
				T result = caseOperationArgType(operationArgType);
				if (result == null) result = casePseudoType(operationArgType);
				if (result == null) result = caseType(operationArgType);
				if (result == null) result = caseEolElement(operationArgType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEolElement(EolElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text Region</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text Region</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTextRegion(TextRegion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text Position</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text Position</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTextPosition(TextPosition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Program</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Program</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProgram(Program object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Import</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Import</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImport(Import object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatement(Statement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpression(Expression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlock(Block object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operator Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operator Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperatorExpression(OperatorExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Operator Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Operator Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryOperatorExpression(BinaryOperatorExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And Operator Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And Operator Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAndOperatorExpression(AndOperatorExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralExpression(LiteralExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanExpression(BooleanExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Divide Operator Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Divide Operator Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDivideOperatorExpression(DivideOperatorExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration Literal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration Literal Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerationLiteralExpression(EnumerationLiteralExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equals Operator Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equals Operator Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEqualsOperatorExpression(EqualsOperatorExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Call Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Call Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureCallExpression(FeatureCallExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Greater Than Operator Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Greater Than Operator Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGreaterThanOperatorExpression(GreaterThanOperatorExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Greater Than Or Equal To Operator Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Greater Than Or Equal To Operator Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGreaterThanOrEqualToOperatorExpression(GreaterThanOrEqualToOperatorExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Implies Operator Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Implies Operator Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImpliesOperatorExpression(ImpliesOperatorExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerExpression(IntegerExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Less Than Operator Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Less Than Operator Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLessThanOperatorExpression(LessThanOperatorExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Less Than Or Equal To Operator Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Less Than Or Equal To Operator Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLessThanOrEqualToOperatorExpression(LessThanOrEqualToOperatorExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Call Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Call Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMethodCallExpression(MethodCallExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Minus Operator Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Minus Operator Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMinusOperatorExpression(MinusOperatorExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multiply Operator Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multiply Operator Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiplyOperatorExpression(MultiplyOperatorExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Name Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Name Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNameExpression(NameExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Operator Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Operator Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryOperatorExpression(UnaryOperatorExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Negative Operator Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Negative Operator Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNegativeOperatorExpression(NegativeOperatorExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not Equals Operator Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not Equals Operator Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNotEqualsOperatorExpression(NotEqualsOperatorExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not Operator Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not Operator Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNotOperatorExpression(NotOperatorExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or Operator Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or Operator Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrOperatorExpression(OrOperatorExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Plus Operator Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Plus Operator Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlusOperatorExpression(PlusOperatorExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Call Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Call Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyCallExpression(PropertyCallExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Real Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Real Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRealExpression(RealExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringExpression(StringExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Declaration Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Declaration Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableDeclarationExpression(VariableDeclarationExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xor Operator Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xor Operator Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXorOperatorExpression(XorOperatorExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationDefinition(OperationDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assignment Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assignment Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssignmentStatement(AssignmentStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Break Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Break Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBreakStatement(BreakStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Break All Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Break All Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBreakAllStatement(BreakAllStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Continue Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Continue Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContinueStatement(ContinueStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delete Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delete Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeleteStatement(DeleteStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>For Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForStatement(ForStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfStatement(IfStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Return Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Return Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReturnStatement(ReturnStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchStatement(SwitchStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Case Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Case Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchCaseStatement(SwitchCaseStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>While Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>While Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWhileStatement(WhileStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Declaration Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Declaration Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelDeclarationStatement(ModelDeclarationStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FOL Method Call Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FOL Method Call Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFOLMethodCallExpression(FOLMethodCallExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionStatement(ExpressionStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Case Default Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Case Default Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchCaseDefaultStatement(SwitchCaseDefaultStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Case Expression Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Case Expression Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchCaseExpressionStatement(SwitchCaseExpressionStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveExpression(PrimitiveExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionExpression(CollectionExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetExpression(SetExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bag Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bag Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBagExpression(BagExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceExpression(SequenceExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ordered Set Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ordered Set Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrderedSetExpression(OrderedSetExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Map Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Map Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMapExpression(MapExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseType(Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Any Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Any Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnyType(AnyType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionType(CollectionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveType(PrimitiveType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanType(BooleanType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerType(IntegerType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Real Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Real Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRealType(RealType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringType(StringType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetType(SetType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bag Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bag Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBagType(BagType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceType(SequenceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ordered Set Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ordered Set Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrderedSetType(OrderedSetType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Map Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Map Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMapType(MapType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotation(Annotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Executable Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Executable Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecutableAnnotation(ExecutableAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleAnnotation(SimpleAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Key Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Key Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKeyValue(KeyValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Special Name Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Special Name Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecialNameExpression(SpecialNameExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Element Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelElementType(ModelElementType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Native Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Native Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNativeType(NativeType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelExpression(ModelExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotationBlock(AnnotationBlock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Declaration Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Declaration Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelDeclarationParameter(ModelDeclarationParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Throw Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Throw Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThrowStatement(ThrowStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abort Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abort Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbortStatement(AbortStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transaction Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transaction Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransactionStatement(TransactionStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Formal Parameter Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Formal Parameter Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFormalParameterExpression(FormalParameterExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Init Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Init Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionInitValue(CollectionInitValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expr List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expr List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExprList(ExprList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exp Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exp Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpRange(ExpRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>New Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>New Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNewExpression(NewExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Special Assignment Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Special Assignment Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecialAssignmentStatement(SpecialAssignmentStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelType(ModelType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Native Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Native Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNativeExpression(NativeExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EType</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EType</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEType(EType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Void Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Void Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVoidType(VoidType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pseudo Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pseudo Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePseudoType(PseudoType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Self Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Self Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelfType(SelfType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Self Content Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Self Content Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelfContentType(SelfContentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ordered Collection Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ordered Collection Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrderedCollectionType(OrderedCollectionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unique Collection Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unique Collection Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUniqueCollectionType(UniqueCollectionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Self Innermost Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Self Innermost Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelfInnermostType(SelfInnermostType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Arg Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Arg Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationArgType(OperationArgType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //EolSwitch
