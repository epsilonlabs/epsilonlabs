package org.eclipse.epsilon.epl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.commons.module.AbstractModuleElement;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.util.AstUtil;
import org.eclipse.epsilon.epl.parse.EplParser;

public class Pattern extends AbstractModuleElement {
	
	protected String name;
	protected List<Component> components = new ArrayList<Component>();
	protected AST doAst = null;
	protected AST matchAst = null;
	protected AST noMatchAst = null;
	protected AST onMatchAst = null;
	
	public Pattern(AST ast) {
		this.ast = ast;
		name = ast.getText();
		doAst = AstUtil.getChild(ast, EplParser.DO); if (doAst != null) doAst = doAst.getFirstChild();
		matchAst = AstUtil.getChild(ast, EplParser.MATCH); if (matchAst != null) matchAst = matchAst.getFirstChild();
		noMatchAst = AstUtil.getChild(ast, EplParser.NOMATCH); if (noMatchAst != null) noMatchAst = noMatchAst.getFirstChild();
		onMatchAst = AstUtil.getChild(ast, EplParser.ONMATCH); if (onMatchAst != null) onMatchAst = onMatchAst.getFirstChild();
		
		for (AST componentAst : AstUtil.getChildren(ast, EplParser.COMPONENT)) {
			components.add(new Component(componentAst));
		}
	}
	
	public String getName() {
		return name;
	}
	
	public List<Component> getComponents() {
		return components;
	}
	
	@Override
	public List getChildren() {
		return Collections.EMPTY_LIST;
	}
	
	public AST getMatchAst() {
		return matchAst;
	}
	
	public AST getDoAst() {
		return doAst;
	}
	
	public AST getNoMatchAst() {
		return noMatchAst;
	}
	
	public AST getOnMatchAst() {
		return onMatchAst;
	}
}
