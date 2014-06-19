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
		if (context.getStack().variableExistsInCurrentScope(variableDeclarationExpression.getName().getName())) {
			context.getLogBook().addError(variableDeclarationExpression, "variable with same name already exists");
		}
		else {
			if (context.isKeyWordSimple(variableDeclarationExpression.getName().getName())) {
				context.getLogBook().addError(variableDeclarationExpression.getName(), "cannot create an variable with reserved keyword");
			}
			else {
				context.getStack().putVariable(variableDeclarationExpression);
			}
		}
		return null;
	}

}
