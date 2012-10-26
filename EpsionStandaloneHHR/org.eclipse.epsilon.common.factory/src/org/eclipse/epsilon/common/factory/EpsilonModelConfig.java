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

import org.eclipse.jdt.annotation.NonNull;

// TODO: Auto-generated Javadoc
/**
 * An Epsilon Model configuration object used by an Epsilon Model factory used
 * to pass information to driver during model initialisation.
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
	 * @return the name of the driver
	 */
	public String getDriverName();
	
	

}
