/*
 * 
 */
package ewe.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

import ewe.diagram.part.EweVisualIDRegistry;

/**
 * @generated
 */
public class EweNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 7003;

	/**
	 * @generated
	 */
	private static final int SHORTCUTS_CATEGORY = 7002;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof EweNavigatorItem) {
			EweNavigatorItem item = (EweNavigatorItem) element;
			if (item.getView().getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				return SHORTCUTS_CATEGORY;
			}
			return EweVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
