package org.eclipse.epsilon.etl.dtx.analysis.transformation.dependency;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class RefreshTransformationAnalysisViewAction extends TransformationDependencyViewAction{

	public RefreshTransformationAnalysisViewAction(
			TransformationDependencyView tdView) {
		super(tdView);
		setText("Refresh View");
		
		setImageDescriptor(getImageDescriptor("icons/refresh.gif"));
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		tdView.refresh();
	}

	public ImageDescriptor getImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.epsilon.etl.dtx", path);
	}

}
