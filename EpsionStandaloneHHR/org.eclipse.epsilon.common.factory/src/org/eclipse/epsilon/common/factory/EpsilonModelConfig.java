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

import org.eclipse.jdt.annotation.NonNull;

// TODO: Auto-generated Javadoc
/**
 * An Epsilon Model configuration object used by the Epsilon Model Factory to
 * set the parameters for loading models with a specific driver.
 */
public interface EpsilonModelConfig {
	
	
	/**
	 * Returns the name of this model instance. The name may be provided via
	 * model process administration or assigned in the model process execution
	 * descriptor.
	 *
	 * @return the name of the model instance
	 */
	public String getModelName();
	
	/**
	 * Sets the model name. This method overwrites the previous value.
	 *
	 * @param name the new model name
	 */
	public void setModelName(String name);
	
	
	/**
	 * Returns a String containing the value of the named configuration parameter,
	 * or null if the parameter does not exist. 
	 * <p>
	 * Depending on the specific implementation the underlying parameter
	 * storage method (for example a Map) could allow values to be null, in which
	 * case a null result is not sufficient proof that the parameter does not
	 * exist.
	 *
	 * @param name the name of the parameter
	 * @return the value of the parameter
	 */
	public String getParameter(@NonNull String name);
	
	
	/**
	 * Sets the value for a given parameter. Any previous value assigned to the
	 * parameter will be overwritten. Implementing classes should provide a set
	 * of String constants for the accepted parameter names.
	 *
	 * @param parameter the parameter
	 * @param value the value to assign to the parameter.
	 */
	public void setParameter(@NonNull String parameter, @NonNull String value);
	
	
	/**
	 * Returns the name of the specific driver for which this configuration
	 * was created. 
	 * 
	 * @return the name of the driver
	 */
	public String getDriverName();
	
	
	/**
	 * Returns the name of the specific model factory that uses this configuration.
	 * Implementing classes should set the value of this property in the
	 * constructor code and assign it the name of the Factory class associated
	 * with the configuration. 
	 *
	 * @return the factory name
	 */
	public String getFactoryName();

	
	/**
	 * Sets the model uri. This method overwrites the previous value.
	 *
	 * @param modelURI the new model uri
	 */
	public void setModelURI(String modelURI);


	/**
	 * Gets the model uri.
	 *
	 * @return the model uri
	 */
	public String getModelURI();


	/**
	 * Sets the read on load setting. This method overwrites the previous value.
	 *
	 * @param value the new read on load
	 */
	public void setReadOnLoad(boolean value);


	/**
	 * Gets the read on load value.
	 *
	 * @return the read on load
	 */
	public boolean getReadOnLoad();


	/**
	 * Sets the store on disposal setting. This method overwrites the previous value.
	 *
	 * @param value the new store on disposal
	 */
	public void setStoreOnDisposal(boolean value);


	/**
	 * Gets the store on disposal value.
	 *
	 * @return the store on disposal
	 */
	public boolean getStoreOnDisposal();


	/**
	 * Sets the aliases. This method overwrites the previous value.
	 *
	 * @param aliases A comma separated list of aliases.
	 */
	public void setAliases(String aliases);

	/**
	 * Gets the aliases.
	 *
	 * @return the aliases as a comma separated list
	 */
	public String getAliases();
	
	
	/**
	 * Sets the cached setting. This method overwrites the previous value.
	 *
	 * @param value the new cached
	 */
	public void setCached(boolean value);


	/**
	 * Gets the cached value.
	 *
	 * @return the cached
	 */
	public boolean getCached();

	
	

}
