package org.eclipse.epsilon.standalone.service.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.epsilon.standalone.service.Activator;
import org.eclipse.epsilon.standalone.service.transform.EglTransformParameters;
import org.eclipse.epsilon.standalone.service.transform.ITransformService;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osgi.framework.ServiceReference;

public abstract class AbstractEglTransformationHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ServiceReference<ITransformService> reference = Activator.getDefault()
				.getBundle().getBundleContext()
				.getServiceReference(ITransformService.class);
		ITransformService service = Activator.getDefault().getBundle()
				.getBundleContext().getService(reference);
		EglTransformParameters parameters = createTransformParameters(new EglTransformParameters());
		IFile selectedModelFile = getSelectedModelFile(event);
		String sourceModelFilePath = selectedModelFile.getLocation()
				.toOSString();
		parameters.setSourceModelFilePath(sourceModelFilePath);
		String outputRoot = selectedModelFile.getProject().getLocation()
				.toOSString();
		parameters.setOutputRoot(outputRoot);
		service.doEglTransform(parameters);
		return null;
	}

	public abstract EglTransformParameters createTransformParameters(
			EglTransformParameters parameters);

	private IFile getSelectedModelFile(ExecutionEvent event) {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		ITreeSelection structuredSelection = (ITreeSelection) selection;
		Object element = structuredSelection.getFirstElement();
		IFile selectedModelFile = (IFile) element;
		return selectedModelFile;
	}

}
