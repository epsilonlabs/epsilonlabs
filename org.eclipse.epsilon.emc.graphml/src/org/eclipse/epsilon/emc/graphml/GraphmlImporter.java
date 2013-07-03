package org.eclipse.epsilon.emc.graphml;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.epsilon.emc.graphml.BooleanType;
import org.eclipse.epsilon.emc.graphml.Graph;
import org.eclipse.epsilon.emc.graphml.IntegerType;
import org.eclipse.epsilon.emc.graphml.Node;
import org.eclipse.epsilon.emc.graphml.NodeType;
import org.eclipse.epsilon.emc.graphml.RealType;
import org.eclipse.epsilon.emc.graphml.Slot;
import org.eclipse.epsilon.emc.graphml.SlotPrototype;
import org.eclipse.epsilon.emc.graphml.StringType;
import org.eclipse.epsilon.emc.graphml.Type;
import org.eclipse.epsilon.emc.graphml.GraphmlFactory;
import org.eclipse.epsilon.eol.EolModule;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.filter.Filter;
import org.jdom.input.SAXBuilder;

public class GraphmlImporter {
	
	protected IntegerType integerType;
	protected StringType stringType;
	protected BooleanType booleanType;
	protected RealType realType;
	protected Graph graph = null;
	protected HashMap<String, Node> nodeMap;
	protected Element graphElement = null;
	protected Namespace namespace;
	protected List<OrphanEdge> orphanEdges;
	protected List<String> extraKeys;
	
	public static void main(String[] args) throws Exception {
		
		GraphmlImporter importer = new GraphmlImporter();
		Graph graph = importer.importGraph(new File("/Users/dimitrioskolovos/Desktop/sample.graphml"));
		
		GraphmlModel model = new GraphmlModel();
		model.setName("X");
		model.setGraph(graph);
		
		EolModule module = new EolModule();
		
		//module.parse("Admin.all.collect(a|a.language).println();");
		module.parse("Entity.all.second().admin.collect(a|a.language).println();");
		//module.parse("Foo.all.size().println();");
		module.getContext().getModelRepository().addModel(model);
		module.execute();
	}
	
	public Graph importGraph(File file) throws Exception {
		
		graph = GraphmlFactory.eINSTANCE.createGraph();
		nodeMap = new HashMap<String, Node>();
		orphanEdges = new ArrayList<OrphanEdge>();
		extraKeys = new ArrayList<String>();
		extraKeys.add("d6");
		
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
			Node node = GraphmlFactory.eINSTANCE.createNode();
			node.setId(nodeElement.getAttributeValue("id"));
			nodeMap.put(node.getId(), node);
			graph.getNodes().add(node);
			
			for (String label : getLabels(nodeElement)) {
				
				// Set the type of the node
				if (!isSlotValueLabel(label) && !isReferenceLabel(label)) {
					node.setType(nodeTypeForName(label));
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
		
		for (Element referenceElement : getNodeElements()) {
			Node node = findReferenceTarget(referenceElement);
			if (node != null) {
				nodeMap.put(referenceElement.getAttributeValue("id"), node);
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
		
		// Try to put orphan edge targets to suitable slots
		for (OrphanEdge orphanEdge : orphanEdges) {
			Slot slot = findSuitableSlot(orphanEdge.getSource(), orphanEdge.getTarget());
			if (slot != null) {
				slot.getValues().add(orphanEdge.getTarget());
			}
		}
		
	}
	
	protected Node findReferenceTarget(Element referenceElement) {
		String referenceType = null;
		
		for (String label : getLabels(referenceElement)) {
			if (isReferenceLabel(label)) {
				referenceType = label.trim().substring(1);
				break;
			}
		}
		
		if (referenceType == null) return null;
		
		NodeType nodeType = nodeTypeForName(referenceType);
		
		for (Node node : nodeType.getInstances()) {
			if (matches(node, referenceElement)) {
				return node;
			}
		}
		
		return null;
		
	}
	
	protected boolean matches(Node node, Element referenceElement) {
		for (String label : getLabels(referenceElement)) {
			if (isReferenceLabel(label)) continue;
			ValuedSlotPrototypeLabelParser parser = new ValuedSlotPrototypeLabelParser(label);
			Slot slot = findSlot(node, parser.getPrototype().getName());
			if (slot == null) return false;
			if (!slot.getValues().contains(parser.getValue())) return false;
		}
		return true;
	}
	
	protected Slot findSlot(Node node, String slotName) {
		for (Slot slot : node.getSlots()) {
			if (slot.getPrototype().getName().equals(slotName)) return slot;
		}
		return null;
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
		
		Slot slot = GraphmlFactory.eINSTANCE.createSlot();
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
		Slot slot = GraphmlFactory.eINSTANCE.createSlot();
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
			labels.addAll(getLabels(labelElement.getText()));
		}
		
		for (Element descriptionElement : getDescendants(e, "data")) {
			if (extraKeys.contains(descriptionElement.getAttributeValue("key"))) {
				labels.addAll(getLabels(descriptionElement.getText()));
			}
		}
		return labels;
	}
	
	protected List<String> getLabels(String s) {
		List<String> labels = new ArrayList<String>();
		s = s.trim();
		for (String label : s.split("\\n")) {
			if (label.trim().length() > 0) {
				labels.add(label.trim());
			}
		}
		return labels;
	}
	
	protected List<Element> getDescendants(Element node, final String name) {
		List<Element> descendants = new ArrayList<Element>();
		Iterator iterator = node.getDescendants(new Filter() {
			@Override
			public boolean matches(Object o) {
				return o instanceof Element && ((Element) o).getName().equals(name);
			}
		});
		while (iterator.hasNext()) {
			descendants.add((Element) iterator.next());
		}
		return descendants;
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
		
		int gt = name.indexOf(">");
		
		if (gt > -1) {
			
			String typeName = name.substring(0, gt).trim();
			String superTypeName = name.substring(gt+1, name.length()).trim();

			NodeType type = nodeTypeForName(typeName);
			NodeType superType = nodeTypeForName(superTypeName);
			if (!type.getSuperTypes().contains(superType)) {
				type.getSuperTypes().add(superType);
			}
			return type;
		}
		
		for (Type type : graph.getTypes()) {
			if (type instanceof NodeType && type.getName().equals(name)) {
				return (NodeType) type;
			}
		}
		
		NodeType nodeType = GraphmlFactory.eINSTANCE.createNodeType();
		nodeType.setName(name);
		graph.getTypes().add(nodeType);
		return nodeType;
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
	
	/**
	 * The extra data keys of interest in
	 * the input .graphml file. By default
	 * it contains "d6" which corresponds
	 * to the description element in yEd
	 * @return
	 */
	public List<String> getExtraKeys() {
		return extraKeys;
	}
}
