package org.eclipse.epsilon.coverage.strategies.statement;

import java.util.Arrays;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.epsilon.evl.parse.EvlParser;

public class EvlStatementCoverage extends EolStatementCoverage {
	
	public EvlStatementCoverage() {
		super();
		ignoredASTElements.addAll(Arrays.asList( EvlParser.CONTEXT, EvlParser.CONSTRAINT, EvlParser.CRITIQUE,
				EvlParser.GUARD, EvlParser.CHECK, EvlParser.MESSAGE));
	}
	
	@Override
	protected boolean ignoreAst(AST ast) {
		if (super.ignoreAst(ast) || ignoredASTElements.contains(ast.getType())){
			return true;
		}
		
		if (ast.getType() == EolParser.NAME && (ast.getParent().getType() == EvlParser.CONTEXT ||
												ast.getParent().getType() == EvlParser.CONSTRAINT ||
												ast.getParent().getType() == EvlParser.CRITIQUE)) {
			return true;
		}
		
		return false;
	}
}
