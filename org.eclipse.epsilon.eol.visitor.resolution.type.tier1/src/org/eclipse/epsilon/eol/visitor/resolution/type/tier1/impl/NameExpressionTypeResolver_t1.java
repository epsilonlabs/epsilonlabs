package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.NameExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class NameExpressionTypeResolver_t1 extends NameExpressionVisitor<TypeResolutionContext, Object>{

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
		
		if (nameString.equals("null")) { //if name is null then it is the keyword
			AnyType anyType = context.getEolFactory().createAnyType();
			context.copyLocation(anyType, nameExpression);
			nameExpression.setResolvedType(EcoreUtil.copy(anyType));
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
					
					type = EcoreUtil.copy(content.getResolvedType());
					if (type != null) {
						nameExpression.setResolvedType(type);
						context.setAssets(type, nameExpression); //set assets of the type
						nameExpression.setResolvedType(type); //assign the var type to the name type
					
					}
					else {
						context.getLogBook().addError((EolElement) resolvedContent, "Expression does not have a type");
					}
				}
				else {
					context.getLogBook().addError(nameExpression, "resolved content is not a variable declaraion or a formal parameter epression");
				}
				return null;
			}
			
			
		}
		else { //if name does not have a resolved content
			//if name is formed like A!B
			if (nameString.contains("!")) {
				//split the string by "!"
				String[] arr = nameString.split("!");
				//model is model
				String model = arr[0];
				//element is element
				String element = arr[1];
				
				
				ModelElementType type = context.getEolFactory().createModelElementType(); //create modelElementType for this
				type.setModelName(model); //set model name
				type.setElementName(element); //set element name
				context.setAssets(type, nameExpression); //set assets
				nameExpression.setResolvedType(type);
				controller.visit(nameExpression.getResolvedType(), context);
				return null;
			}		
			else {
				ModelElementType type = context.getEolFactory().createModelElementType(); //create modelElementType for this
				type.setElementName(nameString); //set element name
				context.setAssets(type, nameExpression); //set assets
				nameExpression.setResolvedType(type);
				controller.visit(nameExpression.getResolvedType(), context);
				return null;
			}
		}
	}

}
