package io.dimitris.aeon;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class App {
	
	public static void main(String[] args) throws Exception{
		new App().run();
	}
	
	public void run() throws Exception {
		File file = new File("sample.hex");
		file.delete();
		
		final RecordFile<TextRecord> recordFile = new RecordFile<TextRecord>(file) {
			@Override
			public TextRecord createRecord() {
				return new TextRecord();
			}
		};
		
		List<TextRecord> records = new ArrayList<>();
		String longString = ""; generateString(1000);
		
		for (int i=0;i<2;i++) {
			TextRecord record = new TextRecord();
			record.setHeader("H" + i);
			record.setData("D" + i + longString);
			record.setState(RecordState.New);
			records.add(record);
		}
		
		long now = System.currentTimeMillis();
		recordFile.persist(records);
		System.out.println("Wrote: " + (System.currentTimeMillis() - now));
		
		now = System.currentTimeMillis();
		recordFile.parse(new RecordFileParseListener<TextRecord>() {
			
			@Override
			public void onRecordParsed(TextRecord record) {
				try {
					recordFile.getRecord(record.getOffset()).getData();
				} catch (Exception e) {
					e.printStackTrace();
				}		
			}
		}, false);
		
		System.out.println("Read: " + (System.currentTimeMillis() - now));
	}
	
	public String pad(String str, int width, String padding) {
		String result = str;
		int pad = width - result.length();
		while (pad > 2) {
			result = result + padding;
			pad = pad - 1;
		}
		result = result + "\r\n";
		return result;
	}
	
	protected String generateString(int size) {
		String str = "";
		for (int i=0;i<size;i++) {
			str += "a";
		}
		return str;
	}
	
}
