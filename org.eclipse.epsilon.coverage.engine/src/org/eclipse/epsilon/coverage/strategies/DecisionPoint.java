package org.eclipse.epsilon.coverage.strategies;

public class DecisionPoint extends CoveragePoint {
	protected boolean coveredTrueBranch;
	protected boolean coveredFalseBranch;

	public DecisionPoint(int line, int column, int astType) {
		super(line, column, astType);
	}
	
	@Override
	public String toString() {
		return "line: " + line + ", column: " + column + ", AST type: " + astType + 
				", covered true branch: " + coveredTrueBranch + ", covered false branch: " + coveredFalseBranch;
	}
}
