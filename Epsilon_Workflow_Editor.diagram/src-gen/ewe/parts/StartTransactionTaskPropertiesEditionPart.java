/**
 * Generated with Acceleo
 */
package ewe.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.EList;



// End of user code

/**
 * 
 * 
 */
public interface StartTransactionTaskPropertiesEditionPart {

	/**
	 * @return the name
	 * 
	 */
	public String getName();

	/**
	 * Defines a new name
	 * @param newValue the new name to set
	 * 
	 */
	public void setName(String newValue);


	/**
	 * @return the models
	 * 
	 */
	public EList getModels();

	/**
	 * Defines a new models
	 * @param newValue the new models to set
	 * 
	 */
	public void setModels(EList newValue);

	/**
	 * Add a value to the models multivalued attribute.
	 * @param newValue the value to add
	 */
	public void addToModels(Object newValue);

	/**
	 * Remove a value to the models multivalued attribute.
	 * @param newValue the value to remove
	 */
	public void removeToModels(Object newValue);





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
