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
package org.eclipse.epsilon.egl.symmetric_ao.tasks.superimpose.rules;

import org.eclipse.epsilon.egl.symmetric_ao.tasks.superimpose.AbstractCompositionRule;
import org.eclipse.epsilon.egl.symmetric_ao.tasks.superimpose.FSTTerminalCompositionRule;

import composer.rules.JavaMethodOverriding;

import de.ovgu.cide.fstgen.ast.FSTNonTerminal;
import de.ovgu.cide.fstgen.ast.FSTTerminal;

/**
 * @author zschaler
 * 
 */
public class JavaMethodOverridingRule extends AbstractCompositionRule implements
		FSTTerminalCompositionRule {

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.epsilon.egl.symmetric_ao.tasks.superimpose.
	 * FSTTerminalCompositionRule#compose(de.ovgu.cide.fstgen.ast.FSTTerminal,
	 * de.ovgu.cide.fstgen.ast.FSTTerminal, de.ovgu.cide.fstgen.ast.FSTTerminal,
	 * de.ovgu.cide.fstgen.ast.FSTNonTerminal)
	 */
	@Override
	public void compose(FSTTerminal terminalA, FSTTerminal terminalB,
			FSTTerminal terminalComp, FSTNonTerminal nonterminalParent) {
		JavaMethodOverriding.compose(terminalA, terminalB, terminalComp,
				nonterminalParent);
	}

	@Override
	public void postProcess(FSTTerminal terminalNode) {
		// Remove any references to original from the composition result
		if (terminalNode.getBody().matches("(?s).*\\s*original\\s*.*")) {
			// Only do this, if we ever had any calls to original() in this that
			// need to be replaced.

			// This is a slightly hacky heuristic trying to capture the entire
			// statement that contained the call to original
			// TODO: Mention this in paper
			String toReplace = "(?:(?<=;)|^)[^;\"]*original\\s*\\([^\\)]*\\)[^;]*;";

			terminalNode.setBody(terminalNode.getBody().replaceAll(toReplace,
					""));
		}
	}
}
