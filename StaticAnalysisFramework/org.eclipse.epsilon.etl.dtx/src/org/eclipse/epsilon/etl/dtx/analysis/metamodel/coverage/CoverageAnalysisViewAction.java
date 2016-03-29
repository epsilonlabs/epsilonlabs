package org.eclipse.epsilon.etl.dtx.analysis.metamodel.coverage;

import org.eclipse.jface.action.Action;

public class CoverageAnalysisViewAction extends Action{

	protected CoverageAnalysisView coverageAnalysisView;
	
	public CoverageAnalysisViewAction(CoverageAnalysisView coverageAnalysisView)
	{
		this.coverageAnalysisView = coverageAnalysisView;
	}
	
	public CoverageAnalysisViewAction(CoverageAnalysisView coverageAnalysisView, String text, int style)
	{
		super(text, style);
		this.coverageAnalysisView = coverageAnalysisView;
	}
}
