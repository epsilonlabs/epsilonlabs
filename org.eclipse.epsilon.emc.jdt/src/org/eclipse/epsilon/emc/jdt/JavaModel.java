package org.eclipse.epsilon.emc.jdt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.models.Model;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;

public class JavaModel extends Model {
	
	protected HashSet<Object> contents = new HashSet<Object>();
	protected HashMap<Class<?>, List<Object>> classObjectMap = new HashMap<Class<?>, List<Object>>();
	protected HashMap<String, Class<?>> classNameMap = new HashMap<String, Class<?>>();
	
	public void addObject(Object o) {
		if (o == null) return;
		contents.add(o);
		addObject(o, o.getClass());
	}
	
	protected void addObject(Object o, Class<?> asType) {
		
		if (asType == Object.class) return;
		
		if (!classObjectMap.containsKey(asType)) {
			addClass(asType);
		}
		classObjectMap.get(asType).add(o);
		
		if (asType.getSuperclass() != null) {
			addObject(o, asType.getSuperclass());
		}
		for (Class<?> interfaze : asType.getInterfaces()) {
			addObject(o, interfaze);
		}
	}
	
	public void addClasses(Class<?>... classes) {
		for (Class<?> clazz : classes) {
			addClass(clazz);
		}
	}
	
	public void addClass(Class<?> clazz) {
		if (!classObjectMap.containsKey(clazz)) {
			classObjectMap.put(clazz, new ArrayList<Object>());
			classNameMap.put(clazz.getSimpleName(), clazz);
		}
	}
	
	@Override
	public void load() throws EolModelLoadingException {
		
	}

	@Override
	public Object getEnumerationValue(String enumeration, String label)
			throws EolEnumerationValueNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<?> allContents() {
		return contents;
	}
	
	
	@Override
	public Collection<?> getAllOfType(String type)
			throws EolModelElementTypeNotFoundException {
		return classObjectMap.get(classNameMap.get(type));
	}

	@Override
	public Collection<?> getAllOfKind(String type)
			throws EolModelElementTypeNotFoundException {
		return getAllOfType(type);
	}

	@Override
	public Object getTypeOf(Object instance) {
		return instance.getClass();
	}

	@Override
	public String getTypeNameOf(Object instance) {
		return instance.getClass().getSimpleName();
	}

	@Override
	public Object createInstance(String type)
			throws EolModelElementTypeNotFoundException,
			EolNotInstantiableModelElementTypeException {
		return null;
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
		return contents.contains(instance);
	}

	@Override
	public boolean isInstantiable(String type) {
		return false;
	}

	@Override
	public boolean isModelElement(Object instance) {
		return true;
	}

	@Override
	public boolean hasType(String type) {
		return classNameMap.containsKey(type);
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
