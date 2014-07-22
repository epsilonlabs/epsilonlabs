package org.eclipse.epsilon.etl.dtx.analysis.metamodel.coverage;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.etl.dtx.analysis.transformation.dependency.RefreshTransformationAnalysisViewAction;
import org.eclipse.epsilon.etl.dtx.editor.EtlxEditor;
import org.eclipse.epsilon.etl.visitor.coverage.analysis.context.MetaElementContainer;
import org.eclipse.epsilon.etl.visitor.coverage.analysis.impl.EtlCoverageAnalyser;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

public class CoverageAnalysisView extends ViewPart {

	protected final int METAMODEL_COLUMN = 0;
	protected final int METAELEMENT_COLUMN = 1;
	protected final int PROPERTY_COLUMN = 2;
	protected final int PROPERTYTYPE_COLUMN = 3;
	protected final int USED_COLUMN = 4;
	
	public static final String ID = "org.eclipse.epsilon.etl.dtx.analysis.metamodel.coverage";
	
	private TableViewer coverageAnalysisViewer;
	
	protected EtlCoverageAnalyser coverageAnalyser = new EtlCoverageAnalyser();
	
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
	
	public CoverageAnalysisView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		coverageAnalysisViewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
		coverageAnalysisViewer.setContentProvider(new ViewContentProvider());
		coverageAnalysisViewer.setLabelProvider(new CoverageAnalysisLabelProvider());
		coverageAnalysisViewer.setInput(getViewSite());
		
//		TableColumn column = new StringTableColumn(coverageAnalysisViewer, SWT.FULL_SELECTION);
//	    column.setText("Current Scope");
//	    column.setWidth(125);
	    
	    TableColumn column = new StringTableColumn(coverageAnalysisViewer, SWT.FULL_SELECTION);
	    column.setText("Meta-model");
	    column.setWidth(125);
	    
	    column = new StringTableColumn(coverageAnalysisViewer, SWT.FULL_SELECTION);
	    column.setText("Meta-element");
	    column.setWidth(125);
	    
	    column = new StringTableColumn(coverageAnalysisViewer, SWT.FULL_SELECTION);
	    column.setText("Property");
	    column.setWidth(125);
	    
	    column = new StringTableColumn(coverageAnalysisViewer, SWT.FULL_SELECTION);
	    column.setText("Property Type");
	    column.setWidth(125);
	    
	    column = new StringTableColumn(coverageAnalysisViewer, SWT.FULL_SELECTION);
	    column.setText("Used");
	    column.setWidth(125);
	    
	    coverageAnalysisViewer.getTable().setHeaderVisible(true);
	    coverageAnalysisViewer.getTable().setLinesVisible(true);

		// TODO Auto-generated method stub
	    
	    contributeToActionBars();

	}
	
	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(new RefreshCoverageAnalysisViewAction(this));
	}
	
	public void refresh()
	{
		EtlxEditor leEditor = getEditor();
		if (leEditor.getEolLibraryModule() != null) {
			coverageAnalyser.getContext().clear();
			coverageAnalyser.run(leEditor.getEolLibraryModule());
		}
		coverageAnalysisViewer.refresh();
	}

	public void refreshTransformationCoverageAnalysisViewer()
	{
		EtlxEditor leEditor = getEditor();
		if (leEditor.getEolLibraryModule() != null) {
			coverageAnalyser.run(leEditor.getEolLibraryModule());
		}
		coverageAnalysisViewer.refresh();
	}
	
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
	
	class CoverageAnalysisLabelProvider extends LabelProvider implements ITableLabelProvider{

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			CoverageUnit unit = (CoverageUnit) element;
			if (columnIndex == METAMODEL_COLUMN) {
				return unit.getMetaModel();
			}
			else if (columnIndex == METAELEMENT_COLUMN) {
				return unit.getMetaElement();
			}
			else if (columnIndex == PROPERTY_COLUMN) {
				return unit.getProperty();
			}
			else if (columnIndex == PROPERTYTYPE_COLUMN) {
				return unit.getPropertyType();
			}
			else if (columnIndex == USED_COLUMN) {
				return unit.getUsed();
			}
			return "_";
		}
		
	}
	
	class ViewContentProvider implements IStructuredContentProvider {
		public void dispose() {
		}
		public Object[] getElements(Object parent) {
			return getUnits(coverageAnalyser.getContext().getCoverageForGlobal(), true).toArray();
		}
		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public ArrayList<CoverageUnit> getUnits(ArrayList<MetaElementContainer> containers, boolean global)
	{
		ArrayList<CoverageUnit> result = new ArrayList<CoverageUnit>();
		for(MetaElementContainer mec: containers)
		{
			EClass eClass = mec.getEClass();
			for(EStructuralFeature feature: mec.getAllFeatures())
			{
				if (mec.getFeaturesAccessedViaOpposite().contains(feature)) {
					result.add(new CoverageUnit(eClass, feature, "via opposite"));
				}
				else {
					result.add(new CoverageUnit(eClass, feature, "true"));	
				}
			}
			for(EStructuralFeature feature: mec.getAllUnusedFeatures())
			{
				result.add(new CoverageUnit(eClass, feature, "false"));
			}
		}
		if (global) {
			for(EClass eClass: coverageAnalyser.getContext().getUnusedClasses())
			{
				if (eClass.isAbstract() || eClass.isInterface()) {
					
				}
				else {
					result.add(new CoverageUnit(eClass, null, "false"));
				}
				
			}
		}
		return result;
	}
	

}
