package org.eclipse.epsilon.coverage.strategies;

import java.util.Arrays;

import org.eclipse.epsilon.eol.parse.EolParser;

public class OperationCoverageStrategy extends RuleCoverageStrategy {

	public OperationCoverageStrategy() {
		super(Arrays.asList(EolParser.HELPERMETHOD));
	}
	
	@Override
	protected String getStrategyName() {
		return "Operation";
	}
}
