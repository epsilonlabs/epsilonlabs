package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.FormalParameterExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class FormalParameterExpressionTypeResolver extends FormalParameterExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(FormalParameterExpression formalParameterExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		//visit name first
		controller.visit(formalParameterExpression.getName(), context);
		
		//visit resolved type
		controller.visit(formalParameterExpression.getResolvedType(), context);
		
		return null;
	}

}
