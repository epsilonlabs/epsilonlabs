/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe.impl;

import ewe.EwePackage;
import ewe.LoadXMLModelTask;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Load XML Model Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ewe.impl.LoadXMLModelTaskImpl#getFile <em>File</em>}</li>
 *   <li>{@link ewe.impl.LoadXMLModelTaskImpl#getUri <em>Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoadXMLModelTaskImpl extends LoadModelTaskImpl implements LoadXMLModelTask
{
  /**
   * The default value of the '{@link #getFile() <em>File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFile()
   * @generated
   * @ordered
   */
  protected static final String FILE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFile() <em>File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFile()
   * @generated
   * @ordered
   */
  protected String file = FILE_EDEFAULT;

  /**
   * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUri()
   * @generated
   * @ordered
   */
  protected static final String URI_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUri()
   * @generated
   * @ordered
   */
  protected String uri = URI_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LoadXMLModelTaskImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return EwePackage.Literals.LOAD_XML_MODEL_TASK;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFile()
  {
    return file;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFile(String newFile)
  {
    String oldFile = file;
    file = newFile;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.LOAD_XML_MODEL_TASK__FILE, oldFile, file));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getUri()
  {
    return uri;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUri(String newUri)
  {
    String oldUri = uri;
    uri = newUri;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.LOAD_XML_MODEL_TASK__URI, oldUri, uri));
  }
  
  /**
   * @generated NOT
   */
  
  public String getType() {
	  return "XML";
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case EwePackage.LOAD_XML_MODEL_TASK__FILE:
        return getFile();
      case EwePackage.LOAD_XML_MODEL_TASK__URI:
        return getUri();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case EwePackage.LOAD_XML_MODEL_TASK__FILE:
        setFile((String)newValue);
        return;
      case EwePackage.LOAD_XML_MODEL_TASK__URI:
        setUri((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case EwePackage.LOAD_XML_MODEL_TASK__FILE:
        setFile(FILE_EDEFAULT);
        return;
      case EwePackage.LOAD_XML_MODEL_TASK__URI:
        setUri(URI_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case EwePackage.LOAD_XML_MODEL_TASK__FILE:
        return FILE_EDEFAULT == null ? file != null : !FILE_EDEFAULT.equals(file);
      case EwePackage.LOAD_XML_MODEL_TASK__URI:
        return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (file: ");
    result.append(file);
    result.append(", uri: ");
    result.append(uri);
    result.append(')');
    return result.toString();
  }

} //LoadXMLModelTaskImpl
