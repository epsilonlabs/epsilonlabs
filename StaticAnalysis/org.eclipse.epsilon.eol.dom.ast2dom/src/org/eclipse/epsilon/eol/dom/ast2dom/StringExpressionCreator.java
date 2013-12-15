package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.StringExpression;
import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.parse.EolParser;

public class StringExpressionCreator extends PrimitiveExpressionCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		
		StringExpression expression = (StringExpression) context.getEolFactory().createStringExpression(); //create a StringExpression
		this.setAssets(ast, expression, container);
		
		String val = "";
		val = ast.getText();
		expression.setVal(val); //set value

		expression.setResolvedType((Type) context.getEolElementCreatorFactory().createDomElement(ast, expression, context, StringTypeCreator.class));
		
		return expression;
	}

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.STRING)
		{
			return true;
		}
		else {
			return false;
		}
	}

}
