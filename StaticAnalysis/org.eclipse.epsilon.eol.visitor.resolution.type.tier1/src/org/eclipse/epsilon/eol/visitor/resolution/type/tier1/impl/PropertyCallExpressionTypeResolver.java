package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;


import java.util.ArrayList;

import metamodel.connectivity.abstractmodel.EMetamodelDriver;
import metamodel.connectivity.plainxml.PlainXMLMetamodelDriver;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.AnnotationBlock;
import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.CollectionType;
import org.eclipse.epsilon.eol.metamodel.EType;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.ModelElementType;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.PropertyCallExpression;
import org.eclipse.epsilon.eol.metamodel.SelfContentType;
import org.eclipse.epsilon.eol.metamodel.SelfType;
import org.eclipse.epsilon.eol.metamodel.SimpleAnnotation;
import org.eclipse.epsilon.eol.metamodel.StringExpression;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.PropertyCallExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class PropertyCallExpressionTypeResolver extends PropertyCallExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(PropertyCallExpression propertyCallExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		Expression expression = propertyCallExpression.getTarget(); //get the target
		controller.visit(expression, context); //visit the target first
		
		if(propertyCallExpression.getExtended().isVal()) //test to see if it is an extended property )  
		{
			AnyType anyType = context.getEolFactory().createAnyType(); //create an anyType
			context.setAssets(anyType, propertyCallExpression); //set assets
			propertyCallExpression.setResolvedType(anyType); //assign type
			
			context.getLogBook().addWarning(propertyCallExpression.getProperty(), "property is an Extended property, expression type is set to Any");
			return null;
		}
		
		if (propertyCallExpression.getTarget().getResolvedType() instanceof AnyType) {// or the target is of type Any
			AnyType tempAnyType = (AnyType) propertyCallExpression.getTarget().getResolvedType();
			propertyCallExpression.setResolvedType(context.getEolFactory().createAnyType());
			context.getLogBook().addWarning(propertyCallExpression.getTarget(), "Potentially unsafe typing");
			return null;
		}

		//if the property is an extended property, then the type of the call should be Any
		//if the type of the target is of Type Any, then the TypeResolver also assumes that the property is of type Any
		//EOL does not guarantee the safe property navigation of type Any -- need to talk to Dimitris for further development on EOL but leave it like this for now
		//System.err.println(propertyCallExpression.getProperty().getName());
		if (isKeyword(propertyCallExpression.getProperty().getName())) {
			handleKeywords(propertyCallExpression, context);
			return null;
		}
		else 
		{ //if the property is not an extended property and the target type is not of type Any
			if(propertyCallExpression.getTarget().getResolvedType() instanceof ModelElementType) //if the target type is ModelElementType
			{
				ModelElementType targetType = (ModelElementType) propertyCallExpression.getTarget().getResolvedType(); //get the type
				EMetamodelDriver mm = context.getMetaModel(targetType.getModelName()); //get the metamodel
				String metaClassString = targetType.getElementName(); //get metaclass string
				String propertyString = propertyCallExpression.getProperty().getName(); //get property string
				
				if(mm != null && mm.contains(metaClassString, propertyString)) //if metamode class contains the property
				{
					
				}
				else {
					if (targetType.getEcoreType()!=null) {
						mm = context.getMetaModelWithNSURI(targetType.getEcoreType().getEPackage().getNsURI());
					}
				}
				
				if (mm instanceof PlainXMLMetamodelDriver) {
					if (context.getTypeUtil().isXMLSyntax(propertyString)) {
						if (propertyString.startsWith("t_")) {
							context.getLogBook().addError(propertyCallExpression.getProperty(), "The syntax t_ cannot be used on property calls");
							return null;
						}
					}
				}
				
				if(mm != null) //if meta model exists
				{
					
					if(mm.contains(metaClassString, propertyString)) //if metamode class contains the property
					{
						EStructuralFeature feature = mm.getEStructuralFeature(mm.getMetaClass(metaClassString), propertyString); //get the property 
						propertyCallExpression.getProperty().setResolvedContent(feature); //set the resolved content for the property
						if (feature.getEAnnotations() != null && feature.getEAnnotations().size() != 0) {
							for(EAnnotation anno: feature.getEAnnotations())
							{
								if (anno.getDetails().get("warning") != null) {
									context.getLogBook().addWarning(propertyCallExpression.getProperty(), anno.getDetails().get("warning"));	
								}
								if (anno.getDetails().get("error") != null) {
									context.getLogBook().addError(propertyCallExpression.getProperty(), anno.getDetails().get("error"));	
								}
							}
						}
						
						if (feature.getUpperBound() != 1) { //this means that the feature is a many value aggregation
							Type contentType = null; //each collection type needs a content type
							CollectionType callType = null; //prepare the callType
							
							EClassifier propertyType = mm.getTypeForEStructuralFeature(mm.getMetaClass(metaClassString), propertyString); //get the type for the property
							if (context.getTypeUtil().isEDataType(propertyType)) { //if type is EDataType
								if(context.getTypeUtil().isNormalisable(propertyType)){ //if type is normalisable
									contentType = context.getTypeUtil().normalise(propertyType); //normalise and assign type to contentType
								}
								else { //if type is not normalisable
									contentType = context.getEolFactory().createEType(); //create a EType and assign it to contentType
									((EType) contentType).setEcoreType(propertyType); //assign the EDataType to EType
								}
							}
							else { //if type is not EDatatype
								contentType = context.getEolFactory().createModelElementType(); //assign a ModelElementType to contentType 
								((ModelElementType) contentType).setEcoreType(propertyType); //setEcoreType
								((ModelElementType) contentType).setModelName(mm.getMetamodelName()); //model name
								((ModelElementType) contentType).setElementName(propertyType.getName()); //element name
							}

				
							
							if (feature.isOrdered() && feature.isUnique()) { //if feature is ordered and unique
								callType = context.getEolFactory().createOrderedSetType(); //this should be ordered set
							}
							else if (feature.isOrdered() && !feature.isUnique()) { //if feature is ordered but not unique
								callType = context.getEolFactory().createSequenceType(); //this should be a sequence
							}
							else if (!feature.isOrdered() && feature.isUnique()) {//if feature is unordered and unique
								callType = context.getEolFactory().createSetType();  //this should be a set
							}
							else if (!feature.isOrdered() && !feature.isUnique()) {//if feature is unordered and non-unique
								callType = context.getEolFactory().createBagType(); //this should be a bag
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
							
							EClassifier propertyType = mm.getTypeForEStructuralFeature(mm.getMetaClass(metaClassString), propertyString); //get property
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
									EType eType = context.getEolFactory().createEType();
									eType.setEcoreType(propertyType);
									propertyCallExpression.getProperty().setResolvedType(eType);
									context.setAssets(eType, propertyCallExpression.getProperty());
									
									Type typeCopy = EcoreUtil.copy(eType);
									propertyCallExpression.setResolvedType(typeCopy);
									context.setAssets(typeCopy, propertyCallExpression);
								}
							}
							else { //if the property is not data type, then it should be model element type
								ModelElementType callType = context.getEolFactory().createModelElementType();
								callType.setEcoreType(propertyType);
								callType.setModelName(mm.getMetamodelName());
								callType.setElementName(propertyType.getName());
								propertyCallExpression.getProperty().setResolvedType(callType);
								context.setAssets(callType, propertyCallExpression.getProperty());
								
								Type typeCopy = EcoreUtil.copy(callType);
								propertyCallExpression.setResolvedType(typeCopy);
								context.setAssets(typeCopy, propertyCallExpression);
							}
						}
					}
					else {

						context.getLogBook().addError(propertyCallExpression.getProperty(), "Property with name " + propertyCallExpression.getProperty().getName()
								+ " is not found" );
						propertyCallExpression.setResolvedType(context.getEolFactory().createAnyType());
						
						//handle property not found
						//this might support for operations like a.all.first; 
					}
				}
				else {
					//handle mm not found
				}
			}
			else {
				if (propertyCallExpression.getTarget().getResolvedType() instanceof CollectionType) { //if target is of type CollectionType
					CollectionType rawCollectionType = (CollectionType) propertyCallExpression.getTarget().getResolvedType(); //prepare collection type
					
					CollectionType rawResultType = EcoreUtil.copy(rawCollectionType);
					
					if (getInnermostType(rawCollectionType) instanceof ModelElementType) 
					{ //if contentType is ModelElementType
						ModelElementType resultContentType = (ModelElementType) getInnermostType(rawCollectionType); //prepare result content type
						EMetamodelDriver mm = context.getMetaModel(resultContentType.getModelName()); //get the metamodel
						if(mm != null) //if meta model exists
						{
							String metaClassString = resultContentType.getElementName(); //get metaclass string
							String propertyString = propertyCallExpression.getProperty().getName(); //get property string
							
							if(mm.contains(metaClassString, propertyString)) //if metamode class contains the property
							{
								EStructuralFeature feature = mm.getEStructuralFeature(mm.getMetaClass(metaClassString), propertyString); //get the property 
								propertyCallExpression.getProperty().setResolvedContent(feature); //set the resolved content for the property

								if (feature.getUpperBound() != 1) { //this means that the feature is a many value aggregation
									Type contentType = null; //each collection type needs a content type
									CollectionType callType = null; //prepare the callType
									
									EClassifier propertyType = mm.getTypeForEStructuralFeature(mm.getMetaClass(metaClassString), propertyString); //get the type for the property
									if (context.getTypeUtil().isEDataType(propertyType)) { //if type is EDataType
										if(context.getTypeUtil().isNormalisable(propertyType)){ //if type is normalisable
											contentType = context.getTypeUtil().normalise(propertyType); //normalise and assign type to contentType
										}
										else { //if type is not normalisable
											contentType = context.getEolFactory().createEType(); //create a EType and assign it to contentType
											((EType) contentType).setEcoreType(propertyType); //assign the EDataType to EType
										}
									}
									else { //if type is not EDatatype
										contentType = context.getEolFactory().createModelElementType(); //assign a ModelElementType to contentType 
										((ModelElementType) contentType).setEcoreType(propertyType); //setEcoreType
										((ModelElementType) contentType).setModelName(mm.getMetamodelName()); //model name
										((ModelElementType) contentType).setElementName(propertyType.getName()); //element name
									}

						
									
									if (feature.isOrdered() && feature.isUnique()) { //if feature is ordered and unique
										callType = context.getEolFactory().createOrderedSetType(); //this should be ordered set
									}
									else if (feature.isOrdered() && !feature.isUnique()) { //if feature is ordered but not unique
										callType = context.getEolFactory().createSequenceType(); //this should be a sequence
									}
									else if (!feature.isOrdered() && feature.isUnique()) {//if feature is unordered and unique
										callType = context.getEolFactory().createSetType();  //this should be a set
									}
									else if (!feature.isOrdered() && !feature.isUnique()) {//if feature is unordered and non-unique
										callType = context.getEolFactory().createBagType(); //this should be a bag
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
									
									EClassifier propertyType = mm.getTypeForEStructuralFeature(mm.getMetaClass(metaClassString), propertyString); //get property
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
											EType eType = context.getEolFactory().createEType();
											eType.setEcoreType(propertyType);
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
										ModelElementType callType = context.getEolFactory().createModelElementType();
										callType.setEcoreType(propertyType);
										callType.setModelName(mm.getMetamodelName());
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
								propertyCallExpression.setResolvedType(context.getEolFactory().createAnyType());
							}
						}
					}
					else {
						context.getLogBook().addError(propertyCallExpression.getProperty(), "Property with name " + propertyCallExpression.getProperty().getName()
								+ " is not found" );
						propertyCallExpression.setResolvedType(context.getEolFactory().createAnyType());
					}
				}
				else {
					context.getLogBook().addError(propertyCallExpression.getProperty(), "Property with name " + propertyCallExpression.getProperty().getName()
							+ " is not found" );
					propertyCallExpression.setResolvedType(context.getEolFactory().createAnyType());
				}
				//no further property queries can be performed if the target type is not ModelElementType
			}
		}
	
		return null;
	}
	
	public boolean isKeyword(String s)
	{
		if (s.equals("all") ||
				s.equals("allInstances") ||
				s.equals("first") ||
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
		Type targetType = propertyCallExpression.getTarget().getResolvedType();
		ArrayList<Type> argTypes = new ArrayList<Type>();
		
		OperationDefinition operationDefinition = context.getOperationDefinitionControl().getOperation(propertyCallExpression, propertyCallExpression.getProperty().getName(), targetType, argTypes, false); //fetch operation definition using name, context type and arg types

		if (operationDefinition != null) {
			Type contextType = operationDefinition.getContextType(); //get the context type of the operation
			if (context.getTypeUtil().isEqualOrGeneric(targetType,contextType)) { //if target type and context type is generic
				if (operationDefinition.getAnnotationBlock() != null) {
					AnnotationBlock annotationBlock = operationDefinition.getAnnotationBlock();

					if(annotationContains(annotationBlock, "returnInnermostType"))
					{
						setInnermostType(operationDefinition, getInnermostType(targetType));
						
						propertyCallExpression.setResolvedType(EcoreUtil.copy(operationDefinition.getReturnType()));
						//propertyCallExpression.getMethod().setResolvedType(EcoreUtil.copy(operationDefinition.getReturnType())); //set the resolved type of the method
						//propertyCallExpression.getMethod().setResolvedContent(operationDefinition); //set resolved content
						return null;
					}
					if(annotationContains(annotationBlock, "checkCollectionArgSingle"))
					{
						//shoudl not happen and should be an error
					}
					if(annotationContains(annotationBlock, "checkCollectionArgCollection"))
					{
						//shoudl not happen and should be an error
					}
					if (annotationContains(annotationBlock, "modelOp")) {						
						String methodcallName = propertyCallExpression.getProperty().getName();
												
						Expression rawTarget = propertyCallExpression.getTarget(); //get targettype
						if(!(rawTarget instanceof NameExpression)) //if targettype is not a NameExpressioin
						{
							context.getLogBook().addError(rawTarget, "operation " + methodcallName + " can only be used on ModelElementTypes");
							return null;
						}
						else { //else
							NameExpression target = (NameExpression) rawTarget; //cast the target to NameExpression
							String targetname = target.getName();
							if (targetname.contains("!")) {
								targetname = targetname.substring(targetname.indexOf("!")+1, targetname.length());
							}
							if (context.numberOfMetamodelsDefine(targetname, true) > 0) { //if the NameExpression is a keyword in the metamodels
								Type rawTargetType = rawTarget.getResolvedType();
								
								if (!(rawTargetType instanceof ModelElementType)) {
									context.getLogBook().addError(rawTarget, "operation " + methodcallName + " can only be used on ModelElementTypes");
									return null;
								}
								else if (rawTargetType instanceof ModelElementType) {
									
									operationDefinition.setContextType(EcoreUtil.copy(contextType));
									//CollectionType returnType = (CollectionType) result.getReturnType();
									//returnType.setContentType(EcoreUtil.copy(rawTargetType));
								}
							}
							else {
								context.getLogBook().addError(rawTarget, "Model Element Type " + target.getName() + " does not exist");
								return null;
							}
						}
					}

				}
				else {
				}
				if (operationDefinition.getReturnType() instanceof SelfType) { //if is self type
					propertyCallExpression.setResolvedType(EcoreUtil.copy(targetType));  //just copy the target type because the target type has been resolved
					//methodCallExpression.getMethod().setResolvedType(EcoreUtil.copy(targetType)); //set the resolved type of the method
					//methodCallExpression.getMethod().setResolvedContent(operationDefinition); //set resolved content
				}
				else if (operationDefinition.getReturnType() instanceof SelfContentType) { //if is selfContentType
					if (targetType instanceof CollectionType) { //if target type is of collection type
						Type contentType = ((CollectionType) targetType).getContentType(); //getContentType
						if (contentType != null) {
							propertyCallExpression.setResolvedType(EcoreUtil.copy(contentType)); //set resolved type
//							methodCallExpression.getMethod().setResolvedType(EcoreUtil.copy(contentType)); //set method type
//							methodCallExpression.getMethod().setResolvedContent(operationDefinition); //set resolved content
						}
						else {
							//this should be Any i guess?
							//handle content type null
						}
						
					}
					else {
						//handle this
					}
				}
				else if (operationDefinition.getReturnType() instanceof CollectionType && 
						(((CollectionType)operationDefinition.getReturnType()).getContentType() instanceof SelfType || 
						((CollectionType)operationDefinition.getReturnType()).getContentType() instanceof SelfContentType)) { //if the return type is collection type and its content type is either SelfType or SelfContentType ============================
					CollectionType returnType = (CollectionType) operationDefinition.getReturnType();
					Type collectionContentType = returnType.getContentType();
					if (collectionContentType instanceof SelfType) {
						CollectionType resultType = EcoreUtil.copy(returnType);
						resultType.setContentType(EcoreUtil.copy(targetType));
						propertyCallExpression.setResolvedType(EcoreUtil.copy(resultType)); //set the type of the method call
//						methodCallExpression.getMethod().setResolvedType(EcoreUtil.copy(resultType)); //set resolved type
//						methodCallExpression.getMethod().setResolvedContent(operationDefinition); //set resolved content
					}
					if (collectionContentType instanceof SelfContentType) {
						if (targetType instanceof CollectionType) { //if target type is of collection type
							Type contentType = ((CollectionType) targetType).getContentType(); //getContentType
							if (contentType != null) {
								CollectionType resultType = EcoreUtil.copy(returnType);
								resultType.setContentType(EcoreUtil.copy(contentType));
								propertyCallExpression.setResolvedType(EcoreUtil.copy(resultType)); //set resolved type
//								methodCallExpression.getMethod().setResolvedType(EcoreUtil.copy(resultType)); //set method type
//								methodCallExpression.getMethod().setResolvedContent(operationDefinition); //set resolved content
							}
							else {
								//this should be Any i guess?
								//handle content type null
							}
						}
						else {
							context.getLogBook().addError(operationDefinition.getReturnType(), "The target should be of type Collection");
						}
					}
				}
				
				else {
					propertyCallExpression.setResolvedType(EcoreUtil.copy(operationDefinition.getReturnType())); //set the type of the method call
//					methodCallExpression.getMethod().setResolvedType(EcoreUtil.copy(operationDefinition.getReturnType())); //set resolved type
//					methodCallExpression.getMethod().setResolvedContent(operationDefinition); //set resolved content
				}
			}
			else if (targetType instanceof AnyType) {
				propertyCallExpression.setResolvedType(EcoreUtil.copy(operationDefinition.getReturnType())); //set the type of the method call
//				methodCallExpression.getMethod().setResolvedType(EcoreUtil.copy(operationDefinition.getReturnType())); //set resolved type
//				methodCallExpression.getMethod().setResolvedContent(operationDefinition); //set resolved conten
			}
			else {
				//handle type incompatible
				String expectedType = "";
				String actualType = "";
				if (contextType instanceof ModelElementType) {
					expectedType = ((ModelElementType)contextType).getModelName() + "!" + ((ModelElementType)contextType).getElementName();
				}
				
				else {
					expectedType = contextType.getClass().toString();
				}
				if (targetType instanceof ModelElementType) {
					actualType = ((ModelElementType)targetType).getModelName() + "!" + ((ModelElementType)targetType).getElementName();
				}
				else {
					actualType = targetType.getClass().toString();
				}
				context.getLogBook().addError(propertyCallExpression.getTarget(), "Type mismatch for Operation: " + 
				operationDefinition.getName().getName() + "()" + "; Expected type: " + expectedType + 
				" , actual type: " + actualType);
				
			}
		}
//			Type contextType = operationDefinition.getContextType(); //get the context type of the operation
//			if (context.getTypeUtil().isEqualOrGeneric(targetType,contextType) || targetType instanceof CollectionType && contextType instanceof CollectionType) { //if target type and context type is generic
//				
//				if (operationDefinition.getReturnType() instanceof SelfType) { //if is self type
//					propertyCallExpression.setResolvedType(EcoreUtil.copy(targetType));  //just copy the target type because the target type has been resolved
//					
//				}
//				else if (operationDefinition.getReturnType() instanceof SelfContentType) { //if is selfContentType
//					if (targetType instanceof CollectionType) { //if target type is of collection type
//						Type contentType = ((CollectionType) targetType).getContentType(); //getContentType
//						if (contentType != null) {
//							propertyCallExpression.setResolvedType(EcoreUtil.copy(contentType)); //set resolved type
//						}
//						else {
//							//this should be Any i guess?
//							//handle content type null
//						}
//						
//					}
//					else {
//						//handle this
//					}
//				}
//				else {
//					propertyCallExpression.setResolvedType(EcoreUtil.copy(operationDefinition.getReturnType())); //set the type of the method call
//				}
//			}
//			else if (targetType instanceof AnyType) {
//				propertyCallExpression.setResolvedType(EcoreUtil.copy(operationDefinition.getReturnType())); //set the type of the method call
//			}
			else {
				//should not happen
			}
		return null;
	}
	
	public boolean annotationContains(AnnotationBlock block, String s)
	{
		boolean result = false;
		for(SimpleAnnotation annot: block.getSimpleAnnotations())
		{
			if (annot.getName().getName().equals("_sysParam")) {
				for(StringExpression str : annot.getValues())
				{
					if (str.getVal().equals(s)) {
						result = true;
						return result;
					}
				}
				
			}
		}
		return result;
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
	
	public void setInnermostType(OperationDefinition op, Type innermost)
	{
		Type returnType = op.getReturnType();
		if (returnType instanceof CollectionType) {
			Type contentType = ((CollectionType)returnType).getContentType();
			if (contentType instanceof CollectionType) {
				while(contentType instanceof CollectionType)
				{
					if (((CollectionType)contentType).getContentType() instanceof CollectionType) {
						contentType = ((CollectionType)contentType).getContentType();
					}
					else {
						break;
					}
				}
				((CollectionType)contentType).setContentType(EcoreUtil.copy(innermost));
			}
			else {
				((CollectionType) returnType).setContentType(EcoreUtil.copy(innermost));
			}
		}
		else
		{
			op.setReturnType(EcoreUtil.copy(innermost));
		}
	}

}
