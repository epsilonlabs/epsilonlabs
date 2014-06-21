package org.eclipse.epsilon.eol.visitor.resolution.variable.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.OperationDefinitionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.variable.context.VariableResolutionContext;

public class OperationDefinitionVariableResolver extends OperationDefinitionVisitor<VariableResolutionContext, Object>{

	@Override
	public Object visit(OperationDefinition operationDefinition,
			VariableResolutionContext context,
			EolVisitorController<VariableResolutionContext, Object> controller) {
		context.getStack().push(operationDefinition, true);
		
		if (operationDefinition.getSelf() != null) {
			context.getStack().putVariable(operationDefinition.getSelf(), false); //put 'self'
		}
		
		if (operationDefinition.get_result() != null) {
			context.getStack().putVariable(operationDefinition.get_result(), false); //put "_result"
		}
		
		if(operationDefinition.getAnnotationBlock()!= null)
		{
			controller.visit(operationDefinition.getAnnotationBlock(), context);
		}
		
		for(FormalParameterExpression param: operationDefinition.getParameters())
		{
			controller.visit(param, context);
		}
		
		controller.visit(operationDefinition.getBody(), context);
		context.getStack().pop();
		return null;
	}
}
