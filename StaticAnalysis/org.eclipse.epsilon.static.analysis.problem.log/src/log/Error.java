package log;

import org.eclipse.epsilon.eol.dom.DomElement;

public class Error extends Problem{

	public Error(DomElement dom, String msg)
	{
		this.domElement = dom;
		this.message = msg;
	}
}
