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
//		NCombinationGenerator<String> f1 = new NCombinationGenerator<String>(createList("a1", "a2", "a3", "a4"), 2);
		//FixedCombinationGenerator<String> f2 = new FixedCombinationGenerator<String>(createList("c", "d"), 2);
		//FixedCombinationGenerator<String> f3 = new FixedCombinationGenerator<String>(createList("e"), 1);
		//ccg.addCombinationGenerator(f1);
		//ccg.addCombinationGenerator(f2);
		//ccg.addCombinationGenerator(f3);
		
		
		//ccg.setValidator(new CompositeCombinationValidator<String>() {
			
		//	@Override
		//	public boolean isValid(List<List<String>> combination) {
		//		System.err.println("Checked " + combination);
		///		return combination.size() < 3;
		//	}
		//});
		
		List<List<String>> next = ccg.getNext();
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
	
	List<List<T>> NEXT = new ArrayList<List<T>>();
	
	public List<List<T>> getNext() {
		List<List<T>> next = getNext2();
		while (next == NEXT) {
			next = getNext2();
		}
		return next;
	}
	
	public List<List<T>> getNext2() {
		
		while (!getCurrentGenerator().hasMore()) {
			if (isFirstGenerator()) {
				return null;
			}
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
			//System.err.println(currentStack);
			return currentStack;
		}
		else {
			return NEXT;
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
		//System.err.println("Switching to generator " + currentGeneratorIndex);
		//new Exception().printStackTrace();
	}
	
	protected boolean isFirstGenerator() {
		return getPreviousGenerator() == null;
	}
	
	protected boolean isLastGenerator() {
		return getNextGenerator() == null;
	}
	
}
