package org.eclipse.epsilon.epl.combinations;

import java.util.ArrayList;
import java.util.List;

public class DynamicListCombinationGenerator<T> implements CombinationGenerator<T>{
	
	protected int n;
	protected List<T> list = null;
	protected ListCombinationGenerator<T> listCombinationGenerator = null;
	protected ArrayList<CombinationGeneratorListener<T>> listeners = new ArrayList<CombinationGeneratorListener<T>>();
	
	public void addListener(CombinationGeneratorListener<T> listener) {
		listeners.add(listener);
	}
	
	public void removeListener(CombinationGeneratorListener<T> listener) {
		listeners.remove(listener);
	}
	
	public DynamicListCombinationGenerator(List<T> list, int n) {
		init(list, n);
	}
	
	protected void init(List<T> list, int n) {
		this.list = list;
		this.n = n;
		
		if (list instanceof DynamicList<?>) {
			((DynamicList<T>) list).addListener(new DynamicListListener<T>() {
				@Override
				public void valuesChanged(DynamicList<T> list) {
					createCombinationGenerator();
				}
			});
		}
		else {
			createCombinationGenerator();
		}
		
	}
	
	protected void createCombinationGenerator() {
		listCombinationGenerator = new ListCombinationGenerator<T>(list, n);		
	}
	
	public void reset() {
		if (listCombinationGenerator != null) listCombinationGenerator.reset();
		if (list instanceof DynamicList<?>) ((DynamicList<T>) list).reset();
		for (CombinationGeneratorListener<T> listener : listeners) {
			listener.reset();
		}
	}
	
	@Override
	public boolean hasMore() {
		nudgeList();
		return listCombinationGenerator.hasMore();
	}

	@Override
	public List<T> getNext() {
		nudgeList();
		List<T> next = listCombinationGenerator.getNext();
		
		for (CombinationGeneratorListener<T> listener : listeners) {
			listener.generated(next);
		}
		
		return next;
	}
	
	/**
	 * Nudge the list so that it loads
	 * its contents if it's dynamic
	 */
	protected void nudgeList() {
		list.size();
	}

}
