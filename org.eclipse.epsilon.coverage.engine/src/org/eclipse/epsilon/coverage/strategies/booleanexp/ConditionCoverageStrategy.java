package org.eclipse.epsilon.coverage.strategies.booleanexp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.parse.EolParser;

import EpsilonCoverage.BooleanCoveragePoint;
import EpsilonCoverage.CoverageType;
import EpsilonCoverage.EpsilonCoverageFactory;


public class ConditionCoverageStrategy extends BooleanExpressionCoverageStrategy {

	public ConditionCoverageStrategy() {
		super(Arrays.asList(EolParser.OPERATOR, EolParser.POINT));
		strategyModel.setType(CoverageType.CONDITION);
	}
	
	private List<Integer> astConditionAncestors = new ArrayList<Integer>(Arrays.asList(EolParser.IF, EolParser.CASE, EolParser.ELSE));
	
	@Override
	public void buildModel(AST ast) {
		if (astTypesOfInterest.contains(ast.getType())) {
			// climb up to find first IF parent. Then check its first child for the given ast. 
			AST holder = null;
			AST p = ast;
			while (p != null) {
				if (astConditionAncestors.contains(p.getType())){
					holder = p;
					break;
				}
				p = p.getParent();
			}
			
			if (holder != null) {
				AST firstChild = holder.getFirstChild();
				if (ast == firstChild || firstChild.getChildren().contains(ast)){
					BooleanCoveragePoint point = EpsilonCoverageFactory.eINSTANCE.createBooleanCoveragePoint();
					point.setAstType(ast.getType());
					point.setColumn(ast.getColumn());
					point.setLine(ast.getLine());
					point.setUri(ast.getUri().getPath());
					strategyModel.getPoints().add(point);
				}
			}
		}
	}
}
