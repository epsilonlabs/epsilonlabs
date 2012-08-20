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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import ewe.parts.EweViewsRepository;
import ewe.parts.LoadXMLModelTaskPropertiesEditionPart;
import ewe.providers.EweMessages;


// End of user code

/**
 * 
 * 
 */
public class LoadXMLModelTaskPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, LoadXMLModelTaskPropertiesEditionPart {

	protected Text name;
	protected Text type;
	protected Text file;
	protected Text uri;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public LoadXMLModelTaskPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence loadXMLModelTaskStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = loadXMLModelTaskStep.addStep(EweViewsRepository.LoadXMLModelTask.Properties.class);
		propertiesStep.addStep(EweViewsRepository.LoadXMLModelTask.Properties.name);
		propertiesStep.addStep(EweViewsRepository.LoadXMLModelTask.Properties.type);
		propertiesStep.addStep(EweViewsRepository.LoadXMLModelTask.Properties.file);
		propertiesStep.addStep(EweViewsRepository.LoadXMLModelTask.Properties.uri);
		
		
		composer = new PartComposer(loadXMLModelTaskStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EweViewsRepository.LoadXMLModelTask.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EweViewsRepository.LoadXMLModelTask.Properties.name) {
					return createNameText(parent);
				}
				if (key == EweViewsRepository.LoadXMLModelTask.Properties.type) {
					return createTypeText(parent);
				}
				if (key == EweViewsRepository.LoadXMLModelTask.Properties.file) {
					return createFileText(parent);
				}
				if (key == EweViewsRepository.LoadXMLModelTask.Properties.uri) {
					return createUriText(parent);
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
		propertiesGroup.setText(EweMessages.LoadXMLModelTaskPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		SWTUtils.createPartLabel(parent, EweMessages.LoadXMLModelTaskPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(EweViewsRepository.LoadXMLModelTask.Properties.name, EweViewsRepository.SWT_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadXMLModelTaskPropertiesEditionPartImpl.this, EweViewsRepository.LoadXMLModelTask.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadXMLModelTaskPropertiesEditionPartImpl.this, EweViewsRepository.LoadXMLModelTask.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, EweViewsRepository.LoadXMLModelTask.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.LoadXMLModelTask.Properties.name, EweViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createTypeText(Composite parent) {
		SWTUtils.createPartLabel(parent, EweMessages.LoadXMLModelTaskPropertiesEditionPart_TypeLabel, propertiesEditionComponent.isRequired(EweViewsRepository.LoadXMLModelTask.Properties.type, EweViewsRepository.SWT_KIND));
		type = new Text(parent, SWT.BORDER);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadXMLModelTaskPropertiesEditionPartImpl.this, EweViewsRepository.LoadXMLModelTask.Properties.type, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, type.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadXMLModelTaskPropertiesEditionPartImpl.this, EweViewsRepository.LoadXMLModelTask.Properties.type, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, type.getText()));
				}
			}

		});
		EditingUtils.setID(type, EweViewsRepository.LoadXMLModelTask.Properties.type);
		EditingUtils.setEEFtype(type, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.LoadXMLModelTask.Properties.type, EweViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createFileText(Composite parent) {
		SWTUtils.createPartLabel(parent, EweMessages.LoadXMLModelTaskPropertiesEditionPart_FileLabel, propertiesEditionComponent.isRequired(EweViewsRepository.LoadXMLModelTask.Properties.file, EweViewsRepository.SWT_KIND));
		file = new Text(parent, SWT.BORDER);
		GridData fileData = new GridData(GridData.FILL_HORIZONTAL);
		file.setLayoutData(fileData);
		file.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadXMLModelTaskPropertiesEditionPartImpl.this, EweViewsRepository.LoadXMLModelTask.Properties.file, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, file.getText()));
			}

		});
		file.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadXMLModelTaskPropertiesEditionPartImpl.this, EweViewsRepository.LoadXMLModelTask.Properties.file, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, file.getText()));
				}
			}

		});
		EditingUtils.setID(file, EweViewsRepository.LoadXMLModelTask.Properties.file);
		EditingUtils.setEEFtype(file, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.LoadXMLModelTask.Properties.file, EweViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createUriText(Composite parent) {
		SWTUtils.createPartLabel(parent, EweMessages.LoadXMLModelTaskPropertiesEditionPart_UriLabel, propertiesEditionComponent.isRequired(EweViewsRepository.LoadXMLModelTask.Properties.uri, EweViewsRepository.SWT_KIND));
		uri = new Text(parent, SWT.BORDER);
		GridData uriData = new GridData(GridData.FILL_HORIZONTAL);
		uri.setLayoutData(uriData);
		uri.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadXMLModelTaskPropertiesEditionPartImpl.this, EweViewsRepository.LoadXMLModelTask.Properties.uri, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, uri.getText()));
			}

		});
		uri.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LoadXMLModelTaskPropertiesEditionPartImpl.this, EweViewsRepository.LoadXMLModelTask.Properties.uri, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, uri.getText()));
				}
			}

		});
		EditingUtils.setID(uri, EweViewsRepository.LoadXMLModelTask.Properties.uri);
		EditingUtils.setEEFtype(uri, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.LoadXMLModelTask.Properties.uri, EweViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see ewe.parts.LoadXMLModelTaskPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.LoadXMLModelTaskPropertiesEditionPart#setName(String newValue)
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
	 * @see ewe.parts.LoadXMLModelTaskPropertiesEditionPart#getType()
	 * 
	 */
	public String getType() {
		return type.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.LoadXMLModelTaskPropertiesEditionPart#setType(String newValue)
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
	 * @see ewe.parts.LoadXMLModelTaskPropertiesEditionPart#getFile()
	 * 
	 */
	public String getFile() {
		return file.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.LoadXMLModelTaskPropertiesEditionPart#setFile(String newValue)
	 * 
	 */
	public void setFile(String newValue) {
		if (newValue != null) {
			file.setText(newValue);
		} else {
			file.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.LoadXMLModelTaskPropertiesEditionPart#getUri()
	 * 
	 */
	public String getUri() {
		return uri.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.LoadXMLModelTaskPropertiesEditionPart#setUri(String newValue)
	 * 
	 */
	public void setUri(String newValue) {
		if (newValue != null) {
			uri.setText(newValue);
		} else {
			uri.setText(""); //$NON-NLS-1$
		}
	}







	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EweMessages.LoadXMLModelTask_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
