package org.eclipse.epsilon.eol.ast2eol;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.parse.EolParser;

public class SpecialAssignmentStatementCreator extends AssignmentStatementCreator{
	
	@Override
	public boolean appliesTo(AST ast) {
		boolean condition = ast.getType() == EolParser.SPECIAL_ASSIGNMENT;
		if(condition)
		{
			return true;
		}
		else {
			return false;
		}
	}

}
