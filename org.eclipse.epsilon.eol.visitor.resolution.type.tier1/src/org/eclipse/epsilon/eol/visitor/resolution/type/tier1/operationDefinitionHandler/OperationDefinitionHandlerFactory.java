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
		
		handlers.add(new CharAtHandler());
		
		handlers.add(new CollectionConcatHandler());
		
		handlers.add(new CollectionClearHandler());
		handlers.add(new CollectionAddHandler());
		handlers.add(new CollectionAddAllHandler());
		handlers.add(new CollectionFlattenHandler());
		handlers.add(new CollectionIncludingHandler());
		handlers.add(new CollectionIncludingAllHandler());
		handlers.add(new CollectionRandomHandler());
		handlers.add(new CollectionUtilityHandler());
		handlers.add(new CollectionCloneHandler());
		handlers.add(new OrderedCollectionAtHandler());
		handlers.add(new OrderedCollectionAccessorHandler());
		handlers.add(new OrderedCollectionInvertHandler());
		handlers.add(new IndexOfHandler());
		handlers.add(new CollectionIncludesHandler());
		handlers.add(new CollectionIncludesAllHandler());
		handlers.add(new CollectionExcludingHandler());
		handlers.add(new CollectionExcludingAllHandler());
		handlers.add(new CollectionRemoveHandler());
		handlers.add(new CollectionRemoveAllHandler());
		
		handlers.add(new MapContainsKeyHandler());
		handlers.add(new MapGetHandler());
		handlers.add(new MapKeySetHandler());
		handlers.add(new ValuesHandler());
		handlers.add(new MapPutHandler());
		handlers.add(new MapPutAllHandler());
		//handlers.add(new MapUtilityHandler());
		
		handlers.add(new CreateInstanceHandler());
		handlers.add(new isInstantiableHandler());
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
