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
 * An abstract implementation of the EpsilonModelFactory interface.
 */
public abstract class EpsilonAbstractModelFactory implements
		EpsilonModelFactory {

	/** The configuration. */
	protected AbstractEpsilonModelConfig config;
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.emc.factory.EpsilonModelFactory#createModel()
	 */
	public abstract IModel createModel() throws EolModelLoadingException;

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.emc.factory.EpsilonModelFactory#getConfiguration()
	 */
	public abstract EpsilonModelConfig getConfiguration();
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.common.factory.EpsilonModelFactory#setModelName(java.lang.String)
	 */
	public void setModelName(@NonNull String name) {
		
		config.setModelName(name);
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.common.factory.EpsilonModelFactory#setModelURI(java.lang.String)
	 */
	public void setModelURI(@NonNull String modelURI) {
		
		config.setModelURI(modelURI);
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.common.factory.EpsilonModelFactory#setModel(java.lang.String, java.lang.String)
	 */
	public void setModel(@NonNull String name, @NonNull String modelURI) {
		
		config.setModelName(name);
		config.setModelURI(modelURI);
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.common.factory.EpsilonModelFactory#setModelAliases(java.lang.String)
	 */
	public void setModelAliases(@NonNull String aliases) {
		
		config.setAliases(aliases);		
	}

	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.common.factory.EpsilonModelFactory#configForSourceModel()
	 */
	public void configForSourceModel() {
		
		config.setReadOnLoad(true);
		config.setStoreOnDisposal(false);
		config.setCached(false);
	}
	

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.common.factory.EpsilonModelFactory#configForCachedSourceModel()
	 */
	public void configForCachedSourceModel() {
		
		config.setReadOnLoad(true);
		config.setStoreOnDisposal(false);
		config.setCached(true);
	}
	

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.common.factory.EpsilonModelFactory#configForTargetModel()
	 */
	public void configForTargetModel() {
		
		config.setStoreOnDisposal(true);
		config.setReadOnLoad(false);
		config.setCached(false);
	}
	

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.common.factory.EpsilonModelFactory#configForCachedTargetModel()
	 */
	public void configForCachedTargetModel() {
		
		config.setStoreOnDisposal(true);
		config.setReadOnLoad(false);
		config.setCached(true);
	}
	

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.common.factory.EpsilonModelFactory#configForBidirectionalModel()
	 */
	public void configForBidirectionalModel() {
		
		config.setReadOnLoad(true);
		config.setStoreOnDisposal(true);
		config.setCached(false);
	}
	

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.common.factory.EpsilonModelFactory#configForCachedBidirectionalModel()
	 */
	public void configForCachedBidirectionalModel() {
		
		configForBidirectionalModel();
		config.setCached(true);
	}

}
