package org.eclipse.epsilon.epl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.commons.module.AbstractModuleElement;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class Domain extends AbstractModuleElement {
	
	public Domain(AST ast) {
		this.ast = ast;
	}
	
	@Override
	public List getChildren() {
		return Collections.EMPTY_LIST;
	}
	
	public List getValues(IEolContext context) throws EolRuntimeException {
		Object result = context.getExecutorFactory().executeBlockOrExpressionAst(ast.getFirstChild(), context);
		if (result instanceof List) {
			return (List) result;
		}
		else {
			List results = new ArrayList();
			results.add(result);
			return results;
		}
	}
	
}
