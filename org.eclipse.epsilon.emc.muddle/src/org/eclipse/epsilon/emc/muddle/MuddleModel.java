package org.eclipse.epsilon.emc.muddle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.models.Model;

public class MuddleModel extends Model {

	protected Muddle muddle;
	@Override
	public Collection<?> allContents() {
		return muddle.getElements();
	}

	@Override
	public Object createInstance(String t)
			throws EolModelElementTypeNotFoundException,
			EolNotInstantiableModelElementTypeException {
		
		MuddleElementType type = muddleElementTypeForName(t);
		
		if (type == null) {
			type = MuddleFactory.eINSTANCE.createMuddleElementType();
			type.setName(t);
			muddle.getTypes().add(type);
		}
		
		MuddleElement element = MuddleFactory.eINSTANCE.createMuddleElement();
		element.setType(type);
		muddle.getElements().add(element);
		
		return element;
	}

	@Override
	public void deleteElement(Object o) throws EolRuntimeException {
		muddle.getElements().remove(o);
	}

	@Override
	public Collection<?> getAllOfKind(String type)
			throws EolModelElementTypeNotFoundException {
		
		ArrayList<MuddleElement> elements = new ArrayList<MuddleElement>();
		for (MuddleElementType elementType : getAllSubTypes(muddleElementTypeForName(type))) {
			elements.addAll(elementType.getInstances());
		}
		return elements;
	}
	
	protected Set<MuddleElementType> getAllSubTypes(MuddleElementType elementType) {
		HashSet<MuddleElementType> allSubTypes = new HashSet<MuddleElementType>();
		collectAllSubTypes(elementType, allSubTypes);
		return allSubTypes;
	}
	
	protected void collectAllSubTypes(MuddleElementType elementType, Set<MuddleElementType> allSubTypes) {
		if (!allSubTypes.contains(elementType)) {
			allSubTypes.add(elementType);
			for (MuddleElementType subType : elementType.getSubTypes()) {
				collectAllSubTypes(subType, allSubTypes);
			}
		}
	}
	
	@Override
	public Collection<?> getAllOfType(String type)
			throws EolModelElementTypeNotFoundException {
		return muddleElementTypeForName(type).getInstances();
	}

	@Override
	public Object getElementById(String id) {
		for (MuddleElement element : muddle.getElements()) {
			if (element.getId().equals(id)) return element;
		}
		return null;
	}

	@Override
	public String getElementId(Object o) {
		return ((MuddleElement) o).getId();
	}

	@Override
	public Object getEnumerationValue(String arg0, String arg1)
			throws EolEnumerationValueNotFoundException {
		return null;
	}

	@Override
	public String getTypeNameOf(Object o) {
		return ((MuddleElement) o).getType().getName();
	}

	@Override
	public boolean hasType(String type) {
		return muddleElementTypeForName(type) != null;
	}

	@Override
	public boolean isInstantiable(String type) {
		return true;
	}

	@Override
	public boolean owns(Object o) {
		return muddle.getElements().contains(o);
	}

	@Override
	public void setElementId(Object o, String id) {
		((MuddleElement) o).setId(id);
	}

	@Override
	public boolean store() {
		return false;
	}

	@Override
	public boolean store(String arg0) {
		return false;
	}
	
	protected MuddleElementType muddleElementTypeForName(String name) {
		for (Type type : muddle.getTypes()) {
			if (type instanceof MuddleElementType && type.getName().equals(name)) {
				return (MuddleElementType) type;
			}
		}
		return null;
	}
	
	public void setGraph(Muddle muddle) {
		this.muddle = muddle;
	}
	
	protected MuddleModelPropertyGetter propertyGetter = new MuddleModelPropertyGetter();
	
	@Override
	public IPropertyGetter getPropertyGetter() {
		return propertyGetter;
	}

	@Override
	public void load() throws EolModelLoadingException {
		
	}
	
}
