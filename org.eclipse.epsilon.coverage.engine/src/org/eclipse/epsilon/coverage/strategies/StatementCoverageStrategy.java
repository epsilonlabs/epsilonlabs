package org.eclipse.epsilon.coverage.strategies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.parse.EolParser;


public class StatementCoverageStrategy extends AbstractCoverageStrategy {
	
	public StatementCoverageStrategy() {
		coveragePoints = new ArrayList<CoveragePoint>();
	}

	// TODO: Check this list with DK/LR - are there any others to ignore?
	protected final ArrayList<Integer> ignoredASTElements = new ArrayList<Integer>(Arrays.asList(
			EolParser.EOLMODULE, EolParser.PARAMETERS, EolParser.FORMAL, EolParser.BLOCK, 
			EolParser.PARAMLIST//, EolParser.FEATURECALL
			));
	
	@Override
	public void buildModel(AST ast) {
		if (!ignoredASTElements.contains(ast.getType())) {
			CoveragePoint point = new CoveragePoint(ast.getLine(), -1, -1);
			if (!coveragePoints.contains(point)) {
				coveragePoints.add(point);
			}
		}
	}
	
	@Override
	public void cover(AST ast){
		for (CoveragePoint c : coveragePoints) {
			if (c.line == ast.getLine()) {
				c.covered = true;
				c.incrementTimesExecuted();
				break;
			}
		}
	}
	
	@Override
	public void finishCovering(AST ast, Object result) { }

	@Override
	public List<CoveragePoint> getModel() {
		return coveragePoints;
	}

	@Override
	protected String getStrategyName() {
		return "Statement";
	}
}
