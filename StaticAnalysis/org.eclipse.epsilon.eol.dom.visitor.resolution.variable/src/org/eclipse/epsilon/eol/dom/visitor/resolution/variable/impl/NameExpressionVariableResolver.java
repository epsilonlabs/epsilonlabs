package org.eclipse.epsilon.eol.dom.visitor.resolution.variable.impl;

import org.eclipse.epsilon.eol.dom.AssignmentStatement;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.OperationDefinition;
import org.eclipse.epsilon.eol.dom.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.NameExpressionVisitor;
import org.eclipse.epsilon.eol.dom.visitor.resolution.variable.context.VariableResolutionContext;

public class NameExpressionVariableResolver extends NameExpressionVisitor<VariableResolutionContext, Object>{

	@Override
	public Object visit(NameExpression nameExpression,
			VariableResolutionContext context,
			EolVisitorController<VariableResolutionContext, Object> controller) {
		if(nameExpression.getName().equals("_result") && context.getStack().getTop().getEntryPoint() instanceof OperationDefinition)
		{
			OperationDefinition operation = (OperationDefinition) context.getStack().getTop().getEntryPoint();
			if(operation.get_result() != null)
			{
				VariableDeclarationExpression r = operation.get_result();
				nameExpression.setResolvedContent(r);
			}
		}
		else
		{
			if(context.getStack().getVariable(nameExpression.getName()) != null)
			{
				nameExpression.setResolvedContent((VariableDeclarationExpression)context.getStack().getVariable(nameExpression.getName()).getVariable());
			}
			else {
				//context.getLogBook().addError(nameExpression, "Variable named " + nameExpression.getName() + " cannot be found");
				//do something else
			}
		}
		return null;
	}

}
