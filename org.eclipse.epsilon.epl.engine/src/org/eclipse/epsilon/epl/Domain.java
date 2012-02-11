package org.eclipse.epsilon.epl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.commons.module.AbstractModuleElement;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.epl.combinations.DynamicList;
import org.eclipse.epsilon.epl.combinations.ExceptionHandler;

public class Domain extends AbstractModuleElement {
	
	protected boolean dynamic = false;
	
	public Domain(AST ast) {
		this.ast = ast;
		this.dynamic = "from".equals(ast.getText());
	}
	
	@Override
	public List getChildren() {
		return Collections.EMPTY_LIST;
	}
	
	public List getValues(final IEolContext context) throws EolRuntimeException {
		
		DynamicList<Object> r = new DynamicList<Object>() {
			@Override
			protected List<Object> getValues() throws Exception {
		
				Object result = context.getExecutorFactory().executeBlockOrExpressionAst(ast.getFirstChild(), context);
				if (result instanceof Return) result = ((Return) result).getValue();
				if (result instanceof List) {
					return (List) result;
				}
				else {
					List results = new ArrayList();
					results.add(result);
					return results;
				}
			}
		};
		
		r.setExceptionHandler(new ExceptionHandler() {
			
			@Override
			public void handleException(Exception ex) {
				ex.printStackTrace();
				System.exit(1);
			}
		});
		
		r.setResetable(isDynamic());
		return r;
		
	}
	
	public boolean isDynamic() {
		return dynamic;
	}
	
}
