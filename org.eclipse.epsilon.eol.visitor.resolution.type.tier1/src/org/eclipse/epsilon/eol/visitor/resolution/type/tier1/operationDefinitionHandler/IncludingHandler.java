package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.operationDefinitionHandler;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.CollectionType;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.FeatureCallExpression;
import org.eclipse.epsilon.eol.metamodel.MethodCallExpression;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_TypeResolution;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.operationDefinitionUtil.OperationDefinitionManager;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.operationDefinitionUtil.StandardLibraryOperationDefinitionContainer;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeInferenceManager;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeUtil;

public class IncludingHandler extends CollectionOperationDefinitionHandler{

	@Override
	public boolean appliesTo(String name, ArrayList<Type> argTypes) {
		return name.equals("including") && argTypes.size() == 1;
	}

	@Override
	public OperationDefinition handle(
			FeatureCallExpression featureCallExpression, Type contextType,
			ArrayList<Type> argTypes) {
		StandardLibraryOperationDefinitionContainer manager = OperationDefinitionManager.getInstance().getStandardLibraryOperationDefinitionContainer();
		
		OperationDefinition result = manager.getOperation(((MethodCallExpression) featureCallExpression).getMethod().getName(), argTypes);
		
		if (result != null) {
			
			OperationDefinitionManager.getInstance().registerHandledOperationDefinition(result);

			Expression target = featureCallExpression.getTarget();
			if (target == null) {
				LogBook.getInstance().addError(featureCallExpression, IMessage_TypeResolution.OPERATION_REQUIRES_TARGET);
			}
			else {
				if (target.getResolvedType() instanceof CollectionType) {
					CollectionType targetType = (CollectionType) target.getResolvedType();	
					Type contentType = targetType.getContentType();
					
					Type argType = argTypes.get(0);
					
					if (TypeUtil.getInstance().isInstanceofAnyType(contentType)) {
						AnyType ct = (AnyType) EcoreUtil.copy(contentType);
						if (!TypeInferenceManager.getInstance().containsDynamicType(ct, argType.eClass())) {
							ct.getDynamicTypes().add(EcoreUtil.copy(argType));
							
							result.setReturnType(EcoreUtil.copy(ct));
							
							
							if (target instanceof NameExpression) {
								if (((NameExpression) target).getResolvedContent() instanceof VariableDeclarationExpression) {
									VariableDeclarationExpression var = (VariableDeclarationExpression) ((NameExpression) target).getResolvedContent();
									TypeResolutionContext.getInstanace().getTypeRegistry().assignType(var, ct);
								}
							}
						}
					}
					else {
						if(!TypeUtil.getInstance().isTypeEqualOrGeneric(argType, contentType))
						{
							LogBook.getInstance().addError(argType, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPECTED_TYPE, contentType.getClass().getSimpleName()));
						}
					}
				}
				else {
					LogBook.getInstance().addError(target, IMessage_TypeResolution.EXPRESSION_SHOULD_BE_COLLECTION_TYPE);
				}
				
			}
		}
		
		return result;
	}

}
