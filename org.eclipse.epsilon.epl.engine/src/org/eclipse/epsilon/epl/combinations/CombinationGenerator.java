package org.eclipse.epsilon.epl.combinations;

import java.util.List;

public interface CombinationGenerator<T> {
	
	public boolean hasMore();
	
	public List<T> getNext();
	
	public void reset();
}
