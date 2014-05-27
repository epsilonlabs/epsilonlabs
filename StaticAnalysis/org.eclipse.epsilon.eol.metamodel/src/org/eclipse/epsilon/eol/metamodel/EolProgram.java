/**
 */
package org.eclipse.epsilon.eol.metamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Program</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.EolProgram#getImportedModules <em>Imported Modules</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.EolProgram#getBlock <em>Block</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getEolProgram()
 * @model
 * @generated
 */
public interface EolProgram extends EolElement, EOLLibraryModule {
	/**
	 * Returns the value of the '<em><b>Imported Modules</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.eol.metamodel.EolProgram}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Modules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported Modules</em>' containment reference list.
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getEolProgram_ImportedModules()
	 * @model containment="true"
	 * @generated
	 */
	EList<EolProgram> getImportedModules();

	/**
	 * Returns the value of the '<em><b>Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Block</em>' containment reference.
	 * @see #setBlock(Block)
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getEolProgram_Block()
	 * @model containment="true"
	 * @generated
	 */
	Block getBlock();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.EolProgram#getBlock <em>Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Block</em>' containment reference.
	 * @see #getBlock()
	 * @generated
	 */
	void setBlock(Block value);

} // EolProgram
