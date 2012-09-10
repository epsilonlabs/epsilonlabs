/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ewe;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see ewe.EweFactory
 * @model kind="package"
 * @generated
 */
public interface EwePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "ewe";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "ewe";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "ewe";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  EwePackage eINSTANCE = ewe.impl.EwePackageImpl.init();

  /**
   * The meta object id for the '{@link ewe.impl.ProjectImpl <em>Project</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ewe.impl.ProjectImpl
   * @see ewe.impl.EwePackageImpl#getProject()
   * @generated
   */
  int PROJECT = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROJECT__NAME = 0;

  /**
   * The feature id for the '<em><b>Targets</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROJECT__TARGETS = 1;

  /**
   * The feature id for the '<em><b>Default Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROJECT__DEFAULT_TARGET = 2;

  /**
   * The number of structural features of the '<em>Project</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROJECT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link ewe.impl.TaskImpl <em>Task</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ewe.impl.TaskImpl
   * @see ewe.impl.EwePackageImpl#getTask()
   * @generated
   */
  int TASK = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK__NAME = 0;

  /**
   * The feature id for the '<em><b>Follows</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK__FOLLOWS = 1;

  /**
   * The feature id for the '<em><b>Follower</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK__FOLLOWER = 2;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK__ATTRIBUTES = 3;

  /**
   * The feature id for the '<em><b>Taskelements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK__TASKELEMENTS = 4;

  /**
   * The number of structural features of the '<em>Task</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link ewe.impl.EpsilonTaskImpl <em>Epsilon Task</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ewe.impl.EpsilonTaskImpl
   * @see ewe.impl.EwePackageImpl#getEpsilonTask()
   * @generated
   */
  int EPSILON_TASK = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EPSILON_TASK__NAME = TASK__NAME;

  /**
   * The feature id for the '<em><b>Follows</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EPSILON_TASK__FOLLOWS = TASK__FOLLOWS;

  /**
   * The feature id for the '<em><b>Follower</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EPSILON_TASK__FOLLOWER = TASK__FOLLOWER;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EPSILON_TASK__ATTRIBUTES = TASK__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Taskelements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EPSILON_TASK__TASKELEMENTS = TASK__TASKELEMENTS;

  /**
   * The number of structural features of the '<em>Epsilon Task</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EPSILON_TASK_FEATURE_COUNT = TASK_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link ewe.impl.LoadModelTaskImpl <em>Load Model Task</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ewe.impl.LoadModelTaskImpl
   * @see ewe.impl.EwePackageImpl#getLoadModelTask()
   * @generated
   */
  int LOAD_MODEL_TASK = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOAD_MODEL_TASK__NAME = EPSILON_TASK__NAME;

  /**
   * The feature id for the '<em><b>Follows</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOAD_MODEL_TASK__FOLLOWS = EPSILON_TASK__FOLLOWS;

  /**
   * The feature id for the '<em><b>Follower</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOAD_MODEL_TASK__FOLLOWER = EPSILON_TASK__FOLLOWER;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOAD_MODEL_TASK__ATTRIBUTES = EPSILON_TASK__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Taskelements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOAD_MODEL_TASK__TASKELEMENTS = EPSILON_TASK__TASKELEMENTS;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOAD_MODEL_TASK__PARAMETERS = EPSILON_TASK_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOAD_MODEL_TASK__TYPE = EPSILON_TASK_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Load Model Task</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOAD_MODEL_TASK_FEATURE_COUNT = EPSILON_TASK_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link ewe.impl.StoreModelTaskImpl <em>Store Model Task</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ewe.impl.StoreModelTaskImpl
   * @see ewe.impl.EwePackageImpl#getStoreModelTask()
   * @generated
   */
  int STORE_MODEL_TASK = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STORE_MODEL_TASK__NAME = EPSILON_TASK__NAME;

  /**
   * The feature id for the '<em><b>Follows</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STORE_MODEL_TASK__FOLLOWS = EPSILON_TASK__FOLLOWS;

  /**
   * The feature id for the '<em><b>Follower</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STORE_MODEL_TASK__FOLLOWER = EPSILON_TASK__FOLLOWER;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STORE_MODEL_TASK__ATTRIBUTES = EPSILON_TASK__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Taskelements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STORE_MODEL_TASK__TASKELEMENTS = EPSILON_TASK__TASKELEMENTS;

  /**
   * The feature id for the '<em><b>Model</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STORE_MODEL_TASK__MODEL = EPSILON_TASK_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STORE_MODEL_TASK__TARGET = EPSILON_TASK_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Store Model Task</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STORE_MODEL_TASK_FEATURE_COUNT = EPSILON_TASK_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link ewe.impl.ParameterNestedElementImpl <em>Parameter Nested Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ewe.impl.ParameterNestedElementImpl
   * @see ewe.impl.EwePackageImpl#getParameterNestedElement()
   * @generated
   */
  int PARAMETER_NESTED_ELEMENT = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_NESTED_ELEMENT__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_NESTED_ELEMENT__VALUE = 1;

  /**
   * The number of structural features of the '<em>Parameter Nested Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_NESTED_ELEMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link ewe.impl.VariableNestedElementImpl <em>Variable Nested Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ewe.impl.VariableNestedElementImpl
   * @see ewe.impl.EwePackageImpl#getVariableNestedElement()
   * @generated
   */
  int VARIABLE_NESTED_ELEMENT = 6;

  /**
   * The feature id for the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_NESTED_ELEMENT__REF = 0;

  /**
   * The feature id for the '<em><b>As</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_NESTED_ELEMENT__AS = 1;

  /**
   * The feature id for the '<em><b>Optional</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_NESTED_ELEMENT__OPTIONAL = 2;

  /**
   * The number of structural features of the '<em>Variable Nested Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_NESTED_ELEMENT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link ewe.impl.ExportsNestedElementImpl <em>Exports Nested Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ewe.impl.ExportsNestedElementImpl
   * @see ewe.impl.EwePackageImpl#getExportsNestedElement()
   * @generated
   */
  int EXPORTS_NESTED_ELEMENT = 7;

  /**
   * The feature id for the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPORTS_NESTED_ELEMENT__REF = VARIABLE_NESTED_ELEMENT__REF;

  /**
   * The feature id for the '<em><b>As</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPORTS_NESTED_ELEMENT__AS = VARIABLE_NESTED_ELEMENT__AS;

  /**
   * The feature id for the '<em><b>Optional</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPORTS_NESTED_ELEMENT__OPTIONAL = VARIABLE_NESTED_ELEMENT__OPTIONAL;

  /**
   * The number of structural features of the '<em>Exports Nested Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPORTS_NESTED_ELEMENT_FEATURE_COUNT = VARIABLE_NESTED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link ewe.impl.UsesNestedElementImpl <em>Uses Nested Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ewe.impl.UsesNestedElementImpl
   * @see ewe.impl.EwePackageImpl#getUsesNestedElement()
   * @generated
   */
  int USES_NESTED_ELEMENT = 8;

  /**
   * The feature id for the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USES_NESTED_ELEMENT__REF = VARIABLE_NESTED_ELEMENT__REF;

  /**
   * The feature id for the '<em><b>As</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USES_NESTED_ELEMENT__AS = VARIABLE_NESTED_ELEMENT__AS;

  /**
   * The feature id for the '<em><b>Optional</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USES_NESTED_ELEMENT__OPTIONAL = VARIABLE_NESTED_ELEMENT__OPTIONAL;

  /**
   * The number of structural features of the '<em>Uses Nested Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USES_NESTED_ELEMENT_FEATURE_COUNT = VARIABLE_NESTED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link ewe.impl.ModelNestedElementImpl <em>Model Nested Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ewe.impl.ModelNestedElementImpl
   * @see ewe.impl.EwePackageImpl#getModelNestedElement()
   * @generated
   */
  int MODEL_NESTED_ELEMENT = 9;

  /**
   * The feature id for the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_NESTED_ELEMENT__REF = 0;

  /**
   * The feature id for the '<em><b>As</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_NESTED_ELEMENT__AS = 1;

  /**
   * The number of structural features of the '<em>Model Nested Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_NESTED_ELEMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link ewe.impl.ExecutableModelTaskImpl <em>Executable Model Task</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ewe.impl.ExecutableModelTaskImpl
   * @see ewe.impl.EwePackageImpl#getExecutableModelTask()
   * @generated
   */
  int EXECUTABLE_MODEL_TASK = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTABLE_MODEL_TASK__NAME = EPSILON_TASK__NAME;

  /**
   * The feature id for the '<em><b>Follows</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTABLE_MODEL_TASK__FOLLOWS = EPSILON_TASK__FOLLOWS;

  /**
   * The feature id for the '<em><b>Follower</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTABLE_MODEL_TASK__FOLLOWER = EPSILON_TASK__FOLLOWER;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTABLE_MODEL_TASK__ATTRIBUTES = EPSILON_TASK__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Taskelements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTABLE_MODEL_TASK__TASKELEMENTS = EPSILON_TASK__TASKELEMENTS;

  /**
   * The feature id for the '<em><b>Src</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTABLE_MODEL_TASK__SRC = EPSILON_TASK_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Exports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTABLE_MODEL_TASK__EXPORTS = EPSILON_TASK_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Uses</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTABLE_MODEL_TASK__USES = EPSILON_TASK_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Models</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTABLE_MODEL_TASK__MODELS = EPSILON_TASK_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Executable Model Task</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTABLE_MODEL_TASK_FEATURE_COUNT = EPSILON_TASK_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link ewe.impl.RollbackTransactionTaskImpl <em>Rollback Transaction Task</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ewe.impl.RollbackTransactionTaskImpl
   * @see ewe.impl.EwePackageImpl#getRollbackTransactionTask()
   * @generated
   */
  int ROLLBACK_TRANSACTION_TASK = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLLBACK_TRANSACTION_TASK__NAME = EPSILON_TASK__NAME;

  /**
   * The feature id for the '<em><b>Follows</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLLBACK_TRANSACTION_TASK__FOLLOWS = EPSILON_TASK__FOLLOWS;

  /**
   * The feature id for the '<em><b>Follower</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLLBACK_TRANSACTION_TASK__FOLLOWER = EPSILON_TASK__FOLLOWER;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLLBACK_TRANSACTION_TASK__ATTRIBUTES = EPSILON_TASK__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Taskelements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLLBACK_TRANSACTION_TASK__TASKELEMENTS = EPSILON_TASK__TASKELEMENTS;

  /**
   * The number of structural features of the '<em>Rollback Transaction Task</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLLBACK_TRANSACTION_TASK_FEATURE_COUNT = EPSILON_TASK_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link ewe.impl.DisposeModelTaskImpl <em>Dispose Model Task</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ewe.impl.DisposeModelTaskImpl
   * @see ewe.impl.EwePackageImpl#getDisposeModelTask()
   * @generated
   */
  int DISPOSE_MODEL_TASK = 12;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPOSE_MODEL_TASK__NAME = EPSILON_TASK__NAME;

  /**
   * The feature id for the '<em><b>Follows</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPOSE_MODEL_TASK__FOLLOWS = EPSILON_TASK__FOLLOWS;

  /**
   * The feature id for the '<em><b>Follower</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPOSE_MODEL_TASK__FOLLOWER = EPSILON_TASK__FOLLOWER;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPOSE_MODEL_TASK__ATTRIBUTES = EPSILON_TASK__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Taskelements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPOSE_MODEL_TASK__TASKELEMENTS = EPSILON_TASK__TASKELEMENTS;

  /**
   * The feature id for the '<em><b>Model</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPOSE_MODEL_TASK__MODEL = EPSILON_TASK_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Dispose Model Task</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPOSE_MODEL_TASK_FEATURE_COUNT = EPSILON_TASK_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link ewe.impl.StartTransactionTaskImpl <em>Start Transaction Task</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ewe.impl.StartTransactionTaskImpl
   * @see ewe.impl.EwePackageImpl#getStartTransactionTask()
   * @generated
   */
  int START_TRANSACTION_TASK = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int START_TRANSACTION_TASK__NAME = EPSILON_TASK__NAME;

  /**
   * The feature id for the '<em><b>Follows</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int START_TRANSACTION_TASK__FOLLOWS = EPSILON_TASK__FOLLOWS;

  /**
   * The feature id for the '<em><b>Follower</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int START_TRANSACTION_TASK__FOLLOWER = EPSILON_TASK__FOLLOWER;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int START_TRANSACTION_TASK__ATTRIBUTES = EPSILON_TASK__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Taskelements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int START_TRANSACTION_TASK__TASKELEMENTS = EPSILON_TASK__TASKELEMENTS;

  /**
   * The feature id for the '<em><b>Models</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int START_TRANSACTION_TASK__MODELS = EPSILON_TASK_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Start Transaction Task</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int START_TRANSACTION_TASK_FEATURE_COUNT = EPSILON_TASK_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link ewe.impl.EolTaskImpl <em>Eol Task</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ewe.impl.EolTaskImpl
   * @see ewe.impl.EwePackageImpl#getEolTask()
   * @generated
   */
  int EOL_TASK = 14;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EOL_TASK__NAME = EXECUTABLE_MODEL_TASK__NAME;

  /**
   * The feature id for the '<em><b>Follows</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EOL_TASK__FOLLOWS = EXECUTABLE_MODEL_TASK__FOLLOWS;

  /**
   * The feature id for the '<em><b>Follower</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EOL_TASK__FOLLOWER = EXECUTABLE_MODEL_TASK__FOLLOWER;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EOL_TASK__ATTRIBUTES = EXECUTABLE_MODEL_TASK__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Taskelements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EOL_TASK__TASKELEMENTS = EXECUTABLE_MODEL_TASK__TASKELEMENTS;

  /**
   * The feature id for the '<em><b>Src</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EOL_TASK__SRC = EXECUTABLE_MODEL_TASK__SRC;

  /**
   * The feature id for the '<em><b>Exports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EOL_TASK__EXPORTS = EXECUTABLE_MODEL_TASK__EXPORTS;

  /**
   * The feature id for the '<em><b>Uses</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EOL_TASK__USES = EXECUTABLE_MODEL_TASK__USES;

  /**
   * The feature id for the '<em><b>Models</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EOL_TASK__MODELS = EXECUTABLE_MODEL_TASK__MODELS;

  /**
   * The number of structural features of the '<em>Eol Task</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EOL_TASK_FEATURE_COUNT = EXECUTABLE_MODEL_TASK_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link ewe.impl.EmlTaskImpl <em>Eml Task</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ewe.impl.EmlTaskImpl
   * @see ewe.impl.EwePackageImpl#getEmlTask()
   * @generated
   */
  int EML_TASK = 15;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EML_TASK__NAME = EXECUTABLE_MODEL_TASK__NAME;

  /**
   * The feature id for the '<em><b>Follows</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EML_TASK__FOLLOWS = EXECUTABLE_MODEL_TASK__FOLLOWS;

  /**
   * The feature id for the '<em><b>Follower</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EML_TASK__FOLLOWER = EXECUTABLE_MODEL_TASK__FOLLOWER;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EML_TASK__ATTRIBUTES = EXECUTABLE_MODEL_TASK__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Taskelements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EML_TASK__TASKELEMENTS = EXECUTABLE_MODEL_TASK__TASKELEMENTS;

  /**
   * The feature id for the '<em><b>Src</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EML_TASK__SRC = EXECUTABLE_MODEL_TASK__SRC;

  /**
   * The feature id for the '<em><b>Exports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EML_TASK__EXPORTS = EXECUTABLE_MODEL_TASK__EXPORTS;

  /**
   * The feature id for the '<em><b>Uses</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EML_TASK__USES = EXECUTABLE_MODEL_TASK__USES;

  /**
   * The feature id for the '<em><b>Models</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EML_TASK__MODELS = EXECUTABLE_MODEL_TASK__MODELS;

  /**
   * The feature id for the '<em><b>Use Match Trace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EML_TASK__USE_MATCH_TRACE = EXECUTABLE_MODEL_TASK_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Export Transformation Trace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EML_TASK__EXPORT_TRANSFORMATION_TRACE = EXECUTABLE_MODEL_TASK_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Export Merge Trace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EML_TASK__EXPORT_MERGE_TRACE = EXECUTABLE_MODEL_TASK_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Eml Task</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EML_TASK_FEATURE_COUNT = EXECUTABLE_MODEL_TASK_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link ewe.impl.EglTaskImpl <em>Egl Task</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ewe.impl.EglTaskImpl
   * @see ewe.impl.EwePackageImpl#getEglTask()
   * @generated
   */
  int EGL_TASK = 16;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EGL_TASK__NAME = EXECUTABLE_MODEL_TASK__NAME;

  /**
   * The feature id for the '<em><b>Follows</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EGL_TASK__FOLLOWS = EXECUTABLE_MODEL_TASK__FOLLOWS;

  /**
   * The feature id for the '<em><b>Follower</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EGL_TASK__FOLLOWER = EXECUTABLE_MODEL_TASK__FOLLOWER;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EGL_TASK__ATTRIBUTES = EXECUTABLE_MODEL_TASK__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Taskelements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EGL_TASK__TASKELEMENTS = EXECUTABLE_MODEL_TASK__TASKELEMENTS;

  /**
   * The feature id for the '<em><b>Src</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EGL_TASK__SRC = EXECUTABLE_MODEL_TASK__SRC;

  /**
   * The feature id for the '<em><b>Exports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EGL_TASK__EXPORTS = EXECUTABLE_MODEL_TASK__EXPORTS;

  /**
   * The feature id for the '<em><b>Uses</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EGL_TASK__USES = EXECUTABLE_MODEL_TASK__USES;

  /**
   * The feature id for the '<em><b>Models</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EGL_TASK__MODELS = EXECUTABLE_MODEL_TASK__MODELS;

  /**
   * The feature id for the '<em><b>Target</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EGL_TASK__TARGET = EXECUTABLE_MODEL_TASK_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Egl Task</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EGL_TASK_FEATURE_COUNT = EXECUTABLE_MODEL_TASK_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link ewe.impl.EtlTaskImpl <em>Etl Task</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ewe.impl.EtlTaskImpl
   * @see ewe.impl.EwePackageImpl#getEtlTask()
   * @generated
   */
  int ETL_TASK = 17;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ETL_TASK__NAME = EXECUTABLE_MODEL_TASK__NAME;

  /**
   * The feature id for the '<em><b>Follows</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ETL_TASK__FOLLOWS = EXECUTABLE_MODEL_TASK__FOLLOWS;

  /**
   * The feature id for the '<em><b>Follower</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ETL_TASK__FOLLOWER = EXECUTABLE_MODEL_TASK__FOLLOWER;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ETL_TASK__ATTRIBUTES = EXECUTABLE_MODEL_TASK__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Taskelements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ETL_TASK__TASKELEMENTS = EXECUTABLE_MODEL_TASK__TASKELEMENTS;

  /**
   * The feature id for the '<em><b>Src</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ETL_TASK__SRC = EXECUTABLE_MODEL_TASK__SRC;

  /**
   * The feature id for the '<em><b>Exports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ETL_TASK__EXPORTS = EXECUTABLE_MODEL_TASK__EXPORTS;

  /**
   * The feature id for the '<em><b>Uses</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ETL_TASK__USES = EXECUTABLE_MODEL_TASK__USES;

  /**
   * The feature id for the '<em><b>Models</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ETL_TASK__MODELS = EXECUTABLE_MODEL_TASK__MODELS;

  /**
   * The feature id for the '<em><b>Export Transformation Trace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ETL_TASK__EXPORT_TRANSFORMATION_TRACE = EXECUTABLE_MODEL_TASK_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Etl Task</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ETL_TASK_FEATURE_COUNT = EXECUTABLE_MODEL_TASK_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link ewe.impl.EvlTaskImpl <em>Evl Task</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ewe.impl.EvlTaskImpl
   * @see ewe.impl.EwePackageImpl#getEvlTask()
   * @generated
   */
  int EVL_TASK = 18;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVL_TASK__NAME = EXECUTABLE_MODEL_TASK__NAME;

  /**
   * The feature id for the '<em><b>Follows</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVL_TASK__FOLLOWS = EXECUTABLE_MODEL_TASK__FOLLOWS;

  /**
   * The feature id for the '<em><b>Follower</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVL_TASK__FOLLOWER = EXECUTABLE_MODEL_TASK__FOLLOWER;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVL_TASK__ATTRIBUTES = EXECUTABLE_MODEL_TASK__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Taskelements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVL_TASK__TASKELEMENTS = EXECUTABLE_MODEL_TASK__TASKELEMENTS;

  /**
   * The feature id for the '<em><b>Src</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVL_TASK__SRC = EXECUTABLE_MODEL_TASK__SRC;

  /**
   * The feature id for the '<em><b>Exports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVL_TASK__EXPORTS = EXECUTABLE_MODEL_TASK__EXPORTS;

  /**
   * The feature id for the '<em><b>Uses</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVL_TASK__USES = EXECUTABLE_MODEL_TASK__USES;

  /**
   * The feature id for the '<em><b>Models</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVL_TASK__MODELS = EXECUTABLE_MODEL_TASK__MODELS;

  /**
   * The feature id for the '<em><b>Fail On Errors</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVL_TASK__FAIL_ON_ERRORS = EXECUTABLE_MODEL_TASK_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Fail On Warnings</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVL_TASK__FAIL_ON_WARNINGS = EXECUTABLE_MODEL_TASK_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Export As Model</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVL_TASK__EXPORT_AS_MODEL = EXECUTABLE_MODEL_TASK_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Export Constraint Trace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVL_TASK__EXPORT_CONSTRAINT_TRACE = EXECUTABLE_MODEL_TASK_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Evl Task</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVL_TASK_FEATURE_COUNT = EXECUTABLE_MODEL_TASK_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link ewe.impl.CommitTransactionTaskImpl <em>Commit Transaction Task</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ewe.impl.CommitTransactionTaskImpl
   * @see ewe.impl.EwePackageImpl#getCommitTransactionTask()
   * @generated
   */
  int COMMIT_TRANSACTION_TASK = 19;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMIT_TRANSACTION_TASK__NAME = EPSILON_TASK__NAME;

  /**
   * The feature id for the '<em><b>Follows</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMIT_TRANSACTION_TASK__FOLLOWS = EPSILON_TASK__FOLLOWS;

  /**
   * The feature id for the '<em><b>Follower</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMIT_TRANSACTION_TASK__FOLLOWER = EPSILON_TASK__FOLLOWER;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMIT_TRANSACTION_TASK__ATTRIBUTES = EPSILON_TASK__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Taskelements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMIT_TRANSACTION_TASK__TASKELEMENTS = EPSILON_TASK__TASKELEMENTS;

  /**
   * The number of structural features of the '<em>Commit Transaction Task</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMIT_TRANSACTION_TASK_FEATURE_COUNT = EPSILON_TASK_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link ewe.impl.TargetImpl <em>Target</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ewe.impl.TargetImpl
   * @see ewe.impl.EwePackageImpl#getTarget()
   * @generated
   */
  int TARGET = 20;

  /**
   * The feature id for the '<em><b>Target Tasks</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET__TARGET_TASKS = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET__NAME = 1;

  /**
   * The feature id for the '<em><b>Containing Project</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET__CONTAINING_PROJECT = 2;

  /**
   * The feature id for the '<em><b>Depends</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET__DEPENDS = 3;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET__DESCRIPTION = 4;

  /**
   * The number of structural features of the '<em>Target</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link ewe.impl.LoadEMFModelTaskImpl <em>Load EMF Model Task</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ewe.impl.LoadEMFModelTaskImpl
   * @see ewe.impl.EwePackageImpl#getLoadEMFModelTask()
   * @generated
   */
  int LOAD_EMF_MODEL_TASK = 21;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOAD_EMF_MODEL_TASK__NAME = LOAD_MODEL_TASK__NAME;

  /**
   * The feature id for the '<em><b>Follows</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOAD_EMF_MODEL_TASK__FOLLOWS = LOAD_MODEL_TASK__FOLLOWS;

  /**
   * The feature id for the '<em><b>Follower</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOAD_EMF_MODEL_TASK__FOLLOWER = LOAD_MODEL_TASK__FOLLOWER;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOAD_EMF_MODEL_TASK__ATTRIBUTES = LOAD_MODEL_TASK__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Taskelements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOAD_EMF_MODEL_TASK__TASKELEMENTS = LOAD_MODEL_TASK__TASKELEMENTS;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOAD_EMF_MODEL_TASK__PARAMETERS = LOAD_MODEL_TASK__PARAMETERS;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOAD_EMF_MODEL_TASK__TYPE = LOAD_MODEL_TASK__TYPE;

  /**
   * The feature id for the '<em><b>Model File</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOAD_EMF_MODEL_TASK__MODEL_FILE = LOAD_MODEL_TASK_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Metamodel File</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOAD_EMF_MODEL_TASK__METAMODEL_FILE = LOAD_MODEL_TASK_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Is Metamodel File Based</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOAD_EMF_MODEL_TASK__IS_METAMODEL_FILE_BASED = LOAD_MODEL_TASK_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Read On Load</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOAD_EMF_MODEL_TASK__READ_ON_LOAD = LOAD_MODEL_TASK_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Metamodel Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOAD_EMF_MODEL_TASK__METAMODEL_URI = LOAD_MODEL_TASK_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Store On Disposal</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOAD_EMF_MODEL_TASK__STORE_ON_DISPOSAL = LOAD_MODEL_TASK_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Load EMF Model Task</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOAD_EMF_MODEL_TASK_FEATURE_COUNT = LOAD_MODEL_TASK_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '{@link ewe.impl.AttributeImpl <em>Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ewe.impl.AttributeImpl
   * @see ewe.impl.EwePackageImpl#getAttribute()
   * @generated
   */
  int ATTRIBUTE = 22;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__VALUE = 1;

  /**
   * The number of structural features of the '<em>Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link ewe.impl.NestedElementImpl <em>Nested Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ewe.impl.NestedElementImpl
   * @see ewe.impl.EwePackageImpl#getNestedElement()
   * @generated
   */
  int NESTED_ELEMENT = 23;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_ELEMENT__NAME = TASK__NAME;

  /**
   * The feature id for the '<em><b>Follows</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_ELEMENT__FOLLOWS = TASK__FOLLOWS;

  /**
   * The feature id for the '<em><b>Follower</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_ELEMENT__FOLLOWER = TASK__FOLLOWER;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_ELEMENT__ATTRIBUTES = TASK__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Taskelements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_ELEMENT__TASKELEMENTS = TASK__TASKELEMENTS;

  /**
   * The number of structural features of the '<em>Nested Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_ELEMENT_FEATURE_COUNT = TASK_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link ewe.impl.FlockTaskImpl <em>Flock Task</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ewe.impl.FlockTaskImpl
   * @see ewe.impl.EwePackageImpl#getFlockTask()
   * @generated
   */
  int FLOCK_TASK = 24;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOCK_TASK__NAME = EXECUTABLE_MODEL_TASK__NAME;

  /**
   * The feature id for the '<em><b>Follows</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOCK_TASK__FOLLOWS = EXECUTABLE_MODEL_TASK__FOLLOWS;

  /**
   * The feature id for the '<em><b>Follower</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOCK_TASK__FOLLOWER = EXECUTABLE_MODEL_TASK__FOLLOWER;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOCK_TASK__ATTRIBUTES = EXECUTABLE_MODEL_TASK__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Taskelements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOCK_TASK__TASKELEMENTS = EXECUTABLE_MODEL_TASK__TASKELEMENTS;

  /**
   * The feature id for the '<em><b>Src</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOCK_TASK__SRC = EXECUTABLE_MODEL_TASK__SRC;

  /**
   * The feature id for the '<em><b>Exports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOCK_TASK__EXPORTS = EXECUTABLE_MODEL_TASK__EXPORTS;

  /**
   * The feature id for the '<em><b>Uses</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOCK_TASK__USES = EXECUTABLE_MODEL_TASK__USES;

  /**
   * The feature id for the '<em><b>Models</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOCK_TASK__MODELS = EXECUTABLE_MODEL_TASK__MODELS;

  /**
   * The feature id for the '<em><b>Original Model</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOCK_TASK__ORIGINAL_MODEL = EXECUTABLE_MODEL_TASK_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Migrated Model</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOCK_TASK__MIGRATED_MODEL = EXECUTABLE_MODEL_TASK_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Flock Task</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOCK_TASK_FEATURE_COUNT = EXECUTABLE_MODEL_TASK_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link ewe.impl.EUnitTaskImpl <em>EUnit Task</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ewe.impl.EUnitTaskImpl
   * @see ewe.impl.EwePackageImpl#getEUnitTask()
   * @generated
   */
  int EUNIT_TASK = 25;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EUNIT_TASK__NAME = EXECUTABLE_MODEL_TASK__NAME;

  /**
   * The feature id for the '<em><b>Follows</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EUNIT_TASK__FOLLOWS = EXECUTABLE_MODEL_TASK__FOLLOWS;

  /**
   * The feature id for the '<em><b>Follower</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EUNIT_TASK__FOLLOWER = EXECUTABLE_MODEL_TASK__FOLLOWER;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EUNIT_TASK__ATTRIBUTES = EXECUTABLE_MODEL_TASK__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Taskelements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EUNIT_TASK__TASKELEMENTS = EXECUTABLE_MODEL_TASK__TASKELEMENTS;

  /**
   * The feature id for the '<em><b>Src</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EUNIT_TASK__SRC = EXECUTABLE_MODEL_TASK__SRC;

  /**
   * The feature id for the '<em><b>Exports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EUNIT_TASK__EXPORTS = EXECUTABLE_MODEL_TASK__EXPORTS;

  /**
   * The feature id for the '<em><b>Uses</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EUNIT_TASK__USES = EXECUTABLE_MODEL_TASK__USES;

  /**
   * The feature id for the '<em><b>Models</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EUNIT_TASK__MODELS = EXECUTABLE_MODEL_TASK__MODELS;

  /**
   * The feature id for the '<em><b>Fail On Errors</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EUNIT_TASK__FAIL_ON_ERRORS = EXECUTABLE_MODEL_TASK_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Report</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EUNIT_TASK__REPORT = EXECUTABLE_MODEL_TASK_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>To Dir</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EUNIT_TASK__TO_DIR = EXECUTABLE_MODEL_TASK_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Package</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EUNIT_TASK__PACKAGE = EXECUTABLE_MODEL_TASK_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>EUnit Task</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EUNIT_TASK_FEATURE_COUNT = EXECUTABLE_MODEL_TASK_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link ewe.impl.EclTaskImpl <em>Ecl Task</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ewe.impl.EclTaskImpl
   * @see ewe.impl.EwePackageImpl#getEclTask()
   * @generated
   */
  int ECL_TASK = 26;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ECL_TASK__NAME = EXECUTABLE_MODEL_TASK__NAME;

  /**
   * The feature id for the '<em><b>Follows</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ECL_TASK__FOLLOWS = EXECUTABLE_MODEL_TASK__FOLLOWS;

  /**
   * The feature id for the '<em><b>Follower</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ECL_TASK__FOLLOWER = EXECUTABLE_MODEL_TASK__FOLLOWER;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ECL_TASK__ATTRIBUTES = EXECUTABLE_MODEL_TASK__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Taskelements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ECL_TASK__TASKELEMENTS = EXECUTABLE_MODEL_TASK__TASKELEMENTS;

  /**
   * The feature id for the '<em><b>Src</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ECL_TASK__SRC = EXECUTABLE_MODEL_TASK__SRC;

  /**
   * The feature id for the '<em><b>Exports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ECL_TASK__EXPORTS = EXECUTABLE_MODEL_TASK__EXPORTS;

  /**
   * The feature id for the '<em><b>Uses</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ECL_TASK__USES = EXECUTABLE_MODEL_TASK__USES;

  /**
   * The feature id for the '<em><b>Models</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ECL_TASK__MODELS = EXECUTABLE_MODEL_TASK__MODELS;

  /**
   * The feature id for the '<em><b>Use Match Trace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ECL_TASK__USE_MATCH_TRACE = EXECUTABLE_MODEL_TASK_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Export Match Trace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ECL_TASK__EXPORT_MATCH_TRACE = EXECUTABLE_MODEL_TASK_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Ecl Task</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ECL_TASK_FEATURE_COUNT = EXECUTABLE_MODEL_TASK_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link ewe.impl.DisposeModelsTaskImpl <em>Dispose Models Task</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ewe.impl.DisposeModelsTaskImpl
   * @see ewe.impl.EwePackageImpl#getDisposeModelsTask()
   * @generated
   */
  int DISPOSE_MODELS_TASK = 27;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPOSE_MODELS_TASK__NAME = EPSILON_TASK__NAME;

  /**
   * The feature id for the '<em><b>Follows</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPOSE_MODELS_TASK__FOLLOWS = EPSILON_TASK__FOLLOWS;

  /**
   * The feature id for the '<em><b>Follower</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPOSE_MODELS_TASK__FOLLOWER = EPSILON_TASK__FOLLOWER;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPOSE_MODELS_TASK__ATTRIBUTES = EPSILON_TASK__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Taskelements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPOSE_MODELS_TASK__TASKELEMENTS = EPSILON_TASK__TASKELEMENTS;

  /**
   * The number of structural features of the '<em>Dispose Models Task</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPOSE_MODELS_TASK_FEATURE_COUNT = EPSILON_TASK_FEATURE_COUNT + 0;


  /**
   * Returns the meta object for class '{@link ewe.Project <em>Project</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Project</em>'.
   * @see ewe.Project
   * @generated
   */
  EClass getProject();

  /**
   * Returns the meta object for the attribute '{@link ewe.Project#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see ewe.Project#getName()
   * @see #getProject()
   * @generated
   */
  EAttribute getProject_Name();

  /**
   * Returns the meta object for the containment reference list '{@link ewe.Project#getTargets <em>Targets</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Targets</em>'.
   * @see ewe.Project#getTargets()
   * @see #getProject()
   * @generated
   */
  EReference getProject_Targets();

  /**
   * Returns the meta object for the reference '{@link ewe.Project#getDefaultTarget <em>Default Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Default Target</em>'.
   * @see ewe.Project#getDefaultTarget()
   * @see #getProject()
   * @generated
   */
  EReference getProject_DefaultTarget();

  /**
   * Returns the meta object for class '{@link ewe.Task <em>Task</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Task</em>'.
   * @see ewe.Task
   * @generated
   */
  EClass getTask();

  /**
   * Returns the meta object for the attribute '{@link ewe.Task#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see ewe.Task#getName()
   * @see #getTask()
   * @generated
   */
  EAttribute getTask_Name();

  /**
   * Returns the meta object for the reference '{@link ewe.Task#getFollows <em>Follows</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Follows</em>'.
   * @see ewe.Task#getFollows()
   * @see #getTask()
   * @generated
   */
  EReference getTask_Follows();

  /**
   * Returns the meta object for the reference '{@link ewe.Task#getFollower <em>Follower</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Follower</em>'.
   * @see ewe.Task#getFollower()
   * @see #getTask()
   * @generated
   */
  EReference getTask_Follower();

  /**
   * Returns the meta object for the containment reference list '{@link ewe.Task#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see ewe.Task#getAttributes()
   * @see #getTask()
   * @generated
   */
  EReference getTask_Attributes();

  /**
   * Returns the meta object for the containment reference list '{@link ewe.Task#getTaskelements <em>Taskelements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Taskelements</em>'.
   * @see ewe.Task#getTaskelements()
   * @see #getTask()
   * @generated
   */
  EReference getTask_Taskelements();

  /**
   * Returns the meta object for class '{@link ewe.EpsilonTask <em>Epsilon Task</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Epsilon Task</em>'.
   * @see ewe.EpsilonTask
   * @generated
   */
  EClass getEpsilonTask();

  /**
   * Returns the meta object for class '{@link ewe.LoadModelTask <em>Load Model Task</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Load Model Task</em>'.
   * @see ewe.LoadModelTask
   * @generated
   */
  EClass getLoadModelTask();

  /**
   * Returns the meta object for the containment reference list '{@link ewe.LoadModelTask#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see ewe.LoadModelTask#getParameters()
   * @see #getLoadModelTask()
   * @generated
   */
  EReference getLoadModelTask_Parameters();

  /**
   * Returns the meta object for the attribute '{@link ewe.LoadModelTask#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see ewe.LoadModelTask#getType()
   * @see #getLoadModelTask()
   * @generated
   */
  EAttribute getLoadModelTask_Type();

  /**
   * Returns the meta object for class '{@link ewe.StoreModelTask <em>Store Model Task</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Store Model Task</em>'.
   * @see ewe.StoreModelTask
   * @generated
   */
  EClass getStoreModelTask();

  /**
   * Returns the meta object for the attribute '{@link ewe.StoreModelTask#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Model</em>'.
   * @see ewe.StoreModelTask#getModel()
   * @see #getStoreModelTask()
   * @generated
   */
  EAttribute getStoreModelTask_Model();

  /**
   * Returns the meta object for the attribute '{@link ewe.StoreModelTask#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Target</em>'.
   * @see ewe.StoreModelTask#getTarget()
   * @see #getStoreModelTask()
   * @generated
   */
  EAttribute getStoreModelTask_Target();

  /**
   * Returns the meta object for class '{@link ewe.ParameterNestedElement <em>Parameter Nested Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter Nested Element</em>'.
   * @see ewe.ParameterNestedElement
   * @generated
   */
  EClass getParameterNestedElement();

  /**
   * Returns the meta object for the attribute '{@link ewe.ParameterNestedElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see ewe.ParameterNestedElement#getName()
   * @see #getParameterNestedElement()
   * @generated
   */
  EAttribute getParameterNestedElement_Name();

  /**
   * Returns the meta object for the attribute '{@link ewe.ParameterNestedElement#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see ewe.ParameterNestedElement#getValue()
   * @see #getParameterNestedElement()
   * @generated
   */
  EAttribute getParameterNestedElement_Value();

  /**
   * Returns the meta object for class '{@link ewe.VariableNestedElement <em>Variable Nested Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Nested Element</em>'.
   * @see ewe.VariableNestedElement
   * @generated
   */
  EClass getVariableNestedElement();

  /**
   * Returns the meta object for the attribute '{@link ewe.VariableNestedElement#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ref</em>'.
   * @see ewe.VariableNestedElement#getRef()
   * @see #getVariableNestedElement()
   * @generated
   */
  EAttribute getVariableNestedElement_Ref();

  /**
   * Returns the meta object for the attribute '{@link ewe.VariableNestedElement#getAs <em>As</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>As</em>'.
   * @see ewe.VariableNestedElement#getAs()
   * @see #getVariableNestedElement()
   * @generated
   */
  EAttribute getVariableNestedElement_As();

  /**
   * Returns the meta object for the attribute '{@link ewe.VariableNestedElement#getOptional <em>Optional</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Optional</em>'.
   * @see ewe.VariableNestedElement#getOptional()
   * @see #getVariableNestedElement()
   * @generated
   */
  EAttribute getVariableNestedElement_Optional();

  /**
   * Returns the meta object for class '{@link ewe.ExportsNestedElement <em>Exports Nested Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Exports Nested Element</em>'.
   * @see ewe.ExportsNestedElement
   * @generated
   */
  EClass getExportsNestedElement();

  /**
   * Returns the meta object for class '{@link ewe.UsesNestedElement <em>Uses Nested Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Uses Nested Element</em>'.
   * @see ewe.UsesNestedElement
   * @generated
   */
  EClass getUsesNestedElement();

  /**
   * Returns the meta object for class '{@link ewe.ModelNestedElement <em>Model Nested Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model Nested Element</em>'.
   * @see ewe.ModelNestedElement
   * @generated
   */
  EClass getModelNestedElement();

  /**
   * Returns the meta object for the attribute '{@link ewe.ModelNestedElement#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ref</em>'.
   * @see ewe.ModelNestedElement#getRef()
   * @see #getModelNestedElement()
   * @generated
   */
  EAttribute getModelNestedElement_Ref();

  /**
   * Returns the meta object for the attribute '{@link ewe.ModelNestedElement#getAs <em>As</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>As</em>'.
   * @see ewe.ModelNestedElement#getAs()
   * @see #getModelNestedElement()
   * @generated
   */
  EAttribute getModelNestedElement_As();

  /**
   * Returns the meta object for class '{@link ewe.ExecutableModelTask <em>Executable Model Task</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Executable Model Task</em>'.
   * @see ewe.ExecutableModelTask
   * @generated
   */
  EClass getExecutableModelTask();

  /**
   * Returns the meta object for the attribute '{@link ewe.ExecutableModelTask#getSrc <em>Src</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Src</em>'.
   * @see ewe.ExecutableModelTask#getSrc()
   * @see #getExecutableModelTask()
   * @generated
   */
  EAttribute getExecutableModelTask_Src();

  /**
   * Returns the meta object for the containment reference list '{@link ewe.ExecutableModelTask#getExports <em>Exports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exports</em>'.
   * @see ewe.ExecutableModelTask#getExports()
   * @see #getExecutableModelTask()
   * @generated
   */
  EReference getExecutableModelTask_Exports();

  /**
   * Returns the meta object for the containment reference list '{@link ewe.ExecutableModelTask#getUses <em>Uses</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Uses</em>'.
   * @see ewe.ExecutableModelTask#getUses()
   * @see #getExecutableModelTask()
   * @generated
   */
  EReference getExecutableModelTask_Uses();

  /**
   * Returns the meta object for the containment reference list '{@link ewe.ExecutableModelTask#getModels <em>Models</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Models</em>'.
   * @see ewe.ExecutableModelTask#getModels()
   * @see #getExecutableModelTask()
   * @generated
   */
  EReference getExecutableModelTask_Models();

  /**
   * Returns the meta object for class '{@link ewe.RollbackTransactionTask <em>Rollback Transaction Task</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rollback Transaction Task</em>'.
   * @see ewe.RollbackTransactionTask
   * @generated
   */
  EClass getRollbackTransactionTask();

  /**
   * Returns the meta object for class '{@link ewe.DisposeModelTask <em>Dispose Model Task</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Dispose Model Task</em>'.
   * @see ewe.DisposeModelTask
   * @generated
   */
  EClass getDisposeModelTask();

  /**
   * Returns the meta object for the attribute '{@link ewe.DisposeModelTask#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Model</em>'.
   * @see ewe.DisposeModelTask#getModel()
   * @see #getDisposeModelTask()
   * @generated
   */
  EAttribute getDisposeModelTask_Model();

  /**
   * Returns the meta object for class '{@link ewe.StartTransactionTask <em>Start Transaction Task</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Start Transaction Task</em>'.
   * @see ewe.StartTransactionTask
   * @generated
   */
  EClass getStartTransactionTask();

  /**
   * Returns the meta object for the attribute list '{@link ewe.StartTransactionTask#getModels <em>Models</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Models</em>'.
   * @see ewe.StartTransactionTask#getModels()
   * @see #getStartTransactionTask()
   * @generated
   */
  EAttribute getStartTransactionTask_Models();

  /**
   * Returns the meta object for class '{@link ewe.EolTask <em>Eol Task</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Eol Task</em>'.
   * @see ewe.EolTask
   * @generated
   */
  EClass getEolTask();

  /**
   * Returns the meta object for class '{@link ewe.EmlTask <em>Eml Task</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Eml Task</em>'.
   * @see ewe.EmlTask
   * @generated
   */
  EClass getEmlTask();

  /**
   * Returns the meta object for the attribute '{@link ewe.EmlTask#getUseMatchTrace <em>Use Match Trace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Use Match Trace</em>'.
   * @see ewe.EmlTask#getUseMatchTrace()
   * @see #getEmlTask()
   * @generated
   */
  EAttribute getEmlTask_UseMatchTrace();

  /**
   * Returns the meta object for the attribute '{@link ewe.EmlTask#getExportTransformationTrace <em>Export Transformation Trace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Export Transformation Trace</em>'.
   * @see ewe.EmlTask#getExportTransformationTrace()
   * @see #getEmlTask()
   * @generated
   */
  EAttribute getEmlTask_ExportTransformationTrace();

  /**
   * Returns the meta object for the attribute '{@link ewe.EmlTask#getExportMergeTrace <em>Export Merge Trace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Export Merge Trace</em>'.
   * @see ewe.EmlTask#getExportMergeTrace()
   * @see #getEmlTask()
   * @generated
   */
  EAttribute getEmlTask_ExportMergeTrace();

  /**
   * Returns the meta object for class '{@link ewe.EglTask <em>Egl Task</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Egl Task</em>'.
   * @see ewe.EglTask
   * @generated
   */
  EClass getEglTask();

  /**
   * Returns the meta object for the attribute '{@link ewe.EglTask#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Target</em>'.
   * @see ewe.EglTask#getTarget()
   * @see #getEglTask()
   * @generated
   */
  EAttribute getEglTask_Target();

  /**
   * Returns the meta object for class '{@link ewe.EtlTask <em>Etl Task</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Etl Task</em>'.
   * @see ewe.EtlTask
   * @generated
   */
  EClass getEtlTask();

  /**
   * Returns the meta object for the attribute '{@link ewe.EtlTask#getExportTransformationTrace <em>Export Transformation Trace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Export Transformation Trace</em>'.
   * @see ewe.EtlTask#getExportTransformationTrace()
   * @see #getEtlTask()
   * @generated
   */
  EAttribute getEtlTask_ExportTransformationTrace();

  /**
   * Returns the meta object for class '{@link ewe.EvlTask <em>Evl Task</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Evl Task</em>'.
   * @see ewe.EvlTask
   * @generated
   */
  EClass getEvlTask();

  /**
   * Returns the meta object for the attribute '{@link ewe.EvlTask#isFailOnErrors <em>Fail On Errors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Fail On Errors</em>'.
   * @see ewe.EvlTask#isFailOnErrors()
   * @see #getEvlTask()
   * @generated
   */
  EAttribute getEvlTask_FailOnErrors();

  /**
   * Returns the meta object for the attribute '{@link ewe.EvlTask#isFailOnWarnings <em>Fail On Warnings</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Fail On Warnings</em>'.
   * @see ewe.EvlTask#isFailOnWarnings()
   * @see #getEvlTask()
   * @generated
   */
  EAttribute getEvlTask_FailOnWarnings();

  /**
   * Returns the meta object for the attribute '{@link ewe.EvlTask#isExportAsModel <em>Export As Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Export As Model</em>'.
   * @see ewe.EvlTask#isExportAsModel()
   * @see #getEvlTask()
   * @generated
   */
  EAttribute getEvlTask_ExportAsModel();

  /**
   * Returns the meta object for the attribute '{@link ewe.EvlTask#getExportConstraintTrace <em>Export Constraint Trace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Export Constraint Trace</em>'.
   * @see ewe.EvlTask#getExportConstraintTrace()
   * @see #getEvlTask()
   * @generated
   */
  EAttribute getEvlTask_ExportConstraintTrace();

  /**
   * Returns the meta object for class '{@link ewe.CommitTransactionTask <em>Commit Transaction Task</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Commit Transaction Task</em>'.
   * @see ewe.CommitTransactionTask
   * @generated
   */
  EClass getCommitTransactionTask();

  /**
   * Returns the meta object for class '{@link ewe.Target <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Target</em>'.
   * @see ewe.Target
   * @generated
   */
  EClass getTarget();

  /**
   * Returns the meta object for the containment reference list '{@link ewe.Target#getTargetTasks <em>Target Tasks</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Target Tasks</em>'.
   * @see ewe.Target#getTargetTasks()
   * @see #getTarget()
   * @generated
   */
  EReference getTarget_TargetTasks();

  /**
   * Returns the meta object for the attribute '{@link ewe.Target#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see ewe.Target#getName()
   * @see #getTarget()
   * @generated
   */
  EAttribute getTarget_Name();

  /**
   * Returns the meta object for the container reference '{@link ewe.Target#getContainingProject <em>Containing Project</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Containing Project</em>'.
   * @see ewe.Target#getContainingProject()
   * @see #getTarget()
   * @generated
   */
  EReference getTarget_ContainingProject();

  /**
   * Returns the meta object for the reference list '{@link ewe.Target#getDepends <em>Depends</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Depends</em>'.
   * @see ewe.Target#getDepends()
   * @see #getTarget()
   * @generated
   */
  EReference getTarget_Depends();

  /**
   * Returns the meta object for the attribute '{@link ewe.Target#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see ewe.Target#getDescription()
   * @see #getTarget()
   * @generated
   */
  EAttribute getTarget_Description();

  /**
   * Returns the meta object for class '{@link ewe.LoadEMFModelTask <em>Load EMF Model Task</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Load EMF Model Task</em>'.
   * @see ewe.LoadEMFModelTask
   * @generated
   */
  EClass getLoadEMFModelTask();

  /**
   * Returns the meta object for the attribute '{@link ewe.LoadEMFModelTask#getModelFile <em>Model File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Model File</em>'.
   * @see ewe.LoadEMFModelTask#getModelFile()
   * @see #getLoadEMFModelTask()
   * @generated
   */
  EAttribute getLoadEMFModelTask_ModelFile();

  /**
   * Returns the meta object for the attribute '{@link ewe.LoadEMFModelTask#getMetamodelFile <em>Metamodel File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Metamodel File</em>'.
   * @see ewe.LoadEMFModelTask#getMetamodelFile()
   * @see #getLoadEMFModelTask()
   * @generated
   */
  EAttribute getLoadEMFModelTask_MetamodelFile();

  /**
   * Returns the meta object for the attribute '{@link ewe.LoadEMFModelTask#isIsMetamodelFileBased <em>Is Metamodel File Based</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Metamodel File Based</em>'.
   * @see ewe.LoadEMFModelTask#isIsMetamodelFileBased()
   * @see #getLoadEMFModelTask()
   * @generated
   */
  EAttribute getLoadEMFModelTask_IsMetamodelFileBased();

  /**
   * Returns the meta object for the attribute '{@link ewe.LoadEMFModelTask#isReadOnLoad <em>Read On Load</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Read On Load</em>'.
   * @see ewe.LoadEMFModelTask#isReadOnLoad()
   * @see #getLoadEMFModelTask()
   * @generated
   */
  EAttribute getLoadEMFModelTask_ReadOnLoad();

  /**
   * Returns the meta object for the attribute '{@link ewe.LoadEMFModelTask#getMetamodelUri <em>Metamodel Uri</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Metamodel Uri</em>'.
   * @see ewe.LoadEMFModelTask#getMetamodelUri()
   * @see #getLoadEMFModelTask()
   * @generated
   */
  EAttribute getLoadEMFModelTask_MetamodelUri();

  /**
   * Returns the meta object for the attribute '{@link ewe.LoadEMFModelTask#isStoreOnDisposal <em>Store On Disposal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Store On Disposal</em>'.
   * @see ewe.LoadEMFModelTask#isStoreOnDisposal()
   * @see #getLoadEMFModelTask()
   * @generated
   */
  EAttribute getLoadEMFModelTask_StoreOnDisposal();

  /**
   * Returns the meta object for class '{@link ewe.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute</em>'.
   * @see ewe.Attribute
   * @generated
   */
  EClass getAttribute();

  /**
   * Returns the meta object for the attribute '{@link ewe.Attribute#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see ewe.Attribute#getName()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_Name();

  /**
   * Returns the meta object for the attribute '{@link ewe.Attribute#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see ewe.Attribute#getValue()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_Value();

  /**
   * Returns the meta object for class '{@link ewe.NestedElement <em>Nested Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Nested Element</em>'.
   * @see ewe.NestedElement
   * @generated
   */
  EClass getNestedElement();

  /**
   * Returns the meta object for class '{@link ewe.FlockTask <em>Flock Task</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Flock Task</em>'.
   * @see ewe.FlockTask
   * @generated
   */
  EClass getFlockTask();

  /**
   * Returns the meta object for the attribute '{@link ewe.FlockTask#getOriginalModel <em>Original Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Original Model</em>'.
   * @see ewe.FlockTask#getOriginalModel()
   * @see #getFlockTask()
   * @generated
   */
  EAttribute getFlockTask_OriginalModel();

  /**
   * Returns the meta object for the attribute '{@link ewe.FlockTask#getMigratedModel <em>Migrated Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Migrated Model</em>'.
   * @see ewe.FlockTask#getMigratedModel()
   * @see #getFlockTask()
   * @generated
   */
  EAttribute getFlockTask_MigratedModel();

  /**
   * Returns the meta object for class '{@link ewe.EUnitTask <em>EUnit Task</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>EUnit Task</em>'.
   * @see ewe.EUnitTask
   * @generated
   */
  EClass getEUnitTask();

  /**
   * Returns the meta object for the attribute '{@link ewe.EUnitTask#isFailOnErrors <em>Fail On Errors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Fail On Errors</em>'.
   * @see ewe.EUnitTask#isFailOnErrors()
   * @see #getEUnitTask()
   * @generated
   */
  EAttribute getEUnitTask_FailOnErrors();

  /**
   * Returns the meta object for the attribute '{@link ewe.EUnitTask#getReport <em>Report</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Report</em>'.
   * @see ewe.EUnitTask#getReport()
   * @see #getEUnitTask()
   * @generated
   */
  EAttribute getEUnitTask_Report();

  /**
   * Returns the meta object for the attribute '{@link ewe.EUnitTask#getToDir <em>To Dir</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>To Dir</em>'.
   * @see ewe.EUnitTask#getToDir()
   * @see #getEUnitTask()
   * @generated
   */
  EAttribute getEUnitTask_ToDir();

  /**
   * Returns the meta object for the attribute '{@link ewe.EUnitTask#getPackage <em>Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Package</em>'.
   * @see ewe.EUnitTask#getPackage()
   * @see #getEUnitTask()
   * @generated
   */
  EAttribute getEUnitTask_Package();

  /**
   * Returns the meta object for class '{@link ewe.EclTask <em>Ecl Task</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ecl Task</em>'.
   * @see ewe.EclTask
   * @generated
   */
  EClass getEclTask();

  /**
   * Returns the meta object for the attribute '{@link ewe.EclTask#getUseMatchTrace <em>Use Match Trace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Use Match Trace</em>'.
   * @see ewe.EclTask#getUseMatchTrace()
   * @see #getEclTask()
   * @generated
   */
  EAttribute getEclTask_UseMatchTrace();

  /**
   * Returns the meta object for the attribute '{@link ewe.EclTask#getExportMatchTrace <em>Export Match Trace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Export Match Trace</em>'.
   * @see ewe.EclTask#getExportMatchTrace()
   * @see #getEclTask()
   * @generated
   */
  EAttribute getEclTask_ExportMatchTrace();

  /**
   * Returns the meta object for class '{@link ewe.DisposeModelsTask <em>Dispose Models Task</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Dispose Models Task</em>'.
   * @see ewe.DisposeModelsTask
   * @generated
   */
  EClass getDisposeModelsTask();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  EweFactory getEweFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link ewe.impl.ProjectImpl <em>Project</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ewe.impl.ProjectImpl
     * @see ewe.impl.EwePackageImpl#getProject()
     * @generated
     */
    EClass PROJECT = eINSTANCE.getProject();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROJECT__NAME = eINSTANCE.getProject_Name();

    /**
     * The meta object literal for the '<em><b>Targets</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROJECT__TARGETS = eINSTANCE.getProject_Targets();

    /**
     * The meta object literal for the '<em><b>Default Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROJECT__DEFAULT_TARGET = eINSTANCE.getProject_DefaultTarget();

    /**
     * The meta object literal for the '{@link ewe.impl.TaskImpl <em>Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ewe.impl.TaskImpl
     * @see ewe.impl.EwePackageImpl#getTask()
     * @generated
     */
    EClass TASK = eINSTANCE.getTask();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TASK__NAME = eINSTANCE.getTask_Name();

    /**
     * The meta object literal for the '<em><b>Follows</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TASK__FOLLOWS = eINSTANCE.getTask_Follows();

    /**
     * The meta object literal for the '<em><b>Follower</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TASK__FOLLOWER = eINSTANCE.getTask_Follower();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TASK__ATTRIBUTES = eINSTANCE.getTask_Attributes();

    /**
     * The meta object literal for the '<em><b>Taskelements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TASK__TASKELEMENTS = eINSTANCE.getTask_Taskelements();

    /**
     * The meta object literal for the '{@link ewe.impl.EpsilonTaskImpl <em>Epsilon Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ewe.impl.EpsilonTaskImpl
     * @see ewe.impl.EwePackageImpl#getEpsilonTask()
     * @generated
     */
    EClass EPSILON_TASK = eINSTANCE.getEpsilonTask();

    /**
     * The meta object literal for the '{@link ewe.impl.LoadModelTaskImpl <em>Load Model Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ewe.impl.LoadModelTaskImpl
     * @see ewe.impl.EwePackageImpl#getLoadModelTask()
     * @generated
     */
    EClass LOAD_MODEL_TASK = eINSTANCE.getLoadModelTask();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOAD_MODEL_TASK__PARAMETERS = eINSTANCE.getLoadModelTask_Parameters();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOAD_MODEL_TASK__TYPE = eINSTANCE.getLoadModelTask_Type();

    /**
     * The meta object literal for the '{@link ewe.impl.StoreModelTaskImpl <em>Store Model Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ewe.impl.StoreModelTaskImpl
     * @see ewe.impl.EwePackageImpl#getStoreModelTask()
     * @generated
     */
    EClass STORE_MODEL_TASK = eINSTANCE.getStoreModelTask();

    /**
     * The meta object literal for the '<em><b>Model</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STORE_MODEL_TASK__MODEL = eINSTANCE.getStoreModelTask_Model();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STORE_MODEL_TASK__TARGET = eINSTANCE.getStoreModelTask_Target();

    /**
     * The meta object literal for the '{@link ewe.impl.ParameterNestedElementImpl <em>Parameter Nested Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ewe.impl.ParameterNestedElementImpl
     * @see ewe.impl.EwePackageImpl#getParameterNestedElement()
     * @generated
     */
    EClass PARAMETER_NESTED_ELEMENT = eINSTANCE.getParameterNestedElement();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAMETER_NESTED_ELEMENT__NAME = eINSTANCE.getParameterNestedElement_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAMETER_NESTED_ELEMENT__VALUE = eINSTANCE.getParameterNestedElement_Value();

    /**
     * The meta object literal for the '{@link ewe.impl.VariableNestedElementImpl <em>Variable Nested Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ewe.impl.VariableNestedElementImpl
     * @see ewe.impl.EwePackageImpl#getVariableNestedElement()
     * @generated
     */
    EClass VARIABLE_NESTED_ELEMENT = eINSTANCE.getVariableNestedElement();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_NESTED_ELEMENT__REF = eINSTANCE.getVariableNestedElement_Ref();

    /**
     * The meta object literal for the '<em><b>As</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_NESTED_ELEMENT__AS = eINSTANCE.getVariableNestedElement_As();

    /**
     * The meta object literal for the '<em><b>Optional</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_NESTED_ELEMENT__OPTIONAL = eINSTANCE.getVariableNestedElement_Optional();

    /**
     * The meta object literal for the '{@link ewe.impl.ExportsNestedElementImpl <em>Exports Nested Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ewe.impl.ExportsNestedElementImpl
     * @see ewe.impl.EwePackageImpl#getExportsNestedElement()
     * @generated
     */
    EClass EXPORTS_NESTED_ELEMENT = eINSTANCE.getExportsNestedElement();

    /**
     * The meta object literal for the '{@link ewe.impl.UsesNestedElementImpl <em>Uses Nested Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ewe.impl.UsesNestedElementImpl
     * @see ewe.impl.EwePackageImpl#getUsesNestedElement()
     * @generated
     */
    EClass USES_NESTED_ELEMENT = eINSTANCE.getUsesNestedElement();

    /**
     * The meta object literal for the '{@link ewe.impl.ModelNestedElementImpl <em>Model Nested Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ewe.impl.ModelNestedElementImpl
     * @see ewe.impl.EwePackageImpl#getModelNestedElement()
     * @generated
     */
    EClass MODEL_NESTED_ELEMENT = eINSTANCE.getModelNestedElement();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_NESTED_ELEMENT__REF = eINSTANCE.getModelNestedElement_Ref();

    /**
     * The meta object literal for the '<em><b>As</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_NESTED_ELEMENT__AS = eINSTANCE.getModelNestedElement_As();

    /**
     * The meta object literal for the '{@link ewe.impl.ExecutableModelTaskImpl <em>Executable Model Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ewe.impl.ExecutableModelTaskImpl
     * @see ewe.impl.EwePackageImpl#getExecutableModelTask()
     * @generated
     */
    EClass EXECUTABLE_MODEL_TASK = eINSTANCE.getExecutableModelTask();

    /**
     * The meta object literal for the '<em><b>Src</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXECUTABLE_MODEL_TASK__SRC = eINSTANCE.getExecutableModelTask_Src();

    /**
     * The meta object literal for the '<em><b>Exports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXECUTABLE_MODEL_TASK__EXPORTS = eINSTANCE.getExecutableModelTask_Exports();

    /**
     * The meta object literal for the '<em><b>Uses</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXECUTABLE_MODEL_TASK__USES = eINSTANCE.getExecutableModelTask_Uses();

    /**
     * The meta object literal for the '<em><b>Models</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXECUTABLE_MODEL_TASK__MODELS = eINSTANCE.getExecutableModelTask_Models();

    /**
     * The meta object literal for the '{@link ewe.impl.RollbackTransactionTaskImpl <em>Rollback Transaction Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ewe.impl.RollbackTransactionTaskImpl
     * @see ewe.impl.EwePackageImpl#getRollbackTransactionTask()
     * @generated
     */
    EClass ROLLBACK_TRANSACTION_TASK = eINSTANCE.getRollbackTransactionTask();

    /**
     * The meta object literal for the '{@link ewe.impl.DisposeModelTaskImpl <em>Dispose Model Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ewe.impl.DisposeModelTaskImpl
     * @see ewe.impl.EwePackageImpl#getDisposeModelTask()
     * @generated
     */
    EClass DISPOSE_MODEL_TASK = eINSTANCE.getDisposeModelTask();

    /**
     * The meta object literal for the '<em><b>Model</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DISPOSE_MODEL_TASK__MODEL = eINSTANCE.getDisposeModelTask_Model();

    /**
     * The meta object literal for the '{@link ewe.impl.StartTransactionTaskImpl <em>Start Transaction Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ewe.impl.StartTransactionTaskImpl
     * @see ewe.impl.EwePackageImpl#getStartTransactionTask()
     * @generated
     */
    EClass START_TRANSACTION_TASK = eINSTANCE.getStartTransactionTask();

    /**
     * The meta object literal for the '<em><b>Models</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute START_TRANSACTION_TASK__MODELS = eINSTANCE.getStartTransactionTask_Models();

    /**
     * The meta object literal for the '{@link ewe.impl.EolTaskImpl <em>Eol Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ewe.impl.EolTaskImpl
     * @see ewe.impl.EwePackageImpl#getEolTask()
     * @generated
     */
    EClass EOL_TASK = eINSTANCE.getEolTask();

    /**
     * The meta object literal for the '{@link ewe.impl.EmlTaskImpl <em>Eml Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ewe.impl.EmlTaskImpl
     * @see ewe.impl.EwePackageImpl#getEmlTask()
     * @generated
     */
    EClass EML_TASK = eINSTANCE.getEmlTask();

    /**
     * The meta object literal for the '<em><b>Use Match Trace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EML_TASK__USE_MATCH_TRACE = eINSTANCE.getEmlTask_UseMatchTrace();

    /**
     * The meta object literal for the '<em><b>Export Transformation Trace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EML_TASK__EXPORT_TRANSFORMATION_TRACE = eINSTANCE.getEmlTask_ExportTransformationTrace();

    /**
     * The meta object literal for the '<em><b>Export Merge Trace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EML_TASK__EXPORT_MERGE_TRACE = eINSTANCE.getEmlTask_ExportMergeTrace();

    /**
     * The meta object literal for the '{@link ewe.impl.EglTaskImpl <em>Egl Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ewe.impl.EglTaskImpl
     * @see ewe.impl.EwePackageImpl#getEglTask()
     * @generated
     */
    EClass EGL_TASK = eINSTANCE.getEglTask();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EGL_TASK__TARGET = eINSTANCE.getEglTask_Target();

    /**
     * The meta object literal for the '{@link ewe.impl.EtlTaskImpl <em>Etl Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ewe.impl.EtlTaskImpl
     * @see ewe.impl.EwePackageImpl#getEtlTask()
     * @generated
     */
    EClass ETL_TASK = eINSTANCE.getEtlTask();

    /**
     * The meta object literal for the '<em><b>Export Transformation Trace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ETL_TASK__EXPORT_TRANSFORMATION_TRACE = eINSTANCE.getEtlTask_ExportTransformationTrace();

    /**
     * The meta object literal for the '{@link ewe.impl.EvlTaskImpl <em>Evl Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ewe.impl.EvlTaskImpl
     * @see ewe.impl.EwePackageImpl#getEvlTask()
     * @generated
     */
    EClass EVL_TASK = eINSTANCE.getEvlTask();

    /**
     * The meta object literal for the '<em><b>Fail On Errors</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVL_TASK__FAIL_ON_ERRORS = eINSTANCE.getEvlTask_FailOnErrors();

    /**
     * The meta object literal for the '<em><b>Fail On Warnings</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVL_TASK__FAIL_ON_WARNINGS = eINSTANCE.getEvlTask_FailOnWarnings();

    /**
     * The meta object literal for the '<em><b>Export As Model</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVL_TASK__EXPORT_AS_MODEL = eINSTANCE.getEvlTask_ExportAsModel();

    /**
     * The meta object literal for the '<em><b>Export Constraint Trace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVL_TASK__EXPORT_CONSTRAINT_TRACE = eINSTANCE.getEvlTask_ExportConstraintTrace();

    /**
     * The meta object literal for the '{@link ewe.impl.CommitTransactionTaskImpl <em>Commit Transaction Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ewe.impl.CommitTransactionTaskImpl
     * @see ewe.impl.EwePackageImpl#getCommitTransactionTask()
     * @generated
     */
    EClass COMMIT_TRANSACTION_TASK = eINSTANCE.getCommitTransactionTask();

    /**
     * The meta object literal for the '{@link ewe.impl.TargetImpl <em>Target</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ewe.impl.TargetImpl
     * @see ewe.impl.EwePackageImpl#getTarget()
     * @generated
     */
    EClass TARGET = eINSTANCE.getTarget();

    /**
     * The meta object literal for the '<em><b>Target Tasks</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TARGET__TARGET_TASKS = eINSTANCE.getTarget_TargetTasks();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TARGET__NAME = eINSTANCE.getTarget_Name();

    /**
     * The meta object literal for the '<em><b>Containing Project</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TARGET__CONTAINING_PROJECT = eINSTANCE.getTarget_ContainingProject();

    /**
     * The meta object literal for the '<em><b>Depends</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TARGET__DEPENDS = eINSTANCE.getTarget_Depends();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TARGET__DESCRIPTION = eINSTANCE.getTarget_Description();

    /**
     * The meta object literal for the '{@link ewe.impl.LoadEMFModelTaskImpl <em>Load EMF Model Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ewe.impl.LoadEMFModelTaskImpl
     * @see ewe.impl.EwePackageImpl#getLoadEMFModelTask()
     * @generated
     */
    EClass LOAD_EMF_MODEL_TASK = eINSTANCE.getLoadEMFModelTask();

    /**
     * The meta object literal for the '<em><b>Model File</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOAD_EMF_MODEL_TASK__MODEL_FILE = eINSTANCE.getLoadEMFModelTask_ModelFile();

    /**
     * The meta object literal for the '<em><b>Metamodel File</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOAD_EMF_MODEL_TASK__METAMODEL_FILE = eINSTANCE.getLoadEMFModelTask_MetamodelFile();

    /**
     * The meta object literal for the '<em><b>Is Metamodel File Based</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOAD_EMF_MODEL_TASK__IS_METAMODEL_FILE_BASED = eINSTANCE.getLoadEMFModelTask_IsMetamodelFileBased();

    /**
     * The meta object literal for the '<em><b>Read On Load</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOAD_EMF_MODEL_TASK__READ_ON_LOAD = eINSTANCE.getLoadEMFModelTask_ReadOnLoad();

    /**
     * The meta object literal for the '<em><b>Metamodel Uri</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOAD_EMF_MODEL_TASK__METAMODEL_URI = eINSTANCE.getLoadEMFModelTask_MetamodelUri();

    /**
     * The meta object literal for the '<em><b>Store On Disposal</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOAD_EMF_MODEL_TASK__STORE_ON_DISPOSAL = eINSTANCE.getLoadEMFModelTask_StoreOnDisposal();

    /**
     * The meta object literal for the '{@link ewe.impl.AttributeImpl <em>Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ewe.impl.AttributeImpl
     * @see ewe.impl.EwePackageImpl#getAttribute()
     * @generated
     */
    EClass ATTRIBUTE = eINSTANCE.getAttribute();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__NAME = eINSTANCE.getAttribute_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__VALUE = eINSTANCE.getAttribute_Value();

    /**
     * The meta object literal for the '{@link ewe.impl.NestedElementImpl <em>Nested Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ewe.impl.NestedElementImpl
     * @see ewe.impl.EwePackageImpl#getNestedElement()
     * @generated
     */
    EClass NESTED_ELEMENT = eINSTANCE.getNestedElement();

    /**
     * The meta object literal for the '{@link ewe.impl.FlockTaskImpl <em>Flock Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ewe.impl.FlockTaskImpl
     * @see ewe.impl.EwePackageImpl#getFlockTask()
     * @generated
     */
    EClass FLOCK_TASK = eINSTANCE.getFlockTask();

    /**
     * The meta object literal for the '<em><b>Original Model</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FLOCK_TASK__ORIGINAL_MODEL = eINSTANCE.getFlockTask_OriginalModel();

    /**
     * The meta object literal for the '<em><b>Migrated Model</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FLOCK_TASK__MIGRATED_MODEL = eINSTANCE.getFlockTask_MigratedModel();

    /**
     * The meta object literal for the '{@link ewe.impl.EUnitTaskImpl <em>EUnit Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ewe.impl.EUnitTaskImpl
     * @see ewe.impl.EwePackageImpl#getEUnitTask()
     * @generated
     */
    EClass EUNIT_TASK = eINSTANCE.getEUnitTask();

    /**
     * The meta object literal for the '<em><b>Fail On Errors</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EUNIT_TASK__FAIL_ON_ERRORS = eINSTANCE.getEUnitTask_FailOnErrors();

    /**
     * The meta object literal for the '<em><b>Report</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EUNIT_TASK__REPORT = eINSTANCE.getEUnitTask_Report();

    /**
     * The meta object literal for the '<em><b>To Dir</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EUNIT_TASK__TO_DIR = eINSTANCE.getEUnitTask_ToDir();

    /**
     * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EUNIT_TASK__PACKAGE = eINSTANCE.getEUnitTask_Package();

    /**
     * The meta object literal for the '{@link ewe.impl.EclTaskImpl <em>Ecl Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ewe.impl.EclTaskImpl
     * @see ewe.impl.EwePackageImpl#getEclTask()
     * @generated
     */
    EClass ECL_TASK = eINSTANCE.getEclTask();

    /**
     * The meta object literal for the '<em><b>Use Match Trace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ECL_TASK__USE_MATCH_TRACE = eINSTANCE.getEclTask_UseMatchTrace();

    /**
     * The meta object literal for the '<em><b>Export Match Trace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ECL_TASK__EXPORT_MATCH_TRACE = eINSTANCE.getEclTask_ExportMatchTrace();

    /**
     * The meta object literal for the '{@link ewe.impl.DisposeModelsTaskImpl <em>Dispose Models Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ewe.impl.DisposeModelsTaskImpl
     * @see ewe.impl.EwePackageImpl#getDisposeModelsTask()
     * @generated
     */
    EClass DISPOSE_MODELS_TASK = eINSTANCE.getDisposeModelsTask();

  }

} //EwePackage
