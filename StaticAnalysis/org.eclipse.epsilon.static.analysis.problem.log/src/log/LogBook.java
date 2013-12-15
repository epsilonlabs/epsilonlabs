package log;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.dom.DomElement;


public class LogBook {

	protected ArrayList<Error> errors;
	protected ArrayList<Warning> warnings;
	
	public LogBook()
	{
		errors = new ArrayList<Error>();
		warnings = new ArrayList<Warning>();
	}
		
	public ArrayList<Error> getErrors()
	{
		return errors;
	}
	
	public ArrayList<Warning> getWarnings()
	{
		return warnings;
	}
		
	public void addError(DomElement dom, String s)
	{
		errors.add(new Error(dom, s));
	}
	
	public void addWarning(DomElement dom, String s)
	{
		warnings.add(new Warning(dom, s));
	}
	
	public ArrayList<Problem> getProblems()
	{
		ArrayList<Problem> problems = new ArrayList<Problem>();
		problems.addAll(this.errors);
		problems.addAll(this.warnings);
		return problems;
	}
}
