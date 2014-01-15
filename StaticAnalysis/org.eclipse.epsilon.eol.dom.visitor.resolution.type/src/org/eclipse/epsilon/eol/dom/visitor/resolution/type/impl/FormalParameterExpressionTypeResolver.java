package org.eclipse.epsilon.eol.dom.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.dom.FormalParameterExpression;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.FormalParameterExpressionVisitor;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;

public class FormalParameterExpressionTypeResolver extends FormalParameterExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(FormalParameterExpression formalParameterExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		// TODO Auto-generated method stub
		controller.visit(formalParameterExpression.getName(), context);
		controller.visit(formalParameterExpression.getResolvedType(), context);
		return null;
	}

}
