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
package org.eclipse.epsilon.egl.symmetric_ao.egl.template;

import java.io.File;
import java.net.URI;

import org.eclipse.epsilon.egl.EglPersistentTemplate;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.spec.EglTemplateSpecification;
import org.eclipse.epsilon.egl.symmetric_ao.egl.GenerationSliceRegistry;

/**
 * A file generating template that registers file contents instead of storing it
 * to the file system.
 * 
 * @author zschaler
 */
public class EglRegisteringTemplate extends EglPersistentTemplate {

	/**
	 * The registry to use.
	 */
	private GenerationSliceRegistry registry;

	/**
	 * The feature to use when registering. May be <code>null</code>.
	 */
	private String sFeature;

	public EglRegisteringTemplate(EglTemplateSpecification spec,
			IEglContext context, URI outputRoot, String outputRootPath,
			GenerationSliceRegistry registry, String sFeature) throws Exception {
		super(spec, context, outputRoot, outputRootPath);

		this.registry = registry;
		this.sFeature = sFeature;
	}

	@Override
	protected void doGenerate(File file, String targetName, boolean overwrite,
			boolean protectRegions) throws EglRuntimeException {
		// TODO: Fixup registry to store flags as well.
		registry.register(file, sFeature, getContents());
		addMessage("Successfully registered contents for " + targetName);

	}
}