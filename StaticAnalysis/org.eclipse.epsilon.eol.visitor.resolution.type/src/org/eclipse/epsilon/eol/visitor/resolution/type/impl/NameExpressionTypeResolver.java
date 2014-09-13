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
		
		//get the name of the name expression
		String nameString = nameExpression.getName();
		
		//if the container is an variableDeclarationExpression, should return, as we don't need 
		if (nameExpression.getContainer() instanceof VariableDeclarationExpression) {
			return null;
		}
		
		//if the name is a keyword, create corresponding type and return 
		if (context.getTypeUtil().isKeyWordSimple(nameString)) { //if name expression is keyword then resolve type immediately
			nameExpression.setResolvedType(context.getTypeUtil().createType(nameString));
			return null;
		}
		
		//set the resolved type of the name to be Any first
		nameExpression.setResolvedType(EcoreUtil.copy(context.getEolFactory().createAnyType()));
		
		//if name has a resolved content
		if(nameExpression.getResolvedContent() != null) 
		{
			//obtain the resolved content
			Object resolvedContent = nameExpression.getResolvedContent();
			
			//if variable's resolved content is an ArrayList, it is surely defined in model declaration statement
			if(resolvedContent instanceof ArrayList<?>) { 
				
				//create model type
				ModelType modelType = context.getEolFactory().createModelType();
				
				//for all of the variables in the resolved content
				for(VariableDeclarationExpression var: (ArrayList<VariableDeclarationExpression>)resolvedContent)
				{
					//get the containing statement
					ModelDeclarationStatement stmt = getContainingModelDeclarationStatement(var);
					
					//add model to model type
					modelType.getModels().add(stmt);
				}
				context.copyLocation(modelType, nameExpression);
				
				//set resolved type and return
				nameExpression.setResolvedType(modelType);
				return null;
			}
			
			//if variable is defined in model declaration statement
			if(definedInModelDeclarationStatement((EolElement) resolvedContent)) { 
				
				//if single
				if (resolvedContent instanceof VariableDeclarationExpression) {
					
					//create model type
					ModelType modelType = context.getEolFactory().createModelType();
					
					//get the containing model declaration
					ModelDeclarationStatement stmt = getContainingModelDeclarationStatement((EolElement) resolvedContent);
					
					//set the location
					context.copyLocation(modelType, nameExpression); 
					
					//add the model to the model type
					modelType.getModels().add(stmt); 
					
					//set resolved type
					nameExpression.setResolvedType(EcoreUtil.copy(modelType)); 
					return null;
				}
				else {
					//this should not happen
					return null;
				}
			}
			//if variable is defined elsewhere rather than model declaration
			else { 
				//if resolvedContent is a var
				if(nameExpression.getResolvedContent() instanceof VariableDeclarationExpression ||
						nameExpression.getResolvedContent() instanceof FormalParameterExpression) 
				{
					VariableDeclarationExpression content = (VariableDeclarationExpression) resolvedContent;
					Type type = null;
					
					//if optimistic is set
					if (context.getPessimistic()) {
						
						//if the current frame does not contain the expression, this is to cater the branching situations such as if/else, while, for, switch, etc
						if (!context.getStack().contentInSameScope(nameExpression)) {
							//add to best guess
							context.addBestGuessVariableDeclaration(content);
							context.getLogBook().addWarning(nameExpression, "The type of this expression is at the best guess of the type inferrence system");
						}
						
						//get the last definition point
						Object lastDefinitionPoint = content.getLastDefinitionPoint();
						
						//if last definition point is not null
						if (lastDefinitionPoint != null) {
							
							//if last definition point is the content itself
							if (lastDefinitionPoint.equals(content)) { 
								type = EcoreUtil.copy(content.getResolvedType());
							}
							//if the last definition point is an assignment statement
							else if (lastDefinitionPoint instanceof AssignmentStatement) {
								//copy the rhs of the assignment to the current type
								AssignmentStatement stmt = (AssignmentStatement) content.getLastDefinitionPoint();
								Expression expression = stmt.getRhs();
								type = EcoreUtil.copy(expression.getResolvedType());
							}
						}
						//if the last definition point is null
						else {
							//get the type of the resolved content
							type = EcoreUtil.copy(content.getResolvedType());
							//if the content is a best guess variable declaration do nothing
							if (context.containsBestGuessVariableDeclaration(content)) {
								
							}
							//if the content is not in the best guess variable list
							else {
								//if the type is any (it only matters if it is AnyType, other types will throw type incompatibility errors)
								if (type instanceof AnyType) {
									
									//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Other operations can also define collection, need elaborative handling
									
									//if the name expression is in an assignment statement
									if (nameExpression.getContainer() instanceof AssignmentStatement) {
										AssignmentStatement stmt = (AssignmentStatement) nameExpression.getContainer();
										//if it is on the left hand side, then set the last definition point, but do not set the type because it is pessimistic
										if (stmt.getLhs().equals(nameExpression)) {
											content.setLastDefinitionPoint(stmt);
										}
									}
									//if the name expression is not in an assignemnt statement
									else {
										//if it is in an operator expression
										if (nameExpression.getContainer() instanceof OperatorExpression){ 
											//get the dynamic type
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
				context.copyLocation(anyType, nameExpression);
				nameExpression.setResolvedType(EcoreUtil.copy(anyType));
				return null;
			}
			//if name is formed like A!B
			else if (nameString.contains("!")) {
				//split the string by "!"
				String[] arr = nameString.split("!");
				//model is model
				String model = arr[0];
				//element is element
				String element = arr[1];
				
				//check if metamodel exists
				if(context.containsMetaModel(model)) 
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
							ModelElementType type = context.getEolFactory().createModelElementType(); //create modelElementType for this
							nameExpression.setResolvedType(type);
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
	
	//check if an eolElement is defined in a model declaration statement
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
	
	public Type getDynamicType(AnyType anyType)
	{
		AnyType result = anyType;
		while(result.getDynamicType() != null)
		{
			if (result.getDynamicType() instanceof AnyType) {
				result = (AnyType) anyType.getDynamicType();
			}
			else {
				return result.getDynamicType();
			}
		}
		return result;
	}

	
}
