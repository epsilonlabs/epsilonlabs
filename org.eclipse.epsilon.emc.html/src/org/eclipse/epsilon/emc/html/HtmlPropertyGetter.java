package org.eclipse.epsilon.emc.html;

import org.eclipse.epsilon.emc.plainxml.PlainXmlProperty;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertyGetter;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlPropertyGetter extends AbstractPropertyGetter {

	@Override
	public Object invoke(Object object, String property)
			throws EolRuntimeException {
		
		Element element = (Element) object;
		PlainXmlProperty p = PlainXmlProperty.parse(property);
		
		if (p.isAttribute()) {
			return element.attr(p.getProperty());
		}
		else {
			Elements elements = element.getElementsByTag(p.getProperty());
			if (p.isMany()) {
				return elements;
			}
			else {
				if (elements.size() > 0) return elements.get(0);
				else return null;
			}
		}
	}

}
