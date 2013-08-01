package org.eclipse.epsilon.epsilonoid;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplateFactoryModuleAdapter;
import org.eclipse.epsilon.emc.plainxml.PlainXmlModel;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.EvlUnsatisfiedConstraint;

import android.app.Activity;
import android.widget.Toast;

public class Example {
	
	protected String code = "";
	protected String model = "";
	protected String title = "";
	protected String language = "";
	protected String output = "";
	protected String modelLoadingError = null;
	protected String codeParseError = null;
	protected String runtimeError = null;
	protected Activity context;
	
	public String getCode() {
		return code;
	}
	
	public void setContext(Activity context) {
		this.context = context;
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
			IEolExecutableModule module = createModule();
			final StringBuffer outputBuffer = new StringBuffer();
			module.parse(code);
			
			if (module.getParseProblems().size() == 0) {
				
				if (model.length() > 0) {
					PlainXmlModel model = new PlainXmlModel();
					model.setName("Source");
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
				
				module.getContext().getFrameStack().put(Variable.createReadOnlyVariable("ctx", context));
				
				module.getContext().setOutputStream(new PrintStream(new OutputStream() {
					
					@Override
					public void write(int c) throws IOException {
						outputBuffer.append((char) c);
					}
					
				}));
				
				customiseModule(module);
				Object result = module.execute();
				collectAdditionalOutput(module, result, outputBuffer);
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
	
	protected IEolExecutableModule createModule() {
		if ("EVL".equalsIgnoreCase(language)) {
			return new EvlModule();
		}
		else if ("EGL".equalsIgnoreCase(language)) {
			return new EglTemplateFactoryModuleAdapter(new EglFileGeneratingTemplateFactory());
		}
		else if ("ETL".equalsIgnoreCase(language)) {
			return new EtlModule();
		}
		return new EolModule();
	}
	
	protected void customiseModule(IEolExecutableModule module) {
		if (module instanceof EtlModule) {
			PlainXmlModel targetModel = new PlainXmlModel();
			targetModel.setReadOnLoad(false);
			targetModel.setName("Target");
			try { targetModel.load(); } catch (Exception ex) {}
			module.getContext().getModelRepository().addModel(targetModel);
		}
	}
	
	protected String collectAdditionalOutput(IEolExecutableModule module, Object result, StringBuffer outputBuffer) {
		if (module instanceof EvlModule) {
			for (EvlUnsatisfiedConstraint constraint : ((EvlModule)module).getContext().getUnsatisfiedConstraints()) {
				outputBuffer.append(constraint.getMessage() + "\n");
			}
		} else if (module instanceof EglTemplateFactoryModuleAdapter) {
			outputBuffer.append(result);
		}
		else if (module instanceof EtlModule) {
			try {
				PlainXmlModel targetModel = (PlainXmlModel) module.getContext().getModelRepository().getModelByName("Target");
				outputBuffer.append(targetModel.getXml());
			}
			catch (Exception ex) {}
		}
		return outputBuffer.toString();
	}
	
}
