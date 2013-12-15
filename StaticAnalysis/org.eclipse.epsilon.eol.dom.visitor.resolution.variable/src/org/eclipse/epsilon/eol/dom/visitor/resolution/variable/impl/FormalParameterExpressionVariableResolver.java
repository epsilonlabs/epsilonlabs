package org.eclipse.epsilon.eol.dom.visitor.resolution.variable.impl;

import org.eclipse.epsilon.eol.dom.FormalParameterExpression;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.FormalParameterExpressionVisitor;
import org.eclipse.epsilon.eol.dom.visitor.resolution.variable.context.VariableResolutionContext;

public class FormalParameterExpressionVariableResolver extends FormalParameterExpressionVisitor<VariableResolutionContext, Object>{

	@Override
	public Object visit(FormalParameterExpression formalParameterExpression,
			VariableResolutionContext context,
			EolVisitorController<VariableResolutionContext, Object> controller) {
		context.getStack().putVariable(formalParameterExpression);
		return null;
	}

}
