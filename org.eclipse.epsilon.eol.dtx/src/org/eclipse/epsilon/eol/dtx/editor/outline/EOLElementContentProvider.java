package org.eclipse.epsilon.eol.dtx.editor.outline;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class EOLElementContentProvider implements ITreeContentProvider {

	private EOLOutlineElement eolOutlineElement;
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		eolOutlineElement = (EOLOutlineElement) newInput;
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		List<EObject> contents = ((EOLOutlineElement) parentElement).getEolElement().eContents();
		List<EOLOutlineElement> children = new ArrayList<EOLOutlineElement>();
		for (EObject content : contents) {
			if (content instanceof EOLElement) {
				children.add(new EOLOutlineElement((EOLElement) content));
			}
		}
		return children.toArray();
	}

	@Override
	public Object getParent(Object element) {
		return eolOutlineElement.getEolElement();
	}

	@Override
	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}
	
}
