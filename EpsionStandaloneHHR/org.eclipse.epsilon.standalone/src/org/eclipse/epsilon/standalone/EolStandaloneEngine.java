/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     hhoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.standalone;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.standalone.util.ExecutionException;
import org.eclipse.epsilon.standalone.util.ParseException;
import org.eclipse.epsilon.standalone.util.SourceLoadException;

/**
 * The Class EolStandaloneEngine.
 */
public class EolStandaloneEngine extends EpsilonStandaloneEngine {
	
	
	/**
	 * Instantiates a new EOL Standalone engine.
	 *
	 * @param eolSourceURI the EOL source URI
	 */
	public EolStandaloneEngine(URI eolSourceURI) {
		super();
		this.sourceURI = eolSourceURI;
		models = new ArrayList<IModel>();
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.riskc.riskc.generator.epsilon.EpsilonStandalone#createModule()
	 */
	@Override
	public EolModule createModule() {
		return new EolModule();
	}
	

	/* (non-Javadoc)
	 * @see net.sourceforge.riskc.riskc.generator.epsilon.EpsilonStandalone#getModels()
	 */
	@Override
	public List<IModel> getModels() {
		return models;
	}
	
	/**
	 * Prepare.
	 * When executing specific operations {@link #executeOperation(String)}
	 * this method behaves similar to the execute method, but it does not
	 * call the module's execute.
	 * Note: When using this method, a call to the {@link close()} method
	 * should be executed when no more operations are being executed,
	 *
	 * @throws SourceLoadException the source load exception
	 * @throws ParseException the parse exception
	 */
	public void prepare() throws SourceLoadException, ParseException  {
		
		module = createModule();
		try {
			module.parse(sourceURI);
		} catch (Exception e1) {
			throw new SourceLoadException("There was an error loading the source.", e1.getCause());
		}
		
		if (module.getParseProblems().size() > 0) {
			System.err.println("Parse errors occured...");
			for (ParseProblem problem : module.getParseProblems()) {
				System.err.println(problem.toString());
			}
			throw new ParseException("Parse errors occured. See stack trace for details.");
		}
		
		for (IModel model : getModels()) {
			module.getContext().getModelRepository().addModel(model);
		}
		
	}
	
	/**
	 * Close.
	 * When executing specific operations ({@link executeOperation(String)}) 
	 * this method disposes the models. This method should be called
	 * when no more operations are being executed
	 */
	public void close() {
		
		module.getContext().getModelRepository().dispose();
	}
	
	
	/**
	 * Execute a specific operation, identified by the operationName parameter.
	 * {@link #prepare()} should be invoked before calling this method. The result
	 * of executing the operation in the loaded model(s) is stored in the result
	 * attribute.
	 * 	
	 * @param operationName the name of the operation in the EOL module operation name
	 * @throws ExecutionException if there was an error executing the operation 
	 */
	public void executeOperation(String operationName) throws ExecutionException {
		
		preProcess();
		result = executeOperation(module, operationName);
		postProcess();
	}
	
	

	/**
	 * Execute operation.
	 *
	 * @param module the module
	 * @param operationName the operation name
	 * @return the object
	 * @throws ExecutionException the execution exception
	 */
	private Object executeOperation(IEolExecutableModule module, String operationName) throws ExecutionException {
		EolOperation operation = module.getDeclaredOperations().getOperation(operationName);
		if(operation != null) {
			try {
				return operation.execute(null, Collections.EMPTY_LIST, module.getContext());
			} catch (EolRuntimeException e) {
				e.printStackTrace();
				throw new ExecutionException(e.getMessage());
			}
		}
		return null;
	}
	

	/**
	 * Executes the first operation found in the EOL source. To invoke a specific
	 * operation use {@link #executeOperation(IEolExecutableModule, String)}.
	 * The result of the operation will be stored in the result field.
	 *
	 * @throws ParseException If there are errors parsing the EOL source
	 * @throws SourceLoadException If there was an error loading the EOL source
	 * @throws ExecutionException the execution exception
	 */
	@Override
	public void execute() throws ParseException, SourceLoadException, ExecutionException {
		prepare();
		EolOperation operation = module.getDeclaredOperations().get(0);
		preProcess();
		try {
			result = operation.execute(null, Collections.EMPTY_LIST, module.getContext());
		} catch (EolRuntimeException e) {
			throw new ExecutionException(e.getMessage(),e.getCause());
		}
		postProcess();
		
		module.getContext().getModelRepository().dispose();
	}
	
	/* (non-Javadoc)
	 * @see net.sourceforge.riskc.riskc.generator.epsilon.EpsilonStandalone#postProcess()
	 */
	@Override
	public void postProcess() {
		System.out.println(result);
	}

}
