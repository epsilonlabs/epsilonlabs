package ewe.diagram.workbench;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.commons.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.plainxml.PlainXmlModel;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

public class Ant2EweAction implements IObjectActionDelegate {
	
	private Shell shell;
	
	private IFile selectedFile;
	
	protected IEolExecutableModule module;
	
	protected Object result;

	@Override
	public void run(final IAction action) {
		Job job = new Job("Generating Epsilon Workflow Diagram Model..") {
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
		PlainXmlModel srcAntModel = null;
		EmfModel destEweModel = null;
		try {
			//First perform validation by running EVL script. Exit if there are any errors.
			System.out.println("Running action to generate Ewe Diagram Model");
			srcAntModel = createPlainXMLModel(selectedFile.getLocation().toString(), true, false);
			System.out.println("Loaded src model");
			String fileNameToGenerate = selectedFile.getName().split("\\.")[0] + "_ewegen.ewe";
			//Create a dummy file - otherwise refresh doesnt work for some reason.
			File f = new File(new URI(getTargetModelUriStr(fileNameToGenerate)));
			f.createNewFile();
			destEweModel = createEmfModelByURI("ewe", getTargetModelUriStr(fileNameToGenerate),"ewe", false, true);
			System.out.println("Loaded dest model");
			EtlModule etlModule = new EtlModule();
			etlModule.parse(getFile("Ant2Ewe.etl"));
			System.out.println("Successfully parsed ETL file");
			etlModule.getContext().getModelRepository().addModel(srcAntModel);
			etlModule.getContext().getModelRepository().addModel(destEweModel);
			System.out.println("Successfully added modules to repo");
			etlModule.execute();
			System.out.println("Successfully executed ETL module");
			selectedFile.getParent().refreshLocal(1, null);
			System.out.println("Refreshed");
		} finally {
			if(srcAntModel !=null)
				srcAntModel.dispose();
			if(destEweModel != null)
				destEweModel.dispose();
		}
	}

	private String getTargetModelUriStr(String fileNameToGen) {
		String uriStr = selectedFile.getLocationURI().toString(); //Returns full URI : file:/home/abcd/project/a.xml
		String projectPathUriStr = uriStr.substring(0, uriStr.lastIndexOf("/")); // Gives : file:/home/abcd/project
		String targetModelToGenUriStr = projectPathUriStr + "/" + fileNameToGen; //Gives :  file:/home/abcd/project/gen.ewe
		return targetModelToGenUriStr;
	}

	private PlainXmlModel createPlainXMLModel(String modelFile, boolean readOnLoad, boolean storeOnDisposal) throws EolModelLoadingException {
		PlainXmlModel xmlModel = new PlainXmlModel();
		StringProperties properties = new StringProperties();
		properties.put(PlainXmlModel.PROPERTY_FILE, modelFile);
		properties.put(PlainXmlModel.PROPERTY_READONLOAD, "" + readOnLoad);
		properties.put(PlainXmlModel.PROPERTY_STOREONDISPOSAL, "" + storeOnDisposal);
		xmlModel.load(properties, null);
		return xmlModel;
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
		
		URL resourceURL = Ant2EweAction.class.getResource(fileName);
		URL fileURL  = FileLocator.resolve(resourceURL);
		return new File(fileURL.toURI());
	}
	
}
