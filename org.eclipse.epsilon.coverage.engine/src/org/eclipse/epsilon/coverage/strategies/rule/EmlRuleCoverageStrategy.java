package org.eclipse.epsilon.coverage.strategies.rule;

import java.util.Arrays;

import org.eclipse.epsilon.eml.parse.EmlParser;


public class EmlRuleCoverageStrategy extends RuleCoverageStrategy {
	public EmlRuleCoverageStrategy() {
		super(Arrays.asList(EmlParser.MERGE));
	}
}