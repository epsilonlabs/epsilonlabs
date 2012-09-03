package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.ForStatement;
import org.eclipse.epsilon.eol.dom.Statement;
import org.eclipse.epsilon.eol.dom.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.parse.EolParser;

public class ForStatementCreator extends StatementCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		
		ForStatement statement = (ForStatement) context.getDomFactory().createForStatement();
		
		AST iteratorAst = ast.getFirstChild();
		AST iteratedAst = iteratorAst.getNextSibling();
		
		statement.setIterator((VariableDeclarationExpression) context.getDomElementCreatorFactory().createDomElement(iteratorAst, statement, context));
		statement.setIterated((Expression) context.getDomElementCreatorFactory().createDomElement(iteratedAst, statement, context));
		AST bodyAst = AstUtilities.getChild(ast, EolParser.BLOCK);
		for (AST statementAst : bodyAst.getChildren()) {
			statement.getBody().add((Statement) context.getDomElementCreatorFactory().createDomElement(statementAst, statement, context));
		}
		//statement.printSelf();
		System.out.println(statement.getClass());
		
		statement.setLine(ast.getLine());
		statement.setColumn(ast.getColumn());
		
		return statement;
	}

}
