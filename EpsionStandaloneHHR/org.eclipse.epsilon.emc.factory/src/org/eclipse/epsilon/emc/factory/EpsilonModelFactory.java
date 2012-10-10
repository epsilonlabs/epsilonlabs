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
package org.eclipse.epsilon.emc.factory;

import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IModel;

/**
 * A factory interface for creating Epsilon Model objects.
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
	
}
