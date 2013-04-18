package com.googlecode.epsilonlabs.evg;

import java.util.Arrays;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
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
	
	public void generate() throws Exception {
		
		String projectName = genModel.getGenModel().getModelPluginID() + ".visitor";
		
		// Create visitor project if it does not exist
		IProject project = new PluginProjectBuilder().
				setProjectName(projectName).setShell(shell).
				setProgressMonitor(progressMonitor).setOverwriteIfExists(true).
				setExportedPackages(Arrays.asList(projectName)).build();
		
		// Create model
		InMemoryEmfModel model = new InMemoryEmfModel("G", genModel.eResource(), GenModelPackage.eINSTANCE);
		
		// Run EGX module
		EglFileGeneratingTemplateFactory templateFactory = new EglFileGeneratingTemplateFactory();
		String src = project.getFolder("src").getLocation().toOSString();
		templateFactory.setOutputRoot(src);
		EgxModule module = new EgxModule(templateFactory);
		
		module.getContext().getModelRepository().addModel(model);
		module.parse(EVisitorGenerator.class.getResource("main.egx").toURI());
		module.execute();
		
		project.refreshLocal(IResource.DEPTH_INFINITE, progressMonitor);
		
	}
	
	
}
