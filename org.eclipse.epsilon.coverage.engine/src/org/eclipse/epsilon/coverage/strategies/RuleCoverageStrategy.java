package org.eclipse.epsilon.coverage.strategies;

import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;


public abstract class RuleCoverageStrategy extends AbstractCoverageStrategy {
	
	protected RuleCoverageStrategy(List<Integer> astsOfInterest) {
		elementsOfInterest = astsOfInterest;
	}
	
	protected final List<Integer> elementsOfInterest;
	
	@Override
	public void buildModel(AST ast) {
		if (elementsOfInterest.contains(ast.getType())) {
			coveragePoints.add(new NamedCoveragePoint(ast.getLine(), ast.getColumn(), ast.getType(), ast.getChild(0).getText()));
		}
	}
	
	@Override
	public void cover(AST ast){
		AST parent = ast.getParent();

		boolean found = false;
		while (parent != null) {
			if (elementsOfInterest.contains(parent.getType())) {
				for (CoveragePoint p : coveragePoints) {
					if (p.line == parent.getLine() && p.astType == parent.getType()) {
						p.setCovered(true);
						found = true;
						break;
					}
				}
				if (found) break;
			} else {
				parent = parent.getParent();
			}
		}
	}

	@Override
	protected String getStrategyName() {
		return "Rule";
	}
}
