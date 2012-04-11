package org.eclipse.epsilon.standalone.service.jobs;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplateFactoryModuleAdapter;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.standalone.service.transform.EglTransformParameters;

public class EglTransformOperationJob extends WorkspaceJob {

	private String eglTransformation;
	private EmfModel sourceModel;
	private String pluginID;
	private String outputRoot;
	private String sourceName;
	private String sourceMetaModelURI;
	private boolean sourceReadOnLoad;
	private boolean sourceStoreOnDisposal;
	private String sourceModelFilePath;

	public EglTransformOperationJob(String name) {
		super(name);
	}

	@Override
	public IStatus runInWorkspace(IProgressMonitor monitor)
			throws CoreException {
		monitor.beginTask(getName(), 4);

		URL transformationEntry = Platform.getBundle(pluginID).getEntry(
				eglTransformation);
		URL resolvedTransformationURL = null;
		URI transformURI = null;
		try {
			resolvedTransformationURL = FileLocator
					.resolve(transformationEntry);
			transformURI = resolvedTransformationURL.toURI();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		monitor.worked(1);

		EglFileGeneratingTemplateFactory eglTemplateFactory = new EglFileGeneratingTemplateFactory();
		IEolExecutableModule eglModule = new EglTemplateFactoryModuleAdapter(
				eglTemplateFactory);
		try {
			eglTemplateFactory.setOutputRoot(outputRoot);
			eglModule.parse(transformURI);
		} catch (EglRuntimeException ere) {
			ere.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		monitor.worked(1);

		if (eglModule.getParseProblems().size() > 0) {
			System.err.println("Parse errors occured...");
			for (ParseProblem problem : eglModule.getParseProblems()) {
				System.err.println(problem.toString());
			}
		}
		sourceModel = createSource();
		eglModule.getContext().getModelRepository().addModel(sourceModel);
		try {
			eglModule.execute();
		} catch (EolRuntimeException e) {
			e.printStackTrace();
		}
		eglModule.getContext().getModelRepository().dispose();

		monitor.done();

		return Status.OK_STATUS;
	}

	protected EmfModel createSource() {
		EmfModel emfModel = new EmfModel();
		emfModel.setName(sourceName);
		emfModel.setMetamodelUri(sourceMetaModelURI);
		emfModel.setModelFile(sourceModelFilePath);
		emfModel.setReadOnLoad(sourceReadOnLoad);
		emfModel.setStoredOnDisposal(sourceStoreOnDisposal);
		try {
			emfModel.load();
		} catch (EolModelLoadingException e) {
			e.printStackTrace();
		}
		return emfModel;
	}

	public static EglTransformOperationJob createJob(
			EglTransformParameters parameters) {

		EglTransformOperationJob job = new EglTransformOperationJob(
				"EGL Transformation Job");
		job.pluginID = parameters.getPluginID();
		job.eglTransformation = parameters.getEglTransformation();
		job.sourceName = parameters.getSourceName();
		job.sourceModelFilePath = parameters.getSourceModelFilePath();
		job.outputRoot = parameters.getOutputRoot();
		job.sourceMetaModelURI = parameters.getSourceMetaModelURI();
		job.sourceReadOnLoad = parameters.isSourceReadOnLoad();
		job.sourceStoreOnDisposal = parameters.isSourceStoreOnDisposal();

		return job;
	}

}
