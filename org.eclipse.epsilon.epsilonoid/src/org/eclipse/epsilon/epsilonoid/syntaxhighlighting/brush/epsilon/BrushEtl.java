package org.eclipse.epsilon.epsilonoid.syntaxhighlighting.brush.epsilon;

public class BrushEtl extends BrushEol{
	
	@Override
	public String getKeywords() {
		return super.getKeywords() + " " +
				"rule transform to";
	}
	
	@Override
	protected String getLanguageName() {
		return "etl";
	}
	
}
