package org.eclipse.epsilon.coverage.strategies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.parse.EolParser;


public class DecisionCoverageStrategy extends AbstractCoverageStrategy {
	
	/**
	 * We keep a list of ASTs who's result we are interested in.
	 */
	protected List<AST> astsOfInterest = new ArrayList<AST>();
	
	public DecisionCoverageStrategy() {
		coveragePoints = new ArrayList<CoveragePoint>();
	}

	protected final ArrayList<Integer> elementsOfInterest = new ArrayList<Integer>(Arrays.asList(
			EolParser.IF, EolParser.CASE // We don't need the ELSE? 
			));
	
	@Override
	public void buildModel(AST ast) {
		if (elementsOfInterest.contains(ast.getType())) {
			coveragePoints.add(new DecisionPoint(ast.getLine(), ast.getColumn(), ast.getType()));
		}
	}
	
	@Override
	public void cover(AST ast){
		if (elementsOfInterest.contains(ast.getType())) {	
			astsOfInterest.add(ast.getChild(0)); // The first child of an IF AST is the condition
			// TODO: What about CASE??
		}
	}
	
	@Override
	public void finishCovering(AST ast, Object result) {
		if (astsOfInterest.contains(ast)) { // TODO: untested. At second glance, this looks wrong.
			AST parent = ast.getParent(); // The IF AST
			
			for (CoveragePoint cPoint : coveragePoints) {
				DecisionPoint dPoint = (DecisionPoint)cPoint;
				
				if (dPoint.line == parent.getLine() && dPoint.column == parent.getColumn() && dPoint.astType == parent.getType()) {
					
					if (result instanceof Boolean) {
						if ((Boolean) result) {
							dPoint.coveredTrueBranch = true;
						} else {
							dPoint.coveredFalseBranch = true;						
						}
					}
					
					break;
				}				
			}
		}
	}

	@Override
	protected String getStrategyName() {
		return "Decision";
	}

//	@Override
//	public void reset() {
//		super.reset();
//		astsOfInterest = new ArrayList<AST>();
//	}
}
