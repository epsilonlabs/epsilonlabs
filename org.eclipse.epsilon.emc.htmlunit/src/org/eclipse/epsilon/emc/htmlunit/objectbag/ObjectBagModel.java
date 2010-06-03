package org.eclipse.epsilon.emc.htmlunit.objectbag;

import java.util.*;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.models.Model;

public abstract class ObjectBagModel extends Model {
	
	protected Collection<Object> bag = new ArrayList<Object>();
	protected INameEncoder classNameEncoder = new DefaultNameEncoder();
	protected HashMap<String, List<Object>> allOfTypeCache = new HashMap<String, List<Object>>();
	protected HashMap<String, List<Object>> allOfKindCache = new HashMap<String, List<Object>>();
	
	@Override
	public Collection<?> allContents() {
		return bag;
	}

	@Override
	public Object createInstance(String type)
			throws EolModelElementTypeNotFoundException,
			EolNotInstantiableModelElementTypeException {
		
		// TODO Readonly for now
		return null;
		
	}

	@Override
	public void deleteElement(Object instance) throws EolRuntimeException {
		// TODO Readonly for now
	}

	@Override
	public Collection<?> getAllOfKind(String type)
			throws EolModelElementTypeNotFoundException {
		return getAllOfType(type);
	}

	@Override
	public Collection<?> getAllOfType(String type)
			throws EolModelElementTypeNotFoundException {
		
		if (allOfTypeCache.containsKey(type)) {
			return allOfKindCache.get(type);
		}
		
		List<Object> allOfType = new ArrayList<Object>();
		
		for (Object o : bag) {
			String className = o.getClass().getSimpleName();
			if (className.equals(type) || className.equals(classNameEncoder.decode(type))) {
				allOfType.add(o);
			}
		}
		
		allOfTypeCache.put(type, allOfType);
		
		return allOfType;
		
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
	public Object getEnumerationValue(String enumeration, String label)
			throws EolEnumerationValueNotFoundException {
		return null;
	}

	@Override
	public String getTypeNameOf(Object instance) {
		return classNameEncoder.encode(instance.getClass().getSimpleName());
	}

	@Override
	public Object getTypeOf(Object instance) {
		return instance.getClass();
	}

	@Override
	public boolean hasType(String type) {
		return true;
	}

	@Override
	public boolean isInstantiable(String type) {
		return true;
	}

	@Override
	public boolean isModelElement(Object instance) {
		return owns(instance);
	}

	@Override
	public abstract void load() throws EolModelLoadingException;

	@Override
	public boolean owns(Object instance) {
		return bag.contains(instance);
	}

	@Override
	public boolean store(String location) {
		return false;
	}

	@Override
	public boolean store() {
		return false;
	}

}
