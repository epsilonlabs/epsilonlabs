package org.eclipse.epsilon.live.webxeed.client;

import org.eclipse.epsilon.live.webxeed.shared.WObject;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("getemfmodel")
public interface EmfModelRetrievalService extends RemoteService {
	
	public WObject getEmfModel(String modelUrl, String metamodelUrl);
	
}
