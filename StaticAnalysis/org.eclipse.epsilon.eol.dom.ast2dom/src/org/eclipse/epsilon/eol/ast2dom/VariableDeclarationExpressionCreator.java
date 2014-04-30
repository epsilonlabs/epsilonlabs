package org.eclipse.epsilon.eol.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.parse.EolParser;

public class VariableDeclarationExpressionCreator extends ExpressionCreator{

	@Override
	public EolElement create(AST ast, EolElement container,
			Ast2DomContext context) {
	

		VariableDeclarationExpression declaration = context.getEolFactory().createVariableDeclarationExpression(); //create a VariableDeclarationExpression
		this.setAssets(ast, declaration, container); //set assets: line, column, container
		
		AST nameAst = ast.getChild(0); //there must be a name AST
		declaration.setName((NameExpression)context.getEolElementCreatorFactory().createDomElement(nameAst, declaration, context)); //create the name from the name AST 

		
		if(ast.getNumberOfChildren() > 1) //if there are children ASTs
		{
			if(ast.getChild(1).getType() == EolParser.TYPE) //if the child is a type
			{
				AST typeAst = ast.getChild(1); //fetch child AST
				declaration.setResolvedType((Type) context.getEolElementCreatorFactory().createDomElement(typeAst, declaration, context)); //set type
				
				
				if(ast.getNumberOfChildren() > 2) //if number of children is greater than 2 it means there are parameters
				{
					if(ast.getChild(2).getType() == EolParser.PARAMETERS) //if children 2 is PARAMETERS
					{
						AST parameterListAst = ast.getChild(2); //fetch parameter AST
						for(AST parameterAst: parameterListAst.getChildren()) //process parameter ASTs
						{
							declaration.getParameters().add((Expression) context.getEolElementCreatorFactory().createDomElement(parameterAst, declaration, context));
						}
					}
				}
			}
		}
		else //if there is no type defined, for the current implementation, AnyType is assigned to the variable declaration BUT THIS SHOULD NOT BE ALLOWED
		{
			declaration.setResolvedType((Type) context.getEolElementCreatorFactory().createDomElement(ast, declaration, context, AnyTypeCreator.class));
		}
		
		BooleanExpression isCreate = (BooleanExpression) context.getEolElementCreatorFactory().createDomElement(ast, declaration, context, BooleanExpressionCreator.class);
		isCreate.setVal((ast.getText().equals("new")) ? true : false); //set to true for corresponding conditions
		declaration.setCreate(isCreate); //set the isCreate of the VariableDeclaratoin
		
		return declaration;
	}

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.VAR)
		{
			return true;
		}
		else {
			return false;
		}
	}

}
