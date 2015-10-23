package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.operationDefinitionHandler;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.BagType;
import org.eclipse.epsilon.eol.metamodel.EolFactory;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.FeatureCallExpression;
import org.eclipse.epsilon.eol.metamodel.MethodCallExpression;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_TypeResolution;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.AnalysisInterruptException;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.operationDefinitionUtil.OperationDefinitionManager;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.operationDefinitionUtil.StandardLibraryOperationDefinitionContainer;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeUtil;

public class AnyAsBagHandler extends AnyOperationDefinitionHandler{

	@Override
	public boolean appliesTo(String name, Type contextType,
			ArrayList<Type> argTypes) {
		boolean result = true;
		if (name.equals("asBag")  && argTypes.size() == 0) {
			if (contextType instanceof AnyType) {
				return true;
			}
		}
		return result;
	}

	@Override
	public OperationDefinition handle(
			FeatureCallExpression featureCallExpression, Type contextType,
			ArrayList<Type> argTypes) throws AnalysisInterruptException {
		
		//get the manager
		StandardLibraryOperationDefinitionContainer manager = OperationDefinitionManager.getInstance().getStandardLibraryOperationDefinitionContainer();
				
		//get the result
		OperationDefinition result = manager.getOperation(((MethodCallExpression) featureCallExpression).getMethod().getName(), argTypes);
		
		if (result != null) {
			
			Expression target = featureCallExpression.getTarget();
			
			if (target == null) {
				LogBook.getInstance().addError(featureCallExpression, IMessage_TypeResolution.OPERATION_REQUIRES_TARGET);
				BagType returnType = EolFactory.eINSTANCE.createBagType();
				AnyType contentType = EolFactory.eINSTANCE.createAnyType();
				returnType.setContentType(contentType);
				result.setReturnType(returnType);
				return result;
			}
			
			AnyType targetType = (AnyType) EcoreUtil.copy(target.getResolvedType());
			if (targetType == null) {
				LogBook.getInstance().addError(target, IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
				BagType returnType = EolFactory.eINSTANCE.createBagType();
				AnyType contentType = EolFactory.eINSTANCE.createAnyType();
				returnType.setContentType(contentType);
				result.setReturnType(returnType);
				return result;
			}
			
			
			BagType returnType = EolFactory.eINSTANCE.createBagType();
			AnyType contentType = EolFactory.eINSTANCE.createAnyType();
			if (TypeUtil.getInstance().isInstanceofAnyType(targetType)) {
				contentType.getDynamicTypes().addAll(targetType.getDynamicTypes());
			}
			else {
				contentType.getDynamicTypes().add(targetType);
			}
			returnType.setContentType(contentType);
			result.setReturnType(returnType);
			return result;
		}
		return result;
	}

}
