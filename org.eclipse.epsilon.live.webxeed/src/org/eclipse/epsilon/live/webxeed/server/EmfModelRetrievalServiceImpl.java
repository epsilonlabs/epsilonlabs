package org.eclipse.epsilon.live.webxeed.server;

import org.eclipse.epsilon.live.webxeed.client.EmfModelRetrievalService;
import org.eclipse.epsilon.live.webxeed.shared.WObject;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class EmfModelRetrievalServiceImpl extends RemoteServiceServlet implements EmfModelRetrievalService {

	@Override
	public WObject getEmfModel(String modelUrl, String metamodelUrl) {
		WObject wObject = new WObject();
		wObject.setTitle("w1");
		
		
		WObject wObject2 = new WObject();
		wObject2.setTitle("w2");
		wObject.getContents().add(wObject2);
		
		return wObject;
	}

}
