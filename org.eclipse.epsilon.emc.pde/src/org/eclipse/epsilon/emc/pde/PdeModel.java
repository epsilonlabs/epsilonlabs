package org.eclipse.epsilon.emc.pde;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.core.runtime.IBundleGroup;
import org.eclipse.core.runtime.IBundleGroupProvider;
import org.eclipse.core.runtime.Platform;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.java.JavaModel;
import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.osgi.service.resolver.PlatformAdmin;
import org.osgi.framework.Bundle;

public class PdeModel extends JavaModel {
	
	public PdeModel() {
		super(new ArrayList<Object>(), Arrays.asList(BundleDescription.class));
	}
	
	@Override
	public void load(StringProperties properties, String basePath)
			throws EolModelLoadingException {
		super.load(properties, basePath);
		load();
	}
	
	public PlatformAdmin getPlatformAdmin() {
		return Platform.getPlatformAdmin();
	}
	
	@Override
	public void load() throws EolModelLoadingException {
		super.load();
		objects.addAll(Arrays.asList(Platform.getPlatformAdmin().getState(false).getBundles()));
	}
	
	public static void main(String[] args) {
		
	}
	

	
}
