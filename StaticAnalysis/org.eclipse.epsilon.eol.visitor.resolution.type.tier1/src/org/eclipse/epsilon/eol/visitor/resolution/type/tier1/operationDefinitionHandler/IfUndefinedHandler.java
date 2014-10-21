package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.operationDefinitionHandler;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.operationDefinitionUtil.StandardLibraryOperationDefinitionContainer;

public class IfUndefinedHandler extends AnyOperationDefinitionHandler{

	public IfUndefinedHandler(TypeResolutionContext context) {
		super(context);
	}

	@Override
	public boolean appliesTo(String name, ArrayList<Type> argTypes) {
		return name.equals("ifUndefined") && argTypes.size() == 1;
	}

	@Override
	public OperationDefinition handle(
			FeatureCallExpression featureCallExpression, Type contextType,
			ArrayList<Type> argTypes) {
		StandardLibraryOperationDefinitionContainer container = context.getOperationDefinitionControl().getStandardLibraryOperationDefinitionContainer();
		
		OperationDefinition result = container.getOperation(((MethodCallExpression) featureCallExpression).getMethod().getName(), argTypes);
		
		Expression target = (Expression) featureCallExpression.getTarget(); //may not be only a name expression
		if (target instanceof NameExpression) {
			if (((NameExpression)target).getResolvedContent() != null) {
				result.setReturnType(EcoreUtil.copy(((NameExpression) target).getResolvedType()));
			}
			else {
				result.setReturnType(EcoreUtil.copy(argTypes.get(0)));
			}
		}
		return result;
	}



}
