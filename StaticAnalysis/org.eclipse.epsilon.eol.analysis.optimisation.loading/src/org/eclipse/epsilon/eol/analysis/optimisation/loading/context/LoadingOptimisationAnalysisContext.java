package org.eclipse.epsilon.eol.analysis.optimisation.loading.context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import org.eclipse.epsilon.eol.metamodel.AssignmentStatement;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.FOLMethodCallExpression;
import org.eclipse.epsilon.eol.metamodel.ForStatement;
import org.eclipse.epsilon.eol.metamodel.FormalParameterExpression;
import org.eclipse.epsilon.eol.metamodel.MethodCallExpression;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.metamodel.WhileStatement;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;


public class LoadingOptimisationAnalysisContext extends TypeResolutionContext{
	
	protected HashMap<Object, EffectiveType> effectiveTypeRegistry = new HashMap<Object, EffectiveType>();
	protected HashMap<Object, EffectiveFeature> effectiveFeatureRegistry = new HashMap<Object, EffectiveFeature>();
	
	protected ArrayList<EffectiveMetamodel> effectiveMetamodels = new ArrayList<EffectiveMetamodel>();
	
	protected AssignmentStatement currentAssignmentStatement = null;
	
	protected FOLMethodCallExpression currentFolMethodCallExpression = null;
	
	protected Stack<FOLMethodCallExpression> currentFolMethodCallExpressions = new Stack<FOLMethodCallExpression>();
	protected Stack<FormalParameterExpression> currentIterators = new Stack<FormalParameterExpression>();

	protected HashMap<FOLMethodCallExpression, EffectiveFeature> map = new HashMap<FOLMethodCallExpression, EffectiveFeature>();
	
	protected ArrayList<OperationDefinitionNode> opCallGraph = new ArrayList<OperationDefinitionNode>();
	
	public void addToCallGraph(OperationDefinition operationDefinition)
	{
		OperationDefinitionNode node = new OperationDefinitionNode(operationDefinition);
		opCallGraph.add(node);
	}
	
	public OperationDefinitionNode getFromCallGraph(OperationDefinition operationDefinition)
	{
		for(OperationDefinitionNode opNode : opCallGraph)
		{
			if (opNode.getContainedOperationDefinition().equals(operationDefinition)) {
				return opNode;
			}
		}
		return null;
	}

	
	public void setCurrentFolMethodCallExpression(
			FOLMethodCallExpression currentFolMethodCallExpression) {
		currentFolMethodCallExpressions.push(currentFolMethodCallExpression);
	}
	
	public FOLMethodCallExpression getCurrentFolMethodCallExpression() {
		return currentFolMethodCallExpressions.peek();
	}
	
	public void popCurrentFOLMethodCallExpression()
	{
		currentFolMethodCallExpressions.pop();
	}
	
	
	public EffectiveFeature getFromMap(FOLMethodCallExpression folMethodCallExpression)
	{
		return map.get(folMethodCallExpression);
	}
	
	public void putToMap(FOLMethodCallExpression folMethodCallExpression, EffectiveFeature effectiveFeature)
	{
		map.put(folMethodCallExpression, effectiveFeature);
	}
	
	
	
	
	public void setCurrentIterator(FormalParameterExpression currentIterator) {
		currentIterators.push(currentIterator);
	}
	
	public FormalParameterExpression getCurrentIterator() {
		return currentIterators.peek();
	}
	
	public void popCurrentIterator()
	{
		currentIterators.pop();
	}
	
	public AssignmentStatement getCurrentAssignmentStatement() {
		return currentAssignmentStatement;
	}
	
	public void setCurrentAssignmentStatement(
			AssignmentStatement currentAssignmentStatement) {
		this.currentAssignmentStatement = currentAssignmentStatement;
	}
	
	public EffectiveFeature getEffectiveFeatureFromRegistry(Object object)
	{
		return effectiveFeatureRegistry.get(object);
	}
	
	public void registerEffectiveFeature(Object object, EffectiveFeature effectiveFeature)
	{
		if(!effectiveFeatureRegistry.containsValue(effectiveFeature))
		{
			effectiveFeatureRegistry.put(object, effectiveFeature);
		}
	}

	public EffectiveType getEffectiveTypeFromRegistry(Object object)
	{
		return effectiveTypeRegistry.get(object);
	}
	
	public void registerEffectiveType(Object object, EffectiveType effectiveType)
	{
		effectiveTypeRegistry.put(object, effectiveType);
	}
	
	//add to effective metamodels, if exist return, if not create then return
	public EffectiveMetamodel addEffectiveMetamodel(String modelName)
	{
		EffectiveMetamodel effectiveMetamodel = getEffectiveMetamodel(modelName);
		if (effectiveMetamodel == null) {
			effectiveMetamodel = new EffectiveMetamodel(modelName);
			effectiveMetamodels.add(effectiveMetamodel);
		}
		return effectiveMetamodel;
	}
	
	//add effective type to existing metamodel's allOfType, if metamodel does not exist return null;
	public EffectiveType addEffectiveTypeToAllOfType(EffectiveMetamodel em, String effectiveType)
	{
		if (em.getAllOfType().contains(effectiveType)) {
			return em.addToAllOfType(effectiveType);
		}
		return null;
	}
	
	//add effective type to existing metamodel's allOfKind, if metamodel does not exist return null;
		public EffectiveType addEffectiveTypeToAllOfKind(EffectiveMetamodel em, String effectiveType)
		{
			if (em.getAllOfKind().contains(effectiveType)) {
				return em.addToAllOfKind(effectiveType);
			}
			return null;
		}
	
	
	public EffectiveType addToEffectiveMetamodelAllOfType(String modelName, String effectiveType)
	{
		EffectiveMetamodel effectiveMetamodel = getEffectiveMetamodel(modelName);
		if (effectiveMetamodel != null) {
			return effectiveMetamodel.addToAllOfType(effectiveType);
		}
		else {
			effectiveMetamodel = new EffectiveMetamodel(modelName);
			effectiveMetamodels.add(effectiveMetamodel);
			return effectiveMetamodel.addToAllOfType(effectiveType);
		}
	}
	
	public EffectiveType addToEffectiveMetamodelAllOfKind(String modelName, String elementName)
	{
		EffectiveMetamodel effectiveMetamodel = getEffectiveMetamodel(modelName);
		if (effectiveMetamodel != null) {
			return effectiveMetamodel.addToAllOfKind(elementName);
		}
		else {
			effectiveMetamodel = new EffectiveMetamodel(modelName);
			effectiveMetamodels.add(effectiveMetamodel);
			return effectiveMetamodel.addToAllOfKind(elementName);
		}
	}
	
	public EffectiveMetamodel getEffectiveMetamodel(String modelName)
	{
		for(EffectiveMetamodel mc: effectiveMetamodels)
		{
			if (mc.getName().equals(modelName)) {
				return mc;
			}
		}
		return null;
	}

	public ArrayList<EffectiveMetamodel> getEffectiveMetamodels() {
		return effectiveMetamodels;
	}
	
	public boolean isKeywordAllOfKind(String keyword)
	{
		if (keyword.equals("all") ||
				keyword.equals("allInstances") ||
				keyword.equals("allOfKind")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isKeywordAllOfType(String keyword)
	{
		if (keyword.equals("allOfType")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void registerEffectiveTypeWithObject(Object object, EffectiveType effectiveType)
	{
		AssignmentStatement currentAssignmentStatement = getCurrentAssignmentStatement();
		if (currentAssignmentStatement.getRhs().equals(object) && 
				currentAssignmentStatement.getLhs() instanceof VariableDeclarationExpression) {
			VariableDeclarationExpression variableDeclarationExpression = (VariableDeclarationExpression) currentAssignmentStatement.getLhs();
			registerEffectiveType(variableDeclarationExpression, effectiveType);
		}
		else {
			registerEffectiveType(object, effectiveType);
		}
	}
	
	
	public void processMap()
	{
		for(FOLMethodCallExpression fol: map.keySet())
		{
			EolElement element = getTrace(fol);
			if (fol != null) {
				if (element instanceof OperationDefinition) {
					OperationDefinition operationDefinition = (OperationDefinition) element;
					OperationDefinitionNode node = getFromCallGraph(operationDefinition);
					if (node.getInvokers().size() > 1) {
						for(int i = 1; i < node.getInvokers().size(); i++)
						{
							map.get(fol).increaseUsage();
						}
					}
					else if (node.getInvokers().size() == 1) {
						if (containedInLoop(node.getInvokers().get(0))) {
							map.get(fol).increaseUsage();
						}
					}
				}
				if ((element instanceof ForStatement) ||
						(element instanceof WhileStatement)) {
					map.get(fol).increaseUsage();
				}
			}
		}
	}
	
	public boolean containedInLoop(MethodCallExpression methodCallExpression)
	{
		EolElement trace = methodCallExpression.getContainer();
		while(trace != null)
		{
			if ((trace instanceof ForStatement) ||
					(trace instanceof WhileStatement)) {
				return true;
			}
			else if (trace instanceof OperationDefinition) {
				OperationDefinition operationDefinition = (OperationDefinition) trace;
				OperationDefinitionNode node = getFromCallGraph(operationDefinition);
				for(MethodCallExpression call: node.getInvokers())
				{
					return containedInLoop(call);
				}
			}
			trace = trace.getContainer();
		}
		return false;
	}
	
	public EolElement getTrace(EolElement eolElement)
	{
		EolElement trace = eolElement.getContainer();
		
		while(trace != null)
		{
			if ((trace instanceof ForStatement)  ||
					(trace instanceof WhileStatement) ||
					(trace instanceof OperationDefinition)){
				return trace;
			}
			trace = trace.getContainer();
		}
		
		return null;
	}
	

	public void print()
	{
		System.out.println(map.keySet());
		System.out.println(map.values());
		for(EffectiveMetamodel mc: effectiveMetamodels)
		{
			System.out.println("Model: " + mc.getName());
			for(EffectiveType mec: mc.getAllOfType())
			{
				System.out.println("	allOfType: " +mec.getName());
				for(EffectiveFeature attr: mec.getAttributes())
				{
					System.out.println("		Attr: " + attr.getName() + " Usage: " + attr.getUsage());
				}
				for(EffectiveFeature ref: mec.getReferences())
				{
					System.out.println("		Ref: " + ref.getName() + " Usage: " + ref.getUsage());
				}
			}
			for(EffectiveType mec: mc.getAllOfKind())
			{
				System.out.println("	allOfKind: " +mec.getName());
				for(EffectiveFeature attr: mec.getAttributes())
				{
					System.out.println("		Attr: " + attr.getName() + " Usage: " + attr.getUsage());
				}
				for(EffectiveFeature ref: mec.getReferences())
				{
					System.out.println("		Ref: " + ref.getName() + " Usage: " + ref.getUsage());
				}
			}
			for(EffectiveType mec: mc.getTypes())
			{
				System.out.println("	types: " +mec.getName());
				for(EffectiveFeature attr: mec.getAttributes())
				{
					System.out.println("		Attr: " + attr.getName() + " Usage: " + attr.getUsage());
				}
				for(EffectiveFeature ref: mec.getReferences())
				{
					System.out.println("		Ref: " + ref.getName() + " Usage: " + ref.getUsage());
				}
			}
		}
	}
}
