package org.eclipse.epsilon.emc.emf.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.emc.emf.EmfSmartModel;
import org.eclipse.epsilon.emc.emf.SmartEmfModelResourceFactory;
import org.eclipse.epsilon.eol.analysis.optimisation.loading.context.ModelContainer;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.junit.Before;
import org.junit.Test;

public class SmartEmfModelTests {
	
	@Before
	public void teardown() {
		SmartEmfModelResourceFactory.getInstance().clearCache();
	}
	
	@Test
	public void testLoadAllOfTypeEClassifier() throws Exception {
		ModelContainer container = new ModelContainer("ecore");
		container.addToModelElementsAllOfType("EClassifier");
		assertEquals(0, load(container).allContents().size());
	}
	
	@Test
	public void testLoadAllOfKindEClassifier() throws Exception {
		ModelContainer container = new ModelContainer("ecore");
		container.addToModelElementsAllOfKind("EClassifier");
		
		assertEquals(2, load(container).allContents().size());		
	}
	
	@Test
	public void testLoadAttribute() throws Exception {
		// EClass.all.ePackage.name.println();
		ModelContainer container = new ModelContainer("ecore");
		container.addToModelElementsAllOfKind("EClass");
		container.addReferenceToModelElement("EClass", "ePackage");
		container.addAttributeToModelElement("EPackage", "name");
		container.addToModelElementsAllOfKind("EPackage");
		//container.addToModelElementsAllOfType("EAttribute");
		//container.addAttributeToModelElement("EClassifier", "name");
		
		assertEquals(3, load(container).allContents().size());		
	}
	
	@Test
	public void testLoadReference() throws Exception {
		ModelContainer container = new ModelContainer("ecore");
		container.addToModelElementsAllOfType("EClass");
		container.addToModelElementsAllOfKind("EStructuralFeature");
		container.addAttributeToModelElement("EClass", "eStructuralFeatures");
		
		assertEquals(5, load(container).allContents().size());		
	}
	
	public EmfSmartModel load(ModelContainer container) throws EolModelLoadingException {
		EmfSmartModel model = new EmfSmartModel();
		
		model.setName("M");
		model.setReadOnLoad(true);
		model.setMetamodelUri(EcorePackage.eNS_URI);
		model.setModelFileUri(URI.createURI(SmartEmfModelTests.class.getResource("filesystem.ecore").toString()));
		
		ArrayList<ModelContainer> containers = new ArrayList<ModelContainer>();
		containers.add(container);
		
		model.setModelContainers(containers);
		model.setSmartLoading(true);
		model.setPartialLoading(true);
		model.preProcess();
		model.load();
		
		return model;
	}
	
}
