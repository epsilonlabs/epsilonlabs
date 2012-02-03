package org.eclipse.epsilon.coverage.strategies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.parse.EolParser;


public class ConditionCoverageStrategy extends AbstractCoverageStrategy {
	
	/**
	 * We keep a list of ASTs who's result we are interested in.
	 */
	protected List<AST> astsOfInterest = new ArrayList<AST>();
	
	protected final ArrayList<Integer> elementsOfInterest = new ArrayList<Integer>(Arrays.asList(
			EolParser.OPERATOR, EolParser.POINT 
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
			astsOfInterest.add(ast); 
		}
	}
	
	@Override
	public void finishCovering(AST ast, Object result) {
		if (astsOfInterest.contains(ast)) {
			Iterator<CoveragePoint> iterator = coveragePoints.iterator();
			while (iterator.hasNext()) {
				DecisionPoint dPoint = (DecisionPoint)iterator.next();
				if (dPoint.line == ast.getLine() && dPoint.column == ast.getColumn() && dPoint.astType == ast.getType()) {
					
					if (result instanceof Boolean) {
						if ((Boolean) result) {
							dPoint.coveredTrueBranch = true;
						} else {
							dPoint.coveredFalseBranch = true;						
						}
					} else {
						// Result isn't a boolean (coming from a POINT AST), so let's remove it from the list
						coveragePoints.remove(dPoint); // TODO - move this check to the top, to avoid unnecessary computation.
					}
					
					break;
				}				
			}
		}		
	}

	@Override
	protected String getStrategyName() {
		return "Condition";
	}
}
