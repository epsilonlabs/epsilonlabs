package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.BinaryOperatorExpression;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.parse.EolParser;

public abstract class BinaryOperatorExpressionCreator extends OperatorExpressionCreator{

	@Override
	public boolean appliesTo(AST ast) {
		return (ast.getNumberOfChildren() == 2 && ast.getType() == EolParser.OPERATOR && ast.getText().equalsIgnoreCase(getOperator()));
	}
	
	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		BinaryOperatorExpression expression = create(context);
		this.buildExpression(ast, expression, container, context);
		return expression;
	}
	
	public void buildExpression(AST ast, BinaryOperatorExpression expression, DomElement container, Ast2DomContext context)
	{
		this.setAssets(ast, expression, container);
		
		AST lhsAst = ast.getChild(0); //fetch LHS AST
		AST rhsAst = ast.getChild(1); //fetch RHS AST
		
		expression.setLhs((Expression) context.getEolElementCreatorFactory().createDomElement(lhsAst, expression, context)); //set LHS
		expression.setRhs((Expression) context.getEolElementCreatorFactory().createDomElement(rhsAst, expression, context)); //set RHS
	}
		
	public abstract BinaryOperatorExpression create(Ast2DomContext context);
	
	public abstract String getOperator();

}
