package io.dimitris.aeon;


public class FreeRecord extends Record {
	
	public FreeRecord(int offset, int length) {
		this.offset = offset;
		this.length = length;
	}
	
	@Override
	public byte[] getHeader() {
		throw new UnsupportedOperationException();
	}

	@Override
	public byte[] getData() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Record setHeader(byte[] header) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Record setData(byte[] data) {
		throw new UnsupportedOperationException();
	}
	
	
}
