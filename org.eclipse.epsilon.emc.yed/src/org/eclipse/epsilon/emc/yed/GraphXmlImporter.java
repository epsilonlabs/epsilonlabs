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
	protected List<OrphanEdge> orphanEdges;
	
	public static void main(String[] args) throws Exception {
		
		GraphXmlImporter importer = new GraphXmlImporter();
		Graph graph = importer.importGraph(new File("/Users/dimitrioskolovos/Desktop/sample.graphml"));
	
		YedModel model = new YedModel();
		model.setName("X");
		model.setGraph(graph);
		
		EolModule module = new EolModule();
		module.parse("Entity.all.first().admin.collect(f|f.language).println();");
		module.getContext().getModelRepository().addModel(model);
		module.execute();
	}
	
	public Graph importGraph(File file) throws Exception {
		
		graph = YedFactory.eINSTANCE.createGraph();
		nodeMap = new HashMap<String, Node>();
		orphanEdges = new ArrayList<OrphanEdge>();
		
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(file);
		Element root = doc.getDocument().getRootElement();
		namespace = root.getNamespace();
		
		graphElement = root.getChild("graph", namespace);
		createNodes();
		adjustMultiplicities();
		
		return graph;
	}
	
	protected void createNodes() {
		
		// Process node elements
		for (Element nodeElement : getNodeElements()) {
			Node node = YedFactory.eINSTANCE.createNode();
			node.setId(nodeElement.getAttributeValue("id"));
			nodeMap.put(node.getId(), node);
			graph.getNodes().add(node);
			
			for (String label : getLabels(nodeElement)) {
				
				// Set the type of the node
				if (!isSlotValueLabel(label) && !isReferenceLabel(label)) {
					
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
		
		// Process edge elements
		for (Element edgeElement : getEdgeElements()) {
			Node source = nodeMap.get(edgeElement.getAttributeValue("source"));
			Node target = nodeMap.get(edgeElement.getAttributeValue("target"));
			
			String label = getFirstLabel(edgeElement);
			if (label == null) {
				orphanEdges.add(new OrphanEdge(source, target));
				continue;
			}
			
			SlotPrototype prototype = new EdgePrototypeLabelParser(label).getPrototype();
			Slot slot = addSlot(source, prototype);
			slot.setPrototype(addSlotPrototype(source.getType(), prototype));
			slot.getValues().add(target);
		}
		
		for (OrphanEdge orphanEdge : orphanEdges) {
			Slot slot = findSuitableSlot(orphanEdge.getSource(), orphanEdge.getTarget());
			if (slot != null) {
				slot.getValues().add(orphanEdge.getTarget());
			}
		}
		
	}
	
	/**
	 * If single-valued slots are found to have
	 * multiple values, adjust the multiplicity accordingly
	 */
	protected void adjustMultiplicities() {
		
		for (Node node : graph.getNodes()) {
			for (Slot slot : node.getSlots()) {
				if (!slot.getPrototype().isMany() && slot.getValues().size() > 1) {
					slot.getPrototype().setMany(true);
				}
			}
		}
		
	}
	
	protected Slot findSuitableSlot(Node source, Node target) {
		SlotPrototype slotPrototype = findSuitableSlotPrototype(source.getType(), target);
		if (slotPrototype == null) return null;
		for (Slot slot : source.getSlots()) {
			if (slot.getPrototype() == slotPrototype) {
				return slot;
			}
		}
		
		Slot slot = YedFactory.eINSTANCE.createSlot();
		slot.setPrototype(slotPrototype);
		source.getSlots().add(slot);
		return slot;
		
	}
	
	protected SlotPrototype findSuitableSlotPrototype(NodeType type, Node value) {
		for (SlotPrototype slotPrototype : type.getSlotPrototypes()) {
			for (Slot slot : slotPrototype.getSlots()) {
				for (Object existingValue : slot.getValues()) {
					if (existingValue instanceof Node && ((Node) existingValue).getType().equals(value.getType())) {
						return slotPrototype;
					}
				}
			}
		}
		return null;
	}
	
	protected boolean isReferenceLabel(String label) {
		return label.startsWith("@");
	}
	
	protected boolean isSlotValueLabel(String label) {
		return label.indexOf('=') > -1;
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
	
	protected String getFirstLabel(Element e) {
		List<String> labels = getLabels(e);
		if (labels.size() > 0) return labels.get(0);
		else return null;
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
