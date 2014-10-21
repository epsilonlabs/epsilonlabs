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
		//if there is already a variable in the current scope, report error
 		if (context.getStack().variableExistsInCurrentScope(variableDeclarationExpression.getName().getName())) {
			context.getLogBook().addError(variableDeclarationExpression, context.VARIABLE_EXISTED + variableDeclarationExpression.getName().getName());
		}
		else {
			//if the name is a reserved keyword
			if (context.isKeyWordSimple(variableDeclarationExpression.getName().getName())) {
				context.getLogBook().addError(variableDeclarationExpression.getName(), context.RESERVED_KEYWORD);
			}
			//else
			else {
				//put the variable
				context.getStack().putVariable(variableDeclarationExpression, false);
				//if the container of the var is an assignment statement and is the lhs of the assignment, add the stateement to the definition point
				/*
				if (variableDeclarationExpression.getContainer() instanceof AssignmentStatement) {
					AssignmentStatement assignmentStatement = (AssignmentStatement) variableDeclarationExpression.getContainer();
					if (assignmentStatement.getLhs().equals(variableDeclarationExpression)) {
						variableDeclarationExpression.getDefinitionPoints().add(assignmentStatement);
					}
				}
				*/
			}
		}
		return null;
	}

}
