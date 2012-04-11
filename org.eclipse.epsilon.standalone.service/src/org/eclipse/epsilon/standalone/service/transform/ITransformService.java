package org.eclipse.epsilon.standalone.service.transform;

public interface ITransformService {

	void doEglTransform(EglTransformParameters parameters);

	void doEtlTransform(EtlTransformParameters parameters);

}
