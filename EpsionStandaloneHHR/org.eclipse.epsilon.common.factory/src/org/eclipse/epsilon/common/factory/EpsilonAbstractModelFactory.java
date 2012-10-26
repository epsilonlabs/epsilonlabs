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
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IModel;

/**
 * A factory for creating EpsilonAbstractModel objects.
 */
public abstract class EpsilonAbstractModelFactory implements
		EpsilonModelFactory {

	
	/** The config. */
	protected EpsilonAbstractModelConfig config;
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.emc.factory.EpsilonModelFactory#createModel()
	 */
	public abstract IModel createModel() throws EolModelLoadingException;

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.emc.factory.EpsilonModelFactory#getConfiguration()
	 */
	public abstract EpsilonModelConfig getConfiguration();
	
	/**
	 * Sets the model name used by the factory.
	 *
	 * @param name the new model name
	 */
	public void setModelName(@NonNull String name) {
		
		config.setModelName(name);
	}
	
	/**
	 * Sets the model uri used by the factory.
	 *
	 * @param modelURI the new model uri
	 */
	public void setModelURI(@NonNull String modelURI) {
		
		config.setModelURI(modelURI);
	}
	
	/**
	 * Sets the model name and URI used by the factory.
	 *
	 * @param name the name
	 * @param modelURI the model uri
	 */
	public void setModel(@NonNull String name, @NonNull String modelURI) {
		
		config.setModelName(name);
		config.setModelURI(modelURI);
	}
	
	
	/**
	 * Sets the model aliases used by the factory
	 *
	 * @param aliases Comma separated list of model aliases
	 */
	public void setModelAliases(@NonNull String aliases) {
		
		config.setAliases(aliases);		
	}

	
	/**
	 * Configure the factory to load models as source models.
	 */
	public void configForSourceModel() {
		
		config.setReadOnLoad(true);
		config.setStoreOnDisposal(false);
		config.setCached(false);
	}
	

	/**
	 * Configure the factory to load models as cached source models.
	 */
	public void configForCachedSourceModel() {
		
		config.setReadOnLoad(true);
		config.setCached(true);
	}
	

	/**
	 * Configure the factory to load models as target models.
	 */
	public void configForTargetModel() {
		
		config.setStoreOnDisposal(true);
		config.setReadOnLoad(false);
		config.setCached(false);
	}
	

	/**
	 * Configure the factory to load models as cached target models.
	 */
	public void configForCachedTargetModel() {
		
		config.setStoreOnDisposal(true);
		config.setCached(true);
	}
	

	/**
	 * Configure the factory to load models as bi-directional models.
	 */
	public void configForBidirectionalModel() {
		
		config.setReadOnLoad(true);
		config.setStoreOnDisposal(true);
		config.setCached(false);
	}
	

	/**
	 * Configure the factory to load models as cached bi-directional models.
	 */
	public void configForCachedBidirModel() {
		
		configForBidirectionalModel();
		config.setCached(true);
	}

}
