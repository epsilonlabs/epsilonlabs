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
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.standalone.service.transform.EtlTransformParameters;

public class EtlTransformOperationJob extends WorkspaceJob {

	private String etlTransformation;
	private String sourceName;
	private String sourceMetaModelURI;
	private String sourceModelFilePath;
	private boolean sourceReadOnLoad;
	private boolean sourceStoreOnDisposal;
	private String targetName;
	private String targetMetaModelURI;
	private String targetModelFilePath;
	private boolean targetReadOnLoad;
	private boolean targetStoreOnDisposal;
	private String pluginID;

	private EtlTransformOperationJob(String name) {
		super(name);
	}

	public void setEtlTransformation(String etlTransformation) {
		this.etlTransformation = etlTransformation;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public void setSourceMetaModelURI(String sourceMetaModelURI) {
		this.sourceMetaModelURI = sourceMetaModelURI;
	}

	public void setsourceModelFilePath(String sourceModelFilePath) {
		this.sourceModelFilePath = sourceModelFilePath;
	}

	public void setSourceReadOnLoad(boolean sourceReadOnLoad) {
		this.sourceReadOnLoad = sourceReadOnLoad;
	}

	public void setSourceSaveOnDispose(boolean sourceStoreOnDisposal) {
		this.sourceStoreOnDisposal = sourceStoreOnDisposal;
	}

	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}

	public void setTargetMetaModelURI(String targetMetaModelURI) {
		this.targetMetaModelURI = targetMetaModelURI;
	}

	public void setTargetModelFilePath(String targetModelFile) {
		this.targetModelFilePath = targetModelFile;
	}

	public void setTargetReadOnLoad(boolean targetReadOnLoad) {
		this.targetReadOnLoad = targetReadOnLoad;
	}

	public void setTargetSaveOnDispose(boolean targetStoreOnDisposal) {
		this.targetStoreOnDisposal = targetStoreOnDisposal;
	}

	public void setContributer(String pluginID) {
		this.pluginID = pluginID;
	}

	@Override
	public IStatus runInWorkspace(IProgressMonitor monitor)
			throws CoreException {

		monitor.beginTask(getName(), 4);

		URL transformationEntry = Platform.getBundle(pluginID).getEntry(
				etlTransformation);
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

		IEolExecutableModule etlModule = new EtlModule();
		try {
			etlModule.parse(transformURI);
		} catch (Exception e) {
			e.printStackTrace();
		}

		monitor.worked(1);

		if (etlModule.getParseProblems().size() > 0) {
			System.err.println("Parse errors occured...");
			for (ParseProblem problem : etlModule.getParseProblems()) {
				System.err.println(problem.toString());
			}
		}
		etlModule.getContext().getModelRepository().addModel(createSource());
		etlModule.getContext().getModelRepository().addModel(createTarget());
		try {
			etlModule.execute();
		} catch (EolRuntimeException e) {
			e.printStackTrace();
		}

		monitor.worked(1);

		etlModule.getContext().getModelRepository().dispose();

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

	protected EmfModel createTarget() {
		EmfModel emfModel = new EmfModel();
		emfModel.setName(targetName);
		emfModel.setMetamodelUri(targetMetaModelURI);
		emfModel.setModelFile(targetModelFilePath);
		emfModel.setReadOnLoad(targetReadOnLoad);
		emfModel.setStoredOnDisposal(targetStoreOnDisposal);
		try {
			emfModel.load();
		} catch (EolModelLoadingException e) {
			e.printStackTrace();
		}
		return emfModel;
	}

	public static EtlTransformOperationJob createJob(
			EtlTransformParameters parameters) {
		EtlTransformOperationJob job = new EtlTransformOperationJob(
				"ETL Transformation Job");
		job.pluginID = parameters.getPluginID();
		job.etlTransformation = parameters.getEtlTransform();
		job.sourceName = parameters.getSourceName();
		job.sourceMetaModelURI = parameters.getSourceMetaModelURI();
		job.sourceModelFilePath = parameters.getSourceModelFilePath();
		job.sourceReadOnLoad = parameters.isSourceReadOnLoad();
		job.targetName = parameters.getTargetName();
		job.targetMetaModelURI = parameters.getTargetMetaModelURI();
		job.targetModelFilePath = parameters.getTargetModelFilePath();
		job.targetReadOnLoad = parameters.isTargetReadOnLoad();
		job.targetStoreOnDisposal = parameters.isTargetStoreOnDisposal();

		return job;
	}

}
