package com.googlecode.epsilonlabs.evg;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class EVisitorGeneratorActionDelegate implements IObjectActionDelegate {

	private Shell shell;
	protected IStructuredSelection selection = null;
	
	/**
	 * Constructor for Action1.
	 */
	public EVisitorGeneratorActionDelegate() {
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
		
		try {
			new EVisitorGenerator((GenModel) selection.getFirstElement(), shell, new NullProgressMonitor()).generate();
		} catch (Exception e) {
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
