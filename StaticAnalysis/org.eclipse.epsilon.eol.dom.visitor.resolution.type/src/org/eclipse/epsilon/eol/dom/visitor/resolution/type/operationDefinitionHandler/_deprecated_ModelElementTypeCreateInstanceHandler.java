package org.eclipse.epsilon.eol.dom.visitor.resolution.type.operationDefinitionHandler;

import java.util.ArrayList;

import metamodel.connectivity.emf.EMetaModel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.operationDefinitionUtil.StandardLibraryOperationDefinitionContainer;

public class _deprecated_ModelElementTypeCreateInstanceHandler extends _deprecated_ModelElementTypeHandler{

	public _deprecated_ModelElementTypeCreateInstanceHandler(TypeResolutionContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean appliesTo(String name, ArrayList<Type> argTypes) {
		// TODO Auto-generated method stub
		return name.equals("createInstance") && argTypes.size() == 0;
	}

	@Override
	public OperationDefinition handle(
			FeatureCallExpression featureCallExpression, Type contextType,
			ArrayList<Type> argTypes) {
		StandardLibraryOperationDefinitionContainer container = context.getOperationDefinitionControl().getStandardLibraryOperationDefinitionContainer();
		
		OperationDefinition result = container.getOperation(((MethodCallExpression) featureCallExpression).getMethod().getName(), argTypes);

		Expression rawTarget = featureCallExpression.getTarget();
		if(!(rawTarget instanceof NameExpression))
		{
			context.getLogBook().addError(featureCallExpression.getTarget(), "operation createInstance() can only be used on ModelElementTypes");
			return null;
		}
		else {
			NameExpression target = (NameExpression) rawTarget;
			if (context.numberOfMetamodelsDefine(target.getName(), true) > 0) {
				Type rawTargetType = featureCallExpression.getTarget().getResolvedType();
				
				if (!(rawTargetType instanceof ModelElementType)) {
					context.getLogBook().addError(featureCallExpression.getTarget(), "operation createInstance() can only be used on ModelElementTypes");;
				}
				else if (rawTargetType instanceof ModelElementType) {
					ModelElementType targetType = (ModelElementType) rawTargetType;
					String modelName = targetType.getModelName();
					String elementName = targetType.getElementName();
					EMetaModel em = context.getMetaModel(modelName); //get metamodel
					EClass eClass = em.getMetaClass(elementName);
					
					if (eClass.isAbstract() || eClass.isInterface()) {
						context.getLogBook().addError(featureCallExpression.getTarget(), "target of type: " + modelName + "!" + elementName + " is not instantiable");
					}
				}
				
				result.setContextType(EcoreUtil.copy(contextType));
				result.setReturnType(EcoreUtil.copy(contextType));
			}
			else {
				context.getLogBook().addError(featureCallExpression.getTarget(), "Model Element Type " + target.getName() + " does not exist");

				return null;
			}
			
		}
		
		
		return result;
	}

}
