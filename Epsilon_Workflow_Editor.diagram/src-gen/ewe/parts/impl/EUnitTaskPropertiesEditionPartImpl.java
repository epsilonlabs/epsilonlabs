/**
 * Generated with Acceleo
 */
package ewe.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
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
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ViewerFilter;
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

import ewe.parts.EUnitTaskPropertiesEditionPart;
import ewe.parts.EweViewsRepository;
import ewe.providers.EweMessages;


// End of user code

/**
 * 
 * 
 */
public class EUnitTaskPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, EUnitTaskPropertiesEditionPart {

	protected Text src;
protected ReferencesTable exports;
protected List<ViewerFilter> exportsBusinessFilters = new ArrayList<ViewerFilter>();
protected List<ViewerFilter> exportsFilters = new ArrayList<ViewerFilter>();
protected ReferencesTable uses;
protected List<ViewerFilter> usesBusinessFilters = new ArrayList<ViewerFilter>();
protected List<ViewerFilter> usesFilters = new ArrayList<ViewerFilter>();
protected ReferencesTable models;
protected List<ViewerFilter> modelsBusinessFilters = new ArrayList<ViewerFilter>();
protected List<ViewerFilter> modelsFilters = new ArrayList<ViewerFilter>();
	protected Button failOnErrors;
	protected Text report;
	protected Text toDir;
	protected Text package_;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public EUnitTaskPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence eUnitTaskStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = eUnitTaskStep.addStep(EweViewsRepository.EUnitTask.Properties.class);
		propertiesStep.addStep(EweViewsRepository.EUnitTask.Properties.src);
		propertiesStep.addStep(EweViewsRepository.EUnitTask.Properties.exports);
		propertiesStep.addStep(EweViewsRepository.EUnitTask.Properties.uses);
		propertiesStep.addStep(EweViewsRepository.EUnitTask.Properties.models);
		propertiesStep.addStep(EweViewsRepository.EUnitTask.Properties.failOnErrors);
		propertiesStep.addStep(EweViewsRepository.EUnitTask.Properties.report);
		propertiesStep.addStep(EweViewsRepository.EUnitTask.Properties.toDir);
		propertiesStep.addStep(EweViewsRepository.EUnitTask.Properties.package_);
		
		
		composer = new PartComposer(eUnitTaskStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EweViewsRepository.EUnitTask.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EweViewsRepository.EUnitTask.Properties.src) {
					return createSrcText(parent);
				}
				if (key == EweViewsRepository.EUnitTask.Properties.exports) {
					return createExportsAdvancedTableComposition(parent);
				}
				if (key == EweViewsRepository.EUnitTask.Properties.uses) {
					return createUsesAdvancedTableComposition(parent);
				}
				if (key == EweViewsRepository.EUnitTask.Properties.models) {
					return createModelsAdvancedTableComposition(parent);
				}
				if (key == EweViewsRepository.EUnitTask.Properties.failOnErrors) {
					return createFailOnErrorsCheckbox(parent);
				}
				if (key == EweViewsRepository.EUnitTask.Properties.report) {
					return createReportText(parent);
				}
				if (key == EweViewsRepository.EUnitTask.Properties.toDir) {
					return createToDirText(parent);
				}
				if (key == EweViewsRepository.EUnitTask.Properties.package_) {
					return createPackage_Text(parent);
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
		propertiesGroup.setText(EweMessages.EUnitTaskPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createSrcText(Composite parent) {
		SWTUtils.createPartLabel(parent, EweMessages.EUnitTaskPropertiesEditionPart_SrcLabel, propertiesEditionComponent.isRequired(EweViewsRepository.EUnitTask.Properties.src, EweViewsRepository.SWT_KIND));
		src = new Text(parent, SWT.BORDER);
		GridData srcData = new GridData(GridData.FILL_HORIZONTAL);
		src.setLayoutData(srcData);
		src.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EUnitTaskPropertiesEditionPartImpl.this, EweViewsRepository.EUnitTask.Properties.src, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, src.getText()));
			}

		});
		src.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EUnitTaskPropertiesEditionPartImpl.this, EweViewsRepository.EUnitTask.Properties.src, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, src.getText()));
				}
			}

		});
		EditingUtils.setID(src, EweViewsRepository.EUnitTask.Properties.src);
		EditingUtils.setEEFtype(src, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.EUnitTask.Properties.src, EweViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createExportsAdvancedTableComposition(Composite parent) {
		this.exports = new ReferencesTable(EweMessages.EUnitTaskPropertiesEditionPart_ExportsLabel, new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EUnitTaskPropertiesEditionPartImpl.this, EweViewsRepository.EUnitTask.Properties.exports, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				exports.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EUnitTaskPropertiesEditionPartImpl.this, EweViewsRepository.EUnitTask.Properties.exports, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				exports.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EUnitTaskPropertiesEditionPartImpl.this, EweViewsRepository.EUnitTask.Properties.exports, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				exports.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EUnitTaskPropertiesEditionPartImpl.this, EweViewsRepository.EUnitTask.Properties.exports, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				exports.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.exportsFilters) {
			this.exports.addFilter(filter);
		}
		this.exports.setHelpText(propertiesEditionComponent.getHelpContent(EweViewsRepository.EUnitTask.Properties.exports, EweViewsRepository.SWT_KIND));
		this.exports.createControls(parent);
		this.exports.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EUnitTaskPropertiesEditionPartImpl.this, EweViewsRepository.EUnitTask.Properties.exports, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData exportsData = new GridData(GridData.FILL_HORIZONTAL);
		exportsData.horizontalSpan = 3;
		this.exports.setLayoutData(exportsData);
		this.exports.setLowerBound(0);
		this.exports.setUpperBound(-1);
		exports.setID(EweViewsRepository.EUnitTask.Properties.exports);
		exports.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createUsesAdvancedTableComposition(Composite parent) {
		this.uses = new ReferencesTable(EweMessages.EUnitTaskPropertiesEditionPart_UsesLabel, new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EUnitTaskPropertiesEditionPartImpl.this, EweViewsRepository.EUnitTask.Properties.uses, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				uses.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EUnitTaskPropertiesEditionPartImpl.this, EweViewsRepository.EUnitTask.Properties.uses, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				uses.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EUnitTaskPropertiesEditionPartImpl.this, EweViewsRepository.EUnitTask.Properties.uses, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				uses.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EUnitTaskPropertiesEditionPartImpl.this, EweViewsRepository.EUnitTask.Properties.uses, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				uses.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.usesFilters) {
			this.uses.addFilter(filter);
		}
		this.uses.setHelpText(propertiesEditionComponent.getHelpContent(EweViewsRepository.EUnitTask.Properties.uses, EweViewsRepository.SWT_KIND));
		this.uses.createControls(parent);
		this.uses.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EUnitTaskPropertiesEditionPartImpl.this, EweViewsRepository.EUnitTask.Properties.uses, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData usesData = new GridData(GridData.FILL_HORIZONTAL);
		usesData.horizontalSpan = 3;
		this.uses.setLayoutData(usesData);
		this.uses.setLowerBound(0);
		this.uses.setUpperBound(-1);
		uses.setID(EweViewsRepository.EUnitTask.Properties.uses);
		uses.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createModelsAdvancedTableComposition(Composite parent) {
		this.models = new ReferencesTable(EweMessages.EUnitTaskPropertiesEditionPart_ModelsLabel, new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EUnitTaskPropertiesEditionPartImpl.this, EweViewsRepository.EUnitTask.Properties.models, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				models.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EUnitTaskPropertiesEditionPartImpl.this, EweViewsRepository.EUnitTask.Properties.models, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				models.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EUnitTaskPropertiesEditionPartImpl.this, EweViewsRepository.EUnitTask.Properties.models, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				models.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EUnitTaskPropertiesEditionPartImpl.this, EweViewsRepository.EUnitTask.Properties.models, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				models.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.modelsFilters) {
			this.models.addFilter(filter);
		}
		this.models.setHelpText(propertiesEditionComponent.getHelpContent(EweViewsRepository.EUnitTask.Properties.models, EweViewsRepository.SWT_KIND));
		this.models.createControls(parent);
		this.models.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EUnitTaskPropertiesEditionPartImpl.this, EweViewsRepository.EUnitTask.Properties.models, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData modelsData = new GridData(GridData.FILL_HORIZONTAL);
		modelsData.horizontalSpan = 3;
		this.models.setLayoutData(modelsData);
		this.models.setLowerBound(0);
		this.models.setUpperBound(-1);
		models.setID(EweViewsRepository.EUnitTask.Properties.models);
		models.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createFailOnErrorsCheckbox(Composite parent) {
		failOnErrors = new Button(parent, SWT.CHECK);
		failOnErrors.setText(EweMessages.EUnitTaskPropertiesEditionPart_FailOnErrorsLabel);
		failOnErrors.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EUnitTaskPropertiesEditionPartImpl.this, EweViewsRepository.EUnitTask.Properties.failOnErrors, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(failOnErrors.getSelection())));
			}

		});
		GridData failOnErrorsData = new GridData(GridData.FILL_HORIZONTAL);
		failOnErrorsData.horizontalSpan = 2;
		failOnErrors.setLayoutData(failOnErrorsData);
		EditingUtils.setID(failOnErrors, EweViewsRepository.EUnitTask.Properties.failOnErrors);
		EditingUtils.setEEFtype(failOnErrors, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.EUnitTask.Properties.failOnErrors, EweViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createReportText(Composite parent) {
		SWTUtils.createPartLabel(parent, EweMessages.EUnitTaskPropertiesEditionPart_ReportLabel, propertiesEditionComponent.isRequired(EweViewsRepository.EUnitTask.Properties.report, EweViewsRepository.SWT_KIND));
		report = new Text(parent, SWT.BORDER);
		GridData reportData = new GridData(GridData.FILL_HORIZONTAL);
		report.setLayoutData(reportData);
		report.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EUnitTaskPropertiesEditionPartImpl.this, EweViewsRepository.EUnitTask.Properties.report, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, report.getText()));
			}

		});
		report.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EUnitTaskPropertiesEditionPartImpl.this, EweViewsRepository.EUnitTask.Properties.report, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, report.getText()));
				}
			}

		});
		EditingUtils.setID(report, EweViewsRepository.EUnitTask.Properties.report);
		EditingUtils.setEEFtype(report, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.EUnitTask.Properties.report, EweViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createToDirText(Composite parent) {
		SWTUtils.createPartLabel(parent, EweMessages.EUnitTaskPropertiesEditionPart_ToDirLabel, propertiesEditionComponent.isRequired(EweViewsRepository.EUnitTask.Properties.toDir, EweViewsRepository.SWT_KIND));
		toDir = new Text(parent, SWT.BORDER);
		GridData toDirData = new GridData(GridData.FILL_HORIZONTAL);
		toDir.setLayoutData(toDirData);
		toDir.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EUnitTaskPropertiesEditionPartImpl.this, EweViewsRepository.EUnitTask.Properties.toDir, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, toDir.getText()));
			}

		});
		toDir.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EUnitTaskPropertiesEditionPartImpl.this, EweViewsRepository.EUnitTask.Properties.toDir, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, toDir.getText()));
				}
			}

		});
		EditingUtils.setID(toDir, EweViewsRepository.EUnitTask.Properties.toDir);
		EditingUtils.setEEFtype(toDir, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.EUnitTask.Properties.toDir, EweViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createPackage_Text(Composite parent) {
		SWTUtils.createPartLabel(parent, EweMessages.EUnitTaskPropertiesEditionPart_Package_Label, propertiesEditionComponent.isRequired(EweViewsRepository.EUnitTask.Properties.package_, EweViewsRepository.SWT_KIND));
		package_ = new Text(parent, SWT.BORDER);
		GridData package_Data = new GridData(GridData.FILL_HORIZONTAL);
		package_.setLayoutData(package_Data);
		package_.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EUnitTaskPropertiesEditionPartImpl.this, EweViewsRepository.EUnitTask.Properties.package_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, package_.getText()));
			}

		});
		package_.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EUnitTaskPropertiesEditionPartImpl.this, EweViewsRepository.EUnitTask.Properties.package_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, package_.getText()));
				}
			}

		});
		EditingUtils.setID(package_, EweViewsRepository.EUnitTask.Properties.package_);
		EditingUtils.setEEFtype(package_, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.EUnitTask.Properties.package_, EweViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see ewe.parts.EUnitTaskPropertiesEditionPart#getSrc()
	 * 
	 */
	public String getSrc() {
		return src.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EUnitTaskPropertiesEditionPart#setSrc(String newValue)
	 * 
	 */
	public void setSrc(String newValue) {
		if (newValue != null) {
			src.setText(newValue);
		} else {
			src.setText(""); //$NON-NLS-1$
		}
	}




	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EUnitTaskPropertiesEditionPart#initExports(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initExports(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		exports.setContentProvider(contentProvider);
		exports.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EUnitTaskPropertiesEditionPart#updateExports()
	 * 
	 */
	public void updateExports() {
	exports.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EUnitTaskPropertiesEditionPart#addFilterExports(ViewerFilter filter)
	 * 
	 */
	public void addFilterToExports(ViewerFilter filter) {
		exportsFilters.add(filter);
		if (this.exports != null) {
			this.exports.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EUnitTaskPropertiesEditionPart#addBusinessFilterExports(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToExports(ViewerFilter filter) {
		exportsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EUnitTaskPropertiesEditionPart#isContainedInExportsTable(EObject element)
	 * 
	 */
	public boolean isContainedInExportsTable(EObject element) {
		return ((ReferencesTableSettings)exports.getInput()).contains(element);
	}




	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EUnitTaskPropertiesEditionPart#initUses(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initUses(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		uses.setContentProvider(contentProvider);
		uses.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EUnitTaskPropertiesEditionPart#updateUses()
	 * 
	 */
	public void updateUses() {
	uses.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EUnitTaskPropertiesEditionPart#addFilterUses(ViewerFilter filter)
	 * 
	 */
	public void addFilterToUses(ViewerFilter filter) {
		usesFilters.add(filter);
		if (this.uses != null) {
			this.uses.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EUnitTaskPropertiesEditionPart#addBusinessFilterUses(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToUses(ViewerFilter filter) {
		usesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EUnitTaskPropertiesEditionPart#isContainedInUsesTable(EObject element)
	 * 
	 */
	public boolean isContainedInUsesTable(EObject element) {
		return ((ReferencesTableSettings)uses.getInput()).contains(element);
	}




	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EUnitTaskPropertiesEditionPart#initModels(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initModels(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		models.setContentProvider(contentProvider);
		models.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EUnitTaskPropertiesEditionPart#updateModels()
	 * 
	 */
	public void updateModels() {
	models.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EUnitTaskPropertiesEditionPart#addFilterModels(ViewerFilter filter)
	 * 
	 */
	public void addFilterToModels(ViewerFilter filter) {
		modelsFilters.add(filter);
		if (this.models != null) {
			this.models.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EUnitTaskPropertiesEditionPart#addBusinessFilterModels(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToModels(ViewerFilter filter) {
		modelsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EUnitTaskPropertiesEditionPart#isContainedInModelsTable(EObject element)
	 * 
	 */
	public boolean isContainedInModelsTable(EObject element) {
		return ((ReferencesTableSettings)models.getInput()).contains(element);
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EUnitTaskPropertiesEditionPart#getFailOnErrors()
	 * 
	 */
	public Boolean getFailOnErrors() {
		return Boolean.valueOf(failOnErrors.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EUnitTaskPropertiesEditionPart#setFailOnErrors(Boolean newValue)
	 * 
	 */
	public void setFailOnErrors(Boolean newValue) {
		if (newValue != null) {
			failOnErrors.setSelection(newValue.booleanValue());
		} else {
			failOnErrors.setSelection(false);
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EUnitTaskPropertiesEditionPart#getReport()
	 * 
	 */
	public String getReport() {
		return report.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EUnitTaskPropertiesEditionPart#setReport(String newValue)
	 * 
	 */
	public void setReport(String newValue) {
		if (newValue != null) {
			report.setText(newValue);
		} else {
			report.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EUnitTaskPropertiesEditionPart#getToDir()
	 * 
	 */
	public String getToDir() {
		return toDir.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EUnitTaskPropertiesEditionPart#setToDir(String newValue)
	 * 
	 */
	public void setToDir(String newValue) {
		if (newValue != null) {
			toDir.setText(newValue);
		} else {
			toDir.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EUnitTaskPropertiesEditionPart#getPackage_()
	 * 
	 */
	public String getPackage_() {
		return package_.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EUnitTaskPropertiesEditionPart#setPackage_(String newValue)
	 * 
	 */
	public void setPackage_(String newValue) {
		if (newValue != null) {
			package_.setText(newValue);
		} else {
			package_.setText(""); //$NON-NLS-1$
		}
	}







	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EweMessages.EUnitTask_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
