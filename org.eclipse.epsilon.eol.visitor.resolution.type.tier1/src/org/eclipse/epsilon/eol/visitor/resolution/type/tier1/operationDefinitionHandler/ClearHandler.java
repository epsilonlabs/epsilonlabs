package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.operationDefinitionHandler;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.CollectionType;
import org.eclipse.epsilon.eol.metamodel.EolFactory;
import org.eclipse.epsilon.eol.metamodel.EolPackage;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.FeatureCallExpression;
import org.eclipse.epsilon.eol.metamodel.MapType;
import org.eclipse.epsilon.eol.metamodel.MethodCallExpression;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_TypeResolution;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.AnalysisInterruptException;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.operationDefinitionUtil.OperationDefinitionManager;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.operationDefinitionUtil.StandardLibraryOperationDefinitionContainer;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeInferenceManager;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeUtil;

public class ClearHandler extends CollectionOperationDefinitionHandler{

	@Override
	public boolean appliesTo(String name, ArrayList<Type> argTypes) {
		return name.equals("clear") && argTypes.size() == 0;
	}

	@Override
	public OperationDefinition handle(
			FeatureCallExpression featureCallExpression, Type contextType,
			ArrayList<Type> argTypes) throws AnalysisInterruptException {
		
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
				//get the target type copy
				Type targetType = EcoreUtil.copy(target.getResolvedType());
				
				//if target type is null, report and return (this will not happend)
				if (targetType == null) {
					LogBook.getInstance().addError(target, IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
					CollectionType returnType = EolFactory.eINSTANCE.createBagType();
					Type contentType = EolFactory.eINSTANCE.createAnyType();
					returnType.setContentType(contentType);;
					TypeResolutionContext.getInstanace().setAssets(contentType, returnType);
					
					result.setReturnType(returnType);
					return null;
				}
				//if target type is collection type
				if (targetType instanceof CollectionType) {
					CollectionType _targetType = (CollectionType) EcoreUtil.copy(targetType);
					if (TypeUtil.getInstance().isInstanceofAnyType(_targetType.getContentType())) {
						AnyType _contentType = (AnyType) _targetType.getContentType();
						_contentType.getDynamicTypes().clear();
					}
					result.setContextType(EcoreUtil.copy(_targetType));
					result.setReturnType(_targetType);
					return result;
				}
				else if (targetType instanceof MapType) {
					MapType _targetType = (MapType) EcoreUtil.copy(targetType);
					AnyType keyType = _targetType.getKeyType();
					AnyType valueType = _targetType.getValueType();
					keyType.getDynamicTypes().clear();
					valueType.getDynamicTypes().clear();
					
					result.setContextType(EcoreUtil.copy(_targetType));
					result.setReturnType(_targetType);
					return result;
				}
				//else if target type is an instance of any
				else if (TypeUtil.getInstance().isInstanceofAnyType(targetType)) {
					
					boolean notCollection = false;
					boolean notMap = false;
					
					//get dynamic types that are of type collection
					ArrayList<Type> dyntypes = TypeInferenceManager.getInstance().getDynamicTypes((AnyType) targetType, EolPackage.eINSTANCE.getCollectionType());
					//if size is 0, no collection type is found, report and return
					if (dyntypes.size() == 0) {
						notCollection = true;
					}
					else {
						//if size is 1, a collection type is found
						if (dyntypes.size() > 0) {
							CollectionType _targetType = (CollectionType) EcoreUtil.copy(dyntypes.get(0));
							if (TypeUtil.getInstance().isInstanceofAnyType(_targetType.getContentType())) {
								AnyType _contentType = (AnyType) _targetType.getContentType();
								_contentType.getDynamicTypes().clear();
							}
							result.setContextType(EcoreUtil.copy(_targetType));
							result.setReturnType(_targetType);
							return result;
						}
					}
					
					dyntypes = TypeInferenceManager.getInstance().getDynamicTypes((AnyType) targetType, EolPackage.eINSTANCE.getMapType());
					if (dyntypes.size() == 0) {
						notMap = true;
					}
					else {
						//if size is 1, a collection type is found
						if (dyntypes.size() > 0) {
							MapType _targetType = (MapType) EcoreUtil.copy(dyntypes.get(0));
							AnyType keyType = _targetType.getKeyType();
							AnyType valueType = _targetType.getValueType();
							keyType.getDynamicTypes().clear();
							valueType.getDynamicTypes().clear();
							
							result.setContextType(EcoreUtil.copy(_targetType));
							result.setReturnType(_targetType);
							return result;
						}
					}
					
					if (notCollection && notMap) {
						LogBook.getInstance().addError(target, IMessage_TypeResolution.EXPRESSION_SHOULD_BE_COLLECTION_TYPE);
						CollectionType returnType = EolFactory.eINSTANCE.createBagType();
						Type contentType = EolFactory.eINSTANCE.createAnyType();
						returnType.setContentType(contentType);;
						TypeResolutionContext.getInstanace().setAssets(contentType, returnType);
						
						result.setReturnType(returnType);
						return result;
					}
				}
				else {
					LogBook.getInstance().addError(target, IMessage_TypeResolution.EXPRESSION_SHOULD_BE_COLLECTION_TYPE);
					CollectionType returnType = EolFactory.eINSTANCE.createBagType();
					Type contentType = EolFactory.eINSTANCE.createAnyType();
					returnType.setContentType(contentType);;
					TypeResolutionContext.getInstanace().setAssets(contentType, returnType);
					
					result.setReturnType(returnType);
					return null;
				}
			}
		}
		return result;
	}

}
