package org.eclipse.epsilon.emc.jdt;

import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class ICompilationUnitOperationContributor extends OperationContributor {

	@Override
	public boolean contributesTo(Object target) {
		return target instanceof ICompilationUnitOperationContributor;
	}
	
	public CompilationUnit parse() {
		return parse(null);
	}
	
	public CompilationUnit parse(ASTVisitor visitor) {
		ASTParser parser = ASTParser.newParser(AST.JLS4); 
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setSource((ICompilationUnit) target); // set source
		parser.setResolveBindings(true); // we need bindings later on
		CompilationUnit cu = (CompilationUnit) parser.createAST(null /* IProgressMonitor */); // parse
		if (visitor != null) {
			cu.accept(visitor);
		}
		return cu;
	}
	
}
