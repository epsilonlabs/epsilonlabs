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
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

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
		return "Select an EPL Pattern Module";
	}

	@Override
	public String getSelectionSubtitle() {
		return "EPL Pattern Modules in Workspace";
	}

	public String getLaunchConfigurationKey() {
		return "SOURCE.EPL";
	}
	

}
