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

import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.jdt.annotation.NonNull;

/**
 * A factory interface for creating Epsilon Model objects.
 * 
 * @author Horacio Hoyos
 */
public interface EpsilonModelFactory {
	
	/**
	 * Creates a new EpsilonModel object for the corresponding driver. The factory
	 * uses a {@link EpsilonModelConfig} object to set the various attributes 
	 * needed for loading a model for the corresponding driver. Implementing factories
	 * should provide additional methods to initialise the configuration.
	 *
	 * @return the model
	 * @throws EolModelLoadingException If there is a problem loading the model
	 * with the supplied configuration
	 */
	public IModel createModel() throws EolModelLoadingException;
	
	
	/**
	 * Returns the configuration used by this factory to create models.
	 *
	 * @return the configuration
	 */
	public EpsilonModelConfig getConfiguration();
	
	/**
	 * Sets the model name used by the factory.
	 *
	 * @param modelName the model name
	 */
	public void setModelName(@NonNull String modelName);
	
	/**
	 * Sets the model uri used by the factory.
	 *
	 * @param modelURI the model uri
	 */
	public void setModelURI(@NonNull String modelURI);
	
	/**
	 * Sets the model name and URI used by the factory.
	 *
	 * @param name the model name
	 * @param modelURI the model uri
	 */
	public void setModel(@NonNull String modelName, @NonNull String modelURI);
	
	/**
	 * Sets the model aliases used by the factory
	 *
	 * @param aliases Comma separated list of model aliases
	 */
	public void setModelAliases(@NonNull String aliases);
	
	/**
	 * Configure the factory to load models as source models. Previous
	 * configuration values are reset.
	 */
	public void configForSourceModel();
	
	/**
	 * Configure the factory to load models as cached source models.
	 */
	public void configForCachedSourceModel();
	
	/**
	 * Configure the factory to load models as target models.
	 */
	public void configForTargetModel() ;
	
	/**
	 * Configure the factory to load models as cached target models.
	 */
	public void configForCachedTargetModel();
	
	/**
	 * Configure the factory to load models as bi-directional models.
	 */
	public void configForBidirectionalModel();
	
	/**
	 * Configure the factory to load models as cached bi-directional models.
	 */
	public void configForCachedBidirectionalModel();
	
}
