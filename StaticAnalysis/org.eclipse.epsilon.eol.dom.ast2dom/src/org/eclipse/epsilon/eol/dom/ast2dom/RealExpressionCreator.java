package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.RealExpression;
import org.eclipse.epsilon.eol.dom.Type;
import org.eclipse.epsilon.eol.parse.EolParser;

public class RealExpressionCreator extends PrimitiveExpressionCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		
		RealExpression expression = (RealExpression) context.getEolFactory().createRealExpression(); //create a RealExpression
		this.setAssets(ast, expression, container);
		
		float val = 0;
		val = Float.parseFloat(ast.getText());
		expression.setVal(val); //set Value
				
		expression.setResolvedType((Type) context.getEolElementCreatorFactory().createDomElement(ast, expression, context, RealTypeCreator.class));
		
		return expression;
	}

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.FLOAT)
		{
			return true;
		}
		else {
			return false;
		}
	}

}
