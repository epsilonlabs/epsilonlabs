/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.epl.dt.launching.tabs;

import org.eclipse.epsilon.common.dt.EpsilonPlugin;
import org.eclipse.epsilon.common.dt.launching.AbstractSourceConfigurationTab;
import org.eclipse.epsilon.epl.dt.EplPlugin;

public class EplSourceConfigurationTab extends AbstractSourceConfigurationTab{

	@Override
	public EpsilonPlugin getPlugin() {
		return EplPlugin.getDefault();
	}

	@Override
	public String getImagePath() {
		return "icons/epl.gif";
	}

	@Override
	public String getFileExtension() {
		return "epl";
	}

	@Override
	public String getSelectionTitle() {
		return "Select an EPL Program";
	}

	@Override
	public String getSelectionSubtitle() {
		return "EPL Programs in Workspace";
	}

	public String getLaunchConfigurationKey() {
		return "SOURCE.EPL";
	}
	

}
