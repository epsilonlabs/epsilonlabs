package org.eclipse.epsilon.eol.visitor.resolution.variable.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.VariableDeclarationExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.variable.context.VariableResolutionContext;

public class VariableDeclarationExpressionVariableResolver extends VariableDeclarationExpressionVisitor<VariableResolutionContext, Object>{

	@Override
	public Object visit(
			VariableDeclarationExpression variableDeclarationExpression,
			VariableResolutionContext context,
			EolVisitorController<VariableResolutionContext, Object> controller) {
		context.getStack().putVariable(variableDeclarationExpression);
		variableDeclarationExpression.setLastDefinitionPoint(variableDeclarationExpression);
		return null;
	}

}
