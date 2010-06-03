package org.eclipse.epsilon.emc.htmlunit;

import com.gargoylesoftware.htmlunit.WebClient;

public class CompositeWebClientConfigurer implements IWebClientConfigurer {
	
	protected IWebClientConfigurer[] configurers = null;
	
	public CompositeWebClientConfigurer(IWebClientConfigurer... configurers) {
		this.configurers = configurers;
	}

	@Override
	public void configure(WebClient webClient) {
		for (IWebClientConfigurer configurer : this.configurers) {
			configurer.configure(webClient);
		}
	}
	
}
