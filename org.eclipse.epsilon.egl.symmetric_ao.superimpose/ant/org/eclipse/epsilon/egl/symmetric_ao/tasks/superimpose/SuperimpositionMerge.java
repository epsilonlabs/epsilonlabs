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
import org.eclipse.epsilon.egl.symmetric_ao.tasks.MergeStrategy;

import cide.gparser.ParseException;
import de.ovgu.cide.fstgen.ast.FSTFeatureNode;
import de.ovgu.cide.fstgen.ast.FSTNode;
import de.ovgu.cide.fstgen.ast.FSTNonTerminal;
import de.ovgu.cide.fstgen.ast.FSTTerminal;

/**
 * Merge strategy type providing access to FeatureHouse superimposition.
 * 
 * @author steffen
 */
public class SuperimpositionMerge implements MergeStrategy {
	private String sHandlerID;
	private Project project;

	public SuperimpositionMerge(Project project) {
		super();
		this.project = project;
	}

	public String merge(List<String> toMerge, boolean fForRegister) {
		if (getArtefactHandler() == null) {
			throw new IllegalStateException("No artefact handler defined!");
		}

		// Parse the contents to be merged
		int nFeature = 0;
		List<FSTNode> lFeatures = new ArrayList<FSTNode>();
		for (String sCurrentContent : toMerge) {
			try {
				// First parse the current string
				FSTNode fstCurrent = getArtefactHandler().process(
						sCurrentContent);
				// Then wrap it into an artificially created feature node (this
				// information is used by some of the merge strategies)
				FSTFeatureNode fstfn = new FSTFeatureNode("Feature"
						+ nFeature++);
				fstfn.addChild(fstCurrent);
				lFeatures.add(fstfn);
			} catch (ParseException e) {
				throw new BuildException(
						"Generated contents was not of the type indicated:"
								+ e.getMessage(), e);
			}
		}

		// Do the actual composition
		FSTNode composed = null;
		for (FSTNode current : lFeatures) {
			if (composed != null) {
				composed = compose(current, composed, null);
			} else
				composed = current;
		}

		// Allow merge strategies to postprocess their terminal nodes where
		// needed.
		if (composed != null) {
			// Postprocessing only happens if the result will be written to a
			// file
			// TODO: We may want to move this decision into the merge strategies
			if (!fForRegister) {
				postProcess(composed);
			}
		}

		// Remove the feature node on top of the tree again.
		if (composed instanceof FSTNonTerminal) {
			composed = ((FSTNonTerminal) composed).getChildren().get(0);
		}

		return getArtefactHandler().print(composed);
	}

	/**
	 * Invoke post processing methods of merge strategies for all terminal
	 * nodes.
	 * 
	 * @param composed
	 */
	private void postProcess(FSTNode node) {
		if (node instanceof FSTNonTerminal) {
			for (FSTNode child : ((FSTNonTerminal) node).getChildren()) {
				postProcess(child);
			}
		} else {
			FSTTerminal terminalNode = (FSTTerminal) node;
			FSTTerminalCompositionRule compRule = CompositionRuleRegistry
					.getInstance(project).getRule(
							terminalNode.getCompositionMechanism());
			if (compRule != null) {
				compRule.postProcess(terminalNode);
			}
		}
	}

	/**
	 * Compose nodeA and nodeB with parent compParent. Code copied and adjusted
	 * from FSTGenComposer from FeatureHouse.
	 * 
	 * @param compParent
	 *            null if nodeA and nodeB are top-level nodes.
	 */
	private FSTNode compose(FSTNode nodeA, FSTNode nodeB, FSTNode compParent) {
		if (nodeA.compatibleWith(nodeB)) {
			FSTNode compNode = nodeA.getShallowClone();
			compNode.setParent(compParent);

			// composed SubTree-stub is integrated in the new Tree, needs
			// children
			if (nodeA instanceof FSTNonTerminal
					&& nodeB instanceof FSTNonTerminal) {
				FSTNonTerminal nonterminalA = (FSTNonTerminal) nodeA;
				FSTNonTerminal nonterminalB = (FSTNonTerminal) nodeB;
				FSTNonTerminal nonterminalComp = (FSTNonTerminal) compNode;

				for (FSTNode childB : nonterminalB.getChildren()) {
					FSTNode childA = nonterminalA.getCompatibleChild(childB);
					// for each child of B get the first compatible child of A
					// (CompatibleChild means a Child which root equals B's
					// root)
					if (childA == null) {
						// no compatible child, FST-node only in B
						nonterminalComp.addChild(childB.getDeepClone());
					} else {
						nonterminalComp.addChild(compose(childA, childB,
								nonterminalComp));
					}
				}
				for (FSTNode childA : nonterminalA.getChildren()) {
					FSTNode childB = nonterminalB.getCompatibleChild(childA);
					if (childB == null) {
						// no compatible child, FST-node only in A
						nonterminalComp.addChild(childA.getDeepClone());
					}
				}
				return nonterminalComp;
			} else if (nodeA instanceof FSTTerminal
					&& nodeB instanceof FSTTerminal
					&& compParent instanceof FSTNonTerminal) {
				FSTTerminal terminalA = (FSTTerminal) nodeA;
				FSTTerminal terminalB = (FSTTerminal) nodeB;
				FSTTerminal terminalComp = (FSTTerminal) compNode;
				FSTNonTerminal nonterminalParent = (FSTNonTerminal) compParent;

				FSTTerminalCompositionRule compRule = CompositionRuleRegistry
						.getInstance(project).getRule(
								terminalA.getCompositionMechanism());
				if (compRule != null) {
					// Only compose if the two nodes are actually different to avoid producing redundant code
					if (!compRule.areEqual(terminalA, terminalB)) {
						compRule.compose(terminalA, terminalB, terminalComp,
								nonterminalParent);
					}
					// No need for else: terminalComp is already a shallow clone of terminalA
				} else {
					System.err
							.println("Error: don't know how to compose terminals: "
									+ terminalB.toString()
									+ " replaces "
									+ terminalA.toString());
				}
				return terminalComp;
			}
		}
		return null;
	}

	public void setArtifactHandler(String sHandlerID) {
		this.sHandlerID = sHandlerID;
	}

	protected ArtifactHandler getArtefactHandler() {
		return ArtifactHandlerRegistry.getInstance(project).getHandler(
				sHandlerID);
	}
}