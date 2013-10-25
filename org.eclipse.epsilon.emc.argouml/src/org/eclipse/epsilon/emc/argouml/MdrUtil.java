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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.jmi.model.AliasType;
import javax.jmi.model.Attribute;
import javax.jmi.model.Classifier;
import javax.jmi.model.MofClass;
import javax.jmi.model.MofPackage;
import javax.jmi.model.Reference;
import javax.jmi.model.StructuralFeature;
import javax.jmi.reflect.CompositionViolationException;
import javax.jmi.reflect.InvalidObjectException;
import javax.jmi.reflect.RefClass;
import javax.jmi.reflect.RefObject;
import javax.jmi.reflect.RefPackage;

import org.eclipse.epsilon.eol.execute.operations.contributors.IterableOperationContributor;

public class MdrUtil {

	public static Collection getMetaClassInstances(RefPackage refPackage, String className){
		
		String[] parts = className.split("::");
		
		RefPackage container = refPackage;
		
		for (int i=2;i<parts.length - 1; i++){
			Iterator it = container.refAllPackages().iterator();
			boolean found = false;
			while (!found && it.hasNext()){
				RefPackage temp = (RefPackage) it.next();
				if (((MofPackage)temp.refMetaObject()).getName().compareTo(parts[i]) == 0){
					container = temp;
					found = true;
				}
			}
			if (!found) return null; 
		}
		
		Iterator it = container.refAllClasses().iterator();
		while (it.hasNext()){
			RefClass next = (RefClass) it.next();
			MofClass mofClass = (MofClass) next.refMetaObject();
			if (mofClass.getName().compareTo(parts[parts.length-1]) == 0){
				return next.refAllOfClass();
			}
		}
		
		return null;
	}
	
	public static List<?> getContents(RefObject refObject){
		return getContents((MofClass)refObject.refMetaObject());	
	}

	@SuppressWarnings("unchecked")
	public static List<?> getContents(MofClass metaclass) {
		final List<?> contents = new ArrayList<Object>();
		
		try {
			contents.addAll(metaclass.getContents());
			
			for (Object supertype : metaclass.allSupertypes()) {
				contents.addAll(((MofClass)supertype).getContents());
			}
		} catch (InvalidObjectException ex){
			// The object no longer exists
		}
		
		return contents;
	}
	
	public static Attribute getAttribute(RefObject refObject, String attributeName){
		Iterator it = MdrUtil.getContents(refObject).iterator();
		while (it.hasNext()){
			Object next = it.next();
			if (next instanceof Attribute){
				Attribute attribute = (Attribute) next;
				if (attribute.getName().compareTo(attributeName) == 0){
					return attribute;
				}
			}
		}
		return null;
	}
	
	public static boolean isMany(StructuralFeature feature) {
		return feature.getMultiplicity().getUpper() == -1 || feature.getMultiplicity().getUpper() > 1;
	}
	
	public static List<String> getStructuralFeatures(MofClass metaclass) {
		final List<String> structuralFeatures = new LinkedList<String>();
		
		for (Object content : getContents(metaclass)) {
			if (content instanceof StructuralFeature){
				final StructuralFeature sf = (StructuralFeature)content;
				structuralFeatures.add(sf.getName());
			}
		}
		
		return structuralFeatures;
	}
	
	public static StructuralFeature getStructuralFeature(RefObject refObject, String structuralFeatureName){
		Iterator it = MdrUtil.getContents(refObject).iterator();
		while (it.hasNext()){
			Object next = it.next();
			if (next instanceof StructuralFeature){
				StructuralFeature structuralFeature = (StructuralFeature) next;
				if (structuralFeature.getName().compareTo(structuralFeatureName) == 0){
					return structuralFeature;
				}
			}
		}
		return null;
	}	
	
	public static Reference getReference(RefObject refObject, String referenceName){
		Iterator it = MdrUtil.getContents(refObject).iterator();
		while (it.hasNext()){
			Object next = it.next();
			if (next instanceof Reference){
				Reference reference = (Reference) next;
				if (reference.getName().compareTo(referenceName) == 0){
					return reference;
				}
			}
		}
		return null;
	}
	
	/*
	public static void setCollectionValues(Collection source, Collection target){
		
		Collection removed = new ArrayList();
		
		Iterator tit = target.iterator();
		while (tit.hasNext()){
			removed.add(tit.next());
		}
		
		Iterator rit = removed.iterator();
		while (rit.hasNext()){
			target.remove(rit.next());
		}
		
		Iterator sit = source.iterator();
		while (sit.hasNext()){
			Object next = sit.next();
			if (next!=null)
			target.add(next);
		}
		
	}
	*/
	
	public static void setCollectionValues(Collection source, Collection target){
		
		source = new IterableOperationContributor(source).flatten();
		
		Iterator tit = target.iterator();
		ArrayList removed = new ArrayList();
		
		while (tit.hasNext()){
			Object next = tit.next();
			if (!source.contains(next)){
				removed.add(next);
			}
		}
		
		ListIterator rit = removed.listIterator();
		while (rit.hasNext()){
			source.remove(rit.next());
		}
		
		Iterator sit = source.iterator();
		
		while (sit.hasNext()){
			Object next = sit.next();
			if (next!=null && !target.contains(next)){
				try {
					//target.add(next);
					//TODO: Go over this quick-fix
					target.add(next);
				}
				catch (CompositionViolationException cvex){
					source.remove(next);
					target.add(next);
				}
				//TODO: Revisit this exception
				catch (Exception ex){
					ex.printStackTrace();
				}
			}
		}
		
	}

	public static String refObjectToString(Object o){
		String str = "Object not a RefObject";
		if (o instanceof RefObject){
			RefObject refObject = (RefObject) o;
			
			MofClass mofClass = (MofClass) refObject.refMetaObject();
			
			str = mofClass.getName();
			
			ListIterator li = MdrUtil.getContents(refObject).listIterator();
			
			str += " ( ";
			
			while (li.hasNext()){
				Object next = li.next();
				if (next instanceof Attribute){
					Attribute attribute = (Attribute) next;
					str += attribute.getName();
					str += "='";
					try {
					str += refObject.refGetValue(attribute);
					}
					catch (Exception ex){
						str += "!!!Exception!!!";
					}
					str += "' ";
				}
			}
			
			str += ")";
		}
		return str;
	}
	
	public static Classifier getNonAliasedType(Classifier classifier){
		
		if (classifier instanceof AliasType){
			AliasType aliasType = (AliasType) classifier;
			return getNonAliasedType(aliasType.getType());
		}
		return classifier;
	}
	
	public static String createStorageId(){
		return "Storage" + System.currentTimeMillis() * Math.random();
	}
	
	public static boolean contains(Collection col, Object o){
		Iterator it = col.iterator();
		while (it.hasNext()){
			if (it.next() == o) return true;
		}
		return false;
	}
	
}
