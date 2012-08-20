/**
 * Generated with Acceleo
 */
package ewe.parts.forms;

// Start of user code for imports
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.emf.eef.runtime.ui.widgets.EEFFeatureEditorDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import ewe.EwePackage;
import ewe.parts.EweViewsRepository;
import ewe.parts.StartTransactionTaskPropertiesEditionPart;
import ewe.providers.EweMessages;


// End of user code

/**
 * 
 * 
 */
public class StartTransactionTaskPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, StartTransactionTaskPropertiesEditionPart {

	protected Text name;
	protected Text models;
		protected Button editModels;
		private EList modelsList;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public StartTransactionTaskPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence startTransactionTaskStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = startTransactionTaskStep.addStep(EweViewsRepository.StartTransactionTask.Properties.class);
		propertiesStep.addStep(EweViewsRepository.StartTransactionTask.Properties.name);
		propertiesStep.addStep(EweViewsRepository.StartTransactionTask.Properties.models);
		
		
		composer = new PartComposer(startTransactionTaskStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EweViewsRepository.StartTransactionTask.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EweViewsRepository.StartTransactionTask.Properties.name) {
					return 		createNameText(widgetFactory, parent);
				}
				if (key == EweViewsRepository.StartTransactionTask.Properties.models) {
					return createModelsMultiValuedEditor(widgetFactory, parent);
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
		propertiesSection.setText(EweMessages.StartTransactionTaskPropertiesEditionPart_PropertiesGroupLabel);
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
		FormUtils.createPartLabel(widgetFactory, parent, EweMessages.StartTransactionTaskPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(EweViewsRepository.StartTransactionTask.Properties.name, EweViewsRepository.FORM_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StartTransactionTaskPropertiesEditionPartForm.this, EweViewsRepository.StartTransactionTask.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StartTransactionTaskPropertiesEditionPartForm.this, EweViewsRepository.StartTransactionTask.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, EweViewsRepository.StartTransactionTask.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.StartTransactionTask.Properties.name, EweViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createModelsMultiValuedEditor(FormToolkit widgetFactory, Composite parent) {
		models = widgetFactory.createText(parent, "", SWT.READ_ONLY); //$NON-NLS-1$
		GridData modelsData = new GridData(GridData.FILL_HORIZONTAL);
		modelsData.horizontalSpan = 2;
		models.setLayoutData(modelsData);
		EditingUtils.setID(models, EweViewsRepository.StartTransactionTask.Properties.models);
		EditingUtils.setEEFtype(models, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editModels = widgetFactory.createButton(parent, EweMessages.StartTransactionTaskPropertiesEditionPart_ModelsLabel, SWT.NONE);
		GridData editModelsData = new GridData();
		editModels.setLayoutData(editModelsData);
		editModels.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 
			 */
			public void widgetSelected(SelectionEvent e) {
				EEFFeatureEditorDialog dialog = new EEFFeatureEditorDialog(
						models.getShell(), "StartTransactionTask", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						modelsList, EwePackage.eINSTANCE.getStartTransactionTask_Models().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					modelsList = dialog.getResult();
					if (modelsList == null) {
						modelsList = new BasicEList();
					}
					models.setText(modelsList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StartTransactionTaskPropertiesEditionPartForm.this, EweViewsRepository.StartTransactionTask.Properties.models, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(modelsList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editModels, EweViewsRepository.StartTransactionTask.Properties.models);
		EditingUtils.setEEFtype(editModels, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
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
	 * @see ewe.parts.StartTransactionTaskPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.StartTransactionTaskPropertiesEditionPart#setName(String newValue)
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
	 * @see ewe.parts.StartTransactionTaskPropertiesEditionPart#getModels()
	 * 
	 */
	public EList getModels() {
		return modelsList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.StartTransactionTaskPropertiesEditionPart#setModels(EList newValue)
	 * 
	 */
	public void setModels(EList newValue) {
		modelsList = newValue;
		if (newValue != null) {
			models.setText(modelsList.toString());
		} else {
			models.setText(""); //$NON-NLS-1$
		}
	}

	public void addToModels(Object newValue) {
		modelsList.add(newValue);
		if (newValue != null) {
			models.setText(modelsList.toString());
		} else {
			models.setText(""); //$NON-NLS-1$
		}
	}

	public void removeToModels(Object newValue) {
		modelsList.remove(newValue);
		if (newValue != null) {
			models.setText(modelsList.toString());
		} else {
			models.setText(""); //$NON-NLS-1$
		}
	}




	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EweMessages.StartTransactionTask_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
