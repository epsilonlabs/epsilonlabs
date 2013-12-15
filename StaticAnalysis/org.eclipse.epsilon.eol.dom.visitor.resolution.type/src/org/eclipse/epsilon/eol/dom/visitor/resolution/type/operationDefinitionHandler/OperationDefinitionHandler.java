package org.eclipse.epsilon.eol.dom.visitor.resolution.type.operationDefinitionHandler;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.dom.FeatureCallExpression;
import org.eclipse.epsilon.eol.dom.MethodCallExpression;
import org.eclipse.epsilon.eol.dom.OperationDefinition;
import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;

public abstract class OperationDefinitionHandler {

	protected TypeResolutionContext context;
	
	public OperationDefinitionHandler(TypeResolutionContext context)
	{
		this.context = context;
	}
	
	public abstract boolean appliesTo(String name, ArrayList<Type> argTypes);
	
	public abstract OperationDefinition handle(FeatureCallExpression featureCallExpression, Type contextType, ArrayList<Type> argTypes);
}
