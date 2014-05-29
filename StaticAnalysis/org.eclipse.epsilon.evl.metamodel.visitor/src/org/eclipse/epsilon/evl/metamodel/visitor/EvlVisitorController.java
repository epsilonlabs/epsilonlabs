package org.eclipse.epsilon.evl.metamodel.visitor;

import org.eclipse.epsilon.evl.metamodel.*;
import org.eclipse.emf.ecore.EObject;
import java.util.List;
import java.util.ArrayList;


import org.eclipse.epsilon.eol.metamodel.visitor.*;

public class EvlVisitorController<T, R> extends EolVisitorController<T, R> {

	protected List<ConstraintVisitor<T, R>> constraintVisitors = new ArrayList<ConstraintVisitor<T, R>>();
	protected List<CritiqueVisitor<T, R>> critiqueVisitors = new ArrayList<CritiqueVisitor<T, R>>();
	protected List<ContextVisitor<T, R>> contextVisitors = new ArrayList<ContextVisitor<T, R>>();
	protected List<InvariantVisitor<T, R>> invariantVisitors = new ArrayList<InvariantVisitor<T, R>>();
	protected List<PreBlockVisitor<T, R>> preBlockVisitors = new ArrayList<PreBlockVisitor<T, R>>();
	protected List<PostBlockVisitor<T, R>> postBlockVisitors = new ArrayList<PostBlockVisitor<T, R>>();
	protected List<EvlProgramVisitor<T, R>> evlProgramVisitors = new ArrayList<EvlProgramVisitor<T, R>>();
	protected List<GuardedElementVisitor<T, R>> guardedElementVisitors = new ArrayList<GuardedElementVisitor<T, R>>();
	protected List<FixVisitor<T, R>> fixVisitors = new ArrayList<FixVisitor<T, R>>();
	protected List<NamedBlockVisitor<T, R>> namedBlockVisitors = new ArrayList<NamedBlockVisitor<T, R>>();
	protected List<EvlElementVisitor<T, R>> evlElementVisitors = new ArrayList<EvlElementVisitor<T, R>>();
	
	public R visit(EObject o, T context) {
		if (o instanceof Constraint && !constraintVisitors.isEmpty()) {
			for (ConstraintVisitor<T, R> visitor : constraintVisitors) {
				if (visitor.appliesTo((Constraint) o, context)) {
					return visitor.visit((Constraint) o, context, this);
				}
			}
		}
		if (o instanceof Critique && !critiqueVisitors.isEmpty()) {
			for (CritiqueVisitor<T, R> visitor : critiqueVisitors) {
				if (visitor.appliesTo((Critique) o, context)) {
					return visitor.visit((Critique) o, context, this);
				}
			}
		}
		if (o instanceof Context && !contextVisitors.isEmpty()) {
			for (ContextVisitor<T, R> visitor : contextVisitors) {
				if (visitor.appliesTo((Context) o, context)) {
					return visitor.visit((Context) o, context, this);
				}
			}
		}
		if (o instanceof Invariant && !invariantVisitors.isEmpty()) {
			for (InvariantVisitor<T, R> visitor : invariantVisitors) {
				if (visitor.appliesTo((Invariant) o, context)) {
					return visitor.visit((Invariant) o, context, this);
				}
			}
		}
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
		if (o instanceof EvlProgram && !evlProgramVisitors.isEmpty()) {
			for (EvlProgramVisitor<T, R> visitor : evlProgramVisitors) {
				if (visitor.appliesTo((EvlProgram) o, context)) {
					return visitor.visit((EvlProgram) o, context, this);
				}
			}
		}
		if (o instanceof GuardedElement && !guardedElementVisitors.isEmpty()) {
			for (GuardedElementVisitor<T, R> visitor : guardedElementVisitors) {
				if (visitor.appliesTo((GuardedElement) o, context)) {
					return visitor.visit((GuardedElement) o, context, this);
				}
			}
		}
		if (o instanceof Fix && !fixVisitors.isEmpty()) {
			for (FixVisitor<T, R> visitor : fixVisitors) {
				if (visitor.appliesTo((Fix) o, context)) {
					return visitor.visit((Fix) o, context, this);
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
		if (o instanceof EvlElement && !evlElementVisitors.isEmpty()) {
			for (EvlElementVisitor<T, R> visitor : evlElementVisitors) {
				if (visitor.appliesTo((EvlElement) o, context)) {
					return visitor.visit((EvlElement) o, context, this);
				}
			}
		}
		
		super.visit(o, context);
		return null;
	}
	
	public void visitContents(EObject o, T context) {
		for (EObject content : o.eContents()) {
			visit(content, context);
		}
	}
	
	public R visitAsConstraint(Constraint constraint, T context) {
		if (!constraintVisitors.isEmpty()) {
			for (ConstraintVisitor<T, R> visitor : constraintVisitors) {
				if (visitor.appliesTo((Constraint) constraint, context)) {
					return visitor.visit((Constraint) constraint, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsCritique(Critique critique, T context) {
		if (!critiqueVisitors.isEmpty()) {
			for (CritiqueVisitor<T, R> visitor : critiqueVisitors) {
				if (visitor.appliesTo((Critique) critique, context)) {
					return visitor.visit((Critique) critique, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsContext(Context _context, T context) {
		if (!contextVisitors.isEmpty()) {
			for (ContextVisitor<T, R> visitor : contextVisitors) {
				if (visitor.appliesTo((Context) _context, context)) {
					return visitor.visit((Context) _context, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsInvariant(Invariant invariant, T context) {
		if (!invariantVisitors.isEmpty()) {
			for (InvariantVisitor<T, R> visitor : invariantVisitors) {
				if (visitor.appliesTo((Invariant) invariant, context)) {
					return visitor.visit((Invariant) invariant, context, this);
				}
			}
		}
		return null;
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
	public R visitAsEvlProgram(EvlProgram evlProgram, T context) {
		if (!evlProgramVisitors.isEmpty()) {
			for (EvlProgramVisitor<T, R> visitor : evlProgramVisitors) {
				if (visitor.appliesTo((EvlProgram) evlProgram, context)) {
					return visitor.visit((EvlProgram) evlProgram, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsGuardedElement(GuardedElement guardedElement, T context) {
		if (!guardedElementVisitors.isEmpty()) {
			for (GuardedElementVisitor<T, R> visitor : guardedElementVisitors) {
				if (visitor.appliesTo((GuardedElement) guardedElement, context)) {
					return visitor.visit((GuardedElement) guardedElement, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsFix(Fix fix, T context) {
		if (!fixVisitors.isEmpty()) {
			for (FixVisitor<T, R> visitor : fixVisitors) {
				if (visitor.appliesTo((Fix) fix, context)) {
					return visitor.visit((Fix) fix, context, this);
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
	public R visitAsEvlElement(EvlElement evlElement, T context) {
		if (!evlElementVisitors.isEmpty()) {
			for (EvlElementVisitor<T, R> visitor : evlElementVisitors) {
				if (visitor.appliesTo((EvlElement) evlElement, context)) {
					return visitor.visit((EvlElement) evlElement, context, this);
				}
			}
		}
		return null;
	}
	
	public boolean addConstraintVisitor(ConstraintVisitor<T, R> constraintVisitor) {
		return this.constraintVisitors.add(constraintVisitor);
	}
	
	public boolean addCritiqueVisitor(CritiqueVisitor<T, R> critiqueVisitor) {
		return this.critiqueVisitors.add(critiqueVisitor);
	}
	
	public boolean addContextVisitor(ContextVisitor<T, R> contextVisitor) {
		return this.contextVisitors.add(contextVisitor);
	}
	
	public boolean addInvariantVisitor(InvariantVisitor<T, R> invariantVisitor) {
		return this.invariantVisitors.add(invariantVisitor);
	}
	
	public boolean addPreBlockVisitor(PreBlockVisitor<T, R> preBlockVisitor) {
		return this.preBlockVisitors.add(preBlockVisitor);
	}
	
	public boolean addPostBlockVisitor(PostBlockVisitor<T, R> postBlockVisitor) {
		return this.postBlockVisitors.add(postBlockVisitor);
	}
	
	public boolean addEvlProgramVisitor(EvlProgramVisitor<T, R> evlProgramVisitor) {
		return this.evlProgramVisitors.add(evlProgramVisitor);
	}
	
	public boolean addGuardedElementVisitor(GuardedElementVisitor<T, R> guardedElementVisitor) {
		return this.guardedElementVisitors.add(guardedElementVisitor);
	}
	
	public boolean addFixVisitor(FixVisitor<T, R> fixVisitor) {
		return this.fixVisitors.add(fixVisitor);
	}
	
	public boolean addNamedBlockVisitor(NamedBlockVisitor<T, R> namedBlockVisitor) {
		return this.namedBlockVisitors.add(namedBlockVisitor);
	}
	
	public boolean addEvlElementVisitor(EvlElementVisitor<T, R> evlElementVisitor) {
		return this.evlElementVisitors.add(evlElementVisitor);
	}
	

	public boolean removeConstraintVisitor(ConstraintVisitor<T, R> constraintVisitor) {
		return this.constraintVisitors.remove(constraintVisitor);
	}
	
	public boolean removeCritiqueVisitor(CritiqueVisitor<T, R> critiqueVisitor) {
		return this.critiqueVisitors.remove(critiqueVisitor);
	}
	
	public boolean removeContextVisitor(ContextVisitor<T, R> contextVisitor) {
		return this.contextVisitors.remove(contextVisitor);
	}
	
	public boolean removeInvariantVisitor(InvariantVisitor<T, R> invariantVisitor) {
		return this.invariantVisitors.remove(invariantVisitor);
	}
	
	public boolean removePreBlockVisitor(PreBlockVisitor<T, R> preBlockVisitor) {
		return this.preBlockVisitors.remove(preBlockVisitor);
	}
	
	public boolean removePostBlockVisitor(PostBlockVisitor<T, R> postBlockVisitor) {
		return this.postBlockVisitors.remove(postBlockVisitor);
	}
	
	public boolean removeEvlProgramVisitor(EvlProgramVisitor<T, R> evlProgramVisitor) {
		return this.evlProgramVisitors.remove(evlProgramVisitor);
	}
	
	public boolean removeGuardedElementVisitor(GuardedElementVisitor<T, R> guardedElementVisitor) {
		return this.guardedElementVisitors.remove(guardedElementVisitor);
	}
	
	public boolean removeFixVisitor(FixVisitor<T, R> fixVisitor) {
		return this.fixVisitors.remove(fixVisitor);
	}
	
	public boolean removeNamedBlockVisitor(NamedBlockVisitor<T, R> namedBlockVisitor) {
		return this.namedBlockVisitors.remove(namedBlockVisitor);
	}
	
	public boolean removeEvlElementVisitor(EvlElementVisitor<T, R> evlElementVisitor) {
		return this.evlElementVisitors.remove(evlElementVisitor);
	}
	
	
	
}