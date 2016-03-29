package org.eclipse.epsilon.labs.indexed.emf;

import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.epsilon.eol.models.transactions.IModelTransaction;

public class EMFTransaction_indexed implements IModelTransaction{
	
	protected ChangeRecorder changeRecorder;
	protected IndexedAbstractEmfModel model;
	
	public EMFTransaction_indexed(IndexedAbstractEmfModel model) {
		this.model = model;
	}
	
	public void start() {
		if (model.getModelImpl().getResourceSet() != null) {
			this.changeRecorder = new ChangeRecorder(model.getModelImpl().getResourceSet());	
		}
		else {
			this.changeRecorder = new ChangeRecorder(model.getModelImpl());		
		}
	}
	
	public void commit() {
		if (changeRecorder != null) {
			changeRecorder.endRecording();
			changeRecorder = null;
		}
	}
	
	public void rollback() {
		if (changeRecorder != null) {
			changeRecorder.endRecording().applyAndReverse();
			model.clearCache();
			changeRecorder = null;
		}
	}
	
	public void dispose() {
		this.model = null;
	}
}
