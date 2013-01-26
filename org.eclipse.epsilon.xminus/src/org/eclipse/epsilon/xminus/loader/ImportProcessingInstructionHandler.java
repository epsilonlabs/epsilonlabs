package org.eclipse.epsilon.xminus.loader;

import org.eclipse.emf.ecore.EObject;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.ProcessingInstruction;

public class ImportProcessingInstructionHandler extends ContextualNodeHandler {

	@Override
	public boolean canHandle(Node node, EObject eObject) {
		return context.isProcessingInstruction(node) && 
			context.getName(node).equalsIgnoreCase("import");
	}

	@Override
	public void handle(Node node, EObject eObject) {
		
	}

}
