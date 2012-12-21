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
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IInitializer;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.ILocalVariable;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.SimpleName;

public class JdtModel extends JavaModel {
	
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
		    
		    /*
		    addClasses(IJavaProject.class, IPackageFragment.class, ICompilationUnit.class,
		    	IType.class, IField.class, IMethod.class, IInitializer.class, 
		    	ILocalVariable.class);
		    */
		    
		    ASTCollector astCollector = new ASTCollector();
		    ICompilationUnitOperationContributor compilationUnitOperationContributor = new ICompilationUnitOperationContributor();
		    
		    for (IJavaProject javaProject : javaProjects) {
		    	addObject(javaProject);
		    	for (IPackageFragment packageFragment : javaProject.getPackageFragments()) {
		    		if (packageFragment.getKind() == IPackageFragmentRoot.K_SOURCE) {
		    			addObject(packageFragment);
		    			for (ICompilationUnit compilationUnit : packageFragment.getCompilationUnits()) {
		    				addObject(compilationUnit);
		    				
		    				compilationUnitOperationContributor.setTarget(compilationUnit);
		    				compilationUnitOperationContributor.parse(astCollector);
		    				
		    				/*
		    				for (IType type : compilationUnit.getTypes()) {
		    					addObject(type);
		    					for (IMethod method : type.getMethods()) {
		    						addObject(method);
		    						for (ILocalVariable parameter : method.getParameters()) {
		    							addObject(parameter);
		    						}
		    					}
		    					for (IField field : type.getFields()) {
		    						addObject(field);
		    					}
		    					for (IInitializer initialiser : type.getInitializers()) {
		    						addObject(initialiser);
		    					}
		    				}*/
		    			}
		    		}
		    	}
		    }
		    
		}
		catch (Exception ex) {
			//throw new EolModelLoadingException(ex, this);
		}
	}

	protected IJavaProject createJavaProject(IProject project) throws JavaModelException {
		IJavaProject javaProject = JavaCore.create(project);
		javaProject.open(new NullProgressMonitor());
		return javaProject;
	}
	
	@Override
	public boolean hasType(String type) {
		if (!super.hasType(type)) {
			try {
				addClass(Class.forName("org.eclipse.jdt.core.dom." + type));
				return true;
			}
			catch (Exception ex) {
				System.err.println("No class: " + type);
				return false;
			}
		}
		return true;
	}
	
	class ASTCollector extends ASTVisitor {
		@Override
		public void preVisit(ASTNode node) {
			if (!(node instanceof SimpleName))
			addObject(node);
		}
	}
	
}
