package util;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

/**
 * 
 * @author Javier Espinazo Pagán http://modelum.es/trac/morsa/
 * 
 */
public class ArangoResource {

	private int registered = 0;

	// registers metamodel
	/**
	 * Iterates through the descendants of a package and registers all the
	 * subpackages (as well as the root)
	 * 
	 * @param root
	 */
	public int registerPackages(EPackage root) {
		if (!root.getNsURI().equals(EcorePackage.eNS_URI)) {

			if (EPackage.Registry.INSTANCE.put(root.getNsURI(), root) != null)
				;
			registered++;

			for (EPackage pkg : root.getESubpackages()) {
				registerPackages(pkg);
			}

		}
		return registered;
	}

}
