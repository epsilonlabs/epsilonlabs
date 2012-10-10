/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     hhoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.emf.factory;


import org.eclipse.epsilon.emc.factory.EpsilonAbstractModelConfig;
import org.eclipse.epsilon.emc.factory.EpsilonModelConfig;

// TODO: Auto-generated Javadoc
/**
 * The Class EpsilonEmfModelConfig.
 */
public class EpsilonEmfModelConfig extends EpsilonAbstractModelConfig implements
		EpsilonModelConfig {
	
	/**
	 * When paired with "true", external references will be resolved during
	 * loading. Otherwise, external references are not resolved. Paired with
	 * "true" by default.
	 */
	public static final String EXPAND = "driver";
	
	/**
	 * The uri meta-models. This key is a comma-separated list of zero or more
	 * namespaces URI of some of the meta-models to which this model conforms.
	 * Users may combine this key with {@link #FILE_METAMODELS} to load
	 * both file-based and URI-based meta-models at the same time.
	 */
	public static final String URI_METAMODELS = "driver";
	
	/** The file meta-models. This key is a comma-separated list of zero or
	 * more URIs that can be used to locate some of the meta-models
	 * to which this model conforms. Users may combine this key with
	 * {@link #URI_METAMODELS} to load both file-based and URI-based
	 * meta-models at the same time.
	 */
	public static final String FILE_METAMODELS = "driver";
	
	/**
	 * Instantiates a new epsilon emf model configuration by setting the DRIVER
	 * parameter to "emf".
	 */
	public EpsilonEmfModelConfig() {
		super();
		parameters.put(DRIVER, "emf");
	}


	/**
	 * Sets the metamodel uris.
	 *
	 * @param metamodelUris the new metamodel uris
	 */
	public void setMetamodelUris(String metamodelUris) {
		
		// TODO Should we split the string and add to set to 
		// avoid duplicate URIs?
		parameters.put(URI_METAMODELS, metamodelUris);
	}
	
	//TODO add a removeMetamodelURI
	
	/**
	 * Gets the metamodel uris.
	 *
	 * @return the metamodel uris
	 */
	public String getMetamodelUris() {
		
		return parameters.get(URI_METAMODELS);
	}


	/**
	 * Sets the metamodel paths.
	 *
	 * @param metamodelPaths the new metamodel paths
	 */
	public void setMetamodelPaths(String metamodelPaths) {
		
		parameters.put(URI_METAMODELS, metamodelPaths);
	}
	
	/**
	 * Gets the metamodel paths.
	 *
	 * @return the metamodel paths
	 */
	public String getMetamodelPaths() {
		
		return parameters.get(FILE_METAMODELS);
	}


	/**
	 * Sets the expand.
	 *
	 * @param value the new expand
	 */
	public void setExpand(boolean value) {
		
		parameters.put(EXPAND, String.valueOf(value));
	}
	
	/**
	 * Gets the expand.
	 *
	 * @return the expand
	 */
	public boolean getExpand() {
		
		return Boolean.getBoolean(parameters.get(EXPAND));
	}


}
