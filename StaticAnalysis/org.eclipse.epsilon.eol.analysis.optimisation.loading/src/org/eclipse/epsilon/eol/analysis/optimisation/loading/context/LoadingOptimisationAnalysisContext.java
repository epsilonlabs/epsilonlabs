package org.eclipse.epsilon.eol.analysis.optimisation.loading.context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import org.eclipse.epsilon.eol.analysis.optimisation.loading.effective.metamodel.EffectiveFeature;
import org.eclipse.epsilon.eol.analysis.optimisation.loading.effective.metamodel.EffectiveMetamodel;
import org.eclipse.epsilon.eol.analysis.optimisation.loading.effective.metamodel.EffectiveType;
import org.eclipse.epsilon.eol.metamodel.AssignmentStatement;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.FOLMethodCallExpression;
import org.eclipse.epsilon.eol.metamodel.ForStatement;
import org.eclipse.epsilon.eol.metamodel.FormalParameterExpression;
import org.eclipse.epsilon.eol.metamodel.MethodCallExpression;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.OperationDefinition;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.metamodel.WhileStatement;
import org.eclipse.epsilon.eol.parse.Eol_EolParserRules.returnStatement_return;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;


public class LoadingOptimisationAnalysisContext extends TypeResolutionContext{
	
	//effectivetype registry, use to register EOL elements with effective types
	protected HashMap<Object, EffectiveType> effectiveTypeRegistry = new HashMap<Object, EffectiveType>();
	
	//effective metamodels
	protected ArrayList<EffectiveMetamodel> effectiveMetamodels = new ArrayList<EffectiveMetamodel>();
	
	//current assignment statement
	protected AssignmentStatement currentAssignmentStatement = null;
	
	//stack to hold fol method calls
	protected Stack<FOLMethodCallExpression> currentFolMethodCallExpressions = new Stack<FOLMethodCallExpression>();
	
	//stack to hold iterators of fol method calls
	protected Stack<FormalParameterExpression> currentIterators = new Stack<FormalParameterExpression>();

	//map that maps fol method calls with effective features
	protected HashMap<FOLMethodCallExpression, EffectiveFeature> map = new HashMap<FOLMethodCallExpression, EffectiveFeature>();
	
	//operationdefinition call graph
	protected ArrayList<OperationDefinitionNode> opCallGraph = new ArrayList<OperationDefinitionNode>();
	
	//add an operationdefinition to the call graph
	public void addToCallGraph(OperationDefinition operationDefinition)
	{
		OperationDefinitionNode node = new OperationDefinitionNode(operationDefinition);
		opCallGraph.add(node);
	}
	
	//get an operation definition node from the call graph
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
	
	//push an folmethodcallexpression to the stack
	public void setCurrentFolMethodCallExpression(
			FOLMethodCallExpression currentFolMethodCallExpression) {
		currentFolMethodCallExpressions.push(currentFolMethodCallExpression);
	}
	
	//get the current fol method call expression
	public FOLMethodCallExpression getCurrentFolMethodCallExpression() {
		return currentFolMethodCallExpressions.peek();
	}
	
	//get the previous method call expression
	public FOLMethodCallExpression getPreviousFolMethodCallExpression()
	{
		return currentFolMethodCallExpressions.get(currentFolMethodCallExpressions.size()-2);
	}
	
	//get the fol method call expressoin count
	public int getCurrentFolMethodCallExpressionsCount()
	{
		return currentFolMethodCallExpressions.size();
	}
	
	//pop the current fol method call expression
	public void popCurrentFOLMethodCallExpression()
	{
		currentFolMethodCallExpressions.pop();
	}
	
	//get an effective feature from the map
	public EffectiveFeature getFromMap(FOLMethodCallExpression folMethodCallExpression)
	{
		return map.get(folMethodCallExpression);
	}
	
	//put a pair to the map
	public void putToMap(FOLMethodCallExpression folMethodCallExpression, EffectiveFeature effectiveFeature)
	{
		map.put(folMethodCallExpression, effectiveFeature);
	}
	
	//push an iterator to the stack
	public void setCurrentIterator(FormalParameterExpression currentIterator) {
		currentIterators.push(currentIterator);
	}
	
	//get the current iterator
	public FormalParameterExpression getCurrentIterator() {
		return currentIterators.peek();
	}
	
	//pop the iterator
	public void popCurrentIterator()
	{
		currentIterators.pop();
	}
	
	//get the current assignment statement
	public AssignmentStatement getCurrentAssignmentStatement() {
		return currentAssignmentStatement;
	}
	
	//set the current assignment statement
	public void setCurrentAssignmentStatement(
			AssignmentStatement currentAssignmentStatement) {
		this.currentAssignmentStatement = currentAssignmentStatement;
	}
	
	//get the effective type from registry with an object
	public EffectiveType getEffectiveTypeFromRegistry(Object object)
	{
		return effectiveTypeRegistry.get(object);
	}
	
	//register an effective type with an object
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
		return em.addToAllOfType(effectiveType);
		
	}
	
	//add effective type to existing metamodel's allOfKind, if metamodel does not exist return null;
	public EffectiveType addEffectiveTypeToAllOfKind(EffectiveMetamodel em, String effectiveType)
	{
		return em.addToAllOfKind(effectiveType);
	}
	
	
	public EffectiveType addToEffectiveMetamodelAllOfType(String modelName, String effectiveType)
	{
		return addEffectiveMetamodel(modelName).addToAllOfType(effectiveType);
	}
	
	public EffectiveType addToEffectiveMetamodelAllOfKind(String modelName, String elementName)
	{
		return addEffectiveMetamodel(modelName).addToAllOfKind(elementName);
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
	
//	public boolean isKeywordAllOfKind(String keyword)
//	{
//		if (keyword.equals("all") ||
//				keyword.equals("allInstances") ||
//				keyword.equals("allOfKind")) {
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
//	
//	public boolean isKeywordAllOfType(String keyword)
//	{
//		if (keyword.equals("allOfType")) {
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
	
	public void registerEffectiveTypeWithObject(Object object, EffectiveType effectiveType)
	{
		//get the current assignment statement
		AssignmentStatement currentAssignmentStatement = getCurrentAssignmentStatement();
		
		//if the rhs of the current assignment is the object provided
		if (currentAssignmentStatement.getRhs().equals(object))
		{
			//if the lhs of the current assignment is a variable declaration expression
			if(currentAssignmentStatement.getLhs() instanceof VariableDeclarationExpression)
			{
				//get the variable declaration expression
				VariableDeclarationExpression variableDeclarationExpression = (VariableDeclarationExpression) currentAssignmentStatement.getLhs();
				
				//register the effective type with the variable declaration expression
				registerEffectiveType(variableDeclarationExpression, effectiveType);
			}
			
			//if the lhs of the current assignment is a name expression
			else if (currentAssignmentStatement.getLhs() instanceof NameExpression) {
				//get the name expression
				NameExpression nameExpression = (NameExpression) currentAssignmentStatement.getLhs();
				
				//if the name expression has a resolved content and the resolved content is a variable declaration expression
				if (nameExpression.getResolvedContent() != null && nameExpression.getResolvedContent() instanceof VariableDeclarationExpression) {
					
					//get the resolved content
					VariableDeclarationExpression originalVariableDeclarationExpression = (VariableDeclarationExpression) nameExpression.getResolvedContent();
					//register the effective type with the resolved content
					registerEffectiveType(originalVariableDeclarationExpression, effectiveType);
				}
			}
			
		}
		
		//if it is not involved in the current assignment, register the effective type with the object
		else {
			registerEffectiveType(object, effectiveType);
		}
	}
	
	
	public void processMap()
	{
		//for each fol
		for(FOLMethodCallExpression fol: map.keySet())
		{
			//get trace
			EolElement element = getTrace(fol);
			
			//if fol is not null
			if (element != null) {
				
				//if element is operation definition
				if (element instanceof OperationDefinition) {
					
					//get the node in opcallgraph
					OperationDefinition operationDefinition = (OperationDefinition) element;
					OperationDefinitionNode node = getFromCallGraph(operationDefinition);
					EffectiveFeature feature = map.get(fol);

					
					for(int i = 0; i < node.getInvokers().size(); i++)
					{
						MethodCallExpression invoker = node.getInvokers().get(i);
						
						OperationDefinition op = getContainingOperationDefinition(invoker);
						if (op != null) {
							OperationDefinitionNode node2 = getFromCallGraph(op);
							if (node != null) {
								ArrayList<MethodCallExpression> invokersToRemove = new ArrayList<MethodCallExpression>();
								for(MethodCallExpression methodCallExpression : node2.getInvokers())
								{
									if (containedInLoop(methodCallExpression)) {
										feature.increaseUsage();
										invokersToRemove.add(methodCallExpression);
									}
								}
								node2.getInvokers().removeAll(invokersToRemove);
							}
						}
						else {
							if (containedInLoop(invoker)) {
								feature.increaseUsage();
							}
						}
					}
					

//					if (node.getInvokers().size() > 1) {
//						for(int i = 1; i < node.getInvokers().size(); i++)
//						{
//							map.get(fol).increaseUsage();
//						}
//					}
//					else if (node.getInvokers().size() == 1) {
//						if (containedInLoop(node.getInvokers().get(0))) {
//							map.get(fol).increaseUsage();
//						}
//					}
				}
				if ((element instanceof ForStatement) ||
						(element instanceof WhileStatement)) {
					map.get(fol).increaseUsage();
				}
			}
		}
	}
	
	//returns true if the methodCallExpression is contained in a loop
	public boolean containedInLoop(MethodCallExpression methodCallExpression)
	{
		boolean result = false;
		//get the container
		EolElement trace = methodCallExpression.getContainer();
		
		//while container is not null
		while(trace != null)
		{
			//if trace is for or while loop, return true
			if ((trace instanceof ForStatement) ||
					(trace instanceof WhileStatement)) {
				result =  true;
			}
			
			//if trace is an operation definition
			else if (trace instanceof OperationDefinition) {
				
				//get the operation definition
				OperationDefinition operationDefinition = (OperationDefinition) trace;
				
				//get the opCallNode from the opCallGraph
				OperationDefinitionNode node = getFromCallGraph(operationDefinition);
				
				//for each invoker, return true if the invoker is contained in a loop
				for(MethodCallExpression call: node.getInvokers())
				{
					result = containedInLoop(call);
				}
			}
			
			//otherwise trace one level up
			trace = trace.getContainer();
		}
		
		//return false if not contained in loop at all
		return result;
	}
	
	
	public OperationDefinition getContainingOperationDefinition(EolElement eolElement)
	{
		EolElement trace = eolElement.getContainer();
		while(trace != null)
		{
			if (trace instanceof OperationDefinition) {
				return (OperationDefinition) trace;
			}
			trace = trace.getContainer();
		}
		return null;
	}
	
	//go up through the containment chain return forstatement, whilestatement or operationdefinition if they are encountered
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
	

	//print the effective metamodels
	public void print()
	{
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
