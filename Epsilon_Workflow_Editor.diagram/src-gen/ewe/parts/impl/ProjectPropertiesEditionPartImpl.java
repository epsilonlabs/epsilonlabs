/**
 * Generated with Acceleo
 */
package ewe.parts.impl;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import ewe.parts.EweViewsRepository;
import ewe.parts.ProjectPropertiesEditionPart;
import ewe.providers.EweMessages;


// End of user code

/**
 * 
 * 
 */
public class ProjectPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ProjectPropertiesEditionPart {

	protected Text name;
	protected EObjectFlatComboViewer defaultTarget;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ProjectPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence projectStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = projectStep.addStep(EweViewsRepository.Project.Properties.class);
		propertiesStep.addStep(EweViewsRepository.Project.Properties.name);
		propertiesStep.addStep(EweViewsRepository.Project.Properties.defaultTarget);
		
		
		composer = new PartComposer(projectStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EweViewsRepository.Project.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EweViewsRepository.Project.Properties.name) {
					return createNameText(parent);
				}
				if (key == EweViewsRepository.Project.Properties.defaultTarget) {
					return createDefaultTargetFlatComboViewer(parent);
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
		propertiesGroup.setText(EweMessages.ProjectPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		SWTUtils.createPartLabel(parent, EweMessages.ProjectPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(EweViewsRepository.Project.Properties.name, EweViewsRepository.SWT_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProjectPropertiesEditionPartImpl.this, EweViewsRepository.Project.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProjectPropertiesEditionPartImpl.this, EweViewsRepository.Project.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, EweViewsRepository.Project.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.Project.Properties.name, EweViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createDefaultTargetFlatComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, EweMessages.ProjectPropertiesEditionPart_DefaultTargetLabel, propertiesEditionComponent.isRequired(EweViewsRepository.Project.Properties.defaultTarget, EweViewsRepository.SWT_KIND));
		defaultTarget = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EweViewsRepository.Project.Properties.defaultTarget, EweViewsRepository.SWT_KIND));
		defaultTarget.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		defaultTarget.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ProjectPropertiesEditionPartImpl.this, EweViewsRepository.Project.Properties.defaultTarget, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getDefaultTarget()));
			}

		});
		GridData defaultTargetData = new GridData(GridData.FILL_HORIZONTAL);
		defaultTarget.setLayoutData(defaultTargetData);
		defaultTarget.setID(EweViewsRepository.Project.Properties.defaultTarget);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.Project.Properties.defaultTarget, EweViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
