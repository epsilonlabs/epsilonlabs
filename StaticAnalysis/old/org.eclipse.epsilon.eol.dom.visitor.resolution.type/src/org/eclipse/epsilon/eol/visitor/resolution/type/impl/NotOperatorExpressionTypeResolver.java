package org.eclipse.epsilon.eol.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.NotOperatorExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;

public class NotOperatorExpressionTypeResolver extends NotOperatorExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(NotOperatorExpression notOperatorExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		controller.visit(notOperatorExpression.getExpr(), context); //visit expr first
		Type type = context.getEolFactory().createBooleanType(); //set type first, this allows minor-error in expressions n statements
		notOperatorExpression.setResolvedType(type);
		context.setAssets(type, notOperatorExpression); //set the type to the notOperatorExpression
		
		if(!(notOperatorExpression.getExpr().getResolvedType() instanceof BooleanType))
		{
			context.getLogBook().addError(notOperatorExpression.getExpr(), "Expression is not of type Boolean");
		}
		
		return null;
	}

}
