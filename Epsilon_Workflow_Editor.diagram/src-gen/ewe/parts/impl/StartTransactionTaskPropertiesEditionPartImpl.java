/**
 * Generated with Acceleo
 */
package ewe.parts.impl;

// Start of user code for imports
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
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
import org.eclipse.emf.eef.runtime.ui.widgets.EEFFeatureEditorDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import ewe.EwePackage;
import ewe.parts.EweViewsRepository;
import ewe.parts.StartTransactionTaskPropertiesEditionPart;
import ewe.providers.EweMessages;


// End of user code

/**
 * 
 * 
 */
public class StartTransactionTaskPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, StartTransactionTaskPropertiesEditionPart {

	protected Text name;
	protected Text models;
	protected Button editModels;
	private EList modelsList;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public StartTransactionTaskPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence startTransactionTaskStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = startTransactionTaskStep.addStep(EweViewsRepository.StartTransactionTask.Properties.class);
		propertiesStep.addStep(EweViewsRepository.StartTransactionTask.Properties.name);
		propertiesStep.addStep(EweViewsRepository.StartTransactionTask.Properties.models);
		
		
		composer = new PartComposer(startTransactionTaskStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EweViewsRepository.StartTransactionTask.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EweViewsRepository.StartTransactionTask.Properties.name) {
					return createNameText(parent);
				}
				if (key == EweViewsRepository.StartTransactionTask.Properties.models) {
					return createModelsMultiValuedEditor(parent);
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
		propertiesGroup.setText(EweMessages.StartTransactionTaskPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		SWTUtils.createPartLabel(parent, EweMessages.StartTransactionTaskPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(EweViewsRepository.StartTransactionTask.Properties.name, EweViewsRepository.SWT_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StartTransactionTaskPropertiesEditionPartImpl.this, EweViewsRepository.StartTransactionTask.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StartTransactionTaskPropertiesEditionPartImpl.this, EweViewsRepository.StartTransactionTask.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, EweViewsRepository.StartTransactionTask.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.StartTransactionTask.Properties.name, EweViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	protected Composite createModelsMultiValuedEditor(Composite parent) {
		models = new Text(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData modelsData = new GridData(GridData.FILL_HORIZONTAL);
		modelsData.horizontalSpan = 2;
		models.setLayoutData(modelsData);
		EditingUtils.setID(models, EweViewsRepository.StartTransactionTask.Properties.models);
		EditingUtils.setEEFtype(models, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editModels = new Button(parent, SWT.NONE);
		editModels.setText(EweMessages.StartTransactionTaskPropertiesEditionPart_ModelsLabel);
		GridData editModelsData = new GridData();
		editModels.setLayoutData(editModelsData);
		editModels.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(StartTransactionTaskPropertiesEditionPartImpl.this, EweViewsRepository.StartTransactionTask.Properties.models, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(modelsList)));
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
