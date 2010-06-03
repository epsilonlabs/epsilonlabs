package org.eclipse.epsilon.emc.htmlunit;

import com.gargoylesoftware.htmlunit.WebClient;

public class NoJavascriptWebClientConfigurer implements IWebClientConfigurer {

	@Override
	public void configure(WebClient webClient) {
		webClient.setJavaScriptEnabled(false);
	}

}
