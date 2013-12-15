package org.eclipse.epsilon.eol.dom.visitor.resolution.type.impl;

import metamodel.connectivity.EMetaModel;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.dom.AnyType;
import org.eclipse.epsilon.eol.dom.AssignmentStatement;
import org.eclipse.epsilon.eol.dom.BooleanExpression;
import org.eclipse.epsilon.eol.dom.FormalParameterExpression;
import org.eclipse.epsilon.eol.dom.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.dom.ModelElementType;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.OperatorExpression;
import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.dom.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.NameExpressionVisitor;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.context.TypeResolutionContext;

public class NameExpressionTypeResolver extends NameExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(NameExpression nameExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		
		String nameString = nameExpression.getName();
		nameExpression.setResolvedType(EcoreUtil.copy(context.getEolFactory().createAnyType()));
		
		if (context.getTypeUtil().isKeyWordSimple(nameString)) {
			nameExpression.setResolvedType(context.getTypeUtil().createType(nameString));
			return null;
		}
		
		if(nameExpression.getResolvedContent() != null) //if name has a resolved content, this should be a var
		{
			if(nameExpression.getResolvedContent() instanceof VariableDeclarationExpression ||
					nameExpression.getResolvedContent() instanceof FormalParameterExpression) //if resolvedContent is a var
			{
				VariableDeclarationExpression content = (VariableDeclarationExpression) nameExpression.getResolvedContent();
				Type typeCopy = null;
				if (content.getLastDefinitionPoint() != null) {
					if (content.getLastDefinitionPoint().equals(content)) {
						typeCopy = EcoreUtil.copy(content.getResolvedType()); //copy the resolvedType of the var
					}
					else if (content.getLastDefinitionPoint() instanceof AssignmentStatement) {
						AssignmentStatement stmt = (AssignmentStatement) content.getLastDefinitionPoint();
						NameExpression expression = (NameExpression) stmt.getLhs();
						typeCopy = EcoreUtil.copy(expression.getResolvedType()); //copy the resolvedType of the var
					}
					

				}
				else {
					typeCopy = EcoreUtil.copy(content.getResolvedType()); 
				}
				
				if (typeCopy instanceof AnyType) {
					if (nameExpression.getContainer() instanceof AssignmentStatement) {
						AssignmentStatement stmt = (AssignmentStatement) nameExpression.getContainer();
						if (stmt.getLhs().equals(nameExpression)) {
							content.setLastDefinitionPoint(stmt);
						}
					}
					else {
						if (nameExpression.getContainer() instanceof OperatorExpression){
							if (((AnyType) typeCopy).getTempType() != null) {
								typeCopy = EcoreUtil.copy(((AnyType) typeCopy).getTempType());
							}
						}
					}
				}
				
				context.setAssets(typeCopy, nameExpression); //set assets of the type
				nameExpression.setResolvedType(typeCopy); //assign the var type to the name type

				
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
		else { //if name does not have a resolved content
			if (nameString.contains("!")) { //if name is formed like A!B
				String[] arr = nameString.split("!");
				String model = arr[0];
				String element = arr[1];
				
				if(context.containsMetaModel(model)) //check if metamodel exists
				{
					EMetaModel em = context.getMetaModel(model); //fetch the metamodel
					if(em.containsMetaClass(element)) //if metaclass exists
					{
						BooleanExpression isType = context.getEolFactory().createBooleanExpression(); //prepare isType
						isType.setVal(true); //isType should be true
						context.setAssets(isType, nameExpression);
						nameExpression.setIsType(isType); //set isType for the nameExpression
						nameExpression.setResolvedContent(em.getMetaClass(element)); //setResolvedContent for nameExpression
						
						ModelElementType type = context.getEolFactory().createModelElementType(); //create modelElementType for this
						type.setModelName(em.getMetaModelName()); //set model name
						type.setElementName(element); //set element name
						type.setEcoreType(em.getMetaClass(element));
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
				
			
			else if(context.numberOfMetamodelsDefine(nameString) > 0) //if name is a modelElementName
			{
				if(context.numberOfMetamodelsDefine(nameString) == 1)
				{
					EMetaModel em = context.getMetaModelDefiningMetaClass(nameString);
					
					BooleanExpression isType = context.getEolFactory().createBooleanExpression(); //prepare isType
					isType.setVal(true); //isType should be true
					context.setAssets(isType, nameExpression);
					nameExpression.setIsType(isType); //set isType for the nameExpression
					nameExpression.setResolvedContent(em.getMetaClass(nameString)); //setResolvedContent for nameExpression
					
					ModelElementType type = context.getEolFactory().createModelElementType(); //create modelElementType for this
					type.setModelName(em.getMetaModelName()); //set model name
					type.setElementName(nameString); //set element name
					type.setEcoreType(em.getMetaClass(nameString));
					context.setAssets(type, nameExpression); //set assets
					type.setResolvedModelDeclaration(context.getModelDeclarationStatement(em.getMetaModelName())); //set resolved model declaration statement
					nameExpression.setResolvedType(type);
				}
				else {
					//handle metaclasses defined in multiple metamodels
				}
			}
			
			else if (nameExpression.getContainer() instanceof ModelDeclarationStatement) {
				
			}
			else if (nameExpression.getContainer() instanceof VariableDeclarationExpression) {
				
			}
			else {
				context.getLogBook().addError(nameExpression, "Name is not defined");
			}
			
		}

		return null;
	}

}
