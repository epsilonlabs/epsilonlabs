package org.eclipse.epsilon.etl.visitor.printer.impl;

import java.util.Iterator;

import org.eclipse.epsilon.eol.metamodel.FormalParameterExpression;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.visitor.printer.context.PrinterContext;

import org.eclipse.epsilon.etl.metamodel.TransformationRule;
import org.eclipse.epsilon.etl.metamodel.visitor.EtlVisitorController;
import org.eclipse.epsilon.etl.metamodel.visitor.TransformationRuleVisitor;

public class TransformationRulePrinter extends TransformationRuleVisitor<PrinterContext, Object>{

	@Override
	public Object visit(TransformationRule transformationRule,
			PrinterContext context,
			EtlVisitorController<PrinterContext, Object> controller) {
		String result = "";
		if (transformationRule.getAnnotationBlock() != null) {
			result += controller.visit(transformationRule.getAnnotationBlock(), context);
			result += context.newline();	
		}
		result += "rule";
		result += " " + controller.visit(transformationRule.getName(), context);
		result += context.newline();
		context.indent();
		result += "transform " + controller.visit(transformationRule.getSource(), context);
		result += context.newline();
		result += "to ";
		if (transformationRule.getTargets() != null && transformationRule.getTargets().size() != 0) {
			Iterator<FormalParameterExpression> iterator = transformationRule.getTargets().iterator();
			while(iterator.hasNext())
			{
				result += controller.visit(iterator.next(), context);
				if (iterator.hasNext()) {
					result += ", ";
				}
			}
		}
		if (transformationRule.getExtends() != null && transformationRule.getExtends().size() != 0) {
			result += "extends ";
			Iterator<NameExpression> iterator = transformationRule.getExtends().iterator();
			while(iterator.hasNext())
			{
				result += controller.visit(iterator.next(), context);
				if (iterator.hasNext()) {
					result += ", ";
				}
			}
		}
		result += " {" + context.newline();
		
		if (transformationRule.getGuard() != null) {
			result += controller.visit(transformationRule.getGuard(), context);
		}
		
		result += controller.visit(transformationRule.getBody(), context);
		
		
		context.outdent();
		result += context.whitespace() + "}";
		return result;
	}

}
