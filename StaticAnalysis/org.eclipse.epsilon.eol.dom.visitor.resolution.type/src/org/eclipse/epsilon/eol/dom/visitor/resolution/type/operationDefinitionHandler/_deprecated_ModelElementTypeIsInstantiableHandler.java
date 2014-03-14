package org.eclipse.epsilon.eol.dom.visitor.resolution.type.operationDefinitionHandler;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.FeatureCallExpression;
import org.eclipse.epsilon.eol.dom.MethodCallExpression;
import org.eclipse.epsilon.eol.dom.ModelElementType;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.OperationDefinition;
import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.operationDefinitionUtil.StandardLibraryOperationDefinitionContainer;

public class _deprecated_ModelElementTypeIsInstantiableHandler extends _deprecated_ModelElementTypeHandler{

	public _deprecated_ModelElementTypeIsInstantiableHandler(TypeResolutionContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean appliesTo(String name, ArrayList<Type> argTypes) {
		// TODO Auto-generated method stub
		return name.equals("isInstantiable") && argTypes.size() == 0;
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
			context.getLogBook().addError(featureCallExpression.getTarget(), "operation isInstantiable() can only be used on ModelElementTypes");
			return null;
		}
		else {
			NameExpression target = (NameExpression) rawTarget;
			if (context.numberOfMetamodelsDefine(target.getName()) > 0) {
				Type rawTargetType = featureCallExpression.getTarget().getResolvedType();
				
				if (!(rawTargetType instanceof ModelElementType)) {
					context.getLogBook().addError(featureCallExpression.getTarget(), "operation isInstantiable() can only be used on ModelElementTypes");
					return null;
				}
				else if (rawTargetType instanceof ModelElementType) {
					result.setContextType(EcoreUtil.copy(contextType));
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
