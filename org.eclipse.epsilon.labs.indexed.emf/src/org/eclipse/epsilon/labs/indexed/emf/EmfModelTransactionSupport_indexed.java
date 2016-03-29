package org.eclipse.epsilon.labs.indexed.emf;

import org.eclipse.epsilon.eol.models.transactions.IModelTransaction;
import org.eclipse.epsilon.eol.models.transactions.NestedModelTransactionSupport;

public class EmfModelTransactionSupport_indexed extends NestedModelTransactionSupport{
	
	protected IndexedAbstractEmfModel model = null;
	
	public EmfModelTransactionSupport_indexed(IndexedAbstractEmfModel model) {
		this.model = model;
	}

	@Override
	public IModelTransaction createTransaction() {
		return new EMFTransaction_indexed(model);
	}

}
