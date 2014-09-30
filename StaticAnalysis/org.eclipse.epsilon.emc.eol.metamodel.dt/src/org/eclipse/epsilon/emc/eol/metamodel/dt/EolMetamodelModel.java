package org.eclipse.epsilon.emc.eol.metamodel.dt;

import java.io.File;
import java.net.URISyntaxException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.epsilon.common.module.ModuleMarker;
import org.eclipse.epsilon.common.module.ModuleMarker.Severity;
import org.eclipse.epsilon.common.parse.Region;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.EolLibraryModule;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.IEolLibraryModule;
import org.eclipse.epsilon.eol.ast2eol.Ast2EolContext;
import org.eclipse.epsilon.eol.ast2eol.EolElementCreatorFactory;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.EolPackage;
import org.eclipse.epsilon.eol.visitor.resolution.type.impl.TypeResolver;
import org.eclipse.epsilon.eol.visitor.resolution.variable.impl.VariableResolver;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.etl.ast2etl.Ast2EtlContext;
import org.eclipse.epsilon.etl.ast2etl.EtlElementCreatorFactory;
import org.eclipse.epsilon.etl.visitor.resolution.type.impl.EtlTypeResolver;
import org.eclipse.epsilon.etl.visitor.resolution.variable.impl.EtlVariableResolver;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.ast2evl.Ast2EvlContext;
import org.eclipse.epsilon.evl.ast2evl.EvlElementCreatorFactory;
import org.eclipse.epsilon.evl.visitor.resolution.impl.EvlVariableResolver;
import org.eclipse.epsilon.evl.visitor.resolution.type.impl.EvlTypeResolver;

public class EolMetamodelModel extends EmfModel{
	
	@Override
	protected ResourceSet createResourceSet() {
		return new ResourceSetImpl() {
			@Override
			public Resource createResource(URI uri) {
				
				try {
					IFile iFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.path().replace("resource/", "")));
					
					EolElement dom = null;
					IEolLibraryModule module = null;
					
					String fileNameString = iFile.getLocation().toOSString();
					
					if (fileNameString.endsWith("eol")) {
					
						module = new EolModule(); 
						module.parse(iFile.getLocation().toFile());
					
						Ast2EolContext context = new Ast2EolContext((EolLibraryModule) module);
						EolElementCreatorFactory factory = context.getEolElementCreatorFactory();
						dom = factory.createDomElement(module.getAst(), null, context);
						
						VariableResolver vr = new VariableResolver();
						vr.run(dom);
						
						TypeResolver tr = new TypeResolver();
						tr.getTypeResolutionContext();
						tr.run(dom);
					}
					else if (fileNameString.endsWith("etl")) {
						module = new EtlModule();
						module.parse(iFile.getLocation().toFile());
						
						
						Ast2EtlContext context = new Ast2EtlContext((EolLibraryModule) module);
						dom = context.getEtlElementCreatorFactory().createDomElement(module.getAst(), null, context);
						
						EtlVariableResolver etlvr = new EtlVariableResolver();
						etlvr.run(dom);
						
						EtlTypeResolver etltr = new EtlTypeResolver((EolLibraryModule) module);
						etltr.run(dom);
					}
					
					else if (fileNameString.endsWith("evl"))
					{
						System.out.println("It's EVL");
						module = new EvlModule();
						module.parse(iFile.getLocation().toFile());
						
						Ast2EvlContext context = new Ast2EvlContext((EolLibraryModule) module);
						dom = context.getEvlElementCreatorFactory().createDomElement(module.getAst(), null, context);
						
						EvlVariableResolver evlvr = new EvlVariableResolver();
						evlvr.run(dom);
						
						EvlTypeResolver evltr = new EvlTypeResolver((EolLibraryModule) module);
						evltr.run(dom);
					}
					
					ResourceImpl resource = new ResourceImpl(uri);
					resource.getContents().add(dom);
					getResources().add(resource);
					getPackageRegistry().put(EolPackage.eINSTANCE.getNsURI(), EolPackage.eINSTANCE);
					return resource;
					
				} catch (Exception e) {
					e.printStackTrace();
				}

				return super.createResource(uri);
			}
		};
	}
	
	@Override
	public boolean store() {
		return false;
	}
	
	@Override
	public boolean store(URI uri) {
		return false;
	}
	
}
