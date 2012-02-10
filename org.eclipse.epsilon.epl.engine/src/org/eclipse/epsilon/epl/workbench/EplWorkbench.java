package org.eclipse.epsilon.epl.workbench;

import java.io.File;

import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.emc.plainxml.PlainXmlModel;
import org.eclipse.epsilon.epl.EplModule;
import org.eclipse.epsilon.epl.PatternMatcher;

public class EplWorkbench {
	
	public static void main(String[] args) throws Exception {
		
		EplModule module = new EplModule();
		module.parse(new File("/Users/dimitrioskolovos/Projects/Eclipse/3.7.1/workspace-new/org.eclipse.epsilon.epl.engine/src/org/eclipse/epsilon/epl/workbench/library.epl"));
		
		if (module.getParseProblems().size() > 0) {
			for (ParseProblem p : module.getParseProblems()) {
				System.err.println(p);
			}
			System.exit(0);
		}
		
		PlainXmlModel model = new PlainXmlModel();
		model.setName("L");
		model.setFile(new File("/Users/dimitrioskolovos/Projects/Eclipse/3.7.1/workspace-new/org.eclipse.epsilon.epl.engine/src/org/eclipse/epsilon/epl/workbench/library.xml"));
		model.load();
		
		module.getContext().getModelRepository().addModel(model);
		module.getContext().setModule(module);
		new PatternMatcher().match(module);
		
	}
	
}
