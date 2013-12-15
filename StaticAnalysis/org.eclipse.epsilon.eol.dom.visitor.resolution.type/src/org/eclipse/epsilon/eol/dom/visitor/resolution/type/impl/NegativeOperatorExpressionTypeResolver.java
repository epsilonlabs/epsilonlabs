package org.eclipse.epsilon.eol.dom.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.dom.BooleanType;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.NegativeOperatorExpression;
import org.eclipse.epsilon.eol.dom.RealType;
import org.eclipse.epsilon.eol.dom.StringType;
import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.NegativeOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;

public class NegativeOperatorExpressionTypeResolver extends NegativeOperatorExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(NegativeOperatorExpression negativeOperatorExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		controller.visitContents(negativeOperatorExpression, context); //visit content first
		
		Type type = context.getEolFactory().createIntegerType(); //set type first, this allows minor-error in expressions n statements
		Expression expression = negativeOperatorExpression.getExpr(); //get the expression
		
		if (expression.getResolvedType() instanceof BooleanType) { //if expression is of type boolean
			context.getLogBook().addError(expression, "Expression cannot be Boolean");
		}
		
		if (expression.getResolvedType() instanceof StringType) { //if expression is of type string
			//handle string
			context.getLogBook().addError(expression, "Expression cannot be String");
		}
		
		if (expression.getResolvedType() instanceof RealType) { //if expression is of type real
			 type = context.getEolFactory().createRealType();
		}	
		
		context.setAssets(type, negativeOperatorExpression);
		return null;
	}
}
