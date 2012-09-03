package org.eclipse.epsilon.eol.dom.ast2dom.workbench;


import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.parse.EpsilonTreeAdaptor;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.Program;
import org.eclipse.epsilon.eol.dom.ast2dom.Ast2DomContext;
import org.eclipse.epsilon.eol.dom.printer.*;
import org.eclipse.epsilon.eol.parse.EolLexer;
import org.eclipse.epsilon.eol.parse.EolParser;

public class Ast2DomWorkbench {

	public static void main(String[] args) throws Exception {
		new Ast2DomWorkbench().run();
	}
	
	public void run() throws Exception {
		
		URL url = getClass().getResource("test3.eol");
		
		File file = new File(url.getPath());
		//File file = new File("/org.eclipse.epsilon.static.analyser.prototype/src/org/eclipse/epsilon/sa/dom/test.eol");
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(file));
		EolLexer lexer = new EolLexer(input);
		CommonTokenStream stream = new CommonTokenStream(lexer);
		EolParser parser = new EolParser(stream);
		EpsilonTreeAdaptor adaptor = new EpsilonTreeAdaptor(file);
		parser.setDeepTreeAdaptor(adaptor);
		
		AST ast = (AST) parser.eolModule().getTree();		
		System.err.println(ast.toStringTree());
		
		Ast2DomContext context = new Ast2DomContext();
		DomElement de = context.getDomElementCreatorFactory().createDomElement(ast, null, context);
		
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		Resource resource = resourceSet.createResource(URI.createFileURI(new File("test3.xmi").getAbsolutePath()));
		resource.getContents().add(de);
		resource.save(null);
		
		System.out.println(new DomElementPrinterFactory().print((Program)de));
		

	}
}
