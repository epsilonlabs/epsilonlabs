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
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeInferenceManager;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeUtil;

public class IncludingAllHandler extends CollectionOperationDefinitionHandler{

	@Override
	public boolean appliesTo(String name, ArrayList<Type> argTypes) {
		return name.equals("includingAll") && argTypes.size() == 1;
	}

	@Override
	public OperationDefinition handle(
			FeatureCallExpression featureCallExpression, Type contextType,
			ArrayList<Type> argTypes) {
		
		OperationDefinition result = OperationDefinitionManager.getInstance().getStandardLibraryOperationDefinitionContainer().getOperation(((MethodCallExpression) featureCallExpression).getMethod().getName(), argTypes);
		
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
					Type argContentType = null;
					
					if (!(argType instanceof CollectionType)) {
						LogBook.getInstance().addError(argType, IMessage_TypeResolution.EXPRESSION_SHOULD_BE_COLLECTION_TYPE);
					}
					else {
						argContentType = ((CollectionType)argType).getContentType();
					}
					
					
					
					if (TypeUtil.getInstance().isInstanceofAnyType(contentType)) {
						AnyType ct = (AnyType) EcoreUtil.copy(contentType);
						if (TypeUtil.getInstance().isInstanceofAnyType(argContentType)) {
							for(Type t: ((AnyType)argContentType).getDynamicTypes())
							{
								if (!TypeInferenceManager.getInstance().containsDynamicType(ct, t.eClass())) {
									ct.getDynamicTypes().add(EcoreUtil.copy(argType));
									
								}
							}
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
						if(!TypeUtil.getInstance().isTypeEqualOrGeneric(argType, argContentType))
						{
							LogBook.getInstance().addError(argType, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPECTED_CONTENT_TYPE, argContentType.getClass().getSimpleName()));
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
