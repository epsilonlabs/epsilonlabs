package workbench;

import java.io.File;
import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.ast2eol.context.Ast2EolContext;
import org.eclipse.epsilon.eol.dom.Import;
import org.eclipse.epsilon.eol.effective.metamodel.extraction.impl.EffectiveMetamodelExtractor;
import org.eclipse.epsilon.eol.metamodel.EOLElement;
import org.eclipse.epsilon.eol.visitor.resolution.type.naive.impl.nonImportant.EOLTypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.variable.impl.EOLVariableResolver;

public class Workbench {

	public static void main(String[] args) throws Exception {
		Workbench workbench = new Workbench();
		workbench.runGrabats();

	}

	public void runGrabats() throws Exception {
		long res = 0;
		for (int k = 0; k < 15; k++) {
			URL url = getClass().getResource("grabats_looped.eol");
			// System.out.println(url.toString());
			EolModule eolModule = new EolModule();
			try {
				eolModule.parse(new File(url.getPath()));
			} catch (Exception e) {
				e.printStackTrace();
			}

			for (Import imp : eolModule.getImports()) {
				System.out.println(imp.getModule().getAst().toStringTree());
			}

			loadEPackageFromFile("model/JDTAST.ecore");

			long start = System.nanoTime();

			Ast2EolContext context = new Ast2EolContext();
			EOLElement dom = context.getEolElementCreatorFactory()
					.createEOLElement(eolModule.getAst(), null, context);

			EOLVariableResolver vr = new EOLVariableResolver();
			vr.run(dom);

			EOLTypeResolver tr = new EOLTypeResolver();
			tr.getTypeResolutionContext().setEolModule(eolModule);
			tr.run(dom);

			EffectiveMetamodelExtractor loa = new EffectiveMetamodelExtractor();
			loa.run(dom);

			long end = System.nanoTime();

			if (k >= 5) {
				res = ((end - start) + res) / 2;
			}
			loa.getEffectiveMetamodelExtractionContext().print();
		}
		System.out.println("grabats: " + (res) / 1000000);
	}

	public void runSet1() throws Exception {
		for (int i = 0; i <= 4; i++) {
			for (int j = 1; j <= 5; j++) {
				long res = 0;
				String nameString = "set" + i + "_" + j * 20 + "percent.eol";
				for (int k = 0; k < 15; k++) {
					URL url = getClass().getResource(nameString);
					// System.out.println(url.toString());
					EolModule eolModule = new EolModule();
					try {
						eolModule.parse(new File(url.getPath()));
					} catch (Exception e) {
						e.printStackTrace();
					}

					for (Import imp : eolModule.getImports()) {
						System.out.println(imp.getModule().getAst()
								.toStringTree());
					}

					loadEPackageFromFile("model/JDTAST.ecore");

					long start = System.nanoTime();

					Ast2EolContext context = new Ast2EolContext();
					EOLElement dom = context
							.getEolElementCreatorFactory()
							.createEOLElement(eolModule.getAst(), null, context);

					EOLVariableResolver vr = new EOLVariableResolver();
					vr.run(dom);

					EOLTypeResolver tr = new EOLTypeResolver();
					tr.getTypeResolutionContext().setEolModule(eolModule);
					tr.run(dom);

					EffectiveMetamodelExtractor loa = new EffectiveMetamodelExtractor();
					loa.run(dom);

					long end = System.nanoTime();

					if (k >= 5) {
						res = ((end - start) + res) / 2;
					}
					loa.getEffectiveMetamodelExtractionContext().print();
				}
				System.out.println(nameString + ": " + (res) / 1000000);
			}
		}

	}

	public void run() throws Exception {

		URL url = getClass().getResource("grabats.eol");
		// System.out.println(url.toString());
		EolModule eolModule = new EolModule();
		try {
			eolModule.parse(new File(url.getPath()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Import imp : eolModule.getImports()) {
			System.out.println(imp.getModule().getAst().toStringTree());
		}

		loadEPackageFromFile("model/JDTAST.ecore");

		long start = System.nanoTime();

		Ast2EolContext context = new Ast2EolContext();
		EOLElement dom = context.getEolElementCreatorFactory()
				.createEOLElement(eolModule.getAst(), null, context);

		EOLVariableResolver vr = new EOLVariableResolver();
		vr.run(dom);

		EOLTypeResolver tr = new EOLTypeResolver();
		tr.getTypeResolutionContext().setEolModule(eolModule);
		tr.run(dom);

		EffectiveMetamodelExtractor loa = new EffectiveMetamodelExtractor();
		loa.run(dom);

		long end = System.nanoTime();

		System.out.println((end - start) / 1000000);

		loa.getEffectiveMetamodelExtractionContext().print();

	}

	public static EPackage loadEPackageFromFile(String fileName) {
		EPackage result = null;
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("ecore", new EcoreResourceFactoryImpl());
		URI uri = URI.createFileURI(new File(fileName).getAbsolutePath());
		Resource resource = resourceSet.getResource(uri, true);
		for (EObject obj : resource.getContents()) {
			if (obj instanceof EPackage) {
				EPackage.Registry.INSTANCE
						.put(((EPackage) obj).getNsURI(), obj);
				result = (EPackage) obj;
			}
		}
		return result;
	}

}
