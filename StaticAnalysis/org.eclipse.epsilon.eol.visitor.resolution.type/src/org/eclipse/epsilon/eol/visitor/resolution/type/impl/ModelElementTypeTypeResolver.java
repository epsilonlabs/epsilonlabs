package org.eclipse.epsilon.eol.visitor.resolution.type.impl;

import java.util.ArrayList;

import metamodel.connectivity.abstractmodel.EMetamodelDriver;
import metamodel.connectivity.emf.EMFMetamodelDriver;
import metamodel.connectivity.plainxml.PlainXMLMetamodelDriver;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ModelElementTypeVisitor;
import org.eclipse.epsilon.eol.parse.Eol_EolParserRules.elseStatement_return;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;

public class ModelElementTypeTypeResolver extends ModelElementTypeVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(ModelElementType modelElementType,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		//get the string for model
		String modelString = modelElementType.getModelName();
		
		//get the string for element
		String elementString = modelElementType.getElementName(); 
		
		//if keyword _ModelElementType_ is found, then return null, do nothing
		if (modelString == null && elementString.equals("_ModelElementType_")) { 
			return null;
		}
		
		//if no metamodel is declared, report error
		if (context.getContainer().getMetaModels().size() == 0) {
			context.getLogBook().addError(modelElementType, "No metamodel has been defined, please define metamodels");
			return null;
		}
		
		else {
			//if model name is not null
			if (modelString != null) {
				
				//if elementString is not null
				if (elementString != null) {
					
					//if metamodel repository contains a metamodel with name
					if (context.containsMetaModel(modelString)) {
						
						//first look for models with the same alias, with the assumption that the model string is an alias
						ArrayList<EMetamodelDriver> models = context.getMetaModelsWithAlias(modelString);
						
						//if there are models no matter how many
						if (models != null) {
							
							//if there is only 1 model
							if (models.size() == 1) {
								
								//get the model
								EMetamodelDriver leModel = models.get(0);
								
								//if it is an EMFMetamodel
								if (leModel instanceof EMFMetamodelDriver) {
									
									//if the model contains the model element
									if (leModel.containsMetaClass(elementString)) {
										
										//get the element
										EClass element = leModel.getMetaClass(elementString);
										
										//check if there are any annotations(errors or warnings) associated with this element
										context.checkAndDisplayAnnotation(element, modelElementType);
										
										//set the ecoretype of the model element type
										modelElementType.setEcoreType(element); 
										
										//declare a model declaration statement first
										ModelDeclarationStatement resolvedDeclarationStatement = null; 
										
										//look into model declaration statements, and assign resolved declarationstatement 
										for(ModelDeclarationStatement mds: context.getModelDeclarations().values())
										{
											for(VariableDeclarationExpression alias: mds.getAlias())
											{
												if (modelString.equals(alias.getName().getName())) {
													resolvedDeclarationStatement = mds;
													break;
												}
											}
										}
										
										//if no resolved declaration is found report error
										if (resolvedDeclarationStatement == null) {
											context.getLogBook().addError(modelElementType, "no corresponding model declaration statement found");
											return null;
										}
										//if resolved declaration is found, set resolved model declaration and return
										else {
											modelElementType.getResolvedModelDeclaration().add(resolvedDeclarationStatement);
											return null;	
										}
									}
									//if the model does not contain the model element report error
									else {
										context.getLogBook().addError(modelElementType, elementString + " cannot be resolved to a type");
										return null;
									}
								}
								//if the model is a plain xml model
								else if (leModel instanceof PlainXMLMetamodelDriver) {
									if (elementString.startsWith("b_") ||
											elementString.startsWith("f_") ||
											elementString.startsWith("d_") ||
											elementString.startsWith("i_") ||
											elementString.startsWith("s_") ||
											elementString.startsWith("c_") ||
											elementString.startsWith("x_") ||
											elementString.startsWith("e_") ) {
										context.getLogBook().addError(modelElementType, "model element type cannot be denoted with prefix: " + elementString.substring(0, 2));
										return null;
									}
									else {
										//if the model contains the element
										if (leModel.containsMetaClass(elementString)) {
											//get the element
											EClass element = leModel.getMetaClass(elementString);
											//check if there are any annotations to display
											context.checkAndDisplayAnnotation(element, modelElementType);
											
											//set ecore type
											modelElementType.setEcoreType(element); //set ecore type
											
											//prepare resolved declaration statement
											ModelDeclarationStatement resolvedDeclarationStatement = null; //declare a model declaration statement
											
											//look into model declaration statements, and assign resolved declarationstatement 
											for(ModelDeclarationStatement mds: context.getModelDeclarations().values())
											{
												for(VariableDeclarationExpression alias: mds.getAlias())
												{
													if (modelString.equals(alias.getName().getName())) {
														resolvedDeclarationStatement = mds;
														break;
													}
												}
											}
											
											//if no resolved declaration is found report error
											if (resolvedDeclarationStatement == null) {
												context.getLogBook().addError(modelElementType, "no corresponding model declaration statement found");
												return null;
											}
											//if resolved declaration is found, set resolved model declaration and return
											else {
												modelElementType.getResolvedModelDeclaration().add(resolvedDeclarationStatement);
												return null;	
											}
										}
										//if cannot find the element report error
										else {
											context.getLogBook().addError(modelElementType, elementString + " cannot be resolved to a type");
										}
									}
								}
								//if more than one models are found
								else {
									context.getLogBook().addError(modelElementType, "unknown error, unknown metamodel driver");
								}
							}
							//if there are multiple models with the same alias
							else if (models.size() > 1) {
								
								for(int i = 0; i < models.size(); i++)
								{
									//get the model
									EMetamodelDriver leModel = models.get(i);
									
									//if it is an EMFMetamodel
									if (leModel instanceof EMFMetamodelDriver) {
										
										//if the model contains the model element
										if (leModel.containsMetaClass(elementString)) {
											
											//get the element
											EClass element = leModel.getMetaClass(elementString);
											
											//check if there are any annotations(errors or warnings) associated with this element
											context.checkAndDisplayAnnotation(element, modelElementType);
											
											//set the ecoretype of the model element type
											modelElementType.setEcoreType(element); 
											
											//declare a model declaration statement first
											ModelDeclarationStatement resolvedDeclarationStatement = null; 
											
											//look into model declaration statements, and assign resolved declarationstatement 
											for(ModelDeclarationStatement mds: context.getModelDeclarations().values())
											{
												for(VariableDeclarationExpression alias: mds.getAlias())
												{
													if (modelString.equals(alias.getName().getName())) {
														resolvedDeclarationStatement = mds;
														break;
													}
												}
											}
											
											//if no resolved declaration is found report error
											if (resolvedDeclarationStatement == null) {
												context.getLogBook().addError(modelElementType, "no corresponding model declaration statement found");
												return null;
											}
											//if resolved declaration is found, set resolved model declaration and return
											else {
												modelElementType.getResolvedModelDeclaration().add(resolvedDeclarationStatement);
												return null;	
											}
										}
										//if the model does not contain the model element report error
										else {
											context.getLogBook().addError(modelElementType, elementString + " cannot be resolved to a type");
											return null;
										}
									}
									//if the model is a plain xml model
									else if (leModel instanceof PlainXMLMetamodelDriver) {
										if (elementString.startsWith("b_") ||
												elementString.startsWith("f_") ||
												elementString.startsWith("d_") ||
												elementString.startsWith("i_") ||
												elementString.startsWith("s_") ||
												elementString.startsWith("c_") ||
												elementString.startsWith("x_") ||
												elementString.startsWith("e_") ) {
											context.getLogBook().addError(modelElementType, "model element type cannot be denoted with prefix: " + elementString.substring(0, 2));
											return null;
										}
										else {
											//if the model contains the element
											if (leModel.containsMetaClass(elementString)) {
												//get the element
												EClass element = leModel.getMetaClass(elementString);
												//check if there are any annotations to display
												context.checkAndDisplayAnnotation(element, modelElementType);
												
												//set ecore type
												modelElementType.setEcoreType(element); //set ecore type
												
												//prepare resolved declaration statement
												ModelDeclarationStatement resolvedDeclarationStatement = null; //declare a model declaration statement
												
												//look into model declaration statements, and assign resolved declarationstatement 
												for(ModelDeclarationStatement mds: context.getModelDeclarations().values())
												{
													for(VariableDeclarationExpression alias: mds.getAlias())
													{
														if (modelString.equals(alias.getName().getName())) {
															resolvedDeclarationStatement = mds;
															break;
														}
													}
												}
												
												//if no resolved declaration is found report error
												if (resolvedDeclarationStatement == null) {
													context.getLogBook().addError(modelElementType, "no corresponding model declaration statement found");
													return null;
												}
												//if resolved declaration is found, set resolved model declaration and return
												else {
													modelElementType.getResolvedModelDeclaration().add(resolvedDeclarationStatement);
													return null;	
												}
											}
											//if cannot find the element report error
											else {
												context.getLogBook().addError(modelElementType, elementString + " cannot be resolved to a type");
											}
										}
									}
									//if its neither a emf or a plain xml
									else {
										context.getLogBook().addError(modelElementType, "unknown error, unknown metamodel driver");
									}
								}
								
								if (modelElementType.getResolvedModelDeclaration().size()>1) {
									context.getLogBook().addWarning(modelElementType, "element defined in multiple models, please be specific");
								}
							}
							else {
								context.getLogBook().addError(modelElementType, "no model found");
							}
							
						}
						
						//if alias look up returns 0 result
						else {
							//look up for metamodels with metamodel name
							//attention: metamodel name should be unique
							EMetamodelDriver leModel = context.getMetaModel(modelString);
							
							//if look up returns result
							if (leModel != null) {
								//if is a emf metamodel
								if (leModel instanceof EMFMetamodelDriver) {
									//if contains element
									if (leModel.containsMetaClass(elementString)) {
										//get the element
										EClass element = leModel.getMetaClass(elementString);
										//check if there are any annotations to display
										context.checkAndDisplayAnnotation(element, modelElementType);
										
										//set ecore type
										modelElementType.setEcoreType(element); 
										
										//prepare resolved declaration statement
										ModelDeclarationStatement resolvedDeclarationStatement = null; //declare a model declaration statement
										
										for(String s: context.getModelDeclarations().keySet()) //get model declaration names
										{
											//this would only look up model names, no aliases are looked up
											if (leModel.getMetamodelName().equals(s)) { //if declaration name is equal to metamodel name, set
												resolvedDeclarationStatement = context.getModelDeclarations().get(s);
												break;
											}
										}
										if (resolvedDeclarationStatement != null) {
											modelElementType.getResolvedModelDeclaration().add(resolvedDeclarationStatement);	
										}
										else {
											context.getLogBook().addError(modelElementType, "type cannot be found in the metamodels defined");
										}
										
									}
									//if does not contain it
									else {
										context.getLogBook().addError(modelElementType, elementString + " cannot be resolved to a type");
									}
								}
								//if the metamodel is a plain xml metamodel
								else if (leModel instanceof PlainXMLMetamodelDriver) {
									if (elementString.startsWith("b_") ||
											elementString.startsWith("f_") ||
											elementString.startsWith("d_") ||
											elementString.startsWith("i_") ||
											elementString.startsWith("s_") ||
											elementString.startsWith("c_") ||
											elementString.startsWith("x_") ||
											elementString.startsWith("e_") ) {
										context.getLogBook().addError(modelElementType, "model element type cannot be denoted with prefix: " + elementString.substring(0, 2));
									}
									else {
										//if contains element
										if (leModel.containsMetaClass(elementString)) {
											//get the element
											EClass element = leModel.getMetaClass(elementString);
											//check for contents to display
											context.checkAndDisplayAnnotation(element, modelElementType);
											//set the ecore type
											modelElementType.setEcoreType(element); //set ecore type
											//prepare the resolved declaration statement
											ModelDeclarationStatement resolvedDeclarationStatement = null; //declare a model declaration statement
											
											for(String s: context.getModelDeclarations().keySet()) //get model declaration names
											{
												if (leModel.getMetamodelName().equals(s)) { //if declaration name is equal to metamodel name, set
													resolvedDeclarationStatement = context.getModelDeclarations().get(s);
													break;
												}
											}
											if (resolvedDeclarationStatement != null) {
												modelElementType.getResolvedModelDeclaration().add(resolvedDeclarationStatement);	
											}
											else {
												context.getLogBook().addError(modelElementType, "type cannot be found in the metamodels defined");
											}
										}
										else {
											context.getLogBook().addError(modelElementType, elementString + " cannot be resolved to a type");
										}
									}
								}
								else {
									context.getLogBook().addError(modelElementType, "unknown error, unknown metamodel driver");
								}
							}
							else {
								context.getLogBook().addError(modelElementType, "no model found");
							}
						}
					}
					else {
						context.getLogBook().addError(modelElementType, "MetaModel with name " + modelString + " cannot be found");
					}
				}
				else {
					context.getLogBook().addError(modelElementType, "ModelElement cannot be null");
				}
			}
			
			//if model string is null
			else {
				//if the element string is not null
				if(elementString != null)
				{
					//if there are more then one plain XML metamodels
					if (context.getNumberOfModelsOfType("XML") > 1) {
						context.getLogBook().addError(modelElementType, "Multiple XML models detected, please specify one");
						return null;
					}
					
					//if there are less than 2 plain XML metamodels
					else {
						//get metamodels that define the element
						ArrayList<EMetamodelDriver> models = context.metamodelsDefine(elementString);
						
						//if there are any number of them
						if (models != null) {
							//if there is only one model which defines the element
							if (models.size() == 1) {
								//get the model
								EMetamodelDriver leModel = models.get(0);
								//set model name
								modelElementType.setModelName(leModel.getName());

								//if is a emf model
								if (leModel instanceof EMFMetamodelDriver) {
									//if the model contians the element
									if (leModel.containsMetaClass(elementString)) {
										//get the element
										EClass element = leModel.getMetaClass(elementString);
										//check for contents to display
										context.checkAndDisplayAnnotation(element, modelElementType);
										
										modelElementType.setEcoreType(element); //set ecore type
										
										ModelDeclarationStatement resolvedDeclarationStatement = null; //declare a model declaration statement
										
										for(String s: context.getModelDeclarations().keySet()) //get model declaration names
										{
											if (leModel.getMetamodelName().equals(s)) { //if declaration name is equal to metamodel name, set
												resolvedDeclarationStatement = context.getModelDeclarations().get(s);
												break;
											}
										}
										if (resolvedDeclarationStatement != null) {
											modelElementType.getResolvedModelDeclaration().add(resolvedDeclarationStatement);	
										}
										else {
											context.getLogBook().addError(modelElementType, "type cannot be found in the metamodels defined");
										}
																		
									}
									else {
										context.getLogBook().addError(modelElementType, elementString + " cannot be resolved to a type");
									}
								}
								else if (leModel instanceof PlainXMLMetamodelDriver) {
									if (elementString.startsWith("b_") ||
											elementString.startsWith("f_") ||
											elementString.startsWith("d_") ||
											elementString.startsWith("i_") ||
											elementString.startsWith("s_") ||
											elementString.startsWith("c_") ||
											elementString.startsWith("x_") ||
											elementString.startsWith("e_") ) {
										context.getLogBook().addError(modelElementType, "model element type cannot be denoted with prefix: " + elementString.substring(0, 2));
									}
									else {
										//if the model contains the element
										if (leModel.containsMetaClass(elementString)) {
											//get the element
											EClass element = leModel.getMetaClass(elementString);
											//check for contents to display
											context.checkAndDisplayAnnotation(element, modelElementType);
											
											modelElementType.setEcoreType(element); //set ecore type
											
											ModelDeclarationStatement resolvedDeclarationStatement = null; //declare a model declaration statement
											
											for(String s: context.getModelDeclarations().keySet()) //get model declaration names
											{
												if (leModel.getMetamodelName().equals(s)) { //if declaration name is equal to metamodel name, set
													resolvedDeclarationStatement = context.getModelDeclarations().get(s);
													break;
												}
											}
											if (resolvedDeclarationStatement != null) {
												modelElementType.getResolvedModelDeclaration().add(resolvedDeclarationStatement);	
											}
											else {
												context.getLogBook().addError(modelElementType, "type cannot be found in the metamodels defined");
											}
										}
										else {
											context.getLogBook().addError(modelElementType, elementString + " cannot be resolved to a type");
										}
									}
								}
								else {
									context.getLogBook().addError(modelElementType, "unknown metamodel driver");
								}
							}
							else {
								context.getLogBook().addWarning(modelElementType, "MetaElement with name " + elementString + " is defined in multiple metamodels");
							}
						}
						else {
							context.getLogBook().addError(modelElementType, "MetaElement with name " + elementString + " cannot be found");
						}
					}
				}
				else {
					context.getLogBook().addError(modelElementType, "invalid Model Element Type");
				}
			}
		}
		
		return null;
	}
	
	
}
