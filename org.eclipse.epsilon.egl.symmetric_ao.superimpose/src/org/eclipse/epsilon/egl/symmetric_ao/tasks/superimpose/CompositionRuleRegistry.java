/**
 * Copyright (C) 2010 Lancaster University.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or 
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the 
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License 
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors:
 * 
 *   Steffen Zschaler -- Initial Implementation
 */
package org.eclipse.epsilon.egl.symmetric_ao.tasks.superimpose;

import java.util.HashMap;
import java.util.Map;

import org.apache.tools.ant.Project;
import org.eclipse.epsilon.egl.symmetric_ao.tasks.superimpose.rules.CompositionErrorRule;
import org.eclipse.epsilon.egl.symmetric_ao.tasks.superimpose.rules.ConcatenationRule;
import org.eclipse.epsilon.egl.symmetric_ao.tasks.superimpose.rules.ConstructorConcatRule;
import org.eclipse.epsilon.egl.symmetric_ao.tasks.superimpose.rules.ExpansionOverridingRule;
import org.eclipse.epsilon.egl.symmetric_ao.tasks.superimpose.rules.FieldOverrideRule;
import org.eclipse.epsilon.egl.symmetric_ao.tasks.superimpose.rules.ImplementsListRule;
import org.eclipse.epsilon.egl.symmetric_ao.tasks.superimpose.rules.JavaMethodOverridingRule;
import org.eclipse.epsilon.egl.symmetric_ao.tasks.superimpose.rules.ModifierRule;
import org.eclipse.epsilon.egl.symmetric_ao.tasks.superimpose.rules.ReplacementRule;

import composer.rules.CompositionError;
import composer.rules.ConstructorConcatenation;
import composer.rules.ExpansionOverriding;
import composer.rules.FieldOverriding;
import composer.rules.ImplementsListMerging;
import composer.rules.JavaMethodOverriding;
import composer.rules.ModifierListSpecialization;
import composer.rules.Replacement;
import composer.rules.StringConcatenation;

/**
 * A registry of terminal composition rules.
 * 
 * @author zschaler
 */
public class CompositionRuleRegistry {

	/**
	 * The key used to store the registry for a project
	 */
	private static final String KEY_COMPRULEREGISTRY = "org.eclipse.epsilon.egl.symmetric_ao.tasks.superimpose.CompositionRuleRegistry";

	public static CompositionRuleRegistry getInstance(Project project) {
		CompositionRuleRegistry crrTentative = (CompositionRuleRegistry) project
				.getReference(KEY_COMPRULEREGISTRY);
		if (crrTentative == null) {
			crrTentative = new CompositionRuleRegistry();
			project.addReference(KEY_COMPRULEREGISTRY, crrTentative);
		}
		return crrTentative;
	}

	private CompositionRuleRegistry() {
		super();

		// Register default rules. These are the ones that were hard-wired into
		// FeatureHouse (minus C#)
		registerRule(Replacement.COMPOSITION_RULE_NAME, new ReplacementRule());
		registerRule(StringConcatenation.COMPOSITION_RULE_NAME,
				new ConcatenationRule());
		registerRule(ImplementsListMerging.COMPOSITION_RULE_NAME,
				new ImplementsListRule());
		registerRule(JavaMethodOverriding.COMPOSITION_RULE_NAME,
				new JavaMethodOverridingRule());
		registerRule(ConstructorConcatenation.COMPOSITION_RULE_NAME,
				new ConstructorConcatRule());
		registerRule(ModifierListSpecialization.COMPOSITION_RULE_NAME,
				new ModifierRule());
		registerRule(FieldOverriding.COMPOSITION_RULE_NAME,
				new FieldOverrideRule());
		registerRule(ExpansionOverriding.COMPOSITION_RULE_NAME,
				new ExpansionOverridingRule());
		registerRule(CompositionError.COMPOSITION_RULE_NAME,
				new CompositionErrorRule());
	}

	private Map<String, FSTTerminalCompositionRule> mpRules = new HashMap<String, FSTTerminalCompositionRule>();

	public FSTTerminalCompositionRule getRule(String sRuleID) {
		return mpRules.get(sRuleID);
	}

	public void registerRule(String sRuleID, FSTTerminalCompositionRule rule) {
		mpRules.put(sRuleID, rule);
	}
}