package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.NewExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class NewExpressionTypeResolver extends NewExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(NewExpression newExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		controller.visit(newExpression.getResolvedType(), context);

		return null;
	}

}
