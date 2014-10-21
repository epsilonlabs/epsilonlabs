package org.eclipse.epsilon.eol.visitor.resolution.type.tier2.impl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.AssignmentStatement;
import org.eclipse.epsilon.eol.metamodel.EolElement;
import org.eclipse.epsilon.eol.metamodel.FormalParameterExpression;
import org.eclipse.epsilon.eol.metamodel.NameExpression;
import org.eclipse.epsilon.eol.metamodel.Statement;
import org.eclipse.epsilon.eol.metamodel.VariableDeclarationExpression;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.NameExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier2.context.TypeResolutionContext_T2;

public class NameExpressionTypeResolver_T2 extends NameExpressionVisitor<TypeResolutionContext_T2, Object>{

	@Override
	public Object visit(NameExpression nameExpression,
			TypeResolutionContext_T2 context,
			EolVisitorController<TypeResolutionContext_T2, Object> controller) {
		String nameString = nameExpression.getName();
		
		//if the container is an variableDeclarationExpression, should return, as we don't need 
		if (nameExpression.getContainer() instanceof VariableDeclarationExpression) {
			return null;
		}
		
		//if the name is a keyword, create corresponding type and return 
		if (context.getTypeUtil().isKeyWordSimple(nameString)) { //if name expression is keyword then resolve type immediately
			return null;
		}
		
		if (nameString.equals("null")) { //if name is null then it is the keyword
			return null;
		}
		
		if(nameExpression.getResolvedContent() instanceof VariableDeclarationExpression)
		{
			VariableDeclarationExpression vde = (VariableDeclarationExpression) nameExpression.getResolvedContent();
			if (vde.getResolvedType() instanceof AnyType) {
				if (nameExpression.getContainer() instanceof AssignmentStatement && ((AssignmentStatement) nameExpression.getContainer()).getLhs().equals(nameExpression)) {
					//get the assignment statement
					AssignmentStatement at = (AssignmentStatement) nameExpression.getContainer();
					//if (!context.isAssignmentToAvoid(at)) {
						//if the lhs of the assignment equals to the name expression, add this to the definition points collection to the variabledeclarationexpression
						vde.getDefinitionPoints().add(at);	
					//}
						
					if (!context.getStack().variableExistsInCurrentScope(vde.getName().getName())) {
						context.addUnsafeVariable(vde);
					}
				}
				//if the container is not an assignment statement
				else {
					//if the defition points are empty， this means that the name expression is not initialised, then an error should be thrown.
					//however, the implication means that the
					if (vde.getDefinitionPoints().size() == 0) {
						//if the resolved content is a formal parameter expression, then it means it is a parameter of a operation definition
						//this also caters for the FOL method calls and for loops
						if (vde instanceof FormalParameterExpression) {
							
						}
						else {
							//throw error
							context.getLogBook().addError(nameExpression, "expression has not been initialised");
							//get the containing statement
							//Statement stmt = getContainingStatement(nameExpression);
							//if the containing statement is an assignment statement, throw into the to-avoid array
							//if (stmt != null && stmt instanceof AssignmentStatement) {
								//context.addAssignmentToAvoid((AssignmentStatement) stmt);
							//}
						}
					}
					else {
						if (context.isSafeVariable(vde)) {
							AssignmentStatement lastDefinition = (AssignmentStatement) vde.getDefinitionPoints().get(vde.getDefinitionPoints().size()-1);
							nameExpression.setResolvedType(EcoreUtil.copy(lastDefinition.getRhs().getResolvedType()));
						}
					}
				}
			}
		}
		return null;
	}
	
	
	public Statement getContainingStatement(NameExpression nameExpression)
	{
		EolElement eolElement = nameExpression.getContainer();
		while(!(eolElement instanceof Statement) && eolElement != null)
		{
			eolElement = eolElement.getContainer();
		}
		return (Statement) eolElement;
	}

}
