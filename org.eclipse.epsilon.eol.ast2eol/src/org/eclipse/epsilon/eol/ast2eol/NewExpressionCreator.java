package org.eclipse.epsilon.eol.ast2eol;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.ast2eol.context.Ast2EolContext;
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
	public EOLElement create(AST ast, EOLElement container,
			Ast2EolContext context) {
		
		NewExpression expression = context.getEolFactory().createNewExpression(); //create a new expression
		this.setAssets(ast, expression, container); //set assets		
		
		AST typeAst = ast.getChild(0); //must have a type
		expression.setResolvedType((Type) context.getEolElementCreatorFactory().createEOLElement(typeAst, expression, context)); //set resolved type to be the type
		
//		if (typeAst.getNumberOfChildren() > 0) {
//			AST paramlistAst = typeAst.getChild(0);
//			for(AST parameterAst : paramlistAst.getChildren())
//			{
//				expression.getParameters().add((NameExpression) context.getEolElementCreatorFactory().createEOLElement(parameterAst, expression, context, NameExpressionCreator.class));
//			}
//		}
		
		return expression;
	}
}
