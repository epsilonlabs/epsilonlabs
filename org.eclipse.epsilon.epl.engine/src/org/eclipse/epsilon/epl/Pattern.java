package org.eclipse.epsilon.epl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.commons.module.AbstractModuleElement;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.util.AstUtil;
import org.eclipse.epsilon.epl.parse.EplParser;

public class Pattern extends AbstractModuleElement {
	
	protected String name;
	protected List<Component> components = new ArrayList<Component>();
	protected AST bodyAst = null;
	
	public Pattern(AST ast) {
		this.ast = ast;
		name = ast.getText();
		bodyAst = AstUtil.getChild(ast, EplParser.BLOCK);
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
		return getComponents();
	}
	
	public AST getBodyAst() {
		return bodyAst;
	}
	
}
