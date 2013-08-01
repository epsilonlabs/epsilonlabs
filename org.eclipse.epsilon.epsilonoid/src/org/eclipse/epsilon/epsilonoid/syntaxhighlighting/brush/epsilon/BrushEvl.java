package org.eclipse.epsilon.epsilonoid.syntaxhighlighting.brush.epsilon;

public class BrushEvl extends BrushEol{
	
	@Override
	public String getKeywords() {
		return super.getKeywords() + " " +
				"context constraint check message fix do title";
	}
	
	@Override
	protected String getLanguageName() {
		return "evl";
	}
	
}
