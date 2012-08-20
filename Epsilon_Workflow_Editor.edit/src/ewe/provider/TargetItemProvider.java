/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe.provider;


import ewe.EweFactory;
import ewe.EwePackage;
import ewe.Target;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link ewe.Target} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TargetItemProvider
  extends ItemProviderAdapter
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
  public TargetItemProvider(AdapterFactory adapterFactory)
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

      addNamePropertyDescriptor(object);
      addDependsPropertyDescriptor(object);
      addDescriptionPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Name feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addNamePropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Target_name_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Target_name_feature", "_UI_Target_type"),
         EwePackage.Literals.TARGET__NAME,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Depends feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addDependsPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Target_depends_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Target_depends_feature", "_UI_Target_type"),
         EwePackage.Literals.TARGET__DEPENDS,
         true,
         false,
         true,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Description feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addDescriptionPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Target_description_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Target_description_feature", "_UI_Target_type"),
         EwePackage.Literals.TARGET__DESCRIPTION,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
   * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
   * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object)
  {
    if (childrenFeatures == null)
    {
      super.getChildrenFeatures(object);
      childrenFeatures.add(EwePackage.Literals.TARGET__TARGET_TASKS);
    }
    return childrenFeatures;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EStructuralFeature getChildFeature(Object object, Object child)
  {
    // Check the type of the specified child object and return the proper feature to use for
    // adding (see {@link AddCommand}) it as a child.

    return super.getChildFeature(object, child);
  }

  /**
   * This returns Target.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object)
  {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/Target"));
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
    String label = ((Target)object).getName();
    return label == null || label.length() == 0 ?
      getString("_UI_Target_type") :
      getString("_UI_Target_type") + " " + label;
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

    switch (notification.getFeatureID(Target.class))
    {
      case EwePackage.TARGET__NAME:
      case EwePackage.TARGET__DESCRIPTION:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
        return;
      case EwePackage.TARGET__TARGET_TASKS:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

    newChildDescriptors.add
      (createChildParameter
        (EwePackage.Literals.TARGET__TARGET_TASKS,
         EweFactory.eINSTANCE.createTask()));

    newChildDescriptors.add
      (createChildParameter
        (EwePackage.Literals.TARGET__TARGET_TASKS,
         EweFactory.eINSTANCE.createLoadModelTask()));

    newChildDescriptors.add
      (createChildParameter
        (EwePackage.Literals.TARGET__TARGET_TASKS,
         EweFactory.eINSTANCE.createStoreModelTask()));

    newChildDescriptors.add
      (createChildParameter
        (EwePackage.Literals.TARGET__TARGET_TASKS,
         EweFactory.eINSTANCE.createRollbackTransactionTask()));

    newChildDescriptors.add
      (createChildParameter
        (EwePackage.Literals.TARGET__TARGET_TASKS,
         EweFactory.eINSTANCE.createDisposeModelTask()));

    newChildDescriptors.add
      (createChildParameter
        (EwePackage.Literals.TARGET__TARGET_TASKS,
         EweFactory.eINSTANCE.createStartTransactionTask()));

    newChildDescriptors.add
      (createChildParameter
        (EwePackage.Literals.TARGET__TARGET_TASKS,
         EweFactory.eINSTANCE.createEolTask()));

    newChildDescriptors.add
      (createChildParameter
        (EwePackage.Literals.TARGET__TARGET_TASKS,
         EweFactory.eINSTANCE.createEmlTask()));

    newChildDescriptors.add
      (createChildParameter
        (EwePackage.Literals.TARGET__TARGET_TASKS,
         EweFactory.eINSTANCE.createEglTask()));

    newChildDescriptors.add
      (createChildParameter
        (EwePackage.Literals.TARGET__TARGET_TASKS,
         EweFactory.eINSTANCE.createEtlTask()));

    newChildDescriptors.add
      (createChildParameter
        (EwePackage.Literals.TARGET__TARGET_TASKS,
         EweFactory.eINSTANCE.createEvlTask()));

    newChildDescriptors.add
      (createChildParameter
        (EwePackage.Literals.TARGET__TARGET_TASKS,
         EweFactory.eINSTANCE.createCommitTransactionTask()));

    newChildDescriptors.add
      (createChildParameter
        (EwePackage.Literals.TARGET__TARGET_TASKS,
         EweFactory.eINSTANCE.createProperty()));

    newChildDescriptors.add
      (createChildParameter
        (EwePackage.Literals.TARGET__TARGET_TASKS,
         EweFactory.eINSTANCE.createLoadEMFModelTask()));

    newChildDescriptors.add
      (createChildParameter
        (EwePackage.Literals.TARGET__TARGET_TASKS,
         EweFactory.eINSTANCE.createLoadXMLModelTask()));

    newChildDescriptors.add
      (createChildParameter
        (EwePackage.Literals.TARGET__TARGET_TASKS,
         EweFactory.eINSTANCE.createNestedElement()));

    newChildDescriptors.add
      (createChildParameter
        (EwePackage.Literals.TARGET__TARGET_TASKS,
         EweFactory.eINSTANCE.createFlockTask()));

    newChildDescriptors.add
      (createChildParameter
        (EwePackage.Literals.TARGET__TARGET_TASKS,
         EweFactory.eINSTANCE.createEUnitTask()));

    newChildDescriptors.add
      (createChildParameter
        (EwePackage.Literals.TARGET__TARGET_TASKS,
         EweFactory.eINSTANCE.createEclTask()));
  }

  /**
   * Return the resource locator for this item provider's resources.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ResourceLocator getResourceLocator()
  {
    return EweEditPlugin.INSTANCE;
  }

}
