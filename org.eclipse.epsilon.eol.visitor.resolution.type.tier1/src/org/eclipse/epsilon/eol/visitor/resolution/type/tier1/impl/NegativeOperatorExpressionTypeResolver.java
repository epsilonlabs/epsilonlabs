package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.BooleanType;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.NegativeOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.RealType;
import org.eclipse.epsilon.eol.metamodel.StringType;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.NegativeOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_TypeResolution;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class NegativeOperatorExpressionTypeResolver extends NegativeOperatorExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(NegativeOperatorExpression negativeOperatorExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		controller.visit(negativeOperatorExpression.getExpression(), context);
			
		Expression expression = negativeOperatorExpression.getExpression(); //get the expression
		Type exprType = expression.getResolvedType();
		
		if (exprType instanceof BooleanType) { //if expression is of type boolean
			context.getLogBook().addError(expression, IMessage_TypeResolution.EXPRESSION_CANNOT_BE_BOOLEAN);
		}
		
		if (exprType instanceof StringType) { //if expression is of type string
			//handle string
			context.getLogBook().addError(expression, IMessage_TypeResolution.EXPRESSION_CANNOT_BE_STRING);
		}
		
		if (exprType instanceof RealType) { //if expression is of type real
			negativeOperatorExpression.setResolvedType(EcoreUtil.copy(exprType));
		}	
		
		return null;
	}
}
