package metamodel.connectivity.emf;

import java.util.ArrayList;
import java.util.LinkedList;

import org.eclipse.emf.ecore.EClass;

public class _deprecated_MetaClassNode {

	EClass eClass;
	int weight;
	_deprecated_MetaClassNode previous;
	
	public _deprecated_MetaClassNode(EClass eClass)
	{
		this.eClass = eClass;
		weight = 0;
		previous = null;
	}
	
	public EClass getEClass()
	{
		return eClass;
	}
	
	public int getWeight()
	{
		return weight;
	}
	
	public void setWeight(int w)
	{
		weight = w;
	}
	
	public _deprecated_MetaClassNode getPrevious()
	{
		return previous;
	}
	
	public void setPrevious(_deprecated_MetaClassNode previous)
	{
		this.previous = previous;
	}
	
	//returns the node which has the minimum weight in the list
	public _deprecated_MetaClassNode extractMin(ArrayList<_deprecated_MetaClassNode> list)
	{
		int min = 100000; //set the weight to be infinite
		_deprecated_MetaClassNode result = null; //set result to null
		for(_deprecated_MetaClassNode node: list) //for all nodes in the list
		{
			if (node.getWeight() < min) { 
				min = node.getWeight();
				result = node;
			}
		}
		if (result != null) { //remove result from list if applicable
			list.remove(result);
		}
		return result; //return result
	}
	
	//returns a list that contains the superTypes of the argument node that exist in the argument list
	public LinkedList<_deprecated_MetaClassNode> getNeighbours(_deprecated_MetaClassNode node, ArrayList<_deprecated_MetaClassNode> list)
	{
		LinkedList<_deprecated_MetaClassNode> result = new LinkedList<_deprecated_MetaClassNode>();
		for(EClass cls: node.getEClass().getESuperTypes())
		{
			for(_deprecated_MetaClassNode n: list)
			{
				if(n.getEClass().equals(cls))
				{
					result.add(n);
				}
			}
		}
		return result;
	}
}
