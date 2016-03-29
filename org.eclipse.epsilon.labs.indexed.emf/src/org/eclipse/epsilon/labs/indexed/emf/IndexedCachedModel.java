package org.eclipse.epsilon.labs.indexed.emf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.models.CachedModel;
import org.eclipse.epsilon.eol.models.Model;

public abstract class IndexedCachedModel<ModelElementType> extends Model{
	
	public static final String PROPERTY_CACHED = "cached";
	
	
	protected abstract Collection<? extends ModelElementType> allContentsFromModel();
	protected abstract Collection<? extends ModelElementType> getAllOfTypeFromModel(String type) throws EolModelElementTypeNotFoundException;
	protected abstract Collection<? extends ModelElementType> getAllOfKindFromModel(String kind) throws EolModelElementTypeNotFoundException;
	protected abstract ModelElementType createInstanceInModel(String type) throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException;
	protected abstract void loadModel() throws EolModelLoadingException;
	protected abstract void disposeModel();
	
	/**
	 * Returns true iff the given instance was deleted from the model.
	 */
	protected abstract boolean deleteElementInModel(Object instance) throws EolRuntimeException;
	
	/**
	 * Returns an identity for the given type, 
	 * which will be used by {@link CachedModel}
	 * as a key for the memoization of model elements
	 * by type.
	 * 
	 * @throws EolModelElementTypeNotFoundException
	 */
	protected abstract Object getCacheKeyForType(String type) throws EolModelElementTypeNotFoundException;
	
	/**
	 * Returns the names of every type to which the 
	 * given object conforms. The values are used by
	 * by {@link CachedModel} for the memoization of
	 * model elements by their kind ({@link #getAllOfKind(String)}).
	 */
	protected abstract Collection<String> getAllTypeNamesOf(Object instance);
	
	protected final Collection<ModelElementType> allContentsCache = new ArrayList<ModelElementType>();
	protected boolean allContentsAreCached = false;

	protected final List<Object> cachedTypes = new ArrayList<Object>();
	protected HashMap<Object, OptimisableCollection> typeCache = new HashMap<Object, OptimisableCollection>();

	protected final List<Object> cachedKinds = new ArrayList<Object>();
	protected HashMap<Object, OptimisableCollection> kindCache = new HashMap<Object, OptimisableCollection>();
	
	protected boolean cachingEnabled = true;
	
	public void setCachingEnabled(boolean cachingEnabled) {
		this.cachingEnabled = cachingEnabled;
	}
	
	public boolean isCachingEnabled() {
		return cachingEnabled;
	}
	public final Collection<ModelElementType> allContents() {
		if (!allContentsAreCached || !isCachingEnabled()) {
			allContentsCache.clear();
			allContentsCache.addAll(allContentsFromModel());
			allContentsAreCached = true;
		}
		
		return allContentsCache;
	}
	
	
	public final Collection<ModelElementType> getAllOfType(String type) throws EolModelElementTypeNotFoundException {
		final Object key = getCacheKeyForType(type);

		if (!cachedTypes.contains(key) || !isCachingEnabled()) {
			typeCache.put(key, (OptimisableCollection) getAllOfTypeFromModel(type));
			cachedTypes.add(key);
		}
		
		return (Collection<ModelElementType>) typeCache.get(key);
	}
	
	public final Collection<ModelElementType> getAllOfKind(String kind) throws EolModelElementTypeNotFoundException {
		final Object key = getCacheKeyForType(kind);
		
		if (!cachedKinds.contains(key) || !isCachingEnabled()) {
			kindCache.put(key, (OptimisableCollection) getAllOfKindFromModel(kind));
			cachedKinds.add(key);
		}
		
		return (Collection<ModelElementType>) kindCache.get(key);
	}
	
	public final ModelElementType createInstance(String type) throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException {
		final ModelElementType instance = createInstanceInModel(type);
		
		allContentsCache.add(instance);
		
		Object key = getCacheKeyForType(type);
		
		OptimisableCollection collection = typeCache.get(key);
		if (collection != null) {
			collection.add((EObject) instance);
		}
		else {
			collection = new OptimisableCollection(this, (EClass) key);
			collection.add((EObject) instance);
			
		}
		typeCache.put(key, collection);

		for (String kind : getAllTypeNamesOf(instance)) {
			OptimisableCollection collection2 = kindCache.get(key);
			if (collection2 != null) {
				collection2.add((EObject) instance);
			}
			else {
				collection2 = new OptimisableCollection(this, (EClass) key);
				collection2.add((EObject) instance);
				
			}
			kindCache.put(key, collection);
		}
		
		return instance;
	}
	
	public final void deleteElement(Object o) throws EolRuntimeException {
		if (deleteElementInModel(o)) {
			@SuppressWarnings("unchecked")
			final ModelElementType instance = (ModelElementType)o;
			
			allContentsCache.remove(instance);
			
			typeCache.remove(getCacheKeyForType(getTypeNameOf(instance)), instance);
			
			for (String kind : getAllTypeNamesOf(instance)) {
				kindCache.remove(getCacheKeyForType(kind), instance);
			}
		}
	}
	
	public final void load() throws EolModelLoadingException {
		clearCache();
		loadModel();
	}
	
	@Override
	public void load(StringProperties properties, String basePath) throws EolModelLoadingException {
		super.load(properties, basePath);
		
		this.setCachingEnabled(new Boolean(properties.getProperty(PROPERTY_CACHED)).booleanValue());
	}

	public final void dispose() {
		super.dispose();
		clearCache();
		disposeModel();
	}

	public void clearCache() {
		allContentsCache.clear();
		allContentsAreCached = false;
		
		typeCache.clear();
		cachedTypes.clear();
		
		kindCache.clear();
		cachedKinds.clear();
	}
}
