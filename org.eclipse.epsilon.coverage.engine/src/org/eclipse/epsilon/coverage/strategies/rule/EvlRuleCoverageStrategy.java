package org.eclipse.epsilon.coverage.strategies.rule;

import java.util.Arrays;

import org.eclipse.epsilon.coverage.strategies.RuleCoverageStrategy;
import org.eclipse.epsilon.evl.parse.EvlParser;


public class EvlRuleCoverageStrategy extends RuleCoverageStrategy {
	public EvlRuleCoverageStrategy() {
		super(Arrays.asList(EvlParser.CONSTRAINT, EvlParser.CRITIQUE));
	}
}