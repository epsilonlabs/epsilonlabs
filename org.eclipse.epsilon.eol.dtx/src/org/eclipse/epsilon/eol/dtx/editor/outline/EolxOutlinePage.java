package org.eclipse.epsilon.eol.dtx.editor.outline;

import java.io.File;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.common.dt.editor.outline.EditorSelection;
import org.eclipse.epsilon.common.dt.editor.outline.ModuleContentOutlinePage;
import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.ast2dom.Ast2DomContext;
import org.eclipse.epsilon.eol.dom.ast2dom.EolElementCreatorFactory;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;

public class EolxOutlinePage extends ModuleContentOutlinePage {

	public EolxOutlinePage(IDocumentProvider documentProvider,
			ITextEditor editor, ILabelProvider labelProvider) {
		super(documentProvider, editor, labelProvider);
	}
	
	@Override
	public Object getOutlineRoot(IModule module) {
		return new DomOutlineElement(new EolElementCreatorFactory().createDomElement(module.getAst(), null, new Ast2DomContext()));
	}
	
	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		
		if (!linkWithEditorAction.isChecked()) return;
		
		try {
			
			DomElement selected = ((DomOutlineElement) ((IStructuredSelection) event
					.getSelection()).getFirstElement()).getDomElement();
			
			EditorSelection editorSelection = getEditorSelection(selected);
			
			EclipseUtil.openEditorAt(editorSelection.getFile(), editorSelection.getLine(), 
					editorSelection.getColumn(), 1, false);
		}
		catch (Exception ex) {
			
		}
	}
	
	@Override
	protected EditorSelection getEditorSelection(Object selection) {
		DomElement element = (DomElement) selection;
		FileEditorInput fileInputEditor = (FileEditorInput) editor.getEditorInput();
		IFile file = fileInputEditor.getFile();
		return new EditorSelection(new File(file.getLocation().toOSString()), element.getLine(), element.getColumn());
	}
	
	@Override
	protected IContentProvider createContentProvider() {
		return new ITreeContentProvider() {
			
			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				
			}
			
			@Override
			public void dispose() {
				
			}
			
			@Override
			public boolean hasChildren(Object element) {
				return getChildren(element).length > 0;
			}
			
			@Override
			public Object getParent(Object element) {
				return ((EObject) element).eContainer();
			}
			
			@Override
			public Object[] getElements(Object inputElement) {
				return getChildren(inputElement);
			}
			
			@Override
			public Object[] getChildren(Object parentElement) {
				//return ((EObject) parentElement).eContents().toArray();
				List<EObject> contents = ((DomOutlineElement) parentElement).getDomElement().eContents();
				DomOutlineElement[] domOutlineElements = new DomOutlineElement[contents.size()];
				int i = 0;
				for (EObject content : contents) {
					domOutlineElements[i] = new DomOutlineElement((DomElement) content);
					i++;
				}
				return domOutlineElements;
			}
		};
	}
	
}
