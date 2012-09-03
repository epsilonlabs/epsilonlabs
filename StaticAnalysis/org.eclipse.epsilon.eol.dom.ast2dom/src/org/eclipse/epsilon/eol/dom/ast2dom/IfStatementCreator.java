package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.IfStatement;

public class IfStatementCreator extends StatementCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		
		IfStatement statement = (IfStatement) context.getDomFactory().createIfStatement();
		
		AST conditionAst = ast.getFirstChild();
		AST ifBodyAst = conditionAst.getNextSibling();
		AST elseBodyAst = ifBodyAst.getNextSibling();
		
		statement.setCondition((Expression) context.getDomElementCreatorFactory().createDomElement(conditionAst, statement, context));
		for (AST statementAst : ifBodyAst.getChildren()) {
			statement.getIfBody().add(context.getDomElementCreatorFactory().createStatement(statementAst, statement, context));
			
		}
		if (elseBodyAst != null) {
			for (AST statementAst : elseBodyAst.getChildren()) {
				statement.getElseBody().add(context.getDomElementCreatorFactory().createStatement(statementAst, statement, context));
			}
		}
		
		statement.setLine(ast.getLine());
		statement.setColumn(ast.getColumn());
		
		return statement;
	}

}
