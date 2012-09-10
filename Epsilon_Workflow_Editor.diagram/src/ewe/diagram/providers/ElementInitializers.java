/*
 * 
 */
package ewe.diagram.providers;

import ewe.diagram.part.EweDiagramEditorPlugin;

/**
 * @generated
 */
public class ElementInitializers {

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	 * @generated
	 */
	public static ElementInitializers getInstance() {
		ElementInitializers cached = EweDiagramEditorPlugin.getInstance()
				.getElementInitializers();
		if (cached == null) {
			EweDiagramEditorPlugin.getInstance().setElementInitializers(
					cached = new ElementInitializers());
		}
		return cached;
	}
}
