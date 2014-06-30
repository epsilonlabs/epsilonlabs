package org.eclipse.epsilon.eol.visitor.resolution.type.impl;

import java.util.ArrayList;

import metamodel.connectivity.abstractmodel.EMetamodelDriver;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.NameExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;

public class NameExpressionTypeResolver extends NameExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(NameExpression nameExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		String nameString = nameExpression.getName();
		nameExpression.setResolvedType(EcoreUtil.copy(context.getEolFactory().createAnyType()));
		
		if (nameExpression.getContainer() instanceof VariableDeclarationExpression) {
			return null;
		}

		if (context.getTypeUtil().isKeyWordSimple(nameString)) { //if name expression is keyword then resolve type immediately
			nameExpression.setResolvedType(context.getTypeUtil().createType(nameString));
			return null;
		}
		
		
		if(nameExpression.getResolvedContent() != null) //if name has a resolved content
		{
			Object resolvedContent = (EolElement) nameExpression.getResolvedContent();
			if (resolvedContent instanceof ArrayList<?>) { //if variable's resolved content is an arraylist, it is defined in model delcaration statement
				ModelType modelType = context.getEolFactory().createModelType();
				for(VariableDeclarationExpression var: (ArrayList<VariableDeclarationExpression>)resolvedContent)
				{
					ModelDeclarationStatement stmt = getContainingModelDeclarationStatement(var);
					modelType.getModels().add(stmt);
				}
				context.setLocation(modelType, nameExpression);
				nameExpression.setResolvedType(modelType);
				return null;
			}
			if (definedInModelDeclarationStatement((EolElement) resolvedContent)) { //if variable is defined in model declaration statement
				if (resolvedContent instanceof VariableDeclarationExpression) { //if single
					ModelType modelType = context.getEolFactory().createModelType(); //create model type
					ModelDeclarationStatement stmt = getContainingModelDeclarationStatement((EolElement) resolvedContent); //get the containing model declaration
					context.setLocation(modelType, nameExpression); //set the location
					modelType.getModels().add(stmt); //add the model to the model type
					nameExpression.setResolvedType(EcoreUtil.copy(modelType)); //set resolved type
					return null;
				}
				else {
					//this should not happen
				}
			}
			else { //if variable is defined elsewhere rather than model declaration
				if(nameExpression.getResolvedContent() instanceof VariableDeclarationExpression ||
						nameExpression.getResolvedContent() instanceof FormalParameterExpression) //if resolvedContent is a var
				{
					VariableDeclarationExpression content = (VariableDeclarationExpression) resolvedContent;
					Type type = null;
					if (context.getPessimistic() == true) { //if optimistic is set
						if (!context.getStack().contentInSameScope(nameExpression)) {
							context.addBestGuessVariableDeclaration(content);
							context.getLogBook().addWarning(nameExpression, "The type of this expression is at the best guess of the type inferrence system");
						}
						Object lastDefinitionPoint = content.getLastDefinitionPoint();
						if (lastDefinitionPoint != null) {
							if (lastDefinitionPoint.equals(content)) { //if last definition point is the content itself
								type = EcoreUtil.copy(content.getResolvedType());
							}
							else if (lastDefinitionPoint instanceof AssignmentStatement) { //if the last definition point is an assignment statement
								AssignmentStatement stmt = (AssignmentStatement) content.getLastDefinitionPoint();
								NameExpression expression = (NameExpression) stmt.getRhs();
								type = EcoreUtil.copy(expression.getResolvedType());
							}
						}
						else {
							type = EcoreUtil.copy(content.getResolvedType()); 
							if (context.containsBestGuessVariableDeclaration(content)) {
								
							}
							else {
								if (type instanceof AnyType) {
									if (nameExpression.getContainer() instanceof AssignmentStatement) {
										AssignmentStatement stmt = (AssignmentStatement) nameExpression.getContainer();
										if (stmt.getLhs().equals(nameExpression)) {
											content.setLastDefinitionPoint(stmt);
										}
									}
									else {
										if (nameExpression.getContainer() instanceof OperatorExpression){
											if (((AnyType) type).getDynamicType() != null) {
												type = EcoreUtil.copy(((AnyType) type).getDynamicType());
											}
										}
									}
								}
							}
						}
					}
					else{ //if optimistic is unset
						type = EcoreUtil.copy(content.getResolvedType());
						if (type != null) {
							nameExpression.setResolvedType(type);
						}
						else {
							context.getLogBook().addError((EolElement) resolvedContent, "Expression does not have a type");
						}
					}
					if (type != null) {
						context.setAssets(type, nameExpression); //set assets of the type
						nameExpression.setResolvedType(type); //assign the var type to the name type
					}
				}
				else {
					//should not happen...
				}
				return null;

			}
			
			
		}
		else { //if name does not have a resolved content
			if (nameString.equals("null")) { //if name is null then it is the keyword
				AnyType anyType = context.getEolFactory().createAnyType();
				context.setLocation(anyType, nameExpression);
				nameExpression.setResolvedType(EcoreUtil.copy(anyType));
			}
			else if (nameString.contains("!")) { //if name is formed like A!B
				String[] arr = nameString.split("!");
				String model = arr[0];
				String element = arr[1];
				
				if(context.containsMetaModel(model)) //check if metamodel exists
				{
					ArrayList<EMetamodelDriver> models = context.getMetaModelsWithAlias(model);
					if (models != null) {
						if (models.size() == 1) {
							EMetamodelDriver leModel = models.get(0);
							if(leModel.containsMetaClass(element)) //if metaclass exists
							{
								BooleanExpression isType = context.getEolFactory().createBooleanExpression(); //prepare isType
								isType.setVal(true); //isType should be true
								context.setAssets(isType, nameExpression);
								nameExpression.setIsType(isType); //set isType for the nameExpression
								nameExpression.setResolvedContent(leModel.getMetaClass(element)); //setResolvedContent for nameExpression
								
								EClass ecoreType = leModel.getMetaClass(element);
								context.checkAndDisplayAnnotation(ecoreType, nameExpression);
								
								ModelElementType type = context.getEolFactory().createModelElementType(); //create modelElementType for this
								type.setModelName(leModel.getMetamodelName()); //set model name
								type.setElementName(element); //set element name
								type.setEcoreType(ecoreType);
								context.setAssets(type, nameExpression); //set assets
								type.setResolvedModelDeclaration(context.getModelDeclarationStatement(model)); //set resolved model declaration statement
								nameExpression.setResolvedType(type);
							}
							else {
								context.getLogBook().addError(nameExpression, "MetaElement with name " + element + " in Meta Model " + model + " cannot be found");
							}
						}
						else {
							//handle multiple metamodel
						}
					}
					else {
						EMetamodelDriver em = context.getMetaModel(model); //fetch the metamodel
						if(em.containsMetaClass(element)) //if metaclass exists
						{
							BooleanExpression isType = context.getEolFactory().createBooleanExpression(); //prepare isType
							isType.setVal(true); //isType should be true
							context.setAssets(isType, nameExpression);
							nameExpression.setIsType(isType); //set isType for the nameExpression
							nameExpression.setResolvedContent(em.getMetaClass(element)); //setResolvedContent for nameExpression
							
							EClass ecoreType = em.getMetaClass(element);
							context.checkAndDisplayAnnotation(ecoreType, nameExpression);
							
							ModelElementType type = context.getEolFactory().createModelElementType(); //create modelElementType for this
							type.setModelName(em.getMetamodelName()); //set model name
							type.setElementName(element); //set element name
							type.setEcoreType(ecoreType);
							context.setAssets(type, nameExpression); //set assets
							type.setResolvedModelDeclaration(context.getModelDeclarationStatement(model)); //set resolved model declaration statement
							nameExpression.setResolvedType(type);
						}
						else {
							context.getLogBook().addError(nameExpression, "MetaElement with name " + element + " in Meta Model " + model + " cannot be found");
						}
					}
				}
				else {
					context.getLogBook().addError(nameExpression, "MetaModel with name " + model + " cannot be found");
					//handle metamodel not found
				}
			}
				
			
			else if(context.numberOfMetamodelsDefine(nameString, true) > 0) //if name is a modelElementName
			{
				if (context.getTypeUtil().isXMLSyntax(nameString) && context.getNumberofPlainXMLModels() > 1) {
					context.getLogBook().addError(nameExpression, "Multiple XML models detected, please specify one");
					return null;
				}
				ArrayList<EMetamodelDriver> models = context.metamodelsDefine(nameString);
				if (models != null) {
					if (models.size() == 1) {
						EMetamodelDriver leModel = models.get(0);
						if(leModel.containsMetaClass(nameString)) //if metaclass exists
						{
							BooleanExpression isType = context.getEolFactory().createBooleanExpression(); //prepare isType
							isType.setVal(true); //isType should be true
							context.setAssets(isType, nameExpression);
							nameExpression.setIsType(isType); //set isType for the nameExpression
							nameExpression.setResolvedContent(leModel.getMetaClass(nameString)); //setResolvedContent for nameExpression
							
							EClass ecoreType = leModel.getMetaClass(nameString);
							context.checkAndDisplayAnnotation(ecoreType, nameExpression);
							
							ModelElementType type = context.getEolFactory().createModelElementType(); //create modelElementType for this
							type.setModelName(leModel.getMetamodelName()); //set model name
							type.setElementName(nameString); //set element name
							type.setEcoreType(ecoreType);
							context.setAssets(type, nameExpression); //set assets
							type.setResolvedModelDeclaration(context.getModelDeclarationStatement(leModel.getName())); //set resolved model declaration statement
							nameExpression.setResolvedType(type);
						}
						else {
							context.getLogBook().addError(nameExpression, "MetaElement with name " + nameString + " cannot be found");
						}
					}
					else {
						context.getLogBook().addError(nameExpression, "metaElement: " + nameString + " is defined in multiple metamodels");
					}
				}
				else {
					if(context.numberOfMetamodelsDefine(nameString, true) == 1)
					{
						EMetamodelDriver em = context.getMetaModelDefiningMetaClass(nameString);
						
						BooleanExpression isType = context.getEolFactory().createBooleanExpression(); //prepare isType
						isType.setVal(true); //isType should be true
						context.setAssets(isType, nameExpression);
						nameExpression.setIsType(isType); //set isType for the nameExpression
						nameExpression.setResolvedContent(em.getMetaClass(nameString)); //setResolvedContent for nameExpression
						
						ModelElementType type = context.getEolFactory().createModelElementType(); //create modelElementType for this
						type.setModelName(em.getMetamodelName()); //set model name
						type.setElementName(nameString); //set element name
						type.setEcoreType(em.getMetaClass(nameString));
						context.setAssets(type, nameExpression); //set assets
						type.setResolvedModelDeclaration(context.getModelDeclarationStatement(em.getMetamodelName())); //set resolved model declaration statement
						nameExpression.setResolvedType(type);
					}
					else {
						if (context.getTypeUtil().isXMLSyntax(nameString)) {
							context.getLogBook().addError(nameExpression, "Multiple XML models detected, please specify one");
						}
					}
				}
			}
			
			else {
				context.getLogBook().addError(nameExpression, "Name is not defined");
			}
			
		}

		return null;
	}
	
	public ModelDeclarationStatement getContainingModelDeclarationStatement(EolElement eolElement)
	{
		EolElement container = eolElement;
		while(container != null)
		{
			if (container instanceof ModelDeclarationStatement) {
				return (ModelDeclarationStatement) container;
			}
			else {
				container = container.getContainer();
			}
		}
		return null;
	}
	
	public boolean definedInModelDeclarationStatement(EolElement eolElement)
	{
		EolElement container = eolElement;
		while(container!=null)
		{
			if (container instanceof ModelDeclarationStatement) {
				return true;
			}
			else {
				container = container.getContainer();	
			}
		}
		return false;
	}
	
}
