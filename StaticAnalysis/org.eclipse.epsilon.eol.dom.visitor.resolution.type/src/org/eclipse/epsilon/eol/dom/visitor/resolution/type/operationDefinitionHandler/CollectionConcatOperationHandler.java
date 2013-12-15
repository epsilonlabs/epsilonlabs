package org.eclipse.epsilon.eol.dom.visitor.resolution.type.operationDefinitionHandler;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.dom.FeatureCallExpression;
import org.eclipse.epsilon.eol.dom.MethodCallExpression;
import org.eclipse.epsilon.eol.dom.OperationDefinition;
import org.eclipse.epsilon.eol.dom.StringType;
import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.operationDefinitionUtil.StandardLibraryOperationDefinitionContainer;

public class CollectionConcatOperationHandler extends CollectionOperationDefinitionHandler{

	public CollectionConcatOperationHandler(TypeResolutionContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean appliesTo(String name, ArrayList<Type> argTypes) {
		// TODO Auto-generated method stub
		return name.equals("concat") && argTypes.size() == 1;
	}

	@Override
	public OperationDefinition handle(
			FeatureCallExpression featureCallExpression, Type contextType,
			ArrayList<Type> argTypes) {
		StandardLibraryOperationDefinitionContainer container = context.getOperationDefinitionControl().getStandardLibraryOperationDefinitionContainer();
		
		OperationDefinition result = container.getOperation(((MethodCallExpression) featureCallExpression).getMethod().getName(), contextType, argTypes);

		Type argtyType = argTypes.get(0);
		
		if (!(argtyType instanceof StringType)) {
			context.getLogBook().addError(((MethodCallExpression) featureCallExpression).getArguments().get(0), "Argument must be of type String");
		}
		
		
		return result;
	}

}
