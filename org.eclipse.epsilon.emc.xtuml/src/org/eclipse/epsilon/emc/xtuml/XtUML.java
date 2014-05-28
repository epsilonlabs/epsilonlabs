package org.eclipse.epsilon.emc.xtuml;

import com.mentor.nucleus.bp.core.Ooaofooa;
import com.mentor.nucleus.bp.core.SystemModel_c;

public class XtUML {
	
	// See https://github.com/xtuml/editor/blob/master/src/com.mentor.nucleus.bp.ui.explorer/src/com/mentor/nucleus/bp/ui/explorer/adapters/
	
	public SystemModel_c[] getSystemModels() {
		return 	SystemModel_c.SystemModelInstances(Ooaofooa
			.getDefaultInstance());
	}
	
}
