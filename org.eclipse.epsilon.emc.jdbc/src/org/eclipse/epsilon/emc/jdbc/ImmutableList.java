package org.eclipse.epsilon.emc.jdbc;

import java.util.Collection;
import java.util.List;

public abstract class ImmutableList<T> implements List<T>{

	@Override
	public boolean add(T arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(Collection<? extends T> arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(int arg0, T arg1) {
		throw new UnsupportedOperationException();		
	}
	
	@Override
	public boolean addAll(int arg0, Collection<? extends T> arg1) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public T remove(int arg0) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public T set(int arg0, T arg1) {
		throw new UnsupportedOperationException();
	}
	
}
