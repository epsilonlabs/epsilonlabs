package org.eclipse.epsilon.eol.dom.visitor.resolution.type.operationDefinitionHandler;

import java.util.ArrayList;
import java.util.jar.Attributes.Name;

import metamodel.connectivity.EMetaModel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.dom.AnyType;
import org.eclipse.epsilon.eol.dom.CollectionType;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.FeatureCallExpression;
import org.eclipse.epsilon.eol.dom.MethodCallExpression;
import org.eclipse.epsilon.eol.dom.ModelElementType;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.OperationDefinition;
import org.eclipse.epsilon.eol.dom.SetType;
import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.operationDefinitionUtil.StandardLibraryOperationDefinitionContainer;

public class ModelElementTypeAllInstancesHandler extends ModelElementTypeHandler{

	public ModelElementTypeAllInstancesHandler(TypeResolutionContext context) {
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
		StandardLibraryOperationDefinitionContainer container = context.getOperationDefinitionControl().getStandardLibraryOperationDefinitionContainer();
		
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
			if (context.numberOfMetamodelsDefine(target.getName()) > 0) { //if the NameExpression is a keyword in the metamodels
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

		
		
		return result;
	}

}
