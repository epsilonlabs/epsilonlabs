package org.eclipse.epsilon.eol.dom.visitor.resolution.type.impl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.NegativeOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;

public class NegativeOperatorExpressionTypeResolver extends NegativeOperatorExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(NegativeOperatorExpression negativeOperatorExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		controller.visit(negativeOperatorExpression.getExpr(), context);
			
		Expression expression = negativeOperatorExpression.getExpr(); //get the expression
		Type exprType = expression.getResolvedType();
		
		if (exprType instanceof BooleanType) { //if expression is of type boolean
			context.getLogBook().addError(expression, "Expression cannot be Boolean");
		}
		
		if (exprType instanceof StringType) { //if expression is of type string
			//handle string
			context.getLogBook().addError(expression, "Expression cannot be String");
		}
		
		if (exprType instanceof RealType) { //if expression is of type real
			negativeOperatorExpression.setResolvedType(EcoreUtil.copy(exprType));
		}	
		if (exprType instanceof IntegerType) {
			negativeOperatorExpression.setResolvedType(EcoreUtil.copy(exprType));
		}
		
		return null;
	}
}
