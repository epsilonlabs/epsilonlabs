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
import org.eclipse.epsilon.emc.factory.EpsilonModelFactory;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IModel;

// TODO: Auto-generated Javadoc
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
	 * Config source model.
	 *
	 * @param modelURI the model uri
	 */
	public void configSourceModel(String modelURI) {
		
		config.setModelURI(modelURI);
		config.setReadOnLoad(true);
		
	}
	
	/**
	 * Config cached source model.
	 *
	 * @param modelURI the model uri
	 */
	public void configCachedSourceModel(String modelURI) {
		
		configSourceModel(modelURI);
		config.setCached(true);
		
	}
	
	/**
	 * Config target model.
	 *
	 * @param modelURI the model uri
	 */
	public void configTargetModel(String modelURI) {
		
		config.setModelURI(modelURI);
		config.setStoreOnDisposal(true);
	}
	
	/**
	 * Config cached target model.
	 *
	 * @param modelURI the model uri
	 */
	public void configCachedTargetModel(String modelURI) {
		configTargetModel(modelURI);
		config.setCached(true);
		
	}
	
	/**
	 * Config bidir model.
	 *
	 * @param modelURI the model uri
	 */
	public void configBidirModel(String modelURI) {
		config.setModelURI(modelURI);
		config.setReadOnLoad(true);
		config.setStoreOnDisposal(true);

	}
	
	/**
	 * Config cached bidir model.
	 *
	 * @param modelURI the model uri
	 */
	public void configCachedBidirModel(String modelURI) {
		configBidirModel(modelURI);
		config.setCached(true);
		
	}

}
