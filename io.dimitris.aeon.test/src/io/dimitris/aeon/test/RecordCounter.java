package io.dimitris.aeon.test;

import io.dimitris.aeon.RecordFileParseListener;
import io.dimitris.aeon.TextRecord;

public class RecordCounter<T extends TextRecord> implements RecordFileParseListener<T>{
	
	protected int size = 0;
	
	@Override
	public void onRecordParsed(T record) {
		size ++;
	}

	public int getSize() {
		return size;
	}
}
