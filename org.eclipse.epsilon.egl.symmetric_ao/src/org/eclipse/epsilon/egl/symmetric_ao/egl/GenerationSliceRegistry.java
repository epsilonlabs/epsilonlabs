/*******************************************************************************
 * Copyright (c) 2010 Lancaster University.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Steffen Zschaler -- Initial Implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.egl.symmetric_ao.egl;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.epsilon.egl.symmetric_ao.tasks.MergeStrategy;

/**
 * Singleton registry of code slices generated and registered for later merging.
 * 
 * @author zschaler
 */
public class GenerationSliceRegistry {

	private static final class FileFeature {
		public String sFeatureName;
		public String sContents;

		public FileFeature(String sFeatureName, String sContents) {
			this.sFeatureName = sFeatureName;
			this.sContents = sContents;
		}
	}

	/**
	 * The map used to store registry data.
	 */
	private Map<File, List<FileFeature>> registry = new HashMap<File, List<FileFeature>>();

	/**
	 * Register the given contents against the given file for later merge.
	 * 
	 * @param file
	 * @param contents
	 */
	public void register(File file, String contents) {
		register(file, null, contents);
	}

	/**
	 * Register the given contents against the given file for later merge.
	 * 
	 * @param file
	 * @param feature
	 *            a feature name useful for ordering the text streams to be
	 *            merged later on
	 *            {@link GenerationSliceRegistry#merge(File, MergeStrategy, Comparator)}
	 * @param contents
	 */
	public void register(File file, String feature, String contents) {
		List<FileFeature> lsFileContents = registry.get(file);
		if (lsFileContents == null) {
			lsFileContents = new ArrayList<FileFeature>();
			registry.put(file, lsFileContents);
		}
		lsFileContents.add(new FileFeature(feature, contents));
	}

	/**
	 * Merge the given file based on the contents registered for it. After this
	 * call, no contents will be registered for the indicated file anymore.
	 * 
	 * @param file
	 *            the file to be merged
	 * @param merger
	 *            the merge strategy to use for the merging
	 * @param fForRegister
	 *            if true, the result is meant to be registered as a code slice
	 *            again rather than be written to a file. This parameter is
	 *            simply forwarded to the merge strategy. Notice that
	 *            <code>merge</code> does not actually result in the code being
	 *            written to a file or re-registered with the registry in any
	 *            case. However, some merge strategies may want to behave
	 *            differently for code that is to be written to a file as
	 *            opposed to code that will be placed back in the registry.
	 * @param comp
	 *            a comparator that sorts feature names to determine the order
	 *            in which features should be merged. Note that feature names
	 *            can be null if unnamed features have been registered.
	 * 
	 * @return the merged contents
	 */
	public String merge(File file, MergeStrategy merger, boolean fForRegister,
			final Comparator<String> comp) throws FileNotRegisteredException {
		List<FileFeature> lFeatures = registry.remove(file);
		if (lFeatures == null) {
			throw new FileNotRegisteredException(file);
		}

		Collections.sort(lFeatures, new Comparator<FileFeature>() {
			@Override
			public int compare(FileFeature o1, FileFeature o2) {
				if (comp == null) {
					return 0;
				}
				return comp.compare(o1.sFeatureName, o2.sFeatureName);
			}
		});

		return merger.merge(extractContents(lFeatures), fForRegister);
	}

	/**
	 * Extract the contents element for every feature in the list.
	 * 
	 * @param lFeatureList
	 * @return
	 */
	private List<String> extractContents(List<FileFeature> lFeatureList) {
		List<String> lsResult = new ArrayList<String>();
		for (FileFeature ff : lFeatureList) {
			lsResult.add(ff.sContents);
		}
		return lsResult;
	}

	/**
	 * Returns an unmodifiable iterator that lists all registered files *
	 */
	public Iterator<File> iterator() {
		return Collections
				.unmodifiableSet(new HashSet<File>(registry.keySet()))
				.iterator();
	}
}