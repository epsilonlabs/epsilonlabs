package org.eclipse.epsilon.eol.dom.visitor.resolution.type.operationDefinitionHandler;

import java.util.ArrayList;
import java.util.jar.Attributes.Name;

import metamodel.connectivity.emf.EMetaModel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.operationDefinitionUtil.StandardLibraryOperationDefinitionContainer;

public class _deprecated_ModelElementTypeAllInstancesHandler extends _deprecated_ModelElementTypeHandler{

	public _deprecated_ModelElementTypeAllInstancesHandler(TypeResolutionContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean appliesTo(String name, ArrayList<Type> argTypes) {
		// TODO Auto-generated method stub
		return (name.equals("allInstances") || name.equals("all") || name.equals("allOfKind")) && argTypes.size() == 0;
	}

	@Override
	public OperationDefinition handle(
			FeatureCallExpression featureCallExpression, Type contextType,
			ArrayList<Type> argTypes) {
		StandardLibraryOperationDefinitionContainer container = context.getOperationDefinitionControl().getStandardLibraryOperationDefinitionContainer(); //get container
		
		String featureCallName = "";
		if (featureCallExpression instanceof MethodCallExpression) {
			featureCallName = ((MethodCallExpression)featureCallExpression).getMethod().getName(); //get method name
		}
		else if (featureCallExpression instanceof PropertyCallExpression) {
			featureCallName = ((PropertyCallExpression)featureCallExpression).getProperty().getName(); //get method name
		}
		
		
		OperationDefinition result = container.getOperation(featureCallName, argTypes); //get operaiton definition
		Expression rawTarget = featureCallExpression.getTarget(); //get targettype
		if(!(rawTarget instanceof NameExpression)) //if targettype is not a NameExpressioin
		{
			context.getLogBook().addError(featureCallExpression.getTarget(), "operation " + featureCallName + " can only be used on ModelElementTypes");
			return null;
		}
		else { //else
			NameExpression target = (NameExpression) rawTarget; //cast the target to NameExpression
			String targetname = target.getName();
			if (targetname.contains("!")) {
				targetname = targetname.substring(targetname.indexOf("!")+1, targetname.length());
			}
			if (context.numberOfMetamodelsDefine(targetname, false) > 0) { //if the NameExpression is a keyword in the metamodels
				Type rawTargetType = featureCallExpression.getTarget().getResolvedType();
				
				if (!(rawTargetType instanceof ModelElementType)) {
					context.getLogBook().addError(featureCallExpression.getTarget(), "operation " + featureCallName + " can only be used on ModelElementTypes");
					return null;
				}
				else if (rawTargetType instanceof ModelElementType) {
					
					result.setContextType(EcoreUtil.copy(contextType));
					CollectionType returnType = (CollectionType) result.getReturnType();
					returnType.setContentType(EcoreUtil.copy(rawTargetType));
				}
			}
			else {
				context.getLogBook().addError(featureCallExpression.getTarget(), "Model Element Type " + target.getName() + " does not exist");
				return null;
			}
		}
		
		return result;
	}

}
