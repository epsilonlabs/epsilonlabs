package org.eclipse.epsilon.epl.combinations;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CompositeCombinationGenerator<T> {
	
	protected ArrayList<CombinationGenerator<T>> generators = new ArrayList<CombinationGenerator<T>>();
	protected int currentGeneratorIndex = 0;
	protected Stack<List<T>> currentStack = new Stack<List<T>>();
	protected CompositeCombinationValidator<T> validator = null;
	
	public static void main(String[] args) {
		
		CompositeCombinationGenerator<String> ccg = new CompositeCombinationGenerator<String>();
		FixedCombinationGenerator<String> f1 = new FixedCombinationGenerator<String>(createList("a", "b"), 1);
		FixedCombinationGenerator<String> f2 = new FixedCombinationGenerator<String>(createList("a"), 2);
		ccg.addCombinationGenerator(f1);
		ccg.addCombinationGenerator(f2);
		
		List<List<String>> next = ccg.getNext();
		ccg.setValidator(new CompositeCombinationValidator<String>() {
			
			@Override
			public boolean isValid(List<List<String>> combination) {
				System.err.println("Boo");
				return true;
			}
		});
		
		while (next != null) {
			System.out.println(next);
			next = ccg.getNext();
		}
	}
	
	public static List<String> createList(String... strings) {
		ArrayList<String> list = new ArrayList<String>();
		for (String str : strings) {
			list.add(str);
		}
		return list;
	}
	
	public void setValidator(CompositeCombinationValidator<T> validator) {
		this.validator = validator;
	}

	public void addCombinationGenerator(CombinationGenerator<T> g) {
		generators.add(g);
		reset();
	}
	
	public boolean removeCombinationGenerator(CombinationGenerator<T> g) {
		boolean removed = generators.remove(g);
		reset();
		return removed;
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
		
		for (List<T> t : currentStack) {
			if (t == null) return false;
		}
		
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
