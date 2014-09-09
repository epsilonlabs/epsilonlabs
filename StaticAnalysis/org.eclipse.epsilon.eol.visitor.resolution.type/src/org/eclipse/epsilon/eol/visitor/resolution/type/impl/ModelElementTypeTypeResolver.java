package org.eclipse.epsilon.eol.visitor.resolution.type.impl;

import java.util.ArrayList;

import metamodel.connectivity.abstractmodel.EMetamodelDriver;
import metamodel.connectivity.emf.EMFMetamodelDriver;
import metamodel.connectivity.plainxml.PlainXMLMetamodelDriver;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ModelElementTypeVisitor;
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
										ModelDeclarationStatement resolveDeclarationStatement = null; 
										
										//get model declaration names
										for(String s: context.getModelDeclarations().keySet()) 
										{
											//if declaration name is equal to metamodel name, set
											if (leModel.getMetamodelName().equals(s)) { 
												resolveDeclarationStatement = context.getModelDeclarations().get(s);
												break;
											}
											else {
												for(String alias: leModel.getAliases())
												{
													//if declaration name is equal to any alias name, set
													if (alias.equals(s)) {
														resolveDeclarationStatement = context.getModelDeclarations().get(s);
														break;
													}
												}
											}
										}
										
										if (resolveDeclarationStatement == null) {
											context.getLogBook().addError(modelElementType, "no corresponding model declaration statement found");
											return null;
										}
										else {
											modelElementType.setResolvedModelDeclaration(resolveDeclarationStatement);		
											return null;	
										}
									}
									
									//if the model does not contain the model element report error
									else {
										context.getLogBook().addError(modelElementType, elementString + " cannot be resolved to a type");
										return null;
									}
								}
								else if (leModel instanceof PlainXMLMetamodelDriver) {
									/*
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
										if (leModel.containsMetaClass(elementString)) {
											EClass element = leModel.getMetaClass(elementString);
											context.checkAndDisplayAnnotation(element, modelElementType);
											
											modelElementType.setEcoreType(element); //set ecore type
											
											ModelDeclarationStatement resolveDeclarationStatement = null; //declare a model declaration statement
											
											for(String s: context.getModelDeclarations().keySet()) //get model declaration names
											{
												if (leModel.getMetamodelName().equals(s)) { //if declaration name is equal to metamodel name, set
													resolveDeclarationStatement = context.getModelDeclarations().get(s);
													break;
												}
												else {
													for(String alias: leModel.getAliases())
													{
														if (alias.equals(s)) { //if declaration name is equal to any alias name, set
															resolveDeclarationStatement = context.getModelDeclarations().get(s);
															break;
														}
													}
												}
											}
											modelElementType.setResolvedModelDeclaration(resolveDeclarationStatement);								
										}
										else {
											context.getLogBook().addError(modelElementType, elementString + " cannot be resolved to a type");
										}
									*/}
								}
								
							}
							else {
								context.getLogBook().addError(modelElementType, "unknown error, unknown metamodel driver");
							}
						}
						else {
							EMetamodelDriver leModel = context.getMetaModel(modelString);
							if (leModel != null) {
								if (leModel instanceof EMFMetamodelDriver) {
									if (leModel.containsMetaClass(elementString)) {
										EClass element = leModel.getMetaClass(elementString);
										context.checkAndDisplayAnnotation(element, modelElementType);
										
										modelElementType.setEcoreType(element); //set ecore type
										
										ModelDeclarationStatement resolveDeclarationStatement = null; //declare a model declaration statement
										
										for(String s: context.getModelDeclarations().keySet()) //get model declaration names
										{
											if (leModel.getMetamodelName().equals(s)) { //if declaration name is equal to metamodel name, set
												resolveDeclarationStatement = context.getModelDeclarations().get(s);
												break;
											}
											else {
												for(String alias: leModel.getAliases())
												{
													if (alias.equals(s)) { //if declaration name is equal to any alias name, set
														resolveDeclarationStatement = context.getModelDeclarations().get(s);
														break;
													}
												}
											}
										}
										modelElementType.setResolvedModelDeclaration(resolveDeclarationStatement);								
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
										if (leModel.containsMetaClass(elementString)) {
											EClass element = leModel.getMetaClass(elementString);
											context.checkAndDisplayAnnotation(element, modelElementType);
											
											modelElementType.setEcoreType(element); //set ecore type
											
											ModelDeclarationStatement resolveDeclarationStatement = null; //declare a model declaration statement
											
											for(String s: context.getModelDeclarations().keySet()) //get model declaration names
											{
												if (leModel.getMetamodelName().equals(s)) { //if declaration name is equal to metamodel name, set
													resolveDeclarationStatement = context.getModelDeclarations().get(s);
													break;
												}
												else {
													for(String alias: leModel.getAliases())
													{
														if (alias.equals(s)) { //if declaration name is equal to any alias name, set
															resolveDeclarationStatement = context.getModelDeclarations().get(s);
															break;
														}
													}
												}
											}
											modelElementType.setResolvedModelDeclaration(resolveDeclarationStatement);								
										}
										else {
											context.getLogBook().addError(modelElementType, elementString + " cannot be resolved to a type");
										}
									}
								}
							}
							else {
								//should not happen
							}
						}
					}
//						else {
//							EMFMetamodelDriver em = context.getMetaModel(modelString); //get metamodel
//							
//							if(em.containsMetaClass(elementString)) //check if metamodel contains meta class
//							{
//								EClass element = em.getMetaClass(elementString);
//								context.checkAndDisplayAnnotation(element, modelElementType);
//								
//								modelElementType.setEcoreType(element); //set ecore type
//								
//								ModelDeclarationStatement resolveDeclarationStatement = null; //declare a model declaration statement
//								
//								for(String s: context.getModelDeclarations().keySet()) //get model declaration names
//								{
//									if (em.getMetamodelName().equals(s)) { //if declaration name is equal to metamodel name, set
//										resolveDeclarationStatement = context.getModelDeclarations().get(s);
//										break;
//									}
//									else {
//										for(String alias: em.getAliases())
//										{
//											if (alias.equals(s)) { //if declaration name is equal to any alias name, set
//												resolveDeclarationStatement = context.getModelDeclarations().get(s);
//												break;
//											}
//										}
//									}
//								}
//								modelElementType.setResolvedModelDeclaration(resolveDeclarationStatement);								
//							}
//							else {
//								if (elementString.startsWith("t_")) {
//									if (modelString != null) {
//										if (em instanceof PlainXMLModel) {
//											EClass created = ((PlainXMLModel)em).getMetaClass(elementString);
//											context.checkAndDisplayAnnotation(created, modelElementType);
//											modelElementType.setEcoreType(created);
//										}
//										else {
//											if (Character.isUpperCase(elementString.charAt(0))) {
//												context.getLogBook().addError(modelElementType, elementString + " cannot be resolved to a type");
//
//											}
//											else {
//												context.getLogBook().addError(modelElementType, "MetaElement with name " + elementString + " in Meta Model " + modelString + " cannot be found");							
//											}
//										}
//									}
//								}
//								else {
//									if (Character.isUpperCase(elementString.charAt(0))) {
//										context.getLogBook().addError(modelElementType, elementString + " cannot be resolved to a type");
//
//									}
//									else {
//										context.getLogBook().addError(modelElementType, "MetaElement with name " + elementString + " in Meta Model " + modelString + " cannot be found");							
//									}
//								}
//								//handle meta class not found
//							}
//						}
						
					else {
						context.getLogBook().addError(modelElementType, "MetaModel with name " + modelString + " cannot be found");
					}
				}
				else {
					context.getLogBook().addError(modelElementType, "ModelElement cannot be null");
				}
			}
			
			//if element string is not null
			else {
				if(elementString != null)
				{
					if (context.getNumberOfModelsOfType("XML") > 1) {
						context.getLogBook().addError(modelElementType, "Multiple XML models detected, please specify one");
					}
					else {
						ArrayList<EMetamodelDriver> models = context.metamodelsDefine(elementString);
						
						if (models != null) {
							if (models.size() == 1) {
								EMetamodelDriver leModel = models.get(0);
								modelElementType.setModelName(leModel.getName());

								if (leModel instanceof EMFMetamodelDriver) {
									if (leModel.containsMetaClass(elementString)) {
										EClass element = leModel.getMetaClass(elementString);
										context.checkAndDisplayAnnotation(element, modelElementType);
										
										modelElementType.setEcoreType(element); //set ecore type
										
										ModelDeclarationStatement resolveDeclarationStatement = null; //declare a model declaration statement
										
										for(String s: context.getModelDeclarations().keySet()) //get model declaration names
										{
											if (leModel.getMetamodelName().equals(s)) { //if declaration name is equal to metamodel name, set
												resolveDeclarationStatement = context.getModelDeclarations().get(s);
												break;
											}
											else {
												for(String alias: leModel.getAliases())
												{
													if (alias.equals(s)) { //if declaration name is equal to any alias name, set
														resolveDeclarationStatement = context.getModelDeclarations().get(s);
														break;
													}
												}
											}
										}
										modelElementType.setResolvedModelDeclaration(resolveDeclarationStatement);								
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
										if (leModel.containsMetaClass(elementString)) {
											EClass element = leModel.getMetaClass(elementString);
											context.checkAndDisplayAnnotation(element, modelElementType);
											
											modelElementType.setEcoreType(element); //set ecore type
											
											ModelDeclarationStatement resolveDeclarationStatement = null; //declare a model declaration statement
											
											for(String s: context.getModelDeclarations().keySet()) //get model declaration names
											{
												if (leModel.getMetamodelName().equals(s)) { //if declaration name is equal to metamodel name, set
													resolveDeclarationStatement = context.getModelDeclarations().get(s);
													break;
												}
												else {
													for(String alias: leModel.getAliases())
													{
														if (alias.equals(s)) { //if declaration name is equal to any alias name, set
															resolveDeclarationStatement = context.getModelDeclarations().get(s);
															break;
														}
													}
												}
											}
											modelElementType.setResolvedModelDeclaration(resolveDeclarationStatement);								
										}
										else {
											context.getLogBook().addError(modelElementType, elementString + " cannot be resolved to a type");
										}
									}
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
