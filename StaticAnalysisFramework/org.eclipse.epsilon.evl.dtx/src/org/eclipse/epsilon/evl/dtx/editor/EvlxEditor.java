package org.eclipse.epsilon.evl.dtx.editor;

import org.eclipse.epsilon.common.dt.editor.outline.ModuleContentOutlinePage;
import org.eclipse.epsilon.common.dt.editor.outline.ModuleElementLabelProvider;
import org.eclipse.epsilon.eol.dtx.EolXPlugin;
import org.eclipse.epsilon.evl.dt.editor.EvlEditor;
import org.eclipse.epsilon.evl.dtx.editor.outline.EvlxOutlinePage;
import org.eclipse.swt.graphics.Image;


public class EvlxEditor extends EvlEditor{

	@Override
	public ModuleContentOutlinePage createOutlinePage() {

		EvlxOutlinePage outline = new EvlxOutlinePage(
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
