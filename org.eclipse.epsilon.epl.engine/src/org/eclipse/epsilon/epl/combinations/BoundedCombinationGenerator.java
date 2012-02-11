package org.eclipse.epsilon.epl.combinations;

import java.util.ArrayList;
import java.util.List;

public class BoundedCombinationGenerator<T> implements CombinationGenerator<T>{
	
	protected int lowerBound;
	protected int upperBound;
	protected List<CombinationGenerator<T>> combinationGenerators = new ArrayList<CombinationGenerator<T>>();
	protected List<T> list = null;
	protected CombinationGenerator<T> currentCombinationGenerator = null;
	protected static int UNBOUNDED = -1;
	protected boolean ascending = true;
	protected ArrayList<CombinationGeneratorListener<T>> listeners = new ArrayList<CombinationGeneratorListener<T>>();
	
	
	public void addListener(CombinationGeneratorListener<T> listener) {
		listeners.add(listener);
	}
	
	public void removeListener(CombinationGeneratorListener<T> listener) {
		listeners.remove(listener);
	}
	
	public BoundedCombinationGenerator(List<T> list, int upperBound) {
		init(list, 1, upperBound, true);
	}
	
	public BoundedCombinationGenerator(List<T> list, int lowerBound, int upperBound, boolean ascending) {
		init(list, lowerBound, upperBound, ascending);
	}
	
	protected void init(List<T> list, int lowerBound, int upperBound, boolean ascending) {
		this.list = list;
		this.ascending = ascending;
		this.lowerBound = lowerBound;
		if (upperBound == BoundedCombinationGenerator.UNBOUNDED) upperBound = list.size();
		this.upperBound = upperBound;
		if (isAscending()) {
			for (int i = lowerBound; i<=this.upperBound; i++) {
				combinationGenerators.add(new FixedCombinationGenerator<T>(list, i));
			}
		}
		else {
			for (int i=this.upperBound; i>=lowerBound; i--) {
				combinationGenerators.add(new FixedCombinationGenerator<T>(list, i));
			}
		}
		
		currentCombinationGenerator = combinationGenerators.get(0);
	}
	
	public void reset() {
		for (CombinationGenerator<T> g : combinationGenerators) {
			g.reset();
		}
		currentCombinationGenerator = combinationGenerators.get(0);
		if (list instanceof DynamicList) ((DynamicList) list).reset();
		for (CombinationGeneratorListener<T> listener : listeners) {
			listener.reset();
		}
	}
	
	public boolean isAscending() {
		return ascending;
	}
	
	@Override
	public boolean hasMore() {
		findNextCombinationGenerator();
		return currentCombinationGenerator != null && currentCombinationGenerator.hasMore();
	}

	@Override
	public List<T> getNext() {
		findNextCombinationGenerator();
		List<T> next = null;
		if (currentCombinationGenerator != null) {
			next = currentCombinationGenerator.getNext();
		}
		
		for (CombinationGeneratorListener<T> listener : listeners) {
			listener.generated(next);
		}
		
		return next;
	}
	
	protected void findNextCombinationGenerator() {
		if (currentCombinationGenerator == null) return;
		while (!currentCombinationGenerator.hasMore()) {
			int index = combinationGenerators.indexOf(currentCombinationGenerator);
			if (index < combinationGenerators.size() - 1) {
				currentCombinationGenerator = combinationGenerators.get(index + 1);
			}
			else {
				currentCombinationGenerator = null;
				return;
			}
		}
	}
	

}
