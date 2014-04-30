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

import java.util.List;

/**
 * Interface encapsulating strategies for merging a number of file contents into
 * a single contents.
 * 
 * @author zschaler
 */
public interface MergeStrategy {
	/**
	 * Merge the given strings into a single one and return the merged string.
	 * 
	 * @param toMerge
	 *            list of strings to be merged
	 * @param fForRegister
	 *            if <code>true</code>, the merge result will be registered as a
	 *            code slice again rather than written to a file.
	 * 
	 * @return the merged string
	 */
	public String merge(List<String> toMerge, boolean fForRegister);
}