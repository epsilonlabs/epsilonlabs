package org.eclipse.epsilon.eol.dom.metamodel.coverage.impl;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.dom.ModelElementType;
import org.eclipse.epsilon.eol.dom.metamodel.coverage.context.CoverageAnalysisContext;
import org.eclipse.epsilon.eol.dom.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.dom.visitor.ModelElementTypeVisitor;

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
