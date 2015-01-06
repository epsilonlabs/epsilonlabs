/*******************************************************************************
 * Copyright (c) 2015 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.web.extractors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExtractor implements IExtractor {

	private final Pattern pattern;
	
	public RegexExtractor(String pattern) {
		this.pattern = Pattern.compile(pattern);
	}
	
	@Override
	public String extract(String value) {
		Matcher matcher = pattern.matcher(value);
			
		if (matcher.find()) {
			return matcher.group(1);
		} else {
			return value;
		}
	}
}
