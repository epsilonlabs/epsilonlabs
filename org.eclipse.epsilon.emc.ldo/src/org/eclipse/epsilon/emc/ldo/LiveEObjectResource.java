package org.eclipse.epsilon.emc.ldo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

public class LiveEObjectResource implements Resource {

	@Override
	public void delete(Map<?, ?> options) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TreeIterator<EObject> getAllContents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<EObject> getContents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EObject getEObject(String uriFragment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<Diagnostic> getErrors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResourceSet getResourceSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getTimeStamp() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public URI getURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getURIFragment(EObject eObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<Diagnostic> getWarnings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLoaded() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isModified() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTrackingModification() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void load(Map<?, ?> options) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load(InputStream inputStream, Map<?, ?> options)
			throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Map<?, ?> options) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(OutputStream outputStream, Map<?, ?> options)
			throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setModified(boolean isModified) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTimeStamp(long timeStamp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTrackingModification(boolean isTrackingModification) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setURI(URI uri) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unload() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EList<Adapter> eAdapters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eDeliver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void eNotify(Notification notification) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eSetDeliver(boolean deliver) {
		// TODO Auto-generated method stub
		
	}

}
