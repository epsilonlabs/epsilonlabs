package org.eclipse.epsilon.eol.visitor.resolution.type.tier1.impl;

import org.eclipse.epsilon.eol.metamodel.AnyType;
import org.eclipse.epsilon.eol.metamodel.Expression;
import org.eclipse.epsilon.eol.metamodel.KeyValueExpression;
import org.eclipse.epsilon.eol.metamodel.MapExpression;
import org.eclipse.epsilon.eol.metamodel.MapType;
import org.eclipse.epsilon.eol.metamodel.visitor.EolVisitorController;
import org.eclipse.epsilon.eol.metamodel.visitor.MapExpressionVisitor;
import org.eclipse.epsilon.eol.visitor.resolution.type.tier1.context.TypeResolutionContext;

public class MapExpressionTypeResolver extends MapExpressionVisitor<TypeResolutionContext, Object>{

	@Override
	public Object visit(MapExpression mapExpression,
			TypeResolutionContext context,
			EolVisitorController<TypeResolutionContext, Object> controller) {
		
		
		MapType resolvedType = (MapType) mapExpression.getResolvedType();
		AnyType keyType = resolvedType.getKeyType();
		AnyType valueType = resolvedType.getValueType();
		
		for(KeyValueExpression keyValueExpression: mapExpression.getKeyValues())
		{
			controller.visit(keyValueExpression, context);
			Expression key = keyValueExpression.getKey();
			Expression value = keyValueExpression.getValue();
			keyType.getDynamicTypes().add(key.getResolvedType());
			valueType.getDynamicTypes().add(value.getResolvedType());
		}
		
		return null;
	}
	
}
