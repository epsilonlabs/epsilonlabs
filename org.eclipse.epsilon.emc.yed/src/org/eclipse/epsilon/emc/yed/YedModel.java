package org.eclipse.epsilon.emc.yed;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.models.Model;
import org.w3c.dom.traversal.NodeFilter;

public class YedModel extends Model {
	
	public static void main(String[] args) throws Exception {
		
		Graph graph = YedFactory.eINSTANCE.createGraph();
		
		NodeType entityType = YedFactory.eINSTANCE.createNodeType();
		entityType.setName("Entity");
		graph.getTypes().add(entityType);
		
		SlotPrototype namePrototype = YedFactory.eINSTANCE.createSlotPrototype();
		namePrototype.setName("name");
		namePrototype.setType(PrimitiveTypes.getStringType());
		namePrototype.setOwningType(entityType);
		
		SlotPrototype extendsPrototype = YedFactory.eINSTANCE.createSlotPrototype();
		extendsPrototype.setName("extends");
		extendsPrototype.setType(entityType);
		extendsPrototype.setOwningType(entityType);
		extendsPrototype.setMany(true);
		
		Node customerNode = YedFactory.eINSTANCE.createNode();
		customerNode.setType(entityType);
		Slot customerNameSlot = YedFactory.eINSTANCE.createSlot();
		customerNameSlot.setPrototype(namePrototype);
		customerNode.getSlots().add(customerNameSlot);
		customerNameSlot.getValues().add("Customer");
		
		Node personNode = YedFactory.eINSTANCE.createNode();
		personNode.setType(entityType);
		Slot personNameSlot = YedFactory.eINSTANCE.createSlot();
		personNameSlot.setPrototype(namePrototype);
		personNode.getSlots().add(personNameSlot);
		personNameSlot.getValues().add("Person");
		
		graph.getNodes().add(customerNode);
		graph.getNodes().add(personNode);
		
		
		YedModel model = new YedModel();
		model.setName("X");
		model.setGraph(graph);
		
		/*
		EolModule module = new EolModule();
		module.parse("for (e in Entity.all) { e.name.println(); e.extends.add(e); e.extends.println(); }");
		module.getContext().getModelRepository().addModel(model);
		module.execute();
		*/
	}
	
	
	protected Graph graph;
	
	@Override
	public Collection<?> allContents() {
		return graph.getNodes();
	}

	@Override
	public Object createInstance(String t)
			throws EolModelElementTypeNotFoundException,
			EolNotInstantiableModelElementTypeException {
		
		NodeType type = nodeTypeForName(t);
		
		if (type == null) {
			type = YedFactory.eINSTANCE.createNodeType();
			type.setName(t);
			graph.getTypes().add(type);
		}
		
		Node node = YedFactory.eINSTANCE.createNode();
		node.setType(type);
		graph.getNodes().add(node);
		
		return node;
	}

	@Override
	public void deleteElement(Object o) throws EolRuntimeException {
		graph.getNodes().remove(o);
	}

	@Override
	public Collection<?> getAllOfKind(String type)
			throws EolModelElementTypeNotFoundException {
		
		ArrayList<Node> nodes = new ArrayList<Node>();
		for (NodeType nodeType : getAllSubTypes(nodeTypeForName(type))) {
			nodes.addAll(nodeType.getInstances());
		}
		return nodes;
	}
	
	protected Set<NodeType> getAllSubTypes(NodeType nodeType) {
		HashSet<NodeType> allSubTypes = new HashSet<NodeType>();
		collectAllSubTypes(nodeType, allSubTypes);
		return allSubTypes;
	}
	
	protected void collectAllSubTypes(NodeType nodeType, Set<NodeType> allSubTypes) {
		if (!allSubTypes.contains(nodeType)) {
			allSubTypes.add(nodeType);
			for (NodeType subType : nodeType.getSubTypes()) {
				collectAllSubTypes(subType, allSubTypes);
			}
		}
	}
	
	@Override
	public Collection<?> getAllOfType(String type)
			throws EolModelElementTypeNotFoundException {
		return nodeTypeForName(type).getInstances();
	}

	@Override
	public Object getElementById(String id) {
		for (Node node : graph.getNodes()) {
			if (node.getId().equals(id)) return node;
		}
		return null;
	}

	@Override
	public String getElementId(Object o) {
		return ((Node) o).getId();
	}

	@Override
	public Object getEnumerationValue(String arg0, String arg1)
			throws EolEnumerationValueNotFoundException {
		return null;
	}

	@Override
	public String getTypeNameOf(Object o) {
		return ((Node) o).getType().getName();
	}

	@Override
	public boolean hasType(String type) {
		return nodeTypeForName(type) != null;
	}

	@Override
	public boolean isInstantiable(String type) {
		return true;
	}

	@Override
	public void load() throws EolModelLoadingException {
		
	}

	@Override
	public boolean owns(Object o) {
		return graph.getNodes().contains(o);
	}

	@Override
	public void setElementId(Object o, String id) {
		((Node) o).setId(id);
	}

	@Override
	public boolean store() {
		return false;
	}

	@Override
	public boolean store(String arg0) {
		return false;
	}
	
	protected NodeType nodeTypeForName(String name) {
		for (Type type : graph.getTypes()) {
			if (type instanceof NodeType && type.getName().equals(name)) {
				return (NodeType) type;
			}
		}
		return null;
	}
	
	public void setGraph(Graph graph) {
		this.graph = graph;
	}
	
	protected YedModelPropertyGetter propertyGetter = new YedModelPropertyGetter();
	
	@Override
	public IPropertyGetter getPropertyGetter() {
		return propertyGetter;
	}
	
}
