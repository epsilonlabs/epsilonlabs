package org.eclipse.epsilon.eol.dtx.editor.outline;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.common.dt.editor.outline.EditorSelection;
import org.eclipse.epsilon.common.dt.editor.outline.ModuleContentOutlinePage;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.ast2dom.Ast2DomContext;
import org.eclipse.epsilon.eol.dom.ast2dom.EolElementCreatorFactory;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
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
	public Object transform(IModule module) {
		return new EolElementCreatorFactory().createDomElement(module.getAst(), null, new Ast2DomContext());
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
				return ((EObject) inputElement).eContents().toArray();
			}
			
			@Override
			public Object[] getChildren(Object parentElement) {
				return ((EObject) parentElement).eContents().toArray();
			}
		};
	}
	
}
