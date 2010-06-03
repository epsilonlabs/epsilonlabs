package org.eclipse.epsilon.emc.htmlunit;

import java.util.Iterator;

import org.eclipse.epsilon.emc.htmlunit.objectbag.ObjectBagModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class HtmlUnitModel extends ObjectBagModel {
	
	protected String url = null;
	protected IWebClientConfigurer webClientConfigurer;
	protected IWebClientFactory webClientFactory = new DefaultWebClientFactory();
	protected HtmlUnitModelPropertyGetter propertyGetter = new HtmlUnitModelPropertyGetter();
	protected WebClient webClient = null;
	
	public IWebClientConfigurer getWebClientConfigurer() {
		return webClientConfigurer;
	}

	public void setWebClientConfigurer(IWebClientConfigurer webClientConfigurer) {
		this.webClientConfigurer = webClientConfigurer;
	}

	public IWebClientFactory getWebClientFactory() {
		return webClientFactory;
	}

	public void setWebClientFactory(IWebClientFactory webClientFactory) {
		this.webClientFactory = webClientFactory;
	}

	public HtmlUnitModel(String name, String url) {
		this.name = name;
		this.url = url;
	}
	
	@Override
	public void load() throws EolModelLoadingException {
		try {
			loadImpl();
		}
		catch (Exception ex) {
			throw new EolModelLoadingException(ex, this);
		}
	}
	
	public void loadImpl() throws Exception {
		
		classNameEncoder = new HtmlUnitClassNameEncoder();
		
		webClient = webClientFactory.createWebClient();
		if (webClientConfigurer != null) { webClientConfigurer.configure(webClient); }
		HtmlPage page = webClient.getPage(this.url);
	    
	    Iterator<HtmlElement> it = page.getAllHtmlChildElements().iterator();
	    while (it.hasNext())  {
	    	bag.add(it.next());
	    }
	    
	}
	
	@Override
	public IPropertyGetter getPropertyGetter() {
		return propertyGetter;
	}
	
	@Override
	public void dispose() {
		super.dispose();
		if (webClient != null) {
			webClient.closeAllWindows();
		}
	}
	
}
