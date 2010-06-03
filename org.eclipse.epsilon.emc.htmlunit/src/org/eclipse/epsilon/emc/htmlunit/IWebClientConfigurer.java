package org.eclipse.epsilon.emc.htmlunit;

import com.gargoylesoftware.htmlunit.WebClient;

public interface IWebClientConfigurer {
	
	public void configure(WebClient webClient);
	
}
