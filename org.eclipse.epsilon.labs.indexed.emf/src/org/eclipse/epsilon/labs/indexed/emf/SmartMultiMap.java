package org.eclipse.epsilon.labs.indexed.emf;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SmartMultiMap<K, V> {

	private final Map<K, Collection<V>> storage = new HashMap<K, Collection<V>>();
	
	public Collection<V> get(K key) {
		return new HashSet<V>(valueStoreFor(key));
	}

	public void put(K key, V value) {
		if (!storage.containsKey(key)) {
			storage.put(key, new HashSet<V>());
		}
		
		storage.get(key).add(value);
	}

	public void putAll(K key, Iterable<? extends V> values) {
		for (V element : values) {
			put(key, element);
		}		
	}

	public void remove(K key, V value) {
		valueStoreFor(key).remove(value);
	}

	public void clear() {
		storage.clear();
	}

	public boolean containsKey(K key) {
		return !(valueStoreFor(key).isEmpty());
	}

	public void replaceValues(K key, Iterable<? extends V> newValues) {
		removeAll(key);
		putAll(key, newValues);
	}

	private void removeAll(K key) {
		valueStoreFor(key).clear();
	}

	private Collection<V> valueStoreFor(K key) {
		return storage.containsKey(key) ? storage.get(key) : Collections.<V>emptyList();
	}
	
	@Override
	public String toString() {
		return storage.toString();
	}
}
