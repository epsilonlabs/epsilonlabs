package com.googlecode.epsilonlabs.evg;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class PluginProjectBuilder {
	
	protected String projectName = "";
	protected List<String> srcFolders = Arrays.asList("src");
	protected List<IProject> referencedProjects = new ArrayList<IProject>();
	protected List<String> requiredBundles = new ArrayList<String>();
	protected List<String> exportedPackages = new ArrayList<String>();
	protected IProgressMonitor progressMonitor = new NullProgressMonitor(); 
	protected Shell shell = null;
	protected boolean overwriteIfExists = false;
	protected boolean confirmOverwrite = true;
	
	public PluginProjectBuilder setProjectName(String projectName) {
		this.projectName = projectName;
		return this;
	}
	
	public PluginProjectBuilder setSrcFolders(List<String> srcFolders) {
		this.srcFolders = srcFolders;
		return this;
	}
	
	public PluginProjectBuilder setReferencedProjects(List<IProject> referencedProjects) {
		this.referencedProjects = referencedProjects;
		return this;
	}
	
	public PluginProjectBuilder setRequiredBundles(List<String> requiredBundles) {
		this.requiredBundles = requiredBundles;
		return this;
	}
	
	public PluginProjectBuilder setExportedPackages(List<String> exportedPackages) {
		this.exportedPackages = exportedPackages;
		return this;
	}
	
	public PluginProjectBuilder setProgressMonitor(IProgressMonitor progressMonitor) {
		this.progressMonitor = progressMonitor;
		return this;
	}
	
	public PluginProjectBuilder setShell(Shell shell) {
		this.shell = shell;
		return this;
	}
	
	public PluginProjectBuilder setOverwriteIfExists(boolean overwriteIfExists) {
		this.overwriteIfExists = overwriteIfExists;
		return this;
	}
	
	public PluginProjectBuilder setReferencedProjectNames(List<String> referencedProjectNames) {
		for (String referencedProjectName : referencedProjectNames) {
			referencedProjects.add(ResourcesPlugin.getWorkspace().getRoot().getProject(referencedProjectName));
		}
		return this;
	}
	
	public PluginProjectBuilder setConfirmOverwrite(boolean confirmOverwrite) {
		this.confirmOverwrite = confirmOverwrite;
		return this;
	}
	
	public IProject build() throws CoreException, IOException {
		IProject project = null;
		try {
			progressMonitor.beginTask("", 10);
			progressMonitor.subTask("Creating project " + projectName);
			final IWorkspace workspace = ResourcesPlugin.getWorkspace();
			project = workspace.getRoot().getProject(projectName);

			if (project.exists()) {
				
				if (!overwriteIfExists) return project;
				
				if (confirmOverwrite) {
					final boolean[] result = new boolean[1];
					PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
						public void run() {
							result[0] = MessageDialog.openQuestion(shell, "Do you want to overwrite the project "
									+ projectName, "Note that everything inside the project '" + projectName
									+ "' will be deleted if you confirm this dialog.");
						}
					});
					if (result[0]) {
						project.delete(true, true, new SubProgressMonitor(progressMonitor, 1));
					}
					else
						return null;
				}
				else {
					project.delete(true, true, new SubProgressMonitor(progressMonitor, 1));					
				}
			}

			final IJavaProject javaProject = JavaCore.create(project);
			final IProjectDescription projectDescription = ResourcesPlugin.getWorkspace().newProjectDescription(
					projectName);
			projectDescription.setLocation(null);
			project.create(projectDescription, new SubProgressMonitor(progressMonitor, 1));
			final List<IClasspathEntry> classpathEntries = new ArrayList<IClasspathEntry>();
			if (referencedProjects.size() != 0) {
				projectDescription.setReferencedProjects(referencedProjects.toArray(new IProject[referencedProjects
				                                                                                 .size()]));
				for (final IProject referencedProject : referencedProjects) {
					final IClasspathEntry referencedProjectClasspathEntry = JavaCore.newProjectEntry(referencedProject
							.getFullPath());
					classpathEntries.add(referencedProjectClasspathEntry);
				}
			}

			projectDescription.setNatureIds(new String[] { JavaCore.NATURE_ID, "org.eclipse.pde.PluginNature"});

			final ICommand java = projectDescription.newCommand();
			java.setBuilderName(JavaCore.BUILDER_ID);

			final ICommand manifest = projectDescription.newCommand();
			manifest.setBuilderName("org.eclipse.pde.ManifestBuilder");

			final ICommand schema = projectDescription.newCommand();
			schema.setBuilderName("org.eclipse.pde.SchemaBuilder");

			projectDescription.setBuildSpec(new ICommand[] { java, manifest, schema });

			project.open(new SubProgressMonitor(progressMonitor, 1));
			project.setDescription(projectDescription, new SubProgressMonitor(progressMonitor, 1));

			Collections.reverse(srcFolders);
			for (final String src : srcFolders) {
				final IFolder srcContainer = project.getFolder(src);
				if (!srcContainer.exists()) {
					srcContainer.create(false, true, new SubProgressMonitor(progressMonitor, 1));
				}
				final IClasspathEntry srcClasspathEntry = JavaCore.newSourceEntry(srcContainer.getFullPath());
				classpathEntries.add(0, srcClasspathEntry);
			}

			classpathEntries
					.add(JavaCore
							.newContainerEntry(new Path(
									"org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/J2SE-1.5")));
			classpathEntries.add(JavaCore.newContainerEntry(new Path("org.eclipse.pde.core.requiredPlugins")));

			javaProject.setRawClasspath(classpathEntries.toArray(new IClasspathEntry[classpathEntries.size()]),
					new SubProgressMonitor(progressMonitor, 1));

			javaProject.setOutputLocation(new Path("/" + projectName + "/bin"), new SubProgressMonitor(progressMonitor,
					1));
			createManifest(project);
			createBuildProps(project);
		}
		catch (CoreException exception) {
			throw exception;
		}
		finally {
			progressMonitor.done();
		}

		return project;
		
	}

	private IFile createFile(final String name, final IContainer container, final String content) throws CoreException, IOException {
		final IFile file = container.getFile(new Path(name));
		assertExist(file.getParent());
		
		final InputStream stream = new ByteArrayInputStream(content.getBytes(file.getCharset()));
		if (file.exists()) {
			file.setContents(stream, true, true, progressMonitor);
		}
		else {
			file.create(stream, true, progressMonitor);
		}
		stream.close();
		
		progressMonitor.worked(1);

		return file;
	}

	private void createBuildProps(final IProject project) throws CoreException, IOException {
		final StringBuilder bpContent = new StringBuilder("source.. = ");
		for (final Iterator<String> iterator = srcFolders.iterator(); iterator.hasNext();) {
			bpContent.append(iterator.next()).append('/');
			if (iterator.hasNext()) {
				bpContent.append(",");
			}
		}
		bpContent.append("\n");
		bpContent.append("bin.includes = META-INF/,.\n");
		createFile("build.properties", project, bpContent.toString());
	}

	private void createManifest(final IProject project)
	throws CoreException, IOException {
		final StringBuilder maniContent = new StringBuilder("Manifest-Version: 1.0\n");
		maniContent.append("Bundle-ManifestVersion: 2\n");
		maniContent.append("Bundle-Name: " + projectName + "\n");
		maniContent.append("Bundle-SymbolicName: " + projectName + "; singleton:=true\n");
		maniContent.append("Bundle-Version: 1.0.0\n");
		// maniContent.append("Bundle-Localization: plugin\n");
		if (!requiredBundles.isEmpty()) {
			maniContent.append("Require-Bundle: ");
			boolean first = true;
			for (String entry : requiredBundles) {
				if (first) { first = false; continue; }
				maniContent.append(" " + entry + ",\n");
			}
			maniContent.append(" " + requiredBundles.get(0) + "\n");
		}
		//maniContent.append(" org.openarchitectureware.dependencies\n");

		if (exportedPackages != null && !exportedPackages.isEmpty()) {
			maniContent.append("Export-Package: " + exportedPackages.get(0));
			for (int i = 1, x = exportedPackages.size(); i < x; i++) {
				maniContent.append(",\n " + exportedPackages.get(i));
			}
			maniContent.append("\n");
		}
		//maniContent.append("Bundle-RequiredExecutionEnvironment: J2SE-1.5\r\n");

		final IFolder metaInf = project.getFolder("META-INF");
		metaInf.create(false, true, new SubProgressMonitor(progressMonitor, 1));
		createFile("MANIFEST.MF", metaInf, maniContent.toString());
	}

	private void assertExist(final IContainer c) {
		if (!c.exists()) {
			if (!c.getParent().exists()) {
				assertExist(c.getParent());
			}
			if (c instanceof IFolder) {
				try {
					((IFolder) c).create(false, true, new NullProgressMonitor());
				}
				catch (final CoreException e) {
					//OawLog.logError(e);
				}
			}

		}

	}

}
