package org.eclipse.epsilon.labs.queryoptimisation;

import java.util.Arrays;
import java.util.List;

import org.antlr.runtime.CommonToken;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.PointExecutor;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.models.ISearchableModel;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.epsilon.eol.types.EolModelElementType;

public class OptimisedPointExecutor extends PointExecutor {
	
	protected List<String> optimisableOperations = Arrays.asList("select", "selectOne", "exists", "forAll");
	
	// select - OK
	// selectOne - OK
	// exists - OK
	// forAll - OK?
	
	@Override
	public Object execute(AST ast, IEolContext context)
			throws EolRuntimeException {
		
		AST targetAst = ast.getChild(0);
		AST featureCallAst = ast.getChild(1);
		
		String operationName = featureCallAst.getText();
		
		if (targetAst.getType() == EolParser.POINT && optimisableOperations.contains(operationName)) {
			
			AST targetTargetAst = targetAst.getChild(0);
			AST targetFeatureCallAst = targetAst.getChild(1);
			
			if (targetFeatureCallAst.getText().equals("all") && targetTargetAst.getChildren().isEmpty()) {
				
				
				try {
					EolModelElementType type = EolModelElementType.forName(targetTargetAst.getText(), context);
					
					boolean one = !operationName.equals("select");
					
					if (type != null && type.getModel() instanceof ISearchableModel) {
						ISearchableModel searchableModel = (ISearchableModel) type.getModel();
						
						String iteratorName = featureCallAst.getFirstChild().getFirstChild().getFirstChild().getText();
						Variable iterator = new Variable(iteratorName, null, type);
						
						AST parametersAst = featureCallAst.getChild(1);
						if (operationName.equals("forAll")) {
							CommonToken notToken = new CommonToken(EolParser.OPERATOR);
							notToken.setText("not");
							AST notAst = new AST(notToken, null);
							notAst.addChild(parametersAst);
							parametersAst = notAst;
						}
						
						if (one) {
							Object result = searchableModel.findOne(iterator, parametersAst, context);
							if (operationName.equals("exists")) return result != null;
							else if (operationName.equals("selectOne")) return result;
							else if (operationName.equals("forAll")) return result == null;
						}
						else {
							return searchableModel.find(iterator, parametersAst, context);
						}
					}
					
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		return super.execute(ast, context);
	}

}
