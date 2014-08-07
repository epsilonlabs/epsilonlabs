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


public final class ModelFactorySelector {
	
	public static final String BIBTEX_DRIVER = "bibtex";
	public static final String CSV_DRIVER = "csv";
	public static final String EMF_DRIVER = "emf";
	public static final String HUTN_DRIVER = "hutn";
	public static final String PLAINXML_DRIVER = "plainxml";
	
	public static Class<?> getModelFactory( EpsilonModelConfig epsilonModelConfig ) throws ClassNotFoundException {
		
		if ( epsilonModelConfig == null ) {
			throw new IllegalArgumentException("EpsilonModelConfig must not be null.");
	    }
	    //examine the configuration to extract the emc driver identifier.
	    final String factoryName = epsilonModelConfig.getDriverName();
	    if (factoryName == null) {
	    	throw new NullPointerException("The model configuration does not specified a assocaited factory");
	    }
	    // TODO Can the driver identifier be instead the factory class name?
	    // That way we just create a new class of the correct type.
	 	return Class.forName(factoryName);
	 	/*if ( driver.equalsIgnoreCase(BIBTEX_DRIVER)) {
	    	// TODO implement the bibtex factory
	    	throw new UnsupportedOperationException("The bibtex factory is not yet implemented");
	    }
	    else if ( driver.equalsIgnoreCase(CSV_DRIVER) ) {
	    	// TODO implement the bibtex factory
	    	throw new UnsupportedOperationException("The csv factory is not yet implemented");
	    }
	    else if ( driver.equalsIgnoreCase(EMF_DRIVER) ) {
	    	return new EpsilonEmfModelFactory();
	    }
	    else if ( driver.equalsIgnoreCase(HUTN_DRIVER) ) {
	    	// TODO implement the hutn factory
	    	throw new UnsupportedOperationException("The hutn factory is not yet implemented");
	    }
	    else if ( driver.equalsIgnoreCase(PLAINXML_DRIVER) ) {
	    	// TODO implement the plainxml factory
	    	throw new UnsupportedOperationException("The plainxml factory is not yet implemented");
	    }
	    else {
	      throw new IllegalArgumentException("Unknown emc driver identifier.");
	    }*/
	}

}
