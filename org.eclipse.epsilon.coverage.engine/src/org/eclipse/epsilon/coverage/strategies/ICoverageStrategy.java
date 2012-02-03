package org.eclipse.epsilon.coverage.strategies;

import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;

public interface ICoverageStrategy {

	/**
	 * Use the AST to create a model representative of the coverage type.
	 * @param ast The AST to traverse, from which the coverage model is built.
	 */
	public void buildModel(AST ast);
	
	/**
	 * Updates the coverage model stating that the given AST has been executed.
	 * @param ast
	 */
	public void cover(AST ast);
	
	/**
	 * Updates the coverage model with the result of executing the AST.
	 * @param ast The AST which was executed.
	 * @param result The result of the execution.
	 */
	public void finishCovering(AST ast, Object result);
	
	/**
	 * @return The coverage model.
	 */
	public List<CoveragePoint> getModel();
	
	/**
	 * @return A summary outlining how much of the model was covered during execution.
	 */
	public String getSummary();
	
	/**
	 * @return A detailed description of how much of the model was covered during execution.
	 */
	public String getDetail();
	
	/**
	 * @return A score based on the amount of the model that was covered during execution.
	 */
	public double getScore();

	/**
	 * Unsets the covered flag on all coverage points. Does not destroy the model.
	 */
	public void reset();
}
