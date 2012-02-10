package org.eclipse.epsilon.epl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.commons.module.AbstractModuleElement;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.util.AstUtil;
import org.eclipse.epsilon.epl.parse.EplParser;

public class PatternSet extends AbstractModuleElement {

	protected AST ast = null;
	protected String name = null;
	protected List<Pattern> patterns = new ArrayList<Pattern>();
	
	public PatternSet(AST ast) {
		this.ast = ast;
		this.name = ast.getText();
		for (AST patternAst : AstUtil.getChildren(ast, EplParser.PATTERN)) {
			patterns.add(new Pattern(patternAst));
		}
	}

	public String getName() {
		return name;
	}
	
	@Override
	public List getChildren() {
		return patterns;
	}

	public List<Pattern> getPatterns() {
		return patterns;
	}
	
}
