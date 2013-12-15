package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.BinaryOperatorExpression;
import org.eclipse.epsilon.eol.parse.EolParser;

public class EqualsOperatorExpressionCreator extends BinaryOperatorExpressionCreator{

	@Override
	public boolean appliesTo(AST ast) {
		if(ast.getType() == EolParser.OPERATOR && (ast.getText().equals("=") || ast.getText().equals("==")) && ast.getNumberOfChildren() == 2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public BinaryOperatorExpression create(Ast2DomContext context) {		
		return context.getEolFactory().createEqualsOperatorExpression(); //create an EqualsOperatorExpression;
	}

	@Override
	public String getOperator() {
		return null; //this class requires more elaborate appliesTo() method 
	}



}
