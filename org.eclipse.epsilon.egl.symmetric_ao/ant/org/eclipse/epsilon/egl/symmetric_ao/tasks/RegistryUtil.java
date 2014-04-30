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

import org.apache.tools.ant.Project;
import org.eclipse.epsilon.egl.symmetric_ao.egl.GenerationSliceRegistry;

/**
 * Utility class to relate projects and GenerationSliceRegistries
 * 
 * @author zschaler
 */
public abstract class RegistryUtil {
	/**
	 * Key used to store the global reference to the registry.
	 */
	public static final String KEY_AOCG_REFERENCE = "org.eclipse.epsilon.egl.symmetric_ao.GenerationSliceRegister";

	/**
	 * Get (and possibly create) the registry for the given ANT project.
	 * 
	 * @param p
	 * @return
	 */
	public static GenerationSliceRegistry getRegistryFor(Project p) {
		GenerationSliceRegistry gsrTentative = (GenerationSliceRegistry) p
				.getReference(KEY_AOCG_REFERENCE);
		if (gsrTentative == null) {
			gsrTentative = new GenerationSliceRegistry();
			p.addReference(KEY_AOCG_REFERENCE, gsrTentative);
		}
		return gsrTentative;
	}

	private RegistryUtil() {
	}
}