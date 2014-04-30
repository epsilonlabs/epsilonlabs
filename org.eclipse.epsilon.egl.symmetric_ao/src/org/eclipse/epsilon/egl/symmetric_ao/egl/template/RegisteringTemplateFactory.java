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

import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplate;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.spec.EglTemplateSpecification;
import org.eclipse.epsilon.egl.symmetric_ao.egl.GenerationSliceRegistry;

/**
 * A template factory for files that registers files rather than storing them to
 * the file system.
 * 
 * @author zschaler
 */
public class RegisteringTemplateFactory extends
		EglFileGeneratingTemplateFactory {

	/**
	 * The registry to be used.
	 */
	private GenerationSliceRegistry registry;

	/**
	 * The feature to use when registering. Could be <code>null</code>.
	 */
	private String sFeature;

	public RegisteringTemplateFactory(IEglContext context,
			GenerationSliceRegistry registry, String sFeature) {
		super(context);

		this.registry = registry;
		this.sFeature = sFeature;
	}

	public RegisteringTemplateFactory(GenerationSliceRegistry registry,
			String sFeature) {
		super();
		this.registry = registry;
		this.sFeature = sFeature;
	}

	@Override
	protected EglTemplate createTemplate(EglTemplateSpecification spec)
			throws Exception {
		return new EglRegisteringTemplate(spec, context, getOutputRootOrRoot(),
				outputRootPath, registry, sFeature);
	}
}