package org.eclipse.epsilon.etl.dtx.editor;

import org.eclipse.epsilon.common.dt.editor.outline.ModuleContentOutlinePage;
import org.eclipse.epsilon.common.dt.editor.outline.ModuleElementLabelProvider;
import org.eclipse.epsilon.eol.dtx.EolXPlugin;
import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.etl.dt.editor.EtlEditor;
import org.eclipse.epsilon.etl.dtx.editor.outline.EtlxOutlinePage;
import org.eclipse.swt.graphics.Image;

public class EtlxEditor extends EtlEditor {

	protected EOLElement eolLibraryModule = null;
	
	public void setEolLibraryModule(EOLElement eolLibraryModule) {
		this.eolLibraryModule = eolLibraryModule;
	}
	
	public EOLElement getEolLibraryModule() {
		return eolLibraryModule;
	}
	
	@Override
	public ModuleContentOutlinePage createOutlinePage() {

		EtlxOutlinePage outline = new EtlxOutlinePage(
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
				return element.toString();
			}
			
			@Override
			public Image getImage(Object element) {
				return EolXPlugin.getDefault().createImage("icons/element.gif");
			}
		};
	}
	

}
