package org.eclipse.epsilon.eol.dom.visitor.resolution.type.impl;

import metamodel.connectivity.EMetaModel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.epsilon.eol.dom.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.dom.ModelElementType;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.ModelElementTypeVisitor;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;

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
		
		if (modelString != null) { //if model name is not null
			if (elementString != null) {
				if (context.containsMetaModel(modelString)) { //check if metamodel is declared
					EMetaModel em = context.getMetaModel(modelString); //get metamodel
					
					if(em.containsMetaClass(elementString)) //check if metamodel contains meta class
					{
						//EClass classifier = em.getMetaClass(elementString);
						//if (!classifier.isAbstract() && !classifier.isInterface()) {
							modelElementType.setEcoreType(em.getMetaClass(elementString)); //set ecore type
							ModelDeclarationStatement resolveDeclarationStatement = null; //declare a model declaration statement
							for(String s: context.getModelDeclarations().keySet()) //get model declaration names
							{
								if (em.getMetaModelName().equals(s)) { //if declaration name is equal to metamodel name, set
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
						if (Character.isUpperCase(elementString.charAt(0))) {
							context.getLogBook().addError(modelElementType, elementString + " cannot be resolved to a type");

						}
						else {
							context.getLogBook().addError(modelElementType, "MetaElement with name " + elementString + " in Meta Model " + modelString + " cannot be found");							
						}
						
						//handle meta class not found
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
				if(context.numberOfMetamodelsDefine(elementString) > 0) //if name is a modelElementName
				{
					if(context.numberOfMetamodelsDefine(elementString) == 1)
					{
						EMetaModel em = context.getMetaModelDefiningMetaClass(elementString);
						modelElementType.setModelName(em.getMetaModelName());
						modelElementType.setEcoreType(em.getMetaClass(elementString));
						//EClass classifier = em.getMetaClass(elementString);
						//if (!classifier.isAbstract() && !classifier.isInterface()) {
							ModelDeclarationStatement resolveDeclarationStatement = null;
							for(String s: context.getModelDeclarations().keySet())
							{
								if (em.getMetaModelName().equals(s)) {
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
				else {
					if (!Character.isUpperCase(elementString.charAt(0))) {
						context.getLogBook().addError(modelElementType, elementString + " cannot be resolved to a type");

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
		
		return null;
	}
	

}
