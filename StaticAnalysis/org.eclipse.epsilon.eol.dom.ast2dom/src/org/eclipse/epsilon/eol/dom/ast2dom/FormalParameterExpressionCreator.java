package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.FormalParameterExpression;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.parse.EolParser;

public class FormalParameterExpressionCreator extends ExpressionCreator{

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.FORMAL)
		{
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		
		FormalParameterExpression expression = context.getEolFactory().createFormalParameterExpression();
		this.setAssets(ast, expression, container);
		
		AST nameAst = ast.getFirstChild(); //get the name ast
		expression.setName((NameExpression) context.getEolElementCreatorFactory().createDomElement(nameAst, expression, context)); //set the name
		
		if(ast.getNumberOfChildren() > 1) //if there are any more ast, it means there should be a type
		{
			AST typeAst = nameAst.getNextSibling(); //fetch next sibling
			expression.setResolvedType((Type) context.getEolElementCreatorFactory().createDomElement(typeAst, expression, context)); //set resolved type
		}
		else {
			expression.setResolvedType((Type) context.getEolElementCreatorFactory().createDomElement(nameAst, expression, context, AnyTypeCreator.class));
		}
		
		return expression;
	}

}
