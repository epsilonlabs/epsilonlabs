package org.eclipse.epsilon.eol.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.parse.EolParser;

public abstract class UnaryOperatorExpressionCreator extends OperatorExpressionCreator{

	
	@Override
	public boolean appliesTo(AST ast) {
		return (ast.getNumberOfChildren() == 1 && ast.getType() == EolParser.OPERATOR && ast.getText().equalsIgnoreCase(getOperator()));
	}
	
	public EolElement create(AST ast, EolElement container,
			Ast2DomContext context) {
		UnaryOperatorExpression expression = create(context);
		this.buildExpression(ast, expression, container, context);
		return expression;
	}
	
	public void buildExpression(AST ast, UnaryOperatorExpression expression, EolElement container, Ast2DomContext context)
	{
		this.setAssets(ast, expression, container);
		
		AST expressionAST = ast.getFirstChild(); //fetch the expression AST
		expression.setExpr((Expression) context.getEolElementCreatorFactory().createDomElement(expressionAST, expression, context)); //create dom for Expression ASt and set
	}
	
	public abstract UnaryOperatorExpression create(Ast2DomContext context);
	
	public abstract String getOperator();


}
