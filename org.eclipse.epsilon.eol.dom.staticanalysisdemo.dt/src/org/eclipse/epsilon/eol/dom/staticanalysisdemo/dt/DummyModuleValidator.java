package org.eclipse.epsilon.eol.dom.staticanalysisdemo.dt;

import java.util.Arrays;
import java.util.List;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.IModuleValidator;
import org.eclipse.epsilon.common.module.ModuleMarker;
import org.eclipse.epsilon.common.module.ModuleMarker.Severity;

public class DummyModuleValidator implements IModuleValidator {

	public DummyModuleValidator() {
	}

	@Override
	public List<ModuleMarker> validate(IModule module) {
		return Arrays.asList(new ModuleMarker(null, module.getAst().getFirstChild().getRegion(), "Dummy warning message", Severity.Warning));
	}

}
