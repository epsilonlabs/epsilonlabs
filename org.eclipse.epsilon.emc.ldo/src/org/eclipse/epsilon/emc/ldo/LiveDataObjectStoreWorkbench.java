package org.eclipse.epsilon.emc.ldo;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.operations.contributors.CollectionOperationContributor;
import org.eclipse.epsilon.eol.execute.operations.contributors.NumberOperationContributor;

public class LiveDataObjectStoreWorkbench {
	
	public static void main(String[] args) throws Exception {
		
		String basepath = "/Users/dimitrioskolovos/Projects/Eclipse/3.7.1/" + 
			"workspace-new/org.eclipse.epsilon.emc.ldo/";
		
		String scriptfilename = basepath + "scripts/sample.eol";
		
		String filename = basepath + "db/test";
		
		// Create datastore
		
		File db = new File(filename + ".h2.db");
		
		if (db.exists()) db.delete();
		
		// See default sizes of tables
		
		if (!db.exists()) {
			System.err.println("Creating store");
			LiveDataObjectStoreBuilder builder = new LiveDataObjectStoreBuilder(filename);
			builder.initialize(true); // Indices give a ~10% improvement in speed and also 
									  // increase size by ~10%
			for (int i = 0; i<100; i++) {
				System.err.println(i);
				builder.add(EcorePackage.eINSTANCE, false);
			}
			builder.dispose();
		}
		else {
			System.err.println("Using existing store...");
		}
		
		// Create EOL script
		
		EolModule module = new EolModule();
		module.parse(new File(scriptfilename));
		if (module.getParseProblems().size() > 0) {
			System.err.println("Something's wrong with " + scriptfilename);
			return;
		}
 		
		LiveDataObjectStore liveDataObjectStore = new LiveDataObjectStore();
		liveDataObjectStore.setName("M");
		liveDataObjectStore.setFilename(filename);
		liveDataObjectStore.addEPackage(EcorePackage.eINSTANCE);
		
		module.getContext().getModelRepository().addModel(liveDataObjectStore);
		module.getContext().getFrameStack().put(Variable.
				createReadOnlyVariable("reg", LiveDataObjectRegistry.INSTANCE));
		module.getContext().getFrameStack().put(Variable.
				createReadOnlyVariable("timer", new SimpleTimer()));
	
		System.err.println("Running...");
		
		liveDataObjectStore.getConnection();
		
		ArrayList<Long> results = new ArrayList<Long>();
		for (int j=0;j<101;j++) {
			long now = System.currentTimeMillis();
			module.execute();
			if (j>0) results.add(System.currentTimeMillis() - now);
		}
		
		
		Number min = new CollectionOperationContributor(results).min();
		Number max = new CollectionOperationContributor(results).max();
		
		results.remove(min);
		results.remove(max);
		
		Number average = new CollectionOperationContributor(results).sum().doubleValue() / results.size();
		System.err.println("Min: " + min + ", Max: " + max + ", Average: " + average);
		System.err.println("All: " + new CollectionOperationContributor(results).concat(","));
		/*
		LiveDataObjectStore db = new LiveDataObjectStore();
		
		System.err.println("Creating db");
		//db.create(filename);
		
		db.addEPackage(EcorePackage.eINSTANCE);
		
		//System.err.println("Creating test data");
		//db.createTestData();
		
		//System.err.println("Query");
		
		Collection<LiveDataObject> allOfType = db.getAllOfType("EClass");
		
		for (LiveDataObject o : allOfType) {
			Collection p = (Collection) o.get("eSuperTypes");
			System.err.print(o.get("name") + " -> ");
			for (Object est : p) {
				System.err.print(((LiveDataObject) est).get("name") + " ");
			}
			System.err.println();
			
		}
		
		LiveDataObject d = new LiveDataObject();
		
		System.err.println(LiveDataObjectRegistry.INSTANCE.getRegisteredSize());
		
		d = null;
		allOfType.clear();
		allOfType = null;
		System.gc();
		
		System.err.println(LiveDataObjectRegistry.INSTANCE.getRegisteredSize());
		
		System.err.println(db.allContents().size());
		
//		System.err.println(db.getObjectCacheSize());
//		
//		System.gc();
//		
//		System.err.println(db.getObjectCacheSize());
		*/
	}
	
}
