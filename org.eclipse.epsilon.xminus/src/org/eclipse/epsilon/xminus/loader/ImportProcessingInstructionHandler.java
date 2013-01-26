package org.eclipse.epsilon.xminus.loader;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
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
		String source = node.getTextContent().trim();
		URI uri = URI.createURI(source).resolve(context.getResource().getURI());
		Resource importedResource = context.getResource().getResourceSet().createResource(uri);
		context.getResource().getImportedResources().add(importedResource);
	}

}
