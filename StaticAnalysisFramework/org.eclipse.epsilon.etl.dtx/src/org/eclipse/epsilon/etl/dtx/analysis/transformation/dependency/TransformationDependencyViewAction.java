package org.eclipse.epsilon.etl.dtx.analysis.transformation.dependency;

import org.eclipse.jface.action.Action;

public class TransformationDependencyViewAction extends Action{

	protected TransformationDependencyView tdView;
	
	public TransformationDependencyViewAction(TransformationDependencyView tdgView)
	{
		this.tdView = tdgView;
	}
	
	public TransformationDependencyViewAction(TransformationDependencyView tdgView, String text, int style)
	{
		super(text, style);
		this.tdView = tdgView;

	}
}
