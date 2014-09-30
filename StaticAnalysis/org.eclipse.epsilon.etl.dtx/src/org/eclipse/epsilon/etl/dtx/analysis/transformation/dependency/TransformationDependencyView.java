package org.eclipse.epsilon.etl.dtx.analysis.transformation.dependency;

import org.eclipse.core.resources.IFile;
import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.TextRegion;
import org.eclipse.epsilon.etl.dtx.editor.EtlxEditor;
import org.eclipse.epsilon.etl.metamodel.TransformationRule;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ViewPart;

public class TransformationDependencyView extends ViewPart {

	protected TransformationDependencyViewer transformationDependencyViewer;
	protected TransformationRule selectedTransformationRule;

	public TransformationDependencyView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		transformationDependencyViewer = new TransformationDependencyViewer(parent, SWT.NONE, this);
		contributeToActionBars();
	}

	@Override
	public void setFocus() {

	}
	
	public void setSelectedTransformationRule(
			TransformationRule selectedTransformationRule) {
		this.selectedTransformationRule = selectedTransformationRule;
	}
	
	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(new RefreshTransformationAnalysisViewAction(this));
	}

	public void refresh(){
		contributeToActionBars();
		transformationDependencyViewer.refresh();
	}
	
	public void selectElementInEditor(EolElement selectedElement)
	{
		if (selectedElement != null) {
			EtlxEditor editor = getEditor();
			try {
				IDocument doc = editor.getDocumentProvider().getDocument(editor.getEditorInput());
				TextRegion region = selectedElement.getRegion();
				
				int startOffset = doc.getLineOffset(region.getStart().getLine()-1) + region.getStart().getColumn();
				int endOffset = doc.getLineOffset(region.getEnd().getLine()-1) + region.getEnd().getColumn();
				
				FileEditorInput fileInputEditor = (FileEditorInput) editor.getEditorInput();
				IFile file = fileInputEditor.getFile();

				EclipseUtil.openEditorAt(file, region.getStart().getLine(), 
						region.getStart().getColumn(), endOffset - startOffset, false);

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
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

}
