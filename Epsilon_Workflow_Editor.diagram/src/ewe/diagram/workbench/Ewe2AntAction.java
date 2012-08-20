package ewe.diagram.workbench;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.commons.util.StringProperties;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplate;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplateFactoryModuleAdapter;
import org.eclipse.epsilon.egl.formatter.Formatter;
import org.eclipse.epsilon.egl.formatter.language.XmlFormatter;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.EvlUnsatisfiedConstraint;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

class EvlValidateException extends Exception {
	
}

public class Ewe2AntAction implements IObjectActionDelegate {
	
	private Shell shell;
	
	private IFile selectedFile;
	
	protected IEolExecutableModule module;
	
	protected Object result;

	@Override
	public void run(final IAction action) {
		Job job = new Job("Generating Epsilon Workflow XML..") {
			protected IStatus run(IProgressMonitor monitor) {
				try {
					runAction(action);
				} catch (Exception ex) {
					// Produce log message before displaying message
					// Swapping the order seems to prevent the message from being logged
					LogUtil.log(ex);
					PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
						public void run() {
							MessageDialog.openError(shell, "Error",
							"An error has occured. Please see the Error Log.");
						}
					});
				}
				return Status.OK_STATUS;
			}
		};
		job.setPriority(Job.SHORT);
		job.schedule();
	}
	
	private void runAction(IAction action) throws Exception {
		EmfModel eweModel = null;
		try {
			//First perform validation by running EVL script. Exit if there are any errors.
			System.out.println("Running action to generate XML File");
			eweModel = createEmfModelByURI(selectedFile.getName(), selectedFile.getLocationURI().toString(),"ewe", true, false);
			try {
				doValidate(eweModel);
			} catch (EvlValidateException e) {
				PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
					public void run() {
						MessageDialog.openInformation(shell, "Unsatisfied Constraints Detected",
						"Please run Edit->Validate to check unsatisfied constraints and correct them");
					}
				});
				return;
			}
			//No validation errors. Generate the ANT XML file.
			doGenerate(eweModel);
			selectedFile.getParent().refreshLocal(1, null);
		} finally {
			if(eweModel!=null) eweModel.dispose();
		}
	}
	
	private void doValidate(EmfModel model) throws EvlValidateException, Exception {
		EvlModule evlModule = new EvlModule();
		evlModule.parse(getFile("ewechecker.evl"));
		evlModule.getContext().getModelRepository().addModel(model);
		evlModule.execute();
		Collection<EvlUnsatisfiedConstraint> unsatisfied = evlModule.getContext().getUnsatisfiedConstraints();
		if (unsatisfied.size() > 0) {
				throw new EvlValidateException();
		}
	}
	
	private void doGenerate(EmfModel model) throws Exception {
		EglFileGeneratingTemplateFactory factory = new EglFileGeneratingTemplateFactory();
		factory.getContext().getModelRepository().addModel(model);
		factory.setDefaultFormatter(new XmlFormatter());
		String modelName = selectedFile.getName().split("\\.")[0];
		EglFileGeneratingTemplate template = (EglFileGeneratingTemplate)factory.load(getFile("ewe2ant.egl"));
		template.generate(selectedFile.getParent().getLocation().toOSString() + "/" + modelName + "_workflow.xml");
	}
	
	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
				IStructuredSelection ssel = (IStructuredSelection) selection;
				this.selectedFile = (IFile) ssel.getFirstElement();
				System.out.println("Set selected file to : " + selectedFile);
		}
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.shell = targetPart.getSite().getShell();
	}
	
	private EmfModel createEmfModelByURI(String name, String modelURI, String metamodelURI, boolean readOnLoad, boolean storeOnDisposal) throws EolModelLoadingException, URISyntaxException {
		EmfModel emfModel = new EmfModel();
		StringProperties properties = new StringProperties();
		properties.put(EmfModel.PROPERTY_NAME, name);
		properties.put(EmfModel.PROPERTY_MODEL_URI, modelURI);
		properties.put(EmfModel.PROPERTY_METAMODEL_URI, metamodelURI);
		properties.put(EmfModel.PROPERTY_IS_METAMODEL_FILE_BASED, "false");
		properties.put(EmfModel.PROPERTY_READONLOAD, readOnLoad + "");
		properties.put(EmfModel.PROPERTY_STOREONDISPOSAL, storeOnDisposal + "");
		emfModel.load(properties, null);
		return emfModel;
	}
	
	protected Object execute(IEolExecutableModule module) throws EolRuntimeException {
		return module.execute();
	}
	
	private File getFile(String fileName) throws URISyntaxException, IOException {
		
		URL resourceURL = Ewe2AntAction.class.getResource(fileName);
		URL fileURL  = FileLocator.resolve(resourceURL);
		return new File(fileURL.toURI());
	}
	
}
