/**
 * Generated with Acceleo
 */
package ewe.parts.forms;

// Start of user code for imports
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
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
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

import ewe.parts.EweViewsRepository;
import ewe.parts.LoadEMFModelTaskPropertiesEditionPart;
import ewe.providers.EweMessages;


// End of user code

/**
 * 
 * 
 */
public class LoadEMFModelTaskPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, LoadEMFModelTaskPropertiesEditionPart {

	protected Text name;
	protected Text type;
	protected Text modelFile;
	protected Text metamodelFile;
	protected Button isMetamodelFileBased;
	protected Button readOnLoad;
	protected Text metamodelUri;
	protected Button storeOnDisposal;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public LoadEMFModelTaskPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence loadEMFModelTaskStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = loadEMFModelTaskStep.addStep(EweViewsRepository.LoadEMFModelTask.Properties.class);
		propertiesStep.addStep(EweViewsRepository.LoadEMFModelTask.Properties.name);
		propertiesStep.addStep(EweViewsRepository.LoadEMFModelTask.Properties.type);
		propertiesStep.addStep(EweViewsRepository.LoadEMFModelTask.Properties.modelFile);
		propertiesStep.addStep(EweViewsRepository.LoadEMFModelTask.Properties.metamodelFile);
		propertiesStep.addStep(EweViewsRepository.LoadEMFModelTask.Properties.isMetamodelFileBased);
		propertiesStep.addStep(EweViewsRepository.LoadEMFModelTask.Properties.readOnLoad);
		propertiesStep.addStep(EweViewsRepository.LoadEMFModelTask.Properties.metamodelUri);
		propertiesStep.addStep(EweViewsRepository.LoadEMFModelTask.Properties.storeOnDisposal);
		
		
		composer = new PartComposer(loadEMFModelTaskStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EweViewsRepository.LoadEMFModelTask.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EweViewsRepository.LoadEMFModelTask.Properties.name) {
					return 		createNameText(widgetFactory, parent);
				}
				if (key == EweViewsRepository.LoadEMFModelTask.Properties.type) {
					return 		createTypeText(widgetFactory, parent);
				}
				if (key == EweViewsRepository.LoadEMFModelTask.Properties.modelFile) {
					return 		createModelFileText(widgetFactory, parent);
				}
				if (key == EweViewsRepository.LoadEMFModelTask.Properties.metamodelFile) {
					return 		createMetamodelFileText(widgetFactory, parent);
				}
				if (key == EweViewsRepository.LoadEMFModelTask.Properties.isMetamodelFileBased) {
					return createIsMetamodelFileBasedCheckbox(widgetFactory, parent);
				}
				if (key == EweViewsRepository.LoadEMFModelTask.Properties.readOnLoad) {
					return createReadOnLoadCheckbox(widgetFactory, parent);
				}
				if (key == EweViewsRepository.LoadEMFModelTask.Properties.metamodelUri) {
					return 		createMetamodelUriText(widgetFactory, parent);
				}
				if (key == EweViewsRepository.LoadEMFModelTask.Properties.storeOnDisposal) {
					return createStoreOnDisposalCheckbox(widgetFactory, parent);
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
		propertiesSection.setText(EweMessages.LoadEMFModelTaskPropertiesEditionPart_PropertiesGroupLabel);
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
		FormUtils.createPartLabel(widgetFactory, parent, EweMessages.LoadEMFModelTaskPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(EweViewsRepository.LoadEMFModelTask.Properties.name, EweViewsRepository.FORM_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadEMFModelTaskPropertiesEditionPartForm.this, EweViewsRepository.LoadEMFModelTask.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadEMFModelTaskPropertiesEditionPartForm.this, EweViewsRepository.LoadEMFModelTask.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, EweViewsRepository.LoadEMFModelTask.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.LoadEMFModelTask.Properties.name, EweViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createTypeText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, EweMessages.LoadEMFModelTaskPropertiesEditionPart_TypeLabel, propertiesEditionComponent.isRequired(EweViewsRepository.LoadEMFModelTask.Properties.type, EweViewsRepository.FORM_KIND));
		type = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		type.setEnabled(false);
		type.setToolTipText(EweMessages.LoadEMFModelTask_ReadOnly);
		type.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData typeData = new GridData(GridData.FILL_HORIZONTAL);
		type.setLayoutData(typeData);
		type.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadEMFModelTaskPropertiesEditionPartForm.this, EweViewsRepository.LoadEMFModelTask.Properties.type, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, type.getText()));
			}
		});
		type.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadEMFModelTaskPropertiesEditionPartForm.this, EweViewsRepository.LoadEMFModelTask.Properties.type, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, type.getText()));
				}
			}
		});
		EditingUtils.setID(type, EweViewsRepository.LoadEMFModelTask.Properties.type);
		EditingUtils.setEEFtype(type, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.LoadEMFModelTask.Properties.type, EweViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createModelFileText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, EweMessages.LoadEMFModelTaskPropertiesEditionPart_ModelFileLabel, propertiesEditionComponent.isRequired(EweViewsRepository.LoadEMFModelTask.Properties.modelFile, EweViewsRepository.FORM_KIND));
		modelFile = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		modelFile.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData modelFileData = new GridData(GridData.FILL_HORIZONTAL);
		modelFile.setLayoutData(modelFileData);
		modelFile.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadEMFModelTaskPropertiesEditionPartForm.this, EweViewsRepository.LoadEMFModelTask.Properties.modelFile, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, modelFile.getText()));
			}
		});
		modelFile.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadEMFModelTaskPropertiesEditionPartForm.this, EweViewsRepository.LoadEMFModelTask.Properties.modelFile, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, modelFile.getText()));
				}
			}
		});
		EditingUtils.setID(modelFile, EweViewsRepository.LoadEMFModelTask.Properties.modelFile);
		EditingUtils.setEEFtype(modelFile, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.LoadEMFModelTask.Properties.modelFile, EweViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createMetamodelFileText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, EweMessages.LoadEMFModelTaskPropertiesEditionPart_MetamodelFileLabel, propertiesEditionComponent.isRequired(EweViewsRepository.LoadEMFModelTask.Properties.metamodelFile, EweViewsRepository.FORM_KIND));
		metamodelFile = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		metamodelFile.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData metamodelFileData = new GridData(GridData.FILL_HORIZONTAL);
		metamodelFile.setLayoutData(metamodelFileData);
		metamodelFile.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadEMFModelTaskPropertiesEditionPartForm.this, EweViewsRepository.LoadEMFModelTask.Properties.metamodelFile, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, metamodelFile.getText()));
			}
		});
		metamodelFile.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadEMFModelTaskPropertiesEditionPartForm.this, EweViewsRepository.LoadEMFModelTask.Properties.metamodelFile, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, metamodelFile.getText()));
				}
			}
		});
		EditingUtils.setID(metamodelFile, EweViewsRepository.LoadEMFModelTask.Properties.metamodelFile);
		EditingUtils.setEEFtype(metamodelFile, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.LoadEMFModelTask.Properties.metamodelFile, EweViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createIsMetamodelFileBasedCheckbox(FormToolkit widgetFactory, Composite parent) {
		isMetamodelFileBased = widgetFactory.createButton(parent, EweMessages.LoadEMFModelTaskPropertiesEditionPart_IsMetamodelFileBasedLabel, SWT.CHECK);
		isMetamodelFileBased.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadEMFModelTaskPropertiesEditionPartForm.this, EweViewsRepository.LoadEMFModelTask.Properties.isMetamodelFileBased, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(isMetamodelFileBased.getSelection())));
			}

		});
		GridData isMetamodelFileBasedData = new GridData(GridData.FILL_HORIZONTAL);
		isMetamodelFileBasedData.horizontalSpan = 2;
		isMetamodelFileBased.setLayoutData(isMetamodelFileBasedData);
		EditingUtils.setID(isMetamodelFileBased, EweViewsRepository.LoadEMFModelTask.Properties.isMetamodelFileBased);
		EditingUtils.setEEFtype(isMetamodelFileBased, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.LoadEMFModelTask.Properties.isMetamodelFileBased, EweViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createReadOnLoadCheckbox(FormToolkit widgetFactory, Composite parent) {
		readOnLoad = widgetFactory.createButton(parent, EweMessages.LoadEMFModelTaskPropertiesEditionPart_ReadOnLoadLabel, SWT.CHECK);
		readOnLoad.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadEMFModelTaskPropertiesEditionPartForm.this, EweViewsRepository.LoadEMFModelTask.Properties.readOnLoad, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(readOnLoad.getSelection())));
			}

		});
		GridData readOnLoadData = new GridData(GridData.FILL_HORIZONTAL);
		readOnLoadData.horizontalSpan = 2;
		readOnLoad.setLayoutData(readOnLoadData);
		EditingUtils.setID(readOnLoad, EweViewsRepository.LoadEMFModelTask.Properties.readOnLoad);
		EditingUtils.setEEFtype(readOnLoad, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.LoadEMFModelTask.Properties.readOnLoad, EweViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createMetamodelUriText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, EweMessages.LoadEMFModelTaskPropertiesEditionPart_MetamodelUriLabel, propertiesEditionComponent.isRequired(EweViewsRepository.LoadEMFModelTask.Properties.metamodelUri, EweViewsRepository.FORM_KIND));
		metamodelUri = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		metamodelUri.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData metamodelUriData = new GridData(GridData.FILL_HORIZONTAL);
		metamodelUri.setLayoutData(metamodelUriData);
		metamodelUri.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadEMFModelTaskPropertiesEditionPartForm.this, EweViewsRepository.LoadEMFModelTask.Properties.metamodelUri, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, metamodelUri.getText()));
			}
		});
		metamodelUri.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadEMFModelTaskPropertiesEditionPartForm.this, EweViewsRepository.LoadEMFModelTask.Properties.metamodelUri, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, metamodelUri.getText()));
				}
			}
		});
		EditingUtils.setID(metamodelUri, EweViewsRepository.LoadEMFModelTask.Properties.metamodelUri);
		EditingUtils.setEEFtype(metamodelUri, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.LoadEMFModelTask.Properties.metamodelUri, EweViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createStoreOnDisposalCheckbox(FormToolkit widgetFactory, Composite parent) {
		storeOnDisposal = widgetFactory.createButton(parent, EweMessages.LoadEMFModelTaskPropertiesEditionPart_StoreOnDisposalLabel, SWT.CHECK);
		storeOnDisposal.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadEMFModelTaskPropertiesEditionPartForm.this, EweViewsRepository.LoadEMFModelTask.Properties.storeOnDisposal, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(storeOnDisposal.getSelection())));
			}

		});
		GridData storeOnDisposalData = new GridData(GridData.FILL_HORIZONTAL);
		storeOnDisposalData.horizontalSpan = 2;
		storeOnDisposal.setLayoutData(storeOnDisposalData);
		EditingUtils.setID(storeOnDisposal, EweViewsRepository.LoadEMFModelTask.Properties.storeOnDisposal);
		EditingUtils.setEEFtype(storeOnDisposal, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.LoadEMFModelTask.Properties.storeOnDisposal, EweViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
	 * @see ewe.parts.LoadEMFModelTaskPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.LoadEMFModelTaskPropertiesEditionPart#setName(String newValue)
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
	 * @see ewe.parts.LoadEMFModelTaskPropertiesEditionPart#getType()
	 * 
	 */
	public String getType() {
		return type.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.LoadEMFModelTaskPropertiesEditionPart#setType(String newValue)
	 * 
	 */
	public void setType(String newValue) {
		if (newValue != null) {
			type.setText(newValue);
		} else {
			type.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.LoadEMFModelTaskPropertiesEditionPart#getModelFile()
	 * 
	 */
	public String getModelFile() {
		return modelFile.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.LoadEMFModelTaskPropertiesEditionPart#setModelFile(String newValue)
	 * 
	 */
	public void setModelFile(String newValue) {
		if (newValue != null) {
			modelFile.setText(newValue);
		} else {
			modelFile.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.LoadEMFModelTaskPropertiesEditionPart#getMetamodelFile()
	 * 
	 */
	public String getMetamodelFile() {
		return metamodelFile.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.LoadEMFModelTaskPropertiesEditionPart#setMetamodelFile(String newValue)
	 * 
	 */
	public void setMetamodelFile(String newValue) {
		if (newValue != null) {
			metamodelFile.setText(newValue);
		} else {
			metamodelFile.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.LoadEMFModelTaskPropertiesEditionPart#getIsMetamodelFileBased()
	 * 
	 */
	public Boolean getIsMetamodelFileBased() {
		return Boolean.valueOf(isMetamodelFileBased.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.LoadEMFModelTaskPropertiesEditionPart#setIsMetamodelFileBased(Boolean newValue)
	 * 
	 */
	public void setIsMetamodelFileBased(Boolean newValue) {
		if (newValue != null) {
			isMetamodelFileBased.setSelection(newValue.booleanValue());
		} else {
			isMetamodelFileBased.setSelection(false);
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.LoadEMFModelTaskPropertiesEditionPart#getReadOnLoad()
	 * 
	 */
	public Boolean getReadOnLoad() {
		return Boolean.valueOf(readOnLoad.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.LoadEMFModelTaskPropertiesEditionPart#setReadOnLoad(Boolean newValue)
	 * 
	 */
	public void setReadOnLoad(Boolean newValue) {
		if (newValue != null) {
			readOnLoad.setSelection(newValue.booleanValue());
		} else {
			readOnLoad.setSelection(false);
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.LoadEMFModelTaskPropertiesEditionPart#getMetamodelUri()
	 * 
	 */
	public String getMetamodelUri() {
		return metamodelUri.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.LoadEMFModelTaskPropertiesEditionPart#setMetamodelUri(String newValue)
	 * 
	 */
	public void setMetamodelUri(String newValue) {
		if (newValue != null) {
			metamodelUri.setText(newValue);
		} else {
			metamodelUri.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.LoadEMFModelTaskPropertiesEditionPart#getStoreOnDisposal()
	 * 
	 */
	public Boolean getStoreOnDisposal() {
		return Boolean.valueOf(storeOnDisposal.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.LoadEMFModelTaskPropertiesEditionPart#setStoreOnDisposal(Boolean newValue)
	 * 
	 */
	public void setStoreOnDisposal(Boolean newValue) {
		if (newValue != null) {
			storeOnDisposal.setSelection(newValue.booleanValue());
		} else {
			storeOnDisposal.setSelection(false);
		}
	}




	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EweMessages.LoadEMFModelTask_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
