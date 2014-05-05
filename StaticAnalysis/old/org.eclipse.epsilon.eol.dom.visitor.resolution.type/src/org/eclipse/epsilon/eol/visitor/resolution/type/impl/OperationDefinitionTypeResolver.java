package org.eclipse.epsilon.eol.visitor.resolution.type.impl;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.OperationDefinitionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;

public class OperationDefinitionTypeResolver extends OperationDefinitionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(OperationDefinition operationDefinition,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		/*controller.visit(operationDefinition.getContextType(), context); //resolve context type
		controller.visit(operationDefinition.getReturnType(), context); //resolve return type
		if (operationDefinition.getSelf() != null) {
			operationDefinition.getSelf().setResolvedType(EcoreUtil.copy(operationDefinition.getReturnType()));	
		}

		Type contextType = operationDefinition.getContextType(); //get the contextType
		ArrayList<Type> argTypes = new ArrayList<Type>(); //prepare argTypes
		
		for(VariableDeclarationExpression v: operationDefinition.getParameters()) //process each arg type
		{
			controller.visit(v, context);
			argTypes.add(v.getResolvedType()); //resolve and collect argument types
		}
		
		if (!context.getOperationDefinitionControl().containsOperation(operationDefinition.getName().getName(), contextType, argTypes)) { //check if operation with the same name and arg list exists
			context.putOperationDefinition(operationDefinition);
		}
		else {
			context.getLogBook().addError(operationDefinition, "OperationDefinition with same signature already defined");
			///handle signature existence
		}*/
		
		//controller.visit(operationDefinition.getAnnotationBlock(), context);
		
		//controller.visit(operationDefinition.get_result(), context);
		controller.visit(operationDefinition.getBody(), context);
		
		
		return null;
	}

}
