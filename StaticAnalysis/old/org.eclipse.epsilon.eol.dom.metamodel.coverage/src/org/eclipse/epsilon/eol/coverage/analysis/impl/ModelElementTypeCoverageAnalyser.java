package org.eclipse.epsilon.eol.coverage.analysis.impl;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.epsilon.eol.coverage.analysis.context.CoverageAnalysisContext;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.ModelElementTypeVisitor;

public class ModelElementTypeCoverageAnalyser extends ModelElementTypeVisitor<CoverageAnalysisContext, Object>{

	@Override
	public Object visit(ModelElementType modelElementType,
			CoverageAnalysisContext context,
			EolVisitorController<CoverageAnalysisContext, Object> controller) {
		// TODO Auto-generated method stub
		EClassifier classifier = modelElementType.getEcoreType();
		if (classifier!=null) {
			context.getCoverageAnalysisRepo().add(classifier);
		}
		else {
			context.getLogBook().addError(modelElementType, "This does not have a resolved type, please contact administrator");
		}
		return null;
	}

}
