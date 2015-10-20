package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.operationDefinitionHandler;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.metamodel.FeatureCallExpression;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.Type;

public class OperationDefinitionHandlerFactory {

	protected ArrayList<OperationDefinitionHandler> handlers;
	
	public OperationDefinitionHandlerFactory()
	{
		handlers = new ArrayList<OperationDefinitionHandler>();
		initTypeHandlers();
	}
	
	public void initTypeHandlers()
	{
		handlers.add(new IfUndefinedHandler());
		handlers.add(new AddHandler());
		handlers.add(new AddAllHandler());
		handlers.add(new FlattenHandler());
		handlers.add(new IncludingHandler());
		handlers.add(new IncludingAllHandler());
		handlers.add(new RandomHandler());
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
