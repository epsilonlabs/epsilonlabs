/*******************************************************************************
 * Copyright (c) 2014 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.web.test.acceptance;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.emc.web.WebModel;
import org.eclipse.epsilon.test.util.ModelWithEolAssertions;
import org.junit.AfterClass;
import org.junit.Before;

public class WebModelAcceptanceTest {

	protected static ModelWithEolAssertions model;
	
	@Before
	public void setup() throws Exception {
		if (model == null) {
			final String className = getClass().getSimpleName();
			
			// Convert FooBarBaz to foo_bar_baz
			final String nsUri = className.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
			
			registerMetamodel(nsUri + ".ecore");
			
			// Users will normally annotate their package with web.base
			// But for these tests we inject the annotation at runtime
			// so that we don't hardcode the path to our test HTML files.
			// Injecting the annotation makes these tests portable.
			injectWebBaseAnnotation(nsUri);
			
			WebModel webModel = new WebModel(className, nsUri);
			webModel.load();
			
			model = new ModelWithEolAssertions(webModel);
		}
	}
	
	@AfterClass
	public static void reset() {
		model = null;
	}


	private void registerMetamodel(final String metamodelFilename) throws Exception {
		EmfUtil.register(URI.createFileURI(FileUtil.getPath(metamodelFilename, getClass())), EPackage.Registry.INSTANCE);
	}
	
	private boolean injectWebBaseAnnotation(final String nsUri) {
		EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
		annotation.setSource("web");
		annotation.getDetails().put("base", "file://" + FileUtil.getDirectoryOf(Basic.class).getAbsolutePath() + System.getProperty("file.separator"));
		EAnnotation createWebBaseAnnotation = annotation;
		return EPackage.Registry.INSTANCE.getEPackage(nsUri).getEAnnotations().add(createWebBaseAnnotation);
	}
}
