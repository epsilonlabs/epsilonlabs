package log;

import org.eclipse.epsilon.eol.metamodel.*;

public class Error extends Problem{

	public Error(EolElement dom, String msg)
	{
		this.eolElement = dom;
		this.message = msg;
	}
}
