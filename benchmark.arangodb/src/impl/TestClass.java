package impl;


import java.util.LinkedList;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.arangodb.ArangoDBGraph;
import com.tinkerpop.blueprints.impls.arangodb.ArangoDBGraphException;
import com.tinkerpop.blueprints.impls.arangodb.ArangoDBVertex;
import com.tinkerpop.blueprints.impls.arangodb.client.ArangoDBBaseDocument;
import com.tinkerpop.blueprints.impls.arangodb.client.ArangoDBConfiguration;

public class TestClass {

	public static void main(String[] args) {
		try {
			  String graphName = "MyFirstGraph";
			  String vertices = "MyVerticesCollection";
			  String edges = "MyEdgesCollection";

			  // cleate a ArangoDB graph
			  ArangoDBGraph graph = new ArangoDBGraph("localhost", 8529, graphName, vertices, edges);
			  
			  
			  ArangoDBVertex v1 = (ArangoDBVertex) graph.addVertex(null);

			  v1.setProperty("name", "William's node");
			  
			  System.out.println(v1.getId().toString());
			  Vertex v2 = graph.addVertex(null);

			  Vertex v = graph.getVertices("name", "William's node").iterator().next();
			  
			  System.out.println(v.toString());
			  // create edge
			  Edge e1 = graph.addEdge("e1", v1, v2, "knows");

			  // close the graph
			  graph.shutdown();
			} catch (ArangoDBGraphException e) {
			  e.printStackTrace();
			  //fail(e.getMessage());
			}
	}
	
}
