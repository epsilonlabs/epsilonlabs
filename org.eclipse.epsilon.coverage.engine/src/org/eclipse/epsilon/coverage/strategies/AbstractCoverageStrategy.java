package org.eclipse.epsilon.coverage.strategies;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;

public abstract class AbstractCoverageStrategy implements ICoverageStrategy {
	
	protected List<CoveragePoint> coveragePoints;
	
	public AbstractCoverageStrategy() {
		coveragePoints = new ArrayList<CoveragePoint>();
	}
	
	abstract protected String getStrategyName();

	@Override
	public List<CoveragePoint> getModel() {
		return coveragePoints;
	}

	@Override
	public String getSummary() {
		DecimalFormat df = new DecimalFormat("#.##");
		return getStrategyName() + " coverage = " + df.format(getPercentageCovered()) +"% : " + getNumberOfPointsCovered() + "/" + coveragePoints.size();
	}

	@Override
	public String getDetail() {
		StringBuilder sb = new StringBuilder();
		
		for (CoveragePoint c : coveragePoints) {
			sb.append(c.toString() + "\n");
		}
		
		return sb.toString();
	}
	
	public int getNumberOfPointsCovered() {
		int numTrue = 0;
		for (CoveragePoint c : coveragePoints) {
			if (c.covered) numTrue++;
		}
		return numTrue;
	}

	@Override
	public double getPercentageCovered() {
		if (coveragePoints.size() == 0) return 0;
		return (Double.valueOf(getNumberOfPointsCovered()) / coveragePoints.size()) * 100;
	}

	@Override
	public void finishCovering(AST ast, Object result) { }	

	public void reset(){
//		for (CoveragePoint c : coveragePoints) {
//			c.reset();
//		}
		coveragePoints.clear(); // TODO
	}
}
