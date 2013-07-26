package org.eclipse.epsilon.emc.incquery;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.models.Model;
import org.eclipse.incquery.tooling.ui.queryexplorer.QueryExplorer;
import org.eclipse.incquery.tooling.ui.queryexplorer.content.matcher.MatcherTreeViewerRoot;
import org.eclipse.incquery.tooling.ui.queryexplorer.content.matcher.ObservablePatternMatch;
import org.eclipse.incquery.tooling.ui.queryexplorer.content.matcher.ObservablePatternMatcher;
import org.eclipse.incquery.tooling.ui.queryexplorer.content.matcher.ObservablePatternMatcherRoot;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class IncQueryModel extends Model {
	
	protected ObservablePatternMatcherRoot observablePatternMatcherRoot = null;
	protected IncQueryPropertyGetter propertyGetter = new IncQueryPropertyGetter();
	
	public void setObservablePatternMatcherRoot(
			ObservablePatternMatcherRoot observablePatternMatcherRoot) {
		this.observablePatternMatcherRoot = observablePatternMatcherRoot;
	}
	
	@Override
	public void load(StringProperties properties, String basePath)
			throws EolModelLoadingException {
		super.load(properties, basePath);
		load();
	}
	
	@Override
	public void load() throws EolModelLoadingException {
		
		Display.getDefault().syncExec(new Runnable() {
			
			@Override
			public void run() {
				MatcherTreeViewerRoot root = QueryExplorer.getInstance().getMatcherTreeViewerRoot();
				setObservablePatternMatcherRoot(root.getRoots().get(0));
			}
		});
	}

	@Override
	public Object getEnumerationValue(String enumeration, String label)
			throws EolEnumerationValueNotFoundException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Collection<?> allContents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<?> getAllOfType(String type)
			throws EolModelElementTypeNotFoundException {
		
		return new ObsevablePatternMatchList(getObservablePatternMatcher(type));

	}

	@Override
	public Collection<?> getAllOfKind(String type)
			throws EolModelElementTypeNotFoundException {
		return getAllOfType(type);
	}

	@Override
	public String getTypeNameOf(Object instance) {
		ObservablePatternMatch match = (ObservablePatternMatch) instance;
		return match.getPatternMatch().patternName();
	}

	@Override
	public Object createInstance(String type)
			throws EolModelElementTypeNotFoundException,
			EolNotInstantiableModelElementTypeException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object getElementById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getElementId(Object instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setElementId(Object instance, String newId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteElement(Object instance) throws EolRuntimeException {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean owns(Object instance) {
		
		if (!(instance instanceof ObservablePatternMatch)) return false;
		
		ObservablePatternMatch match = (ObservablePatternMatch) instance;
		return match.getParent().getParent() == observablePatternMatcherRoot;
		
	}

	@Override
	public boolean isInstantiable(String type) {
		return false;
	}

	@Override
	public boolean knowsAboutProperty(Object instance, String property) {
		return owns(instance) || (instance instanceof EObject);
	}
	
	@Override
	public boolean hasType(String type) {
		return getObservablePatternMatcher(type) != null;
	}

	protected ObservablePatternMatcher getObservablePatternMatcher(String type) {
		for (ObservablePatternMatcher matcher : observablePatternMatcherRoot.getMatchers()) {
			if (matcher.getPatternName().endsWith(type)) return matcher;
		}
		return null;
	}
	
	@Override
	public boolean store(String location) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean store() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public IPropertyGetter getPropertyGetter() {
		return propertyGetter;
	}
	
}
