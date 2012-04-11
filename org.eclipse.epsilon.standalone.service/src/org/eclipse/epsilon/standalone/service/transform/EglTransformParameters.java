package org.eclipse.epsilon.standalone.service.transform;

public class EglTransformParameters {

	private String pluginID;
	private String eglTransformation;
	private String sourceName;
	private String sourceMetaModelURI;
	private String sourceModelFilePath;
	private boolean sourceReadOnLoad;
	private boolean sourceStoreOnDisposal;
	private String outputRoot;

	public String getPluginID() {
		return pluginID;
	}

	public void setPluginID(String pluginID) {
		this.pluginID = pluginID;
	}

	public String getEglTransformation() {
		return eglTransformation;
	}

	public void setEglTransform(String eglTransformation) {
		this.eglTransformation = eglTransformation;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getSourceMetaModelURI() {
		return sourceMetaModelURI;
	}

	public void setSourceMetaModelURI(String sourceMetaModelURI) {
		this.sourceMetaModelURI = sourceMetaModelURI;
	}

	public String getSourceModelFilePath() {
		return sourceModelFilePath;
	}

	public void setSourceModelFilePath(String sourceModelFilePath) {
		this.sourceModelFilePath = sourceModelFilePath;
	}

	public boolean isSourceReadOnLoad() {
		return sourceReadOnLoad;
	}

	public void setSourceReadOnLoad(boolean sourceReadOnLoad) {
		this.sourceReadOnLoad = sourceReadOnLoad;
	}

	public boolean isSourceStoreOnDisposal() {
		return sourceStoreOnDisposal;
	}

	public void setSourceStoreOnDisposal(boolean sourceStoreOnDisposal) {
		this.sourceStoreOnDisposal = sourceStoreOnDisposal;
	}

	public String getOutputRoot() {
		return outputRoot;
	}

	public void setOutputRoot(String outputRoot) {
		this.outputRoot = outputRoot;
	}

}
