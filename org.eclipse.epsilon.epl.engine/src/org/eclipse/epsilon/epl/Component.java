package org.eclipse.epsilon.epl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.commons.module.AbstractModuleElement;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.util.AstUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.eol.types.EolSequence;
import org.eclipse.epsilon.epl.combinations.DynamicList;
import org.eclipse.epsilon.epl.parse.EplParser;

public class Component extends AbstractModuleElement {
	
	protected ArrayList<String> names = new ArrayList<String>();
	protected AST typeAst;
	protected Domain domain = null;
	protected Guard guard = null;
	protected EolModelElementType type = null;
	protected boolean negative;
	
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
		AST noAST = AstUtil.getChild(ast, EplParser.NO);
		negative = (noAST != null);
	}

	public boolean isNegative() {
		return negative;
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
	
	public List getInstances(final IEolContext context) throws EolRuntimeException {
		
		List instances = null;
		
		if (domain != null) {
			instances = domain.getValues(context, typeAst.getText());
		}
		else {
			if (type == null) {
				type = EolModelElementType.forName(typeAst.getText(), context);
			}

			Collection allInstances = type.getAllOfKind();
			if (allInstances instanceof List) {
				instances = (List) allInstances;
			}
			else {
				EolSequence sequence = new EolSequence();
				sequence.addAll(allInstances);
				instances = sequence;
			}
		}
		
		if (isNegative()) {
			
			final List domainValues = instances;
			
			DynamicList<Object> negativeDomainValues = new DynamicList<Object>() {

				@Override
				protected List<Object> getValues() throws Exception {
					
					if (getGuard()!=null) {
						for (Object o : domainValues) {
							boolean result = true;
							Return ret = null;
							context.getFrameStack().enter(FrameType.UNPROTECTED, getGuard().getAst(), Variable.createReadOnlyVariable(getNames().get(0), o));
							ret = (Return) context.getExecutorFactory().executeBlockOrExpressionAst(getGuard().getAst().getFirstChild(), context);
							context.getFrameStack().leave(getGuard().getAst());
							if (ret.getValue() instanceof Boolean) result = (Boolean) ret.getValue();
							if (result == true) {
								return new ArrayList();
							}
						}
					}
					else {
						if (domainValues.size() > 0) return new ArrayList();
					}
					ArrayList noMatchList = new ArrayList();
					noMatchList.add(NoMatch.INSTANCE);
					return noMatchList;
				}
				
				@Override
				public void reset() {
					super.reset();
					if (domainValues instanceof DynamicList<?>) ((DynamicList<?>) domainValues).reset();
				}
			};
			
			negativeDomainValues.setResetable(getGuard()!=null || ((domainValues instanceof DynamicList<?>) && ((DynamicList<?>) domainValues).isResetable()));
			
			return negativeDomainValues;
			
			/*
			if (getGuard()!=null) {
				for (Object o : instances) {
					boolean result = true;
					Return ret = null;
					context.getFrameStack().enter(FrameType.UNPROTECTED, getGuard().getAst(), Variable.createReadOnlyVariable(getNames().get(0), o));
					ret = (Return) context.getExecutorFactory().executeBlockOrExpressionAst(getGuard().getAst().getFirstChild(), context);
					context.getFrameStack().leave(getGuard().getAst());
					if (ret.getValue() instanceof Boolean) result = (Boolean) ret.getValue();
					if (result == true) return new ArrayList();
				}
			}
			else {
				if (instances.size() > 0) return new ArrayList();
			}
			instances = new ArrayList();
			instances.add(NoMatch.INSTANCE);*/
		}
	
		return instances;
	}
	
}
