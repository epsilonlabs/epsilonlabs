package org.eclipse.epsilon.etl.dtx.transformation.dependency;

import org.eclipse.jface.action.Action;

public class TransformationDependencyViewAction extends Action{

	protected TransformationDependencyGraph tdgView;
	
	public TransformationDependencyViewAction(TransformationDependencyGraph tdgView)
	{
		this.tdgView = tdgView;
	}
	
	public TransformationDependencyViewAction(TransformationDependencyGraph tdgView, String text, int style)
	{
		super(text, style);
		this.tdgView = tdgView;

	}
}
