package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.operationDefinitionHandler;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.CollectionType;
import org.eclipse.epsilon.eol.metamodel.EolPackage;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.FeatureCallExpression;
import org.eclipse.epsilon.eol.metamodel.MethodCallExpression;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_TypeResolution;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.operationDefinitionUtil.OperationDefinitionManager;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.operationDefinitionUtil.StandardLibraryOperationDefinitionContainer;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeInferenceManager;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeUtil;

public class AddAllHandler extends CollectionOperationDefinitionHandler{

	@Override
	public boolean appliesTo(String name, ArrayList<Type> argTypes) {
		return name.equals("addAll") && argTypes.size() == 1;
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
			
			//register result as it has been handled
			OperationDefinitionManager.getInstance().registerHandledOperationDefinition(result);

			//get the target
			Expression target = featureCallExpression.getTarget();
			
			//if target is null, report and return
			if (target == null) {
				LogBook.getInstance().addError(featureCallExpression, IMessage_TypeResolution.OPERATION_REQUIRES_TARGET);
				return null;
			}
			else {
				//if target is collection type
				Type targetType = target.getResolvedType();
				
				//if target type is collection
				if (targetType instanceof CollectionType) {
					//get collection type and get content type
					CollectionType collectionType = (CollectionType) targetType;	
					Type contentType = collectionType.getContentType();
					
					//get the arg type
					Type argType = argTypes.get(0);
					Type argContentType = null;
					
					
					if (argType instanceof CollectionType) {
						CollectionType _argType = (CollectionType) argType;
						argContentType = _argType.getContentType();
						if (TypeUtil.getInstance().isTypeEqualOrGeneric(argContentType, contentType)) {
							return null;
						}
						else {
							LogBook.getInstance().addWarning(argType, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.POTENTIAL_TYPE_MISMATCH, contentType.getClass().getSimpleName()));
							return null;
						}
					}
					else if (TypeUtil.getInstance().isInstanceofAnyType(argType)) {
						if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) argType, EolPackage.eINSTANCE.getCollectionType())) {
							ArrayList<Type> dynTypes = TypeInferenceManager.getInstance().getDynamicTypes((AnyType) argType, EolPackage.eINSTANCE.getCollectionType());
							if (dynTypes.size() > 0) {
								boolean found = false;
								for(Type t: dynTypes)
								{
									CollectionType collectionType2 = (CollectionType) t;
									argContentType = collectionType2.getContentType();
									if (TypeUtil.getInstance().isTypeEqualOrGeneric(argContentType, contentType)) {
										found = true;
									}
								}
								if (!found) {
									LogBook.getInstance().addWarning(argType, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.POTENTIAL_ARGUMENT_MISMATCH, "addAll(" + TypeUtil.getInstance().getTypeName(targetType) + ")"));
									return null;
								}
								return null;
							}
							else {
								LogBook.getInstance().addWarning(argType, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.POTENTIAL_ARGUMENT_MISMATCH, "addAll(" + TypeUtil.getInstance().getTypeName(targetType) + ")"));
								return null;
							}
						}
						else {
							LogBook.getInstance().addWarning(argType, IMessage_TypeResolution.EXPRESSION_MAY_NOT_BE_COLLECTION_TYPE);
							return null;
						}
					}
					else {
						LogBook.getInstance().addWarning(argType, IMessage_TypeResolution.EXPRESSION_MAY_NOT_BE_COLLECTION_TYPE);
						return null;
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
							CollectionType collectionType = (CollectionType) t;	
							Type contentType = collectionType.getContentType();
							
							//get the arg type
							Type argContentType = null;
							
							
							if (argType instanceof CollectionType) {
								CollectionType _argType = (CollectionType) argType;
								argContentType = _argType.getContentType();
								if (TypeUtil.getInstance().isTypeEqualOrGeneric(argContentType, contentType)) {
									return null;
								}
								else {
									LogBook.getInstance().addWarning(argType, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.POTENTIAL_TYPE_MISMATCH, contentType.getClass().getSimpleName()));
									return null;
								}
							}
							else if (TypeUtil.getInstance().isInstanceofAnyType(argType)) {
								if (TypeInferenceManager.getInstance().containsDynamicType((AnyType) argType, EolPackage.eINSTANCE.getCollectionType())) {
									ArrayList<Type> _dynTypes = TypeInferenceManager.getInstance().getDynamicTypes((AnyType) argType, EolPackage.eINSTANCE.getCollectionType());
									if (_dynTypes.size() > 0) {
										boolean found = false;
										for(Type _t: _dynTypes)
										{
											CollectionType collectionType2 = (CollectionType) _t;
											argContentType = collectionType2.getContentType();
											if (TypeUtil.getInstance().isTypeEqualOrGeneric(argContentType, contentType)) {
												found = true;
											}
										}
										if (!found) {
											LogBook.getInstance().addWarning(argType, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.POTENTIAL_ARGUMENT_MISMATCH, "addAll(" + TypeUtil.getInstance().getTypeName(t)) + ")");
											return null;
										}
										return null;
									}
									else {
										LogBook.getInstance().addWarning(argType, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.POTENTIAL_ARGUMENT_MISMATCH, "addAll(" + TypeUtil.getInstance().getTypeName(t)) +")");
										return null;
									}
								}
								else {
									LogBook.getInstance().addWarning(argType, IMessage_TypeResolution.EXPRESSION_MAY_NOT_BE_COLLECTION_TYPE);
									return null;
								}
							}
							else {
								LogBook.getInstance().addWarning(argType, IMessage_TypeResolution.EXPRESSION_MAY_NOT_BE_COLLECTION_TYPE);
								return null;
							}
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
