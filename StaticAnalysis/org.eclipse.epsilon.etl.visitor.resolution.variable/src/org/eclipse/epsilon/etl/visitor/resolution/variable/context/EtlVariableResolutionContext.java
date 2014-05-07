package org.eclipse.epsilon.etl.visitor.resolution.variable.context;

import org.eclipse.epsilon.eol.visitor.resolution.variable.context.VariableResolutionContext;
import org.eclipse.epsilon.etl.metamodel.EtlProgram;

public class EtlVariableResolutionContext extends VariableResolutionContext{

	protected EtlProgram mainEtlProgram = null; //main program, which is the EOL program in question

	public EtlProgram getMainEtlProgram() {
		return mainEtlProgram;
	}
	
	public void setMainEtlProgram(EtlProgram mainEtlProgram) {
		this.mainEtlProgram = mainEtlProgram;
	}
}
