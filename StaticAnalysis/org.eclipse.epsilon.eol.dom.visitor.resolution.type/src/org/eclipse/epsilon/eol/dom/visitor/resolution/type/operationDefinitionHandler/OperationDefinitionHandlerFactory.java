package org.eclipse.epsilon.eol.dom.visitor.resolution.type.operationDefinitionHandler;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.dom.FeatureCallExpression;
import org.eclipse.epsilon.eol.dom.OperationDefinition;
import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;

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
		//handlers.add(new IsTypeOfHandler(context));
		//handlers.add(new AsTypeHandler(context));
		//handlers.add(new AbstractPrintHanlder(context));
		//handlers.add(new _deprecated_AbstractToCollectionHandler(context));
		
		//handlers.add(new _deprecated_CollectionMutatingOperationHandler(context));
		//handlers.add(new CollectionQueryingOperationHandler(context));
		//handlers.add(new CollectionRandomOperationHandler(context));
		//handlers.add(new CollectionFlatternOperationHandler(context));
		//handlers.add(new CollectionCountOperationHandler(context));
		//handlers.add(new CollectionCloneOperationHandler(context));
		//handlers.add(new CollectionConcatOperationHandler(context));
		

		//handlers.add(new CollectionFirstAndLastOperationHandler(context));
		//handlers.add(new CollectionIndexOfOperationHandler(context));
		//handlers.add(new CollectionInvertOperationHandler(context));
		
		//handlers.add(new ModelElementTypeAllOfTypeHandler(context));
		//handlers.add(new ModelElementTypeAllInstancesHandler(context));
		//handlers.add(new ModelElementTypeIsInstantiableHandler(context));
		//handlers.add(new ModelElementTypeCreateInstanceHandler(context));
	}
	
	public OperationDefinition handle(FeatureCallExpression featureCallExpression, String name, Type contextType, ArrayList<Type> argTypes)
	{
		//System.err.println("handling: " + name + ", with " + argTypes.size() + "arguments");
		for(OperationDefinitionHandler handler: handlers)
		{
			if (handler.appliesTo(name, argTypes)) {
				return handler.handle(featureCallExpression, contextType, argTypes);
			}
		}
		return null;
	}
	
}
