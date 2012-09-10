/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe.util;

import ewe.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see ewe.EwePackage
 * @generated
 */
public class EweSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static EwePackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EweSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = EwePackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case EwePackage.PROJECT:
      {
        Project project = (Project)theEObject;
        T result = caseProject(project);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EwePackage.TASK:
      {
        Task task = (Task)theEObject;
        T result = caseTask(task);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EwePackage.EPSILON_TASK:
      {
        EpsilonTask epsilonTask = (EpsilonTask)theEObject;
        T result = caseEpsilonTask(epsilonTask);
        if (result == null) result = caseTask(epsilonTask);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EwePackage.LOAD_MODEL_TASK:
      {
        LoadModelTask loadModelTask = (LoadModelTask)theEObject;
        T result = caseLoadModelTask(loadModelTask);
        if (result == null) result = caseEpsilonTask(loadModelTask);
        if (result == null) result = caseTask(loadModelTask);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EwePackage.STORE_MODEL_TASK:
      {
        StoreModelTask storeModelTask = (StoreModelTask)theEObject;
        T result = caseStoreModelTask(storeModelTask);
        if (result == null) result = caseEpsilonTask(storeModelTask);
        if (result == null) result = caseTask(storeModelTask);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EwePackage.PARAMETER_NESTED_ELEMENT:
      {
        ParameterNestedElement parameterNestedElement = (ParameterNestedElement)theEObject;
        T result = caseParameterNestedElement(parameterNestedElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EwePackage.VARIABLE_NESTED_ELEMENT:
      {
        VariableNestedElement variableNestedElement = (VariableNestedElement)theEObject;
        T result = caseVariableNestedElement(variableNestedElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EwePackage.EXPORTS_NESTED_ELEMENT:
      {
        ExportsNestedElement exportsNestedElement = (ExportsNestedElement)theEObject;
        T result = caseExportsNestedElement(exportsNestedElement);
        if (result == null) result = caseVariableNestedElement(exportsNestedElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EwePackage.USES_NESTED_ELEMENT:
      {
        UsesNestedElement usesNestedElement = (UsesNestedElement)theEObject;
        T result = caseUsesNestedElement(usesNestedElement);
        if (result == null) result = caseVariableNestedElement(usesNestedElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EwePackage.MODEL_NESTED_ELEMENT:
      {
        ModelNestedElement modelNestedElement = (ModelNestedElement)theEObject;
        T result = caseModelNestedElement(modelNestedElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EwePackage.EXECUTABLE_MODEL_TASK:
      {
        ExecutableModelTask executableModelTask = (ExecutableModelTask)theEObject;
        T result = caseExecutableModelTask(executableModelTask);
        if (result == null) result = caseEpsilonTask(executableModelTask);
        if (result == null) result = caseTask(executableModelTask);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EwePackage.ROLLBACK_TRANSACTION_TASK:
      {
        RollbackTransactionTask rollbackTransactionTask = (RollbackTransactionTask)theEObject;
        T result = caseRollbackTransactionTask(rollbackTransactionTask);
        if (result == null) result = caseEpsilonTask(rollbackTransactionTask);
        if (result == null) result = caseTask(rollbackTransactionTask);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EwePackage.DISPOSE_MODEL_TASK:
      {
        DisposeModelTask disposeModelTask = (DisposeModelTask)theEObject;
        T result = caseDisposeModelTask(disposeModelTask);
        if (result == null) result = caseEpsilonTask(disposeModelTask);
        if (result == null) result = caseTask(disposeModelTask);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EwePackage.START_TRANSACTION_TASK:
      {
        StartTransactionTask startTransactionTask = (StartTransactionTask)theEObject;
        T result = caseStartTransactionTask(startTransactionTask);
        if (result == null) result = caseEpsilonTask(startTransactionTask);
        if (result == null) result = caseTask(startTransactionTask);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EwePackage.EOL_TASK:
      {
        EolTask eolTask = (EolTask)theEObject;
        T result = caseEolTask(eolTask);
        if (result == null) result = caseExecutableModelTask(eolTask);
        if (result == null) result = caseEpsilonTask(eolTask);
        if (result == null) result = caseTask(eolTask);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EwePackage.EML_TASK:
      {
        EmlTask emlTask = (EmlTask)theEObject;
        T result = caseEmlTask(emlTask);
        if (result == null) result = caseExecutableModelTask(emlTask);
        if (result == null) result = caseEpsilonTask(emlTask);
        if (result == null) result = caseTask(emlTask);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EwePackage.EGL_TASK:
      {
        EglTask eglTask = (EglTask)theEObject;
        T result = caseEglTask(eglTask);
        if (result == null) result = caseExecutableModelTask(eglTask);
        if (result == null) result = caseEpsilonTask(eglTask);
        if (result == null) result = caseTask(eglTask);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EwePackage.ETL_TASK:
      {
        EtlTask etlTask = (EtlTask)theEObject;
        T result = caseEtlTask(etlTask);
        if (result == null) result = caseExecutableModelTask(etlTask);
        if (result == null) result = caseEpsilonTask(etlTask);
        if (result == null) result = caseTask(etlTask);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EwePackage.EVL_TASK:
      {
        EvlTask evlTask = (EvlTask)theEObject;
        T result = caseEvlTask(evlTask);
        if (result == null) result = caseExecutableModelTask(evlTask);
        if (result == null) result = caseEpsilonTask(evlTask);
        if (result == null) result = caseTask(evlTask);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EwePackage.COMMIT_TRANSACTION_TASK:
      {
        CommitTransactionTask commitTransactionTask = (CommitTransactionTask)theEObject;
        T result = caseCommitTransactionTask(commitTransactionTask);
        if (result == null) result = caseEpsilonTask(commitTransactionTask);
        if (result == null) result = caseTask(commitTransactionTask);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EwePackage.TARGET:
      {
        Target target = (Target)theEObject;
        T result = caseTarget(target);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EwePackage.LOAD_EMF_MODEL_TASK:
      {
        LoadEMFModelTask loadEMFModelTask = (LoadEMFModelTask)theEObject;
        T result = caseLoadEMFModelTask(loadEMFModelTask);
        if (result == null) result = caseLoadModelTask(loadEMFModelTask);
        if (result == null) result = caseEpsilonTask(loadEMFModelTask);
        if (result == null) result = caseTask(loadEMFModelTask);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EwePackage.ATTRIBUTE:
      {
        Attribute attribute = (Attribute)theEObject;
        T result = caseAttribute(attribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EwePackage.NESTED_ELEMENT:
      {
        NestedElement nestedElement = (NestedElement)theEObject;
        T result = caseNestedElement(nestedElement);
        if (result == null) result = caseTask(nestedElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EwePackage.FLOCK_TASK:
      {
        FlockTask flockTask = (FlockTask)theEObject;
        T result = caseFlockTask(flockTask);
        if (result == null) result = caseExecutableModelTask(flockTask);
        if (result == null) result = caseEpsilonTask(flockTask);
        if (result == null) result = caseTask(flockTask);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EwePackage.EUNIT_TASK:
      {
        EUnitTask eUnitTask = (EUnitTask)theEObject;
        T result = caseEUnitTask(eUnitTask);
        if (result == null) result = caseExecutableModelTask(eUnitTask);
        if (result == null) result = caseEpsilonTask(eUnitTask);
        if (result == null) result = caseTask(eUnitTask);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EwePackage.ECL_TASK:
      {
        EclTask eclTask = (EclTask)theEObject;
        T result = caseEclTask(eclTask);
        if (result == null) result = caseExecutableModelTask(eclTask);
        if (result == null) result = caseEpsilonTask(eclTask);
        if (result == null) result = caseTask(eclTask);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EwePackage.DISPOSE_MODELS_TASK:
      {
        DisposeModelsTask disposeModelsTask = (DisposeModelsTask)theEObject;
        T result = caseDisposeModelsTask(disposeModelsTask);
        if (result == null) result = caseEpsilonTask(disposeModelsTask);
        if (result == null) result = caseTask(disposeModelsTask);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Project</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Project</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProject(Project object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Task</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Task</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTask(Task object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Epsilon Task</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Epsilon Task</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEpsilonTask(EpsilonTask object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Load Model Task</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Load Model Task</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLoadModelTask(LoadModelTask object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Store Model Task</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Store Model Task</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStoreModelTask(StoreModelTask object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parameter Nested Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parameter Nested Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParameterNestedElement(ParameterNestedElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variable Nested Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable Nested Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVariableNestedElement(VariableNestedElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Exports Nested Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Exports Nested Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExportsNestedElement(ExportsNestedElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Uses Nested Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Uses Nested Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUsesNestedElement(UsesNestedElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model Nested Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model Nested Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModelNestedElement(ModelNestedElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Executable Model Task</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Executable Model Task</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExecutableModelTask(ExecutableModelTask object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rollback Transaction Task</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rollback Transaction Task</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRollbackTransactionTask(RollbackTransactionTask object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Dispose Model Task</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Dispose Model Task</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDisposeModelTask(DisposeModelTask object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Start Transaction Task</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Start Transaction Task</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStartTransactionTask(StartTransactionTask object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Eol Task</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Eol Task</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEolTask(EolTask object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Eml Task</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Eml Task</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEmlTask(EmlTask object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Egl Task</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Egl Task</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEglTask(EglTask object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Etl Task</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Etl Task</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEtlTask(EtlTask object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Evl Task</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Evl Task</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEvlTask(EvlTask object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Commit Transaction Task</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Commit Transaction Task</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCommitTransactionTask(CommitTransactionTask object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Target</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Target</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTarget(Target object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Load EMF Model Task</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Load EMF Model Task</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLoadEMFModelTask(LoadEMFModelTask object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttribute(Attribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Nested Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Nested Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNestedElement(NestedElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Flock Task</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Flock Task</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFlockTask(FlockTask object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EUnit Task</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EUnit Task</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEUnitTask(EUnitTask object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ecl Task</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ecl Task</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEclTask(EclTask object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Dispose Models Task</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Dispose Models Task</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDisposeModelsTask(DisposeModelsTask object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //EweSwitch
