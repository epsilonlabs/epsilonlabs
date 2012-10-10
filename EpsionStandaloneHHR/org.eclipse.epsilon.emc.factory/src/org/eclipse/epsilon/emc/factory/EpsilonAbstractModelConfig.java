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
package org.eclipse.epsilon.emc.factory;

import java.util.HashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class EpsilonModelConfig.
 */
public abstract class EpsilonAbstractModelConfig implements EpsilonModelConfig {
	
	/**
	 * This parameter defines the preferred driver to load the model. Available
	 * options are: bibtex, csv, emf, hutn and plainxml.
	 */
	public static final String DRIVER = "driver";
	
	/**
	 * This parameter defines the model name used as identifier in the ExL
	 * source.
	 */
	public static final String NAME = "name";
	
	/** The model uri. */
	public static final String MODEL_URI = "modelUri";
	
	/** The read on load parameter. When paired with "true", the model will
	 * read when loaded.
	 */
	public static final String READ_ON_LOAD = "readOnLoad";
	
	/** The store on disposal parameter. When paired with "true", the model
	 * will be stored when disposed.
	 */
	public static final String STORE_ON_DISPOSAL = "storeOnDisposal";
	
	/** This parameter defines aliases for the model used as identifiers in
	 * the ExL source. It is a comma separated string of names.
	 */
	public static final String ALIASES = "aliases";
	
	/** The cached parameter. When paired with "true", the model will be
	 * cached for faster loading.
	 */
	public static final String CACHED = "cached";
	
	// TODO Move this to the respective driver configuration
	//== bibtex Specifics ==//
	/** The Constant SOURCE_FILE. */
	public static final String SOURCE_FILE = "";
	
	//== XML & CSV Specifics ==//
	/** This parameter defines a base path for the model file. It is used
	 * by the csv and plainxml drivers to locate the model file.
	 */
	public static final String BASE_PATH = "";
	
	/** This parameter defines a path for the model file. It is used
	 * by the csv and plainxml drivers to locate the model file.
	 */
	public static final String FILE = "driver";
	
	//== XML Specifics ==//
	/** This parameter defines a URI for the model file. It is used
	 * by the plainxml drivers to locate the model file if no FILE parameter
	 * is set.
	 */
	public static final String URI = "driver";
	
	
	/** The parameters. */
	protected Map<String, String> parameters;
	
	
	/**
	 * Instantiates a new epsilon model config.
	 */
	public EpsilonAbstractModelConfig() {
		parameters = new HashMap<String, String>();
	}

	
	public String getParameter(String name) {
		
		return parameters.get(name);
	}
	
	
	public void setParameter(String parameter, String value) {
		
		parameters.put(parameter, value);
	}
	
	public String getDriverName() {
		
		return parameters.get(DRIVER);
	}

	
	/**
	 * Sets the model name.
	 *
	 * @param name the new model name
	 */
	public void setModelName(String name) {
		
		parameters.put(NAME, name);
	}
	

	public String getModelName() {
		
		return parameters.get(NAME);
	}
	
	
	/**
	 * Sets the model uri.
	 *
	 * @param modelURI the new model uri
	 */
	public void setModelURI(String modelURI) {
		
		parameters.put(MODEL_URI, modelURI);
	}
	
	/**
	 * Gets the model uri.
	 *
	 * @return the model uri
	 */
	public String getModelURI() {
		
		return parameters.get(MODEL_URI);
	}


	/**
	 * Sets the read on load.
	 *
	 * @param value the new read on load
	 */
	public void setReadOnLoad(boolean value) {
		
		parameters.put(READ_ON_LOAD, String.valueOf(value));
	}
	
	/**
	 * Gets the read on load.
	 *
	 * @return the read on load
	 */
	public boolean getReadOnLoad() {
		
		return Boolean.getBoolean(parameters.get(READ_ON_LOAD));
	}


	/**
	 * Sets the store on disposal.
	 *
	 * @param value the new store on disposal
	 */
	public void setStoreOnDisposal(boolean value) {
		
		parameters.put(STORE_ON_DISPOSAL, String.valueOf(value));
	}
	
	/**
	 * Gets the store on disposal.
	 *
	 * @return the store on disposal
	 */
	public boolean getStoreOnDisposal() {
		
		return Boolean.getBoolean(parameters.get(STORE_ON_DISPOSAL));
	}


	/**
	 * Sets the cached.
	 *
	 * @param value the new cached
	 */
	public void setCached(boolean value) {
		
		parameters.put(CACHED, String.valueOf(value));
	}
	
	/**
	 * Gets the cached.
	 *
	 * @return the cached
	 */
	public boolean getCached() {
		
		return Boolean.getBoolean(parameters.get(CACHED));
	}


	

}
