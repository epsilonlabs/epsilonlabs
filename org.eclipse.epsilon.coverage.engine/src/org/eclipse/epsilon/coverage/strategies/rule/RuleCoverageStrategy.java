package org.eclipse.epsilon.coverage.strategies.rule;

import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.coverage.strategies.AbstractCoverageStrategy;

import EpsilonCoverage.CoveragePoint;
import EpsilonCoverage.CoverageType;
import EpsilonCoverage.EpsilonCoverageFactory;


public abstract class RuleCoverageStrategy extends AbstractCoverageStrategy {
	
	protected RuleCoverageStrategy(List<Integer> astsOfInterest) {
		elementsOfInterest = astsOfInterest;
		strategyModel.setType(CoverageType.RULE);
	}
	
	protected final List<Integer> elementsOfInterest;
	
	@Override
	public void buildModel(AST ast) {
		if (elementsOfInterest.contains(ast.getType())) {
			CoveragePoint point = EpsilonCoverageFactory.eINSTANCE.createCoveragePoint();
			point.setAstType(ast.getType());
			point.setColumn(ast.getColumn());
			point.setLine(ast.getLine());
			point.setUri(ast.getUri().getPath());

			strategyModel.getPoints().add(point);
		}
	}
	
	@Override
	public void cover(AST ast){
		AST parent = ast.getParent();

		boolean found = false;
		while (parent != null) {
			if (elementsOfInterest.contains(parent.getType())) {
				for (CoveragePoint p : strategyModel.getPoints()) {
					if (p.getLine() == parent.getLine() && p.getAstType() == parent.getType()) {
						p.setTimesExecuted(p.getTimesExecuted()+1);
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
}