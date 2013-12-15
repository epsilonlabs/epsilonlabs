package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.ModelExpression;

public class ModelExpressionCreator extends NameExpressionCreator{

	@Override
	public boolean appliesTo(AST ast) {
		return false; // appliesTo will never be called
	}

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		ModelExpression expression = context.getEolFactory().createModelExpression();
		this.setAssets(ast, expression, container);
		
		//expression.setName(ast.getText()); 
		//setName supressed because it will be handled by other creators
		
		return expression;
	}
}
