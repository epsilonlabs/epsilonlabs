package org.eclipse.epsilon.epl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.commons.module.AbstractModuleElement;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.util.AstUtil;

public class PatternSet extends AbstractModuleElement {

	protected AST ast = null;
	protected List<Pattern> patterns = new ArrayList<Pattern>();
	
	public PatternSet(AST ast) {
		this.ast = ast;
//		for (AST patternAst : AstUtil.getChildren(ast, EplP))
	}

	@Override
	public List getChildren() {
		return patterns;
	}
	
}
