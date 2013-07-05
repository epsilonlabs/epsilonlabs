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
	
	// Add support for node label patterns
	protected Graph graph = null;
	protected HashMap<String, Node> nodeMap;
	protected HashMap<Node, Element> nodeElementMap;
	protected Element graphElement = null;
	protected Namespace namespace;
	protected List<OrphanEdge> orphanEdges;
	protected GraphmlConfiguration configuration;
	protected List<Node> referenceNodes;
	
	public static void main(String[] args) throws Exception {
		
		GraphmlImporter importer = new GraphmlImporter();
		Graph graph = importer.importGraph(new File("/Users/dimitrioskolovos/Desktop/sample.graphml"));
		
		GraphmlModel model = new GraphmlModel();
		model.setName("X");
		model.setGraph(graph);
		
		EolModule module = new EolModule();
		
		module.parse("City.all.collect(c|c.incoming.collect(r|r.distance)).println();");
		//module.parse("Road.all.collect(r|r.distance).println();");
		//module.parse("Admin.all.collect(a|a.language).println();");
		//module.parse("Entity.all.second().admin.collect(a|a.language).println();");
		//module.parse("Foo.all.size().println();");
		module.getContext().getModelRepository().addModel(model);
		module.execute();
	}
	
	public Graph importGraph(File file) throws Exception {
		
		graph = GraphmlFactory.eINSTANCE.createGraph();
		nodeMap = new HashMap<String, Node>();
		nodeElementMap = new HashMap<Node, Element>();
		orphanEdges = new ArrayList<OrphanEdge>();
		referenceNodes = new ArrayList<Node>();
		
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(file);
		Element root = doc.getDocument().getRootElement();
		namespace = root.getNamespace();
		
		graphElement = root.getChild("graph", namespace);
		configuration = new GraphmlConfiguration(root);
		
		populateGraph();
		adjustSlotPrototypeMultiplicitiesAndSlotValueTypes();
		
		return graph;
	}
	
	protected void populateGraph() {
		
		// Process node elements
		for (Element nodeElement : getNodeElements()) {
			
			String nodeTypeName = getElementData(nodeElement, configuration.getNodeTypeKey());
			if (nodeTypeName == null) continue;
			boolean isReference = false;
			
			if (nodeTypeName.startsWith("@")) {
				nodeTypeName = nodeTypeName.substring(1);
				isReference = true;
			}
			
			// Create nodes only for typed node elements
			Node node = GraphmlFactory.eINSTANCE.createNode();
			node.setId(nodeElement.getAttributeValue("id"));
			nodeMap.put(node.getId(), node);
			nodeElementMap.put(node, nodeElement);
			
			if (isReference) {
				referenceNodes.add(node);
			}
			graph.getNodes().add(node);
			node.setType(nodeTypeForName(nodeTypeName));
			
			// If the node is a reference there's nothing
			// else to do here
			if (isReference) continue;
			
			createPrimaryPrototypeSlot(node, nodeElement, configuration.getNodePrimarySlotPrototypeNameKey());
		}
		
		for (Node node : graph.getNodes()) {
			Element nodeElement = nodeElementMap.get(node);
			populateSlots(node, nodeElement);
		}
		
		// Replace references with actual elements in the node map
		for (Node referenceNode : referenceNodes) {
			Node target = findReferenceTarget(referenceNode);
			if (target != null) {
				nodeMap.put(referenceNode.getId(), target);
			}
		}
		
		// We don't need references any more
		graph.getNodes().removeAll(referenceNodes);
		for (Node referenceNode : referenceNodes) {
			annihilate(referenceNode);
		}
		
		// Process untyped edge elements
		for (Element edgeElement : getEdgeElements()) {
			
			String edgeTypeName = getElementData(edgeElement, configuration.getEdgeTypeKey());
			if (edgeTypeName != null) continue;
				
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
		
		List<Node> typedEdgeNodes = new ArrayList<Node>();
		
		// Create nodes for typed edges
		for (Element edgeElement : getEdgeElements()) {
			String edgeTypeName = getElementData(edgeElement, configuration.getEdgeTypeKey());
			if (edgeTypeName == null) continue;
			
			Node node = GraphmlFactory.eINSTANCE.createNode();
			node.setId(edgeElement.getAttributeValue("id"));
			nodeElementMap.put(node, edgeElement);
			graph.getNodes().add(node);
			typedEdgeNodes.add(node);
			EdgeType edgeType = edgeTypeForName(edgeTypeName);
			node.setType(edgeType);
			createPrimaryPrototypeSlot(node, edgeElement, configuration.getEdgePrimarySlotPrototypeNameKey());
			
			SlotPrototype sourcePrototype = createEdgeTypeSlotPrototype(node, configuration.getEdgeSourceKey());
			
			if (sourcePrototype != null && edgeType.getSourcePrototype() == null) {
				edgeType.setSourcePrototype(sourcePrototype);
				edgeType.getSlotPrototypes().add(sourcePrototype);
			}
			
			SlotPrototype targetPrototype = createEdgeTypeSlotPrototype(node, configuration.getEdgeTargetKey());
			if (targetPrototype != null && edgeType.getTargetPrototype() == null) {
				edgeType.setTargetPrototype(targetPrototype);
				edgeType.getSlotPrototypes().add(targetPrototype);
			}
			
			SlotPrototype roleInSourcePrototype = createEdgeTypeSlotPrototype(node, configuration.getEdgeRoleInSourceKey());
			if (roleInSourcePrototype != null && edgeType.getRoleInSourcePrototype() == null) {
				edgeType.setRoleInSourcePrototype(roleInSourcePrototype);
			}
			
			SlotPrototype roleInTargetPrototype = createEdgeTypeSlotPrototype(node, configuration.getEdgeRoleInTargetKey());
			if (roleInTargetPrototype != null && edgeType.getRoleInTargetPrototype() == null) {
				edgeType.setRoleInTargetPrototype(roleInTargetPrototype);
			}
		}
		
		// Populate nodes for typed edges
		for (Node edgeNode : typedEdgeNodes) {
			Element edgeElement = nodeElementMap.get(edgeNode);
			populateSlots(edgeNode, edgeElement);
			
			Node source = nodeMap.get(edgeElement.getAttributeValue("source"));
			Node target = nodeMap.get(edgeElement.getAttributeValue("target"));
		
			if (source != null) {
				addEdgeNodeToNode(edgeNode, source, ((EdgeType) edgeNode.getType()).getRoleInSourcePrototype());
				addNodeToEdgeNode(edgeNode, source, ((EdgeType) edgeNode.getType()).getSourcePrototype());
				
			}
			if (target != null) {
				addEdgeNodeToNode(edgeNode, target, ((EdgeType) edgeNode.getType()).getRoleInTargetPrototype());
				addNodeToEdgeNode(edgeNode, target, ((EdgeType) edgeNode.getType()).getTargetPrototype());
			}
			
		}
		
	}
	
	protected SlotPrototype createEdgeTypeSlotPrototype(Node edgeNode, String key) {
		String slotPrototypeLabel = getNodeData(edgeNode, key);
		if (slotPrototypeLabel == null) return null;
		SlotPrototype prototype = new EdgePrototypeLabelParser(slotPrototypeLabel).getPrototype(); 
		return prototype;
	}
	
	protected void addNodeToEdgeNode(Node edgeNode, Node node, SlotPrototype prototype) {
		if (prototype == null) return;
		Slot slot = addSlot(edgeNode, prototype);
		slot.getValues().add(node);
	}
	
	protected void addEdgeNodeToNode(Node edgeNode, Node node, SlotPrototype prototype) {
		if (prototype == null) return;
		Slot slot = addSlot(node, addSlotPrototype(node.getType(), clone(prototype)));
		slot.getValues().add(edgeNode);
	}
	
	protected String getNodeData(Node node, String key) {
		return getElementData(nodeElementMap.get(node), key);
	}
	
	protected void populateSlots(Node node, Element element) {
		for (String label : getLabels(element)) {
			
			// Named slot value
			if (isSlotValueLabel(label)) {
				ValuedSlotPrototypeLabelParser parser = new ValuedSlotPrototypeLabelParser(label);
				Slot slot = addSlot(node, parser.getPrototype());
				slot.setPrototype(addSlotPrototype(node.getType(), parser.getPrototype()));
				slot.getValues().add(parser.getValue());
			}
			// Default slot value
			else { 
				Slot primarySlot = getPrimarySlot(node);
				if (primarySlot != null) primarySlot.getValues().add(label);
			}
			
		}
	}
	
	protected void createPrimaryPrototypeSlot(Node node, Element element, String defaultSlotPrototypeNameKey) {
		// Create default prototype slot if exists
		String defaultSlotPrototypeName = defaultSlotPrototypeNameKey;
		if (defaultSlotPrototypeName == null) return;
		String defaultSlotPrototypeLabel = getElementData(element, defaultSlotPrototypeName);
		if (defaultSlotPrototypeLabel == null) return;
		SlotPrototype prototype = new ValuedSlotPrototypeLabelParser(defaultSlotPrototypeLabel + " = 0").getPrototype();
		prototype.setPrimary(true);
		addSlotPrototype(node.getType(), prototype);
	}
	
	protected String getElementData(Element e, String key) {
		for (Element descriptionElement : getDescendants(e, "data")) {
			if (descriptionElement.getAttributeValue("key","").equals(key)) {
				String data = descriptionElement.getText().trim();
				if (data.length() == 0) return null;
				else return data;
			}
		}
		return null;
	}
	
	protected void annihilate(Node node) {
		node.setType(null);
		for (Slot slot : node.getSlots()) {
			slot.setPrototype(null);
			slot.getValues().clear();
		}
	}
	
	protected Node findReferenceTarget(Node referenceNode) {
		
		for (Node node : referenceNode.getType().getInstances()) {
			if (referenceNodes.contains(node)) continue;
			if (matches(node, referenceNode)) {
				return node;
			}
		}
		
		return null;
		
	}
	
	protected boolean matches(Node node, Node referenceNode) {
		for (Slot referenceSlot : referenceNode.getSlots()) {
			Slot slot = findSlot(node, referenceSlot.getPrototype());
			if (slot == null) return false;
			for (Object referenceValue : referenceSlot.getValues()) {
				if (!slot.getValues().contains(referenceValue)) return false;
			}
		}
		return true;
	}
	
	protected Slot findSlot(Node node, SlotPrototype slotPrototype) {
		for (Slot slot : node.getSlots()) {
			if (slot.getPrototype().equals(slotPrototype)) return slot;
		}
		return null;
	}
	
	/**
	 * If single-valued slots are found to have
	 * multiple values, adjust the multiplicity accordingly.
	 * Also, adjust the type of slot values
	 */
	protected void adjustSlotPrototypeMultiplicitiesAndSlotValueTypes() {
		for (Node node : graph.getNodes()) {
			for (Slot slot : node.getSlots()) {
				if (!slot.getPrototype().isMany() && slot.getValues().size() > 1) {
					slot.getPrototype().setMany(true);
				}
				if (slot.getValues().size() > 0) {
					Type slotType = slot.getPrototype().getType();
					if (slotType instanceof IntegerType || slotType instanceof BooleanType || slotType instanceof RealType) {
						List<Object> castedValues = new ArrayList<Object>();
						for (Object value : slot.getValues()) {
							castedValues.add(cast(value, slotType));
						}
						slot.getValues().clear();
						slot.getValues().addAll(castedValues);
					}
				}
			}
		}
	}
	
	protected Object cast(Object object, Type type) {
		if (type instanceof IntegerType) {
			try {
				return Integer.parseInt(object + "");
			}
			catch (Exception ex) { return 0; }
		}
		else if (type instanceof BooleanType) {
			try {
				return Boolean.parseBoolean(object + "");
			}
			catch (Exception ex) { return false; }			
		}
		else if (type instanceof RealType) {
			try {
				return Float.parseFloat(object + "");
			}
			catch (Exception ex) { return 0.0f; }
		}
		else return object;
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
		slot.setPrototype(prototype);
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
				if (!existingPrototype.isPrimary()) {
					existingPrototype.setPrimary(prototype.isPrimary());
				}
				return existingPrototype;
			}
		}
		nodeType.getSlotPrototypes().add(prototype);
		return prototype;
	}
	
	protected SlotPrototype clone(SlotPrototype prototype) {
		SlotPrototype clone = GraphmlFactory.eINSTANCE.createSlotPrototype();
		clone.setName(prototype.getName());
		clone.setPrimary(prototype.isPrimary());
		clone.setMany(prototype.isMany());
		return clone;
	}
	
	protected Slot getPrimarySlot(Node node) {
		SlotPrototype primarySlotPrototype = null;
		for (SlotPrototype prototype : node.getType().getSlotPrototypes()) {
			if (prototype.isPrimary()) primarySlotPrototype = prototype;
			break;
		}
		
		if (primarySlotPrototype == null) return null;
		
		Slot primarySlot = null;
		for (Slot slot : node.getSlots()) {
			if (slot.getPrototype().equals(primarySlotPrototype)) {
				primarySlot = slot;
				break;
			}
		}
		
		if (primarySlot == null) {
			Slot slot = GraphmlFactory.eINSTANCE.createSlot();
			slot.setPrototype(primarySlotPrototype);
			slot.setOwningNode(node);
			return slot;
		}
		else {
			return primarySlot;
		}
		
	}
	
	protected String getFirstLabel(Element e) {
		List<String> labels = getLabels(e);
		if (labels.size() > 0) return labels.get(0);
		else return null;
	}
	
	protected List<String> getLabels(Element e) {
		String labelTag = "NodeLabel";
		String propertiesKey = configuration.getNodePropertiesKey();
		
		if (e.getName().equals("edge")) {
			labelTag = "EdgeLabel";
			propertiesKey = configuration.getEdgePropertiesKey();
		}
		List<String> labels = new ArrayList<String>();
		for (Element labelElement : getDescendants(e, labelTag)) {
			labels.addAll(getLabels(labelElement.getText()));
		}
		
		for (Element descriptionElement : getDescendants(e, "data")) {
			if (descriptionElement.getAttributeValue("key","").equals(propertiesKey)) {
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
		Iterator<?> iterator = node.getDescendants(new Filter() {
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

	protected EdgeType edgeTypeForName(String name) {
		return (EdgeType) typeForName(name, true);
	}
	
	protected NodeType nodeTypeForName(String name) {
		return typeForName(name, false);
	}
	
	protected NodeType typeForName(String name, boolean edgeType) {
		
		int gt = name.indexOf(">");
		
		if (gt > -1) {
			
			String typeName = name.substring(0, gt).trim();
			String superTypeName = name.substring(gt+1, name.length()).trim();

			NodeType type = typeForName(typeName, edgeType);
			NodeType superType = typeForName(superTypeName, edgeType);
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
		
		NodeType nodeType = null;
		if (edgeType) {
			nodeType = GraphmlFactory.eINSTANCE.createEdgeType();
		}
		else {
			nodeType = GraphmlFactory.eINSTANCE.createNodeType();
		}
		nodeType.setName(name);
		graph.getTypes().add(nodeType);
		return nodeType;
	}
	
	public GraphmlConfiguration getConfiguration() {
		return configuration;
	}
}
