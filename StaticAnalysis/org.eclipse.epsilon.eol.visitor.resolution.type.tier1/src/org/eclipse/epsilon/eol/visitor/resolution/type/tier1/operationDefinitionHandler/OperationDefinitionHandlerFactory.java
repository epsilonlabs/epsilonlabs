package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.operationDefinitionHandler;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class OperationDefinitionHandlerFactory {

	protected TypeResolutionContext context;
	protected ArrayList<OperationDefinitionHandler> handlers;
	
	public OperationDefinitionHandlerFactory(TypeResolutionContext context)
	{
		this.context = context;
		handlers = new ArrayList<OperationDefinitionHandler>();
		initTypeHandlers();
	}
	
	public void initTypeHandlers()
	{
		handlers.add(new IfUndefinedHandler(context));
	}
	
	public void addHandler(OperationDefinitionHandler handler)
	{
		handlers.add(handler);
	}
	
	public OperationDefinition handle(FeatureCallExpression featureCallExpression, String name, Type contextType, ArrayList<Type> argTypes)
	{
		for(OperationDefinitionHandler handler: handlers)
		{
			if (handler.appliesTo(name, argTypes)) {
				return handler.handle(featureCallExpression, contextType, argTypes);
			}
		}
		return null;
	}
	
}
