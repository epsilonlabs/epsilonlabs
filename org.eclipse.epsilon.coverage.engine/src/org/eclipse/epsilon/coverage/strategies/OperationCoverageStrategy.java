package org.eclipse.epsilon.coverage.strategies;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.epsilon.eol.parse.EolParser;

public class OperationCoverageStrategy extends RuleCoverageStrategy {

	protected final ArrayList<Integer> elementsOfInterest = new ArrayList<Integer>(Arrays.asList(
			EolParser.HELPERMETHOD
			));
	
//	@Override
//	public void buildModel(AST ast) {
//		if (elementsOfInterest.contains(ast.getType())) {
//			coveragePoints.add(new NamedCoveragePoint(ast.getLine(), ast.getColumn(), ast.getType(), ast.getChild(0).getText()));
//		}
//	}

	@Override
	protected String getStrategyName() {
		return "Operation";
	}
}
