package org.eclipse.epsilon.emc.htmlunit.workbench;

import java.io.File;

import org.eclipse.epsilon.emc.htmlunit.HtmlUnitModel;
import org.eclipse.epsilon.emc.htmlunit.NoJavascriptWebClientConfigurer;
import org.eclipse.epsilon.emc.htmlunit.util.Clock;
import org.eclipse.epsilon.eol.EolModule;

public class HtmlUnitWorkbench {
	
	public static void main(String[] args) throws Exception {
		new HtmlUnitWorkbench().run();
	}
	
	public void run() throws Exception {
		
		
		EolModule module = new EolModule();
		
		module.parse(new File("D:/Projects/Eclipse/3.5.1/workspace/org.eclipse.epsilon.emc.htmlunit/" + 
				"src/org/eclipse/epsilon/emc/htmlunit/workbench/HtmlUnitWorkbench.eol"));
		
		HtmlUnitModel model = new HtmlUnitModel("M", "http://www.cs.york.ac.uk");
		model.setWebClientConfigurer(new NoJavascriptWebClientConfigurer());
		model.load();
		
		module.getContext().getModelRepository().addModel(model);
		module.execute();
		
	}
	
	
	
}
