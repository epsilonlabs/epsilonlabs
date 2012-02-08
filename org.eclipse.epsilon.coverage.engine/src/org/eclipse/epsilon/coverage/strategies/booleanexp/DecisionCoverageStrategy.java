package org.eclipse.epsilon.coverage.strategies.booleanexp;

import java.util.Arrays;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.coverage.strategies.BooleanExpressionCoverageStrategy;
import org.eclipse.epsilon.coverage.strategies.DecisionPoint;
import org.eclipse.epsilon.eol.parse.EolParser;


public class DecisionCoverageStrategy extends BooleanExpressionCoverageStrategy {

	public DecisionCoverageStrategy() {
		super(Arrays.asList(EolParser.IF, EolParser.CASE, EolParser.ELSE));
	}

	@Override
	public void buildModel(AST ast) {
		if (astTypesOfInterest.contains(ast.getType())) {
			AST child = ast.getFirstChild();
			coveragePoints.add(new DecisionPoint(child.getLine(), child.getColumn(), child.getType()));
		}
	}
	
	@Override
	public void cover(AST ast){
		if (astTypesOfInterest.contains(ast.getType())) {	
			astsToMonitor.add(ast.getFirstChild()); 
		}
	}
	
	@Override
	protected String getStrategyName() {
		return "Decision";
	}

}
