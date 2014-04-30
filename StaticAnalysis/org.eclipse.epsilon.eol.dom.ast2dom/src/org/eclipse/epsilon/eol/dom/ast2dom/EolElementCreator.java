package org.eclipse.epsilon.eol.dom.ast2dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.parse.Position;
import org.eclipse.epsilon.eol.metamodel.*;


public abstract class EolElementCreator {
	/*private int createCount = 0;
	
	public void addCreateCount()
	{
		createCount++;
	}*/
	public abstract boolean appliesTo(AST ast);
	
	public void setAssets(AST ast, EolElement dom, EolElement container)
	{
		dom.setLine(ast.getLine());
		dom.setColumn(ast.getColumn());
		dom.setContainer(container);
		
		if (ast.getRegion() != null) {
			TextRegion region = EolFactory.eINSTANCE.createTextRegion();
			TextPosition start = toTextPosition(ast.getRegion().getStart());
			//start.setContainer(region);
			region.setStart(start);
			TextPosition end = toTextPosition(ast.getRegion().getEnd());
			//end.setContainer(region);
			region.setEnd(end);
			
			//region.setStart(toTextPosition(ast.getRegion().getStart()));
			//region.setEnd(toTextPosition(ast.getRegion().getEnd()));
			//region.setContainer(dom);
			dom.setRegion(region);
		}
		
	}
	
	protected TextPosition toTextPosition(Position position) {
		TextPosition textPosition = EolFactory.eINSTANCE.createTextPosition();
		textPosition.setLine(position.getLine());
		textPosition.setColumn(position.getColumn());
		return textPosition;
	}
	
	public abstract EolElement create(AST ast, EolElement container, Ast2DomContext context);
}
