package org.eclipse.epsilon.epl.engine.combinations;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CompositeCombinationGenerator<T> {
	
	protected ArrayList<CombinationGenerator<T>> generators = new ArrayList<CombinationGenerator<T>>();
	protected int currentGeneratorIndex = 0;
	protected Stack<List<T>> currentStack = new Stack<List<T>>();
	protected CompositeCombinationValidator<T> validator = null;
	
	public void setValidator(CompositeCombinationValidator<T> validator) {
		this.validator = validator;
	}

	public void addCombinationGenerator(CombinationGenerator<T> g) {
		generators.add(g);
		reset();
	}
	
	public boolean removeCombinationGenerator(CombinationGenerator<T> g) {
		return generators.remove(g);
	}
	
	public List<List<T>> getNext() {
		while (!getCurrentGenerator().hasMore()) {
			if (isFirstGenerator()) return null;
			else {
				currentStack.pop();
				getCurrentGenerator().reset();
				setCurrentGenerator(getPreviousGenerator());
			}
		}
		
		if (!currentStack.isEmpty()) currentStack.pop();
		currentStack.push(getCurrentGenerator().getNext());
		
		boolean validCombination = isValidCombination();
				
		while (!isLastGenerator() && validCombination) {
			setCurrentGenerator(getNextGenerator());
			currentStack.push(getCurrentGenerator().getNext());
			validCombination = isValidCombination();
		}
		
		if (validCombination) {
			return currentStack;
		}
		else {
			return getNext();
		}
	}
	
	public void reset() {
		for (CombinationGenerator<T> g : generators) {
			g.reset();
		}
		if (!generators.isEmpty()) {
			currentGeneratorIndex = 0;
		}
	}
	
	protected boolean isValidCombination() {
		if (validator == null) {
			return true;
		}
		else {
			return validator.isValid(currentStack);
		}
	}
	
	protected CombinationGenerator<T> getPreviousGenerator() {
		if (currentGeneratorIndex == 0) return null;
		else return generators.get(currentGeneratorIndex - 1); 
	}
	
	protected CombinationGenerator<T> getNextGenerator() {
		if (currentGeneratorIndex == generators.size()-1) return null;
		else return generators.get(currentGeneratorIndex + 1);
	}
	
	protected CombinationGenerator<T> getCurrentGenerator() {
		return generators.get(currentGeneratorIndex);
	}
	
	protected void setCurrentGenerator(CombinationGenerator<T> g) {
		currentGeneratorIndex = generators.indexOf(g);
	}
	
	protected boolean isFirstGenerator() {
		return getPreviousGenerator() == null;
	}
	
	protected boolean isLastGenerator() {
		return getNextGenerator() == null;
	}
	
}
