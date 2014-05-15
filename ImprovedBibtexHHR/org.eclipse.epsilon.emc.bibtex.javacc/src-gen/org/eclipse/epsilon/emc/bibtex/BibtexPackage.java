/**
 * Copyright (c) 2013 Horacio Hoyos.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial implementation
 * 
 */
package org.eclipse.epsilon.emc.bibtex;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.epsilon.emc.bibtex.BibtexFactory
 * @model kind="package"
 * @generated
 */
public interface BibtexPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "bibtex";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://www.eclipse.org/epsilon/0.1/bibtex";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "bibtex";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BibtexPackage eINSTANCE = org.eclipse.epsilon.emc.bibtex.impl.BibtexBibtexPackage.init();

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.emc.bibtex.parser.Node <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.emc.bibtex.parser.Node
	 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexBibtexPackage#getNode()
	 * @generated
	 */
	int NODE = 9;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.emc.bibtex.impl.BibtexTag <em>Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexTag
	 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexBibtexPackage#getTag()
	 * @generated
	 */
	int TAG = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__NAME = NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Entry</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__ENTRY = NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__VALUE = NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_FEATURE_COUNT = NODE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Jjt Set Parent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG___JJT_SET_PARENT__NODE = NODE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_OPERATION_COUNT = NODE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.emc.bibtex.impl.BibtexAuthorTag <em>Author Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexAuthorTag
	 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexBibtexPackage#getAuthorTag()
	 * @generated
	 */
	int AUTHOR_TAG = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR_TAG__NAME = TAG__NAME;

	/**
	 * The feature id for the '<em><b>Entry</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR_TAG__ENTRY = TAG__ENTRY;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR_TAG__VALUE = TAG__VALUE;

	/**
	 * The number of structural features of the '<em>Author Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR_TAG_FEATURE_COUNT = TAG_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Jjt Set Parent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR_TAG___JJT_SET_PARENT__NODE = TAG___JJT_SET_PARENT__NODE;

	/**
	 * The number of operations of the '<em>Author Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR_TAG_OPERATION_COUNT = TAG_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.emc.bibtex.impl.BibtexBibliography <em>Bibliography</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexBibliography
	 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexBibtexPackage#getBibliography()
	 * @generated
	 */
	int BIBLIOGRAPHY = 1;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIBLIOGRAPHY__ENTRIES = NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIBLIOGRAPHY__CONTENTS = NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIBLIOGRAPHY__NAME = NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Bibliography</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIBLIOGRAPHY_FEATURE_COUNT = NODE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Bibliography</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIBLIOGRAPHY_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.emc.bibtex.impl.BibtexContent <em>Content</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexContent
	 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexBibtexPackage#getContent()
	 * @generated
	 */
	int CONTENT = 3;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT__CONTENT = NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bibliography</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT__BIBLIOGRAPHY = NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Content</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_FEATURE_COUNT = NODE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Jjt Set Parent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT___JJT_SET_PARENT__NODE = NODE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Content</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_OPERATION_COUNT = NODE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.emc.bibtex.impl.BibtexComment <em>Comment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexComment
	 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexBibtexPackage#getComment()
	 * @generated
	 */
	int COMMENT = 2;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__CONTENT = CONTENT__CONTENT;

	/**
	 * The feature id for the '<em><b>Bibliography</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__BIBLIOGRAPHY = CONTENT__BIBLIOGRAPHY;

	/**
	 * The number of structural features of the '<em>Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Jjt Set Parent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT___JJT_SET_PARENT__NODE = CONTENT___JJT_SET_PARENT__NODE;

	/**
	 * The number of operations of the '<em>Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_OPERATION_COUNT = CONTENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.emc.bibtex.impl.BibtexEntry <em>Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexEntry
	 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexBibtexPackage#getEntry()
	 * @generated
	 */
	int ENTRY = 4;

	/**
	 * The feature id for the '<em><b>Bibliography</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY__BIBLIOGRAPHY = NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY__TAGS = NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_FEATURE_COUNT = NODE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Jjt Set Parent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY___JJT_SET_PARENT__NODE = NODE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_OPERATION_COUNT = NODE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.emc.bibtex.impl.BibtexPreamble <em>Preamble</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexPreamble
	 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexBibtexPackage#getPreamble()
	 * @generated
	 */
	int PREAMBLE = 5;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREAMBLE__CONTENT = CONTENT__CONTENT;

	/**
	 * The feature id for the '<em><b>Bibliography</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREAMBLE__BIBLIOGRAPHY = CONTENT__BIBLIOGRAPHY;

	/**
	 * The number of structural features of the '<em>Preamble</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREAMBLE_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Jjt Set Parent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREAMBLE___JJT_SET_PARENT__NODE = CONTENT___JJT_SET_PARENT__NODE;

	/**
	 * The number of operations of the '<em>Preamble</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREAMBLE_OPERATION_COUNT = CONTENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.emc.bibtex.impl.BibtexPublicationEntry <em>Publication Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexPublicationEntry
	 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexBibtexPackage#getPublicationEntry()
	 * @generated
	 */
	int PUBLICATION_ENTRY = 6;

	/**
	 * The feature id for the '<em><b>Bibliography</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLICATION_ENTRY__BIBLIOGRAPHY = ENTRY__BIBLIOGRAPHY;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLICATION_ENTRY__TAGS = ENTRY__TAGS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLICATION_ENTRY__TYPE = ENTRY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Citation Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLICATION_ENTRY__CITATION_KEY = ENTRY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Publication Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLICATION_ENTRY_FEATURE_COUNT = ENTRY_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Jjt Set Parent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLICATION_ENTRY___JJT_SET_PARENT__NODE = ENTRY___JJT_SET_PARENT__NODE;

	/**
	 * The number of operations of the '<em>Publication Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLICATION_ENTRY_OPERATION_COUNT = ENTRY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.epsilon.emc.bibtex.impl.BibtexStringEntry <em>String Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexStringEntry
	 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexBibtexPackage#getStringEntry()
	 * @generated
	 */
	int STRING_ENTRY = 7;

	/**
	 * The feature id for the '<em><b>Bibliography</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_ENTRY__BIBLIOGRAPHY = ENTRY__BIBLIOGRAPHY;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_ENTRY__TAGS = ENTRY__TAGS;

	/**
	 * The number of structural features of the '<em>String Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_ENTRY_FEATURE_COUNT = ENTRY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Jjt Set Parent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_ENTRY___JJT_SET_PARENT__NODE = ENTRY___JJT_SET_PARENT__NODE;

	/**
	 * The number of operations of the '<em>String Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_ENTRY_OPERATION_COUNT = ENTRY_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.emc.bibtex.AuthorTag <em>Author Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Author Tag</em>'.
	 * @see org.eclipse.epsilon.emc.bibtex.AuthorTag
	 * @generated
	 */
	EClass getAuthorTag();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.emc.bibtex.Bibliography <em>Bibliography</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bibliography</em>'.
	 * @see org.eclipse.epsilon.emc.bibtex.Bibliography
	 * @generated
	 */
	EClass getBibliography();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.emc.bibtex.Bibliography#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entries</em>'.
	 * @see org.eclipse.epsilon.emc.bibtex.Bibliography#getEntries()
	 * @see #getBibliography()
	 * @generated
	 */
	EReference getBibliography_Entries();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.emc.bibtex.Bibliography#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contents</em>'.
	 * @see org.eclipse.epsilon.emc.bibtex.Bibliography#getContents()
	 * @see #getBibliography()
	 * @generated
	 */
	EReference getBibliography_Contents();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.epsilon.emc.bibtex.Bibliography#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.epsilon.emc.bibtex.Bibliography#getName()
	 * @see #getBibliography()
	 * @generated
	 */
	EAttribute getBibliography_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.emc.bibtex.Comment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comment</em>'.
	 * @see org.eclipse.epsilon.emc.bibtex.Comment
	 * @generated
	 */
	EClass getComment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.emc.bibtex.Content <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Content</em>'.
	 * @see org.eclipse.epsilon.emc.bibtex.Content
	 * @generated
	 */
	EClass getContent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.epsilon.emc.bibtex.Content#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see org.eclipse.epsilon.emc.bibtex.Content#getContent()
	 * @see #getContent()
	 * @generated
	 */
	EAttribute getContent_Content();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.epsilon.emc.bibtex.Content#getBibliography <em>Bibliography</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Bibliography</em>'.
	 * @see org.eclipse.epsilon.emc.bibtex.Content#getBibliography()
	 * @see #getContent()
	 * @generated
	 */
	EReference getContent_Bibliography();

	/**
	 * Returns the meta object for the '{@link org.eclipse.epsilon.emc.bibtex.Content#jjtSetParent(org.eclipse.epsilon.emc.bibtex.parser.Node) <em>Jjt Set Parent</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Jjt Set Parent</em>' operation.
	 * @see org.eclipse.epsilon.emc.bibtex.Content#jjtSetParent(org.eclipse.epsilon.emc.bibtex.parser.Node)
	 * @generated
	 */
	EOperation getContent__JjtSetParent__Node();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.emc.bibtex.Entry <em>Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entry</em>'.
	 * @see org.eclipse.epsilon.emc.bibtex.Entry
	 * @generated
	 */
	EClass getEntry();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.epsilon.emc.bibtex.Entry#getBibliography <em>Bibliography</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Bibliography</em>'.
	 * @see org.eclipse.epsilon.emc.bibtex.Entry#getBibliography()
	 * @see #getEntry()
	 * @generated
	 */
	EReference getEntry_Bibliography();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.epsilon.emc.bibtex.Entry#getTags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tags</em>'.
	 * @see org.eclipse.epsilon.emc.bibtex.Entry#getTags()
	 * @see #getEntry()
	 * @generated
	 */
	EReference getEntry_Tags();

	/**
	 * Returns the meta object for the '{@link org.eclipse.epsilon.emc.bibtex.Entry#jjtSetParent(org.eclipse.epsilon.emc.bibtex.parser.Node) <em>Jjt Set Parent</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Jjt Set Parent</em>' operation.
	 * @see org.eclipse.epsilon.emc.bibtex.Entry#jjtSetParent(org.eclipse.epsilon.emc.bibtex.parser.Node)
	 * @generated
	 */
	EOperation getEntry__JjtSetParent__Node();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.emc.bibtex.Preamble <em>Preamble</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Preamble</em>'.
	 * @see org.eclipse.epsilon.emc.bibtex.Preamble
	 * @generated
	 */
	EClass getPreamble();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.emc.bibtex.PublicationEntry <em>Publication Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Publication Entry</em>'.
	 * @see org.eclipse.epsilon.emc.bibtex.PublicationEntry
	 * @generated
	 */
	EClass getPublicationEntry();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.epsilon.emc.bibtex.PublicationEntry#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.epsilon.emc.bibtex.PublicationEntry#getType()
	 * @see #getPublicationEntry()
	 * @generated
	 */
	EAttribute getPublicationEntry_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.epsilon.emc.bibtex.PublicationEntry#getCitationKey <em>Citation Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Citation Key</em>'.
	 * @see org.eclipse.epsilon.emc.bibtex.PublicationEntry#getCitationKey()
	 * @see #getPublicationEntry()
	 * @generated
	 */
	EAttribute getPublicationEntry_CitationKey();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.emc.bibtex.StringEntry <em>String Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Entry</em>'.
	 * @see org.eclipse.epsilon.emc.bibtex.StringEntry
	 * @generated
	 */
	EClass getStringEntry();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.emc.bibtex.Tag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tag</em>'.
	 * @see org.eclipse.epsilon.emc.bibtex.Tag
	 * @generated
	 */
	EClass getTag();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.epsilon.emc.bibtex.Tag#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.epsilon.emc.bibtex.Tag#getName()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_Name();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.epsilon.emc.bibtex.Tag#getEntry <em>Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Entry</em>'.
	 * @see org.eclipse.epsilon.emc.bibtex.Tag#getEntry()
	 * @see #getTag()
	 * @generated
	 */
	EReference getTag_Entry();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.epsilon.emc.bibtex.Tag#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.epsilon.emc.bibtex.Tag#getValue()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_Value();

	/**
	 * Returns the meta object for the '{@link org.eclipse.epsilon.emc.bibtex.Tag#jjtSetParent(org.eclipse.epsilon.emc.bibtex.parser.Node) <em>Jjt Set Parent</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Jjt Set Parent</em>' operation.
	 * @see org.eclipse.epsilon.emc.bibtex.Tag#jjtSetParent(org.eclipse.epsilon.emc.bibtex.parser.Node)
	 * @generated
	 */
	EOperation getTag__JjtSetParent__Node();

	/**
	 * Returns the meta object for class '{@link org.eclipse.epsilon.emc.bibtex.parser.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.eclipse.epsilon.emc.bibtex.parser.Node
	 * @model instanceClass="org.eclipse.epsilon.emc.bibtex.parser.Node"
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BibtexFactory getBibtexFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.emc.bibtex.impl.BibtexAuthorTag <em>Author Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexAuthorTag
		 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexBibtexPackage#getAuthorTag()
		 * @generated
		 */
		EClass AUTHOR_TAG = eINSTANCE.getAuthorTag();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.emc.bibtex.impl.BibtexBibliography <em>Bibliography</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexBibliography
		 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexBibtexPackage#getBibliography()
		 * @generated
		 */
		EClass BIBLIOGRAPHY = eINSTANCE.getBibliography();

		/**
		 * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BIBLIOGRAPHY__ENTRIES = eINSTANCE.getBibliography_Entries();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BIBLIOGRAPHY__CONTENTS = eINSTANCE.getBibliography_Contents();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIBLIOGRAPHY__NAME = eINSTANCE.getBibliography_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.emc.bibtex.impl.BibtexComment <em>Comment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexComment
		 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexBibtexPackage#getComment()
		 * @generated
		 */
		EClass COMMENT = eINSTANCE.getComment();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.emc.bibtex.impl.BibtexContent <em>Content</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexContent
		 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexBibtexPackage#getContent()
		 * @generated
		 */
		EClass CONTENT = eINSTANCE.getContent();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTENT__CONTENT = eINSTANCE.getContent_Content();

		/**
		 * The meta object literal for the '<em><b>Bibliography</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTENT__BIBLIOGRAPHY = eINSTANCE.getContent_Bibliography();

		/**
		 * The meta object literal for the '<em><b>Jjt Set Parent</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTENT___JJT_SET_PARENT__NODE = eINSTANCE.getContent__JjtSetParent__Node();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.emc.bibtex.impl.BibtexEntry <em>Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexEntry
		 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexBibtexPackage#getEntry()
		 * @generated
		 */
		EClass ENTRY = eINSTANCE.getEntry();

		/**
		 * The meta object literal for the '<em><b>Bibliography</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTRY__BIBLIOGRAPHY = eINSTANCE.getEntry_Bibliography();

		/**
		 * The meta object literal for the '<em><b>Tags</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTRY__TAGS = eINSTANCE.getEntry_Tags();

		/**
		 * The meta object literal for the '<em><b>Jjt Set Parent</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ENTRY___JJT_SET_PARENT__NODE = eINSTANCE.getEntry__JjtSetParent__Node();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.emc.bibtex.impl.BibtexPreamble <em>Preamble</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexPreamble
		 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexBibtexPackage#getPreamble()
		 * @generated
		 */
		EClass PREAMBLE = eINSTANCE.getPreamble();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.emc.bibtex.impl.BibtexPublicationEntry <em>Publication Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexPublicationEntry
		 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexBibtexPackage#getPublicationEntry()
		 * @generated
		 */
		EClass PUBLICATION_ENTRY = eINSTANCE.getPublicationEntry();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUBLICATION_ENTRY__TYPE = eINSTANCE.getPublicationEntry_Type();

		/**
		 * The meta object literal for the '<em><b>Citation Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUBLICATION_ENTRY__CITATION_KEY = eINSTANCE.getPublicationEntry_CitationKey();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.emc.bibtex.impl.BibtexStringEntry <em>String Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexStringEntry
		 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexBibtexPackage#getStringEntry()
		 * @generated
		 */
		EClass STRING_ENTRY = eINSTANCE.getStringEntry();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.emc.bibtex.impl.BibtexTag <em>Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexTag
		 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexBibtexPackage#getTag()
		 * @generated
		 */
		EClass TAG = eINSTANCE.getTag();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG__NAME = eINSTANCE.getTag_Name();

		/**
		 * The meta object literal for the '<em><b>Entry</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TAG__ENTRY = eINSTANCE.getTag_Entry();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG__VALUE = eINSTANCE.getTag_Value();

		/**
		 * The meta object literal for the '<em><b>Jjt Set Parent</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TAG___JJT_SET_PARENT__NODE = eINSTANCE.getTag__JjtSetParent__Node();

		/**
		 * The meta object literal for the '{@link org.eclipse.epsilon.emc.bibtex.parser.Node <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.epsilon.emc.bibtex.parser.Node
		 * @see org.eclipse.epsilon.emc.bibtex.impl.BibtexBibtexPackage#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

	}

} //BibtexPackage
