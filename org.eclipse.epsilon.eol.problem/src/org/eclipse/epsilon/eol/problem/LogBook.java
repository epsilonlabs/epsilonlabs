package org.eclipse.epsilon.eol.problem;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.metamodel.EOLElement;

public class LogBook {

	private static LogBook instance = null;
	
	protected ArrayList<EOLWarning> warnings;
	protected ArrayList<EOLError> errors;
	
	public LogBook()
	{
		warnings = new ArrayList<EOLWarning>();
		errors = new ArrayList<EOLError>();
	}
	
	public static LogBook getInstance()
	{
		if (instance == null) {
			instance = new LogBook();
		}
		return instance;
	}

	public ArrayList<EOLWarning> getWarnings() {
		return warnings;
	}
	
	public ArrayList<EOLError> getErrors() {
		return errors;
	}
	
	public void addWarning(EOLElement eolElement, String message)
	{
		warnings.add(new EOLWarning(eolElement, message));
	}
	
	public void addError(EOLElement eolElement, String message)
	{
		errors.add(new EOLError(eolElement, message));
	}
	
	public ArrayList<EOLProblem> getProblems()
	{
		ArrayList<EOLProblem> result = new ArrayList<EOLProblem>();
		result.addAll(warnings);
		result.addAll(errors);
		return result;
	}
	
}
