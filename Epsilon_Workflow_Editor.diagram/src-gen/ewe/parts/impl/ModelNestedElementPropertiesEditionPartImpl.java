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
import ewe.parts.ModelNestedElementPropertiesEditionPart;
import ewe.providers.EweMessages;


// End of user code

/**
 * 
 * 
 */
public class ModelNestedElementPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ModelNestedElementPropertiesEditionPart {

	protected Text ref;
	protected Text as;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ModelNestedElementPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence modelNestedElementStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = modelNestedElementStep.addStep(EweViewsRepository.ModelNestedElement.Properties.class);
		propertiesStep.addStep(EweViewsRepository.ModelNestedElement.Properties.ref);
		propertiesStep.addStep(EweViewsRepository.ModelNestedElement.Properties.as);
		
		
		composer = new PartComposer(modelNestedElementStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EweViewsRepository.ModelNestedElement.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EweViewsRepository.ModelNestedElement.Properties.ref) {
					return createRefText(parent);
				}
				if (key == EweViewsRepository.ModelNestedElement.Properties.as) {
					return createAsText(parent);
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
		propertiesGroup.setText(EweMessages.ModelNestedElementPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createRefText(Composite parent) {
		SWTUtils.createPartLabel(parent, EweMessages.ModelNestedElementPropertiesEditionPart_RefLabel, propertiesEditionComponent.isRequired(EweViewsRepository.ModelNestedElement.Properties.ref, EweViewsRepository.SWT_KIND));
		ref = new Text(parent, SWT.BORDER);
		GridData refData = new GridData(GridData.FILL_HORIZONTAL);
		ref.setLayoutData(refData);
		ref.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ModelNestedElementPropertiesEditionPartImpl.this, EweViewsRepository.ModelNestedElement.Properties.ref, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, ref.getText()));
			}

		});
		ref.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ModelNestedElementPropertiesEditionPartImpl.this, EweViewsRepository.ModelNestedElement.Properties.ref, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, ref.getText()));
				}
			}

		});
		EditingUtils.setID(ref, EweViewsRepository.ModelNestedElement.Properties.ref);
		EditingUtils.setEEFtype(ref, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.ModelNestedElement.Properties.ref, EweViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createAsText(Composite parent) {
		SWTUtils.createPartLabel(parent, EweMessages.ModelNestedElementPropertiesEditionPart_AsLabel, propertiesEditionComponent.isRequired(EweViewsRepository.ModelNestedElement.Properties.as, EweViewsRepository.SWT_KIND));
		as = new Text(parent, SWT.BORDER);
		GridData asData = new GridData(GridData.FILL_HORIZONTAL);
		as.setLayoutData(asData);
		as.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ModelNestedElementPropertiesEditionPartImpl.this, EweViewsRepository.ModelNestedElement.Properties.as, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, as.getText()));
			}

		});
		as.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ModelNestedElementPropertiesEditionPartImpl.this, EweViewsRepository.ModelNestedElement.Properties.as, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, as.getText()));
				}
			}

		});
		EditingUtils.setID(as, EweViewsRepository.ModelNestedElement.Properties.as);
		EditingUtils.setEEFtype(as, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.ModelNestedElement.Properties.as, EweViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see ewe.parts.ModelNestedElementPropertiesEditionPart#getRef()
	 * 
	 */
	public String getRef() {
		return ref.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.ModelNestedElementPropertiesEditionPart#setRef(String newValue)
	 * 
	 */
	public void setRef(String newValue) {
		if (newValue != null) {
			ref.setText(newValue);
		} else {
			ref.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.ModelNestedElementPropertiesEditionPart#getAs()
	 * 
	 */
	public String getAs() {
		return as.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.ModelNestedElementPropertiesEditionPart#setAs(String newValue)
	 * 
	 */
	public void setAs(String newValue) {
		if (newValue != null) {
			as.setText(newValue);
		} else {
			as.setText(""); //$NON-NLS-1$
		}
	}







	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EweMessages.ModelNestedElement_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
