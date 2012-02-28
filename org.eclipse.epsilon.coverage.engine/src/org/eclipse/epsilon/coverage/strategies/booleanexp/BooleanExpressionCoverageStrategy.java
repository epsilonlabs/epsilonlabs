package org.eclipse.epsilon.coverage.strategies.booleanexp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.coverage.strategies.AbstractCoverageStrategy;

import EpsilonCoverage.BooleanCoveragePoint;
import EpsilonCoverage.EpsilonCoverageFactory;


public abstract class BooleanExpressionCoverageStrategy extends AbstractCoverageStrategy {
	
	/**
	 * We keep a list of ASTs that have been executed and who's result we are expecting.
	 */
	protected List<AST> astsToMonitor = new ArrayList<AST>();
	
	/**
	 * A list of the ASTs who's execution we wish to monitor.
	 */
	protected final List<Integer> astTypesOfInterest;
	
	protected BooleanExpressionCoverageStrategy(List<Integer> astTypesOfInterest) {
		this.astTypesOfInterest = astTypesOfInterest;
	}
	
	@Override
	public void buildModel(AST ast) {
		if (astTypesOfInterest.contains(ast.getType())) {
			System.out.println(ast);
			
			BooleanCoveragePoint point = EpsilonCoverageFactory.eINSTANCE.createBooleanCoveragePoint();
			point.setAstType(ast.getType());
			point.setColumn(ast.getColumn());
			point.setLine(ast.getLine());
			point.setUri(ast.getUri().getPath());
			strategyModel.getPoints().add(point);
		}
	}
	
	@Override
	public void cover(AST ast){
		if (astTypesOfInterest.contains(ast.getType())) {	
			astsToMonitor.add(ast); 
		}
	}
	
	@Override
	public void finishCovering(AST ast, Object result) {
		if (astsToMonitor.contains(ast)) {
			
			Iterator<EpsilonCoverage.CoveragePoint> iterator = strategyModel.getPoints().iterator();
			while (iterator.hasNext()) {
				BooleanCoveragePoint dPoint = (BooleanCoveragePoint)iterator.next();
				if (dPoint.getLine() == ast.getLine() && dPoint.getColumn() == ast.getColumn() && dPoint.getAstType() == ast.getType() && dPoint.getUri().equals(ast.getUri().getPath())) {
					if (result instanceof Boolean) {
						if ((Boolean) result) {
							dPoint.setTrueBranchCovered(true);
						} else {
							dPoint.setFalseBranchCovered(true);						
						}
						dPoint.setTimesExecuted(dPoint.getTimesExecuted()+1);
					} else {
						// Result isn't a boolean (coming from a POINT AST), so let's remove it from the list
						strategyModel.getPoints().remove(dPoint);
					}
					
					break;
				}				
			}
			// FIXME: This will never delete invalid coverage points which aren't executed. I.e. assignment.
		}		
	}

	public int getNumberOfPointsPartiallyCovered() {
		int numTrue = 0;
		for (EpsilonCoverage.CoveragePoint c : strategyModel.getPoints()) {
			if (((BooleanCoveragePoint)c).isFalseBranchCovered() && !((BooleanCoveragePoint)c).isTrueBranchCovered())  numTrue++;
			if (((BooleanCoveragePoint)c).isTrueBranchCovered() && !((BooleanCoveragePoint)c).isFalseBranchCovered())  numTrue++;
		}
		return numTrue;
	}
	
}
