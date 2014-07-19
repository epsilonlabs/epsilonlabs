package org.eclipse.epsilon.etl.dtx.analysis.coverage;

import org.eclipse.epsilon.common.util.StringUtil;
import org.eclipse.jface.viewers.TableViewer;

public class StringTableColumn extends SortableTableColumn{
	public StringTableColumn(TableViewer tableViewer, int style) {
		super(tableViewer, style);
	}

	public StringTableColumn(TableViewer tableViewer, int style, int index) {
		super(tableViewer, style, index);
	}

	@Override
	int compare(Object o1, Object o2) {
		return StringUtil.toString(o1).compareTo(StringUtil.toString(o2));
	}

}
