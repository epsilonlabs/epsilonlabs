package org.eclipse.epsilon.eol.ast2eol;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.parse.EolParser;

public class NewExpressionCreator extends ExpressionCreator{

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.NEW && ast.getFirstChild().getType() == EolParser.TYPE)
		{
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public EolElement create(AST ast, EolElement container,
			Ast2EolContext context) {
		
		NewExpression expression = context.getEolFactory().createNewExpression(); //create a new expression
		this.setAssets(ast, expression, container); //set assets		
		
		AST typeAst = ast.getChild(0); //must have a type
		expression.setResolvedType((Type) context.getEolElementCreatorFactory().createDomElement(typeAst, expression, context)); //set resolved type to be the type
		
		
		if(ast.getNumberOfChildren() > 1) //if there are any siblings, means there are parameters
		{
			AST paramListAst = ast.getChild(1); //fetch parameter ast
			for(AST parameterAst : paramListAst.getChildren()) //process parameters
			{
				expression.getParameters().add((Expression) context.getEolElementCreatorFactory().createDomElement(parameterAst, expression, context));
			}
		}	
		return expression;
	}

}
