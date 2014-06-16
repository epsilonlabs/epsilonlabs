package org.eclipse.epsilon.eol.visitor.printer.context;

public class PrinterContext {

	protected int indentation;
	
	public PrinterContext()
	{
		indentation = 0;
	}
	
	
	public int getIndentation() {
		return indentation;
	}
	
	public void indent()
	{
		indentation++;
	}
	
	public void outdent()
	{
		indentation--;
	}
	
	public String newline() {
		return System.getProperty("line.separator");
	}

	public String whitespace() {
		String str = "";
		for (int i = 0; i<indentation; i++) {
			str += "   ";
		}
		return str;
	}
	
}
