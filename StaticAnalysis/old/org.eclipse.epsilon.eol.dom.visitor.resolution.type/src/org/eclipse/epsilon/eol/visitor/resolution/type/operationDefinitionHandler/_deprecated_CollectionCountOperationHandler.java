package org.eclipse.epsilon.eol.visitor.resolution.type.operationDefinitionHandler;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.operationDefinitionUtil.StandardLibraryOperationDefinitionContainer;

public class _deprecated_CollectionCountOperationHandler extends _deprecated_CollectionOperationDefinitionHandler{

	public _deprecated_CollectionCountOperationHandler(TypeResolutionContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean appliesTo(String name, ArrayList<Type> argTypes) {
		// TODO Auto-generated method stub
		return name.equals("count") && argTypes.size() == 1;
	}

	@Override
	public OperationDefinition handle(
			FeatureCallExpression featureCallExpression, Type contextType,
			ArrayList<Type> argTypes) {

		StandardLibraryOperationDefinitionContainer container = context.getOperationDefinitionControl().getStandardLibraryOperationDefinitionContainer();
		
		OperationDefinition result = container.getOperation(((MethodCallExpression) featureCallExpression).getMethod().getName(), argTypes);

		CollectionType targetType = (CollectionType) featureCallExpression.getTarget().getResolvedType();
		
		if (targetType.getContentType() instanceof AnyType) {
		}
		else {
			Type contentType = targetType.getContentType();
			Type argType = argTypes.get(0);
			if (!contentType.getClass().equals(argType.getClass())) {
				context.getLogBook().addError(((MethodCallExpression) featureCallExpression).getArguments().get(0), "Type mismiatch with Collection's content");
			}
		}
		return result;
	}

}
