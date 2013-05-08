package org.eclipse.epsilon.mgl.dt;

import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.dt.launching.EolLaunchConfigurationDelegate;
import org.eclipse.epsilon.mgl.engine.MglModule;

public class MglLaunchConfigurationDelegate extends EolLaunchConfigurationDelegate {
	
	@Override
	public IEolExecutableModule createModule() {
		return new MglModule();
	}
	
}
