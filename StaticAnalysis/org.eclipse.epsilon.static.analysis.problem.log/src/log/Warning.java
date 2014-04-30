package log;

import org.eclipse.epsilon.eol.metamodel.*;


public class Warning extends Problem{
	
	public Warning(EolElement dom, String msg)
	{
		this.eolElement = dom;
		this.message = msg;
	}
}
