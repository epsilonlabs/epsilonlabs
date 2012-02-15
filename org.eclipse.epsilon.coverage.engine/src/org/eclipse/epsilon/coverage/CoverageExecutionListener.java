package org.eclipse.epsilon.coverage;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.coverage.strategies.ICoverageStrategy;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.control.IExecutionListener;

public class CoverageExecutionListener implements IExecutionListener {
	
	protected boolean astAnalysed = false;
	protected List<ICoverageStrategy> coverageStrategies;
	
	public CoverageExecutionListener() {
		coverageStrategies = new ArrayList<ICoverageStrategy>();
	}
	
	public void addCoverageStrategy(ICoverageStrategy strategy) {
		this.coverageStrategies.add(strategy);
	}

	@Override
	public void aboutToExecute(AST ast, IEolContext context) {
		if (!astAnalysed) {
			// The first ast that is executed may not be the TOP one. Therefore, 
			// we need to travel UP the AST before analysing it.
			AST top = ast;
			while (top != null) {
				if (top.getParent() != null) {
					top = top.getParent();
				} else {
					break;
				}
			}
			analyseAST(top);
			astAnalysed = true;
		}
		
		for (ICoverageStrategy strategy : coverageStrategies) {
			strategy.cover(ast);
		}
	}

	@Override
	public void finishedExecuting(AST ast, Object evaluatedAst, IEolContext context) { 
		for (ICoverageStrategy strategy : coverageStrategies) {
			strategy.finishCovering(ast, evaluatedAst);
		}
	}
	
	protected void analyseAST(AST ast) {
		for (ICoverageStrategy strategy : coverageStrategies) {
			strategy.buildModel(ast);
		}
		
		for (AST child : ast.getChildren()) {
			analyseAST(child);
		}
	}
	
	public List<ICoverageStrategy> getCoverageStrategies() {
		return coverageStrategies;
	}
	
	public void reset() {
		for (ICoverageStrategy s : coverageStrategies) {
			s.reset();
		}
		astAnalysed = false;
	}
}
