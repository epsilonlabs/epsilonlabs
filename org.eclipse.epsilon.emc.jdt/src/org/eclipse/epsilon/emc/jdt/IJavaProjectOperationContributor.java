package org.eclipse.epsilon.emc.jdt;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;

public class IJavaProjectOperationContributor extends OperationContributor {

	@Override
	public boolean contributesTo(Object target) {
		return target instanceof IJavaProject;
	}
	
	public IJavaProject getJavaProject() {
		return (IJavaProject) target;
	}

	public ArrayList<IPackageFragment> getSourcePackages() throws JavaModelException {
		return getPackages(IPackageFragmentRoot.K_SOURCE);
	}
	
	public ArrayList<IPackageFragment> getBinaryPackages() throws JavaModelException {
		return getPackages(IPackageFragmentRoot.K_BINARY);
	}
	
	protected ArrayList<IPackageFragment> getPackages(int type) throws JavaModelException {
		ArrayList<IPackageFragment> packageFragments = new ArrayList<>();
		for (IPackageFragment pf : getJavaProject().getPackageFragments()) {
			if (pf.getKind() == type) {
				packageFragments.add(pf);
			}
		}
		return packageFragments;
	}
}
