package org.eclipse.epsilon.eol.dtx.editor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.common.dt.editor.outline.ModuleContentOutlinePage;
import org.eclipse.epsilon.common.dt.editor.outline.ModuleElementLabelProvider;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dt.EolPlugin;
import org.eclipse.epsilon.eol.dt.editor.EolEditor;
import org.eclipse.epsilon.eol.dtx.EolxPlugin;
import org.eclipse.epsilon.eol.dtx.editor.outline.EolxOutlinePage;
import org.eclipse.swt.graphics.Image;

public class EolxEditor extends EolEditor {
	
	@Override
	public ModuleContentOutlinePage createOutlinePage() {
		EolxOutlinePage outline = new EolxOutlinePage(
				this.getDocumentProvider(), 
				this, 
				createModuleElementLabelProvider());
		
		addModuleParsedListener(outline);
		return outline;
	}
	
	@Override
	public ModuleElementLabelProvider createModuleElementLabelProvider() {
		return new ModuleElementLabelProvider() {
			
			@Override
			public String getText(Object element) {
				DomElement domElement = (DomElement) element;
				return ((EObject) element).eClass().getName() + " (" + domElement.getLine() + "," + domElement.getColumn() + ")";
			}
			
			@Override
			public Image getImage(Object element) {
				return EolxPlugin.getDefault().createImage("icons/element.gif");
			}
		};
	}
	
}
