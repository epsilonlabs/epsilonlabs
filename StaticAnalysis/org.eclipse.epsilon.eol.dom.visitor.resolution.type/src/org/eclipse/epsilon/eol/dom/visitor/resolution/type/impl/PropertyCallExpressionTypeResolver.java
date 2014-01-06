package org.eclipse.epsilon.eol.dom.visitor.resolution.type.impl;


import metamodel.connectivity.EMetaModel;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.dom.AnyType;
import org.eclipse.epsilon.eol.dom.CollectionType;
import org.eclipse.epsilon.eol.dom.EType;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.ModelElementType;
import org.eclipse.epsilon.eol.dom.PropertyCallExpression;
import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.PropertyCallExpressionVisitor;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;

public class PropertyCallExpressionTypeResolver extends PropertyCallExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(PropertyCallExpression propertyCallExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		Expression expression = propertyCallExpression.getTarget(); //get the target
		controller.visit(expression, context); //visit the target first
		
		
		//if the property is an extended property, then the type of the call should be Any
		//if the type of the target is of Type Any, then the TypeResolver also assumes that the property is of type Any
		//EOL does not guarantee the safe property navigation of type Any -- need to talk to Dimitris for further development on EOL but leave it like this for now
		if(propertyCallExpression.getExtended().isVal()) //test to see if it is an extended property )  
		{
			AnyType anyType = context.getEolFactory().createAnyType(); //create an anyType
			context.setAssets(anyType, propertyCallExpression); //set assets
			propertyCallExpression.setResolvedType(anyType); //assign type
			
			//can throw an warning for these types of property call, but we will see
			context.getLogBook().addWarning(propertyCallExpression.getProperty(), "property is an Extended property, expression type is set to Any");
		}
		else if (propertyCallExpression.getTarget().getResolvedType() instanceof AnyType) {// or the target is of type Any
			AnyType anyType = context.getEolFactory().createAnyType(); //create an anyType
			context.setAssets(anyType, propertyCallExpression); //set assets
			propertyCallExpression.setResolvedType(anyType); //assign type

			context.getLogBook().addWarning(propertyCallExpression.getTarget(), "target type is Any, expression type is set to Any");
		}
		else { //if the property is not an extended property and the target type is not of type Any
			if(propertyCallExpression.getTarget().getResolvedType() instanceof ModelElementType) //if the target type is ModelElementType
			{
				ModelElementType targetType = (ModelElementType) propertyCallExpression.getTarget().getResolvedType(); //get the type
				EMetaModel mm = context.getMetaModel(targetType.getModelName()); //get the metamodel

				if(mm != null) //if meta model exists
				{
					String metaClassString = targetType.getElementName(); //get metaclass string
					String propertyString = propertyCallExpression.getProperty().getName(); //get property string
					
					if(mm.contains(metaClassString, propertyString)) //if metamode class contains the property
					{
						EStructuralFeature feature = mm.getEStructuralFeature(mm.getMetaClass(metaClassString), propertyString); //get the property 
						propertyCallExpression.getProperty().setResolvedContent(feature); //set the resolved content for the property
						
						if (feature.getUpperBound() != 1) { //this means that the feature is a many value aggregation
							Type contentType = null; //each collection type needs a content type
							CollectionType callType = null; //prepare the callType
							
							EClassifier propertyType = mm.getTypeForProperty(mm.getMetaClass(metaClassString), propertyString); //get the type for the property
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
								((ModelElementType) contentType).setModelName(mm.getMetaModelName()); //model name
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
							
							
							propertyCallExpression.setResolvedType(callType);
							context.setAssets(callType, propertyCallExpression); //set assets for callType
							
						}
						else { //if the feature is single value aggregation
							
							EClassifier propertyType = mm.getTypeForProperty(mm.getMetaClass(metaClassString), propertyString); //get property
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
								callType.setModelName(mm.getMetaModelName());
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
					
					if (rawCollectionType.getContentType() instanceof ModelElementType) 
					{ //if contentType is ModelElementType
						ModelElementType resultContentType = (ModelElementType) rawCollectionType.getContentType(); //prepare result content type
						EMetaModel mm = context.getMetaModel(resultContentType.getModelName()); //get the metamodel
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
									
									EClassifier propertyType = mm.getTypeForProperty(mm.getMetaClass(metaClassString), propertyString); //get the type for the property
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
										((ModelElementType) contentType).setModelName(mm.getMetaModelName()); //model name
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
									
									EClassifier propertyType = mm.getTypeForProperty(mm.getMetaClass(metaClassString), propertyString); //get property
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
										callType.setModelName(mm.getMetaModelName());
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

							}
						}
					}
				}
				//no further property queries can be performed if the target type is not ModelElementType
			}
		}

		
		return null;
	}

}
