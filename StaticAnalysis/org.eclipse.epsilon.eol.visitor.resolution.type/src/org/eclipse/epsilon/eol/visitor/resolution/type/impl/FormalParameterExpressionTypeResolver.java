package org.eclipse.epsilon.eol.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.FormalParameterExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;

public class FormalParameterExpressionTypeResolver extends FormalParameterExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(FormalParameterExpression formalParameterExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		// TODO Auto-generated method stub
		if (context.getPessimistic()) {
			context.getStack().push(formalParameterExpression, true);
		}
		controller.visit(formalParameterExpression.getName(), context);
		controller.visit(formalParameterExpression.getResolvedType(), context);
		if (context.getPessimistic()) {
			context.getStack().pop();
		}
		return null;
	}

}
