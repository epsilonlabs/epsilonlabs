package log;

import org.eclipse.epsilon.eol.dom.DomElement;


public class Warning extends Problem{
	
	public Warning(DomElement dom, String msg)
	{
		this.domElement = dom;
		this.message = msg;
	}
}
