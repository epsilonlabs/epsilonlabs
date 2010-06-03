package org.eclipse.epsilon.emc.htmlunit;

import com.gargoylesoftware.htmlunit.WebClient;

public class DefaultWebClientFactory implements IWebClientFactory {

	@Override
	public WebClient createWebClient() {
		return new WebClient();
	}
	
}
