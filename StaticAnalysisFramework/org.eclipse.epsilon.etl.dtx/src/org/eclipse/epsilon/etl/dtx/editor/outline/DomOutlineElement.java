package org.eclipse.epsilon.etl.dtx.editor.outline;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;

public class DomOutlineElement implements IPropertySource{
	
	protected EOLElement domElement = null;
	
	public DomOutlineElement(EOLElement domElement) {
		this.domElement = domElement;
	}
	
	public EOLElement getDomElement() {
		return domElement;
	}

	@Override
	public Object getEditableValue() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public IPropertyDescriptor[] getPropertyDescriptors() {
		List<IPropertyDescriptor> propertyDescriptors = new ArrayList<IPropertyDescriptor>();
		for (EStructuralFeature sf : domElement.eClass().getEAllStructuralFeatures()) {
			propertyDescriptors.add(new PropertyDescriptor(sf.getName(), sf.getName()));
		}
		return propertyDescriptors.toArray(new IPropertyDescriptor[]{});
		
	}

	@Override
	public Object getPropertyValue(Object id) {
		Object value = domElement.eGet(domElement.eClass().getEStructuralFeature(id + ""));
		String propertyValue = "";
		if (value instanceof List<?>) {
			ListIterator<?> iterator = ((List<?>) value).listIterator();
			while (iterator.hasNext()) {
				propertyValue = propertyValue + getLabel(iterator.next());
				if (iterator.hasNext()) propertyValue = propertyValue + ", ";
			}
		}
		else {
			propertyValue = getLabel(value);
		}
		return propertyValue;
	}

	@Override
	public boolean isPropertySet(Object id) {
		return true;
	}

	@Override
	public void resetPropertyValue(Object id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPropertyValue(Object id, Object value) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		return getLabel(domElement);
	}
	
	protected String getLabel(Object o) {
		if (o instanceof EOLElement) {
			EOLElement domElement = (EOLElement) o;
			return domElement.eClass().getName() /*+ " (" + domElement.getLine() + "," + domElement.getColumn() + ")"*/;
		}
		else {
			return o + "";
		}
		
	}
	
}
