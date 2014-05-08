package org.eclipse.epsilon.eol.dtx.validator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.IModuleValidator;
import org.eclipse.epsilon.common.module.ModuleMarker;
import org.eclipse.epsilon.common.module.ModuleMarker.Severity;
import org.eclipse.epsilon.common.parse.Region;
import org.eclipse.epsilon.eol.ast2eol.Ast2EolContext;
import org.eclipse.epsilon.eol.ast2eol.EolElementCreatorFactory;
import org.eclipse.epsilon.eol.coverage.analysis.impl.CoverageAnalyser;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.TextRegion;
import org.eclipse.epsilon.eol.performance.analysis.impl.Optimiser;
import org.eclipse.epsilon.eol.visitor.resolution.type.impl.TypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.variable.impl.VariableResolver;

public class EolxModuleValidator implements IModuleValidator{

	@Override
	public String getMarkerType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ModuleMarker> validate(IModule arg0) {
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
				
		String path = arg0.getSourceUri().getPath();
		//System.err.println("=============" + path);
		int lastIndexOf = path.lastIndexOf("/");
		//System.out.println("--------------------" + lastIndexOf);
		//System.out.println("=======================" + path.substring(0, lastIndexOf+1));
		String directoryPathString = path.substring(0, lastIndexOf+1);
		

		EolElementCreatorFactory factory = new EolElementCreatorFactory(directoryPathString);
		Ast2EolContext context = new Ast2EolContext(factory);
		EolElement dom = factory.createDomElement(arg0.getAst(), null, context);
		
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
		tr.getTypeResolutionContext().setDirectoryPathString(directoryPathString);
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
		o.getOptimisationContext().setDirectoryPathString(directoryPathString);
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

}
