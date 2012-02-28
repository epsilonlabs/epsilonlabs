package org.eclipse.epsilon.coverage.strategies;

import org.eclipse.epsilon.commons.parse.AST;

import EpsilonCoverage.CoverageStrategy;
import EpsilonCoverage.EpsilonCoverageFactory;

public abstract class AbstractCoverageStrategy implements ICoverageStrategy {
	
	protected CoverageStrategy strategyModel;
	
	public AbstractCoverageStrategy() {
		strategyModel = EpsilonCoverageFactory.eINSTANCE.createCoverageStrategy();
	}
	
	@Override
	final public CoverageStrategy getModel() {
		return strategyModel;
	}

	public int getNumberOfPointsCovered() {
		int numCovered = 0;
		for (EpsilonCoverage.CoveragePoint c : strategyModel.getPoints()) {
			if (c.getTimesExecuted() > 0) numCovered++;
		}
		return numCovered;
	}

	@Override
	public void finishCovering(AST ast, Object result) { }	

	public void reset(){
		strategyModel.getPoints().clear();
	}
}
