package org.eclipse.epsilon.standalone.service.transform;

public class EtlTransformParameters {

	private String pluginID;
	private String etlTransform;
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

	public String getPluginID() {
		return pluginID;
	}

	public void setPluginID(String pluginID) {
		this.pluginID = pluginID;
	}

	public String getEtlTransform() {
		return etlTransform;
	}

	public void setEtlTransform(String etlTransform) {
		this.etlTransform = etlTransform;
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

	public String getTargetName() {
		return targetName;
	}

	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}

	public String getTargetMetaModelURI() {
		return targetMetaModelURI;
	}

	public void setTargetMetaModelURI(String targetMetaModelURI) {
		this.targetMetaModelURI = targetMetaModelURI;
	}

	public String getTargetModelFilePath() {
		return targetModelFilePath;
	}

	public void setTargetModelFilePath(String targetModelFilePath) {
		this.targetModelFilePath = targetModelFilePath;
	}

	public boolean isTargetReadOnLoad() {
		return targetReadOnLoad;
	}

	public void setTargetReadOnLoad(boolean targetReadOnLoad) {
		this.targetReadOnLoad = targetReadOnLoad;
	}

	public boolean isTargetStoreOnDisposal() {
		return targetStoreOnDisposal;
	}

	public void setTargetStoreOnDisposal(boolean targetStoreOnDisposal) {
		this.targetStoreOnDisposal = targetStoreOnDisposal;
	}

}
