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
package org.eclipse.epsilon.egl.symmetric_ao.tasks;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.types.FileSet;
import org.apache.tools.ant.types.PatternSet;
import org.apache.tools.ant.types.selectors.SelectorUtils;
import org.eclipse.epsilon.egl.symmetric_ao.egl.GenerationSliceRegistry;
import org.eclipse.epsilon.workflow.tasks.EpsilonTask;

/**
 * Complement AORegisterTask by merging previously registered contents and
 * writing them to their respective files.
 * 
 * @author zschaler
 */
public class AOMergeTask extends EpsilonTask {

	public static class Order {
		private String sFirstFeature;
		private String sSecondFeature;

		public Order() {
		}

		public Order(String first, String second) {
			setFirst(first);
			setSecond(second);
		}

		public void setFirst(String sFirst) {
			sFirstFeature = sFirst;
		}

		public void setSecond(String sSecond) {
			sSecondFeature = sSecond;
		}

		public String getFirst() {
			return sFirstFeature;
		}

		public String getSecond() {
			return sSecondFeature;
		}

		public boolean check() {
			return (sFirstFeature != null) && (sSecondFeature != null);
		}
	}

	public static class BasicMerge implements MergeStrategy {
		public String merge(List<String> toMerge, boolean fForRegister) {
			StringBuffer sbResult = new StringBuffer();
			for (String sCurrent : toMerge) {
				sbResult.append(sCurrent);
				sbResult.append('\n');
			}
			return sbResult.toString();
		}

		private static BasicMerge instance;

		public static BasicMerge getInstance() {
			if (instance == null) {
				instance = new BasicMerge();
			}
			return instance;
		}
	}

	/**
	 * Representation of the nested file element. This is based off of ANT's
	 * standard file sets, so it should support all of their properties
	 * including wildcards and stuff.
	 * 
	 * @author zschaler
	 */
	public class FileToMerge extends FileSet {
		/**
		 * If true, simply re-register merge results under their file name. This
		 * can be useful for hierarchical generator modules. The merged code
		 * will be registered using feature {@link #feature}.
		 */
		private boolean register = false;
		private String feature;
		private MergeStrategy strategy;

		public void setRegister(String feature) {
			this.register = true;
			this.feature = feature;
		}

		public String getRegister() {
			return feature;
		}

		public MergeStrategy createConcatenate() {
			if (strategy != null) {
				fail("Only one merge strategy allowed!",
						new IllegalStateException(
								"Only one merge strategy allowed!"));
			}
			strategy = BasicMerge.getInstance();
			return strategy;
		}

		/**
		 * This allows new strategies to be defined using <typedef> and then
		 * used inside AOMergeTask.
		 * 
		 * @param strategy
		 */
		public void addConfigured(MergeStrategy strategy) {
			if (this.strategy != null) {
				fail("Only one merge strategy allowed!",
						new IllegalStateException(
								"Only one merge strategy allowed!"));
			}
			this.strategy = strategy;
		}

		/*
		 * REMOVED TO SEPARATE PROJECTS FOR COPYRIGHT REASONS. public
		 * MergeStrategy createSuperimpose() { if (strategy != null) {
		 * fail("Only one merge strategy allowed!"); } strategy = new
		 * SuperimpositionMerge(getProject()); return strategy; }
		 */

		public MergeStrategy getStrategy() {
			if (strategy == null) {
				createConcatenate();
			}
			return strategy;
		}

		/**
		 * Perform the actual merge for this file set.
		 */
		public void merge() {
			/*
			 * Here, we have to abuse FileSet a bit. Using the standard iterator
			 * provided doesn't work, because it would actually try to find the
			 * files in the file system. Instead, we need an iterator over the
			 * files registered that gets only those files matching the pattern
			 * set.
			 */
			final GenerationSliceRegistry registry = RegistryUtil
					.getRegistryFor(getProject());
			PatternSet psMerged = mergePatterns(getProject());
			final String[] saIncludePatterns = psMerged
					.getIncludePatterns(getProject());
			final String[] saExcludePatterns = psMerged
					.getExcludePatterns(getProject());
			Iterator<File> it = new Iterator<File>() {
				private Iterator<File> base = registry.iterator();
				private File fNext;

				@Override
				public boolean hasNext() {
					getNext();
					return (fNext != null);
				}

				@Override
				public File next() {
					getNext();
					if (fNext != null) {
						File fReturn = fNext;
						fNext = null;
						return fReturn;
					} else {
						throw new NoSuchElementException();
					}
				}

				private void getNext() {
					if (fNext != null)
						return;

					while (base.hasNext()) {
						File fTentative = base.next();

						if (match(fTentative)) {
							fNext = fTentative;
							return;
						}
					}
				}

				private boolean match(File f) {
					String sPath = f.getPath();

					return (isIncluded(sPath) && !isExcluded(sPath));
				}

				private boolean isIncluded(String sPath) {
					if (saIncludePatterns == null)
						return true;
					for (String sPattern : saIncludePatterns) {
						if (SelectorUtils.matchPath(sPattern, sPath,
								isCaseSensitive())) {
							return true;
						}
					}
					return false;
				}

				private boolean isExcluded(String sPath) {
					if (saExcludePatterns == null)
						return false;
					for (String sPattern : saExcludePatterns) {
						if (SelectorUtils.matchPath(sPattern, sPath,
								isCaseSensitive())) {
							return true;
						}
					}
					return false;
				}

				@Override
				public void remove() {
					throw new UnsupportedOperationException(
							"Removing not supported for this iterator.");
				}
			};

			while (it.hasNext()) {
				merge(it.next());
			}
		}

		/**
		 * Perform the actual merge for the indicated file.
		 */
		public void merge(File fToMerge) {
			FileOutputStream fos = null;
			try {
				GenerationSliceRegistry registry = RegistryUtil
						.getRegistryFor(getProject());

				String sMergedContents = registry.merge(fToMerge,
						getStrategy(), register, ((msssTransitiveOrder.isEmpty()) ? null
								: new Comparator<String>() {
									@Override
									public int compare(String s1, String s2) {
										if ((s1 == null) || (s2 == null)) {
											return 0;
										}

										return isOrdered(s1, s2) ? 1
												: (isOrdered(s2, s1) ? -1 : 0);
										/*
										 * for (Order o : lOrder) { if
										 * (s1.equals(o.getFirst())) { if
										 * (s2.equals(o.getSecond())) { return
										 * 1; } } if (s1.equals(o.getSecond()))
										 * { if (s2.equals(o.getFirst())) {
										 * return -1; } } } // transitivity is
										 * handled by first // computing the
										 * transitive closure... return 0;
										 */
									}
								}));

				if (register) {
					RegistryUtil.getRegistryFor(getProject()).register(
							fToMerge,
							(((getRegister() == null) || (getRegister()
									.equals(""))) ? null : getRegister()),
							sMergedContents);
				} else {
					fos = new FileOutputStream(fToMerge);

					fos.write(sMergedContents.getBytes());

					fos.flush();
				}
			} catch (Exception e) {
				fail(e.getMessage() + "\n" + e.getStackTrace()[0].toString(), e);
			} finally {
				if (fos != null) {
					try {
						fos.close();
					} catch (IOException e) {
						fail(e.getMessage(), e);
					}
				}
			}
		}
	}

	private List<FileToMerge> lFiles = new ArrayList<FileToMerge>();
	// private List<Order> lOrder = new ArrayList<Order>();

	/**
	 * Set of all features for which ordering information has been provided.
	 */
	private Set<String> sFeatures = new HashSet<String>();

	/**
	 * Complete transitivity information. This will be filled in by
	 * {@link #computeTransitiveClosure()} before asking merges to be performed.
	 * This map should be used by merge algorithms to determine merging orders.
	 * 
	 * The map should be interpreted as follows: Keys come before everything in
	 * the set of associated values. Do not use this map directly. Instead, call
	 * {@link #isOrdered(String, String)} to determine ordering.
	 */
	private Map<String, Set<String>> msssTransitiveOrder = new HashMap<String, Set<String>>();

	@Override
	public void executeImpl() throws BuildException {
		// lOrder = transitiveClosure(lOrder);

		// Ensure transitive closure will be computed from scratch the first
		// time ordering information is required.
		computeTransitiveClosure();
		for (FileToMerge fCurrent : lFiles) {
			fCurrent.merge();
		}
	}

	/**
	 * An adaptation of {@see
	 * http://www.cs.nmsu.edu/~ipivkina/TransClosure/index.html Warshall's
	 * algorithm} for our scenario. This will fill {@link #msssTransitiveOrder}
	 * with data.
	 */
	private void computeTransitiveClosure() {
		// Now start computing the transitive closure
		for (String sSecond : sFeatures) {
			for (String sFirst : sFeatures) {
				if (isOrdered(sFirst, sSecond)) {
					Set<String> sFirsts = msssTransitiveOrder.get(sFirst);
					Set<String> sSeconds = msssTransitiveOrder.get(sSecond);
					msssTransitiveOrder.put(sFirst, union(sFirsts, sSeconds));
				}
			}
		}
	}

	private Set<String> union(Set<String> sLeft, Set<String> sRight) {
		if (sLeft == null) {
			return sRight;
		}
		if (sRight == null) {
			return sLeft;
		}
		Set<String> sResult = new HashSet<String>(sLeft);
		sResult.addAll(sRight);
		return sResult;
	}

	/**
	 * Return true if feature sFirst should come before feature sSecond.
	 * 
	 * @param sFirst
	 * @param sSecond
	 * @return
	 */
	public boolean isOrdered(String sFirst, String sSecond) {
		Set<String> sSeconds = msssTransitiveOrder.get(sFirst);
		return ((sSeconds != null) && (sSeconds.contains(sSecond)));
	}

	/*
	 * // Compute transitive closure of the order relationship private
	 * List<Order> transitiveClosure(List<Order> order) { List<Order> order1 =
	 * order;
	 * 
	 * do { order = order1; order1 = transitiveClosure1(order); } while
	 * (order1.size() > order.size());
	 * 
	 * return order1; }
	 * 
	 * // One step of the transitive closure computation private List<Order>
	 * transitiveClosure1(List<Order> order) { List<Order> loResult = new
	 * ArrayList<Order>(order);
	 * 
	 * // TODO: This algorithm is completely messed up as it will not terminate
	 * // if there is at least one transitive step to be added for (Order o1 :
	 * order) { // Find all elements that have a first that is o1.second for
	 * (Order o2 : order) { if (o2.getFirst().equals(o1.getSecond())) { // Add
	 * transitive step loResult.add(new Order(o1.getFirst(), o2.getSecond())); }
	 * } }
	 * 
	 * return loResult; }
	 */

	public FileToMerge createFile() {
		FileToMerge f = new FileToMerge();
		lFiles.add(f);
		return f;
	}

	public void addConfiguredOrder(Order o) {
		if (o.check()) {
			// lOrder.add(o);
			String sFirst = o.getFirst();
			String sSecond = o.getSecond();

			Set<String> sSeconds = msssTransitiveOrder.get(sFirst);
			if (sSeconds == null) {
				sSeconds = new HashSet<String>();
				msssTransitiveOrder.put(sFirst, sSeconds);
			}
			sSeconds.add(sSecond);

			sFeatures.add(sFirst);
			sFeatures.add(sSecond);
		} else {
			throw new IllegalStateException(
					"Order must have both first and second.");
		}
	}
}