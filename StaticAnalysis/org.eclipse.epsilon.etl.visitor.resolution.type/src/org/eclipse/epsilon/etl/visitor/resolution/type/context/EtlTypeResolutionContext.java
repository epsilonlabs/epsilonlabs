package org.eclipse.epsilon.etl.visitor.resolution.type.context;


import java.util.ArrayList;

import log.Error;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.epsilon.eol.metamodel.AnnotationBlock;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.SimpleAnnotation;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.etl.metamodel.EtlFactory;
import org.eclipse.epsilon.etl.metamodel.TransformationRule;
import org.eclipse.epsilon.etl.visitor.resolution.type.handler.EquivalentHandler;
import org.eclipse.epsilon.etl.visitor.resolution.type.handler.EquivalentsHandler;

public class EtlTypeResolutionContext extends TypeResolutionContext{

	protected TransformationRule currentRule;
	protected EtlFactory etlFactory = EtlFactory.eINSTANCE;
	protected ArrayList<Expression> surpressionList = new ArrayList<Expression>();
	
	
	public EtlTypeResolutionContext()
	{
		operationDefinitionControl.getHandlerFactory().addHandler(new EquivalentHandler(this));
		operationDefinitionControl.getHandlerFactory().addHandler(new EquivalentsHandler(this));
	}
	
	public EtlFactory getEtlFactory() {
		return etlFactory;
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
	
	public ArrayList<TraceUnitContainer> getTraceUnitContainersWhichTransforms(EClass eClass)
	{
		ArrayList<TraceUnitContainer> normalRules = new ArrayList<TraceUnitContainer>();
		ArrayList<TraceUnitContainer> primaryRules = new ArrayList<TraceUnitContainer>();
		ArrayList<TraceUnitContainer> result = new ArrayList<TraceUnitContainer>();
		for(TraceUnitContainer tuc: traceUnitContainers)
		{
			if (isGreedy(tuc.getTransformationRule())) {
				if (tuc.getSource().equals(eClass)) {
					if (isPrimary(tuc.getTransformationRule())) {
						primaryRules.add(tuc);
					}
					else {
						normalRules.add(tuc);
					}
				}
				else {
					for(EClass superClass: eClass.getEAllSuperTypes())
					{
						if (superClass.equals(tuc.getSource())) {
							if (isPrimary(tuc.getTransformationRule())) {
								primaryRules.add(tuc);
							}
							else {
								normalRules.add(tuc);
							}
						}
					}
				}
			}
			else {
				if (tuc.getSource().equals(eClass)) { //if not greedy if classes match
					if (isPrimary(tuc.getTransformationRule())) { //if is primary rule return immediately
						primaryRules.add(tuc);
					}
					else {
						normalRules.add(tuc);
					}
				}
			}
		}
		result.addAll(primaryRules);
		result.addAll(normalRules);
		return result;
	}
	
	public TraceUnitContainer getTraceUnitContainerWhichTransforms(EClass eClass)
	{
 		TraceUnitContainer first = null;
		for(TraceUnitContainer tuc: traceUnitContainers)
		{
			if (first != null) { //if first is not null
				if (isGreedy(tuc.getTransformationRule())) { //if greedy
					if(tuc.getSource().equals(eClass)) //if source is the type
					{
						if (isPrimary(tuc.getTransformationRule())) { //if source is primary too, then return immediately
							return tuc;
						}
					}
					else {
						for(EClass eClass2: eClass.getEAllSuperTypes()) { //if source is not the type look for sub types
							if (eClass2.equals(tuc.getSource())) { 
								if (isPrimary(tuc.getTransformationRule())) { //if is primary return immediately
									return tuc;
								}
							}
						}
//						for(EClass eClass2: tuc.getSource().getEAllSuperTypes()) { //if source is not the type look for sub types
//							if (eClass2.equals(eClass)) { 
//								if (isPrimary(tuc.getTransformationRule())) { //if is primary return immediately
//									return tuc;
//								}
//							}
//						}	
					}
				}
				else {
					if (tuc.getSource().equals(eClass)) { //if not greedy if classes match
						if (isPrimary(tuc.getTransformationRule())) { //if is primary rule return immediately
							return tuc;
						}
					}
				}
			}
			else { //if first is not null
				if (isGreedy(tuc.getTransformationRule())) { //if greedy
					if(tuc.getSource().equals(eClass))
					{
						if (isPrimary(tuc.getTransformationRule())) { //if is primary then return
							return tuc;
						}
						first = tuc; //record first
					}
					else {
						for(EClass eClass2: eClass.getEAllSuperTypes()) {
							if (eClass2.equals(tuc.getSource())) {
								if (isPrimary(tuc.getTransformationRule())) { //if is primary then return
									return tuc;
								}
								first = tuc; //record first
							}
						}	
					}
				}
				else {
					if (tuc.getSource().equals(eClass)) {
						if (isPrimary(tuc.getTransformationRule())) { //if is primary then return
							return tuc;
						}
						first = tuc; //record first
					}
				}
			}
			
		}
		return first;
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
	
	public boolean isGreedy(TransformationRule rule)
	{
		AnnotationBlock annot = rule.getAnnotationBlock();
		if (annot != null) {
			for(SimpleAnnotation sa: annot.getSimpleAnnotations())
			{
				if (sa.getName().getName().equals("greedy")) {
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
	
	public void addSupression(Expression expr)
	{
		surpressionList.add(expr);
	}
	
	public void supressErrors()
	{
		ArrayList<log.Error> errors = (ArrayList<Error>) getLogBook().getErrors().clone();
		for(Expression expr: surpressionList)
		{
			for(log.Error error: errors)
			{
				if (error.getDomElement().equals(expr)) {
					getLogBook().getErrors().remove(error);
				}
			}
		}
	}
	
	

}
