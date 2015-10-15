package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;


import java.util.ArrayList;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.analysis.model.driver.IPackageDriver;
import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.CollectionType;
import org.eclipse.epsilon.eol.metamodel.EolFactory;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.ModelElementType;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.PropertyCallExpression;
import org.eclipse.epsilon.eol.metamodel.SelfContentType;
import org.eclipse.epsilon.eol.metamodel.SelfType;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.PropertyCallExpressionVisitor;
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_TypeResolution;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.operationDefinitionUtil.OperationDefinitionManager;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeInferenceManager;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeUtil;

public class PropertyCallExpressionTypeResolver extends PropertyCallExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(PropertyCallExpression propertyCallExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		Expression target = propertyCallExpression.getTarget(); //get the target
		controller.visit(target, context); //visit the target first
		
		Type targetType = target.getResolvedType();
		
		TypeUtil typeUtil = TypeUtil.getInstance();
		TypeInferenceManager typeInferenceManager = TypeInferenceManager.getInstance();
		
		NameExpression property = propertyCallExpression.getProperty();
		String propertyString = property.getName();
		
		if (propertyCallExpression.isExtended()) {
			AnyType anyType = EolFactory.eINSTANCE.createAnyType(); //create an anyType
			context.setAssets(anyType, propertyCallExpression); //set assets
			propertyCallExpression.setResolvedType(anyType); //assign type
			
			context.getLogBook().addWarning(propertyCallExpression.getProperty(), "property is an Extended property, expression type is set to Any");
			return null;
		}
		
		
		//if the target is of any type, find the leat common type first, then find property, if no common type found, find property that applies to the first model element type
		if (typeUtil.isInstanceofAnyType(targetType)) {// or the target is of type Any
			//AnyType tempAnyType = (AnyType) propertyCallExpression.getTarget().getResolvedType();
			if (target instanceof NameExpression) {
				
				//get the target
				NameExpression theTarget = (NameExpression) target;
				//get the resolved content
				Object resolvedContent = theTarget.getResolvedContent();
				//if resolved content is not null and is a variable declaration
				if (resolvedContent != null && resolvedContent instanceof VariableDeclarationExpression) {
					//get the inferred types
					ArrayList<Type> types = context.getTypeRegistry().getTypesForVariable((VariableDeclarationExpression) resolvedContent);
					//infer the types to get a least common type
					Type inferredType = typeInferenceManager.getLeastCommonTypeFromTypes(types);
					//if inferred type is not null
					if (inferredType != null) {
						//if inferred type is a model element type
						if (inferredType instanceof ModelElementType) {
							ModelElementType met = (ModelElementType) inferredType;
							IPackageDriver iPackageDriver = (IPackageDriver) met.getResolvedIPackage().getIPackageDriver();
							if (iPackageDriver.containsFeature(met.getElementName(), propertyString)) {
								targetType = inferredType;
							}
							else {
								targetType = inferredType;
//								propertyCallExpression.setResolvedType(EolFactory.eINSTANCE.createAnyType());
//								context.getLogBook().addWarning(propertyCallExpression.getTarget(), "Potentially unsafe typing");
//								return null;
							}
						}
						else if (inferredType instanceof CollectionType) {
							Type contentType = ((CollectionType)inferredType).getContentType();
							if (contentType instanceof ModelElementType) {
								ModelElementType met = (ModelElementType) contentType;
								IPackageDriver iPackageDriver = (IPackageDriver) met.getResolvedIPackage().getIPackageDriver();
								if (iPackageDriver.containsFeature(met.getElementName(), propertyString)) {
									targetType = inferredType;
								}
								else {
									targetType = inferredType;

//									propertyCallExpression.setResolvedType(EolFactory.eINSTANCE.createAnyType());
//									context.getLogBook().addWarning(propertyCallExpression.getTarget(), "Potentially unsafe typing");
//									return null;
								}
							}
							else {
								if (isKeyword(propertyString)) {
									targetType = inferredType;
								}
								else {
									propertyCallExpression.setResolvedType(EolFactory.eINSTANCE.createAnyType());
									context.getLogBook().addWarning(propertyCallExpression.getTarget(), "Potentially unsafe typing");
									return null;	
								}
							}
						}
						else {
							propertyCallExpression.setResolvedType(EolFactory.eINSTANCE.createAnyType());
							context.getLogBook().addWarning(propertyCallExpression.getTarget(), "Potentially unsafe typing");
							return null;
						}
					}
					else {
						propertyCallExpression.setResolvedType(EolFactory.eINSTANCE.createAnyType());
						context.getLogBook().addWarning(propertyCallExpression.getTarget(), "Potentially unsafe typing");
						return null;
					}
				}
				else {
					propertyCallExpression.setResolvedType(EolFactory.eINSTANCE.createAnyType());
					context.getLogBook().addWarning(propertyCallExpression.getTarget(), "Potentially unsafe typing");
					return null;
				}
			}
		}

		//if the property is an extended property, then the type of the call should be Any
		//if the type of the target is of Type Any, then the TypeResolver also assumes that the property is of type Any
		//System.err.println(propertyCallExpression.getProperty().getName());
		if (isKeyword(propertyCallExpression.getProperty().getName())) {
			handleKeywords(propertyCallExpression, context);
			return null;
		}
		else 
		{ //if the property is not an extended property and the target type is not of type Any
			if(targetType instanceof ModelElementType) //if the target type is ModelElementType
			{
				ModelElementType modelElementType = (ModelElementType) targetType; //get the type
				
				//String modelString = modelElementType.getModelName();
				String elementString = modelElementType.getElementName();
				
				IPackageDriver ipd = (IPackageDriver) modelElementType.getResolvedIPackage().getIPackageDriver();
				if (ipd != null) {
					if (!ipd.containsFeature(elementString, propertyString)) {
						LogBook.getInstance().addError(propertyCallExpression.getProperty(), IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.ELEMENT_DOES_NOT_CONTAIN_PROPERTY, elementString, propertyString));
						propertyCallExpression.setResolvedType(EolFactory.eINSTANCE.createAnyType());
					}
					else {
						EStructuralFeature feature = ipd.getFeature(elementString, propertyString); //get the property 
						
						propertyCallExpression.getProperty().setResolvedContent(feature); //set the resolved content for the property
						
						if (feature.getUpperBound() != 1) { //this means that the feature is a many value aggregation
							Type contentType = null; //each collection type needs a content type
							CollectionType callType = null; //prepare the callType
							
							EClassifier propertyType = ipd.getTypeForFeature(elementString, propertyString); //get the type for the property
							
							if (context.getTypeUtil().isEDataType(propertyType)) {//if type is EDataType
								if(context.getTypeUtil().isNormalisable(propertyType)){ //if type is normalisable
									contentType = context.getTypeUtil().normalise(propertyType); //normalise and assign type to contentType
								}
								else { //if type is not normalisable
									contentType = EolFactory.eINSTANCE.createModelElementType(); //create a EType and assign it to contentType
									((ModelElementType)contentType).setModelType(propertyType);
								}
							}
							else { //if type is not EDatatype
								contentType = EolFactory.eINSTANCE.createModelElementType(); //assign a ModelElementType to contentType 
								((ModelElementType) contentType).setModelType(propertyType); //setEcoreType
								((ModelElementType) contentType).setModelName(ipd.getPackageName()); //model name
								((ModelElementType) contentType).setElementName(propertyType.getName()); //element name
							}

				
							
							if (feature.isOrdered() && feature.isUnique()) { //if feature is ordered and unique
								callType = EolFactory.eINSTANCE.createOrderedSetType(); //this should be ordered set
							}
							else if (feature.isOrdered() && !feature.isUnique()) { //if feature is ordered but not unique
								callType = EolFactory.eINSTANCE.createSequenceType(); //this should be a sequence
							}
							else if (!feature.isOrdered() && feature.isUnique()) {//if feature is unordered and unique
								callType = EolFactory.eINSTANCE.createSetType();  //this should be a set
							}
							else if (!feature.isOrdered() && !feature.isUnique()) {//if feature is unordered and non-unique
								callType = EolFactory.eINSTANCE.createBagType(); //this should be a bag
							}
							
							callType.setContentType(EcoreUtil.copy(contentType));
							//context.setAssets(contentType, callType); //set assets for contentType
							
							Type typeCopy = EcoreUtil.copy(callType);
							propertyCallExpression.getProperty().setResolvedType(typeCopy);
							context.setAssets(typeCopy, propertyCallExpression.getProperty());
							
							
							propertyCallExpression.setResolvedType(typeCopy);
							context.setAssets(typeCopy, propertyCallExpression); //set assets for callType
							
						}
						else { //if the feature is single value aggregation
							
							EClassifier propertyType = ipd.getTypeForFeature(elementString, propertyString); //get property
							if (context.getTypeUtil().isEDataType(propertyType)) { //if property is data type
								if(context.getTypeUtil().isNormalisable(propertyType)){ //if the data type is normalisable
									Type type = context.getTypeUtil().normalise(propertyType);
									propertyCallExpression.getProperty().setResolvedType(type);
									context.setAssets(type, propertyCallExpression.getProperty());
									
									Type typeCopy = EcoreUtil.copy(type);
									propertyCallExpression.setResolvedType(typeCopy);
									context.setAssets(typeCopy, propertyCallExpression);
								}
								else { //if the data type is not normalisable
									ModelElementType eType = EolFactory.eINSTANCE.createModelElementType();
									eType.setModelType(propertyType);
									propertyCallExpression.getProperty().setResolvedType(eType);
									context.setAssets(eType, propertyCallExpression.getProperty());
									
									Type typeCopy = EcoreUtil.copy(eType);
									propertyCallExpression.setResolvedType(typeCopy);
									context.setAssets(typeCopy, propertyCallExpression);
								}
							}
							else { //if the property is not data type, then it should be model element type
								ModelElementType callType = EolFactory.eINSTANCE.createModelElementType();
								callType.setModelType(propertyType);
								callType.setModelName(ipd.getPackageName());
								callType.setElementName(propertyType.getName());
								propertyCallExpression.getProperty().setResolvedType(callType);
								context.setAssets(callType, propertyCallExpression.getProperty());
								
								Type typeCopy = EcoreUtil.copy(callType);
								propertyCallExpression.setResolvedType(typeCopy);
								context.setAssets(typeCopy, propertyCallExpression);
							}
						}
					
					}
				}
			
				
			}
			else {
				if (targetType instanceof CollectionType) { //if target is of type CollectionType
					CollectionType rawCollectionType = (CollectionType) targetType; //prepare collection type
					
					CollectionType rawResultType = EcoreUtil.copy(rawCollectionType);
					
					if (getInnermostType(rawCollectionType) instanceof ModelElementType) 
					{ //if contentType is ModelElementType
						
						ModelElementType resultContentType = (ModelElementType) getInnermostType(rawCollectionType); //prepare result content type
						IPackageDriver ipd = (IPackageDriver) resultContentType.getResolvedIPackage().getIPackageDriver();
						if(ipd != null) //if meta model exists
						{
							String elementString = resultContentType.getElementName(); //get metaclass string
							
							if(ipd.containsFeature(elementString, propertyString)) //if metamode class contains the property
							{
								EStructuralFeature feature = ipd.getFeature(elementString, propertyString); //get the property 
								propertyCallExpression.getProperty().setResolvedContent(feature); //set the resolved content for the property

								if (feature.getUpperBound() != 1) { //this means that the feature is a many value aggregation
									Type contentType = null; //each collection type needs a content type
									CollectionType callType = null; //prepare the callType
									
									EClassifier propertyType = ipd.getTypeForFeature(elementString, propertyString); //get the type for the property
									if (context.getTypeUtil().isEDataType(propertyType)) { //if type is EDataType
										if(context.getTypeUtil().isNormalisable(propertyType)){ //if type is normalisable
											contentType = context.getTypeUtil().normalise(propertyType); //normalise and assign type to contentType
										}
										else { //if type is not normalisable
											contentType = EolFactory.eINSTANCE.createModelElementType();
											((ModelElementType) contentType).setModelType(propertyType); //assign the EDataType to EType
										}
									}
									else { //if type is not EDatatype
										contentType = EolFactory.eINSTANCE.createModelElementType(); //assign a ModelElementType to contentType 
										((ModelElementType) contentType).setModelType(propertyType); //setEcoreType
										((ModelElementType) contentType).setModelName(ipd.getPackageName()); //model name
										((ModelElementType) contentType).setElementName(propertyType.getName()); //element name
									}

						
									
									if (feature.isOrdered() && feature.isUnique()) { //if feature is ordered and unique
										callType = EolFactory.eINSTANCE.createOrderedSetType(); //this should be ordered set
									}
									else if (feature.isOrdered() && !feature.isUnique()) { //if feature is ordered but not unique
										callType = EolFactory.eINSTANCE.createSequenceType(); //this should be a sequence
									}
									else if (!feature.isOrdered() && feature.isUnique()) {//if feature is unordered and unique
										callType = EolFactory.eINSTANCE.createSetType();  //this should be a set
									}
									else if (!feature.isOrdered() && !feature.isUnique()) {//if feature is unordered and non-unique
										callType = EolFactory.eINSTANCE.createBagType(); //this should be a bag
									}
									
									callType.setContentType(contentType);
									context.setAssets(contentType, callType); //set assets for contentType
									
									Type typeCopy = EcoreUtil.copy(callType);
									propertyCallExpression.getProperty().setResolvedType(typeCopy);
									context.setAssets(typeCopy, propertyCallExpression.getProperty());
									
									rawResultType.setContentType(callType);
									context.setAssets(callType, rawResultType);
									
									propertyCallExpression.setResolvedType(rawResultType);
									context.setAssets(rawResultType, propertyCallExpression); //set assets for callType
									
								}
								else { //if the feature is single value aggregation
									
									EClassifier propertyType = ipd.getTypeForFeature(elementString, propertyString); //get property
									if (context.getTypeUtil().isEDataType(propertyType)) { //if property is data type
										if(context.getTypeUtil().isNormalisable(propertyType)){ //if the data type is normalisable
											Type type = context.getTypeUtil().normalise(propertyType);
											propertyCallExpression.getProperty().setResolvedType(type);
											context.setAssets(type, propertyCallExpression.getProperty());
											
											Type typeCopy = EcoreUtil.copy(type);
											rawResultType.setContentType(typeCopy);
											context.setAssets(typeCopy, rawResultType);
											
											propertyCallExpression.setResolvedType(rawResultType);
											context.setAssets(rawResultType, propertyCallExpression);
										}
										else { //if the data type is not normalisable
											ModelElementType eType = EolFactory.eINSTANCE.createModelElementType();
											eType.setModelType(propertyType);
											propertyCallExpression.getProperty().setResolvedType(eType);
											context.setAssets(eType, propertyCallExpression.getProperty());
											
											Type typeCopy = EcoreUtil.copy(eType);
											rawResultType.setContentType(typeCopy);
											context.setAssets(typeCopy, rawResultType);
											
											propertyCallExpression.setResolvedType(rawResultType);
											context.setAssets(rawResultType, propertyCallExpression);
										}
									}
									else { //if the property is not data type, then it should be model element type
										ModelElementType callType = EolFactory.eINSTANCE.createModelElementType();
										callType.setModelType(propertyType);
										callType.setModelName(ipd.getPackageName());
										callType.setElementName(propertyType.getName());
										propertyCallExpression.getProperty().setResolvedType(callType);
										context.setAssets(callType, propertyCallExpression.getProperty());
										
										Type typeCopy = EcoreUtil.copy(callType);
										rawResultType.setContentType(typeCopy);
										context.setAssets(typeCopy, rawResultType);
										
										propertyCallExpression.setResolvedType(rawResultType);
										context.setAssets(rawResultType, propertyCallExpression);
									}
								}
							}
							else {
								context.getLogBook().addError(propertyCallExpression.getProperty(), "Property with name " + propertyString
										+ " is not found" );
								propertyCallExpression.setResolvedType(EolFactory.eINSTANCE.createAnyType());
							}
						}
					}
					else {
						LogBook.getInstance().addError(propertyCallExpression.getProperty(), IMessage_TypeResolution.PROPERTY_NOT_FOUND);
						propertyCallExpression.setResolvedType(EolFactory.eINSTANCE.createAnyType());
					}
				}
				else {
					LogBook.getInstance().addError(propertyCallExpression.getProperty(), IMessage_TypeResolution.PROPERTY_NOT_FOUND);
					propertyCallExpression.setResolvedType(EolFactory.eINSTANCE.createAnyType());
				}
			}
		}
	
		return null;
	}
	
	public boolean isKeyword(String s)
	{
		if (s.equals("all") ||
				s.equals("allInstances") ||
				s.equals("first") ||
				s.equals("second") ||
				s.equals("third") ||
				s.equals("fourth") ||
				s.equals("last") ||
				s.equals("one")) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public Object handleKeywords(PropertyCallExpression propertyCallExpression, TypeResolutionContext context)
	{
		//get the target type
		Type targetType = propertyCallExpression.getTarget().getResolvedType();
		//prepare arg types
		ArrayList<Type> argTypes = new ArrayList<Type>();
		
		Expression target = propertyCallExpression.getTarget();
		
		//get the operation definition
		OperationDefinition operationDefinition = context.getOperationDefinitionManager().getOperation(propertyCallExpression, propertyCallExpression.getProperty().getName(), targetType, argTypes, false); //fetch operation definition using name, context type and arg types
		//if an operation is found
		if (operationDefinition != null) {
			
			//get the context type of the operation
			Type contextType = operationDefinition.getContextType();
			
			//if target type and context type is generic
			if (context.getTypeUtil().isTypeEqualOrGeneric(targetType,contextType)) {
				
				if (OperationDefinitionManager.getInstance().handled(operationDefinition)) {
					propertyCallExpression.setResolvedType(EcoreUtil.copy(operationDefinition.getReturnType()));
					//set the resolved type of the method
					propertyCallExpression.getProperty().setResolvedType(EcoreUtil.copy(operationDefinition.getReturnType()));
					//set resolved content
					propertyCallExpression.getProperty().setResolvedContent(operationDefinition); 
				}
				else {
					
					//if is self type
					if (operationDefinition.getReturnType() instanceof SelfType) { 
						//just copy the target type because the target type has been resolved
						propertyCallExpression.setResolvedType(EcoreUtil.copy(targetType));
						//set the resolved type of the method
						propertyCallExpression.getProperty().setResolvedType(EcoreUtil.copy(targetType));
						//set resolved content
						propertyCallExpression.getProperty().setResolvedContent(operationDefinition); 
					}
					
					//if is selfContentType
					else if (operationDefinition.getReturnType() instanceof SelfContentType) {
						
						//if target type is of collection type
						if (targetType instanceof CollectionType) {
							Type contentType = ((CollectionType) targetType).getContentType(); //getContentType
							if (contentType != null) {
								propertyCallExpression.setResolvedType(EcoreUtil.copy(contentType)); //set resolved type
								propertyCallExpression.getProperty().setResolvedType(EcoreUtil.copy(contentType)); //set method type
								propertyCallExpression.getProperty().setResolvedContent(operationDefinition); //set resolved content
							}
							else {
								AnyType tempAnyType = EolFactory.eINSTANCE.createAnyType();
								propertyCallExpression.setResolvedType(EcoreUtil.copy(tempAnyType));
								propertyCallExpression.getProperty().setResolvedType(EcoreUtil.copy(tempAnyType));
								//handle content type null
							}
						}
						else {
							LogBook.getInstance().addError(target, IMessage_TypeResolution.EXPRESSION_SHOULD_BE_COLLECTION_TYPE);
							
							AnyType tempAnyType = EolFactory.eINSTANCE.createAnyType();
							propertyCallExpression.setResolvedType(EcoreUtil.copy(tempAnyType));
							propertyCallExpression.getProperty().setResolvedType(EcoreUtil.copy(tempAnyType));
						}
					}
					
					else if (operationDefinition.getReturnType() instanceof CollectionType && 
							(((CollectionType)operationDefinition.getReturnType()).getContentType() instanceof SelfType)) { //if the return type is collection type and its content type is SelfType ============================
						
						CollectionType returnType = (CollectionType) operationDefinition.getReturnType();
						
						CollectionType resultType = EcoreUtil.copy(returnType);
						resultType.setContentType(EcoreUtil.copy(targetType));
						propertyCallExpression.setResolvedType(EcoreUtil.copy(resultType)); //set the type of the method call
						propertyCallExpression.getProperty().setResolvedType(EcoreUtil.copy(resultType)); //set resolved type
						propertyCallExpression.getProperty().setResolvedContent(operationDefinition); //set resolved content
					}
					
					else {
						propertyCallExpression.setResolvedType(EcoreUtil.copy(operationDefinition.getReturnType())); //set the type of the method call
						propertyCallExpression.getProperty().setResolvedType(EcoreUtil.copy(operationDefinition.getReturnType())); //set resolved type
						propertyCallExpression.getProperty().setResolvedContent(operationDefinition); //set resolved content
					}
				}
				
				
			}
			else if (TypeUtil.getInstance().isInstanceofAnyType(targetType)) {
				propertyCallExpression.setResolvedType(EcoreUtil.copy(operationDefinition.getReturnType())); //set the type of the method call
				propertyCallExpression.getProperty().setResolvedType(EcoreUtil.copy(operationDefinition.getReturnType())); //set resolved type
				propertyCallExpression.getProperty().setResolvedContent(operationDefinition); //set resolved conten
			}
			else {
				//handle type incompatible
				String expectedType = "";
				//String actualType = "";
				if (contextType instanceof ModelElementType) {
					expectedType = ((ModelElementType)contextType).getModelName() + "!" + ((ModelElementType)contextType).getElementName();
				}
				
				else {
					expectedType = contextType.getClass().toString();
				}
//				if (targetType instanceof ModelElementType) {
//					actualType = ((ModelElementType)targetType).getModelName() + "!" + ((ModelElementType)targetType).getElementName();
//				}
//				else {
//					actualType = targetType.getClass().toString();
//				}
				LogBook.getInstance().addError(target, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.EXPECTED_TYPE, expectedType));
			}
		}
		else {
			String argString = "";
			for(int i = 0; i < argTypes.size(); i++)
			{
				argString.concat(argTypes.get(i).getClass().toString());
				if (i == argTypes.size() - 1) {
					
				}
				else {
					argString.concat(", ");
				}
			}
			
			LogBook.getInstance().addError(propertyCallExpression.getProperty(), IMessage_TypeResolution.PROPERTY_NOT_FOUND);
		}
		return null;
		
	}
	
	
	public Type getInnermostType(Type t)
	{
		if (t instanceof CollectionType) {
			CollectionType collectionType = (CollectionType) t;
			Type contentType = collectionType.getContentType();
			while(contentType instanceof CollectionType)
			{
				contentType = ((CollectionType)contentType).getContentType();
			}
			return EcoreUtil.copy(contentType);
		}
		else {
			return EcoreUtil.copy(t);
		}
	}
	
}
