package org.eclipse.epsilon.emc.argouml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.jmi.reflect.RefPackage;
import javax.xml.transform.TransformerFactory;

import org.argouml.application.Main;
import org.argouml.configuration.Configuration;
import org.argouml.kernel.Project;
import org.argouml.model.InitializeModel;
import org.argouml.notation.providers.uml.InitNotationUml;
import org.argouml.persistence.AbstractFilePersister;
import org.argouml.persistence.PersistenceManager;
import org.argouml.profile.ProfileFacade;
import org.argouml.profile.ProfileManager;
import org.argouml.profile.internal.ProfileManagerImpl;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.omg.uml.modelmanagement.Model;

public class ArgoUMLModel extends AbstractMdrModel {

	public static String PROPERTY_MODEL_FILE = "modelFile";
	public static String PROPERTY_OVERRIDE_PROFILE_DIRECTORIES = "overrideProfileDirectories";
	public static String PROPERTY_PROFILE_DIRECTORIES = "profileDirectories";
	
	protected RefPackage refPackage = null;
	protected String modelFile = null;
	protected Project project = null;
	protected AbstractFilePersister persister = null;
	protected boolean overrideProfileDirectories;
	protected List<String> profileDirectories = new ArrayList<String>();
	
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
	public void load(StringProperties properties, String basePath)
			throws EolModelLoadingException {
		super.load(properties, basePath);
		
		modelFile = properties.getProperty(PROPERTY_MODEL_FILE, "");
		
		if (basePath != null) {
			modelFile = basePath + modelFile;
		}
		
		overrideProfileDirectories = properties.getBooleanProperty(PROPERTY_OVERRIDE_PROFILE_DIRECTORIES, false);
		String profileDirectoriesString = properties.getProperty(PROPERTY_PROFILE_DIRECTORIES, "");
		for (String profileDirectory : profileDirectoriesString.split(";")) {
			profileDirectories.add(profileDirectory.trim());
		}
		
		load();
	}
	
	@Override
	public void load() throws EolModelLoadingException {
		
		try {
			
			//System.err.println(" --- " + TransformerFactory.newInstance().getClass().getCanonicalName());
			
			File file = new File(modelFile);

			Configuration.load();
			Main.initVersion();
			PersistenceManager pm = PersistenceManager.getInstance();
			persister = pm.getPersisterFromFileName(file.getAbsolutePath());
			InitializeModel.initializeDefault();
			
			ProfileManager profileManager = new ProfileManagerImpl() {
				
				public void refreshRegisteredProfiles() {
					
					if (overrideProfileDirectories) {
						for (String profilesDirectory : new ArrayList<String>(getSearchPathDirectories())) {
							removeSearchPathDirectory(profilesDirectory);
						}
					}
					
					for (String profilesDirectory : profileDirectories) {
						addSearchPathDirectory(profilesDirectory);
					}
					
					super.refreshRegisteredProfiles();
				};
			};
			
			ProfileFacade.setManager(profileManager);
			new InitNotationUml().init();
			project = persister.doLoad(file);

			Model model = (Model) project.getUserDefinedModelList().get(0);	
			refPackage = model.refClass().refOutermostPackage();
			
		}
		catch (Exception ex) {
			throw new EolModelLoadingException(ex, this);
		}
		finally {
			//System.setProperty("javax.xml.transform.TransformerFactory", "null");
			System.clearProperty("javax.xml.transform.TransformerFactory");
		}
			
	}

	@Override
	public boolean store(String location) {
		try {
			// Look at registerDiagramsInternal for projects
			// that don't have diagrams
			project.setActiveDiagram(project.getDiagramList().get(0));
			persister.save(project, new File(location));
			return true;
		}
		catch (Exception ex) {
			throw new RuntimeException("An error occured while saving model " + this.getName() + " under " + location, ex);
		}
	}

	@Override
	public boolean store() {
		return store(modelFile);
	}
	
	public boolean isOverrideProfileDirectories() {
		return overrideProfileDirectories;
	}
	
	public void setOverrideProfileDirectories(boolean overrideProfileDirectories) {
		this.overrideProfileDirectories = overrideProfileDirectories;
	}
	
	public List<String> getProfileDirectories() {
		return profileDirectories;
	}
	
	public void setProfileDirectories(List<String> profileDirectories) {
		this.profileDirectories = profileDirectories;
	}

}
