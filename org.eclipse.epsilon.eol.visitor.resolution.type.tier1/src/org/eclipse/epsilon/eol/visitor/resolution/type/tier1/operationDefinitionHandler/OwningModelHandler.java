package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.operationDefinitionHandler;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.EolFactory;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.FeatureCallExpression;
import org.eclipse.epsilon.eol.metamodel.IModel;
import org.eclipse.epsilon.eol.metamodel.MethodCallExpression;
import org.eclipse.epsilon.eol.metamodel.ModelElementType;
import org.eclipse.epsilon.eol.metamodel.ModelType;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_TypeResolution;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.operationDefinitionUtil.OperationDefinitionManager;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.operationDefinitionUtil.StandardLibraryOperationDefinitionContainer;

public class OwningModelHandler extends AnyOperationDefinitionHandler{

	@Override
	public boolean appliesTo(String name, ArrayList<Type> argTypes) {
		return name.equals("owningModel") && argTypes.size() == 0;
	}

	@Override
	public OperationDefinition handle(
			FeatureCallExpression featureCallExpression, Type contextType,
			ArrayList<Type> argTypes) {
		
		StandardLibraryOperationDefinitionContainer manager = OperationDefinitionManager.getInstance().getStandardLibraryOperationDefinitionContainer();
		
		OperationDefinition result = manager.getOperation(((MethodCallExpression) featureCallExpression).getMethod().getName(), argTypes);
		
		Expression target = (Expression) featureCallExpression.getTarget(); //may not be only a name expression
		if (target == null) {
			LogBook.getInstance().addError(featureCallExpression, IMessage_TypeResolution.OPERATION_REQUIRES_TARGET);
		}
		else {
			if (target.getResolvedType() instanceof ModelElementType) {
				ModelElementType targetType = (ModelElementType) target.getResolvedType();
				IModel iModel = targetType.getResolvedIModel();
				if (iModel != null) {
					ModelType modelType = EolFactory.eINSTANCE.createModelType();
					modelType.setResolvedIModel(iModel);
					TypeResolutionContext.getInstanace().copyLocation(modelType, featureCallExpression);
					featureCallExpression.setResolvedType(EcoreUtil.copy(modelType));
					result.setReturnType(EcoreUtil.copy(modelType));
					return result;
				}
				else {
					LogBook.getInstance().addError(target, IMessage_TypeResolution.TYPE_CANNOT_BE_RESOLVED);
				}
			}
			else {
				LogBook.getInstance().addError(target, IMessage_TypeResolution.EXPRESSION_SHOULD_BE_MODELELEMENT_TYPE);
			}

		}
		return result;

	}

}
