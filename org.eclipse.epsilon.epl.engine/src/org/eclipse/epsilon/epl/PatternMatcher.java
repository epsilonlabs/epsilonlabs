package org.eclipse.epsilon.epl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.eol.exceptions.EolIllegalReturnException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.Frame;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.epl.combinations.DynamicListCombinationGenerator;
import org.eclipse.epsilon.epl.combinations.CombinationGenerator;
import org.eclipse.epsilon.epl.combinations.CombinationGeneratorListener;
import org.eclipse.epsilon.epl.combinations.CompositeCombinationGenerator;
import org.eclipse.epsilon.epl.combinations.CompositeCombinationValidator;
import org.eclipse.epsilon.epl.combinations.ListCombinationGenerator;

public class PatternMatcher {
	
	protected Frame frame = null;
	
	public PatternMatchModel match(EplModule module) throws EolRuntimeException {
		PatternMatchModel model = new PatternMatchModel();
		for (Pattern pattern : module.getPatterns()) {
			for (PatternMatch match : match(pattern, module.getContext())) {
				model.addMatch(match);
			}
		}
		return model;
	}
	
	public List<PatternMatch> match(final Pattern pattern, final IEolContext context) throws EolRuntimeException {
		
		List<PatternMatch> patternMatches = new ArrayList<PatternMatch>();
		
		context.getFrameStack().enter(FrameType.PROTECTED, pattern.getAst());
		
		CompositeCombinationGenerator<Object> generator = new CompositeCombinationGenerator<Object>();
		
		for (Component component : pattern.getComponents()) {
			generator.addCombinationGenerator(createCombinationGenerator(component, context));
		}

		generator.setValidator(new CompositeCombinationValidator<Object>() {
			
			@Override
			public boolean isValid(List<List<Object>> combination) {
				frame = context.getFrameStack().enter(FrameType.PROTECTED, pattern.getAst());
				boolean result = true;
				int i = 0;
				Component component = null;
				for (List<Object> values : combination) {
					component = pattern.getComponents().get(i);
					for (Variable variable : getVariables(values, component)) {
						frame.put(variable);
					}
					i++;
				}
				if (component.getGuard() != null) {
					Return ret = null;
					try {
						ret = (Return) context.getExecutorFactory().executeBlockOrExpressionAst(component.getGuard().getAst().getFirstChild(), context);
						if (ret.getValue() instanceof Boolean) result = (Boolean) ret.getValue();
					} catch (EolRuntimeException e) {
						e.printStackTrace();
						result = false;
					}
				}
				context.getFrameStack().leave(pattern.getAst());
				return result;
			}
		});
		
		List<List<Object>> candidate = generator.getNext();
		
		while (candidate != null) {
			
			boolean matches = true;
			
			frame = context.getFrameStack().enter(FrameType.PROTECTED, pattern.getAst());
			
			if (pattern.getMatchAst() != null || pattern.getNoMatchAst() != null || pattern.getDoAst() != null) {
				int i = 0;
				for (Component component : pattern.getComponents()) {
					for (Variable variable : getVariables(candidate.get(i), component)) {
						frame.put(variable);
					}
					i++;
				}
			}
			
			if (pattern.getMatchAst() != null) {
				Object result = context.getExecutorFactory().executeAST(pattern.getMatchAst(), context);
				if (result instanceof Return) result = ((Return) result).getValue();
				if (result instanceof Boolean) {
					matches = (Boolean) result;
				}
				else throw new EolIllegalReturnException("Boolean", result, pattern.getMatchAst(), context);
			}
			
			if (matches) { 
				context.getExecutorFactory().executeAST(pattern.getDoAst(), context);
				patternMatches.add(createPatternMatch(pattern, candidate));
			}
			else context.getExecutorFactory().executeAST(pattern.getNoMatchAst(), context);
			
			context.getFrameStack().leave(pattern.getAst());
			
			candidate = generator.getNext();
		}
		
		context.getFrameStack().leave(pattern.getAst());
		
		return patternMatches;
	}
	
	protected List<Variable> getVariables(List<Object> combination, Component component) {
		ArrayList<Variable> variables = new ArrayList<Variable>();
		int i = 0;
		for (String name : component.getNames()) {
			variables.add(Variable.createReadOnlyVariable(name, combination.get(i)));
			i++;
		}
		if (component.getAlias() != null) {
			variables.add(Variable.createReadOnlyVariable(component.getAlias(), combination));
		}
		return variables;
	}
	
	protected CombinationGenerator<Object> createCombinationGenerator(final Component component, final IEolContext context) throws EolRuntimeException {
		DynamicListCombinationGenerator<Object> combinationGenerator = null;
		combinationGenerator = new DynamicListCombinationGenerator<Object>(component.getInstances(context), component.getNames().size());
		//FixedCombinationGenerator<Object> combinationGenerator = null;
		//combinationGenerator = new FixedCombinationGenerator<Object>(component.getInstances(context), component.getNames().size());
		
		combinationGenerator.addListener(new CombinationGeneratorListener<Object>() {			
			@Override
			public void generated(List<Object> next) {
				if (next != null)
				for (Variable variable : getVariables(next, component)) {
					context.getFrameStack().put(variable);
				}
			}
			
			@Override
			public void reset() {
				for (String variableName : component.getNames()) {
					context.getFrameStack().remove(variableName);
				}
			}
		});
		
		return combinationGenerator;
	}
	
	protected PatternMatch createPatternMatch(Pattern pattern, List<List<Object>> combination) {
		PatternMatch patternMatch = new PatternMatch(pattern);
		int i = 0;
		for (Component component : pattern.getComponents()) {
			patternMatch.getComponents().addAll(getVariables(combination.get(i), component));
			i++;
		}
		return patternMatch;
	}
	
}
