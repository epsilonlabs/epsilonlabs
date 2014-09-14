package org.eclipse.epsilon.emc.html;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

import org.eclipse.epsilon.emc.plainxml.PlainXmlType;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.models.CachedModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class HtmlModel extends CachedModel<org.jsoup.nodes.Element> {
	
 	protected Document document;
	protected final String ELEMENT_TYPE = "Element";
	public static String PROPERTY_FILE = "file";
	public static String PROPERTY_URI = "uri";
	protected String uri = null;
	
	public static void main(String[] args) throws Exception {
		EolModule module = new EolModule();
		module.parse("t_div.all.println();");
		HtmlModel model = new HtmlModel();
		model.setName("M");
		model.setUri("http://www.google.com");
		model.load();
		module.getContext().getModelRepository().addModel(model);
		module.execute();
	}

	public String getUri() {
		return uri;
	}
	
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	@Override
	public Object getEnumerationValue(String enumeration, String label)
			throws EolEnumerationValueNotFoundException {
		return null;
	}

	@Override
	public String getTypeNameOf(Object instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getElementById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getElementId(Object instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setElementId(Object instance, String newId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean owns(Object instance) {
		if (instance instanceof Element) {
			return ((Element) instance).ownerDocument() == document;
		}
		else return false;
	}

	@Override
	public boolean isInstantiable(String type) {
		return true;
	}

	@Override
	public boolean hasType(String type) {
		return ELEMENT_TYPE.equals(type) || PlainXmlType.parse(type) != null;
	}

	@Override
	public boolean store(String location) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean store() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Collection<? extends Element> allContentsFromModel() {
		return document.getAllElements();
	}

	@Override
	protected Collection<? extends Element> getAllOfTypeFromModel(String type)
			throws EolModelElementTypeNotFoundException {
		return document.select(PlainXmlType.parse(type).getTagName());
	}

	@Override
	protected Collection<? extends Element> getAllOfKindFromModel(String kind)
			throws EolModelElementTypeNotFoundException {
		return getAllOfTypeFromModel(kind);
	}

	@Override
	protected Element createInstanceInModel(String type)
			throws EolModelElementTypeNotFoundException,
			EolNotInstantiableModelElementTypeException {
		return document.createElement(PlainXmlType.parse(type).getTagName());
	}

	@Override
	protected void loadModel() throws EolModelLoadingException {
		try {
			document = Jsoup.connect(uri).get();
		} catch (IOException e) {
			throw new EolModelLoadingException(e, this);
		}
	}

	@Override
	protected void disposeModel() {}

	@Override
	protected boolean deleteElementInModel(Object instance)
			throws EolRuntimeException {
		((Element) instance).remove();
		return false;
	}

	@Override
	protected Object getCacheKeyForType(String type)
			throws EolModelElementTypeNotFoundException {
		return type;
	}

	@Override
	protected Collection<String> getAllTypeNamesOf(Object instance) {
		return Collections.singleton(getTypeNameOf(instance));
	}
	
	public Document getDocument() {
		return document;
	}
	
	protected HtmlPropertyGetter propertyGetter = new HtmlPropertyGetter();
	
	@Override
	public IPropertyGetter getPropertyGetter() {
		return propertyGetter;
	}

}
