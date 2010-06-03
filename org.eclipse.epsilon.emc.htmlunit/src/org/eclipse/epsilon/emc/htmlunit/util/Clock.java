package org.eclipse.epsilon.emc.htmlunit.util;

public class Clock {

	long time;

	public void start() {
		time = System.currentTimeMillis();
	}

	public void stop(String header) {
		System.err
				.println(header + " : " + (System.currentTimeMillis() - time));
	}

}