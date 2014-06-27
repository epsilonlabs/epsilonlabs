package org.eclipse.epsilon.eol.visitor.resolution.type.impl;

import java.util.ArrayList;

import metamodel.connectivity.emf.EMFMetamodelDriver;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.NameExpressionVisitor;
import org.eclipse.epsilon.eol.parse.Eol_EolParserRules.elseStatement_return;
import org.eclipse.epsilon.eol.parse.Eol_EolParserRules.returnStatement_return;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;

public class NameExpressionTypeResolver extends NameExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(NameExpression nameExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		String nameString = nameExpression.getName();
		nameExpression.setResolvedType(EcoreUtil.copy(context.getEolFactory().createAnyType()));
		
		if (context.getTypeUtil().isKeyWordSimple(nameString)) { //if name expression is keyword then resolve type immediately
			nameExpression.setResolvedType(context.getTypeUtil().createType(nameString));
			return null;
		}
		
		
		if(nameExpression.getResolvedContent() != null) //if name has a resolved content
		{
			EolElement resolvedContent = (EolElement) nameExpression.getResolvedContent();
			if (resolvedContent instanceof ArrayList<?>) { //if variable's resolved content is an arraylist, it is defined in model delcaration statement
				ModelType modelType = context.getEolFactory().createModelType();
				for(VariableDeclarationExpression var: (ArrayList<VariableDeclarationExpression>)resolvedContent)
				{
					ModelDeclarationStatement stmt = getContainingModelDeclarationStatement(var);
					modelType.getModels().add(stmt);
				}
				context.setLocation(modelType, nameExpression);
				nameExpression.setResolvedType(modelType);
			}
			if (definedInModelDeclarationStatement(resolvedContent)) { //if variable is defined in model declaration statement
				if (resolvedContent instanceof VariableDeclarationExpression) { //if single
					ModelType modelType = context.getEolFactory().createModelType(); //create model type
					ModelDeclarationStatement stmt = getContainingModelDeclarationStatement(resolvedContent); //get the containing model declaration
					context.setLocation(modelType, nameExpression); //set the location
					modelType.getModels().add(stmt); //add the model to the model type
					nameExpression.setResolvedType(EcoreUtil.copy(modelType)); //set resolved type
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
					if (context.getOptimisitic() == true) { //if optimistic is set
						if (!nameExpression.isResolvedContentInSameScope()) {
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
							
							if (type instanceof AnyType) {
								if (nameExpression.getContainer() instanceof AssignmentStatement) {
									AssignmentStatement stmt = (AssignmentStatement) nameExpression.getContainer();
									if (stmt.getLhs().equals(nameExpression)) {
										content.setLastDefinitionPoint(stmt);
									}
								}
								else {
									if (nameExpression.getContainer() instanceof OperatorExpression){
										if (((AnyType) typeCopy).getDynamicType() != null) {
											typeCopy = EcoreUtil.copy(((AnyType) typeCopy).getDynamicType());
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
							return null;
						}
						else {
							context.getLogBook().addError(resolvedContent, "Expression does not have a type");
						}
					}
					
					
					if (typeCopy != null) {
						context.setAssets(typeCopy, nameExpression); //set assets of the type
						nameExpression.setResolvedType(typeCopy); //assign the var type to the name type
					}
					
					
					/*
					VariableDeclarationExpression content = (VariableDeclarationExpression) nameExpression.getResolvedContent(); //get the var
					if(!(content.getResolvedType() instanceof AnyType)) //if the type of the content is not of type Any
					{
						Type typeCopy = EcoreUtil.copy(content.getResolvedType()); //copy the resolvedType of the var
						context.setAssets(typeCopy, nameExpression); //set assets of the type
						nameExpression.setResolvedType(typeCopy); //assign the var type to the name type
					}
					else { //if the type of the content is of type Any
						if (((AnyType)content.getResolvedType()).getTempType() != null) { //if there is a tempType
							if (nameExpression.getContainer() instanceof AssignmentStatement) { //if the container of the nameExpression is an AssignmentStatement
								AssignmentStatement stmt = (AssignmentStatement) nameExpression.getContainer(); //get the statement
								if (nameExpression.equals(stmt.getLhs())) { //if name is the lhs
									Type typeCopy = EcoreUtil.copy(content.getResolvedType()); //copy the resolvedType of the var
									context.setAssets(typeCopy, nameExpression); //set assets of the type
									nameExpression.setResolvedType(typeCopy); //assign the var type to the name type
								}
								else { //if name is rhs, assign the temp type as the type of the name expression
									//Type typeCopy = EcoreUtil.copy(((AnyType)content.getResolvedType()).getTempType());
									if (content.getLastDefinitionPoint() != null) {
										if (content.getLastDefinitionPoint().equals(content)) {
											Type typeCopy = EcoreUtil.copy(((AnyType)content.getResolvedType()).getTempType());
											context.setAssets(typeCopy, nameExpression);
											nameExpression.setResolvedType(typeCopy);

										}
										else if (content.getLastDefinitionPoint() instanceof AssignmentStatement) {
											AssignmentStatement statement = (AssignmentStatement) content.getLastDefinitionPoint();
											
										}
										Type typeCopy = EcoreUtil.copy(((AnyType)content.getLastDefinitionPoint().getResolvedType()).getTempType());

									}
									Type typeCopy = EcoreUtil.copy(((AnyType)nameExpression.getResolvedType()).getTempType());
									context.setAssets(typeCopy, nameExpression);
									nameExpression.setResolvedType(typeCopy);

								}
							}
							else {
								Type typeCopy = null;
								//Type typeCopy = EcoreUtil.copy(((AnyType)content.getResolvedType()).getTempType()); //if the container is not an assignment, set temp type to the nameExpression
								if(nameExpression.getResolvedType() != null && nameExpression.getResolvedType() instanceof AnyType)
								{
									typeCopy = EcoreUtil.copy(((AnyType)nameExpression.getResolvedType()).getTempType()); //if the container is not an assignment, set temp type to the nameExpression
								}
								else {
									typeCopy = EcoreUtil.copy(((AnyType)content.getResolvedType()).getTempType()); //if the container is not an assignment, set temp type to the nameExpression
								}
								context.setAssets(typeCopy, nameExpression);
								nameExpression.setResolvedType(typeCopy);
							}
							
						}
						else { //if there is not a tempType, normally it means this name expression has just been created
							// need to handle this situation
						}
					}*/
				}
				else {
					//should not happen...
				}
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
					EMFMetamodelDriver em = context.getMetaModel(model); //fetch the metamodel
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
						//handle metclass not found
					}
				}
				else {
					context.getLogBook().addError(nameExpression, "MetaModel with name " + model + " cannot be found");
					//handle metamodel not found
				}
			}
				
			
			else if(context.numberOfMetamodelsDefine(nameString, true) > 0) //if name is a modelElementName
			{
				if(context.numberOfMetamodelsDefine(nameString, true) == 1)
				{
					EMFMetamodelDriver em = context.getMetaModelDefiningMetaClass(nameString);
					
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
			
			else if (nameExpression.getContainer() instanceof VariableDeclarationExpression) {
				
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
	
	public boolean definedInEolElement(EolElement eolElement, EClass eClass)
	{
		EolElement container = eolElement;
		while(container != null)
		{
			if (container.eClass().equals(eClass)) {
				return true;
			}
			else {
				container = container.getContainer();
			}
		}
		return false;
	}
	
	public boolean inSameProgram(EolElement e1, EolElement e2)
	{
		EolElement c1 = e1;
		EolElement c2 = e2;
		while(c1 != null)
		{
			if (c1 instanceof EolLibraryModule) {
				while(c2 != null)
				{
					if (c2 instanceof EolLibraryModule) {
						if (c1.equals(c2)) {
							return true;
						}
						else {
							return false;
						}
					}
					else {
						c2 = c2.getContainer();
					}
				}
			}
			else {
				c1 = c1.getContainer();
			}
		}
		return false;
	}
}
