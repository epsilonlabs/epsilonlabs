package org.eclipse.epsilon.eol.dom.ast2dom.dt;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.visitor.resolution.variable.impl.VariableResolver;
import org.eclipse.epsilon.eol.ast2dom.Ast2DomContext;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class ParseEolFileAction implements IObjectActionDelegate {

	private Shell shell;
	private IStructuredSelection selection;
	
	/**
	 * Constructor for Action1.
	 */
	public ParseEolFileAction() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		IFile file = (IFile) this.selection.getFirstElement();
		String path = file.getLocation().toOSString();
		EolModule eolModule = new EolModule();
		try {
			eolModule.parse(new File(path));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Ast2DomContext context = new Ast2DomContext();
		EolElement dom = context.getEolElementCreatorFactory().createDomElement(eolModule.getAst(), null, context);
		
		System.err.println(context.getEolElementCreatorFactory().isProperlyContained() ? "DomElements are property contained" : "DomElements are NOT properly contained");

		//VariableResolutionContext resolutionContext = new VariableResolutionContext();
		
		//resolutionContext.getDomElementVariableResolverFactory().resolve(dom, resolutionContext);
		
		VariableResolver app = new VariableResolver();
		app.run(dom);
		
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		Resource resource = resourceSet.createResource(URI.createFileURI(new File(path + ".xmi").getAbsolutePath()));
		resource.getContents().add(dom);
		System.out.println(resourceSet.getPackageRegistry().toString());
		System.out.println(EPackage.Registry.INSTANCE.toString());
		try {
			resource.save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			file.getParent().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = (IStructuredSelection) selection;
	}

}
