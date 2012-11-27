/**
 */
package testm2.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import testm2.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Testm2FactoryImpl extends EFactoryImpl implements Testm2Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Testm2Factory init() {
		try {
			Testm2Factory theTestm2Factory = (Testm2Factory)EPackage.Registry.INSTANCE.getEFactory("testm2"); 
			if (theTestm2Factory != null) {
				return theTestm2Factory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Testm2FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Testm2FactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Testm2Package.PROJECT: return createProject();
			case Testm2Package.WP: return createWP();
			case Testm2Package.THING_WITH_NO_ID: return createThingWithNoId();
			case Testm2Package.CONCRETE_THING: return createConcreteThing();
			case Testm2Package.CONCRETE_THING2: return createConcreteThing2();
			case Testm2Package.TASK: return createTask();
			case Testm2Package.DELIVERABLE: return createDeliverable();
			case Testm2Package.EFFORT: return createEffort();
			case Testm2Package.PARTNER: return createPartner();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project createProject() {
		ProjectImpl project = new ProjectImpl();
		return project;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WP createWP() {
		WPImpl wp = new WPImpl();
		return wp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThingWithNoId createThingWithNoId() {
		ThingWithNoIdImpl thingWithNoId = new ThingWithNoIdImpl();
		return thingWithNoId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcreteThing createConcreteThing() {
		ConcreteThingImpl concreteThing = new ConcreteThingImpl();
		return concreteThing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcreteThing2 createConcreteThing2() {
		ConcreteThing2Impl concreteThing2 = new ConcreteThing2Impl();
		return concreteThing2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Task createTask() {
		TaskImpl task = new TaskImpl();
		return task;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Deliverable createDeliverable() {
		DeliverableImpl deliverable = new DeliverableImpl();
		return deliverable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Effort createEffort() {
		EffortImpl effort = new EffortImpl();
		return effort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Partner createPartner() {
		PartnerImpl partner = new PartnerImpl();
		return partner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Testm2Package getTestm2Package() {
		return (Testm2Package)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Testm2Package getPackage() {
		return Testm2Package.eINSTANCE;
	}

} //Testm2FactoryImpl
