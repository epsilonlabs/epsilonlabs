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

import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.factory.EpsilonModelConfig;
import org.eclipse.epsilon.emc.factory.EpsilonModelFactory;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IModel;

/**
 * A factory for creating Epsilon EmfModel models.
 */
public class EpsilonEmfModelFactory extends EpsilonAbstractModelFactory implements EpsilonModelFactory {
	
	/**
	 * Instantiates a new Epsilon emf model factory.
	 */
	public EpsilonEmfModelFactory() {
		config = new EpsilonEmfModelConfig();
	}
	
	/**
	 * Instantiates a new Epsilon emf model factory for the given model name
	 *
	 * @param modelName the model name
	 */
	public EpsilonEmfModelFactory(String modelName) {
		super();
		config.setModelName(modelName);
	}
	

	public IModel createModel() throws EolModelLoadingException {
		// TODO test that the configuration has the needed parameters??
		EmfModel emfModel = new EmfModel();
		StringProperties properties = new StringProperties();
		properties.put(EmfModel.PROPERTY_NAME, config.getParameter(EpsilonEmfModelConfig.NAME));
		properties.put(EmfModel.PROPERTY_ALIASES, config.getParameter(EpsilonEmfModelConfig.ALIASES));
		properties.put(EmfModel.PROPERTY_MODEL_URI, config.getParameter(EpsilonEmfModelConfig.MODEL_URI));
		properties.put(EmfModel.PROPERTY_READONLOAD, config.getParameter(EpsilonEmfModelConfig.READ_ON_LOAD));
		properties.put(EmfModel.PROPERTY_STOREONDISPOSAL, config.getParameter(EpsilonEmfModelConfig.STORE_ON_DISPOSAL));
		properties.put(EmfModel.PROPERTY_CACHED, config.getParameter(EpsilonEmfModelConfig.CACHED));
		properties.put(EmfModel.PROPERTY_EXPAND, config.getParameter(EpsilonEmfModelConfig.EXPAND));
		properties.put(EmfModel.PROPERTY_FILE_BASED_METAMODEL_URI, config.getParameter(EpsilonEmfModelConfig.FILE_METAMODELS));
		properties.put(EmfModel.PROPERTY_METAMODEL_URI, config.getParameter(EpsilonEmfModelConfig.URI_METAMODELS));
		emfModel.load(properties, null);
		return emfModel;
	}
	
	
	@Override
	public EpsilonModelConfig getConfiguration() {
		return config;
	}
	
	public void setConfiguration(EpsilonModelConfig config) {
		
		this.config = (EpsilonEmfModelConfig) config;
	}
	
	// TODO Additional methods for the possible combinations of cached and expanded
	
	public void configSourceModelExpand(String modelURI) {
		
		configSourceModel(modelURI);
		config.setParameter(EpsilonEmfModelConfig.EXPAND, String.valueOf(true));
	}
	
	
	public void configCachedSourceModelExpand(String modelURI) {
		
		configCachedSourceModel(modelURI);
		config.setParameter(EpsilonEmfModelConfig.EXPAND, String.valueOf(true));
	}
	
	public void configTargetModelExpand(String modelURI) {
		
		configTargetModel(modelURI);
		config.setParameter(EpsilonEmfModelConfig.EXPAND, String.valueOf(true));
	}
	
	
	public void configCachedTargetModelExpand(String modelURI) {
		
		configCachedTargetModel(modelURI);
		config.setParameter(EpsilonEmfModelConfig.EXPAND, String.valueOf(true));
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
	void addMetamodelUri(String metamodelURI) {
		
		StringBuilder metamodels = null;
		try {
			metamodels = new StringBuilder(config.getParameter(EpsilonEmfModelConfig.URI_METAMODELS));
		} catch (NullPointerException ex) {
			
		} finally {
			if(metamodels == null) {
				metamodels = new StringBuilder();
			}
			if(metamodels.length() > 0) {
				// Some previous list of meta-models exist
				metamodels.append(",");
			}
			metamodels.append(metamodelURI);
			config.setParameter(EpsilonEmfModelConfig.URI_METAMODELS, metamodels.toString());
		}
		
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
		StringBuilder metamodels = null;
		try {
			metamodels = new StringBuilder(config.getParameter(EpsilonEmfModelConfig.FILE_METAMODELS));
		} catch (NullPointerException ex) {
			
		} finally {
			if(metamodels == null) {
				metamodels = new StringBuilder();
			}
			if(metamodels.length() > 0) {
				// Some previous list of meta-models exist
				metamodels.append(",");
			}
			metamodels.append(metamodelPath);
			config.setParameter(EpsilonEmfModelConfig.FILE_METAMODELS, metamodels.toString());
		}
	}

}
