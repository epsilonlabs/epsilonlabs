/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe.util;

import ewe.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see ewe.EwePackage
 * @generated
 */
public class EweAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static EwePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EweAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = EwePackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EweSwitch<Adapter> modelSwitch =
    new EweSwitch<Adapter>()
    {
      @Override
      public Adapter caseProject(Project object)
      {
        return createProjectAdapter();
      }
      @Override
      public Adapter caseTask(Task object)
      {
        return createTaskAdapter();
      }
      @Override
      public Adapter caseEpsilonTask(EpsilonTask object)
      {
        return createEpsilonTaskAdapter();
      }
      @Override
      public Adapter caseLoadModelTask(LoadModelTask object)
      {
        return createLoadModelTaskAdapter();
      }
      @Override
      public Adapter caseStoreModelTask(StoreModelTask object)
      {
        return createStoreModelTaskAdapter();
      }
      @Override
      public Adapter caseParameterNestedElement(ParameterNestedElement object)
      {
        return createParameterNestedElementAdapter();
      }
      @Override
      public Adapter caseVariableNestedElement(VariableNestedElement object)
      {
        return createVariableNestedElementAdapter();
      }
      @Override
      public Adapter caseExportsNestedElement(ExportsNestedElement object)
      {
        return createExportsNestedElementAdapter();
      }
      @Override
      public Adapter caseUsesNestedElement(UsesNestedElement object)
      {
        return createUsesNestedElementAdapter();
      }
      @Override
      public Adapter caseModelNestedElement(ModelNestedElement object)
      {
        return createModelNestedElementAdapter();
      }
      @Override
      public Adapter caseExecutableModelTask(ExecutableModelTask object)
      {
        return createExecutableModelTaskAdapter();
      }
      @Override
      public Adapter caseRollbackTransactionTask(RollbackTransactionTask object)
      {
        return createRollbackTransactionTaskAdapter();
      }
      @Override
      public Adapter caseDisposeModelTask(DisposeModelTask object)
      {
        return createDisposeModelTaskAdapter();
      }
      @Override
      public Adapter caseStartTransactionTask(StartTransactionTask object)
      {
        return createStartTransactionTaskAdapter();
      }
      @Override
      public Adapter caseEolTask(EolTask object)
      {
        return createEolTaskAdapter();
      }
      @Override
      public Adapter caseEmlTask(EmlTask object)
      {
        return createEmlTaskAdapter();
      }
      @Override
      public Adapter caseEglTask(EglTask object)
      {
        return createEglTaskAdapter();
      }
      @Override
      public Adapter caseEtlTask(EtlTask object)
      {
        return createEtlTaskAdapter();
      }
      @Override
      public Adapter caseEvlTask(EvlTask object)
      {
        return createEvlTaskAdapter();
      }
      @Override
      public Adapter caseCommitTransactionTask(CommitTransactionTask object)
      {
        return createCommitTransactionTaskAdapter();
      }
      @Override
      public Adapter caseTarget(Target object)
      {
        return createTargetAdapter();
      }
      @Override
      public Adapter caseLoadEMFModelTask(LoadEMFModelTask object)
      {
        return createLoadEMFModelTaskAdapter();
      }
      @Override
      public Adapter caseAttribute(Attribute object)
      {
        return createAttributeAdapter();
      }
      @Override
      public Adapter caseNestedElement(NestedElement object)
      {
        return createNestedElementAdapter();
      }
      @Override
      public Adapter caseFlockTask(FlockTask object)
      {
        return createFlockTaskAdapter();
      }
      @Override
      public Adapter caseEUnitTask(EUnitTask object)
      {
        return createEUnitTaskAdapter();
      }
      @Override
      public Adapter caseEclTask(EclTask object)
      {
        return createEclTaskAdapter();
      }
      @Override
      public Adapter caseDisposeModelsTask(DisposeModelsTask object)
      {
        return createDisposeModelsTaskAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link ewe.Project <em>Project</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ewe.Project
   * @generated
   */
  public Adapter createProjectAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ewe.Task <em>Task</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ewe.Task
   * @generated
   */
  public Adapter createTaskAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ewe.EpsilonTask <em>Epsilon Task</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ewe.EpsilonTask
   * @generated
   */
  public Adapter createEpsilonTaskAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ewe.LoadModelTask <em>Load Model Task</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ewe.LoadModelTask
   * @generated
   */
  public Adapter createLoadModelTaskAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ewe.StoreModelTask <em>Store Model Task</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ewe.StoreModelTask
   * @generated
   */
  public Adapter createStoreModelTaskAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ewe.ParameterNestedElement <em>Parameter Nested Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ewe.ParameterNestedElement
   * @generated
   */
  public Adapter createParameterNestedElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ewe.VariableNestedElement <em>Variable Nested Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ewe.VariableNestedElement
   * @generated
   */
  public Adapter createVariableNestedElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ewe.ExportsNestedElement <em>Exports Nested Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ewe.ExportsNestedElement
   * @generated
   */
  public Adapter createExportsNestedElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ewe.UsesNestedElement <em>Uses Nested Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ewe.UsesNestedElement
   * @generated
   */
  public Adapter createUsesNestedElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ewe.ModelNestedElement <em>Model Nested Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ewe.ModelNestedElement
   * @generated
   */
  public Adapter createModelNestedElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ewe.ExecutableModelTask <em>Executable Model Task</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ewe.ExecutableModelTask
   * @generated
   */
  public Adapter createExecutableModelTaskAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ewe.RollbackTransactionTask <em>Rollback Transaction Task</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ewe.RollbackTransactionTask
   * @generated
   */
  public Adapter createRollbackTransactionTaskAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ewe.DisposeModelTask <em>Dispose Model Task</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ewe.DisposeModelTask
   * @generated
   */
  public Adapter createDisposeModelTaskAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ewe.StartTransactionTask <em>Start Transaction Task</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ewe.StartTransactionTask
   * @generated
   */
  public Adapter createStartTransactionTaskAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ewe.EolTask <em>Eol Task</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ewe.EolTask
   * @generated
   */
  public Adapter createEolTaskAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ewe.EmlTask <em>Eml Task</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ewe.EmlTask
   * @generated
   */
  public Adapter createEmlTaskAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ewe.EglTask <em>Egl Task</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ewe.EglTask
   * @generated
   */
  public Adapter createEglTaskAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ewe.EtlTask <em>Etl Task</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ewe.EtlTask
   * @generated
   */
  public Adapter createEtlTaskAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ewe.EvlTask <em>Evl Task</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ewe.EvlTask
   * @generated
   */
  public Adapter createEvlTaskAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ewe.CommitTransactionTask <em>Commit Transaction Task</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ewe.CommitTransactionTask
   * @generated
   */
  public Adapter createCommitTransactionTaskAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ewe.Target <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ewe.Target
   * @generated
   */
  public Adapter createTargetAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ewe.LoadEMFModelTask <em>Load EMF Model Task</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ewe.LoadEMFModelTask
   * @generated
   */
  public Adapter createLoadEMFModelTaskAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ewe.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ewe.Attribute
   * @generated
   */
  public Adapter createAttributeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ewe.NestedElement <em>Nested Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ewe.NestedElement
   * @generated
   */
  public Adapter createNestedElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ewe.FlockTask <em>Flock Task</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ewe.FlockTask
   * @generated
   */
  public Adapter createFlockTaskAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ewe.EUnitTask <em>EUnit Task</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ewe.EUnitTask
   * @generated
   */
  public Adapter createEUnitTaskAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ewe.EclTask <em>Ecl Task</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ewe.EclTask
   * @generated
   */
  public Adapter createEclTaskAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ewe.DisposeModelsTask <em>Dispose Models Task</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ewe.DisposeModelsTask
   * @generated
   */
  public Adapter createDisposeModelsTaskAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //EweAdapterFactory
