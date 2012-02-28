package org.eclipse.epsilon.coverage.strategies.booleanexp;

import java.util.Arrays;

import org.eclipse.epsilon.eol.parse.EolParser;

import EpsilonCoverage.CoverageType;


public class DecisionCoverageStrategy extends BooleanExpressionCoverageStrategy {

	public DecisionCoverageStrategy() {
		super(Arrays.asList(EolParser.IF, EolParser.CASE, EolParser.ELSE));
		strategyModel.setType(CoverageType.DECISION);
	}
}
