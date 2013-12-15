package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.ModelDeclarationParameter;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.StringExpression;
import org.eclipse.epsilon.eol.parse.EolParser;

public class ModelDeclarationParameterCreator extends EolElementCreator{

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.MODELDECLARATIONPARAMETER)
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
		
		ModelDeclarationParameter expression = context.getEolFactory().createModelDeclarationParameter();
		this.setAssets(ast, expression, container);
		
		AST nameAst = ast.getChild(0);
		AST valueAst = ast.getChild(1);
		
		expression.setName((NameExpression) context.getEolElementCreatorFactory().createDomElement(nameAst, expression, context));
		expression.setValue((StringExpression) context.getEolElementCreatorFactory().createDomElement(valueAst, expression, context));
		
		return expression;
	}

}
