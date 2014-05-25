package io.dimitris.aeon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecordPersistencePlan<T extends Record> {
	
	protected List<Integer> recordOffsetsToFree;
	protected int extraSpace;
	protected HashMap<T, Integer> newOffsetMap;
	
	public void compute(List<T> records, List<FreeRecord> freeRecords) {
		recordOffsetsToFree = new ArrayList<Integer>();
		newOffsetMap = new HashMap<T, Integer>();
		extraSpace = 0;
		
		for (T record : records) {
			if (record.isDeleted() || record.needsMoreSpace()) {
				freeRecords.add(new FreeRecord(record.getOffset(), record.getLength()));
				recordOffsetsToFree.add(record.getOffset());
			}
		}
		
		for (T record : records) {
			if (record.isNew() || record.needsMoreSpace()) {
				
				FreeRecord freeRecord = findfreeRecord(record.computeLength(), freeRecords);
				if (freeRecord == null) {
					// We have not found an empty record we have overwrite
					// Add some space
					extraSpace += record.lengthInBits();
				}
				else {
					// We have found an empty record we can replace 
					// so there is no need for extra space
					freeRecords.remove(freeRecord);
					recordOffsetsToFree.remove((Integer) freeRecord.getOffset());
					newOffsetMap.put(record, freeRecord.getOffset());
				}
			}
			
		}
	}
	
	// Finds an empty record within a list of candidate empty records
	// Improve logic using a TreeSet so that it finds the most suitable free record
	protected FreeRecord findfreeRecord(int length, List<FreeRecord> freeRecords) {		
		for (FreeRecord freeRecord : freeRecords) {
			if (freeRecord.getLength() >= length) {
				return freeRecord;
			}
		}
		return null;
	}
		
		
	public int getExtraSpace() {
		return extraSpace;
	}
	
	public List<Integer> getRecordOffsetsToFree() {
		return recordOffsetsToFree;
	}
	
	public Integer getFreeRecordOffset(T record) {
		return newOffsetMap.get(record);
	}
	
}
