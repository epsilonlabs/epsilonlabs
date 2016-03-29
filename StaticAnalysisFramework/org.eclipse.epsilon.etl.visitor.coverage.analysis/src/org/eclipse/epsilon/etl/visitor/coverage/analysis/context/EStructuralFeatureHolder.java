package org.eclipse.epsilon.etl.visitor.coverage.analysis.context;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.metamodel.EOLElement;

public class EStructuralFeatureHolder {

	protected boolean write = false;
	protected boolean read = true;
	protected ArrayList<EOLElement> reads = new ArrayList<EOLElement>();
	protected ArrayList<EOLElement> writes = new ArrayList<EOLElement>();
	
	public ArrayList<EOLElement> getReads() {
		return reads;
	}
	
	public ArrayList<EOLElement> getWrites() {
		return writes;
	}
	
	public boolean isWrite() {
		return write;
	}
	
	public boolean isRead() {
		return read;
	}
}
