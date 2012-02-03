package org.eclipse.epsilon.coverage.strategies;

public class CoveragePoint implements Cloneable {
	protected int line;
	protected int column;
	protected int astType;
	protected boolean covered = false;
	protected int timesExecuted = 0;
	
	public CoveragePoint(int line, int column, int astType) {
		this.line = line;
		this.column = column;
		this.astType = astType;
	}
	
	public boolean isCovered() {
		return covered;
	}
	
	public String toString() {
		return "Line="+line+", column="+column+", astType=" + astType+", covered="+covered;
	}
	
	@Override
	public CoveragePoint clone() {
		CoveragePoint c = new CoveragePoint(line, column, astType);
		c.covered = this.covered;
		return c;
	}
	
	@Override
	public boolean equals(Object c) {
		if (c instanceof CoveragePoint) {
			CoveragePoint p = (CoveragePoint) c;
			if (line == p.line && column == p.column && p.astType == astType){
				return true;
			}
		}
		return false;
	}
	
	public void incrementTimesExecuted() {
		timesExecuted++;
	}

	public void setCovered(boolean covered) {
		this.covered = covered;
	}
	
	public int getAstType() {
		return astType;
	}
}
