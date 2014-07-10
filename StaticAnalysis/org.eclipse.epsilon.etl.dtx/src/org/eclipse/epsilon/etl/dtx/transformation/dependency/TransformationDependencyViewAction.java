package org.eclipse.epsilon.etl.dtx.transformation.dependency;

import org.eclipse.jface.action.Action;

public class TransformationDependencyViewAction extends Action{

	protected TransformationAnalysis tdgView;
	
	public TransformationDependencyViewAction(TransformationAnalysis tdgView)
	{
		this.tdgView = tdgView;
	}
	
	public TransformationDependencyViewAction(TransformationAnalysis tdgView, String text, int style)
	{
		super(text, style);
		this.tdgView = tdgView;

	}
}
