package org.eclipse.epsilon.etl.dtx.transformation.dependency;

public class RefreshTransformationDependencyViewAction extends TransformationDependencyViewAction{

	public RefreshTransformationDependencyViewAction(
			TransformationDependencyGraph tdgView) {
		super(tdgView);
		setText("Refresh View");
		//setImageDescriptor(Activator.getImageDescriptor("icons/refresh.gif"));
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		tdgView.refresh();
	}

}
