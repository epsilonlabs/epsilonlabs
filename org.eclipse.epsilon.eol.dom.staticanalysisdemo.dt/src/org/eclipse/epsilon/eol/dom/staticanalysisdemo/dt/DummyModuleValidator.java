package org.eclipse.epsilon.eol.dom.staticanalysisdemo.dt;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.IModuleValidator;
import org.eclipse.epsilon.common.module.ModuleMarker;
import org.eclipse.epsilon.common.module.ModuleMarker.Severity;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.parse.EolParser;

public class DummyModuleValidator implements IModuleValidator {

	public DummyModuleValidator() {
	}

	@Override
	public List<ModuleMarker> validate(IModule module) {
		ArrayList<ModuleMarker> markers = new ArrayList<ModuleMarker>();
		
		// Creates dummy warning markers for all "for" statements
		// and error markers for all "if" statements
		for (AST ast : module.getAst().getDescendants()) {
			if (ast.getType() == EolParser.FOR) {
				// file can be null - doesn't matter yet
				markers.add(new ModuleMarker(null, ast.getRegion(), "For loops are discouraged", Severity.Warning));
			}
			else if (ast.getType() == EolParser.IF) {
				markers.add(new ModuleMarker(null, ast.getRegion(), "If statements are out of question", Severity.Error));				
			}
		}
		return markers;
	}

}
