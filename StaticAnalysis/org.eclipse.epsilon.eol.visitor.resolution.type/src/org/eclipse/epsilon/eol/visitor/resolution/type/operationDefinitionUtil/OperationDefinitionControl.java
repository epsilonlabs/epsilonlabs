package org.eclipse.epsilon.eol.visitor.resolution.type.operationDefinitionUtil;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.operationDefinitionHandler.OperationDefinitionHandlerFactory;

public class OperationDefinitionControl {

	protected UserDefinedOperationDefinitionContainer userDefinedOperations; //used to store user defined oeprations
	protected StandardLibraryOperationDefinitionContainer standardLibraryOperations; //used to store standard library operations
	protected TypeResolutionContext context;
	protected OperationDefinitionHandlerFactory handlerFactory;
	
	public OperationDefinitionControl(TypeResolutionContext context)
	{
		
		userDefinedOperations = new UserDefinedOperationDefinitionContainer(context.getTypeUtil());
		standardLibraryOperations = new StandardLibraryOperationDefinitionContainer(context.getTypeUtil());
		this.context = context;
		handlerFactory = new OperationDefinitionHandlerFactory(context);
	}
	
	public OperationDefinitionHandlerFactory getHandlerFactory()
	{
		return handlerFactory;
	}
	
	public StandardLibraryOperationDefinitionContainer getStandardLibraryOperationDefinitionContainer()
	{
		return standardLibraryOperations;
	}
	
	
	public void putOperationDefinition(OperationDefinition operation)
	{
		userDefinedOperations.putOperation(operation);
	}
	
	public OperationDefinition getOperation(FeatureCallExpression methodCallExpression, String name, Type contextType, ArrayList<Type> argTypes, boolean priority)
	{
		OperationDefinition operation = null; //prepare the result
		if (!priority) { //if priority is given to the userdefined operations
			operation = userDefinedOperations.getOperation(name, contextType, argTypes); //get operation from the user defined opeartions
			if (operation == null) {
				operation = standardLibraryOperations.getOperation(name, contextType, argTypes);
				if (operation != null) {
					if ((operation.getReturnType() instanceof SelfType) || (operation.getReturnType() instanceof SelfContentType)) {
						
					}
					else {
						OperationDefinition temp = handlerFactory.handle(methodCallExpression, name, contextType, argTypes);
						if (temp != null) {
							operation = temp;
						}
						else {
							//operation = null;
						}

					}
				}
			}
		}
		else {
			operation = standardLibraryOperations.getOperation(name, contextType, argTypes);
			if (operation == null) {
				operation = userDefinedOperations.getOperation(name, contextType, argTypes);
			}
			else {
				if ((operation.getReturnType() instanceof SelfType) || (operation.getReturnType() instanceof SelfContentType)) {
					
				}
				else {
					OperationDefinition temp = handlerFactory.handle(methodCallExpression, name, contextType, argTypes);
					if (temp != null) {
						operation = temp;
					}
					else
					{
						operation = null;
					}
				}
			}
		}
		return operation;
	}

	public boolean containsOperation(String name, ArrayList<Type> argTypes)
	{
		return userDefinedOperations.containsOperation(name, argTypes);
	}

	public boolean containsOperation(String name, Type contextType, ArrayList<Type> argTypes)
	{
		return userDefinedOperations.containsOperation(name, contextType, argTypes);
	}
	
	public OperationDefinition getOperation(String name, Type contextType, ArrayList<Type> argTypes)
	{
		return userDefinedOperations.getOperation(name, contextType, argTypes);
	}
	
	
	
}
