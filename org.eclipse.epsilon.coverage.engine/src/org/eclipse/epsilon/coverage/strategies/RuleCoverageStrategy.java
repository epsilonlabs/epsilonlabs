package org.eclipse.epsilon.coverage.strategies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.ecl.parse.EclParser;
import org.eclipse.epsilon.eml.parse.EmlParser;
import org.eclipse.epsilon.etl.parse.EtlParser;
import org.eclipse.epsilon.evl.parse.EvlParser;
import org.eclipse.epsilon.flock.parse.FlockParser;


public class RuleCoverageStrategy extends AbstractCoverageStrategy {
	
	protected List<NamedCoveragePoint> coveragePoints;
	
	public RuleCoverageStrategy() {
		coveragePoints = new ArrayList<NamedCoveragePoint>();
	}

	protected final ArrayList<Integer> elementsOfInterest = new ArrayList<Integer>(Arrays.asList(
			EtlParser.TRANSFORM, EmlParser.MERGE, EclParser.COMPARE, EvlParser.CONSTRAINT,
			EvlParser.CRITIQUE, FlockParser.MIGRATE
			));
	
	@Override
	public void buildModel(AST ast) {
		if (elementsOfInterest.contains(ast.getType())) {
			coveragePoints.add(new NamedCoveragePoint(ast.getLine(), ast.getColumn(), ast.getType(), ast.getChild(0).getText()));
		}
	}
	
	@Override
	public void cover(AST ast){
		AST parent = ast.getParent();
		// TODO test.
		while (parent != null) {
			if (elementsOfInterest.contains(parent)) {
				// add and break
				NamedCoveragePoint point = new NamedCoveragePoint(parent.getLine(), -1, parent.getType(), parent.getChild(0).getText());
			
				for (NamedCoveragePoint p : coveragePoints) {
					if (point.equals(p)) {
						p.setCovered(true);
						break;
					}
				}
				break;
			} else {
				parent = parent.getParent();
			}
		}
	}
	
	@Override
	public void finishCovering(AST ast, Object result) { }

	@Override
	protected String getStrategyName() {
		return "Rule";
	}
}
