package org.eclipse.epsilon.eol.dom.staticanalysisdemo.dt;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.IModuleValidator;
import org.eclipse.epsilon.common.module.ModuleMarker;
import org.eclipse.epsilon.common.module.ModuleMarker.Severity;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.parse.Region;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.TextRegion;
import org.eclipse.epsilon.eol.dom.ast2dom.Ast2DomContext;
import org.eclipse.epsilon.eol.dom.ast2dom.EolElementCreatorFactory;
import org.eclipse.epsilon.eol.dom.metamodel.coverage.impl.CoverageAnalyser;
import org.eclipse.epsilon.eol.dom.visitor.optimisation.impl.Optimiser;
import org.eclipse.epsilon.eol.dom.visitor.resolution.type.impl.TypeResolver;
import org.eclipse.epsilon.eol.dom.visitor.resolution.variable.impl.VariableResolver;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.epsilon.eol.parse.Eol_EolParserRules.logicalExpression_return;

public class DummyModuleValidator implements IModuleValidator {

	public DummyModuleValidator() {
	}

	@Override
	public List<ModuleMarker> validate(IModule module) {
		ArrayList<ModuleMarker> markers = new ArrayList<ModuleMarker>();
		
		// Creates dummy warning markers for all "for" statements
		// and error markers for all "if" statements
		/*for (AST ast : module.getAst().getDescendants()) {
			if (ast.getType() == EolParser.FOR) {
				// file can be null - doesn't matter yet
				markers.add(new ModuleMarker(null, ast.getRegion(), "For loops are discouraged", Severity.Warning));
			}
			else if (ast.getType() == EolParser.IF) {
				markers.add(new ModuleMarker(null, ast.getRegion(), "If statements are out of question", Severity.Error));				
			}
		}*/
				
		String path = module.getSourceUri().getPath();
		//System.err.println("=============" + path);
		int lastIndexOf = path.lastIndexOf("/");
		//System.out.println("--------------------" + lastIndexOf);
		//System.out.println("=======================" + path.substring(0, lastIndexOf+1));
		String directoryPathString = path.substring(0, lastIndexOf+1);
		

		EolElementCreatorFactory factory = new EolElementCreatorFactory(directoryPathString);
		Ast2DomContext context = new Ast2DomContext(factory);
		DomElement dom = factory.createDomElement(module.getAst(), null, context);
		
		VariableResolver vr = new VariableResolver();
		vr.run(dom);
		int warnings = 0;
		for(log.Error error: vr.getVariableResolutionContext().getLogBook().getErrors())
		{  
			TextRegion textRegion = error.getDomElement().getRegion();
			Region region = new Region(textRegion.getStart().getLine(), textRegion.getStart().getColumn(), textRegion.getEnd().getLine(), textRegion.getEnd().getColumn());
			ModuleMarker marker = new ModuleMarker(null, region, error.getMessage(), Severity.Error);
			markers.add(marker);
		}
		for(log.Warning warning: vr.getVariableResolutionContext().getLogBook().getWarnings())
		{
			TextRegion textRegion = warning.getDomElement().getRegion();
			Region region = new Region(textRegion.getStart().getLine(), textRegion.getStart().getColumn(), textRegion.getEnd().getLine(), textRegion.getEnd().getColumn());

			ModuleMarker marker = new ModuleMarker(null, region, warning.getMessage(), Severity.Warning);
			markers.add(marker);
			warnings++;
		}
		
		TypeResolver tr = new TypeResolver();
		tr.run(dom);
		
		for(log.Error error: tr.getTypeResolutionContext().getLogBook().getErrors())
		{
			TextRegion textRegion = error.getDomElement().getRegion();
			Region region = new Region(textRegion.getStart().getLine(), textRegion.getStart().getColumn(), textRegion.getEnd().getLine(), textRegion.getEnd().getColumn());
			ModuleMarker marker = new ModuleMarker(null, region, error.getMessage(), Severity.Error);
			markers.add(marker);
		}
		for(log.Warning warning: tr.getTypeResolutionContext().getLogBook().getWarnings())
		{
			TextRegion textRegion = warning.getDomElement().getRegion();
			Region region = new Region(textRegion.getStart().getLine(), textRegion.getStart().getColumn(), textRegion.getEnd().getLine(), textRegion.getEnd().getColumn());

			ModuleMarker marker = new ModuleMarker(null, region, warning.getMessage(), Severity.Warning);
			markers.add(marker);
			warnings++;
		}
		
		Optimiser o = new Optimiser();
		o.run(dom);
		
		for(log.Error error: o.getOptimisationContext().getLogBook().getErrors())
		{
			TextRegion textRegion = error.getDomElement().getRegion();
			Region region = new Region(textRegion.getStart().getLine(), textRegion.getStart().getColumn(), textRegion.getEnd().getLine(), textRegion.getEnd().getColumn());
			ModuleMarker marker = new ModuleMarker(null, region, error.getMessage(), Severity.Error);
			markers.add(marker);
		}
		
		for(log.Warning warning: o.getOptimisationContext().getLogBook().getWarnings())
		{
			TextRegion textRegion = warning.getDomElement().getRegion();
			Region region = new Region(textRegion.getStart().getLine(), textRegion.getStart().getColumn(), textRegion.getEnd().getLine(), textRegion.getEnd().getColumn());

			ModuleMarker marker = new ModuleMarker(null, region, warning.getMessage(), Severity.Warning);
			markers.add(marker);
		}
		
		CoverageAnalyser ca = new CoverageAnalyser();
		ca.run(dom);
		ca.print();
		for(log.Error error: ca.getCoverageAnalysisContext().getLogBook().getErrors())
		{
			TextRegion textRegion = error.getDomElement().getRegion();
			Region region = new Region(textRegion.getStart().getLine(), textRegion.getStart().getColumn(), textRegion.getEnd().getLine(), textRegion.getEnd().getColumn());
			ModuleMarker marker = new ModuleMarker(null, region, error.getMessage(), Severity.Error);
			markers.add(marker);
		}
		System.err.println("warnings are : " + warnings);
		return markers;
	}

	@Override
	public String getMarkerType() {
		// TODO Auto-generated method stub
		return null;
	}

}
