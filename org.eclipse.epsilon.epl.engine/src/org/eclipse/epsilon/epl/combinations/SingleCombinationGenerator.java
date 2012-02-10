package org.eclipse.epsilon.epl.combinations;

import java.util.ArrayList;
import java.util.List;

public class SingleCombinationGenerator<T> implements CombinationGenerator<T> {
	
	protected T t;
	protected boolean hasMore = true;
	
	public SingleCombinationGenerator(T t) {
		this.t = t;
	}
	
	@Override
	public boolean hasMore() {
		return hasMore;
	}

	@Override
	public List<T> getNext() {
		if (hasMore) {
			ArrayList<T> list = new ArrayList<T>();
			hasMore = false;
			list.add(t);
			return list;
		}
		else {
			return null;
		}
	}

	@Override
	public void reset() {
		hasMore = true;
	}

}
