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
package org.eclipse.epsilon.emc.emf.factory;

import org.eclipse.epsilon.common.factory.AbstractEpsilonModelFactory;
import org.eclipse.epsilon.common.factory.EpsilonModelConfig;
import org.eclipse.epsilon.common.factory.EpsilonModelFactory;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IModel;

/**
 * A factory for creating Epsilon EmfModel models.
 */
public class EpsilonEmfModelFactory extends AbstractEpsilonModelFactory implements EpsilonModelFactory {
	
	/**
	 * Instantiates a new Epsilon emf model factory.
	 */
	public EpsilonEmfModelFactory() {
		config = new EmfEpsilonModelConfig();
	}
	
	/**
	 * Instantiates a new Epsilon emf model factory for the given model name.
	 *
	 * @param modelName the model name
	 * @param modelURI the model uri
	 */
	public EpsilonEmfModelFactory(String modelName, String modelURI) {
		config = new EmfEpsilonModelConfig();
		config.setModelName(modelName);
		config.setModelURI(modelURI);
	}
	

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.emc.factory.EpsilonAbstractModelFactory#createModel()
	 */
	public IModel createModel() throws EolModelLoadingException {
		// TODO test that the configuration has the needed parameters??
		EmfModel emfModel = new EmfModel();
		StringProperties properties = new StringProperties();
		properties.put(EmfModel.PROPERTY_NAME, config.getParameter(EmfEpsilonModelConfig.NAME));
		properties.put(EmfModel.PROPERTY_ALIASES, config.getParameter(EmfEpsilonModelConfig.ALIASES));
		properties.put(EmfModel.PROPERTY_MODEL_URI, config.getParameter(EmfEpsilonModelConfig.MODEL_URI));
		properties.put(EmfModel.PROPERTY_READONLOAD, config.getParameter(EmfEpsilonModelConfig.READ_ON_LOAD));
		properties.put(EmfModel.PROPERTY_STOREONDISPOSAL, config.getParameter(EmfEpsilonModelConfig.STORE_ON_DISPOSAL));
		properties.put(EmfModel.PROPERTY_CACHED, config.getParameter(EmfEpsilonModelConfig.CACHED));
		properties.put(EmfModel.PROPERTY_EXPAND, config.getParameter(EmfEpsilonModelConfig.EXPAND));
		properties.put(EmfModel.PROPERTY_FILE_BASED_METAMODEL_URI, config.getParameter(EmfEpsilonModelConfig.FILE_METAMODELS));
		properties.put(EmfModel.PROPERTY_METAMODEL_URI, config.getParameter(EmfEpsilonModelConfig.URI_METAMODELS));
		emfModel.load(properties, null);
		return emfModel;
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.emc.factory.EpsilonAbstractModelFactory#getConfiguration()
	 */
	@Override
	public EpsilonModelConfig getConfiguration() {
		return config;
	}
	
	/**
	 * Sets the configuration used in the factory. Convenience method for setting
	 * the factory's configuration. 
	 *
	 * @param config the new configuration
	 */
	public void setConfiguration(EpsilonModelConfig config) {
		
		this.config = (EmfEpsilonModelConfig) config;
	}
	
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.common.factory.EpsilonAbstractModelFactory#configForSourceModel()
	 */
	@Override
	public void configForSourceModel() {
		super.configForSourceModel();
		config.setParameter(EmfEpsilonModelConfig.EXPAND, String.valueOf(true));
		
	}

	/**
	 * Configure the factory to load models as source models and don't expand them on
	 * load.
	 */
	public void configForSourceModelNoExpand() {
		
		configForSourceModel();
		config.setParameter(EmfEpsilonModelConfig.EXPAND, String.valueOf(false));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.common.factory.EpsilonAbstractModelFactory#configForCachedSourceModel()
	 */
	@Override
	public void configForCachedSourceModel() {
		super.configForCachedSourceModel();
		config.setParameter(EmfEpsilonModelConfig.EXPAND, String.valueOf(true));
	}
	
	
	/**
	 * Configure the factory to load models as cached source models and don't expand
	 * them on load.
	 */
	public void configForCachedSourceModelNoExpand() {
		
		configForCachedSourceModel();
		config.setParameter(EmfEpsilonModelConfig.EXPAND, String.valueOf(false));
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.common.factory.EpsilonAbstractModelFactory#configForTargetModel()
	 */
	@Override
	public void configForTargetModel() {
		super.configForTargetModel();
		config.setParameter(EmfEpsilonModelConfig.EXPAND, String.valueOf(true));
	}

	/**
	 * Configure the factory to load models as target models and don't expand them on
	 * load.
	 */
	public void configForTargetModelNoExpand() {
		
		configForTargetModel();
		config.setParameter(EmfEpsilonModelConfig.EXPAND, String.valueOf(false));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.common.factory.EpsilonAbstractModelFactory#configForCachedTargetModel()
	 */
	@Override
	public void configForCachedTargetModel() {
		super.configForCachedTargetModel();
		config.setParameter(EmfEpsilonModelConfig.EXPAND, String.valueOf(true));
	}
	
	/**
	 * Configure the factory to load models as cached target models and don't expand
	 * them on load.
	 */
	public void configForCachedTargetModelNoExpand() {		
		configForCachedTargetModel();
		config.setParameter(EmfEpsilonModelConfig.EXPAND, String.valueOf(false));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.common.factory.EpsilonAbstractModelFactory#configForBidirectionalModel()
	 */
	@Override
	public void configForUpdateModel() {
		super.configForUpdateModel();
		config.setParameter(EmfEpsilonModelConfig.EXPAND, String.valueOf(true));
	}
	
	/**
	 * Configure the factory to load models as cached target models and don't expand
	 * them on load.
	 */
	public void configForUpdateModelNoExpand() {
		
		configForUpdateModel();
		config.setParameter(EmfEpsilonModelConfig.EXPAND, String.valueOf(false));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.common.factory.EpsilonAbstractModelFactory#configForCachedBidirectionalModel()
	 */
	@Override
	public void configForCachedUpdateModel() {
		super.configForCachedUpdateModel();
		config.setParameter(EmfEpsilonModelConfig.EXPAND, String.valueOf(true));
	}
	
	/**
	 * Configure the factory to load models as cached target models and don't expand
	 * them on load.
	 */
	public void configForCachedUpdateModelNoExpand() {		
		configForCachedUpdateModel();
		config.setParameter(EmfEpsilonModelConfig.EXPAND, String.valueOf(false));
	}
	
	/**
	 * Adds the meta-model URI (or UIRs) to the configuration list of URI based
	 * meta-models. To add several URIs pass them as a comma separated list. If
	 * the configuration has any previous URI based meta-models, the supplied
	 * URIs passed by this method will be appended to the existing ones.
	 *
	 * @param metamodelURI the meta-model URI or a comma separated list of URI (
	 * 	for multiple URIs)
	 */
	public void addMetamodelUri(String metamodelURI) {
		// TODO some how test the well formness of the parameter
		StringBuilder metamodels = null;
		String oldMetamodels = config.getParameter(EmfEpsilonModelConfig.URI_METAMODELS);
		if (oldMetamodels == null) {
			metamodels = new StringBuilder();
		} else {
			metamodels = new StringBuilder(oldMetamodels);
			metamodels.append(",");
		}
		metamodelURI = metamodelURI.trim();
		if (metamodelURI.endsWith(",")) {
			metamodelURI = metamodelURI.substring(0, metamodelURI.length()-1);
		}
		metamodels.append(metamodelURI);
		config.setParameter(EmfEpsilonModelConfig.URI_METAMODELS, metamodels.toString());
	}
	
	/**
	 * Adds the meta-model path (or paths) to the configuration list of path based
	 * meta-models. To add several paths pass them as a comma separated list. If
	 * the configuration has any previous path based meta-models, the supplied
	 * path(s) passed by this method will be appended to the existing one(s).
	 *
	 * @param metamodelPath the meta-model path or a comma separated list of paths
	 *  (for multiple paths)
	 */
	public void addMetamodelFile(String metamodelPath) {
		// TODO some how test the well formness of the parameter		
		StringBuilder metamodels = null;
		String oldMetamodels = config.getParameter(EmfEpsilonModelConfig.FILE_METAMODELS);
		if (oldMetamodels == null) {
			metamodels = new StringBuilder();
		} else {
			metamodels = new StringBuilder(oldMetamodels);
			metamodels.append(",");
		}
		metamodelPath = metamodelPath.trim();
		if (metamodelPath.endsWith(",")) {
			metamodelPath = metamodelPath.substring(0, metamodelPath.length()-1);
		}
		
		metamodels.append(metamodelPath);
		config.setParameter(EmfEpsilonModelConfig.FILE_METAMODELS, metamodels.toString());
	}
	
	/**
	 * Removes all metamodel URIs previously added to the Factory. 
	 */
	public void clearMetamodelUris() {
		
		config.setParameter(EmfEpsilonModelConfig.URI_METAMODELS, "");
	}
	
	
	/**
	 * Removes all metamodel paths (file based) previously added to the Factory.
	 */
	public void clearMetamodelPaths() {
		
		config.setParameter(EmfEpsilonModelConfig.FILE_METAMODELS, "");
	}

}
