package org.eclipse.epsilon.coverage.strategies;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

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
		int numTrue = 0;
		
		for (CoveragePoint c : coveragePoints) {
			if (c.covered) numTrue++;
		}
		DecimalFormat df = new DecimalFormat("#.##");
		return getStrategyName() + " coverage = " + df.format(getScore()) +"% : " + numTrue + "/" + coveragePoints.size();
	}

	@Override
	public String getDetail() {
		StringBuilder sb = new StringBuilder();
		
		for (CoveragePoint c : coveragePoints) {
			sb.append(c.toString() + "\n");
		}
		
		return sb.toString();
	}

	@Override
	public double getScore() {
		
		if (coveragePoints.size() == 0) return 0;
		
		int numTrue = 0;
		for (CoveragePoint c : coveragePoints) {
			if (c.covered) numTrue++;
		}
		return (Double.valueOf(numTrue) / coveragePoints.size()) * 100;
	}
	

	public void reset(){
		for (CoveragePoint c : coveragePoints) {
			c.setCovered(false);
		}
	}
}
