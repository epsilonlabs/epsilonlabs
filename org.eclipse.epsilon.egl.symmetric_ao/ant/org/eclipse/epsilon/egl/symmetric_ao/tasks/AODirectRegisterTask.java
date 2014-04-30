/*******************************************************************************
 * Copyright (c) 2010 Lancaster University.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Steffen Zschaler -- Initial Implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.egl.symmetric_ao.tasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

/**
 * Task implementation enabling an existing file to be registered in the
 * generation registry.
 */
public class AODirectRegisterTask extends Task {

	/**
	 * The file from which to take the contents to be registered.
	 */
	private File fSource;

	/**
	 * The file name under which to register this contents.
	 */
	private String sTargetName;

	/**
	 * The feature to use when registering.
	 */
	private String sFeature;

	/**
	 * @return the fSource
	 */
	public File getSource() {
		return fSource;
	}

	/**
	 * @param source
	 *            the fSource to set
	 */
	public void setSource(File source) {
		fSource = source;
	}

	/**
	 * @return the sTargetName
	 */
	public String getTargetName() {
		return sTargetName;
	}

	/**
	 * @param targetName
	 *            the sTargetName to set
	 */
	public void setTargetName(String targetName) {
		sTargetName = targetName;
	}

	/**
	 * @return the sFeature
	 */
	public String getFeature() {
		return sFeature;
	}

	/**
	 * @param feature
	 *            the sFeature to set
	 */
	public void setFeature(String feature) {
		sFeature = feature;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.tools.ant.Task#execute()
	 */
	@Override
	public void execute() throws BuildException {
		try {
			BufferedReader r = new BufferedReader(new FileReader(getSource()));
			String sLine;
			StringBuffer sbContents = new StringBuffer();
			while ((sLine = r.readLine()) != null) {
				sbContents.append(sLine).append('\n');
			}
			r.close();

			RegistryUtil.getRegistryFor(this.getProject()).register(
					new File(getTargetName()), getFeature(),
					sbContents.toString());
			handleOutput("Registered some content for "
					+ ((getFeature() != null) ? "feature '" + getFeature()
							+ "' of " : "") + getTargetName());

		} catch (IOException ioe) {
			handleErrorFlush(ioe.getLocalizedMessage());
		}
	}

}
