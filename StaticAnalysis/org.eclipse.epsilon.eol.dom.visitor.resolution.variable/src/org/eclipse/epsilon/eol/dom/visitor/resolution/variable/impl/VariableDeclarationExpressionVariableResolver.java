package org.eclipse.epsilon.eol.dom.visitor.resolution.variable.impl;

import org.eclipse.epsilon.eol.dom.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.VariableDeclarationExpressionVisitor;
import org.eclipse.epsilon.eol.dom.visitor.resolution.variable.context.VariableResolutionContext;

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
