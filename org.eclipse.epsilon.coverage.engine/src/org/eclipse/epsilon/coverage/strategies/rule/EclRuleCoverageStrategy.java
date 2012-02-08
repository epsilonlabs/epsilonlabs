package org.eclipse.epsilon.coverage.strategies.rule;

import java.util.Arrays;

import org.eclipse.epsilon.coverage.strategies.RuleCoverageStrategy;
import org.eclipse.epsilon.ecl.parse.EclParser;


public class EclRuleCoverageStrategy extends RuleCoverageStrategy {
	public EclRuleCoverageStrategy() {
		super(Arrays.asList(EclParser.COMPARE));
	}
}