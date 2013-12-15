package org.eclipse.epsilon.eol.dom.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.dom.BooleanType;
import org.eclipse.epsilon.eol.dom.NotOperatorExpression;
import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.NotOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;

public class NotOperatorExpressionTypeResolver extends NotOperatorExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(NotOperatorExpression notOperatorExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		controller.visitContents(notOperatorExpression, context); //visit contents first
		Type type = context.getEolFactory().createBooleanType(); //set type first, this allows minor-error in expressions n statements
		context.setAssets(type, notOperatorExpression); //set the type to the notOperatorExpression
		
		if(!(notOperatorExpression.getExpr().getResolvedType() instanceof BooleanType))
		{
			context.getLogBook().addError(notOperatorExpression.getExpr(), "Expression is not of type Boolean");
		}
		
		return null;
	}

}
