package org.eclipse.epsilon.epl.combinations;

import java.util.ArrayList;
import java.util.List;


public class CombinationWorkbench {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i=2;i<6;i++) {
			list.add(i);
		}
		
		CompositeCombinationGenerator<Integer> g = new CompositeCombinationGenerator<Integer>();
		//g.addCombinationGenerator(new BoundedCombinationGenerator<Integer>(list, BoundedCombinationGenerator.UNBOUNDED));
		g.addCombinationGenerator(new SingleCombinationGenerator<Integer>(3));
		g.addCombinationGenerator(new ListCombinationGenerator<Integer>(list, 1));
		g.setValidator(new CompositeCombinationValidator<Integer>() {
			
			@Override
			public boolean isValid(List<List<Integer>> combination) {
				int sum = 0;
				for (List<Integer> l : combination) {
					for (int i : l) {
						sum += i;
					}
				}
				return sum<160;
			} 
		});
		
		Object next = null;
		while ((next = g.getNext()) != null) {
			System.err.println(next);
		}
		
	}
	
}
