package org.eclipse.epsilon.emc.jdbc;

import java.util.ArrayList;
import java.util.List;

public class Database {
	
	protected List<Table> tables = new ArrayList<Table>();
	
	public List<Table> getTables() {
		return tables;
	}
	
}