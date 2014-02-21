package impl;

import java.io.File;
import java.util.HashSet;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import util.ArangoParseResource;
import util.ParseResource;

import com.tinkerpop.blueprints.Parameter;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.arangodb.ArangoDBGraph;
import com.tinkerpop.blueprints.impls.arangodb.ArangoDBGraphFactory;
import com.tinkerpop.blueprints.impls.arangodb.ArangoDBVertex;
import com.tinkerpop.blueprints.impls.arangodb.client.ArangoDBConfiguration;


public class ArangoDBSaveTests {

	String system = System.getProperty("user.dir").replaceAll("\\\\", "/");
	String db = system + "/graph";

	private ResourceSet modelResourceSet; // model and metamodel resource set
	private File f; // xmi file to import model from
	private ArangoDBGraph graph; // database
	private HashSet<File> files; // metamodel file(s)
	private HashSet<File> movedfiles; // metamodel file(s) - after moved to the

	
	private File logfile; // log file
	private File indexlogfile; // index log file

	private Resource metamodelResource; // metamodel resource

	@SuppressWarnings("unused")
	private int unset = 0; // the number of unset references
	
	public static void main(String[] args) {
		new ArangoDBSaveTests().run();
	}
	
	private void run() {

		JFrame window = null;
		try {
			
			// OGlobalConfiguration.FILE_MMAP_MAX_MEMORY.setValue("3000MB");

			// OGlobalConfiguration.FILE_MMAP_FORCE_DELAY.setValue(100);

			// OGlobalConfiguration.FILE_MMAP_STRATEGY.setValue(4);

			// OGlobalConfiguration.MEMORY_OPTIMIZE_THRESHOLD.setValue(0.95);

			// OGlobalConfiguration.MVRBTREE_LAZY_UPDATES.setValue(0);

			// OGlobalConfiguration.MVRBTREE_OPTIMIZE_THRESHOLD.setValue(500000);

			// System.out.println(OGlobalConfiguration.FILE_MMAP_MAX_MEMORY.getValue());
			// System.out.println(OGlobalConfiguration.FILE_MMAP_FORCE_DELAY.getValue());

			// OGlobalConfiguration.TX_USE_LOG.setValue(false);

			// OGlobalConfiguration.CACHE_LEVEL1_SIZE.setValue(2500000);

			// disabling lvl 1 cashe crashes referencing when used with ORID
			// refereneces
			// OGlobalConfiguration.CACHE_LEVEL1_ENABLED.setValue(false);

			// OGlobalConfiguration.CACHE_LEVEL2_ENABLED.setValue(false);

			// create resource set and add xmi and ecore packages
			modelResourceSet = new ResourceSetImpl();
			modelResourceSet.getResourceFactoryRegistry()
					.getExtensionToFactoryMap()
					.put("xmi", new XMIResourceFactoryImpl());
			modelResourceSet.getResourceFactoryRegistry()
					.getExtensionToFactoryMap()
					.put("ecore", new EcoreResourceFactoryImpl());

			window = new JFrame();

			JFileChooser filechoser = new JFileChooser();
			filechoser.setDialogTitle("Chose Model File:");

			File temp = new File("");
			String parent = temp.getAbsolutePath().replaceAll("\\\\", "/");

			filechoser.setCurrentDirectory(new File(parent + "/model/"));
			FileNameExtensionFilter filter = new FileNameExtensionFilter("XMI",
					"xmi");
			filechoser.setFileFilter(filter);

			if (filechoser.showDialog(window, "Select File") == JFileChooser.APPROVE_OPTION)
				f = filechoser.getSelectedFile();
			else {
				System.err
						.println("Chosing of model file canceled, program terminated");
				System.exit(1);
			}

			db+="-"+f.getName();
			
			db = system + "/moo-t4";
			
			files = new HashSet<File>();

			movedfiles = new HashSet<File>();

			@SuppressWarnings("unused")
			long cpu = System.nanoTime();

			boolean isNew = false;
			//graph = new ArangoDBGraph("localhost", 8529, "testArango", "EClasss", "EReferences");
			
			ArangoDBConfiguration config = new ArangoDBConfiguration();
			config.setBatchSize(5000);
			config.setMaxPerConnection(100);
			graph = new ArangoDBGraph(config, "whateve", "EClass", "EReference");
			
			
			//graph = ArangoDBGraphFactory.createArangoDBGraph();
			
			
			isNew = true;
			//graph = new arango("local:" + db);
			
			registerShutdownHook(graph);

			// create log and indexlog files
			logfile = new File("log.txt");
			try {
				if (!logfile.exists())
					logfile.createNewFile();
			} catch (Exception ee) {
				ee.printStackTrace();
			}
			indexlogfile = new File("indexlog.txt");
			try {
				if (!indexlogfile.exists())
					indexlogfile.createNewFile();
			} catch (Exception ee) {
				ee.printStackTrace();
			}

			// new database actions
			if (isNew) {

				// MASSIVE BUG, BREAKS REFERENCING!!! - caused by using ORID
				// referencing without a lvl1cache
				//graph.declareIntent(new OIntentMassiveInsert());

				
				// create root node (currently no useful info in it)
				Parameter<String, String> type   = new Parameter<String, String>("type", "root");
				Parameter<String, Boolean> unique = new Parameter<String, Boolean>("unique", true);

				graph.createKeyIndex("root", Vertex.class, type, unique);
				
				ArangoDBVertex root = (ArangoDBVertex) graph.addVertex(null);
				root.setProperty("root", graph.getProperty("_id"));
				//root.save();

				// copy the metamodel files to the database folder (for faster
				// access should the model be in a remote repository)
				for (File metamodelFile : f.getParentFile().listFiles()) {
					if (metamodelFile.getAbsolutePath().endsWith(".ecore")) {
						files.add(metamodelFile);
					}
				}
				for (File metamodelFile : files) {
					File destfile = new File(db + "/" + metamodelFile.getName());
					new util.CopyFile().copyFile(metamodelFile, destfile);
					movedfiles.add(destfile);
				}
				System.out.println("metamodel copied to database...");

				// register the EPackages used by this graph.
				for (File metamodelFile : movedfiles) {

					files.add(metamodelFile);
					metamodelResource = modelResourceSet.getResource(
							URI.createFileURI(metamodelFile.getAbsolutePath()),
							true);

					for (EObject eObject : metamodelResource.getContents()) {

						if (eObject instanceof EPackage)
							new util.ArangoResource()
									.registerPackages((EPackage) eObject);

					}
				}
				System.out.println("metamodel registered...");

				// populate the database
				addnodes();

			}

			// log graph and index
			// System.out.println(new util.ToLog().toLog(graph, logfile,
			// unset));
			// new util.indexLog().log(graph, indexlogfile);

			// print information about the contents of the graph
			/*int element_count = ((List<?>) graph.command(
					new OCommandSQL("select * from index:metacdictionary"))
					.execute()).size();

			System.out.print("Metamodel Class Dictionary contains: ");

			System.out.println(element_count
					+ " entries ( unique-uri-id : nodeid )");

			//
			System.out.print("Dictionary contains: ");

			element_count = ((List<?>) graph.command(
					new OCommandSQL("select * from index:dictionary"))
					.execute()).size();

			System.out.println(element_count
					+ " entries ( unique-uri-id : nodeid )");

			System.out
					.println("\nProgram ending with no errors, shutting down database...");
			*/
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			long init = System.nanoTime();
			graph.shutdown();
			System.out.println("(took ~" + (System.nanoTime() - init)
					/ 1000000000 + "sec to commit changes)");
			window.dispose();
		}

	}
	
	private void addnodes() {

		long init = System.nanoTime();

		Resource modelResource = modelResourceSet.getResource(
				URI.createFileURI(f.getAbsolutePath()), true);

		System.out.println("model resource loaded, (took ~"
				+ (System.nanoTime() - init) / 1000000000 + "sec)");

		unset = new ParseResource(graph, movedfiles, modelResource,
				modelResourceSet).getUnset();

		init = System.nanoTime();

		try {
			modelResource.unload();
			System.gc();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("resource unloaded (took ~"
				+ (System.nanoTime() - init) / 1000000000 + "sec)\n");
	}

	
	private void registerShutdownHook(final ArangoDBGraph database) {

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				try {
					long l = System.nanoTime();
					//ArangoDBConfiguration configuration = new ArangoDBConfiguration();
					database.shutdown();
					System.out.println("SHUTDOWN HOOK INVOKED: (took ~"
							+ (System.nanoTime() - l) / 1000000000
							+ "sec to commit changes)");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
