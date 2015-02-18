package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.BooleanType;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.IntegerType;
import org.eclipse.epsilon.eol.metamodel.NegativeOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.PrimitiveType;
import org.eclipse.epsilon.eol.metamodel.RealType;
import org.eclipse.epsilon.eol.metamodel.StringType;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.NegativeOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.parse.Eol_EolParserRules.elseStatement_return;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class NegativeOperatorExpressionTypeResolver extends NegativeOperatorExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(NegativeOperatorExpression negativeOperatorExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		controller.visit(negativeOperatorExpression.getExpr(), context);
		
		
		Type type = context.getEolFactory().createIntegerType(); //create an integer type
		negativeOperatorExpression.setResolvedType(type);
		context.setAssets(type, negativeOperatorExpression);

		Expression expression = negativeOperatorExpression.getExpr(); //get the expression
		Type exprType = expression.getResolvedType();
		
		if (exprType == null) {
			context.getLogBook().addError(expression, "Expression does not have a type");
			return null;
		}
		else {
			if (exprType instanceof AnyType) {
				context.getLogBook().addError(expression, "Expression is of type Any");
				type = context.getEolFactory().createAnyType(); //create an integer type
				negativeOperatorExpression.setResolvedType(type);
				context.setAssets(type, negativeOperatorExpression);
				return null;
			}
			else if (exprType instanceof PrimitiveType) {
				if (exprType instanceof RealType) { //if expression is of type real
					type = EcoreUtil.copy(exprType); //create an integer type
					negativeOperatorExpression.setResolvedType(type);
					context.setAssets(type, negativeOperatorExpression);
					return null;
				}	
				else if (exprType instanceof IntegerType) {
					type = EcoreUtil.copy(exprType); //create an integer type
					negativeOperatorExpression.setResolvedType(type);
					context.setAssets(type, negativeOperatorExpression);
					return null;
				}
				else {
					context.getLogBook().addError(expression, "Expression should be numeral");
					type = context.getEolFactory().createAnyType(); //create an integer type
					negativeOperatorExpression.setResolvedType(type);
					context.setAssets(type, negativeOperatorExpression);
					return null;
				}
			}
			else {
				context.getLogBook().addError(expression, "Expression should be numeral");
				type = context.getEolFactory().createAnyType(); //create an integer type
				negativeOperatorExpression.setResolvedType(type);
				context.setAssets(type, negativeOperatorExpression);
				return null;
			}
		}
	}
}
