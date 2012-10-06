/*
 * Copyright (c) 2011 MetaCase Consulting
 * Released under the MIT license. See the file license.txt for details. 
 */

/**
 * MetaEditAPIPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.eclipse.epsilon.emc.metaedit.api;

public interface MetaEditAPIPortType extends java.rmi.Remote {

    /**
     * Returns a set of all instances of this Graph type in currently
     * open projects.
     */
    public MEOop[] allGoodInstances(METype receiver) throws java.rmi.RemoteException;

    /**
     * Returns a set of all instances of this Graph type or its subtypes
     * in currently open projects.
     */
    public MEOop[] allSimilarInstances(METype receiver) throws java.rmi.RemoteException;

    /**
     * Looks at subtypes of the METype receiver argument, and returns
     * the METype of the first subtype whose name matches the wildcard string
     * in the second argument. If none are found, returns the same METype
     * as the receiver argument.
     */
    public METype subTypeNamed(METype receiver, java.lang.String subTypeNamed) throws java.rmi.RemoteException;

    /**
     * Returns the set of NonProperties from this Graph whose id property
     * value matches the specified string, which can contain ? and * as wildcards.
     * Case insensitive.
     */
    public MEOop[] findString(MEOop receiver, java.lang.String findString) throws java.rmi.RemoteException;

    /**
     * Returns a sorted collection of all loaded matching instances
     * of matching types. Types may be the METype receiver argument or its
     * subtypes. Matching is case insensitive with wildcards. Note that only
     * graph instances in open projects are guaranteed to be loaded.
     */
    public MEOop[] instancesNamed(METype receiver, java.lang.String instancesNamed, java.lang.String ofSubTypesNamed) throws java.rmi.RemoteException;

    /**
     * Returns the user-visible string name of the receiver argument,
     * an METype.
     */
    public java.lang.String typeName(METype receiver) throws java.rmi.RemoteException;

    /**
     * Returns an METype, the type of the receiver argument. The receiver
     * argument must be the MEOop of a GOPRR instance.
     */
    public METype type(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Returns the simple string representation of the receiver argument,
     * an MEOop representing any conceptual or representational element.
     */
    public java.lang.String userPrintString(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Returns an MEAny representing the nth property value of the
     * receiver argument, a NonProperty MEOop. The second argument must be
     * an integer, starting with 1 for the first property.
     */
    public MEAny valueAt(MEOop receiver, int valueAt) throws java.rmi.RemoteException;

    /**
     * Sets the value of the the nth property value of the receiver
     * argument, a NonProperty MEOop. The second argument must be an integer,
     * starting with 1 for the first property. The third argument is an MEAny
     * containing the value for the property. Returns an MEAny containing
     * the MEOop of the property that was changed, or an MEAny containing
     * an MENull if unsuccessful (e.g. if the value is not of the right type
     * or fails the property type's regular expression rule).
     */
    public MEAny setValueAt(MEOop receiver, int valueAt, MEAny put) throws java.rmi.RemoteException;

    /**
     * Returns an MEAnyArray of the values of the properties of the
     * receiver argument, a NonProperty MEOop.
     */
    public MEAny[] allPropertiesValues(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Returns an MEOopArray of the properties of the receiver argument,
     * a NonProperty MEOop. (Note this returns the actual properties, not
     * their values: if you want the values, use allPropertiesValues.) This
     * can be useful when working with property sharing; note though that
     * instProps requires an MEAnyArray, so each MEOop returned here would
     * have to be wrapped in an MEAny. The method allPropertiesWrapped returns
     * such an MEAnyArray.
     */
    public MEOop[] allProperties(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Returns an MEAnyArray of the properties of the receiver argument,
     * a NonProperty MEOop. (Note this returns the actual properties, not
     * their values.) This is useful for setting up property sharing, since
     * instProps requires an MEAnyArray of properties. To get just the properties
     * as an MEOopArray, use allProperties. To get just their values, use
     * allPropertiesValues.
     */
    public MEAny[] allPropertiesWrapped(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Creates or sets the properties of an instance of the METype
     * argument, returning an MEAny with the MEOop of the instance, or MENull
     * for an error. The first argument is the METype; propColl is an array
     * of MEAnys, either MEOops of existing property instances or MENull
     * to create a new property of the default type; valueColl is an array
     * of MEAnys, the values of the properties; np is an MEAny, either the
     * MEOop of an existing NonProperty of this type, or MENull to create
     * a new one; inArea is an MEAny, either an integer corresponding to
     * the project's area number, or MENull for the default (the same project
     * as np if it exists already, else the current default project).
     */
    public MEAny instProps(METype receiver, MEAny[] propColl, MEAny[] valueColl, MEAny np, MEAny inArea) throws java.rmi.RemoteException;

    /**
     * Create and return the MEOop of a new instance of the receiver
     * argument, a NonProperty type METype. The result is created in the
     * current default project. Properties are created with their default
     * values, and the result is not checked against the metamodel rules.
     */
    public MEOop unsafeNew(METype receiver) throws java.rmi.RemoteException;

    /**
     * Returns the set of all Objects in this Graph
     */
    public MEOop[] objectSet(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Returns the set of all Relationships in this Graph.
     */
    public MEOop[] relationshipSet(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Returns the set of all Roles in this Graph.
     */
    public MEOop[] roleSet(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Returns the set of all Binding MEOops in this Graph MEOop
     */
    public MEOop[] bindingSet(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Returns the set of Graphs that are explosions of objects in
     * the receiver argument, a Graph MEOop.
     */
    public MEOop[] explodeGraphs(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Returns the set of Graphs that are decompositions of objects
     * in the receiver argument, a Graph MEOop.
     */
    public MEOop[] decompGraphs(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Returns the set of Graphs that are subgraphs (i.e. either explosions
     * or decompositions) of the receiver argument, a Graph MEOop.
     */
    public MEOop[] subgraphs(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * In the receiver argument, a Graph MEOop, add a new explosion
     * to the second argument, a Graph MEOop, for the final argument, an
     * Object MEOop.
     */
    public MEOop addExplode(MEOop receiver, MEOop addExplode, MEOop _for) throws java.rmi.RemoteException;

    /**
     * For this Graph and this NonProperty, returns the set of explosion
     * subgraphs
     */
    public MEOop[] getExplodeGraphsForNP(MEOop receiver, MEOop getExplodeGraphsForNP) throws java.rmi.RemoteException;

    /**
     * Removes the explosion link from the receiver argument, a Graph
     * MEOop. The second argument is the target Graph MEOop of the explosion
     * to remove. The third argument is the source Object, Role or Relationship
     * MEOop of the explosion to remove. The result is the receiver Graph
     * MEOop.
     */
    public MEOop removeExplode(MEOop receiver, MEOop removeExplode, MEOop _for) throws java.rmi.RemoteException;

    /**
     * Get the decomposition of the receiver argument, an Object MEOop.
     * Returns an MEAny containing either a Graph MEOop or MENull.
     */
    public MEAny decompGraph(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Set the decomposition of the receiver argument, an Object MEOop,
     * to be the decompGraph argument, an MEAny containing either a Graph
     * MEOop or MENull. Returns an MEAny containing either the receiver for
     * success or MENull for failure.
     */
    public MEAny setDecompGraph(MEOop receiver, MEAny decompGraph) throws java.rmi.RemoteException;

    /**
     * For this Graph and this Object, returns the set of Objects
     * directly connected to it. The third argument restricts the type of
     * the connected Objects: use NonProperty for no restriction.
     */
    public MEOop[] objsForObj(MEOop receiver, MEOop objsForObj, METype ofClass) throws java.rmi.RemoteException;

    /**
     * For this Graph and this Relationship, returns the set of Objects
     * directly connected to it. The third argument restricts the type of
     * the connected Objects: use NonProperty for no restriction.
     */
    public MEOop[] objsForRel(MEOop receiver, MEOop objsForRel, METype ofClass) throws java.rmi.RemoteException;

    /**
     * For this Graph and this Role, returns the set of Objects directly
     * connected to it. The third argument restricts the type of the connected
     * Objects: use NonProperty for no restriction.
     */
    public MEOop[] objsForRole(MEOop receiver, MEOop objsForRole, METype ofClass) throws java.rmi.RemoteException;

    /**
     * For this Graph and this Object, returns the set of Relationships
     * directly connected to it. The third argument restricts the type of
     * the connected Relationships: use NonProperty for no restriction.
     */
    public MEOop[] relsForObj(MEOop receiver, MEOop relsForObj, METype ofClass) throws java.rmi.RemoteException;

    /**
     * For this Graph and this Role, returns the set of Relationships
     * directly connected to it. The third argument restricts the type of
     * the connected Relationships: use NonProperty for no restriction.
     */
    public MEOop[] relsForRole(MEOop receiver, MEOop relsForRole, METype ofClass) throws java.rmi.RemoteException;

    /**
     * For this Graph and this Object, returns the set of Roles directly
     * connected to it. The third argument restricts the type of the connected
     * Roles: use NonProperty for no restriction.
     */
    public MEOop[] rolesForObj(MEOop receiver, MEOop rolesForObj, METype ofClass) throws java.rmi.RemoteException;

    /**
     * For this Graph and this Relationship, returns the set of Roles
     * directly connected to it. The third argument restricts the type of
     * the connected Roles: use NonProperty for no restriction.
     */
    public MEOop[] rolesForRel(MEOop receiver, MEOop rolesForRel, METype ofClass) throws java.rmi.RemoteException;

    /**
     * For this Graph and this Roles, returns the set of Roles that
     * belong to the same binding as the referred Role. The third argument
     * restricts the type of the connected Roles: use NonProperty for no
     * restriction.
     */
    public MEOop[] rolesForRole(MEOop receiver, MEOop rolesForRole, METype ofClass) throws java.rmi.RemoteException;

    /**
     * Opens the receiver argument in a graph representation. Will
     * prompt with a list dialog in MetaEdit+ if there is more than one possibility.
     */
    public MENull open(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Opens the specified graph and highlights the specified NonProperty.
     * The receiver argument is the MEOop of the graph, the second is the
     * MEOop of the NonProperty. This will never prompt.
     */
    public MENull animate(MEOop receiver, MEOop animate) throws java.rmi.RemoteException;

    /**
     * Refreshes the display of the receiver argument, which is an
     * MEOop of any conceptual or representational instance.
     */
    public MENull refresh(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Returns the MEOops of objects currently in the copy buffer.
     * Bindings in the copy buffer are ignored. This is a useful way of allowing
     * users to select an object in MetaEdit+, and have your application
     * know which object was selected: rather than just selecting the object,
     * they can select and copy it.
     */
    public MEOop[] copiedObjects(MENull receiver) throws java.rmi.RemoteException;

    /**
     * Delete the receiver argument, a Graph MEOop, and all its representations.
     * Note this does not delete links from other graphs etc. to this graph.
     */
    public MENull delete(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Adds the receiver argument, an Object MEOop, to the second
     * argument, a Graph MEOop. No type checking is performed.
     */
    public MENull addToGraph(MEOop receiver, MEOop addToGraph) throws java.rmi.RemoteException;

    /**
     * Creates a new binding into the receiver argument, a Graph MEOop.
     * The second argument is the METype of the relationship to create. The
     * third argument is an METypeArray of the types of Roles to create.
     * The final argument is an MEOopArray of the existing Objects that this
     * binding connects, in the same order as the third argument. The return
     * value is the newly created binding MEOop.
     */
    public MEOop createBinding(MEOop receiver, METype relType, METype[] roleTypes, MEOop[] objects) throws java.rmi.RemoteException;

    /**
     * Returns the relationship MEOop of this binding MEOop
     */
    public MEOop relationship(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Returns an MEOopArray of the roles in this binding MEOop in
     * order
     */
    public MEOop[] roles(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Returns an MEOopArray of the objects in this binding MEOop
     * in order
     */
    public MEOop[] objects(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Returns an MEOopArray containing the set of diagram representations
     * of the receiver argument, a Graph MEOop.
     */
    public MEOop[] diagrams(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Returns an MEOopArray containing the set of matrix representations
     * of the receiver argument, a Graph MEOop.
     */
    public MEOop[] matrices(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Returns an MEOopArray containing the set of table representations
     * of the receiver argument, a Graph MEOop.
     */
    public MEOop[] tables(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Creates a new diagram representation for the receiver argument,
     * a Graph MEOop, and returns the MEOop for the new representation.
     */
    public MEOop newDiagram(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Creates a new matrix representation for the receiver argument,
     * a Graph MEOop, and returns the MEOop for the new representation.
     */
    public MEOop newMatrix(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Creates a new table representation for the receiver argument,
     * a Graph MEOop, and returns the MEOop for the new representation.
     */
    public MEOop newTable(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Returns the NonProperty MEOop represented by the receiver argument,
     * an MEOop of a representation element.
     */
    public MEOop inst(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Returns an MEOopArray containing all representation elements
     * of the receiver argument, a NonProperty MEOop.
     */
    public MEOop[] repSet(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Returns the representation graph to which this representation
     * element belongs. The receiver argument must be an MEOop of a representation
     * element.
     */
    public MEOop reprGraph(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Removes the receiver argument, any representation MEOop. Returns
     * the NonProperty MEOop the receiver used to represent.
     */
    public MEOop remove(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Returns the timestamp of the receiver argument, a representation
     * graph MEOop.
     */
    public java.util.Calendar timeStamp(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Sets the timestamp of the receiver argument, a representation
     * graph MEOop.
     */
    public MENull setTimeStamp(MEOop receiver, java.util.Calendar timeStamp) throws java.rmi.RemoteException;

    /**
     * Returns an MEOopArray of the object representations in the
     * receiver argument, a diagram MEOop. The result is in Z-order, backmost
     * first.
     */
    public MEOop[] objectReprs(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Returns an MEOopArray of the binding representations in the
     * receiver argument, a diagram MEOop. The result is in Z-order, backmost
     * first.
     */
    public MEOop[] bindingReprs(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Returns an MEAny containing a point specifying the size of
     * the grid in the receiver argument, a diagram MEOop.
     */
    public MEAny grid(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Sets the size of the grid in the receiver argument, a diagram
     * MEOop. The value is an MEAny containing a point specifying the size
     * of the grid.
     */
    public MENull setGrid(MEOop receiver, MEAny grid) throws java.rmi.RemoteException;

    /**
     * Returns a Boolean indicating whether the grid is displayed
     * in the receiver argument, a diagram MEOop.
     */
    public boolean displayGrid(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Sets a Boolean indicating whether the grid is displayed in
     * the receiver argument, a diagram MEOop.
     */
    public MENull setDisplayGrid(MEOop receiver, boolean displayGrid) throws java.rmi.RemoteException;

    /**
     * Returns a Boolean indicating whether Snap to Grid is on in
     * the receiver argument, a diagram MEOop.
     */
    public boolean useGrid(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Sets a Boolean indicating whether Snap to Grid is on in the
     * receiver argument, a diagram MEOop.
     */
    public MENull setUseGrid(MEOop receiver, boolean useGrid) throws java.rmi.RemoteException;

    /**
     * Returns the position of the receiver, an MEOop for an object
     * or binding representation in a diagram argument. The result returned
     * is an MEAny containing a point, where 1 represents 1 pixel at 100%
     * zoom.
     */
    public MEAny place(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Sets the position of the receiver argument, an MEOop for an
     * object or binding representation in a diagram. The value is an MEAny
     * containing a point, where 1 represents 1 pixel at 100% zoom.
     */
    public MENull setPlace(MEOop receiver, MEAny place) throws java.rmi.RemoteException;

    /**
     * Returns the scale of the receiver argument, an MEOop for an
     * object or binding representation in a diagram. The result returned
     * is an MEAny containing a point, where 1 represents 100%.
     */
    public MEAny scale(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Sets the scale of the receiver argument, an MEOop for an object
     * or binding representation in a diagram. The value is an MEAny containing
     * a point, where 1 represents 100%.
     */
    public MENull setScale(MEOop receiver, MEAny scale) throws java.rmi.RemoteException;

    /**
     * Returns a Boolean indicating whether the receiver argument,
     * a diagram binding representation MEOop, is straight.
     */
    public boolean isStraight(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Straightens the receiver argument, a diagram binding representation
     * MEOop. The receiver must be a binary binding. All breakpoints and
     * target point offsets are removed from all connection representations,
     * and the relationship position is set to the midpoint of the role lines.
     */
    public MENull straighten(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Creates a new diagram representation with automatic layout
     * for the graph denoted by the first MEOop argument. The auto-layout
     * algorithm assumes a directed acyclic graph (DAG) as its input and
     * therefore the user must provide the API call with rules according
     * to which the DAG is built. Therefore, the following argument, relationship,
     * defines the relationship type which instances appear as edges in the
     * DAG. The two following arguments, parentRole and childRole, define
     * the directivity according to which the DAG is build. The fifth argument,
     * direction, provides the information how the layout is distributed
     * and can have either 'vertical' or 'horizontal' as values. The final
     * argument, manhattan, toggles the usage of orthogonal or diagonal lines
     * between DAG nodes.
     */
    public MENull layout(MEOop receiver, METype layoutRelationship, METype fromRole, METype toRole, java.lang.String direction, boolean manhattan) throws java.rmi.RemoteException;

    /**
     * Adds a new object representation to the receiver argument,
     * a diagram MEOop. The second argument is the MEOop of the object to
     * represent. The third argument is a 1-based integer before which to
     * insert the new binding representation in the Z-ordered collection
     * of binding representations: 1 is the backmost element. The fourth
     * argument is an MEAny containing the point position of the new object
     * representation. The return value is the MEOop of the new object representation.
     */
    public MEOop addNewObjectRepFor(MEOop receiver, MEOop addNewObjectRepFor, int beforeIndex, MEAny place) throws java.rmi.RemoteException;

    /**
     * Adds a new binding representation to the receiver argument,
     * a diagram MEOop. The second argument is the MEOop of the binding to
     * represent. The third argument is a 1-based integer before which to
     * insert the new binding representation in the Z-ordered collection
     * of binding representations: 1 is the backmost element. The fourth
     * argument is an MEAny containg the point position of the relationship
     * representation. The return value is the MEOop of the new binding representation.
     */
    public MEOop addNewBindingRepFor(MEOop receiver, MEOop addNewBindingRepFor, int beforeIndex, MEAny place) throws java.rmi.RemoteException;

    /**
     * Returns an MEAnyArray containing the integer ids of the connections
     * represented in the receiver argument, a diagram binding representation
     * MEOop.
     */
    public MEAny[] connectionReprIds(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Adds a new breakpoint to a role representation in the receiver
     * argument, a diagram binding representation MEOop. The second argument
     * is an MEAny containing the breakpoint coordinate. The third argument
     * is the 1-based integer index before which to insert the new breakpoint,
     * counting from the object. The fourth argument is the integer id of
     * the connection within this binding.
     */
    public MENull addPoint(MEOop receiver, MEAny addPoint, int index, int id) throws java.rmi.RemoteException;

    /**
     * Moves the position of a breakpoint in a role representation
     * in the receiver argument, a diagram binding representation MEOop.
     * The second argument is the 1-based integer index of the breakpoint,
     * counting from the object. The third argument is an MEAny containing
     * the new coordinate for the breakpoint. The fourth argument is the
     * integer id of the connection within this binding.
     */
    public MENull putPointAtIndex(MEOop receiver, int at, MEAny putPoint, int id) throws java.rmi.RemoteException;

    /**
     * Sets the breakpoints of a role representation in the receiver
     * argument, a diagram binding representation MEOop. The second argument
     * is an MEAnyArray containing the coordinates of the breakpoints. The
     * third argument is the integer id of the connection within this binding.
     */
    public MENull breakpoints(MEOop receiver, MEAny[] breakpoints, int id) throws java.rmi.RemoteException;

    /**
     * Sets the target point offset for a role representation in the
     * receiver argument, a diagram binding representation MEOop. The second
     * argument is an MEAny containing the offset coordinate. The third argument
     * is the integer id of the connection within this binding.
     */
    public MENull objTargetOffset(MEOop receiver, MEAny objTargetOffset, int id) throws java.rmi.RemoteException;

    /**
     * Removes a breakpoint from a role representation in the receiver
     * argument, a diagram binding representation MEOop. The second argument
     * is an MEAny containing the breakpoint coordinate. The third argument
     * is the integer id of the connection within this binding.
     */
    public MEAny removePoint(MEOop receiver, MEAny removePoint, int id) throws java.rmi.RemoteException;

    /**
     * Returns an MEOopArray of the axis elements on the horizontal
     * axis of the receiver argument, a matrix MEOop.
     */
    public MEOop[] hAxis(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Returns an MEOopArray of the axis elements on the vertical
     * axis of the receiver argument, a matrix MEOop.
     */
    public MEOop[] vAxis(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Returns the element to select from a binding for display in
     * a cell of the receiver argument, a matrix MEOop. The result returned
     * is a string corresponding to the choice in the View menu: firstRole
     * for the Row Role, secondRole for the Column Role, and relationship
     * for the Relationship.
     */
    public java.lang.String bindSelect(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Sets the element to select from a binding for display in a
     * cell of the receiver argument, a matrix MEOop. The value is a string
     * corresponding to the choice in the View menu: firstRole for the Row
     * Role, secondRole for the Column Role, and relationship for the Relationship.
     */
    public MENull setBindSelect(MEOop receiver, java.lang.String bindSelect) throws java.rmi.RemoteException;

    /**
     * Returns the cell display mode of the receiver argument, a matrix
     * MEOop. The result returned is a string corresponding to the choice
     * in the Cell menu: displayText, displaySymbol, or displayTextAndSymbol.
     */
    public java.lang.String cellDisplayMode(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Sets the cell display mode of the receiver argument, a matrix
     * MEOop. The value is a string corresponding to the choice in the Cell
     * menu: displayText, displaySymbol, or displayTextAndSymbol.
     */
    public MENull setCellDisplayMode(MEOop receiver, java.lang.String cellDisplayMode) throws java.rmi.RemoteException;

    /**
     * Returns the cell text display function of the receiver argument,
     * a matrix MEOop. The result returned is a string corresponding to the
     * choice in the Cell | Text Display dialog: userPrintStringWithType,
     * userPrintString, typeName, letter, justX.
     */
    public java.lang.String displayStringSelector(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Sets the cell text display function of the receiver argument,
     * a matrix MEOop. The value is a string corresponding to the choice
     * in the Cell | Text Display dialog: userPrintStringWithType, userPrintString,
     * typeName, letter, justX.
     */
    public MENull setDisplayStringSelector(MEOop receiver, java.lang.String displayStringSelector) throws java.rmi.RemoteException;

    /**
     * Returns the axis display mode of the receiver argument, a matrix
     * MEOop. The result returned is a string corresponding to the choice
     * in the Axis menu: axesDisplayText, axesDisplaySymbol, or axesDisplayTextAndSymbol.
     */
    public java.lang.String axisDisplayMode(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Sets the axis display mode of the receiver argument, a matrix
     * MEOop. The value is a string corresponding to the choice in the Axis
     * menu: axesDisplayText, axesDisplaySymbol, or axesDisplayTextAndSymbol.
     */
    public MENull setAxisDisplayMode(MEOop receiver, java.lang.String axisDisplayMode) throws java.rmi.RemoteException;

    /**
     * Returns whether the receiver argument, a matrix MEOop, only
     * shows bindings in cells corresponding to the first role, i.e. whether
     * the View | Directed? menu item is chosen.
     */
    public boolean showFirst(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Sets whether the receiver argument, a matrix MEOop, only shows
     * bindings in cells corresponding to the first role, i.e. whether the
     * View | Directed? menu item is chosen.
     */
    public MENull setShowFirst(MEOop receiver, boolean showFirst) throws java.rmi.RemoteException;

    /**
     * Returns the width in pixels of the row labels in the receiver
     * argument, a matrix MEOop.
     */
    public int rowLabelsWidth(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Sets the width in pixels of the row labels in the receiver
     * argument, a matrix MEOop.
     */
    public MENull setRowLabelsWidth(MEOop receiver, int rowLabelsWidth) throws java.rmi.RemoteException;

    /**
     * Returns the text style used by the receiver argument, a matrix
     * MEOop. The result returned is one of the styles shown in Format |
     * Font...
     */
    public java.lang.String textStyleSymbol(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Sets the text style used by the receiver argument, a matrix
     * MEOop. The value is one of the styles shown in Format | Font...
     */
    public MENull setTextStyleSymbol(MEOop receiver, java.lang.String textStyleSymbol) throws java.rmi.RemoteException;

    /**
     * Add to the receiver argument, a matrix MEOop, a new representation
     * for the Object MEOop. The representation is added to the horizontal
     * or vertical axis, depending on the toAxis argument, before the specified
     * index (1-based). Returns the MEOop of the resulting axis element.
     */
    public MEOop addNewAxisEltFor(MEOop receiver, MEOop addNewRepFor, java.lang.String toAxis, int beforeIndex) throws java.rmi.RemoteException;

    /**
     * Returns the width in pixels of the receiver argument, a matrix
     * axis element MEOop.
     */
    public int getWidth(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Sets the width in pixels of the receiver argument, a matrix
     * axis element MEOop.
     */
    public MENull setWidth(MEOop receiver, int setWidth) throws java.rmi.RemoteException;

    /**
     * Returns the METype of the object type whose instances are shown
     * in the receiver argument, a table MEOop.
     */
    public METype oT(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Returns an MEOopArray containing the object representations
     * in the receiver, a table MEOop.
     */
    public MEOop[] baseCollection(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Returns the text style used by the receiver argument, a table
     * MEOop. The result returned is one of the styles shown in Format |
     * Font...
     */
    public java.lang.String font(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Sets the text style used by the receiver argument, a table
     * MEOop. The value is one of the styles shown in Format | Font...
     */
    public MENull setFont(MEOop receiver, java.lang.String font) throws java.rmi.RemoteException;

    /**
     * Returns an MEAnyArray containing the column widths in pixels
     * in the receiver, a table MEOop.
     */
    public MEAny[] gxlWidths(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Sets the column widths in pixels of the receiver, a table MEOop.
     * The value is an MEAnyArray containing either one MEAny integer, which
     * will become the default width for all columns, or as many MEAny integers
     * as there are properties in this table's object type.
     */
    public MENull setGxlWidths(MEOop receiver, MEAny[] gxlWidths) throws java.rmi.RemoteException;

    /**
     * Adds a new object representation to the receiver argument,
     * a table MEOop. The second argument is the MEOop of the object to represent.
     * The third argument is a 1-based integer index of the row before which
     * to insert the new object representation. The return value is the MEOop
     * of the new object representation.
     */
    public MENull addNewTableEltFor(MEOop receiver, MEOop addNewRepFor, int beforeIndex) throws java.rmi.RemoteException;

    /**
     * Returns an MEAny array containing information about a binding
     * creation that was started before the timeout, or an empty MEAny array
     * if it times out. The 3-element array is: the graph representation
     * (MEAny of MEOop), relationship type (MEAny of METype), and first object
     * representation (MEAny of MEOop).
     */
    public MEAny[] waitForBindingCreation(MENull receiver, int waitForBindingCreation) throws java.rmi.RemoteException;

    /**
     * Returns an MEAny array: empty if it times out, containing the
     * diagram and two MENulls if binding creation was cancelled (either
     * during the duration of this call or before it, i.e. the diagram does
     * not currently have an open editor in binding creation mode), or containing
     * the diagram, new bindingRepr and binding
     */
    public MEAny[] waitForBindingFinalization(MENull receiver, int waitForBindingFinalization, MEOop in) throws java.rmi.RemoteException;

    /**
     * Return the MEOops of all representation graphs that are currently
     * open in editors, uppermost first.
     */
    public MEOop[] openedGraphReprs(MENull receiver) throws java.rmi.RemoteException;

    /**
     * Opens the specified diagram and highlights the specified ObjectReprs.
     * The receiver argument is the MEOop of the diagram, the second is the
     * MEOopArray of the ObjectReprs. This will never prompt.
     */
    public MENull animateAll(MEOop receiver, MEOop[] animateAll) throws java.rmi.RemoteException;

    /**
     * Turns off all highlighting in any editor open on the diagram.
     * Does not open the diagram.
     */
    public MENull animateNone(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * Opens the Create Graph dialog, with the Graph type in the first
     * argument as the initial selection (or none, if this is the Graph metatype).
     * Creates the graph and returns an MEAny containing the new graph's
     * MEOop, or MENull if creation was cancelled or unsuccessful. As the
     * graph is new, it will have at most one representation, which can be
     * found from its repSet.
     */
    public MEAny createGraphDialog(METype receiver) throws java.rmi.RemoteException;

    /**
     * Opens a property dialog to create a new instance of the first
     * argument, an METype. The project to store the new instance in is specified
     * by the second argument, an integer. Valid numbers are 3 and above,
     * and an existing instance's project/area number can be found from the
     * areaID of its MEOop. Returns an MEAny, containing the MEOop of the
     * new instance or an MENull if unsuccessful.
     */
    public MEAny createFromPropertyDialogInArea(METype receiver, int createFromPropertyDialogInArea) throws java.rmi.RemoteException;

    /**
     * Opens a property dialog for the receiver argument, an MEOop
     * of a NonProperty instance. Returns true if the edit is successful
     * or false if the user cancels.
     */
    public boolean propertyDialog(MEOop receiver) throws java.rmi.RemoteException;

    /**
     * For the receiver argument, a Graph MEOop, run the generator
     * named in the second argument, a string. Returns a boolean indicating
     * whether the generation proceeded without fatal errors.
     */
    public boolean forGraphRun(MEOop receiver, java.lang.String forGraphRun) throws java.rmi.RemoteException;

    /**
     * Returns the names of the generators defined in the receiver
     * argument, a Graph METype, one per line.
     */
    public java.lang.String generatorNames(METype receiver) throws java.rmi.RemoteException;

    /**
     * See the documentation for the corresponding command-line argument
     */
    public MENull currentDir(MENull receiver, java.lang.String currentDir) throws java.rmi.RemoteException;

    /**
     * See the documentation for the corresponding command-line argument
     */
    public MENull fileInPatch(MENull receiver, java.lang.String fileInPatch) throws java.rmi.RemoteException;

    /**
     * See the documentation for the corresponding command-line argument
     */
    public MENull fileInPatches(MENull receiver) throws java.rmi.RemoteException;

    /**
     * See the documentation for the corresponding command-line argument
     */
    public MENull abandon(MENull receiver) throws java.rmi.RemoteException;

    /**
     * See the documentation for the corresponding command-line argument
     */
    public MENull commit(MENull receiver) throws java.rmi.RemoteException;

    /**
     * See the documentation for the corresponding command-line argument
     */
    public MENull condenseDatabase(MENull receiver) throws java.rmi.RemoteException;

    /**
     * See the documentation for the corresponding command-line argument
     */
    public MENull createProject(MENull receiver, java.lang.String createProject) throws java.rmi.RemoteException;

    /**
     * See the documentation for the corresponding command-line argument
     */
    public MENull document(MENull receiver, java.lang.String document, java.lang.String into) throws java.rmi.RemoteException;

    /**
     * See the documentation for the corresponding command-line argument
     */
    public MENull forAll(MENull receiver, java.lang.String forAll, java.lang.String run) throws java.rmi.RemoteException;

    /**
     * See the documentation for the corresponding command-line argument
     */
    public MENull forName(MENull receiver, java.lang.String forName, java.lang.String type, java.lang.String run) throws java.rmi.RemoteException;

    /**
     * See the documentation for the corresponding command-line argument
     */
    public MENull login(MENull receiver) throws java.rmi.RemoteException;

    /**
     * See the documentation for the corresponding command-line argument
     */
    public MENull loginDB(MENull receiver, java.lang.String loginDB, java.lang.String user, java.lang.String password) throws java.rmi.RemoteException;

    /**
     * See the documentation for the corresponding command-line argument
     */
    public MENull loginNewDB(MENull receiver, java.lang.String loginNewDB, java.lang.String dir, java.lang.String user, java.lang.String password) throws java.rmi.RemoteException;

    /**
     * See the documentation for the corresponding command-line argument
     */
    public MENull logoutAndExit(MENull receiver) throws java.rmi.RemoteException;

    /**
     * See the documentation for the corresponding command-line argument
     */
    public MENull maintainDatabase(MENull receiver) throws java.rmi.RemoteException;

    /**
     * See the documentation for the corresponding command-line argument
     */
    public MENull openAllProjects(MENull receiver) throws java.rmi.RemoteException;

    /**
     * See the documentation for the corresponding command-line argument
     */
    public MENull quit(MENull receiver) throws java.rmi.RemoteException;

    /**
     * See the documentation for the corresponding command-line argument
     */
    public MENull saveWSDL(MENull receiver, java.lang.String saveWSDL) throws java.rmi.RemoteException;

    /**
     * See the documentation for the corresponding command-line argument
     */
    public MENull setProject(MENull receiver, java.lang.String setProject) throws java.rmi.RemoteException;

    /**
     * See the documentation for the corresponding command-line argument
     */
    public MENull startAPI(MENull receiver) throws java.rmi.RemoteException;

    /**
     * See the documentation for the corresponding command-line argument
     */
    public MENull startAPIHostname(MENull receiver, java.lang.String startAPIHostname, java.lang.String port, java.lang.String logEvents) throws java.rmi.RemoteException;

    /**
     * See the documentation for the corresponding command-line argument
     */
    public MENull stopAPI(MENull receiver) throws java.rmi.RemoteException;
}
