package org.eclipse.epsilon.emc.incquery;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.IAbstractOperationContributor;
import org.eclipse.epsilon.eol.execute.operations.declarative.IteratorOperation;
import org.eclipse.epsilon.eol.parse.Eol_EolParserRules.returnStatement_return;
import org.eclipse.incquery.tooling.ui.queryexplorer.content.matcher.ObservablePatternMatch;
import org.eclipse.incquery.tooling.ui.queryexplorer.content.matcher.ObservablePatternMatcher;

public class ObsevablePatternMatchList implements List<ObservablePatternMatch>, IAbstractOperationContributor {
	
	protected ObservablePatternMatcher matcher = null;
	
	public ObsevablePatternMatchList(ObservablePatternMatcher matcher) {
		this.matcher = matcher;
		
	}
	
	protected List<ObservablePatternMatch> getDelegate() {
		return matcher.getMatches();
	}
	
	@Override
	public int size() {
		return getDelegate().size();
	}

	@Override
	public boolean isEmpty() {
		return getDelegate().isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return getDelegate().contains(o);
	}

	@Override
	public Iterator<ObservablePatternMatch> iterator() {
		return getDelegate().iterator();
	}

	@Override
	public Object[] toArray() {
		return getDelegate().toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return getDelegate().toArray(a);
	}

	@Override
	public boolean add(ObservablePatternMatch e) {
		return getDelegate().add(e);
	}

	@Override
	public boolean remove(Object o) {
		return getDelegate().remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return getDelegate().containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends ObservablePatternMatch> c) {
		return getDelegate().addAll(c);
	}

	@Override
	public boolean addAll(int index,
			Collection<? extends ObservablePatternMatch> c) {
		return getDelegate().addAll(index, c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return getDelegate().removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return getDelegate().retainAll(c);
	}

	@Override
	public void clear() {
		getDelegate().clear();
	}

	@Override
	public ObservablePatternMatch get(int index) {
		return getDelegate().get(index);
	}

	@Override
	public ObservablePatternMatch set(int index, ObservablePatternMatch element) {
		return getDelegate().set(index, element);
	}

	@Override
	public void add(int index, ObservablePatternMatch element) {
		getDelegate().add(index, element);
	}

	@Override
	public ObservablePatternMatch remove(int index) {
		return getDelegate().remove(index);
	}

	@Override
	public int indexOf(Object o) {
		return getDelegate().indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return getDelegate().lastIndexOf(o);
	}

	@Override
	public ListIterator<ObservablePatternMatch> listIterator() {
		return getDelegate().listIterator();
	}

	@Override
	public ListIterator<ObservablePatternMatch> listIterator(int index) {
		return getDelegate().listIterator(index);
	}

	@Override
	public List<ObservablePatternMatch> subList(int fromIndex, int toIndex) {
		return getDelegate().subList(fromIndex, toIndex);
	}

	@Override
	public AbstractOperation getAbstractOperation(String name) {
		if ("select".equals(name)) {
			return new IteratorOperation() {
				
				@Override
				public Object execute(Object target, Variable iterator, AST expressionAst,
						IEolContext context) throws EolRuntimeException {
					
					AST propertyAst = expressionAst.getFirstChild().getChild(1);
					AST valueAst = expressionAst.getChild(1);
					
					EList<org.eclipse.incquery.patternlanguage.patternLanguage.Variable> variables = matcher.getMatcher().getPattern().getParameters();
					
					Object[] filter = new Object[variables.size()];
					
					for (int i=0; i<filter.length; i++) {
						if (variables.get(i).getName().equals(propertyAst.getText())) {
							filter[i] = context.getExecutorFactory().executeAST(valueAst, context);
						}
						else {
							filter[i] = null;
						}
					}
					
					for (Object o : filter) {
						System.err.print(o + ",");
					}
					System.err.println();
					
					//matcher.setFilter(new Object[variables.size()]);
					matcher.setFilter(filter);
					List<ObservablePatternMatch> result = matcher.getMatches();
					
					return result;
				}
			};
		}
		return null;
	}

}
