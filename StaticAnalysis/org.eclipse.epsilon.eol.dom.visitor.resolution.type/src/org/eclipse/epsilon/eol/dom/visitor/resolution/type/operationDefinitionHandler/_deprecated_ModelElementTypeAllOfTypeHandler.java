package org.eclipse.epsilon.eol.dom.visitor.resolution.type.operationDefinitionHandler;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.operationDefinitionUtil.StandardLibraryOperationDefinitionContainer;

public class _deprecated_ModelElementTypeAllOfTypeHandler extends _deprecated_ModelElementTypeHandler{

	public _deprecated_ModelElementTypeAllOfTypeHandler(TypeResolutionContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean appliesTo(String name, ArrayList<Type> argTypes) {
		// TODO Auto-generated method stub
		return name.equals("allOfType") && argTypes.size() == 0;
	}

	@Override
	public OperationDefinition handle(
			FeatureCallExpression featureCallExpression, Type contextType,
			ArrayList<Type> argTypes) {
		StandardLibraryOperationDefinitionContainer container = context.getOperationDefinitionControl().getStandardLibraryOperationDefinitionContainer(); //get container
		
		String featureCallName = ((MethodCallExpression)featureCallExpression).getMethod().getName(); //get method name

		OperationDefinition result = container.getOperation(((MethodCallExpression) featureCallExpression).getMethod().getName(), argTypes); //get operaiton definition
		Expression rawTarget = featureCallExpression.getTarget(); //get targettype
		if(!(rawTarget instanceof NameExpression)) //if targettype is not a NameExpressioin
		{
			context.getLogBook().addError(featureCallExpression.getTarget(), "operation " + featureCallName + " can only be used on ModelElementTypes");
			return null;
		}
		else { //else
			NameExpression target = (NameExpression) rawTarget; //cast the target to NameExpression
			if (context.numberOfMetamodelsDefine(target.getName(), true) > 0) { //if the NameExpression is a keyword in the metamodels
				Type rawTargetType = featureCallExpression.getTarget().getResolvedType();
				
				if (!(rawTargetType instanceof ModelElementType)) {
					context.getLogBook().addError(featureCallExpression.getTarget(), "operation " + featureCallName + " can only be used on ModelElementTypes");
					return null;
				}
				else if (rawTargetType instanceof ModelElementType) {
					
					result.setContextType(EcoreUtil.copy(contextType));
					CollectionType returnType = (CollectionType) result.getReturnType();
					((SetType)returnType).setContentType(EcoreUtil.copy(rawTargetType));
				}
			}
			else {
				context.getLogBook().addError(featureCallExpression.getTarget(), "Model Element Type " + target.getName() + " does not exist");
				return null;
			}
		}

		
		
		/*
		
		if (!(featureCallExpression.getTarget().getResolvedType() instanceof ModelElementType)) {
			context.getLogBook().addError(featureCallExpression.getTarget(), "operation " + ((MethodCallExpression)featureCallExpression).getMethod().getName() + "() can only be used on ModelElementTypes");
		}
		
		result.setContextType(EcoreUtil.copy(contextType));
		
		CollectionType returnType = (CollectionType) result.getReturnType();
		((SetType)returnType).setContentType(EcoreUtil.copy(contextType));*/
		
		return result;
	}

}
