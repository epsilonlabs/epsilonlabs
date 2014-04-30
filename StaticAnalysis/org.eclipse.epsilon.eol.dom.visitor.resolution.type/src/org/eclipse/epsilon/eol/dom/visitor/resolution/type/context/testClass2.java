package org.eclipse.epsilon.eol.dom.visitor.resolution.type.context;

import java.util.ArrayList;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.epsilon.eol.metamodel.impl.EolFactoryImpl;

public class testClass2 {

	public static void main(String[] args) {
		EolFactory factory = new EolFactoryImpl();
		
		ArrayList<Type> types = new ArrayList<Type>();
		types.add(factory.createBagType());
		types.add(factory.createBooleanType());
		types.add(factory.createSetType());
		types.add(factory.createSequenceType());
		types.add(factory.createBagType());
		
		for(Type t: types)
		{
			System.out.println(t.getClass());
		}
		
		Type t1 = types.get(0);
		Type t2 = types.get(3);
		
		System.out.println(t1.getClass() == t1.getClass());
		
		
		System.out.println(factory.createIntegerType() instanceof PrimitiveType);
	}
	
	
}
