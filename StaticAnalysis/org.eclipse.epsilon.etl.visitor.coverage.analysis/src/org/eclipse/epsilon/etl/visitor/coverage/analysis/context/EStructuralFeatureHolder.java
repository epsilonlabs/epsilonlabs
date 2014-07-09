package org.eclipse.epsilon.etl.visitor.coverage.analysis.context;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.metamodel.EolElement;

public class EStructuralFeatureHolder {

	protected boolean write = false;
	protected boolean read = true;
	protected ArrayList<EolElement> reads = new ArrayList<EolElement>();
	protected ArrayList<EolElement> writes = new ArrayList<EolElement>();
	
	public ArrayList<EolElement> getReads() {
		return reads;
	}
	
	public ArrayList<EolElement> getWrites() {
		return writes;
	}
	
	public boolean isWrite() {
		return write;
	}
	
	public boolean isRead() {
		return read;
	}
}
