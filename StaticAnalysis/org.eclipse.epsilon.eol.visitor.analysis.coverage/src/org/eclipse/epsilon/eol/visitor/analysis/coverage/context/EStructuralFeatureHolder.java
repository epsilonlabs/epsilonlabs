package org.eclipse.epsilon.eol.visitor.analysis.coverage.context;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.eol.metamodel.EolElement;

public class EStructuralFeatureHolder {
	protected EStructuralFeature feature;
	
	protected ArrayList<EolElement> reads = new ArrayList<EolElement>();
	protected ArrayList<EolElement> writes = new ArrayList<EolElement>();
	
	public EStructuralFeature getFeature() {
		return feature;
	}
	
	public void setFeature(EStructuralFeature feature) {
		this.feature = feature;
	}
	
	public ArrayList<EolElement> getReads() {
		return reads;
	}
	
	public ArrayList<EolElement> getWrites() {
		return writes;
	}
	
	public void addRead(EolElement eolElement)
	{
		reads.add(eolElement);
	}
	
	public void addWrite(EolElement eolElement)
	{
		writes.add(eolElement);
	}
}
