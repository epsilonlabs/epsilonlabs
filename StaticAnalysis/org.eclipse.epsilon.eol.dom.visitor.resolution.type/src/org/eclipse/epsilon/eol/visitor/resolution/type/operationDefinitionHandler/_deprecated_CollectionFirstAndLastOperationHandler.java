package org.eclipse.epsilon.eol.visitor.resolution.type.operationDefinitionHandler;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.operationDefinitionUtil.StandardLibraryOperationDefinitionContainer;

public class _deprecated_CollectionFirstAndLastOperationHandler extends _deprecated_CollectionOperationDefinitionHandler{

	public _deprecated_CollectionFirstAndLastOperationHandler(TypeResolutionContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean appliesTo(String name, ArrayList<Type> argTypes) {
		// TODO Auto-generated method stub
		return (name.equals("first") || name.equals("last")) && argTypes.size() == 0;
	}

	@Override
	public OperationDefinition handle(
			FeatureCallExpression featureCallExpression, Type contextType,
			ArrayList<Type> argTypes) {
		StandardLibraryOperationDefinitionContainer container = context.getOperationDefinitionControl().getStandardLibraryOperationDefinitionContainer();
		
		OperationDefinition result = null;
		String name= "";
		if(featureCallExpression instanceof MethodCallExpression)
		{
			result = container.getOperation(((MethodCallExpression) featureCallExpression).getMethod().getName(), argTypes);
			name = ((MethodCallExpression) featureCallExpression).getMethod().getName();
		}
		if (featureCallExpression instanceof PropertyCallExpression) {
			result = container.getOperation(((PropertyCallExpression) featureCallExpression).getProperty().getName(), argTypes);
			name = ((PropertyCallExpression) featureCallExpression).getProperty().getName();
		}

		CollectionType targetType = (CollectionType) featureCallExpression.getTarget().getResolvedType();
		
		if (!(targetType instanceof SequenceType || targetType instanceof OrderedSetType || targetType instanceof SetType || targetType instanceof BagType)) {
			context.getLogBook().addError(featureCallExpression.getTarget(), "Operation " + name + " can only be performed on collection types");
		}
		else {
			if (!(targetType.getContentType() instanceof AnyType)) { //if content type is not any
				Type contentType = targetType.getContentType();
				result.setReturnType(EcoreUtil.copy(contentType));
			}
			
		}
		return result;
	}

}
