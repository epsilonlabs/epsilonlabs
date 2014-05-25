package io.dimitris.aeon;


public class TextRecord extends Record {

	protected String header = "";
	protected String data = "";
	
	public byte[] getHeader() {
		return header.trim().getBytes();
	}
	
	public TextRecord setHeader(byte[] header) {
		this.header = new String(header);
		return this;
	}
	
	public byte[] getData() {
		return data.trim().getBytes();
	}

	public TextRecord setData(byte[] data) {
		this.data = new String(data);
		return this;
	}
	
	public TextRecord setHeader(String header) {
		this.header = header;
		return this;
	}
	
	public TextRecord setData(String data) {
		this.data = data;
		return this;
	}
	
	public String getHeaderAsString() {
		return new String(header).trim();
	}
	
	public String getDataAsString() {
		return new String(data).trim();
	}

}
