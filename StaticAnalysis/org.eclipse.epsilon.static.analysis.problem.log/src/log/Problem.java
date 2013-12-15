package log;

import org.eclipse.epsilon.eol.dom.DomElement;

public abstract class Problem {

	protected String message;
	protected DomElement domElement;
	
	public String getMessage()
	{
		return message;
	}
	
	public void SetMessage(String message)
	{
		this.message = message;
	}
	
	public DomElement getDomElement()
	{
		return domElement;
	}
}
