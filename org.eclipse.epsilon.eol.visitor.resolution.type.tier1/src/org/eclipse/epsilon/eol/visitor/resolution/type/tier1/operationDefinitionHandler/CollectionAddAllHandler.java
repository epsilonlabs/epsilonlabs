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
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.AnalysisInterruptException;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.operationDefinitionUtil.OperationDefinitionManager;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.operationDefinitionUtil.StandardLibraryOperationDefinitionContainer;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeInferenceManager;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeUtil;

public class CollectionAddAllHandler extends CollectionOperationDefinitionHandler{

	@Override
	public boolean appliesTo(String name, Type contextType,
			ArrayList<Type> argTypes) {
		boolean result = true;
		if (name.equals("addAll") && argTypes.size() == 1) {
			if (contextType instanceof CollectionType) {
				
			}
			else if (TypeUtil.getInstance().isInstanceofAnyType(contextType)) {
				if (!TypeInferenceManager.getInstance().containsDynamicType((AnyType) contextType, EolPackage.eINSTANCE.getCollectionType())) {
					result = false;
				}
			}
			else {
				result = false;
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
		
		//if result is not null
		if (result != null) {
			
			//register result as it has been handled
			OperationDefinitionManager.getInstance().registerHandledOperationDefinition(result);

			//get the target
			Expression target = featureCallExpression.getTarget();
			
			//if target is null, report and return
			if (target == null) {
				LogBook.getInstance().addError(featureCallExpression, IMessage_TypeResolution.OPERATION_REQUIRES_TARGET);
				return null;
			}
			

			//if target is collection type
			Type targetType = target.getResolvedType();
			
			//if target type is collection
			if (targetType instanceof CollectionType) {
				//get collection type and get content type
				CollectionType _targetType = (CollectionType) targetType;	
				Type contentType = _targetType.getContentType();
				
				//get the arg type
				Type argType = argTypes.get(0);
				Type argContentType = null;
				
				//if argument is collection
				if (argType instanceof CollectionType) {
					CollectionType _argType = (CollectionType) argType;
					argContentType = _argType.getContentType();
					
					//if content type is any, add the argtype to the content type
					if (TypeUtil.getInstance().isInstanceofAnyType(contentType)) {
						if (TypeUtil.getInstance().isInstanceofAnyType(argContentType)) {
							AnyType _contentType = (AnyType) EcoreUtil.copy(contentType);
							AnyType _argContentType = (AnyType) argContentType;
							
							_contentType.getDynamicTypes().addAll(_argContentType.getDynamicTypes());
							if (target instanceof NameExpression) {
								if (((NameExpression)target).getResolvedContent() != null) {
									if (((NameExpression) target).getResolvedContent() instanceof VariableDeclarationExpression) {
										VariableDeclarationExpression var = (VariableDeclarationExpression) ((NameExpression) target).getResolvedContent();
										TypeResolutionContext.getInstanace().getTypeRegistry().assignType(var, targetType);
									}
								}
							}
							return result;
						}
						else {
							AnyType _contentType = (AnyType) contentType;
							_contentType.getDynamicTypes().add(argContentType);
							if (target instanceof NameExpression) {
								if (((NameExpression)target).getResolvedContent() != null) {
									if (((NameExpression) target).getResolvedContent() instanceof VariableDeclarationExpression) {
										VariableDeclarationExpression var = (VariableDeclarationExpression) ((NameExpression) target).getResolvedContent();
										TypeResolutionContext.getInstanace().getTypeRegistry().assignType(var, targetType);
									}
								}
							}
							return result;
						}
					}
					//if content type is not any, compare with the arg type (argtype is collection now, dont forget)
					else {
						if (TypeUtil.getInstance().isTypeEqualOrGeneric(argContentType, contentType)) {
							return result;
						}
						else {
							LogBook.getInstance().addWarning(argType, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.POTENTIAL_TYPE_MISMATCH, contentType.getClass().getSimpleName()));
							return result;
						}
					}
				}
				//if arg type is any
				else if (TypeUtil.getInstance().isInstanceofAnyType(argType)) {
					
					//get all dyn types that are of type collection
					if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) argType, EolPackage.eINSTANCE.getCollectionType())) {
						
						ArrayList<Type> dynTypes = TypeInferenceManager.getInstance().getDynamicTypes((AnyType) argType, EolPackage.eINSTANCE.getCollectionType());
						
						if (dynTypes.size() > 0) {
							boolean found = false;
							//for all the dynamic types
							for(Type t: dynTypes)
							{
								//cast to collection type and get the arg content type
								CollectionType _argType = (CollectionType) EcoreUtil.copy(t);
								argContentType = _argType.getContentType();
								
								//if target content type is any, add to dynamic types
								if (TypeUtil.getInstance().isInstanceofAnyType(contentType)) {
									if (TypeUtil.getInstance().isInstanceofAnyType(argContentType)) {
										found = true;
										AnyType _contenType = (AnyType) EcoreUtil.copy(contentType);
										AnyType _argContentType = (AnyType) argContentType;
										_contenType.getDynamicTypes().addAll(_argContentType.getDynamicTypes());
									}
									else {
										AnyType _contentType = (AnyType) contentType;
										_contentType.getDynamicTypes().add(argContentType);
									}
									
								}
								else {
									if (TypeUtil.getInstance().isTypeEqualOrGeneric(argContentType, contentType)) {
										found = true;
									}
								}
							}
							
							if (target instanceof NameExpression) {
								if (((NameExpression)target).getResolvedContent() != null) {
									if (((NameExpression) target).getResolvedContent() instanceof VariableDeclarationExpression) {
										VariableDeclarationExpression var = (VariableDeclarationExpression) ((NameExpression) target).getResolvedContent();
										TypeResolutionContext.getInstanace().getTypeRegistry().assignType(var, targetType);
									}
								}
							}
							if (!found) {
								LogBook.getInstance().addWarning(argType, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.POTENTIAL_ARGUMENT_MISMATCH, "addAll(" + TypeUtil.getInstance().getTypeName(targetType) + ")"));
								return result;
							}
							return result;
						}
						else {
							LogBook.getInstance().addWarning(argType, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.POTENTIAL_ARGUMENT_MISMATCH, "addAll(" + TypeUtil.getInstance().getTypeName(targetType) + ")"));
							return result;
						}
					}
					else {
						LogBook.getInstance().addWarning(argType, IMessage_TypeResolution.EXPRESSION_MAY_NOT_BE_COLLECTION_TYPE);
						return result;
					}
				}
				else {
					LogBook.getInstance().addWarning(argType, IMessage_TypeResolution.EXPRESSION_MAY_NOT_BE_COLLECTION_TYPE);
					return result;
				}
			}
			
			//if target is any type
			else if (TypeUtil.getInstance().isInstanceofAnyType(targetType)) {
				//get dynamic types that are collection
				ArrayList<Type> dynTypes = TypeInferenceManager.getInstance().getDynamicTypes((AnyType) targetType, EolPackage.eINSTANCE.getCollectionType());
				//if no collection type found, report and return
				if (dynTypes.size() == 0) {
					LogBook.getInstance().addWarning(targetType, IMessage_TypeResolution.EXPRESSION_MAY_NOT_BE_COLLECTION_TYPE);
					return null;
				}
				//if found collection type
				else if (dynTypes.size() > 0) {
					Type argType = argTypes.get(0);
					//for all types found
					for(Type t: dynTypes)
					{
						//get collection type and get content type
						CollectionType _targetType = (CollectionType) EcoreUtil.copy(t);	
						Type contentType = _targetType.getContentType();
						
						//get the arg type
						Type argContentType = null;
						
						
						if (argType instanceof CollectionType) {
							
							CollectionType _argType = (CollectionType) EcoreUtil.copy(argType);
							argContentType = _argType.getContentType();
							//if content type is any, add the argtype to the content type
							if (TypeUtil.getInstance().isInstanceofAnyType(contentType)) {
								AnyType _contentType = (AnyType) contentType;

								if (TypeUtil.getInstance().isInstanceofAnyType(argContentType)) {
									AnyType _argContentType = (AnyType) EcoreUtil.copy(argContentType);
									_contentType.getDynamicTypes().addAll(_argContentType.getDynamicTypes());
								}
								else {
									_contentType.getDynamicTypes().add(_argType.getContentType());
								}
								
							}
							else {
								if (TypeUtil.getInstance().isTypeEqualOrGeneric(argContentType, contentType)) {
								}
								else {
									LogBook.getInstance().addWarning(argType, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.POTENTIAL_TYPE_MISMATCH, contentType.getClass().getSimpleName()));
								}
							}
						}
						else if (TypeUtil.getInstance().isInstanceofAnyType(argType)) {
							if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) argType, EolPackage.eINSTANCE.getCollectionType())) {
								ArrayList<Type> _dynTypes = TypeInferenceManager.getInstance().getDynamicTypes((AnyType) argType, EolPackage.eINSTANCE.getCollectionType());
								if (_dynTypes.size() > 0) {
									boolean found = false;
									for(Type _t: _dynTypes)
									{
										CollectionType __targetType = (CollectionType) EcoreUtil.copy(_t);
										argContentType = __targetType.getContentType();
										//if target content type is any, add to dynamic types
										if (TypeUtil.getInstance().isInstanceofAnyType(contentType)) {
											AnyType _contentType = (AnyType) contentType;

											if (TypeUtil.getInstance().isInstanceofAnyType(argContentType)) {
												AnyType _argContentType = (AnyType) EcoreUtil.copy(argContentType);
												_contentType.getDynamicTypes().addAll(_argContentType.getDynamicTypes());
											}
											else {
												_contentType.getDynamicTypes().add(((CollectionType)_t).getContentType());
											}
											found = true;
										}
										else {
											if (TypeUtil.getInstance().isTypeEqualOrGeneric(argContentType, contentType)) {
												found = true;
											}
										}
									}
									if (target instanceof NameExpression) {
										if (((NameExpression)target).getResolvedContent() != null) {
											if (((NameExpression) target).getResolvedContent() instanceof VariableDeclarationExpression) {
												VariableDeclarationExpression var = (VariableDeclarationExpression) ((NameExpression) target).getResolvedContent();
												TypeResolutionContext.getInstanace().getTypeRegistry().assignType(var, targetType);
											}
										}
									}
									if (!found) {
										LogBook.getInstance().addWarning(argType, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.POTENTIAL_ARGUMENT_MISMATCH, "addAll(" + TypeUtil.getInstance().getTypeName(t)) + ")");
										return null;
									}
									return result;
								}
								else {
									LogBook.getInstance().addWarning(argType, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.POTENTIAL_ARGUMENT_MISMATCH, "addAll(" + TypeUtil.getInstance().getTypeName(t)) +")");
									return result;
								}
							}
							else {
								LogBook.getInstance().addWarning(argType, IMessage_TypeResolution.EXPRESSION_MAY_NOT_BE_COLLECTION_TYPE);
								return result;
							}
						}
						else {
							LogBook.getInstance().addWarning(argType, IMessage_TypeResolution.EXPRESSION_MAY_NOT_BE_COLLECTION_TYPE);
							return result;
						}
					}
				}
			}
			else {
				LogBook.getInstance().addError(target, IMessage_TypeResolution.EXPRESSION_SHOULD_BE_COLLECTION_TYPE);
			}
		}
		return result;
	}



}