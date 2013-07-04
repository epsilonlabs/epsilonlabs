/**
 */
package org.eclipse.epsilon.emc.graphml;

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
 * @see org.eclipse.epsilon.emc.graphml.GraphmlFactory
 * @model kind="package"
 *        annotation="emf.gen basePackage='org.eclipse.epsilon.emc' modelDirectory='/org.eclipse.epsilon.emc.graphml/src-gen'"
 * @generated
 */
public interface GraphmlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "graphml";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/epsilon/emc/graphml";

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
	GraphmlPackage eINSTANCE = org.eclipse.epsilon.emc.graphml.impl.GraphmlPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.emc.graphml.impl.GraphImpl <em>Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.emc.graphml.impl.GraphImpl
	 * @see org.eclipse.epsilon.emc.graphml.impl.GraphmlPackageImpl#getGraph()
	 * @generated
	 */
	int GRAPH = 0;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__TYPES = 0;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__NODES = 1;

	/**
	 * The number of structural features of the '<em>Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.emc.graphml.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.emc.graphml.impl.NodeImpl
	 * @see org.eclipse.epsilon.emc.graphml.impl.GraphmlPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__ID = 0;

	/**
	 * The feature id for the '<em><b>Slots</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__SLOTS = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__TYPE = 2;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.emc.graphml.impl.SlotImpl <em>Slot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.emc.graphml.impl.SlotImpl
	 * @see org.eclipse.epsilon.emc.graphml.impl.GraphmlPackageImpl#getSlot()
	 * @generated
	 */
	int SLOT = 2;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT__VALUES = 0;

	/**
	 * The feature id for the '<em><b>Prototype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT__PROTOTYPE = 1;

	/**
	 * The feature id for the '<em><b>Owning Node</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT__OWNING_NODE = 2;

	/**
	 * The number of structural features of the '<em>Slot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.emc.graphml.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.emc.graphml.impl.TypeImpl
	 * @see org.eclipse.epsilon.emc.graphml.impl.GraphmlPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.emc.graphml.impl.CompositeTypeImpl <em>Composite Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.emc.graphml.impl.CompositeTypeImpl
	 * @see org.eclipse.epsilon.emc.graphml.impl.GraphmlPackageImpl#getCompositeType()
	 * @generated
	 */
	int COMPOSITE_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_TYPE__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_TYPE__TYPES = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.emc.graphml.impl.SlotPrototypeImpl <em>Slot Prototype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.emc.graphml.impl.SlotPrototypeImpl
	 * @see org.eclipse.epsilon.emc.graphml.impl.GraphmlPackageImpl#getSlotPrototype()
	 * @generated
	 */
	int SLOT_PROTOTYPE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_PROTOTYPE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_PROTOTYPE__MANY = 1;

	/**
	 * The feature id for the '<em><b>Primary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_PROTOTYPE__PRIMARY = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_PROTOTYPE__TYPE = 3;

	/**
	 * The feature id for the '<em><b>Owning Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_PROTOTYPE__OWNING_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Slots</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_PROTOTYPE__SLOTS = 5;

	/**
	 * The number of structural features of the '<em>Slot Prototype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLOT_PROTOTYPE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.emc.graphml.impl.NodeTypeImpl <em>Node Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.emc.graphml.impl.NodeTypeImpl
	 * @see org.eclipse.epsilon.emc.graphml.impl.GraphmlPackageImpl#getNodeType()
	 * @generated
	 */
	int NODE_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Instances</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE__INSTANCES = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Slot Prototypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE__SLOT_PROTOTYPES = TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE__SUPER_TYPES = TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Sub Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE__SUB_TYPES = TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Node Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.emc.graphml.impl.EdgeTypeImpl <em>Edge Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.emc.graphml.impl.EdgeTypeImpl
	 * @see org.eclipse.epsilon.emc.graphml.impl.GraphmlPackageImpl#getEdgeType()
	 * @generated
	 */
	int EDGE_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_TYPE__NAME = NODE_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Instances</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_TYPE__INSTANCES = NODE_TYPE__INSTANCES;

	/**
	 * The feature id for the '<em><b>Slot Prototypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_TYPE__SLOT_PROTOTYPES = NODE_TYPE__SLOT_PROTOTYPES;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_TYPE__SUPER_TYPES = NODE_TYPE__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Sub Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_TYPE__SUB_TYPES = NODE_TYPE__SUB_TYPES;

	/**
	 * The feature id for the '<em><b>Source Prototype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_TYPE__SOURCE_PROTOTYPE = NODE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Prototype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_TYPE__TARGET_PROTOTYPE = NODE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Role In Source Prototype</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_TYPE__ROLE_IN_SOURCE_PROTOTYPE = NODE_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Role In Target Prototype</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_TYPE__ROLE_IN_TARGET_PROTOTYPE = NODE_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Edge Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_TYPE_FEATURE_COUNT = NODE_TYPE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.emc.graphml.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.emc.graphml.impl.PrimitiveTypeImpl
	 * @see org.eclipse.epsilon.emc.graphml.impl.GraphmlPackageImpl#getPrimitiveType()
	 * @generated
	 */
	int PRIMITIVE_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__NAME = TYPE__NAME;

	/**
	 * The number of structural features of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.emc.graphml.impl.IntegerTypeImpl <em>Integer Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.emc.graphml.impl.IntegerTypeImpl
	 * @see org.eclipse.epsilon.emc.graphml.impl.GraphmlPackageImpl#getIntegerType()
	 * @generated
	 */
	int INTEGER_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__NAME = PRIMITIVE_TYPE__NAME;

	/**
	 * The number of structural features of the '<em>Integer Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.emc.graphml.impl.StringTypeImpl <em>String Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.emc.graphml.impl.StringTypeImpl
	 * @see org.eclipse.epsilon.emc.graphml.impl.GraphmlPackageImpl#getStringType()
	 * @generated
	 */
	int STRING_TYPE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__NAME = PRIMITIVE_TYPE__NAME;

	/**
	 * The number of structural features of the '<em>String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.emc.graphml.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.emc.graphml.impl.BooleanTypeImpl
	 * @see org.eclipse.epsilon.emc.graphml.impl.GraphmlPackageImpl#getBooleanType()
	 * @generated
	 */
	int BOOLEAN_TYPE = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE__NAME = PRIMITIVE_TYPE__NAME;

	/**
	 * The number of structural features of the '<em>Boolean Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.emc.graphml.impl.RealTypeImpl <em>Real Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.emc.graphml.impl.RealTypeImpl
	 * @see org.eclipse.epsilon.emc.graphml.impl.GraphmlPackageImpl#getRealType()
	 * @generated
	 */
	int REAL_TYPE = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE__NAME = PRIMITIVE_TYPE__NAME;

	/**
	 * The number of structural features of the '<em>Real Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.emc.graphml.Graph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.Graph
	 * @generated
	 */
	EClass getGraph();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.emc.graphml.Graph#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Types</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.Graph#getTypes()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Types();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.emc.graphml.Graph#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.Graph#getNodes()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Nodes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.emc.graphml.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.epsilon.emc.graphml.Node#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.Node#getId()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Id();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.emc.graphml.Node#getSlots <em>Slots</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Slots</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.Node#getSlots()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Slots();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.epsilon.emc.graphml.Node#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.Node#getType()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.emc.graphml.Slot <em>Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Slot</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.Slot
	 * @generated
	 */
	EClass getSlot();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.epsilon.emc.graphml.Slot#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.Slot#getValues()
	 * @see #getSlot()
	 * @generated
	 */
	EAttribute getSlot_Values();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.epsilon.emc.graphml.Slot#getPrototype <em>Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Prototype</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.Slot#getPrototype()
	 * @see #getSlot()
	 * @generated
	 */
	EReference getSlot_Prototype();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.epsilon.emc.graphml.Slot#getOwningNode <em>Owning Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Node</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.Slot#getOwningNode()
	 * @see #getSlot()
	 * @generated
	 */
	EReference getSlot_OwningNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.emc.graphml.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.epsilon.emc.graphml.Type#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.Type#getName()
	 * @see #getType()
	 * @generated
	 */
	EAttribute getType_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.emc.graphml.CompositeType <em>Composite Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Type</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.CompositeType
	 * @generated
	 */
	EClass getCompositeType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.emc.graphml.CompositeType#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Types</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.CompositeType#getTypes()
	 * @see #getCompositeType()
	 * @generated
	 */
	EReference getCompositeType_Types();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.emc.graphml.SlotPrototype <em>Slot Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Slot Prototype</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.SlotPrototype
	 * @generated
	 */
	EClass getSlotPrototype();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.epsilon.emc.graphml.SlotPrototype#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.SlotPrototype#getName()
	 * @see #getSlotPrototype()
	 * @generated
	 */
	EAttribute getSlotPrototype_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.epsilon.emc.graphml.SlotPrototype#isMany <em>Many</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Many</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.SlotPrototype#isMany()
	 * @see #getSlotPrototype()
	 * @generated
	 */
	EAttribute getSlotPrototype_Many();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.epsilon.emc.graphml.SlotPrototype#isPrimary <em>Primary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Primary</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.SlotPrototype#isPrimary()
	 * @see #getSlotPrototype()
	 * @generated
	 */
	EAttribute getSlotPrototype_Primary();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.epsilon.emc.graphml.SlotPrototype#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.SlotPrototype#getType()
	 * @see #getSlotPrototype()
	 * @generated
	 */
	EReference getSlotPrototype_Type();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.epsilon.emc.graphml.SlotPrototype#getOwningType <em>Owning Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Type</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.SlotPrototype#getOwningType()
	 * @see #getSlotPrototype()
	 * @generated
	 */
	EReference getSlotPrototype_OwningType();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.epsilon.emc.graphml.SlotPrototype#getSlots <em>Slots</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Slots</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.SlotPrototype#getSlots()
	 * @see #getSlotPrototype()
	 * @generated
	 */
	EReference getSlotPrototype_Slots();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.emc.graphml.NodeType <em>Node Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Type</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.NodeType
	 * @generated
	 */
	EClass getNodeType();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.epsilon.emc.graphml.NodeType#getInstances <em>Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Instances</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.NodeType#getInstances()
	 * @see #getNodeType()
	 * @generated
	 */
	EReference getNodeType_Instances();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.emc.graphml.NodeType#getSlotPrototypes <em>Slot Prototypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Slot Prototypes</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.NodeType#getSlotPrototypes()
	 * @see #getNodeType()
	 * @generated
	 */
	EReference getNodeType_SlotPrototypes();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.epsilon.emc.graphml.NodeType#getSuperTypes <em>Super Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Super Types</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.NodeType#getSuperTypes()
	 * @see #getNodeType()
	 * @generated
	 */
	EReference getNodeType_SuperTypes();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.epsilon.emc.graphml.NodeType#getSubTypes <em>Sub Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sub Types</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.NodeType#getSubTypes()
	 * @see #getNodeType()
	 * @generated
	 */
	EReference getNodeType_SubTypes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.emc.graphml.EdgeType <em>Edge Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Type</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.EdgeType
	 * @generated
	 */
	EClass getEdgeType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.epsilon.emc.graphml.EdgeType#getSourcePrototype <em>Source Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Prototype</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.EdgeType#getSourcePrototype()
	 * @see #getEdgeType()
	 * @generated
	 */
	EReference getEdgeType_SourcePrototype();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.epsilon.emc.graphml.EdgeType#getTargetPrototype <em>Target Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Prototype</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.EdgeType#getTargetPrototype()
	 * @see #getEdgeType()
	 * @generated
	 */
	EReference getEdgeType_TargetPrototype();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.emc.graphml.EdgeType#getRoleInSourcePrototype <em>Role In Source Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Role In Source Prototype</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.EdgeType#getRoleInSourcePrototype()
	 * @see #getEdgeType()
	 * @generated
	 */
	EReference getEdgeType_RoleInSourcePrototype();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.epsilon.emc.graphml.EdgeType#getRoleInTargetPrototype <em>Role In Target Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Role In Target Prototype</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.EdgeType#getRoleInTargetPrototype()
	 * @see #getEdgeType()
	 * @generated
	 */
	EReference getEdgeType_RoleInTargetPrototype();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.emc.graphml.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.PrimitiveType
	 * @generated
	 */
	EClass getPrimitiveType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.emc.graphml.IntegerType <em>Integer Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Type</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.IntegerType
	 * @generated
	 */
	EClass getIntegerType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.emc.graphml.StringType <em>String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Type</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.StringType
	 * @generated
	 */
	EClass getStringType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.emc.graphml.BooleanType <em>Boolean Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Type</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.BooleanType
	 * @generated
	 */
	EClass getBooleanType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.emc.graphml.RealType <em>Real Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Type</em>'.
	 * @see org.eclipse.epsilon.emc.graphml.RealType
	 * @generated
	 */
	EClass getRealType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GraphmlFactory getGraphmlFactory();

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
		 * The meta object literal for the '{@link org.eclipse.epsilon.emc.graphml.impl.GraphImpl <em>Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.emc.graphml.impl.GraphImpl
		 * @see org.eclipse.epsilon.emc.graphml.impl.GraphmlPackageImpl#getGraph()
		 * @generated
		 */
		EClass GRAPH = eINSTANCE.getGraph();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__TYPES = eINSTANCE.getGraph_Types();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__NODES = eINSTANCE.getGraph_Nodes();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.emc.graphml.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.emc.graphml.impl.NodeImpl
		 * @see org.eclipse.epsilon.emc.graphml.impl.GraphmlPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__ID = eINSTANCE.getNode_Id();

		/**
		 * The meta object literal for the '<em><b>Slots</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__SLOTS = eINSTANCE.getNode_Slots();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__TYPE = eINSTANCE.getNode_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.emc.graphml.impl.SlotImpl <em>Slot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.emc.graphml.impl.SlotImpl
		 * @see org.eclipse.epsilon.emc.graphml.impl.GraphmlPackageImpl#getSlot()
		 * @generated
		 */
		EClass SLOT = eINSTANCE.getSlot();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SLOT__VALUES = eINSTANCE.getSlot_Values();

		/**
		 * The meta object literal for the '<em><b>Prototype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SLOT__PROTOTYPE = eINSTANCE.getSlot_Prototype();

		/**
		 * The meta object literal for the '<em><b>Owning Node</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SLOT__OWNING_NODE = eINSTANCE.getSlot_OwningNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.emc.graphml.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.emc.graphml.impl.TypeImpl
		 * @see org.eclipse.epsilon.emc.graphml.impl.GraphmlPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE__NAME = eINSTANCE.getType_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.emc.graphml.impl.CompositeTypeImpl <em>Composite Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.emc.graphml.impl.CompositeTypeImpl
		 * @see org.eclipse.epsilon.emc.graphml.impl.GraphmlPackageImpl#getCompositeType()
		 * @generated
		 */
		EClass COMPOSITE_TYPE = eINSTANCE.getCompositeType();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_TYPE__TYPES = eINSTANCE.getCompositeType_Types();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.emc.graphml.impl.SlotPrototypeImpl <em>Slot Prototype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.emc.graphml.impl.SlotPrototypeImpl
		 * @see org.eclipse.epsilon.emc.graphml.impl.GraphmlPackageImpl#getSlotPrototype()
		 * @generated
		 */
		EClass SLOT_PROTOTYPE = eINSTANCE.getSlotPrototype();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SLOT_PROTOTYPE__NAME = eINSTANCE.getSlotPrototype_Name();

		/**
		 * The meta object literal for the '<em><b>Many</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SLOT_PROTOTYPE__MANY = eINSTANCE.getSlotPrototype_Many();

		/**
		 * The meta object literal for the '<em><b>Primary</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SLOT_PROTOTYPE__PRIMARY = eINSTANCE.getSlotPrototype_Primary();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SLOT_PROTOTYPE__TYPE = eINSTANCE.getSlotPrototype_Type();

		/**
		 * The meta object literal for the '<em><b>Owning Type</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SLOT_PROTOTYPE__OWNING_TYPE = eINSTANCE.getSlotPrototype_OwningType();

		/**
		 * The meta object literal for the '<em><b>Slots</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SLOT_PROTOTYPE__SLOTS = eINSTANCE.getSlotPrototype_Slots();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.emc.graphml.impl.NodeTypeImpl <em>Node Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.emc.graphml.impl.NodeTypeImpl
		 * @see org.eclipse.epsilon.emc.graphml.impl.GraphmlPackageImpl#getNodeType()
		 * @generated
		 */
		EClass NODE_TYPE = eINSTANCE.getNodeType();

		/**
		 * The meta object literal for the '<em><b>Instances</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_TYPE__INSTANCES = eINSTANCE.getNodeType_Instances();

		/**
		 * The meta object literal for the '<em><b>Slot Prototypes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_TYPE__SLOT_PROTOTYPES = eINSTANCE.getNodeType_SlotPrototypes();

		/**
		 * The meta object literal for the '<em><b>Super Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_TYPE__SUPER_TYPES = eINSTANCE.getNodeType_SuperTypes();

		/**
		 * The meta object literal for the '<em><b>Sub Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_TYPE__SUB_TYPES = eINSTANCE.getNodeType_SubTypes();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.emc.graphml.impl.EdgeTypeImpl <em>Edge Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.emc.graphml.impl.EdgeTypeImpl
		 * @see org.eclipse.epsilon.emc.graphml.impl.GraphmlPackageImpl#getEdgeType()
		 * @generated
		 */
		EClass EDGE_TYPE = eINSTANCE.getEdgeType();

		/**
		 * The meta object literal for the '<em><b>Source Prototype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_TYPE__SOURCE_PROTOTYPE = eINSTANCE.getEdgeType_SourcePrototype();

		/**
		 * The meta object literal for the '<em><b>Target Prototype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_TYPE__TARGET_PROTOTYPE = eINSTANCE.getEdgeType_TargetPrototype();

		/**
		 * The meta object literal for the '<em><b>Role In Source Prototype</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_TYPE__ROLE_IN_SOURCE_PROTOTYPE = eINSTANCE.getEdgeType_RoleInSourcePrototype();

		/**
		 * The meta object literal for the '<em><b>Role In Target Prototype</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_TYPE__ROLE_IN_TARGET_PROTOTYPE = eINSTANCE.getEdgeType_RoleInTargetPrototype();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.emc.graphml.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.emc.graphml.impl.PrimitiveTypeImpl
		 * @see org.eclipse.epsilon.emc.graphml.impl.GraphmlPackageImpl#getPrimitiveType()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.emc.graphml.impl.IntegerTypeImpl <em>Integer Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.emc.graphml.impl.IntegerTypeImpl
		 * @see org.eclipse.epsilon.emc.graphml.impl.GraphmlPackageImpl#getIntegerType()
		 * @generated
		 */
		EClass INTEGER_TYPE = eINSTANCE.getIntegerType();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.emc.graphml.impl.StringTypeImpl <em>String Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.emc.graphml.impl.StringTypeImpl
		 * @see org.eclipse.epsilon.emc.graphml.impl.GraphmlPackageImpl#getStringType()
		 * @generated
		 */
		EClass STRING_TYPE = eINSTANCE.getStringType();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.emc.graphml.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.emc.graphml.impl.BooleanTypeImpl
		 * @see org.eclipse.epsilon.emc.graphml.impl.GraphmlPackageImpl#getBooleanType()
		 * @generated
		 */
		EClass BOOLEAN_TYPE = eINSTANCE.getBooleanType();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.emc.graphml.impl.RealTypeImpl <em>Real Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.emc.graphml.impl.RealTypeImpl
		 * @see org.eclipse.epsilon.emc.graphml.impl.GraphmlPackageImpl#getRealType()
		 * @generated
		 */
		EClass REAL_TYPE = eINSTANCE.getRealType();

	}

} //GraphmlPackage
