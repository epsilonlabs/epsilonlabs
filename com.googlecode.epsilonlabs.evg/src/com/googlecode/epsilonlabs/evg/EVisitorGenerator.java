package com.googlecode.epsilonlabs.evg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.swt.widgets.Shell;

public class EVisitorGenerator {
	
	protected GenModel genModel = null;
	protected Shell shell;
	protected IProgressMonitor progressMonitor;
	
	public EVisitorGenerator(GenModel genModel, Shell shell, IProgressMonitor progressMonitor) {
		this.genModel = genModel;
		this.shell = shell;
		this.progressMonitor = progressMonitor;
	}
	
	public void generate(boolean force) throws Exception {
		
		String modelProjectName = genModel.getGenModel().getModelPluginID();
		String visitorProjectName = modelProjectName + ".visitor";
		PluginProjectBuilder projectBuilder = new PluginProjectBuilder();
		List<String> requiredBundles = new ArrayList<String>();
		requiredBundles.addAll(Arrays.asList(modelProjectName, "org.eclipse.emf.common", "org.eclipse.emf.ecore"));
		
		// Create visitor project
		IProject project = projectBuilder.
				setProjectName(visitorProjectName).setShell(shell).
				setProgressMonitor(progressMonitor).
				setOverwriteIfExists(force).
				setExportedPackages(Arrays.asList(visitorProjectName)).
				setRequiredBundles(requiredBundles).
				build();
		
		// Create model
		InMemoryEmfModel model = new InMemoryEmfModel("G", genModel.eResource(), GenModelPackage.eINSTANCE);
		
		
		// Run EGX module
		EglFileGeneratingTemplateFactory templateFactory = new EglFileGeneratingTemplateFactory();
		String src = project.getFolder("src").getLocation().toOSString();
		templateFactory.setOutputRoot(src);
		EgxModule module = new EgxModule(templateFactory);
		
		module.getContext().getModelRepository().addModel(model);
		module.parse(EVisitorGenerator.class.getResource("main.egx").toURI());
		
		// Create extra packages parameter
		List<String> extraBundles = new ArrayList<String>();
		module.getContext().getFrameStack().put(Variable.createReadOnlyVariable("extraBundles", extraBundles));
		
		module.execute();
		
		if (!extraBundles.isEmpty()) {
			requiredBundles.addAll(extraBundles);
			projectBuilder.setRequiredBundles(requiredBundles).createManifest(project);
		}
		
		project.refreshLocal(IResource.DEPTH_INFINITE, progressMonitor);
		
	}
	
	
}
