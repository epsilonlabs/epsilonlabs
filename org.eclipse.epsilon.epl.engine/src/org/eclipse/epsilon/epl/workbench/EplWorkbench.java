package org.eclipse.epsilon.epl.workbench;

import java.io.File;

import org.eclipse.epsilon.emc.plainxml.PlainXmlModel;
import org.eclipse.epsilon.epl.EplModule;
import org.eclipse.epsilon.epl.Pattern;
import org.eclipse.epsilon.epl.PatternMatcher;
import org.eclipse.epsilon.epl.PatternSet;

public class EplWorkbench {
	
	public static void main(String[] args) throws Exception {
		
		EplModule module = new EplModule();
		module.parse(new File("/Users/dimitrioskolovos/Projects/Eclipse/3.7.1/workspace-new/org.eclipse.epsilon.epl.engine/src/org/eclipse/epsilon/epl/workbench/library.epl"));
		
		PlainXmlModel model = new PlainXmlModel();
		model.setName("L");
		model.setFile(new File("/Users/dimitrioskolovos/Projects/Eclipse/3.7.1/workspace-new/org.eclipse.epsilon.epl.engine/src/org/eclipse/epsilon/epl/workbench/library.xml"));
		model.load();
		
		module.getContext().getModelRepository().addModel(model);
		
		for (PatternSet patternSet : module.getPatternSets()) {
			for (Pattern pattern : patternSet.getPatterns()) {
				
				PatternMatcher patternMatcher = new PatternMatcher();
				patternMatcher.match(pattern, module.getContext());
				
			}
		}
		
	}
	
}
