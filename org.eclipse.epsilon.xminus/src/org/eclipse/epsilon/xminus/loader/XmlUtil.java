package org.eclipse.epsilon.xminus.loader;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlUtil {
	
	public static List<Node> getChildren(Node node) {
		ArrayList<Node> children = new ArrayList<Node>();
		NodeList nodeList = node.getChildNodes();
		for (int i=0; i<nodeList.getLength(); i++) {
			children.add(nodeList.item(i));
		}
		return children;
	}
	
	public static String getAttributeValue(Node node, String attributeName) {
		return node.getAttributes().getNamedItem(attributeName).getNodeValue();
	}
}
