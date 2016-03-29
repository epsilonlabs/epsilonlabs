package org.eclipse.epsilon.evl.dtx.validator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.IModuleValidator;
import org.eclipse.epsilon.common.module.ModuleMarker;
import org.eclipse.epsilon.common.module.ModuleMarker.Severity;
import org.eclipse.epsilon.common.parse.Region;
import org.eclipse.epsilon.eol.EolLibraryModule;
import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.metamodel.TextRegion;
import org.eclipse.epsilon.eol.problem.EOLError;
import org.eclipse.epsilon.eol.problem.EOLWarning;
import org.eclipse.epsilon.eol.problem.LogBook;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.ast2evl.Ast2EvlContext;
import org.eclipse.epsilon.evl.ast2evl.EvlElementCreatorFactory;
import org.eclipse.epsilon.evl.visitor.resolution.impl.EvlVariableResolver;
import org.eclipse.epsilon.evl.visitor.resolution.type.context.EvlTypeResolutionContext;
import org.eclipse.epsilon.evl.visitor.resolution.type.impl.EvlTypeResolver;

public class EvlxModuleValidator implements IModuleValidator{

	@Override
	public List<ModuleMarker> validate(IModule module) {
		
		ArrayList<ModuleMarker> markers = new ArrayList<ModuleMarker>();
		
		if (module instanceof EvlModule) {
			String path = module.getSourceUri().getPath();
			//System.err.println("=============" + path);
			
			//System.out.println("--------------------" + lastIndexOf);
			//System.out.println("=======================" + path.substring(0, lastIndexOf+1));
			int lastIndexOf = path.lastIndexOf("/");
			String directoryPathString = path.substring(0, lastIndexOf+1);
			

			Ast2EvlContext ast2EtlContext = new Ast2EvlContext((EolLibraryModule) module);
			EvlElementCreatorFactory factory = ast2EtlContext.getEvlElementCreatorFactory();
			EOLElement eolElement = factory.createDomElement(module.getAst(), null, ast2EtlContext);
			LogBook.getInstance(true);
			
			EvlVariableResolver variableResolver = new EvlVariableResolver();
			variableResolver.getContext().setEolModule( (EolLibraryModule) module);
			variableResolver.run(eolElement);
			
			EvlTypeResolver typeResolver = new EvlTypeResolver((EolLibraryModule) module);
			EvlTypeResolutionContext.getInstance().setEolModule( (EolLibraryModule) module);
			typeResolver.run(eolElement);
			
			int warnings = 0;
			for(EOLError error: LogBook.getInstance().getAllErrors())
			{  
				TextRegion textRegion = error.getEolElement().getRegion();
				Region region = new Region(textRegion.getStart().getLine(), textRegion.getStart().getColumn(), textRegion.getEnd().getLine(), textRegion.getEnd().getColumn());
				ModuleMarker marker = new ModuleMarker(null, region, error.getMessage(), Severity.Error);
				markers.add(marker);
			}
			for(EOLWarning warning: LogBook.getInstance().getAllWarnings())
			{
				TextRegion textRegion = warning.getEolElement().getRegion();
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

	@Override
	public String getMarkerType() {
		// TODO Auto-generated method stub
		return null;
	}

}
