package org.eclipse.epsilon.epl;

import java.util.List;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.Frame;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.epl.combinations.BoundedCombinationGenerator;
import org.eclipse.epsilon.epl.combinations.CombinationGenerator;
import org.eclipse.epsilon.epl.combinations.CompositeCombinationGenerator;

public class PatternMatcher {
	
	public void match(Pattern pattern, IEolContext context) throws EolRuntimeException {
		
		CompositeCombinationGenerator<Object> generator = new CompositeCombinationGenerator<Object>();
		
		for (Component component : pattern.getComponents()) {
			generator.addCombinationGenerator(createCombinationGenerator(component, context));
		}
		
		List<List<Object>> candidate = generator.getNext();
		while (candidate != null) {
			
			Frame frame = context.getFrameStack().enter(FrameType.PROTECTED, pattern.getAst());
			
			int i = 0;
			for (Component component : pattern.getComponents()) {
				frame.put(Variable.createReadOnlyVariable(component.getName(), candidate.get(i)));
				i++;
			}
			
			context.getExecutorFactory().executeAST(pattern.getBodyAst(), context);
			
			context.getFrameStack().leave(pattern.getAst());
			
			candidate = generator.getNext();
		}
		
	}
	
	protected CombinationGenerator<Object> createCombinationGenerator(Component component, IEolContext context) throws EolRuntimeException {
		Cardinality cardinality = component.getCardinality();
		CombinationGenerator<Object> combinationGenerator = null;
		if (cardinality.isOne()) {
			combinationGenerator = new BoundedCombinationGenerator<Object>(component.getInstances(context), cardinality.getLowerBound(), cardinality.getUpperBound(), true);
		}
		return combinationGenerator;
	}
	
}
