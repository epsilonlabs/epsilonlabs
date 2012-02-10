package org.eclipse.epsilon.epl;

import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.commons.module.AbstractModuleElement;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.util.AstUtil;
import org.eclipse.epsilon.epl.parse.EplParser;

public class Component extends AbstractModuleElement {
	
	protected String name;
	protected AST typeAst;
	protected Cardinality cardinality = new Cardinality(1, 1);
	protected Domain domain = null;
	protected Guard guard = null;
	
	public Component(AST ast) {
		this.ast = ast;
		this.name = ast.getText();
		this.typeAst = AstUtil.getChild(ast, EplParser.TYPE);
		AST cardinalityAst = AstUtil.getChild(ast, EplParser.CARDINALITY);
		if (cardinalityAst != null) {
			cardinality = new Cardinality(cardinalityAst);
		}
		AST domainAst = AstUtil.getChild(ast, EplParser.DOMAIN);
		if (domainAst != null) {
			domain = new Domain(domainAst);
		}
		AST guardAst = AstUtil.getChild(ast, EplParser.GUARD);
		if (guardAst != null) {
			guard = new Guard(guardAst);
		}
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public List getChildren() {
		return Collections.EMPTY_LIST;
	}

}
