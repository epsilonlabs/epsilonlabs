package org.eclipse.epsilon.etl.visitor.resolution.type.context;


import org.eclipse.epsilon.eol.metamodel.AnnotationBlock;
import org.eclipse.epsilon.eol.metamodel.SimpleAnnotation;
import org.eclipse.epsilon.eol.visitor.resolution.type.context.TypeResolutionContext;
import org.eclipse.epsilon.etl.metamodel.TransformationRule;

public class EtlTypeResolutionContext extends TypeResolutionContext{

	//protected HashMap<TransformationRule, ArrayList<ENamedElement>> transformation
	
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
