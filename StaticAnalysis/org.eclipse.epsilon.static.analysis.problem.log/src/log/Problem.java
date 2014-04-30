package log;

import org.eclipse.epsilon.eol.metamodel.*;

public abstract class Problem {

	protected String message;
	protected EolElement eolElement;
	
	public String getMessage()
	{
		return message;
	}
	
	public void SetMessage(String message)
	{
		this.message = message;
	}
	
	public EolElement getDomElement()
	{
		return eolElement;
	}
}
