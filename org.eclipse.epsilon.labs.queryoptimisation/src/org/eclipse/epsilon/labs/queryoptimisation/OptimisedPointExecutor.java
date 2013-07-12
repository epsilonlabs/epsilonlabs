package org.eclipse.epsilon.labs.queryoptimisation;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.PointExecutor;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.models.ISearchableModel;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.epsilon.eol.types.EolModelElementType;

public class OptimisedPointExecutor extends PointExecutor {

	@Override
	public Object execute(AST ast, IEolContext context)
			throws EolRuntimeException {
		
		AST targetAst = ast.getChild(0);
		AST featureCallAst = ast.getChild(1);
		
		if ((featureCallAst.getText().equals("selectOne") || featureCallAst.getText().equals("select"))
				&& targetAst.getType() == EolParser.POINT) {
			
			AST targetTargetAst = targetAst.getChild(0);
			AST targetFeatureCallAst = targetAst.getChild(1);
			
			if (targetFeatureCallAst.getText().equals("all") && targetTargetAst.getChildren().isEmpty()) {
				
				try {
					EolModelElementType type = EolModelElementType.forName(targetTargetAst.getText(), context);
					
					boolean one = featureCallAst.getText().equals("selectOne");
					
					if (type != null && type.getModel() instanceof ISearchableModel) {
						ISearchableModel searchableModel = (ISearchableModel) type.getModel();
						
						String iteratorName = featureCallAst.getFirstChild().getFirstChild().getFirstChild().getText();
						Variable iterator = new Variable(iteratorName, null, type);
						
						if (one) {
							return searchableModel.findOne(iterator, featureCallAst.getChild(1), context);
						}
						else {
							return searchableModel.find(iterator, featureCallAst.getChild(1), context);
						}
					}
					
				}
				catch (Exception ex) {}
			}
		}
		
		return super.execute(ast, context);
	}

}
