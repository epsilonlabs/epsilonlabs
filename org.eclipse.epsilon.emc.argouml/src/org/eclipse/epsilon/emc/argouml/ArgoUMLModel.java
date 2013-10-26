package org.eclipse.epsilon.emc.argouml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.jmi.reflect.RefPackage;
import javax.xml.transform.TransformerFactory;

import org.argouml.application.Main;
import org.argouml.configuration.Configuration;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.notation.providers.uml.InitNotationUml;
import org.argouml.persistence.AbstractFilePersister;
import org.argouml.persistence.PersistenceManager;
import org.argouml.profile.Profile;
import org.argouml.profile.ProfileFacade;
import org.argouml.profile.ProfileManager;
import org.argouml.profile.internal.ProfileManagerImpl;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.CachedModel;
import org.omg.uml.foundation.core.ModelElement;
import org.omg.uml.foundation.core.Stereotype;
import org.omg.uml.foundation.core.UmlClass;
import org.omg.uml.modelmanagement.Model;
import org.omg.uml.modelmanagement.UmlPackage;

public class ArgoUMLModel extends AbstractMdrModel {

	public static String PROPERTY_MODEL_FILE = "modelFile";
	public static String PROPERTY_IGNORE_ARGOUML_PROFILE_DIRECTORIES = "overrideProfileDirectories";
	public static String PROPERTY_PROFILE_DIRECTORIES = "profileDirectories";
	public static String PROPERTY_PROFILE_WORKSPACE_DIRECTORIES = "profileWorkspaceDirectories";
	
	protected RefPackage refPackage = null;
	protected String modelFile = null;
	protected Project project = null;
	protected AbstractFilePersister persister = null;
	protected boolean overrideProfileDirectories;
	protected List<String> profileDirectories = new ArrayList<String>();
	protected ProfileManager profileManager = null;
	protected Model model = null;
	
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
	
	public Profile applyProfile(String profileName) {
		Profile profile = null;
		
		// Check to see whether the project already has a profile with this name
		for (Profile p : project.getProfileConfiguration().getProfiles()) {
			if (p.getProfileIdentifier().equals(profileName)) {
				return p;
			}
		}
		
		// Find the profile
		for (Profile p : profileManager.getRegisteredProfiles()) {
			if (p.getProfileIdentifier().equals(profileName)) {
				profile = p;
				break;
			}
		}
		
		if (profile == null) throw new RuntimeException("Could not find profile " + profileName);
		
		project.getProfileConfiguration().addProfile(profile, model);
		return profile;
	}
	
	public Stereotype getStereotype(String stereotypeName) {
		for (Profile p : project.getProfileConfiguration().getProfiles()) {
			Stereotype stereotype = getStereotype(p.getProfileIdentifier(), stereotypeName);
			if (stereotype != null) {
				return stereotype;
			}
		}
		return null;
	}
	
	public Stereotype getStereotype(String profileName, String stereotypeName) {
		
		Profile profile = null;
		
		for (Profile p : project.getProfileConfiguration().getProfiles()) {
			if (p.getProfileIdentifier().equals(profileName)) {
				profile = p;
				break;
			}
		}
		
		if (profile == null) return null;

		try {
			for (Object o : profile.getProfilePackages()) {
				UmlPackage profilePackage = (UmlPackage) o;
				for (Object ownedElement : profilePackage.getOwnedElement()) {
					if (ownedElement instanceof Stereotype) {
						Stereotype stereotype = (Stereotype) ownedElement;
						if (stereotype.getName().equals(stereotypeName)) {
							return stereotype;
						}
					}
				}
			}
		}
		catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return null;
	}
	
	@Override
	public void load(StringProperties properties, String basePath)
			throws EolModelLoadingException {
		super.load(properties, basePath);
		
		modelFile = properties.getProperty(PROPERTY_MODEL_FILE, "");
		
		if (basePath != null) {
			modelFile = basePath + modelFile;
		}
		
		cacheElements = properties.getBooleanProperty(CachedModel.PROPERTY_CACHED, true);
		overrideProfileDirectories = properties.getBooleanProperty(PROPERTY_IGNORE_ARGOUML_PROFILE_DIRECTORIES, false);
		String profileDirectoriesString = properties.getProperty(PROPERTY_PROFILE_DIRECTORIES, "");
		if (profileDirectoriesString.trim().length() > 0) {
			for (String profileDirectory : profileDirectoriesString.split(";")) {
				profileDirectories.add(profileDirectory.trim());
			}
		}
		
		String profileWorkspaceDirectoriesString = properties.getProperty(PROPERTY_PROFILE_WORKSPACE_DIRECTORIES, "");
		if (basePath != null && profileWorkspaceDirectoriesString.trim().length() > 0) {
			for (String profileDirectory : profileWorkspaceDirectoriesString.split(";")) {
				profileDirectories.add(basePath + profileDirectory.trim());
			}
		}
		
		load();
	}
	
	@Override
	public void load() throws EolModelLoadingException {
		
		try {
			File file = new File(modelFile);

			Configuration.load();
			Main.initVersion();
			PersistenceManager pm = PersistenceManager.getInstance();
			persister = pm.getPersisterFromFileName(file.getAbsolutePath());
			InitializeModel.initializeDefault();
			
			profileManager = new ProfileManagerImpl() {
				
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
			
			for (Project oldProject : new ArrayList<Project>(ProjectManager.getManager().getOpenProjects())) {
				ProjectManager.getManager().removeProject(oldProject);
			}
			
			if (readOnLoad) {
				project = persister.doLoad(file);
			}
			else {
				project = ProjectManager.getManager().makeEmptyProject(true);
			}
			
			model = (Model) project.getUserDefinedModelList().get(0);	
			refPackage = model.refClass().refOutermostPackage();
			
		}
		catch (Exception ex) {
			throw new EolModelLoadingException(ex, this);
		}
		finally {
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
