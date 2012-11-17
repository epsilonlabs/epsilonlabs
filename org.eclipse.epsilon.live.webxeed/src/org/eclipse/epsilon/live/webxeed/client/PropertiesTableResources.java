package org.eclipse.epsilon.live.webxeed.client;

import com.google.gwt.user.cellview.client.CellTable;

public interface PropertiesTableResources extends CellTable.Resources {
	@Source({ CellTable.Style.DEFAULT_CSS, "properties-table.css" })
	TableStyle cellTableStyle();

	interface TableStyle extends CellTable.Style {
	}

}