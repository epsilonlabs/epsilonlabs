package org.eclipse.epsilon.etl.dtx.validator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.IModuleValidator;
import org.eclipse.epsilon.common.module.ModuleMarker;
import org.eclipse.epsilon.common.module.ModuleMarker.Severity;
import org.eclipse.epsilon.common.parse.Region;
import org.eclipse.epsilon.eol.EolLibraryModule;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.TextRegion;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.etl.ast2etl.Ast2EtlContext;
import org.eclipse.epsilon.etl.ast2etl.EtlElementCreatorFactory;
import org.eclipse.epsilon.etl.visitor.resolution.type.impl.EtlTypeResolver;
import org.eclipse.epsilon.etl.visitor.resolution.variable.impl.EtlVariableResolver;

public class EtlxModuleValidator implements IModuleValidator{

	@Override
	public String getMarkerType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ModuleMarker> validate(IModule arg0) {
		
		ArrayList<ModuleMarker> markers = new ArrayList<ModuleMarker>();
		
		if (arg0 instanceof EtlModule) {
			String path = arg0.getSourceUri().getPath();
			//System.err.println("=============" + path);
			
			//System.out.println("--------------------" + lastIndexOf);
			//System.out.println("=======================" + path.substring(0, lastIndexOf+1));
			int lastIndexOf = path.lastIndexOf("/");
			String directoryPathString = path.substring(0, lastIndexOf+1);
			

			Ast2EtlContext context = new Ast2EtlContext((EolLibraryModule) arg0);
			EtlElementCreatorFactory factory = context.getEtlElementCreatorFactory();
			EolElement dom = factory.createDomElement(arg0.getAst(), null, context);
			
			EtlVariableResolver etlvr = new EtlVariableResolver();
			etlvr.run(dom);
			
			EtlTypeResolver etltr = new EtlTypeResolver((EolLibraryModule) arg0);
			etltr.run(dom);
			
			int warnings = 0;
			for(log.Error error: etlvr.getContext().getLogBook().getErrors())
			{  
				TextRegion textRegion = error.getDomElement().getRegion();
				Region region = new Region(textRegion.getStart().getLine(), textRegion.getStart().getColumn(), textRegion.getEnd().getLine(), textRegion.getEnd().getColumn());
				ModuleMarker marker = new ModuleMarker(null, region, error.getMessage(), Severity.Error);
				markers.add(marker);
			}
			for(log.Warning warning: etlvr.getContext().getLogBook().getWarnings())
			{
				TextRegion textRegion = warning.getDomElement().getRegion();
				Region region = new Region(textRegion.getStart().getLine(), textRegion.getStart().getColumn(), textRegion.getEnd().getLine(), textRegion.getEnd().getColumn());

				ModuleMarker marker = new ModuleMarker(null, region, warning.getMessage(), Severity.Warning);
				markers.add(marker);
				warnings++;
			}
			
			
			for(log.Error error: etltr.getContext().getLogBook().getErrors())
			{
				TextRegion textRegion = error.getDomElement().getRegion();
				Region region = new Region(textRegion.getStart().getLine(), textRegion.getStart().getColumn(), textRegion.getEnd().getLine(), textRegion.getEnd().getColumn());
				ModuleMarker marker = new ModuleMarker(null, region, error.getMessage(), Severity.Error);
				markers.add(marker);
			}
			for(log.Warning warning: etltr.getContext().getLogBook().getWarnings())
			{
				TextRegion textRegion = warning.getDomElement().getRegion();
				Region region = new Region(textRegion.getStart().getLine(), textRegion.getStart().getColumn(), textRegion.getEnd().getLine(), textRegion.getEnd().getColumn());

				ModuleMarker marker = new ModuleMarker(null, region, warning.getMessage(), Severity.Warning);
				markers.add(marker);
				warnings++;
			}
			
//			Optimiser o = new Optimiser();
//			o.getOptimisationContext().setDirectoryPathString(directoryPathString);
//			o.run(dom);
//			
//			for(log.Error error: o.getOptimisationContext().getLogBook().getErrors())
//			{
//				TextRegion textRegion = error.getDomElement().getRegion();
//				Region region = new Region(textRegion.getStart().getLine(), textRegion.getStart().getColumn(), textRegion.getEnd().getLine(), textRegion.getEnd().getColumn());
//				ModuleMarker marker = new ModuleMarker(null, region, error.getMessage(), Severity.Error);
//				markers.add(marker);
//			}
//			
//			for(log.Warning warning: o.getOptimisationContext().getLogBook().getWarnings())
//			{
//				TextRegion textRegion = warning.getDomElement().getRegion();
//				Region region = new Region(textRegion.getStart().getLine(), textRegion.getStart().getColumn(), textRegion.getEnd().getLine(), textRegion.getEnd().getColumn());
	//
//				ModuleMarker marker = new ModuleMarker(null, region, warning.getMessage(), Severity.Warning);
//				markers.add(marker);
//			}
//			
//			CoverageAnalyser ca = new CoverageAnalyser();
//			ca.run(dom);
//			ca.print();
//			for(log.Error error: ca.getCoverageAnalysisContext().getLogBook().getErrors())
//			{
//				TextRegion textRegion = error.getDomElement().getRegion();
//				Region region = new Region(textRegion.getStart().getLine(), textRegion.getStart().getColumn(), textRegion.getEnd().getLine(), textRegion.getEnd().getColumn());
//				ModuleMarker marker = new ModuleMarker(null, region, error.getMessage(), Severity.Error);
//				markers.add(marker);
//			}
			System.err.println("warnings are : " + warnings);
		}
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
				
		
		return markers;
	}

}
