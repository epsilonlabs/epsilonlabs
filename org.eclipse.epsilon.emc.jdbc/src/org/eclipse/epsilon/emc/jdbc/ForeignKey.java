package org.eclipse.epsilon.emc.jdbc;

public class ForeignKey {
	
	protected String name;
	protected String column;
	protected String foreignColumn;
	protected String foreignTable;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getColumn() {
		return column;
	}
	
	public void setColumn(String column) {
		this.column = column;
	}
	
	public String getForeignColumn() {
		return foreignColumn;
	}
	
	public void setForeignColumn(String foreignColumn) {
		this.foreignColumn = foreignColumn;
	}
	
	public String getForeignTable() {
		return foreignTable;
	}
	
	public void setForeignTable(String foreignTable) {
		this.foreignTable = foreignTable;
	}
	
	
}
