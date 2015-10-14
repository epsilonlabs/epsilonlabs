package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.EolFactory;
import org.eclipse.epsilon.eol.metamodel.FormalParameterExpression;
import org.eclipse.epsilon.eol.metamodel.ModelDeclarationStatement;
import org.eclipse.epsilon.eol.metamodel.ModelType;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.NameExpressionVisitor;
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.eol.problem.imessages.IMessage_TypeResolution;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util.TypeUtil;

public class NameExpressionTypeResolver extends NameExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(NameExpression nameExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		//get the name of the name expression
		String nameString = nameExpression.getName();
		
		//if the name is a keyword, create corresponding type, resolve the type, and return
		if (context.getTypeUtil().isTypeKeyWord(nameString)) { //if name expression is keyword then resolve type immediately
			AnyType type = context.getTypeUtil().createType(nameString);
			
			//if type is null, report error
			if (type == null) {
				LogBook.getInstance().addError(nameExpression, IMessage_TypeResolution.bindMessage(IMessage_TypeResolution.TYPE_CANNOT_BE_RESOLVED,  nameString));
			}
			else {
				//set resolved type and then resolve the type
				nameExpression.setResolvedType(type);
				context.copyLocation(type, nameExpression);
				controller.visit(nameExpression.getResolvedType(), context);
			}
			return null;
		}
		
		if (nameString.equals("null")) { //if name is null, create anytype then return
			AnyType anyType = EolFactory.eINSTANCE.createAnyType();
			nameExpression.setResolvedType(EcoreUtil.copy(anyType));
			context.copyLocation(anyType, nameExpression);
			return null;
		}

		
		//set the resolved type of the name to be Any first
		AnyType anyType = EolFactory.eINSTANCE.createAnyType();
		context.setAssets(anyType, nameExpression);
		nameExpression.setResolvedType(anyType);
		
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
					modelType.setResolvedIMetamodel(stmt.getIMetamodel());

				}
				context.copyLocation(modelType, nameExpression);
				
				//set resolved type and return
				nameExpression.setResolvedType(modelType);
				return null;
			}
			else {
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
						modelType.setResolvedIMetamodel(stmt.getIMetamodel());
						
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
						//if variable is of anytype
						if (TypeUtil.getInstance().isInstanceofAnyType(content.getResolvedType())) {
							//get the types in the type registry
							ArrayList<Type> types = context.getTypeRegistry().getTypesForVariable(content);
							//get the resolved type
							AnyType contentType = (AnyType) content.getResolvedType();
							//clear recorded dynamic types and add types recorded in the type registry
							contentType.getDynamicTypes().clear();
							contentType.getDynamicTypes().addAll(types);
							//nameExpression.setResolvedType(anyType);
							nameExpression.setResolvedType(EcoreUtil.copy(contentType));
						}
						else {
							Type type = null;
							
							type = EcoreUtil.copy(content.getResolvedType());
							if (type != null) {
								nameExpression.setResolvedType(type);
								context.setAssets(type, nameExpression); //set assets of the type
							}
							else {
								LogBook.getInstance().addError((EOLElement) resolvedContent, IMessage_TypeResolution.EXPRESSION_DOES_NOT_HAVE_A_TYPE);
							}
						}
					}
					else {
						LogBook.getInstance().addError((EOLElement) resolvedContent, IMessage_TypeResolution.RESOLVED_CONTENT_NOT_VAR);
					}
					return null;
				}
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
