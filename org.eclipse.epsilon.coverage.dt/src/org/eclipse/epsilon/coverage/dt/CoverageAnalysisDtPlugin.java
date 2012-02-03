package org.eclipse.epsilon.coverage.dt;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class CoverageAnalysisDtPlugin extends AbstractUIPlugin {

	//The shared instance.
	private static CoverageAnalysisDtPlugin plugin;

	/**
	 * The constructor.
	 */
	public CoverageAnalysisDtPlugin() {
		plugin = this;
	}

	public void start(BundleContext bundleContext) throws Exception {
		super.start(bundleContext);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		super.stop(bundleContext);
		plugin = null;
	}
	
	/**
	 * Returns the shared instance.
	 */
	public static CoverageAnalysisDtPlugin getDefault() {
		return plugin;
	}
	
	/**
	 * This method returns an image from the path
	 * @param path
	 * @return
	 */
	public static Image createImage(String path) {
		try {
			URL BASE_URL = CoverageAnalysisDtPlugin.getDefault().getBundle().getEntry("/");
			URL url = new URL(BASE_URL, path);
			return ImageDescriptor.createFromURL(url).createImage();
		}
		catch(MalformedURLException e) {}
		return null;
	}
}
