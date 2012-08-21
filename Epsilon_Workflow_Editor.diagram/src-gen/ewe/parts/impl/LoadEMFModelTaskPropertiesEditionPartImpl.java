/**
 * Generated with Acceleo
 */
package ewe.parts.impl;

// Start of user code for imports
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import ewe.parts.EweViewsRepository;
import ewe.parts.LoadEMFModelTaskPropertiesEditionPart;
import ewe.providers.EweMessages;


// End of user code

/**
 * 
 * 
 */
public class LoadEMFModelTaskPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, LoadEMFModelTaskPropertiesEditionPart {

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
	public LoadEMFModelTaskPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(view);
		return view;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(Composite view) { 
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
					return createPropertiesGroup(parent);
				}
				if (key == EweViewsRepository.LoadEMFModelTask.Properties.name) {
					return createNameText(parent);
				}
				if (key == EweViewsRepository.LoadEMFModelTask.Properties.type) {
					return createTypeText(parent);
				}
				if (key == EweViewsRepository.LoadEMFModelTask.Properties.modelFile) {
					return createModelFileText(parent);
				}
				if (key == EweViewsRepository.LoadEMFModelTask.Properties.metamodelFile) {
					return createMetamodelFileText(parent);
				}
				if (key == EweViewsRepository.LoadEMFModelTask.Properties.isMetamodelFileBased) {
					return createIsMetamodelFileBasedCheckbox(parent);
				}
				if (key == EweViewsRepository.LoadEMFModelTask.Properties.readOnLoad) {
					return createReadOnLoadCheckbox(parent);
				}
				if (key == EweViewsRepository.LoadEMFModelTask.Properties.metamodelUri) {
					return createMetamodelUriText(parent);
				}
				if (key == EweViewsRepository.LoadEMFModelTask.Properties.storeOnDisposal) {
					return createStoreOnDisposalCheckbox(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(EweMessages.LoadEMFModelTaskPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		SWTUtils.createPartLabel(parent, EweMessages.LoadEMFModelTaskPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(EweViewsRepository.LoadEMFModelTask.Properties.name, EweViewsRepository.SWT_KIND));
		name = new Text(parent, SWT.BORDER);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadEMFModelTaskPropertiesEditionPartImpl.this, EweViewsRepository.LoadEMFModelTask.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
			}

		});
		name.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadEMFModelTaskPropertiesEditionPartImpl.this, EweViewsRepository.LoadEMFModelTask.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, EweViewsRepository.LoadEMFModelTask.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.LoadEMFModelTask.Properties.name, EweViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createTypeText(Composite parent) {
		SWTUtils.createPartLabel(parent, EweMessages.LoadEMFModelTaskPropertiesEditionPart_TypeLabel, propertiesEditionComponent.isRequired(EweViewsRepository.LoadEMFModelTask.Properties.type, EweViewsRepository.SWT_KIND));
		type = new Text(parent, SWT.BORDER);
		type.setEnabled(false);
		type.setToolTipText(EweMessages.LoadEMFModelTask_ReadOnly);
		GridData typeData = new GridData(GridData.FILL_HORIZONTAL);
		type.setLayoutData(typeData);
		type.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadEMFModelTaskPropertiesEditionPartImpl.this, EweViewsRepository.LoadEMFModelTask.Properties.type, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, type.getText()));
			}

		});
		type.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadEMFModelTaskPropertiesEditionPartImpl.this, EweViewsRepository.LoadEMFModelTask.Properties.type, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, type.getText()));
				}
			}

		});
		EditingUtils.setID(type, EweViewsRepository.LoadEMFModelTask.Properties.type);
		EditingUtils.setEEFtype(type, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.LoadEMFModelTask.Properties.type, EweViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createModelFileText(Composite parent) {
		SWTUtils.createPartLabel(parent, EweMessages.LoadEMFModelTaskPropertiesEditionPart_ModelFileLabel, propertiesEditionComponent.isRequired(EweViewsRepository.LoadEMFModelTask.Properties.modelFile, EweViewsRepository.SWT_KIND));
		modelFile = new Text(parent, SWT.BORDER);
		GridData modelFileData = new GridData(GridData.FILL_HORIZONTAL);
		modelFile.setLayoutData(modelFileData);
		modelFile.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadEMFModelTaskPropertiesEditionPartImpl.this, EweViewsRepository.LoadEMFModelTask.Properties.modelFile, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, modelFile.getText()));
			}

		});
		modelFile.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadEMFModelTaskPropertiesEditionPartImpl.this, EweViewsRepository.LoadEMFModelTask.Properties.modelFile, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, modelFile.getText()));
				}
			}

		});
		EditingUtils.setID(modelFile, EweViewsRepository.LoadEMFModelTask.Properties.modelFile);
		EditingUtils.setEEFtype(modelFile, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.LoadEMFModelTask.Properties.modelFile, EweViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createMetamodelFileText(Composite parent) {
		SWTUtils.createPartLabel(parent, EweMessages.LoadEMFModelTaskPropertiesEditionPart_MetamodelFileLabel, propertiesEditionComponent.isRequired(EweViewsRepository.LoadEMFModelTask.Properties.metamodelFile, EweViewsRepository.SWT_KIND));
		metamodelFile = new Text(parent, SWT.BORDER);
		GridData metamodelFileData = new GridData(GridData.FILL_HORIZONTAL);
		metamodelFile.setLayoutData(metamodelFileData);
		metamodelFile.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadEMFModelTaskPropertiesEditionPartImpl.this, EweViewsRepository.LoadEMFModelTask.Properties.metamodelFile, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, metamodelFile.getText()));
			}

		});
		metamodelFile.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadEMFModelTaskPropertiesEditionPartImpl.this, EweViewsRepository.LoadEMFModelTask.Properties.metamodelFile, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, metamodelFile.getText()));
				}
			}

		});
		EditingUtils.setID(metamodelFile, EweViewsRepository.LoadEMFModelTask.Properties.metamodelFile);
		EditingUtils.setEEFtype(metamodelFile, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.LoadEMFModelTask.Properties.metamodelFile, EweViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createIsMetamodelFileBasedCheckbox(Composite parent) {
		isMetamodelFileBased = new Button(parent, SWT.CHECK);
		isMetamodelFileBased.setText(EweMessages.LoadEMFModelTaskPropertiesEditionPart_IsMetamodelFileBasedLabel);
		isMetamodelFileBased.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadEMFModelTaskPropertiesEditionPartImpl.this, EweViewsRepository.LoadEMFModelTask.Properties.isMetamodelFileBased, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(isMetamodelFileBased.getSelection())));
			}

		});
		GridData isMetamodelFileBasedData = new GridData(GridData.FILL_HORIZONTAL);
		isMetamodelFileBasedData.horizontalSpan = 2;
		isMetamodelFileBased.setLayoutData(isMetamodelFileBasedData);
		EditingUtils.setID(isMetamodelFileBased, EweViewsRepository.LoadEMFModelTask.Properties.isMetamodelFileBased);
		EditingUtils.setEEFtype(isMetamodelFileBased, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.LoadEMFModelTask.Properties.isMetamodelFileBased, EweViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createReadOnLoadCheckbox(Composite parent) {
		readOnLoad = new Button(parent, SWT.CHECK);
		readOnLoad.setText(EweMessages.LoadEMFModelTaskPropertiesEditionPart_ReadOnLoadLabel);
		readOnLoad.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadEMFModelTaskPropertiesEditionPartImpl.this, EweViewsRepository.LoadEMFModelTask.Properties.readOnLoad, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(readOnLoad.getSelection())));
			}

		});
		GridData readOnLoadData = new GridData(GridData.FILL_HORIZONTAL);
		readOnLoadData.horizontalSpan = 2;
		readOnLoad.setLayoutData(readOnLoadData);
		EditingUtils.setID(readOnLoad, EweViewsRepository.LoadEMFModelTask.Properties.readOnLoad);
		EditingUtils.setEEFtype(readOnLoad, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.LoadEMFModelTask.Properties.readOnLoad, EweViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createMetamodelUriText(Composite parent) {
		SWTUtils.createPartLabel(parent, EweMessages.LoadEMFModelTaskPropertiesEditionPart_MetamodelUriLabel, propertiesEditionComponent.isRequired(EweViewsRepository.LoadEMFModelTask.Properties.metamodelUri, EweViewsRepository.SWT_KIND));
		metamodelUri = new Text(parent, SWT.BORDER);
		GridData metamodelUriData = new GridData(GridData.FILL_HORIZONTAL);
		metamodelUri.setLayoutData(metamodelUriData);
		metamodelUri.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadEMFModelTaskPropertiesEditionPartImpl.this, EweViewsRepository.LoadEMFModelTask.Properties.metamodelUri, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, metamodelUri.getText()));
			}

		});
		metamodelUri.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadEMFModelTaskPropertiesEditionPartImpl.this, EweViewsRepository.LoadEMFModelTask.Properties.metamodelUri, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, metamodelUri.getText()));
				}
			}

		});
		EditingUtils.setID(metamodelUri, EweViewsRepository.LoadEMFModelTask.Properties.metamodelUri);
		EditingUtils.setEEFtype(metamodelUri, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.LoadEMFModelTask.Properties.metamodelUri, EweViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createStoreOnDisposalCheckbox(Composite parent) {
		storeOnDisposal = new Button(parent, SWT.CHECK);
		storeOnDisposal.setText(EweMessages.LoadEMFModelTaskPropertiesEditionPart_StoreOnDisposalLabel);
		storeOnDisposal.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadEMFModelTaskPropertiesEditionPartImpl.this, EweViewsRepository.LoadEMFModelTask.Properties.storeOnDisposal, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(storeOnDisposal.getSelection())));
			}

		});
		GridData storeOnDisposalData = new GridData(GridData.FILL_HORIZONTAL);
		storeOnDisposalData.horizontalSpan = 2;
		storeOnDisposal.setLayoutData(storeOnDisposalData);
		EditingUtils.setID(storeOnDisposal, EweViewsRepository.LoadEMFModelTask.Properties.storeOnDisposal);
		EditingUtils.setEEFtype(storeOnDisposal, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.LoadEMFModelTask.Properties.storeOnDisposal, EweViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
