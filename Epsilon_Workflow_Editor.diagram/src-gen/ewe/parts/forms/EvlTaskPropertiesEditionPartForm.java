/**
 * Generated with Acceleo
 */
package ewe.parts.forms;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
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
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
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
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import ewe.parts.EvlTaskPropertiesEditionPart;
import ewe.parts.EweViewsRepository;
import ewe.providers.EweMessages;


// End of user code

/**
 * 
 * 
 */
public class EvlTaskPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, EvlTaskPropertiesEditionPart {

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
	protected Button failOnWarnings;
	protected Button exportAsModel;
	protected Text exportConstraintTrace;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public EvlTaskPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence evlTaskStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = evlTaskStep.addStep(EweViewsRepository.EvlTask.Properties.class);
		propertiesStep.addStep(EweViewsRepository.EvlTask.Properties.src);
		propertiesStep.addStep(EweViewsRepository.EvlTask.Properties.exports);
		propertiesStep.addStep(EweViewsRepository.EvlTask.Properties.uses);
		propertiesStep.addStep(EweViewsRepository.EvlTask.Properties.models);
		propertiesStep.addStep(EweViewsRepository.EvlTask.Properties.failOnErrors);
		propertiesStep.addStep(EweViewsRepository.EvlTask.Properties.failOnWarnings);
		propertiesStep.addStep(EweViewsRepository.EvlTask.Properties.exportAsModel);
		propertiesStep.addStep(EweViewsRepository.EvlTask.Properties.exportConstraintTrace);
		
		
		composer = new PartComposer(evlTaskStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EweViewsRepository.EvlTask.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EweViewsRepository.EvlTask.Properties.src) {
					return 		createSrcText(widgetFactory, parent);
				}
				if (key == EweViewsRepository.EvlTask.Properties.exports) {
					return createExportsTableComposition(widgetFactory, parent);
				}
				if (key == EweViewsRepository.EvlTask.Properties.uses) {
					return createUsesTableComposition(widgetFactory, parent);
				}
				if (key == EweViewsRepository.EvlTask.Properties.models) {
					return createModelsTableComposition(widgetFactory, parent);
				}
				if (key == EweViewsRepository.EvlTask.Properties.failOnErrors) {
					return createFailOnErrorsCheckbox(widgetFactory, parent);
				}
				if (key == EweViewsRepository.EvlTask.Properties.failOnWarnings) {
					return createFailOnWarningsCheckbox(widgetFactory, parent);
				}
				if (key == EweViewsRepository.EvlTask.Properties.exportAsModel) {
					return createExportAsModelCheckbox(widgetFactory, parent);
				}
				if (key == EweViewsRepository.EvlTask.Properties.exportConstraintTrace) {
					return 		createExportConstraintTraceText(widgetFactory, parent);
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
		propertiesSection.setText(EweMessages.EvlTaskPropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createSrcText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, EweMessages.EvlTaskPropertiesEditionPart_SrcLabel, propertiesEditionComponent.isRequired(EweViewsRepository.EvlTask.Properties.src, EweViewsRepository.FORM_KIND));
		src = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		src.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData srcData = new GridData(GridData.FILL_HORIZONTAL);
		src.setLayoutData(srcData);
		src.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EvlTaskPropertiesEditionPartForm.this, EweViewsRepository.EvlTask.Properties.src, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, src.getText()));
			}
		});
		src.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EvlTaskPropertiesEditionPartForm.this, EweViewsRepository.EvlTask.Properties.src, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, src.getText()));
				}
			}
		});
		EditingUtils.setID(src, EweViewsRepository.EvlTask.Properties.src);
		EditingUtils.setEEFtype(src, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.EvlTask.Properties.src, EweViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createExportsTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.exports = new ReferencesTable(EweMessages.EvlTaskPropertiesEditionPart_ExportsLabel, new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EvlTaskPropertiesEditionPartForm.this, EweViewsRepository.EvlTask.Properties.exports, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				exports.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EvlTaskPropertiesEditionPartForm.this, EweViewsRepository.EvlTask.Properties.exports, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				exports.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EvlTaskPropertiesEditionPartForm.this, EweViewsRepository.EvlTask.Properties.exports, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				exports.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EvlTaskPropertiesEditionPartForm.this, EweViewsRepository.EvlTask.Properties.exports, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				exports.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.exportsFilters) {
			this.exports.addFilter(filter);
		}
		this.exports.setHelpText(propertiesEditionComponent.getHelpContent(EweViewsRepository.EvlTask.Properties.exports, EweViewsRepository.FORM_KIND));
		this.exports.createControls(parent, widgetFactory);
		this.exports.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EvlTaskPropertiesEditionPartForm.this, EweViewsRepository.EvlTask.Properties.exports, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData exportsData = new GridData(GridData.FILL_HORIZONTAL);
		exportsData.horizontalSpan = 3;
		this.exports.setLayoutData(exportsData);
		this.exports.setLowerBound(0);
		this.exports.setUpperBound(-1);
		exports.setID(EweViewsRepository.EvlTask.Properties.exports);
		exports.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createUsesTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.uses = new ReferencesTable(EweMessages.EvlTaskPropertiesEditionPart_UsesLabel, new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EvlTaskPropertiesEditionPartForm.this, EweViewsRepository.EvlTask.Properties.uses, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				uses.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EvlTaskPropertiesEditionPartForm.this, EweViewsRepository.EvlTask.Properties.uses, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				uses.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EvlTaskPropertiesEditionPartForm.this, EweViewsRepository.EvlTask.Properties.uses, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				uses.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EvlTaskPropertiesEditionPartForm.this, EweViewsRepository.EvlTask.Properties.uses, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				uses.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.usesFilters) {
			this.uses.addFilter(filter);
		}
		this.uses.setHelpText(propertiesEditionComponent.getHelpContent(EweViewsRepository.EvlTask.Properties.uses, EweViewsRepository.FORM_KIND));
		this.uses.createControls(parent, widgetFactory);
		this.uses.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EvlTaskPropertiesEditionPartForm.this, EweViewsRepository.EvlTask.Properties.uses, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData usesData = new GridData(GridData.FILL_HORIZONTAL);
		usesData.horizontalSpan = 3;
		this.uses.setLayoutData(usesData);
		this.uses.setLowerBound(0);
		this.uses.setUpperBound(-1);
		uses.setID(EweViewsRepository.EvlTask.Properties.uses);
		uses.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createModelsTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.models = new ReferencesTable(EweMessages.EvlTaskPropertiesEditionPart_ModelsLabel, new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EvlTaskPropertiesEditionPartForm.this, EweViewsRepository.EvlTask.Properties.models, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				models.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EvlTaskPropertiesEditionPartForm.this, EweViewsRepository.EvlTask.Properties.models, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				models.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EvlTaskPropertiesEditionPartForm.this, EweViewsRepository.EvlTask.Properties.models, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				models.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EvlTaskPropertiesEditionPartForm.this, EweViewsRepository.EvlTask.Properties.models, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				models.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.modelsFilters) {
			this.models.addFilter(filter);
		}
		this.models.setHelpText(propertiesEditionComponent.getHelpContent(EweViewsRepository.EvlTask.Properties.models, EweViewsRepository.FORM_KIND));
		this.models.createControls(parent, widgetFactory);
		this.models.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EvlTaskPropertiesEditionPartForm.this, EweViewsRepository.EvlTask.Properties.models, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData modelsData = new GridData(GridData.FILL_HORIZONTAL);
		modelsData.horizontalSpan = 3;
		this.models.setLayoutData(modelsData);
		this.models.setLowerBound(0);
		this.models.setUpperBound(-1);
		models.setID(EweViewsRepository.EvlTask.Properties.models);
		models.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createFailOnErrorsCheckbox(FormToolkit widgetFactory, Composite parent) {
		failOnErrors = widgetFactory.createButton(parent, EweMessages.EvlTaskPropertiesEditionPart_FailOnErrorsLabel, SWT.CHECK);
		failOnErrors.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EvlTaskPropertiesEditionPartForm.this, EweViewsRepository.EvlTask.Properties.failOnErrors, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(failOnErrors.getSelection())));
			}

		});
		GridData failOnErrorsData = new GridData(GridData.FILL_HORIZONTAL);
		failOnErrorsData.horizontalSpan = 2;
		failOnErrors.setLayoutData(failOnErrorsData);
		EditingUtils.setID(failOnErrors, EweViewsRepository.EvlTask.Properties.failOnErrors);
		EditingUtils.setEEFtype(failOnErrors, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.EvlTask.Properties.failOnErrors, EweViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createFailOnWarningsCheckbox(FormToolkit widgetFactory, Composite parent) {
		failOnWarnings = widgetFactory.createButton(parent, EweMessages.EvlTaskPropertiesEditionPart_FailOnWarningsLabel, SWT.CHECK);
		failOnWarnings.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EvlTaskPropertiesEditionPartForm.this, EweViewsRepository.EvlTask.Properties.failOnWarnings, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(failOnWarnings.getSelection())));
			}

		});
		GridData failOnWarningsData = new GridData(GridData.FILL_HORIZONTAL);
		failOnWarningsData.horizontalSpan = 2;
		failOnWarnings.setLayoutData(failOnWarningsData);
		EditingUtils.setID(failOnWarnings, EweViewsRepository.EvlTask.Properties.failOnWarnings);
		EditingUtils.setEEFtype(failOnWarnings, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.EvlTask.Properties.failOnWarnings, EweViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createExportAsModelCheckbox(FormToolkit widgetFactory, Composite parent) {
		exportAsModel = widgetFactory.createButton(parent, EweMessages.EvlTaskPropertiesEditionPart_ExportAsModelLabel, SWT.CHECK);
		exportAsModel.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EvlTaskPropertiesEditionPartForm.this, EweViewsRepository.EvlTask.Properties.exportAsModel, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(exportAsModel.getSelection())));
			}

		});
		GridData exportAsModelData = new GridData(GridData.FILL_HORIZONTAL);
		exportAsModelData.horizontalSpan = 2;
		exportAsModel.setLayoutData(exportAsModelData);
		EditingUtils.setID(exportAsModel, EweViewsRepository.EvlTask.Properties.exportAsModel);
		EditingUtils.setEEFtype(exportAsModel, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.EvlTask.Properties.exportAsModel, EweViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createExportConstraintTraceText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, EweMessages.EvlTaskPropertiesEditionPart_ExportConstraintTraceLabel, propertiesEditionComponent.isRequired(EweViewsRepository.EvlTask.Properties.exportConstraintTrace, EweViewsRepository.FORM_KIND));
		exportConstraintTrace = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		exportConstraintTrace.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData exportConstraintTraceData = new GridData(GridData.FILL_HORIZONTAL);
		exportConstraintTrace.setLayoutData(exportConstraintTraceData);
		exportConstraintTrace.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EvlTaskPropertiesEditionPartForm.this, EweViewsRepository.EvlTask.Properties.exportConstraintTrace, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, exportConstraintTrace.getText()));
			}
		});
		exportConstraintTrace.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EvlTaskPropertiesEditionPartForm.this, EweViewsRepository.EvlTask.Properties.exportConstraintTrace, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, exportConstraintTrace.getText()));
				}
			}
		});
		EditingUtils.setID(exportConstraintTrace, EweViewsRepository.EvlTask.Properties.exportConstraintTrace);
		EditingUtils.setEEFtype(exportConstraintTrace, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EweViewsRepository.EvlTask.Properties.exportConstraintTrace, EweViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
	 * @see ewe.parts.EvlTaskPropertiesEditionPart#getSrc()
	 * 
	 */
	public String getSrc() {
		return src.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EvlTaskPropertiesEditionPart#setSrc(String newValue)
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
	 * @see ewe.parts.EvlTaskPropertiesEditionPart#initExports(EObject current, EReference containingFeature, EReference feature)
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
	 * @see ewe.parts.EvlTaskPropertiesEditionPart#updateExports()
	 * 
	 */
	public void updateExports() {
	exports.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EvlTaskPropertiesEditionPart#addFilterExports(ViewerFilter filter)
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
	 * @see ewe.parts.EvlTaskPropertiesEditionPart#addBusinessFilterExports(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToExports(ViewerFilter filter) {
		exportsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EvlTaskPropertiesEditionPart#isContainedInExportsTable(EObject element)
	 * 
	 */
	public boolean isContainedInExportsTable(EObject element) {
		return ((ReferencesTableSettings)exports.getInput()).contains(element);
	}




	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EvlTaskPropertiesEditionPart#initUses(EObject current, EReference containingFeature, EReference feature)
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
	 * @see ewe.parts.EvlTaskPropertiesEditionPart#updateUses()
	 * 
	 */
	public void updateUses() {
	uses.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EvlTaskPropertiesEditionPart#addFilterUses(ViewerFilter filter)
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
	 * @see ewe.parts.EvlTaskPropertiesEditionPart#addBusinessFilterUses(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToUses(ViewerFilter filter) {
		usesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EvlTaskPropertiesEditionPart#isContainedInUsesTable(EObject element)
	 * 
	 */
	public boolean isContainedInUsesTable(EObject element) {
		return ((ReferencesTableSettings)uses.getInput()).contains(element);
	}




	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EvlTaskPropertiesEditionPart#initModels(EObject current, EReference containingFeature, EReference feature)
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
	 * @see ewe.parts.EvlTaskPropertiesEditionPart#updateModels()
	 * 
	 */
	public void updateModels() {
	models.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EvlTaskPropertiesEditionPart#addFilterModels(ViewerFilter filter)
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
	 * @see ewe.parts.EvlTaskPropertiesEditionPart#addBusinessFilterModels(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToModels(ViewerFilter filter) {
		modelsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EvlTaskPropertiesEditionPart#isContainedInModelsTable(EObject element)
	 * 
	 */
	public boolean isContainedInModelsTable(EObject element) {
		return ((ReferencesTableSettings)models.getInput()).contains(element);
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EvlTaskPropertiesEditionPart#getFailOnErrors()
	 * 
	 */
	public Boolean getFailOnErrors() {
		return Boolean.valueOf(failOnErrors.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EvlTaskPropertiesEditionPart#setFailOnErrors(Boolean newValue)
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
	 * @see ewe.parts.EvlTaskPropertiesEditionPart#getFailOnWarnings()
	 * 
	 */
	public Boolean getFailOnWarnings() {
		return Boolean.valueOf(failOnWarnings.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EvlTaskPropertiesEditionPart#setFailOnWarnings(Boolean newValue)
	 * 
	 */
	public void setFailOnWarnings(Boolean newValue) {
		if (newValue != null) {
			failOnWarnings.setSelection(newValue.booleanValue());
		} else {
			failOnWarnings.setSelection(false);
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EvlTaskPropertiesEditionPart#getExportAsModel()
	 * 
	 */
	public Boolean getExportAsModel() {
		return Boolean.valueOf(exportAsModel.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EvlTaskPropertiesEditionPart#setExportAsModel(Boolean newValue)
	 * 
	 */
	public void setExportAsModel(Boolean newValue) {
		if (newValue != null) {
			exportAsModel.setSelection(newValue.booleanValue());
		} else {
			exportAsModel.setSelection(false);
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EvlTaskPropertiesEditionPart#getExportConstraintTrace()
	 * 
	 */
	public String getExportConstraintTrace() {
		return exportConstraintTrace.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see ewe.parts.EvlTaskPropertiesEditionPart#setExportConstraintTrace(String newValue)
	 * 
	 */
	public void setExportConstraintTrace(String newValue) {
		if (newValue != null) {
			exportConstraintTrace.setText(newValue);
		} else {
			exportConstraintTrace.setText(""); //$NON-NLS-1$
		}
	}




	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EweMessages.EvlTask_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
