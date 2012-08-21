/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Load XML Model Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ewe.LoadXMLModelTask#getFile <em>File</em>}</li>
 *   <li>{@link ewe.LoadXMLModelTask#getUri <em>Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see ewe.EwePackage#getLoadXMLModelTask()
 * @model annotation="gmf.node tool.name='Load XML Model Task'"
 * @generated
 */
public interface LoadXMLModelTask extends LoadModelTask
{
  /**
   * Returns the value of the '<em><b>File</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>File</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>File</em>' attribute.
   * @see #setFile(String)
   * @see ewe.EwePackage#getLoadXMLModelTask_File()
   * @model
   * @generated
   */
  String getFile();

  /**
   * Sets the value of the '{@link ewe.LoadXMLModelTask#getFile <em>File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>File</em>' attribute.
   * @see #getFile()
   * @generated
   */
  void setFile(String value);

  /**
   * Returns the value of the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Uri</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Uri</em>' attribute.
   * @see #setUri(String)
   * @see ewe.EwePackage#getLoadXMLModelTask_Uri()
   * @model
   * @generated
   */
  String getUri();

  /**
   * Sets the value of the '{@link ewe.LoadXMLModelTask#getUri <em>Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Uri</em>' attribute.
   * @see #getUri()
   * @generated
   */
  void setUri(String value);

} // LoadXMLModelTask
