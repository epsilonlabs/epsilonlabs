package org.eclipse.epsilon.etl.dtx.transformation.dependency;

import org.eclipse.jface.viewers.TableViewer;


public class LongTableColumn extends SortableTableColumn{

	public LongTableColumn(TableViewer tableViewer, int style) {
		super(tableViewer, style);
		// TODO Auto-generated constructor stub
	}

	public LongTableColumn(TableViewer tableViewer, int style, int index) {
		super(tableViewer, style, index);
	}

	@Override
	int compare(Object o1, Object o2) {
		return 0;
	}

}
