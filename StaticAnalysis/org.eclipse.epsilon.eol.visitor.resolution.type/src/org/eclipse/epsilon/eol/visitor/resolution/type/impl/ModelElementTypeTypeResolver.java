package org.eclipse.epsilon.eol.visitor.resolution.type.impl;

import metamodel.connectivity.emf.EMFMetamodelDriver;
import metamodel.connectivity.plainxml.PlainXMLModel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
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
		
		if (elementString.equals("_ModelElementType_")) {
			return null;
		}
		
		if (context.getContainer().getMetaModels().size() == 0) {
			context.getLogBook().addError(modelElementType, "No metamodel has been defined, please define metamodels");
		}
		
		else {
			if (modelString != null) { //if model name is not null
				if (elementString != null) {
					if (context.containsMetaModel(modelString)) { //check if metamodel is declared
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
							EMFMetamodelDriver em = context.getMetaModel(modelString); //get metamodel
							
							if(em.containsMetaClass(elementString)) //check if metamodel contains meta class
							{
								//EClass classifier = em.getMetaClass(elementString);
								//if (!classifier.isAbstract() && !classifier.isInterface()) {
								EClass element = em.getMetaClass(elementString);
								context.checkAndDisplayAnnotation(element, modelElementType);
									modelElementType.setEcoreType(element); //set ecore type
									ModelDeclarationStatement resolveDeclarationStatement = null; //declare a model declaration statement
									for(String s: context.getModelDeclarations().keySet()) //get model declaration names
									{
										if (em.getMetamodelName().equals(s)) { //if declaration name is equal to metamodel name, set
											resolveDeclarationStatement = context.getModelDeclarations().get(s);
											break;
										}
										else {
											for(String alias: em.getAliases())
											{
												if (alias.equals(s)) { //if declaration name is equal to any alias name, set
													resolveDeclarationStatement = context.getModelDeclarations().get(s);
													break;
												}
											}
										}
									}
									modelElementType.setResolvedModelDeclaration(resolveDeclarationStatement);
								//}
								//else {
								//	context.getLogBook().addError(modelElementType, "Meta Class: " + modelString + "!" + elementString + " is not instantiable");
								//}
								
							}
							else {
								if (elementString.startsWith("t_")) {
									if (modelString != null) {
										if (em instanceof PlainXMLModel) {
											EClass created = ((PlainXMLModel)em).getMetaClass(elementString);
											context.checkAndDisplayAnnotation(created, modelElementType);
											modelElementType.setEcoreType(created);
										}
										else {
											if (Character.isUpperCase(elementString.charAt(0))) {
												context.getLogBook().addError(modelElementType, elementString + " cannot be resolved to a type");

											}
											else {
												context.getLogBook().addError(modelElementType, "MetaElement with name " + elementString + " in Meta Model " + modelString + " cannot be found");							
											}
										}
									}
								}
								else {
									if (Character.isUpperCase(elementString.charAt(0))) {
										context.getLogBook().addError(modelElementType, elementString + " cannot be resolved to a type");

									}
									else {
										context.getLogBook().addError(modelElementType, "MetaElement with name " + elementString + " in Meta Model " + modelString + " cannot be found");							
									}
								}
								//handle meta class not found
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
			
			else {
				if(elementString != null)
				{
					if(context.numberOfMetamodelsDefine(elementString, false) > 0) //if name is a modelElementName
					{
						if (elementString.startsWith("b_") ||
								elementString.startsWith("f_") ||
								elementString.startsWith("d_") ||
								elementString.startsWith("i_") ||
								elementString.startsWith("s_") ||
								elementString.startsWith("c_") ||
								elementString.startsWith("x_") ||
								elementString.startsWith("a_") ||
								elementString.startsWith("e_") ) {
							context.getLogBook().addError(modelElementType, "model element type cannot be denoted with prefix: " + elementString.substring(0,2));
						}
						else
						{
							if(context.numberOfMetamodelsDefine(elementString, false) == 1)
							{
								EMFMetamodelDriver em = context.getMetaModelDefiningMetaClass(elementString);
								modelElementType.setModelName(em.getMetamodelName());
								modelElementType.setEcoreType(em.getMetaClass(elementString));
								//EClass classifier = em.getMetaClass(elementString);
								//if (!classifier.isAbstract() && !classifier.isInterface()) {
									ModelDeclarationStatement resolveDeclarationStatement = null;
									for(String s: context.getModelDeclarations().keySet())
									{
										if (em.getMetamodelName().equals(s)) {
											resolveDeclarationStatement = context.getModelDeclarations().get(s);
											break;
										}
										else {
											for(String alias: em.getAliases())
											{
												if (alias.equals(s)) {
													resolveDeclarationStatement = context.getModelDeclarations().get(s);
													break;
												}
											}
										}
									}
									modelElementType.setResolvedModelDeclaration(resolveDeclarationStatement);
								//}
								//else {
									//context.getLogBook().addError(modelElementType, "Meta Class: " + elementString + " is not instantiable");

								//}
							}
							else {
								context.getLogBook().addWarning(modelElementType, "MetaElement with name " + elementString + " is defined in multiple metamodels");
								//handle metaclasses defined in multiple metamodels
							}
						}
					}
					else {
						if (elementString.startsWith("t_")) {
							if (context.getNumberofPlainXMLModels() == 1) {
								PlainXMLModel xmlModel = context.getOneXMLModel();
								EClass created = ((PlainXMLModel)xmlModel).getMetaClass(elementString);
								modelElementType.setEcoreType(created);
							}
							else {
								context.getLogBook().addError(modelElementType, "Multiple XML models detected, please specify one");
							}
						}
						else {
							if (!Character.isUpperCase(elementString.charAt(0))) {
								context.getLogBook().addError(modelElementType, elementString + " cannot be resolved to a type");
							}
							else {
								context.getLogBook().addError(modelElementType, "MetaElement with name " + elementString + " cannot be found");							
							}
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
	
	public boolean isXMLSyntax(String fullName)
	{
		if (fullName.startsWith("a_") || fullName.startsWith("b_") ||
				fullName.startsWith("i_") || fullName.startsWith("f_") || 
				fullName.startsWith("d_") || fullName.startsWith("s_") ||
				fullName.startsWith("t_") || fullName.startsWith("c_") ||
				fullName.startsWith("e_") || fullName.startsWith("x_"))
		{
			return true;
		}
		else {
			return false;
		}
	}

	

}
