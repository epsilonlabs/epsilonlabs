package org.eclipse.epsilon.emc.argouml;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javax.jmi.model.MofClass;
import javax.jmi.reflect.RefPackage;

import org.argouml.application.Main;
import org.argouml.configuration.Configuration;
import org.argouml.kernel.Project;
import org.argouml.model.InitializeModel;
import org.argouml.notation.providers.uml.InitNotationUml;
import org.argouml.persistence.AbstractFilePersister;
import org.argouml.persistence.PersistenceManager;
import org.argouml.profile.ProfileFacade;
import org.argouml.profile.internal.ProfileManagerImpl;
import org.eclipse.epsilon.emc.mdr.AbstractMdrModel;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.omg.uml.modelmanagement.Model;

public class ArgoUMLModel extends AbstractMdrModel {

	protected RefPackage refPackage = null;
	protected String modelFile = null;
	protected Project project = null;
	protected AbstractFilePersister persister = null;
	
	public static void main(String[] args) throws Exception {
		
		ArgoUMLModel model = new ArgoUMLModel();
		model.setModelFile("/Users/dimitrioskolovos/Desktop/dummy1.zargo");
		model.setName("M");
		model.load();
		
		EolModule module = new EolModule();
		module.parse("for (c in ModelElement.all.println()) { c.stereotype.name.println(); }");
		module.getContext().getModelRepository().addModel(model);
		module.execute();
		
	}
	
	public String getModelFile() {
		return modelFile;
	}
	
	public void setModelFile(String modelFile) {
		this.modelFile = modelFile;
	}
	
	@Override
	public RefPackage getRefPackage() {
		return refPackage;
	}

	@Override
	public void load() throws EolModelLoadingException {
		
		try {

			File file = new File(modelFile);

			Configuration.load();
			Main.initVersion();
			PersistenceManager pm = PersistenceManager.getInstance();
			persister = pm.getPersisterFromFileName(file
					.getAbsolutePath());
			InitializeModel.initializeDefault();
			ProfileFacade.setManager(new ProfileManagerImpl());

			new InitNotationUml().init();
			project = persister.doLoad(file);

			
			Model model = (Model) new ArrayList<Object>(project.getModels()).get(1);
			/*
			Iterator<?> it = project.getModels().iterator();
			Model model = null;
			
			
			int i = 0;
			while (it.hasNext()) {
				i++;
				if (i == 1) model = (Model) it.next();
				//System.out.println(((MofClass)model.refMetaObject()).getName());
			}*/
			
			refPackage = model.refClass().refOutermostPackage();
			
			/*
			model.setName("Brand new name");

			for (Object o : model.refClass().refOutermostPackage()
					.refAllPackages()) {
				System.out.println("P -> " + o);
			}

			RefPackage p = model.refOutermostPackage();
			for (Object o : model.refClass().refImmediatePackage()
					.refAllClasses()) {
				System.out.println(o);
			}

			// MofClass mc = (MofClass) model.refMetaObject();

			// System.err.println(mc.refClass().refGetValue("name"));
			// System.out.println(model.refMetaObject());
			for (Object o : p.refAllClasses()) {
				System.out.println(o);
			}*/
		}
		catch (Exception ex) {
			throw new EolModelLoadingException(ex, this);
		}
		/*
		// Look at registerDiagramsInternal for projects
		// that don't have diagrams
		System.err.println(project.getDiagramList());
		project.setActiveDiagram(project.getDiagramList().get(0));
		
		persister.save(project, saveAs);*/		
	}

	@Override
	public boolean store(String location) {
		return false;
	}

	@Override
	public boolean store() {
		return false;
	}

}
