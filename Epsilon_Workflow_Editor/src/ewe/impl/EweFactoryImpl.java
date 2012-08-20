/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe.impl;

import ewe.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EweFactoryImpl extends EFactoryImpl implements EweFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static EweFactory init()
  {
    try
    {
      EweFactory theEweFactory = (EweFactory)EPackage.Registry.INSTANCE.getEFactory("ewe"); 
      if (theEweFactory != null)
      {
        return theEweFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new EweFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EweFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case EwePackage.PROJECT: return createProject();
      case EwePackage.TASK: return createTask();
      case EwePackage.LOAD_MODEL_TASK: return createLoadModelTask();
      case EwePackage.STORE_MODEL_TASK: return createStoreModelTask();
      case EwePackage.PARAMETER_NESTED_ELEMENT: return createParameterNestedElement();
      case EwePackage.VARIABLE_NESTED_ELEMENT: return createVariableNestedElement();
      case EwePackage.EXPORTS_NESTED_ELEMENT: return createExportsNestedElement();
      case EwePackage.USES_NESTED_ELEMENT: return createUsesNestedElement();
      case EwePackage.MODEL_NESTED_ELEMENT: return createModelNestedElement();
      case EwePackage.ROLLBACK_TRANSACTION_TASK: return createRollbackTransactionTask();
      case EwePackage.DISPOSE_MODEL_TASK: return createDisposeModelTask();
      case EwePackage.START_TRANSACTION_TASK: return createStartTransactionTask();
      case EwePackage.EOL_TASK: return createEolTask();
      case EwePackage.EML_TASK: return createEmlTask();
      case EwePackage.EGL_TASK: return createEglTask();
      case EwePackage.ETL_TASK: return createEtlTask();
      case EwePackage.EVL_TASK: return createEvlTask();
      case EwePackage.COMMIT_TRANSACTION_TASK: return createCommitTransactionTask();
      case EwePackage.PROPERTY: return createProperty();
      case EwePackage.TARGET: return createTarget();
      case EwePackage.LOAD_EMF_MODEL_TASK: return createLoadEMFModelTask();
      case EwePackage.ATTRIBUTE: return createAttribute();
      case EwePackage.LOAD_XML_MODEL_TASK: return createLoadXMLModelTask();
      case EwePackage.NESTED_ELEMENT: return createNestedElement();
      case EwePackage.FLOCK_TASK: return createFlockTask();
      case EwePackage.EUNIT_TASK: return createEUnitTask();
      case EwePackage.ECL_TASK: return createEclTask();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Project createProject()
  {
    ProjectImpl project = new ProjectImpl();
    return project;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Task createTask()
  {
    TaskImpl task = new TaskImpl();
    return task;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LoadModelTask createLoadModelTask()
  {
    LoadModelTaskImpl loadModelTask = new LoadModelTaskImpl();
    return loadModelTask;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StoreModelTask createStoreModelTask()
  {
    StoreModelTaskImpl storeModelTask = new StoreModelTaskImpl();
    return storeModelTask;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParameterNestedElement createParameterNestedElement()
  {
    ParameterNestedElementImpl parameterNestedElement = new ParameterNestedElementImpl();
    return parameterNestedElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableNestedElement createVariableNestedElement()
  {
    VariableNestedElementImpl variableNestedElement = new VariableNestedElementImpl();
    return variableNestedElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExportsNestedElement createExportsNestedElement()
  {
    ExportsNestedElementImpl exportsNestedElement = new ExportsNestedElementImpl();
    return exportsNestedElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UsesNestedElement createUsesNestedElement()
  {
    UsesNestedElementImpl usesNestedElement = new UsesNestedElementImpl();
    return usesNestedElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelNestedElement createModelNestedElement()
  {
    ModelNestedElementImpl modelNestedElement = new ModelNestedElementImpl();
    return modelNestedElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RollbackTransactionTask createRollbackTransactionTask()
  {
    RollbackTransactionTaskImpl rollbackTransactionTask = new RollbackTransactionTaskImpl();
    return rollbackTransactionTask;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DisposeModelTask createDisposeModelTask()
  {
    DisposeModelTaskImpl disposeModelTask = new DisposeModelTaskImpl();
    return disposeModelTask;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StartTransactionTask createStartTransactionTask()
  {
    StartTransactionTaskImpl startTransactionTask = new StartTransactionTaskImpl();
    return startTransactionTask;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EolTask createEolTask()
  {
    EolTaskImpl eolTask = new EolTaskImpl();
    return eolTask;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EmlTask createEmlTask()
  {
    EmlTaskImpl emlTask = new EmlTaskImpl();
    return emlTask;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EglTask createEglTask()
  {
    EglTaskImpl eglTask = new EglTaskImpl();
    return eglTask;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EtlTask createEtlTask()
  {
    EtlTaskImpl etlTask = new EtlTaskImpl();
    return etlTask;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EvlTask createEvlTask()
  {
    EvlTaskImpl evlTask = new EvlTaskImpl();
    return evlTask;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CommitTransactionTask createCommitTransactionTask()
  {
    CommitTransactionTaskImpl commitTransactionTask = new CommitTransactionTaskImpl();
    return commitTransactionTask;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Property createProperty()
  {
    PropertyImpl property = new PropertyImpl();
    return property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Target createTarget()
  {
    TargetImpl target = new TargetImpl();
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LoadEMFModelTask createLoadEMFModelTask()
  {
    LoadEMFModelTaskImpl loadEMFModelTask = new LoadEMFModelTaskImpl();
    return loadEMFModelTask;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Attribute createAttribute()
  {
    AttributeImpl attribute = new AttributeImpl();
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LoadXMLModelTask createLoadXMLModelTask()
  {
    LoadXMLModelTaskImpl loadXMLModelTask = new LoadXMLModelTaskImpl();
    return loadXMLModelTask;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NestedElement createNestedElement()
  {
    NestedElementImpl nestedElement = new NestedElementImpl();
    return nestedElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FlockTask createFlockTask()
  {
    FlockTaskImpl flockTask = new FlockTaskImpl();
    return flockTask;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EUnitTask createEUnitTask()
  {
    EUnitTaskImpl eUnitTask = new EUnitTaskImpl();
    return eUnitTask;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EclTask createEclTask()
  {
    EclTaskImpl eclTask = new EclTaskImpl();
    return eclTask;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EwePackage getEwePackage()
  {
    return (EwePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static EwePackage getPackage()
  {
    return EwePackage.eINSTANCE;
  }

} //EweFactoryImpl
