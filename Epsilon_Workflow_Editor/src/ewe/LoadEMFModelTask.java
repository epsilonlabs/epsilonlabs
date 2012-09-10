/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Load EMF Model Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ewe.LoadEMFModelTask#getModelFile <em>Model File</em>}</li>
 *   <li>{@link ewe.LoadEMFModelTask#getMetamodelFile <em>Metamodel File</em>}</li>
 *   <li>{@link ewe.LoadEMFModelTask#isIsMetamodelFileBased <em>Is Metamodel File Based</em>}</li>
 *   <li>{@link ewe.LoadEMFModelTask#isReadOnLoad <em>Read On Load</em>}</li>
 *   <li>{@link ewe.LoadEMFModelTask#getMetamodelUri <em>Metamodel Uri</em>}</li>
 *   <li>{@link ewe.LoadEMFModelTask#isStoreOnDisposal <em>Store On Disposal</em>}</li>
 * </ul>
 * </p>
 *
 * @see ewe.EwePackage#getLoadEMFModelTask()
 * @model annotation="gmf.node tool.name='Load EMF Model Task'"
 * @generated
 */
public interface LoadEMFModelTask extends LoadModelTask
{
  /**
   * Returns the value of the '<em><b>Model File</b></em>' attribute.
   * The default value is <code>""</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Model File</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Model File</em>' attribute.
   * @see #setModelFile(String)
   * @see ewe.EwePackage#getLoadEMFModelTask_ModelFile()
   * @model default="" required="true"
   * @generated
   */
  String getModelFile();

  /**
   * Sets the value of the '{@link ewe.LoadEMFModelTask#getModelFile <em>Model File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Model File</em>' attribute.
   * @see #getModelFile()
   * @generated
   */
  void setModelFile(String value);

  /**
   * Returns the value of the '<em><b>Metamodel File</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Metamodel File</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Metamodel File</em>' attribute.
   * @see #setMetamodelFile(String)
   * @see ewe.EwePackage#getLoadEMFModelTask_MetamodelFile()
   * @model
   * @generated
   */
  String getMetamodelFile();

  /**
   * Sets the value of the '{@link ewe.LoadEMFModelTask#getMetamodelFile <em>Metamodel File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Metamodel File</em>' attribute.
   * @see #getMetamodelFile()
   * @generated
   */
  void setMetamodelFile(String value);

  /**
   * Returns the value of the '<em><b>Is Metamodel File Based</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Metamodel File Based</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Metamodel File Based</em>' attribute.
   * @see #setIsMetamodelFileBased(boolean)
   * @see ewe.EwePackage#getLoadEMFModelTask_IsMetamodelFileBased()
   * @model
   * @generated
   */
  boolean isIsMetamodelFileBased();

  /**
   * Sets the value of the '{@link ewe.LoadEMFModelTask#isIsMetamodelFileBased <em>Is Metamodel File Based</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Metamodel File Based</em>' attribute.
   * @see #isIsMetamodelFileBased()
   * @generated
   */
  void setIsMetamodelFileBased(boolean value);

  /**
   * Returns the value of the '<em><b>Read On Load</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Read On Load</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Read On Load</em>' attribute.
   * @see #setReadOnLoad(boolean)
   * @see ewe.EwePackage#getLoadEMFModelTask_ReadOnLoad()
   * @model
   * @generated
   */
  boolean isReadOnLoad();

  /**
   * Sets the value of the '{@link ewe.LoadEMFModelTask#isReadOnLoad <em>Read On Load</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Read On Load</em>' attribute.
   * @see #isReadOnLoad()
   * @generated
   */
  void setReadOnLoad(boolean value);

  /**
   * Returns the value of the '<em><b>Metamodel Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Metamodel Uri</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Metamodel Uri</em>' attribute.
   * @see #setMetamodelUri(String)
   * @see ewe.EwePackage#getLoadEMFModelTask_MetamodelUri()
   * @model
   * @generated
   */
  String getMetamodelUri();

  /**
   * Sets the value of the '{@link ewe.LoadEMFModelTask#getMetamodelUri <em>Metamodel Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Metamodel Uri</em>' attribute.
   * @see #getMetamodelUri()
   * @generated
   */
  void setMetamodelUri(String value);

  /**
   * Returns the value of the '<em><b>Store On Disposal</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Store On Disposal</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Store On Disposal</em>' attribute.
   * @see #setStoreOnDisposal(boolean)
   * @see ewe.EwePackage#getLoadEMFModelTask_StoreOnDisposal()
   * @model
   * @generated
   */
  boolean isStoreOnDisposal();

  /**
   * Sets the value of the '{@link ewe.LoadEMFModelTask#isStoreOnDisposal <em>Store On Disposal</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Store On Disposal</em>' attribute.
   * @see #isStoreOnDisposal()
   * @generated
   */
  void setStoreOnDisposal(boolean value);

} // LoadEMFModelTask
