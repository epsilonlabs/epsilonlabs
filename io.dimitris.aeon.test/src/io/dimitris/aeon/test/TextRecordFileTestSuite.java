package io.dimitris.aeon.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.dimitris.aeon.RecordFile;
import io.dimitris.aeon.RecordState;
import io.dimitris.aeon.TextRecord;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TextRecordFileTestSuite {
	
	protected RecordFile<TextRecord> writeFile = null;
	protected RecordFile<TextRecord> readFile = null;
	protected RecordFile<TextRecord> readAgainFile = null;
	
	@Before
	public void setup() {
		File file = new File("sample.hex");
		file.delete();
		writeFile = new RecordFile<TextRecord>(file) {
			@Override
			public TextRecord createRecord() {
				return new TextRecord();
			}
		};
		readFile = new RecordFile<TextRecord>(file) {
			
			@Override
			public TextRecord createRecord() {
				return new TextRecord();
			}
		};
		readAgainFile = new RecordFile<TextRecord>(file) {
			
			@Override
			public TextRecord createRecord() {
				return new TextRecord();
			}
		};
	}
	
	@Test
	public void testAddTwoRecords() throws Exception {
		writeFile.persist(createTextRecord(0));
		writeFile.persist(createTextRecord(1));
		RecordCounter<TextRecord> recordCounter = new RecordCounter<TextRecord>();
		readFile.parse(recordCounter, false);
		assertEquals(2, recordCounter.getSize());
	}
	
	@Test
	public void testSecondRecordHeaderAndData() throws Exception {
		writeFile.persist(createTextRecord(0), createTextRecord(1));
		
		
		readFile.parse(new NthRecordListener<TextRecord>(1) {
			
			@Override
			public void onNthRecordParsed(TextRecord record) {
				assertEquals(createTextRecord(1).getHeaderAsString(), record.getHeaderAsString());
				assertEquals(createTextRecord(1).getDataAsString(), record.getDataAsString());
			}
		}, true);
	}
	
	@Test
	public void testDeleteUniqueRecord() throws Exception {
		TextRecord record = createTextRecord(0);
		writeFile.persist(record);
		assertEquals(0, record.getOffset());		
		record.setState(RecordState.Deleted);
		writeFile.persist(record);
		
		RecordCounter<TextRecord> recordCounter = new RecordCounter<TextRecord>();
		readFile.parse(recordCounter, false);
		assertEquals(0, recordCounter.getSize());
	}
	
	@Test
	public void testReplaceSecondRecord() throws Exception {
		TextRecord secondRecord = createTextRecord(12);
		writeFile.persist(createTextRecord(0), secondRecord, createTextRecord(3));
		secondRecord.setState(RecordState.Deleted);
		final TextRecord thirdRecord = createTextRecord(2);
		writeFile.persist(secondRecord, thirdRecord);
		
		readFile.parse(new NthRecordListener<TextRecord>(1) {
			
			@Override
			public void onNthRecordParsed(TextRecord record) {
				assertEquals(thirdRecord.getHeaderAsString(), record.getHeaderAsString());
				assertEquals(thirdRecord.getDataAsString(), record.getDataAsString());
			}
		}, true);
	}
	
	@Test
	public void testDeleteSecondAndThirdRecord() throws Exception {
		TextRecord secondRecord = createTextRecord(1);
		TextRecord thirdRecord = createTextRecord(2);
		
		writeFile.persist(createTextRecord(0), secondRecord, thirdRecord, createTextRecord(3));
		secondRecord.setState(RecordState.Deleted);
		thirdRecord.setState(RecordState.Deleted);
		writeFile.persist(secondRecord, thirdRecord);
		
		readFile.parse(new NthRecordListener<TextRecord>(1) {
			
			@Override
			public void onNthRecordParsed(TextRecord record) {
				assertEquals(createTextRecord(3).getHeaderAsString(), record.getHeaderAsString());
				assertEquals(createTextRecord(3).getDataAsString(), record.getDataAsString());
			}
		}, true);
	}
	
	@Test
	public void testReplaceRecordInExistingFile() throws Exception {
		writeRecordFile(1, 2, 3);
		readFile.parse(true);
		TextRecord secondRecord = readFile.getRecord(1);
		secondRecord.setState(RecordState.Deleted);
		TextRecord replacementRecord = createTextRecord(4);
		readFile.persist(secondRecord, replacementRecord);
		assertEquals(replacementRecord.getHeaderAsString(), readFile.getRecord(1).getHeaderAsString());
	}
	
	@Test
	public void testUpdateSecondRecordWithLarger() throws Exception {
		writeRecordFile(1, 2, 3);
		TextRecord record = writeFile.getRecord(2);
		record.setHeader("HH2");
		record.setState(RecordState.Dirty);
		writeFile.persist(record);
		assertEquals(RecordState.Clean, record.getState());
		
		readFile.parse(true);
		assertEquals(record.getHeaderAsString(), readFile.getRecord(record.getId()).getHeaderAsString());
	}
	
	@Test
	public void testUpdateSecondRecordWithSame() throws Exception {
		writeRecordFile(1, 2, 3, 4);
		TextRecord toUpdate = writeFile.getRecord(2);
		toUpdate.setState(RecordState.Dirty);
		writeFile.persist(toUpdate);
	}
	
	@Test
	public void testFreeRecords() throws Exception {
		writeRecordFile(1, 2, 3, 4);
		TextRecord toUpdate = writeFile.getRecord(2);
		toUpdate.setHeader("H10");
		toUpdate.setState(RecordState.Dirty);
		
		TextRecord toDelete = writeFile.getRecord(4);
		toDelete.setState(RecordState.Deleted);
		
		writeFile.persist(toUpdate, toDelete);
		assertEquals(2, writeFile.getFreeRecords().size());
	}
	
	
	@Test
	public void testAMillionRecords() throws Exception {
		
		List<TextRecord> records = new ArrayList<TextRecord>();
		
		for (int i=0;i<1000000;i++) {
			records.add(createTextRecord(i));
		}
		
		long now = System.currentTimeMillis();
		writeFile.persist(records);
		System.out.println(System.currentTimeMillis() - now);
		
		now = System.currentTimeMillis();
		readFile.parse(false);
		
		//System.out.println(readFile.getRecord(500000).getHeader());
		System.out.println(System.currentTimeMillis() - now);
		
	}
	
	protected void writeRecordFile(int... is) throws Exception {
		List<TextRecord> records = new ArrayList<TextRecord>();
		for (int i : is) {
			records.add(createTextRecord(i));
		}
		writeFile.persist(records);
	}
	
	protected TextRecord createTextRecord(int i) {
		TextRecord textRecord = writeFile.newRecord();
		textRecord.setHeader("H" + i);
		textRecord.setData("D" + i);
		textRecord.setState(RecordState.New);
		return textRecord;
	}
	
}
