package org.eclipse.epsilon.eol.visitor.mutation.testing.mutant.generator.context;

import java.util.HashMap;

import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.EolFactory;
import org.eclipse.epsilon.eol.metamodel.PlusOperatorExpression;
import org.eclipse.epsilon.eol.metamodel.impl.EolFactoryImpl;
import org.eclipse.epsilon.eol.metamodel.impl.PlusOperatorExpressionImpl;

public class MutantGeneratorContext {

	protected EolFactory eolFactory = new EolFactoryImpl();
	protected HashMap<Class<?>, Class<?>> mutationMap = new HashMap<Class<?>, Class<?>>();
	
	public EolFactory getEolFactory() {
		return eolFactory;
	}
	
	public void fillMap(Class<?> from, Class<?> to)
	{
		mutationMap.put(from, to);
	}
	
	public static void main(String[] args) {
		
	}
	
}
