/**
 */
package testm2;

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
 * @see testm2.Testm2Factory
 * @model kind="package"
 * @generated
 */
public interface Testm2Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "testm2";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "testm2";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Testm2Package eINSTANCE = testm2.impl.Testm2PackageImpl.init();

	/**
	 * The meta object id for the '{@link testm2.impl.ProjectImpl <em>Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see testm2.impl.ProjectImpl
	 * @see testm2.impl.Testm2PackageImpl#getProject()
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
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__DURATION = 1;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__TITLE = 2;

	/**
	 * The feature id for the '<em><b>Wps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__WPS = 3;

	/**
	 * The feature id for the '<em><b>Partners</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__PARTNERS = 4;

	/**
	 * The number of structural features of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link testm2.impl.WPImpl <em>WP</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see testm2.impl.WPImpl
	 * @see testm2.impl.Testm2PackageImpl#getWP()
	 * @generated
	 */
	int WP = 1;

	/**
	 * The feature id for the '<em><b>Tasks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WP__TASKS = 0;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WP__TITLE = 1;

	/**
	 * The feature id for the '<em><b>Leader</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WP__LEADER = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WP__TYPE = 3;

	/**
	 * The feature id for the '<em><b>Effort</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WP__EFFORT = 4;

	/**
	 * The number of structural features of the '<em>WP</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WP_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link testm2.impl.TaskImpl <em>Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see testm2.impl.TaskImpl
	 * @see testm2.impl.Testm2PackageImpl#getTask()
	 * @generated
	 */
	int TASK = 2;

	/**
	 * The feature id for the '<em><b>Partners</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__PARTNERS = 0;

	/**
	 * The number of structural features of the '<em>Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_FEATURE_COUNT = 1;


	/**
	 * The meta object id for the '{@link testm2.impl.EffortImpl <em>Effort</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see testm2.impl.EffortImpl
	 * @see testm2.impl.Testm2PackageImpl#getEffort()
	 * @generated
	 */
	int EFFORT = 3;

	/**
	 * The feature id for the '<em><b>Partner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFORT__PARTNER = 0;

	/**
	 * The feature id for the '<em><b>Months</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFORT__MONTHS = 1;

	/**
	 * The number of structural features of the '<em>Effort</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFFORT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link testm2.impl.PartnerImpl <em>Partner</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see testm2.impl.PartnerImpl
	 * @see testm2.impl.Testm2PackageImpl#getPartner()
	 * @generated
	 */
	int PARTNER = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER__ID = 0;

	/**
	 * The number of structural features of the '<em>Partner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link testm2.Project <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project</em>'.
	 * @see testm2.Project
	 * @generated
	 */
	EClass getProject();

	/**
	 * Returns the meta object for the attribute '{@link testm2.Project#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see testm2.Project#getName()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Name();

	/**
	 * Returns the meta object for the attribute '{@link testm2.Project#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see testm2.Project#getDuration()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Duration();

	/**
	 * Returns the meta object for the attribute '{@link testm2.Project#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see testm2.Project#getTitle()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Title();

	/**
	 * Returns the meta object for the containment reference list '{@link testm2.Project#getWps <em>Wps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Wps</em>'.
	 * @see testm2.Project#getWps()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Wps();

	/**
	 * Returns the meta object for the containment reference list '{@link testm2.Project#getPartners <em>Partners</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Partners</em>'.
	 * @see testm2.Project#getPartners()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Partners();

	/**
	 * Returns the meta object for class '{@link testm2.WP <em>WP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>WP</em>'.
	 * @see testm2.WP
	 * @generated
	 */
	EClass getWP();

	/**
	 * Returns the meta object for the containment reference list '{@link testm2.WP#getTasks <em>Tasks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tasks</em>'.
	 * @see testm2.WP#getTasks()
	 * @see #getWP()
	 * @generated
	 */
	EReference getWP_Tasks();

	/**
	 * Returns the meta object for the attribute '{@link testm2.WP#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see testm2.WP#getTitle()
	 * @see #getWP()
	 * @generated
	 */
	EAttribute getWP_Title();

	/**
	 * Returns the meta object for the reference '{@link testm2.WP#getLeader <em>Leader</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Leader</em>'.
	 * @see testm2.WP#getLeader()
	 * @see #getWP()
	 * @generated
	 */
	EReference getWP_Leader();

	/**
	 * Returns the meta object for the attribute '{@link testm2.WP#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see testm2.WP#getType()
	 * @see #getWP()
	 * @generated
	 */
	EAttribute getWP_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link testm2.WP#getEffort <em>Effort</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Effort</em>'.
	 * @see testm2.WP#getEffort()
	 * @see #getWP()
	 * @generated
	 */
	EReference getWP_Effort();

	/**
	 * Returns the meta object for class '{@link testm2.Task <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task</em>'.
	 * @see testm2.Task
	 * @generated
	 */
	EClass getTask();

	/**
	 * Returns the meta object for the attribute list '{@link testm2.Task#getPartners <em>Partners</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Partners</em>'.
	 * @see testm2.Task#getPartners()
	 * @see #getTask()
	 * @generated
	 */
	EAttribute getTask_Partners();

	/**
	 * Returns the meta object for class '{@link testm2.Effort <em>Effort</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Effort</em>'.
	 * @see testm2.Effort
	 * @generated
	 */
	EClass getEffort();

	/**
	 * Returns the meta object for the reference '{@link testm2.Effort#getPartner <em>Partner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Partner</em>'.
	 * @see testm2.Effort#getPartner()
	 * @see #getEffort()
	 * @generated
	 */
	EReference getEffort_Partner();

	/**
	 * Returns the meta object for the attribute '{@link testm2.Effort#getMonths <em>Months</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Months</em>'.
	 * @see testm2.Effort#getMonths()
	 * @see #getEffort()
	 * @generated
	 */
	EAttribute getEffort_Months();

	/**
	 * Returns the meta object for class '{@link testm2.Partner <em>Partner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Partner</em>'.
	 * @see testm2.Partner
	 * @generated
	 */
	EClass getPartner();

	/**
	 * Returns the meta object for the attribute '{@link testm2.Partner#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see testm2.Partner#getId()
	 * @see #getPartner()
	 * @generated
	 */
	EAttribute getPartner_Id();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Testm2Factory getTestm2Factory();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link testm2.impl.ProjectImpl <em>Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see testm2.impl.ProjectImpl
		 * @see testm2.impl.Testm2PackageImpl#getProject()
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
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__DURATION = eINSTANCE.getProject_Duration();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__TITLE = eINSTANCE.getProject_Title();

		/**
		 * The meta object literal for the '<em><b>Wps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__WPS = eINSTANCE.getProject_Wps();

		/**
		 * The meta object literal for the '<em><b>Partners</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__PARTNERS = eINSTANCE.getProject_Partners();

		/**
		 * The meta object literal for the '{@link testm2.impl.WPImpl <em>WP</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see testm2.impl.WPImpl
		 * @see testm2.impl.Testm2PackageImpl#getWP()
		 * @generated
		 */
		EClass WP = eINSTANCE.getWP();

		/**
		 * The meta object literal for the '<em><b>Tasks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WP__TASKS = eINSTANCE.getWP_Tasks();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WP__TITLE = eINSTANCE.getWP_Title();

		/**
		 * The meta object literal for the '<em><b>Leader</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WP__LEADER = eINSTANCE.getWP_Leader();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WP__TYPE = eINSTANCE.getWP_Type();

		/**
		 * The meta object literal for the '<em><b>Effort</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WP__EFFORT = eINSTANCE.getWP_Effort();

		/**
		 * The meta object literal for the '{@link testm2.impl.TaskImpl <em>Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see testm2.impl.TaskImpl
		 * @see testm2.impl.Testm2PackageImpl#getTask()
		 * @generated
		 */
		EClass TASK = eINSTANCE.getTask();

		/**
		 * The meta object literal for the '<em><b>Partners</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK__PARTNERS = eINSTANCE.getTask_Partners();

		/**
		 * The meta object literal for the '{@link testm2.impl.EffortImpl <em>Effort</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see testm2.impl.EffortImpl
		 * @see testm2.impl.Testm2PackageImpl#getEffort()
		 * @generated
		 */
		EClass EFFORT = eINSTANCE.getEffort();

		/**
		 * The meta object literal for the '<em><b>Partner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EFFORT__PARTNER = eINSTANCE.getEffort_Partner();

		/**
		 * The meta object literal for the '<em><b>Months</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EFFORT__MONTHS = eINSTANCE.getEffort_Months();

		/**
		 * The meta object literal for the '{@link testm2.impl.PartnerImpl <em>Partner</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see testm2.impl.PartnerImpl
		 * @see testm2.impl.Testm2PackageImpl#getPartner()
		 * @generated
		 */
		EClass PARTNER = eINSTANCE.getPartner();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARTNER__ID = eINSTANCE.getPartner_Id();

	}

} //Testm2Package
