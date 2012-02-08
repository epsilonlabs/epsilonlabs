package org.eclipse.epsilon.coverage.strategies;

public class NamedCoveragePoint extends CoveragePoint {

	protected String name;
	
	public NamedCoveragePoint(int line, int column, int astType, String name) {
		super(line, column, astType);
		this.name = name;
	}

	@Override
	public String toString(){
		return super.toString() + ", name=" + name;
	}
}
