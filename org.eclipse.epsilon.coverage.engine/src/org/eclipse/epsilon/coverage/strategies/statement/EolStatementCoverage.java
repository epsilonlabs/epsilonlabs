package org.eclipse.epsilon.coverage.strategies.statement;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.coverage.strategies.AbstractCoverageStrategy;
import org.eclipse.epsilon.eol.parse.EolParser;

import EpsilonCoverage.CoveragePoint;
import EpsilonCoverage.CoverageType;
import EpsilonCoverage.EpsilonCoverageFactory;

public class EolStatementCoverage extends AbstractCoverageStrategy {
	
	protected final ArrayList<Integer> ignoredASTElements = new ArrayList<Integer>(Arrays.asList(
			EolParser.IMPORT, EolParser.EOLMODULE, EolParser.PARAMETERS, EolParser.FORMAL, EolParser.BLOCK, 
			EolParser.PARAMLIST, EolParser.Annotation, EolParser.ANNOTATIONBLOCK
			));
	
	public EolStatementCoverage() {
		super();
		strategyModel.setType(CoverageType.STATEMENT);
	}
	
	protected boolean ignoreAst(AST ast) {
		if (ast.getType() == EolParser.NAME && ast.getParent().getType() == EolParser.IMPORT) {
			return true;
		}
		return false;
	}

	@Override
	public void buildModel(AST ast) {
		if (ignoreAst(ast)) {
			return;
		}
		
		CoveragePoint point = EpsilonCoverageFactory.eINSTANCE.createCoveragePoint();
		point.setAstType(ast.getType());
		point.setColumn(ast.getColumn());
		point.setLine(ast.getLine());
		point.setUri(ast.getUri().getPath());
		
		strategyModel.getPoints().add(point);
	}

	@Override
	public void cover(AST ast){
		for (CoveragePoint c : strategyModel.getPoints()) {
			if (c.getLine() == ast.getLine() && c.getUri().equals(ast.getUri().getPath())) {
				c.setTimesExecuted(c.getTimesExecuted()+1);
				break;
			}
		}
	}
}
