package org.eclipse.epsilon.epsilonoid;

import java.io.InputStream;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ExampleSet {
	
	protected ArrayList<Example> examples;
	
	public ArrayList<Example> getExamples() {
		return examples;
	}
	
	public void setExamples(ArrayList<Example> examples) {
		this.examples = examples;
	}
	
	public void load(InputStream inputStream) {
		XStream xStream = new XStream(new DomDriver());
		xStream.alias("exampleset", ExampleSet.class);
		xStream.alias("example", Example.class);
		xStream.useAttributeFor(Example.class, "title");
		xStream.useAttributeFor(Example.class, "language");
		xStream.fromXML(inputStream, this);
	}
	
}
