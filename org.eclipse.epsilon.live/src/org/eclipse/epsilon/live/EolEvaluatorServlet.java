package org.eclipse.epsilon.live;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.EolModule;

@SuppressWarnings("serial")
public class EolEvaluatorServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		
		EolModule module = new EolModule();
		StringOutputStream output = new StringOutputStream();
		
		ResourceSet rs = new ResourceSetImpl();
		rs.getPackageRegistry().put(EcorePackage.eINSTANCE.getNsURI(), EcorePackage.eINSTANCE);
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		Resource r = null;
		EPackage metamodel = null;
		
		if (req.getParameter("metamodel") == null) {
			r = rs.createResource(URI.createURI(""));
			r.getContents().add(EcoreUtil.copy(EcorePackage.eINSTANCE));
			metamodel = EcorePackage.eINSTANCE;
		}
		else {
			r = rs.createResource(URI.createURI(req.getParameter("metamodel")));
			r.load(Collections.emptyMap());
			metamodel = (EPackage) r.getContents().get(0);

			rs = new ResourceSetImpl();
			rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
			rs.getPackageRegistry().put(metamodel.getNsURI(), metamodel);
			r = rs.createResource(URI.createURI(req.getParameter("model")));
			r.load(Collections.emptyMap());
		}
		
		try {
			InMemoryEmfModel model = new InMemoryEmfModel("M", r, metamodel);
			module.parse(req.getParameter("source"));
			
			if (module.getParseProblems().size() > 0) {
				for (ParseProblem problem : module.getParseProblems()) {
					resp.getWriter().println("Syntax error: " + problem.toString() + "");
				}
				return;
			}
			
			module.getContext().getModelRepository().addModel(model);
			module.getContext().getPrettyPrinterManager().addPrettyPrinter(new SecretiveEmfPrettyPrinter());
			module.getContext().setOutputStream(new PrintStream(output));
			module.getContext().setErrorStream(new PrintStream(output));
			module.execute();
		} catch (Exception e) {
			resp.getWriter().println(e.getMessage());
			return;
		}

		resp.getWriter().println(output.getValue());
		
		module.getContext().getModelRepository().dispose();
		module.getContext().dispose();
		
	}
	
	public class StringOutputStream extends OutputStream {
		
		protected String value = "";
		
		public String getValue() {
			return value;
		}
		
		@Override
		public void write(int ch) throws IOException {
			value += (char) ch;
		}
		
	}
}
