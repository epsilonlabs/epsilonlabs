package io.dimitris.aeon;

public interface RecordFileParseListener<T extends Record> {
	
	public void onRecordParsed(T record);
	
}
