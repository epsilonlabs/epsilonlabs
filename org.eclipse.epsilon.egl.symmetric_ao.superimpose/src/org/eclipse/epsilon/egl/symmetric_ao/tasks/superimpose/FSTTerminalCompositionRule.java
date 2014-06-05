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

import de.ovgu.cide.fstgen.ast.FSTNonTerminal;
import de.ovgu.cide.fstgen.ast.FSTTerminal;

/**
 * A terminal composition rule defines how to compose two FST terminals.
 * 
 * @author zschaler
 */
public interface FSTTerminalCompositionRule {

	/**
	 * Return true if the two nodes should be considered equal.
	 * {@link #compose(FSTTerminal, FSTTerminal, FSTTerminal, FSTNonTerminal)}
	 * will only be invoked for terminals for which this method returns
	 * <code>false</code>. Otherwise, the composition result will be taken to be
	 * a copy of <code>terminalA</code>.
	 * 
	 * @param terminalA
	 * @param terminalB
	 * @return
	 */
	public boolean areEqual(FSTTerminal terminalA, FSTTerminal terminalB);

	/**
	 * Compose terminalA and terminalB and place the result in terminalComp,
	 * which resides under nonterminalParent.
	 * 
	 * @param terminalA
	 * @param terminalB
	 * @param terminalComp
	 * @param nonterminalParent
	 */
	public void compose(FSTTerminal terminalA, FSTTerminal terminalB,
			FSTTerminal terminalComp, FSTNonTerminal nonterminalParent);

	/**
	 * This is called after composition of all features is complete. It allows a
	 * composition rule to perform post-processing where required.
	 * 
	 * @param terminalNode
	 */
	public void postProcess(FSTTerminal terminalNode);
}