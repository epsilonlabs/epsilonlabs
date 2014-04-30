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

import org.eclipse.epsilon.egl.EglTemplateFactoryModuleAdapter;
import org.eclipse.epsilon.egl.symmetric_ao.egl.template.RegisteringTemplateFactory;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.workflow.tasks.EglTask;

/**
 * An extension of the standard EGL task registering the generated code for
 * later merging rather than writing directly to the file.
 * 
 * @author zschaler
 */
public class AORegisterTask extends EglTask {

	private String sFeature;

	public void setFeature(String sFeature) {
		this.sFeature = sFeature;
	}

	protected String getFeature() {
		return sFeature;
	}

	@Override
	protected IEolExecutableModule createModule() {
		return new EglTemplateFactoryModuleAdapter(
				new RegisteringTemplateFactory(RegistryUtil.getRegistryFor(this
						.getProject()), getFeature()));
	}

	/**
	 * Registers the given contents against the given file for later merging.
	 * 
	 * @param file
	 * @param contents
	 */
	/*
	 * private void register(File file, String contents) {
	 * RegistryUtil.getRegistryFor(this.getProject()).register(file,
	 * getFeature(), contents); handleOutput("Registered some content for " +
	 * ((getFeature()!=null)?"feature '" + getFeature() + "' of ":"") + file); }
	 */
}