package org.eclipse.epsilon.emc.bibtex;

import java.io.FileInputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.common.util.StringUtil;
import org.eclipse.epsilon.emc.bibtex.impl.BibtexBibliography;
import org.eclipse.epsilon.emc.bibtex.impl.BibtexBibtexPackage;
import org.eclipse.epsilon.emc.bibtex.parser.javacc.Bibtex;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IReflectiveModel;

public class BibtexModel extends EmfModel implements IReflectiveModel {
	
	public static final String PROPERTY_MODEL_URI = EmfModel.PROPERTY_MODEL_URI;
	
	protected Bibtex bibtex;
	
	@Override
	public void load(StringProperties properties, String basePath) throws EolModelLoadingException {
		
		this.modelUri = URI.createURI(StringUtil.toString(basePath) + properties.getProperty(PROPERTY_MODEL_URI));
		try {
			String path = this.modelUri.toString();
			this.bibtex = new Bibtex(new FileInputStream(path));
		} catch (Exception e) {
			throw new EolModelLoadingException(e, this);
		}
		super.load(properties, basePath);
		this.expand = false;
		this.isMetamodelFileBased = false;
		this.metamodelUris.add(URI.createURI(BibtexBibtexPackage.eNS_URI));
	}
	
	@Override
	public void loadModelFromUri() throws EolModelLoadingException {
		
        // Check if global package registry contains the EcorePackage
		if (EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI) == null) {
			EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		}
		
		BibtexBibtexPackage.eINSTANCE.eClass();
		ResourceSet rs = new ResourceSetImpl();
		
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
	    reg.getExtensionToFactoryMap().put("bib", new XMIResourceFactoryImpl());
		
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		modelImpl = rs.createResource(URI.createFileURI(""));
		
		if (this.readOnLoad) {
			try {
				BibtexBibliography b = bibtex.bibliography();
				modelImpl.getContents().add(b);
			} catch (Exception e) {
				throw new EolModelLoadingException(e, this);
			} catch (Error e) {
				Exception ex = new Exception("Error. " + e.getMessage());
				throw new EolModelLoadingException(ex, this);
            } 
		}
	}
	

	@Override
	public boolean store() {
		// TODO Auto-generated method stub
		return false;
	}


}
