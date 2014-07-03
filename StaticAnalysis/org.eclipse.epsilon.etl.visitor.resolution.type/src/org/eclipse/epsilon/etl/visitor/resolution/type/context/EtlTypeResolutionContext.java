package org.eclipse.epsilon.etl.visitor.resolution.type.context;


import java.util.ArrayList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.epsilon.eol.metamodel.AnnotationBlock;
import org.eclipse.epsilon.eol.metamodel.SimpleAnnotation;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.etl.metamodel.TransformationRule;
import org.eclipse.epsilon.etl.visitor.resolution.type.handler.EquivalentHandler;
import org.eclipse.epsilon.etl.visitor.resolution.type.handler.EquivalentsHandler;

public class EtlTypeResolutionContext extends TypeResolutionContext{

	protected TransformationRule currentRule;
	
	public EtlTypeResolutionContext()
	{
		operationDefinitionControl.getHandlerFactory().addHandler(new EquivalentHandler(this));
		operationDefinitionControl.getHandlerFactory().addHandler(new EquivalentsHandler(this));
	}
	
	public void setCurrentRule(TransformationRule currentRule) {
		this.currentRule = currentRule;
	}
	
	public TransformationRule getCurrentRule() {
		return currentRule;
	}
	
	public void printTraceUnitContainers()
	{
		for(TraceUnitContainer tuc: traceUnitContainers)
		{
			System.out.println(tuc.toString());
		}
	}
	
	protected ArrayList<TraceUnitContainer> traceUnitContainers = new ArrayList<TraceUnitContainer>();
	
	public void addTraceUnitContainer(TraceUnitContainer container)
	{
		traceUnitContainers.add(container);
	}
	
	public void addTraceUnitContainer(TransformationRule rule)
	{
		traceUnitContainers.add(new TraceUnitContainer(rule));
	}
	
	public ArrayList<TraceUnitContainer> getTraceUnitContainers() {
		return traceUnitContainers;
	}
	
	public TraceUnitContainer getTraceUnitContainer(String name)
	{
		for(TraceUnitContainer tuc: traceUnitContainers)
		{
			if (tuc.getName().equals(name)) {
				return tuc;
			}
		}
		return null;
	}
	
	public TraceUnitContainer getTraceUnitContainerWhichTransforms(EClass eClass, boolean greedy)
	{
		for(TraceUnitContainer tuc: traceUnitContainers)
		{
			if (greedy) {
				if(tuc.getSource().equals(eClass))
				{
					return tuc;
				}
				else {
					for(EClass eClass2: tuc.getSource().getEAllSuperTypes()) {
						if (eClass2.equals(eClass)) {
							return tuc;
						}
					}	
				}
			}
			else {
				if (tuc.getSource().equals(eClass)) {
					return tuc;
				}
			}
		}
		return null;
	}
	
	public boolean isAbstract(TransformationRule rule)
	{
		AnnotationBlock annot = rule.getAnnotationBlock();
		if (annot != null) {
			for(SimpleAnnotation sa: annot.getSimpleAnnotations())
			{
				if (sa.getName().getName().equals("abstract")) {
					return true;
				}
			}
			return false;
		}
		else {
			return false;
		}
	}
	
	public boolean isLazy(TransformationRule rule)
	{
		AnnotationBlock annot = rule.getAnnotationBlock();
		if (annot != null) {
			for(SimpleAnnotation sa: annot.getSimpleAnnotations())
			{
				if (sa.getName().getName().equals("lazy")) {
					return true;
				}
			}
			return false;
		}
		else {
			return false;
		}
	}
	
	public boolean isPrimary(TransformationRule rule)
	{
		AnnotationBlock annot = rule.getAnnotationBlock();
		if (annot != null) {
			for(SimpleAnnotation sa: annot.getSimpleAnnotations())
			{
				if (sa.getName().getName().equals("primary")) {
					return true;
				}
			}
			return false;
		}
		else {
			return false;
		}
	}
	
	public boolean isKindOf(TransformationRule rule, String kind)
	{
		AnnotationBlock annot = rule.getAnnotationBlock();
		if (annot != null) {
			for(SimpleAnnotation sa: annot.getSimpleAnnotations())
			{
				if (sa.getName().getName().equals(kind)) {
					return true;
				}
			}
			return false;
		}
		else {
			return false;
		}
	}
}
