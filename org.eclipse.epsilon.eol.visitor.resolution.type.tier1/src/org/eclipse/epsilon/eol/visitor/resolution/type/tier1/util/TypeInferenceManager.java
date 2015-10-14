package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.analysis.model.driver.IMetamodelDriver;
import org.eclipse.epsilon.analysis.model.driver.IPackageDriver;
import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.CollectionType;
import org.eclipse.epsilon.eol.metamodel.EolFactory;
import org.eclipse.epsilon.eol.metamodel.ModelElementType;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.PrimitiveType;
import org.eclipse.epsilon.eol.metamodel.Type;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class TypeInferenceManager {
	
	private static TypeInferenceManager instance = null;

	protected TypeInferenceManager()
	{
	}
	
	public static TypeInferenceManager getInstance()
	{
		if (instance == null) {
			instance = new TypeInferenceManager();
		}
		return instance;
	}
	
	
	public ArrayList<Type> getCommonTypesForTwoAnys(AnyType anyType1, AnyType anyType2)
	{
		ArrayList<Type> result = new ArrayList<Type>();
		
		ArrayList<Type> dynTypes1 = new ArrayList<Type>();
		ArrayList<Type> dynTypes2 = new ArrayList<Type>();
		
		if (TypeUtil.getInstance().isInstanceofAnyType(anyType1)) {
			dynTypes1.addAll(EcoreUtil.copyAll(anyType1.getDynamicTypes()));
		}
		else {
			dynTypes1.add(EcoreUtil.copy(anyType1));
		}
		
		if (TypeUtil.getInstance().isInstanceofAnyType(anyType2)) {
			dynTypes2.addAll(EcoreUtil.copyAll(anyType2.getDynamicTypes()));
		}
		else {
			dynTypes2.add(EcoreUtil.copy(anyType2));
		}
		
		for(Type t1: dynTypes1)
		{
			for(Type t2: dynTypes2)
			{
				Type common = getLeastCommonType(t1, t2);
				if (common != null) {
					result.add(common);
				}
			}
		}
		return result;
		
	}
	
	
	public static void main(String[] args) {
		Type t1 = EolFactory.eINSTANCE.createRealType();
		Type t2 = EolFactory.eINSTANCE.createIntegerType();
		Type t3 = EolFactory.eINSTANCE.createStringType();
		
		System.out.println(t1.eClass());
		System.out.println(t2.eClass());
		System.out.println(t3.eClass());
		
		if (t1.eClass().isSuperTypeOf(t2.eClass())) {
			System.out.println("trueeeeeeee");
		}
		
		System.out.println(t3.eClass().isSuperTypeOf(t1.eClass()));
		
		TypeInferenceManager typeInferenceManager = new TypeInferenceManager();
		System.out.println(typeInferenceManager.getLeastCommonTypeOf(t2.eClass(), t1.eClass()));
	}
	
	public ArrayList<Type> getTypesForName(NameExpression nameExpression)
	{
		Object resolvedContent = nameExpression.getResolvedContent();
		if (resolvedContent != null && resolvedContent instanceof VariableDeclarationExpression) {
			VariableDeclarationExpression vde = (VariableDeclarationExpression) resolvedContent;
			return TypeResolutionContext.getInstanace().getTypeRegistry().getTypesForVariable(vde);
		}
		return null;
	}
	
	public boolean containsDynamicType(AnyType anyType, EClass typeUnderQuestion)
	{
		for(Type dynType: anyType.getDynamicTypes())
		{
			if (typeUnderQuestion.isSuperTypeOf(dynType.eClass()) || typeUnderQuestion.equals(dynType.eClass())) {
				return true;
			}
		}
		return false;
	}
	
	public Type getDynamicType(AnyType anyType, EClass typeUnderQuestion)
	{
		for(Type dynType: anyType.getDynamicTypes())
		{
			if (typeUnderQuestion.isSuperTypeOf(dynType.eClass()) || typeUnderQuestion.equals(dynType.eClass())) {
				return dynType;
			}
		}
		return null;
	}
	
	public Type inferType(AnyType anyType)
	{
		Type result = null;
		for(Type t: anyType.getDynamicTypes())
		{
			result = getLeastCommonType(result, t);
		}
		
		if (result == null) {
			return anyType;
		}
		else {
			return result;
		}
	}
	
	public Type inferType(ArrayList<Type> types)
	{
		Type result = null;
		for(Type t: types)
		{
			result = getLeastCommonType(result, t);
		}
		return result;
	}
	
	public boolean isRightCompatibleToLeft(Type left, AnyType right)
	{
		for(Type t : right.getDynamicTypes())
		{
			if (TypeUtil.getInstance().isTypeEqualOrGeneric(t, left)) {
				return true;
			}
		}
		return false;
	}
	
	public Type inferType(AnyType anyType, String property)
	{
		return null;
	}
	
	public Type getLeastCommonType(Type t1, Type t2)
	{
		if (t1 == null) {
			return EcoreUtil.copy(t2);
		}
		else {
			if (t2 == null) {
				return EcoreUtil.copy(t1);
			}
		}
		
		if (t1 instanceof PrimitiveType && t2 instanceof PrimitiveType) {
			return getLeastCommonPrimitiveType((PrimitiveType)t1, (PrimitiveType)t2);
		}
		else if (t1 instanceof CollectionType && t2 instanceof CollectionType) {
			return getLeastCommonCollectionType((CollectionType)t1, (CollectionType)t2);
		}
		else if (t1 instanceof ModelElementType && t2 instanceof ModelElementType) {
			return getLeastCommonModelElementType((ModelElementType)t1, (ModelElementType)t2);
		}
		return null;
	}
	
	public Type getLeastCommonCollectionType(CollectionType t1, CollectionType t2)
	{
		if (t1.getClass().equals(t2.getClass())) {
			if (t1.getContentType() != null) {
				if (t2.getContentType() != null) {
					Type c1 = t1.getContentType();
					Type c2 = t2.getContentType();
					if (c1 instanceof PrimitiveType && c2 instanceof PrimitiveType) {
						Type contentType = getLeastCommonPrimitiveType((PrimitiveType)c1, (PrimitiveType)c2);
						if (contentType != null) {
							CollectionType returnType = EcoreUtil.copy(t1);
							returnType.setContentType(EcoreUtil.copy(contentType));
							return returnType;
						}
					}
					else if (c1 instanceof ModelElementType && c2 instanceof ModelElementType) {
						Type contentType = getLeastCommonModelElementType((ModelElementType)c1, (ModelElementType)c2);
						if (contentType != null) {
							CollectionType returnType = EcoreUtil.copy(t1);
							returnType.setContentType(EcoreUtil.copy(contentType));
							return returnType;
						}
					}
					else if (c1 instanceof CollectionType && c2 instanceof CollectionType) {
						Type t = getLeastCommonCollectionType((CollectionType)c1, (CollectionType)c2);
						if (t!= null) {
							
						}
						CollectionType returnType = EcoreUtil.copy(t1);
						returnType.setContentType(EcoreUtil.copy(t));
						return returnType;
					}
				}
				else {
					return EcoreUtil.copy(t1);
				}
			}
			else {
				if (t2.getContentType() != null) {
					return EcoreUtil.copy(t2);
				}
			}
		}
		return null;
	}
	
	public ModelElementType getLeastCommonModelElementType(ModelElementType t1, ModelElementType t2)
	{
		EClass eClass1 = (EClass) t1.getModelType();
		EClass eClass2 = (EClass) t2.getModelType();

		if (eClass1.eClass().isSuperTypeOf(eClass2.eClass())) {
			return EcoreUtil.copy(t1);
		}
		else if (eClass2.eClass().isSuperTypeOf(eClass1.eClass())) {
			return EcoreUtil.copy(t2);
		}
		else {
			EClass result = getLeastCommonTypeOf(eClass1, eClass2);
			if(result != null)
			{
				TypeResolutionContext context = TypeResolutionContext.getInstanace();
				for(IMetamodelDriver iMetamodelDriver : context.getiMetamodelManager().getiMetamodelDrivers())
				{
					for(IPackageDriver iPackageDriver: iMetamodelDriver.getIPackageDrivers()) {
						if (iPackageDriver.getClass(result.getName()).equals(result)) {
							ModelElementType modelElementType = EolFactory.eINSTANCE.createModelElementType();
							modelElementType.setModelType(result);
							modelElementType.setElementName(result.getName());
							modelElementType.setModelName(iMetamodelDriver.getName());
							return modelElementType;
						}
					}
				}
				return null;
			}
			else {
				return null;
			}
		}
	}
	
	public Type getLeastCommonPrimitiveType(PrimitiveType t1, PrimitiveType t2)
	{
		if (t1.eClass().isSuperTypeOf(t2.eClass())) {
			return EcoreUtil.copy(t1);
		}
		else if (t2.eClass().isSuperTypeOf(t1.eClass())) {
			return EcoreUtil.copy(t2);
		}
		else {
			return null;
		}
	}
	
	public HashSet<EClass> getCommonTypesOf(EClass t1, EClass t2)
	{
		HashSet<EClass> result = new HashSet<EClass>();
		if (t1.isSuperTypeOf(t2)) {
			result.add(t1);
		}
		if (t2.isSuperTypeOf(t1)) {
			result.add(t2);
		}
		
		for(EClass eClass: t1.getEAllSuperTypes())
		{
			if (eClass.isSuperTypeOf(t2)) {
				result.add(eClass);
			}
		}
		for(EClass eClass: t2.getEAllSuperTypes())
		{
			if (eClass.isSuperTypeOf(t1)) {
				result.add(eClass);
			}
		}
		return result;
	}

	
	public EClass getLeastCommonTypeOf(EClass t1, EClass t2)
	{
		HashMap<EClass, Integer> result = new HashMap<EClass, Integer>();
		for(EClass commonType: getCommonTypesOf(t1, t2))
		{
			int temp = 0;
			temp = TypeUtil.getInstance().shortestDistanceBetweenClass(t1, commonType);
			temp = TypeUtil.getInstance().shortestDistanceBetweenClass(t2, commonType);
			result.put(commonType, temp);
		}
		EClass least = null;
		int count = 9999;
		for(EClass eClass: result.keySet())
		{
			int sum = result.get(eClass);
			if (sum < count) {
				least = eClass;
				count = sum;
			}
		}
		return least;
	}

}
