package org.eclipse.epsilon.labs.queryoptimisation;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.EolEvaluator;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.IAbstractOperationContributor;
import org.eclipse.epsilon.eol.execute.operations.declarative.IteratorOperation;

public class AbstractOperationContributorApp implements IAbstractOperationContributor {
	
	public static void main(String[] args) {
		
		EolEvaluator evaluator = new EolEvaluator();
		evaluator.getContext().getFrameStack().put(Variable.createReadOnlyVariable("x", new AbstractOperationContributorApp()));
		evaluator.evaluate("x.foo(a|a.b = c).println()");
		
	}
	
	@Override
	public AbstractOperation getAbstractOperation(String name) {
		if ("foo".equals(name)) return new IteratorOperation() {
			
			@Override
			public Object execute(Object target, Variable iterator, AST expressionAst,
					IEolContext context) throws EolRuntimeException {
				return iterator.getName();
			}
		};
		else return null;
	}

}
