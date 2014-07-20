package org.eclipse.epsilon.etl.dtx.analysis.metamodel.coverage;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class RefreshCoverageAnalysisViewAction extends CoverageAnalysisViewAction{

	public RefreshCoverageAnalysisViewAction(
			CoverageAnalysisView coverageAnalysisView) {
		super(coverageAnalysisView);
		setText("Refresh View");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		coverageAnalysisView.refresh();
	}
	
	public ImageDescriptor getImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.epsilon.etl.dtx", path);
	}

}
