package org.eclipse.epsilon.emc.incquery.demo;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.incquery.patternlanguage.emf.EMFPatternLanguageStandaloneSetup;
import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.PatternModel;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.QuerySpecificationRegistry;
import org.eclipse.incquery.tooling.core.generator.GeneratorModule;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class PluggedInTest {
	
	@Test
	public void testStandaloneIncQuery() throws Exception {
		
/*		String root = "/org.eclipse.epsilon.emc.incquery.demo/src/org/eclipse/epsilon/emc/incquery/demo/";
		
		ResourceSet modelResourceSet = new ResourceSetImpl();
		Resource modelResource = modelResourceSet.createResource(URI.createPlatformPluginURI(root + "demo.ecore", true));
		modelResource.load(null);
		
		IncQueryEngine engine = AdvancedIncQueryEngine.createUnmanagedEngine(modelResource);
		
		ResourceSet patternsResourceSet = new ResourceSetImpl();
		Resource patternsResource = patternsResourceSet.createResource(URI.createPlatformPluginURI("/org.eclipse.epsilon.emc.incquery.demo/queries/globalEiqModel.xmi", true));
		patternsResource.load(null);
		
		PatternModel patternModel = (PatternModel) patternsResource.getContents().get(0);
		
		IQuerySpecification<? extends IncQueryMatcher<? extends IPatternMatch>> querySpecification 
				= QuerySpecificationRegistry.getOrCreateQuerySpecification(patternModel.getPatterns().get(0));
		
		System.err.println(querySpecification.getMatcher(engine).getAllMatches().size());
		*/
		Resource model = loadResourceFromUri(URI.createPlatformPluginURI("org.eclipse.epsilon.emc.incquery.demo/src/org/eclipse/epsilon/emc/incquery/demo/demo.eiq", false));
		URI incQueryPatternsModel = URI.createPlatformPluginURI("org.eclipse.epsilon.emc.incquery.demo/src/org/eclipse/epsilon/emc/incquery/demo/demo.eiq", false);
		System.err.println(executeDemo_GenericAPI_LoadFromEIQ(
				model,
				"EClassesWithManyEAttributes",
				incQueryPatternsModel
				));
		
	}
	
	/**
	 * Returns the match set for patternFQN over the model in modelPath in pretty printed form
	 * 
	 * @param modelPath
	 * @param patternName
	 * @param patternURI TODO
	 * @return
	 */
	public String executeDemo_GenericAPI_LoadFromEIQ(Resource resource, String patternName /*not the FQN*/, URI fileURI) {
	 final StringBuilder results = new StringBuilder(); 
	 if (resource != null) {
	  try {
	    // get all matches of the pattern
	    // create an *unmanaged* engine to ensure that noone else is going
	    // to use our engine
	    AdvancedIncQueryEngine engine = AdvancedIncQueryEngine.createUnmanagedEngine(resource);
	    // instantiate a pattern matcher through the registry, by only knowing its FQN
	    // assuming that there is a pattern definition registered matching 'patternFQN'

	    // Xtext resource magic -- this is needed for EIQ resources;
	    new EMFPatternLanguageStandaloneSetup()
	    {
	     @Override
	     public Injector createInjector() { return Guice.createInjector(new GeneratorModule()); }
	    }
	   .createInjectorAndDoEMFRegistration();
	    // use a trick to load Pattern models from a file
	   Resource patternResource = loadResourceFromUri(fileURI);
	    // navigate to the pattern definition that we want
	    if (patternResource != null) {
	     if (patternResource.getErrors().size() == 0 && patternResource.getContents().size() >= 1) {
	      EObject topElement = patternResource.getContents().get(0);
	       if (topElement instanceof PatternModel) {
	        for (Pattern _p  : ((PatternModel) topElement).getPatterns()) {
//	        System.out.println(_p.getName());
	         if (_p.getName().equals(patternName)) {
    	     IncQueryMatcher<? extends IPatternMatch> matcher = engine.getMatcher(_p);
    	       if (matcher!=null) {
    	        Collection<? extends IPatternMatch> matches = matcher.getAllMatches();
    	        prettyPrintMatches(results, matches, matcher);
    	      }
	         }
	        }
	       }
	      }
	     }
	     // wipe the engine
	     engine.wipe();
	     // after a wipe, new patterns can be rebuilt with much less overhead than 
	     // complete traversal (as the base indexes will be kept)
	     // completely dispose of the engine once's it is not needed
	     engine.dispose();
	     resource.unload();
	    } catch (IncQueryException e) {
	      e.printStackTrace();
	     results.append(e.getMessage());
	    }
	   } else {
	    results.append("Resource not found");
	  }
	 return results.toString();
	}
	
	protected Resource loadModel(String modelPath) {
		// Loads the resource
		URI fileURI = URI.createFileURI(modelPath);
		return loadResourceFromUri(fileURI);
	}

	private Resource loadResourceFromUri(URI fileURI) {
		ResourceSet resourceSet = new ResourceSetImpl();
		return resourceSet.getResource(fileURI, true);
	}
	
	protected void prettyPrintMatches(StringBuilder results, Collection<? extends IPatternMatch> matches, IncQueryMatcher<? extends IPatternMatch> matcher) {		
		results.append(matcher.getPatternName() + " -> ");
		for (IPatternMatch match : matches) {
			results.append(match.prettyPrint()+"; ");
		}
		if(matches.size() == 0) {
			results.append("Empty match set");
		}
		results.append("\n");
	}	
}
