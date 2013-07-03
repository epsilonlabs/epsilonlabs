package org.eclipse.epsilon.emc.graphml;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.models.Model;

public class GraphmlModel extends Model {
	
	public static final String PROPERTY_FILE = "file";
	protected File file = null;	
	protected Graph graph;
	
	@Override
	public void load(StringProperties properties, String basePath)
			throws EolModelLoadingException {
		super.load(properties, basePath);
		String filePath = properties.getProperty(GraphmlModel.PROPERTY_FILE);
		
		if (filePath != null && filePath.trim().length() > 0) {
			if (basePath != null) filePath = basePath + filePath;
			file = new File(filePath);
		}
		
		load();
	}
	
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
			type = GraphmlFactory.eINSTANCE.createNodeType();
			type.setName(t);
			graph.getTypes().add(type);
		}
		
		Node node = GraphmlFactory.eINSTANCE.createNode();
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
		if (readOnLoad) {
			GraphmlImporter importer = new GraphmlImporter();
			try {
				graph = importer.importGraph(file);
			} catch (Exception e) {
				throw new EolModelLoadingException(e, this);
			}
		}
		else {
			graph = GraphmlFactory.eINSTANCE.createGraph();
		}
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
	
	protected GraphmlModelPropertyGetter propertyGetter = new GraphmlModelPropertyGetter();
	
	@Override
	public IPropertyGetter getPropertyGetter() {
		return propertyGetter;
	}
	
}
