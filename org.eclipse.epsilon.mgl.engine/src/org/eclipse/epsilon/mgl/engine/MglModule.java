package org.eclipse.epsilon.mgl.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.epsilon.emc.plainxml.PlainXmlModel;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.annotations.EolAnnotationsUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.ModelReference;

public class MglModule extends EolModule {
	
	protected String initOperationName = "init";
	
	public static void main(String[] args) throws Exception {
		
		MglModule module = new MglModule();
		module.parse("var x = t_a.generate(5); operation t_a init(i : Integer) { self.a_y = ('foo'+i).println(); }");
		PlainXmlModel model = new PlainXmlModel();
		model.setName("M");
		model.setReadOnLoad(false);
		model.load();
		module.getContext().getModelRepository().addModel(model);
		module.execute();
		
	}
	
	@Override
	public Object execute() throws EolRuntimeException {
		wrapModels();
		context.getOperationContributorRegistry().add(new ModelElementTypeOperationContributor());
		return super.execute();
	}
	
	protected void created(Object instance) {
		try {
			getContext().setInstanceCount(getContext().getInstanceCount()+1);
			List<Integer> parameters = Arrays.asList(getContext().getInstanceCount());
			
			List<EolOperation> inits = new ArrayList<EolOperation>();
			
			for (EolOperation init : getOperations().getOperations(instance, initOperationName, parameters, false, context)) {
				if (EolAnnotationsUtil.getAnnotation(init.getAst(), "greedy") != null) {
					init.execute(instance, parameters, context);
					inits.add(init);
				}
			}
			
			for (EolOperation init : getOperations().getOperations(instance, initOperationName, parameters, true, context)) {
				if (!inits.contains(init)) {
					init.execute(instance, parameters, context);
				}
			}
			
		} catch (EolRuntimeException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public IEolContext createContext() {
		return new MglContext();
	}
	
	@Override
	public MglContext getContext() {
		return (MglContext) super.getContext();
	}
	
	protected void wrapModels() {
		ArrayList<ModelReference> modelReferences = new ArrayList<ModelReference>();
		
		for (IModel model : context.getModelRepository().getModels()) {
			modelReferences.add(new ModelReference(model) {
				
				@Override
				public Object createInstance(String type)
						throws EolModelElementTypeNotFoundException,
						EolNotInstantiableModelElementTypeException {
					
					Object instance = super.createInstance(type);
					created(instance);
					return instance;
				}
				
				@Override
				public Object createInstance(String type,
						Collection<Object> parameters)
						throws EolModelElementTypeNotFoundException,
						EolNotInstantiableModelElementTypeException {
					
					Object instance = super.createInstance(type, parameters);
					created(instance);
					return instance;
				}
				
			});
		}
		
		for (ModelReference modelReference : modelReferences) {
			context.getModelRepository().removeModel(modelReference.getTarget());
			context.getModelRepository().addModel(modelReference);
		}
		
	}
	
}
