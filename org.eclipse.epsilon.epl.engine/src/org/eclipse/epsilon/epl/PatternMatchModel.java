package org.eclipse.epsilon.epl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.models.Model;

public class PatternMatchModel extends Model{
	
	protected HashMap<String, List<PatternMatch>> matchMap = new HashMap<String, List<PatternMatch>>();
	protected HashSet<PatternMatch> matches = new HashSet<PatternMatch>();
	protected PatternMatchPropertyGetter propertyGetter = new PatternMatchPropertyGetter();
	protected PatternMatchPropertySetter propertySetter = new PatternMatchPropertySetter();
	
	public void addMatch(PatternMatch match) {
		String patternName = match.getPattern().getName();
		List<PatternMatch> matches = matchMap.get(patternName);
		if (matches == null) matches = new ArrayList<PatternMatch>();
		matches.add(match);
		matchMap.put(patternName, matches);
		this.matches.add(match);
	}
	
	@Override
	public void load() throws EolModelLoadingException {

	}

	@Override
	public Object getEnumerationValue(String enumeration, String label)
			throws EolEnumerationValueNotFoundException {
		
		return null;
	}

	@Override
	public Collection<?> allContents() {
		return matches;
	}

	@Override
	public Collection<?> getAllOfType(String type)
			throws EolModelElementTypeNotFoundException {
		return matchMap.get(type);
	}

	@Override
	public Collection<?> getAllOfKind(String type)
			throws EolModelElementTypeNotFoundException {
		return getAllOfType(type);
	}

	@Override
	public Object getTypeOf(Object instance) {
		return PatternMatch.class;
	}

	@Override
	public String getTypeNameOf(Object instance) {
		if (instance instanceof PatternMatch) {
			return ((PatternMatch) instance).getPattern().getName();
		}
		return null;
	}

	@Override
	public Object createInstance(String type)
			throws EolModelElementTypeNotFoundException,
			EolNotInstantiableModelElementTypeException {
		throw new EolNotInstantiableModelElementTypeException(this.name, type);
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
		
	}

	@Override
	public boolean owns(Object instance) {
		return matches.contains(instance);
	}

	@Override
	public boolean isInstantiable(String type) {
		return false;
	}

	@Override
	public boolean isModelElement(Object instance) {
		return owns(instance);
	}

	@Override
	public boolean hasType(String type) {
		return matchMap.keySet().contains(type);
	}

	@Override
	public boolean store(String location) {
		return false;
	}

	@Override
	public boolean store() {
		return false;
	}
	
	@Override
	public IPropertyGetter getPropertyGetter() {
		return propertyGetter;
	}
	
	@Override
	public IPropertySetter getPropertySetter() {
		return propertySetter;
	}

}
