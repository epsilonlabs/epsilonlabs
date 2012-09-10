/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe.impl;

import ewe.EwePackage;
import ewe.LoadEMFModelTask;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Load EMF Model Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ewe.impl.LoadEMFModelTaskImpl#getModelFile <em>Model File</em>}</li>
 *   <li>{@link ewe.impl.LoadEMFModelTaskImpl#getMetamodelFile <em>Metamodel File</em>}</li>
 *   <li>{@link ewe.impl.LoadEMFModelTaskImpl#isIsMetamodelFileBased <em>Is Metamodel File Based</em>}</li>
 *   <li>{@link ewe.impl.LoadEMFModelTaskImpl#isReadOnLoad <em>Read On Load</em>}</li>
 *   <li>{@link ewe.impl.LoadEMFModelTaskImpl#getMetamodelUri <em>Metamodel Uri</em>}</li>
 *   <li>{@link ewe.impl.LoadEMFModelTaskImpl#isStoreOnDisposal <em>Store On Disposal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoadEMFModelTaskImpl extends LoadModelTaskImpl implements LoadEMFModelTask
{
  /**
   * The default value of the '{@link #getModelFile() <em>Model File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModelFile()
   * @generated
   * @ordered
   */
  protected static final String MODEL_FILE_EDEFAULT = "";

  /**
   * The cached value of the '{@link #getModelFile() <em>Model File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModelFile()
   * @generated
   * @ordered
   */
  protected String modelFile = MODEL_FILE_EDEFAULT;

  /**
   * The default value of the '{@link #getMetamodelFile() <em>Metamodel File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMetamodelFile()
   * @generated
   * @ordered
   */
  protected static final String METAMODEL_FILE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMetamodelFile() <em>Metamodel File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMetamodelFile()
   * @generated
   * @ordered
   */
  protected String metamodelFile = METAMODEL_FILE_EDEFAULT;

  /**
   * The default value of the '{@link #isIsMetamodelFileBased() <em>Is Metamodel File Based</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsMetamodelFileBased()
   * @generated
   * @ordered
   */
  protected static final boolean IS_METAMODEL_FILE_BASED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsMetamodelFileBased() <em>Is Metamodel File Based</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsMetamodelFileBased()
   * @generated
   * @ordered
   */
  protected boolean isMetamodelFileBased = IS_METAMODEL_FILE_BASED_EDEFAULT;

  /**
   * The default value of the '{@link #isReadOnLoad() <em>Read On Load</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isReadOnLoad()
   * @generated
   * @ordered
   */
  protected static final boolean READ_ON_LOAD_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isReadOnLoad() <em>Read On Load</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isReadOnLoad()
   * @generated
   * @ordered
   */
  protected boolean readOnLoad = READ_ON_LOAD_EDEFAULT;

  /**
   * The default value of the '{@link #getMetamodelUri() <em>Metamodel Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMetamodelUri()
   * @generated
   * @ordered
   */
  protected static final String METAMODEL_URI_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMetamodelUri() <em>Metamodel Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMetamodelUri()
   * @generated
   * @ordered
   */
  protected String metamodelUri = METAMODEL_URI_EDEFAULT;

  /**
   * The default value of the '{@link #isStoreOnDisposal() <em>Store On Disposal</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStoreOnDisposal()
   * @generated
   * @ordered
   */
  protected static final boolean STORE_ON_DISPOSAL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isStoreOnDisposal() <em>Store On Disposal</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStoreOnDisposal()
   * @generated
   * @ordered
   */
  protected boolean storeOnDisposal = STORE_ON_DISPOSAL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LoadEMFModelTaskImpl()
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
    return EwePackage.Literals.LOAD_EMF_MODEL_TASK;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getModelFile()
  {
    return modelFile;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModelFile(String newModelFile)
  {
    String oldModelFile = modelFile;
    modelFile = newModelFile;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.LOAD_EMF_MODEL_TASK__MODEL_FILE, oldModelFile, modelFile));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMetamodelFile()
  {
    return metamodelFile;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMetamodelFile(String newMetamodelFile)
  {
    String oldMetamodelFile = metamodelFile;
    metamodelFile = newMetamodelFile;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.LOAD_EMF_MODEL_TASK__METAMODEL_FILE, oldMetamodelFile, metamodelFile));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsMetamodelFileBased()
  {
    return isMetamodelFileBased;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsMetamodelFileBased(boolean newIsMetamodelFileBased)
  {
    boolean oldIsMetamodelFileBased = isMetamodelFileBased;
    isMetamodelFileBased = newIsMetamodelFileBased;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.LOAD_EMF_MODEL_TASK__IS_METAMODEL_FILE_BASED, oldIsMetamodelFileBased, isMetamodelFileBased));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isReadOnLoad()
  {
    return readOnLoad;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReadOnLoad(boolean newReadOnLoad)
  {
    boolean oldReadOnLoad = readOnLoad;
    readOnLoad = newReadOnLoad;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.LOAD_EMF_MODEL_TASK__READ_ON_LOAD, oldReadOnLoad, readOnLoad));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMetamodelUri()
  {
    return metamodelUri;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMetamodelUri(String newMetamodelUri)
  {
    String oldMetamodelUri = metamodelUri;
    metamodelUri = newMetamodelUri;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.LOAD_EMF_MODEL_TASK__METAMODEL_URI, oldMetamodelUri, metamodelUri));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isStoreOnDisposal()
  {
    return storeOnDisposal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStoreOnDisposal(boolean newStoreOnDisposal)
  {
    boolean oldStoreOnDisposal = storeOnDisposal;
    storeOnDisposal = newStoreOnDisposal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EwePackage.LOAD_EMF_MODEL_TASK__STORE_ON_DISPOSAL, oldStoreOnDisposal, storeOnDisposal));
  }
  
  /**
   * Harcoding the type as EMF.
   * @generated NOT
   */
  public String getType()
  {
    return "EMF";
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
      case EwePackage.LOAD_EMF_MODEL_TASK__MODEL_FILE:
        return getModelFile();
      case EwePackage.LOAD_EMF_MODEL_TASK__METAMODEL_FILE:
        return getMetamodelFile();
      case EwePackage.LOAD_EMF_MODEL_TASK__IS_METAMODEL_FILE_BASED:
        return isIsMetamodelFileBased();
      case EwePackage.LOAD_EMF_MODEL_TASK__READ_ON_LOAD:
        return isReadOnLoad();
      case EwePackage.LOAD_EMF_MODEL_TASK__METAMODEL_URI:
        return getMetamodelUri();
      case EwePackage.LOAD_EMF_MODEL_TASK__STORE_ON_DISPOSAL:
        return isStoreOnDisposal();
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
      case EwePackage.LOAD_EMF_MODEL_TASK__MODEL_FILE:
        setModelFile((String)newValue);
        return;
      case EwePackage.LOAD_EMF_MODEL_TASK__METAMODEL_FILE:
        setMetamodelFile((String)newValue);
        return;
      case EwePackage.LOAD_EMF_MODEL_TASK__IS_METAMODEL_FILE_BASED:
        setIsMetamodelFileBased((Boolean)newValue);
        return;
      case EwePackage.LOAD_EMF_MODEL_TASK__READ_ON_LOAD:
        setReadOnLoad((Boolean)newValue);
        return;
      case EwePackage.LOAD_EMF_MODEL_TASK__METAMODEL_URI:
        setMetamodelUri((String)newValue);
        return;
      case EwePackage.LOAD_EMF_MODEL_TASK__STORE_ON_DISPOSAL:
        setStoreOnDisposal((Boolean)newValue);
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
      case EwePackage.LOAD_EMF_MODEL_TASK__MODEL_FILE:
        setModelFile(MODEL_FILE_EDEFAULT);
        return;
      case EwePackage.LOAD_EMF_MODEL_TASK__METAMODEL_FILE:
        setMetamodelFile(METAMODEL_FILE_EDEFAULT);
        return;
      case EwePackage.LOAD_EMF_MODEL_TASK__IS_METAMODEL_FILE_BASED:
        setIsMetamodelFileBased(IS_METAMODEL_FILE_BASED_EDEFAULT);
        return;
      case EwePackage.LOAD_EMF_MODEL_TASK__READ_ON_LOAD:
        setReadOnLoad(READ_ON_LOAD_EDEFAULT);
        return;
      case EwePackage.LOAD_EMF_MODEL_TASK__METAMODEL_URI:
        setMetamodelUri(METAMODEL_URI_EDEFAULT);
        return;
      case EwePackage.LOAD_EMF_MODEL_TASK__STORE_ON_DISPOSAL:
        setStoreOnDisposal(STORE_ON_DISPOSAL_EDEFAULT);
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
      case EwePackage.LOAD_EMF_MODEL_TASK__MODEL_FILE:
        return MODEL_FILE_EDEFAULT == null ? modelFile != null : !MODEL_FILE_EDEFAULT.equals(modelFile);
      case EwePackage.LOAD_EMF_MODEL_TASK__METAMODEL_FILE:
        return METAMODEL_FILE_EDEFAULT == null ? metamodelFile != null : !METAMODEL_FILE_EDEFAULT.equals(metamodelFile);
      case EwePackage.LOAD_EMF_MODEL_TASK__IS_METAMODEL_FILE_BASED:
        return isMetamodelFileBased != IS_METAMODEL_FILE_BASED_EDEFAULT;
      case EwePackage.LOAD_EMF_MODEL_TASK__READ_ON_LOAD:
        return readOnLoad != READ_ON_LOAD_EDEFAULT;
      case EwePackage.LOAD_EMF_MODEL_TASK__METAMODEL_URI:
        return METAMODEL_URI_EDEFAULT == null ? metamodelUri != null : !METAMODEL_URI_EDEFAULT.equals(metamodelUri);
      case EwePackage.LOAD_EMF_MODEL_TASK__STORE_ON_DISPOSAL:
        return storeOnDisposal != STORE_ON_DISPOSAL_EDEFAULT;
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
    result.append(" (modelFile: ");
    result.append(modelFile);
    result.append(", metamodelFile: ");
    result.append(metamodelFile);
    result.append(", isMetamodelFileBased: ");
    result.append(isMetamodelFileBased);
    result.append(", readOnLoad: ");
    result.append(readOnLoad);
    result.append(", metamodelUri: ");
    result.append(metamodelUri);
    result.append(", storeOnDisposal: ");
    result.append(storeOnDisposal);
    result.append(')');
    return result.toString();
  }

} //LoadEMFModelTaskImpl
