package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.dom.AssignmentStatement;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.DomFactory;

public class AssignmentStatementCreator extends StatementCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {
		DomFactory domFactory = context.getDomFactory();
		DomElementCreatorFactory factory = context.getDomElementCreatorFactory();
		
		AssignmentStatement statement = (AssignmentStatement) domFactory.createAssignmentStatement();
		statement.setLine(ast.getLine());
		statement.setColumn(ast.getColumn());
		statement.setLhs(factory.createExpression(ast.getChild(0), statement, context));
		statement.setRhs(factory.createExpression(ast.getChild(1), statement, context));
		return statement;
	}

}
