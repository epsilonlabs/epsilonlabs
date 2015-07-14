package org.eclipse.epsilon.eol.visitor.resolution.variable.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.VariableDeclarationExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.variable.context.IMessage_VariableResolution;
import org.eclipse.epsilon.eol.visitor.resolution.variable.context.VariableResolutionContext;

public class VariableDeclarationExpressionVariableResolver extends VariableDeclarationExpressionVisitor<VariableResolutionContext, Object>{

	@Override
	public Object visit(
			VariableDeclarationExpression variableDeclarationExpression,
			VariableResolutionContext context,
			EolVisitorController<VariableResolutionContext, Object> controller) {
		
		
		if (context.isReservedWord(variableDeclarationExpression.getName().getName())) {
			context.getLogBook().addError(variableDeclarationExpression.getName(), IMessage_VariableResolution.RESERVED_KEYWORD);
		}
		else {
	 		if (context.getStack().variableExistsInCurrentScope(variableDeclarationExpression.getName().getName())) {
				context.getLogBook().addError(variableDeclarationExpression, IMessage_VariableResolution.VARIABLE_EXISTED + variableDeclarationExpression.getName().getName());
	 		}
	 		else {
				context.getStack().putVariable(variableDeclarationExpression, false);
				context.storeVariable(variableDeclarationExpression);
			}
		}
		return null;
	}
}
