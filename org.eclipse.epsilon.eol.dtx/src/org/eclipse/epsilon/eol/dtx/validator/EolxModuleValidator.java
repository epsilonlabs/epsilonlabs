package org.eclipse.epsilon.eol.dtx.validator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.IModuleValidator;
import org.eclipse.epsilon.common.module.ModuleMarker;
import org.eclipse.epsilon.common.module.ModuleMarker.Severity;
import org.eclipse.epsilon.common.parse.Region;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.ast2eol.context.Ast2EolContext;
import org.eclipse.epsilon.eol.ast2eol.context.EolElementCreatorFactory;
import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.TextRegion;
import org.eclipse.epsilon.eol.problem.EOLError;
import org.eclipse.epsilon.eol.problem.EOLWarning;
import org.eclipse.epsilon.eol.visitor.resolution.variable.impl.VariableResolver;

public class EolxModuleValidator implements IModuleValidator {

	
	@Override
	public List<ModuleMarker> validate(IModule module) {
		
		ArrayList<ModuleMarker> markers = new ArrayList<ModuleMarker>();
		
		if (module instanceof EolModule) {

			Ast2EolContext ast2EolContext = new Ast2EolContext((EolModule) module);
			EolElementCreatorFactory factory = ast2EolContext.getEolElementCreatorFactory();
			EOLElement eolElement = factory.createEOLElement(module.getAst(), null, ast2EolContext);
			
			VariableResolver variableResolver = new VariableResolver();
			variableResolver.run(eolElement);
			
			int warnings = 0;
			for(EOLWarning warning: variableResolver.getVariableResolutionContext().getLogBook().getWarnings())
			{
				TextRegion textRegion = warning.getEolElement().getRegion();
				Region region = new Region(textRegion.getStart().getLine(), textRegion.getStart().getColumn(), textRegion.getEnd().getLine(), textRegion.getEnd().getColumn());
				ModuleMarker marker = new ModuleMarker(null, region, warning.getMessage(), Severity.Warning);
				markers.add(marker);
			}
			
			for(EOLError error: variableResolver.getVariableResolutionContext().getLogBook().getErrors())
			{
				TextRegion textRegion = error.getEolElement().getRegion();
				Region region = new Region(textRegion.getStart().getLine(), textRegion.getStart().getColumn(), textRegion.getEnd().getLine(), textRegion.getEnd().getColumn());
				ModuleMarker marker = new ModuleMarker(null, region, error.getMessage(), Severity.Error);
				markers.add(marker);
			}
		}
		return markers;
	}

	@Override
	public String getMarkerType() {
		// TODO Auto-generated method stub
		
		return null;
	}

}
