package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.EolFactory;
import org.eclipse.epsilon.eol.metamodel.FormalParameterExpression;
import org.eclipse.epsilon.eol.metamodel.InvalidType;
import org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.metamodel.ModelType;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.NameExpressionVisitor;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_TypeResolution;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class NameExpressionTypeResolver_t1 extends NameExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(NameExpression nameExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		//get the name of the name expression
		String nameString = nameExpression.getName();
		
		//if the name is a keyword, create corresponding type and return 
		if (context.getTypeUtil().isKeyWord(nameString)) { //if name expression is keyword then resolve type immediately
			AnyType type = context.getTypeUtil().createType(nameString);
			if (type == null) {
				context.getLogBook().addError(nameExpression, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.TYPE_CANNOT_BE_RESOLVED,  nameString));
			}
			else {
				nameExpression.setResolvedType(context.getTypeUtil().createType(nameString));
				context.copyLocation(type, nameExpression);
				controller.visit(nameExpression.getResolvedType(), context);
			}
			return null;
		}
		
		if (nameString.equals("null")) { //if name is null then it is the keyword
			InvalidType invalidType = EolFactory.eINSTANCE.createInvalidType();
			nameExpression.setResolvedType(EcoreUtil.copy(invalidType));
			context.copyLocation(invalidType, nameExpression);
			return null;
		}

		
		//set the resolved type of the name to be Any first
		nameExpression.setResolvedType(EcoreUtil.copy(EolFactory.eINSTANCE.createAnyType()));
		
		//if name has a resolved content
		if(nameExpression.getResolvedContent() != null) 
		{
			//obtain the resolved content
			Object resolvedContent = nameExpression.getResolvedContent();
			
			//if variable's resolved content is an ArrayList, it is surely defined in model declaration statement
			if(resolvedContent instanceof ArrayList<?>) {
				
				//create model type
				ModelType modelType = EolFactory.eINSTANCE.createModelType();
				
				//for all of the variables in the resolved content
				for(VariableDeclarationExpression var: (ArrayList<VariableDeclarationExpression>)resolvedContent)
				{
					//get the containing statement
					ModelDeclarationStatement stmt = getContainingModelDeclarationStatement(var);
					
					//add model to model type					
					modelType.setResolvedIModel(stmt.getImodel());

				}
				context.copyLocation(modelType, nameExpression);
				
				//set resolved type and return
				nameExpression.setResolvedType(modelType);
				return null;
			}
			
			//if variable is defined in model declaration statement
			if(definedInModelDeclarationStatement((EOLElement) resolvedContent)) {
				
				//if single
				if (resolvedContent instanceof VariableDeclarationExpression) {
					
					//create model type
					ModelType modelType = EolFactory.eINSTANCE.createModelType();
					
					//get the containing model declaration
					ModelDeclarationStatement stmt = getContainingModelDeclarationStatement((EOLElement) resolvedContent);
					
					//set the location
					context.copyLocation(modelType, nameExpression); 
					
					//add the model to the model type
					modelType.setResolvedIModel(stmt.getImodel());
					
					//set resolved type
					nameExpression.setResolvedType(modelType); 
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
					
					type = EcoreUtil.copy(content.getResolvedType());
					if (type != null) {
						nameExpression.setResolvedType(type);
						context.setAssets(type, nameExpression); //set assets of the type
					}
					else {
						context.getLogBook().addError((EOLElement) resolvedContent, IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
					}
				}
				else {
					context.getLogBook().addError((EOLElement) resolvedContent, IMessage_TypeResolution.RESOLVED_CONTENT_NOT_VAR);
				}
				return null;
			}
		}
		return null;
	}
	
	public ModelDeclarationStatement getContainingModelDeclarationStatement(EOLElement eolElement)
	{
		EOLElement container = eolElement;
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
	public boolean definedInModelDeclarationStatement(EOLElement eolElement)
	{
		EOLElement container = eolElement;
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
