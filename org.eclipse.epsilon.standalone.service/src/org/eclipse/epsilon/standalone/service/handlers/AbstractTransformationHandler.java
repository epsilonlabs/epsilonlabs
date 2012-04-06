package org.eclipse.epsilon.standalone.service.handlers;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.epsilon.standalone.service.Activator;
import org.eclipse.epsilon.standalone.service.transform.EtlTransformParameters;
import org.eclipse.epsilon.standalone.service.transform.ITransformService;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osgi.framework.ServiceReference;

public abstract class AbstractTransformationHandler extends AbstractHandler {

	public AbstractTransformationHandler() {
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ServiceReference<ITransformService> reference = Activator.getDefault()
				.getBundle().getBundleContext()
				.getServiceReference(ITransformService.class);
		ITransformService service = Activator.getDefault().getBundle()
				.getBundleContext().getService(reference);
		EtlTransformParameters parameters = createTransformParameters(new EtlTransformParameters());
		IFile selectedModelFile = getSelectedModelFile(event);
		String sourceModelFilePath = selectedModelFile.getLocation()
				.toOSString();
		parameters.setSourceModelFilePath(sourceModelFilePath);
		String targetModelFile = createTargetFile(selectedModelFile,
				parameters.getTargetMetaModelURI());
		parameters.setTargetModelFilePath(targetModelFile);
		service.doEtlTransform(parameters);
		return null;
	}

	public abstract EtlTransformParameters createTransformParameters(
			EtlTransformParameters etlTransformParameters);

	private IFile getSelectedModelFile(ExecutionEvent event) {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		ITreeSelection structuredSelection = (ITreeSelection) selection;
		Object element = structuredSelection.getFirstElement();
		IFile selectedModelFile = (IFile) element;
		return selectedModelFile;
	}

	private String createTargetFile(IFile selectedModelFile,
			String targetMetaModelURI) {
		String modelFileExtension = EPackage.Registry.INSTANCE.getEPackage(
				targetMetaModelURI).getNsPrefix();
		int index = selectedModelFile.getName().indexOf(
				selectedModelFile.getFileExtension());
		String fileName = selectedModelFile.getName().substring(0, index);
		String targetModelFile = selectedModelFile.getProject().getLocation()
				.toOSString()
				+ "/" + fileName + modelFileExtension;

		ResourceSet resourceSet = new ResourceSetImpl();
		org.eclipse.emf.common.util.URI orocosModelURI = org.eclipse.emf.common.util.URI
				.createFileURI(targetModelFile);
		Resource resource = resourceSet.createResource(orocosModelURI);
		try {
			resource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return targetModelFile;
	}

}
