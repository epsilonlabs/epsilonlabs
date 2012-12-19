package org.eclipse.epsilon.emc.jdt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.models.Model;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

public class JdtModel extends Model {
	
	public static String PROPERTY_PROJECT_NAME = "projectName";
	protected String projectName = null;
	protected List<IJavaProject> javaProjects = new ArrayList<IJavaProject>();
	
	@Override
	public void load(StringProperties properties, String basePath)
			throws EolModelLoadingException {
		super.load(properties, basePath);
		this.projectName = properties.getProperty(JdtModel.PROPERTY_PROJECT_NAME);
		load();
	}
	
	public List<IJavaProject> getJavaProjects() {
		return javaProjects;
	}
	
	@Override
	public void load() throws EolModelLoadingException {
		try {
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
		    IWorkspaceRoot root = workspace.getRoot();

		    if (!"*".equals(projectName)) {
			    IProject project = root.getProject(projectName);
			    if (project != null && project.hasNature(JavaCore.NATURE_ID)) {
			    	javaProjects.add(createJavaProject(project));
			    }
		    }
		    else {
		    	for (IProject project : root.getProjects()) {
		    		if (project.hasNature(JavaCore.NATURE_ID)) {
				    	javaProjects.add(createJavaProject(project));
				    }
		    	}
		    }
		}
		catch (Exception ex) {
			throw new EolModelLoadingException(ex, this);
		}
	}

	protected IJavaProject createJavaProject(IProject project) throws JavaModelException {
		IJavaProject javaProject = JavaCore.create(project);
		javaProject.open(new NullProgressMonitor());
		return javaProject;
	}
	
	@Override
	public Object getEnumerationValue(String enumeration, String label)
			throws EolEnumerationValueNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<?> allContents() {
		return javaProjects;
	}

	@Override
	public Collection<?> getAllOfType(String type)
			throws EolModelElementTypeNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<?> getAllOfKind(String type)
			throws EolModelElementTypeNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getTypeOf(Object instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTypeNameOf(Object instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object createInstance(String type)
			throws EolModelElementTypeNotFoundException,
			EolNotInstantiableModelElementTypeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getElementById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getElementId(Object instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setElementId(Object instance, String newId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteElement(Object instance) throws EolRuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean owns(Object instance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInstantiable(String type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isModelElement(Object instance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasType(String type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean store(String location) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean store() {
		// TODO Auto-generated method stub
		return false;
	}

}
