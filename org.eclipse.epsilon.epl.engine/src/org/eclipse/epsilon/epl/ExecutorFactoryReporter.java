package org.eclipse.epsilon.epl;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.epl.combinations.ExceptionHandler;

public class ExecutorFactoryReporter implements ExceptionHandler {
	
	protected IEolContext context;
	
	public ExecutorFactoryReporter(IEolContext context) {
		this.context = context;
	}
	
	@Override
	public void handleException(Exception ex) {
		throw new RuntimeException(ex.getMessage());
		//context.getExecutorFactory().reportException(EolRuntimeException.wrap(ex));
	}

}
