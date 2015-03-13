package org.eclipse.epsilon.emc.emf.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.emc.emf.EmfSmartModel;
import org.eclipse.epsilon.emc.emf.SmartEmfModelResourceFactory;
import org.eclipse.epsilon.eol.analysis.optimisation.loading.context.EffectiveMetamodel;
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
		EffectiveMetamodel container = new EffectiveMetamodel("ecore");
		container.addToAllOfType("EClassifier");
		assertEquals(0, load(container).allContents().size());
	}
	
	@Test
	public void testLoadAllOfKindEClassifier() throws Exception {
		EffectiveMetamodel container = new EffectiveMetamodel("ecore");
		container.addToAllOfKind("EClassifier");
		
		assertEquals(2, load(container).allContents().size());		
	}
	
	@Test
	public void testLoadAttribute() throws Exception {
		// EClass.all.ePackage.name.println();
		EffectiveMetamodel container = new EffectiveMetamodel("ecore");
		container.addToAllOfKind("EClass");
		container.addReferenceToModelElement("EClass", "ePackage");
		container.addAttributeToModelElement("EPackage", "name");
		container.addToAllOfKind("EPackage");
		//container.addToModelElementsAllOfType("EAttribute");
		//container.addAttributeToModelElement("EClassifier", "name");
		
		assertEquals(3, load(container).allContents().size());		
	}
	
	@Test
	public void testPackageClassifiers() throws Exception {
		EffectiveMetamodel container = new EffectiveMetamodel("ecore");
		container.addToAllOfKind("EPackage");
		container.addToAllOfKind("EClassifier");
		EPackage ePackage = (EPackage) load(container).getAllOfType("EPackage").iterator().next();
		// We haven't asked EmfSmartModel to link packages to their contained classifiers
		assertTrue(ePackage.getEClassifiers().isEmpty());
	}
	
	@Test
	public void testEmptyClassifiers() throws Exception {
		EffectiveMetamodel container = new EffectiveMetamodel("ecore");
		container.addToAllOfKind("EPackage");
		EPackage ePackage = (EPackage) load(container).getAllOfType("EPackage").iterator().next();
		// We haven't asked EmfSmartModel to load package names so the following should return null
		assertTrue(ePackage.getEClassifiers().isEmpty());
	}
	
	@Test
	public void testNullPackageNames() throws Exception {
		EffectiveMetamodel container = new EffectiveMetamodel("ecore");
		container.addToAllOfKind("EPackage");
		EPackage ePackage = (EPackage) load(container).getAllOfType("EPackage").iterator().next();
		// We haven't asked EmfSmartModel to load package names so the following should return null
		assertNull(ePackage.getName());
	}
	
	@Test
	public void testLoadReference() throws Exception {
		EffectiveMetamodel container = new EffectiveMetamodel("ecore");
		container.addToAllOfType("EClass");
		container.addToAllOfKind("EStructuralFeature");
		container.addAttributeToModelElement("EClass", "eStructuralFeatures");
		
		assertEquals(5, load(container).allContents().size());		
	}
	
	public EmfSmartModel load(EffectiveMetamodel container) throws EolModelLoadingException {
		EmfSmartModel model = new EmfSmartModel();
		
		model.setName("M");
		model.setReadOnLoad(true);
		model.setMetamodelUri(EcorePackage.eNS_URI);
		model.setModelFileUri(URI.createURI(SmartEmfModelTests.class.getResource("filesystem.ecore").toString()));
		
		ArrayList<EffectiveMetamodel> containers = new ArrayList<EffectiveMetamodel>();
		containers.add(container);
		
		model.setModelContainers(containers);
		model.setSmartLoading(true);
		model.setPartialLoading(true);
		model.setLoadAllAttributes(false);
		model.preProcess();
		model.load();
		
		return model;
	}
	
}
