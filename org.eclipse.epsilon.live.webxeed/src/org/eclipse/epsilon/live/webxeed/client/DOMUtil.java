package org.eclipse.epsilon.live.webxeed.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;


public class DOMUtil {
	
	public static List<Element> findElementsForName (Element element, String name)
    {
        ArrayList<Element> result = new ArrayList<Element>();
        recElementsForClass(result, element, name);
        return result;
    }

    private static void recElementsForClass (ArrayList<Element> res, Element element, String name)
    {
        String c;
        
        if (element == null) {
            return;
        }
        
        c = DOM.getElementProperty(element, "name");
        
        if (c != null) {
            String[] p = c.split(" ");
            
            for (int x = 0; x < p.length; x++) {
                if (p[x].equals(name)) {
                    res.add(element);
                }
            }
        }
        
        for (int i = 0; i < DOM.getChildCount(element); i++) {
            Element child = DOM.getChild(element, i);
            recElementsForClass(res, child, name);
        }
    }
	
}
