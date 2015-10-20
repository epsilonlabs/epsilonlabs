package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.operationDefinitionHandler;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.metamodel.FeatureCallExpression;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.AnalysisInterruptException;

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
		handlers.add(new UtilityHandler());
		handlers.add(new CloneHandler());
		handlers.add(new AtHandler());
		handlers.add(new OrderedCollectionAccessorHandler());
		handlers.add(new InvertHandler());
		handlers.add(new IndexOfHandler());
		handlers.add(new IncludesHandler());
		handlers.add(new IncludesAllHandler());
		handlers.add(new ExcludingHandler());
		handlers.add(new ExcludingAllHandler());
		handlers.add(new RemoveHandler());
		handlers.add(new RemoveAllHandler());
	}
	
	public void addHandler(OperationDefinitionHandler handler)
	{
		handlers.add(handler);
	}
	
	public OperationDefinition handle(FeatureCallExpression featureCallExpression, String name, Type contextType, ArrayList<Type> argTypes) throws AnalysisInterruptException
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
