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
package org.eclipse.epsilon.common.factory;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;

// TODO: Auto-generated Javadoc
/**
 * Abstract implementation of the EpsilonModelConfig interface. Specific Epsilon
 * drivers should extend this class to provide specific driver configuration
 * parameter setting. 
 * <p>
 * To provide a driver specific Model Configuration, extend this class and add
 * the required parameters as Static final Strings. The provide setter and getter
 * method for these parameters.
 */
public abstract class EpsilonAbstractModelConfig implements EpsilonModelConfig {
	
	/**
	 * This parameter defines the preferred driver to load the model. Values depend
	 * on the avaliable Epsilon model drivers, for example bibtex, csv, emf, hutn,
	 * plainxml, etc.
	 */
	public static final String DRIVER = "driver";
	
	/**
	 * This parameter defines the model name used as identifier within the ExL
	 * source.
	 */
	public static final String NAME = "name";
	
	/** The model uri. */
	public static final String MODEL_URI = "modelUri";
	
	/** This parameter defines if the model will be loaded when read. This
	 * parameter should be true if the model is being used as a source/input
	 * model. For a target/output model this parameter must be set to true if
	 * we want to modify the model rather override its contents.
	 */
	public static final String READ_ON_LOAD = "readOnLoad";
	
	/** This parameter defines if the model will be saved when disposed. This
	 * parameter should be true if the model is being used as a target/output
	 * model. For a source/input model this parameter must be set to true if the
	 * ExL modifies its contents and we want to preserve those changes. 
	 */
	public static final String STORE_ON_DISPOSAL = "storeOnDisposal";
	
	/** This parameter defines aliases for the model used as identifiers in
	 * the ExL source(s). It is a comma separated string of names. Aliases can be
	 * used, for example, to execute a ExL source over a list of input models.
	 */
	public static final String ALIASES = "aliases";
	
	/** This parameter defines if the model would be cached when loaded. Cached
	 * models will improve execution in terms of loading times. 
	 */
	public static final String CACHED = "cached";
	
	// TODO Move this to the respective driver configuration
	//== bibtex Specifics ==//
	/** This parameter defines the bibtex source file. It is 
	 * used by the bibtex drivers to locate the model file.
	 */
	public static final String SOURCE_FILE = "";
	
	//== XML & CSV Specifics ==//
	/** This parameter defines a base path for the XML or csv model file. It is 
	 * used by the csv and plainxml drivers to locate the model file.
	 */
	public static final String BASE_PATH = "";
	
	/** This parameter defines a path for the XML or csv model file. It is used
	 * by the csv and plainxml drivers to locate the model file.
	 */
	public static final String FILE = "file";
	
	//== XML Specifics ==//
	/** This parameter defines a URI for the XML model file. It is used
	 * by the plainxml drivers to locate the model file if no FILE parameter
	 * is set.
	 */
	public static final String XML_URI = "xmlUri";
	// END moving 
	
	
	/** The parameters. */
	protected Map<String, String> parameters;
	
	
	/**
	 * Instantiates a new epsilon model config.
	 */
	public EpsilonAbstractModelConfig() {
		parameters = new HashMap<String, String>();
	}

	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.emc.factory.EpsilonModelConfig#getParameter(java.lang.String)
	 */
	public String getParameter(@NonNull String name) {
		
		return parameters.get(name);
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.emc.factory.EpsilonModelConfig#setParameter(java.lang.String, java.lang.String)
	 */
	public void setParameter(@NonNull String parameter, @NonNull String value) {
		
		parameters.put(parameter, value);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.emc.factory.EpsilonModelConfig#getDriverName()
	 */
	public String getDriverName() {
		
		return parameters.get(DRIVER);
	}

	
	/**
	 * Sets the model name. This method overwrites the previous value.
	 *
	 * @param name the new model name
	 */
	public void setModelName(@NonNull String name) {
		
		parameters.put(NAME, name);
	}
	

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.emc.factory.EpsilonModelConfig#getModelName()
	 */
	public String getModelName() {
		
		return parameters.get(NAME);
	}
	
	
	/**
	 * Sets the model uri. This method overwrites the previous value.
	 *
	 * @param modelURI the new model uri
	 */
	public void setModelURI(@NonNull String modelURI) {
		
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
	 * Sets the read on load setting. This method overwrites the previous value.
	 *
	 * @param value the new read on load
	 */
	public void setReadOnLoad(boolean value) {
		
		parameters.put(READ_ON_LOAD, String.valueOf(value));
	}
	
	/**
	 * Gets the read on load value.
	 *
	 * @return the read on load
	 */
	public boolean getReadOnLoad() {
		
		return Boolean.valueOf(parameters.get(READ_ON_LOAD));
	}


	/**
	 * Sets the store on disposal setting. This method overwrites the previous value.
	 *
	 * @param value the new store on disposal
	 */
	public void setStoreOnDisposal(boolean value) {
		
		parameters.put(STORE_ON_DISPOSAL, String.valueOf(value));
	}
	
	/**
	 * Gets the store on disposal value.
	 *
	 * @return the store on disposal
	 */
	public boolean getStoreOnDisposal() {
		
		return Boolean.valueOf(parameters.get(STORE_ON_DISPOSAL));
	}
	
	/**
	 * Sets the aliases. This method overwrites the previous value.
	 *
	 * @param aliases A comma separated list of aliases.
	 */
	public void setAliases(@NonNull String aliases) {
		
		parameters.put(ALIASES, aliases);
	}
	
	/**
	 * Gets the aliases.
	 *
	 * @return the aliases
	 */
	public String getAliases() {
		
		return parameters.get(ALIASES);
	}


	/**
	 * Sets the cached setting. This method overwrites the previous value.
	 *
	 * @param value the new cached
	 */
	public void setCached(boolean value) {
		
		parameters.put(CACHED, String.valueOf(value));
	}
	
	/**
	 * Gets the cached value.
	 *
	 * @return the cached
	 */
	public boolean getCached() {
		
		return Boolean.valueOf(parameters.get(CACHED));
	}


}
