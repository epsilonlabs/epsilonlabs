package io.dimitris.aeon.test;

import io.dimitris.aeon.Record;
import io.dimitris.aeon.RecordFileParseListener;

public abstract class NthRecordListener<T extends Record> implements RecordFileParseListener<T> {
	
	protected int n = 0;
	protected int counter = 0;
	
	
	public NthRecordListener(int n) {
		this.n = n;
	}
	
	@Override
	public void onRecordParsed(T record) {
		if (counter == n) {
			onNthRecordParsed(record);
		}
		counter++;
	}
	
	public abstract void onNthRecordParsed(T record);
}
