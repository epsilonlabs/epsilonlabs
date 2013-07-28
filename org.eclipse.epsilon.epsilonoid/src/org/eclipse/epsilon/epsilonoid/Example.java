package org.eclipse.epsilon.epsilonoid;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.emc.plainxml.PlainXmlModel;
import org.eclipse.epsilon.eol.EolModule;

public class Example {
	
	protected String code = "";
	protected String model = "";
	protected String title = "";
	protected String language = "";
	protected String output = "";
	protected String modelLoadingError = null;
	protected String codeParseError = null;
	protected String runtimeError = null;
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	@Override
	public String toString() {
		return getTitle();
	}
	
	public String getOutput() {
		return output;
	}
	
	public String getModelLoadingError() {
		return modelLoadingError;
	}
	
	public String getCodeParseError() {
		return codeParseError;
	}
	
	public String getRuntimeError() {
		return runtimeError;
	}
	
	public void execute() {
		try {
			EolModule module = new EolModule();
			final StringBuffer outputBuffer = new StringBuffer();
			module.parse(code);
			
			if (module.getParseProblems().size() == 0) {
				
				if (model.length() > 0) {
					PlainXmlModel model = new PlainXmlModel();
					model.setName("M");
					model.setXml(this.model);
					
					try {
						model.load();
					}
					catch (Exception ex) {
						modelLoadingError = ex.getMessage();
						return;
					}
					module.getContext().getModelRepository().addModel(model);
				}
				
				module.getContext().setOutputStream(new PrintStream(new OutputStream() {
					
					@Override
					public void write(int c) throws IOException {
						outputBuffer.append((char) c);
					}
					
				}));
				
				module.execute();
				output = outputBuffer.toString();
			}
			else {
				codeParseError = "";
				for (ParseProblem problem : module.getParseProblems()) {
					codeParseError += problem.toString() + "\n";
				}
			}
			
		}
		catch (Exception ex) {
			runtimeError = ex.getMessage();
		}
	}
	
}
