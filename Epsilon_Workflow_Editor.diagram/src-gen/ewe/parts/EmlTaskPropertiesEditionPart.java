/**
 * Generated with Acceleo
 */
package ewe.parts;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ViewerFilter;



// End of user code

/**
 * 
 * 
 */
public interface EmlTaskPropertiesEditionPart {

	/**
	 * @return the src
	 * 
	 */
	public String getSrc();

	/**
	 * Defines a new src
	 * @param newValue the new src to set
	 * 
	 */
	public void setSrc(String newValue);




	/**
	 * Init the exports
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initExports(ReferencesTableSettings settings);

	/**
	 * Update the exports
	 * @param newValue the exports to update
	 * 
	 */
	public void updateExports();

	/**
	 * Adds the given filter to the exports edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToExports(ViewerFilter filter);

	/**
	 * Adds the given filter to the exports edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToExports(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the exports table
	 * 
	 */
	public boolean isContainedInExportsTable(EObject element);




	/**
	 * Init the uses
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initUses(ReferencesTableSettings settings);

	/**
	 * Update the uses
	 * @param newValue the uses to update
	 * 
	 */
	public void updateUses();

	/**
	 * Adds the given filter to the uses edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToUses(ViewerFilter filter);

	/**
	 * Adds the given filter to the uses edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToUses(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the uses table
	 * 
	 */
	public boolean isContainedInUsesTable(EObject element);




	/**
	 * Init the models
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initModels(ReferencesTableSettings settings);

	/**
	 * Update the models
	 * @param newValue the models to update
	 * 
	 */
	public void updateModels();

	/**
	 * Adds the given filter to the models edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToModels(ViewerFilter filter);

	/**
	 * Adds the given filter to the models edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToModels(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the models table
	 * 
	 */
	public boolean isContainedInModelsTable(EObject element);


	/**
	 * @return the useMatchTrace
	 * 
	 */
	public String getUseMatchTrace();

	/**
	 * Defines a new useMatchTrace
	 * @param newValue the new useMatchTrace to set
	 * 
	 */
	public void setUseMatchTrace(String newValue);


	/**
	 * @return the exportTransformationTrace
	 * 
	 */
	public String getExportTransformationTrace();

	/**
	 * Defines a new exportTransformationTrace
	 * @param newValue the new exportTransformationTrace to set
	 * 
	 */
	public void setExportTransformationTrace(String newValue);


	/**
	 * @return the exportMergeTrace
	 * 
	 */
	public String getExportMergeTrace();

	/**
	 * Defines a new exportMergeTrace
	 * @param newValue the new exportMergeTrace to set
	 * 
	 */
	public void setExportMergeTrace(String newValue);





	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
