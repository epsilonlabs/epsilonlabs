package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.operationDefinitionHandler;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.CollectionType;
import org.eclipse.epsilon.eol.metamodel.EolPackage;
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

public class AddHandler extends CollectionOperationDefinitionHandler{

	@Override
	public boolean appliesTo(String name, ArrayList<Type> argTypes) {
		return name.equals("add") && argTypes.size() == 1;
	}

	@Override
	public OperationDefinition handle(
			FeatureCallExpression featureCallExpression, Type contextType,
			ArrayList<Type> argTypes) {
		//get the manager
		StandardLibraryOperationDefinitionContainer manager = OperationDefinitionManager.getInstance().getStandardLibraryOperationDefinitionContainer();
		
		//get the result
		OperationDefinition result = manager.getOperation(((MethodCallExpression) featureCallExpression).getMethod().getName(), argTypes);
		
		//if result is not null
		if (result != null) {
			
			//register the result as it has been handled
			OperationDefinitionManager.getInstance().registerHandledOperationDefinition(result);

			//get the target
			Expression target = featureCallExpression.getTarget();
			
			//if target is null, report and return
			if (target == null) {
				LogBook.getInstance().addError(featureCallExpression, IMessage_TypeResolution.OPERATION_REQUIRES_TARGET);
				return null;
			}
			else {
				
				//get the target type
				Type targetType = target.getResolvedType();
				
				//if target type is null, report and return
				if (targetType == null) {
					LogBook.getInstance().addError(target, IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
					return null;
				}
				//if target type is collection type
				if (targetType instanceof CollectionType) {
					
					//get the content type and arg type
					Type contentType = ((CollectionType)targetType).getContentType();
					Type argType = argTypes.get(0);
					
					//if content type is any
					if (TypeUtil.getInstance().isInstanceofAnyType(contentType)) {
						//get the copy of the content type
						AnyType ct = (AnyType) EcoreUtil.copy(contentType);
						//if the dynamic types does not contain the arg type, add the type to the dynamic types and register resolved content
						if (!TypeInferenceManager.getInstance().containsDynamicType(ct, argType.eClass())) {
							ct.getDynamicTypes().add(EcoreUtil.copy(argType));
							if (target instanceof NameExpression) {
								if (((NameExpression) target).getResolvedContent() instanceof VariableDeclarationExpression) {
									VariableDeclarationExpression var = (VariableDeclarationExpression) ((NameExpression) target).getResolvedContent();
									TypeResolutionContext.getInstanace().getTypeRegistry().assignType(var, ct);
								}
							}
						}
					}
					//if content type is not any, compare content type with the arg type and report if necessary
					else {
						if(!TypeUtil.getInstance().isTypeEqualOrGeneric(argType, contentType))
						{
							LogBook.getInstance().addWarning(argType, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.POTENTIAL_TYPE_MISMATCH, contentType.getClass().getSimpleName()));
							return null;
						}
					}
				}
				//else if target type is an instance of any
				else if (TypeUtil.getInstance().isInstanceofAnyType(targetType)) {
					//get dynamic types that are of type collection
					ArrayList<Type> dyntypes = TypeInferenceManager.getInstance().getDynamicTypes((AnyType) targetType, EolPackage.eINSTANCE.getCollectionType());
					//if size is 0, no collection type is found, report and return
					if (dyntypes.size() == 0) {
						LogBook.getInstance().addError(target, IMessage_TypeResolution.EXPRESSION_SHOULD_BE_COLLECTION_TYPE);
						return null;
					}
					else {
						//if size is 1, a collection type is found
						if (dyntypes.size() == 1) {
							
							//get the collection type and the content type and the arg type
							CollectionType collectionType = (CollectionType) dyntypes.get(0);
							Type contentType = collectionType.getContentType();
							Type argType = argTypes.get(0);
							
							//if contenttype is any and arg type is any, check if there are any common types
							if (TypeUtil.getInstance().isInstanceofAnyType(contentType) && TypeUtil.getInstance().isInstanceofAnyType(argType)) {
								if (TypeInferenceManager.getInstance().getCommonTypesForTwoAnys((AnyType)contentType, (AnyType)argType).size() == 0) {
									for(Type t: ((AnyType)argType).getDynamicTypes())
									{
										((AnyType)contentType).getDynamicTypes().add(EcoreUtil.copy(t));
									}
									//LogBook.getInstance().addWarning(argType, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.POTENTIAL_TYPE_MISMATCH, contentType.getClass().getSimpleName()));
									return null;
								}
							}
							//if content type is any, but arg type is not
							else if (TypeUtil.getInstance().isInstanceofAnyType(contentType)) {
								AnyType ct = (AnyType) EcoreUtil.copy(contentType);
								if (!TypeInferenceManager.getInstance().containsDynamicType(ct, argType.eClass())) {
									ct.getDynamicTypes().add(EcoreUtil.copy(argType));
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
						return null;
					}
				}
				else {
					LogBook.getInstance().addError(target, IMessage_TypeResolution.EXPRESSION_SHOULD_BE_COLLECTION_TYPE);
					return null;
				}
			}
		}
		return result;
	}

}
