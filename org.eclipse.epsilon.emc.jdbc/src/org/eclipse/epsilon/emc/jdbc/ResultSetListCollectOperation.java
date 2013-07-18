package org.eclipse.epsilon.emc.jdbc;

import java.util.ArrayList;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.operations.declarative.IteratorOperation;

public class ResultSetListCollectOperation extends IteratorOperation {

	@Override
	public Object execute(Object target, Variable iterator, AST expressionAst,
			IEolContext context) throws EolRuntimeException {
		
		ResultSetList resultSetList = (ResultSetList) target;
		return new PrimitiveValuesList(resultSetList.getModel(), resultSetList.getTable(), 
				resultSetList.getModel().ast2sql(iterator, expressionAst, context, new ArrayList<Object>()), 
				resultSetList.getCondition(), resultSetList.getParameters(), false, resultSetList.isStreamed(),
				resultSetList.isOne());

	}

}
