/**
 * Generated with Acceleo
 */
package ewe.providers;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;

import ewe.parts.EweViewsRepository;
import ewe.parts.forms.AttributePropertiesEditionPartForm;
import ewe.parts.forms.CommitTransactionTaskPropertiesEditionPartForm;
import ewe.parts.forms.DisposeModelTaskPropertiesEditionPartForm;
import ewe.parts.forms.DisposeModelsTaskPropertiesEditionPartForm;
import ewe.parts.forms.EUnitTaskPropertiesEditionPartForm;
import ewe.parts.forms.EclTaskPropertiesEditionPartForm;
import ewe.parts.forms.EglTaskPropertiesEditionPartForm;
import ewe.parts.forms.EmlTaskPropertiesEditionPartForm;
import ewe.parts.forms.EolTaskPropertiesEditionPartForm;
import ewe.parts.forms.EtlTaskPropertiesEditionPartForm;
import ewe.parts.forms.EvlTaskPropertiesEditionPartForm;
import ewe.parts.forms.ExportsNestedElementPropertiesEditionPartForm;
import ewe.parts.forms.FlockTaskPropertiesEditionPartForm;
import ewe.parts.forms.LoadEMFModelTaskPropertiesEditionPartForm;
import ewe.parts.forms.LoadModelTaskPropertiesEditionPartForm;
import ewe.parts.forms.ModelNestedElementPropertiesEditionPartForm;
import ewe.parts.forms.NestedElementPropertiesEditionPartForm;
import ewe.parts.forms.ParameterNestedElementPropertiesEditionPartForm;
import ewe.parts.forms.ProjectPropertiesEditionPartForm;
import ewe.parts.forms.RollbackTransactionTaskPropertiesEditionPartForm;
import ewe.parts.forms.StartTransactionTaskPropertiesEditionPartForm;
import ewe.parts.forms.StoreModelTaskPropertiesEditionPartForm;
import ewe.parts.forms.TargetPropertiesEditionPartForm;
import ewe.parts.forms.TaskPropertiesEditionPartForm;
import ewe.parts.forms.UsesNestedElementPropertiesEditionPartForm;
import ewe.parts.forms.VariableNestedElementPropertiesEditionPartForm;
import ewe.parts.impl.AttributePropertiesEditionPartImpl;
import ewe.parts.impl.CommitTransactionTaskPropertiesEditionPartImpl;
import ewe.parts.impl.DisposeModelTaskPropertiesEditionPartImpl;
import ewe.parts.impl.DisposeModelsTaskPropertiesEditionPartImpl;
import ewe.parts.impl.EUnitTaskPropertiesEditionPartImpl;
import ewe.parts.impl.EclTaskPropertiesEditionPartImpl;
import ewe.parts.impl.EglTaskPropertiesEditionPartImpl;
import ewe.parts.impl.EmlTaskPropertiesEditionPartImpl;
import ewe.parts.impl.EolTaskPropertiesEditionPartImpl;
import ewe.parts.impl.EtlTaskPropertiesEditionPartImpl;
import ewe.parts.impl.EvlTaskPropertiesEditionPartImpl;
import ewe.parts.impl.ExportsNestedElementPropertiesEditionPartImpl;
import ewe.parts.impl.FlockTaskPropertiesEditionPartImpl;
import ewe.parts.impl.LoadEMFModelTaskPropertiesEditionPartImpl;
import ewe.parts.impl.LoadModelTaskPropertiesEditionPartImpl;
import ewe.parts.impl.ModelNestedElementPropertiesEditionPartImpl;
import ewe.parts.impl.NestedElementPropertiesEditionPartImpl;
import ewe.parts.impl.ParameterNestedElementPropertiesEditionPartImpl;
import ewe.parts.impl.ProjectPropertiesEditionPartImpl;
import ewe.parts.impl.RollbackTransactionTaskPropertiesEditionPartImpl;
import ewe.parts.impl.StartTransactionTaskPropertiesEditionPartImpl;
import ewe.parts.impl.StoreModelTaskPropertiesEditionPartImpl;
import ewe.parts.impl.TargetPropertiesEditionPartImpl;
import ewe.parts.impl.TaskPropertiesEditionPartImpl;
import ewe.parts.impl.UsesNestedElementPropertiesEditionPartImpl;
import ewe.parts.impl.VariableNestedElementPropertiesEditionPartImpl;




/**
 * 
 * 
 */
public class EwePropertiesEditionPartProvider implements IPropertiesEditionPartProvider {

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#provides(java.lang.Object)
	 * 
	 */
	public boolean provides(Object key) {
		return key == EweViewsRepository.class;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#getPropertiesEditionPart(java.lang.Object, int, org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(Object key, int kind, IPropertiesEditionComponent component) {
		if (key == EweViewsRepository.Project.class) {
			if (kind == EweViewsRepository.SWT_KIND)
				return new ProjectPropertiesEditionPartImpl(component);
			if (kind == EweViewsRepository.FORM_KIND)
				return new ProjectPropertiesEditionPartForm(component);
		}
		if (key == EweViewsRepository.Task.class) {
			if (kind == EweViewsRepository.SWT_KIND)
				return new TaskPropertiesEditionPartImpl(component);
			if (kind == EweViewsRepository.FORM_KIND)
				return new TaskPropertiesEditionPartForm(component);
		}
		if (key == EweViewsRepository.LoadModelTask.class) {
			if (kind == EweViewsRepository.SWT_KIND)
				return new LoadModelTaskPropertiesEditionPartImpl(component);
			if (kind == EweViewsRepository.FORM_KIND)
				return new LoadModelTaskPropertiesEditionPartForm(component);
		}
		if (key == EweViewsRepository.StoreModelTask.class) {
			if (kind == EweViewsRepository.SWT_KIND)
				return new StoreModelTaskPropertiesEditionPartImpl(component);
			if (kind == EweViewsRepository.FORM_KIND)
				return new StoreModelTaskPropertiesEditionPartForm(component);
		}
		if (key == EweViewsRepository.ParameterNestedElement.class) {
			if (kind == EweViewsRepository.SWT_KIND)
				return new ParameterNestedElementPropertiesEditionPartImpl(component);
			if (kind == EweViewsRepository.FORM_KIND)
				return new ParameterNestedElementPropertiesEditionPartForm(component);
		}
		if (key == EweViewsRepository.VariableNestedElement.class) {
			if (kind == EweViewsRepository.SWT_KIND)
				return new VariableNestedElementPropertiesEditionPartImpl(component);
			if (kind == EweViewsRepository.FORM_KIND)
				return new VariableNestedElementPropertiesEditionPartForm(component);
		}
		if (key == EweViewsRepository.ExportsNestedElement.class) {
			if (kind == EweViewsRepository.SWT_KIND)
				return new ExportsNestedElementPropertiesEditionPartImpl(component);
			if (kind == EweViewsRepository.FORM_KIND)
				return new ExportsNestedElementPropertiesEditionPartForm(component);
		}
		if (key == EweViewsRepository.UsesNestedElement.class) {
			if (kind == EweViewsRepository.SWT_KIND)
				return new UsesNestedElementPropertiesEditionPartImpl(component);
			if (kind == EweViewsRepository.FORM_KIND)
				return new UsesNestedElementPropertiesEditionPartForm(component);
		}
		if (key == EweViewsRepository.ModelNestedElement.class) {
			if (kind == EweViewsRepository.SWT_KIND)
				return new ModelNestedElementPropertiesEditionPartImpl(component);
			if (kind == EweViewsRepository.FORM_KIND)
				return new ModelNestedElementPropertiesEditionPartForm(component);
		}
		if (key == EweViewsRepository.RollbackTransactionTask.class) {
			if (kind == EweViewsRepository.SWT_KIND)
				return new RollbackTransactionTaskPropertiesEditionPartImpl(component);
			if (kind == EweViewsRepository.FORM_KIND)
				return new RollbackTransactionTaskPropertiesEditionPartForm(component);
		}
		if (key == EweViewsRepository.DisposeModelTask.class) {
			if (kind == EweViewsRepository.SWT_KIND)
				return new DisposeModelTaskPropertiesEditionPartImpl(component);
			if (kind == EweViewsRepository.FORM_KIND)
				return new DisposeModelTaskPropertiesEditionPartForm(component);
		}
		if (key == EweViewsRepository.StartTransactionTask.class) {
			if (kind == EweViewsRepository.SWT_KIND)
				return new StartTransactionTaskPropertiesEditionPartImpl(component);
			if (kind == EweViewsRepository.FORM_KIND)
				return new StartTransactionTaskPropertiesEditionPartForm(component);
		}
		if (key == EweViewsRepository.EolTask.class) {
			if (kind == EweViewsRepository.SWT_KIND)
				return new EolTaskPropertiesEditionPartImpl(component);
			if (kind == EweViewsRepository.FORM_KIND)
				return new EolTaskPropertiesEditionPartForm(component);
		}
		if (key == EweViewsRepository.EmlTask.class) {
			if (kind == EweViewsRepository.SWT_KIND)
				return new EmlTaskPropertiesEditionPartImpl(component);
			if (kind == EweViewsRepository.FORM_KIND)
				return new EmlTaskPropertiesEditionPartForm(component);
		}
		if (key == EweViewsRepository.EglTask.class) {
			if (kind == EweViewsRepository.SWT_KIND)
				return new EglTaskPropertiesEditionPartImpl(component);
			if (kind == EweViewsRepository.FORM_KIND)
				return new EglTaskPropertiesEditionPartForm(component);
		}
		if (key == EweViewsRepository.EtlTask.class) {
			if (kind == EweViewsRepository.SWT_KIND)
				return new EtlTaskPropertiesEditionPartImpl(component);
			if (kind == EweViewsRepository.FORM_KIND)
				return new EtlTaskPropertiesEditionPartForm(component);
		}
		if (key == EweViewsRepository.EvlTask.class) {
			if (kind == EweViewsRepository.SWT_KIND)
				return new EvlTaskPropertiesEditionPartImpl(component);
			if (kind == EweViewsRepository.FORM_KIND)
				return new EvlTaskPropertiesEditionPartForm(component);
		}
		if (key == EweViewsRepository.CommitTransactionTask.class) {
			if (kind == EweViewsRepository.SWT_KIND)
				return new CommitTransactionTaskPropertiesEditionPartImpl(component);
			if (kind == EweViewsRepository.FORM_KIND)
				return new CommitTransactionTaskPropertiesEditionPartForm(component);
		}
		if (key == EweViewsRepository.Target.class) {
			if (kind == EweViewsRepository.SWT_KIND)
				return new TargetPropertiesEditionPartImpl(component);
			if (kind == EweViewsRepository.FORM_KIND)
				return new TargetPropertiesEditionPartForm(component);
		}
		if (key == EweViewsRepository.LoadEMFModelTask.class) {
			if (kind == EweViewsRepository.SWT_KIND)
				return new LoadEMFModelTaskPropertiesEditionPartImpl(component);
			if (kind == EweViewsRepository.FORM_KIND)
				return new LoadEMFModelTaskPropertiesEditionPartForm(component);
		}
		if (key == EweViewsRepository.Attribute.class) {
			if (kind == EweViewsRepository.SWT_KIND)
				return new AttributePropertiesEditionPartImpl(component);
			if (kind == EweViewsRepository.FORM_KIND)
				return new AttributePropertiesEditionPartForm(component);
		}
		if (key == EweViewsRepository.NestedElement.class) {
			if (kind == EweViewsRepository.SWT_KIND)
				return new NestedElementPropertiesEditionPartImpl(component);
			if (kind == EweViewsRepository.FORM_KIND)
				return new NestedElementPropertiesEditionPartForm(component);
		}
		if (key == EweViewsRepository.FlockTask.class) {
			if (kind == EweViewsRepository.SWT_KIND)
				return new FlockTaskPropertiesEditionPartImpl(component);
			if (kind == EweViewsRepository.FORM_KIND)
				return new FlockTaskPropertiesEditionPartForm(component);
		}
		if (key == EweViewsRepository.EUnitTask.class) {
			if (kind == EweViewsRepository.SWT_KIND)
				return new EUnitTaskPropertiesEditionPartImpl(component);
			if (kind == EweViewsRepository.FORM_KIND)
				return new EUnitTaskPropertiesEditionPartForm(component);
		}
		if (key == EweViewsRepository.EclTask.class) {
			if (kind == EweViewsRepository.SWT_KIND)
				return new EclTaskPropertiesEditionPartImpl(component);
			if (kind == EweViewsRepository.FORM_KIND)
				return new EclTaskPropertiesEditionPartForm(component);
		}
		if (key == EweViewsRepository.DisposeModelsTask.class) {
			if (kind == EweViewsRepository.SWT_KIND)
				return new DisposeModelsTaskPropertiesEditionPartImpl(component);
			if (kind == EweViewsRepository.FORM_KIND)
				return new DisposeModelsTaskPropertiesEditionPartForm(component);
		}
		return null;
	}

}
