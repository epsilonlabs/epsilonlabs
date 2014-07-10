package org.eclipse.epsilon.etl.dtx.transformation.dependency;

import org.eclipse.epsilon.etl.metamodel.TransformationRule;
import org.eclipse.jface.action.Action;

public class PullDownAction extends Action{

	protected TransformationRule transformationRule;
	protected TransformationAnalysis transformationAnalysis;
	
	public PullDownAction(String text, int style, TransformationRule transformationRule, TransformationAnalysis transformationAnalysis)
	{
		super(text, style);
		this.transformationRule = transformationRule;
		this.transformationAnalysis = transformationAnalysis;
	}
	
	public TransformationRule getTransformationRule() {
		return transformationRule;
	}
	
	@Override
	public void run() {
		transformationAnalysis.setSelectedTransformationRule(transformationRule);
		transformationAnalysis.refreshTransformationCoverageAnalysisViewer();
		if (transformationRule != null) {
			transformationAnalysis.selectElementInEditor(transformationRule);	
		}
		
	}
}
