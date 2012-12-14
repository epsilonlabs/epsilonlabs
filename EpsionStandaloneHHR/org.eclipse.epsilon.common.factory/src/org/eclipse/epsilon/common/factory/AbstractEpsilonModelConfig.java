/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.common.factory;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;

/**
 * AbstractEpsilonModelConfig is the abstract base class for all Epsilon Model
 * Configurations.
 * An EpsilonModelConfig object encapsulates the information needed to load a
 * model in order to use it with any of the Epsilon Languages. This information
 * includes:
 * <ul>
 * <li>The Factory used to load the models associated to the configuration
 * <li>The name of the model as used in the Epsilon Language(s)
 * <li>The URI of the model
 * <li>The model aliases used in the the Epsilon Language(s)
 * <li>The vallue of the ReadOnLoad, StoreOnDisposal and Cached properties
 * </ul>
 * <p>
 * Specific Epsilon drivers should extend this class to provide specific driver
 * configuration parameter setting. 
 */
public abstract class AbstractEpsilonModelConfig implements EpsilonModelConfig {
	
	/**
	 * This parameter defines the preferred driver to load the model. Values depend
	 * on the available Epsilon model drivers, for example bibtex, csv, emf, hutn,
	 * plainxml, etc.
	 */
	public static final String DRIVER = "driver";
	
	
	/** The Constant FACTORY. */
	public static final String FACTORY = "factoryName";
	
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
	public AbstractEpsilonModelConfig() {
		parameters = new HashMap<String, String>();
	}

	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.emc.factory.EpsilonModelConfig#getParameter(java.lang.String)
	 */
	@Override
	public String getParameter(@NonNull String name) {
		
		return parameters.get(name);
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.emc.factory.EpsilonModelConfig#setParameter(java.lang.String, java.lang.String)
	 */
	@Override
	public void setParameter(@NonNull String parameter, @NonNull String value) {
		
		parameters.put(parameter, value);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.emc.factory.EpsilonModelConfig#getDriverName()
	 */
	@Override
	public String getDriverName() {
		
		return parameters.get(DRIVER);
	}
	
	public String getFactoryName() {
		
		return parameters.get(FACTORY);
	}

	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.common.factory.EpsilonModelConfig#setModelName(java.lang.String)
	 */
	@Override
	public void setModelName(@NonNull String name) {
		
		parameters.put(NAME, name);
	}
	

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.emc.factory.EpsilonModelConfig#getModelName()
	 */
	@Override
	public String getModelName() {
		
		return parameters.get(NAME);
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.common.factory.EpsilonModelConfig#setModelURI(java.lang.String)
	 */
	@Override
	public void setModelURI(@NonNull String modelURI) {
		
		parameters.put(MODEL_URI, modelURI);
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.common.factory.EpsilonModelConfig#getModelURI()
	 */
	@Override
	public String getModelURI() {
		
		return parameters.get(MODEL_URI);
	}


	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.common.factory.EpsilonModelConfig#setReadOnLoad(boolean)
	 */
	@Override
	public void setReadOnLoad(boolean value) {
		
		parameters.put(READ_ON_LOAD, String.valueOf(value));
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.common.factory.EpsilonModelConfig#getReadOnLoad()
	 */
	@Override
	public boolean getReadOnLoad() {
		
		return Boolean.valueOf(parameters.get(READ_ON_LOAD));
	}


	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.common.factory.EpsilonModelConfig#setStoreOnDisposal(boolean)
	 */
	@Override
	public void setStoreOnDisposal(boolean value) {
		
		parameters.put(STORE_ON_DISPOSAL, String.valueOf(value));
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.common.factory.EpsilonModelConfig#getStoreOnDisposal()
	 */
	@Override
	public boolean getStoreOnDisposal() {
		
		return Boolean.valueOf(parameters.get(STORE_ON_DISPOSAL));
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.common.factory.EpsilonModelConfig#setAliases(java.lang.String)
	 */
	@Override
	public void setAliases(@NonNull String aliases) {
		
		parameters.put(ALIASES, aliases);
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.common.factory.EpsilonModelConfig#getAliases()
	 */
	@Override
	public String getAliases() {
		
		return parameters.get(ALIASES);
	}


	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.common.factory.EpsilonModelConfig#setCached(boolean)
	 */
	@Override
	public void setCached(boolean value) {
		
		parameters.put(CACHED, String.valueOf(value));
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.common.factory.EpsilonModelConfig#getCached()
	 */
	@Override
	public boolean getCached() {
		
		return Boolean.valueOf(parameters.get(CACHED));
	}


}
