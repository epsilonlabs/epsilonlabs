package org.eclipse.epsilon.emc.ldo;

public class SimpleTimer {
	
	protected long start = -1;
	protected String task = "";
	
	public void start(String task) {
		this.task = task;
		this.start = System.currentTimeMillis();
	}
	
	public void stop() {
		System.err.println(task + ": " + (System.currentTimeMillis() - start));
	}
	
}
