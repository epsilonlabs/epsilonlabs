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

import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.Task;

/**
 * ANT Task allowing the registration of new composition rules for
 * superimposition merge.
 * 
 * @author zschaler
 */
public class RegisterCompositionRules extends Task {

	public static class RuleDescriptor {

		/**
		 * The rule ID
		 */
		private String sRuleID;

		/**
		 * The class name of the class of the rule.
		 */
		private String sRuleClassName;

		/**
		 * Set the ID under which this rule should be registered.
		 * 
		 * @param sName
		 */
		public void setName(String sName) {
			sRuleID = sName;
		}

		/**
		 * Set the name of a subclass of FSTTerminalCompositionRule, which
		 * implements this rule.
		 * 
		 * @param sClass
		 */
		public void setClass(String sClass) {
			sRuleClassName = sClass;
		}

		/**
		 * Used to register the described rule for a given project.
		 * 
		 * @param p
		 * 
		 * @throws ClassNotFoundException
		 * @throws InstantiationException
		 * @throws IllegalAccessException
		 */
		public void registerRule(Project p) throws ClassNotFoundException,
				InstantiationException, IllegalAccessException {
			@SuppressWarnings("rawtypes")
			Class cRule = Class.forName(sRuleClassName);
			if (FSTTerminalCompositionRule.class.isAssignableFrom(cRule)) {
				CompositionRuleRegistry.getInstance(p).registerRule(sRuleID,
						(FSTTerminalCompositionRule) cRule.newInstance());
			} else {
				throw new IllegalArgumentException("Class " + sRuleClassName
						+ " is not a valid rule class.");
			}
		}
	}

	private List<RuleDescriptor> lRules = new ArrayList<RuleDescriptor>();

	public RuleDescriptor createRule() {
		RuleDescriptor rdNew = new RuleDescriptor();
		lRules.add(rdNew);
		return rdNew;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.tools.ant.Task#execute()
	 */
	@Override
	public void execute() throws BuildException {
		for (RuleDescriptor rdCurrent : lRules) {
			try {
				rdCurrent.registerRule(getProject());
			} catch (Exception e) {
				throw new BuildException(e);
			}
		}
	}
}