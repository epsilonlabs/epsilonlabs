/**
 */
package org.eclipse.epsilon.eol.metamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IModel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.IModel#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.IModel#getAliases <em>Aliases</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.IModel#getDriver <em>Driver</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.IModel#getIMetamodelDriver <em>IMetamodel Driver</em>}</li>
 *   <li>{@link org.eclipse.epsilon.eol.metamodel.IModel#getIPackages <em>IPackages</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getIModel()
 * @model
 * @generated
 */
public interface IModel extends EOLElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' reference.
	 * @see #setName(NameExpression)
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getIModel_Name()
	 * @model required="true"
	 * @generated
	 */
	NameExpression getName();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.IModel#getName <em>Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' reference.
	 * @see #getName()
	 * @generated
	 */
	void setName(NameExpression value);

	/**
	 * Returns the value of the '<em><b>Aliases</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.eol.metamodel.NameExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aliases</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aliases</em>' reference list.
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getIModel_Aliases()
	 * @model
	 * @generated
	 */
	EList<NameExpression> getAliases();

	/**
	 * Returns the value of the '<em><b>Driver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Driver</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Driver</em>' reference.
	 * @see #setDriver(NameExpression)
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getIModel_Driver()
	 * @model required="true"
	 * @generated
	 */
	NameExpression getDriver();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.IModel#getDriver <em>Driver</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Driver</em>' reference.
	 * @see #getDriver()
	 * @generated
	 */
	void setDriver(NameExpression value);

	/**
	 * Returns the value of the '<em><b>IMetamodel Driver</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>IMetamodel Driver</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>IMetamodel Driver</em>' attribute.
	 * @see #setIMetamodelDriver(Object)
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getIModel_IMetamodelDriver()
	 * @model
	 * @generated
	 */
	Object getIMetamodelDriver();

	/**
	 * Sets the value of the '{@link org.eclipse.epsilon.eol.metamodel.IModel#getIMetamodelDriver <em>IMetamodel Driver</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>IMetamodel Driver</em>' attribute.
	 * @see #getIMetamodelDriver()
	 * @generated
	 */
	void setIMetamodelDriver(Object value);

	/**
	 * Returns the value of the '<em><b>IPackages</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epsilon.eol.metamodel.IPackage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>IPackages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>IPackages</em>' containment reference list.
	 * @see org.eclipse.epsilon.eol.metamodel.EolPackage#getIModel_IPackages()
	 * @model containment="true"
	 * @generated
	 */
	EList<IPackage> getIPackages();

} // IModel
