package org.eclipse.epsilon.eol.dom.visitor.resolution.type.operationDefinitionHandler;

import java.util.ArrayList;
import java.util.jar.Attributes.Name;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.dom.CollectionType;
import org.eclipse.epsilon.eol.dom.FeatureCallExpression;
import org.eclipse.epsilon.eol.dom.MethodCallExpression;
import org.eclipse.epsilon.eol.dom.ModelElementType;
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
		
		OperationDefinition result = container.getOperation(((MethodCallExpression) featureCallExpression).getMethod().getName(), argTypes);

		if (!(featureCallExpression.getTarget().getResolvedType() instanceof ModelElementType)) {
			context.getLogBook().addError(featureCallExpression.getTarget(), "operation " + ((MethodCallExpression)featureCallExpression).getMethod().getName() + "() can only be used on ModelElementTypes");
		}
		result.setContextType(EcoreUtil.copy(contextType));
		
		CollectionType returnType = (CollectionType) result.getReturnType();
		((SetType)returnType).setContentType(EcoreUtil.copy(contextType));
		
		return result;
	}

}
