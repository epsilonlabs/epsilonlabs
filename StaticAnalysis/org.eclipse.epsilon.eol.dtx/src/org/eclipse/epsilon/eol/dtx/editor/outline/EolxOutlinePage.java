package org.eclipse.epsilon.eol.dtx.editor.outline;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.common.dt.editor.outline.EditorSelection;
import org.eclipse.epsilon.common.dt.editor.outline.ModuleContentOutlinePage;
import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.Region;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.TextRegion;
import org.eclipse.epsilon.eol.dom.ast2dom.Ast2DomContext;
import org.eclipse.epsilon.eol.dom.ast2dom.EolElementCreatorFactory;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.impl.TypeResolver;
import org.eclipse.epsilon.eol.dom.visitor.resolution.variable.impl.VariableResolver;
import org.eclipse.jface.text.IDocument;
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
		DomElement dom = new EolElementCreatorFactory().createDomElement(module.getAst(), null, new Ast2DomContext());
		VariableResolver vr = new VariableResolver();
		vr.run(dom);
		
		TypeResolver tr = new TypeResolver();
		tr.run(dom);
		
		
		return new DomOutlineElement(dom);
	}
	
	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		
		if (!linkWithEditorAction.isChecked()) return;
		
		try {
			
			DomElement selected = ((DomOutlineElement) ((IStructuredSelection) event
					.getSelection()).getFirstElement()).getDomElement();
			
			IDocument doc = editor.getDocumentProvider().getDocument(editor.getEditorInput());
			TextRegion region = selected.getRegion();
			
			int startOffset = doc.getLineOffset(region.getStart().getLine()-1) + region.getStart().getColumn();
			int endOffset = doc.getLineOffset(region.getEnd().getLine()-1) + region.getEnd().getColumn();
			
			FileEditorInput fileInputEditor = (FileEditorInput) editor.getEditorInput();
			IFile file = fileInputEditor.getFile();
			
			EclipseUtil.openEditorAt(new File(file.getLocation().toOSString()), region.getStart().getLine(), 
					region.getStart().getColumn(), endOffset - startOffset, false);

		}
		catch (Exception ex) {
			
		}
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
				List<EObject> contents = ((DomOutlineElement) parentElement).getDomElement().eContents();
				List<DomOutlineElement> children = new ArrayList<DomOutlineElement>();
				for (EObject content : contents) {
					if (content instanceof DomElement) {
						children.add(new DomOutlineElement((DomElement) content));
					}
				}
				return children.toArray();
			}
		};
	}
	
}