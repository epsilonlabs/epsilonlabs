package org.eclipse.epsilon.emc.argouml;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.jmi.model.MofClass;
import javax.jmi.model.MofPackage;
import javax.jmi.reflect.RefClass;
import javax.jmi.reflect.RefEnum;
import javax.jmi.reflect.RefObject;
import javax.jmi.reflect.RefPackage;

import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotAnEnumerationValueException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IReflectivePropertySetter;
import org.eclipse.epsilon.eol.models.IReflectiveModel;
import org.eclipse.epsilon.eol.models.Model;

public abstract class AbstractMdrModel extends Model implements IReflectiveModel {
	
	protected boolean cacheElements = true;
	protected MdrIdManager idManager = new MdrIdManager();
	
	public abstract RefPackage getRefPackage();
	
	protected Collection allInstances;
	public Collection allContents() {
		
		if (allInstances == null){
			allInstances = new ArrayList();
			Collection metaClasses = getAllClasses(true);
			Iterator it = metaClasses.iterator();
			while (it.hasNext()){
				String metaClass = it.next().toString();
				Collection instances = null;
				try {
					instances = getAllOfType(metaClass);
				} catch (EolModelElementTypeNotFoundException e) {
					// Not going to happen
				}
				allInstances.addAll(instances);
			}
		}
		return allInstances;
	}
	
	public Collection getAllClasses(boolean onlyConcrete){
		return getAllClassesImpl(getRefPackage(), onlyConcrete);
	}

	private Collection getAllClassesImpl(RefPackage refPackage, boolean onlyConcrete){
		TreeSet allClasses = new TreeSet();
		
		Iterator it = refPackage.refAllClasses().iterator();
		
		while (it.hasNext()){
			MofClass mofClass = (MofClass) ((RefClass)it.next()).refMetaObject();
			
			if (onlyConcrete){
				if (!mofClass.isAbstract()){
					allClasses.add(mofClass.getName());
				}
			}
			else {
				allClasses.add(mofClass.getName());
			}
		}
		
		it = refPackage.refAllPackages().iterator();
		
		while (it.hasNext()){
			allClasses.addAll(getAllClassesImpl((RefPackage)it.next(), onlyConcrete));
		}
		return allClasses;		
	}
	
	private TreeMap allOfTypeCache = new TreeMap();
	public Collection getAllOfType(String type) throws EolModelElementTypeNotFoundException{
		if (!cacheElements) return allInstances(type,false);
		Collection allOfType = (Collection) allOfTypeCache.get(type);
		if (allOfType == null){
			allOfType = allInstances(type, false);
			allOfTypeCache.put(type,allOfType);
		}
		return allOfType;
	}
	
	private TreeMap allOfKindCache = new TreeMap();
	public Collection getAllOfKind(String type) throws EolModelElementTypeNotFoundException{
		if (!cacheElements) return allInstances(type,true);
		Collection allOfKind = (Collection) allOfKindCache.get(type);
		if (allOfKind == null){
			allOfKind = allInstances(type, true);
			allOfKindCache.put(type,allOfKind);
		}
		return allOfKind;
	}
	
	protected Collection allInstances(String type, boolean allOfType) throws EolModelElementTypeNotFoundException{
		RefPackage container = getRefPackage();

		if (container == null) return null;
		
		if (type.indexOf("::") > 0){
			String[] parts = type.split("::");
			
			for (int i=1;i<parts.length - 1; i++){
				Iterator it = container.refAllPackages().iterator();
				boolean found = false;
				while (!found && it.hasNext()){
					RefPackage temp = (RefPackage) it.next();
					if (((MofPackage)temp.refMetaObject()).getName().compareTo(parts[i]) == 0){
						container = temp;
						found = true;
					}
				}
				if (!found) throw new EolModelElementTypeNotFoundException(this.name, type);
			}
			Iterator it = container.refAllClasses().iterator();
			while (it.hasNext()){
				RefClass next = (RefClass) it.next();
				MofClass mofClass = (MofClass) next.refMetaObject();
				if (mofClass.getName().compareTo(parts[parts.length-1]) == 0){
					if (allOfType){
						return next.refAllOfType();
					} else {
						return next.refAllOfClass();
					}
				}
			}
		}
		else {
			RefClass refClass = findMetaClass(type, container);
			if (refClass != null) {
				if (allOfType){
					return refClass.refAllOfType();
				} else {
					return refClass.refAllOfClass();
				}
			}
		}
		
		throw new EolModelElementTypeNotFoundException(this.name, type);
	}

	public Object createInstance(String type) throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException {
		clearCache();
		RefPackage container = getRefPackage();
		
		if (container == null) return null;
		
		RefClass refClass = findMetaClass(type, container);
		RefObject refObject = null;
		
		if (refClass != null) {
			try {
				refObject = refClass.refCreateInstance(new ArrayList());
				idManager.register(null, idManager.newId(), refObject);
			}
			catch (Exception ex){
				throw new EolNotInstantiableModelElementTypeException(this.name, type);
			}
		}
		else {
			throw new EolModelElementTypeNotFoundException(this.name, type);
		}
		return refObject;
	}
	
	public String getClassOf(Object instance){
		if (instance instanceof RefObject){
			MofClass mofClass = ((MofClass) ((RefObject) instance).refMetaObject());
			return mofClass.getName();
		}
		return null;
	}
	
	public boolean owns(Object instance){
		
		if (instance instanceof RefObject){
			RefObject refObject = (RefObject) instance;
			return (refObject.refOutermostPackage() == getRefPackage());
		}
		return false;
		
		//return allInstances().contains(instance);
	}
	
	public Object getEnumerationValue(String enumeration, String label) throws EolEnumerationValueNotFoundException{
		Object value = findEnumerationValue(enumeration,label, getRefPackage());
		if (value == null) {
			throw new EolEnumerationValueNotFoundException(enumeration,label,this.getName());
		}
		else {
			return value;
		}
	}
	
	public Object findEnumerationValue(String enumeration, String label, RefPackage pkg){
		Object enumerationValue = null;
		
		try {
			enumerationValue = pkg.refGetEnum(enumeration, label);
		}
		catch (Exception ex){
			//Ignore the exception
		}
		if (enumerationValue == null){
			Iterator it = pkg.refAllPackages().iterator();
			while (it.hasNext()){
				RefPackage refPackage = (RefPackage) it.next();
				Object o = findEnumerationValue(enumeration, label, refPackage);
				if (o != null){
					return o;
				}
			}
		}
		else {
			return enumerationValue;
		}
		return null;
	}
	
	public RefClass findMetaClass(String type, RefPackage pkg){
		Iterator it = pkg.refAllClasses().iterator();

		while (it.hasNext()){
			RefClass refClass = (RefClass) it.next();
			MofClass mofClass = (MofClass) refClass.refMetaObject();
			if (mofClass.getName().compareTo(type) == 0){
				return refClass;
			}
		}
		it = pkg.refAllPackages().iterator();
		while (it.hasNext()){
			RefClass refClass = findMetaClass(type, (RefPackage) it.next());
			if (refClass != null) return refClass;
		}
		return null;
	}
	
	public void deleteElement(Object instance) {
		if (instance instanceof RefObject) {
			clearCache();
			RefObject refObject = (RefObject) instance;
			refObject.refDelete();
		}
	}
	
	@Override
	public void dispose(){
		super.dispose();
		clearCache();
		idManager.clear();
		this.allOfKindCache = null;
		this.allOfTypeCache = null;
	}
	
	public Collection getAllSupertypes(String type){
		
		RefClass refClass = findMetaClass(type, getRefPackage());
		
		if (refClass == null) return null;
		
		ArrayList allSupertypes = new ArrayList();
		MofClass mofClass = (MofClass) refClass.refMetaObject();
		Iterator it = mofClass.allSupertypes().iterator();
		
		while (it.hasNext()){
			MofClass supertype = (MofClass) it.next();
			RefClass superTypeRefClass = findMetaClass(supertype.getName(), getRefPackage());
			if (!allSupertypes.contains(superTypeRefClass))
				allSupertypes.add(superTypeRefClass);
		}
		
		allSupertypes.add(0, refClass); // Add the refClass itself
		
		return allSupertypes;
	}
	
	public Collection getAllSubtypes(String type){
		RefClass refClass = findMetaClass(type, getRefPackage());
		Collection allRefClasses = allRefClasses(getRefPackage());
		ArrayList allSubtypes = new ArrayList();
		
		Iterator it = allRefClasses.iterator();
		while (it.hasNext()){
			RefClass subtype = (RefClass) it.next();
			
			MofClass mofClass = ((MofClass) subtype.refMetaObject());
			List supertypes = mofClass.allSupertypes();
			if (supertypes.contains(refClass.refMetaObject())){
				if (!((MofClass) subtype.refMetaObject()).isAbstract()){
					if (!(allSubtypes.contains(subtype)))
						allSubtypes.add(subtype);
				}
			}
		}
		allSubtypes.add(0, refClass);
		return allSubtypes;
	}

	protected Collection allRefClasses(RefPackage pkg){
		ArrayList allRefClasses = new ArrayList();
		Iterator it = pkg.refAllClasses().iterator();
		while (it.hasNext()){
			allRefClasses.add(it.next());
		}
		it = pkg.refAllPackages().iterator();
		while (it.hasNext()){
			allRefClasses.addAll(allRefClasses((RefPackage) it.next()));
		}
		return allRefClasses;
	}
		
	private String convertToUri(String fileName){
		try {
			return new File(fileName).toURL().toString();
		} catch (MalformedURLException e) {
			// Ignore
		}
		return "";
	}

	public Object getElementById(String id) {
		return idManager.getById(id);
	}
	
	public void setElementId(Object instance, String newId) {
		throw new UnsupportedOperationException();
	}

	public String getElementId(Object instance) {
		return idManager.getId((RefObject) instance);
	}

	public Object getTypeOf(Object instance) {
		return ((RefObject) instance).refMetaObject();
	}

	public boolean isInstantiable(String type) {
		RefClass refClass = findMetaClass(type, getRefPackage());
		if (refClass!=null) {
			MofClass mofClass = (MofClass) refClass.refMetaObject();
			return !mofClass.isAbstract();
		}
		return false;
	}

	public boolean hasType(String type) {
		RefClass refClass = findMetaClass(type, getRefPackage());
		return refClass!=null;
	}
	
	protected void clearCache(){
		allOfTypeCache.clear();
		allOfKindCache.clear();
		allInstances = null;
	}
	
	@Override
	public IPropertyGetter getPropertyGetter() {
		return new MdrPropertyGetter();
	}
	
	@Override
	public IReflectivePropertySetter getPropertySetter() {
		return new MdrPropertySetter();
	}

	public boolean isModelElement(Object instance) {
		return instance instanceof RefObject;
	}

	public String getTypeNameOf(Object instance) {
		return ((MofClass)getTypeOf(instance)).getName();
	}

	public Collection<String> getPropertiesOf(String type) throws EolModelElementTypeNotFoundException {
		final RefClass metaclassRef = findMetaClass(type, getRefPackage());
		
		if (metaclassRef==null) {
			return Collections.emptySet();
		}
		
		final MofClass metaclass = (MofClass)metaclassRef.refMetaObject();
		
		return MdrUtil.getStructuralFeatures(metaclass);
	}

	@Override
	public boolean preventLoadingOfExternalModelElements() {
		return false;
	}

	@Override
	public Object getContainerOf(Object object) {
		return ((RefObject) object).refImmediateComposite();
	}

	
	@Override
	public boolean isEnumerationValue(Object object) {
		return object instanceof RefEnum;
	}

	//FIXME: Not implemented
	@Override
	public boolean hasProperty(String type, String property)
			throws EolModelElementTypeNotFoundException {
		return false;
	}

	//FIXME: Not implemented
	@Override
	public String getEnumerationTypeOf(Object literal)
			throws EolNotAnEnumerationValueException {
		return null;
	}

	//FIXME: Not implemented
	@Override
	public String getEnumerationLabelOf(Object literal)
			throws EolNotAnEnumerationValueException {
		// TODO Auto-generated method stub
		return null;
	}

	//FIXME: Not implemented
	@Override
	public boolean hasPackage(String packageName) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void setCacheElements(boolean cacheElements) {
		this.cacheElements = cacheElements;
	}
	
	public boolean isCacheElements() {
		return cacheElements;
	}
}
