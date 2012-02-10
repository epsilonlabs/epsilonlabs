package org.eclipse.epsilon.epl;

import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.commons.module.AbstractModuleElement;
import org.eclipse.epsilon.commons.parse.AST;

public class Cardinality extends AbstractModuleElement {
	
	protected int lowerBound;
	protected int upperBound;
	
	public static final int UNBOUNDED = -1;
	
	public Cardinality(AST ast) {
		this.ast = ast;
	}
	
	public Cardinality(int lowerBound, int upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}
	
	public int getUpperBound() {
		return upperBound;
	}
	
	public int getLowerBound() {
		return lowerBound;
	}
	
	public boolean isUnbounded() {
		return upperBound == UNBOUNDED;
	}
	
	public boolean isOne() {
		return upperBound == 1 && lowerBound == 1;
	}
	
	@Override
	public List getChildren() {
		return Collections.EMPTY_LIST;
	}
	
}
