/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.argouml;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

import javax.jmi.reflect.RefObject;
import javax.jmi.reflect.RefPackage;
import javax.jmi.xmi.MalformedXMIException;

import org.netbeans.api.xmi.XMIInputConfig;
import org.netbeans.api.xmi.XMIReferenceProvider;
import org.netbeans.api.xmi.XMIReferenceResolver;

public class MdrIdManager implements XMIReferenceResolver, XMIReferenceProvider{
	
	HashMap cache = new HashMap();
	HashMap reverseCache = new HashMap();
	
	public void register(String resource, String xmiId, RefObject refObject) {
		XMIReference reference = new XMIReference(null, xmiId);
		cache.put(refObject, reference);
		reverseCache.put(xmiId, refObject);
	}

	public void resolve(Client arg0, RefPackage arg1, String arg2, XMIInputConfig arg3, Collection arg4) throws MalformedXMIException, IOException {
		
	}
	
	public XMIReference getReference(RefObject refObject) {
		XMIReference reference = (XMIReference) cache.get(refObject);
		return reference;
	}
	
	public String newId(){
		return IdFactory.createId();
	}
	
	public void clear(){
		cache.clear();
		reverseCache.clear();
	}
	
	public String getId(RefObject refObject){
		XMIReference reference = getReference(refObject);
		return reference.getXmiId();
	}
	
	public Object getById(String id){
		return reverseCache.get(id);
	}
}
