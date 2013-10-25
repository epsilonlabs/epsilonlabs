package org.eclipse.epsilon.emc.argouml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

import javax.jmi.model.MofClass;
import javax.jmi.reflect.RefPackage;
import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

import org.argouml.application.Main;
import org.argouml.application.SubsystemUtility;
import org.argouml.application.api.Argo;
import org.argouml.application.helpers.ApplicationVersion;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.checklist.ui.InitCheckListUI;
import org.argouml.cognitive.ui.InitCognitiveUI;
import org.argouml.configuration.Configuration;
import org.argouml.i18n.Translator;
import org.argouml.kernel.Command;
import org.argouml.kernel.NonUndoableCommand;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.XmiReferenceException;
import org.argouml.model.XmiReferenceRuntimeException;
import org.argouml.notation.InitNotation;
import org.argouml.notation.providers.java.InitNotationJava;
import org.argouml.notation.providers.uml.InitNotationUml;
import org.argouml.notation.ui.InitNotationUI;
import org.argouml.persistence.AbstractFilePersister;
import org.argouml.persistence.OpenException;
import org.argouml.persistence.PersistenceManager;
import org.argouml.persistence.ProjectFilePersister;
import org.argouml.persistence.UmlVersionException;
import org.argouml.persistence.VersionException;
import org.argouml.persistence.XmiFormatException;
import org.argouml.profile.ProfileFacade;
import org.argouml.profile.internal.ProfileManagerImpl;
import org.argouml.taskmgmt.ProgressMonitor;
import org.argouml.ui.cmd.InitUiCmdSubsystem;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.activity.ui.InitActivityDiagram;
import org.argouml.uml.diagram.collaboration.ui.InitCollaborationDiagram;
import org.argouml.uml.diagram.deployment.ui.InitDeploymentDiagram;
import org.argouml.uml.diagram.state.ui.InitStateDiagram;
import org.argouml.uml.diagram.static_structure.ui.InitClassDiagram;
import org.argouml.uml.diagram.ui.InitDiagramAppearanceUI;
import org.argouml.uml.diagram.use_case.ui.InitUseCaseDiagram;
import org.argouml.uml.ui.ActionOpenProject;
import org.argouml.uml.ui.InitUmlUI;
import org.argouml.util.ThreadUtils;
import org.omg.uml.modelmanagement.Model;

public class ArgoUMLApp {
	
	
	public static void main(String[] args) throws Exception {
		
		File zargo = new File("/Users/dimitrioskolovos/Dropbox/SOAR/assessment/solution/soho2.zargo");
		File dummy1 = new File("/Users/dimitrioskolovos/Desktop/dummy1.zargo");
		File dummy2 = new File("/Users/dimitrioskolovos/Desktop/dummy2.zargo");
		
		File file = dummy1;
		File saveAs = dummy2;
		
		Configuration.load();
		Main.initVersion();
		PersistenceManager pm = PersistenceManager.getInstance();
		AbstractFilePersister persister = pm.getPersisterFromFileName(file.getAbsolutePath());
		InitializeModel.initializeDefault();
        ProfileFacade.setManager(new ProfileManagerImpl());
        
        
     // new InitUiCmdSubsystem().init();
      //new InitNotationUI().init();
      //new InitNotation().init();
      new InitNotationUml().init();
      //new InitNotationJava().init();
      //new InitDiagramAppearanceUI().init();
      //new InitActivityDiagram().init();
      //new InitCollaborationDiagram().init();
      //new InitDeploymentDiagram().init();
      //new InitStateDiagram().init();
      //new InitClassDiagram().init();
      //new InitUseCaseDiagram().init();
      //new InitUmlUI().init();
     // new InitCheckListUI().init();
      //new InitCognitiveUI().init();
               
		Project project = persister.doLoad(file);
		
		
		Iterator<?> it = project.getModels().iterator();
		Model model = null;
		while (it.hasNext()) {
			model = (Model) it.next();
		}
		
		model.setName("Brand new name");
		
		
		for (Object o : model.refClass().refOutermostPackage().refAllPackages()) {
			System.out.println("P -> " + o);
		}
		
		RefPackage p = model.refOutermostPackage();
		for (Object o : model.refClass().refImmediatePackage().refAllClasses()) {
			System.out.println(o);
		}
		
		//MofClass mc = (MofClass) model.refMetaObject();
		
		//System.err.println(mc.refClass().refGetValue("name"));
		//System.out.println(model.refMetaObject());
		for (Object o : p.refAllClasses()) {
			System.out.println(o);
		}
		
		/*
		// Look at registerDiagramsInternal for projects
		// that don't have diagrams
		System.err.println(project.getDiagramList());
		project.setActiveDiagram(project.getDiagramList().get(0));
		
		persister.save(project, saveAs);*/
	}
	
	public static void main2(String[] args) throws Exception {
		
		File zargo = new File("/Users/dimitrioskolovos/Dropbox/SOAR/assessment/solution/soho2.zargo");
		File dummy1 = new File("/Users/dimitrioskolovos/Desktop/dummy1.zargo");
		File dummy2 = new File("/Users/dimitrioskolovos/Desktop/dummy2.zargo");
		final String[] profilesDirectories = new String[]{"/Users/dimitrioskolovos/Desktop/custom-profiles"};
		
		File file = dummy1;
		File saveAs = dummy2;
		
		Configuration.load();
		Main.initVersion();
		PersistenceManager pm = PersistenceManager.getInstance();
		AbstractFilePersister persister = pm.getPersisterFromFileName(file.getAbsolutePath());
		InitializeModel.initializeDefault();
		
		ProfileManagerImpl profileManager = new ProfileManagerImpl() {
			public void refreshRegisteredProfiles() {
				
				for (String profilesDirectory : new ArrayList<String>(getSearchPathDirectories())) {
					removeSearchPathDirectory(profilesDirectory);
				}
				
				for (String profilesDirectory : profilesDirectories) {
					addSearchPathDirectory(profilesDirectory);
				}
				super.refreshRegisteredProfiles();
			};
		};
		
        ProfileFacade.setManager(profileManager);
		Project project = persister.doLoad(file);
		
		/*
		Iterator<?> it = project.getModels().iterator();
		Model model = null;
		while (it.hasNext()) {
			model = (Model) it.next();
		}
		
		model.setName("Brand new name");
		*/
		
		//System.err.println("** " + project.getVersion());
		persister.save(project, saveAs);
		
		//System.out.println(.getClass().getCanonicalName());
		
	}
	
    public static Project loadProject2(File file, boolean showUI,
            ProgressMonitor pmw) {

        PersistenceManager pm = PersistenceManager.getInstance();
        Project oldProject = ProjectManager.getManager().getCurrentProject();
        if (oldProject != null) {
            // Remove the old project first.  It's wasteful to create a temp
            // empty project, but too much of ArgoUML depends on having a
            // current project
            Project p = ProjectManager.getManager().makeEmptyProject();
            ProjectManager.getManager().setCurrentProject(p);
            ProjectManager.getManager().removeProject(oldProject);
            oldProject = p;
        }

        boolean success = false;

        // TODO:
        // This is actually a hack! Some diagram types
        // (like the statechart diagrams) access the current
        // diagram to get some info. This might cause
        // problems if there's another statechart diagram
        // active, so I remove the current project, before
        // loading the new one.

        Designer.disableCritiquing();
        Designer.clearCritiquing();
        Project project = null;

        if (!(file.canRead())) {
            Designer.enableCritiquing();
            success = false;
        } else {
            // Hide save action during load. Otherwise we get the
            // * appearing in title bar and the save enabling as models are
            // updated
            // TODO: Do we still need this now the save enablement is improved?
            ProjectManager.getManager().setSaveAction(null);
            try {
                ProjectFilePersister persister =
                    pm.getPersisterFromFileName(file.getName());
                if (persister == null) {
                    throw new IllegalStateException("Filename "
                            + file.getName()
                            + " is not of a known file type");
                }

                if (pmw != null) {
                    persister.addProgressListener(pmw);
                }


                project = persister.doLoad(file);

                if (pmw != null) {
                    persister.removeProgressListener(pmw);
                }
                ThreadUtils.checkIfInterrupted();
                // Let's save this project as the last used one
                // in the configuration file
                Configuration.setString(Argo.KEY_MOST_RECENT_PROJECT_FILE,
                        file.getCanonicalPath());
                success = true;
            } catch (Exception ex) {
            	ex.printStackTrace();
            } finally {

                try {
                    if (!success) {
                        project =
                            ProjectManager.getManager().makeEmptyProject();
                    }
                    ProjectManager.getManager().setCurrentProject(project);
                    if (oldProject != null) {
                        ProjectManager.getManager().removeProject(oldProject);
                    }

                    project.getProjectSettings().init();

                    Command cmd = new NonUndoableCommand() {
                        public Object execute() {
                            // This is temporary. Load project
                            // should create a new project
                            // with its own UndoManager and so
                            // there should be no Command
                            return null;
                        }
                    };
                    project.getUndoManager().addCommand(cmd);
                    Designer.enableCritiquing();
                } finally {
                    
                }
            }
        }
        if (!success) {
            return null;
        }
        return project;
    }

	
}
