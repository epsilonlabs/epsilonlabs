package org.eclipse.epsilon.live;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.eol.execute.prettyprinting.PrettyPrinter;

public class SecretiveEmfPrettyPrinter implements PrettyPrinter {

	@Override
	public boolean appliesTo(Object o) {
		return o instanceof EObject;
	}

	@Override
	public String print(Object o) {
		return ((EObject) o).eClass().getName();
	}

}
