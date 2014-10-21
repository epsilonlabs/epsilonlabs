package org.eclipse.epsilon.eol.visitor.resolution.type.tier2.impl;

import org.eclipse.epsilon.eol.metamodel.AssignmentStatement;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.VariableDeclarationExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier2.context.TypeResolutionContext_T2;

public class VariableDeclarationExpressionTypeResolver_T2 extends VariableDeclarationExpressionVisitor<TypeResolutionContext_T2, Object>{

	@Override
	public Object visit(
			VariableDeclarationExpression variableDeclarationExpression,
			TypeResolutionContext_T2 context,
			EolVisitorController<TypeResolutionContext_T2, Object> controller) {
		context.getStack().putVariable(variableDeclarationExpression, false);
		
		if (variableDeclarationExpression.getContainer() instanceof AssignmentStatement) {
			AssignmentStatement assignmentStatement = (AssignmentStatement) variableDeclarationExpression.getContainer();
			if (assignmentStatement.getLhs().equals(variableDeclarationExpression)) {
				variableDeclarationExpression.getDefinitionPoints().add(assignmentStatement);
			}
		}
		return null;
	}

}
