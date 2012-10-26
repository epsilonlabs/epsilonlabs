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

import org.eclipse.epsilon.emc.emf.factory.EpsilonEmfModelFactory;


public final class ModelFactorySelector {
	
	
	public static EpsilonModelFactory getModelFactory( EpsilonModelConfig epsilonModelConfig ){
		
		if ( epsilonModelConfig == null ) {
	      throw new IllegalArgumentException("EpsilonModelConfig must not be null.");
	    }
	    //examine the configuration to extract the emc driver identifier
	    final String driver = epsilonModelConfig.getDriverName();
	    if ( driver.equalsIgnoreCase("bitex")) {
	    	// TODO implement the bibtex factory
	    	throw new UnsupportedOperationException("The bibtex factory is not yet implemented");
	    }
	    else if ( driver.equalsIgnoreCase("csv") ) {
	    	// TODO implement the bibtex factory
	    	throw new UnsupportedOperationException("The csv factory is not yet implemented");
	    }
	    else if ( driver.equalsIgnoreCase("emf") ) {
	    	return new EpsilonEmfModelFactory();
	    }
	    else if ( driver.equalsIgnoreCase("hutn") ) {
	    	// TODO implement the hutn factory
	    	throw new UnsupportedOperationException("The hutn factory is not yet implemented");
	    }
	    else if ( driver.equalsIgnoreCase("plainxml") ) {
	    	// TODO implement the plainxml factory
	    	throw new UnsupportedOperationException("The plainxml factory is not yet implemented");
	    }
	    else {
	      throw new IllegalArgumentException("Unknown emc driver identifier.");
	    }
	}

}
