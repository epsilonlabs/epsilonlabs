package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.operationDefinitionUtil;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.metamodel.FeatureCallExpression;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.SelfContentType;
import org.eclipse.epsilon.eol.metamodel.SelfType;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.operationDefinitionHandler.OperationDefinitionHandlerFactory;

public class OperationDefinitionManager {

	protected UserDefinedOperationDefinitionContainer userDefinedOperations; //used to store user defined oeprations
	protected StandardLibraryOperationDefinitionContainer standardLibraryOperations; //used to store standard library operations
	protected TypeResolutionContext context;
	protected OperationDefinitionHandlerFactory handlerFactory;
	
	public OperationDefinitionManager(TypeResolutionContext context)
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
			if (operation == null) { //if there is no operation in the user defined operations
				if (name.equals("equivalent") || name.equals("equivalents")) {
					operation = standardLibraryOperations.getOperation(name, contextType, new ArrayList<Type>()); //look for standard library
				}
				else {
					operation = standardLibraryOperations.getOperation(name, contextType, argTypes); //look for standard library
				}
				
				if (operation != null) { //if there's an operation in the standard library
					if ((operation.getReturnType() instanceof SelfType) || (operation.getReturnType() instanceof SelfContentType)) {
						//if it's selfType or SelfContentType, it is handled automatically
					}
					else { //otherwise it should be handled by the handler
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
		else { //if priority is given to the standard library
			if (name.equals("equivalent") || name.equals("equivalents")) {
				operation = standardLibraryOperations.getOperation(name, contextType, new ArrayList<Type>()); //look for standard library
			}
			else {
				operation = standardLibraryOperations.getOperation(name, contextType, argTypes); //look for standard library
			}

			if (operation == null) { //if there is no operation in the standard library
				operation = userDefinedOperations.getOperation(name, contextType, argTypes); //assign operation
			}
			else { //if there is operation in the standard library, proceed as before
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

	public boolean containsOperation(String name, Type contextType, ArrayList<Type> argTypes)
	{
		return userDefinedOperations.containsOperation(name, contextType, argTypes);
	}
	
	public OperationDefinition getOperation(String name, Type contextType, ArrayList<Type> argTypes)
	{
		return userDefinedOperations.getOperation(name, contextType, argTypes);
	}
	
	
	
}
