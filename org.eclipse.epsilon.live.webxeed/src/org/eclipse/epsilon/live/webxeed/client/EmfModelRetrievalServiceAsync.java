package org.eclipse.epsilon.live.webxeed.client;

import org.eclipse.epsilon.live.webxeed.shared.WObject;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface EmfModelRetrievalServiceAsync {
	public void getEmfModel(String modelUrl, String metamodelUrl, AsyncCallback<WObject> callback);
}
