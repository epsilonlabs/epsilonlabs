package io.dimitris.aeon;

public abstract class Record {
	
	protected int offset = -1;
	protected int length = -1;
	protected int id;
	protected RecordState state = RecordState.New;
	
	public RecordState getState() {
		return state;
	}
	
	public void setState(RecordState state) {
		this.state = state;
	}
	
	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	public int getOffset() {
		return offset;
	}
	
	public int computeLength() {
		// Structure of the record |type|headerLength|header|data
		// Excludes the byte used to store the length of the record
		return 2 + getHeader().length + getData().length;
	}
	
	public int lengthInBits() {
		// 4 bits 
		return 12 + getHeader().length + getData().length;
	}
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHeaderLength() {
		return getHeader().length;
	}
	
	public boolean isNew() {
		return this.getState() == RecordState.New;
	}
	
	public boolean isDeleted() {
		return this.getState() == RecordState.Deleted;
	}
	
	public boolean isDirty() {
		return this.getState() == RecordState.Dirty;
	}
	
	protected boolean needsMoreSpace() {
		boolean needsMoreSpace = this.getState() == RecordState.Dirty &&
			this.getLength() < this.computeLength();
		return needsMoreSpace;
	}
	
	public abstract byte[] getHeader();
	
	public abstract byte[] getData();
	
	public abstract Record setHeader(byte[] header);
	
	public abstract Record setData(byte[] data);
}
