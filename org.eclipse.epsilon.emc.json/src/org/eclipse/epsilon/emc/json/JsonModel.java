/*******************************************************************************
 * Copyright (c) 2013 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.json;

import java.util.Collection;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.models.CachedModel;
import org.eclipse.epsilon.eol.models.IModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class JsonModel extends CachedModel<Object> implements IModel {

	private JSONObject root;

	public void setJson(String json) {
		root = (JSONObject) JSONValue.parse(json);
	}

	@Override
	public Object getEnumerationValue(String enumeration, String label)
			throws EolEnumerationValueNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getTypeOf(Object instance) {
		// TODO Auto-generated method stub
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
		return instance instanceof JSONArray || instance instanceof JSONObject; // FIXME
	}

	@Override
	public boolean isInstantiable(String type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasType(String type) {
		return root.containsKey(getRealTypeName(type));
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
	public IPropertyGetter getPropertyGetter() {
		return new JsonPropertyGetter();
	}

	@Override
	public IPropertySetter getPropertySetter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Collection<? extends String> allContentsFromModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Collection<? extends String> getAllOfTypeFromModel(String type)
			throws EolModelElementTypeNotFoundException {
		return (JSONArray) root.get(getRealTypeName(type));
	}

	@Override
	protected Collection<? extends Object> getAllOfKindFromModel(String kind)
			throws EolModelElementTypeNotFoundException {
		return getAllOfType(kind);
	}

	@Override
	protected String createInstanceInModel(String type)
			throws EolModelElementTypeNotFoundException,
			EolNotInstantiableModelElementTypeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void loadModel() throws EolModelLoadingException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void disposeModel() {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean deleteElementInModel(Object instance)
			throws EolRuntimeException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Object getCacheKeyForType(String type)
			throws EolModelElementTypeNotFoundException {
		return type;
	}

	@Override
	protected Collection<String> getAllTypeNamesOf(Object instance) {
		// TODO Auto-generated method stub
		return null;
	}

	private String getRealTypeName(String type) {
		// strips off the t_
		return type.substring(2);
	}
}
