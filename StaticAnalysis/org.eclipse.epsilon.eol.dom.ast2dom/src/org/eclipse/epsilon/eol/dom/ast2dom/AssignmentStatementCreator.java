package org.eclipse.epsilon.eol.dom.ast2dom;


import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.AssignmentStatement;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.parse.EolParser;

public class AssignmentStatementCreator extends StatementCreator{

	@Override
	public DomElement create(AST ast, DomElement container,
			Ast2DomContext context) {

		AssignmentStatement statement = context.getEolFactory().createAssignmentStatement(); //create AssignmentStatement
		this.setAssets(ast, statement, container);
		
		statement.setLhs((Expression) context.getEolElementCreatorFactory().createDomElement(ast.getChild(0), statement, context)); //set Lhs
		statement.setRhs((Expression) context.getEolElementCreatorFactory().createDomElement(ast.getChild(1), statement, context)); //set Rhs

		return statement;
	}

	@Override
	public boolean appliesTo(AST ast) { 
		if(ast.getType() == EolParser.ASSIGNMENT)
		{
			return true;
		}
		else {
			return false;
		}
	}

}
