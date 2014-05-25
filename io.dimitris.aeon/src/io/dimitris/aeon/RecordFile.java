package io.dimitris.aeon;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel.MapMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class RecordFile<T extends Record> {
	
	protected File file = null;
	protected List<FreeRecord> freeRecords = new ArrayList<FreeRecord>();
	protected List<RecordFileParseListener<T>> parseListeners = new ArrayList<RecordFileParseListener<T>>();
	protected int maxId = 0;
	protected RecordPersistencePlan<T> plan = new RecordPersistencePlan<T>();
	protected int offsetCacheExpansionDelta = 10000;
	protected int[] offsetCache = new int[offsetCacheExpansionDelta];
	
	public RecordFile(File file) {
		this.file = file;
	}
	
	public void parse() throws Exception {
		parse(false);
	}
	
	public void parse(boolean retainData) throws Exception {
		RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
		MappedByteBuffer buffer = randomAccessFile.getChannel().map(MapMode.READ_ONLY, 0, randomAccessFile.length());
		
		// Listener that keeps track of offsets
		parseListeners.add(new RecordFileParseListener<T>() {
			
			@Override
			public void onRecordParsed(T record) {
				maxId = Math.max(maxId, record.getId());
				updateOffsetCache(record);
			}
		});
		
		while (buffer.position() < randomAccessFile.length()) {
			T record = parseRecord(buffer, retainData);
			if (record != null) {
				for (RecordFileParseListener<T> listener : parseListeners) {
					if (listener != null) listener.onRecordParsed(record);
				}
			}
		}
		
		randomAccessFile.close();
	}
	
	public void addParseListener(RecordFileParseListener<T> listener) {
		parseListeners.add(listener);
	}
	
	public void removeParseListener(RecordFileParseListener<T> listener) {
		parseListeners.remove(listener);
	}
	
	public void parse(RecordFileParseListener<T> listener, boolean retainData) throws Exception {
		addParseListener(listener);
		parse(retainData);
		removeParseListener(listener);
	}
	
	protected abstract T createRecord();
	
	public T newRecord() {
		T record = createRecord();
		maxId++;
		record.setId(maxId);
		return record;
	}
	
	protected T parseRecord(MappedByteBuffer buffer, boolean retainData) {
		T record = createRecord();
		record.setOffset(buffer.position()); 
		record.setLength(buffer.getInt());
		record.setId(buffer.getInt());
		
		if (record.getId() == -1) {
			freeRecords.add(new FreeRecord(record.getOffset(), record.getLength()));
			//byte[] skip = new byte[record.getLength()+2];
			//buffer.get(skip);
			buffer.position(buffer.position() + record.getLength() + 2);
			return null;
		}
		
		int headerLength = buffer.getInt();
		if (headerLength > 0) {
			byte[] header = new byte[headerLength];
			buffer.get(header);
			record.setHeader(header);
		}
		
		int dataLength = record.getLength() - headerLength - 2;
		if (retainData) {
			byte[] data = new byte[dataLength];
			buffer.get(data);
			record.setData(data);
		}
		else {
			buffer.position(buffer.position() + dataLength);
		}
		return record;
	}
	
	public T getRecord(int id) throws Exception {
		RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
		MappedByteBuffer buffer = randomAccessFile.getChannel().map(MapMode.READ_ONLY, 0, randomAccessFile.length());
		buffer.position(getCachedOffset(id));
		T record = parseRecord(buffer, true);
		randomAccessFile.close();
		return record;
	}
	
	public void persist(T... records) throws Exception {
		persist(Arrays.asList(records));
	}
	
	public void persist(List<T> records) throws Exception {
		
		RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
		long eof = randomAccessFile.length();
		
		plan.compute(records, freeRecords);
		randomAccessFile.setLength(randomAccessFile.length() + plan.getExtraSpace());
		
		MappedByteBuffer buffer = randomAccessFile.getChannel().map(MapMode.READ_WRITE, 0, randomAccessFile.length());
		
		for (T record : records) {
			if (record.isNew() || record.isDirty()) {
				
				Integer freeRecordOffset = plan.getFreeRecordOffset(record);
				boolean overwritesFreeRecord = (freeRecordOffset != null);
				
				if (overwritesFreeRecord) {
					buffer.position(freeRecordOffset);
				}
				else if (record.isDirty() && !record.needsMoreSpace()) {
					buffer.position(record.getOffset());
				}
				else {
					buffer.position((int)eof);
				}
				
				record.setOffset(buffer.position());
				if (overwritesFreeRecord) { 
					record.setLength(buffer.getInt());
				}
				else {
					record.setLength(record.computeLength());
					buffer.putInt(record.getLength());
				}
				
				buffer.putInt(record.getId());
				buffer.putInt(record.getHeaderLength());
				buffer.put(record.getHeader());
				buffer.put((new String(record.getData()) + getPadding(record.getLength() - record.computeLength())).getBytes());
				record.setState(RecordState.Clean);
				
				if (!overwritesFreeRecord) {
					eof = buffer.position();
				}
			}
			else if (record.isDeleted()) {
				record.setId(-1);
			}
			
			updateOffsetCache(record);
		}
		
		for (Integer offset : plan.getRecordOffsetsToFree()) {
			buffer.position(offset);
			buffer.getInt();
			buffer.putInt(-1);
		}
		
		randomAccessFile.close();
	}
	
	protected String getPadding(int n) {
		String padding = "";
		for (int i=0;i<n;i++) {
			padding += " ";
		}
		return padding;
	}
	
	protected void updateOffsetCache(T record) {
		if (record.getId() >= offsetCache.length) {
			offsetCache = Arrays.copyOf(offsetCache, record.getId() + 1000);
		}
		if (record.getId() > 0) offsetCache[record.getId()] = record.getOffset();
	}
	
	protected int getCachedOffset(int recordId) {
		return offsetCache[recordId];
	}
	
	public List<FreeRecord> getFreeRecords() {
		return freeRecords;
	}
	
}
