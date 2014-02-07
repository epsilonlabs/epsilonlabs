/**
 */
package org.eclipse.epsilon.eol.dom;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.dom.Import#getImported <em>Imported</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.dom.Import#getImportedProgram <em>Imported Program</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.dom.Import#getProgram <em>Program</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.dom.EolPackage#getImport()
 * @model
 * @generated
 */
public interface Import extends DomElement {
	/**
	 * Returns the value of the '<em><b>Imported</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported</em>' containment reference.
	 * @see #setImported(StringExpression)
	 * @see org.eclipse.epsilon.eol.dom.EolPackage#getImport_Imported()
	 * @model containment="true" required="true"
	 * @generated
	 */
	StringExpression getImported();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.dom.Import#getImported <em>Imported</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Imported</em>' containment reference.
	 * @see #getImported()
	 * @generated
	 */
	void setImported(StringExpression value);

	/**
	 * Returns the value of the '<em><b>Imported Program</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Program</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported Program</em>' containment reference.
	 * @see #setImportedProgram(Program)
	 * @see org.eclipse.epsilon.eol.dom.EolPackage#getImport_ImportedProgram()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Program getImportedProgram();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.dom.Import#getImportedProgram <em>Imported Program</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Imported Program</em>' containment reference.
	 * @see #getImportedProgram()
	 * @generated
	 */
	void setImportedProgram(Program value);

	/**
	 * Returns the value of the '<em><b>Program</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.epsilon.eol.dom.Program#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Program</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Program</em>' container reference.
	 * @see #setProgram(Program)
	 * @see org.eclipse.epsilon.eol.dom.EolPackage#getImport_Program()
	 * @see org.eclipse.epsilon.eol.dom.Program#getImports
	 * @model opposite="imports" transient="false"
	 * @generated
	 */
	Program getProgram();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.dom.Import#getProgram <em>Program</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Program</em>' container reference.
	 * @see #getProgram()
	 * @generated
	 */
	void setProgram(Program value);

} // Import
