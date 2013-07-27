package org.eclipse.epsilon.epsilonoid;

import android.app.Application;
import android.util.Log;

public class Epsilonoid extends Application {
	
	private static Epsilonoid instance;
	
	public static Epsilonoid getInstance() {
		return instance;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		Log.d("", "created");
	}
	
}
