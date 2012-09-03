package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.EnumerationLiteralExpression;

public class EnumerationLiteralExpressionCreator extends ExpressionCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		EnumerationLiteralExpression e = (EnumerationLiteralExpression) context.getDomFactory().createEnumerationLiteralExpression();
		e.setLine(ast.getLine());
		e.setColumn(ast.getColumn());
		String[] arr = ast.getText().split("#");
		e.setEnumeration(arr[0]);
		e.setLiteral(arr[1]);
		return e;
	}

}
