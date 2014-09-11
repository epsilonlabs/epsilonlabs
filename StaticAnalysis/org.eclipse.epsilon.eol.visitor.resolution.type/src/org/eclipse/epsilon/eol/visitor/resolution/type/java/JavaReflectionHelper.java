package org.eclipse.epsilon.eol.visitor.resolution.type.java;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class JavaReflectionHelper {

	protected String className;
	protected ClassLoader classLoader;

	public static void main(String[] args) {
		String className = "org.eclipse.epsilon.eol.visitor.resolution.type.java.JavaClassLoader";
		JavaReflectionHelper loader = new JavaReflectionHelper("org.eclipse.epsilon.eol.visitor.resolution.type.java.JavaClassLoader");
		System.out.println(loader.loadClass());
		
		Class<?> clazz = null;
		try {
			clazz = Class.forName(className);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Constructor<?> constructor = null;
		try {
			constructor = clazz.getConstructor(null);
//			constructor = clazz.getConstructor(String.class);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Object object = constructor.newInstance(null);
			System.out.println(object);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	public JavaReflectionHelper(String name)
	{
		className = name;
		classLoader = this.getClass().getClassLoader();
	}
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	public String getClassName() {
		return className;
	}
	
	public boolean loadClass()
	{
		try {
			classLoader.loadClass(className);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public static boolean hasMethods(Object obj, String methodName) {
		
		if (obj == null) return false;
		
		for (Method method : obj.getClass().getMethods()) {
			if (getMethodName(method).equals(methodName)) {
				return true;
			}
		}
		return false;
	}
	
	protected static String getMethodName(Method method) {
		String methodName = method.getName();
		if (methodName.startsWith("_"))
		{
			methodName = methodName.substring(1);
		}
		return methodName;
	}
	
	public static Set<String> getMethodNames(Object obj, boolean includeInheritedMethods) {
		
		HashSet<String> methodNames = new HashSet<String>();
		
		if (obj == null) return methodNames;
		
		Method[] methods = null;
		
		if (includeInheritedMethods) {
			methods = obj.getClass().getMethods();
		}
		else {
			methods = obj.getClass().getDeclaredMethods();
		}
		
		for (int i=0;i<methods.length;i++) {
			methodNames.add(getMethodName(methods[i]));
		}
		
		return methodNames;
	}

}
