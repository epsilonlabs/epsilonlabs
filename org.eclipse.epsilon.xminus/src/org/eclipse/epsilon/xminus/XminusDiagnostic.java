package org.eclipse.epsilon.xminus;

import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.w3c.dom.Node;

public class XminusDiagnostic implements Diagnostic {
	
	protected String message;
	protected Node node;
	
	public XminusDiagnostic(String message, Node node) {
		super();
		this.message = message;
		this.node = node;
	}
	
	public Node getNode() {
		return node;
	}
	
	public void setNode(Node node) {
		this.node = node;
	}
	
	@Override
	public String toString() {
		return getMessage();
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public String getLocation() {
		return null;
	}

	@Override
	public int getLine() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumn() {
		// TODO Auto-generated method stub
		return 0;
	}
}
