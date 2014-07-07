package org.eclipse.epsilon.etl.visitor.coverage.analysis.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.epsilon.eol.metamodel.ModelElementType;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ModelElementTypeVisitor;
import org.eclipse.epsilon.etl.visitor.coverage.analysis.context.CoverageAnalysisContext;

public class ModelElementTypeCoverageAnalyser extends ModelElementTypeVisitor<CoverageAnalysisContext, Object>{

	@Override
	public Object visit(ModelElementType modelElementType,
			CoverageAnalysisContext context,
			EolVisitorController<CoverageAnalysisContext, Object> controller) {
		context.add((EClass) modelElementType.getEcoreType());
		return null;
	}

}
