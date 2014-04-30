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
package org.eclipse.epsilon.egl.symmetric_ao.egl;

import java.io.File;

/**
 * Exception thrown when attempting to merge a file for which no contents has
 * been registered.
 * 
 * @author zschaler
 */
@SuppressWarnings("serial")
public class FileNotRegisteredException extends Exception {

	private File file;

	public FileNotRegisteredException(File file) {
		super("No content registered for file " + file);
		this.file = file;
	}

	public File getFile() {
		return file;
	}
}