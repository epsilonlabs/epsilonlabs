package org.eclipse.epsilon.etl.dtx.transformation.dependency;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class RefreshTransformationDependencyViewAction extends TransformationDependencyViewAction{

	public RefreshTransformationDependencyViewAction(
			TransformationAnalysis tdgView) {
		super(tdgView);
		setText("Refresh View");
		
		setImageDescriptor(getImageDescriptor("icons/refresh.gif"));
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		tdgView.refresh();
	}

	public ImageDescriptor getImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.epsilon.etl.dtx", path);
	}

}
