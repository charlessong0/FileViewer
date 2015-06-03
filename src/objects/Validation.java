package objects;

import java.util.ArrayList;

public class Validation {
	private ArrayList<ColumnVal> columnList = new ArrayList<ColumnVal>();
	
	public void addColumn(ColumnVal column) {
		columnList.add(column);
	}
	
	//column start from 0
	public ColumnVal getColumn(int i) {
		return columnList.get(i);
	}
}
