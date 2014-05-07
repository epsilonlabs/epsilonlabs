package org.eclipse.epsilon.etl.dtx.editor.outline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ArrayBlockingQueue;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

public class DomOutlineElement implements IPropertySource{
	
	protected EolElement domElement = null;
	
	public DomOutlineElement(EolElement domElement) {
		this.domElement = domElement;
	}
	
	public EolElement getDomElement() {
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
		if (o instanceof EolElement) {
			EolElement domElement = (EolElement) o;
			return domElement.eClass().getName() /*+ " (" + domElement.getLine() + "," + domElement.getColumn() + ")"*/;
		}
		else {
			return o + "";
		}
		
	}
	
}
