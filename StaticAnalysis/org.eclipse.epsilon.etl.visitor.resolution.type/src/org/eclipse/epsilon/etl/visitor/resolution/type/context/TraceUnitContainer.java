package org.eclipse.epsilon.etl.visitor.resolution.type.context;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.epsilon.etl.metamodel.TransformationRule;

public class TraceUnitContainer {

	protected TransformationRule rule;
	protected String transformationRule;
	
	protected EClass source;
	protected ArrayList<EClass> targets;
	
	protected ArrayList<TraceUnit> traces;
	
	public TraceUnitContainer()
	{
		
	}
}
