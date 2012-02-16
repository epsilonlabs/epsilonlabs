package org.eclipse.epsilon.epl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.commons.module.AbstractModuleElement;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.util.AstUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.eol.types.EolSequence;
import org.eclipse.epsilon.epl.parse.EplParser;

public class Component extends AbstractModuleElement {
	
	protected ArrayList<String> names = new ArrayList<String>();
	protected AST typeAst;
	protected Domain domain = null;
	protected Guard guard = null;
	protected EolModelElementType type = null;
	
	public Component(AST ast) {
		this.ast = ast;
		for (AST nameAst : AstUtil.getChildren(ast, EplParser.NAME)) {
			this.names.add(nameAst.getText());
		}
		this.typeAst = AstUtil.getChild(ast, EplParser.TYPE);
		AST domainAst = AstUtil.getChild(ast, EplParser.DOMAIN);
		if (domainAst != null) {
			domain = new Domain(domainAst);
		}
		AST guardAst = AstUtil.getChild(ast, EplParser.GUARD);
		if (guardAst != null) {
			guard = new Guard(guardAst);
		}
	}
	
	public List<String> getNames() {
		return names;
	}
	
	@Override
	public List getChildren() {
		return Collections.EMPTY_LIST;
	}
	
	public Domain getDomain() {
		return domain;
	}
	
	public Guard getGuard() {
		return guard;
	}
	
	public List getInstances(IEolContext context) throws EolRuntimeException {
		
		if (domain != null) {
			return domain.getValues(context);
		}
		else {
			if (type == null) {
				type = EolModelElementType.forName(typeAst.getText(), context);
			}

			Collection allInstances = type.getAllOfKind();
			if (allInstances instanceof List) {
				return (List) allInstances;
			}
			else {
				EolSequence sequence = new EolSequence();
				sequence.addAll(allInstances);
				return sequence;
			}
			
		}
	}
}
