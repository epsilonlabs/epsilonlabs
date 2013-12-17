package org.eclipse.epsilon.eol.dom.visitor.resolution.variable.impl;

import org.eclipse.epsilon.eol.dom.FormalParameterExpression;
import org.eclipse.epsilon.eol.dom.OperationDefinition;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.OperationDefinitionVisitor;
import org.eclipse.epsilon.eol.dom.visitor.resolution.variable.context.VariableResolutionContext;

public class OperationDefinitionVariableResolver extends OperationDefinitionVisitor<VariableResolutionContext, Object>{

	@Override
	public Object visit(OperationDefinition operationDefinition,
			VariableResolutionContext context,
			EolVisitorController<VariableResolutionContext, Object> controller) {
		context.getStack().push(operationDefinition, false);
		
		if (operationDefinition.getSelf() != null) {
			context.getStack().putVariable(operationDefinition.getSelf()); //put 'self'
		}
		
		for(FormalParameterExpression param: operationDefinition.getParameters())
		{
			controller.visit(param, context);
		}
		
		if(operationDefinition.getAnnotationBlock()!= null)
		{
			controller.visit(operationDefinition.getAnnotationBlock(), context);
		}
		controller.visit(operationDefinition.getBody(), context);
		context.getStack().pop();
		return null;
	}
}
