package org.eclipse.epsilon.emc.argouml;

import org.argouml.model.Model;
import org.argouml.model.ModelImplementation;

public final class InitializeModel {
    
    /**
     * The default model implementation to start.
     */
    private static final String DEFAULT_MODEL_IMPLEMENTATION =
        "org.argouml.model.mdr.MDRModelImplementation";


    /**
     * This is never instantiated.
     */
    private InitializeModel() {
    }
    
    /**
     * Initialize the Model subsystem with the default ModelImplementation.
     */
    public static void initializeDefault() {
    	if (Model.isInitiated()) {
    	    return;
    	}
        String className =
            System.getProperty(
                    "argouml.model.implementation",
                    DEFAULT_MODEL_IMPLEMENTATION);
        initializeModelImplementation(className);
    }

    /**
     * Initialize the Model subsystem with the MDR ModelImplementation.
     */
    public static void initializeMDR() {
        initializeModelImplementation(
                "org.argouml.model.mdr.MDRModelImplementation");
    }

    /**
     * Initialize the Model subsystem with the eUML ModelImplementation.
     */
    public static void initializeEUML() {
        initializeModelImplementation(
                "org.argouml.model.euml.EUMLModelImplementation");
    }


    private static ModelImplementation initializeModelImplementation(
            String name) {
        ModelImplementation impl = null;

        Class implType;
        try {
            implType =
                Class.forName(name);
        } catch (ClassNotFoundException e) {
            return null;
        }

        try {
            impl = (ModelImplementation) implType.newInstance();
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        }
        Model.setImplementation(impl);
        return impl;
    }
}