/**
 * Generated with Acceleo
 */
package ewe.parts.forms;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import ewe.parts.EweViewsRepository;
import ewe.parts.ProjectPropertiesEditionPart;
import ewe.providers.EweMessages;


// End of user code

/**
 * 
 * 
 */
public class ProjectPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, ProjectPropertiesEditionPart {

	protected Text name;
	protected EObjectFlatComboViewer defaultTarget;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ProjectPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 * 
	 */
	public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
		ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
		Form form = scrolledForm.getForm();
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view);
		return scrolledForm;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		CompositionSequence projectStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = projectStep.addStep(EweViewsRepository.Project.Properties.class);
		propertiesStep.addStep(EweViewsRepository.Project.Properties.name);
		propertiesStep.addStep(EweViewsRepository.Project.Properties.defaultTarget);
		
		
		composer = new PartComposer(projectStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EweViewsRepository.Project.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EweViewsRepository.Project.Properties.name) {
					return 		createNameText(widgetFactory, parent);
				}
				if (key == EweViewsRepository.Project.Properties.defaultTarget) {
					return createDefaultTargetFlatComboViewer(parent, widgetFactory);
				}
				return parent;
			}
		};
		composer.compose(view);
	}
	/**
	 * 
	 */
	protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
		Section propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(EweMessages.ProjectPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		propertiesSection.setClient(propertiesGroup);
		return propertiesGroup;
	}

	
	protected Composite createNameText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, EweMessages.ProjectPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(EweViewsRepository.Project.Properties.name, EweViewsRepository.FORM_KIND));
		name = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		name.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProjectPropertiesEditionPartForm.this, EweViewsRepository.Project.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
			}
		});
		name.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProjectPropertiesEditionPartForm.this, EweViewsRepository.Project.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, EweViewsRepository.Project.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.Project.Properties.name, EweViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createDefaultTargetFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		FormUtils.createPartLabel(widgetFactory, parent, EweMessages.ProjectPropertiesEditionPart_DefaultTargetLabel, propertiesEditionComponent.isRequired(EweViewsRepository.Project.Properties.defaultTarget, EweViewsRepository.FORM_KIND));
		defaultTarget = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EweViewsRepository.Project.Properties.defaultTarget, EweViewsRepository.FORM_KIND));
		widgetFactory.adapt(defaultTarget);
		defaultTarget.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData defaultTargetData = new GridData(GridData.FILL_HORIZONTAL);
		defaultTarget.setLayoutData(defaultTargetData);
		defaultTarget.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProjectPropertiesEditionPartForm.this, EweViewsRepository.Project.Properties.defaultTarget, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getDefaultTarget()));
			}

		});
		defaultTarget.setID(EweViewsRepository.Project.Properties.defaultTarget);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.Project.Properties.defaultTarget, EweViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.ProjectPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.ProjectPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.ProjectPropertiesEditionPart#getDefaultTarget()
	 * 
	 */
	public EObject getDefaultTarget() {
		if (defaultTarget.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) defaultTarget.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.ProjectPropertiesEditionPart#initDefaultTarget(EObjectFlatComboSettings)
	 */
	public void initDefaultTarget(EObjectFlatComboSettings settings) {
		defaultTarget.setInput(settings);
		if (current != null) {
			defaultTarget.setSelection(new StructuredSelection(settings.getValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.ProjectPropertiesEditionPart#setDefaultTarget(EObject newValue)
	 * 
	 */
	public void setDefaultTarget(EObject newValue) {
		if (newValue != null) {
			defaultTarget.setSelection(new StructuredSelection(newValue));
		} else {
			defaultTarget.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.ProjectPropertiesEditionPart#setDefaultTargetButtonMode(ButtonsModeEnum newValue)
	 */
	public void setDefaultTargetButtonMode(ButtonsModeEnum newValue) {
		defaultTarget.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.ProjectPropertiesEditionPart#addFilterDefaultTarget(ViewerFilter filter)
	 * 
	 */
	public void addFilterToDefaultTarget(ViewerFilter filter) {
		defaultTarget.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.ProjectPropertiesEditionPart#addBusinessFilterDefaultTarget(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToDefaultTarget(ViewerFilter filter) {
		defaultTarget.addBusinessRuleFilter(filter);
	}




	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EweMessages.Project_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
