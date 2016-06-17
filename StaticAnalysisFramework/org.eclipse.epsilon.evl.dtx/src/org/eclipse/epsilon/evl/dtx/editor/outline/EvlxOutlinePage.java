package org.eclipse.epsilon.evl.dtx.editor.outline;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.common.dt.editor.AbstractModuleEditor;
import org.eclipse.epsilon.common.dt.editor.outline.ModuleContentOutlinePage;
import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.eol.EolLibraryModule;
import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.TextRegion;
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.evl.ast2evl.Ast2EvlContext;
import org.eclipse.epsilon.evl.ast2evl.EvlElementCreatorFactory;
import org.eclipse.epsilon.evl.dtx.editor.EvlxEditor;
import org.eclipse.epsilon.evl.visitor.resolution.impl.EvlVariableResolver;
import org.eclipse.epsilon.evl.visitor.resolution.type.context.EvlTypeResolutionContext;
import org.eclipse.epsilon.evl.visitor.resolution.type.impl.EvlTypeResolver;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;

public class EvlxOutlinePage extends ModuleContentOutlinePage{
	
	protected EvlxEditor evlxEditor;

	public EvlxOutlinePage(IDocumentProvider documentProvider,
			AbstractModuleEditor editor, ILabelProvider labelProvider) {
		super(documentProvider, editor, labelProvider);
		evlxEditor = (EvlxEditor) editor;
	}
	
	@Override
	public Object getOutlineRoot(IModule module) {
		
		Ast2EvlContext ast2EtlContext = new Ast2EvlContext((EolLibraryModule) module);
		EvlElementCreatorFactory factory = ast2EtlContext.getEvlElementCreatorFactory();
		EOLElement eolElement = factory.createEOLElement(module.getAst(), null, ast2EtlContext);
		LogBook.getInstance(true);
		
		EvlVariableResolver variableResolver = new EvlVariableResolver();
		variableResolver.getContext().setEolModule((EolLibraryModule) module);
//		VariableResolutionContext.getInstance().setEolModule((EolModule) arg0);
		variableResolver.run(eolElement);
		
		EvlTypeResolver typeResolver = new EvlTypeResolver((EolLibraryModule) module);
		EvlTypeResolutionContext.getInstance().setEolModule( (EolLibraryModule) module);
		typeResolver.run(eolElement);
		//evlxEditor.setEolLibraryModule(eolElement);
		
		return new DomOutlineElement(eolElement);
	}
	
	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		
		if (!linkWithEditorAction.isChecked()) return;
		
		try {
			
			EOLElement selected = ((DomOutlineElement) ((IStructuredSelection) event
					.getSelection()).getFirstElement()).getDomElement();
		
			
			IDocument doc = editor.getDocumentProvider().getDocument(editor.getEditorInput());
			TextRegion region = selected.getRegion();
			
			int startOffset = doc.getLineOffset(region.getStart().getLine()-1) + region.getStart().getColumn();
			int endOffset = doc.getLineOffset(region.getEnd().getLine()-1) + region.getEnd().getColumn();
			
			FileEditorInput fileInputEditor = (FileEditorInput) editor.getEditorInput();
			IFile file = fileInputEditor.getFile();
			
			
//			EclipseUtil.openEditorAt(new File(file.getLocation().toOSString()), region.getStart().getLine(), 
//					region.getStart().getColumn(), false);

			EclipseUtil.openEditorAt(file, region.getStart().getLine(), 
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
					if (content instanceof EOLElement) {
						children.add(new DomOutlineElement((EOLElement) content));
					}
				}
				return children.toArray();
			}
		};
	}


}
