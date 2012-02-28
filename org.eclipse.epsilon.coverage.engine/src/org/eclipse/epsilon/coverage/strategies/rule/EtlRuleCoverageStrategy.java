package org.eclipse.epsilon.coverage.strategies.rule;

import java.util.Arrays;

import org.eclipse.epsilon.etl.parse.EtlParser;

public class EtlRuleCoverageStrategy extends RuleCoverageStrategy {
		public EtlRuleCoverageStrategy() {
			super(Arrays.asList(EtlParser.TRANSFORM));
		}
	}