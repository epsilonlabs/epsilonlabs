package org.eclipse.epsilon.eol.ast2eol;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.*;
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
	public EolElement create(AST ast, EolElement container,
			Ast2EolContext context) {
		
		ModelDeclarationParameter expression = context.getEolFactory().createModelDeclarationParameter();
		this.setAssets(ast, expression, container);
		
		AST nameAst = ast.getChild(0);
		AST valueAst = ast.getChild(1);
		
		expression.setName((NameExpression) context.getEolElementCreatorFactory().createDomElement(nameAst, expression, context));
		expression.setValue((StringExpression) context.getEolElementCreatorFactory().createDomElement(valueAst, expression, context));
		
		return expression;
	}

}
