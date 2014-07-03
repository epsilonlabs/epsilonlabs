package org.eclipse.epsilon.eol.ast2eol;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.SpecialAssignmentStatement;
import org.eclipse.epsilon.eol.parse.EolParser;

public class SpecialAssignmentStatementCreator extends AssignmentStatementCreator{
	
	@Override
	public boolean appliesTo(AST ast) {
		return ast.getType() == EolParser.SPECIAL_ASSIGNMENT;
	}
	
	@Override
	public EolElement create(AST ast, EolElement container,
			Ast2EolContext context) {
		SpecialAssignmentStatement statement = context.getEolFactory().createSpecialAssignmentStatement(); //create AssignmentStatement
		this.setAssets(ast, statement, container);
		
		statement.setLhs((Expression) context.getEolElementCreatorFactory().createDomElement(ast.getChild(0), statement, context)); //set Lhs
		statement.setRhs((Expression) context.getEolElementCreatorFactory().createDomElement(ast.getChild(1), statement, context)); //set Rhs

		return statement;
	}


}
