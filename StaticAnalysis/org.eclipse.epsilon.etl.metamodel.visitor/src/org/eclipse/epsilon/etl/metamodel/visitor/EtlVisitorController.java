package org.eclipse.epsilon.etl.metamodel.visitor;

import org.eclipse.epsilon.etl.metamodel.*;
import org.eclipse.emf.ecore.EObject;
import java.util.List;
import java.util.ArrayList;


import org.eclipse.epsilon.eol.metamodel.visitor.*;

public class EtlVisitorController<T, R> extends EolVisitorController<T, R> {

	protected List<PreBlockVisitor<T, R>> preBlockVisitors = new ArrayList<PreBlockVisitor<T, R>>();
	protected List<PostBlockVisitor<T, R>> postBlockVisitors = new ArrayList<PostBlockVisitor<T, R>>();
	protected List<NamedBlockVisitor<T, R>> namedBlockVisitors = new ArrayList<NamedBlockVisitor<T, R>>();
	protected List<GuardVisitor<T, R>> guardVisitors = new ArrayList<GuardVisitor<T, R>>();
	protected List<EtlProgramVisitor<T, R>> etlProgramVisitors = new ArrayList<EtlProgramVisitor<T, R>>();
	protected List<TransformationRuleVisitor<T, R>> transformationRuleVisitors = new ArrayList<TransformationRuleVisitor<T, R>>();
	protected List<EtlElementVisitor<T, R>> etlElementVisitors = new ArrayList<EtlElementVisitor<T, R>>();
	
	public R visit(EObject o, T context) {
		if (o instanceof PreBlock && !preBlockVisitors.isEmpty()) {
			for (PreBlockVisitor<T, R> visitor : preBlockVisitors) {
				if (visitor.appliesTo((PreBlock) o, context)) {
					return visitor.visit((PreBlock) o, context, this);
				}
			}
		}
		if (o instanceof PostBlock && !postBlockVisitors.isEmpty()) {
			for (PostBlockVisitor<T, R> visitor : postBlockVisitors) {
				if (visitor.appliesTo((PostBlock) o, context)) {
					return visitor.visit((PostBlock) o, context, this);
				}
			}
		}
		if (o instanceof NamedBlock && !namedBlockVisitors.isEmpty()) {
			for (NamedBlockVisitor<T, R> visitor : namedBlockVisitors) {
				if (visitor.appliesTo((NamedBlock) o, context)) {
					return visitor.visit((NamedBlock) o, context, this);
				}
			}
		}
		if (o instanceof Guard && !guardVisitors.isEmpty()) {
			for (GuardVisitor<T, R> visitor : guardVisitors) {
				if (visitor.appliesTo((Guard) o, context)) {
					return visitor.visit((Guard) o, context, this);
				}
			}
		}
		if (o instanceof EtlProgram && !etlProgramVisitors.isEmpty()) {
			for (EtlProgramVisitor<T, R> visitor : etlProgramVisitors) {
				if (visitor.appliesTo((EtlProgram) o, context)) {
					return visitor.visit((EtlProgram) o, context, this);
				}
			}
		}
		if (o instanceof TransformationRule && !transformationRuleVisitors.isEmpty()) {
			for (TransformationRuleVisitor<T, R> visitor : transformationRuleVisitors) {
				if (visitor.appliesTo((TransformationRule) o, context)) {
					return visitor.visit((TransformationRule) o, context, this);
				}
			}
		}
		if (o instanceof EtlElement && !etlElementVisitors.isEmpty()) {
			for (EtlElementVisitor<T, R> visitor : etlElementVisitors) {
				if (visitor.appliesTo((EtlElement) o, context)) {
					return visitor.visit((EtlElement) o, context, this);
				}
			}
		}
		
		return super.visit(o, context);
		//return null;
	}
	
	public void visitContents(EObject o, T context) {
		for (EObject content : o.eContents()) {
			visit(content, context);
		}
	}
	
	public R visitAsPreBlock(PreBlock preBlock, T context) {
		if (!preBlockVisitors.isEmpty()) {
			for (PreBlockVisitor<T, R> visitor : preBlockVisitors) {
				if (visitor.appliesTo((PreBlock) preBlock, context)) {
					return visitor.visit((PreBlock) preBlock, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsPostBlock(PostBlock postBlock, T context) {
		if (!postBlockVisitors.isEmpty()) {
			for (PostBlockVisitor<T, R> visitor : postBlockVisitors) {
				if (visitor.appliesTo((PostBlock) postBlock, context)) {
					return visitor.visit((PostBlock) postBlock, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsNamedBlock(NamedBlock namedBlock, T context) {
		if (!namedBlockVisitors.isEmpty()) {
			for (NamedBlockVisitor<T, R> visitor : namedBlockVisitors) {
				if (visitor.appliesTo((NamedBlock) namedBlock, context)) {
					return visitor.visit((NamedBlock) namedBlock, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsGuard(Guard guard, T context) {
		if (!guardVisitors.isEmpty()) {
			for (GuardVisitor<T, R> visitor : guardVisitors) {
				if (visitor.appliesTo((Guard) guard, context)) {
					return visitor.visit((Guard) guard, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsEtlProgram(EtlProgram etlProgram, T context) {
		if (!etlProgramVisitors.isEmpty()) {
			for (EtlProgramVisitor<T, R> visitor : etlProgramVisitors) {
				if (visitor.appliesTo((EtlProgram) etlProgram, context)) {
					return visitor.visit((EtlProgram) etlProgram, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsTransformationRule(TransformationRule transformationRule, T context) {
		if (!transformationRuleVisitors.isEmpty()) {
			for (TransformationRuleVisitor<T, R> visitor : transformationRuleVisitors) {
				if (visitor.appliesTo((TransformationRule) transformationRule, context)) {
					return visitor.visit((TransformationRule) transformationRule, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsEtlElement(EtlElement etlElement, T context) {
		if (!etlElementVisitors.isEmpty()) {
			for (EtlElementVisitor<T, R> visitor : etlElementVisitors) {
				if (visitor.appliesTo((EtlElement) etlElement, context)) {
					return visitor.visit((EtlElement) etlElement, context, this);
				}
			}
		}
		return null;
	}
	
	public boolean addPreBlockVisitor(PreBlockVisitor<T, R> preBlockVisitor) {
		return this.preBlockVisitors.add(preBlockVisitor);
	}
	
	public boolean addPostBlockVisitor(PostBlockVisitor<T, R> postBlockVisitor) {
		return this.postBlockVisitors.add(postBlockVisitor);
	}
	
	public boolean addNamedBlockVisitor(NamedBlockVisitor<T, R> namedBlockVisitor) {
		return this.namedBlockVisitors.add(namedBlockVisitor);
	}
	
	public boolean addGuardVisitor(GuardVisitor<T, R> guardVisitor) {
		return this.guardVisitors.add(guardVisitor);
	}
	
	public boolean addEtlProgramVisitor(EtlProgramVisitor<T, R> etlProgramVisitor) {
		return this.etlProgramVisitors.add(etlProgramVisitor);
	}
	
	public boolean addTransformationRuleVisitor(TransformationRuleVisitor<T, R> transformationRuleVisitor) {
		return this.transformationRuleVisitors.add(transformationRuleVisitor);
	}
	
	public boolean addEtlElementVisitor(EtlElementVisitor<T, R> etlElementVisitor) {
		return this.etlElementVisitors.add(etlElementVisitor);
	}
	

	public boolean removePreBlockVisitor(PreBlockVisitor<T, R> preBlockVisitor) {
		return this.preBlockVisitors.remove(preBlockVisitor);
	}
	
	public boolean removePostBlockVisitor(PostBlockVisitor<T, R> postBlockVisitor) {
		return this.postBlockVisitors.remove(postBlockVisitor);
	}
	
	public boolean removeNamedBlockVisitor(NamedBlockVisitor<T, R> namedBlockVisitor) {
		return this.namedBlockVisitors.remove(namedBlockVisitor);
	}
	
	public boolean removeGuardVisitor(GuardVisitor<T, R> guardVisitor) {
		return this.guardVisitors.remove(guardVisitor);
	}
	
	public boolean removeEtlProgramVisitor(EtlProgramVisitor<T, R> etlProgramVisitor) {
		return this.etlProgramVisitors.remove(etlProgramVisitor);
	}
	
	public boolean removeTransformationRuleVisitor(TransformationRuleVisitor<T, R> transformationRuleVisitor) {
		return this.transformationRuleVisitors.remove(transformationRuleVisitor);
	}
	
	public boolean removeEtlElementVisitor(EtlElementVisitor<T, R> etlElementVisitor) {
		return this.etlElementVisitors.remove(etlElementVisitor);
	}
	
	
	
}