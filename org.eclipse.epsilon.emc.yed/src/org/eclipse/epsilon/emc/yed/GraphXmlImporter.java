package org.eclipse.epsilon.emc.yed;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.epsilon.emc.yed.BooleanType;
import org.eclipse.epsilon.emc.yed.Graph;
import org.eclipse.epsilon.emc.yed.IntegerType;
import org.eclipse.epsilon.emc.yed.Node;
import org.eclipse.epsilon.emc.yed.NodeType;
import org.eclipse.epsilon.emc.yed.RealType;
import org.eclipse.epsilon.emc.yed.StringType;
import org.eclipse.epsilon.emc.yed.Type;
import org.eclipse.epsilon.emc.yed.YedFactory;
import org.eclipse.epsilon.eol.EolModule;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.filter.Filter;
import org.jdom.input.SAXBuilder;

public class GraphXmlImporter {
	
	protected IntegerType integerType;
	protected StringType stringType;
	protected BooleanType booleanType;
	protected RealType realType;
	protected Graph graph = null;
	protected HashMap<String, Node> nodeMap;
	protected Element graphElement = null;
	protected Namespace namespace;
	
	public static void main(String[] args) throws Exception {
		
		GraphXmlImporter importer = new GraphXmlImporter();
		Graph graph = importer.importGraph(new File("/Users/dimitrioskolovos/Desktop/sample.graphml"));
	
		YedModel model = new YedModel();
		model.setName("X");
		model.setGraph(graph);
		
		EolModule module = new EolModule();
		module.parse("Field.all.collect(f|f.name).println();");
		module.getContext().getModelRepository().addModel(model);
		module.execute();
	}
	
	public Graph importGraph(File file) throws Exception {
		
		graph = YedFactory.eINSTANCE.createGraph();
		nodeMap = new HashMap<String, Node>();
		
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(file);
		Element root = doc.getDocument().getRootElement();
		namespace = root.getNamespace();
		
		graphElement = root.getChild("graph", namespace);
		createNodes();
		
		/*
		for (Element edgeElement : getEdgeElements()) {
			System.err.println(edgeElement.getAttributeValue("source") + "->" + edgeElement.getAttributeValue("target"));
			for (Element label : getDescendants(edgeElement, "EdgeLabel")) {
				System.err.println(label.getText().trim());
			}
		}*/
		
		return graph;
	}
	
	protected void createNodes() {
		
		for (Element nodeElement : getNodeElements()) {
			Node node = YedFactory.eINSTANCE.createNode();
			node.setId(nodeElement.getAttributeValue("id"));
			nodeMap.put(node.getId(), node);
			graph.getNodes().add(node);
			
			for (String label : getLabels(nodeElement)) {
				
				// Set the type of the node
				if (label.indexOf("=") == -1 && !label.startsWith("@")) {
					NodeType nodeType = nodeTypeForName(label);
					if (nodeType == null) {
						nodeType = YedFactory.eINSTANCE.createNodeType();
						nodeType.setName(label);
						graph.getTypes().add(nodeType);
					}
					node.setType(nodeType);
				}
				// Add a slot to the node
				else if (node.getType() != null) {
					
					ValuedSlotPrototypeLabelParser parser = new ValuedSlotPrototypeLabelParser(label);
					Slot slot = addSlot(node, parser.getPrototype());
					slot.setPrototype(addSlotPrototype(node.getType(), parser.getPrototype()));
					slot.getValues().add(parser.getValue());
				}
				
			}
		}
		
	}
	
	protected Slot addSlot(Node node, SlotPrototype prototype) {
		for (Slot existingSlot : node.getSlots()) {
			if (existingSlot.getPrototype().getName().equals(prototype.getName())) {
				return existingSlot;
			}
		}
		Slot slot = YedFactory.eINSTANCE.createSlot();
		node.getSlots().add(slot);
		return slot;
	}
	
	protected SlotPrototype addSlotPrototype(NodeType nodeType, SlotPrototype prototype) {
		for (SlotPrototype existingPrototype : nodeType.getSlotPrototypes()) {
			if (existingPrototype.getName().equals(prototype.getName())) {
				if (existingPrototype.getType() == null) {
					existingPrototype.setType(prototype.getType());
				}
				if (!existingPrototype.isMany()) {
					existingPrototype.setMany(prototype.isMany());
				}
				return existingPrototype;
			}
		}
		nodeType.getSlotPrototypes().add(prototype);
		return prototype;
	}
	
	protected List<String> getLabels(Element e) {
		String labelTag = "NodeLabel";
		if (e.getName().equals("edge")) labelTag = "EdgeLabel";
		List<String> labels = new ArrayList<String>();
		for (Element labelElement : getDescendants(e, labelTag)) {
			String label = labelElement.getText().trim();
			for (String line : label.split("\\n")) {
				labels.add(line.trim());
			}
		}
		return labels;
	}
	
	protected List<Element> getDescendants(Element node, final String name) {
		List<Element> labels = new ArrayList<>();
		Iterator iterator = node.getDescendants(new Filter() {
			@Override
			public boolean matches(Object o) {
				return o instanceof Element && ((Element) o).getName().equals(name);
			}
		});
		while (iterator.hasNext()) {
			labels.add((Element) iterator.next());
		}
		return labels;
	}
	
	protected List<Element> getNodeElements() {
		List<Element> elements = new ArrayList<Element>();
		for (Object o : graphElement.getChildren("node", namespace)) {
			elements.add((Element) o);
		}
		return elements;
	}
	
	protected List<Element> getEdgeElements() {
		List<Element> elements = new ArrayList<Element>();
		for (Object o : graphElement.getChildren("edge", namespace)) {
			elements.add((Element) o);
		}
		return elements;
	}
	
	protected NodeType nodeTypeForName(String name) {
		for (Type type : graph.getTypes()) {
			if (type instanceof NodeType && type.getName().equals(name)) {
				return (NodeType) type;
			}
		}
		return null;
	}
	
	public IntegerType getIntegerType() {
		return integerType;
	}
	
	public StringType getStringType() {
		return stringType;
	}
	
	public BooleanType getBooleanType() {
		return booleanType;
	}
	
	public RealType getRealType() {
		return realType;
	}
}
