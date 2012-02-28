package org.eclipse.epsilon.coverage.strategies.rule;

import java.util.Arrays;

import org.eclipse.epsilon.eol.parse.EolParser;

import EpsilonCoverage.CoverageType;

public class OperationCoverageStrategy extends RuleCoverageStrategy {

	public OperationCoverageStrategy() {
		super(Arrays.asList(EolParser.HELPERMETHOD));
		strategyModel.setType(CoverageType.OPERATION);
	}
}
