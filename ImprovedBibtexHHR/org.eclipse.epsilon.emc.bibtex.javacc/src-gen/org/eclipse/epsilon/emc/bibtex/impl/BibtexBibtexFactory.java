/**
 */
package org.eclipse.epsilon.emc.bibtex.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.epsilon.emc.bibtex.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BibtexBibtexFactory extends EFactoryImpl implements BibtexFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BibtexFactory init() {
		try {
			BibtexFactory theBibtexFactory = (BibtexFactory)EPackage.Registry.INSTANCE.getEFactory(BibtexPackage.eNS_URI);
			if (theBibtexFactory != null) {
				return theBibtexFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BibtexBibtexFactory();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BibtexBibtexFactory() {
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
			case BibtexPackage.BIBLIOGRAPHY: return createBibliography();
			case BibtexPackage.COMMENT: return createComment();
			case BibtexPackage.PREAMBLE: return createPreamble();
			case BibtexPackage.PUBLICATION_ENTRY: return createPublicationEntry();
			case BibtexPackage.STRING_ENTRY: return createStringEntry();
			case BibtexPackage.TAG: return createTag();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bibliography createBibliography() {
		BibtexBibliography bibliography = new BibtexBibliography();
		return bibliography;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Comment createComment() {
		BibtexComment comment = new BibtexComment();
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Preamble createPreamble() {
		BibtexPreamble preamble = new BibtexPreamble();
		return preamble;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PublicationEntry createPublicationEntry() {
		BibtexPublicationEntry publicationEntry = new BibtexPublicationEntry();
		return publicationEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringEntry createStringEntry() {
		BibtexStringEntry stringEntry = new BibtexStringEntry();
		return stringEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tag createTag() {
		BibtexTag tag = new BibtexTag();
		return tag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BibtexPackage getBibtexPackage() {
		return (BibtexPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BibtexPackage getPackage() {
		return BibtexPackage.eINSTANCE;
	}

} //BibtexBibtexFactory
