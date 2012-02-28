package org.eclipse.epsilon.coverage.strategies.rule;

import java.util.Arrays;

import org.eclipse.epsilon.flock.parse.FlockParser;


public class FlockRuleCoverageStrategy extends RuleCoverageStrategy {
	public FlockRuleCoverageStrategy() {
		super(Arrays.asList(FlockParser.MIGRATE));
	}
}