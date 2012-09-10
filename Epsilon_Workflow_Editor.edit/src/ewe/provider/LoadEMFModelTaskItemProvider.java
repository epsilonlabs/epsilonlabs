/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe.provider;


import ewe.EwePackage;
import ewe.LoadEMFModelTask;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link ewe.LoadEMFModelTask} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class LoadEMFModelTaskItemProvider
  extends LoadModelTaskItemProvider
  implements
    IEditingDomainItemProvider,
    IStructuredItemContentProvider,
    ITreeItemContentProvider,
    IItemLabelProvider,
    IItemPropertySource
{
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LoadEMFModelTaskItemProvider(AdapterFactory adapterFactory)
  {
    super(adapterFactory);
  }

  /**
   * This returns the property descriptors for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object)
  {
    if (itemPropertyDescriptors == null)
    {
      super.getPropertyDescriptors(object);

      addModelFilePropertyDescriptor(object);
      addMetamodelFilePropertyDescriptor(object);
      addIsMetamodelFileBasedPropertyDescriptor(object);
      addReadOnLoadPropertyDescriptor(object);
      addMetamodelUriPropertyDescriptor(object);
      addStoreOnDisposalPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Model File feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addModelFilePropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_LoadEMFModelTask_modelFile_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_LoadEMFModelTask_modelFile_feature", "_UI_LoadEMFModelTask_type"),
         EwePackage.Literals.LOAD_EMF_MODEL_TASK__MODEL_FILE,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Metamodel File feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addMetamodelFilePropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_LoadEMFModelTask_metamodelFile_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_LoadEMFModelTask_metamodelFile_feature", "_UI_LoadEMFModelTask_type"),
         EwePackage.Literals.LOAD_EMF_MODEL_TASK__METAMODEL_FILE,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Is Metamodel File Based feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addIsMetamodelFileBasedPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_LoadEMFModelTask_isMetamodelFileBased_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_LoadEMFModelTask_isMetamodelFileBased_feature", "_UI_LoadEMFModelTask_type"),
         EwePackage.Literals.LOAD_EMF_MODEL_TASK__IS_METAMODEL_FILE_BASED,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Read On Load feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addReadOnLoadPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_LoadEMFModelTask_readOnLoad_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_LoadEMFModelTask_readOnLoad_feature", "_UI_LoadEMFModelTask_type"),
         EwePackage.Literals.LOAD_EMF_MODEL_TASK__READ_ON_LOAD,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Metamodel Uri feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addMetamodelUriPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_LoadEMFModelTask_metamodelUri_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_LoadEMFModelTask_metamodelUri_feature", "_UI_LoadEMFModelTask_type"),
         EwePackage.Literals.LOAD_EMF_MODEL_TASK__METAMODEL_URI,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Store On Disposal feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addStoreOnDisposalPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_LoadEMFModelTask_storeOnDisposal_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_LoadEMFModelTask_storeOnDisposal_feature", "_UI_LoadEMFModelTask_type"),
         EwePackage.Literals.LOAD_EMF_MODEL_TASK__STORE_ON_DISPOSAL,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This returns LoadEMFModelTask.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object)
  {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/LoadEMFModelTask"));
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object)
  {
    String label = ((LoadEMFModelTask)object).getName();
    return label == null || label.length() == 0 ?
      getString("_UI_LoadEMFModelTask_type") :
      getString("_UI_LoadEMFModelTask_type") + " " + label;
  }

  /**
   * This handles model notifications by calling {@link #updateChildren} to update any cached
   * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void notifyChanged(Notification notification)
  {
    updateChildren(notification);

    switch (notification.getFeatureID(LoadEMFModelTask.class))
    {
      case EwePackage.LOAD_EMF_MODEL_TASK__MODEL_FILE:
      case EwePackage.LOAD_EMF_MODEL_TASK__METAMODEL_FILE:
      case EwePackage.LOAD_EMF_MODEL_TASK__IS_METAMODEL_FILE_BASED:
      case EwePackage.LOAD_EMF_MODEL_TASK__READ_ON_LOAD:
      case EwePackage.LOAD_EMF_MODEL_TASK__METAMODEL_URI:
      case EwePackage.LOAD_EMF_MODEL_TASK__STORE_ON_DISPOSAL:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
        return;
    }
    super.notifyChanged(notification);
  }

  /**
   * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
   * that can be created under this object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object)
  {
    super.collectNewChildDescriptors(newChildDescriptors, object);
  }

}
