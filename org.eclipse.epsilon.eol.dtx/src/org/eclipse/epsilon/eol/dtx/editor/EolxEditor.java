package org.eclipse.epsilon.eol.dtx.editor;

import org.eclipse.epsilon.common.dt.editor.outline.ModuleContentOutlinePage;
import org.eclipse.epsilon.common.dt.editor.outline.ModuleElementLabelProvider;
import org.eclipse.epsilon.eol.dt.editor.EolEditor;
import org.eclipse.epsilon.eol.dtx.EolXPlugin;
import org.eclipse.epsilon.eol.dtx.editor.outline.EolXOutlinePage;
import org.eclipse.swt.graphics.Image;

public class EolxEditor extends EolEditor {

	@Override
	public ModuleContentOutlinePage createOutlinePage() {
		EolXOutlinePage outlinePage = new EolXOutlinePage(this.getDocumentProvider(), this, createModuleElementLabelProvider());
		
		addModuleParsedListener(outlinePage);
		
		return outlinePage;
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
