package org.eclipse.epsilon.live;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.commons.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.EolEvaluator;
import org.eclipse.epsilon.eol.EolModule;

@SuppressWarnings("serial")
public class EolEvaluatorServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//String response = "";
		resp.setContentType("text/html");
		
		//System.err.println(req.getServerName());
		
		String server = "";
		
		if ("localhost".equals(req.getServerName())) {
			server = "localhost:8080";
			//System.err.println("Source: " + req.getParameter("source"));
		}
		else {
			server = "epsilon-live.appspot.com";
		}
		
		EolModule module = new EolModule();
		StringOutputStream output = new StringOutputStream();
		EmfModel model = new EmfModel();
		StringProperties properties = new StringProperties();
		properties.put(EmfModel.PROPERTY_NAME, "Ecore");
		properties.put(EmfModel.PROPERTY_MODEL_FILE, "http://" + server + "/Ecore.ecore");
		properties.put(EmfModel.PROPERTY_METAMODEL_FILE, "http://" + server + "/Ecore.ecore");
		properties.put(EmfModel.PROPERTY_IS_METAMODEL_FILE_BASED, "true");
		properties.put(EmfModel.PROPERTY_READONLOAD, "true");
		properties.put(EmfModel.PROPERTY_STOREONDISPOSAL, "false");
		
		try {
			model.load(properties, null);
			module.parse(req.getParameter("source"));
			
			if (module.getParseProblems().size() > 0) {
				for (ParseProblem problem : module.getParseProblems()) {
					resp.getWriter().println("Syntax error: " + problem.toString() + "");
				}
				return;
			}
			
			module.getContext().getModelRepository().addModel(model);
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
