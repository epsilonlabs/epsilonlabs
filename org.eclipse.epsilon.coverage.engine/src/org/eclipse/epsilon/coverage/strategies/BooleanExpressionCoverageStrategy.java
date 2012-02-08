package org.eclipse.epsilon.coverage.strategies;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;


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
			coveragePoints.add(new DecisionPoint(ast.getLine(), ast.getColumn(), ast.getType()));
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
			
			Iterator<CoveragePoint> iterator = coveragePoints.iterator();
			while (iterator.hasNext()) {
				DecisionPoint dPoint = (DecisionPoint)iterator.next();
//				System.out.println(ast + " = " + dPoint);
				if (dPoint.line == ast.getLine() && dPoint.column == ast.getColumn() && dPoint.astType == ast.getType()) {
					if (result instanceof Boolean) {
//						System.out.println(result + ", " + dPoint);
						if ((Boolean) result) {
							dPoint.coveredTrueBranch = true;
						} else {
							dPoint.coveredFalseBranch = true;						
						}
						
						if (dPoint.coveredFalseBranch && dPoint.coveredTrueBranch) {
							dPoint.covered = true;
						}
					} else {
						// Result isn't a boolean (coming from a POINT AST), so let's remove it from the list
						coveragePoints.remove(dPoint);
					}
					
					break;
				}				
			}
			// FIXME: This will never delete invalid coverage points which aren't executed. I.e. assignment.
		}		
	}

	public int getNumberOfPointsPartiallyCovered() {
		int numTrue = 0;
		for (CoveragePoint c : coveragePoints) {
			if (((DecisionPoint)c).coveredFalseBranch && !((DecisionPoint)c).coveredTrueBranch)  numTrue++;
			if (((DecisionPoint)c).coveredTrueBranch && !((DecisionPoint)c).coveredFalseBranch)  numTrue++;
		}
		return numTrue;
	}
	
	@Override
	public String getSummary() {
		DecimalFormat df = new DecimalFormat("#.##");
		
		for (CoveragePoint c : coveragePoints) {
			System.out.println(c);
		}
		
		return getStrategyName() + " coverage = " + df.format(getPercentageCovered()) +"% : " 
				+ getNumberOfPointsCovered() + "/" + coveragePoints.size() 
				+ " (" + getNumberOfPointsPartiallyCovered() + "/" + coveragePoints.size() + ")";
	}

	@Override
	protected String getStrategyName() {
		return "Condition";
	}
}
