package org.eclipse.epsilon.etl.dtx.transformation.dependency;

import org.eclipse.epsilon.etl.dtx.editor.EtlxEditor;
import org.eclipse.epsilon.etl.visitor.coverage.analysis.impl.EtlCoverageAnalyser;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

public class TransformationDependencyGraph extends ViewPart {

	  public static final String ID = "org.eclipse.epsilon.etl.dtx.transformation.dependency";
	  
	  protected TransformationDependencyViewer transformationDependencyViewer;
	  
	  protected EtlCoverageAnalyser coverageAnalyser = new EtlCoverageAnalyser();
	  
	  private CTabFolder folder;
	  private Composite parent;


	  public TransformationDependencyGraph() {
		  super();
	  }

	  public EtlxEditor getEditor()
	  {
		  IWorkbench wb = PlatformUI.getWorkbench();
			IWorkbenchWindow window = wb.getActiveWorkbenchWindow();
			IWorkbenchPage page = window.getActivePage();
			IEditorPart editor = page.getActiveEditor();
			if (editor instanceof EtlxEditor) {
				return (EtlxEditor) editor;
			}
			else {
				return null;
			}
	  }
	@Override
	public void createPartControl(Composite parent) {
		
		folder = new CTabFolder(parent, SWT.NONE);
		folder.setSimple(true);
		folder.setTabPosition(SWT.BOTTOM);

		CTabItem overviewItem = new CTabItem(folder, SWT.NONE);
		overviewItem.setText("Overview");
		transformationDependencyViewer = new TransformationDependencyViewer(folder, SWT.NONE);
		overviewItem.setControl(transformationDependencyViewer);
		
		CTabItem coverageItem = new CTabItem(folder, SWT.NONE);
		coverageItem.setText("Coverage Analysis");
		
		
		folder.setSelection(overviewItem);
		this.parent = parent;
		contributeToActionBars();
	}
	
	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		//fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		//manager.add(action1);
		//manager.add(action2);
		manager.add(new RefreshTransformationDependencyViewAction(this));
	}


	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	
	public void refresh(){
		transformationDependencyViewer.refresh();
//		folder.layout();
//		parent.layout();

	}
	
	

}
