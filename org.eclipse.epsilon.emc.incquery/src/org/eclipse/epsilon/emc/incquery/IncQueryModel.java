package org.eclipse.epsilon.emc.incquery;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.models.Model;
import org.eclipse.incquery.patternlanguage.emf.EMFPatternLanguageStandaloneSetup;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternModel;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.QuerySpecificationRegistry;
import org.eclipse.incquery.tooling.core.generator.GeneratorModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class IncQueryModel extends Model {
	
	public static final String PROPERTY_MODEL_FILE = "modelFile";
	public static final String PROPERTY_PATTERNS_FILE = "patternsFile";
	
	protected IncQueryPropertyGetter propertyGetter = new IncQueryPropertyGetter();
	
	protected String modelFile = "/org.eclipse.epsilon.emc.incquery.demo/src/org/eclipse/epsilon/emc/incquery/demo/anotherdemo.ecore";
	protected String patternsFile = "/org.eclipse.epsilon.emc.incquery.demo/src/org/eclipse/epsilon/emc/incquery/demo/demo.eiq";
	protected PatternModel patternModel = null;
	protected IncQueryEngine engine = null;
	
	@Override
	public void load(StringProperties properties, String basePath)
			throws EolModelLoadingException {
		super.load(properties, basePath);
		modelFile = properties.getProperty(PROPERTY_MODEL_FILE);
		patternsFile = properties.getProperty(PROPERTY_PATTERNS_FILE);
		load();
	}
	
	@Override
	public void load() throws EolModelLoadingException {
				
		try {
		
			new EMFPatternLanguageStandaloneSetup() {
				@Override
				public Injector createInjector() {
					return Guice.createInjector(new GeneratorModule());
				}
			}.createInjectorAndDoEMFRegistration();
			
			ResourceSet modelResourceSet = new ResourceSetImpl();
			Resource modelResource = modelResourceSet.createResource(URI.createPlatformResourceURI(modelFile, true));
			modelResource.load(null);
			
			engine = IncQueryEngine.on(modelResource); 
			
			ResourceSet patternsResourceSet = new ResourceSetImpl();
			Resource patternsResource = patternsResourceSet.createResource(URI.createPlatformResourceURI(patternsFile, true));
			patternsResource.load(null);
			patternModel = (PatternModel) patternsResource.getContents().get(0);
			
		} catch (Exception e) {
			throw new EolModelLoadingException(e, this);
		}
		
	}

	@Override
	public Object getEnumerationValue(String enumeration, String label)
			throws EolEnumerationValueNotFoundException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Collection<?> allContents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<?> getAllOfType(String type)
			throws EolModelElementTypeNotFoundException {
		
		try {
			
			IQuerySpecification<? extends IncQueryMatcher<? extends IPatternMatch>> querySpecification 
					= QuerySpecificationRegistry.getOrCreateQuerySpecification(getPattern(type));
			
			return querySpecification.
					getMatcher(engine).getAllMatches();
		} catch (IncQueryException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public Collection<?> getAllOfKind(String type)
			throws EolModelElementTypeNotFoundException {
		return getAllOfType(type);
	}

	@Override
	public String getTypeNameOf(Object instance) {
		IPatternMatch match = (IPatternMatch) instance;
		return match.patternName();
	}

	@Override
	public Object createInstance(String type)
			throws EolModelElementTypeNotFoundException,
			EolNotInstantiableModelElementTypeException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object getElementById(String id) {
		return null;
	}

	@Override
	public String getElementId(Object instance) {
		return null;
	}

	@Override
	public void setElementId(Object instance, String newId) {
	}

	@Override
	public void deleteElement(Object instance) throws EolRuntimeException {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean owns(Object instance) {
		
		if (instance instanceof IPatternMatch) {
			
			IPatternMatch match = (IPatternMatch) instance;
			return patternModel.getPatterns().contains(match.pattern());
			
		}
		
		return false;
		
	}

	@Override
	public boolean isInstantiable(String type) {
		return false;
	}

	@Override
	public boolean knowsAboutProperty(Object instance, String property) {
		return owns(instance) || (instance instanceof EObject);
	}
	
	@Override
	public boolean hasType(String type) {
		return getPattern(type) != null;
	}
	
	protected Pattern getPattern(String type) {
		for (Pattern pattern : patternModel.getPatterns()) {
			if (pattern.getName().endsWith(type)) return pattern;
		}
		return null;
	}
		
	@Override
	public boolean store(String location) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean store() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public IPropertyGetter getPropertyGetter() {
		return propertyGetter;
	}
	
	public PatternModel getPatternModel() {
		return patternModel;
	}
	
}
