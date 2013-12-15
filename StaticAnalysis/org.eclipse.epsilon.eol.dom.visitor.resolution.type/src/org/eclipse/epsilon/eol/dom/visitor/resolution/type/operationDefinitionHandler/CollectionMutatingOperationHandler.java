package org.eclipse.epsilon.eol.dom.visitor.resolution.type.operationDefinitionHandler;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.dom.AnyType;
import org.eclipse.epsilon.eol.dom.CollectionType;
import org.eclipse.epsilon.eol.dom.FeatureCallExpression;
import org.eclipse.epsilon.eol.dom.MethodCallExpression;
import org.eclipse.epsilon.eol.dom.OperationDefinition;
import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeUtil;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.operationDefinitionUtil.StandardLibraryOperationDefinitionContainer;

public class CollectionMutatingOperationHandler extends CollectionOperationDefinitionHandler{

	public CollectionMutatingOperationHandler(TypeResolutionContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean appliesTo(String name, ArrayList<Type> argTypes) {
		// TODO Auto-generated method stub
		return (
				(
						name.equals("add") || 
						name.equals("addAll") ||
						name.equals("remove") ||
						name.equals("removeAll") ||
						name.equals("including") ||
						name.equals("excluding") ||
						name.equals("includingAll") ||
						name.equals("excludingAll") &&
						argTypes.size() == 1) ||
						(name.equals("clear") && argTypes.size() == 0));
	}

	@Override
	public OperationDefinition handle(
			FeatureCallExpression featureCallExpression, Type contextType,
			ArrayList<Type> argTypes) {
		String name = ((MethodCallExpression) featureCallExpression).getMethod().getName();
		
		StandardLibraryOperationDefinitionContainer container = context.getOperationDefinitionControl().getStandardLibraryOperationDefinitionContainer();
		
		OperationDefinition result = container.getOperation(name, argTypes);

		CollectionType targetType = (CollectionType) featureCallExpression.getTarget().getResolvedType();

		if (name.equals("add") || name.equals("remove") || name.equals("including") || name.equals("excluding")) {
			if (targetType.getContentType() instanceof AnyType) {
				result.setReturnType(EcoreUtil.copy(targetType));
			}
			else {
				Type contentType = targetType.getContentType();
				Type argType = argTypes.get(0);
				if (!context.getTypeUtil().isEqualOrGeneric(argType, contentType)) {
					context.getLogBook().addError(((MethodCallExpression) featureCallExpression).getArguments().get(0), "Type mismiatch with Collection's content");
				}
			}
		}
		
		else if (name.equals("addAll") || name.equals("removeAll") || name.equals("includingAll") || name.equals("excludingAll")) {
			if (targetType.getContentType() instanceof AnyType) {
				result.setReturnType(EcoreUtil.copy(targetType));
			}
			else {
				Type contentType = targetType.getContentType();
				CollectionType argType = (CollectionType) argTypes.get(0);
				Type argContentType = argType.getContentType();
				if (!context.getTypeUtil().isEqualOrGeneric(argContentType, contentType)) {
					context.getLogBook().addError(((MethodCallExpression) featureCallExpression).getArguments().get(0), "Type mismiatch with Collection's content");
				}
			}
		}
		else {
			result.setReturnType(EcoreUtil.copy(targetType));
		}
		return result;
	}

}
