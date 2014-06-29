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
		
		String modelString = modelElementType.getModelName(); //get the string for model
		String elementString = modelElementType.getElementName(); //get the string for element
		
		if (modelString == null && elementString.equals("_ModelElementType_")) { //if keyword _ModelElementType_ is found, then return null, do nothing
			return null;
		}
		
		if (context.getContainer().getMetaModels().size() == 0) { //if no metamodel is declared, report error
			context.getLogBook().addError(modelElementType, "No metamodel has been defined, please define metamodels");
		}
		
		else {
			if (modelString != null) { //if model name is not null
				if (elementString != null) {
					if (context.containsMetaModel(modelString)) {
						ArrayList<EMetamodelDriver> models = context.getMetaModelsWithAlias(modelString); //if there are multiple metamodels
						if (models != null) {
							if (models.size() == 1) {
								EMetamodelDriver leModel = models.get(0);
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
								//need more elaborative handling
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
			
			else {
				if(elementString != null)
				{
					if (context.getNumberofPlainXMLModels() > 1) {
						context.getLogBook().addError(modelElementType, "Multiple XML models detected, please specify one");
					}
					else {
						ArrayList<EMetamodelDriver> models = context.metamodelsDefine(elementString);
						
						if (models != null) {
							if (models.size() == 1) {
								EMetamodelDriver leModel = models.get(0);
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
