package org.eclipse.epsilon.etl.visitor.resolution.type.context;


import org.eclipse.emf.ecore.EStructuralFeature;

public class TraceUnit {

	protected EStructuralFeature sourceFeature;
	protected EStructuralFeature targetFeature;
	
	public EStructuralFeature getSourceFeature() {
		return sourceFeature;
	}
	
	public EStructuralFeature getTargetFeature() {
		return targetFeature;
	};
}
